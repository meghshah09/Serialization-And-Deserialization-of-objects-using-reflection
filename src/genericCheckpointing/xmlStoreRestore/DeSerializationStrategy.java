/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;
import java.util.List;
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
       
        List<String> paramList = new ArrayList<String>();
        String word[] = null;
        String className= null;
        String fieldName= null;
        String type=null;
        String value=null;
        fp.setCount(fp.getCount());
        String line = fp.readLine();
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
                        System.out.println(m.group(1));
                        //System.out.println(m.group(2)); //NA
                        //System.out.println(m.group(3)); //NA
                        //System.out.println(m.group(4)); //NA
                       value = m.group(1);
                    }
                    paramList.add(value);
                }
                line= fp.readLine();
        }
        
        
        return obj;
    }

    
}
