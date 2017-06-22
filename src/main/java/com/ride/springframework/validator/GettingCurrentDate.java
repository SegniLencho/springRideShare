package com.ride.springframework.validator;

/**
 * Created by OD on 6/22/2017.
 */
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GettingCurrentDate {
    public static void main(String[] args) {
        //getting current date and time using Date class
//
//        System.out.println(df.format(dateobj));

       /*getting current date time using calendar class
        * An Alternative of above*/
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Calendar calobj = Calendar.getInstance();
        System.out.println(df.format(calobj.getTime()));
    }
}