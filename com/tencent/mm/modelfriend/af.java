package com.tencent.mm.modelfriend;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.bc.a;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.as;
import com.tencent.mm.e.a.gw;
import com.tencent.mm.e.a.hg;
import com.tencent.mm.e.a.j;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.d;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class af implements am {
    private static HashMap<Integer, c> gJr;
    private com.tencent.mm.sdk.b.c hCA = new com.tencent.mm.sdk.b.c<gw>(this) {
        final /* synthetic */ af hCD;

        {
            this.hCD = r2;
            this.usg = gw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gw gwVar = (gw) bVar;
            if (gwVar instanceof gw) {
                String str = gwVar.fMh.fMj;
                if (bg.mA(str)) {
                    w.e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
                } else {
                    Cursor a = af.FY().hnH.a("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = " + str, null, 2);
                    List linkedList = new LinkedList();
                    while (a.moveToNext()) {
                        linkedList.add(a.getString(0));
                    }
                    a.close();
                    w.i("MicroMsg.SubCoreFriend", "hy: username: %s", linkedList.size() == 0 ? "" : (String) linkedList.get(0));
                    gwVar.fMi.userName = str;
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c hCB = new com.tencent.mm.sdk.b.c<nz>(this) {
        final /* synthetic */ af hCD;

        {
            this.hCD = r2;
            this.usg = nz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nz nzVar = (nz) bVar;
            Intent intent = nzVar.fVf.intent;
            String str = nzVar.fVf.username;
            if (intent == null || str == null || str.length() == 0) {
                w.e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            } else {
                ad jk = af.Gd().jk(str);
                if (jk != null) {
                    intent.putExtra("Contact_Uin", jk.hCb);
                    intent.putExtra("Contact_QQNick", jk.getDisplayName());
                }
                b iZ = af.FY().iZ(str);
                if (iZ != null) {
                    intent.putExtra("Contact_Mobile_MD5", iZ.EP());
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c hCC = new com.tencent.mm.sdk.b.c<j>(this) {
        final /* synthetic */ af hCD;

        {
            this.hCD = r2;
            this.usg = j.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a.xU(((j) bVar).fCx.scene);
            return false;
        }
    };
    private c hCm;
    private i hCn;
    private l hCo;
    private ac hCp;
    private ae hCq;
    private r hCr;
    private p hCs;
    private e hCt = new e();
    private LinkedList<ajm> hCu = null;
    private d hCv = new d();
    private f hCw = new f();
    private g hCx = new g();
    private com.tencent.mm.sdk.b.c hCy = new com.tencent.mm.sdk.b.c<as>(this) {
        final /* synthetic */ af hCD;

        {
            this.hCD = r2;
            this.usg = as.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            as asVar = (as) bVar;
            if (asVar instanceof as) {
                asVar.fEh.fDU = m.Fo();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c hCz = new com.tencent.mm.sdk.b.c<hg>(this) {
        final /* synthetic */ af hCD;

        {
            this.hCD = r2;
            this.usg = hg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hg hgVar = (hg) bVar;
            if (hgVar instanceof hg) {
                int i = hgVar.fMH.scene;
                k vVar = new v();
                ((zj) vVar.gUA.hsj.hsr).tdM = i;
                ap.vd().a(vVar, 0);
            }
            return false;
        }
    };

    private static af FX() {
        af afVar = (af) ap.yR().gs(af.class.getName());
        if (afVar != null) {
            return afVar;
        }
        Object afVar2 = new af();
        ap.yR().a(af.class.getName(), afVar2);
        return afVar2;
    }

    public static c FY() {
        h.vG().uQ();
        if (FX().hCm == null) {
            af FX = FX();
            ap.yY();
            FX.hCm = new c(com.tencent.mm.u.c.wO());
        }
        return FX().hCm;
    }

    public static i FZ() {
        h.vG().uQ();
        if (FX().hCn == null) {
            af FX = FX();
            ap.yY();
            FX.hCn = new i(com.tencent.mm.u.c.wO());
        }
        return FX().hCn;
    }

    public static l Ga() {
        h.vG().uQ();
        if (FX().hCo == null) {
            af FX = FX();
            ap.yY();
            FX.hCo = new l(com.tencent.mm.u.c.wO());
        }
        return FX().hCo;
    }

    public static ac Gb() {
        h.vG().uQ();
        if (FX().hCp == null) {
            af FX = FX();
            ap.yY();
            FX.hCp = new ac(com.tencent.mm.u.c.wO());
        }
        return FX().hCp;
    }

    public static r Gc() {
        h.vG().uQ();
        if (FX().hCr == null) {
            af FX = FX();
            ap.yY();
            FX.hCr = new r(com.tencent.mm.u.c.wO());
        }
        return FX().hCr;
    }

    public static ae Gd() {
        h.vG().uQ();
        if (FX().hCq == null) {
            af FX = FX();
            ap.yY();
            FX.hCq = new ae(com.tencent.mm.u.c.wO());
        }
        return FX().hCq;
    }

    public static void f(LinkedList<ajm> linkedList) {
        h.vG().uQ();
        FX().hCu = linkedList;
    }

    public static LinkedList<ajm> Ge() {
        h.vG().uQ();
        return FX().hCu;
    }

    public static void Gf() {
        h.vG().uQ();
        FX().hCu = null;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.hCB);
        com.tencent.mm.sdk.b.a.urY.c(this.hCC);
        com.tencent.mm.sdk.b.a.urY.c(this.hCA);
        com.tencent.mm.sdk.b.a.urY.c(this.hCv);
        com.tencent.mm.sdk.b.a.urY.c(this.hCw);
        com.tencent.mm.sdk.b.a.urY.c(this.hCx);
        com.tencent.mm.sdk.b.a.urY.c(this.hCy);
        com.tencent.mm.sdk.b.a.urY.c(this.hCz);
        d.c.aA(Integer.valueOf(42));
        this.hCu = null;
        l.a.sBD = null;
    }

    public final void eD(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return c.gUx;
            }
        });
        gJr.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return i.gUx;
            }
        });
        gJr.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
        gJr.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return ac.gUx;
            }
        });
        gJr.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return ae.gUx;
            }
        });
        gJr.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return r.gUx;
            }
        });
        gJr.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return p.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(42), this.hCt);
        com.tencent.mm.sdk.b.a.urY.b(this.hCB);
        com.tencent.mm.sdk.b.a.urY.b(this.hCC);
        com.tencent.mm.sdk.b.a.urY.b(this.hCA);
        com.tencent.mm.sdk.b.a.urY.b(this.hCv);
        com.tencent.mm.sdk.b.a.urY.b(this.hCw);
        com.tencent.mm.sdk.b.a.urY.b(this.hCx);
        com.tencent.mm.sdk.b.a.urY.b(this.hCy);
        com.tencent.mm.sdk.b.a.urY.b(this.hCz);
        l.a.sBD = FY();
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).registerIndexStorage(new com.tencent.mm.o.a());
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).registerNativeLogic(9, new com.tencent.mm.o.b());
    }

    public final void aN(boolean z) {
    }

    public static p Gg() {
        h.vG().uQ();
        if (FX().hCs == null) {
            af FX = FX();
            ap.yY();
            FX.hCs = new p(com.tencent.mm.u.c.wO());
        }
        return FX().hCs;
    }
}
