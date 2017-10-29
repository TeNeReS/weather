package arkhipov.weather.services;

import arkhipov.weather.models.Location;

public interface WeatherService {
    Location getWeatherByCoordinates(String lon, String lat);
    Location getWeatherByName(String name);
}
