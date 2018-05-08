/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

  @Test
  public void test02() {
  	CalDay dayOne = new CalDay(new GregorianCalendar(2018, 10, 10));

	dayOne.getFullInfomrationApp(dayOne);

	Appt calDayAppt1 = new Appt(7, 30, 10, 10, 2018, "Test 1", "This is test appt 1", "coulby@gmail.com");
	Appt calDayAppt2 = new Appt(8, 30, 10, 10, 2018, "Test 2", "This is test appt 2", "coulby@gmail.com");
	Appt calDayAppt3 = new Appt(9, 30, 10, 10, 2018, "Test 3", "This is test appt 3", "coulby@gmail.com");
	
	calDayAppt1.setValid();
	calDayAppt2.setValid();
	calDayAppt3.setValid();
	
	dayOne.addAppt(calDayAppt1);
	dayOne.addAppt(calDayAppt2);
	dayOne.addAppt(calDayAppt3);

	assertEquals(3, dayOne.getSizeAppts());

	String test = dayOne.toString();
	assertNotNull(test);

	String test2 = dayOne.getFullInfomrationApp(dayOne);
	assertNotNull(test2);
	
  }

  @Test
  public void test03(){
	CalDay dayTwo = new CalDay(new GregorianCalendar(2018, 10, 10));

	assertEquals(10, dayTwo.getDay());
	assertEquals(11, dayTwo.getMonth());
	assertEquals(2018, dayTwo.getYear());

	Appt calDayAppt4 = new Appt(7, 30, 10, 10, 2018, "Test 4", "This is test appt 4", "coulby@gmail.com");
	Appt calDayAppt5 = new Appt(8, 30, 10, 10, 2018, "Test 5", "This is test appt 4", "coulby@gmail.com");
	Appt calDayAppt6 = new Appt(9, 30, 10, 10, 2018, "Test 6", "This is test appt 4", "coulby@gmail.com");

	dayTwo.addAppt(calDayAppt4);
	dayTwo.addAppt(calDayAppt5);
	dayTwo.addAppt(calDayAppt6);

	assertTrue(calDayAppt4.hasTimeSet());
	
	String test3 = dayTwo.getFullInfomrationApp(dayTwo);
  	assertNotNull(test3);
  }
}
