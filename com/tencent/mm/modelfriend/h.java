package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;

public final class h {
    String aIO = "";
    int fRW = -1;
    int gkA = 0;
    String gkB = "";
    String gkC = "";
    int gkr = 0;
    public long gkt = 0;
    private String gku = "";
    String gtR = "";
    String hAW = "";
    int hAX = 0;
    String hAw = "";
    String hAx = "";
    String signature = "";
    public int status = 0;
    private int type = 0;
    String username = "";

    public final void b(Cursor cursor) {
        this.gkt = cursor.getLong(0);
        this.hAW = cursor.getString(1);
        this.hAX = cursor.getInt(2);
        this.status = cursor.getInt(3);
        this.username = cursor.getString(4);
        this.aIO = cursor.getString(5);
        this.hAw = cursor.getString(6);
        this.hAx = cursor.getString(7);
        this.gkr = cursor.getInt(8);
        this.gkA = cursor.getInt(9);
        this.gkB = cursor.getString(10);
        this.gkC = cursor.getString(11);
        this.signature = cursor.getString(12);
        this.gtR = cursor.getString(13);
        this.type = cursor.getInt(14);
        this.gku = cursor.getString(15);
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("fbid", Long.valueOf(this.gkt));
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("fbname", Fd());
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("fbimgkey", Integer.valueOf(this.hAX));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("nickname", EU());
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("nicknamepyinitial", this.hAw == null ? "" : this.hAw);
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("nicknamequanpin", this.hAx == null ? "" : this.hAx);
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("sex", Integer.valueOf(this.gkr));
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.gkA));
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("province", this.gkB == null ? "" : this.gkB);
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put("city", this.gkC == null ? "" : this.gkC);
        }
        if ((this.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("signature", this.signature == null ? "" : this.signature);
        }
        if ((this.fRW & 8192) != 0) {
            contentValues.put("alias", this.gtR == null ? "" : this.gtR);
        }
        if ((this.fRW & 16384) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.type));
        }
        if ((this.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("email", this.gku == null ? "" : this.gku);
        }
        return contentValues;
    }

    public final String Fd() {
        return this.hAW == null ? "" : this.hAW;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String EU() {
        return this.aIO == null ? "" : this.aIO;
    }
}
