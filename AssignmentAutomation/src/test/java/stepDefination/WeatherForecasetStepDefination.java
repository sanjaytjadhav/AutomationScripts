package stepDefination;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.Assert;

import com.qa.la.base.TestBase;
import com.qa.la.pages.WeatherForecastPage;
import com.qa.la.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherForecasetStepDefination extends TestBase {
	WeatherForecastPage weatherForecastPage;
	TestUtil testUtil;
	HashMap<String, String> expectedResult = new HashMap<>();

	List<String> actualResult = new ArrayList<>();
	List<String> expectedResults = new ArrayList<>();
	String result;
	
	

	@Given("^launch the weather forecast application$")
	public void launch_the_weather_forecast_application()
			throws FileNotFoundException {
		driver = init();
		weatherForecastPage = new WeatherForecastPage(driver);
		testUtil = new TestUtil();

	}

	@And("^verify the application page header$")
	public void verify_the_application_page_header() {
		Assert.assertEquals("Five Day Weather Forecast for",
				weatherForecastPage.getPageHeader());
	}

	@When("^user enter city name as \"(.*)\"$")
	public void user_enter_city_name_as(String cityName) {
		weatherForecastPage.enterCityName(cityName);
	}

	@Then("verify the five days weather forecast is diplayed$")
	public void verify_the_five_days_weather_forecast_is_diplayed() {
		Assert.assertTrue(weatherForecastPage.isTueDispayed());
	}

	@Then("^verify the default city is \"(.*)\"$")
	public void verify_the_default_city(String defaultCity)
			throws InterruptedException {
		Assert.assertEquals(defaultCity, weatherForecastPage.getdefaultcity());
	}

	@Then("^close the browser$")
	public void Close_the_browser() {
		driver.close();
	}

	@Then("^verify the error message \"(.*)\"$")
	public void verify_the_error_message(String msg) {
		Assert.assertEquals(msg, weatherForecastPage.getErrorMsg());
	}

	// Second feature file

	@Then("^user clicks on day1$")
	public void user_clicks_on_day1() {
		weatherForecastPage.clickOnDay1();
	}

	@Then("^user clicks on next day$")
	public void user_clicks_on_next_day() {
		weatherForecastPage.clickOnNextDay();
	}

	@Then("^user will be able to see three hourly forecast$")
	public void user_will_be_able_to_see_three_hourly_forecast() {
		Assert.assertEquals(3, weatherForecastPage.getTheNoOfRecordsOfDay1());
	}

	@Then("^user will be able to see three hourly forecast for next day$")
	public void threehourelyforecastfornextday() {
		Assert.assertEquals(8, weatherForecastPage.getTheNoOfRecordsOfDay2());
	}

	@Then("^three hourly forecast should be hidden$")
	public void three_hourly_forecast_should_be_hidden() {
		Assert.assertEquals(false,
				weatherForecastPage.isday1forecastDispayed());
	}


	@Then("^verify the five days weather forecast details \"(.*)\"$")
	public void verify_the_five_days_weather_forecast_details(String path)
			throws FileNotFoundException {
		expectedResult = testUtil.readjssonValue(path);
		result = expectedResult.get("day");
		String[] days = result.split("-");
		actualResult = weatherForecastPage.getdays();
		for (int i = 0; i < days.length; i++) {
			Assert.assertEquals(days[i], actualResult.get(i));
		}
		result = expectedResult.get("date");
		String[] dates = result.split("-");
		actualResult = weatherForecastPage.getDates();
		for (int i = 0; i < dates.length; i++) {
			Assert.assertEquals(dates[i], actualResult.get(i));

		}
		result = expectedResult.get("cloudCondition");
		String[] cloudCondition = result.split("-");
		actualResult = weatherForecastPage.getcloudConditions();
		for (int i = 0; i < cloudCondition.length; i++) {
			Assert.assertEquals(cloudCondition[i], actualResult.get(i));
		}
		result = expectedResult.get("maxTemp");
		String[] maxTemp = result.split("-");
		actualResult = weatherForecastPage.getmaxTemp();
		for (int i = 0; i < maxTemp.length; i++) {
			Assert.assertTrue(actualResult.get(i).contains(maxTemp[i]));
		}
		result = expectedResult.get("minTemp");
		String[] minTemp = result.split("-");
		actualResult = weatherForecastPage.getminTemp();
		for (int i = 0; i < minTemp.length; i++) {
			Assert.assertTrue(actualResult.get(i).contains(minTemp[i]));

		}
		result = expectedResult.get("windSpeed");
		String[] windSpeed = result.split("-");
		actualResult = weatherForecastPage.getwindSpeed();
		for (int i = 0; i < windSpeed.length; i++) {
			Assert.assertEquals(windSpeed[i], actualResult.get(i));

		}
		result = expectedResult.get("rainfall");
		String[] rainfall = result.split("-");
		actualResult = weatherForecastPage.getRainfall();
		for (int i = 0; i < rainfall.length; i++) {
			Assert.assertEquals(rainfall[i], actualResult.get(i));

		}
		result = expectedResult.get("pressure");
		String[] pressure = result.split("-");
		actualResult = weatherForecastPage.getPressure();
		for (int i = 0; i < pressure.length; i++) {
			Assert.assertEquals(pressure[i], actualResult.get(i));

		}
	}


	@Then("^user verifies the current condition \"(.*)\"$")
	public void user_verifies_the_current_condition(String path)
			throws Throwable {
		expectedResult = testUtil.readjssonValue(path);
		result = expectedResult.get("cloudCondition");
		Assert.assertEquals(result, weatherForecastPage.getCurrentCondition());
		

	}

	@Then("^user verifies the current wind speed \"(.*)\"$")
	public void user_verifies_the_current_wind_speed(String path)
			throws Throwable {
		expectedResult = testUtil.readjssonValue(path);
		result = expectedResult.get("windSpeed");
		Assert.assertEquals(result, weatherForecastPage.getCurrentWindSpeed());
		
	}

	@Then("^user verifies the maximum tempreture \"(.*)\"$")
	public void user_verifies_the_maximum_tempreture(String path)
			throws Throwable {
		expectedResult = testUtil.readjssonValue(path);
		result = expectedResult.get("maxTemp");
		String maxTemp = weatherForecastPage.getThreeHrsMaxTemp();
		Assert.assertEquals(result, maxTemp);
		

	}

	@Then("^user verifies the minimum tempreture \"(.*)\"$")
	public void user_verifies_the_minimum_tempreture(String path)
			throws Throwable {
		expectedResult = testUtil.readjssonValue(path);
		result = expectedResult.get("minTemp");
		String minTemp = weatherForecastPage.getThreeHrsMinTemp();
		Assert.assertEquals(result, minTemp);
		
	}

	@Then("^user verifies the agregate rainfall \"(.*)\"$")
	public void user_verifies_the_agregate_rainfall(String path)
			throws Throwable {
		expectedResult = testUtil.readjssonValue(path);
		result = expectedResult.get("rainfall");
		int agreegateRainfall = weatherForecastPage.getagreegateRainfall();
		Assert.assertEquals(Integer.parseInt(result), agreegateRainfall);
		
	}

}
