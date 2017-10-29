package arkhipov.weather.services;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface OpenWeatherMapAPI {
    @GET("weather")
    Call<JsonObject> getWeatherByCoordinates(@Query("lon") String lon, @Query("lat") String lat, @Query("APPID") String appid);

    @GET("weather")
    Call<JsonObject> getWeatherByName(@Query("q") String name, @Query("APPID") String appid);
}
