package com.tencent.mm.modelfriend;

import android.content.ContentValues;

public final class k {
    int fRW = -1;
    int gkA = 0;
    String gkB = "";
    String gkC = "";
    public int gkr = 0;
    String signature = "";
    String username = "";

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("sex", Integer.valueOf(this.gkr));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.gkA));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("province", this.gkB == null ? "" : this.gkB);
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("city", this.gkC == null ? "" : this.gkC);
        }
        if ((this.fRW & 32) != 0) {
            String str;
            String str2 = "signature";
            if (this.signature == null) {
                str = "";
            } else {
                str = this.signature;
            }
            contentValues.put(str2, str);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
