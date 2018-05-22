package calendar;


import org.junit.Test;


import static org.junit.Assert.*;
import java.util.*;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	 public void radnomtest()  throws Throwable  {
	    GregorianCalendar gregcal = new GregorianCalendar(2018, 21, 5);
	    CalDay calday = new CalDay(gregcal);
	    for(int i = 0; i < 100; i++){
	       long seed = System.currentTimeMillis();
	       Random random = new Random(seed);
	       int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 11);
	       int startMinute = ValuesGenerator.getRandomIntBetween(random, 10, 20);
	       int startDay = ValuesGenerator.getRandomIntBetween(random, -8, 8);
	       int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 10);
	       int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
	       String title = "Birthday Party";
	       String description = "This is my birthday party.";
	       String emailAddress = "xyz@gmail.com";

	       Appt appt = new Appt(startHour,
		     startMinute,
		     startDay,
		     startMonth,
		     startYear,
		     title,
		     description,
		     emailAddress);
	       appt.setValid();
	       calday.addAppt(appt);
	    } 




	 }



}
