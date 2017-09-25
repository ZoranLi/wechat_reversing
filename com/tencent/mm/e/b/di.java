package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class di extends c {
    private static final int gEA = "msgid".hashCode();
    private static final int gEB = "filenowsize".hashCode();
    private static final int gEC = "totallen".hashCode();
    private static final int gED = "lastmodifytime".hashCode();
    private static final int gEE = "clientid".hashCode();
    private static final int gEF = "voicelenght".hashCode();
    private static final int gEG = "msglocalid".hashCode();
    private static final int gEH = "human".hashCode();
    private static final int gEI = "voiceformat".hashCode();
    private static final int gEJ = "nettimes".hashCode();
    private static final int gEy = FFmpegMetadataRetriever.METADATA_KEY_FILENAME.hashCode();
    private static final int gEz = "user".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcR = "offset".hashCode();
    private static final int gny = "reserved1".hashCode();
    private static final int gnz = "reserved2".hashCode();
    private static final int gva = "createtime".hashCode();
    public String field_clientid;
    public long field_createtime;
    public String field_filename;
    public int field_filenowsize;
    public String field_human;
    public long field_lastmodifytime;
    public long field_msgid;
    public int field_msglocalid;
    public int field_nettimes;
    public int field_offset;
    public int field_reserved1;
    public String field_reserved2;
    public int field_status;
    public int field_totallen;
    public String field_user;
    public int field_voiceformat;
    public int field_voicelenght;
    private boolean gEm = true;
    private boolean gEn = true;
    private boolean gEo = true;
    private boolean gEp = true;
    private boolean gEq = true;
    private boolean gEr = true;
    private boolean gEs = true;
    private boolean gEt = true;
    private boolean gEu = true;
    private boolean gEv = true;
    private boolean gEw = true;
    private boolean gEx = true;
    private boolean gaW = true;
    private boolean gcA = true;
    private boolean gnb = true;
    private boolean gnc = true;
    private boolean guV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gEy == hashCode) {
                    this.field_filename = cursor.getString(i);
                } else if (gEz == hashCode) {
                    this.field_user = cursor.getString(i);
                } else if (gEA == hashCode) {
                    this.field_msgid = cursor.getLong(i);
                } else if (gcR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (gEB == hashCode) {
                    this.field_filenowsize = cursor.getInt(i);
                } else if (gEC == hashCode) {
                    this.field_totallen = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gva == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gED == hashCode) {
                    this.field_lastmodifytime = cursor.getLong(i);
                } else if (gEE == hashCode) {
                    this.field_clientid = cursor.getString(i);
                } else if (gEF == hashCode) {
                    this.field_voicelenght = cursor.getInt(i);
                } else if (gEG == hashCode) {
                    this.field_msglocalid = cursor.getInt(i);
                } else if (gEH == hashCode) {
                    this.field_human = cursor.getString(i);
                } else if (gEI == hashCode) {
                    this.field_voiceformat = cursor.getInt(i);
                } else if (gEJ == hashCode) {
                    this.field_nettimes = cursor.getInt(i);
                } else if (gny == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (gnz == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gEm) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, this.field_filename);
        }
        if (this.gEn) {
            contentValues.put("user", this.field_user);
        }
        if (this.gEo) {
            contentValues.put("msgid", Long.valueOf(this.field_msgid));
        }
        if (this.gcA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.gEp) {
            contentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
        }
        if (this.gEq) {
            contentValues.put("totallen", Integer.valueOf(this.field_totallen));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.guV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gEr) {
            contentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
        }
        if (this.gEs) {
            contentValues.put("clientid", this.field_clientid);
        }
        if (this.gEt) {
            contentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
        }
        if (this.gEu) {
            contentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
        }
        if (this.gEv) {
            contentValues.put("human", this.field_human);
        }
        if (this.gEw) {
            contentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
        }
        if (this.gEx) {
            contentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
        }
        if (this.gnb) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.gnc) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
