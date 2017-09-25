package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ce extends c {
    public static final String[] gaK = new String[0];
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int ggg = "bizChatId".hashCode();
    private static final int ggr = "isSend".hashCode();
    private static final int goD = "talker".hashCode();
    private static final int gsK = "msgSeq".hashCode();
    private static final int gtM = "lvbuffer".hashCode();
    private static final int gxA = "transBrandWording".hashCode();
    private static final int gxB = "bizClientMsgId".hashCode();
    private static final int gxC = "bizChatUserId".hashCode();
    private static final int gxu = "msgSvrId".hashCode();
    private static final int gxv = "isShowTimer".hashCode();
    private static final int gxw = "imgPath".hashCode();
    private static final int gxx = "reserved".hashCode();
    private static final int gxy = "talkerId".hashCode();
    private static final int gxz = "transContent".hashCode();
    private String fUY;
    public long field_bizChatId;
    public String field_bizChatUserId;
    private String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public String field_transBrandWording;
    public String field_transContent;
    public int field_type;
    private boolean gaO = false;
    private boolean gaW = false;
    private boolean gbB = false;
    private boolean gbE = false;
    private boolean gbJ = false;
    private boolean gfG = false;
    private boolean gfS = false;
    private boolean ggd = false;
    private boolean gon = false;
    private boolean gsE = false;
    public boolean gtA = false;
    public String gxD;
    public int gxE;
    public String gxF;
    public int gxG;
    public int gxH;
    public int gxI;
    public int gxJ;
    public int gxK;
    public int gxL;
    public String gxM;
    public String gxN;
    public String gxO;
    public int gxP;
    private boolean gxl = false;
    public boolean gxm = false;
    private boolean gxn = false;
    private boolean gxo = false;
    public boolean gxp = false;
    private boolean gxq = false;
    private boolean gxr = false;
    private boolean gxs = false;
    public boolean gxt = false;

    public final void x(long j) {
        this.field_msgId = j;
        this.gaO = true;
    }

    public final long pH() {
        return this.field_msgId;
    }

    public final void y(long j) {
        this.field_msgSvrId = j;
        this.gxl = true;
    }

    public final long pI() {
        return this.field_msgSvrId;
    }

    public final void setType(int i) {
        this.field_type = i;
        this.gbE = true;
    }

    public final int getType() {
        return this.field_type;
    }

    public void dv(int i) {
        this.field_status = i;
        this.gaW = true;
    }

    public final void dw(int i) {
        this.field_isSend = i;
        this.ggd = true;
    }

    public final int pJ() {
        return this.field_isSend;
    }

    public final void z(long j) {
        this.field_createTime = j;
        this.gbB = true;
    }

    public final long pK() {
        return this.field_createTime;
    }

    public final void cH(String str) {
        this.field_talker = str;
        this.gon = true;
    }

    public final String pL() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.gbJ = true;
    }

    public final String pM() {
        return this.field_content;
    }

    public final void cI(String str) {
        this.field_imgPath = str;
        this.gxn = true;
    }

    public final String pN() {
        return this.field_imgPath;
    }

    public final void cJ(String str) {
        this.field_reserved = str;
        this.gxo = true;
    }

    public final void cK(String str) {
        this.field_transContent = str;
        this.gxq = true;
    }

    public final void cL(String str) {
        this.field_bizClientMsgId = str;
        this.gxs = true;
    }

    public final void A(long j) {
        this.field_bizChatId = j;
        this.gfS = true;
    }

    public final void B(long j) {
        this.field_msgSeq = j;
        this.gsE = true;
    }

    public final void dF(int i) {
        this.field_flag = i;
        this.gfG = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.gaO = true;
                } else if (gxu == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ggr == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (gxv == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (goD == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gxw == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (gxx == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (gtM == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (gxy == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (gxz == hashCode) {
                    this.field_transContent = cursor.getString(i);
                } else if (gxA == hashCode) {
                    this.field_transBrandWording = cursor.getString(i);
                } else if (gxB == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i);
                } else if (ggg == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                } else if (gxC == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i);
                } else if (gsK == hashCode) {
                    this.field_msgSeq = cursor.getLong(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    t tVar = new t();
                    int bh = tVar.bh(this.field_lvbuffer);
                    if (bh != 0) {
                        w.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:" + bh);
                        return;
                    }
                    if (!tVar.bIG()) {
                        this.gxD = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gxE = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gxF = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gxG = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gxH = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gxI = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gxJ = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gxK = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gxL = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gxM = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gxN = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gxO = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gxP = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.fUY = tVar.getString();
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    public ContentValues pv() {
        try {
            if (this.gtA) {
                t tVar = new t();
                tVar.bIH();
                tVar.Pm(this.gxD);
                tVar.yt(this.gxE);
                tVar.Pm(this.gxF);
                tVar.yt(this.gxG);
                tVar.yt(this.gxH);
                tVar.yt(this.gxI);
                tVar.yt(this.gxJ);
                tVar.yt(this.gxK);
                tVar.yt(this.gxL);
                tVar.Pm(this.gxM);
                tVar.Pm(this.gxN);
                tVar.Pm(this.gxO);
                tVar.yt(this.gxP);
                tVar.Pm(this.fUY);
                this.field_lvbuffer = tVar.bII();
            }
        } catch (Exception e) {
            w.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.gaO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gxl) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.ggd) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.gxm) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gon) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.gxn) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.gxo) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.gtA) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.gxp) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = "";
        }
        if (this.gxq) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = "";
        }
        if (this.gxr) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.gxs) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.gfS) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = "";
        }
        if (this.gxt) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.gsE) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.gfG) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }

    public final void cM(String str) {
        this.gxD = str;
        this.gtA = true;
    }

    public final void dG(int i) {
        this.gxE = i;
        this.gtA = true;
    }

    public final void cN(String str) {
        this.gxF = str;
        this.gtA = true;
    }

    public final void dH(int i) {
        this.gxG = i;
        this.gtA = true;
    }

    public final void dI(int i) {
        this.gxH = i;
        this.gtA = true;
    }

    public final void dJ(int i) {
        this.gxL = i;
        this.gtA = true;
    }

    public final void cO(String str) {
        this.gxN = str;
        this.gtA = true;
    }

    public final void cP(String str) {
        this.gxO = str;
        this.gtA = true;
    }

    public final void dK(int i) {
        this.gxP = i;
        this.gtA = true;
    }
}
