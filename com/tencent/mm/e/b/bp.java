package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;

public abstract class bp extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int giB = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int grz = "mac".hashCode();
    private static final int gtB = "deviceID".hashCode();
    private static final int gtC = "brandName".hashCode();
    private static final int gtD = "deviceType".hashCode();
    private static final int gtE = "connProto".hashCode();
    private static final int gtF = "connStrategy".hashCode();
    private static final int gtG = "closeStrategy".hashCode();
    private static final int gtH = "md5Str".hashCode();
    private static final int gtI = "authKey".hashCode();
    private static final int gtJ = "sessionKey".hashCode();
    private static final int gtK = "sessionBuf".hashCode();
    private static final int gtL = "authBuf".hashCode();
    private static final int gtM = "lvbuffer".hashCode();
    public String category;
    public byte[] field_authBuf;
    public String field_authKey;
    public String field_brandName;
    public int field_closeStrategy;
    public String field_connProto;
    public int field_connStrategy;
    public String field_deviceID;
    public String field_deviceType;
    public byte[] field_lvbuffer;
    public long field_mac;
    public String field_md5Str;
    public byte[] field_sessionBuf;
    public byte[] field_sessionKey;
    public String field_url;
    private boolean gii = true;
    private boolean grm = true;
    public boolean gtA = true;
    public int gtN;
    public int gtO;
    public long gtP;
    private long gtQ;
    public String gtR;
    public String gtS;
    public String gtT;
    private int gtU;
    public int gtV;
    public long gtW;
    public String gtX;
    public String gtY;
    private String gtZ;
    private boolean gtp = true;
    private boolean gtq = true;
    private boolean gtr = true;
    private boolean gts = true;
    private boolean gtt = true;
    private boolean gtu = true;
    private boolean gtv = true;
    private boolean gtw = true;
    private boolean gtx = true;
    private boolean gty = true;
    private boolean gtz = true;
    public String gua;
    public String iconUrl;
    public String jumpUrl;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gtB == hashCode) {
                    this.field_deviceID = cursor.getString(i);
                    this.gtp = true;
                } else if (gtC == hashCode) {
                    this.field_brandName = cursor.getString(i);
                } else if (grz == hashCode) {
                    this.field_mac = cursor.getLong(i);
                } else if (gtD == hashCode) {
                    this.field_deviceType = cursor.getString(i);
                } else if (gtE == hashCode) {
                    this.field_connProto = cursor.getString(i);
                } else if (gtF == hashCode) {
                    this.field_connStrategy = cursor.getInt(i);
                } else if (gtG == hashCode) {
                    this.field_closeStrategy = cursor.getInt(i);
                } else if (gtH == hashCode) {
                    this.field_md5Str = cursor.getString(i);
                } else if (gtI == hashCode) {
                    this.field_authKey = cursor.getString(i);
                } else if (giB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gtJ == hashCode) {
                    this.field_sessionKey = cursor.getBlob(i);
                } else if (gtK == hashCode) {
                    this.field_sessionBuf = cursor.getBlob(i);
                } else if (gtL == hashCode) {
                    this.field_authBuf = cursor.getBlob(i);
                } else if (gtM == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    t tVar = new t();
                    int bh = tVar.bh(this.field_lvbuffer);
                    if (bh != 0) {
                        w.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:" + bh);
                        return;
                    }
                    if (!tVar.bIG()) {
                        this.gtN = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gtO = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gtP = tVar.getLong();
                    }
                    if (!tVar.bIG()) {
                        this.gtQ = tVar.getLong();
                    }
                    if (!tVar.bIG()) {
                        this.gtR = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.iconUrl = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.jumpUrl = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gtS = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gtT = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.category = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gtU = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gtV = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gtW = tVar.getLong();
                    }
                    if (!tVar.bIG()) {
                        this.gtX = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gtY = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gtZ = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gua = tVar.getString();
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    public final ContentValues pv() {
        try {
            if (this.gtA) {
                t tVar = new t();
                tVar.bIH();
                tVar.yt(this.gtN);
                tVar.yt(this.gtO);
                tVar.es(this.gtP);
                tVar.es(this.gtQ);
                tVar.Pm(this.gtR);
                tVar.Pm(this.iconUrl);
                tVar.Pm(this.jumpUrl);
                tVar.Pm(this.gtS);
                tVar.Pm(this.gtT);
                tVar.Pm(this.category);
                tVar.yt(this.gtU);
                tVar.yt(this.gtV);
                tVar.es(this.gtW);
                tVar.Pm(this.gtX);
                tVar.Pm(this.gtY);
                tVar.Pm(this.gtZ);
                tVar.Pm(this.gua);
                this.field_lvbuffer = tVar.bII();
            }
        } catch (Exception e) {
            w.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[]{e.getMessage()});
        }
        ContentValues contentValues = new ContentValues();
        if (this.gtp) {
            contentValues.put("deviceID", this.field_deviceID);
        }
        if (this.gtq) {
            contentValues.put("brandName", this.field_brandName);
        }
        if (this.grm) {
            contentValues.put("mac", Long.valueOf(this.field_mac));
        }
        if (this.gtr) {
            contentValues.put("deviceType", this.field_deviceType);
        }
        if (this.gts) {
            contentValues.put("connProto", this.field_connProto);
        }
        if (this.gtt) {
            contentValues.put("connStrategy", Integer.valueOf(this.field_connStrategy));
        }
        if (this.gtu) {
            contentValues.put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
        }
        if (this.gtv) {
            contentValues.put("md5Str", this.field_md5Str);
        }
        if (this.gtw) {
            contentValues.put("authKey", this.field_authKey);
        }
        if (this.gii) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gtx) {
            contentValues.put("sessionKey", this.field_sessionKey);
        }
        if (this.gty) {
            contentValues.put("sessionBuf", this.field_sessionBuf);
        }
        if (this.gtz) {
            contentValues.put("authBuf", this.field_authBuf);
        }
        if (this.gtA) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }

    public final void bO(String str) {
        this.gtR = str;
        this.gtA = true;
    }

    public final void cy(String str) {
        this.iconUrl = str;
        this.gtA = true;
    }

    public final void cz(String str) {
        this.jumpUrl = str;
        this.gtA = true;
    }

    public final void cA(String str) {
        this.gtS = str;
        this.gtA = true;
    }

    public final void cB(String str) {
        this.gtT = str;
        this.gtA = true;
    }

    public final void cC(String str) {
        this.category = str;
        this.gtA = true;
    }

    public final void dD(int i) {
        this.gtU = i;
        this.gtA = true;
    }

    public final void dE(int i) {
        this.gtV = i;
        this.gtA = true;
    }

    public final void w(long j) {
        this.gtW = j;
        this.gtA = true;
    }

    public final void cD(String str) {
        this.gtX = str;
        this.gtA = true;
    }

    public final void cE(String str) {
        this.gtY = str;
        this.gtA = true;
    }

    public final void cF(String str) {
        this.gtZ = str;
        this.gtA = true;
    }

    public final void cG(String str) {
        this.gua = str;
        this.gtA = true;
    }
}
