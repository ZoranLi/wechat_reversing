package com.tencent.b.a.a;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n implements Runnable {
    public static long aQB = -1;
    int aQA = 0;
    private a aQz = null;
    private Context mContext = null;
    private int mType = 0;

    public n(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    private void nR() {
        g n = r.T(this.mContext).n(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)})));
        g n2 = r.T(this.mContext).n(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        g n3 = r.T(this.mContext).n(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (!s.b(n, n2) || !s.b(n, n3)) {
            n = s.a(s.a(n, n2), s.a(n, n3));
            new StringBuilder("local mid check failed, redress with mid:").append(n.toString());
            r.T(this.mContext).b(n);
        }
    }

    private void a(JSONObject jSONObject) {
        if (i.aQp != null && j.aQv != 1) {
            if (j.aQw <= 0 || this.aQA <= j.aQw) {
                i.aQp.aH("[" + new m(this.mContext, jSONObject).nQ().toString() + "]");
                aQB = System.currentTimeMillis();
                this.aQA++;
                return;
            }
            new StringBuilder("limit dispatch:").append(j.aQw);
        }
    }

    public final void run() {
        new StringBuilder("request type:").append(this.mType);
        switch (this.mType) {
            case 1:
                a(null);
                return;
            case 2:
                if (this.aQz == null) {
                    this.aQz = r.T(this.mContext).nT();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i.aQq <= 0) {
                    i.aQq = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0);
                }
                long abs = Math.abs(currentTimeMillis - i.aQq);
                new StringBuilder("check entity: ").append(this.aQz.toString()).append(",duration:").append(abs);
                if (this.aQz.aPQ < 0 || this.aQz.aPQ > 100) {
                    this.aQz.aPQ = 3;
                }
                long j = ((long) this.aQz.aPQ) * e.aQk;
                new StringBuilder("duration:").append(abs).append(",maxCheckDays:").append(j).append(",mLastCheckTime:").append(i.aQq).append(",mCheckEntity:").append(this.aQz);
                if (abs >= j) {
                    nR();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dur", abs);
                        jSONObject.put("md", j);
                        jSONObject.put("lct", i.aQq);
                        jSONObject.put("cur", currentTimeMillis);
                    } catch (JSONException e) {
                    }
                    if (aQB <= 0) {
                        a(jSONObject);
                        return;
                    }
                    return;
                } else if (abs > e.aQk) {
                    nR();
                    return;
                } else {
                    return;
                }
            default:
                new StringBuilder("wrong type:").append(this.mType);
                return;
        }
    }
}
