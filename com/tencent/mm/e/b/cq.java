package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class cq extends c {
    private static final int gAA = "urlKey_hashcode".hashCode();
    private static final int gAB = "urlKey".hashCode();
    private static final int gAC = "fileVersion".hashCode();
    private static final int gAD = "networkType".hashCode();
    private static final int gAE = "maxRetryTimes".hashCode();
    private static final int gAF = "retryTimes".hashCode();
    private static final int gAG = "contentLength".hashCode();
    private static final int gAH = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int gAI = "groupId1".hashCode();
    private static final int gAJ = "groupId2".hashCode();
    private static final int gAK = DownloadInfo.PRIORITY.hashCode();
    private static final int gAL = "fileUpdated".hashCode();
    private static final int gAM = "deleted".hashCode();
    private static final int gAN = "resType".hashCode();
    private static final int gAO = "reportId".hashCode();
    private static final int gAP = "sampleId".hashCode();
    private static final int gAQ = "eccSignature".hashCode();
    private static final int gAR = "originalMd5".hashCode();
    private static final int gAS = "fileCompress".hashCode();
    private static final int gAT = "fileEncrypt".hashCode();
    private static final int gAU = "encryptKey".hashCode();
    private static final int gAV = "keyVersion".hashCode();
    private static final int gAW = "EID".hashCode();
    private static final int gAX = "needRetry".hashCode();
    private static final int gAY = "wvCacheType".hashCode();
    private static final int gAZ = "packageId".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gco = "subType".hashCode();
    private static final int giB = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gns = "md5".hashCode();
    private static final int gqL = "fileSize".hashCode();
    private static final int gqN = DownloadInfoColumns.FILEPATH.hashCode();
    private static final int gso = "expireTime".hashCode();
    public int field_EID;
    public String field_appId;
    public long field_contentLength;
    public String field_contentType;
    public boolean field_deleted;
    public byte[] field_eccSignature;
    public String field_encryptKey;
    public long field_expireTime;
    public boolean field_fileCompress;
    public boolean field_fileEncrypt;
    public String field_filePath;
    public long field_fileSize;
    public boolean field_fileUpdated;
    public String field_fileVersion;
    public String field_groupId1;
    public String field_groupId2;
    public int field_keyVersion;
    public int field_maxRetryTimes;
    public String field_md5;
    public boolean field_needRetry;
    public int field_networkType;
    public String field_originalMd5;
    public String field_packageId;
    public int field_priority;
    public long field_reportId;
    public int field_resType;
    public int field_retryTimes;
    public String field_sampleId;
    public int field_status;
    public int field_subType;
    public String field_url;
    public String field_urlKey;
    public int field_urlKey_hashcode;
    public int field_wvCacheType;
    private boolean gAa = true;
    private boolean gAb = true;
    private boolean gAc = true;
    private boolean gAd = true;
    private boolean gAe = true;
    private boolean gAf = true;
    private boolean gAg = true;
    private boolean gAh = true;
    private boolean gAi = true;
    private boolean gAj = true;
    private boolean gAk = true;
    private boolean gAl = true;
    private boolean gAm = true;
    private boolean gAn = true;
    private boolean gAo = true;
    private boolean gAp = true;
    private boolean gAq = true;
    private boolean gAr = true;
    private boolean gAs = true;
    private boolean gAt = true;
    private boolean gAu = true;
    private boolean gAv = true;
    private boolean gAw = true;
    private boolean gAx = true;
    private boolean gAy = true;
    private boolean gAz = true;
    private boolean gaW = true;
    private boolean gbS = true;
    private boolean gcu = true;
    private boolean gii = true;
    private boolean gmV = true;
    private boolean gqs = true;
    private boolean gqu = true;
    private boolean gsf = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gAA == hashCode) {
                    this.field_urlKey_hashcode = cursor.getInt(i);
                    this.gAa = true;
                } else if (gAB == hashCode) {
                    this.field_urlKey = cursor.getString(i);
                } else if (giB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gAC == hashCode) {
                    this.field_fileVersion = cursor.getString(i);
                } else if (gAD == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (gAE == hashCode) {
                    this.field_maxRetryTimes = cursor.getInt(i);
                } else if (gAF == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (gqN == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gAG == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (gAH == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (gso == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gns == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gAI == hashCode) {
                    this.field_groupId1 = cursor.getString(i);
                } else if (gAJ == hashCode) {
                    this.field_groupId2 = cursor.getString(i);
                } else if (gAK == hashCode) {
                    this.field_priority = cursor.getInt(i);
                } else if (gAL == hashCode) {
                    this.field_fileUpdated = cursor.getInt(i) != 0;
                } else if (gAM == hashCode) {
                    this.field_deleted = cursor.getInt(i) != 0;
                } else if (gAN == hashCode) {
                    this.field_resType = cursor.getInt(i);
                } else if (gco == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (gAO == hashCode) {
                    this.field_reportId = cursor.getLong(i);
                } else if (gAP == hashCode) {
                    this.field_sampleId = cursor.getString(i);
                } else if (gAQ == hashCode) {
                    this.field_eccSignature = cursor.getBlob(i);
                } else if (gAR == hashCode) {
                    this.field_originalMd5 = cursor.getString(i);
                } else if (gAS == hashCode) {
                    this.field_fileCompress = cursor.getInt(i) != 0;
                } else if (gAT == hashCode) {
                    this.field_fileEncrypt = cursor.getInt(i) != 0;
                } else if (gAU == hashCode) {
                    this.field_encryptKey = cursor.getString(i);
                } else if (gAV == hashCode) {
                    this.field_keyVersion = cursor.getInt(i);
                } else if (gAW == hashCode) {
                    this.field_EID = cursor.getInt(i);
                } else if (gqL == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (gAX == hashCode) {
                    this.field_needRetry = cursor.getInt(i) != 0;
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gAY == hashCode) {
                    this.field_wvCacheType = cursor.getInt(i);
                } else if (gAZ == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gAa) {
            contentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
        }
        if (this.gAb) {
            contentValues.put("urlKey", this.field_urlKey);
        }
        if (this.gii) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gAc) {
            contentValues.put("fileVersion", this.field_fileVersion);
        }
        if (this.gAd) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.gAe) {
            contentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
        }
        if (this.gAf) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.gqu) {
            contentValues.put(DownloadInfoColumns.FILEPATH, this.field_filePath);
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gAg) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.gAh) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.gsf) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.gmV) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gAi) {
            contentValues.put("groupId1", this.field_groupId1);
        }
        if (this.gAj) {
            contentValues.put("groupId2", this.field_groupId2);
        }
        if (this.gAk) {
            contentValues.put(DownloadInfo.PRIORITY, Integer.valueOf(this.field_priority));
        }
        if (this.gAl) {
            contentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
        }
        if (this.gAm) {
            contentValues.put("deleted", Boolean.valueOf(this.field_deleted));
        }
        if (this.gAn) {
            contentValues.put("resType", Integer.valueOf(this.field_resType));
        }
        if (this.gbS) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.gAo) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.gAp) {
            contentValues.put("sampleId", this.field_sampleId);
        }
        if (this.gAq) {
            contentValues.put("eccSignature", this.field_eccSignature);
        }
        if (this.gAr) {
            contentValues.put("originalMd5", this.field_originalMd5);
        }
        if (this.gAs) {
            contentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
        }
        if (this.gAt) {
            contentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
        }
        if (this.gAu) {
            contentValues.put("encryptKey", this.field_encryptKey);
        }
        if (this.gAv) {
            contentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
        }
        if (this.gAw) {
            contentValues.put("EID", Integer.valueOf(this.field_EID));
        }
        if (this.gqs) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.gAx) {
            contentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gAy) {
            contentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
        }
        if (this.gAz) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
