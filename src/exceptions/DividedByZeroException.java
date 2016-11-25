package exceptions;

public class DividedByZeroException extends ExpressionException
{
	public DividedByZeroException() {
		this("Divisoraty is zero!");
	}
	public DividedByZeroException(String msg) {
		super(msg);
	}
}