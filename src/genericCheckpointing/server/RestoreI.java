/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;

/**
 *
 * @author Megh Shah
 */
public interface RestoreI extends StoreRestoreI{

    /**
     *
     * @param xml
     * @return
     */
    public SerializableObject readObj(String xml);
    
}
