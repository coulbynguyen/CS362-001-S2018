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
     	Calendar rightnow = Calendar.getInstance();
	int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	int thisMonth = rightnow.get(Calendar.MONTH);
	int thisYear = rightnow.get(Calendar.YEAR);

	GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);

	CalDay testCalDay = new CalDay(today);

	//to make sure that the construcdtor functions correctly assigns the right variables
	assertEquals(thisYear, testCalDay.getYear());
	assertEquals(thisMonth, testCalDay.getMonth());
	assertEquals(thisDay, testCalDay.getDay());
  }

}
