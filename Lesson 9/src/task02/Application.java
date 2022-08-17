/*
 * Homework, module "Java Core"
 * Lesson 09
 * task02
 */

package task02;

import java.util.Scanner;

/**
 * Application about exceptions
 * 
 * @author Yura
 * 
 * @version 1.0
 * 
 */

public class Application {
	public static void main(String[] args) throws Exception {

		double a = 0;
		double b = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number a:");

		if (sc.hasNextDouble()) {
			a = sc.nextDouble();
		} else {
			System.err.println("This is not double, enter double");
			System.exit(0);
			sc.close();
		}

		System.out.println("Enter number b:");

		if (sc.hasNextDouble()) {
			b = sc.nextDouble();
		} else {
			System.out.println("This is not double, enter double");
			System.exit(0);
			sc.close();
		}

		try {

			if ((a < 0) && (b < 0)) {
				throw new IllegalArgumentException("Illegal Argument");
			}
			if (((a == 0) && (b != 0)) || ((a != 0) && (b == 0))) {
				throw new ArithmeticException("Arithmetic Exception");
			}
			if ((a == 0) && (b == 0)) {
				throw new IllegalAccessException("Illegal Access");
			}
			if ((a > 0) && (b > 0)) {
				throw new MyException("My Exception");
			}

		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println(e.getMessage());
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}

		Methods methods = new Methods(a, b);
		System.out.println("Summary = " + methods.add(a, b));
		System.out.println("Substraction = " + methods.subtraction(a, b));
		System.out.println("Multiply = " + methods.multiplication(a, b));
		System.out.println("Divide = " + methods.division(a, b));

	}

}