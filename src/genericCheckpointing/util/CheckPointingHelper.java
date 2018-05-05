/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.util;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Megh Shah
 */
public class CheckPointingHelper {
    
    private StoreRestoreI cPointRef;
    private String fileName;
    private Results result;
    public CheckPointingHelper(StoreRestoreI cpointRefIn,String fileIn,Results rIn){
        cPointRef = cpointRefIn;
        fileName= fileIn;
        result=rIn;
    }
    
    public void createObjects(int NUM_OF_OBJECTS, String modeIn){
        // FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
            
            if(modeIn.equalsIgnoreCase("serdeser")){
                result.openingOutputFile(fileName);
                // The code below is for "serdeser" mode
            // For "serdeser" mode, both the serialize and deserialize functionality should be called.
            // create a data structure to store the objects being serialized
            // NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
            List<SerializableObject> serList = new ArrayList<SerializableObject>();
                    for (int i = 0; i < NUM_OF_OBJECTS; i++) {
                        int authID = ( int )( Math.random() * 9999 );
                        if( authID == 0 ) {
                                    authID = authID + 1000;                      
                        }
                        // FIXME: create these object instances correctly using an explicit value constructor
                        // use the index variable of this loop to change the values of the arguments to these constructors
                        MyAllTypesFirst myFirst = new MyAllTypesFirst(i+1,i*99999,"object"+i,((i%2)==0),i+2,i*999999);
                        MyAllTypesSecond mySecond = new MyAllTypesSecond(i*2.55556,i+3.5f,'#',(short)i,i*3.67777778);
                        // FIXME: store myFirst and mySecond in the data structure
                        serList.add(myFirst);
                        serList.add(mySecond);
                        ((StoreI) cPointRef).writeObj(myFirst,authID, "XML");
                        ((StoreI) cPointRef).writeObj(mySecond, authID,"XML");
                    }
                    result.closeingOutputFile();
              List<SerializableObject> deserList = new ArrayList<>(); 
              for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {
                    SerializableObject deSer= (SerializableObject)((RestoreI) cPointRef).readObj("XML");
                    deserList.add(deSer);
                }
              int misMatch=0;
              for(int i =0; i<serList.size();i++){
                  if(serList.get(i).equals(deserList.get(i)) ){
                  }else{
                      misMatch++;
                  }
              }
              System.out.println("No. of Mis Match are :" +misMatch);
              
            }
            else if (modeIn.equalsIgnoreCase("deser")){
             // Use an if/switch to proceed according to the command line argument
            // For deser, just deserliaze the input file into the data structure and then print the objects
            List<SerializableObject> deserList = new ArrayList<>(); 
              for (int j = 0; j < NUM_OF_OBJECTS; j++) {
                    SerializableObject deSer= (SerializableObject)((RestoreI) cPointRef).readObj("XML");
                    deserList.add(deSer);
                }
              for (int j = 0; j < NUM_OF_OBJECTS; j++) {
                  result.stdoutDisplay(deserList.get(j).toString());
                  result.stdoutDisplay("\n");
                }
            
                    
            }
            
            
    }
}
