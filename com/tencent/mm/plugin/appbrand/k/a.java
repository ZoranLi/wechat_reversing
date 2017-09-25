package com.tencent.mm.plugin.appbrand.k;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class a extends i<a> {
    public static final String[] iCe = new String[]{i.a(a.iFJ, "AppBrandCommonKVBinaryData")};

    static final class a extends c {
        static final com.tencent.mm.sdk.e.c.a iFJ = u(a.class);
        @h(bKo = "$$invalid", bKp = 1)
        public String field_key;
        public byte[] field_value;

        a() {
        }

        protected final com.tencent.mm.sdk.e.c.a sY() {
            return iFJ;
        }

        public final void b(Cursor cursor) {
            this.field_key = cursor.getString(0);
            this.field_value = cursor.getBlob(1);
        }

        public final ContentValues pv() {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", this.field_key);
            contentValues.put(Columns.VALUE, this.field_value);
            return contentValues;
        }
    }

    public a(e eVar) {
        super(eVar, a.iFJ, "AppBrandCommonKVBinaryData", null);
    }

    public final void l(String str, byte[] bArr) {
        if (!bg.mA(str)) {
            c aVar = new a();
            aVar.field_key = str;
            aVar.field_value = bArr;
            super.a(aVar);
        }
    }

    public final <T extends com.tencent.mm.bd.a> T e(String str, Class<T> cls) {
        byte[] bArr;
        if (!bg.mA(str)) {
            c aVar = new a();
            aVar.field_key = str;
            if (super.b(aVar, new String[0])) {
                bArr = aVar.field_value;
                if (bg.bm(bArr)) {
                    return null;
                }
                try {
                    T t = (com.tencent.mm.bd.a) cls.newInstance();
                    t.aD(bArr);
                    return t;
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", new Object[]{cls.getSimpleName(), e});
                    return null;
                }
            }
        }
        bArr = null;
        if (bg.bm(bArr)) {
            return null;
        }
        T t2 = (com.tencent.mm.bd.a) cls.newInstance();
        t2.aD(bArr);
        return t2;
    }
}
