package weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import weather.entity.UserWeather;
import weather.service.UserService;

@RestController
@RequestMapping("/weather")
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{city}")
	public UserWeather getWeather(@PathVariable String city) {
		return userService.getWeather(city);
		
	} 

} 