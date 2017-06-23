package com.scottlv;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.dto.Location;

public class CrowthorneSun 
{
    public static void main( String[] args )
    {
        // Set location to Crowthorne
        Location location = new Location("51.377580", "-0.806787");
        
        // Set timezone to London
        SunriseSunsetCalculator calculator = new SunriseSunsetCalculator(location, "Europe/London");

        // Get sunrise/sunset times for today
        Calendar today = Calendar.getInstance();
        String officialSunrise = calculator.getOfficialSunriseForDate(today);
        String officialSunset = calculator.getOfficialSunsetForDate(today);
        
        // Convert date/time to a printable date
        Date date = today.getTime();             
        SimpleDateFormat myDateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");          
        String todayDate = myDateFormat.format(date);
        
        System.out.println("Sunrise for Crowthorne on " + todayDate + " is at " + officialSunrise);
        System.out.println("Sunset for Crowthorne on " + todayDate + " is at " + officialSunset);
        
        
        // Get sunrise/sunset times for 1 weeks time
        Calendar nextWeek = today;
        nextWeek.add(Calendar.DATE, 7); 

        officialSunrise = calculator.getOfficialSunriseForDate(nextWeek);
        officialSunset = calculator.getOfficialSunsetForDate(nextWeek);

        // Convert date/time to a printable date
        date = nextWeek.getTime();             
        String nextWeekDate = myDateFormat.format(date);
        
        System.out.println();
        System.out.println("Sunrise for Crowthorne on " + nextWeekDate + " is at " + officialSunrise);
        System.out.println("Sunset for Crowthorne on " + nextWeekDate + " is at " + officialSunset);
        
    }
}
