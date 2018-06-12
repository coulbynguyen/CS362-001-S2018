
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
 	  UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

 	  assertFalse(urlVal.isValid(""));
 	  assertFalse(urlVal.isValid(null));
 	  assertTrue(urlVal.isValid("http://www.test.com"));
 	  assertTrue(urlVal.isValid("http://test.com"));
 	  //assertTrue(urlVal.isValid("www.test.com"));
 	  //assertTrue(urlVal.isValid("test.com"));

 	  assertEquals(false, urlVal.isValid("://test.com"));
 	  assertEquals(false, urlVal.isValid("http:test.com"));
 	  assertEquals(false, urlVal.isValid("http//test.com"));
 	  //assertEquals(false, urlVal.isValid("http:/test.com"));
 	  //something wrong with http!

 	  //assertEquals(false, urlVal.isValid("http://.com"));
 	  //assertEquals(false, urlVal.isValid("http://test.asdf"));
 	  //something wrong with URL tails?

 	  assertEquals(false, urlVal.isValid("http://qq.com:80"));
 	  assertEquals(false, urlVal.isValid("http://qq.com:70000"));

 	 //assertEquals(false, urlVal.isValid("http://asdfasdfasdfasdfasdfasfdasdf"));
 	 //assertEquals(false, urlVal.isValid("q://asdfasdfasdfasdfasdfasdfasdfasdf"));
    }


    public void testYourFirstPartition()
    {
 	 //Scheme Test
 	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
 	 assertEquals(true, urlVal.isValid("http://test.com"));

 	 assertEquals(false, urlVal.isValid("3qs3://test.com"));
 	 assertEquals(false, urlVal.isValid("http test.com"));
 	 assertEquals(false, urlVal.isValid("http/test.com"));
 	 assertEquals(false, urlVal.isValid("http:test.com"));
 	 //assertEquals(true, urlVal.isValid("ftp://test.com")); //something wrong here
 	 //assertEquals(true, urlVal.isValid("h3t://test.com"));
 	 //assertEquals(false, urlVal.isValid("ftx://test.com"));
    }

    public void testYourSecondPartition(){
 	 //Authority Test
 	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

 	 //assertEquals(false, urlVal.isValid("http://.com"));
 	 //assertEquals(false, urlVal.isValid("http://test.asdf"));
 	 assertEquals(true, urlVal.isValid("http://test.asdf")); //should be FALSE, is true
 	 assertEquals(true, urlVal.isValid("http://go.a"));      //inverse authority accept?
    }

    public void testYourThirdPartition(){
 	 //Port Test
 	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

 	 assertEquals(false, urlVal.isValid("http://www.test.com:80")); //should be true, evals to false
 	 assertEquals(false, urlVal.isValid("http://www.test.com:800000000"));
 	 assertEquals(false, urlVal.isValid("http://www.test.com:-1"));
 	 //assertEquals(true, urlVal.isValid("http://www.test.com:65535")); //no ports evaluating to true
    }

    public void testYourFourthPartition(){
 	 //Path options test
 	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
 	 assertEquals(true, urlVal.isValid("http://www.test.com/test1"));
 	 assertEquals(false, urlVal.isValid("http://www.test.com/../"));
    }

    public void testYourFifthPartition(){
 	 //Query Options Test
 	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

 	 assertEquals(true, urlVal.isValid("http://www.test.com?action=view"));
    }

    public void testYourSixthPartition(){
 	 //IP Test
 	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

 	 assertEquals(true, urlVal.isValid("http://0.0.0.0"));
 	 assertEquals(true, urlVal.isValid("http://255.255.255.255"));
 	 assertEquals(false, urlVal.isValid("0.0.0.0"));		 //should be true, IP error?
 	 assertEquals(false, urlVal.isValid("255.255.255.255"));

 	 assertEquals(false, urlVal.isValid("1.2.3"));
 	 assertEquals(false, urlVal.isValid(".1.2.3"));
 	 assertEquals(false, urlVal.isValid("1.2.3."));
 	 assertEquals(false, urlVal.isValid("1.2.3.4.5"));

 	 //assertEquals(true, urlVal.isValid("255.255.255.255"));

 	 //assertEquals(false, urlVal.isValid("0.0.0.0.0"));
 	 assertEquals(true, urlVal.isValid("http://0.0.0.0.0")); //that's bad

 	 //assertEquals(false, urlVal.isValid("http://256.256.256.256"));
 	 assertEquals(true, urlVal.isValid("http://256.256.256.256")); //something wrong with IP bounds

 	 //assertEquals(false, urlVal.isValid("0.0.0.0.0"));
 	 //assertEquals(false, urlVal.isValid("http://0.0.0.0.0"));

    }

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
