package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class q {
    private int hAz;
    long iam;
    public int offset;
    public String olJ;
    private long qnO;
    public int qnP;
    private int qnQ;
    private long qnR;
    public String qnS;
    public byte[] qnT;
    public int qnk;
    public int type;
    private String userName;

    public final ContentValues bhS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqId", Long.valueOf(this.qnO));
        contentValues.put(Columns.TYPE, Integer.valueOf(this.type));
        contentValues.put("createTime", Long.valueOf(this.iam));
        contentValues.put("userName", this.userName);
        contentValues.put("totallen", Integer.valueOf(this.qnP));
        contentValues.put("offset", Integer.valueOf(this.offset));
        contentValues.put("local_flag", Integer.valueOf(this.hAz));
        contentValues.put("tmp_path", this.olJ);
        contentValues.put("nums", Integer.valueOf(this.qnQ));
        contentValues.put("try_times", Long.valueOf(this.qnR));
        contentValues.put("StrId", this.qnS);
        contentValues.put("upload_buf", this.qnT);
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.qnk = cursor.getInt(0);
        long j = cursor.getLong(1);
        this.qnO = j;
        this.qnS = i.df(j);
        this.type = cursor.getInt(2);
        this.iam = cursor.getLong(3);
        this.userName = cursor.getString(4);
        this.qnP = cursor.getInt(5);
        this.offset = cursor.getInt(6);
        this.hAz = cursor.getInt(7);
        this.olJ = cursor.getString(8);
        this.qnQ = cursor.getInt(9);
        this.qnR = cursor.getLong(10);
        this.qnS = cursor.getString(11);
        this.qnT = cursor.getBlob(12);
    }

    public final void bhT() {
        this.hAz |= 4;
    }

    public final void bhU() {
        this.hAz &= -5;
    }
}
