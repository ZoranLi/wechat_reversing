package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cs extends c {
    private static final int gBj = "productId".hashCode();
    private static final int gBk = "xmlContent".hashCode();
    private static final int gBl = "ScanTime".hashCode();
    private static final int gBm = "funcType".hashCode();
    private static final int gBn = "qrcodeUrl".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcs = "scene".hashCode();
    public long field_ScanTime;
    public int field_funcType;
    public String field_productId;
    public String field_qrcodeUrl;
    public int field_scene;
    public String field_xmlContent;
    private boolean gBe = true;
    private boolean gBf = true;
    private boolean gBg = true;
    private boolean gBh = true;
    private boolean gBi = true;
    private boolean gcq = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gBj == hashCode) {
                    this.field_productId = cursor.getString(i);
                    this.gBe = true;
                } else if (gBk == hashCode) {
                    this.field_xmlContent = cursor.getString(i);
                } else if (gBl == hashCode) {
                    this.field_ScanTime = cursor.getLong(i);
                } else if (gBm == hashCode) {
                    this.field_funcType = cursor.getInt(i);
                } else if (gBn == hashCode) {
                    this.field_qrcodeUrl = cursor.getString(i);
                } else if (gcs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gBe) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.gBf) {
            contentValues.put("xmlContent", this.field_xmlContent);
        }
        if (this.gBg) {
            contentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
        }
        if (this.gBh) {
            contentValues.put("funcType", Integer.valueOf(this.field_funcType));
        }
        if (this.gBi) {
            contentValues.put("qrcodeUrl", this.field_qrcodeUrl);
        }
        if (this.gcq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
