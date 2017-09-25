package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ao extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gdj = "size".hashCode();
    private static final int gfF = "source".hashCode();
    private static final int gmJ = "lastUseTime".hashCode();
    private static final int gmN = "idx".hashCode();
    private static final int gnA = "reserved3".hashCode();
    private static final int gnB = "reserved4".hashCode();
    private static final int gnC = "app_id".hashCode();
    private static final int gnD = "groupId".hashCode();
    private static final int gnE = "framesInfo".hashCode();
    private static final int gnF = "temp".hashCode();
    private static final int gnG = "needupload".hashCode();
    private static final int gnH = "designerID".hashCode();
    private static final int gnI = "thumbUrl".hashCode();
    private static final int gnJ = "cdnUrl".hashCode();
    private static final int gnK = "encrypturl".hashCode();
    private static final int gnL = "aeskey".hashCode();
    private static final int gnM = "width".hashCode();
    private static final int gnN = "height".hashCode();
    private static final int gnO = "activityid".hashCode();
    private static final int gns = "md5".hashCode();
    private static final int gnt = "svrid".hashCode();
    private static final int gnu = "catalog".hashCode();
    private static final int gnv = "start".hashCode();
    private static final int gnw = "state".hashCode();
    private static final int gnx = "name".hashCode();
    private static final int gny = "reserved1".hashCode();
    private static final int gnz = "reserved2".hashCode();
    public String field_activityid;
    public String field_aeskey;
    public String field_app_id;
    public int field_catalog;
    public String field_cdnUrl;
    public String field_content;
    public String field_designerID;
    public String field_encrypturl;
    public String field_framesInfo;
    public String field_groupId;
    public int field_height;
    public int field_idx;
    public long field_lastUseTime;
    public String field_md5;
    public String field_name;
    public int field_needupload;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public int field_reserved4;
    public int field_size;
    public int field_source;
    public int field_start;
    public int field_state;
    public String field_svrid;
    public int field_temp;
    public String field_thumbUrl;
    public int field_type;
    public int field_width;
    private boolean gbE = true;
    private boolean gbJ = true;
    private boolean gdg = true;
    private boolean gfB = true;
    private boolean gmV = true;
    private boolean gmW = true;
    private boolean gmX = true;
    private boolean gmY = true;
    private boolean gmZ = true;
    private boolean gmj = true;
    private boolean gmn = true;
    private boolean gna = true;
    private boolean gnb = true;
    private boolean gnc = true;
    private boolean gnd = true;
    private boolean gne = true;
    private boolean gnf = true;
    private boolean gng = true;
    private boolean gnh = true;
    private boolean gni = true;
    private boolean gnj = true;
    private boolean gnk = true;
    private boolean gnl = true;
    private boolean gnm = true;
    private boolean gnn = true;
    private boolean gno = true;
    private boolean gnp = true;
    private boolean gnq = true;
    private boolean gnr = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gns == hashCode) {
                    this.field_md5 = cursor.getString(i);
                    this.gmV = true;
                } else if (gnt == hashCode) {
                    this.field_svrid = cursor.getString(i);
                } else if (gnu == hashCode) {
                    this.field_catalog = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gdj == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (gnv == hashCode) {
                    this.field_start = cursor.getInt(i);
                } else if (gnw == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (gnx == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gny == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (gnz == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (gnA == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (gnB == hashCode) {
                    this.field_reserved4 = cursor.getInt(i);
                } else if (gnC == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (gnD == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (gmJ == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (gnE == hashCode) {
                    this.field_framesInfo = cursor.getString(i);
                } else if (gmN == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (gnF == hashCode) {
                    this.field_temp = cursor.getInt(i);
                } else if (gfF == hashCode) {
                    this.field_source = cursor.getInt(i);
                } else if (gnG == hashCode) {
                    this.field_needupload = cursor.getInt(i);
                } else if (gnH == hashCode) {
                    this.field_designerID = cursor.getString(i);
                } else if (gnI == hashCode) {
                    this.field_thumbUrl = cursor.getString(i);
                } else if (gnJ == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gnK == hashCode) {
                    this.field_encrypturl = cursor.getString(i);
                } else if (gnL == hashCode) {
                    this.field_aeskey = cursor.getString(i);
                } else if (gnM == hashCode) {
                    this.field_width = cursor.getInt(i);
                } else if (gnN == hashCode) {
                    this.field_height = cursor.getInt(i);
                } else if (gnO == hashCode) {
                    this.field_activityid = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gmV) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gmW) {
            contentValues.put("svrid", this.field_svrid);
        }
        if (this.gmX) {
            contentValues.put("catalog", Integer.valueOf(this.field_catalog));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gdg) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.gmY) {
            contentValues.put("start", Integer.valueOf(this.field_start));
        }
        if (this.gmZ) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.gna) {
            contentValues.put("name", this.field_name);
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.gnb) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.gnc) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.gnd) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.gne) {
            contentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
        }
        if (this.gnf) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.gng) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.gmj) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.field_framesInfo == null) {
            this.field_framesInfo = "";
        }
        if (this.gnh) {
            contentValues.put("framesInfo", this.field_framesInfo);
        }
        if (this.gmn) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.gni) {
            contentValues.put("temp", Integer.valueOf(this.field_temp));
        }
        if (this.gfB) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.gnj) {
            contentValues.put("needupload", Integer.valueOf(this.field_needupload));
        }
        if (this.gnk) {
            contentValues.put("designerID", this.field_designerID);
        }
        if (this.gnl) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.gnm) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.gnn) {
            contentValues.put("encrypturl", this.field_encrypturl);
        }
        if (this.gno) {
            contentValues.put("aeskey", this.field_aeskey);
        }
        if (this.gnp) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.gnq) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.gnr) {
            contentValues.put("activityid", this.field_activityid);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }

    public void reset() {
    }
}
