/**
 * The base class for all number games.
 * Your guessing game should extend this class and
 * override the methods: guess(), toString(), getUpperBound().
 * 
 * Your class should not override getMessage() and setMessage(),
 * just use the methods from this class.
 *
 * @author Pakanon Pantisawat
 */
public class NumberGame {
	/** A helpful message for user. */
	private String message;

    /** Initialize a new default game. */
    public NumberGame() {
		// initialize your game.
    	message = "";
    }
   
    /**
     * Evaluate a user's answer to the game.
     * @param answer is the user's answer, as an integer.
     * @return true if correct, false otherwise
     */
    public boolean guess(int answer) {
		message = "Sorry, that's not correct";
		return false;
    }
    
    /**
     * Return a message about the most recent call to guess().
     * Initially the message should tell the user something so
     * the user knows what to guess, such as
     * "I'm thinking of a number between 1 and xx".
     * @return string message related to the most recent guess.
     */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Set a message about the game.
     * @param newMessage a string about game or most recent guess.
	 */
    public void setMessage(String newMessage) {
        this.message = newMessage;
	}
	
	/** 
	 * Get the largest possible value of the solution for this game. 
	 * For a guessing game, this should be the upper bound of secret.
	 */
	public int getUpperBound() {
		return Integer.MAX_VALUE;  // not very helpful :-)
	}

    /**
     * Get the count from the guess counter.
     *
     * @return count for guess.
     */
    public int getCount() {
        return 0;
    }
    
    /**
     * toString describes the game or problem.
     * @return description of this game or the problem to be solved.
     */
	@Override
    public String toString() {
		return "You should override this method for your game";
    }
}