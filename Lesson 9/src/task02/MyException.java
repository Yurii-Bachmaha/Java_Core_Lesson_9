/*
 * Homework, module "Java Core"
 * Lesson 09
 * task02
 */

package task02;

/**
 * Application about exceptions
 * 
 * @author Yura
 * 
 * @version 1.0
 * 
 */

public class MyException extends Exception {
	private String message;

	public MyException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
