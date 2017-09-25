package com.tencent.mm.plugin.fts.a.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.bc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bc {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[12];
        aVar.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "featureId";
        aVar.uxd.put("featureId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" featureId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "featureId";
        aVar.columns[1] = "title";
        aVar.uxd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "titlePY";
        aVar.uxd.put("titlePY", "TEXT");
        stringBuilder.append(" titlePY TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "titleShortPY";
        aVar.uxd.put("titleShortPY", "TEXT");
        stringBuilder.append(" titleShortPY TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "tag";
        aVar.uxd.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "actionType";
        aVar.uxd.put("actionType", "INTEGER default '0' ");
        stringBuilder.append(" actionType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.uxd.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "helpUrl";
        aVar.uxd.put("helpUrl", "TEXT");
        stringBuilder.append(" helpUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "updateUrl";
        aVar.uxd.put("updateUrl", "TEXT");
        stringBuilder.append(" updateUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "androidUrl";
        aVar.uxd.put("androidUrl", "TEXT");
        stringBuilder.append(" androidUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "iconPath";
        aVar.uxd.put("iconPath", "TEXT");
        stringBuilder.append(" iconPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "timestamp";
        aVar.uxd.put("timestamp", "LONG default '0' ");
        stringBuilder.append(" timestamp LONG default '0' ");
        aVar.columns[12] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public c() {
        this.field_featureId = 0;
        this.field_title = "";
        this.field_titlePY = "";
        this.field_titleShortPY = "";
        this.field_tag = "";
        this.field_actionType = 0;
        this.field_url = "";
        this.field_helpUrl = "";
        this.field_updateUrl = "";
        this.field_androidUrl = "";
        this.field_iconPath = "";
    }

    public final String toString() {
        return "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
    }
}
