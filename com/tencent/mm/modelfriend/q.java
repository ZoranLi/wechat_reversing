package com.tencent.mm.modelfriend;

import android.content.ContentValues;

public final class q {
    int fRW = -1;
    public int hBx = 0;
    private int hBy = 0;
    private int hnD = 0;
    private String hnF = "";
    private String hnG = "";
    public int hve = 0;
    public String username = "";

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("friendtype", Integer.valueOf(this.hBx));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("updatetime", Integer.valueOf(this.hve));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hnD));
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.hBy));
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("reserved3", this.hnF == null ? "" : this.hnF);
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("reserved4", this.hnG == null ? "" : this.hnG);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
