package arkhipov.weather.models;

public class Location {
    private String name;
    private String longitude;
    private String latitude;
    private Weather weather;

    public Location(String name, String longitude, String latitude, Weather weather) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public Weather getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "Location {name = " + name +
                ", longitude = " + longitude +
                ", latitude = " + latitude +
                ", weather = " + weather +
                "}";
    }
}
