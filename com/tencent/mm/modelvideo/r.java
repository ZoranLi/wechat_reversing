package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Map;

public final class r {
    String clientId = "";
    public int fOA = 0;
    public int fRW = -1;
    public String fSf = "";
    public long fTQ = 0;
    public String fUY = "";
    public String fVC = "";
    public String fyF = "";
    public String hXX = "";
    public long hYG = 0;
    public int hYV = 0;
    public int hrs = 0;
    public int hzv = 0;
    public String iah = "";
    public int iaj = 0;
    int iak = 0;
    public int ial = 0;
    public long iam = 0;
    public long ian = 0;
    public long iao = 0;
    public int iap = 0;
    public int iaq = 0;
    public int iar = 0;
    private int ias = 0;
    public int iat = 0;
    public int iau = 0;
    public String iav = "";
    public int iaw = 0;
    public String iax = "";
    public bdu iay = new bdu();
    public aks iaz = new aks();
    public int status = 0;
    public int videoFormat = 0;

    public static String lr(String str) {
        try {
            Map q = bh.q(str, "msg");
            if (q != null) {
                return (String) q.get(".msg.videomsg.$cdnvideourl");
            }
        } catch (Exception e) {
        }
        return "";
    }

    public final void b(Cursor cursor) {
        this.fyF = cursor.getString(0);
        this.clientId = cursor.getString(1);
        this.fTQ = cursor.getLong(2);
        this.hYV = cursor.getInt(3);
        this.iaj = cursor.getInt(4);
        this.hrs = cursor.getInt(5);
        this.iak = cursor.getInt(6);
        this.ial = cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.iam = cursor.getLong(9);
        this.ian = cursor.getLong(10);
        this.iao = cursor.getLong(11);
        this.iap = cursor.getInt(12);
        this.iaq = cursor.getInt(13);
        this.iar = cursor.getInt(14);
        this.ias = cursor.getInt(15);
        this.fSf = cursor.getString(16);
        this.iah = cursor.getString(17);
        this.iat = cursor.getInt(18);
        this.iau = cursor.getInt(19);
        this.hXX = cursor.getString(20);
        this.iav = cursor.getString(21);
        this.iaw = cursor.getInt(22);
        this.hYG = cursor.getLong(23);
        this.iax = cursor.getString(24);
        this.fVC = cursor.getString(25);
        byte[] blob = cursor.getBlob(26);
        this.iay = new bdu();
        try {
            this.iay.aD(blob);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
        }
        this.fUY = cursor.getString(27);
        this.hzv = cursor.getInt(28);
        blob = cursor.getBlob(29);
        this.iaz = new aks();
        try {
            this.iaz.aD(blob);
        } catch (Exception e2) {
        }
        this.fOA = cursor.getInt(30);
        this.videoFormat = cursor.getInt(31);
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, getFileName());
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("clientid", this.clientId == null ? "" : this.clientId);
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("msgsvrid", Long.valueOf(this.fTQ));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("netoffset", Integer.valueOf(this.hYV));
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("filenowsize", Integer.valueOf(this.iaj));
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.hrs));
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("thumbnetoffset", Integer.valueOf(this.iak));
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("thumblen", Integer.valueOf(this.ial));
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("createtime", Long.valueOf(this.iam));
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("lastmodifytime", Long.valueOf(this.ian));
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put("downloadtime", Long.valueOf(this.iao));
        }
        if ((this.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("videolength", Integer.valueOf(this.iap));
        }
        if ((this.fRW & 8192) != 0) {
            contentValues.put("msglocalid", Integer.valueOf(this.iaq));
        }
        if ((this.fRW & 16384) != 0) {
            contentValues.put("nettimes", Integer.valueOf(this.iar));
        }
        if ((this.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("cameratype", Integer.valueOf(this.ias));
        }
        if ((this.fRW & 65536) != 0) {
            contentValues.put("user", Le());
        }
        if ((this.fRW & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("human", Lf());
        }
        if ((this.fRW & 262144) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.iat));
        }
        if ((this.fRW & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.iau));
        }
        if ((this.fRW & 1048576) != 0) {
            contentValues.put("reserved3", Lg());
        }
        if ((this.fRW & 2097152) != 0) {
            contentValues.put("reserved4", Lh());
        }
        if ((this.fRW & 4194304) != 0) {
            contentValues.put("videofuncflag", Integer.valueOf(this.iaw));
        }
        if ((this.fRW & 8388608) != 0) {
            contentValues.put("masssendid", Long.valueOf(this.hYG));
        }
        if ((this.fRW & 16777216) != 0) {
            contentValues.put("masssendlist", this.iax);
        }
        if ((this.fRW & 33554432) != 0) {
            contentValues.put("videomd5", this.fVC);
        }
        if ((this.fRW & 67108864) != 0) {
            contentValues.put("streamvideo", Ld());
        }
        if ((this.fRW & 134217728) != 0) {
            contentValues.put("statextstr", this.fUY);
        }
        if ((this.fRW & SQLiteDatabase.CREATE_IF_NECESSARY) != 0) {
            contentValues.put("downloadscene", Integer.valueOf(this.hzv));
        }
        if ((this.fRW & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            contentValues.put("mmsightextinfo", Ll());
        }
        if ((this.fRW & 1) != 0) {
            contentValues.put("preloadsize", Integer.valueOf(this.fOA));
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("videoformat", Integer.valueOf(this.videoFormat));
        }
        return contentValues;
    }

    private byte[] Ld() {
        byte[] bArr = new byte[0];
        try {
            bArr = this.iay.toByteArray();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
        }
        return bArr;
    }

    public final void gO(int i) {
        this.fRW = 1280;
    }

    public final String getFileName() {
        return this.fyF == null ? "" : this.fyF;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void at(long j) {
        this.ian = j;
    }

    public final String Le() {
        return this.fSf == null ? "" : this.fSf;
    }

    public final String Lf() {
        return this.iah == null ? "" : this.iah;
    }

    public final String Lg() {
        return this.hXX == null ? "" : this.hXX;
    }

    public final String Lh() {
        return this.iav == null ? "" : this.iav;
    }

    public final boolean Li() {
        if (this.status == c.CTRL_INDEX || this.status == k.CTRL_INDEX || this.status == 142) {
            return true;
        }
        return false;
    }

    public final boolean Lj() {
        if (this.status == 121 || this.status == 122 || this.status == 120) {
            return true;
        }
        return false;
    }

    public final boolean Lk() {
        if (this.status == 199 || this.status == 199) {
            return true;
        }
        return false;
    }

    private byte[] Ll() {
        byte[] bArr = new byte[0];
        try {
            bArr = this.iaz.toByteArray();
        } catch (Exception e) {
        }
        return bArr;
    }
}
