package by.bsu.tender;

import java.text.DateFormat;
import java.text.ParseException;

import by.bsu.tender.exception.TenderLogicException;



public class Tender{

	private String nameTender;
	private String region;
	private String nameOwner;
	private int applicationNumber;
	private String subsection;
	private String description;
	private int price;
	private String begin;
	private String end;
	//добавить поля имя/название того, кто добавил тендер и конец тендера 
	
	public Tender() {}
	public Tender(String name, String nameRegion, String owner, int application, String subsection, String description, int price, String begining, String end) throws TenderLogicException, ParseException {
		nameTender = name;
		region = nameRegion;
		nameOwner = owner;
		applicationNumber = application;
		this.subsection = subsection;
		this.description = description;
		this.price = price;
		//DateFormat date = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
		//try{
			begin = begining;
		//} catch(ParseException e){
			//throw e;
		//}
			//DateFormat date = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
			//System.out.println(DateFormat.getAvailableLocales());
			//this.end = date.parse(end);
				this.end = end;
			
	}
	
	public String getNameTender(){
		return nameTender;
	}
	
	public String getNameRegion(){
		return region;
	}
	
	public String getNameOwner(){
		return nameOwner;
	}
	
	public int getApplicationNumber(){
		return applicationNumber;
	}
	
	public String getSubsection(){
		return subsection;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String getDateBegin(){
		return begin;
	}
	
	public String getDateEnd(){
		return end;
	}
	
	public void setNameTender(String name) throws TenderLogicException {
		if (name.length() == 0)
			throw new TenderLogicException("Name of tender is empty.");
		nameTender = name;
	}
	
	public void setNameRegion(String nameRegion) throws TenderLogicException {
		if (nameRegion.length() == 0)
			throw new TenderLogicException("Name of region is empty.");
		region = nameRegion;
	}
	
	public void setNameOwner(String owner) throws TenderLogicException {
		if (owner.length() == 0)
			throw new TenderLogicException("Name of owner is empty.");
		nameOwner = owner;
	}
	
	public void setApplicationNumber(int applicationNumber) throws TenderLogicException {
		if (applicationNumber <= 0)
			throw new TenderLogicException("Application number of tender is empty.");
		this.applicationNumber = applicationNumber;
	}
	
	public void setSubsection(String subsection) throws TenderLogicException {
		if (subsection.length() == 0)
			throw new TenderLogicException("Name of subsection is empty.");
		this.subsection = subsection;
	}
	
	public void setDescription(String description) throws TenderLogicException {
		if (description.length() == 0)
			throw new TenderLogicException("Description of tender is empty.");
		this.description = description;
	}
	
	public void setPrice(int price) throws TenderLogicException {
		if (price <= 0)
			throw new TenderLogicException("Price of tender is incorrect.");
		this.price = price;
	}
	
	/*public void setDateBegin(String begining) throws ParseException {
		DateFormat date = DateFormat.getDateInstance(DateFormat.LONG, new Locale("BY"));
		try{
			begin = date.parse(begining);
		} catch(ParseException e){
			throw e;
		}
	}*/
	
	@Override
	public boolean equals(Object tender) {
		if(this == tender)
			return true;
		if(tender == null)
			return false;
		if(getClass() != tender.getClass())
			return false;
		Tender tend = (Tender) tender;
		if(nameTender == null) {
			if(tend.nameTender != null)
				return false;
		} else if(!nameTender.equals(tend.nameTender))
			return false;
		if(region == null) {
			if(tend.region != null)
				return false;
		} else if(!region.equals(tend.region))
			return false;
		if(nameOwner == null) {
			if(tend.nameOwner != null)
				return false;
		} else if(!nameOwner.equals(tend.nameOwner))
			return false;
		if(applicationNumber != tend.applicationNumber)
				return false;
		if(subsection == null) {
			if(tend.subsection != null)
				return false;
		} else if(!subsection.equals(tend.subsection))
			return false;
		if(description == null) {
			if(tend.description != null)
				return false;
		} else if(!description.equals(tend.description))
			return false;
		if(price != tend.price)
			return false;
		if(begin == null) {
			if(tend.begin != null)
				return false;
		} else if(!begin.equals(tend.begin))
			return false;
		if(end == null) {
			if(tend.end != null)
				return false;
		} else if(!end.equals(tend.end))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		int code = (int)(19 * applicationNumber + 23 * price + ((nameTender == null)?0:nameTender.hashCode()) + ((region == null)?0:region.hashCode()) + ((nameOwner == null)?0:nameOwner.hashCode()) + ((subsection == null)?0:subsection.hashCode()) + ((description == null)?0:description.hashCode()) + ((begin == null)?0:begin.hashCode()) + ((end == null)?0:end.hashCode()));
		return code;
	}
	
	@Override
	public String toString(){
		return "" + this.getNameTender() + " " + this.getNameRegion() + " " + this.getNameOwner() + " " + this.getApplicationNumber() + " " + this.getSubsection() + " " + this.getDescription() + " " + this.getPrice() + " " + this.getDateBegin() + " " + this.getDateEnd();
	}
	
	/*public static Tender deserialize(byte[] data) throws InvalidObjectException {
	    try {
	    	ByteArrayInputStream in = new ByteArrayInputStream(data);
	    	ObjectInputStream is = new ObjectInputStream(in);
	    	Tender tender = (Tender) is.readObject();
	    	return tender;
	    } catch(ClassNotFoundException ce) {
	    	System.out.println("Class not exist." + ce);
	    } catch(InvalidClassException ioe) {
	    	System.out.println("Versions of class are different." + ioe);
	    } catch(IOException ioe) {
	    	System.out.println("Ordinary error." + ioe);
	    }
	    throw new InvalidObjectException("Object not restore.");
	}*/
}
