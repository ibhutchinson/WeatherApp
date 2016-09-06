package com.isaachutchinson.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.isaachutchinson.game.Weather;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Weather.WIDTH;
		config.height = Weather.HEIGHT;
		new LwjglApplication(new Weather(), config);
	}
}
