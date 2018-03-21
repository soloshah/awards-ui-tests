package com.nhsbsa.finance.shared;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class SharedMethods {

	public static String formatDay(LocalDate localDate) {
		DecimalFormat df = new DecimalFormat("00");
		return String.valueOf(df.format(localDate.getDayOfMonth()));
	}

	public static String formatMonth(LocalDate localDate) {
		DecimalFormat df = new DecimalFormat("00");
		return String.valueOf(df.format(localDate.getMonthValue()));

	}

	public static String formatYear(LocalDate localDate) {
		return String.valueOf(localDate.getYear());
	}

	public static String randomDateGenerator() {

		LocalDate from = LocalDate.of(1900, 01, 01);
		LocalDate to = LocalDate.of(2002, 01, 01);
		long days = from.until(to, ChronoUnit.DAYS);
		long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
		LocalDate randomDate = from.plusDays(randomDays);
		return randomDate.toString();
	}
}
