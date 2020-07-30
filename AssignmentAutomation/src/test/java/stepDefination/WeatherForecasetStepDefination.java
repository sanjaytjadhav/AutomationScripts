package stepDefination;

import java.util.HashMap;
import java.util.List;

import junit.framework.Assert;

import com.qa.la.base.TestBase;
import com.qa.la.pages.WeatherForecastPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherForecasetStepDefination extends TestBase {
	WeatherForecastPage weatherForecastPage ;
	
	
	@Given("^launch the weather forecast application$")
	public void launch_the_weather_forecast_application() {
		driver=init();
		weatherForecastPage= new WeatherForecastPage(driver);
	}

	@When("^user enter city name as \"(.*)\"$")
	public void user_enter_city_name_as(String cityName){
		weatherForecastPage.enterCityName(cityName);
	 }

	@Then("verify the five days weather forecast details$")
	public void verify_the_five_days_weather_forecast_details(DataTable table) {
		List<List<String>> forcastData = table.raw();

		Assert.assertEquals(5,weatherForecastPage.getNoOfDays());
		HashMap<String, String> days = weatherForecastPage.getdays();
		
		Assert.assertEquals(forcastData.get(0).get(0), days.get("Tue"));
		Assert.assertEquals(forcastData.get(0).get(1), days.get("Wed"));
		Assert.assertEquals(forcastData.get(0).get(2), days.get("Thu"));
		Assert.assertEquals(forcastData.get(0).get(3), days.get("Fri"));
		Assert.assertEquals(forcastData.get(0).get(4), days.get("Sat"));
		
	}

	@Then("^close the browser$")
	public void Close_the_browser() {
		driver.close();
	}
	
	@Then("^verify the error message \"(.*)\"$")
	public void verify_the_error_message(String msg) {
		Assert.assertEquals(msg, weatherForecastPage.getErrorMsg());
	}
	
	//Second feature file
	
	@Then("^user clicks on day1$")
	public void user_clicks_on_day1() {
		weatherForecastPage.clickOnDay1();
	}
	
	@Then("^user clicks on next day$")
    public void user_clicks_on_next_day() {
        weatherForecastPage.clickOnNextDay();
    }

    @Then("^user will be able to see three hourly forecast$")
    public void user_will_be_able_to_see_three_hourly_forecast(){
    	Assert.assertEquals(3, weatherForecastPage.getTheNoOfRecordsOfDay1());
    }
    
    @Then("^user will be able to see three hourly forecast for next day$")
    public void threehourelyforecastfornextday(){
    	Assert.assertEquals(8, weatherForecastPage.getTheNoOfRecordsOfDay2());
    }

    @Then("^three hourly forecast should be hidden$")
    public void three_hourly_forecast_should_be_hidden() {
       Assert.assertEquals(false, weatherForecastPage.isElementDispayed());
    }
    
    @Then("^summary of all the three hourly data should be displayed like below$")
    public void summary_of_all_the_three_hourly_data_should_be_displayed_like_below(DataTable threeHourlyData) {
    	List<List<String>> expDataList = threeHourlyData.raw();
    	weatherForecastPage.getAllTheRow1Data();
    	List<String> row1records=weatherForecastPage.allRecordsofRow1;
    	List<String> row2records=weatherForecastPage.allRecordsofRow2;
    	List<String> row3records=weatherForecastPage.allRecordsofRow3;
    	 
    		Assert.assertEquals(row1records.get(0), expDataList.get(1).get(0));
            Assert.assertEquals(row1records.get(1), expDataList.get(1).get(1));
            Assert.assertTrue((row1records.get(2).contains(expDataList.get(1).get(2))));
            Assert.assertTrue(row1records.get(2).contains(expDataList.get(1).get(3)));
            Assert.assertTrue((row1records.get(3).contains(expDataList.get(1).get(4))));
            Assert.assertTrue(row1records.get(4).contains(expDataList.get(1).get(5)));
            Assert.assertTrue((row1records.get(4).contains(expDataList.get(1).get(6))));
            
            Assert.assertEquals(row2records.get(0), expDataList.get(2).get(0));
            Assert.assertEquals(row2records.get(1), expDataList.get(2).get(1));
            Assert.assertTrue((row2records.get(2).contains(expDataList.get(2).get(2))));
            Assert.assertTrue(row2records.get(2).contains(expDataList.get(2).get(3)));
            Assert.assertTrue((row2records.get(3).contains(expDataList.get(2).get(4))));
            Assert.assertTrue(row2records.get(4).contains(expDataList.get(2).get(5)));
            Assert.assertTrue((row2records.get(4).contains(expDataList.get(2).get(6))));
            
            Assert.assertEquals(row3records.get(0), expDataList.get(3).get(0));
            Assert.assertEquals(row3records.get(1), expDataList.get(3).get(1));
            Assert.assertTrue((row3records.get(2).contains(expDataList.get(3).get(2))));
            Assert.assertTrue(row3records.get(2).contains(expDataList.get(3).get(3)));
            Assert.assertTrue((row3records.get(3).contains(expDataList.get(3).get(4))));
            Assert.assertTrue(row3records.get(4).contains(expDataList.get(3).get(5)));
            Assert.assertTrue((row3records.get(4).contains(expDataList.get(3).get(6))));
		
    }
	
}
