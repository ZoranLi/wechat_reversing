package com.tencent.mm.booter.notification.a;

import android.content.Context;

public final class g {
    public b gMg;
    public c gMh;
    public d gMi;
    public h gMj;
    private f gMk;
    public a gMl;
    public int gMm;
    public int gMn;
    public int gMo;
    public int gMp;
    public boolean gMq;
    private int gMr = -1;
    private int gMs = -1;
    public boolean gMt;
    public boolean gMu;
    public Context mContext;

    public g(Context context) {
        this.mContext = context;
        this.gMg = new b();
        this.gMh = new c();
        this.gMi = new d();
        this.gMj = new h();
        this.gMl = new a();
        this.gMk = a.gMf;
    }

    public final void dj(String str) {
        this.gMk.di(str);
    }

    public static String a(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        String str = "";
        int length = jArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str = str + String.valueOf(jArr[i]) + ",";
        }
        return !str.isEmpty() ? str.substring(0, str.length() - 1) : str;
    }
}
