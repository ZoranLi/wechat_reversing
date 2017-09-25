package com.tencent.mm.u;

import android.database.Cursor;
import junit.framework.Assert;

public final class bd {
    int fRW = -1;
    public String hks = "";
    public String hku = "";
    public String hnA = "";
    public String hnB = "";
    public int hnC = 0;
    public int hnD = 0;
    public long hnE = 0;
    public String hnF = "";
    String hnG = "";
    public String hnw = "";
    public String hnx = "";
    public String hny = "";
    public long hnz = 0;
    public String name = "";
    public long time = 0;
    public String title = "";
    public int type = 0;
    public String url = "";

    public final void b(Cursor cursor) {
        this.hnw = cursor.getString(0);
        this.time = cursor.getLong(1);
        this.type = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.title = cursor.getString(4);
        this.url = cursor.getString(5);
        this.hnx = cursor.getString(6);
        this.hny = cursor.getString(7);
        this.hnz = cursor.getLong(8);
        this.hnA = cursor.getString(9);
        this.hnB = cursor.getString(10);
        this.hnC = cursor.getInt(11);
        this.hks = cursor.getString(12);
        this.hku = cursor.getString(13);
        this.hnD = cursor.getInt(14);
        this.hnE = cursor.getLong(15);
        this.hnF = cursor.getString(16);
        this.hnG = cursor.getString(17);
    }

    public static String fd(int i) {
        if (i == 20) {
            return "newsapp";
        }
        if (i == 11) {
            return "blogapp";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public final void M(long j) {
        this.hnE = j;
    }

    public final boolean zC() {
        return this.hnD == 1;
    }

    public final String zD() {
        return this.hnw == null ? "" : this.hnw;
    }

    public final String getName() {
        return this.name == null ? "" : this.name;
    }

    public final String getTitle() {
        return this.title == null ? "" : this.title;
    }

    public final String getUrl() {
        return this.url == null ? "" : this.url;
    }

    public final String zE() {
        return this.hnx == null ? "" : this.hnx;
    }

    public final String zF() {
        return this.hnA == null ? "" : this.hnA;
    }

    public final String zG() {
        return this.hnB == null ? "" : this.hnB;
    }

    public final String zH() {
        if (this.hks == null) {
            return "";
        }
        String[] split = this.hks.split("\\|");
        if (split == null || split.length <= 0) {
            return "";
        }
        return split[0];
    }

    public final String zI() {
        return this.hku == null ? "" : this.hku;
    }

    public final String zJ() {
        return this.hnF == null ? "" : this.hnF;
    }
}
