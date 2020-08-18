package Runner;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.relevantcodes.extentreports.NetworkMode;



import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\main\\resources\\Features",
		glue={"stepDefination"},
		format ={"pretty","html:test-outout", "json:test-outout/cucumber.json", "junit:test-outout/cucumber.xml"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:test-output/report.html"},
		tags={"~@Reg","@smoke"},
		dryRun= false,
		monochrome = true
		
		)

public class TestRunner {
	
   public static String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
   public static String resultFileFolder="Run_"+timeStamp;
   public static String resultFileName="test-output/"+resultFileFolder+"/report.html";
	
   
   @BeforeClass
   public static void setUp(){
	   File file = new File(resultFileName);
	 //  ExtentCucumberFormatter.initiateExtentCucumberFormatter(file,NetworkMode.OFFLINE);
	  // ExtentCucumberFormatter.loadConfig(new File("/src/main/resources/extent-config.xml"));
	   
   }

	/*
	@AfterClass
	public static void setup()
	{
		
	Reporter.loadXMLConfig(new File());
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "AJ");
	Reporter.setSystemInfo("Application Name", "Test App");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	*/
	
}
