package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class ch extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbn = "startTime".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int gyJ = "musicId".hashCode();
    private static final int gyK = "originMusicId".hashCode();
    private static final int gyL = "musicType".hashCode();
    private static final int gyM = "downloadedLength".hashCode();
    private static final int gyN = "wifiDownloadedLength".hashCode();
    private static final int gyO = "endFlag".hashCode();
    private static final int gyP = "wifiEndFlag".hashCode();
    private static final int gyQ = "songId".hashCode();
    private static final int gyR = "songName".hashCode();
    private static final int gyS = "songSinger".hashCode();
    private static final int gyT = "songAlbum".hashCode();
    private static final int gyU = "songAlbumType".hashCode();
    private static final int gyV = "songAlbumUrl".hashCode();
    private static final int gyW = "songHAlbumUrl".hashCode();
    private static final int gyX = "songAlbumLocalPath".hashCode();
    private static final int gyY = "songWifiUrl".hashCode();
    private static final int gyZ = "songWapLinkUrl".hashCode();
    private static final int gza = "songWebUrl".hashCode();
    private static final int gzb = "songMediaId".hashCode();
    private static final int gzc = "songSnsAlbumUser".hashCode();
    private static final int gzd = "songSnsShareUser".hashCode();
    private static final int gze = "songLyric".hashCode();
    private static final int gzf = "songBgColor".hashCode();
    private static final int gzg = "songLyricColor".hashCode();
    private static final int gzh = "songFileLength".hashCode();
    private static final int gzi = "songWifiFileLength".hashCode();
    private static final int gzj = "hideBanner".hashCode();
    private static final int gzk = "jsWebUrlDomain".hashCode();
    private static final int gzl = "isBlock".hashCode();
    public String field_appId;
    public long field_downloadedLength;
    public int field_endFlag;
    public boolean field_hideBanner;
    public int field_isBlock;
    public String field_jsWebUrlDomain;
    public String field_musicId;
    public int field_musicType;
    public String field_originMusicId;
    public String field_songAlbum;
    public String field_songAlbumLocalPath;
    public int field_songAlbumType;
    public String field_songAlbumUrl;
    public int field_songBgColor;
    public long field_songFileLength;
    public String field_songHAlbumUrl;
    public int field_songId;
    public String field_songLyric;
    public int field_songLyricColor;
    public String field_songMediaId;
    public String field_songName;
    public String field_songSinger;
    public String field_songSnsAlbumUser;
    public String field_songSnsShareUser;
    public String field_songWapLinkUrl;
    public String field_songWebUrl;
    public long field_songWifiFileLength;
    public String field_songWifiUrl;
    public int field_startTime;
    public long field_updateTime;
    public long field_wifiDownloadedLength;
    public int field_wifiEndFlag;
    private boolean gbf = true;
    private boolean gcu = true;
    private boolean gdn = true;
    private boolean gyA = true;
    private boolean gyB = true;
    private boolean gyC = true;
    private boolean gyD = true;
    private boolean gyE = true;
    private boolean gyF = true;
    private boolean gyG = true;
    private boolean gyH = true;
    private boolean gyI = true;
    private boolean gyg = true;
    private boolean gyh = true;
    private boolean gyi = true;
    private boolean gyj = true;
    private boolean gyk = true;
    private boolean gyl = true;
    private boolean gym = true;
    private boolean gyn = true;
    private boolean gyo = true;
    private boolean gyp = true;
    private boolean gyq = true;
    private boolean gyr = true;
    private boolean gys = true;
    private boolean gyt = true;
    private boolean gyu = true;
    private boolean gyv = true;
    private boolean gyw = true;
    private boolean gyx = true;
    private boolean gyy = true;
    private boolean gyz = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[32];
        aVar.columns = new String[33];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.uxd.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "musicId";
        aVar.columns[1] = "originMusicId";
        aVar.uxd.put("originMusicId", "TEXT");
        stringBuilder.append(" originMusicId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "musicType";
        aVar.uxd.put("musicType", "INTEGER");
        stringBuilder.append(" musicType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "downloadedLength";
        aVar.uxd.put("downloadedLength", "LONG");
        stringBuilder.append(" downloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "wifiDownloadedLength";
        aVar.uxd.put("wifiDownloadedLength", "LONG");
        stringBuilder.append(" wifiDownloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "endFlag";
        aVar.uxd.put("endFlag", "INTEGER");
        stringBuilder.append(" endFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiEndFlag";
        aVar.uxd.put("wifiEndFlag", "INTEGER");
        stringBuilder.append(" wifiEndFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateTime";
        aVar.uxd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "songId";
        aVar.uxd.put("songId", "INTEGER");
        stringBuilder.append(" songId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "songName";
        aVar.uxd.put("songName", "TEXT");
        stringBuilder.append(" songName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "songSinger";
        aVar.uxd.put("songSinger", "TEXT");
        stringBuilder.append(" songSinger TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "songAlbum";
        aVar.uxd.put("songAlbum", "TEXT");
        stringBuilder.append(" songAlbum TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "songAlbumType";
        aVar.uxd.put("songAlbumType", "INTEGER");
        stringBuilder.append(" songAlbumType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "songAlbumUrl";
        aVar.uxd.put("songAlbumUrl", "TEXT");
        stringBuilder.append(" songAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "songHAlbumUrl";
        aVar.uxd.put("songHAlbumUrl", "TEXT");
        stringBuilder.append(" songHAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "songAlbumLocalPath";
        aVar.uxd.put("songAlbumLocalPath", "TEXT");
        stringBuilder.append(" songAlbumLocalPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "songWifiUrl";
        aVar.uxd.put("songWifiUrl", "TEXT");
        stringBuilder.append(" songWifiUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "songWapLinkUrl";
        aVar.uxd.put("songWapLinkUrl", "TEXT");
        stringBuilder.append(" songWapLinkUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "songWebUrl";
        aVar.uxd.put("songWebUrl", "TEXT");
        stringBuilder.append(" songWebUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "songMediaId";
        aVar.uxd.put("songMediaId", "TEXT");
        stringBuilder.append(" songMediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "songSnsAlbumUser";
        aVar.uxd.put("songSnsAlbumUser", "TEXT");
        stringBuilder.append(" songSnsAlbumUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "songSnsShareUser";
        aVar.uxd.put("songSnsShareUser", "TEXT");
        stringBuilder.append(" songSnsShareUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "songLyric";
        aVar.uxd.put("songLyric", "TEXT");
        stringBuilder.append(" songLyric TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "songBgColor";
        aVar.uxd.put("songBgColor", "INTEGER");
        stringBuilder.append(" songBgColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[25] = "songLyricColor";
        aVar.uxd.put("songLyricColor", "INTEGER");
        stringBuilder.append(" songLyricColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "songFileLength";
        aVar.uxd.put("songFileLength", "LONG");
        stringBuilder.append(" songFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[27] = "songWifiFileLength";
        aVar.uxd.put("songWifiFileLength", "LONG");
        stringBuilder.append(" songWifiFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[28] = "hideBanner";
        aVar.uxd.put("hideBanner", "INTEGER");
        stringBuilder.append(" hideBanner INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "jsWebUrlDomain";
        aVar.uxd.put("jsWebUrlDomain", "TEXT");
        stringBuilder.append(" jsWebUrlDomain TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "isBlock";
        aVar.uxd.put("isBlock", "INTEGER");
        stringBuilder.append(" isBlock INTEGER");
        stringBuilder.append(", ");
        aVar.columns[31] = "startTime";
        aVar.uxd.put("startTime", "INTEGER");
        stringBuilder.append(" startTime INTEGER");
        aVar.columns[32] = "rowid";
        aVar.uxe = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gyJ == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.gyg = true;
                } else if (gyK == hashCode) {
                    this.field_originMusicId = cursor.getString(i);
                } else if (gyL == hashCode) {
                    this.field_musicType = cursor.getInt(i);
                } else if (gyM == hashCode) {
                    this.field_downloadedLength = cursor.getLong(i);
                } else if (gyN == hashCode) {
                    this.field_wifiDownloadedLength = cursor.getLong(i);
                } else if (gyO == hashCode) {
                    this.field_endFlag = cursor.getInt(i);
                } else if (gyP == hashCode) {
                    this.field_wifiEndFlag = cursor.getInt(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gyQ == hashCode) {
                    this.field_songId = cursor.getInt(i);
                } else if (gyR == hashCode) {
                    this.field_songName = cursor.getString(i);
                } else if (gyS == hashCode) {
                    this.field_songSinger = cursor.getString(i);
                } else if (gyT == hashCode) {
                    this.field_songAlbum = cursor.getString(i);
                } else if (gyU == hashCode) {
                    this.field_songAlbumType = cursor.getInt(i);
                } else if (gyV == hashCode) {
                    this.field_songAlbumUrl = cursor.getString(i);
                } else if (gyW == hashCode) {
                    this.field_songHAlbumUrl = cursor.getString(i);
                } else if (gyX == hashCode) {
                    this.field_songAlbumLocalPath = cursor.getString(i);
                } else if (gyY == hashCode) {
                    this.field_songWifiUrl = cursor.getString(i);
                } else if (gyZ == hashCode) {
                    this.field_songWapLinkUrl = cursor.getString(i);
                } else if (gza == hashCode) {
                    this.field_songWebUrl = cursor.getString(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gzb == hashCode) {
                    this.field_songMediaId = cursor.getString(i);
                } else if (gzc == hashCode) {
                    this.field_songSnsAlbumUser = cursor.getString(i);
                } else if (gzd == hashCode) {
                    this.field_songSnsShareUser = cursor.getString(i);
                } else if (gze == hashCode) {
                    this.field_songLyric = cursor.getString(i);
                } else if (gzf == hashCode) {
                    this.field_songBgColor = cursor.getInt(i);
                } else if (gzg == hashCode) {
                    this.field_songLyricColor = cursor.getInt(i);
                } else if (gzh == hashCode) {
                    this.field_songFileLength = cursor.getLong(i);
                } else if (gzi == hashCode) {
                    this.field_songWifiFileLength = cursor.getLong(i);
                } else if (gzj == hashCode) {
                    this.field_hideBanner = cursor.getInt(i) != 0;
                } else if (gzk == hashCode) {
                    this.field_jsWebUrlDomain = cursor.getString(i);
                } else if (gzl == hashCode) {
                    this.field_isBlock = cursor.getInt(i);
                } else if (gbn == hashCode) {
                    this.field_startTime = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gyg) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.gyh) {
            contentValues.put("originMusicId", this.field_originMusicId);
        }
        if (this.gyi) {
            contentValues.put("musicType", Integer.valueOf(this.field_musicType));
        }
        if (this.gyj) {
            contentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
        }
        if (this.gyk) {
            contentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
        }
        if (this.gyl) {
            contentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
        }
        if (this.gym) {
            contentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gyn) {
            contentValues.put("songId", Integer.valueOf(this.field_songId));
        }
        if (this.gyo) {
            contentValues.put("songName", this.field_songName);
        }
        if (this.gyp) {
            contentValues.put("songSinger", this.field_songSinger);
        }
        if (this.gyq) {
            contentValues.put("songAlbum", this.field_songAlbum);
        }
        if (this.gyr) {
            contentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
        }
        if (this.gys) {
            contentValues.put("songAlbumUrl", this.field_songAlbumUrl);
        }
        if (this.gyt) {
            contentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
        }
        if (this.gyu) {
            contentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
        }
        if (this.gyv) {
            contentValues.put("songWifiUrl", this.field_songWifiUrl);
        }
        if (this.gyw) {
            contentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
        }
        if (this.gyx) {
            contentValues.put("songWebUrl", this.field_songWebUrl);
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gyy) {
            contentValues.put("songMediaId", this.field_songMediaId);
        }
        if (this.gyz) {
            contentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
        }
        if (this.gyA) {
            contentValues.put("songSnsShareUser", this.field_songSnsShareUser);
        }
        if (this.gyB) {
            contentValues.put("songLyric", this.field_songLyric);
        }
        if (this.gyC) {
            contentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
        }
        if (this.gyD) {
            contentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
        }
        if (this.gyE) {
            contentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
        }
        if (this.gyF) {
            contentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
        }
        if (this.gyG) {
            contentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
        }
        if (this.gyH) {
            contentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
        }
        if (this.gyI) {
            contentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
        }
        if (this.gbf) {
            contentValues.put("startTime", Integer.valueOf(this.field_startTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
