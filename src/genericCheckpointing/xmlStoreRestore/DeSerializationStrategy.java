/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Megh Shah
 */
public class DeSerializationStrategy implements StrategyI{
    private String fileName;
    
    public DeSerializationStrategy() {
        
    }

    @Override
    public void processInput(SerializableObject sIn) {
        
    }
    
    @Override
    public SerializableObject processInput(FileProcessor fp){
        SerializableObject obj = new SerializableObject();
        List<String> paramList = new ArrayList<>();
        String word[] = null;
        String className= null;
        String fieldName= null;
        String type=null;
        String value=null;
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
                 
                if(word[0].equalsIgnoreCase("<complexType")){
                            String str[] = word[1].split("\"");
                            className = str[1];
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
                    paramList.add(value);
                }
                line= fp.readLine();
        }
        //[Ref:https://stackoverflow.com/questions/6094575/creating-an-instance-using-the-class-name-and-calling-constructor]
        
            Class<?> cls = Class.forName(className);
            for(Constructor<?> constructor : cls.getConstructors()){
                Class<?>[] types = constructor.getParameterTypes();
                if(paramList.size() != types.length){ //parameters in constructor should match
                    continue;
                }
                Object args[] = new Object[types.length];
                for(int i =0; i<types.length;i++){
                    args[i] = typeParser(paramList.get(i),types[i]) ;
                }
                return (SerializableObject) constructor.newInstance(args);
            }
            
        } catch (ClassNotFoundException | ArrayIndexOutOfBoundsException |InvocationTargetException |InstantiationException | IllegalAccessException | IllegalArgumentException ex) {
            ex.printStackTrace();
        } 
        
        return obj;
    }

    private Object typeParser(String arg, Class<?> type) {
        if(type == Integer.TYPE ||type == Integer.class){
            return Integer.parseInt(arg);
        }
        if(type == Long.TYPE || type== Long.class){
            return Long.parseLong(arg);
        }
        if(type==Double.TYPE || type == Double.class){
            return Double.parseDouble(arg);
        }
        if(type == Boolean.TYPE || type == Boolean.class){
            return Boolean.parseBoolean(arg);
        }
        if(type == Float.TYPE|| type == Float.class){
            return Float.parseFloat(arg);
        }
        if(type == Character.TYPE || type == Character.class){
            return arg.charAt(0);
        }
        if(type == Short.TYPE || type == Short.class){
            return Short.parseShort(arg);
        }
        if(type == String.class){
            return arg;
        }
        return null;
    }

    
}
