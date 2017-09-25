package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dv extends c {
    private static final int gAG = "contentLength".hashCode();
    private static final int gAH = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int gAZ = "packageId".hashCode();
    private static final int gHY = "urlMd5Hashcode".hashCode();
    private static final int gHZ = "domain".hashCode();
    private static final int gIa = "localPath".hashCode();
    private static final int gIb = "isLatestVersion".hashCode();
    private static final int gIc = "accessTime".hashCode();
    private static final int gId = "cacheType".hashCode();
    private static final int gIe = "protocol".hashCode();
    private static final int gIf = "contentMd5".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS WebViewResourceCacheAppIdIndex ON WebViewResourceCache(appId)", "CREATE INDEX IF NOT EXISTS WebViewResourceCacheDomainIndex ON WebViewResourceCache(domain)", "CREATE INDEX IF NOT EXISTS WebViewResourceCachePackageIdIndex ON WebViewResourceCache(packageId)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int geb = "version".hashCode();
    private static final int giB = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gpk = "configId".hashCode();
    private static final int gso = "expireTime".hashCode();
    public long field_accessTime;
    public String field_appId;
    public int field_cacheType;
    public String field_configId;
    public long field_contentLength;
    public String field_contentMd5;
    public String field_contentType;
    public long field_createTime;
    public String field_domain;
    public long field_expireTime;
    public boolean field_isLatestVersion;
    public String field_localPath;
    public String field_packageId;
    public int field_protocol;
    public String field_url;
    public int field_urlMd5Hashcode;
    public String field_version;
    private boolean gAg = true;
    private boolean gAh = true;
    private boolean gAz = true;
    private boolean gHQ = true;
    private boolean gHR = true;
    private boolean gHS = true;
    private boolean gHT = true;
    private boolean gHU = true;
    private boolean gHV = true;
    private boolean gHW = true;
    private boolean gHX = true;
    private boolean gbB = true;
    private boolean gcu = true;
    private boolean gdU = true;
    private boolean gii = true;
    private boolean gpj = true;
    private boolean gsf = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gHY == hashCode) {
                    this.field_urlMd5Hashcode = cursor.getInt(i);
                } else if (giB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gHZ == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (geb == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (gIa == hashCode) {
                    this.field_localPath = cursor.getString(i);
                } else if (gAH == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (gAG == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (gIb == hashCode) {
                    this.field_isLatestVersion = cursor.getInt(i) != 0;
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gIc == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (gso == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gId == hashCode) {
                    this.field_cacheType = cursor.getInt(i);
                } else if (gpk == hashCode) {
                    this.field_configId = cursor.getString(i);
                } else if (gIe == hashCode) {
                    this.field_protocol = cursor.getInt(i);
                } else if (gAZ == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (gIf == hashCode) {
                    this.field_contentMd5 = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gHQ) {
            contentValues.put("urlMd5Hashcode", Integer.valueOf(this.field_urlMd5Hashcode));
        }
        if (this.gii) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gHR) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.gdU) {
            contentValues.put("version", this.field_version);
        }
        if (this.gHS) {
            contentValues.put("localPath", this.field_localPath);
        }
        if (this.gAh) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.gAg) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.gHT) {
            contentValues.put("isLatestVersion", Boolean.valueOf(this.field_isLatestVersion));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gHU) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.gsf) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.gHV) {
            contentValues.put("cacheType", Integer.valueOf(this.field_cacheType));
        }
        if (this.gpj) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.gHW) {
            contentValues.put("protocol", Integer.valueOf(this.field_protocol));
        }
        if (this.gAz) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.gHX) {
            contentValues.put("contentMd5", this.field_contentMd5);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
