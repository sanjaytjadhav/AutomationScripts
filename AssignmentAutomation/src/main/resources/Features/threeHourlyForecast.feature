Feature: Select day, get 3 hourly forecast details 

@pass
Scenario: user should be able to see three hourly forecast for a given day 
	Given launch the weather forecast application 
	When user enter city name as "perth" 
	Then user clicks on day1 
	Then user will be able to see three hourly forecast 
	Then close the browser 
	
@Pass
Scenario: user should be able to see three hourly forecast for a next day 
	Given launch the weather forecast application 
	When user enter city name as "perth" 
	Then user clicks on next day 
	Then user will be able to see three hourly forecast for next day 
	Then close the browser 
	
@Pass
Scenario: user should be able to hide the three hourly forecast 
	Given launch the weather forecast application 
	When user enter city name as "perth" 
	Then user clicks on day1 
	Then user will be able to see three hourly forecast 
	Then user clicks on day1 
	Then three hourly forecast should be hidden 
	Then close the browser