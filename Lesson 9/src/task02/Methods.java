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

public class Methods {

	private double a;
	private double b;

	public Methods(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double add(double a, double b) {
		return a + b;
	}

	public double subtraction(double a, double b) {
		return a - b;
	}

	public double multiplication(double a, double b) {
		return a * b;
	}

	public double division(double a, double b) {
		return a / b;
	}

}