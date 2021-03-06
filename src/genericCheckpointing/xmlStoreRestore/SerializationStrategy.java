/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Field;

/**
 *
 * @author Megh Shah
 */
public class SerializationStrategy implements StrategyI{
       // private Map<String,String> types= new HashMap<>();
        private StringBuilder sb = new StringBuilder();
        private Results result;
        public SerializationStrategy(Results rIn){
            result =rIn;
        }
    @Override
    public void processInput(SerializableObject sIn) {
       
        try{
        Class<?> cls = sIn.getClass();
       // System.out.println(cls); //both class will come.
        sb.append("<DPSerialization>\n");
        sb.append(" <complexType xsi:type=\""+cls.getName()+"\">\n");
        Field[] field = cls.getDeclaredFields();
        for(Field f : field){
            f.setAccessible(true);
            Object value = f.get(sIn);
            
            String type = f.getType().getName();
            if(serializeType(type,value.toString()))
                 sb.append("  <"+f.getName()+" xsi:type=\"xsd:"+type+"\">"+value.toString()+"</"+f.getName()+">\n");
            
        }
            
        sb.append(" </complexType>\n");
        sb.append("</DPSerialization>\n");
        result.fileDisplay(sb.toString());
        //result.stdoutDisplay(sb.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @Override
    public SerializableObject processInput(FileProcessor fp) {
        return null;
    }

    private boolean serializeType(String type, String val) {
        if(type.equalsIgnoreCase("int") && (Integer.parseInt(val) <10)){
            return false;
        }
        else if(type.equalsIgnoreCase("long") && (Long.parseLong(val) <10)){
            return false;
        }
        else if(type.equalsIgnoreCase("double") && (Double.parseDouble(val) <10)){
            return false;
        }
        else if(type.equalsIgnoreCase("float") && (Float.parseFloat(val) <10)){
            return false;
        }
        return true;
        
    }
    
}
