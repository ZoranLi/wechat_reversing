package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class n extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gcZ = "signature".hashCode();
    private static final int gdJ = "appName".hashCode();
    private static final int geE = "appDiscription".hashCode();
    private static final int geF = "appIconUrl".hashCode();
    private static final int geG = "appStoreUrl".hashCode();
    private static final int geH = "appVersion".hashCode();
    private static final int geI = "appWatermarkUrl".hashCode();
    private static final int geJ = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int geK = "modifyTime".hashCode();
    private static final int geL = "appName_en".hashCode();
    private static final int geM = "appName_tw".hashCode();
    private static final int geN = "appName_hk".hashCode();
    private static final int geO = "appDiscription_en".hashCode();
    private static final int geP = "appDiscription_tw".hashCode();
    private static final int geQ = "appType".hashCode();
    private static final int geR = "openId".hashCode();
    private static final int geS = "authFlag".hashCode();
    private static final int geT = "appInfoFlag".hashCode();
    private static final int geU = "lvbuff".hashCode();
    private static final int geV = "serviceAppType".hashCode();
    private static final int geW = "serviceAppInfoFlag".hashCode();
    private static final int geX = "serviceShowFlag".hashCode();
    private static final int geY = "appSupportContentType".hashCode();
    private static final int geZ = "svrAppSupportContentType".hashCode();
    public String field_appDiscription;
    public String field_appDiscription_en;
    public String field_appDiscription_tw;
    public String field_appIconUrl;
    public String field_appId;
    public int field_appInfoFlag;
    public String field_appName;
    public String field_appName_en;
    public String field_appName_hk;
    public String field_appName_tw;
    public String field_appStoreUrl;
    public long field_appSupportContentType;
    public String field_appType;
    public int field_appVersion;
    public String field_appWatermarkUrl;
    public int field_authFlag;
    public byte[] field_lvbuff;
    public long field_modifyTime;
    public String field_openId;
    public String field_packageName;
    public int field_serviceAppInfoFlag;
    public int field_serviceAppType;
    public int field_serviceShowFlag;
    public String field_signature;
    public int field_status;
    public long field_svrAppSupportContentType;
    private boolean gaW = true;
    private boolean gcI = true;
    private boolean gcu = true;
    private boolean gdw = true;
    private boolean geA = true;
    private boolean geB = true;
    private boolean geC = true;
    private boolean geD = true;
    private boolean gei = true;
    private boolean gej = true;
    private boolean gek = true;
    private boolean gel = true;
    private boolean gem = true;
    private boolean gen = true;
    private boolean geo = true;
    private boolean gep = true;
    private boolean geq = true;
    private boolean ger = true;
    private boolean ges = true;
    private boolean get = true;
    private boolean geu = true;
    private boolean gev = true;
    private boolean gew = true;
    private boolean gex = true;
    public boolean gey = true;
    private boolean gez = true;
    public String gfa;
    public String gfb;
    public String gfc;
    public int gfd;
    public int gfe;
    public String gff;
    public String gfg;
    public String gfh;
    public String gfi;
    public String gfj;
    public String gfk;
    public int gfl;
    public String gfm;
    public String gfn;
    public String gfo;
    public String gfp;
    public String gfq;
    public int gfr;
    public String gfs;
    private int gft;
    public String gfu;
    public String gfv;
    public String gfw;
    public int gfx;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.gcu = true;
                } else if (gdJ == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (geE == hashCode) {
                    this.field_appDiscription = cursor.getString(i);
                } else if (geF == hashCode) {
                    this.field_appIconUrl = cursor.getString(i);
                } else if (geG == hashCode) {
                    this.field_appStoreUrl = cursor.getString(i);
                } else if (geH == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (geI == hashCode) {
                    this.field_appWatermarkUrl = cursor.getString(i);
                } else if (geJ == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gcZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (geK == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (geL == hashCode) {
                    this.field_appName_en = cursor.getString(i);
                } else if (geM == hashCode) {
                    this.field_appName_tw = cursor.getString(i);
                } else if (geN == hashCode) {
                    this.field_appName_hk = cursor.getString(i);
                } else if (geO == hashCode) {
                    this.field_appDiscription_en = cursor.getString(i);
                } else if (geP == hashCode) {
                    this.field_appDiscription_tw = cursor.getString(i);
                } else if (geQ == hashCode) {
                    this.field_appType = cursor.getString(i);
                } else if (geR == hashCode) {
                    this.field_openId = cursor.getString(i);
                } else if (geS == hashCode) {
                    this.field_authFlag = cursor.getInt(i);
                } else if (geT == hashCode) {
                    this.field_appInfoFlag = cursor.getInt(i);
                } else if (geU == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (geV == hashCode) {
                    this.field_serviceAppType = cursor.getInt(i);
                } else if (geW == hashCode) {
                    this.field_serviceAppInfoFlag = cursor.getInt(i);
                } else if (geX == hashCode) {
                    this.field_serviceShowFlag = cursor.getInt(i);
                } else if (geY == hashCode) {
                    this.field_appSupportContentType = cursor.getLong(i);
                } else if (geZ == hashCode) {
                    this.field_svrAppSupportContentType = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    t tVar = new t();
                    int bh = tVar.bh(this.field_lvbuff);
                    if (bh != 0) {
                        w.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:" + bh);
                        return;
                    }
                    this.gfa = tVar.getString();
                    this.gfb = tVar.getString();
                    this.gfc = tVar.getString();
                    this.gfd = tVar.getInt();
                    this.gfe = tVar.getInt();
                    this.gff = tVar.getString();
                    this.gfg = tVar.getString();
                    this.gfh = tVar.getString();
                    this.gfi = tVar.getString();
                    if (!tVar.bIG()) {
                        this.gfj = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfk = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfl = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gfm = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfn = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfo = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfp = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfq = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfr = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gfs = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gft = tVar.getInt();
                    }
                    if (!tVar.bIG()) {
                        this.gfu = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfv = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfw = tVar.getString();
                    }
                    if (!tVar.bIG()) {
                        this.gfx = tVar.getInt();
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    public ContentValues pv() {
        try {
            if (this.gey) {
                t tVar = new t();
                tVar.bIH();
                tVar.Pm(this.gfa);
                tVar.Pm(this.gfb);
                tVar.Pm(this.gfc);
                tVar.yt(this.gfd);
                tVar.yt(this.gfe);
                tVar.Pm(this.gff);
                tVar.Pm(this.gfg);
                tVar.Pm(this.gfh);
                tVar.Pm(this.gfi);
                tVar.Pm(this.gfj);
                tVar.Pm(this.gfk);
                tVar.yt(this.gfl);
                tVar.Pm(this.gfm);
                tVar.Pm(this.gfn);
                tVar.Pm(this.gfo);
                tVar.Pm(this.gfp);
                tVar.Pm(this.gfq);
                tVar.yt(this.gfr);
                tVar.Pm(this.gfs);
                tVar.yt(this.gft);
                tVar.Pm(this.gfu);
                tVar.Pm(this.gfv);
                tVar.Pm(this.gfw);
                tVar.yt(this.gfx);
                this.field_lvbuff = tVar.bII();
            }
        } catch (Exception e) {
            w.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gdw) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.gei) {
            contentValues.put("appDiscription", this.field_appDiscription);
        }
        if (this.gej) {
            contentValues.put("appIconUrl", this.field_appIconUrl);
        }
        if (this.gek) {
            contentValues.put("appStoreUrl", this.field_appStoreUrl);
        }
        if (this.gel) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.gem) {
            contentValues.put("appWatermarkUrl", this.field_appWatermarkUrl);
        }
        if (this.gen) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gcI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.geo) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.gep) {
            contentValues.put("appName_en", this.field_appName_en);
        }
        if (this.geq) {
            contentValues.put("appName_tw", this.field_appName_tw);
        }
        if (this.ger) {
            contentValues.put("appName_hk", this.field_appName_hk);
        }
        if (this.ges) {
            contentValues.put("appDiscription_en", this.field_appDiscription_en);
        }
        if (this.get) {
            contentValues.put("appDiscription_tw", this.field_appDiscription_tw);
        }
        if (this.geu) {
            contentValues.put("appType", this.field_appType);
        }
        if (this.gev) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.gew) {
            contentValues.put("authFlag", Integer.valueOf(this.field_authFlag));
        }
        if (this.gex) {
            contentValues.put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
        }
        if (this.gey) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.gez) {
            contentValues.put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
        }
        if (this.geA) {
            contentValues.put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
        }
        if (this.geB) {
            contentValues.put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
        }
        if (this.geC) {
            contentValues.put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
        }
        if (this.geD) {
            contentValues.put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }

    public final void bB(String str) {
        this.gfa = str;
        this.gey = true;
    }

    public final void bC(String str) {
        this.gfb = str;
        this.gey = true;
    }

    public final String px() {
        return this.gfc;
    }

    public final void bD(String str) {
        this.gfc = str;
        this.gey = true;
    }

    public final void bE(String str) {
        this.gff = str;
        this.gey = true;
    }

    public final void bF(String str) {
        this.gfg = str;
        this.gey = true;
    }

    public final String py() {
        return this.gfh;
    }

    public final void bG(String str) {
        this.gfh = str;
        this.gey = true;
    }

    public final String pz() {
        return this.gfi;
    }

    public final void bH(String str) {
        this.gfi = str;
        this.gey = true;
    }

    public final void bI(String str) {
        this.gfj = str;
        this.gey = true;
    }

    public final void bJ(String str) {
        this.gfk = str;
        this.gey = true;
    }

    public final void da(int i) {
        this.gfl = i;
        this.gey = true;
    }

    public final void bK(String str) {
        this.gfm = str;
        this.gey = true;
    }

    public final void bL(String str) {
        this.gfn = str;
        this.gey = true;
    }

    public final void bM(String str) {
        this.gfo = str;
        this.gey = true;
    }

    public final void bN(String str) {
        this.gfp = str;
        this.gey = true;
    }

    public final void db(int i) {
        this.gfr = i;
        this.gey = true;
    }
}
