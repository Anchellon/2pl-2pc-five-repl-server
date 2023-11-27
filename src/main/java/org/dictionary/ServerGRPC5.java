package org.dictionary;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ServerGRPC5 {
    public static void main(String[] args){
        int PORT_NUM = Integer.parseInt(args[0]);

        Logger logger;
        FileHandler fh = null;
        logger = Logger.getLogger("Server_gRPCLog");
        try {
            fh = new FileHandler("Server_gRPClog", true);
        } catch (IOException e) {
            logger.info("File I/O failed");
            e.printStackTrace();
        }


        try {
            logger.addHandler(fh);
        } catch (SecurityException e) {
            logger.info("Security Privileges Not Valid");
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter();
        try {
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            logger.info("Security Privileges Not Valid");
            e.printStackTrace();
        } catch (NullPointerException e) {
            logger.info("File Handler Not set Not Valid");
            e.printStackTrace();
        }

        //      Thread Safe Implementation of HashMap
        Map<String, String> localDbStore = new ConcurrentHashMap<>();
        Map<Txn, List<String>> volatileDbStore = new ConcurrentHashMap<>();
        Map<String,Boolean> lockManager = new ConcurrentHashMap<>();
//      gRPC server can handle request in parallel by default as it uses Netty under the hood
        logger.info("Listening on channel using port "+ String.valueOf(PORT_NUM));
        Server server = ServerBuilder.forPort(PORT_NUM)
                .addService(new DictionaryService(localDbStore,volatileDbStore,lockManager,logger,PORT_NUM))
                .addService(new TxnService(localDbStore,volatileDbStore,lockManager,logger,PORT_NUM))
                .build();
//        try{
//            server.start();
//        }catch(IOException e){
//            logger.info("Server Failed to start");
//            e.printStackTrace();
//        }
//        try {
//            server.awaitTermination();
//        }catch(InterruptedException e){
//            logger.info("Server Interrupted");
//            e.printStackTrace();
//        }
    }
}