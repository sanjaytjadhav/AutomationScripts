Feature: Verify 5 days weather forecast for a given valid and invalid locations. 

@smoke
Scenario Outline: A user sees five day weather forecast for the valid city 
	Given launch the weather forecast application
	And verify the application page header 
	When user enter city name as "<City>" 
	Then verify the five days weather forecast details "<path>"
	Then close the browser 
	Examples: 
		|City   |path                              |
		|glasgow|expectedWeatherDetailsGlasgow.json|
#		|dundee|                                   |
			
	@smoke
    Scenario: A user sees five day weather forecast for the invalid city 
	    Given launch the weather forecast application 
	    And verify the application page header
		When user enter city name as "Bangalore" 
		Then verify the error message "Error retrieving the forecast" 
		Then close the browser 
		
	@smoke	
	Scenario: A user verified the default city for the weatherforast 
	    Given launch the weather forecast application 
		And verify the application page header
		Then verify the default city is "Glasgow"
		Then close the browser 
		
	@smoke
    Scenario: A user sees five day weather forecast for the blank city
	    Given launch the weather forecast application 
		And verify the application page header
		When user enter city name as " " 
		Then verify the error message "Error retrieving the forecast" 
		Then close the browser
		
	@smoke	
	Scenario Outline: A user verified city name is case insensitive for weather forecast
	    Given launch the weather forecast application 
	    And verify the application page header 
	    When user enter city name as "<City>" 
		Then verify the five days weather forecast is diplayed 
	    Then close the browser
	    Examples: 
		|City|
		|GLASGOW|
		|glasgow|
		|gLaSgoW|
		
		