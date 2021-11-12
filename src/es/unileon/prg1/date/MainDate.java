package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		
		try {
			today = new Date(8,8,2020);
			//System.out.println(today);
			//System.out.println(today.getSeason());
			//System.out.println(today.getDatesUntilEndOfMonth());
			//System.out.println(today.getMonthsWithSameDays());
			//System.out.println(today.getNumDaysSinceStartYear());
			//System.out.println(today.getNumOfRandomAttempts());
			System.out.println(today.getDayOfWeek(3));
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}