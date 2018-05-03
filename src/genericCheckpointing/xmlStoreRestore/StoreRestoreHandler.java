/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author Megh Shah
 */
public class StoreRestoreHandler implements InvocationHandler{
     private StrategyI serializationStrategy;
     private StrategyI deserializationStrategy;
     private Results result;
     
     public StoreRestoreHandler(Results rIn){
         result = rIn;
     }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          //args will contain the arguements of the interface method.
         // if the method is write
       // if the wireFormat is XML args[2]
           //  call serializeData(args[0], new XMLSerializationStrategy());
           if(method.getName().equalsIgnoreCase("writeObj")){
               String str = args[2].toString();
               if(str.equalsIgnoreCase("XML")){
                   serializationStrategy = new SerializationStrategy(result);
                   serializeData((SerializableObject) args[0],serializationStrategy);
               }
           }
           
           if(method.getName().equalsIgnoreCase("readObj")){
              String str = args[0].toString();
               if(str.equalsIgnoreCase("XML")){
                   deserializationStrategy = new DeSerializationStrategy();
                   return deSerializeData(deserializationStrategy);
               }
           }
   
    // if statements to check if it is the read method so that
    // deserialization can be done ... 
    return null;
    }
    //does deSerialization.
    private Object deSerializeData( StrategyI deserializationStrategy) {
        SerializableObject s=null ;
        deserializationStrategy.processInput(s);
        return (SerializableObject)s;
    }
//Does serialization
    private void serializeData(SerializableObject serializableObject, StrategyI serializationStrategy) {
       serializationStrategy.processInput(serializableObject);
      return;
    }

   
    
}
