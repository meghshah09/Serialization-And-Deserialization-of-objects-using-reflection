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
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.Results;
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
            System.out.println("Starting the Process with given "+args[2]+" file......");
            System.out.println("");
            try{
            int N = Integer.parseInt(args[1]);
            String mode = args[0];
            String fileName = args[2]; 
            Scanner scan = new Scanner(System.in);
            FileProcessor fp = new FileProcessor(scan);
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
            helper.createObjects(N,mode); // does all the Job
            }
            catch(NumberFormatException e){
                System.err.println("Second Arguement Should be int");
                System.exit(0);
            }
            
        }
        else{
            
                System.out.println("Please Kindly re-run the program with Correct Command line Arguments");
                System.exit(0);
        }
        }

    }
