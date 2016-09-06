package States;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.isaachutchinson.game.Weather;

import Functionality.CurrentForecast;
import Functionality.MoonPhase;
import Functionality.ThreeDayForcast;

public class AppState extends State {
	private Texture background;
	private TextField textfield;
	Texture testT;
	private Stage stage;
	private FreeTypeFontGenerator gen;
	private FreeTypeFontParameter parameter;
	private FreeTypeFontParameter parameter2;
	private CurrentForecast currentF;
	private BitmapFont font2;
	private String location;
	private String farenC;
	private String conditionText;
	private String feelsLikeT;
	private String windDir;
	private String windMph;
	private String pressureIN;
	private String precipIn;
	private String humidity;
	private MoonPhase times;
	private ThreeDayForcast threeDayCast;
	private String minor1DS;
	private String minor1DE;
	private String major1DS;
	private String major1DE;
	private String dayOneHigh;
	private String dayOneLow;
	private String dayTwoHigh;
	private String dayTwolow;
	private String dayThreeHigh;
	private String dayThreeLow;
	private String dayOneDate;
	private String dayThreeDate;
	private String dayTwoDate;
	private String dayOneMinors;
	private String dayTwoMinors;
	private String dayThreeMinors;
	private String dayThreeCondition;
	private String dayTwoCondition;
	private String dayOneCondition;
	private ArrayList<String> zip;

	/*
	 * The method MenuState is the constructor for the MenuState class.
	 * 
	 * 
	 * @param GameStateManger gsm.
	 */
	public AppState(StateManager gsm) {
		super(gsm);
		load();
		placeHolders();
		times = new MoonPhase();
		font2 = new BitmapFont();
		stage = new Stage();
		gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/WarnockPro-Regular.otf"));
		parameter = new FreeTypeFontParameter();
		parameter2 = new FreeTypeFontParameter();
		parameter.size = 20;
		parameter2.size = 25;
		font2 = gen.generateFont(parameter2);
		TextFieldStyle style = new TextFieldStyle();
		style.fontColor = Color.GRAY;
		style.font = gen.generateFont(parameter);
		textfield = new TextField("Zip Code", style);
		textfield.setPosition(260, 640);
		stage.addActor(textfield);
		background = new Texture("background.jpg");
		Gdx.input.setInputProcessor(stage);
		testT = new Texture("placeHolder.png");
		threeDayCast = new ThreeDayForcast();

	}

