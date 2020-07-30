Feature: Daily forecast should summarise the 3 hour data
@Pass
  Scenario: Summarise three hour data of selected day
    Given launch the weather forecast application 
	When user enter city name as "stirling" 
	Then user clicks on day1 
    Then summary of all the three hourly data should be displayed like below
      |Hour  | DominantCondition|Max_Temp|Min_Temp|Wind_Speed|Rainfall|Pressure|
      | 1730 | Rain             | 12     | 11     | 1kph     | 1mm    | 992mb |
      | 2030 | Rain             | 12     | 11     | 1kph     | 1mm    | 992mb |
      | 2330 | Clouds           | 11     | 10     | 1kph     | 0mm    | 991mb |
    Then close the browser
     