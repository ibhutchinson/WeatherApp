package States;
/*
 * StateManager.java
 * @verson 0.0.1
 * GameStateManager variation from original version made by Brent Aureli 
 * Youtube Channel: https://www.youtube.com/user/Profyx
 */
import java.util.Stack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class StateManager {

	private Stack<State> states;
	public static Music sound;
	public static Music sound2;
	/*
	 * The GameStateManager is the constructor for GameStateManager.
	 * 
	 */
	public StateManager()
	{
		states = new Stack<State>();
		
	}
    /*
     * The method update updates the delta time in the system.
     * 
     * 
     * @param float dt
     */
	public void update(float dt) {
		states.peek().update(dt);
		
	}

	/*
	 * The pop method takes the state on top of the stack off.
	 * 
	 */
	public void pop(){
		states.pop();
	}
	
	/*
	 * The set method remove the current state from the top of the stack and pushes a new state to the stack
	 * 
	 * 
	 * @param State state.
	 */
	public void set(State state){
		states.pop();
		states.push(state);
	}

	/*
	 * The push method pushes a state onto the stack.
	 * 
	 * @param State state
	 */
	public void push(State state){
		states.push(state);
	}
    /*
     * The method render draws images to the screen.
     * 
     * @param SpriteBatch sb.
     */
	public void render(SpriteBatch sb) {
		states.peek().render(sb);
		
	}


	

}
