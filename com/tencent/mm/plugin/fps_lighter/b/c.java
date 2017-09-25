package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class c implements Serializable {
    public static HashMap<String, Integer> lPO;
    public float lPG = 60.0f;
    public float lPH = 16.666668f;
    public final long lPI = 8000;
    public final long lPJ = 120000;
    boolean lPK = false;
    boolean lPL = false;
    boolean lPM = false;
    public int lPN = 3;
    public String lPP = "FRAGMENT_UNKNOW";
    String lPQ;
    int lPR = 100;

    protected c() {
        int cd = com.tencent.mm.plugin.fps_lighter.e.c.cd(ab.getContext());
        if (cd >= 2015) {
            this.lPN = 0;
        } else if (cd >= 2013) {
            this.lPN = 1;
        } else if (cd > 2010) {
            this.lPN = 2;
        } else {
            this.lPN = 3;
        }
    }

    public static long avF() {
        return 120000;
    }

    public static long avG() {
        return TimeUnit.NANOSECONDS.convert(8000, TimeUnit.MILLISECONDS);
    }

    static {
        HashMap hashMap = new HashMap();
        lPO = hashMap;
        hashMap.put("En_424b8e16", Integer.valueOf(0));
        lPO.put("FRAGMENT_MAINUI", Integer.valueOf(1));
        lPO.put("FRAGMENT_ADDRESS", Integer.valueOf(4));
        lPO.put("FRAGMENT_CHATTING", Integer.valueOf(3));
        lPO.put("En_5b8fbb1e", Integer.valueOf(3));
        lPO.put("SnsUserUI", Integer.valueOf(5));
    }

    public final void B(Activity activity) {
        this.lPQ = activity.getClass().getSimpleName();
    }
}
