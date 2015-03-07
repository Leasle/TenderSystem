package by.bsu.tender.database;

//import java.util.logging.Logger;
import org.apache.log4j.*;

import tokyocabinet.*;
import by.bsu.tender.Tender;
import by.bsu.tender.exception.TenderLogicException;
import java.util.*;
import java.io.InvalidObjectException;
import java.text.ParseException;

public class BTree {

	public static void addTender(String nameDataBase, Tender record){
		
		Logger log = LogManager.getLogger(BTree.class);

		PropertyConfigurator.configure("log4j2.properties");
		log.setLevel(Level.INFO);
//		 create the object
	    BDB bdb = new BDB();

	    // open the database
	    if (!bdb.open(nameDataBase, BDB.OWRITER | BDB.OCREAT)) {
	    	int ecode = bdb.ecode();
	    	log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + bdb.errmsg(ecode));
	    }
	    	    		
		byte[] value = Util.serialize(record);
		byte[] key = Util.packint(record.getApplicationNumber());
		//System.out.println("key : " + key);
		//System.out.println("value : " + value);
			
		/*Tender record5 = null;
		try {
			record5 = Tender.deserialize(value);
			System.out.println(record5.toString());
		} catch(InvalidObjectException e) {
			e.printStackTrace();
		}*/
				
		log.info("working");
		// store records
		if (!bdb.put(key, value)) { 
		   	int ecode = bdb.ecode();
		   	//log.error("Put error: " + bdb.errmsg(ecode));
		   	System.err.println("Put error: " + bdb.errmsg(ecode));
		}
		
	    //close database
	    if (!bdb.close()) {
		    int ecode = bdb.ecode();
		    log.error("Database is not close. Error: " + bdb.errmsg(ecode));
		    System.err.println("close error: " + bdb.errmsg(ecode));
	    }
	}
	
	public static void findTender(String nameDataBase, int key){
		Logger log = LogManager.getLogger(BTree.class);
		PropertyConfigurator.configure("log4j2.properties");
		
		log.setLevel(Level.INFO);
		// create the object
	    BDB bdb = new BDB();

	    // open the database
	    if (!bdb.open(nameDataBase, BDB.OWRITER | BDB.OCREAT)) {
	    	int ecode = bdb.ecode();
	    	log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + bdb.errmsg(ecode));
	    }

	    byte[] currentKey = Util.packint(key);
	    System.out.println("key : " + key);
	    
	    log.info("working");
	    // store records
	    byte[] value = bdb.get(currentKey);
	    Tender record = (Tender)Util.deserialize(value);
	    
	    System.out.println("Name of tender " + record.getNameTender());
	    System.out.println("record " + record);
	    if (value == null) {	     
	    	int ecode = bdb.ecode();
	    	log.error("Get error: " + bdb.errmsg(ecode));
	    	System.err.println("Get error: " + bdb.errmsg(ecode));
	    }
	    
	    //close database
	    if (!bdb.close()) {
		    int ecode = bdb.ecode();
		    log.error("Database is not close. Error: " + bdb.errmsg(ecode));
		    System.err.println("close error: " + bdb.errmsg(ecode));
		}
	}
	
	public void deleteTender(String nameDataBase, int key) {

		Logger log = LogManager.getLogger(BTree.class);
		PropertyConfigurator.configure("log4j2.properties");
		
		log.setLevel(Level.INFO);
		// create the object
		BDB bdb = new BDB();

	    // open the database
	    if (!bdb.open(nameDataBase, BDB.OWRITER | BDB.OCREAT)) {
	    	int ecode = bdb.ecode();
	    	log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + bdb.errmsg(ecode));
	    }
	    
	    byte[] currentKey = Util.packint(key);

	    log.info("working");
	 
	    // retrieve records
	    if (!bdb.out(currentKey)) {
	    	int ecode = bdb.ecode();
	    	log.error("It is fail to remove the record. Error: " + bdb.errmsg(ecode));
	    	System.err.println("Remove error: " + bdb.errmsg(ecode));
	    }

	    // close the database
	    if (!bdb.close()) {
	    	int ecode = bdb.ecode();
	    	System.err.println("close error: " + bdb.errmsg(ecode));
	    }
	}

}


