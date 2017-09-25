package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;

public abstract class da extends c {
    private static final int gCW = "snsID".hashCode();
    private static final int gCX = "parentID".hashCode();
    private static final int gCY = "curActionBuf".hashCode();
    private static final int gCZ = "refActionBuf".hashCode();
    private static final int gDa = "commentSvrID".hashCode();
    private static final int gDb = Columns.CLIENTID.hashCode();
    private static final int gDc = "commentflag".hashCode();
    private static final int gDd = "isSilence".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gca = DownloadSettingTable.Columns.TYPE.hashCode();
    private static final int ggr = "isSend".hashCode();
    private static final int goD = "talker".hashCode();
    private static final int gsq = "isRead".hashCode();
    public String field_clientId;
    public long field_commentSvrID;
    public int field_commentflag;
    public int field_createTime;
    public byte[] field_curActionBuf;
    public short field_isRead;
    public boolean field_isSend;
    public int field_isSilence;
    public long field_parentID;
    public byte[] field_refActionBuf;
    public long field_snsID;
    public String field_talker;
    public int field_type;
    private boolean gCO = true;
    private boolean gCP = true;
    private boolean gCQ = true;
    private boolean gCR = true;
    private boolean gCS = true;
    private boolean gCT = true;
    private boolean gCU = true;
    private boolean gCV = true;
    private boolean gbB = true;
    private boolean gbE = true;
    private boolean ggd = true;
    private boolean gon = true;
    private boolean gsh = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gCW == hashCode) {
                    this.field_snsID = cursor.getLong(i);
                } else if (gCX == hashCode) {
                    this.field_parentID = cursor.getLong(i);
                } else if (gsq == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (goD == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ggr == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (gCY == hashCode) {
                    this.field_curActionBuf = cursor.getBlob(i);
                } else if (gCZ == hashCode) {
                    this.field_refActionBuf = cursor.getBlob(i);
                } else if (gDa == hashCode) {
                    this.field_commentSvrID = cursor.getLong(i);
                } else if (gDb == hashCode) {
                    this.field_clientId = cursor.getString(i);
                } else if (gDc == hashCode) {
                    this.field_commentflag = cursor.getInt(i);
                } else if (gDd == hashCode) {
                    this.field_isSilence = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gCO) {
            contentValues.put("snsID", Long.valueOf(this.field_snsID));
        }
        if (this.gCP) {
            contentValues.put("parentID", Long.valueOf(this.field_parentID));
        }
        if (this.gsh) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.gbB) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.gon) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.gbE) {
            contentValues.put(DownloadSettingTable.Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.ggd) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.gCQ) {
            contentValues.put("curActionBuf", this.field_curActionBuf);
        }
        if (this.gCR) {
            contentValues.put("refActionBuf", this.field_refActionBuf);
        }
        if (this.gCS) {
            contentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
        }
        if (this.gCT) {
            contentValues.put(Columns.CLIENTID, this.field_clientId);
        }
        if (this.gCU) {
            contentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
        }
        if (this.gCV) {
            contentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
