package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cv extends c {
    private static final int gBX = "from_username".hashCode();
    private static final int gBY = "consumer".hashCode();
    private static final int gBZ = "share_time".hashCode();
    private static final int gCa = "local_updateTime".hashCode();
    private static final int gCb = "begin_time".hashCode();
    private static final int gCc = "end_time".hashCode();
    private static final int gCd = "block_mask".hashCode();
    private static final int gCe = "dataInfoData".hashCode();
    private static final int gCf = "cardTpInfoData".hashCode();
    private static final int gCg = "shareInfoData".hashCode();
    private static final int gCh = "shopInfoData".hashCode();
    private static final int gCi = "categoryType".hashCode();
    private static final int gCj = "itemIndex".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int giw = "card_id".hashCode();
    private static final int gix = "card_tp_id".hashCode();
    private static final int gnC = "app_id".hashCode();
    private static final int gpE = "updateSeq".hashCode();
    public String field_app_id;
    public long field_begin_time;
    public long field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_categoryType;
    public String field_consumer;
    public byte[] field_dataInfoData;
    public long field_end_time;
    public String field_from_username;
    public int field_itemIndex;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public long field_share_time;
    public byte[] field_shopInfoData;
    public int field_status;
    public long field_updateSeq;
    public long field_updateTime;
    private boolean gBK = true;
    private boolean gBL = true;
    private boolean gBM = true;
    private boolean gBN = true;
    private boolean gBO = true;
    private boolean gBP = true;
    private boolean gBQ = true;
    private boolean gBR = true;
    private boolean gBS = true;
    private boolean gBT = true;
    private boolean gBU = true;
    private boolean gBV = true;
    private boolean gBW = true;
    private boolean gaW = true;
    private boolean gdn = true;
    private boolean gid = true;
    private boolean gie = true;
    private boolean gnf = true;
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
                } else if (gBY == hashCode) {
                    this.field_consumer = cursor.getString(i);
                } else if (gnC == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gBZ == hashCode) {
                    this.field_share_time = cursor.getLong(i);
                } else if (gCa == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gCb == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (gCc == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (gpE == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (gCd == hashCode) {
                    this.field_block_mask = cursor.getLong(i);
                } else if (gCe == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (gCf == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (gCg == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (gCh == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (gCi == hashCode) {
                    this.field_categoryType = cursor.getInt(i);
                } else if (gCj == hashCode) {
                    this.field_itemIndex = cursor.getInt(i);
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
        if (this.gBL) {
            contentValues.put("consumer", this.field_consumer);
        }
        if (this.gnf) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gBM) {
            contentValues.put("share_time", Long.valueOf(this.field_share_time));
        }
        if (this.gBN) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gBO) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.gBP) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.gpq) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.gBQ) {
            contentValues.put("block_mask", Long.valueOf(this.field_block_mask));
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
        if (this.gBV) {
            contentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
        }
        if (this.gBW) {
            contentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
