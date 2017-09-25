package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int gue = "rankID".hashCode();
    private static final int guf = "appusername".hashCode();
    private static final int gui = "score".hashCode();
    private static final int guo = "ranknum".hashCode();
    private static final int gup = "likecount".hashCode();
    private static final int guq = "selfLikeState".hashCode();
    public String field_appusername;
    public int field_likecount;
    public String field_rankID;
    public int field_ranknum;
    public int field_score;
    public int field_selfLikeState;
    public String field_username;
    private boolean gds = true;
    private boolean gub = true;
    private boolean guc = true;
    private boolean guh = true;
    private boolean gul = true;
    private boolean gum = true;
    private boolean gun = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gue == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (guf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (guo == hashCode) {
                    this.field_ranknum = cursor.getInt(i);
                } else if (gui == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (gup == hashCode) {
                    this.field_likecount = cursor.getInt(i);
                } else if (guq == hashCode) {
                    this.field_selfLikeState = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gub) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.guc) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.gul) {
            contentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
        }
        if (this.guh) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.gum) {
            contentValues.put("likecount", Integer.valueOf(this.field_likecount));
        }
        if (this.gun) {
            contentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
