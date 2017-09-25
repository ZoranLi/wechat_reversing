package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public abstract class q extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gfN = "deviceId".hashCode();
    private static final int gfO = "sessionName".hashCode();
    private static final int gfP = "moveTime".hashCode();
    public String field_deviceId;
    public ec field_moveTime;
    public String field_sessionName;
    private boolean gfK = true;
    private boolean gfL = true;
    private boolean gfM = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfN == hashCode) {
                    this.field_deviceId = cursor.getString(i);
                } else if (gfO == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (gfP == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_moveTime = (ec) new ec().aD(blob);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
                    }
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_deviceId == null) {
            this.field_deviceId = "";
        }
        if (this.gfK) {
            contentValues.put("deviceId", this.field_deviceId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.gfL) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.gfM && this.field_moveTime != null) {
            try {
                contentValues.put("moveTime", this.field_moveTime.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
            }
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
