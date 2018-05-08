/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }

  @Test
  public void test01() {
	Appt testAppt = new Appt(15,30, 9, 14, 2018, "Homework", "Homework Assignment is Due Today", "coulby@gmail.com");
	//first to check that its a valid date entry
	assertEquals(true, testAppt.getValid());
	//check to see if the hour was set correctly
	assertEquals(15, testAppt.getStartHour());
	//check to see if the title is set correctly
	assertEquals("Homework", testAppt.getTitle());

  }

  @Test
  public void test02() throws Throwable{
     //month not a good value
     Appt appt1 = new Appt(14, 32, 2018, "Some Appt1", "Random Appointment 1", "coulby@gmail.com");
     String string1 = appt1.toString();
     int[] someint = null;
     appt1.setRecurrence(someint, 4, 6, 8);
     assertEquals(4, appt1.getRecurBy());
     assertEquals(6, appt1.getRecurIncrement());
     assertTrue(appt1.isRecurring());
  }

  @Test
  public void test03(){
    //hour not a good value
    Appt appt2 = new Appt(48, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    String string2 = appt2.toString();
    assertEquals("\t9/9/2018 at 36:30pm ,Birthday Party, This is my birthday party\n", string2);
  }

  @Test
  public void test04(){
    //hour not a good value
    Appt appt3 = new Appt(-48, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    String string3 = appt3.toString();
    assertEquals("\t9/9/2018 at -48:30am ,Birthday Party, This is my birthday party\n", string3);

  }

  @Test
  public void test05(){

     //minute not a good value
     Appt appt4 = new Appt(7, 61, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     String string4 = appt4.toString();
     assertEquals("\t9/9/2018 at 7:61am ,Birthday Party, This is my birthday party\n", string4);

  }

  @Test
  public void test06(){
	
     //minute not a good value
     Appt appt5 = new Appt(7, -20, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     String string5 = appt5.toString();
     assertEquals("\t9/9/2018 at 7:-20am ,Birthday Party, This is my birthday party\n", string5);
     
  }

  @Test
  public void test07(){
	
     //day not a good value
     Appt appt6 = new Appt(7, 30, 33, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     String string6 = appt6.toString();
     assertEquals("\t9/33/2018 at 7:30am ,Birthday Party, This is my birthday party\n", string6);
  }

  @Test
  public void test08(){

     //day not a good value
     Appt appt7 = new Appt(7, 30, -2, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     String string7 = appt7.toString();
     assertEquals("\t9/-2/2018 at 7:30am ,Birthday Party, This is my birthday party\n", string7);
  }

  @Test
  public void test09(){
	//no title
	Appt appt8 = new Appt(7, 30, 9, 9, 2018, null, "This is my birthday party", "xyz@gmail.com");
	String string8 = appt8.toString();
	assertEquals("\t9/9/2018 at 7:30am ,, This is my birthday party\n", string8);
  }

  @Test
  public void test10(){
	//no description
	Appt appt9 = new Appt(7, 30, 9, 9, 2018, "Birthday Party", null, "xyz@gmail.com");
	String string9 = appt9.toString();
	assertEquals("\t9/9/2018 at 7:30am ,Birthday Party, \n", string9);
  }

  @Test
  public void test11(){
     //no email
	Appt appt10 = new Appt(7, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", null);
	String string10 = appt10.toString();
	assertEquals("\t9/9/2018 at 7:30am ,Birthday Party, This is my birthday party\n", string10);
  }

  @Test
  public void test12(){
     //february not a leap year
	Appt appt11 = new Appt(7, 30, 29, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	String string11 = appt11.toString();
	assertEquals("\t2/29/2018 at 7:30am ,Birthday Party, This is my birthday party\n", string11);
  }

  @Test
  public void test13(){
     //february on a leap year
	Appt appt12 = new Appt(7, 30, 29, 2, 2016, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	String string12 = appt12.toString();
	assertEquals("\t2/29/2016 at 7:30am ,Birthday Party, This is my birthday party\n", string12);
  }

  @Test
  public void test14(){
     //year not a good value
     Appt appt13 = new Appt(7, 30, 9, 9, -1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     String string13 = appt13.toString();
     assertEquals("\t9/9/-1 at 7:30am ,Birthday Party, This is my birthday party\n", string13);
  }
}








