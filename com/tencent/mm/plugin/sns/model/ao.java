package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.pk;
import com.tencent.mm.e.a.pl;
import com.tencent.mm.e.a.pm;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.e.a.qr;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao {
    private static HashMap<String, b> pXt = new HashMap();
    public static LinkedList<a> pXu = new LinkedList();
    private static c pXv = new c<qr>() {
        {
            this.usg = qr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = 1;
            qr qrVar = (qr) bVar;
            if (qrVar instanceof qr) {
                String str = qrVar.fXN.id;
                int i2 = qrVar.fXN.type;
                a bF = ao.bF(str, i2);
                if (bF != null) {
                    String str2 = qrVar.fXN.fXO;
                    bF.pXx = str2;
                    bF.fWo = qrVar.fXN.fWo;
                    String str3 = "MicroMsg.SnsTranslateManager";
                    String str4 = "finish translate, id:%s, type: %d, success: %b";
                    Object[] objArr = new Object[3];
                    objArr[0] = bF.id;
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Boolean.valueOf(!bg.mA(str2));
                    w.i(str3, str4, objArr);
                    switch (i2) {
                        case 2:
                            break;
                        case 3:
                            i = 2;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    if (i != -1) {
                        ao.e(str, i, bF.pXx, bF.fWo);
                        ao.pXu.remove(bF);
                    }
                }
            }
            return false;
        }
    };

    private static class a {
        String fWo;
        String id;
        String pXw;
        String pXx;
        int type;

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            if (this.id.equals(aVar.id) && this.type == aVar.type) {
                return true;
            }
            return false;
        }
    }

    public static class b {
        public int gkv;
        public boolean hoD;
        public boolean hrm;
        public String hwe;
        public String id;
        public boolean pXy;
        public boolean pXz;
        public String result;
    }

    public static a bF(String str, int i) {
        Iterator it = pXu.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == i && !bg.mA(str) && !bg.mA(aVar.id) && str.equals(aVar.id)) {
                return aVar;
            }
        }
        return null;
    }

    public static void init() {
        com.tencent.mm.sdk.b.a.urY.b(pXv);
    }

    public static void NU() {
        com.tencent.mm.sdk.b.a.urY.c(pXv);
    }

    private static boolean oL() {
        if (!d.Jt("translate")) {
            return false;
        }
        String value = g.sV().getValue("TranslateSnsOff");
        if (bg.mA(value)) {
            return true;
        }
        if (bg.PY(value) == 0) {
            return true;
        }
        return false;
    }

    public static void a(Menu menu, boolean z) {
        if (!oL()) {
            return;
        }
        if (z) {
            menu.add(0, 14, 0, j.pMN);
        } else {
            menu.add(0, 15, 0, j.pMN);
        }
    }

    public static void b(Menu menu, boolean z) {
        if (!oL()) {
            return;
        }
        if (z) {
            menu.add(0, 16, 0, j.pMP);
        } else {
            menu.add(0, 17, 0, j.pMP);
        }
    }

    public static void o(m mVar) {
        if (mVar != null) {
            String bhe = mVar.bhe();
            w.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[]{bhe});
            if (mVar.field_snsId == 0) {
                w.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                pXt.remove(bhe);
                e(bhe, 1, null, null);
                return;
            }
            if (pXt.containsKey(bhe)) {
                b bVar = (b) pXt.get(bhe);
                if (!bVar.hoD || bVar.hrm) {
                    pXt.remove(bhe);
                } else {
                    w.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[]{bhe});
                    e(bVar.id, 1, bVar.result, bVar.hwe);
                    return;
                }
            }
            if (mVar.bhd() != null) {
                String str = mVar.bhd().ufy;
                com.tencent.mm.sdk.b.b qpVar = new qp();
                qpVar.fXH.id = bhe;
                qpVar.fXH.fXI = str;
                qpVar.fXH.type = 2;
                com.tencent.mm.sdk.b.a.urY.m(qpVar);
                bG(mVar.bhe(), 1);
                a aVar = new a();
                aVar.id = bhe;
                aVar.pXw = str;
                aVar.type = 2;
                pXu.add(aVar);
            }
        }
    }

    public static void a(b bVar) {
        if ((bVar.gkv & 2) != 0) {
            bVar.pXy = false;
        } else if ((bVar.gkv & 4) != 0) {
            bVar.pXz = false;
        }
        pXt.put(bVar.id, bVar);
    }

    private static void b(b bVar) {
        if ((bVar.gkv & 2) != 0) {
            bVar.pXy = true;
        } else if ((bVar.gkv & 4) != 0) {
            bVar.pXz = true;
        }
        pXt.put(bVar.id, bVar);
    }

    public static void p(m mVar) {
        if (mVar != null) {
            String bhe = mVar.bhe();
            b(Fq(bhe));
            com.tencent.mm.sdk.b.b pmVar = new pm();
            pmVar.fWq.type = 1;
            pmVar.fWq.id = bhe;
            com.tencent.mm.sdk.b.a.urY.m(pmVar);
            w.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[]{bhe});
        }
    }

    public static void a(l lVar) {
        if (lVar != null && lVar.pUa != null) {
            long j;
            String str = lVar.opI;
            StringBuilder stringBuilder = new StringBuilder();
            if (lVar.pUa.ubK != 0) {
                j = (long) lVar.pUa.ubK;
            } else {
                j = lVar.pUa.ubN;
            }
            String dv = dv(lVar.qqG, stringBuilder.append(j).toString());
            if (pXt.containsKey(dv)) {
                b bVar = (b) pXt.get(dv);
                if (!bVar.hoD || bg.mA(bVar.result)) {
                    pXt.remove(dv);
                } else {
                    w.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[]{dv});
                    e(bVar.id, 2, bVar.result, bVar.hwe);
                    return;
                }
            }
            com.tencent.mm.sdk.b.b qpVar = new qp();
            qpVar.fXH.id = dv;
            qpVar.fXH.fXI = str;
            qpVar.fXH.type = 3;
            com.tencent.mm.sdk.b.a.urY.m(qpVar);
            bG(dv, 2);
            a aVar = new a();
            aVar.id = dv;
            aVar.pXw = str;
            aVar.type = 3;
            pXu.add(aVar);
            w.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[]{aVar.id});
        }
    }

    public static void b(l lVar) {
        if (lVar != null) {
            String dv = dv(lVar.qqG, (lVar.pUa.ubK != 0 ? (long) lVar.pUa.ubK : lVar.pUa.ubN));
            b(Fq(dv));
            com.tencent.mm.sdk.b.b pmVar = new pm();
            pmVar.fWq.type = 2;
            pmVar.fWq.id = dv;
            com.tencent.mm.sdk.b.a.urY.m(pmVar);
            w.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[]{dv});
        }
    }

    private static void bG(String str, int i) {
        if (!pXt.containsKey(str)) {
            b bVar = new b();
            bVar.id = str;
            bVar.hwe = null;
            bVar.result = null;
            bVar.hoD = false;
            bVar.hrm = false;
            bVar.pXz = true;
            bVar.pXy = true;
            pXt.put(str, bVar);
        }
        com.tencent.mm.sdk.b.b plVar = new pl();
        plVar.fWp.type = i;
        plVar.fWp.id = str;
        com.tencent.mm.sdk.b.a.urY.m(plVar);
    }

    public static void e(String str, int i, String str2, String str3) {
        if (pXt.containsKey(str)) {
            b bVar = (b) pXt.get(str);
            bVar.hwe = str3;
            bVar.result = str2;
            bVar.hoD = true;
            bVar.hrm = bg.mA(str2);
            pXt.put(str, bVar);
        }
        if (bg.mA(str2)) {
            Toast.makeText(ab.getContext(), j.pMO, 1).show();
        }
        com.tencent.mm.sdk.b.b pkVar = new pk();
        pkVar.fWn.type = i;
        pkVar.fWn.id = str;
        pkVar.fWn.result = str2;
        pkVar.fWn.fWo = str3;
        com.tencent.mm.sdk.b.a.urY.m(pkVar);
    }

    public static String dv(String str, String str2) {
        return str + ";" + str2;
    }

    public static HashMap<String, b> bfn() {
        return pXt;
    }

    public static void bH(String str, int i) {
        if (pXt.containsKey(str)) {
            b bVar = (b) pXt.get(str);
            bVar.gkv |= i;
            pXt.put(str, bVar);
        }
    }

    public static void bI(String str, int i) {
        if (pXt.containsKey(str)) {
            b bVar = (b) pXt.get(str);
            bVar.gkv &= i ^ -1;
            if (i != 2 && i == 4) {
                bVar.pXz = true;
            }
            pXt.put(str, bVar);
        }
    }

    public static boolean bJ(String str, int i) {
        if (!pXt.containsKey(str)) {
            return false;
        }
        if ((((b) pXt.get(str)).gkv & i) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(b bVar) {
        if (bVar == null || (bVar.gkv & 2) == 0) {
            return false;
        }
        return true;
    }

    public static b Fq(String str) {
        if (pXt.containsKey(str)) {
            return (b) pXt.get(str);
        }
        return null;
    }
}
