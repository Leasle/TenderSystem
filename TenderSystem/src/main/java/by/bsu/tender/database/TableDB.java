package by.bsu.tender.database;

//import java.util.logging.Logger;
import org.apache.log4j.*;
import tokyocabinet.*;
import by.bsu.tender.Tender;
import by.bsu.tender.exception.TenderLogicException;
import java.util.*;
import by.bsu.tender.typesearch.TypeSearch;
import java.io.InvalidObjectException;
import java.text.ParseException;

public class TableDB {

	public static void addTender(String nameDataBase, Tender record){
		//Logger log = Logger.getLogger("scientificwork");
		
		//log.setLevel(Level.INFO);
		// create the object
	    TDB tdb = new TDB();

	    // open the database
	    if (!tdb.open(nameDataBase, TDB.OWRITER | TDB.OCREAT)) {
	    	int ecode = tdb.ecode();
	    	//log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + tdb.errmsg(ecode));
	    }
				
		//log.info("working");
		// store records
		
		String key = new Long(tdb.genuid()).toString();
	    Map cols = new HashMap();
	    cols.put("Name", record.getNameTender());
	    cols.put("Region", record.getNameRegion());
	    cols.put("Owner", record.getNameOwner());
	    cols.put("Application_Number", record.getApplicationNumber());
	    cols.put("Subsection", record.getSubsection());
	    cols.put("Description", record.getDescription());
	    cols.put("Price", record.getPrice());
	    cols.put("Begin", record.getDateBegin());
	    cols.put("End", record.getDateEnd());
	    
		if (!tdb.put(key, cols)) { 
		   	int ecode = tdb.ecode();
		   	//log.error("Put error: " + bdb.errmsg(ecode));
		   	System.err.println("Put error: " + tdb.errmsg(ecode));
		}
		
	    //close database
	    if (!tdb.close()) {
		    int ecode = tdb.ecode();
		    //log.error("Database is not close. Error: " + bdb.errmsg(ecode));
		    System.err.println("close error: " + tdb.errmsg(ecode));
	    }
	}
	
	public static void findTender(String nameDataBase, Tender search, TypeSearch type){
		//Logger log = Logger.getLogger("scientificwork");
		
		//log.setLevel(Level.INFO);
		// create the object
	    TDB tdb = new TDB();

	    // open the database
	    if (!tdb.open(nameDataBase, TDB.OWRITER | TDB.OCREAT)) {
	    	int ecode = tdb.ecode();
	    	//log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + tdb.errmsg(ecode));
	    }
	    
	    TDBQRY tendersrc = new TDBQRY(tdb);
	    
	    if (search.getNameTender() != null)	    
	    	tendersrc.addcond("Name", TDBQRY.QCSTRINC, search.getNameTender());
	    if (search.getNameRegion() != null)
	    	tendersrc.addcond("Region", TDBQRY.QCSTRINC, search.getNameRegion());
	    if (search.getNameOwner() != null)
	    	tendersrc.addcond("Owner", TDBQRY.QCSTRINC, search.getNameOwner());
	    if (search.getApplicationNumber() != 0)
	    	tendersrc.addcond("Application_Number", TDBQRY.QCNUMEQ, String.valueOf(search.getApplicationNumber()));
	    if (search.getSubsection() != null)
	    	tendersrc.addcond("Subsection", TDBQRY.QCSTRINC, search.getSubsection());
	    if (search.getDescription() != null)
	    	tendersrc.addcond("Description", TDBQRY.QCSTRINC, search.getDescription());
	    if (search.getPrice() != 0)
	    	tendersrc.addcond("Price", TDBQRY.QCNUMEQ, String.valueOf(search.getPrice()));
	    if (search.getDateBegin() != null)
	    	tendersrc.addcond("Begin", TDBQRY.QCSTRINC, search.getDateBegin());
	    if (search.getDateEnd() != null)
	    	tendersrc.addcond("End", TDBQRY.QCSTRINC, search.getDateEnd());
	    
	    switch(type) {
	    	case NAME: { 
	    		tendersrc.setorder("Name", TDBQRY.QOSTRASC);
	    		break;
	    	}
	    	case PRICE: {
	    		tendersrc.setorder("Price", TDBQRY.QONUMASC);
	    		break;
	    	}
	    	case BEGIN: {
	    		tendersrc.setorder("Begin", TDBQRY.QOSTRASC);
	    		break;
	    	}
	    	default: {
	    		tendersrc.setorder("Name", TDBQRY.QOSTRASC);
	    		break;
	    	}	    	
	    }
	    
	    tendersrc.setlimit(10, 0);
	    
	    List res = tendersrc.search();
	    Iterator it = res.iterator();
	    while(it.hasNext()){
	      String rkey = new String((byte[])it.next());
	      Map rcols = tdb.get(rkey);
	      System.out.println("name:" + rcols.get("name"));
	    }
	    
	    //close database
	    if (!tdb.close()) {
		    int ecode = tdb.ecode();
		    //log.error("Database is not close. Error: " + bdb.errmsg(ecode));
		    System.err.println("close error: " + tdb.errmsg(ecode));
		}
	}
	
	public void deleteTender(String nameDataBase, int key) {

		//Logger log = Logger.getLogger("scientificwork");
		
		//log.setLevel(Level.INFO);
		// create the object
		TDB tdb = new TDB();

	    // open the database
	    if (!tdb.open(nameDataBase, TDB.OWRITER | TDB.OCREAT)) {
	    	int ecode = tdb.ecode();
	    	//log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + tdb.errmsg(ecode));
	    }
	    
	    byte[] currentKey = Util.packint(key);

	    //log.info("working");
	 
	    // retrieve records
	    if (!tdb.out(currentKey)) {
	    	int ecode = tdb.ecode();
	    	//log.error("It is fail to remove the record. Error: " + bdb.errmsg(ecode));
	    	System.err.println("Remove error: " + tdb.errmsg(ecode));
	    }

	    // close the database
	    if (!tdb.close()) {
	    	int ecode = tdb.ecode();
	    	System.err.println("close error: " + tdb.errmsg(ecode));
	    }
	}

}


