package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.mm.s.a.k;
import java.util.Calendar;
import java.util.Date;

public class a {
    private static a wiL;
    private long wiI = Calendar.getInstance().getTimeInMillis();
    private long wiJ;
    private long wiK;

    public static a bZj() {
        if (wiL == null) {
            synchronized (a.class) {
                wiL = new a();
            }
        }
        return wiL;
    }

    private a() {
        Calendar instance = Calendar.getInstance();
        instance.set(7, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.wiJ = instance.getTimeInMillis();
        instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.wiK = instance.getTimeInMillis();
    }

    public final long a(Date date) {
        if (date.getTime() >= this.wiJ) {
            return Long.MAX_VALUE;
        }
        if (date.getTime() >= this.wiK) {
            return 9223372036854775806L;
        }
        return (long) ((date.getYear() * 100) + date.getMonth());
    }

    public static long eX(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public final String a(Date date, Context context) {
        if (date.getTime() >= this.wiJ) {
            return context.getString(k.hfs);
        }
        if (date.getTime() >= this.wiK) {
            return context.getString(k.hfr);
        }
        return String.format("%d/%d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1)});
    }
}
