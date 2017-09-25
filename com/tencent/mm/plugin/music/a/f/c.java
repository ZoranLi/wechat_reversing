package com.tencent.mm.plugin.music.a.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends i<b> {
    public e gUz;
    public f<String, b> nUv = new f(20);

    public c(e eVar) {
        super(eVar, b.gTP, "PieceMusicInfo", null);
        this.gUz = eVar;
    }

    public final b BF(String str) {
        if (this.nUv.get(str) != null) {
            return (b) this.nUv.get(str);
        }
        String format = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
        Cursor a = this.gUz.a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            return null;
        }
        b bVar = new b();
        bVar.b(a);
        a.close();
        this.nUv.put(str, bVar);
        return bVar;
    }

    public final void q(String str, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("indexBitData", bArr);
        if (this.gUz.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str}) <= 0) {
            w.i("MicroMsg.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", new Object[]{Integer.valueOf(this.gUz.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str})), str});
        }
        b bVar = (b) this.nUv.get(str);
        if (bVar != null) {
            bVar.field_indexBitData = bArr;
        }
    }
}
