package com.tencent.mm.ap;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;

public final class m {
    private String fJz = (this.id + "_" + this.fKL);
    public int fKL = 0;
    int fRW = -1;
    String hOq = "";
    private String hrv = "";
    private String hrw = "";
    private int hrx = 0;
    private int hry = 0;
    public int id = 0;
    String name = "";
    int size = 0;
    public int status = 0;
    public int version = 0;

    public final void b(Cursor cursor) {
        this.version = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.size = cursor.getInt(4);
        this.hOq = cursor.getString(5);
        this.status = cursor.getInt(6);
        this.hrv = cursor.getString(8);
        this.hrw = cursor.getString(9);
        this.fKL = cursor.getInt(7);
        this.hry = cursor.getInt(11);
        this.id = cursor.getInt(1);
        this.hrx = cursor.getInt(10);
        this.fJz = cursor.getString(0);
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 2) != 0) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.id));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("version", Integer.valueOf(this.version));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("name", this.name == null ? "" : this.name);
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("size", Integer.valueOf(this.size));
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("packname", HX());
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.fKL));
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("reserved1", this.hrv == null ? "" : this.hrv);
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("reserved2", this.hrw == null ? "" : this.hrw);
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hrx));
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hry));
        }
        if ((this.fRW & 1) != 0) {
            contentValues.put("localId", this.id + "_" + this.fKL);
        }
        return contentValues;
    }

    public final String HX() {
        return this.hOq == null ? "" : this.hOq;
    }
}
