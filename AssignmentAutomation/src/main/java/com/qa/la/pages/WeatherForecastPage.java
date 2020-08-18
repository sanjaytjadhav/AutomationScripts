package com.qa.la.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherForecastPage {
	WebDriver driver;
	List<String> actualResult = new ArrayList<String>();
	HashMap<String, String> actualResulthm = new HashMap<>();

	// Initializing the page objects
	public WeatherForecastPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Page Factory or OR

	@FindBy(name = "city")
	WebElement city;
	@FindBy(xpath = "//span[@class='name']")
	List<WebElement> days;
	@FindBy(xpath = "//div[@data-test='error']")
	WebElement errorMsg;
	@FindBy(xpath = "//div[@id='root']/div/h1")
	WebElement pageHeader;

	@FindBy(xpath = "//span[contains(@class,'date')]")
	List<WebElement> fivedates;

	@FindBy(xpath = "//div[@class='summary']//*[@class='cell']//*[@class='icon']")
	List<WebElement> fivecloudcondition;
	@FindBy(xpath = "//div[@class='summary']//*[@class='cell']//span[@class='max']")
	List<WebElement> fivemaxTemp;

	@FindBy(xpath = "//div[@class='summary']//*[@class='cell']//span[@class='rmq-5ea3c959 min']")
	List<WebElement> fiveminTemp;
	@FindBy(xpath = "//div[@class='summary']//*[@class='cell']//span[@class='speed']")
	List<WebElement> fivedaysWindSpeed;
	@FindBy(xpath = "//div[@class='summary']//*[@class='cell']//span[@class='rainfall']")
	List<WebElement> fivedaysRainFall;

	@FindBy(xpath = "//div[@class='summary']//*[@class='cell']//span[@class='rmq-5ea3c959 pressure']")
	List<WebElement> fivedaysPresure;

	@FindBy(xpath = "//span[@data-test='day-1']")
	WebElement day1;
	@FindBy(xpath = "//span[@data-test='day-2']")
	WebElement day2;
	@FindBy(xpath = "//div[@id='root']/div/div[1]/div[@class='details']/div/span/span[@class='hour']")
	List<WebElement> reordsOfDay1;
	@FindBy(xpath = "//div[@id='root']/div/div[2]/div[@class='details']/div/span/span[@class='hour']")
	List<WebElement> recordsOfDay2;
	@FindBy(xpath = "//div[@id='root']/div/div[1]/div[@class='details']/div/span/span[@data-test='hour-1-1']")
	WebElement firstHrOfday1;
	
			@FindBy(xpath = "(//div[@class='details'])[1]")
			WebElement day1forecast;

	@FindBy(xpath = "//div[@id='root']/div/div[1]/div[@class='details']/div[1]/span")
	List<WebElement> recordsOfDay1row1;
	@FindBy(xpath = "//div[@id='root']/div/div[1]/div[@class='details']/div[2]/span")
	List<WebElement> recordsOfDay1row2;
	@FindBy(xpath = "//div[@id='root']/div/div[1]/div[@class='details']/div[3]/span")
	List<WebElement> recordsOfDay1row3;

	@FindBy(xpath = "//*[@id='root']/div/div[1]/div[2]/div[1]/span[2]/*[@class='icon']")
	WebElement currentConditionTue;

	@FindBy(xpath = "//*[@id='root']/div/div[1]/div[2]/div[1]/span[4]/span[1]")
	WebElement currentWindSpeedTue;

	@FindBy(xpath = "(//*[@class='details'])[1]/div[@class='detail']//*[@class='rmq-5ea3c959 min']")
	List<WebElement> dailyThreeHrsMinTemp;
	@FindBy(xpath = "(//*[@class='details'])[1]/div[@class='detail']//*[@class='max']")
	List<WebElement> dailyThreeHrsMaxTemp;

	@FindBy(xpath = "(//*[@class='details'])[1]/div[@class='detail']//*[@class='rainfall']")
	List<WebElement> dailyThreeRainfall;

	// Actions

	public void enterCityName(String cityName) {
		city.clear();
		city.sendKeys(cityName, Keys.ENTER);

	}

	public int getNoOfDays() {
		return days.size();
	}

	public List<String> getdays() {
		for (WebElement element : days) {
			actualResult.add(element.getText());

		}
		return actualResult;

	}

	public List<String> getDates() {
		List<String> actualResult = new ArrayList<>();

		for (WebElement element : fivedates) {
			actualResult.add(element.getText());

		}

		return actualResult;

	}

	public ArrayList<String> getcloudConditions() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : fivecloudcondition) {
			String value = element.getAttribute("aria-label");
			list.add(value);
		}
		return list;

	}

	public ArrayList<String> getmaxTemp() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : fivemaxTemp) {
			String value = element.getText();
			list.add(value);
		}
		return list;

	}

	public ArrayList<String> getminTemp() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : fiveminTemp) {
			String value = element.getText();
			list.add(value);
		}
		return list;

	}

	public ArrayList<String> getwindSpeed() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : fivedaysWindSpeed) {
			String value = element.getText();
			list.add(value);
		}
		return list;

	}

	public ArrayList<String> getRainfall() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : fivedaysRainFall) {
			String value = element.getText();
			list.add(value);
		}
		return list;

	}

	public ArrayList<String> getPressure() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : fivedaysPresure) {
			String value = element.getText();
			list.add(value);
		}
		return list;

	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}

	public String getdefaultcity() {
		return city.getAttribute("value");
	}

	public void clickOnDay1() {
		day1.click();

	}

	public void clickOnNextDay() {
		day2.click();
	}

	public int getTheNoOfRecordsOfDay1() {
		return reordsOfDay1.size();
	}

	public int getTheNoOfRecordsOfDay2() {
		return recordsOfDay2.size();
	}

	public boolean isday1forecastDispayed() {
		return day1forecast.isDisplayed();
	}

	public boolean isTueDispayed() {
		return day1.isDisplayed();
	}

	public String getPageHeader() {
		return pageHeader.getText();
	}

	public String getCurrentCondition() {
		return currentConditionTue.getAttribute("aria-label");
	}

	public String getCurrentWindSpeed() {
		return currentWindSpeedTue.getText();
	}

	public String getThreeHrsMaxTemp() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : dailyThreeHrsMaxTemp) {
			String value = element.getText();
			// value=value.substring(0,2);
			value = value.replaceAll("°", "");
			list.add(value);
		}
		Collections.sort(list, Collections.reverseOrder());

		return list.get(0);

	}

	public String getThreeHrsMinTemp() {
		ArrayList<String> list = new ArrayList<>();

		for (WebElement element : dailyThreeHrsMinTemp) {
			String value = element.getText();
			value = value.replaceAll("°", "");
			list.add(value);
		}
		Collections.sort(list);

		return list.get(0);

	}

	public int getagreegateRainfall() {

		int rainfallValue = 0;

		for (WebElement element : dailyThreeRainfall) {

			String value = element.getText();
			value = value.replace("mm", "");
			int values = Integer.parseInt(value);
			rainfallValue = rainfallValue + values;

		}

		return rainfallValue;
	}

}
