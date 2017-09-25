package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class av extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gnw = "state".hashCode();
    private static final int goD = "talker".hashCode();
    private static final int goE = "encryptTalker".hashCode();
    private static final int goF = "displayName".hashCode();
    private static final int goG = "lastModifiedTime".hashCode();
    private static final int goH = "isNew".hashCode();
    private static final int goI = "addScene".hashCode();
    private static final int goJ = "fmsgSysRowId".hashCode();
    private static final int goK = "fmsgIsSend".hashCode();
    private static final int goL = "fmsgType".hashCode();
    private static final int goM = "fmsgContent".hashCode();
    private static final int goN = "recvFmsgType".hashCode();
    private static final int goO = "contentFromUsername".hashCode();
    private static final int goP = "contentNickname".hashCode();
    private static final int goQ = "contentPhoneNumMD5".hashCode();
    private static final int goR = "contentFullPhoneNumMD5".hashCode();
    private static final int goS = "contentVerifyContent".hashCode();
    public int field_addScene;
    public String field_contentFromUsername;
    public String field_contentFullPhoneNumMD5;
    public String field_contentNickname;
    public String field_contentPhoneNumMD5;
    public String field_contentVerifyContent;
    public String field_displayName;
    public String field_encryptTalker;
    public String field_fmsgContent;
    public int field_fmsgIsSend;
    public long field_fmsgSysRowId;
    public int field_fmsgType;
    public int field_isNew;
    public long field_lastModifiedTime;
    public int field_recvFmsgType;
    public int field_state;
    public String field_talker;
    private boolean gmZ = true;
    private boolean goA = true;
    private boolean goB = true;
    private boolean goC = true;
    private boolean gon = true;
    private boolean goo = true;
    private boolean gop = true;
    private boolean goq = true;
    private boolean gor = true;
    private boolean gos = true;
    private boolean got = true;
    private boolean gou = true;
    private boolean gov = true;
    private boolean gow = true;
    private boolean gox = true;
    private boolean goy = true;
    private boolean goz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (goD == hashCode) {
                    this.field_talker = cursor.getString(i);
                    this.gon = true;
                } else if (goE == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (goF == hashCode) {
                    this.field_displayName = cursor.getString(i);
                } else if (gnw == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (goG == hashCode) {
                    this.field_lastModifiedTime = cursor.getLong(i);
                } else if (goH == hashCode) {
                    this.field_isNew = cursor.getInt(i);
                } else if (goI == hashCode) {
                    this.field_addScene = cursor.getInt(i);
                } else if (goJ == hashCode) {
                    this.field_fmsgSysRowId = cursor.getLong(i);
                } else if (goK == hashCode) {
                    this.field_fmsgIsSend = cursor.getInt(i);
                } else if (goL == hashCode) {
                    this.field_fmsgType = cursor.getInt(i);
                } else if (goM == hashCode) {
                    this.field_fmsgContent = cursor.getString(i);
                } else if (goN == hashCode) {
                    this.field_recvFmsgType = cursor.getInt(i);
                } else if (goO == hashCode) {
                    this.field_contentFromUsername = cursor.getString(i);
                } else if (goP == hashCode) {
                    this.field_contentNickname = cursor.getString(i);
                } else if (goQ == hashCode) {
                    this.field_contentPhoneNumMD5 = cursor.getString(i);
                } else if (goR == hashCode) {
                    this.field_contentFullPhoneNumMD5 = cursor.getString(i);
                } else if (goS == hashCode) {
                    this.field_contentVerifyContent = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_talker == null) {
            this.field_talker = "0";
        }
        if (this.gon) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.goo) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.field_displayName == null) {
            this.field_displayName = "";
        }
        if (this.gop) {
            contentValues.put("displayName", this.field_displayName);
        }
        if (this.gmZ) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.goq) {
            contentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
        }
        if (this.gor) {
            contentValues.put("isNew", Integer.valueOf(this.field_isNew));
        }
        if (this.gos) {
            contentValues.put("addScene", Integer.valueOf(this.field_addScene));
        }
        if (this.got) {
            contentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
        }
        if (this.gou) {
            contentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
        }
        if (this.gov) {
            contentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
        }
        if (this.field_fmsgContent == null) {
            this.field_fmsgContent = "";
        }
        if (this.gow) {
            contentValues.put("fmsgContent", this.field_fmsgContent);
        }
        if (this.gox) {
            contentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
        }
        if (this.field_contentFromUsername == null) {
            this.field_contentFromUsername = "";
        }
        if (this.goy) {
            contentValues.put("contentFromUsername", this.field_contentFromUsername);
        }
        if (this.field_contentNickname == null) {
            this.field_contentNickname = "";
        }
        if (this.goz) {
            contentValues.put("contentNickname", this.field_contentNickname);
        }
        if (this.field_contentPhoneNumMD5 == null) {
            this.field_contentPhoneNumMD5 = "";
        }
        if (this.goA) {
            contentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
        }
        if (this.field_contentFullPhoneNumMD5 == null) {
            this.field_contentFullPhoneNumMD5 = "";
        }
        if (this.goB) {
            contentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
        }
        if (this.field_contentVerifyContent == null) {
            this.field_contentVerifyContent = "";
        }
        if (this.goC) {
            contentValues.put("contentVerifyContent", this.field_contentVerifyContent);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
