package com.rep.java8data;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PeriodAndDurationMain {
    public static void main(String[] args) {
        /**
         * 设置时间
         */
        ZoneId usCentral = ZoneId.of("America/Chicago"); // 设置时区
        LocalDateTime ldt = LocalDateTime.of(2019, Month.MARCH, 10, 7, 30); // 设置local时间
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt, usCentral); // 时区时间
        Period p1 = Period.ofDays(1); // 加一天 日期差类
        Duration d1 = Duration.ofHours(24); // 加24小时 时间差类
        System.out.println(displayDuration(d1));

        // Add a period of 1 day and a duration of 24 hours
        ZonedDateTime zdt2 = zdt1.plus(p1);
        ZonedDateTime zdt3 = zdt1.plus(d1);

        System.out.println("Start Datetime: " + zdt1);
        System.out.println("After 1 Day period: " + zdt2);
        System.out.println("After 24 Hours duration: " + zdt3);

        /**
         * 时间差
         */
        LocalDate ld1 = LocalDate.of(2019, Month.JANUARY, 7);
        LocalDate ld2 = LocalDate.of(2019, Month.MAY, 18);
        long days = ChronoUnit.DAYS.between(ld1, ld2); // java.time.temporal.ChronoUnit 的between方法获取时间差值
        /* from w w w .j a va 2 s . c om */
        LocalTime lt1 = LocalTime.of(7, 0);
        LocalTime lt2 = LocalTime.of(9, 30);
        long hours = ChronoUnit.HOURS.between(lt1, lt2);
        long minutes = ChronoUnit.MINUTES.between(lt1, lt2);

        System.out.println("Using between (days): " + days);
        System.out.println("Using between (hours): " + hours);
        System.out.println("Using between (minutes): " + minutes);

        // Using the until() method
        long days2 = ld1.until(ld2, ChronoUnit.DAYS); // ld lt 自带的until的方法获取时间差值
        long hours2 = lt1.until(lt2, ChronoUnit.HOURS);
        long minutes2 = lt1.until(lt2, ChronoUnit.MINUTES);

        System.out.println("Using until (days): " + days2);
        System.out.println("Using until (hours): " + hours2);
        System.out.println("Using until (minutes): " + minutes2);

        System.out.println(getAge(LocalDate.of(1991, 10, 3)));

        LocalDateTime.now(Clock.systemUTC());
    } // w w w . ja v a2 s. c om

    public static long getAge(LocalDate date) {
        return ChronoUnit.YEARS.between(date, LocalDate.now());
    }

    public static String displayDuration(Duration tempsCourse) {
        return String.valueOf(tempsCourse.toHours() + "h") + String.valueOf(tempsCourse.toMinutes() % 60);
    }
}