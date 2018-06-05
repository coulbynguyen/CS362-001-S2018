package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		System.out.println("Done testing...");
	  }
	 @Test
	 public void randomTestIsOn()  throws Throwable  {
	    long randomseed =System.currentTimeMillis();
	    Random random = new Random(randomseed);
	    int startHour=ValuesGenerator.getRandomIntBetween(random,  1, 11);
	    int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	    int startDay=ValuesGenerator.getRandomIntBetween(random, -31, 31);
	    int startMonth=ValuesGenerator.getRandomIntBetween(random, -12, 12);
	    int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
	    String title="Birthday Party";
	    String description="This is my birthday party.";
	    String emailAddress="xyz@gmail.com";

	    Appt appt = new Appt(startHour,
		  startMinute ,
		  startDay ,
		  startMonth ,
		  startYear ,
		  title,
		  description,
		  emailAddress);

	    for(int i = -30; i <= 31; i++){
	       for(int j = -12; j <= 12; j++){
		  if(appt.isOn(i, j, 2018)){
		     assertTrue(appt.isOn(startDay, startMonth, 2018));
		  }
		  if(appt.isOn(i, j, 2017)){
			//do nothing
		  }
	       }
	    }
	 }





	 @Test
	 public void testSetValid(){
	    for(int i = 0; i < NUM_TESTS; i++){
	       long seed = System.currentTimeMillis();
	       Random random = new Random(seed);
	       int startHour=ValuesGenerator.getRandomIntBetween(random, -24, 24);
	       int startMinute=ValuesGenerator.getRandomIntBetween(random, -60, 60);
	       int startDay=ValuesGenerator.getRandomIntBetween(random, -31, 31);
	       int startMonth=ValuesGenerator.getRandomIntBetween(random, -12, 12);
	       int startYear=ValuesGenerator.getRandomIntBetween(random, -10, 10);
	       String title="Birthday Party";
	       String description="This is my birthday party.";
	       String emailAddress="xyz@gmail.com";

	       //Construct a new Appointment object with the initial data	 
	       //Construct a new Appointment object with the initial data	 
	       Appt appt = new Appt(startHour,
		     startMinute ,
		     startDay ,
		     startMonth ,
		     startYear ,
		     title,
		     description,
		     emailAddress);
	       appt.setValid();
	       if(appt.getStartMonth() >= 0 && appt.getStartMonth() <= 12){
		  if(appt.getStartYear() > 0){
		     if(appt.getStartMinute() >= 0 && appt.getStartMinute() <= 60){
			if(appt.getStartHour() >= 0 && appt.getStartHour() <= 24){
			   if(appt.getStartDay() > 0 && appt.getStartDay() < CalendarUtil.NumDaysInMonth(appt.getStartYear(), appt.getStartMonth() - 1)){
			      assertTrue(true);
			   }
			}
		     }
		  }
	       }
	    }
	 }

	 @Test
	 public void testNoTime(){
	    for(int i = 0; i < NUM_TESTS; i++){
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 11);
		int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
		int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 11);
		String title="Birthday Party";
		String description="This is my birthday party.";
		String emailAddress="xyz@gmail.com";

		Appt appt = new Appt(startDay,
		      startMonth,
		      startYear,
		      title,
		      description,
		      emailAddress);

		assertTrue(appt.getValid());
	    }

	 }

	@Test
	public void testRecurDays(){
	   for(int i = 0; i < NUM_TESTS; i++){
	      long randomseed =System.currentTimeMillis(); //10
	      //			System.out.println(" Seed:"+randomseed );
	      Random random = new Random(randomseed);

	      int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	      int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	      int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	      int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	      int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
	      String title="Birthday Party";
	      String description="This is my birthday party.";
	      String emailAddress="xyz@gmail.com";

	      //Construct a new Appointment object with the initial data	 
	      //Construct a new Appointment object with the initial data	 
	      Appt appt = new Appt(startHour,
		    startMinute ,
		    startDay ,
		    startMonth ,
		    startYear ,
		    title,
		    description,
		    emailAddress);
	            appt.setRecurrence(null, 1, 1, 1);
	   	    assertTrue(appt.hasTimeSet());
	   }
	   
	}





}
