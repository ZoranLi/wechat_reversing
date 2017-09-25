package com.tencent.mm.ah;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class d {
    int cGa;
    public int fRW = -2;
    public long fTQ;
    int gxK = 0;
    public long hEY;
    public String hEZ = "";
    private boolean hFA;
    private boolean hFB;
    private boolean hFC;
    private boolean hFD;
    String hFa = "";
    public String hFb = "";
    public int hFc;
    int hFd;
    private String hFe = "";
    int hFf;
    public long hFg;
    int hFh;
    public int hFi = 0;
    public String hFj = "";
    int hFk = 1;
    private boolean hFl;
    private boolean hFm;
    private boolean hFn;
    private boolean hFo;
    private boolean hFp;
    private boolean hFq;
    private boolean hFr;
    private boolean hFs;
    private boolean hFt;
    private boolean hFu;
    private boolean hFv;
    private boolean hFw;
    boolean hFx;
    private boolean hFy;
    boolean hFz;
    public int hrs;
    public int offset;
    public int status;

    public final void jn(String str) {
        this.hFe = str;
        this.hFB = true;
    }

    public final void dv(int i) {
        this.status = i;
        this.hFu = true;
    }

    public final void fM(int i) {
        this.hFh = i;
        this.hFv = true;
    }

    public final void fN(int i) {
        this.hFf = i;
        this.hFs = true;
    }

    public final long Gx() {
        return this.hFg;
    }

    public final void ag(long j) {
        this.hFg = j;
        this.hFt = true;
    }

    public final long Gy() {
        return this.hEY;
    }

    public final void ah(long j) {
        this.hEY = j;
        this.hFl = true;
    }

    public final long pI() {
        return this.fTQ;
    }

    public final void y(long j) {
        if (this.fTQ != j) {
            this.hFm = true;
        }
        this.fTQ = j;
    }

    public final void setOffset(int i) {
        int i2 = 0;
        if (this.offset != i) {
            this.hFn = true;
        }
        this.offset = i;
        w.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i), Long.valueOf(this.hFg), Integer.valueOf(this.hrs));
        if (i >= this.hrs) {
            i2 = 1;
        }
        fR(i2);
    }

    public final void fO(int i) {
        this.hrs = i;
        this.hFo = true;
    }

    public final String Gz() {
        return this.hEZ;
    }

    public final void jo(String str) {
        this.hEZ = str;
        this.hFp = true;
    }

    public final void jp(String str) {
        this.hFa = str;
        this.hFq = true;
    }

    public final void jq(String str) {
        this.hFb = str;
        this.hFr = true;
    }

    public final void fP(int i) {
        this.hFi = i;
        this.hFw = true;
    }

    public final void fQ(int i) {
        this.hFd = i;
        this.hFD = true;
    }

    public final boolean GA() {
        return this.hrs != 0 && this.hrs == this.offset;
    }

    public final boolean GB() {
        return this.hFi > 0;
    }

    public final void jr(String str) {
        if ((this.hFj == null && str != null) || !(this.hFj == null || this.hFj.equals(str))) {
            this.hFy = true;
        }
        this.hFj = str;
    }

    public final void b(Cursor cursor) {
        this.hEY = (long) cursor.getInt(0);
        this.fTQ = cursor.getLong(1);
        this.offset = cursor.getInt(2);
        this.hrs = cursor.getInt(3);
        this.hEZ = cursor.getString(4);
        this.hFb = cursor.getString(5);
        this.hFf = cursor.getInt(6);
        this.hFg = (long) cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.hFh = cursor.getInt(9);
        this.hFi = cursor.getInt(10);
        this.cGa = cursor.getInt(11);
        this.hFj = cursor.getString(12);
        this.gxK = cursor.getInt(14);
        this.hFk = cursor.getInt(15);
        this.hFe = cursor.getString(16);
        this.hFc = cursor.getInt(17);
        this.hFa = cursor.getString(18);
        this.hFd = cursor.getInt(19);
    }

    public final void fR(int i) {
        if (this.hFk != i) {
            this.hFA = true;
        }
        this.hFk = i;
    }

    public final void fS(int i) {
        this.hFc = i;
        this.hFC = true;
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.hFl) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Long.valueOf(this.hEY));
        }
        if (this.hFm) {
            contentValues.put("msgSvrId", Long.valueOf(this.fTQ));
        }
        if (this.hFn) {
            contentValues.put("offset", Integer.valueOf(this.offset));
        }
        if (this.hFo) {
            contentValues.put("totalLen", Integer.valueOf(this.hrs));
        }
        if (this.hFp) {
            contentValues.put("bigImgPath", this.hEZ);
        }
        if (this.hFq) {
            contentValues.put("midImgPath", this.hFa);
        }
        if (this.hFr) {
            contentValues.put("thumbImgPath", this.hFb);
        }
        if (this.hFs) {
            contentValues.put("createtime", Integer.valueOf(this.hFf));
        }
        if (this.hFt) {
            contentValues.put("msglocalid", Long.valueOf(this.hFg));
        }
        if (this.hFu) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if (this.hFv) {
            contentValues.put("nettimes", Integer.valueOf(this.hFh));
        }
        if (this.hFw) {
            contentValues.put("reserved1", Integer.valueOf(this.hFi));
        }
        if (this.hFx) {
            contentValues.put("reserved2", Integer.valueOf(this.cGa));
        }
        if (this.hFy) {
            contentValues.put("reserved3", this.hFj);
        }
        if (this.hFz) {
            contentValues.put("hashdthumb", Integer.valueOf(this.gxK));
        }
        if (this.hFA) {
            contentValues.put("iscomplete", Integer.valueOf(this.offset < this.hrs ? 0 : 1));
        }
        if (this.hFB) {
            contentValues.put("origImgMD5", this.hFe);
        }
        if (this.hFC) {
            contentValues.put("compressType", Integer.valueOf(this.hFc));
        }
        if (this.hFD) {
            contentValues.put("forwardType", Integer.valueOf(this.hFd));
        }
        return contentValues;
    }

    public final void GC() {
        this.hFl = false;
        this.hFm = false;
        this.hFn = false;
        this.hFo = false;
        this.hFp = false;
        this.hFq = false;
        this.hFr = false;
        this.hFs = false;
        this.hFt = false;
        this.hFu = false;
        this.hFv = false;
        this.hFw = false;
        this.hFx = false;
        this.hFy = false;
        this.hFz = false;
        this.hFA = false;
        this.hFB = false;
        this.hFC = false;
        this.hFD = false;
    }
}
