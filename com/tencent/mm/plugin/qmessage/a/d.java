package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class d {
    String extInfo = "";
    public int fRW = -1;
    int hBy = 0;
    long hCb = 0;
    int hnD = 0;
    int hrx = 0;
    int hry = 0;
    public int oyB = 0;
    public long oyC = 0;
    public long oyD = 0;
    String oyE = "";
    String oyF = "";
    String oyG = "";
    String oyH = "";
    public String username = "";

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("qq", Long.valueOf(this.hCb));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("extinfo", aUc());
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.oyB));
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("extupdateseq", Long.valueOf(this.oyC));
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("imgupdateseq", Long.valueOf(this.oyD));
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hnD));
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.hBy));
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hrx));
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hry));
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved5", this.oyE == null ? "" : this.oyE);
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put("reserved6", this.oyF == null ? "" : this.oyF);
        }
        if ((this.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("reserved7", this.oyG == null ? "" : this.oyG);
        }
        if ((this.fRW & 8192) != 0) {
            contentValues.put("reserved8", this.oyH == null ? "" : this.oyH);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String aUc() {
        return this.extInfo == null ? "" : this.extInfo;
    }
}
