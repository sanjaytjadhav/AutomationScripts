Feature: Verify 5 days weather forecast for a given valid and invalid location. 

@Pass
Scenario Outline: A user sees five day weather forecast for the valid city 

	Given launch the weather forecast application 
	When user enter city name as "<City>" 
	Then verify the five days weather forecast details 
		|Tue|Wed|Thu|Fri|Sat|
	Then close the browser 
	Examples: 
		|City|
		|aberdeen|
		|dundee|
		|edinburgh|
		|glasgow|
		|perth|
		|stirling|
		
	@Pass	
   Scenario: A user sees five day weather forecast for the invalid city 
		
	    Given launch the weather forecast application 
		When user enter city name as "Bangalore" 
		Then verify the error message "Error retrieving the forecast" 
		Then close the browser 