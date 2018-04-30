/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.util;

import genericCheckpointing.server.StoreRestoreI;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author Megh Shah
 */
public class ProxyCreator {
    
    public Object createProxy(Class<?>[] interfaceArray, InvocationHandler handler ){
        StoreRestoreI  serDeserObj = (StoreRestoreI) Proxy.newProxyInstance(getClass().getClassLoader(),interfaceArray, handler);
    
    return serDeserObj;
    }
    
}
