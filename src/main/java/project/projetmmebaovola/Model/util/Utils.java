package project.projetmmebaovola.Model.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Utils {

    public static Date stringToDate(String dateString) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        java.util.Date utilDate = sdf.parse(dateString);
        return new Date(utilDate.getTime());
    }
    public static LocalDate convertToLocalDate(String dateString) {
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }
    public static LocalTime convertToTime(String timeString) {
        String pattern = "HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalTime DL;
        try{
           DL= LocalTime.parse(timeString, formatter);
        }catch (Exception e){
            DL= LocalTime.parse(timeString+":00", formatter);
        }
        return DL;
    }
    public static LocalTime addMinuteHour(LocalTime time, int minutes ){
        long totalSeconds = (long) (minutes * 60L);
        LocalTime finalTime = time.plus(totalSeconds, ChronoUnit.SECONDS);
        return finalTime;
    }

    public static LocalDateTime convertToDateTime(String timeString) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime DL;
        try{
            DL= LocalDateTime.parse(timeString, formatter);
        }catch (Exception e){
            DL= LocalDateTime.parse(timeString+":00", formatter);
        }
        return DL;
    }

    public static int differenceInYears(LocalDate startDate, LocalDate endDate) {
        // Calcul de la différence en années
        Period period = Period.between(startDate, endDate);

        // Récupération de la différence en années
        int years = period.getYears();

        return years;
    }


    public static void main(String[] args) throws ParseException {
        String dateString = "2023-12-11 09:30";
        String timeString = "09:30";
//        System.out.println("LD "+convertToLocalDate(dateString));
//        System.out.println("SD "+stringToDate(dateString));
//        System.out.println("ST "+convertToTime(timeString));
        System.out.println("LDT "+convertToDateTime(dateString));
        LocalTime initialTime = LocalTime.parse("12:00:00");
        int minutesAndSeconds = 52;
        long totalSeconds = (long) (minutesAndSeconds * 60);
        LocalTime finalTime = initialTime.plus(totalSeconds, ChronoUnit.SECONDS);
        System.out.println(finalTime);

        LocalDate localDate= convertToLocalDate("2023-12-11");
        LocalDate localDate2= convertToLocalDate("2024-12-11");
        System.out.println(differenceInYears(localDate,localDate2));

    }
}
