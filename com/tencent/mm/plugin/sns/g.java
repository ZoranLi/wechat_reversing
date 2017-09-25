package com.tencent.mm.plugin.sns;

import com.tencent.mm.ao.i;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public final class g extends c<lc> {
    public g() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((lc) bVar) instanceof lc)) {
            w.f("MicroMsg.PostSnsAsyncTaskListener", "mismatched event");
            return false;
        } else if (ae.beu()) {
            return false;
        } else {
            int i;
            List linkedList;
            int a;
            w.d("MicroMsg.PostSnsAsyncTask", "check PostTaskSnsPost ");
            if (ae.beH() != null) {
                ae.beH().bdz();
            }
            w.d("MicroMsg.PostSnsAsyncTask", "check AsyncQueue");
            if (ae.beB() != null) {
                ae.beK().bem();
            }
            h.vJ();
            if (h.vG().uV()) {
                h.vJ();
                h.vG();
                if (!a.uP()) {
                    i = 1;
                    if (i != 0) {
                        h.vJ();
                        if ((bg.az(bg.a((Long) h.vI().vr().get(68390, null), 0)) * 1000 <= 3600000 ? 1 : 0) != 0) {
                            linkedList = new LinkedList();
                            h.vJ();
                            a = bg.a((Integer) h.vI().vr().get(68388, null), 0);
                            h.vJ();
                            i = bg.a((Integer) h.vI().vr().get(68389, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new i.a(10077, a + "," + i));
                                h.vJ();
                                h.vI().vr().set(68388, Integer.valueOf(0));
                                h.vJ();
                                h.vI().vr().set(68389, Integer.valueOf(0));
                            }
                            h.vJ();
                            i = bg.a((Integer) h.vI().vr().get(68391, null), 0);
                            if (i > 0) {
                                linkedList.add(new i.a(28, String.valueOf(i)));
                                h.vJ();
                                h.vI().vr().set(68391, Integer.valueOf(0));
                            }
                            h.vJ();
                            a = bg.a((Integer) h.vI().vr().get(68392, null), 0);
                            h.vJ();
                            i = bg.a((Integer) h.vI().vr().get(68393, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new i.a(10072, a + "," + i));
                                h.vJ();
                                h.vI().vr().set(68392, Integer.valueOf(0));
                                h.vJ();
                                h.vI().vr().set(68393, Integer.valueOf(0));
                            }
                            if (!linkedList.isEmpty()) {
                                h.vJ();
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new i(linkedList));
                                h.vJ();
                                h.vI().vr().set(68390, Long.valueOf(bg.Ny()));
                            }
                        }
                    }
                    return true;
                }
            }
            i = 0;
            if (i != 0) {
                h.vJ();
                if (bg.az(bg.a((Long) h.vI().vr().get(68390, null), 0)) * 1000 <= 3600000) {
                }
                if ((bg.az(bg.a((Long) h.vI().vr().get(68390, null), 0)) * 1000 <= 3600000 ? 1 : 0) != 0) {
                    linkedList = new LinkedList();
                    h.vJ();
                    a = bg.a((Integer) h.vI().vr().get(68388, null), 0);
                    h.vJ();
                    i = bg.a((Integer) h.vI().vr().get(68389, null), 0);
                    linkedList.add(new i.a(10077, a + "," + i));
                    h.vJ();
                    h.vI().vr().set(68388, Integer.valueOf(0));
                    h.vJ();
                    h.vI().vr().set(68389, Integer.valueOf(0));
                    h.vJ();
                    i = bg.a((Integer) h.vI().vr().get(68391, null), 0);
                    if (i > 0) {
                        linkedList.add(new i.a(28, String.valueOf(i)));
                        h.vJ();
                        h.vI().vr().set(68391, Integer.valueOf(0));
                    }
                    h.vJ();
                    a = bg.a((Integer) h.vI().vr().get(68392, null), 0);
                    h.vJ();
                    i = bg.a((Integer) h.vI().vr().get(68393, null), 0);
                    linkedList.add(new i.a(10072, a + "," + i));
                    h.vJ();
                    h.vI().vr().set(68392, Integer.valueOf(0));
                    h.vJ();
                    h.vI().vr().set(68393, Integer.valueOf(0));
                    if (linkedList.isEmpty()) {
                        h.vJ();
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new i(linkedList));
                        h.vJ();
                        h.vI().vr().set(68390, Long.valueOf(bg.Ny()));
                    }
                }
            }
            return true;
        }
    }
}
