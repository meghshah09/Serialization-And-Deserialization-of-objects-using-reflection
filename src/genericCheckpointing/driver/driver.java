/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.Driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.CheckPointingHelper;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import java.util.Scanner;

/**
 *
 * @author Megh Shah
 */
public class driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // FIXME: read the value of checkpointFile from the command line
        if (args.length == 3) {
            System.out.println("================================================");
            System.out.println("            CheckPointing Objects             ");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("Starting the Process......");
            System.out.println("");
            int N = Integer.parseInt(args[1]);
            String mode = args[0];
            String fileName = args[2]; 
            Scanner scan = new Scanner(System.in);
            FileProcessor fp = new FileProcessor();
            fp.setFileName(fileName);
            fp.setCount(0);
            ProxyCreator pc = new ProxyCreator();
            Results r = new Results();
           // r.openingOutputFile(fileName);
            // create an instance of StoreRestoreHandler (which implements
            // the InvocationHandler
            // create a proxy
            StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[]{StoreI.class, RestoreI.class}, new StoreRestoreHandler(r,fp));
            CheckPointingHelper  helper = new CheckPointingHelper(cpointRef,fileName,r);
            helper.createObjects(N,mode);

            //SerializableObject myRecordRet;

            // create a data structure to store the returned ojects
            //for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {

                //myRecordRet = ((RestoreI) cpointRef).readObj("XML");
                // FIXME: store myRecordRet in the vector
            //}

            // FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)
            // FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
            // The comparison should use the equals and hashCode methods. Note that hashCode 
            // is used for key-value based data structures
        }
        else{
            
                System.out.println("Please Kindly re-run the program with Correct Command line Arguments");
                System.exit(0);
        }
        }

    }
