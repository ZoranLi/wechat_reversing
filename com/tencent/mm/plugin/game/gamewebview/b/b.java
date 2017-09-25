package com.tencent.mm.plugin.game.gamewebview.b;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public final class b {
    public static Map<String, a> mls;

    public static void a(a aVar) {
        if (!bg.mA(aVar.getName())) {
            mls.put(aVar.getName(), aVar);
        }
    }
}
