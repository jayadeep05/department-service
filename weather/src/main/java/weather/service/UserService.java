package weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import weather.entity.UserWeather;

@Service
public class UserService {

    @Value("${weatherapi.key}")
    private String apiKey;

    @Value("${weatherapi.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public UserWeather getWeather(String city) {
    	
    	
        String url = apiUrl + "/v1/current.json?key=" + apiKey + "&q=" + city;

        System.out.println("Requesting URL: " + url);
        String response = restTemplate.getForObject(url, String.class);

        System.out.println("Raw API Response: " + response);

        JSONObject json = new JSONObject(response);
        JSONObject current = json.getJSONObject("current");

        String temperature = current.get("temp_c") + "°C";
        String condition = current.getJSONObject("condition").getString("text");

        return new UserWeather(city, temperature + " (" + condition + ")");
    }
}
