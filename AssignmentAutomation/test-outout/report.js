$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("weatherForecase_5days.feature");
formatter.feature({
  "line": 1,
  "name": "Verify 5 days weather forecast for a given valid and invalid locations.",
  "description": "",
  "id": "verify-5-days-weather-forecast-for-a-given-valid-and-invalid-locations.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "A user sees five day weather forecast for the valid city",
  "description": "",
  "id": "verify-5-days-weather-forecast-for-a-given-valid-and-invalid-locations.;a-user-sees-five-day-weather-forecast-for-the-valid-city",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "launch the weather forecast application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify the application page header",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user enter city name as \"\u003cCity\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "verify the five days weather forecast details \"\u003cpath\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "verify-5-days-weather-forecast-for-a-given-valid-and-invalid-locations.;a-user-sees-five-day-weather-forecast-for-the-valid-city;",
  "rows": [
    {
      "cells": [
        "City",
        "path"
      ],
      "line": 11,
      "id": "verify-5-days-weather-forecast-for-a-given-valid-and-invalid-locations.;a-user-sees-five-day-weather-forecast-for-the-valid-city;;1"
    },
    {
      "cells": [
        "glasgow",
        "expectedWeatherDetailsGlasgow.json"
      ],
      "line": 12,
      "id": "verify-5-days-weather-forecast-for-a-given-valid-and-invalid-locations.;a-user-sees-five-day-weather-forecast-for-the-valid-city;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "A user sees five day weather forecast for the valid city",
  "description": "",
  "id": "verify-5-days-weather-forecast-for-a-given-valid-and-invalid-locations.;a-user-sees-five-day-weather-forecast-for-the-valid-city;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "launch the weather forecast application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify the application page header",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user enter city name as \"glasgow\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "verify the five days weather forecast details \"expectedWeatherDetailsGlasgow.json\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "WeatherForecasetStepDefination.launch_the_weather_forecast_application()"
});
