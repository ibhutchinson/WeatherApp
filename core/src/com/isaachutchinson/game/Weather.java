package com.isaachutchinson.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import States.StateManager;
import States.AppState;

public class Weather extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private StateManager gsm;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 700;
	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#create()
	 */
	@Override
	public void create () {
		gsm = new StateManager();
		batch = new SpriteBatch();
		gsm.push(new AppState(gsm));
	}
    /*
     * (non-Javadoc)
     * @see com.badlogic.gdx.ApplicationAdapter#render()
     */
	@Override
	public void render () {
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
