/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

/**
 *
 * @author Megh Shah
 */
public interface StrategyI {
    
    /**
     *
     * @param sIn Consists of Serializable object needed of Serialization
     */
    public void processInput(SerializableObject sIn);

    /**
     *
     * @param fp
     * @return the SerializableObject consisting the instance
     */
    public SerializableObject processInput(FileProcessor fp);
}
