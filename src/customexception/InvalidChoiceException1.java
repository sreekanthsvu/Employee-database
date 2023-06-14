package customexception;

public class InvalidChoiceException1 extends RuntimeException
{
	String message;

	public InvalidChoiceException1(String message) {
		super();
		this.message = message;
	}
	public String getMessage()
	{
		return message;
	}

}
