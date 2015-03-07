package by.bsu.tender;

import static org.junit.Assert.*;

import org.junit.Test;

import by.bsu.tender.exception.TenderLogicException;

import java.text.ParseException;

public class TenderTestc {

	@Test
	public void testHashCode() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender2 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender3 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 10, "April 9, 2012", "May 9, 2012");
			assertEquals(tender.hashCode(), tender2.hashCode());
			if(tender2.hashCode() != tender3.hashCode()){
				assertNotEquals(tender2, tender3);
			}		
	}

	@Test
	public void testTender() {
		Tender tender = new Tender();
		assertNotNull(tender);
	}

	@Test
	public void testTenderWithParameters() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
	}

	@Test
	public void testGetNameTender() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getNameTender(), "Sciense");
	}

	@Test
	public void testGetNameRegion() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getNameRegion(), "Minsk");
	}

	@Test
	public void testGetNameOwner() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getNameOwner(), "Elcerm");
	}

	@Test
	public void testGetApplicationNumber() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getApplicationNumber(), 1);
	}

	@Test
	public void testGetSubsection() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getSubsection(), "Math");
	}

	@Test
	public void testGetDescription() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getDescription(), "First tender");
	}

	@Test
	public void testGetPrice() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getPrice(), 100);
	}

	@Test
	public void testGetDateBegin() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getDateBegin(), "April 9, 2012");
	}

	@Test
	public void testGetDateEnd() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			assertNotNull(tender);
			assertEquals(tender.getDateEnd(), "May 9, 2012");
	}

	@Test
	public void testSetNameTender() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setNameTender("Name");
			assertEquals(tender.getNameTender(), "Name");
	}
	
	@Test(expected=TenderLogicException.class)
	public void testSetNameTenderException() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setNameTender("");
	}

	@Test
	public void testSetNameRegion() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setNameRegion("Name");
			assertEquals(tender.getNameRegion(), "Name");
	}
	
	@Test(expected=TenderLogicException.class)
	public void testSetNameRegionException() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setNameRegion("");
	}

	@Test
	public void testSetNameOwner() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setNameOwner("Name");
			assertEquals(tender.getNameOwner(), "Name");
	}
	
	@Test(expected=TenderLogicException.class)
	public void testSetNameOwnerException() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setNameOwner("");
	}

	@Test
	public void testSetApplicationNumber() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setApplicationNumber(1);
			assertEquals(tender.getApplicationNumber(), 1);
	}
	
	@Test(expected=TenderLogicException.class)
	public void testSetApplicationNumberException() throws TenderLogicException {		
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setApplicationNumber(0);		
	}

	@Test
	public void testSetSubsection() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setSubsection("Physics");
			assertEquals(tender.getSubsection(), "Physics");
	}
	
	@Test(expected=TenderLogicException.class)
	public void testSetSubsectionException() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setSubsection("");
	}

	@Test
	public void testSetDescription() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setDescription("Sciense work");
			assertEquals(tender.getDescription(), "Sciense work");
	}
	
	@Test(expected=TenderLogicException.class)
	public void testSetDescriptionException() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setDescription("");
	}

	@Test
	public void testSetPrice() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setPrice(10);
			assertEquals(tender.getPrice(), 10);
	}
	
	@Test(expected=TenderLogicException.class)
	public void testSetPriceException() throws TenderLogicException {
			Tender tender = new Tender();
			assertNotNull(tender);
			tender.setPrice(0);
	}

	@Test
	public void testEqualsObject() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender2 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			Tender tender3 = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 10, "April 9, 2012", "May 9, 2012");
			assertTrue(tender.equals(tender2));
			assertFalse(tender2.equals(tender3));
	}

	@Test
	public void testToString() throws TenderLogicException, ParseException {
			Tender tender = new Tender("Sciense", "Minsk", "Elcerm", 1, "Math", "First tender", 100, "April 9, 2012", "May 9, 2012");
			String str = "Sciense Minsk Elcerm 1 Math First tender 100 April 9, 2012 May 9, 2012";
			assertEquals(str, tender.toString());
	}

}
