package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dg extends c {
    private static final int gBX = "from_username".hashCode();
    private static final int gCa = "local_updateTime".hashCode();
    private static final int gCb = "begin_time".hashCode();
    private static final int gCc = "end_time".hashCode();
    private static final int gCd = "block_mask".hashCode();
    private static final int gCe = "dataInfoData".hashCode();
    private static final int gCf = "cardTpInfoData".hashCode();
    private static final int gCg = "shareInfoData".hashCode();
    private static final int gCh = "shopInfoData".hashCode();
    private static final int gEf = "delete_state_flag".hashCode();
    private static final int gEg = "create_time".hashCode();
    private static final int gEh = "stickyIndex".hashCode();
    private static final int gEi = "stickyEndTime".hashCode();
    private static final int gEj = "stickyAnnouncement".hashCode();
    private static final int gEk = "label_wording".hashCode();
    private static final int gEl = "is_dynamic".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int git = "card_type".hashCode();
    private static final int giw = "card_id".hashCode();
    private static final int gix = "card_tp_id".hashCode();
    private static final int gpE = "updateSeq".hashCode();
    public long field_begin_time;
    public String field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public long field_create_time;
    public byte[] field_dataInfoData;
    public int field_delete_state_flag;
    public long field_end_time;
    public String field_from_username;
    public boolean field_is_dynamic;
    public String field_label_wording;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public byte[] field_shopInfoData;
    public int field_status;
    public String field_stickyAnnouncement;
    public int field_stickyEndTime;
    public int field_stickyIndex;
    public long field_updateSeq;
    public long field_updateTime;
    private boolean gBK = true;
    private boolean gBN = true;
    private boolean gBO = true;
    private boolean gBP = true;
    private boolean gBQ = true;
    private boolean gBR = true;
    private boolean gBS = true;
    private boolean gBT = true;
    private boolean gBU = true;
    private boolean gDY = true;
    private boolean gDZ = true;
    private boolean gEa = true;
    private boolean gEb = true;
    private boolean gEc = true;
    private boolean gEd = true;
    private boolean gEe = true;
    private boolean gaW = true;
    private boolean gdn = true;
    private boolean gia = true;
    private boolean gid = true;
    private boolean gie = true;
    private boolean gpq = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (giw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.gid = true;
                } else if (gix == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (gBX == hashCode) {
                    this.field_from_username = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gEf == hashCode) {
                    this.field_delete_state_flag = cursor.getInt(i);
                } else if (gCa == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gpE == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (gEg == hashCode) {
                    this.field_create_time = cursor.getLong(i);
                } else if (gCb == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (gCc == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (gCd == hashCode) {
                    this.field_block_mask = cursor.getString(i);
                } else if (gCe == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (gCf == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (gCg == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (gCh == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (gEh == hashCode) {
                    this.field_stickyIndex = cursor.getInt(i);
                } else if (gEi == hashCode) {
                    this.field_stickyEndTime = cursor.getInt(i);
                } else if (gEj == hashCode) {
                    this.field_stickyAnnouncement = cursor.getString(i);
                } else if (git == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (gEk == hashCode) {
                    this.field_label_wording = cursor.getString(i);
                } else if (gEl == hashCode) {
                    this.field_is_dynamic = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gid) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.gie) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.gBK) {
            contentValues.put("from_username", this.field_from_username);
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gDY) {
            contentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
        }
        if (this.gBN) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gpq) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.gDZ) {
            contentValues.put("create_time", Long.valueOf(this.field_create_time));
        }
        if (this.gBO) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.gBP) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.gBQ) {
            contentValues.put("block_mask", this.field_block_mask);
        }
        if (this.gBR) {
            contentValues.put("dataInfoData", this.field_dataInfoData);
        }
        if (this.gBS) {
            contentValues.put("cardTpInfoData", this.field_cardTpInfoData);
        }
        if (this.gBT) {
            contentValues.put("shareInfoData", this.field_shareInfoData);
        }
        if (this.gBU) {
            contentValues.put("shopInfoData", this.field_shopInfoData);
        }
        if (this.gEa) {
            contentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
        }
        if (this.gEb) {
            contentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
        }
        if (this.gEc) {
            contentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
        }
        if (this.gia) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.gEd) {
            contentValues.put("label_wording", this.field_label_wording);
        }
        if (this.gEe) {
            contentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
