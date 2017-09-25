package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bk extends c {
    public static final String[] gaK = new String[0];
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gbx = "rawXML".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int ggs = "msgType".hashCode();
    private static final int gsm = "mergerId".hashCode();
    private static final int gsn = "gameMsgId".hashCode();
    private static final int gso = "expireTime".hashCode();
    private static final int gsp = "showInMsgList".hashCode();
    private static final int gsq = "isRead".hashCode();
    private static final int gsr = "label".hashCode();
    private static final int gss = "isHidden".hashCode();
    private static final int gst = "weight".hashCode();
    private static final int gsu = "receiveTime".hashCode();
    public String field_appId;
    public long field_createTime;
    public long field_expireTime;
    public String field_gameMsgId;
    public boolean field_isHidden;
    public boolean field_isRead;
    public String field_label;
    public String field_mergerId;
    public long field_msgId;
    public int field_msgType;
    public String field_rawXML;
    public long field_receiveTime;
    public boolean field_showInMsgList;
    public String field_weight;
    private boolean gaO = true;
    private boolean gbB = true;
    private boolean gbt = true;
    private boolean gcu = true;
    private boolean gge = true;
    private boolean gsd = true;
    private boolean gse = true;
    private boolean gsf = true;
    private boolean gsg = true;
    private boolean gsh = true;
    private boolean gsi = true;
    private boolean gsj = true;
    private boolean gsk = true;
    private boolean gsl = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.gaO = true;
                } else if (gsm == hashCode) {
                    this.field_mergerId = cursor.getString(i);
                } else if (gsn == hashCode) {
                    this.field_gameMsgId = cursor.getString(i);
                } else if (ggs == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gso == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gsp == hashCode) {
                    this.field_showInMsgList = cursor.getInt(i) != 0;
                } else if (gsq == hashCode) {
                    this.field_isRead = cursor.getInt(i) != 0;
                } else if (gsr == hashCode) {
                    this.field_label = cursor.getString(i);
                } else if (gss == hashCode) {
                    this.field_isHidden = cursor.getInt(i) != 0;
                } else if (gst == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (gbx == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (gsu == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gaO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gsd) {
            contentValues.put("mergerId", this.field_mergerId);
        }
        if (this.gse) {
            contentValues.put("gameMsgId", this.field_gameMsgId);
        }
        if (this.gge) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gsf) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gsg) {
            contentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
        }
        if (this.gsh) {
            contentValues.put("isRead", Boolean.valueOf(this.field_isRead));
        }
        if (this.field_label == null) {
            this.field_label = "";
        }
        if (this.gsi) {
            contentValues.put("label", this.field_label);
        }
        if (this.gsj) {
            contentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
        }
        if (this.field_weight == null) {
            this.field_weight = "";
        }
        if (this.gsk) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.gbt) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.gsl) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
