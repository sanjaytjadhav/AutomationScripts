Feature: Daily forecast should summarise the 3 hour data
@Reg
  Scenario: Summarise three hour data and get current condition
    Given launch the weather forecast application 
	And verify the application page header
	When user enter city name as "glasgow" 
	Then user clicks on day1 
    Then user verifies the current condition "glasgowTueThreeHrsData.json"
    Then close the browser

     @Reg
    Scenario: Summarise three hour data and get current wind speed
    Given launch the weather forecast application 
	And verify the application page header
	When user enter city name as "glasgow" 
	Then user clicks on day1 
    Then user verifies the current wind speed "glasgowTueThreeHrsData.json"
    Then close the browser
    
    @Reg
    Scenario: Summarise three hour data and get maximum tempreture
    Given launch the weather forecast application  
	And verify the application page header
	When user enter city name as "glasgow" 
	Then user clicks on day1 
    Then user verifies the maximum tempreture "glasgowTueThreeHrsData.json"
    Then close the browser
    
    @Reg
    Scenario: Summarise three hour data and get minimum tempreture
    Given launch the weather forecast application 
	And verify the application page header
	When user enter city name as "glasgow" 
	Then user clicks on day1 
    Then user verifies the minimum tempreture "glasgowTueThreeHrsData.json"
    Then close the browser
    
    @Reg
    Scenario: Summarise three hour data and get agregate rainfall
    Given launch the weather forecast application 
	And verify the application page header
	When user enter city name as "glasgow" 
	Then user clicks on day1 
    Then user verifies the agregate rainfall "glasgowTueThreeHrsData.json"
    Then close the browser
    
    
    