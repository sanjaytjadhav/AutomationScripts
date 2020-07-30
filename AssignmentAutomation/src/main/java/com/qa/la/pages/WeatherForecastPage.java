package com.qa.la.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherForecastPage {
	WebDriver driver;

	// Page Factory or OR

	@FindBy(name = "city")
	WebElement city;
	@FindBy(xpath = "//span[@class='name']")
	List<WebElement> days;
	@FindBy(xpath="//div[@data-test='error']")
	WebElement errorMsg;
	@FindBy(xpath="//span[@data-test='day-1']")
	WebElement day1;
	@FindBy(xpath="//span[@data-test='day-2']")
	WebElement day2;
	@FindBy(xpath="//div[@id='root']/div/div[1]/div[@class='details']/div/span/span[@class='hour']")
	List<WebElement> reordsOfDay1;
	@FindBy(xpath="//div[@id='root']/div/div[2]/div[@class='details']/div/span/span[@class='hour']")
	List<WebElement> recordsOfDay2;
	@FindBy(xpath="//div[@id='root']/div/div[1]/div[@class='details']/div/span/span[@data-test='hour-1-1']")
	WebElement firstHrOfday1;
	
	@FindBy(xpath="//div[@id='root']/div/div[1]/div[@class='details']/div[1]/span")
	List<WebElement> recordsOfDay1row1;
	@FindBy(xpath="//div[@id='root']/div/div[1]/div[@class='details']/div[2]/span")
	List<WebElement> recordsOfDay1row2;
	@FindBy(xpath="//div[@id='root']/div/div[1]/div[@class='details']/div[3]/span")
	List<WebElement> recordsOfDay1row3;
	
	
	// Initializing the page objects
	public WeatherForecastPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void enterCityName(String cityName) {
		city.clear();
		city.sendKeys(cityName, Keys.ENTER);
	}

	public int getNoOfDays() {
		return days.size();
	}

	public HashMap<String, String> getdays() {
		HashMap<String, String> hm = new HashMap<>();
		for (WebElement element : days) {
			String value = element.getText();
			hm.put(value, value);
		}
		return hm;

	}
	
	public String getErrorMsg(){
		return errorMsg.getText();
	}
	
	public void clickOnDay1(){
		day1.click();
		
	}
	public void clickOnNextDay(){
		day2.click();
	}
	public int getTheNoOfRecordsOfDay1(){
		return reordsOfDay1.size();
	}
	public int getTheNoOfRecordsOfDay2(){
		return recordsOfDay2.size();
	}
	public boolean isElementDispayed(){
		return firstHrOfday1.isDisplayed();
	}
	
	public List<String> allRecordsofRow1= new ArrayList<String>();
	public List<String> allRecordsofRow2= new ArrayList<String>();
	public List<String> allRecordsofRow3= new ArrayList<String>();
	
	public void getAllTheRow1Data(){
		
			for (int i = 0; i < recordsOfDay1row1.size(); i++) {
				if(i==1){
					allRecordsofRow1.add(recordsOfDay1row1.get(i).findElement(By.cssSelector("svg[aria-label]")).getAttribute("aria-label"));
				}else
					allRecordsofRow1.add(recordsOfDay1row1.get(i).getText());
		    }
			for (int i = 0; i < recordsOfDay1row2.size(); i++) {
				if(i==1){
					allRecordsofRow2.add(recordsOfDay1row2.get(i).findElement(By.cssSelector("svg[aria-label]")).getAttribute("aria-label"));
				}else
					allRecordsofRow2.add(recordsOfDay1row2.get(i).getText());
		    }
			for (int i = 0; i < recordsOfDay1row3.size(); i++) {
				if(i==1){
					allRecordsofRow3.add(recordsOfDay1row3.get(i).findElement(By.cssSelector("svg[aria-label]")).getAttribute("aria-label"));
				}else
					allRecordsofRow3.add(recordsOfDay1row3.get(i).getText());
		    }
		
		
	}
	
}
