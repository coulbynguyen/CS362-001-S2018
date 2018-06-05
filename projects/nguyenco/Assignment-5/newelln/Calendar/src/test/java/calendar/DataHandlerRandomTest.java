package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		Appt [] appts = new Appt[100];
		DataHandler dh = new DataHandler();
		GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar day2 = new GregorianCalendar(2018, 21, 5);

		for(int i = 0; i < 100; i++){
		   long seed = System.currentTimeMillis();
		   Random random = new Random(seed);
		   int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 30);
		   int startHour = ValuesGenerator.getRandomIntBetween(random, -5, 10);
		   int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
		   int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 5);
		   int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
		   String title = "Birthday Party";
		   String description = "This is my birthday party.";
		   String emailAddress = "xyz@gmail.com";

		   Appt singleAppt = new Appt(startHour,
			 startMinute,
			 startDay,
			 startMonth,
			 startYear,
			 title,
			 description,
			 emailAddress);
		   singleAppt.setValid();
		   dh.saveAppt(singleAppt);
		   appts[i] = singleAppt;
		}
		assertNotNull(dh.getApptRange(day1, day2));
		for(int i = 0; i < 100; i++){
			dh.deleteAppt(appts[i]);
		}
		assertNotNull(dh.getApptRange(day1, day2));



	  }
	@Test
	public void autoSaveTest() throws Throwable{
		Appt [] appts = new Appt[100];
		DataHandler dh = new DataHandler(System.getProperty("user.dir")+System.getProperty("file.seperator")+ "calendar.xml", false);
		GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar day2 = new GregorianCalendar(2018, 21, 5);

		for(int i = 0; i < 100; i++){
		   long seed = System.currentTimeMillis();
		   Random random = new Random(seed);
		   int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 30);
		   int startHour = ValuesGenerator.getRandomIntBetween(random, -5, 10);
		   int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
		   int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 5);
		   int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
		   String title = "Birthday Party";
		   String description = "This is my birthday party.";
		   String emailAddress = "xyz@gmail.com";

		   Appt singleAppt = new Appt(startHour,
			 startMinute,
			 startDay,
			 startMonth,
			 startYear,
			 title,
			 description,
			 emailAddress);
		   singleAppt.setValid();
		   dh.saveAppt(singleAppt);
		   appts[i] = singleAppt;
		}
		assertNotNull(dh.getApptRange(day1, day2));
		for(int i = 0; i < 100; i++){
			dh.deleteAppt(appts[i]);
		}
		assertNotNull(dh.getApptRange(day1, day2));

	}
	@Test
	public void setXmlTest() throws Throwable{
		Appt [] appts = new Appt[100];
		DataHandler dh = new DataHandler();
		GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar day2 = new GregorianCalendar(2018, 21, 5);

		for(int i = 0; i < 100; i++){
		   long seed = System.currentTimeMillis();
		   Random random = new Random(seed);
		   int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 30);
		   int startHour = ValuesGenerator.getRandomIntBetween(random, -5, 10);
		   int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
		   int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 5);
		   int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
		   String title = "Birthday Party";
		   String description = "This is my birthday party.";
		   String emailAddress = "xyz@gmail.com";

		   Appt singleAppt = new Appt(startHour,
			 startMinute,
			 startDay,
			 startMonth,
			 startYear,
			 title,
			 description,
			 emailAddress);
		   singleAppt.setValid();
		   dh.saveAppt(singleAppt);
		   appts[i] = singleAppt;
		}
		assertNotNull(dh.getApptRange(day1, day2));
		for(int i = 0; i < 100; i++){
		   	appts[i].setXmlElement(null);
			dh.deleteAppt(appts[i]);
		}
		assertNotNull(dh.getApptRange(day1, day2));

	}

	@Test
	public void switchedDatesTest() throws Throwable{
		Appt [] appts = new Appt[100];
		DataHandler dh = new DataHandler();
		GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar day2 = new GregorianCalendar(2018, 21, 5);

		for(int i = 0; i < 100; i++){
		   long seed = System.currentTimeMillis();
		   Random random = new Random(seed);
		   int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 30);
		   int startHour = ValuesGenerator.getRandomIntBetween(random, -5, 10);
		   int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
		   int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 5);
		   int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
		   String title = "Birthday Party";
		   String description = "This is my birthday party.";
		   String emailAddress = "xyz@gmail.com";

		   Appt singleAppt = new Appt(startHour,
			 startMinute,
			 startDay,
			 startMonth,
			 startYear,
			 title,
			 description,
			 emailAddress);
		   singleAppt.setValid();
		   dh.saveAppt(singleAppt);
		   appts[i] = singleAppt;
		}
		try{
		   dh.getApptRange(day2, day1);
		}
		catch(Exception e){
			//do nothing
		}
		for(int i = 0; i < 100; i++){
		   appts[i].setXmlElement(null);
		   dh.deleteAppt(appts[i]);
		}
		assertNotNull(dh.getApptRange(day1, day2));


	}



}
