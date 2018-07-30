package exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownIDException extends NullPointerException {

	String str;
	public static final String message = "User don't exist.";

	public UnknownIDException() {
		this.str = "User don't exist";
	}
}
