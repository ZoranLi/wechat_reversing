package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.cy;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class s extends cy {
    protected static a gTP;

    protected final a sY() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hXH = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.uxd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "key";
        aVar.columns[1] = "cnValue";
        aVar.uxd.put("cnValue", "TEXT");
        stringBuilder.append(" cnValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "qqValue";
        aVar.uxd.put("qqValue", "TEXT");
        stringBuilder.append(" qqValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "twValue";
        aVar.uxd.put("twValue", "TEXT");
        stringBuilder.append(" twValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "enValue";
        aVar.uxd.put("enValue", "TEXT");
        stringBuilder.append(" enValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "thValue";
        aVar.uxd.put("thValue", "TEXT");
        stringBuilder.append(" thValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.FILENAME;
        aVar.uxd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "eggIndex";
        aVar.uxd.put("eggIndex", "INTEGER default '-1' ");
        stringBuilder.append(" eggIndex INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "position";
        aVar.uxd.put("position", "INTEGER default '-1' ");
        stringBuilder.append(" position INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "flag";
        aVar.uxd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        aVar.columns[10] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public s(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.field_key = str;
        this.field_cnValue = str3;
        this.field_qqValue = str2;
        this.field_enValue = str5;
        this.field_thValue = str6;
        this.field_twValue = str4;
        this.field_position = i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key:").append(this.field_key).append("/n");
        stringBuilder.append("cn:").append(this.field_cnValue).append("/n");
        stringBuilder.append("qq:").append(this.field_qqValue).append("/n");
        stringBuilder.append("en:").append(this.field_enValue).append("/n");
        stringBuilder.append("th:").append(this.field_thValue).append("/n");
        stringBuilder.append("tw:").append(this.field_twValue).append("/n");
        stringBuilder.append("position:").append(this.field_position).append("/n");
        stringBuilder.append("file Name:").append(this.field_fileName).append("/n");
        stringBuilder.append("egg index:").append(this.field_eggIndex).append("/n");
        return stringBuilder.toString();
    }
}
