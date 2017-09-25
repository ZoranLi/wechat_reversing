package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.R;
import java.util.GregorianCalendar;

public final class u {
    public static CharSequence s(Context context, int i) {
        if (i <= 0) {
            return context.getString(R.l.ejo, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
        }
        int i2 = i / 60;
        int i3 = i % 60;
        return context.getString(R.l.ejo, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static CharSequence e(Context context, long j) {
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return context.getString(R.l.elG);
        }
        long timeInMillis2 = gregorianCalendar2.getTimeInMillis() - j;
        if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
            return context.getString(R.l.elH);
        }
        new GregorianCalendar().setTimeInMillis(j);
        int timeInMillis3 = (int) ((gregorianCalendar.getTimeInMillis() - j) / 86400000);
        if (timeInMillis3 <= 0) {
            timeInMillis3 = 1;
        }
        if (timeInMillis3 > 30) {
            return DateFormat.format(context.getString(R.l.eiG), j);
        }
        return context.getResources().getQuantityString(R.j.dso, timeInMillis3, new Object[]{Integer.valueOf(timeInMillis3)});
    }
}
