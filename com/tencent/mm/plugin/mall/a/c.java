package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements am, e {
    public ae mHandler = new ae(Looper.getMainLooper());
    ConcurrentHashMap<Integer, r> nvl = new ConcurrentHashMap();
    private boolean nvm = false;
    private a nvn = new a(this) {
        final /* synthetic */ c nvp;

        {
            this.nvp = r1;
        }

        public final void a(d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.SubCoreMall", "WalletNotifyConfXml:" + a);
            this.nvp.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 nvq;

                public final void run() {
                    com.tencent.mm.plugin.wallet_core.model.mall.c buC = com.tencent.mm.plugin.wallet_core.model.mall.c.buC();
                    String str = a;
                    MallNews Ic = com.tencent.mm.plugin.wallet_core.model.mall.c.Ic(str);
                    if (Ic == null) {
                        return;
                    }
                    if ("2".equals(Ic.type)) {
                        w.d("MicroMsg.MallNewsManager", "removeNews : " + Ic);
                        MallNews mallNews = (MallNews) buC.rIU.get(Ic.rIK);
                        if (mallNews != null && mallNews.qSx.equals(Ic.qSx) && mallNews.fGV.equals(Ic.fGV)) {
                            w.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + Ic.rIK);
                            buC.rIU.remove(Ic.rIK);
                            return;
                        }
                        w.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
                        return;
                    }
                    buC.rIU.put(Ic.rIK, Ic);
                    w.i("MicroMsg.MallNewsManager", "onRecieveMsg : " + str);
                    buC.aTl();
                    if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(Ic)) {
                        w.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                        return;
                    }
                    if (Ic.showType == 0) {
                        w.d("MicroMsg.MallNewsManager", "showType New");
                        com.tencent.mm.q.c.uk().s(262156, true);
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIb, Long.valueOf(System.currentTimeMillis()));
                    } else if (Ic.showType == 1) {
                        w.d("MicroMsg.MallNewsManager", "showType Dot");
                        com.tencent.mm.q.c.uk().t(262156, true);
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIb, Long.valueOf(System.currentTimeMillis()));
                    }
                    com.tencent.mm.plugin.wallet_core.model.mall.c.buE();
                }
            });
        }
    };
    private a nvo = new a(this) {
        final /* synthetic */ c nvp;

        {
            this.nvp = r1;
        }

        public final void a(d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[]{a});
            this.nvp.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 nvr;

                public final void run() {
                    com.tencent.mm.plugin.wallet_core.model.mall.c.buC();
                    com.tencent.mm.plugin.wallet_core.model.mall.c.HZ(a);
                }
            });
        }
    };

    public static c aIQ() {
        c cVar = (c) ap.yR().gs("plugin.mall");
        if (cVar != null) {
            return cVar;
        }
        w.w("MicroMsg.SubCoreMall", "not found in MMCore, new one");
        Object cVar2 = new c();
        ap.yR().a("plugin.mall", cVar2);
        return cVar2;
    }

    public final r pe(int i) {
        Object obj = null;
        if (!this.nvl.contains(Integer.valueOf(i))) {
            com.tencent.mm.plugin.wallet_core.c.e btX = m.btX();
            String str = "select * from WalletFunciontList where wallet_region = " + i;
            Cursor a = btX.gUz.a(str, null, 2);
            w.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo " + str);
            if (a != null) {
                if (a.moveToNext()) {
                    obj = new r();
                    obj.b(a);
                }
                a.close();
            }
            if (obj != null) {
                this.nvl.put(Integer.valueOf(i), obj);
            }
        }
        r rVar = (r) this.nvl.get(Integer.valueOf(i));
        if (rVar == null) {
            return new r();
        }
        return rVar;
    }

    public final ArrayList<MallFunction> pf(int i) {
        return pe(i).nvg;
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        ap.getSysCmdMsgExtension().a("mallactivity", this.nvn, true);
        ap.getSysCmdMsgExtension().a("paymsg", this.nvo, true);
        com.tencent.mm.plugin.wallet_core.model.mall.c.buC().Oe();
        com.tencent.mm.plugin.wallet_core.model.mall.d.buG().Oe();
        if (com.tencent.mm.u.m.xY() && com.tencent.mm.u.m.xU()) {
            b.vy(b.rIH);
        } else {
            b.vy(b.rIG);
        }
        ap.vd().a(302, this);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("mallactivity", this.nvn, true);
        ap.getSysCmdMsgExtension().b("paymsg", this.nvo, true);
        ap.vd().b(302, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i2 == 0 && i == 0 && !this.nvm && com.tencent.mm.u.m.xY()) {
            this.nvm = true;
            b.vy(b.rIH);
        }
    }
}
