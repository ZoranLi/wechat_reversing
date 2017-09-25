package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class bc extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gfD = "title".hashCode();
    private static final int giB = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gqf = "featureId".hashCode();
    private static final int gqg = "titlePY".hashCode();
    private static final int gqh = "titleShortPY".hashCode();
    private static final int gqi = "tag".hashCode();
    private static final int gqj = "actionType".hashCode();
    private static final int gqk = "helpUrl".hashCode();
    private static final int gql = "updateUrl".hashCode();
    private static final int gqm = "androidUrl".hashCode();
    private static final int gqn = "iconPath".hashCode();
    private static final int gqo = "timestamp".hashCode();
    public int field_actionType;
    public String field_androidUrl;
    public int field_featureId;
    public String field_helpUrl;
    public String field_iconPath;
    public String field_tag;
    public long field_timestamp;
    public String field_title;
    public String field_titlePY;
    public String field_titleShortPY;
    public String field_updateUrl;
    public String field_url;
    private boolean gfz = true;
    private boolean gii = true;
    private boolean gpV = true;
    private boolean gpW = true;
    private boolean gpX = true;
    private boolean gpY = true;
    private boolean gpZ = true;
    private boolean gqa = true;
    private boolean gqb = true;
    private boolean gqc = true;
    private boolean gqd = true;
    private boolean gqe = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gqf == hashCode) {
                    this.field_featureId = cursor.getInt(i);
                    this.gpV = true;
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gqg == hashCode) {
                    this.field_titlePY = cursor.getString(i);
                } else if (gqh == hashCode) {
                    this.field_titleShortPY = cursor.getString(i);
                } else if (gqi == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (gqj == hashCode) {
                    this.field_actionType = cursor.getInt(i);
                } else if (giB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gqk == hashCode) {
                    this.field_helpUrl = cursor.getString(i);
                } else if (gql == hashCode) {
                    this.field_updateUrl = cursor.getString(i);
                } else if (gqm == hashCode) {
                    this.field_androidUrl = cursor.getString(i);
                } else if (gqn == hashCode) {
                    this.field_iconPath = cursor.getString(i);
                } else if (gqo == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gpV) {
            contentValues.put("featureId", Integer.valueOf(this.field_featureId));
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.gpW) {
            contentValues.put("titlePY", this.field_titlePY);
        }
        if (this.gpX) {
            contentValues.put("titleShortPY", this.field_titleShortPY);
        }
        if (this.gpY) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.gpZ) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.gii) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gqa) {
            contentValues.put("helpUrl", this.field_helpUrl);
        }
        if (this.gqb) {
            contentValues.put("updateUrl", this.field_updateUrl);
        }
        if (this.gqc) {
            contentValues.put("androidUrl", this.field_androidUrl);
        }
        if (this.gqd) {
            contentValues.put("iconPath", this.field_iconPath);
        }
        if (this.gqe) {
            contentValues.put("timestamp", Long.valueOf(this.field_timestamp));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
