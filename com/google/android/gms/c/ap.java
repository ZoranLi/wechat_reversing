package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ap extends af<ap> {
    public String aBs;
    public int aBt;
    private int aBu;
    private String aBv;
    public String aBw;
    private boolean aBx;
    private boolean aBy;
    private boolean aBz;

    public ap() {
        this((byte) 0);
    }

    private ap(byte b) {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0) {
            leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
            if (leastSignificantBits == 0) {
                leastSignificantBits = Integer.MAX_VALUE;
            }
        }
        this(false, leastSignificantBits);
    }

    private ap(boolean z, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        this.aBt = i;
        this.aBy = false;
    }

    private void lg() {
        if (this.aBz) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public final /* synthetic */ void a(af afVar) {
        ap apVar = (ap) afVar;
        if (!TextUtils.isEmpty(this.aBs)) {
            String str = this.aBs;
            apVar.lg();
            apVar.aBs = str;
        }
        if (this.aBt != 0) {
            int i = this.aBt;
            apVar.lg();
            apVar.aBt = i;
        }
        if (this.aBu != 0) {
            i = this.aBu;
            apVar.lg();
            apVar.aBu = i;
        }
        if (!TextUtils.isEmpty(this.aBv)) {
            str = this.aBv;
            apVar.lg();
            apVar.aBv = str;
        }
        if (!TextUtils.isEmpty(this.aBw)) {
            Object obj = this.aBw;
            apVar.lg();
            if (TextUtils.isEmpty(obj)) {
                apVar.aBw = null;
            } else {
                apVar.aBw = obj;
            }
        }
        if (this.aBx) {
            boolean z = this.aBx;
            apVar.lg();
            apVar.aBx = z;
        }
        if (this.aBy) {
            z = this.aBy;
            apVar.lg();
            apVar.aBy = z;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.aBs);
        hashMap.put("interstitial", Boolean.valueOf(this.aBx));
        hashMap.put("automatic", Boolean.valueOf(this.aBy));
        hashMap.put("screenId", Integer.valueOf(this.aBt));
        hashMap.put("referrerScreenId", Integer.valueOf(this.aBu));
        hashMap.put("referrerScreenName", this.aBv);
        hashMap.put("referrerUri", this.aBw);
        return af.ac(hashMap);
    }
}
