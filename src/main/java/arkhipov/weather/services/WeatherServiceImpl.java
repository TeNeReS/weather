package arkhipov.weather.services;

import arkhipov.weather.models.Location;
import arkhipov.weather.models.Weather;
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
        JsonObject jsonObject = (JsonObject) response.body();
        String nameWithQuotes = jsonObject.get("name").toString();
        String name = nameWithQuotes.substring(1, nameWithQuotes.length() - 1);
        String temperature = jsonObject.getAsJsonObject("main").get("temp").toString();
        String wind = jsonObject.getAsJsonObject("wind").get("speed").toString();
        String pressure = jsonObject.getAsJsonObject("main").get("pressure").toString();
        String humidity = jsonObject.getAsJsonObject("main").get("humidity").toString();
        Weather weather = new Weather(temperature, wind, pressure, humidity);
        return new Location(name, lon, lat, weather);
    }

    @Override
    public Location getWeatherByName(String name) {
        Response response = null;
        try {
            response = api.getWeatherByName(name, APPID).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = (JsonObject) response.body();
        String nameWithQuotes = jsonObject.get("name").toString();
//        String name = nameWithQuotes.substring(1, nameWithQuotes.length() - 1);
        String temperature = jsonObject.getAsJsonObject("main").get("temp").toString();
        String wind = jsonObject.getAsJsonObject("wind").get("speed").toString();
        String pressure = jsonObject.getAsJsonObject("main").get("pressure").toString();
        String humidity = jsonObject.getAsJsonObject("main").get("humidity").toString();
        Weather weather = new Weather(temperature, wind, pressure, humidity);
        return null;
    }
}
