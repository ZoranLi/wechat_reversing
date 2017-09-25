package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a.bk;
import com.tencent.mm.e.a.mq;
import com.tencent.mm.e.a.sd;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.c.g;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.i;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class m implements am {
    private static HashMap<Integer, c> gJr;
    private o rHd = new o();
    private af rHe = null;
    private j rHf = null;
    private com.tencent.mm.plugin.wallet_core.c.c rHg = null;
    private z rHh = null;
    private ac rHi = null;
    private a rHj = null;
    private f rHk = null;
    private d rHl = null;
    private s rHm = new s();
    private e rHn = null;
    private i rHo = null;
    private h rHp = null;
    private g rHq = null;
    private com.tencent.mm.plugin.wallet_core.id_verify.util.a rHr = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    private com.tencent.mm.sdk.b.c rHs = new com.tencent.mm.sdk.b.c<mq>(this) {
        final /* synthetic */ m rHw;

        {
            this.rHw = r2;
            this.usg = mq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mq mqVar = (mq) bVar;
            m.r(mqVar.fTW.context, mqVar.fTW.intent);
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c rHt = new com.tencent.mm.sdk.b.c<bk>(this) {
        final /* synthetic */ m rHw;

        {
            this.rHw = r2;
            this.usg = bk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.wallet_core.c.a.cbV();
            com.tencent.mm.wallet_core.c.a.clean();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<sd> rHu = new com.tencent.mm.sdk.b.c<sd>(this) {
        final /* synthetic */ m rHw;

        {
            this.rHw = r2;
            this.usg = sd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w wVar;
            sd sdVar = (sd) bVar;
            g btP = m.btP();
            String str = sdVar.fZD.fZF;
            if (!bg.mA(str)) {
                if (g.ioj.containsKey(str)) {
                    wVar = (w) g.ioj.get(str);
                } else {
                    wVar = btP.If(str);
                    if (wVar != null) {
                        g.ioj.put(str, wVar);
                    }
                }
                if (wVar != null) {
                    sdVar.fZE.fZG = wVar.field_hbStatus;
                    sdVar.fZE.fZH = wVar.field_receiveStatus;
                }
                return false;
            }
            wVar = null;
            if (wVar != null) {
                sdVar.fZE.fZG = wVar.field_hbStatus;
                sdVar.fZE.fZH = wVar.field_receiveStatus;
            }
            return false;
        }
    };
    private bp.a rHv = new bp.a(this) {
        final /* synthetic */ m rHw;

        {
            this.rHw = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            Map q = bh.q(n.a(aVar.hst.tff), "sysmsg");
            if (q != null) {
                int i = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                w.i("MicroMsg.SubCoreNfc", "got a pay msg, type = " + i);
                switch (i) {
                    case 16:
                        i = bg.getInt((String) q.get(".sysmsg.paymsg.Flag"), 0);
                        w.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                        if (i == 1) {
                            w.i("MicroMsg.SubCoreNfc", "open wallet");
                            com.tencent.mm.u.m.xV();
                            return;
                        } else if (i == 2) {
                            w.i("MicroMsg.SubCoreNfc", "close wallet");
                            i = com.tencent.mm.u.m.xR() & -32769;
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vI().vr().set(40, Integer.valueOf(i));
                            return;
                        } else {
                            return;
                        }
                    case 17:
                        i = bg.getInt((String) q.get(".sysmsg.paymsg.WalletType"), -1);
                        w.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                        if (i >= 0) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(339975, Integer.valueOf(i));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };

    static {
        k.b("tenpay_utils", m.class.getClassLoader());
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return j.gUx;
            }
        });
        gJr.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.wallet_core.c.c.gUx;
            }
        });
        gJr.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return a.gUx;
            }
        });
        gJr.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return f.gUx;
            }
        });
        gJr.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
        gJr.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return h.gUx;
            }
        });
        gJr.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return e.gUx;
            }
        });
        gJr.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return i.gUx;
            }
        });
        gJr.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new c() {
            public final String[] pP() {
                return g.gUx;
            }
        });
    }

    public static m btN() {
        m mVar = (m) ap.yR().gs("plugin.wallet_core");
        if (mVar != null) {
            return mVar;
        }
        w.w("MicroMsg.SubCoreNfc", "[NFC]not found in MMCore, new one");
        Object mVar2 = new m();
        ap.yR().a("plugin.wallet_core", mVar2);
        return mVar2;
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public static j btO() {
        if (ap.zb()) {
            if (btN().rHf == null) {
                m btN = btN();
                ap.yY();
                btN.rHf = new j(com.tencent.mm.u.c.wO());
            }
            return btN().rHf;
        }
        throw new com.tencent.mm.u.b();
    }

    public static g btP() {
        if (ap.zb()) {
            if (btN().rHq == null) {
                m btN = btN();
                ap.yY();
                btN.rHq = new g(com.tencent.mm.u.c.wO());
            }
            return btN().rHq;
        }
        throw new com.tencent.mm.u.b();
    }

    public static com.tencent.mm.plugin.wallet_core.c.c btQ() {
        if (ap.zb()) {
            if (btN().rHg == null) {
                m btN = btN();
                ap.yY();
                btN.rHg = new com.tencent.mm.plugin.wallet_core.c.c(com.tencent.mm.u.c.wO());
            }
            return btN().rHg;
        }
        throw new com.tencent.mm.u.b();
    }

    public static h btR() {
        if (ap.zb()) {
            if (btN().rHp == null) {
                m btN = btN();
                ap.yY();
                btN.rHp = new h(com.tencent.mm.u.c.wO());
            }
            return btN().rHp;
        }
        throw new com.tencent.mm.u.b();
    }

    public static af btS() {
        if (ap.zb()) {
            if (btN().rHe == null) {
                btN().rHe = new af();
            }
            return btN().rHe;
        }
        throw new com.tencent.mm.u.b();
    }

    public static ac btT() {
        if (ap.zb()) {
            if (btN().rHi == null) {
                btN().rHi = new ac();
            }
            return btN().rHi;
        }
        throw new com.tencent.mm.u.b();
    }

    public static a btU() {
        if (ap.zb()) {
            if (btN().rHj == null) {
                m btN = btN();
                ap.yY();
                btN.rHj = new a(com.tencent.mm.u.c.wO());
            }
            return btN().rHj;
        }
        throw new com.tencent.mm.u.b();
    }

    public static f btV() {
        if (ap.zb()) {
            if (btN().rHk == null) {
                m btN = btN();
                ap.yY();
                btN.rHk = new f(com.tencent.mm.u.c.wO());
            }
            return btN().rHk;
        }
        throw new com.tencent.mm.u.b();
    }

    public static d btW() {
        if (ap.zb()) {
            if (btN().rHl == null) {
                m btN = btN();
                ap.yY();
                btN.rHl = new d(com.tencent.mm.u.c.wO());
            }
            return btN().rHl;
        }
        throw new com.tencent.mm.u.b();
    }

    public static e btX() {
        if (ap.zb()) {
            if (btN().rHn == null) {
                m btN = btN();
                ap.yY();
                btN.rHn = new e(com.tencent.mm.u.c.wO());
            }
            return btN().rHn;
        }
        throw new com.tencent.mm.u.b();
    }

    public static i btY() {
        if (ap.zb()) {
            if (btN().rHo == null) {
                m btN = btN();
                ap.yY();
                btN.rHo = new i(com.tencent.mm.u.c.wO());
            }
            return btN().rHo;
        }
        throw new com.tencent.mm.u.b();
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public static z btZ() {
        return btN().rHh;
    }

    public final void aM(boolean z) {
        com.tencent.mm.wallet_core.c.a.cbV();
        com.tencent.mm.wallet_core.c.a.init(ab.getContext());
        ap.getSysCmdMsgExtension().a("paymsg", this.rHv, true);
        btS().buv();
        this.rHh = z.buc();
        ap.getSysCmdMsgExtension().a("paymsg", this.rHh.kAf, true);
        com.tencent.mm.sdk.b.a.urY.b(this.rHs);
        com.tencent.mm.sdk.b.a.urY.b(this.rHm);
        com.tencent.mm.sdk.b.a.urY.a(this.rHt);
        com.tencent.mm.sdk.b.a.urY.a(this.rHu);
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("paymsg", this.rHv, true);
        btS().aue();
        ac btT = btT();
        btT.rIh = null;
        btT.rIg.clear();
        btT.rIg = new ArrayList();
        ap.getSysCmdMsgExtension().b("paymsg", this.rHh.kAf, true);
        if (z.lxc != null) {
            z.lxc.clear();
        }
        this.rHh = null;
        com.tencent.mm.sdk.b.a.urY.c(this.rHs);
        com.tencent.mm.sdk.b.a.urY.c(this.rHm);
        com.tencent.mm.sdk.b.a.urY.c(this.rHt);
        com.tencent.mm.sdk.b.a.urY.c(this.rHu);
    }

    public static void r(Context context, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (com.tencent.mm.u.m.xZ()) {
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            w.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is h5,jump to ibg");
            com.tencent.mm.bb.d.b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
        } else if (com.tencent.mm.u.m.ya()) {
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            com.tencent.mm.bb.d.b(context, "mall", ".ui.MallIndexOSUI", intent);
        } else {
            w.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is native");
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            com.tencent.mm.bb.d.b(context, "mall", ".ui.MallIndexUI", intent);
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                ap.vd().a(new com.tencent.mm.ap.k(11), 0);
            }
        }
    }

    public static o bua() {
        return btN().rHd;
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.b bVar, com.tencent.mm.plugin.wallet_core.id_verify.util.a.a aVar) {
        return btN().rHr.a(mMActivity, 2, bVar, aVar, false, (int) MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, true);
    }

    public static boolean b(MMActivity mMActivity, com.tencent.mm.wallet_core.d.b bVar, com.tencent.mm.plugin.wallet_core.id_verify.util.a.a aVar) {
        return btN().rHr.a(mMActivity, 4, bVar, aVar, false, (int) MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, false);
    }
}
