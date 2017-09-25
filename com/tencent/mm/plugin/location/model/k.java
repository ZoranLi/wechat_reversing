package com.tencent.mm.plugin.location.model;

import com.tencent.mm.i.g;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class k implements e {
    List<com.tencent.mm.pluginsdk.location.a> gJv = new ArrayList();
    public int h = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
    public ar hCV = new ar(1, "location_worker");
    LinkedList<b> nbw = new LinkedList();
    public b nbx = null;
    public int w = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;

    public class a implements com.tencent.mm.sdk.platformtools.ar.a {
        private byte[] data;
        private String mFilePath;
        private int nbA;
        final /* synthetic */ k nbB;
        boolean nby = true;
        private int nbz;
        String url = "";

        public a(k kVar, boolean z, String str, String str2) {
            this.nbB = kVar;
            this.nby = z;
            this.nbz = kVar.w;
            this.nbA = kVar.h;
            this.url = str;
            while (this.nbz * this.nbA > 270000) {
                this.nbz = (int) (((double) this.nbz) / 1.2d);
                this.nbA = (int) (((double) this.nbA) / 1.2d);
            }
            this.mFilePath = str2;
            w.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[]{str, bg.ap(this.mFilePath, "")});
        }

        public final boolean Bn() {
            this.data = bg.Qc(this.url);
            if (this.data != null) {
                com.tencent.mm.a.e.b(this.mFilePath, this.data, this.data.length);
            }
            return true;
        }

        public final boolean Bo() {
            w.i("MicroMsg.StaticMapServer", "http onPostExecute " + (this.data == null) + " isGoole: " + this.nby);
            if (this.data != null) {
                this.nbB.fm(true);
            } else if (!this.nby) {
                this.nbB.fm(false);
            } else if (this.nbB.nbx == null) {
                this.nbB.fm(false);
            } else {
                this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(this.nbz), Integer.valueOf(this.nbA), Float.valueOf(this.nbB.nbx.hCQ), Float.valueOf(this.nbB.nbx.hCP), Integer.valueOf(this.nbB.nbx.fOd)});
                this.nbB.hCV.c(new a(this.nbB, false, this.url, k.b(this.nbB.nbx)));
            }
            return false;
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.a aVar) {
        this.gJv.remove(aVar);
        w.i("MicroMsg.StaticMapServer", "removeCallback " + this.gJv.size());
        if (this.gJv.size() == 0) {
            w.i("MicroMsg.StaticMapServer", "clean task");
            this.nbw.clear();
            this.nbx = null;
            stop();
        }
    }

    public k() {
        start();
    }

    public final void start() {
        ap.vd().a(648, this);
    }

    public final void stop() {
        w.i("MicroMsg.StaticMapServer", "stop static map server");
        ap.vd().b(648, this);
    }

    final void Gj() {
        if (this.nbx == null && this.nbw.size() > 0) {
            int intValue;
            this.nbx = (b) this.nbw.removeFirst();
            try {
                intValue = Integer.valueOf(bg.ap(g.sV().getValue("StaticMapGetClient"), "")).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            w.i("MicroMsg.StaticMapServer", "run local %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue == 0) {
                ap.vd().a(new g(this.nbx.hCP, this.nbx.hCQ, this.nbx.fOd + 1, this.w, this.h, b(this.nbx), v.bIN()), 0);
                return;
            }
            int i = this.w;
            for (intValue = this.h; i * intValue > 270000; intValue = (int) (((double) intValue) / 1.2d)) {
                i = (int) (((double) i) / 1.2d);
            }
            if (bg.Hp()) {
                this.hCV.c(new a(this, true, String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nbx.hCP), Float.valueOf(this.nbx.hCQ), Integer.valueOf(this.nbx.fOd), v.bIN()}), b(this.nbx)));
                return;
            }
            this.hCV.c(new a(this, false, String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nbx.hCQ), Float.valueOf(this.nbx.hCP), Integer.valueOf(this.nbx.fOd)}), b(this.nbx)));
        }
    }

    public static String b(b bVar) {
        String n = com.tencent.mm.a.g.n((bVar.toString()).getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        String stringBuilder2 = stringBuilder.append(c.xc()).append(n.charAt(0)).append(n.charAt(1)).append("/").append(n.charAt(3)).append(n.charAt(4)).append("/").toString();
        if (!com.tencent.mm.a.e.aO(stringBuilder2)) {
            new File(stringBuilder2).mkdirs();
        }
        return stringBuilder2 + "static_map_" + n;
    }

    public final void fm(boolean z) {
        w.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            if (this.nbx != null) {
                for (com.tencent.mm.pluginsdk.location.a aVar : this.gJv) {
                    if (aVar != null) {
                        aVar.a(b(this.nbx), this.nbx);
                    }
                }
            }
        } else if (this.nbx != null) {
            for (com.tencent.mm.pluginsdk.location.a aVar2 : this.gJv) {
                if (aVar2 != null) {
                    aVar2.a(this.nbx);
                }
            }
        }
        this.nbx = null;
        Gj();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar.getType() != 648) {
            return;
        }
        if (i == 0 && i2 == 0 && this.nbx != null) {
            fm(true);
        } else {
            fm(false);
        }
    }
}
