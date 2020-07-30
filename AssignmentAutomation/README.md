# acceptance-testing-selenium
A simple project which deals with testing of weather forecast using Selenium BDD

This application covers testing of following features 
### Features
* Enter city name, get 5 day weather forecast
* Select day, get 3 hourly forecast
* Select day again, hide 3 hourly forecast
* Daily forecast should summarise the 3 hour data:
  * Most dominant (or current) condition
  * Most dominant (or current) wind speed and direction
  * Aggregate rainfall
  * Minimum and maximum temperatures


### Techincal Overview

This Automation Suite built using Cucumber Java, Selenium and Maven.

Feature files are created using Gherkin Syntax and step definitions written in Java and Assertions with jUnit.
 
Feature files are located under src/main/resources/Features.

Step Definitions are located under src/test/java/stepDefenition.

TestRunner is the entry point for these tests and defining the report format and tags to run the scenarios of feature files.

All the supporting class's & files, TestBase, Util, Page classes and config properties are located under src/main/java

### Pre-requisites

* Java is already installed on the client machine.
* Maven
* Chrome Browser is already installed.
* All the dependencies should be added in pom.xml


### Running Tests 
* Run the Weather Application 
* Open IDE , Run SeleniumCucumber.java
* Run TestRunner class by right clik ans selecting junit.

### Verify the Report
* After running the feature files do refresh the project
* Go to Output Folder and Open the index.html

Note: chrome driver exe kept uner src\main\resources\libs.