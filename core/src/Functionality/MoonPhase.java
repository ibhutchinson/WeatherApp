package Functionality;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.IOUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MoonPhase {
	private String moonRise;
	private String moonSet;
	private String moonMinor1DS;
	private String moonMinor1DE;
	private String moonMajor1DS;
	private String moonMajor1DE;
	private char moonMajor1DEHours;
	private int amOrPm;
	private Calendar calendar;
	private SimpleDateFormat sdf;
	private SimpleDateFormat sdf2;

	/*
	 * The MoonPhase method is the constructor for the MoonPhase Class
	 */
	public MoonPhase() {
		calendar = new GregorianCalendar();
		sdf = new SimpleDateFormat("hh:mm a");
		sdf2 = new SimpleDateFormat("HH:mm");
	}

	/*
	 * The getAMTimes method does the calculations for the current days minor
	 * hunting times.
	 */
	public void getAMTimes() {
		try {
			Date date = new SimpleDateFormat("hh:mm").parse(moonRise);
			sdf.format(date);
			calendar.setTime(date);
			calendar.add(Calendar.HOUR, -1);
			moonMinor1DS = (sdf.format((calendar.getTime())));
			calendar.add(Calendar.HOUR, 3);
			moonMinor1DE = (sdf.format((calendar.getTime())));

		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	/*
	 * The method getPMTimes does the calculations for the major hunting times
	 * that occur at night. Some times there is no data for moonset
	 */
	public void getPMTimes() {

		try {
			if ((moonSet.trim().compareTo(("No moonset").trim()) != 0)) {
				Date date2 = new SimpleDateFormat("hh:mm a").parse(moonSet);
				sdf.format(date2);
				calendar.setTime(date2);
				calendar.add(Calendar.HOUR, -1);
				moonMajor1DS = sdf.format(calendar.getTime());
				calendar.add(Calendar.HOUR, 3);
				moonMajor1DE = (sdf.format(calendar.getTime()));

			} else {
				moonMajor1DS = "No Times";
				moonMajor1DE = "No Times";
			}
		} catch (Exception e) {

		}

	}
    /*
     * The buildTimes method parses the JSON API data and stores the information in the correct variables.
     * 
     * @param Sring zip ( Zip Code Entered by the user )
     */
	public void buildTimes(String zip) {

		try {
			String JSonString = readURL(
					"=" + zip);
			JSONObject x = JSONObject.fromObject(JSonString);
			JSONObject astroData = (JSONObject) (x.get("forecast"));
			JSONArray forecastDay = astroData.getJSONArray("forecastday");
			JSONObject astro = (JSONObject) (((JSONObject) forecastDay.get(0)).get("astro"));
			moonRise = (String) astro.get("moonrise");
			moonSet = (String) astro.get("moonset");
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
     * The method getMinor1Start is a getter method for the current days minor hunting times start.
     * 
     * @return this.moonMinor1DS
     */
	public String getMinor1DStart() {
		return this.moonMinor1DS;
	}
    /*
     * The method getMinor1DEnd is a getter method for the current days Minor hunting times end.
     * 
     * @return  this.moonMinor1DE
     */
	public String getMinor1DEnd() {
		return this.moonMinor1DE;
	}
    /*
     * The method getMajor1Start is a getter method for the current days Major hunting times start.
     * 
     * @return this.moonMajor1DS
     */
	public String getMajor1DStart() {
		return this.moonMajor1DS;
	}
    /*
     * The method getMajor1DEnd is a getter method for the current days Major hunting times end.
     * 
     * @return  this.moonMajor1DE
     */
	public String getMajor1DEnd() {
		return this.moonMajor1DE;
	}

}
