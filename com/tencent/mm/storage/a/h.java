package com.tencent.mm.storage.a;

import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;

public final class h extends i<g> implements a {
    public static final String[] gUx = new String[]{i.a(g.gTP, "EmojiSuggestDescInfo")};
    private e gUz;

    public h(e eVar) {
        this(eVar, g.gTP, "EmojiSuggestDescInfo");
    }

    private h(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final boolean ah(ArrayList<ArrayList<String>> arrayList) {
        if (arrayList.isEmpty()) {
            w.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
        } else {
            long cs;
            g gVar;
            if (this.gUz instanceof g) {
                g gVar2 = (g) this.gUz;
                cs = gVar2.cs(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                cs = -1;
                gVar = null;
            }
            this.gUz.delete("EmojiSuggestDescInfo", "", null);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                ArrayList arrayList2 = (ArrayList) it.next();
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    i2 = i;
                } else {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!bg.mA(str)) {
                            w.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[]{String.valueOf(i), str});
                            b(new g(String.valueOf(i), str));
                        }
                    }
                    i2 = i + 1;
                }
                i = i2;
            }
            if (gVar != null) {
                gVar.aD(cs);
            }
        }
        return false;
    }
}
