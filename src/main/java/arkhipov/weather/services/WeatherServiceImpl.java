package arkhipov.weather.services;

import arkhipov.weather.exceptions.BadRequestException;
import arkhipov.weather.exceptions.NotFoundException;
import arkhipov.weather.models.Location;
import arkhipov.weather.models.Weather;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final String APPID = "be95a3f1a8dc196675f8f7c3cdffb1a8";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private OpenWeatherMapAPI api = retrofit.create(OpenWeatherMapAPI.class);

    @Override
    public Location getWeatherByCoordinates(String lon, String lat) {
        Response response = null;
        try {
            response = api.getWeatherByCoordinates(lon, lat, APPID).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseToLocation(response);
    }

    @Override
    public Location getWeatherByName(String name) {
        Response response = null;
        try {
            response = api.getWeatherByName(name, APPID).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseToLocation(response);
    }

    private Location responseToLocation (Response response) {
        if (response.code() == 200) {
            JsonObject body = (JsonObject) response.body();
            JsonObject coord = body.getAsJsonObject("coord");
            String lon = coord.get("lon").toString();
            String lat = coord.get("lat").toString();
            JsonObject main = body.getAsJsonObject("main");
            String temperature = main.get("temp").toString();
            String pressure = main.get("pressure").toString();
            String humidity = main.get("humidity").toString();
            String wind = body.getAsJsonObject("wind").get("speed").toString();
            JsonElement countryElement = body.getAsJsonObject("sys").get("country");
            String country = countryElement != null ? trimQuotes(countryElement.toString()) : null;
            JsonElement nameElement = body.get("name");
            String name = nameElement != null ? trimQuotes(nameElement.toString()) : null;
            Weather weather = new Weather(temperature, wind, pressure, humidity);
            return new Location(name, country, lon, lat, weather);
        }
        else if (response.code() == 404)
            throw new NotFoundException("Location not found!");
        else if (response.code() == 400)
            throw new BadRequestException("Bad request!");
        else throw new RuntimeException();
    }

    private String trimQuotes(String string) {
        return string.substring(1, string.length() - 1);
    }
}
