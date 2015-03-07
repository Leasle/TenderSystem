package by.bsu.tender.action;

import java.util.Date;
import by.bsu.tender.Tender;
import by.bsu.tender.exception.TenderLogicException;
import by.bsu.tender.database.BTree;
import by.bsu.tender.database.HashDB;
import by.bsu.tender.typesearch.TypeSearch;
import java.text.ParseException;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Runner {

	public static void main(String[] args) {
		
		Logger log = LogManager.getLogger(Runner.class);
		PropertyConfigurator.configure("log4j2.properties");
		String databaseFile = "src/main/resource/Math.tcb";
		String hashDatabase = "src/main/resource/hashdatabase.tcb";
		int number = 1;
		
		HashMap<Integer, Tender> tendermap = new HashMap<Integer, Tender>();
		
		try {
			Tender tender1 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender2 = new Tender("Sciense", "Brest", "Elcerm", 2, "Phisycs", "Senond tender", 100, "December 9, 2011", "Febriary 20, 2012");
			Tender tender3 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender4 = new Tender("Sciense", "Gomel", "Elcerm", 3, "Chemistry", "Four tender", 100, "April 10, 2012", "June 29, 2012");
			Tender tender5 = new Tender("Sciense", "Mogilev", "Elcerm", 4, "Math", "Fivse tender", 100, "April 9, 2012", "May 9, 2012");
			
			tendermap.put(1, tender1);
			tendermap.put(2, tender2);
			tendermap.put(3, tender3);
			tendermap.put(4, tender4);
			tendermap.put(5, tender5);
			
			Tender tenderforsearching = new Tender("", "Minsk", "", 0, "Math", "", 0, "", "");
			
			System.out.println(tendermap);
			
			Set<Map.Entry<Integer, Tender>> tenderset = tendermap.entrySet();
			
			System.out.println(tenderset);
			
			Iterator<Map.Entry<Integer, Tender>> i = tenderset.iterator();
			while (i.hasNext()) {
				
				Map.Entry<Integer, Tender> me = i.next();
				System.out.println(me.getKey() + " : " + me.getValue());
			}
						
			BTree.addTender(databaseFile, tender1);
			BTree.findTender(databaseFile, number);
			HashDB.addTender(hashDatabase, tender1);
			HashDB.findTender(hashDatabase, number);
		} catch (TenderLogicException | ParseException e) {
			log.error("Tender object exception. Error: " + e);
			e.printStackTrace();
		}
	}
}
