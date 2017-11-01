package arkhipov.weather.controllers;

import arkhipov.weather.models.Location;
import arkhipov.weather.services.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private static Logger LOG = LoggerFactory.getLogger(WeatherController.class);

    private WeatherService service;

    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @RequestMapping("coordinates")
    public Location getWeatherByCoordinates(@RequestParam(value = "lon") String lon, @RequestParam(value = "lat") String lat) {
        Location respLocation = service.getWeatherByCoordinates(lon, lat);
        LOG.info("Request with parameters {lon=" + lon +
                ", lat=" + lat +
                "} -> Response: " + respLocation);
        return respLocation;
    }

    @RequestMapping("location")
    public Location getWeatherByName(@RequestParam(value = "name") String name) {
        Location respLocation = service.getWeatherByName(name);
        LOG.info("Request with parameters {name=" + name +
                "} -> Response: " + respLocation);
        return respLocation;
    }
}
