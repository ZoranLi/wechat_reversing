package com.tencent.mm.plugin.fps_lighter.e;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;

public class c {
    private static volatile Integer lQT;

    public static int cd(Context context) {
        int i = 2011;
        int i2 = -1;
        if (lQT == null) {
            synchronized (c.class) {
                if (lQT == null) {
                    long cc = b.cc(context);
                    if (cc == -1) {
                        ArrayList arrayList = new ArrayList();
                        int avN = b.avN();
                        avN = avN <= 0 ? -1 : avN == 1 ? 2008 : avN <= 3 ? 2011 : 2012;
                        c(arrayList, avN);
                        long avO = (long) b.avO();
                        avN = avO == -1 ? -1 : avO <= 528000 ? 2008 : avO <= 620000 ? 2009 : avO <= 1020000 ? 2010 : avO <= 1220000 ? 2011 : avO <= 1520000 ? 2012 : avO <= 2020000 ? 2013 : 2014;
                        c(arrayList, avN);
                        avO = b.cc(context);
                        if (avO <= 0) {
                            i = -1;
                        } else if (avO <= 201326592) {
                            i = 2008;
                        } else if (avO <= 304087040) {
                            i = 2009;
                        } else if (avO <= 536870912) {
                            i = 2010;
                        } else if (avO > 1073741824) {
                            i = avO <= 1610612736 ? 2012 : avO <= 2147483648L ? 2013 : 2014;
                        }
                        c(arrayList, i);
                        if (!arrayList.isEmpty()) {
                            Collections.sort(arrayList);
                            if ((arrayList.size() & 1) == 1) {
                                i2 = ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
                            } else {
                                i = (arrayList.size() / 2) - 1;
                                i2 = ((((Integer) arrayList.get(i + 1)).intValue() - ((Integer) arrayList.get(i)).intValue()) / 2) + ((Integer) arrayList.get(i)).intValue();
                            }
                        }
                    } else {
                        i2 = cc <= 805306368 ? b.avN() <= 1 ? 2009 : 2010 : cc <= 1073741824 ? b.avO() < 1300000 ? 2011 : 2012 : cc <= 1610612736 ? b.avO() < 1800000 ? 2012 : 2013 : cc <= 2147483648L ? 2013 : cc <= 3221225472L ? 2014 : 2015;
                    }
                    lQT = Integer.valueOf(i2);
                }
            }
        }
        return lQT.intValue();
    }

    private static void c(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }
}
