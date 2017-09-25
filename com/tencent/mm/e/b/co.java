package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;

public abstract class co extends c {
    public static final String[] gaK = new String[0];
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gfD = "title".hashCode();
    private static final int gnU = "desc".hashCode();
    private static final int gpJ = "toUser".hashCode();
    private static final int gpn = "localId".hashCode();
    private static final int gzT = "oriMsgId".hashCode();
    private static final int gzU = "dataProto".hashCode();
    private static final int gzV = "favFrom".hashCode();
    public rv field_dataProto;
    public String field_desc;
    public String field_favFrom;
    public int field_localId;
    public long field_msgId;
    public long field_oriMsgId;
    public int field_status;
    public String field_title;
    public String field_toUser;
    public int field_type;
    private boolean gaO = true;
    private boolean gaW = true;
    private boolean gbE = true;
    private boolean gfz = true;
    private boolean gnQ = true;
    private boolean gpl = true;
    private boolean gpv = true;
    private boolean gzQ = true;
    private boolean gzR = true;
    private boolean gzS = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpn == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gpl = true;
                } else if (gaS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (gzT == hashCode) {
                    this.field_oriMsgId = cursor.getLong(i);
                } else if (gpJ == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gnU == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (gzU == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_dataProto = (rv) new rv().aD(blob);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
                    }
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gzV == hashCode) {
                    this.field_favFrom = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gpl) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.gaO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gzQ) {
            contentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.gpv) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.gnQ) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.gzR && this.field_dataProto != null) {
            try {
                contentValues.put("dataProto", this.field_dataProto.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
            }
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gzS) {
            contentValues.put("favFrom", this.field_favFrom);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
