package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.FileUtils;

public final class ay {
    int fRW;
    public String name;
    int status;
    public a uKJ;
    public int uKK;

    public static class a {
        private String fSf;
        private String gaj;

        public a(String str) {
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.fSf = str.substring(0, indexOf);
                this.gaj = str.substring(indexOf);
                return;
            }
            this.fSf = str;
            this.gaj = "";
        }

        public final String RU(String str) {
            return this.gaj != null ? this.gaj : str;
        }
    }

    public ay() {
        this.fRW = b.CTRL_INDEX;
        this.name = "";
        this.uKJ = null;
        this.uKJ = null;
        this.name = "";
        this.status = 0;
        this.uKK = 0;
    }

    public ay(String str, boolean z, int i) {
        this.fRW = b.CTRL_INDEX;
        this.name = "";
        this.uKJ = null;
        this.uKJ = new a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.uKK = i;
    }

    public final void fe(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean isEnable() {
        return (this.status & 1) != 0;
    }

    public final boolean bMS() {
        return (this.status & 2) != 0;
    }

    public final void b(Cursor cursor) {
        if ((this.fRW & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.uKJ == null) {
                this.uKJ = new a(this.name);
            }
        }
        if ((this.fRW & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            this.uKK = cursor.getInt(7);
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.uKK));
        }
        return contentValues;
    }
}
