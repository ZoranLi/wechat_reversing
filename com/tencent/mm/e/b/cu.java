package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cu extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gcs = "scene".hashCode();
    private static final int ggr = "isSend".hashCode();
    private static final int gnt = "svrid".hashCode();
    private static final int goD = "talker".hashCode();
    private static final int gva = "createtime".hashCode();
    private static final int gvb = "sayhiuser".hashCode();
    private static final int gvc = "sayhicontent".hashCode();
    private static final int gvd = "imgpath".hashCode();
    public String field_content;
    public long field_createtime;
    public String field_imgpath;
    public int field_isSend;
    public String field_sayhicontent;
    public String field_sayhiuser;
    public int field_scene;
    public int field_status;
    public long field_svrid;
    public String field_talker;
    public int field_type;
    private boolean gaW = true;
    private boolean gbE = true;
    private boolean gbJ = true;
    private boolean gcq = true;
    private boolean ggd = true;
    private boolean gmW = true;
    private boolean gon = true;
    private boolean guV = true;
    private boolean guW = true;
    private boolean guX = true;
    private boolean guY = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gnt == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.gmW = true;
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gcs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gva == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (goD == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gvb == hashCode) {
                    this.field_sayhiuser = cursor.getString(i);
                } else if (gvc == hashCode) {
                    this.field_sayhicontent = cursor.getString(i);
                } else if (gvd == hashCode) {
                    this.field_imgpath = cursor.getString(i);
                } else if (ggr == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gmW) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gcq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.guV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gon) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.guW) {
            contentValues.put("sayhiuser", this.field_sayhiuser);
        }
        if (this.guX) {
            contentValues.put("sayhicontent", this.field_sayhicontent);
        }
        if (this.guY) {
            contentValues.put("imgpath", this.field_imgpath);
        }
        if (this.ggd) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
