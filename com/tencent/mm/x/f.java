package com.tencent.mm.x;

import android.content.ContentValues;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;

public final class f {
    int fRW = -1;
    int hrp;
    int hrq;
    String hrr;
    int hrs;
    int hrt;
    int hru;
    String hrv;
    String hrw;
    int hrx;
    int hry;
    String username;

    public f() {
        reset();
    }

    public final void reset() {
        this.username = "";
        this.hrp = 0;
        this.hrq = 0;
        this.hrr = "";
        this.hrs = 0;
        this.hrt = 0;
        this.hru = 0;
        this.hrv = "";
        this.hrw = "";
        this.hrx = 0;
        this.hry = 0;
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("username", this.username == null ? "" : this.username);
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("imgwidth", Integer.valueOf(this.hrp));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("imgheigth", Integer.valueOf(this.hrq));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("imgformat", Bq());
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.hrs));
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("startpos", Integer.valueOf(this.hrt));
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("headimgtype", Integer.valueOf(this.hru));
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved1", this.hrv == null ? "" : this.hrv);
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("reserved2", this.hrw == null ? "" : this.hrw);
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hrx));
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hry));
        }
        return contentValues;
    }

    public final String Bq() {
        return this.hrr == null ? "" : this.hrr;
    }
}
