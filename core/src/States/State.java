package States;

/*
 * States.java
 * @author Isaac Hutchinson
 * @version 0.0.1
 */
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

	protected StateManager gsm;


	/*
	 * Constructor for Abstract State Class
	 * 
	 * @param StateManager gsm
	 */
	protected State(StateManager gsm) {
		this.gsm = gsm;


	}

	/*
	 * The handleInput method takes all the logic for input in the game so that
	 * one call can be made in the update.
	 */
	protected abstract void handleInput();

	/*
	 * The update method updates all the content in the app.
	 * 
	 * @param float dt
	 */
	public abstract void update(float dt);

	/*
	 * The render method draws all the app content to the screen.
	 * 
	 * @param SpriteBatch sb
	 */
	public abstract void render(SpriteBatch sb);

	/*
	 * The dispose method takes away all the rendered objects to the screen when
	 * they are no longer being used to prevent memory leaks.
	 */
	public abstract void dispose();
}
