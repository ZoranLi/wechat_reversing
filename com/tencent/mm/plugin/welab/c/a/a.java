package com.tencent.mm.plugin.welab.c.a;

import android.text.TextUtils;
import com.tencent.mm.e.b.ca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends ca {
    public static com.tencent.mm.sdk.e.c.a gTP;
    private static final List<String> ssV = Arrays.asList(new String[]{"_cn", "_hk", "_tw", "_en"});
    private Map<String, Field> ssU = new HashMap();

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[45];
        aVar.columns = new String[46];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "LabsAppId";
        aVar.uxd.put("LabsAppId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "LabsAppId";
        aVar.columns[1] = "expId";
        aVar.uxd.put("expId", "TEXT default '' ");
        stringBuilder.append(" expId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "Type";
        aVar.uxd.put("Type", "INTEGER default '0' ");
        stringBuilder.append(" Type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "BizType";
        aVar.uxd.put("BizType", "INTEGER default '0' ");
        stringBuilder.append(" BizType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "Switch";
        aVar.uxd.put("Switch", "INTEGER default '0' ");
        stringBuilder.append(" Switch INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "AllVer";
        aVar.uxd.put("AllVer", "INTEGER default '0' ");
        stringBuilder.append(" AllVer INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "DetailURL";
        aVar.uxd.put("DetailURL", "TEXT");
        stringBuilder.append(" DetailURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "WeAppUser";
        aVar.uxd.put("WeAppUser", "TEXT");
        stringBuilder.append(" WeAppUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "WeAppPath";
        aVar.uxd.put("WeAppPath", "TEXT");
        stringBuilder.append(" WeAppPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "Pos";
        aVar.uxd.put("Pos", "INTEGER default '0' ");
        stringBuilder.append(" Pos INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "TitleKey_android";
        aVar.uxd.put("TitleKey_android", "TEXT");
        stringBuilder.append(" TitleKey_android TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "Title_cn";
        aVar.uxd.put("Title_cn", "TEXT");
        stringBuilder.append(" Title_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "Title_hk";
        aVar.uxd.put("Title_hk", "TEXT");
        stringBuilder.append(" Title_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "Title_tw";
        aVar.uxd.put("Title_tw", "TEXT");
        stringBuilder.append(" Title_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "Title_en";
        aVar.uxd.put("Title_en", "TEXT");
        stringBuilder.append(" Title_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "Desc_cn";
        aVar.uxd.put("Desc_cn", "TEXT");
        stringBuilder.append(" Desc_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "Desc_hk";
        aVar.uxd.put("Desc_hk", "TEXT");
        stringBuilder.append(" Desc_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "Desc_tw";
        aVar.uxd.put("Desc_tw", "TEXT");
        stringBuilder.append(" Desc_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "Desc_en";
        aVar.uxd.put("Desc_en", "TEXT");
        stringBuilder.append(" Desc_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "Introduce_cn";
        aVar.uxd.put("Introduce_cn", "TEXT");
        stringBuilder.append(" Introduce_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "Introduce_hk";
        aVar.uxd.put("Introduce_hk", "TEXT");
        stringBuilder.append(" Introduce_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "Introduce_tw";
        aVar.uxd.put("Introduce_tw", "TEXT");
        stringBuilder.append(" Introduce_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "Introduce_en";
        aVar.uxd.put("Introduce_en", "TEXT");
        stringBuilder.append(" Introduce_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "starttime";
        aVar.uxd.put("starttime", "LONG");
        stringBuilder.append(" starttime LONG");
        stringBuilder.append(", ");
        aVar.columns[24] = "endtime";
        aVar.uxd.put("endtime", "LONG");
        stringBuilder.append(" endtime LONG");
        stringBuilder.append(", ");
        aVar.columns[25] = "sequence";
        aVar.uxd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[26] = "prioritylevel";
        aVar.uxd.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[27] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[28] = "ThumbUrl_cn";
        aVar.uxd.put("ThumbUrl_cn", "TEXT");
        stringBuilder.append(" ThumbUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "ThumbUrl_hk";
        aVar.uxd.put("ThumbUrl_hk", "TEXT");
        stringBuilder.append(" ThumbUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "ThumbUrl_tw";
        aVar.uxd.put("ThumbUrl_tw", "TEXT");
        stringBuilder.append(" ThumbUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "ThumbUrl_en";
        aVar.uxd.put("ThumbUrl_en", "TEXT");
        stringBuilder.append(" ThumbUrl_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "ImgUrl_android_cn";
        aVar.uxd.put("ImgUrl_android_cn", "TEXT");
        stringBuilder.append(" ImgUrl_android_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "ImgUrl_android_hk";
        aVar.uxd.put("ImgUrl_android_hk", "TEXT");
        stringBuilder.append(" ImgUrl_android_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "ImgUrl_android_tw";
        aVar.uxd.put("ImgUrl_android_tw", "TEXT");
        stringBuilder.append(" ImgUrl_android_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "ImgUrl_android_en";
        aVar.uxd.put("ImgUrl_android_en", "TEXT");
        stringBuilder.append(" ImgUrl_android_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "RedPoint";
        aVar.uxd.put("RedPoint", "INTEGER");
        stringBuilder.append(" RedPoint INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "WeAppDebugMode";
        aVar.uxd.put("WeAppDebugMode", "INTEGER");
        stringBuilder.append(" WeAppDebugMode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "idkey";
        aVar.uxd.put("idkey", "INTEGER");
        stringBuilder.append(" idkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[39] = "idkeyValue";
        aVar.uxd.put("idkeyValue", "INTEGER");
        stringBuilder.append(" idkeyValue INTEGER");
        stringBuilder.append(", ");
        aVar.columns[40] = "Icon";
        aVar.uxd.put("Icon", "TEXT");
        stringBuilder.append(" Icon TEXT");
        stringBuilder.append(", ");
        aVar.columns[41] = "ImgUrl_cn";
        aVar.uxd.put("ImgUrl_cn", "TEXT");
        stringBuilder.append(" ImgUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[42] = "ImgUrl_hk";
        aVar.uxd.put("ImgUrl_hk", "TEXT");
        stringBuilder.append(" ImgUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[43] = "ImgUrl_tw";
        aVar.uxd.put("ImgUrl_tw", "TEXT");
        stringBuilder.append(" ImgUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[44] = "ImgUrl_en";
        aVar.uxd.put("ImgUrl_en", "TEXT");
        stringBuilder.append(" ImgUrl_en TEXT");
        aVar.columns[45] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public int hashCode() {
        return this.field_LabsAppId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return ((a) obj).field_LabsAppId.equals(this.field_LabsAppId);
        }
        return false;
    }

    public final boolean isValid() {
        return !TextUtils.isEmpty(this.field_LabsAppId);
    }

    public final boolean isRunning() {
        return isValid() && System.currentTimeMillis() / 1000 > this.field_starttime && System.currentTimeMillis() / 1000 < this.field_endtime;
    }

    public final boolean bAQ() {
        return isValid() && System.currentTimeMillis() / 1000 >= this.field_endtime;
    }

    public String toString() {
        return "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + "]";
    }

    public final String Lb(String str) {
        Object rc = rc(str + "Key_android");
        if (!TextUtils.isEmpty(rc)) {
            rc = ab.getResources().getString(ab.getResources().getIdentifier(rc, "string", ab.getPackageName()));
            if (!TextUtils.isEmpty(rc)) {
                return rc;
            }
        }
        String ea = v.ea(ab.getContext());
        if (v.bIK()) {
            return ee(str, "_cn");
        }
        if ("zh_HK".equals(ea)) {
            return ee(str, "_hk");
        }
        if ("zh_TW".equals(ea)) {
            return ee(str, "_tw");
        }
        return ee(str, "_en");
    }

    private String ee(String str, String str2) {
        Object rc = rc(str + str2);
        return !TextUtils.isEmpty(rc) ? rc : Lc(str);
    }

    private String Lc(String str) {
        for (String str2 : ssV) {
            String str22 = rc(str + str22);
            if (!TextUtils.isEmpty(str22)) {
                return str22;
            }
        }
        return "";
    }

    private String rc(String str) {
        Field field;
        Throwable e;
        Field field2 = (Field) this.ssU.get(str);
        if (field2 == null) {
            try {
                field = a.class.getField(str);
                try {
                    this.ssU.put(str, field);
                } catch (NoSuchFieldException e2) {
                    e = e2;
                    w.w("LabAppInfo", bg.g(e));
                    if (field != null) {
                        try {
                            return (String) field.get(this);
                        } catch (Throwable e3) {
                            w.w("LabAppInfo", bg.g(e3));
                        }
                    }
                    return "";
                }
            } catch (Throwable e4) {
                Throwable th = e4;
                field = field2;
                e3 = th;
                w.w("LabAppInfo", bg.g(e3));
                if (field != null) {
                    return (String) field.get(this);
                }
                return "";
            }
        }
        field = field2;
        if (field != null) {
            return (String) field.get(this);
        }
        return "";
    }

    public final boolean bAR() {
        return isRunning() && (this.field_Switch == 2 || this.field_Switch == 1);
    }
}
