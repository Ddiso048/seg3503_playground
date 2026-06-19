public class Date {

  /* Data fields */
  private int year;
  private int month;
  private int day;

  /* String correspondent used for displaying months */
  String[] monthNames = {
    "January", "February", "March",
    "April", "May", "June",
    "July", "August", "September",
    "October", "November", "December"
  };

  public Date(int year, int month, int day) {
    setYear(year);
    setMonth(month);
    setDay(day);
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  private void setDay(int day) {
    int maximumDay = daysInMonth();
    if (day < 1 || day > maximumDay) {
      throw new IllegalArgumentException(
        "day must be between 1 and " + maximumDay + " for month " + monthNames[month - 1] + "."
      );
    }
    this.day = day;
  }

  private void setMonth(int month) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("month must be between 1 and 12.");
    }
    this.month = month;
  }

  private void setYear(int year) {
    if (year < 0) {
      throw new IllegalArgumentException("year must be greater or equal to 0.");
    }
    this.year = year;
  }

  public Date nextDate() {
    int nextYear = year;
    int nextMonth = month;
    int nextDay = day + 1;

    if (isEndOfMonth()) {
      nextDay = 1;
      if (month == 12) {
        nextYear++;
        nextMonth = 1;
      } else {
        nextMonth++;
      }
    }
    return new Date(nextYear, nextMonth, nextDay);
  }

  private boolean isEndOfMonth() {
    return day == daysInMonth();
  }

  private int daysInMonth() {
    if (month == 2) {
      return isLeapYear() ? 29 : 28;
    }
    return isThirtyDayMonth() ? 30 : 31;
  }

  private boolean isThirtyDayMonth() {
    return month == 4 || month == 6 || month == 9 || month == 11;
  }

  public boolean isLeapYear() {
    if (year % 100 == 0) {
      return year % 400 == 0;
    }
    return year % 4 == 0;
  }

  public String toString() {
    return year + "/" + monthNames[month - 1] + "/" + day;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Date)) {
      return false;
    }
    Date od = (Date) obj;
    return year == od.getYear() && month == od.getMonth() && day == od.getDay();
  }
}
