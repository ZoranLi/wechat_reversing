package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.a.a;
import java.util.HashMap;

public final class h extends a {
    private static String TAG = "MicroMsg.MMBakItemFactory";
    private static h jGg;
    private HashMap<Integer, e> jGh;

    public static h abc() {
        if (jGg == null) {
            a hVar = new h();
            jGg = hVar;
            a.a(hVar);
        }
        return jGg;
    }

    public final void ZY() {
        jGg = null;
    }

    public final e jj(int i) {
        if (this.jGh == null) {
            this.jGh = new HashMap();
            this.jGh.put(Integer.valueOf(3), new i());
            this.jGh.put(Integer.valueOf(47), new f());
            this.jGh.put(Integer.valueOf(49), new g());
            this.jGh.put(Integer.valueOf(34), new l());
            k kVar = new k();
            this.jGh.put(Integer.valueOf(43), kVar);
            this.jGh.put(Integer.valueOf(44), kVar);
            this.jGh.put(Integer.valueOf(62), kVar);
            j jVar = new j();
            this.jGh.put(Integer.valueOf(48), jVar);
            this.jGh.put(Integer.valueOf(42), jVar);
            this.jGh.put(Integer.valueOf(10000), jVar);
            this.jGh.put(Integer.valueOf(1), jVar);
            this.jGh.put(Integer.valueOf(37), jVar);
            this.jGh.put(Integer.valueOf(40), jVar);
            this.jGh.put(Integer.valueOf(50), jVar);
        }
        return (e) this.jGh.get(Integer.valueOf(i));
    }
}
