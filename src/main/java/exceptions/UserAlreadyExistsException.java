package exceptions;

public class UserAlreadyExistsException extends IllegalArgumentException 
{

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistsException(String s) {
		super(s);
	}

	public UserAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
}
