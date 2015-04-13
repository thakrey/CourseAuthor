package com.lrn.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class DateUtil
    implements Constants
{

    public DateUtil()
    {
    }

    public static Date toSqlDate(String string)
    {
        Date sqlDate = null;
        java.util.Date utilDate = null;
              
        if(string == null || string.trim().length() <= 0)
            return sqlDate;
        try
        {
            utilDate = df2.parse(string);
        }
        catch(Exception e){
            try
            {
                utilDate = df.parse(string);
            }
            catch(Exception ee)
            {
                try
                {
                    utilDate = DateParser.parse(string);
                }
                catch(Exception eee)
                {
                    return null;
                }
            }
        }
        sqlDate = new Date(utilDate.getTime());
        return sqlDate;
    }

    public static java.util.Date toUtilDate(String string)
    {
        java.util.Date utilDate = null;
        if(string == null || string.trim().length() <= 0)
            return utilDate;
        try
        {
            utilDate = df1.parse(string);
        }
        catch(Exception e)
        {
            try
            {
                utilDate = df2.parse(string);
            }
            catch(Exception ee)
            {
                try
                {
                    utilDate = df.parse(string);
                }
                catch(Exception eee)
                {
                    try
                    {
                        utilDate = DateParser.parse(string);
                    }
                    catch(Exception eeee)
                    {
                        return null;
                    }
                }
            }
        }
        return utilDate;
    }

    public static String toString(Date sqlDate)
    {
        String dateAsString = "";
        if(sqlDate == null)
        {
            return dateAsString;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sqlDate);
        boolean isShortFormat = true;
        isShortFormat = (calendar.get(11) == 0 || calendar.get(11) == 24) && (calendar.get(12) == 0 || calendar.get(12) == 60) && (calendar.get(13) == 0 || calendar.get(13) == 60) && (calendar.get(14) == 0 || calendar.get(13) == 1000);
        if(isShortFormat)
        {
            dateAsString = df.format(sqlDate);
        } else
        {
            dateAsString = df1.format(sqlDate);
        }
        return dateAsString;
    }

    public static String toString(java.util.Date date)
    {
        String dateAsString = "";
        if(date == null)
        {
            return dateAsString;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        boolean isShortFormat = true;
        isShortFormat = (calendar.get(11) == 0 || calendar.get(11) == 24) && (calendar.get(12) == 0 || calendar.get(12) == 60) && (calendar.get(13) == 0 || calendar.get(13) == 60) && (calendar.get(14) == 0 || calendar.get(13) == 1000);
        if(isShortFormat)
        {
            dateAsString = df.format(date);
        } else
        {
            dateAsString = df1.format(date);
        }
        return dateAsString;
    }

    public static String toString(Timestamp timestamp)
    {
        String dateAsString = "";
        if(timestamp == null)
        {
            return dateAsString;
        } else
        {
            dateAsString = df1.format(timestamp);
            return dateAsString;
        }
    }

    private static final DateFormat df = new SimpleDateFormat("ddMMMyyyy");
    private static final DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
}
