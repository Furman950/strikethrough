package exceptions;

public class InvalidUsernameOrPasswordException extends IllegalArgumentException 
{

	private static final long serialVersionUID = 1L;
	
	public InvalidUsernameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUsernameOrPasswordException(String s) {
		super(s);
	}

	public InvalidUsernameOrPasswordException(Throwable cause) {
		super(cause);
	}

}