	/*
	 * The placeHolders method is a private helper method that helps make the
	 * constructor smaller and more readable
	 */
	private void placeHolders() {
		dayOneDate = "";
		dayThreeDate = "";
		dayTwoDate = "";
		dayOneHigh = "";
		dayOneLow = "";
		dayTwoHigh = "";
		dayTwolow = "";
		dayThreeHigh = "";
		dayThreeLow = "";
		minor1DS = "";
		minor1DE = "";
		major1DS = "";
		major1DE = "";
		location = "";
		conditionText = "";
		feelsLikeT = "";
		windDir = "";
		windMph = "";
		farenC = "";
		pressureIN = "";
		precipIn = "";
		humidity = "";
		dayOneMinors = "";
		dayTwoMinors = "";
		dayThreeMinors = "";
		dayThreeCondition = "";
		dayTwoCondition = "";
		dayOneCondition = "";
		location = "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#handleInput()
	 */
	protected void handleInput() {
		callInputs();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#update(float)
	 */
	public void update(float dt) {
		handleInput();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#render(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	public void render(SpriteBatch sb) {

		sb.begin();
		sb.draw(background, 0, 0, Weather.WIDTH, Weather.HEIGHT);
		sb.draw(testT, 0, 420);
		font2.draw(sb, location, 140, 520);
		font2.draw(sb, conditionText, 135, 490);
		font2.draw(sb, farenC, 300, 490);
		font2.draw(sb, feelsLikeT, 0, 425);
		font2.draw(sb, windMph, 0, 395);
		font2.draw(sb, windDir, 0, 370);
		font2.draw(sb, pressureIN, 0, 345);
		font2.draw(sb, precipIn, 0, 320);
		font2.draw(sb, humidity, 0, 295);
		font2.draw(sb, "Minor Times (Day Times)\n" + minor1DS + "-" + minor1DE, 0, 185);
		font2.draw(sb, "Major Times (Night Times)\n" + major1DS + "-" + major1DE, 0, 120);
		font2.draw(sb, dayOneDate, 400, 540);
		font2.draw(sb, dayOneCondition, 400, 515);
		font2.draw(sb, dayOneHigh, 400, 490);
		font2.draw(sb, dayOneLow, 400, 470);
		font2.draw(sb, dayOneMinors, 400, 450);
		font2.draw(sb, dayTwoDate, 400, 370);
		font2.draw(sb, dayTwoCondition, 400, 345);
		font2.draw(sb, dayTwoHigh, 400, 320);
		font2.draw(sb, dayTwolow, 400, 295);
		font2.draw(sb, dayTwoMinors, 400, 270);
		font2.draw(sb, dayThreeDate, 400, 185);
		font2.draw(sb, dayThreeCondition, 400, 160);
		font2.draw(sb, dayThreeHigh, 400, 135);
		font2.draw(sb, dayThreeLow, 400, 110);
		font2.draw(sb, dayThreeMinors, 400, 90);
		sb.end();
		stage.draw();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#dispose()
	 */
	public void dispose() {

	}

	/*
	 * The callInputs method checks and corrects the entered zipcode if needed.
	 * Then the method calls the methods : currentW(); getMinorMajorTimes();
	 * getForecast();
	 */
	public void callInputs() {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {

			if (zip.contains(("00000" + textfield.getText()).substring(textfield.getText().length()))
					&& textfield.getText().length() <= 5) {
				textfield.setText(("00000" + textfield.getText()).substring(textfield.getText().length()));
				currentW();
				getMinorMajorTimes();
				getForecast();
			} else {
				textfield.setText("Invalid zip!");
			}
		}
	}

	/*
	 * The currentW method gets the current weather information and stores the
	 * information to the correct variables when the enter key is hit.
	 */
	public void currentW() {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {

			currentF = new CurrentForecast();
			try {
				currentF.getWeatherCurrent(textfield.getText());
				testT = currentF.getTexture();

			} catch (Exception e) {

			}
			feelsLikeT = "Feels like: " + String.valueOf(currentF.getFeelsLike()) + " F";
			location = currentF.getLocation();
			conditionText = currentF.getConditionText();
			farenC = String.valueOf(currentF.getFarenC() + " F");
			windMph = "Wind Speed: " + String.valueOf(currentF.getWindMph() + " Mph");
			windDir = "Wind Direction: " + currentF.getWindDr();
			pressureIN = "Atmospheric Pressure: " + String.valueOf(currentF.getpressureIN() + " in");
			precipIn = "Precipitation: " + String.valueOf(currentF.getPrecipIn() + " in");
			humidity = "Humidity " + String.valueOf(currentF.getHumidity() + " %");

		}
	}

	/*
	 * The getMinorMajorTimes method gets the minor and major hunting and
	 * fishing times when the enter key is hit.
	 */
	public void getMinorMajorTimes() {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			times.buildTimes(textfield.getText());
			times.getAMTimes();
			times.getPMTimes();
			minor1DS = (times.getMinor1DStart());
			minor1DE = (times.getMinor1DEnd());
			major1DS = (times.getMajor1DStart());
			major1DE = (times.getMajor1DEnd());
		}
	}

	/*
	 * The method getForecast gets the next three days weather information when
	 * enter is hit.
	 */
	public void getForecast() {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			try {
				threeDayCast.getWeatherForecast(textfield.getText());
			} catch (Exception e) {

			}
			dayOneHigh = threeDayCast.getDayOneHigh();
			dayOneLow = threeDayCast.getDayOneLow();
			dayOneMinors = threeDayCast.getDayOneMinors();
			dayOneCondition = "Forecast: " + threeDayCast.getDayOneCondition();
			dayTwoHigh = threeDayCast.getDayTwoHigh();
			dayTwolow = threeDayCast.getDayTwoLow();
			dayTwoMinors = threeDayCast.getDayTwoMinors();
			dayTwoCondition = "Forecast: " + threeDayCast.getDayTwoCondition();
			dayThreeHigh = threeDayCast.getDayThreeHigh();
			dayThreeLow = threeDayCast.getDayThreeLow();
			dayThreeCondition = "Forecast: " + threeDayCast.getDayThreeCondition();
			dayThreeMinors = threeDayCast.getDayThreeMinors();
			dayOneDate = threeDayCast.getDayOneDate();
			dayTwoDate = threeDayCast.getDayTwoDate();
			dayThreeDate = threeDayCast.getDayThreeDate();

		}
	}

	/*
	 * The load method loads in a zip code array list that contains all USA
	 * zipcodes.
	 */
	public void load() {
		try {
			FileInputStream fileIn = new FileInputStream("zipcodeAL");
			ObjectInputStream oIn = new ObjectInputStream(fileIn);
			this.zip = (ArrayList<String>) oIn.readObject();
			oIn.close();
			fileIn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
