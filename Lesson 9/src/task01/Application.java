/*
 * Homework, module "Java Core"
 * Lesson 09
 * task01
 */

package task01;

import java.util.Scanner;

/**
 * Application about seasons and months
 * 
 * @author Yura
 * 
 * @version 1.0
 * 
 */

public class Application {

	static void menu() {
		System.out.println("Enter 1 to check if there is such a month.");
		System.out.println("Enter 2 to display all months with the same time of year.");
		System.out.println("Enter 3 to dispay all months that have the same number of days.");
		System.out.println("Enter 4 to display all months that have fewer days.");
		System.out.println("Enter 5 to display all months that have the most days.");
		System.out.println("Enter 6 to display next season.");
		System.out.println("Enter 7 to display previous season.");
		System.out.println("Enter 8 to display all months that have an even number of days.");
		System.out.println("Enter 9 to display all months that have an odd number of days.");
		System.out.println("Enter 10 to display whether the month entered from the console has an even number of days.");

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		/*arrays for seasons and months*/
		Months[] monthArr = Months.values();
		Seasons[] seasonArr = Seasons.values();
		

		while (true) {
			menu();

			switch (sc.next()) {

			case "1": {

				System.out.println("Enter month");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(monthArr, month);

				wrongMonth(month, flag);
				
				break;
			}

			case "2": {
				System.out.println("Enter season");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = false;

				for (Months m : monthArr) {
					if (m.getSeasons().name().equals(month)) {
						flag = true;
					}
				}

				if (flag) {

					for (Months m2 : monthArr) {
						if (m2.getSeasons().toString().equalsIgnoreCase(month)) {
							System.out.println(m2);
						}
					}
				}
				
				wrongSeason(month, flag);

				break;
			}

			case "3": {
				System.out.println("Enter number 28 , 30 or 31");
				sc = new Scanner(System.in);
				int m1 = sc.nextInt();

				boolean flag = false;

				for (Months m2 : monthArr) {
					if (m2.getDays() == m1) {
						System.out.println(m2);
						flag = true;
					}
				}
				
				wrongNumber(m1, flag);

				break;
			}

			case "4": {
				System.out.println("All months that have fewer days.");
				for (Months m : monthArr) {
					if (m.getDays() < 31) {
						System.out.println(m + " has " + m.getDays() + " days");
					}
				}
				break;
			}

			case "5": {
				System.out.println("All months that have the most days.");
				for (Months m : monthArr) {
					if (m.getDays() > 30) {
						System.out.println(m + " has " + m.getDays() + " days");
					}
				}
				break;
			}

			case "6": {
				System.out.println("Enter season");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(seasonArr, season);

				if (flag) {
					Seasons s = Seasons.valueOf(season);
					int ordinal = s.ordinal();

					if (ordinal == seasonArr.length - 1) {
						ordinal = 0;
						System.out.println(seasonArr[ordinal]);
					} else {
						System.out.println(seasonArr[ordinal + 1]);
					}
				}
				
				wrongSeason(season, flag);

				break;

			}

			case "7": {
				System.out.println("Enter season");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(seasonArr, season);

				if (flag) {
					Seasons s = Seasons.valueOf(season);
					int ordinal = s.ordinal();

					if (ordinal == 0) {
						ordinal = (seasonArr.length - 1);
						System.out.println(seasonArr[ordinal]);
					} else {
						System.out.println(seasonArr[ordinal - 1]);
					}
				}
				
				wrongSeason(season, flag);

				break;
			}

			case "8": {
				System.out.println("All months that have an even number of days.");
				for (Months m : monthArr) {
					if (m.getDays() % 2 == 0) {
						System.out.println(m + " has " + m.getDays() + " days");
					}

				}
				break;
			}

			case "9": {
				System.out.println("All months that have an odd number of days.");
				for (Months m : monthArr) {
					if (m.getDays() % 2 == 1) {
						System.out.println(m + " has " + m.getDays() + " days");
					}

				}
				break;
			}

			case "10": {
				System.out.println("Enter month");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = false;

				for (Months ma : monthArr) {
					if (ma.name().equals(month))
						flag = true;
				}

				if (flag) {
					Months m = Months.valueOf(month);

					if (m.getDays() % 2 == 0) {
						System.out.println(m + " has even number of days");
					} else {
						System.out.println(m + " has odd number of days");
					}
				}
				
				wrongMonth(month, flag);
				
				break;
				
			}
			}

		}

	}
	
	//method that reports incorrect number
	
	private static void wrongNumber(int month, boolean flag) {
		if(flag) {
			month = month;
		}else {
			try {
				throw new WrongInputConsoleParametersException();
			}catch(WrongInputConsoleParametersException a) {
				System.err.println("Number doesn't exist, enter correct number");
			}finally {
				System.out.println("The program continues to work");
			}
		}
	}
	
	//method that reports absence of the season
	
	private static void wrongSeason(String season, boolean flag) {
		if(flag) {
			season = season;
		} else {
				try {
					throw new WrongInputConsoleParametersException();
				}catch(WrongInputConsoleParametersException a) {
					System.err.println("Season doesn't exist, enter correct season");
				}finally {
					System.out.println("The program continues to work");
				}
		}
	}
	
	//method that reports absence of the month
	
	private static void wrongMonth(String month, boolean flag) {
		if(flag) {
			month = month;
		} else {
				try {
					throw new WrongInputConsoleParametersException();
				}catch(WrongInputConsoleParametersException a) {
					System.err.println("Month doesn't exist, enter correct month");
				}finally {
					System.out.println("The program continues to work");
				}
		}
	}
	
	//method that checks presence of the season

	private static boolean isSeasonPresent(Seasons[] seasonArr, String season) {
		boolean flag = false;

		for (Seasons s : seasonArr) {
			if (s.name().equals(season)) {
				flag = true;
			}
		}
		return flag;
	}
	
	//method that checks presence of the month

	private static boolean isMonthPresent(Months[] mas, String month) {
		boolean flag = false;

		for (Months m : mas) {
			if (m.name().equals(month)) {
				System.out.println("Month exist");
				flag = true;
			}
		}
		return flag;
	}
}