# TDD & Mock assignment

## Description
This project is based on the assignment i have been given durning my education which is to create a series of tests for WeatherService using JUnit and mock object and write a report on the results.
The purpose is to learn how to use JUnit and mock objects to test the WeatherService class and to write a detailed report on the results. I learned alot from this task and i am happy with the results.
This project has been in collaboration with ChatGPT. 


## Table of Contents
- [Installation](#installation)
- [Dependencies](#Dependencies)
- [Usage](#usage)
- [License](#license)
- [Contribute](#contribute)
- [Report](#report)

## Installation
The project is built with Maven and the dependencies are listed in the pom.xml file.
Your IDE might ask for the SDK setup, if so then you should choose the latest working version.
This project was coded with java version 19.0.1.

## Dependencies
These dependencies are found in the pom.xml file:
- org.junit.jupiter:junit-jupiter:5.9.3
- org.junit:junit:RELEASE
- org.mockito:mockito-core:5.3.1
- org.json:json:20230227

## Usage
The main purpose for this project is to test the WeatherService class. The WeatherService class is a class that uses the OpenWeatherMap API to get weather information for a city. The WeatherService class has a method called getWeather which takes a city as a parameter and returns a Weather object. The Weather object contains information about the weather in the city.
The WeatherService class also has a method called getWeatherForcast which takes a city as a parameter and returns a WeatherForcast object.
All the methods in the WeatherService class are tested in the WeatherServiceTest class. Enter the test class and run the tests to see the results.

## License
Copyright (c) 2023 Kerim Kozo  
[MIT License](https://choosealicense.com/licenses/mit/).

## Contribute
Feel free to pull and expand on this project.

---

## Report

| Test ID | Test description                                                                           | Expected result                     | Real result                        | Status | Comments                                                                 |
| ------- |--------------------------------------------------------------------------------------------|-------------------------------------|------------------------------------|--------|--------------------------------------------------------------------------|
| 1       | Checks that the constructor correctly assigned the<br/> WeatherAPI object to the WeatherService | Will return the same object reference | Returned the same object reference | Passed | No problems identified                                                   |
| 2       | Checks that the method getWeatherData returns the stored weatherAPI object                 | Stored a different object           | Stored a different object          | Passed | No problems identified                                                   |
| 3       | Verifies that the method call for getWeatherData was called only once                      | Call will happen only once          | Call will happen only once         | Passed | Can be good practice/test for loops                                      |
| 4       | Checks that the method getWeatherData returns the String stored in the weatherAPI object   | Will return the stored String       | Returned the stored String         | Passed | No problems identified                                                   |
| 5       | Checks that the method getWeatherData is updated if the stored data should change, for example by a second API call | The data will change                | Returned different data            | Passed | No problems identified                                                   |
| 6       | Checks that getWeatherData can handle a real Json string                                   | Will return the same Json string    | Returned the same String           | Passed | No problems identified                                                   |
| 7       | Checks that the NullpointerException will get caught                                       | Will return an error message        | Returned an error message          | Passed | No problems identified                                                   |
| 8       | Checks that the Exception will get caught with an empty JSON                               | Will return an error message        | Returned an error message          | Passed | No problems identified                                                   |
| 9       | Checks that the JSONException will get caught with an invalid JSON                         | Will return an error message        | Returned an error message          | Passed | No problems identified                                                   |
| 10      | Checks that the parseWeatherData method will not cause an exception if data is missing     | Will NOT return an error message    | Did not return an error message    | Passed | No problems identified                                                   |
| 11      | Checks that the parseWeatherData method works with full data                               | Will return weatherData             | Returned weatherData               | Passed | Works with special letters ex åäö                                        |
| 12      | Checks that the method getCity works                                                       | Will return the setCityName         | Returned the correct cityName      | Passed | No problems identified                                                   |
| 13      | Checks that the method getTemperature works                                                | Will return the setTemperature      | Returned the correct Temperature   | Passed | Works with negative numbers aswell                                       |
| 14      | Checks that the method getWindSpeed works                                                  | Will return the setWindSpeed        | Returned the correct WindSpeed     | Passed | No problems identified                                                   |
| 15      | Checks that the method getCloudiness works                                                 | Will return the setCloudiness       | Returned the correct Cloudiness    | Passed | If the json returns a double, the decimals will not be taken into account |
| 16      | *NOT A TEST* - The last "@Test" will print the stored values from the BeforeEach setup.    |                                     | Prints values from beforeEach      | Works  | Just a quick reference to see what is being stored in the Setup          |
