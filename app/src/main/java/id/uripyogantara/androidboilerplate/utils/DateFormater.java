package id.uripyogantara.androidboilerplate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
    public  static String format(String oldDate){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(oldDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("dd MMMM yyyy").format(date);
    }


    public static String dateValidation(int value){
        if (value<10){
            return "0"+value;
        }
        return String.valueOf(value);
    }

}
