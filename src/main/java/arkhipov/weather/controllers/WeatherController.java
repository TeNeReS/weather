package arkhipov.weather.controllers;

import arkhipov.weather.models.Location;
import arkhipov.weather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private WeatherService service;
    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @RequestMapping("coordinates")
    public Location getWeatherByCoordinates(@RequestParam(value = "lon") String lon, @RequestParam(value = "lat") String lat) {
        return service.getWeatherByCoordinates(lon, lat);
    }

    @RequestMapping("location")
    public Location getWeatherByName(@RequestParam(value = "name") String name) {
        return service.getWeatherByName(name);
    }
}
