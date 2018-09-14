package com.vic.examples.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.TimeZone;

public class DateApiMain {
    public static void main(String[] args) {
        testLocalDate();
        testLocalTime();
        testLocalDateTime();
        testDuration();
        testPeriod();
        testTemporalAdjusters();
        testTimeZones();
    }

    private static void testLocalDate() {
        System.out.println(" LocalDate");
        LocalDate localDate = LocalDate.of(2018, 8, 24);
        System.out.println(localDate);
        System.out.println(String.format("Year: %s", localDate.getYear()));
        System.out.println("Month: " + localDate.getMonth());
        System.out.println("Day of Month: " + localDate.getDayOfMonth());
        System.out.println("Month value: " + localDate.getMonthValue());
        System.out.println("Length of Month: " + localDate.lengthOfMonth());
        LocalDate now = LocalDate.now();
        System.out.println("Current date:  " + now);
        System.out.println("Date of year: " + now.get(ChronoField.DAY_OF_YEAR));
        LocalDate parseDate = LocalDate.parse("2018-08-24");
        System.out.println("Parsed date: " + parseDate);
        System.out.println("Epoch: " + parseDate.toEpochDay());
        System.out.println("Formatted String: " + now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(" LocalDate");
    }

    private static void testLocalTime() {
        System.out.println(" LocalTime");
        LocalTime time = LocalTime.of(21, 14, 11);
        System.out.println("Time is " + time);
        System.out.println("Current time is " + LocalTime.now());
        LocalTime parsedTime = LocalTime.parse("21:14:11");
        System.out.println("Parsed time: " + parsedTime);
        System.out.println(" LocalTime");
    }

    private static void testLocalDateTime() {
        System.out.println(" LocalDateTime");
        LocalDateTime dateTime = LocalDateTime.of(2018, Month.AUGUST, 13, 1, 3);
        System.out.println(dateTime);
        LocalDateTime now = LocalDateTime.now();
        LocalDate currDate = now.toLocalDate();
        LocalTime currTime = now.toLocalTime();
        System.out.println("Current LocalDate: " + currDate);
        System.out.println("Current LocalTime: " + currTime);
        System.out.println("LocalDateTime from LocalDate and LocalTime: " + LocalDateTime.of(currDate, currTime));
        System.out.println("LocalDateTime from LocalDate + atTime: " + currDate.atTime(0, 11, 11));
        System.out.println("LocalDateTime from LocalDate + atTime2: " + currDate.atTime(currTime));
        System.out.println("LocalDateTime from LocalTime + atDate: " + currTime.atDate(currDate));
        System.out.println(" LocalDateTime");
    }

    private static void testDuration() {
        System.out.println(" Duration");
        Duration between = Duration.between(LocalTime.now(), LocalTime.of(1, 3, 3));
        System.out.println("Between local time: " + between);
        System.out.println("Duration of " + Duration.ofMinutes(3).getSeconds());
        System.out.println(" Duration");
    }

    private static void testPeriod() {
        System.out.println(" Period");
        Period between = Period.between(LocalDate.now(), LocalDate.of(2019, 11, 11));
        System.out.println(between.getMonths());
        System.out.println("Period of 10 days: " + Period.ofDays(10).getDays());
        System.out.println(" Period");
    }

    private static void testTemporalAdjusters() {
        System.out.println(" TemporalAdjusters()");
        LocalDate date = LocalDate.of(2011, 3, 24);
        LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Last day of month: " + lastDayOfMonth);
        System.out.println(" TemporalAdjusters()");
    }

    private static void testTimeZones() {
        System.out.println(" TimeZones");
        LocalDateTime dateTime = LocalDateTime.of(2018, 2, 22, 1, 2);
        ZoneId timeZoneId = TimeZone.getDefault().toZoneId();
        ZonedDateTime zonedDateTime = dateTime.atZone(timeZoneId);
        System.out.println("Zoned Date Time: " + zonedDateTime);
        System.out.println(" TimeZones");
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println("OffsetDateTime: " + utc);
    }
}
