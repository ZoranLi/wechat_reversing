package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ae extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gjA = "roomowner".hashCode();
    private static final int gjB = "roomdata".hashCode();
    private static final int gjC = "isShowname".hashCode();
    private static final int gjD = "selfDisplayName".hashCode();
    private static final int gjE = "style".hashCode();
    private static final int gjF = "chatroomdataflag".hashCode();
    private static final int gjG = "modifytime".hashCode();
    private static final int gjH = "chatroomnotice".hashCode();
    private static final int gjI = "chatroomVersion".hashCode();
    private static final int gjJ = "chatroomnoticeEditor".hashCode();
    private static final int gjK = "chatroomnoticePublishTime".hashCode();
    private static final int gjL = "chatroomLocalVersion".hashCode();
    private static final int gju = "chatroomname".hashCode();
    private static final int gjv = "addtime".hashCode();
    private static final int gjw = "memberlist".hashCode();
    private static final int gjx = "displayname".hashCode();
    private static final int gjy = "chatroomnick".hashCode();
    private static final int gjz = "roomflag".hashCode();
    public long field_addtime;
    public long field_chatroomLocalVersion;
    public int field_chatroomVersion;
    public int field_chatroomdataflag;
    public String field_chatroomname;
    public String field_chatroomnick;
    public String field_chatroomnotice;
    public String field_chatroomnoticeEditor;
    public long field_chatroomnoticePublishTime;
    public String field_displayname;
    public int field_isShowname;
    public String field_memberlist;
    public long field_modifytime;
    public byte[] field_roomdata;
    public int field_roomflag;
    public String field_roomowner;
    public String field_selfDisplayName;
    public int field_style;
    private boolean gjc = true;
    private boolean gjd = true;
    private boolean gje = true;
    private boolean gjf = true;
    private boolean gjg = true;
    private boolean gjh = true;
    private boolean gji = true;
    private boolean gjj = true;
    private boolean gjk = true;
    private boolean gjl = true;
    private boolean gjm = true;
    private boolean gjn = true;
    private boolean gjo = true;
    private boolean gjp = true;
    private boolean gjq = true;
    private boolean gjr = true;
    private boolean gjs = true;
    private boolean gjt = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gju == hashCode) {
                    this.field_chatroomname = cursor.getString(i);
                    this.gjc = true;
                } else if (gjv == hashCode) {
                    this.field_addtime = cursor.getLong(i);
                } else if (gjw == hashCode) {
                    this.field_memberlist = cursor.getString(i);
                } else if (gjx == hashCode) {
                    this.field_displayname = cursor.getString(i);
                } else if (gjy == hashCode) {
                    this.field_chatroomnick = cursor.getString(i);
                } else if (gjz == hashCode) {
                    this.field_roomflag = cursor.getInt(i);
                } else if (gjA == hashCode) {
                    this.field_roomowner = cursor.getString(i);
                } else if (gjB == hashCode) {
                    this.field_roomdata = cursor.getBlob(i);
                } else if (gjC == hashCode) {
                    this.field_isShowname = cursor.getInt(i);
                } else if (gjD == hashCode) {
                    this.field_selfDisplayName = cursor.getString(i);
                } else if (gjE == hashCode) {
                    this.field_style = cursor.getInt(i);
                } else if (gjF == hashCode) {
                    this.field_chatroomdataflag = cursor.getInt(i);
                } else if (gjG == hashCode) {
                    this.field_modifytime = cursor.getLong(i);
                } else if (gjH == hashCode) {
                    this.field_chatroomnotice = cursor.getString(i);
                } else if (gjI == hashCode) {
                    this.field_chatroomVersion = cursor.getInt(i);
                } else if (gjJ == hashCode) {
                    this.field_chatroomnoticeEditor = cursor.getString(i);
                } else if (gjK == hashCode) {
                    this.field_chatroomnoticePublishTime = cursor.getLong(i);
                } else if (gjL == hashCode) {
                    this.field_chatroomLocalVersion = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatroomname == null) {
            this.field_chatroomname = "";
        }
        if (this.gjc) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.gjd) {
            contentValues.put("addtime", Long.valueOf(this.field_addtime));
        }
        if (this.gje) {
            contentValues.put("memberlist", this.field_memberlist);
        }
        if (this.gjf) {
            contentValues.put("displayname", this.field_displayname);
        }
        if (this.gjg) {
            contentValues.put("chatroomnick", this.field_chatroomnick);
        }
        if (this.gjh) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.gji) {
            contentValues.put("roomowner", this.field_roomowner);
        }
        if (this.gjj) {
            contentValues.put("roomdata", this.field_roomdata);
        }
        if (this.gjk) {
            contentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
        }
        if (this.gjl) {
            contentValues.put("selfDisplayName", this.field_selfDisplayName);
        }
        if (this.gjm) {
            contentValues.put("style", Integer.valueOf(this.field_style));
        }
        if (this.gjn) {
            contentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
        }
        if (this.gjo) {
            contentValues.put("modifytime", Long.valueOf(this.field_modifytime));
        }
        if (this.gjp) {
            contentValues.put("chatroomnotice", this.field_chatroomnotice);
        }
        if (this.gjq) {
            contentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
        }
        if (this.gjr) {
            contentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
        }
        if (this.gjs) {
            contentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
        }
        if (this.gjt) {
            contentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
