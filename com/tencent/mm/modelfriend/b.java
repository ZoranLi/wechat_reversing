package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class b {
    String aIO = "";
    private String fFW = "";
    public int fRW = -1;
    String gTY = "";
    String gku = "";
    public byte[] hAA;
    public int hAB;
    public String hAC = "";
    public int hAD = 0;
    public String hAE = "";
    public String hAF = "";
    public String hAG = "";
    int hAH = 0;
    public String hAI = "";
    int hAJ = 0;
    int hAK = 0;
    String hAL = "";
    public String hAM = "";
    String hAN = "";
    int hAO = -1;
    String hAP = "";
    long hAQ = -1;
    int hAR = -1;
    String hAS = "";
    String hAT = "";
    String hAU = "";
    long hAV = 0;
    String hAs = "";
    long hAt = 0;
    String hAu = "";
    String hAv = "";
    String hAw = "";
    String hAx = "";
    String hAy = "";
    public int hAz = 0;
    public String hrv = "";
    public int hry = 0;
    private int id = 0;
    public int status = 0;
    public int type = 0;
    public String username = "";

    public final void b(Cursor cursor) {
        iY(cursor.getString(1));
        this.hAs = cursor.getString(2);
        this.hAt = cursor.getLong(3);
        this.gTY = cursor.getString(4);
        this.hAu = cursor.getString(5);
        this.hAv = cursor.getString(6);
        this.username = cursor.getString(7);
        this.aIO = cursor.getString(8);
        this.hAw = cursor.getString(9);
        this.hAx = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.hAy = cursor.getString(12);
        this.gku = cursor.getString(13);
        int i = cursor.getInt(14);
        if (i == 65536) {
            this.status = 0;
        } else {
            this.status = i;
        }
        this.hAz = cursor.getInt(17);
        this.hrv = cursor.getString(15);
        this.hry = cursor.getInt(18);
        this.hAA = cursor.getBlob(19);
        if (!bg.bm(this.hAA)) {
            byte[] bArr = this.hAA;
            try {
                t tVar = new t();
                i = tVar.bh(bArr);
                if (i != 0) {
                    w.e("MicroMsg.AddrUpload", "parse LVBuffer error:" + i);
                } else {
                    this.hAC = tVar.getString();
                    this.hAD = tVar.getInt();
                    this.hAE = tVar.getString();
                    this.hAF = tVar.getString();
                    this.hAG = tVar.getString();
                    this.hAH = tVar.getInt();
                    this.hAI = tVar.getString();
                    this.hAJ = tVar.getInt();
                    this.hAK = tVar.getInt();
                    this.hAL = tVar.getString();
                    this.hAM = tVar.getString();
                    this.hAN = tVar.getString();
                    this.hAO = tVar.getInt();
                    this.hAP = tVar.getString();
                    this.hAQ = tVar.getLong();
                    this.hAR = tVar.getInt();
                    this.hAS = tVar.getString();
                    this.hAT = tVar.getString();
                    this.hAU = tVar.getString();
                    this.hAV = tVar.getLong();
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            }
        }
        this.hAB = cursor.getInt(20);
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.id));
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("md5", EP());
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("peopleid", EQ());
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.hAt));
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("realname", ER());
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("realnamepyinitial", ES());
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("realnamequanpin", ET());
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("nickname", EU());
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("nicknamepyinitial", EV());
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("nicknamequanpin", EW());
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.type));
        }
        if ((this.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("moblie", EX());
        }
        if ((this.fRW & 8192) != 0) {
            contentValues.put("email", EY());
        }
        if ((this.fRW & 16384) != 0) {
            int i = this.status;
            if (i == 0) {
                contentValues.put(DownloadInfo.STATUS, Integer.valueOf(65536));
            } else {
                contentValues.put(DownloadInfo.STATUS, Integer.valueOf(i));
            }
        }
        if ((this.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved1", this.hrv);
        }
        if ((this.fRW & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hAz));
        }
        if ((this.fRW & 262144) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hry));
        }
        if ((this.fRW & SQLiteGlobal.journalSizeLimit) != 0) {
            this.hAA = EO();
            contentValues.put("lvbuf", this.hAA);
        }
        if ((this.fRW & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.hAB));
        }
        return contentValues;
    }

    private byte[] EO() {
        try {
            t tVar = new t();
            tVar.bIH();
            tVar.Pm(this.hAC);
            tVar.yt(this.hAD);
            tVar.Pm(this.hAE);
            tVar.Pm(this.hAF);
            tVar.Pm(this.hAG);
            tVar.yt(this.hAH);
            tVar.Pm(this.hAI);
            tVar.yt(this.hAJ);
            tVar.yt(this.hAK);
            tVar.Pm(this.hAL);
            tVar.Pm(this.hAM);
            tVar.Pm(this.hAN);
            tVar.yt(this.hAO);
            tVar.Pm(this.hAP);
            tVar.es(this.hAQ);
            tVar.yt(this.hAR);
            tVar.Pm(this.hAS);
            tVar.Pm(this.hAT);
            tVar.Pm(this.hAU);
            tVar.es(this.hAV);
            return tVar.bII();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            return null;
        }
    }

    public static int iX(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str.substring(0, 8), 16);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AddrUpload", e, "md5: %s", str);
        }
        return (int) j;
    }

    public final void iY(String str) {
        this.fFW = str;
        this.id = iX(str);
    }

    public final String EP() {
        return this.fFW == null ? "" : this.fFW;
    }

    public final String EQ() {
        return this.hAs == null ? "" : this.hAs;
    }

    public final String ER() {
        return this.gTY == null ? "" : this.gTY;
    }

    public final String ES() {
        return this.hAu == null ? "" : this.hAu;
    }

    public final String ET() {
        return this.hAv == null ? "" : this.hAv;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String EU() {
        return this.aIO == null ? "" : this.aIO;
    }

    public final String EV() {
        return this.hAw == null ? "" : this.hAw;
    }

    public final String EW() {
        return this.hAx == null ? "" : this.hAx;
    }

    public final String EX() {
        return this.hAy == null ? "" : this.hAy;
    }

    public final String EY() {
        return this.gku == null ? "" : this.gku;
    }

    public final void EZ() {
        this.hAz |= 1;
    }

    public final boolean Fa() {
        return (this.hAz & 1) == 0;
    }

    public final int sZ() {
        int i = 32;
        if (!bg.mA(ES())) {
            i = ES().charAt(0);
        } else if (!bg.mA(ET())) {
            i = ET().charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }
}
