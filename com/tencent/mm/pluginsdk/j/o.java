package com.tencent.mm.pluginsdk.j;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class o {
    private static final Locale sEU = v.Po(v.bIN());
    private static final boolean sEV = v.bIK();

    public static String Z(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(1000 * j));
    }

    public static String M(Context context, int i) {
        long j = 1000 * ((long) i);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return p(context, timeInMillis) + ";" + aa(context.getString(g.kEp), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(g.elH) + " " + p(context, timeInMillis) + ";" + aa(context.getString(g.kEp), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(g.kEs) + " " + p(context, timeInMillis) + ";" + aa(context.getString(g.kEp), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(g.kEA) + " " + p(context, timeInMillis) + ";" + aa(context.getString(g.kEp), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(g.kEr) + " " + p(context, timeInMillis) + ";" + aa(context.getString(g.kEp), j);
        }
        gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        int i2 = gregorianCalendar2.get(11);
        int i3;
        StringBuilder stringBuilder;
        String string;
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) == gregorianCalendar2.get(3)) {
            i3 = gregorianCalendar2.get(7);
            stringBuilder = new StringBuilder();
            switch (i3) {
                case 1:
                    string = context.getString(g.kEE);
                    break;
                case 2:
                    string = context.getString(g.kEC);
                    break;
                case 3:
                    string = context.getString(g.kEG);
                    break;
                case 4:
                    string = context.getString(g.kEH);
                    break;
                case 5:
                    string = context.getString(g.kEF);
                    break;
                case 6:
                    string = context.getString(g.kEB);
                    break;
                case 7:
                    string = context.getString(g.kED);
                    break;
                default:
                    string = "";
                    break;
            }
            return stringBuilder.append(string).append(" ").append(N(context, i2)).append(";").append(aa(context.getString(g.kEp), j)).toString();
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar2.get(3)) {
            i3 = gregorianCalendar2.get(7);
            stringBuilder = new StringBuilder();
            switch (i3) {
                case 1:
                    string = context.getString(g.kEw);
                    break;
                case 2:
                    string = context.getString(g.kEu);
                    break;
                case 3:
                    string = context.getString(g.kEy);
                    break;
                case 4:
                    string = context.getString(g.kEz);
                    break;
                case 5:
                    string = context.getString(g.kEx);
                    break;
                case 6:
                    string = context.getString(g.kEt);
                    break;
                case 7:
                    string = context.getString(g.kEv);
                    break;
                default:
                    string = "";
                    break;
            }
            return stringBuilder.append(string).append(" ").append(N(context, i2)).append(";").append(aa(context.getString(g.kEp), j)).toString();
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return DateFormat.format(context.getString(g.elp), j) + " " + N(context, i2) + ";" + aa(context.getString(g.kEp), j);
        } else {
            return DateFormat.format(context.getString(g.elz), j) + " " + N(context, i2) + ";" + aa(context.getString(g.kEp), j);
        }
    }

    public static String aa(String str, long j) {
        String charSequence = DateFormat.format(str, j).toString();
        if (bg.mA(charSequence)) {
            return "";
        }
        charSequence = charSequence.trim();
        if (charSequence.startsWith("0")) {
            return charSequence.substring(1);
        }
        return charSequence;
    }

    public static CharSequence n(Context context, long j) {
        return context.getString(g.kEJ) + DateFormat.format(context.getString(g.kEI), j);
    }

    public static CharSequence o(Context context, long j) {
        return context.getString(g.kEK) + DateFormat.format(context.getString(g.kEI), j);
    }

    private static CharSequence N(Context context, int i) {
        if (i < 0) {
            return "";
        }
        if (((long) i) < 6) {
            return context.getString(g.kEk);
        }
        if (((long) i) < 12) {
            return context.getString(g.kEn);
        }
        if (((long) i) < 13) {
            return context.getString(g.kEo);
        }
        if (((long) i) < 18) {
            return context.getString(g.kEj);
        }
        return context.getString(g.kEl);
    }

    public static CharSequence p(Context context, long j) {
        if (j < 0) {
            return "";
        }
        if (j < 21600000) {
            return context.getString(g.kEk);
        }
        if (j < 43200000) {
            return context.getString(g.kEn);
        }
        if (j < 46800000) {
            return context.getString(g.kEo);
        }
        if (j < 64800000) {
            return context.getString(g.kEj);
        }
        return context.getString(g.kEl);
    }

    public static CharSequence c(Context context, long j, boolean z) {
        CharSequence charSequence;
        if (!sEV) {
            Locale locale = sEU;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                return "";
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
                    return z ? context.getString(g.elH) : context.getString(g.elH) + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                } else {
                    gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(j);
                    if (gregorianCalendar.get(1) != gregorianCalendar2.get(1) || gregorianCalendar.get(3) != gregorianCalendar2.get(3)) {
                        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) ? z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j)) : z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j));
                    } else {
                        charSequence = new SimpleDateFormat("E", locale).format(Long.valueOf(j));
                        if (z) {
                            return charSequence;
                        }
                        return charSequence + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                    }
                }
            }
            return java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
        } else if (j < 3600000) {
            return "";
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                if (DateFormat.is24HourFormat(ab.getContext())) {
                    return n.a(context.getString(g.elE), time);
                }
                return N(context, time.hour) + n.a(context.getString(g.kEp), time);
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                boolean is24HourFormat = DateFormat.is24HourFormat(ab.getContext());
                if (z) {
                    return context.getString(g.elH);
                }
                Object a;
                StringBuilder append = new StringBuilder().append(context.getString(g.elH)).append(" ");
                if (is24HourFormat) {
                    a = n.a(context.getString(g.elE), time);
                } else {
                    a = N(context, time.hour) + n.a(context.getString(g.kEp), time);
                }
                return append.append(a).toString();
            } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                charSequence = n.a("E ", time);
                if (z) {
                    return charSequence;
                }
                return charSequence + n.a(context.getString(g.kEq), time);
            } else if (time.year == time2.year) {
                if (z) {
                    return n.a(context.getString(g.elp), time);
                }
                return n.a(context.getString(g.elq, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            } else if (z) {
                return n.a(context.getString(g.elz), time);
            } else {
                return n.a(context.getString(g.kEm, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            }
        }
    }
}
