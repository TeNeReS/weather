package arkhipov.weather.models;

public class Weather {
    private String temperature;
    private String wind;
    private String pressure;
    private String humidity;

    public Weather(String temperature, String wind, String pressure, String humidity) {
        this.temperature = temperature;
        this.wind = wind;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWind() {
        return wind;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "Weather {temperature = " + temperature +
                ", wind = " + wind +
                ", pressure = " + pressure +
                ", humidity = " + humidity +
                "}";
    }
}
