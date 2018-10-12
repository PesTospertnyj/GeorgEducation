package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class DateTimeExample {
    public static void main(String[] args) throws InterruptedException {
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);
        localTime1 = localTime1.plus(50, ChronoUnit.MINUTES);
        System.out.println(localTime1);

        LocalDate localDate1= LocalDate.of(2018,10,10 );
        localDate1 = localDate1.plusYears(10).minus(1, ChronoUnit.MONTHS);
        System.out.println(localDate1);

        LocalDateTime localDateTime1 =LocalDateTime.of(localDate1, localTime1);
        System.out.println(localDateTime1);
        localDateTime1 = localDateTime1.truncatedTo(ChronoUnit.SECONDS);
        System.out.println(localDateTime1);

        ZoneId zoneId1 = ZoneId.of("Europe/Minsk");
        ZoneId zoneId2 = ZoneId.of("Europe/London");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now().withZoneSameInstant(zoneId1);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now().withZoneSameInstant(zoneId2);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime1.isEqual(zonedDateTime2));
        ZonedDateTime zonedDateTime3 = zonedDateTime1.plusHours(1);
        System.out.println(zonedDateTime1.isBefore(zonedDateTime3));
        System.out.println(zonedDateTime1.isAfter(zonedDateTime3));

        ZonedDateTime zonedDateTime4 = ZonedDateTime.now().withZoneSameInstant(ZoneOffset.of("-9"));
        ZonedDateTime zonedDateTime5 = ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0);
        System.out.println(zonedDateTime4);
        System.out.println(zonedDateTime5);

//        ZoneId.getAvailableZoneIds().stream().filter(z->z.contains("urope")).forEach(System.out::println);

        Duration duration = Duration.of(1,ChronoUnit.HOURS);

        duration = duration.plusMinutes(100).plusDays(10000);
        System.out.println("Duration "+duration);

        Period period = Period.of(1,0,0);
        period = period.plusDays(-60);

        System.out.println(period);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());

        Period period1 = Period.between(LocalDate.now(), LocalDate.now().plusMonths(1));
        System.out.println(period1);
        Period period2 = Period.of(0,1,0);

        System.out.println(period2);
        System.out.println(Period.ofWeeks(1).getDays());
        period2.getMonths();

        Instant instant = Instant.now();
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(ZonedDateTime.now().toEpochSecond());
        Thread.sleep(100);
        Instant instant1 = Instant.now();
        System.out.println(instant1.getNano()-instant.getNano());

        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_DATE;
        System.out.println(formatter1.format(zdt));
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy EEEE")
                .withLocale(new Locale("ru"));
        System.out.println(formatter2.format(zdt));

        String dateExample = "12102018202030";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        LocalDateTime zdt1 = LocalDateTime.parse(dateExample, formatter3);
        System.out.println(zdt1);

        TemporalAdjuster adjuster = TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.MONDAY);
        System.out.println(zdt.with(adjuster));









    }
}
