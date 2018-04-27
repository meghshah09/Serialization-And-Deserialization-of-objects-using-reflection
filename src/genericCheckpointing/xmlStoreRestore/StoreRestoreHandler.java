/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author Megh Shah
 */
public class StoreRestoreHandler implements InvocationHandler{

    @Override
    public Object invoke(Object o, Method method, Object[] os) throws Throwable {
        
         // if the method is write
       // if the wireFormat is XML
           //  call serializeData(args[0], new XMLSerializationStrategy());
   
    // if statements to check if it is the read method so that
    // deserialization can be done ... 
    return null;
    }
    
}
