package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class p {
    public String clientId = "";
    public int fRW = -1;
    public String fSf = "";
    public long fTQ = 0;
    public String fyF = "";
    int gxE = 0;
    String gxF = "";
    int hJR = 0;
    public int hYV = 0;
    public int hrs = 0;
    public String iah = "";
    public int iaj = 0;
    public long iam = 0;
    public long ian = 0;
    public int iaq = 0;
    int iar = 0;
    String ibe = "";
    int ibl = 0;
    public int icm = 0;
    long icn = 0;
    public int status = 0;

    public final boolean LB() {
        if (this.status == 5 || this.status == 6) {
            return true;
        }
        return false;
    }

    public final boolean LC() {
        if ((this.status <= 1 || this.status > 3) && this.status != 8) {
            return false;
        }
        return true;
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("FileName", this.fyF);
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("User", this.fSf);
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("MsgId", Long.valueOf(this.fTQ));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("NetOffset", Integer.valueOf(this.hYV));
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("FileNowSize", Integer.valueOf(this.iaj));
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("TotalLen", Integer.valueOf(this.hrs));
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("Status", Integer.valueOf(this.status));
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("CreateTime", Long.valueOf(this.iam));
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("LastModifyTime", Long.valueOf(this.ian));
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("ClientId", this.clientId);
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("VoiceLength", Integer.valueOf(this.icm));
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put("MsgLocalId", Integer.valueOf(this.iaq));
        }
        if ((this.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("Human", this.iah);
        }
        if ((this.fRW & 8192) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.iar));
        }
        if ((this.fRW & 16384) != 0) {
            contentValues.put("reserved2", this.ibe);
        }
        if ((this.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("MsgSource", this.gxF);
        }
        if ((this.fRW & 65536) != 0) {
            contentValues.put("MsgFlag", Integer.valueOf(this.gxE));
        }
        if ((this.fRW & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("MsgSeq", Integer.valueOf(this.hJR));
        }
        if ((this.fRW & 262144) != 0) {
            contentValues.put("MasterBufId", Long.valueOf(this.icn));
        }
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.fyF = cursor.getString(0);
        this.fSf = cursor.getString(1);
        this.fTQ = cursor.getLong(2);
        this.hYV = cursor.getInt(3);
        this.iaj = cursor.getInt(4);
        this.hrs = cursor.getInt(5);
        this.status = cursor.getInt(6);
        this.iam = cursor.getLong(7);
        this.ian = cursor.getLong(8);
        this.clientId = cursor.getString(9);
        this.icm = cursor.getInt(10);
        this.iaq = cursor.getInt(11);
        this.iah = cursor.getString(12);
        this.iar = cursor.getInt(13);
        this.ibe = cursor.getString(14);
        this.gxF = cursor.getString(15);
        this.gxE = cursor.getInt(16);
        this.hJR = cursor.getInt(17);
        this.icn = cursor.getLong(18);
    }
}
