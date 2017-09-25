package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.mm.e.b.ct;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public final class d extends ct {
    protected static a gTP;
    public int fRW;
    private avw pok;
    public int scene;

    static {
        a aVar = new a();
        aVar.hXH = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "shakeItemID";
        aVar.uxd.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "shakeItemID";
        aVar.columns[1] = "username";
        aVar.uxd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "nickname";
        aVar.uxd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "province";
        aVar.uxd.put("province", "TEXT");
        stringBuilder.append(" province TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "city";
        aVar.uxd.put("city", "TEXT");
        stringBuilder.append(" city TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "signature";
        aVar.uxd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "distance";
        aVar.uxd.put("distance", "TEXT");
        stringBuilder.append(" distance TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "sex";
        aVar.uxd.put("sex", "INTEGER");
        stringBuilder.append(" sex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "imgstatus";
        aVar.uxd.put("imgstatus", "INTEGER");
        stringBuilder.append(" imgstatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "hasHDImg";
        aVar.uxd.put("hasHDImg", "INTEGER");
        stringBuilder.append(" hasHDImg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "insertBatch";
        aVar.uxd.put("insertBatch", "INTEGER");
        stringBuilder.append(" insertBatch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved1";
        aVar.uxd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved2";
        aVar.uxd.put("reserved2", "INTEGER");
        stringBuilder.append(" reserved2 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "reserved3";
        aVar.uxd.put("reserved3", "TEXT");
        stringBuilder.append(" reserved3 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "reserved4";
        aVar.uxd.put("reserved4", "TEXT");
        stringBuilder.append(" reserved4 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "lvbuffer";
        aVar.uxd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[17] = "regionCode";
        aVar.uxd.put("regionCode", "TEXT");
        stringBuilder.append(" regionCode TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "snsFlag";
        aVar.uxd.put("snsFlag", "INTEGER");
        stringBuilder.append(" snsFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "sns_bgurl";
        aVar.uxd.put("sns_bgurl", "TEXT");
        stringBuilder.append(" sns_bgurl TEXT");
        aVar.columns[20] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public d() {
        this.fRW = -1;
        this.field_insertBatch = 2;
    }

    public d(azi com_tencent_mm_protocal_c_azi) {
        this.fRW = -1;
        this.field_username = com_tencent_mm_protocal_c_azi.jNj;
        this.field_nickname = com_tencent_mm_protocal_c_azi.jOp;
        this.field_signature = com_tencent_mm_protocal_c_azi.hAG;
        this.field_distance = com_tencent_mm_protocal_c_azi.tMO;
        this.field_reserved4 = String.valueOf(com_tencent_mm_protocal_c_azi.uaH);
        this.field_sex = com_tencent_mm_protocal_c_azi.hAD;
        this.field_imgstatus = com_tencent_mm_protocal_c_azi.tfg;
        this.field_hasHDImg = com_tencent_mm_protocal_c_azi.uaF;
        this.field_reserved1 = com_tencent_mm_protocal_c_azi.tMP;
        this.field_reserved3 = com_tencent_mm_protocal_c_azi.tMQ;
        this.field_insertBatch = 2;
        if (com_tencent_mm_protocal_c_azi.tMV != null) {
            this.field_snsFlag = com_tencent_mm_protocal_c_azi.tMV.hAO;
            this.field_sns_bgurl = com_tencent_mm_protocal_c_azi.tMV.hAP;
        }
        this.pok = com_tencent_mm_protocal_c_azi.uaG;
        this.field_province = com_tencent_mm_protocal_c_azi.hAE;
        this.field_city = com_tencent_mm_protocal_c_azi.hAF;
        this.field_regionCode = RegionCodeDecoder.ab(com_tencent_mm_protocal_c_azi.hAM, this.field_province, this.field_city);
    }

    public final String getProvince() {
        if (!bg.mA(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    this.field_province = RegionCodeDecoder.bMP().RS(split[0]);
                } else {
                    this.field_province = RegionCodeDecoder.bMP().eL(split[0], split[1]);
                }
            }
        }
        return this.field_province;
    }

    public final String getCity() {
        if (!bg.mA(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    this.field_city = RegionCodeDecoder.bMP().ac(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    this.field_city = RegionCodeDecoder.bMP().eL(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        return this.field_city;
    }

    private int baG() {
        try {
            return Integer.valueOf(this.field_reserved4).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 2) != 0) {
            contentValues.put("username", this.field_username);
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("nickname", this.field_nickname);
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("province", getProvince());
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("city", getCity());
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("signature", this.field_signature);
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("distance", this.field_distance);
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if ((this.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if ((this.fRW & 8192) != 0) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if ((this.fRW & 16384) != 0) {
            contentValues.put("reserved4", Integer.valueOf(baG()));
        }
        if ((this.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if ((this.fRW & 65536) != 0) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if ((this.fRW & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if ((this.fRW & 262144) != 0) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if ((this.fRW & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        return contentValues;
    }
}
