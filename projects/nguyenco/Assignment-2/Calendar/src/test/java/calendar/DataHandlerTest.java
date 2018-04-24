
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
	DataHandler testDataHandler = new DataHandler("calendar2.xml", true);

	//make sure the program does nothing when given bad data
	assertFalse(testDataHandler.deleteAppt(null));
  }

}
