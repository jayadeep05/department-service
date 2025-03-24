package weather.entity;

//import jakarta.persistence.Entity;

//@Entity
public class UserWeather {

	private String city;
	private String temperature;
//	private String description
	
	public UserWeather() {}
	
	public UserWeather(String city, String temperature) {
		this.city = city;
		this.temperature = temperature;
	}

	public String getCity() {
		return city;
	}

//	public void setCity(String city) {
//		this.city = city;
//	}

	public String getTemperature() {
		return temperature;
	}

//	public void setTemperature(String temperature) {
//		this.temperature = temperature;
//	}
	

}
