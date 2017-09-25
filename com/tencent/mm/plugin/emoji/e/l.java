package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.me;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.b;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.a.e;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.storage.a.h;
import com.tencent.mm.storage.a.j;
import com.tencent.mm.storage.a.n;
import com.tencent.mm.storage.a.p;
import com.tencent.mm.storage.a.r;
import com.tencent.mm.storage.a.t;
import com.tencent.mm.storage.a.v;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class l {
    public static int gaH = -1;
    public static boolean kLl = false;
    public static boolean kLm = false;
    public static boolean kLn = false;
    public static boolean kLo = false;
    public static ArrayList<a> kLp = new ArrayList();
    public static HashMap<String, ArrayList<c>> kLq = new HashMap();
    public f kLa;
    public b kLb;
    public e kLc;
    public r kLd;
    public com.tencent.mm.storage.a.l kLe;
    public n kLf;
    public j kLg;
    public p kLh;
    t kLi;
    v kLj;
    h kLk;
    public final com.tencent.mm.sdk.e.j.a kLr = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ l kLv;

        {
            this.kLv = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (!bg.mA(str) && str.equals("event_update_group")) {
                w.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[]{(String) lVar.obj});
                if (com.tencent.mm.kernel.h.vG().uV()) {
                    com.tencent.mm.plugin.emoji.model.h.alX().alv();
                } else {
                    return;
                }
            }
            if (!bg.mA(str)) {
                if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                    w.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
                    l.kLl = true;
                    l.kLo = true;
                }
            }
        }
    };
    public final com.tencent.mm.sdk.e.j.a kLs = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ l kLv;

        {
            this.kLv = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            com.tencent.mm.plugin.emoji.model.h.alX().alv();
        }
    };
    public final com.tencent.mm.sdk.e.j.a kLt = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ l kLv;

        {
            this.kLv = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (str != null) {
                if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                    l.kLm = true;
                    return;
                }
                c ub = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(str);
                if (ub != null && ub.field_catalog == c.uKY) {
                    l.kLm = true;
                }
            }
        }
    };
    public final com.tencent.mm.sdk.b.c kLu = new com.tencent.mm.sdk.b.c<me>(this) {
        final /* synthetic */ l kLv;

        {
            this.kLv = r2;
            this.usg = me.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.emoji.EmojiStorageMgr", "REFRESH_PANEL_EVENT");
            l.kLm = true;
            return false;
        }
    };

    public l() {
        ap.yY();
        this.kLa = new f(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLb = new b(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLc = new e(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLe = new com.tencent.mm.storage.a.l(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLf = new n(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLg = new j(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLd = new r(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLh = new p(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLi = new t(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLj = new v(com.tencent.mm.u.c.wO());
        ap.yY();
        this.kLk = new h(com.tencent.mm.u.c.wO());
    }

    public final void alL() {
        Context context = ab.getContext();
        if (context != null) {
            ap.yY();
            w.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[]{String.valueOf(((Boolean) com.tencent.mm.u.c.vr().get(274480, Boolean.valueOf(true))).booleanValue())});
            if (((Boolean) com.tencent.mm.u.c.vr().get(274480, Boolean.valueOf(true))).booleanValue()) {
                this.kLa.eu(context);
                this.kLb.eu(context);
            }
            ap.yY();
            com.tencent.mm.u.c.vr().set(274480, Boolean.valueOf(false));
        }
        ap.yY();
        if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzT, Integer.valueOf(0))).intValue() != d.sYN) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.emoji.model.h.amc().kLb.bNq();
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzT, Integer.valueOf(d.sYN));
            w.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        ap.yY();
        if (((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzU, Boolean.valueOf(true))).booleanValue()) {
            long cs;
            g gVar;
            int aD;
            long currentTimeMillis2 = System.currentTimeMillis();
            b bVar = com.tencent.mm.plugin.emoji.model.h.amc().kLb;
            if (bVar.gUz instanceof g) {
                g gVar2 = (g) bVar.gUz;
                cs = gVar2.cs(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                gVar = null;
                cs = -1;
            }
            ArrayList bNd = bVar.bNd();
            if (!bNd.isEmpty()) {
                Iterator it = bNd.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (!(aVar == null || bg.mA(aVar.field_productID))) {
                        int Se = bVar.Se(aVar.field_productID);
                        if (aVar.field_count != Se) {
                            aVar.field_count = Se;
                            bVar.gUz.update("EmojiGroupInfo", aVar.pv(), "productID=?", new String[]{aVar.field_productID});
                        }
                    }
                }
            }
            if (gVar != null) {
                aD = gVar.aD(cs);
            } else {
                aD = -1;
            }
            bVar.a("event_update_group", 0, bg.bJZ().toString());
            Object obj = aD >= 0 ? 1 : null;
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzU, Boolean.valueOf(obj == null));
            w.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        }
    }

    public final f abK() {
        return this.kLa;
    }

    public final ArrayList<c> alM() {
        if (kLq == null) {
            kLq = new HashMap();
        }
        if (!kLq.containsKey("custom") || kLm) {
            kLq.put("custom", (ArrayList) this.kLa.bNy());
        }
        kLm = false;
        return (ArrayList) kLq.get("custom");
    }
}
