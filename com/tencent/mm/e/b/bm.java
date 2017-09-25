package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bm extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int gnA = "reserved3".hashCode();
    private static final int gnB = "reserved4".hashCode();
    private static final int gny = "reserved1".hashCode();
    private static final int gnz = "reserved2".hashCode();
    private static final int gsF = "originSvrId".hashCode();
    private static final int gsG = "newMsgId".hashCode();
    private static final int gsH = "fromUserName".hashCode();
    private static final int gsI = "toUserName".hashCode();
    private static final int gsJ = "msgSource".hashCode();
    private static final int gsK = "msgSeq".hashCode();
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_fromUserName;
    public int field_msgSeq;
    public String field_msgSource;
    public long field_newMsgId;
    public long field_originSvrId;
    public int field_reserved1;
    public long field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public String field_toUserName;
    private boolean gbB = true;
    private boolean gbJ = true;
    private boolean gfG = true;
    private boolean gnb = true;
    private boolean gnc = true;
    private boolean gnd = true;
    private boolean gne = true;
    private boolean gsA = true;
    private boolean gsB = true;
    private boolean gsC = true;
    private boolean gsD = true;
    private boolean gsE = true;
    private boolean gsz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gsF == hashCode) {
                    this.field_originSvrId = cursor.getLong(i);
                    this.gsz = true;
                } else if (gsG == hashCode) {
                    this.field_newMsgId = cursor.getLong(i);
                } else if (gsH == hashCode) {
                    this.field_fromUserName = cursor.getString(i);
                } else if (gsI == hashCode) {
                    this.field_toUserName = cursor.getString(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gsJ == hashCode) {
                    this.field_msgSource = cursor.getString(i);
                } else if (gsK == hashCode) {
                    this.field_msgSeq = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gny == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (gnz == hashCode) {
                    this.field_reserved2 = cursor.getLong(i);
                } else if (gnA == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (gnB == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gsz) {
            contentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
        }
        if (this.gsA) {
            contentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
        }
        if (this.field_fromUserName == null) {
            this.field_fromUserName = "";
        }
        if (this.gsB) {
            contentValues.put("fromUserName", this.field_fromUserName);
        }
        if (this.field_toUserName == null) {
            this.field_toUserName = "";
        }
        if (this.gsC) {
            contentValues.put("toUserName", this.field_toUserName);
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgSource == null) {
            this.field_msgSource = "";
        }
        if (this.gsD) {
            contentValues.put("msgSource", this.field_msgSource);
        }
        if (this.gsE) {
            contentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
        }
        if (this.gfG) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.gnb) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.gnc) {
            contentValues.put("reserved2", Long.valueOf(this.field_reserved2));
        }
        if (this.field_reserved3 == null) {
            this.field_reserved3 = "";
        }
        if (this.gnd) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.field_reserved4 == null) {
            this.field_reserved4 = "";
        }
        if (this.gne) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
