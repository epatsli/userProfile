package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownIDException extends NullPointerException {

	public static final String message = "User don't exist.";

	public UnknownIDException() {
		super(message);
	}
}
