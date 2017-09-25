package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ca extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gbk = "expId".hashCode();
    private static final int gbl = "sequence".hashCode();
    private static final int gbm = "prioritylevel".hashCode();
    private static final int gvU = "LabsAppId".hashCode();
    private static final int gvV = "Type".hashCode();
    private static final int gvW = "BizType".hashCode();
    private static final int gvX = "Switch".hashCode();
    private static final int gvY = "AllVer".hashCode();
    private static final int gvZ = "DetailURL".hashCode();
    private static final int gwA = "RedPoint".hashCode();
    private static final int gwB = "WeAppDebugMode".hashCode();
    private static final int gwC = "idkey".hashCode();
    private static final int gwD = "idkeyValue".hashCode();
    private static final int gwE = "Icon".hashCode();
    private static final int gwF = "ImgUrl_cn".hashCode();
    private static final int gwG = "ImgUrl_hk".hashCode();
    private static final int gwH = "ImgUrl_tw".hashCode();
    private static final int gwI = "ImgUrl_en".hashCode();
    private static final int gwa = "WeAppUser".hashCode();
    private static final int gwb = "WeAppPath".hashCode();
    private static final int gwc = "Pos".hashCode();
    private static final int gwd = "TitleKey_android".hashCode();
    private static final int gwe = "Title_cn".hashCode();
    private static final int gwf = "Title_hk".hashCode();
    private static final int gwg = "Title_tw".hashCode();
    private static final int gwh = "Title_en".hashCode();
    private static final int gwi = "Desc_cn".hashCode();
    private static final int gwj = "Desc_hk".hashCode();
    private static final int gwk = "Desc_tw".hashCode();
    private static final int gwl = "Desc_en".hashCode();
    private static final int gwm = "Introduce_cn".hashCode();
    private static final int gwn = "Introduce_hk".hashCode();
    private static final int gwo = "Introduce_tw".hashCode();
    private static final int gwp = "Introduce_en".hashCode();
    private static final int gwq = "starttime".hashCode();
    private static final int gwr = "endtime".hashCode();
    private static final int gws = "ThumbUrl_cn".hashCode();
    private static final int gwt = "ThumbUrl_hk".hashCode();
    private static final int gwu = "ThumbUrl_tw".hashCode();
    private static final int gwv = "ThumbUrl_en".hashCode();
    private static final int gww = "ImgUrl_android_cn".hashCode();
    private static final int gwx = "ImgUrl_android_hk".hashCode();
    private static final int gwy = "ImgUrl_android_tw".hashCode();
    private static final int gwz = "ImgUrl_android_en".hashCode();
    public int field_AllVer;
    public int field_BizType;
    public String field_Desc_cn;
    public String field_Desc_en;
    public String field_Desc_hk;
    public String field_Desc_tw;
    public String field_DetailURL;
    public String field_Icon;
    public String field_ImgUrl_android_cn;
    public String field_ImgUrl_android_en;
    public String field_ImgUrl_android_hk;
    public String field_ImgUrl_android_tw;
    public String field_ImgUrl_cn;
    public String field_ImgUrl_en;
    public String field_ImgUrl_hk;
    public String field_ImgUrl_tw;
    public String field_Introduce_cn;
    public String field_Introduce_en;
    public String field_Introduce_hk;
    public String field_Introduce_tw;
    public String field_LabsAppId;
    public int field_Pos;
    public int field_RedPoint;
    public int field_Switch;
    public String field_ThumbUrl_cn;
    public String field_ThumbUrl_en;
    public String field_ThumbUrl_hk;
    public String field_ThumbUrl_tw;
    public String field_TitleKey_android;
    public String field_Title_cn;
    public String field_Title_en;
    public String field_Title_hk;
    public String field_Title_tw;
    public int field_Type;
    public int field_WeAppDebugMode;
    public String field_WeAppPath;
    public String field_WeAppUser;
    public long field_endtime;
    public String field_expId;
    public int field_idkey;
    public int field_idkeyValue;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_starttime;
    public int field_status;
    private boolean gaW = true;
    private boolean gbc = true;
    private boolean gbd = true;
    private boolean gbe = true;
    private boolean gvA = true;
    private boolean gvB = true;
    private boolean gvC = true;
    private boolean gvD = true;
    private boolean gvE = true;
    private boolean gvF = true;
    private boolean gvG = true;
    private boolean gvH = true;
    private boolean gvI = true;
    private boolean gvJ = true;
    private boolean gvK = true;
    private boolean gvL = true;
    private boolean gvM = true;
    private boolean gvN = true;
    private boolean gvO = true;
    private boolean gvP = true;
    private boolean gvQ = true;
    private boolean gvR = true;
    private boolean gvS = true;
    private boolean gvT = true;
    private boolean gvf = true;
    private boolean gvg = true;
    private boolean gvh = true;
    private boolean gvi = true;
    private boolean gvj = true;
    private boolean gvk = true;
    private boolean gvl = true;
    private boolean gvm = true;
    private boolean gvn = true;
    private boolean gvo = true;
    private boolean gvp = true;
    private boolean gvq = true;
    private boolean gvr = true;
    private boolean gvs = true;
    private boolean gvt = true;
    private boolean gvu = true;
    private boolean gvv = true;
    private boolean gvw = true;
    private boolean gvx = true;
    private boolean gvy = true;
    private boolean gvz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gvU == hashCode) {
                    this.field_LabsAppId = cursor.getString(i);
                    this.gvf = true;
                } else if (gbk == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (gvV == hashCode) {
                    this.field_Type = cursor.getInt(i);
                } else if (gvW == hashCode) {
                    this.field_BizType = cursor.getInt(i);
                } else if (gvX == hashCode) {
                    this.field_Switch = cursor.getInt(i);
                } else if (gvY == hashCode) {
                    this.field_AllVer = cursor.getInt(i);
                } else if (gvZ == hashCode) {
                    this.field_DetailURL = cursor.getString(i);
                } else if (gwa == hashCode) {
                    this.field_WeAppUser = cursor.getString(i);
                } else if (gwb == hashCode) {
                    this.field_WeAppPath = cursor.getString(i);
                } else if (gwc == hashCode) {
                    this.field_Pos = cursor.getInt(i);
                } else if (gwd == hashCode) {
                    this.field_TitleKey_android = cursor.getString(i);
                } else if (gwe == hashCode) {
                    this.field_Title_cn = cursor.getString(i);
                } else if (gwf == hashCode) {
                    this.field_Title_hk = cursor.getString(i);
                } else if (gwg == hashCode) {
                    this.field_Title_tw = cursor.getString(i);
                } else if (gwh == hashCode) {
                    this.field_Title_en = cursor.getString(i);
                } else if (gwi == hashCode) {
                    this.field_Desc_cn = cursor.getString(i);
                } else if (gwj == hashCode) {
                    this.field_Desc_hk = cursor.getString(i);
                } else if (gwk == hashCode) {
                    this.field_Desc_tw = cursor.getString(i);
                } else if (gwl == hashCode) {
                    this.field_Desc_en = cursor.getString(i);
                } else if (gwm == hashCode) {
                    this.field_Introduce_cn = cursor.getString(i);
                } else if (gwn == hashCode) {
                    this.field_Introduce_hk = cursor.getString(i);
                } else if (gwo == hashCode) {
                    this.field_Introduce_tw = cursor.getString(i);
                } else if (gwp == hashCode) {
                    this.field_Introduce_en = cursor.getString(i);
                } else if (gwq == hashCode) {
                    this.field_starttime = cursor.getLong(i);
                } else if (gwr == hashCode) {
                    this.field_endtime = cursor.getLong(i);
                } else if (gbl == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (gbm == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gws == hashCode) {
                    this.field_ThumbUrl_cn = cursor.getString(i);
                } else if (gwt == hashCode) {
                    this.field_ThumbUrl_hk = cursor.getString(i);
                } else if (gwu == hashCode) {
                    this.field_ThumbUrl_tw = cursor.getString(i);
                } else if (gwv == hashCode) {
                    this.field_ThumbUrl_en = cursor.getString(i);
                } else if (gww == hashCode) {
                    this.field_ImgUrl_android_cn = cursor.getString(i);
                } else if (gwx == hashCode) {
                    this.field_ImgUrl_android_hk = cursor.getString(i);
                } else if (gwy == hashCode) {
                    this.field_ImgUrl_android_tw = cursor.getString(i);
                } else if (gwz == hashCode) {
                    this.field_ImgUrl_android_en = cursor.getString(i);
                } else if (gwA == hashCode) {
                    this.field_RedPoint = cursor.getInt(i);
                } else if (gwB == hashCode) {
                    this.field_WeAppDebugMode = cursor.getInt(i);
                } else if (gwC == hashCode) {
                    this.field_idkey = cursor.getInt(i);
                } else if (gwD == hashCode) {
                    this.field_idkeyValue = cursor.getInt(i);
                } else if (gwE == hashCode) {
                    this.field_Icon = cursor.getString(i);
                } else if (gwF == hashCode) {
                    this.field_ImgUrl_cn = cursor.getString(i);
                } else if (gwG == hashCode) {
                    this.field_ImgUrl_hk = cursor.getString(i);
                } else if (gwH == hashCode) {
                    this.field_ImgUrl_tw = cursor.getString(i);
                } else if (gwI == hashCode) {
                    this.field_ImgUrl_en = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gvf) {
            contentValues.put("LabsAppId", this.field_LabsAppId);
        }
        if (this.field_expId == null) {
            this.field_expId = "";
        }
        if (this.gbc) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.gvg) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.gvh) {
            contentValues.put("BizType", Integer.valueOf(this.field_BizType));
        }
        if (this.gvi) {
            contentValues.put("Switch", Integer.valueOf(this.field_Switch));
        }
        if (this.gvj) {
            contentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
        }
        if (this.gvk) {
            contentValues.put("DetailURL", this.field_DetailURL);
        }
        if (this.gvl) {
            contentValues.put("WeAppUser", this.field_WeAppUser);
        }
        if (this.gvm) {
            contentValues.put("WeAppPath", this.field_WeAppPath);
        }
        if (this.gvn) {
            contentValues.put("Pos", Integer.valueOf(this.field_Pos));
        }
        if (this.gvo) {
            contentValues.put("TitleKey_android", this.field_TitleKey_android);
        }
        if (this.gvp) {
            contentValues.put("Title_cn", this.field_Title_cn);
        }
        if (this.gvq) {
            contentValues.put("Title_hk", this.field_Title_hk);
        }
        if (this.gvr) {
            contentValues.put("Title_tw", this.field_Title_tw);
        }
        if (this.gvs) {
            contentValues.put("Title_en", this.field_Title_en);
        }
        if (this.gvt) {
            contentValues.put("Desc_cn", this.field_Desc_cn);
        }
        if (this.gvu) {
            contentValues.put("Desc_hk", this.field_Desc_hk);
        }
        if (this.gvv) {
            contentValues.put("Desc_tw", this.field_Desc_tw);
        }
        if (this.gvw) {
            contentValues.put("Desc_en", this.field_Desc_en);
        }
        if (this.gvx) {
            contentValues.put("Introduce_cn", this.field_Introduce_cn);
        }
        if (this.gvy) {
            contentValues.put("Introduce_hk", this.field_Introduce_hk);
        }
        if (this.gvz) {
            contentValues.put("Introduce_tw", this.field_Introduce_tw);
        }
        if (this.gvA) {
            contentValues.put("Introduce_en", this.field_Introduce_en);
        }
        if (this.gvB) {
            contentValues.put("starttime", Long.valueOf(this.field_starttime));
        }
        if (this.gvC) {
            contentValues.put("endtime", Long.valueOf(this.field_endtime));
        }
        if (this.gbd) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.gbe) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gvD) {
            contentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
        }
        if (this.gvE) {
            contentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
        }
        if (this.gvF) {
            contentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
        }
        if (this.gvG) {
            contentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
        }
        if (this.gvH) {
            contentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
        }
        if (this.gvI) {
            contentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
        }
        if (this.gvJ) {
            contentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
        }
        if (this.gvK) {
            contentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
        }
        if (this.gvL) {
            contentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
        }
        if (this.gvM) {
            contentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
        }
        if (this.gvN) {
            contentValues.put("idkey", Integer.valueOf(this.field_idkey));
        }
        if (this.gvO) {
            contentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
        }
        if (this.gvP) {
            contentValues.put("Icon", this.field_Icon);
        }
        if (this.gvQ) {
            contentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
        }
        if (this.gvR) {
            contentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
        }
        if (this.gvS) {
            contentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
        }
        if (this.gvT) {
            contentValues.put("ImgUrl_en", this.field_ImgUrl_en);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
