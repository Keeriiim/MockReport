package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {
    private WeatherAPI weatherAPI;
    private WeatherService weatherService;
    private String desiredJson;


    @BeforeEach
    public void setup() { // setup runs before each test
        weatherAPI = mock(WeatherAPI.class); // Create a mock object of the WeatherAPI class
        weatherService = new WeatherService(weatherAPI); // Create a new WeatherService object with the mock object as a parameter

        this.desiredJson = "{\n" +
                "  \"coord\": {\n" +
                "    \"lon\": 11.97,\n" +
                "    \"lat\": 57.71\n" +
                "  },\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 804,\n" +
                "      \"main\": \"Clouds\",\n" +
                "      \"description\": \"overcast clouds\",\n" +
                "      \"icon\": \"04d\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"base\": \"stations\",\n" +
                "  \"main\": {\n" +
                "    \"temp\": 20.59,\n" +
                "    \"feels_like\": 20.13,\n" +
                "    \"temp_min\": 18.89,\n" +
                "    \"temp_max\": 21.74,\n" +
                "    \"pressure\": 1013,\n" +
                "    \"humidity\": 67\n" +
                "  },\n" +
                "  \"visibility\": 10000,\n" +
                "  \"wind\": {\n" +
                "    \"speed\": 5.14,\n" +
                "    \"deg\": 210,\n" +
                "    \"gust\": 7.2\n" +
                "  },\n" +
                "  \"clouds\": {\n" +
                "    \"all\": 90\n" +
                "  },\n" +
                "  \"dt\": 1599478913,\n" +
                "  \"sys\": {\n" +
                "    \"type\": 1,\n" +
                "    \"id\": 1752,\n" +
                "    \"country\": \"SE\",\n" +
                "    \"sunrise\": 1599457990,\n" +
                "    \"sunset\": 1599510755\n" +
                "  },\n" +
                "  \"timezone\": 7200,\n" +
                "  \"id\": 2711537,\n" +
                "  \"name\": \"Gothenburg\",\n" +
                "  \"cod\": 200\n" +
                "}";
    }


    @Test
    public void testWeatherServiceConstructor() {
        WeatherAPI weatherAPI = mock(WeatherAPI.class); // Create a mock object of the WeatherAPI class
        WeatherService object1 = new WeatherService(weatherAPI); // Create a new WeatherService object with the mock object as a parameter

        // Get the WeatherAPI object from WeatherService
        Object object2 = object1.getWeatherAPI();

        // Verify that the WeatherAPI object in WeatherService is the same as the mock object
        assertSame(weatherAPI, object2);
    }

    @Test
    public void testWeatherDataObject() {
        // Create a mock WeatherAPI object
        WeatherAPI weatherAPI = mock(WeatherAPI.class);

        // Create a new WeatherService object with the mock WeatherAPI object as a parameter
        WeatherService weatherService = new WeatherService(weatherAPI);
        Object object1 = weatherService.getWeatherAPI(); // Get the WeatherAPI object from the WeatherService object

        // Create a new mock WeatherAPI object
        WeatherAPI weatherAPI2 = mock(WeatherAPI.class);
        Object object2 = weatherService.setWeatherAPI(weatherAPI2); // Set the WeatherAPI object in the WeatherService object to the new mock object

        // Verify that the WeatherAPI object in WeatherService is the same as the new mock object
        assertNotSame(object1, object2);
    }


    @Test
    public void testGetWeatherDataInteraction() {
        // Sets the first call to getWeatherData()  to return "Mocked weather data"
        when(weatherAPI.getWeatherData()).thenReturn("Mocked weather data");

        // First call to getWeatherData() to return "Mocked weather data"
        weatherService.getWeatherData();

        // Verify that the interaction took place only once
        verify(weatherAPI, times(1)).getWeatherData();
    }


    @Test
    public void testGetWeatherDataFirstQuery() {
        // Configure the mock behavior
        when(weatherAPI.getWeatherData()).thenReturn("Mocked weather data");

        // Invoke the method being tested
        String result = weatherService.getWeatherData();

        // Verify the interactions and assertions
        assertEquals("Mocked weather data", result);

        // Store the first result, so we can compare it to the mock object. Expectation = outcome
    }


    @Test
    public void testGetWeatherDataSecondQuery() {
        // Configure the mock behavior
        when(weatherAPI.getWeatherData()).thenReturn("Mocked weather data").thenReturn("Another mocked weather data");

        // Invoke the method being tested
        String result = weatherService.getWeatherData();

        // Verify the interactions and assertions
        assertEquals("Mocked weather data", result);
        assertEquals("Another mocked weather data", weatherService.getWeatherData());
    }

    @Test
    public void testGetWeatherData() {
        // Prepare the desired JSON data
        String desiredJsonTest = "{\n" +
                "  \"coord\": {\n" +
                "    \"lon\": 11.97,\n" +
                "    \"lat\": 57.71\n" +
                "  },\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 804,\n" +
                "      \"main\": \"Clouds\",\n" +
                "      \"description\": \"overcast clouds\",\n" +
                "      \"icon\": \"04d\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"base\": \"stations\",\n" +
                "  \"main\": {\n" +
                "    \"temp\": 20.59,\n" +
                "    \"feels_like\": 20.13,\n" +
                "    \"temp_min\": 18.89,\n" +
                "    \"temp_max\": 21.74,\n" +
                "    \"pressure\": 1013,\n" +
                "    \"humidity\": 67\n" +
                "  },\n" +
                "  \"visibility\": 10000,\n" +
                "  \"wind\": {\n" +
                "    \"speed\": 5.14,\n" +
                "    \"deg\": 210,\n" +
                "    \"gust\": 7.2\n" +
                "  },\n" +
                "  \"clouds\": {\n" +
                "    \"all\": 90\n" +
                "  },\n" +
                "  \"dt\": 1599478913,\n" +
                "  \"sys\": {\n" +
                "    \"type\": 1,\n" +
                "    \"id\": 1752,\n" +
                "    \"country\": \"SE\",\n" +
                "    \"sunrise\": 1599457990,\n" +
                "    \"sunset\": 1599510755\n" +
                "  },\n" +
                "  \"timezone\": 7200,\n" +
                "  \"id\": 2711537,\n" +
                "  \"name\": \"Gothenburg\",\n" +
                "  \"cod\": 200\n" +
                "}";

        // Configure the mock behavior
        when(weatherAPI.getWeatherData()).thenReturn(desiredJsonTest);

        // Invoke the method being tested
        String result = weatherService.getWeatherData();

        // Verify the interactions and assertions
        assertEquals(desiredJsonTest, result);

        // Made a String of the json code via chat gpt to test against the real code that should come from the APIn API:et
        // Expectation = outcome
    }


    @Test
    public void testParseWeatherDataWithNull() {
        // Setup from BeforeEach

        // Configure the mock behavior
        when(weatherAPI.getWeatherData()).thenReturn(null); // Sets the first call to getWeatherData()  to return the Json from setup

        // Assert & act
        assertThrows(NullPointerException.class, () -> weatherService.parseWeatherData(null));
    }

    @Test
    public void testParseWeatherDataWithEmptyJson() {
        // Configure the mock behavior
        String desiredJsonTest = "";
        when(weatherAPI.getWeatherData()).thenReturn(desiredJsonTest); // Sets the first call to getWeatherData()  to return the Json from setup

        // Assert & act
        assertThrows(Exception.class, () -> weatherService.parseWeatherData(desiredJsonTest));
    }

    @Test
    public void testParseWeatherDataWithMissingData() {
        // Configure the mock behavior
        String desiredJsonTest = "{\n" +
                "  \"coord\": {\n" +
                "    \"lon\": 11.97,\n" +
                "    \"lat\": 57.71\n" +
                "  },\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 804,\n" +
                "      \"main\": \"Clouds\",\n" +
                "      \"description\": \"overcast clouds\",\n" +
                "      \"icon\": \"04d\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"base\": \"stations\",\n" +
                "  \"main\": {\n" +
                "    \"temp\": -20,\n" +
                "    \"feels_like\": 20.13,\n" +
                "    \"temp_min\": 18.89,\n" +
                "    \"temp_max\": 21.74,\n" +
                "    \"pressure\": 1013,\n" +
                "    \"humidity\": 67\n" +
                "  },\n" +
                "  \"visibility\": 10000,\n" +
                "  \"wind\": {\n" +
                "    \"speed\": 5.14,\n" +
                "    \"deg\": 210,\n" +
                "    \"gust\": 7.2\n" +
                "  },\n" +
                "  \"clouds\": {\n" +
                "    \"all\": 90.2\n" +
                "  },\n" +
                "  \"dt\": 1599478913,\n" +
                "  \"sys\": {\n" +
                "    \"type\": 1,\n" +
                "    \"id\": 1752,\n" +
                "    \"country\": \"SE\",\n" +
                "    \"sunrise\": 1599457990,\n" +
                "    \"sunset\": 1599510755\n" +
                "  },\n" +
                "  \"timezone\": 7200,\n" +
                "  \"id\": 2711537,\n" +
                "  \"name\": \"\",\n" +
                "  \"cod\": 200\n" +
                "}";
        when(weatherAPI.getWeatherData()).thenReturn(desiredJsonTest); // Sets the first call to getWeatherData()  to return the Json from setup

        // Assert & act
        assertDoesNotThrow(() -> weatherService.parseWeatherData(desiredJsonTest));
    }

    @Test
    public void testParseWeatherDataWithFullData() {
        // Configure the mock behavior
        when(weatherAPI.getWeatherData()).thenReturn(desiredJson); // Sets the first call to getWeatherData()  to return the Json from setup
        String city = "Gothenburg"; // Sets a test value of the city to Gothenburg
        Double temp = 20.59; // Sets a test value of the temperature to 20.59
        int clouds = 90; // Sets a test value of the clouds to 90.0
        Double wind = 5.14; // Sets a test value of the wind to 5.14

        // Assert
        weatherService.parseWeatherData(desiredJson); // parses the json code
        String result1 = weatherService.getCity(); // Get's the stored city from the json code
        Double result2 = weatherService.getTemperature(); // Get's the stored city from the json code
        int result3 = weatherService.getCloudiness(); // Get's the stored city from the json code
        Double result4 = weatherService.getWindSpeed(); // Get's the stored city from the json code

        // Verifies that the stored city is the same as the test value
        assertEquals(city, result1);
        // Verifies that the stored temperature is the same as the test value
        assertEquals(temp, result2);
        // Verifies that the stored cloudiness is the same as the test value
        assertEquals(clouds, result3);
        // Verifies that the stored windspeed is the same as the test value
        assertEquals(wind, result4);
    }

    @Test
    public void testGetCity() {
        // Setup from beforeEach

        // Set the city using the setter
        String city = "New York";
        weatherService.setCity(city);

        // Retrieve the city using the getter
        String retrievedCity = weatherService.getCity();

        // Assert that the retrieved city matches the expected city
        assertEquals(city, retrievedCity);
    }

    @Test
    public void testGetTemperature() {
        // Setup from beforeEach

        // Set the temperature using the setter
        double temperature = 25.5;
        weatherService.setTemperature(temperature);

        // Retrieve the temperature using the getter
        double retrievedTemperature = weatherService.getTemperature();

        // Assert that the retrieved temperature matches the expected temperature
        assertEquals(temperature, retrievedTemperature, 0.001);
    }

    @Test
    public void testGetNegativeTemperature() {
        // Setup from beforeEach

        // Set the temperature using the setter
        double temp1 = -25.5;
        weatherService.setTemperature(temp1);

        // Retrieve the temperature using the getter
        double retrievedTemperature = weatherService.getTemperature();

        // Assert that the retrieved temperature matches the expected temperature
        assertEquals(temp1, retrievedTemperature, 0.001);
    }

    @Test
    public void testGetWindSpeed() {
        // Setup from beforeEach

        // Set the wind speed using the setter
        double windSpeed = 10.3;
        weatherService.setWindSpeed(windSpeed);

        // Retrieve the wind speed using the getter
        double retrievedWindSpeed = weatherService.getWindSpeed();

        // Assert that the retrieved wind speed matches the expected wind speed
        assertEquals(windSpeed, retrievedWindSpeed, 0.001);
    }

    @Test
    public void testGetCloudiness() {
        // Setup from beforeEach

        // Set the cloudiness using the setter
        int cloudiness = 70;
        weatherService.setCloudiness(cloudiness);

        // Retrieve the cloudiness using the getter
        int retrievedCloudiness = weatherService.getCloudiness();

        // Assert that the retrieved cloudiness matches the expected cloudiness
        assertEquals(cloudiness, retrievedCloudiness);
    }


    @Test
    public void printJson() {
        when(weatherAPI.getWeatherData()).thenReturn(desiredJson);
        weatherService.parseWeatherData(desiredJson);
        weatherService.printWeatherData();
    }
}