package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;

public final class a {
    int fRW = -1;
    public String filename = "";
    public int fuU = 0;
    String hTJ = "";
    String hnF = "";
    String hnG = "";
    int iak = 0;
    public long iam = 0;
    long ian = 0;
    public int msgType = 0;
    String nwP = "";
    public String nwQ = "";
    public int nwR = 0;
    public int nwS = 0;
    int nwT = 0;
    int nwU = 0;
    public int nwV = 0;
    public int nwW = 0;
    int status = 0;

    public final void b(Cursor cursor) {
        this.hTJ = cursor.getString(0);
        this.status = cursor.getInt(1);
        this.iam = cursor.getLong(2);
        this.ian = cursor.getLong(3);
        this.filename = cursor.getString(4);
        this.nwP = cursor.getString(5);
        this.nwQ = cursor.getString(6);
        this.nwR = cursor.getInt(7);
        this.msgType = cursor.getInt(8);
        this.nwS = cursor.getInt(9);
        this.nwT = cursor.getInt(10);
        this.fuU = cursor.getInt(11);
        this.iak = cursor.getInt(12);
        this.nwU = cursor.getInt(13);
        this.nwV = cursor.getInt(14);
        this.nwW = cursor.getInt(15);
        this.hnF = cursor.getString(16);
        this.hnG = cursor.getString(17);
    }

    public final String aJl() {
        return this.hTJ == null ? "" : this.hTJ;
    }

    public final String aJm() {
        return this.filename == null ? "" : this.filename;
    }

    public final String aJn() {
        return this.nwP == null ? "" : this.nwP;
    }

    public final String aJo() {
        return this.nwQ == null ? "" : this.nwQ;
    }
}
