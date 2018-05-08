
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

  @Test
  public void test02() throws Throwable{
 	DataHandler testDataHandler = new DataHandler("SomeFile", true);

	GregorianCalendar dayOne = new GregorianCalendar(2018, 10, 9);
	GregorianCalendar dayTwo = new GregorianCalendar(2018, 10, 10);

	CalDay test1 = new CalDay(dayOne);
	CalDay test2 = new CalDay(dayTwo);

	Appt testAppt1 = new Appt(7, 30, 10, 9, 2018, "Test 1", "This is test appt 1", "coulby@gmail.com");
	Appt testAppt2 = new Appt(8, 30, 10, 9, 2018, "Test 2", "This is test appt 2", "coulby@gmail.com");
	
	int[] daysToRecur = new int[3];
	daysToRecur[0] = 9;
	daysToRecur[1] = 10;
	daysToRecur[2] = 11;
	testAppt1.setRecurrence(daysToRecur, 4, 1, 2);
	testAppt2.setRecurrence(daysToRecur, 4, 1, 2);

	testAppt1.setValid();
	testAppt2.setValid();

	assertTrue(testDataHandler.saveAppt(testAppt1));
	assertTrue(testDataHandler.saveAppt(testAppt2));

	assertNotNull(testDataHandler.getApptRange(dayOne, dayTwo));

	assertTrue(testDataHandler.deleteAppt(testAppt1));
	assertTrue(testDataHandler.deleteAppt(testAppt2));

  }

  @Test
  public void test03() throws Throwable{
	DataHandler testDataHandler2 = new DataHandler("SomeFile2", false);

	assertNotNull(testDataHandler2);

	GregorianCalendar dayThree = new GregorianCalendar(2018, 2, 2);
	GregorianCalendar dayFour = new GregorianCalendar(2018, 3, 2);

	Appt testAppt3 = new Appt(7, 30, 2, 2, 2018, "Test 3", "This is test appt 3", "coulby@gmail.com");
	Appt testAppt4 = new Appt(8, 30, 2, 4, 2018, "Test 4", "This is test appt 4", "coulby@gmail.com");

	int[] daysToRecur = new int[3];
	daysToRecur[0] = 2;
	daysToRecur[1] = 3;
	daysToRecur[2] = 4;
	testAppt3.setRecurrence(daysToRecur, 3, 1, 1000);
	int[] daysToNotRecur = new int[0];
	testAppt4.setRecurrence(daysToNotRecur, 0, 0, 0);

	testAppt3.setValid();
	testAppt4.setValid();

	assertTrue(testAppt3.getValid());
	assertTrue(testAppt4.getValid());

	assertTrue(testDataHandler2.saveAppt(testAppt3));
	assertTrue(testDataHandler2.saveAppt(testAppt4));

	try{
	   assertNull(testDataHandler2.getApptRange(dayFour, dayThree));
	} catch (DateOutOfRangeException e){
	   System.out.println("DateOutOfRangeException Caught");
	}


  }

}









