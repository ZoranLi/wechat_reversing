package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public final class b implements d, e {
    private Queue<a> qSQ = null;
    private boolean qSR = false;

    static class a {
        public String iru;
        public Queue<String> qSS = new LinkedList();

        a(String str) {
            this.iru = str;
            w.d("MicroMsg.PushMessageExtension", "DoSceneStruct:" + str);
            ArrayList aU = com.tencent.mm.pluginsdk.l.a.a.aU(ab.getContext(), str);
            if (aU == null || aU.size() <= 0) {
                w.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
                return;
            }
            for (int i = 0; i < aU.size(); i++) {
                Map map = ((com.tencent.mm.pluginsdk.l.a.a) aU.get(i)).sHh;
                if (map != null) {
                    for (Entry value : map.entrySet()) {
                        this.qSS.offer(value.getValue());
                    }
                }
            }
        }
    }

    public final com.tencent.mm.y.d.b b(com.tencent.mm.y.d.a aVar) {
        String a = n.a(aVar.hst.tff);
        if (this.qSQ == null) {
            this.qSQ = new LinkedList();
        }
        a aVar2 = new a(a);
        if (aVar2.iru != null) {
            this.qSQ.offer(aVar2);
            bmX();
        }
        return null;
    }

    private void bmX() {
        if (!this.qSR && this.qSQ.size() != 0) {
            a aVar = (a) this.qSQ.peek();
            if (aVar.qSS.size() == 0) {
                this.qSQ.poll();
                ap.yY();
                c.vr().set(8193, aVar.iru);
                ap.yY();
                c.vr().set(8449, Long.valueOf(bg.Ny()));
                return;
            }
            String str = (String) aVar.qSS.peek();
            if (str != null && str.length() > 0) {
                this.qSR = true;
                k aVar2 = new a(str);
                ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.map.k.CTRL_INDEX, (e) this);
                ap.vd().a(aVar2, 0);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.map.k.CTRL_INDEX) {
            this.qSR = false;
            return;
        }
        ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.map.k.CTRL_INDEX, (e) this);
        String str2 = ((a) kVar).url;
        a aVar = (a) this.qSQ.peek();
        if (aVar == null || aVar.qSS.size() == 0) {
            w.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
            this.qSQ = new LinkedList();
            this.qSR = false;
        } else if (aVar.qSS.size() == 0) {
            w.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
            this.qSQ.poll();
            this.qSR = false;
        } else if (!((String) aVar.qSS.peek()).equals(str2)) {
            w.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
            this.qSQ.poll();
            this.qSR = false;
        } else if (i == 0 && i2 == 0) {
            aVar.qSS.poll();
            this.qSR = false;
            bmX();
        } else {
            w.e("MicroMsg.PushMessageExtension", "down failed [" + i + "," + i2 + "] ignore this message : img:[" + str2 + "] ");
            this.qSQ.poll();
            this.qSR = false;
        }
    }

    public final void h(au auVar) {
    }
}
