package Functionality;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.badlogic.gdx.graphics.Texture;

import net.sf.json.JSONObject;

public class CurrentForecast {
	private ArrayList<WeatherObject> condition;
	private String location;
	private double feelsLikeT;
	private String windDir;
	private int humidity;
	private double farenC;
	private double windMph;
	private double pressureIN;
	private double precipIn;
	private String conditionText;
	private Texture phold;

	/*
	 * The CurrentForecast method is a Constructor for the CurrentForecast
	 * class.
	 */
	public CurrentForecast() {
		phold = new Texture("placeHolder.png");
		condition = new ArrayList<WeatherObject>();
		condition.add(new WeatherObject("Chance of Flurries", new Texture("weatherIcons/Snowy.png")));
		condition.add(new WeatherObject("Chance of Rain", new Texture("weatherIcons/Showers.png")));
		condition.add(new WeatherObject("Chance of Sleet", new Texture("weatherIcons/Sleet.png")));
		condition.add(new WeatherObject("Chance of Snow", new Texture("weatherIcons/Snowy.png")));
		condition.add(new WeatherObject("Chance of a Thunderstorm", new Texture("weatherIcons/Thunder.png")));
		condition.add(new WeatherObject("Clear", new Texture("weatherIcons/Sunny.png")));
		condition.add(new WeatherObject("Sunny", new Texture("weatherIcons/Sunny.png")));
		condition.add(new WeatherObject("Cloudy", new Texture("weatherIcons/Cloudy.png")));
		condition.add(new WeatherObject("Flurries", new Texture("weatherIcons/Snowy.png")));
		condition.add(new WeatherObject("Overcast", new Texture("weatherIcons/Cloudy.png")));
		condition.add(new WeatherObject("Mostly Cloudy", new Texture("weatherIcons/Sunny_to_cloudy.png")));
		condition.add(new WeatherObject("Mostly Sunny", new Texture("weatherIcons/Sunny_to_cloudy.png")));
		condition.add(new WeatherObject("Partly Cloudy", new Texture("weatherIcons/Sunny_to_cloudy.png")));
		condition.add(new WeatherObject("Partly Sunny", new Texture("weatherIcons/Sunny_to_cloudy.png")));
		condition.add(new WeatherObject("Rain", new Texture("weatherIcons/Heavy_rain.png")));
		condition.add(new WeatherObject("Light rain", new Texture("weatherIcons/Heavy_rain.png")));
		condition.add(new WeatherObject("Sleet", new Texture("weatherIcons/Sleet.png")));
		condition.add(new WeatherObject("Snow", new Texture("weatherIcons/Snowy.png")));
		condition.add(new WeatherObject("Light snow", new Texture("weatherIcons/Snowy.png")));
		condition.add(new WeatherObject("Thunderstorm", new Texture("weatherIcons/Thunder.png")));

	}

	/*
	 * The getWeatherCurrent method parses the data retrieved from the API site
	 * and stores the information needed in the correct variables
	 */
	public void getWeatherCurrent(String zip) throws MalformedURLException, IOException {
		try {
			String JSonString = readURL(
					"http://api.apixu.com/v1/current.json?key=e77e5a2ee254456496712848160404&q=" + zip);
			JSONObject x = JSONObject.fromObject(JSonString);
			JSONObject weatherDataLocation = (JSONObject) (x.get("location"));
			location = (weatherDataLocation.get("name").toString());
			JSONObject weatherDataCurrent = (JSONObject) (x.get("current"));
			farenC = (Double) (weatherDataCurrent.get("temp_f"));
			feelsLikeT = (Double) (weatherDataCurrent.get("feelslike_f"));
			windMph = (Double) (weatherDataCurrent.get("wind_mph"));
			pressureIN = (Double) (weatherDataCurrent.get("pressure_in"));
			precipIn = (Double) (weatherDataCurrent.get("precip_in"));
			windDir = (String) (weatherDataCurrent.get("wind_dir"));
			conditionText = (String) (weatherDataCurrent.getJSONObject("condition").get("text"));
			if (conditionText.length() > 20) {
				conditionText = "No Condition";
			}
			humidity = (Integer) (weatherDataCurrent.get("humidity"));
		} catch (Exception e) {

		}

	}

	/*
	 * The method readURL converts the URL into a string.
	 * 
	 * Method originates from Lab 4 ITEC 220
	 * 
	 * @return result
	 */
	private static String readURL(String webservice) throws java.net.MalformedURLException, java.io.IOException {
		URL service = new URL(webservice);
		String result = IOUtils.toString(service, "UTF-8");
		return result;
	}

	/*
	 * The method getPrecipIn is a getter method for the precipitation
	 * 
	 * @return this.precipIn
	 */
	public double getPrecipIn() {
		return this.precipIn;
	}

	/*
	 * The method getpressureIN is a getter method for the atmospheric pressure.
	 * 
	 * @return this.pressureIN
	 */
	public double getpressureIN() {
		return this.pressureIN;
	}

	/*
	 * The method getFeelsLike is a getter method for the current feels like
	 * 
	 * @return this.feelsLikeT
	 */
	public double getFeelsLike() {
		return this.feelsLikeT;
	}

	/*
	 * The method getHumidity is a getter method for the current humidity
	 * 
	 * @return this.humidity
	 */
	public double getHumidity() {
		return this.humidity;
	}

	/*
	 * The method getWindMph is a getter method for the current MPH of the wind.
	 * 
	 * @return this.windMph
	 */
	public double getWindMph() {
		return this.windMph;
	}

	/*
	 * The method getWindDr is a getter method for the current direction of the
	 * wind
	 * 
	 * @return this.windDir
	 */
	public String getWindDr() {
		return this.windDir;
	}

	/*
	 * The method getLocation is a getter method for the current forecasts
	 * location
	 * 
	 * @return this.location
	 */
	public String getLocation() {
		return this.location;
	}

	/*
	 * The method getFarenC is a getter method for the current days forecasted
	 * temp.
	 * 
	 * @return this.farenC
	 */
	public double getFarenC() {
		return this.farenC;
	}

	/*
	 * The method getConditionText is a getter method that gets the current
	 * forecast condition
	 * 
	 * @return this.getConditionText
	 */
	public String getConditionText() {
		return this.conditionText;
	}

	/*
	 * The method getTexture is a getter method that operates on the conditions
	 * texture array.When a matching condition is found it returns the
	 * Corresponding texture.
	 * 
	 * @return this.phold ( The Texture for the current weather condition.)
	 */
	public Texture getTexture() {
		for (WeatherObject x : condition) {

			if (x.getConditionName().trim().equals(conditionText.trim())) {
				phold = x.getConditionImage();

			}

		}
		return phold;
	}

}
