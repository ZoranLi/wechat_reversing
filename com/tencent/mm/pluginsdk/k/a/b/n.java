package com.tencent.mm.pluginsdk.k.a.b;

import android.util.SparseArray;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.k.a.a.a;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.avo;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class n extends k implements j {
    protected static final SparseArray<a> sGj = new SparseArray();
    private volatile e gUD;
    protected final List<avo> sGi = new LinkedList();

    protected abstract p bDA();

    protected abstract String getTag();

    protected abstract kx h(p pVar);

    public static void a(a aVar) {
        sGj.put(39, aVar);
    }

    public n() {
        for (int i : i.sFM) {
            a aVar = (a) sGj.get(i);
            if (aVar == null || !aVar.jI(i)) {
                avo com_tencent_mm_protocal_c_avo = new avo();
                com_tencent_mm_protocal_c_avo.jOc = i;
                this.sGi.add(com_tencent_mm_protocal_c_avo);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.d(getTag(), "before dispatch");
        return a(eVar, bDA(), this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (h.vG().uV()) {
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, Long.valueOf(bg.Ny() + 86400));
        }
        if (i2 == 0 && i3 == 0) {
            kx h = h(pVar);
            String tag = getTag();
            String str2 = "response.Res.size() = %s";
            Object[] objArr = new Object[1];
            objArr[0] = bg.bV(h.trm) ? "null" : String.valueOf(h.trm.size());
            w.i(tag, str2, objArr);
            if (!bg.bV(h.trm)) {
                final List list = h.trm;
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ n sGl;

                    public final void run() {
                        for (avn com_tencent_mm_protocal_c_avn : list) {
                            String tag = this.sGl.getTag();
                            String str = "resType(%d) responses.size() = %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_avn.jOc);
                            objArr[1] = bg.bV(com_tencent_mm_protocal_c_avn.tZc) ? "null" : String.valueOf(com_tencent_mm_protocal_c_avn.tZc.size());
                            w.i(tag, str, objArr);
                            if (!bg.bV(com_tencent_mm_protocal_c_avn.tZc)) {
                                Iterator it = com_tencent_mm_protocal_c_avn.tZc.iterator();
                                while (it.hasNext()) {
                                    this.sGl.a(com_tencent_mm_protocal_c_avn.jOc, (avi) it.next());
                                }
                            }
                        }
                    }
                }, "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final void a(int i, avi com_tencent_mm_protocal_c_avi) {
        w.i(getTag(), "resType = %d, subType = %d, res.Oper = %d", Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_avi.tVQ), Integer.valueOf(com_tencent_mm_protocal_c_avi.tEV));
        if (com_tencent_mm_protocal_c_avi.tYO != null) {
            w.i(getTag(), "resource.Info.FileFlag %d ", Integer.valueOf(com_tencent_mm_protocal_c_avi.tYO.tYZ));
        }
        if (b.xf(com_tencent_mm_protocal_c_avi.tEV)) {
            w.i(getTag(), "just do nothing");
            return;
        }
        if (b.xg(com_tencent_mm_protocal_c_avi.tEV)) {
            w.i(getTag(), "do cache");
            c.sFE.b(i, com_tencent_mm_protocal_c_avi, false);
        }
        if (b.xh(com_tencent_mm_protocal_c_avi.tEV)) {
            w.i(getTag(), "do decrypt");
            c.sFE.c(i, com_tencent_mm_protocal_c_avi, false);
        }
        if (b.xi(com_tencent_mm_protocal_c_avi.tEV)) {
            w.i(getTag(), "do delete");
            c.sFE.a(i, com_tencent_mm_protocal_c_avi, false);
        }
    }
}
