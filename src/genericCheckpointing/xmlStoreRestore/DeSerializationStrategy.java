/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Megh Shah
 */
public class DeSerializationStrategy implements StrategyI{


    private String fileName;
    private Map<String,Class<?>> map = new HashMap<>();
    /**
     * Default Constructor
     */
    public DeSerializationStrategy() {
        map.put("java.lang.String",String.class);
        map.put("int",Integer.TYPE);
        map.put("float",Float.TYPE);
        map.put("boolean",Boolean.TYPE);
        map.put("double",Double.TYPE);
        map.put("char",Character.TYPE);
        map.put("short",Short.TYPE);
        map.put("long",Long.TYPE);
        map.put("String",String.class);
    }
/**
 * 
 * @param sIn Is the Serializable Object 
 */
    @Override
    public void processInput(SerializableObject sIn) {
        //Does Nothing
    }
    /**
     * 
     * @param fp FileProcessor Object
     * @return the Serializable Object
     */
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
                    deSerializeType(type,value,obj1,cls,fieldName);
                }
                line= fp.readLine();
        }
        
            return (SerializableObject)obj1;
        } catch (ClassNotFoundException | ArrayIndexOutOfBoundsException |InstantiationException | IllegalAccessException | IllegalArgumentException ex) {
            ex.printStackTrace();
        } 
        
        return obj;
    }
/**
 * 
 * @param type is the String consisting of the type
 * @param arg is String Consisting of the Parameters
 * @param obj1is the object
 * @param cls is the of the type Class<?>
 * @param fName is the Field Name.
 */
    private void deSerializeType(String type,String arg,Object obj1,Class<?>cls,String fName) {
        Class<?>types = findType(type);
        String output = fName.substring(0, 1).toUpperCase() + fName.substring(1);
         output = "set"+output;
        try {
        if(types == Integer.TYPE ||types == Integer.class){
                  //System.out.println(output);
                    Method m = cls.getMethod(output, types);
                m.invoke(obj1,Integer.parseInt(arg));

        }
        else if(types == Long.TYPE || types== Long.class){

                    Method m = cls.getMethod(output, types);
                    m.invoke(obj1,Long.parseLong(arg));

          }
        else if(types==Double.TYPE || types == Double.class){

                Method m =cls.getMethod(output, types);
                m.invoke(obj1,Double.parseDouble(arg));
        }
        else  if(types == Boolean.TYPE || types == Boolean.class){

            Method m =cls.getMethod(output, types);
            m.invoke(obj1, Boolean.parseBoolean(arg));
        }
        else if(types == Float.TYPE|| types == Float.class){

            Method m = cls.getDeclaredMethod(output, types);
            m.invoke(obj1,Float.parseFloat(arg));
        }
        else if(types == Character.TYPE || types == Character.class){

            Method m = cls.getDeclaredMethod(output, types);
            m.invoke(obj1,arg.charAt(0));
        }
        else if(types == Short.TYPE || types == Short.class){

            Method m = cls.getDeclaredMethod(output, types);
            m.invoke(obj1,Short.parseShort(arg));
        }
        else if(types == String.class  || types == Object.class){

            Method m = cls.getDeclaredMethod(output, types);
            m.invoke(obj1,arg);
        }
         } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    ex.printStackTrace();
          }
    }
    /**
     * 
     * @param type is the String consisting the type of Object
     * @return the Calss<?> of the given type
     */
       private Class<?> findType(String type) {
           Class<?>t = map.get(type);
           return t;
    }

    
}
