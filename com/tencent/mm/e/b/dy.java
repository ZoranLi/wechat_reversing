package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dy extends c {
    private static final int gHJ = "disable".hashCode();
    private static final int gHZ = "domain".hashCode();
    private static final int gII = "disableWvCache".hashCode();
    private static final int gIJ = "clearPkgTime".hashCode();
    private static final int gIK = "checkIntervalTime".hashCode();
    private static final int gIL = "packMethod".hashCode();
    private static final int gIM = "pkgSize".hashCode();
    private static final int gIN = "nextCheckTime".hashCode();
    private static final int gIO = "charset".hashCode();
    private static final int gIP = "bigPackageReady".hashCode();
    private static final int gIQ = "preloadFilesReady".hashCode();
    private static final int gIR = "preloadFilesAtomic".hashCode();
    private static final int gIS = "totalDownloadCount".hashCode();
    private static final int gIT = "packageDownloadCount".hashCode();
    private static final int gIc = "accessTime".hashCode();
    private static final int gIp = "pkgId".hashCode();
    private static final int gIs = "downloadNetType".hashCode();
    private static final int gIu = "autoDownloadCount".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int geb = "version".hashCode();
    private static final int gee = "pkgPath".hashCode();
    private static final int gns = "md5".hashCode();
    private static final int gqJ = "downloadUrl".hashCode();
    public long field_accessTime;
    public String field_appId;
    public int field_autoDownloadCount;
    public boolean field_bigPackageReady;
    public String field_charset;
    public long field_checkIntervalTime;
    public long field_clearPkgTime;
    public long field_createTime;
    public boolean field_disable;
    public boolean field_disableWvCache;
    public String field_domain;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public String field_md5;
    public long field_nextCheckTime;
    public int field_packMethod;
    public int field_packageDownloadCount;
    public String field_pkgId;
    public String field_pkgPath;
    public int field_pkgSize;
    public boolean field_preloadFilesAtomic;
    public boolean field_preloadFilesReady;
    public int field_totalDownloadCount;
    public String field_version;
    private boolean gHE = true;
    private boolean gHR = true;
    private boolean gHU = true;
    private boolean gIA = true;
    private boolean gIB = true;
    private boolean gIC = true;
    private boolean gID = true;
    private boolean gIE = true;
    private boolean gIF = true;
    private boolean gIG = true;
    private boolean gIH = true;
    private boolean gIi = true;
    private boolean gIl = true;
    private boolean gIn = true;
    private boolean gIw = true;
    private boolean gIx = true;
    private boolean gIy = true;
    private boolean gIz = true;
    private boolean gbB = true;
    private boolean gcu = true;
    private boolean gdU = true;
    private boolean gdX = true;
    private boolean gmV = true;
    private boolean gqq = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gIp == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                    this.gIi = true;
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (geb == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (gee == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (gII == hashCode) {
                    this.field_disableWvCache = cursor.getInt(i) != 0;
                } else if (gIJ == hashCode) {
                    this.field_clearPkgTime = cursor.getLong(i);
                } else if (gIK == hashCode) {
                    this.field_checkIntervalTime = cursor.getLong(i);
                } else if (gIL == hashCode) {
                    this.field_packMethod = cursor.getInt(i);
                } else if (gHZ == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (gns == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gqJ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (gIM == hashCode) {
                    this.field_pkgSize = cursor.getInt(i);
                } else if (gIs == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (gIN == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gIc == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (gIO == hashCode) {
                    this.field_charset = cursor.getString(i);
                } else if (gIP == hashCode) {
                    this.field_bigPackageReady = cursor.getInt(i) != 0;
                } else if (gIQ == hashCode) {
                    this.field_preloadFilesReady = cursor.getInt(i) != 0;
                } else if (gIR == hashCode) {
                    this.field_preloadFilesAtomic = cursor.getInt(i) != 0;
                } else if (gIu == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (gHJ == hashCode) {
                    this.field_disable = cursor.getInt(i) != 0;
                } else if (gIS == hashCode) {
                    this.field_totalDownloadCount = cursor.getInt(i);
                } else if (gIT == hashCode) {
                    this.field_packageDownloadCount = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gIi) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gdU) {
            contentValues.put("version", this.field_version);
        }
        if (this.gdX) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.gIw) {
            contentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
        }
        if (this.gIx) {
            contentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
        }
        if (this.gIy) {
            contentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
        }
        if (this.gIz) {
            contentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
        }
        if (this.gHR) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.gmV) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gqq) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.gIA) {
            contentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
        }
        if (this.gIl) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.gIB) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gHU) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.field_charset == null) {
            this.field_charset = "UTF-8";
        }
        if (this.gIC) {
            contentValues.put("charset", this.field_charset);
        }
        if (this.gID) {
            contentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
        }
        if (this.gIE) {
            contentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
        }
        if (this.gIF) {
            contentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
        }
        if (this.gIn) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.gHE) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.gIG) {
            contentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
        }
        if (this.gIH) {
            contentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
