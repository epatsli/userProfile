package exception;

public class UserNotFoundException extends Error {
	public UserNotFoundException() {
		super("This user not found.");
	}
}
