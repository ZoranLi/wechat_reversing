package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dz extends c {
    private static final int gJe = "usernameHash".hashCode();
    private static final int gJf = "roundedSquareIconURL".hashCode();
    private static final int gJg = "bigHeadURL".hashCode();
    private static final int gJh = "smallHeadURL".hashCode();
    private static final int gJi = "appOpt".hashCode();
    private static final int gJj = "registerSource".hashCode();
    private static final int gJk = "bindWxaInfo".hashCode();
    private static final int gJl = "dynamicInfo".hashCode();
    private static final int gJm = "syncTimeSecond".hashCode();
    private static final int gJn = "syncVersion".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gcZ = "signature".hashCode();
    private static final int gdL = "appInfo".hashCode();
    private static final int gdM = "versionInfo".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int ghG = "brandIconURL".hashCode();
    private static final int ghU = "nickname".hashCode();
    private static final int gxx = "reserved".hashCode();
    public String field_appId;
    public String field_appInfo;
    public int field_appOpt;
    public String field_bigHeadURL;
    public String field_bindWxaInfo;
    public String field_brandIconURL;
    public String field_dynamicInfo;
    public String field_nickname;
    public String field_registerSource;
    public String field_reserved;
    public String field_roundedSquareIconURL;
    public String field_signature;
    public String field_smallHeadURL;
    public long field_syncTimeSecond;
    public String field_syncVersion;
    public String field_username;
    public int field_usernameHash;
    public String field_versionInfo;
    private boolean gIU = true;
    private boolean gIV = true;
    private boolean gIW = true;
    private boolean gIX = true;
    private boolean gIY = true;
    private boolean gIZ = true;
    private boolean gJa = true;
    private boolean gJb = true;
    private boolean gJc = true;
    private boolean gJd = true;
    private boolean gcI = true;
    private boolean gcu = true;
    private boolean gds = true;
    private boolean gdy = true;
    private boolean gdz = true;
    private boolean ghQ = true;
    private boolean ght = true;
    private boolean gxo = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gJe == hashCode) {
                    this.field_usernameHash = cursor.getInt(i);
                    this.gIU = true;
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (ghU == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (ghG == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (gJf == hashCode) {
                    this.field_roundedSquareIconURL = cursor.getString(i);
                } else if (gJg == hashCode) {
                    this.field_bigHeadURL = cursor.getString(i);
                } else if (gJh == hashCode) {
                    this.field_smallHeadURL = cursor.getString(i);
                } else if (gcZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (gJi == hashCode) {
                    this.field_appOpt = cursor.getInt(i);
                } else if (gJj == hashCode) {
                    this.field_registerSource = cursor.getString(i);
                } else if (gdL == hashCode) {
                    this.field_appInfo = cursor.getString(i);
                } else if (gdM == hashCode) {
                    this.field_versionInfo = cursor.getString(i);
                } else if (gJk == hashCode) {
                    this.field_bindWxaInfo = cursor.getString(i);
                } else if (gJl == hashCode) {
                    this.field_dynamicInfo = cursor.getString(i);
                } else if (gxx == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (gJm == hashCode) {
                    this.field_syncTimeSecond = cursor.getLong(i);
                } else if (gJn == hashCode) {
                    this.field_syncVersion = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gIU) {
            contentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.ghQ) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.ght) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.gIV) {
            contentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
        }
        if (this.gIW) {
            contentValues.put("bigHeadURL", this.field_bigHeadURL);
        }
        if (this.gIX) {
            contentValues.put("smallHeadURL", this.field_smallHeadURL);
        }
        if (this.gcI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.gIY) {
            contentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
        }
        if (this.gIZ) {
            contentValues.put("registerSource", this.field_registerSource);
        }
        if (this.gdy) {
            contentValues.put("appInfo", this.field_appInfo);
        }
        if (this.gdz) {
            contentValues.put("versionInfo", this.field_versionInfo);
        }
        if (this.gJa) {
            contentValues.put("bindWxaInfo", this.field_bindWxaInfo);
        }
        if (this.gJb) {
            contentValues.put("dynamicInfo", this.field_dynamicInfo);
        }
        if (this.gxo) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.gJc) {
            contentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
        }
        if (this.gJd) {
            contentValues.put("syncVersion", this.field_syncVersion);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
