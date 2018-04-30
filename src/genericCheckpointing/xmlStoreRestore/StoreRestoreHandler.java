/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

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
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          //args will contain the arguements of the interface method.
         // if the method is write
       // if the wireFormat is XML args[2]
           //  call serializeData(args[0], new XMLSerializationStrategy());
           if(method.getName().equalsIgnoreCase("writeObj")){
               String str = args[2].toString();
               if(str.equalsIgnoreCase("XML")){
                   serializationStrategy = new SerializationStrategy();
                   return serializeData((SerializableObject) args[0],serializationStrategy);
               }
           }
           
           if(method.getName().equalsIgnoreCase("readObj")){
              deserializationStrategy = new DeSerializationStrategy();
               return deSerializeData((SerializableObject)args[0], deserializationStrategy);
           }
   
    // if statements to check if it is the read method so that
    // deserialization can be done ... 
    return null;
    }

    private Object deSerializeData(SerializableObject serializableObject, StrategyI deserializationStrategy) {
        SerializableObject s = deserializationStrategy.serializeObject(serializableObject);
        return (SerializableObject)s;
    }

    private Object serializeData(SerializableObject serializableObject, StrategyI serializationStrategy) {
       SerializableObject s = serializationStrategy.serializeObject(serializableObject);
      return (SerializableObject)s;
    }

   
    
}
