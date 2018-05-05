/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Megh Shah
 */
public class DeSerializationStrategy implements StrategyI{

    private  int countInt=0;
    private  int countLong =0;
    private  int countDouble=0;
    private String fileName;
    private Map<String,Class<?>> map = new HashMap<>();
    public DeSerializationStrategy() {
        map.put("String",String.class);
        map.put("int",Integer.TYPE);
        map.put("float",Float.TYPE);
        map.put("boolean",Boolean.TYPE);
        map.put("double",Double.TYPE);
        map.put("char",Character.TYPE);
        map.put("short",Short.TYPE);
        map.put("long",Long.TYPE);
    }

    @Override
    public void processInput(SerializableObject sIn) {
        
    }
    
    @Override
    public SerializableObject processInput(FileProcessor fp){
        SerializableObject obj = new SerializableObject();
        List<Object> paramList = new ArrayList<>();
        String word[] = null;
        String className= null;
        String fieldName= null;
        String type=null;
        String value=null;
        Class<?> cls =null;
        Object obj1 = null;
        fp.setCount(fp.getCount());
        String line = fp.readLine();
        try{
        while(line!=null && !(line.equalsIgnoreCase("</DPSerialization>"))){
            //start here
            line = line.trim();
            if(line.equalsIgnoreCase("<DPSerialization>")){
                line = fp.readLine();
            }
            if(line.equalsIgnoreCase("</complexType>")){
                line = fp.readLine();
                //continue;
                if(line.equalsIgnoreCase("</DPSerialization>")){
                    break;
                }
            }
                // <complexType xsi:type=genericCheckpointing.util.MyAllTypesFirst>
                line = line.trim();
                word = line.split(" ");
                 
                if(word[0].substring(1).equalsIgnoreCase("complexType")){
                            String str[] = word[1].split("\"");
                            className = str[1];
                            cls = Class.forName(className);
                            obj1 = cls.newInstance();
                }
                else{// <myLong xsi:type="xsd:long">899991</myLong>
                    fieldName = word[0].substring(1);
                    String str[] = word[1].split("\"");
                    String s[] = str[1].split(":");
                    type = s[1];
                    //[Ref: https://stackoverflow.com/questions/237061/using-regular-expressions-to-extract-a-value-in-java]
                    Pattern p = Pattern.compile(">(.*?)<");
                    Matcher m = p.matcher(line);
                    if(m.find()){
                       // System.out.println(m.group(0)); >0<
                       // System.out.println(m.group(1));
                        //System.out.println(m.group(2)); //NA
                        //System.out.println(m.group(3)); //NA
                        //System.out.println(m.group(4)); //NA
                       value = m.group(1);
                    }
                    deSerializeType(type,value,obj1,cls);
                }
                line= fp.readLine();
        }
        //[Ref:https://stackoverflow.com/questions/6094575/creating-an-instance-using-the-class-name-and-calling-constructor]
        
            
           //Object args[] = new Object[paramList.size()];
            
           
            return (SerializableObject)obj1;
            /*for(Constructor<?> constructor : cls.getConstructors()){
                Class<?>[] types = constructor.getParameterTypes();
                if(types.length == 0){ //empty constructor
                    
                }
                
                if(paramList.size() != types.length){ //parameters in constructor should match
                    continue;
                }
                Object args[] = new Object[types.length];
                for(int i =0; i<types.length;i++){
                    args[i] = typeParser(paramList.get(i),types[i]) ;
                }
                return (SerializableObject) constructor.newInstance(args);
            }*/
            
        } catch (ClassNotFoundException | ArrayIndexOutOfBoundsException |InstantiationException | IllegalAccessException | IllegalArgumentException ex) {
            ex.printStackTrace();
        } 
        
        return obj;
    }

    private void deSerializeType(String type,String arg,Object obj1,Class<?>cls) {
        Class<?>types = findType(type);
        try {
        if(types == Integer.TYPE ||types == Integer.class){
            
                if(countInt==0){
                    Method m = cls.getMethod("setMyInt", types);
                     
                m.invoke(obj1,Integer.parseInt(arg));
                countInt++;
                }else{
                    Method m = cls.getMethod("setMyOtherInt", types);
                    
                     m.invoke(obj1,Integer.parseInt(arg));
                }
        }
        else if(types == Long.TYPE || types== Long.class){
            if(countLong==0){
                
                    Method m = cls.getMethod("setMyLong", types);
                    m.invoke(obj1,Long.parseLong(arg));
                    countLong++;
            }else{
                    Method m = cls.getMethod("setMyOtherLong", types);
                     m.invoke(obj1,Long.parseLong(arg));
                }
         
          }
        else if(types==Double.TYPE || types == Double.class){
            if(countDouble == 0){
                Method m =cls.getMethod("setMyDoubleT", types);
                m.invoke(obj1,Double.parseDouble(arg));
                countDouble++;
            }else{
                Method m =cls.getMethod("setMyOtherDoubleT", types);
                m.invoke(obj1,Double.parseDouble(arg));
            }
            
        }
        else  if(types == Boolean.TYPE || types == Boolean.class){
            Method m =cls.getMethod("setMyBoolean", types);
            m.invoke(obj1, Boolean.parseBoolean(arg));
        }
        else if(types == Float.TYPE|| types == Float.class){
            Method m = cls.getDeclaredMethod("setMyFloatT", types);
            m.invoke(obj1,Float.parseFloat(arg));
        }
        else if(types == Character.TYPE || types == Character.class){
            Method m = cls.getDeclaredMethod("setMyCharT", types);
            m.invoke(obj1,arg.charAt(0));
        }
        else if(types == Short.TYPE || types == Short.class){
            Method m = cls.getDeclaredMethod("setMyShortT", types);
            m.invoke(obj1,Short.parseShort(arg));
        }
        else if(types == String.class){
            Method m = cls.getDeclaredMethod("setMyString", types);
            m.invoke(obj1,arg);
        }
         } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    ex.printStackTrace();
          }
    }
    
       private Class<?> findType(String type) {
           Class<?>t = map.get(type);
           return t;
    }

    
}
