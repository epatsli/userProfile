package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownIDException extends NullPointerException {
	private String error;

	public UnknownIDException() {
		System.out.println("This user don't exist.");
	}
}
