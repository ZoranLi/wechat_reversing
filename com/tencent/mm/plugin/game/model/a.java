package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.GameABTestStrategy";

    public static class a {
        public int fRW = 0;
        public String url = "";
    }

    public static a aAu() {
        a aVar = new a();
        c dX = com.tencent.mm.u.c.c.Az().dX("100001");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            aVar.fRW = bg.getInt((String) bKK.get("game_homepage_jump"), 0);
            String str = (String) bKK.get("game_homepage_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            w.i(TAG, "getIndexABTestInfo success, layerId = %s, flag = %d, url = %s", new Object[]{dX.field_layerId, Integer.valueOf(aVar.fRW), aVar.url});
            return aVar;
        }
        w.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(dX.field_startTime), Long.valueOf(dX.field_endTime)});
        return aVar;
    }

    public static a xN(String str) {
        a aVar = new a();
        if (bg.mA(str)) {
            w.e(TAG, "appid is null");
            return aVar;
        }
        c dX = com.tencent.mm.u.c.c.Az().dX("100002");
        if (dX.isValid()) {
            w.i(TAG, "getDetailABTestInfo success, layerId = %s", new Object[]{dX.field_layerId});
            Map bKK = dX.bKK();
            aVar.fRW = bg.getInt((String) bKK.get("game_detail_jump"), 0);
            String str2 = (String) bKK.get("game_detail_url");
            aVar.url = str2 == null ? "" : str2 + str;
            return aVar;
        }
        w.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(dX.field_startTime), Long.valueOf(dX.field_endTime)});
        return aVar;
    }

    public static a aAv() {
        a aVar = new a();
        c dX = com.tencent.mm.u.c.c.Az().dX("100003");
        if (dX.isValid()) {
            w.i(TAG, "getLibraryABTestInfo success, layerId = %s", new Object[]{dX.field_layerId});
            Map bKK = dX.bKK();
            aVar.fRW = bg.getInt((String) bKK.get("game_library_jump"), 0);
            String str = (String) bKK.get("game_library_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            return aVar;
        }
        w.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(dX.field_startTime), Long.valueOf(dX.field_endTime)});
        return aVar;
    }

    public static a aAw() {
        a aVar = new a();
        c dX = com.tencent.mm.u.c.c.Az().dX("100022");
        if (!dX.isValid()) {
            return aVar;
        }
        Map bKK = dX.bKK();
        aVar.fRW = bg.getInt((String) bKK.get("game_message_jump"), 0);
        String str = (String) bKK.get("game_message_url");
        if (str == null) {
            str = "";
        }
        aVar.url = str;
        return aVar;
    }
}
