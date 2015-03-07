package by.bsu.tender;

import java.text.ParseException;
import java.util.*;
import by.bsu.tender.*;
import by.bsu.tender.database.BTree;
import tokyocabinet.*;
import by.bsu.tender.exception.TenderLogicException;
import java.io.InvalidObjectException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import tokyocabinet.BDB;
import tokyocabinet.Util;

public class TenderTest {

	@Test
	public void testAddTender() {
		// Add tender to collection
		// Check ..
		
		try {
			Tender tender1 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender2 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender3 = new Tender("Sciense2", "Minsk", "Elcerm", 3, "Math", "Third tender", 150, "May 9, 2014", "June 9, 2012");
			
			Tender[] tender = new Tender[2];
			tender[0] = tender1;
			tender[1] = tender2;
			//tender[2] = tender3;
			
			List<Tender> list = Arrays.asList(tender);
			/*list.add(tender1);
			list.add(tender2);
			list.add(tender3);*/
			
			assertThat("Integer needs to be equal each other", 1, equalTo(1));
			assertThat("There are no some objects in array tender", tender, hasItemInArray(tender2));
			assertThat("There is no object in list", list, hasItem(tender2));
			assertThat("There are no some of this objects in list", list, hasItems(tender));
			
		} catch (TenderLogicException | ParseException e) {
			e.printStackTrace();
		}		
		
		
	}
	
	@Test
	public void testFindTender(){
		
		String nameDataBase = "Math";
		int key = 3;
		
	    BDB bdb = new BDB();

	    if (!bdb.open(nameDataBase, BDB.OWRITER | BDB.OCREAT)) {
	    	int ecode = bdb.ecode();
	    	//log.error("open error: " + bdb.errmsg(ecode));
	    	System.err.println("Database is not open. Error: " + bdb.errmsg(ecode));
	    }
	    
	    try{
		    Tender tender = new Tender("Sciense", "Minsk", "Eclerm", 1, "Math", "First tender", 100, "April 9, 2012", "April 9, 2012");
		    
		    byte[] value1 = Util.serialize(tender);
			byte[] curKey = Util.packint(tender.getApplicationNumber());
		    
		    byte[] currentKey = Util.packint(key);
		    
		    System.out.println();
		    
		    byte[] value = bdb.get(currentKey);
		    Tender record = (Tender)Util.deserialize(value);
		    
		    //assertThat(record, sameInstance(tender));
		    
		    if (value == null) {	     
		    	int ecode = bdb.ecode();
		    	//log.error("Get error: " + bdb.errmsg(ecode));
		    	System.err.println("Get error: " + bdb.errmsg(ecode));
		    }
	    
	    } catch (TenderLogicException | ParseException e) {
			e.printStackTrace();
		}		
	    
	    //close database
	    if (!bdb.close()) {
		    int ecode = bdb.ecode();
		    //log.error("Database is not close. Error: " + bdb.errmsg(ecode));
		    System.err.println("close error: " + bdb.errmsg(ecode));
		}
	}
}
