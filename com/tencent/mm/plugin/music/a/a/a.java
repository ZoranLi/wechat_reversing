package com.tencent.mm.plugin.music.a.a;

import android.database.Cursor;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class a {
    static final Long kyu = Long.valueOf(604800000);
    private static final Long nTu = Long.valueOf(86400000);
    public static final Long nTv = Long.valueOf(43200000);
    private static final Long nTw = Long.valueOf(240000);
    static final Long nTx = nTu;
    private static final Long nTy = Long.valueOf(60000);
    private List<String> nTt = new ArrayList(10);

    public a(List<String> list) {
        if (!list.isEmpty()) {
            this.nTt.addAll(list);
        }
    }

    final boolean Bw(String str) {
        for (String contains : this.nTt) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static void aNX() {
        w.i("MicroMsg.CleanMusicController", "scanMusicFile");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.music.a.f.a aNT = i.aNT();
        String format = String.format("SELECT * from %s WHERE updateTime < ? AND musicType <> ? limit 10", new Object[]{"Music"});
        long currentTimeMillis2 = System.currentTimeMillis() - 604800000;
        List<com.tencent.mm.am.a> arrayList = new ArrayList();
        Cursor rawQuery = aNT.gUz.rawQuery(format, new String[]{String.valueOf(currentTimeMillis2), "6"});
        while (rawQuery.moveToNext()) {
            com.tencent.mm.am.a aVar = new com.tencent.mm.am.a();
            aVar.b(rawQuery);
            arrayList.add(aVar);
        }
        rawQuery.close();
        for (com.tencent.mm.am.a aVar2 : arrayList) {
            String e = h.e(aVar2, true);
            String e2 = h.e(aVar2, false);
            String f = h.f(aVar2, false);
            String f2 = h.f(aVar2, true);
            FileOp.deleteFile(e);
            FileOp.deleteFile(e2);
            FileOp.deleteFile(f);
            FileOp.deleteFile(f2);
            com.tencent.mm.plugin.music.a.f.a aNT2 = i.aNT();
            e2 = aVar2.field_musicId;
            aNT2.nUv.remove(e2);
            aNT2.nUw.remove(e2);
            aNT2 = i.aNT();
            e2 = aVar2.field_musicId;
            int delete = aNT2.gUz.delete("Music", "musicId=?", new String[]{e2});
            w.i("MicroMsg.CleanMusicController", "delete music %d %s", new Object[]{Integer.valueOf(delete), aVar2.field_musicId});
        }
        w.i("MicroMsg.CleanMusicController", "scanMusic UseTime=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ArrayList arrayList2 = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(285);
        iDKey.SetKey(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE);
        iDKey.SetValue((int) r0);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(285);
        iDKey2.SetKey(255);
        iDKey2.SetValue(1);
        arrayList2.add(iDKey);
        arrayList2.add(iDKey2);
        g.oUh.b(arrayList2, false);
    }
}
