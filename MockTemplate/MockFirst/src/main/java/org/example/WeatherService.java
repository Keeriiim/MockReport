package org.example;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherService {
    private WeatherAPI weatherAPI;
    private String city;
    private double temperature;
    private double windSpeed;
    private int cloudiness;
        public WeatherService(WeatherAPI weatherAPI) { // Constructor

            this.weatherAPI = weatherAPI;
        }

    public Object setWeatherAPI(WeatherAPI weatherAPI) { // Sets the weatherAPI object
        this.weatherAPI = weatherAPI;
        return weatherAPI;
    }
    public Object getWeatherAPI() { // Gets the weatherAPI object
        return weatherAPI;
    }

    public String getWeatherData() { // Gets the weather data in string format from the weatherAPI object
        String weatherData = weatherAPI.getWeatherData();
        return weatherData;
    }


    public void parseWeatherData(String weatherData) {// Parse the weatherData JSON and extract the necessary values

            try {
                JSONObject json = new JSONObject(weatherData); // Create a JSON object from the weatherData string

                String cityName = json.getString("name"); // Extract the city name from the JSON

                // Extract the temperature from the "main" object in the JSON
                JSONObject mainObject = json.getJSONObject("main");
                double temp = mainObject.getDouble("temp");

                // Extract the wind speed from the "wind" object in the JSON
                JSONObject windObject = json.getJSONObject("wind");
                double windS = windObject.getDouble("speed");

                // Extract the cloudiness from the "clouds" object in the JSON
                JSONObject cloudsObject = json.getJSONObject("clouds");
                int cloudS = cloudsObject.getInt("all");


                // Set the city name in the WeatherService object
                setCity(cityName);

                // Set the temperature in the WeatherService object
                setTemperature(temp);

                // Set the wind speed in the WeatherService object
                setWindSpeed(windS);

                // Set the cloudiness in the WeatherService object
                setCloudiness(cloudS);


            } catch (Exception e) {
                if (e instanceof NullPointerException){
                    System.out.println("JSON is Null" + e.getMessage());
                    throw new NullPointerException("JSON is Null: " + e.getMessage());
                }
                else if (e instanceof JSONException){
                    System.out.println("Error parsing JSON data: " + e.getMessage());
                    throw new JSONException("Error parsing JSON data: " + e.getMessage());
                }
            }
    }


    // Setter & Getter methods for the attributes
    public void setCity(String city){
            this.city = city;
    }
    public String getCity() {
        return city;
    }
    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public void setCloudiness(int cloudiness){
        this.cloudiness = cloudiness;
    }
    public int getCloudiness() {
        return cloudiness;
    }

    public void printWeatherData() { // Prints the weather data
        System.out.println("City: " + getCity());
        System.out.println("Temperature: " + getTemperature());
        System.out.println("Wind speed: " + getWindSpeed());
        System.out.println("Cloudiness: " + getCloudiness());
    }
}