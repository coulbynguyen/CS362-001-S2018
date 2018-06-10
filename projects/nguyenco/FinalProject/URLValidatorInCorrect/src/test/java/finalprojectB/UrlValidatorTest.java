
package finalprojectB;
import java.lang.StringBuilder;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);

   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	UrlValidator myUrlValidator;
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	ResultPair[] testUrlScheme = {new ResultPair("http://", true),
	   				new ResultPair("ftp://", true),
					new ResultPair("3ht://", false),
					new ResultPair("http:", false),
					new ResultPair("://", false)};
	ResultPair[] testUrlAuthority = {new ResultPair("www.google.com",true),
					new ResultPair("go.com", true),
					new ResultPair("256.256.256.256", true),
					new ResultPair("1.2.3.4.5", false),
					new ResultPair("aaa", false)};
	ResultPair[] testUrlPort = {new ResultPair(":80", true),
	   				new ResultPair(":65535", true),
					new ResultPair("", true),
					new ResultPair(":-1", false),
					new ResultPair(":65a", false)};
	ResultPair[] testPath = {new ResultPair("/test1", true),
	   				new ResultPair("/t123", true),
					new ResultPair("", true),
					new ResultPair("/..", false),
					new ResultPair("/..//file", false)};
	ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
	   				new ResultPair("?action=edit&mode=up", true),
					new ResultPair("", true)};

	//UrlValidator myUrlValidator = new UrlValidator(null, null, 1);
	//long allowAllSchemes = 1 << 0;
	//UrlValidator myUrlValidator = new UrlValidator(allowAllSchemes);
	UrlValidator myUrlValidator = new UrlValidator();
	Random rand = new Random();
	for(int i = 0; i < 1000; i++){
	   StringBuilder testBuffer = new StringBuilder();
	   boolean expected = true;

	   int testUrlSchemeIdx = rand.nextInt(5);
	   testBuffer.append(testUrlScheme[testUrlSchemeIdx].item);
	   expected &= testUrlScheme[testUrlSchemeIdx].valid;

	   int testUrlAuthorityIdx = rand.nextInt(5);
	   testBuffer.append(testUrlAuthority[testUrlAuthorityIdx].item);
	   expected &= testUrlAuthority[testUrlAuthorityIdx].valid;

	   int testUrlPortIdx = rand.nextInt(5);
	   testBuffer.append(testUrlPort[testUrlPortIdx].item);
	   expected &= testUrlPort[testUrlPortIdx].valid;

	   int testPathIdx = rand.nextInt(5);
	   testBuffer.append(testPath[testPathIdx].item);
	   expected &= testPath[testPathIdx].valid;

	   int testUrlQueryIdx = rand.nextInt(3);
	   testBuffer.append(testUrlQuery[testUrlQueryIdx].item);
	   expected &= testUrlQuery[testUrlQueryIdx].valid;
	   
	   String url = testBuffer.toString();
	   boolean result = myUrlValidator.isValid(url);
	
	   System.out.println(result);
	   if(result == true){
	      System.out.println("pass");
	   //   System.out.println(url);
	   }	      
	}


   }



}
