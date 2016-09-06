package Functionality;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Texture;

public class WeatherObject implements Serializable{
	private String conditionName;
	private Texture conditionImage;
    /*
     * The WeatherObject method is the constructor for the WeatherObject Class.
     * 
     * @param String _conditionName
     * @param Texture _conditionImage
     */
	public WeatherObject(String _conditionName, Texture _conditionImage) {
		this.conditionName = _conditionName;
		this.conditionImage = _conditionImage;
		
	}



	/*
	 * The method setConditionName is a setter for the conditionName.
	 * 
	 * @param String newConditionName.
	 */
	public void setConditionName(String newConditionName) {
		this.conditionName = newConditionName;
	}

	/*
	 * The method getConditionName is a getter for the conditionName.
	 * 
	 * @return this.conditionName.
	 */
	public String getConditionName() {
		return this.conditionName;
	}

	/*
	 * The method getConditionImage is a getter for conditionImage.
	 * 
	 * @return this.conditionImage (Texture).
	 */
	public Texture getConditionImage() {
		return this.conditionImage;
	}

	/*
	 * The method setConditionImage is a setter for conditionImage.
	 * 
	 * @param Texture newTex.
	 */
	public void setConditionImage(Texture newTex) {
		this.conditionImage = newTex;
	}
}
