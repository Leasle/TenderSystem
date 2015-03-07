package by.bsu.tender.database;

import org.apache.log4j.*;
import tokyocabinet.*;
import by.bsu.tender.Tender;
import by.bsu.tender.exception.TenderLogicException;
import java.util.*;
import java.io.InvalidObjectException;
import java.text.ParseException;

public class HashDB {

	public static void addTender(String nameDataBase, Tender record){
		//Logger log = Logger.getLogger("scientificwork");		
		//log.setLevel(Level.INFO);
		
		// create the object
	    HDB hdb = new HDB();

	    // open the database
	    if (!hdb.open(nameDataBase, BDB.OWRITER | BDB.OCREAT)) {
	    	int ecode = hdb.ecode();
	    	//log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + hdb.errmsg(ecode));
	    }
	    	    		
		byte[] value = Util.serialize(record);
		byte[] key = Util.packint(record.getApplicationNumber());
		
		// store records
		if (!hdb.put(key, value)) { 
		   	int ecode = hdb.ecode();
		   	//log.error("Put error: " + bdb.errmsg(ecode));
		   	System.err.println("Put error: " + hdb.errmsg(ecode));
		}
		
	    //close database
	    if (!hdb.close()) {
		    int ecode = hdb.ecode();
		    //log.error("Database is not close. Error: " + bdb.errmsg(ecode));
		    System.err.println("close error: " + hdb.errmsg(ecode));
	    }
	}
	
	public static void findTender(String nameDataBase, int key){
		//Logger log = Logger.getLogger("scientificwork");
		
		//log.setLevel(Level.INFO);
		// create the object
	    HDB hdb = new HDB();

	    // open the database
	    if (!hdb.open(nameDataBase, BDB.OWRITER | BDB.OCREAT)) {
	    	int ecode = hdb.ecode();
	    	//log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + hdb.errmsg(ecode));
	    }

	    byte[] currentKey = Util.packint(key);
	    System.out.println("key : " + key);
	    
	    //log.info("working");
	    // store records
	    byte[] value = hdb.get(currentKey);
	    Tender record = (Tender)Util.deserialize(value);
	    
	    System.out.println("Hash database");
	    System.out.println("Name of tender " + record.getNameTender());
	    System.out.println("record " + record);
	    if (value == null) {	     
	    	int ecode = hdb.ecode();
	    	//log.error("Get error: " + bdb.errmsg(ecode));
	    	System.err.println("Get error: " + hdb.errmsg(ecode));
	    }
	    
	    //close database
	    if (!hdb.close()) {
		    int ecode = hdb.ecode();
		    //log.error("Database is not close. Error: " + bdb.errmsg(ecode));
		    System.err.println("close error: " + hdb.errmsg(ecode));
		}
	}
	
	public void deleteTender(String nameDataBase, int key) {

		//Logger log = Logger.getLogger("scientificwork");
		
		//log.setLevel(Level.INFO);
		// create the object
		HDB hdb = new HDB();

	    // open the database
	    if (!hdb.open(nameDataBase, BDB.OWRITER | BDB.OCREAT)) {
	    	int ecode = hdb.ecode();
	    	//log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + hdb.errmsg(ecode));
	    }
	    
	    byte[] currentKey = Util.packint(key);

	    //log.info("working");
	 
	    // retrieve records
	    if (!hdb.out(currentKey)) {
	    	int ecode = hdb.ecode();
	    	//log.error("It is fail to remove the record. Error: " + bdb.errmsg(ecode));
	    	System.err.println("Remove error: " + hdb.errmsg(ecode));
	    }
	    // close the database
	    if (!hdb.close()) {
	    	int ecode = hdb.ecode();
	    	System.err.println("close error: " + hdb.errmsg(ecode));
	    }
	}
	
}
