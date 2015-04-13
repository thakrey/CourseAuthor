package com.lrn.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateParser
{

    public DateParser()
    {
    }

    public static long UTC(int year, int month, int date, int hrs, int min, int sec)
    {
        Calendar cal = new GregorianCalendar();
        cal.set(1, year + 1900);
        cal.set(2, month);
        cal.set(5, date);
        cal.set(11, hrs);
        cal.set(12, min);
        cal.set(13, sec);
        cal.set(14, 0);
        return cal.getTime().getTime();
    }

    public static Date parse(String s)
    {
        return parse(s, new GregorianCalendar());
    }

    public static Date parse(String s, GregorianCalendar cal)
    {
label0:
        {
            int year = -1;
            int mon = -1;
            int mday = -1;
            int hour = -1;
            int min = -1;
            int sec = -1;
           // int millis = -1;
            int c = -1;
            int i = 0;
            int n = -1;
          //  int wst = -1;
            int tzoffset = -1;
            int prevc = 0;
            cal.setTime(new Date());
            if(s == null)
                break label0;
            int limit = s.length();
            while(i < limit) 
            {
                c = s.charAt(i);
                i++;
                if(c <= 32 || c == 44)
                    continue;
                if(c == 40)
                {
                    int depth = 1;
                    while(i < limit) 
                    {
                        c = s.charAt(i);
                        i++;
                        if(c == 40)
                        {
                            depth++;
                            continue;
                        }
                        if(c == 41 && --depth <= 0)
                            break;
                    }
                    continue;
                }
                if(48 <= c && c <= 57)
                {
                    n = c - 48;
                    for(; i < limit && '0' <= (c = s.charAt(i)) && c <= 57; i++)
                        n = (n * 10 + c) - 48;

                    if(prevc == 43 || prevc == 45 && year >= 0)
                    {
                        if(n < 24)
                            n *= 60;
                        else
                            n = n % 100 + (n / 100) * 60;
                        if(prevc == 43)
                            n = -n;
                        if(tzoffset != 0 && tzoffset != -1)
                            break label0;
                        tzoffset = n;
                    } else
                    if(n >= 70)
                    {
                        if(year >= 0 || c > 32 && c != 44 && c != 47 && i < limit)
                            break label0;
                        year = n >= 1900 ? n - 1900 : n;
                    } else
                    if(c == 58)
                    {
                        if(hour < 0)
                        {
                            hour = (byte)n;
                        } else
                        {
                            if(min >= 0)
                                break label0;
                            min = (byte)n;
                        }
                    } else
                    if(c == 47)
                    {
                        if(mon < 0)
                        {
                            mon = (byte)(n - 1);
                        } else
                        {
                            if(mday >= 0)
                                break label0;
                            mday = (byte)n;
                        }
                    } else
                    {
                        if(i < limit && c != 44 && c > 32 && c != 45)
                            break label0;
                        if(hour >= 0 && min < 0)
                            min = (byte)n;
                        else
                        if(min >= 0 && sec < 0)
                        {
                            sec = (byte)n;
                        } else
                        {
                            if(mday >= 0)
                                break label0;
                            mday = (byte)n;
                        }
                    }
                    prevc = 0;
                    continue;
                }
                if(c == 47 || c == 58 || c == 43 || c == 45)
                {
                    prevc = c;
                    continue;
                }
                int st = i - 1;
                for(; i < limit; i++)
                {
                    c = s.charAt(i);
                    if((65 > c || c > 90) && (97 > c || c > 122))
                        break;
                }

                if(i <= st + 1)
                    break label0;
                int k;
                for(k = wtb.length; --k >= 0;)
                    if(wtb[k].regionMatches(true, 0, s, st, i - st))
                    {
                        int action = ttb[k];
                        if(action == 0)
                            break;
                        if(action == 1)
                        {
                            if(hour <= 12 && hour >= 1)
                            {
                                if(hour < 12)
                                    hour += 12;
                                break;
                            }
                        } else
                        if(action == 14)
                        {
                            if(hour <= 12 && hour >= 1)
                            {
                                if(hour == 12)
                                    hour = 0;
                                break;
                            }
                        } else
                        if(action <= 13)
                        {
                            if(mon < 0)
                            {
                                mon = (byte)(action - 2);
                                break;
                            }
                        } else
                        {
                            tzoffset = action - 10000;
                            break;
                        }
                        break label0;
                    }

                if(k < 0)
                    break label0;
                prevc = 0;
            }
            if(year < 0)
                year = cal.get(1) - 1900;
            if(mon < 0)
                mon = cal.get(2);
            if(mday < 0)
                mday = cal.get(5);
            if(sec < 0)
                sec = 0;
            if(min < 0)
                min = 0;
            if(hour < 0)
                hour = 0;
            if(tzoffset == -1)
                return parse(year, mon, mday, hour, min, sec);
            else
                return new Date(UTC(year, mon, mday, hour, min, sec) + (long)(tzoffset * 60000));
        }
        throw new IllegalArgumentException();
    }

    public static Date parse(int year, int month, int date, int hrs, int min, int sec)
    {
        GregorianCalendar cal = new GregorianCalendar(year + 1900, month, date, hrs, min, sec);
        cal.get(0);
        return cal.getTime();
    }

    public static Date parse(int year, int month, int date, int hrs, int min)
    {
        return parse(year, month, date, hrs, min, 0);
    }

    public static long parseTime(String time)
    {
        try
        {
            int i = time.indexOf(':');
            if(i == -1)
                return 0L;
            int j = time.indexOf(':', i + 1);
            if(j == -1)
                return 0L;
            else
                return (long)((Integer.parseInt(time.substring(i - 2, i)) * 60 * 60 + Integer.parseInt(time.substring(i + 1, j)) * 60 + Integer.parseInt(time.substring(j + 1))) * 1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0L;
    }

    public static Date nextDate(long delay)
    {
        long l = ((System.currentTimeMillis() / dayMillis) * dayMillis + dayMillis) - (long)tz.getRawOffset();
        if(tz.inDaylightTime(new Date()))
            l -= 0x36ee80L;
        return new Date(l + delay);
    }

    public static Date startOf(int year, int month, int date)
    {
        return parse(year, month, date, 0, 0, 0);
    }

    public static Date startOf(Date d)
    {
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        return parse(gc.get(1) - 1900, gc.get(2), gc.get(5), 0, 0, 0);
    }

    public static Date endOf(int year, int month, int date)
    {
        return parse(year, month, date, 23, 59, 59);
    }

    public static Date endOf(Date d)
    {
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        return parse(gc.get(1) - 1900, gc.get(2), gc.get(5), 23, 59, 59);
    }

    public static long parseDelay(String s)
    {
        Date d = parse(s);
        Date d2 = parse("00:00:00");
        return d.getTime() - d2.getTime();
    }

    public static boolean isToday(Date inp)
    {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(new Date());
        cal2.setTime(inp);
        return cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
    }

    public static String GMTTime()
    {
        return GMTTime(new Date());
    }

    public static String GMTTime(Date d)
    {
        try
        {
            DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
            return formatter.format(d);
        }
        catch(Throwable e)
        {
            return "???";
        }
    }

    public static Date toGMT(Date d)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        long offset = cal.getTimeZone().getOffset(cal.get(0), cal.get(1), cal.get(2), cal.get(5), cal.get(7), 0);
        return new Date(d.getTime() + offset);
    }

    public static long toGMT(long longDate)
    {
        return toGMT(new Date(longDate)).getTime();
    }

    public static String DateToString(long i)
    {
        return i > 0L ? DateToString(new Date(i)) : "Never";
    }

    public static String DateToString(Date d)
    {
        try
        {
            DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm z");
            formatter.setTimeZone(TimeZone.getDefault());
            return formatter.format(d);
        }
        catch(Throwable e)
        {
            return "???";
        }
    }

    public static String DateToRFC822Date(Date d)
    {
        try
        {
            GregorianCalendar cal = new GregorianCalendar();
            TimeZone tz = GregorianCalendar.getInstance().getTimeZone();
            boolean isDayLightSavings = tz.inDaylightTime(d);
            String retTZ = "";
            DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ");
            retTZ = cal.getTimeZone().getDisplayName(isDayLightSavings, 0, Locale.getDefault());
            if(retTZ.indexOf(":") != -1)
            {
                retTZ = retTZ.substring(0, retTZ.indexOf("GMT")) + retTZ.substring(retTZ.indexOf("GMT") + 3);
                retTZ = retTZ.substring(0, retTZ.indexOf(":")) + retTZ.substring(retTZ.indexOf(":") + 1);
            }
            return formatter.format(d) + retTZ;
        }
        catch(Throwable e)
        {
            return "???";
        }
    }

    public static String DateFormatToString(String format)
    {
        DateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(TimeZone.getDefault());
        return formatter.format(new Date());
    }

    public static String DateFormatToString(String format, Date d)
    {
        try
        {
            DateFormat formatter = new SimpleDateFormat(format);
            formatter.setTimeZone(TimeZone.getDefault());
            return formatter.format(d);
        }
        catch(Throwable e)
        {
            return "???";
        }
    }

    public static Date StringToDate(String s)
    {
        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm z");
        formatter.setTimeZone(TimeZone.getDefault());
        try
        {
            return formatter.parse(s);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    public static String DateToSmallString(long time, boolean html)
    {
        Date d = new Date(time);
        Date now = new Date();
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getDefault());
        DateFormat formatter = null;
        cal.setTime(d);
        int year = cal.get(1);
        cal.setTime(now);
        try
        {
            if(year == cal.get(1))
                formatter = new SimpleDateFormat("dd MMM HH:mm");
            else
                formatter = new SimpleDateFormat("dd MMM yyyy HH:mm");
            formatter.setTimeZone(TimeZone.getDefault());
            if(html)
                return "<NOBR>" + StringUtils.replace(formatter.format(d), " ", "&nbsp;") + "</NOBR>";
            else
                return formatter.format(d);
        }
        catch(Throwable e)
        {
            return "???";
        }
    }

    public static String DateToSmallerString(long time, boolean html, boolean hour)
    {
        Date d = new Date(time);
        Date now = new Date();
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getDefault());
        DateFormat formatter = null;
        cal.setTime(d);
       // int year = cal.get(1);
        cal.setTime(now);
        try
        {
            formatter = new SimpleDateFormat(hour ? "dd MMM HH:00" : "dd MMM");
            formatter.setTimeZone(TimeZone.getDefault());
            if(html)
                return "<NOBR>" + StringUtils.replace(formatter.format(d), " ", "&nbsp;") + "</NOBR>";
            else
                return formatter.format(d);
        }
        catch(Throwable e)
        {
            return "???";
        }
    }

    public static String parseToTime(String s)
    {
        return parseToTime(Integer.parseInt(s));
    }

    public static String parseToTime(int val)
    {
        StringBuffer sb = new StringBuffer();
        int da = val / 0x15180;
        val -= da * 3600 * 24;
        int hr = val / 3600;
        val -= hr * 3600;
        int mn = val / 60;
        val -= mn * 60;
        int se = val;
        if(da > 0)
        {
            if(da < 10)
                sb.append("0");
            sb.append(da + ":");
        }
        if(hr < 10)
            sb.append("0");
        sb.append(hr).append(":");
        if(mn < 10)
            sb.append("0");
        sb.append(mn).append(":");
        if(se < 10)
            sb.append("0");
        sb.append(se);
        return sb.toString();
    }

    public static String expandArchiveSpec(String spec, int count)
    {
        StringBuffer filename = new StringBuffer();
        boolean escape = false;
        for(int i = 0; i < spec.length(); i++)
        {
            char ch;
            switch(ch = spec.charAt(i))
            {
            case 37: // '%'
                if(i + 1 < spec.length())
                {
                    if(spec.charAt(i + 1) != '%')
                    {
                        escape = true;
                    } else
                    {
                        filename.append(ch);
                        i++;
                    }
                } else
                {
                    filename.append(ch);
                }
                break;

            case 99: // 'c'
                if(escape)
                {
                    filename.append(count);
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 109: // 'm'
                if(escape)
                {
                    filename.append(DateFormatToString("MM"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 77: // 'M'
                if(escape)
                {
                    filename.append(DateFormatToString("MMMM"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 100: // 'd'
                if(escape)
                {
                    filename.append(DateFormatToString("dd"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 68: // 'D'
                if(escape)
                {
                    filename.append(DateFormatToString("DDD"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 69: // 'E'
                if(escape)
                {
                    filename.append(DateFormatToString("EEE"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 119: // 'w'
                if(escape)
                {
                    filename.append(DateFormatToString("ww"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 87: // 'W'
                if(escape)
                {
                    filename.append(DateFormatToString("W"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 121: // 'y'
                if(escape)
                {
                    filename.append(DateFormatToString("yy"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            case 89: // 'Y'
                if(escape)
                {
                    filename.append(DateFormatToString("yyyy"));
                    escape = false;
                } else
                {
                    filename.append(ch);
                }
                break;

            default:
                filename.append(ch);
                break;
            }
        }

        return filename.toString();
    }

    public static String RFC822Date()
    {
        return DateToRFC822Date(new Date());
    }

    private static TimeZone tz = TimeZone.getDefault();
    private static long dayMillis = 0x5265c00L;
    private static final String wtb[] = {
        "am", "pm", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "january", 
        "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", 
        "december", "gmt", "ut", "utc", "est", "edt", "cst", "cdt", "mst", "mdt", 
        "pst", "pdt"
    };
    /*
    private static final String monthNames[] = {
        "january"
    };*/
    private static final int ttb[] = {
        14, 1, 0, 0, 0, 0, 0, 0, 0, 2, 
        3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 
        13, 10000, 10000, 10000, 10300, 10240, 10360, 10300, 10420, 10360, 
        10480, 10420
    };
    public static final long oneHour = 0x36ee80L;
    public static final long oneDay = 0x5265c00L;
    public static final long oneWeek = 0x240c8400L;
    public static final long oneYear = parse("1971, Jan 1 00:00:00").getTime();

}