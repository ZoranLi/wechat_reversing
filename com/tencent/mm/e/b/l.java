package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bqa;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.gj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public abstract class l extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaAppInfoBrandIdIndex ON AppBrandWxaAppInfo(brandId)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gcZ = "signature".hashCode();
    private static final int gdH = "appIdHashCode".hashCode();
    private static final int gdI = "appIcon".hashCode();
    private static final int gdJ = "appName".hashCode();
    private static final int gdK = "BigHeadImgUrl".hashCode();
    private static final int gdL = "appInfo".hashCode();
    private static final int gdM = "versionInfo".hashCode();
    private static final int gdN = "bindInfo".hashCode();
    private static final int gdO = "brandFlag".hashCode();
    private static final int gdP = "AppOpt".hashCode();
    private static final int gdQ = "syncAttrVersion".hashCode();
    private static final int gdR = "lastSyncAttrTimeInSecond".hashCode();
    private static final int gdS = "debugEnabled".hashCode();
    private static final int gdT = "roundedSquareIcon".hashCode();
    private static final int gdp = "brandId".hashCode();
    public int field_AppOpt;
    public String field_BigHeadImgUrl;
    public String field_appIcon;
    public String field_appId;
    public int field_appIdHashCode;
    public bqa field_appInfo;
    public String field_appName;
    public gj field_bindInfo;
    public int field_brandFlag;
    public String field_brandId;
    public boolean field_debugEnabled;
    public long field_lastSyncAttrTimeInSecond;
    public String field_roundedSquareIcon;
    public String field_signature;
    public String field_syncAttrVersion;
    public bqg field_versionInfo;
    private boolean gcI = true;
    private boolean gcu = true;
    private boolean gdA = true;
    private boolean gdB = true;
    private boolean gdC = true;
    private boolean gdD = true;
    private boolean gdE = true;
    private boolean gdF = true;
    private boolean gdG = true;
    private boolean gdl = true;
    private boolean gdu = true;
    private boolean gdv = true;
    private boolean gdw = true;
    private boolean gdx = true;
    private boolean gdy = true;
    private boolean gdz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdH == hashCode) {
                    this.field_appIdHashCode = cursor.getInt(i);
                    this.gdu = true;
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gdI == hashCode) {
                    this.field_appIcon = cursor.getString(i);
                } else if (gdJ == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (gdK == hashCode) {
                    this.field_BigHeadImgUrl = cursor.getString(i);
                } else if (gdL == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_appInfo = (bqa) new bqa().aD(r0);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e.getMessage());
                    }
                } else if (gdM == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_versionInfo = (bqg) new bqg().aD(r0);
                        }
                    } catch (IOException e2) {
                        w.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e2.getMessage());
                    }
                } else if (gdN == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_bindInfo = (gj) new gj().aD(r0);
                        }
                    } catch (IOException e22) {
                        w.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e22.getMessage());
                    }
                } else if (gdp == hashCode) {
                    this.field_brandId = cursor.getString(i);
                } else if (gdO == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (gcZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (gdP == hashCode) {
                    this.field_AppOpt = cursor.getInt(i);
                } else if (gdQ == hashCode) {
                    this.field_syncAttrVersion = cursor.getString(i);
                } else if (gdR == hashCode) {
                    this.field_lastSyncAttrTimeInSecond = cursor.getLong(i);
                } else if (gdS == hashCode) {
                    this.field_debugEnabled = cursor.getInt(i) != 0;
                } else if (gdT == hashCode) {
                    this.field_roundedSquareIcon = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gdu) {
            contentValues.put("appIdHashCode", Integer.valueOf(this.field_appIdHashCode));
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gdv) {
            contentValues.put("appIcon", this.field_appIcon);
        }
        if (this.gdw) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.gdx) {
            contentValues.put("BigHeadImgUrl", this.field_BigHeadImgUrl);
        }
        if (this.gdy && this.field_appInfo != null) {
            try {
                contentValues.put("appInfo", this.field_appInfo.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e.getMessage());
            }
        }
        if (this.gdz && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e2) {
                w.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e2.getMessage());
            }
        }
        if (this.gdA && this.field_bindInfo != null) {
            try {
                contentValues.put("bindInfo", this.field_bindInfo.toByteArray());
            } catch (IOException e22) {
                w.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e22.getMessage());
            }
        }
        if (this.gdl) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.gdB) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.gcI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.gdC) {
            contentValues.put("AppOpt", Integer.valueOf(this.field_AppOpt));
        }
        if (this.gdD) {
            contentValues.put("syncAttrVersion", this.field_syncAttrVersion);
        }
        if (this.gdE) {
            contentValues.put("lastSyncAttrTimeInSecond", Long.valueOf(this.field_lastSyncAttrTimeInSecond));
        }
        if (this.gdF) {
            contentValues.put("debugEnabled", Boolean.valueOf(this.field_debugEnabled));
        }
        if (this.gdG) {
            contentValues.put("roundedSquareIcon", this.field_roundedSquareIcon);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
