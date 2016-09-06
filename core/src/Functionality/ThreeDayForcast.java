package Functionality;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.IOUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ThreeDayForcast {
	private String dayOneHigh;
	private String dayOneLow;
	private String dayTwoDate;
	private String dayTwoHigh;
	private String dayTwolow;
	private String dayThreeHigh;
	private String dayThreeLow;
	private Calendar calendar;
	private Date date;
	private SimpleDateFormat sdf;
	private String dayOneDate;
	private String dayThreeDate;
	private String moonRiseF;
	private String moonSetF;
	private String moonMinors;
	private JSONObject dayOneAstro;
	private String dayOneMinors;
	private JSONObject dayTwoAstro;
	private JSONObject dayThreeAstro;
	private String moonMinorE;
	private String moonMinorS;
	private String dayTwoMinors;
	private String dayThreeMinors;
	private String JSonStringAll;
	private String dayThreeCondition;
	private String dayTwoCondition;
	private String dayOneCondition;
    /*
     * The method ThreeDayForcast is the Constructor for the ThreeDayForcast.
     */
	public ThreeDayForcast() {
		calendar = new GregorianCalendar();
		sdf = new SimpleDateFormat("hh:mm a");
		moonMinors = "";

		try {

		} catch (Exception e) {

		}
	}
    /*
     * The method getWeatherForecast parses the JSON data for day one from the API and stores the information in the correct variables.
     * The method calls:
     *                  getDayTwo();
			            getDayThree(); 
     * 
     * @param The zip code for the the forecast
     */
	public void getWeatherForecast(String zip) throws MalformedURLException, IOException {
		try {
			String JSonString = readURL(
					"" + zip + "&days=4");
			JSonStringAll = JSonString;
			JSONObject x = JSONObject.fromObject(JSonString);
			JSONObject threeDayCast = (JSONObject) (x.get("forecast"));
			JSONArray threeDayCastDay = threeDayCast.getJSONArray("forecastday");
			JSONObject dayOne = (JSONObject) threeDayCastDay.get(1);
			dayOneAstro = (JSONObject) ((JSONObject) threeDayCastDay.get(1)).get("astro");
			buildTimes(dayOneAstro);
			getMoonMinorData();
			dayOneMinors = moonMinors;
			dayOneDate = (String) (dayOne.get("date"));
			JSONObject dayOneWeather = (JSONObject) dayOne.getJSONObject("day");
			dayOneCondition = (String) (dayOneWeather.getJSONObject("condition").get("text"));
		    if(dayOneCondition.length()>20){
		    	dayOneCondition = "No Condition";
		    }
			dayOneHigh = (String) ("High: " + dayOneWeather.get("maxtemp_f") + " F");
			dayOneLow = (String) ("Low: " + dayOneWeather.get("mintemp_f") + " F");
			getDayTwo();
			getDayThree();

		} catch (Exception e) {

		}

	}
   /*
    * The method getDayTwo parses the JSON day two from the API and Stores the information in the correct variables.
    *
    */
	private void getDayTwo() {
		JSONObject x = JSONObject.fromObject(JSonStringAll);
		JSONObject threeDayCast = (JSONObject) (x.get("forecast"));
		JSONArray threeDayCastDay = threeDayCast.getJSONArray("forecastday");
		JSONObject dayTwo = (JSONObject) threeDayCastDay.get(2);
		dayTwoAstro = (JSONObject) ((JSONObject) threeDayCastDay.get(2)).get("astro");
		buildTimes(dayTwoAstro);
		getMoonMinorData();
		dayTwoMinors = moonMinors;
		dayTwoDate = (String) (dayTwo.get("date"));
		JSONObject dayTwoWeather = (JSONObject) dayTwo.getJSONObject("day");
		dayTwoCondition = (String) (dayTwoWeather.getJSONObject("condition").get("text"));
	    if(dayTwoCondition.length()>20){
	    	dayTwoCondition = "No Condition";
	    }
		dayTwoHigh = (String) ("High: " + dayTwoWeather.get("maxtemp_f") + " F");
		dayTwolow = (String) ("Low: " + dayTwoWeather.get("mintemp_f") + " F");
	}
    /*
     * The method getDayThree parses the JSON data for the third forcast day and stores it in the correct variables.
     */
	private void getDayThree() {
		JSONObject x = JSONObject.fromObject(JSonStringAll);
		JSONObject threeDayCast = (JSONObject) (x.get("forecast"));
		JSONArray threeDayCastDay = threeDayCast.getJSONArray("forecastday");
		JSONObject dayThree = (JSONObject) threeDayCastDay.get(3);
		dayThreeAstro = (JSONObject) ((JSONObject) threeDayCastDay.get(3)).get("astro");
		buildTimes(dayThreeAstro);
		getMoonMinorData();
		dayThreeMinors = moonMinors;
		dayThreeDate = (String) (dayThree.get("date"));
		JSONObject dayThreeWeather = (JSONObject) dayThree.getJSONObject("day");
		dayThreeCondition = (String) (dayThreeWeather.getJSONObject("condition").get("text"));
	    if(dayThreeCondition.length()>20){
	    	dayThreeCondition = "No Condition";
	    }
		dayThreeHigh = (String) ("High: " + dayThreeWeather.get("maxtemp_f") + " F");
		dayThreeLow = (String) ("Low: " + dayThreeWeather.get("mintemp_f") + " F");
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
     * The method buildTimes gets the moonrise and moonset data from the API
     * 
     * @param time is a JSONObject from the API
     */
	public void buildTimes(JSONObject time) {

		try {

			moonRiseF = (String) time.get("moonrise");
			moonSetF = (String) time.get("moonset");

		} catch (Exception e) {
		
		}
	}
    /*
     * The method getMoonMinorData performs the calculations for the moon minors times
     */
	public void getMoonMinorData() {
		try {
			Date date = new SimpleDateFormat("hh:mm a").parse(moonRiseF);
			sdf.format(date);
			calendar.setTime(date);
			calendar.add(Calendar.HOUR, -1);
			moonMinors = sdf.format(calendar.getTime()) + " - ";
			calendar.add(Calendar.HOUR, 3);
			moonMinors += sdf.format(calendar.getTime());

		} catch (ParseException e) {

			e.printStackTrace();
		}

	}
    /*
     * The method getDaythreeMinors is a getter method for the third days minor times
     * 
     * @return "Minor Times: " + this.dayThreeMinors
     */
	public String getDayThreeMinors() {
		return "Minor Times: " + this.dayThreeMinors;
	}
    /*
     * The method getDayTwoMinors is a getter method for the second days minor times
     * 
     * @return "Minor Times: " + this.dayTwoMinors
     */
	public String getDayTwoMinors() {
		return "Minor Times: " + this.dayTwoMinors;
	}
    /*
     * The method getDayOneMinors is a getter method for the first days minor times
     * 
     * @return "Minor Times: " + this.dayOneMinors
     */
	public String getDayOneMinors() {
		return "Minor Times: " + this.dayOneMinors;
	}
    /*
     * The method getDayThreeDate is a getter method for the Third days date
     * 
     * @return "Weather for: " + this.dayThreeDate;
     */
	public String getDayThreeDate() {
		return "Weather for: " + this.dayThreeDate;
	}
    /*
     * The method getDayTwoDate is a getter method for the second days date
     * 
     * @return "Weather for: " + this.dayTwoDate;
     */
	public String getDayTwoDate() {
		return "Weather for: " + this.dayTwoDate;
	}
    /*
     * The method getDayOneDate is a getter method for the First days date
     * 
     * @return "Weather for: " + this.dayOneDate;
     */
	public String getDayOneDate() {
		return "Weather for: " + this.dayOneDate;
	}
    /*
     * The method get getDayOneCondition is a getter method for the First days condition.
     * 
     *  @return this.dayOneCondition
     */
	public String getDayOneCondition() {
		return this.dayOneCondition;
	}
    /*
     * The method get getDayTwoCondition is a getter method for the second days condition.
     * 
     *  @return this.dayTwoCondition
     */
	public String getDayTwoCondition() {
		return this.dayTwoCondition;
	}
    /*
     * The method get getDayThreeCondition is a getter method for the third days condition.
     * 
     *  @return this.dayThreeCondition
     */
	public String getDayThreeCondition() {
		return this.dayThreeCondition;
	}
    /*
     * The method getDayOneHigh is the getter method for the first days high temp.
     * 
     * @return this.dayOneHigh;
     */
	public String getDayOneHigh() {
		return this.dayOneHigh;
	}
    /*
     * The method getDayOneLow is the getter method for the first days low temp.
     * 
     * @return this.dayOneLow;
     */
	public String getDayOneLow() {
		return this.dayOneLow;
	}
    /*
     * The method getDayTwoHigh is the getter method for the second days high temp.
     * 
     * @return this.dayTwoHigh;
     */
	public String getDayTwoHigh() {
		return this.dayTwoHigh;
	}
    /*
     * The method getDayTwoLow is the getter method for the second days low temp.
     * 
     * @return this.dayTwoLow;
     */
	public String getDayTwoLow() {
		return this.dayTwolow;
	}
    /*
     * The method getDayThreeHigh is the getter method for the third days high temp.
     * 
     * @return this.dayThreeHigh;
     */
	public String getDayThreeHigh() {
		return this.dayThreeHigh;
	}
    /*
     * The method getDayThreeLow is the getter method for the third days low temp.
     * 
     * @return this.dayThreeLow;
     */
	public String getDayThreeLow() {
		return this.dayThreeLow;
	}

}
