package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import java.util.HashMap;

public final class a {
    private static HashMap<Integer, d> mlv = new HashMap();

    public static void a(d dVar) {
        mlv.put(Integer.valueOf(dVar.hashCode()), dVar);
    }

    public static void b(d dVar) {
        mlv.remove(Integer.valueOf(dVar.hashCode()));
    }

    public static d ns(int i) {
        return (d) mlv.get(Integer.valueOf(i));
    }
}
