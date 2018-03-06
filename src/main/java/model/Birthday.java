package model;

import exceptions.InvalidBirthdayException;

import java.io.Serializable;
import java.util.Calendar;

public class Birthday implements Serializable {
	private static final long serialVersionUID = 1L;

	private int day;
	private int month;
	private int year;
	
	public Birthday() {}
	
	public Birthday(int day, int month, int year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}

	public Birthday(String date) {
        String[] birthday = date.split("/");
        System.out.println(birthday[0]);
        System.out.println(birthday[1]);
        System.out.println(birthday[2]);

        if (birthday.length != 3){
            throw new InvalidBirthdayException("Invalid birthday format!!");
        }


        try {
            month = Integer.parseInt(birthday[0].trim());
            day = Integer.parseInt(birthday[1].trim());
            year = Integer.parseInt(birthday[2].trim());

            if (day <= 0 || day > 31) {
                System.out.println("Day");
                throw new InvalidBirthdayException("Invalid day");
            }


            if (month <= 0 || month > 12) {
                System.out.println("Month");
                throw new InvalidBirthdayException("Invalid month");
            }


            if (year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)) {
                throw new InvalidBirthdayException("Invalid year");
            }

        }
        catch (NumberFormatException e) {
            throw new InvalidBirthdayException("Invalid birthday format");
        }
    }


    /**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Birthday: " + this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
	}

}
