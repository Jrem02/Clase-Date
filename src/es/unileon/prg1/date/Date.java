package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}

	public boolean isSameYear(Date otherDate) {
		int otherYear = otherDate.getYear();
		boolean isSameYear = (otherYear == this.year);
		return isSameYear;
	}

	public boolean isSameMonth(Date otherDate) {
		int otherMonth = otherDate.getMonth();
		boolean isSameMonth = (otherMonth == this.month);
		return isSameMonth;
	}

	public boolean isSameDay(Date otherDate) {
		int otherDay = otherDate.getDay();
		boolean isSameDay = (otherDay == this.day);
		return isSameDay;
	}

	public boolean isSame(Date otherDate) {
		boolean isSame = ((this.year == otherDate.getYear()) && (this.month == otherDate.getMonth()) && (this.day == otherDate.getDay()));
		return isSame;
	}

	public String getMonthName() throws DateException {
		if (this.month < 1 || this.month > 12) {
			throw new DateException("Date error: Invalid Month");
		}
		String monthName = new String();
		switch (this.month) {
			case 1:
				monthName = "January";
				break;
			case 2: 
				monthName = "February";
				break;
			case 3: 
				monthName = "March";
				break;
			case 4: 
				monthName = "April";
				break;
			case 5: 
				monthName = "May";
				break;
			case 6: 
				monthName = "June";
				break;
			case 7: 
				monthName = "July";
				break;
			case 8: 
				monthName = "August";
				break;
			case 9: 
				monthName = "September";
				break;
			case 10: 
				monthName = "October";
				break;
			case 11: 
				monthName = "November";
				break;
			case 12: 
				monthName = "December";
				break;
		}
		return monthName;
	}

	private boolean isDayOfMonthRight() {
		if (this.day > getDaysOfMonth() || this.day < 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getSeason() throws DateException {
		if (!isDayOfMonthRight()) {
			throw new DateException("Date error: day is not part of the specified month");
		}
		String Season = new String();
		switch (this.month) {
			case 3: //next
			case 4: //next
			case 5:
				Season = "Spring";
				break;
			case 6: //next
			case 7: //next
			case 8:
				Season = "Summer";
				break;
			case 9: //next
			case 10: //next
			case 11:
				Season = "Autumm";
				break;
			case 12: //next
			case 1: //next
			case 2:
				Season = "Winter";
				break;
		}
		return Season;
	}

	public int getMonthsUntilEnd() throws DateException{
		if (this.month < 1 || this.month > 12) {
			throw new DateException("Date error: Invalid Month");
		}
		return 12 - this.month;
	}

	private boolean isLeapYear() {
		return ((this.year % 4 == 0) && (this.year % 100 != 0)) || (this.year % 400 == 0);
	}

	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}

	private int getDaysOfMonth(int month) throws DateException {
		if (month < 1 || month > 12) {
			throw new DateException("Date error: Invalid Month");
		}
		int numDays;
		
		numDays = 0;
		switch (month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;
		}
		
		return numDays;
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	public String getDatesUntilEndOfMonth() throws DateException {
		if (!isDayOfMonthRight()) {
			throw new DateException("Date error: Invalid day.");
		}
		if (this.month < 1 || this.month > 12) {
			throw new DateException("Date error: Invalid Month");
		}
		StringBuffer auxString = new StringBuffer();
		if (this.day == getDaysOfMonth()) {
			auxString.append("0 days until the end of the month");
		}
		else {
			for (int i = this.day+1; i <= getDaysOfMonth(); i++) {
				auxString.append(i + "/" + this.month + "/" + this.year + "; ");
			}
		}
		String dates = auxString.toString();
		return dates;
	}

	
	public String getMonthsWithSameDays () throws DateException {
		StringBuffer monthString = new StringBuffer();
		for (int i = 1; i <= 12; i++) {
			if (i != this.month) {
				Date e = new Date(1, i, this.year);
				if (e.getDaysOfMonth() == this.getDaysOfMonth()) {
					monthString.append(e.getMonthName() + "; ");
				}
			}
		}
		if (this.month == 2) { //february
			monthString.append("There are no months with the same number of days");
		}
		String months = monthString.toString();
		return months;
	}

	public int getNumDaysSinceStartYear() throws DateException {
		if (!isDayOfMonthRight()) {
			throw new DateException("Date error: Invalid Day");
		}
		if (this.month < 1 || this.month > 12) {
			throw new DateException("Date error: Invalid Month");
		}
		int numDays = 0;
		// Junio no tiene meses anteriores a el al empezar el año, asi que no contamos el num de dias de los meses anteriores a Junio
		// Para el resto, contamos el numero de dias que hay en total de los meses que preceden al mes actual.
		if (this.month != 1) {
			for (int j = 1; j < this.month; j++) {
				Date prevMonths = new Date(1, j, this.year);
				numDays += prevMonths.getDaysOfMonth();
			}
		}
		// Esto cuenta el num de dias desde el principio del mes actual hasta el dia de la fecha.
		for (int i = 0; i < this.day; i++) {
			numDays++;
		}

		return numDays;
	}

	public int getNumOfRandomAttempts() throws DateException {
		
		boolean continueExecution = true;
		int numAttempts = 0;
		
		while (numAttempts != Integer.MAX_VALUE && continueExecution) {
			int randomMonth = (int) ((Math.random() * 12)+1);
			int randomDay = (int) ((Math.random() * getDaysOfMonth(randomMonth))+1);
			Date randomDate = new Date(randomDay, randomMonth, this.year);
			if (isSame(randomDate)) {
				continueExecution = false;
			}
			else {
				numAttempts++;
			}
		}
		return numAttempts;
	}

	public int getNumOfRandomAttemptsAlt() throws DateException {
		//Mismo metodo, pero con un do while.
		
		boolean continueExecution = true;
		int numAttempts = 0;

		do {
			int randomMonth = (int) ((Math.random() * 12)+1);
			int randomDay = (int) ((Math.random() * getDaysOfMonth(randomMonth))+1);
			Date randomDate = new Date(randomDay, randomMonth, this.year);
			if (isSame(randomDate)) {
				continueExecution = false;
			}
			else {
				numAttempts++;
			}
		}
		while (numAttempts != Integer.MAX_VALUE && continueExecution);
		
		return numAttempts;
	}

	public String getDayOfWeek(int firstDay) throws DateException {
		if (firstDay < 1 || firstDay > 7) {
			throw new DateException("Date error: " + firstDay + " is not a valid day of the week. It should be a value between 1 and 7 both included.");
		}

		String dayOfTheWeekStr = new String();
		/*
		Hallamos el num de dias desde el principio del año hasta la fecha a calcular.
		al calcular "days" mod 7 nos dira en que posicion del anillo mod 7 esta la fecha.
		Pero como el anillo mod 7 retorna valores de 0 a 6; siendo el 0 la primera posicion, el 1 la segunda, el 2 la tercera, etc
		nos devolvera un numero que esta 1 posicion a la derecha de la real. Por eso le restamos 1 al num de dias, para que al hacer mod 7 nos de la posicion real en el anillo.
		El valor 0 en el anillo mod 7, osea la primera posicion, sera siempre el mismo dia de la semana que el primer dia del anyo.
		*/
		int days = getNumDaysSinceStartYear() - 1;
		// si el anyo es bisiesto y el mes de la fecha es posterior a febrero le sumamos 1 dia
		if (isLeapYear() && (this.month > 2)) {
			days++;
		}
		int dateInRingFormat = days % 7;
		//dateInRingFormat retorna la posicion de la fecha en el anillo mod 7
		/*
		Pueden haber 7 anillos posibles, uno por cada dia de la semana, ya que el primer dia del anyo puede ser cualquiera de estos 7 dias.
		Para hacerlo todo mas sencillo vamos a utilizar el anillo que tiene como primer dia el Lunes, por que ser el mas sencillo, y vamos a calcular las posiciones del resto de anillos en funcion de este anillo base.
		Para ello hallamos el offset de dias entre firstDay, el primer dia del anyo, y el Lunes(1)
		por ejemplo si firstDay es 1, osea Lunes, la diferencia es 0.
		otro ejemplo seria si el primer dia del año es Miercoles, entonces la diferencia de dias entre el miercoles(3) y el Lunes(1) es 2.
		*/
		int ringOffset = firstDay-1;

		//Si el primer dia del anyo es Lunes
		if (firstDay == 1) {
			switch (dateInRingFormat) {
				case 0:
					dayOfTheWeekStr = "Lunes";
					break;
				case 1:
					dayOfTheWeekStr = "Martes";
					break;
				case 2:
					dayOfTheWeekStr = "Miercoles";
					break;
				case 3:
					dayOfTheWeekStr = "Jueves";
					break;
				case 4:
					dayOfTheWeekStr = "Viernes";
					break;
				case 5:
					dayOfTheWeekStr = "Sabado";
					break;
				case 6:
					dayOfTheWeekStr = "Domingo";
					break;
				default:
					break;
			}
		}
		//El resto de anillos que no empiezan en Lunes
		/*
		Es una estructura que se repite. Va del Lunes al Domingo (0-6) y para la posicion siguiente al Domingo vuelve a empezar con lunes otra vez.
		Por lo tanto es basicamente un anillo de 7 elementos, osea que podemos hacer mod 7 a (dateInRingFormat+ringOffset) para no tener que escribir todos los valores posibles de la suma en el switch.
		*/
		else {
			switch ((dateInRingFormat+ringOffset) % 7) {
				case 0:
					dayOfTheWeekStr = "Lunes";
					break;
				case 1:
					dayOfTheWeekStr = "Martes";
					break;
				case 2:
					dayOfTheWeekStr = "Miercoles";
					break;
				case 3:
					dayOfTheWeekStr = "Jueves";
					break;
				case 4:
					dayOfTheWeekStr = "Viernes";
					break;
				case 5:
					dayOfTheWeekStr = "Sabado";
					break;
				case 6:
					dayOfTheWeekStr = "Domingo";
					break;
				/*case 7:
					7 mod 7 = 0. Osea case 0, que es Lunes.
					dayOfTheWeekStr = "Lunes";
					break;
					Y asi sucesivamente
				*/
				default:
					break;
			}
		}
		return dayOfTheWeekStr;
	}

}
