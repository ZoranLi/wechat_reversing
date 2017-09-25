package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import java.util.LinkedList;
import java.util.List;

public final class a implements b, al, com.tencent.mm.x.d.a {
    Context context;
    m oYc;
    List<com.tencent.mm.pluginsdk.ui.b.b> wbb = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> wbc = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> wbd = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> wbe = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> wbf = new LinkedList();
    c wbg;
    c wbh;
    public ListView wbi;
    public View wbj;

    public final void bYs() {
        boolean z = true;
        if (this.context != null && ap.zb()) {
            w.i("MicroMsg.BannerHelper", "updateBanner, :%d", Integer.valueOf(hashCode()));
            boolean j = j(this.wbb, true);
            boolean j2 = j(this.wbc, true);
            boolean j3 = j(this.wbd, true);
            boolean j4 = j(this.wbe, true);
            if (!(j || j2 || j3 || j4)) {
                z = false;
            }
            if (j2) {
                cS(this.wbd);
                cS(this.wbe);
            } else if (j3) {
                cS(this.wbe);
            }
            if (z && this.wbi.getVisibility() != 0) {
                this.wbi.setVisibility(0);
                this.wbj.setVisibility(8);
            }
            for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.wbf) {
                if (bVar != null) {
                    bVar.Xj();
                }
            }
        }
    }

    public final void ho(String str) {
        if (ap.zb() && !ap.uP() && u.mz(str).length() > 0 && str.equals(com.tencent.mm.u.m.xL())) {
            bYs();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (ap.zb()) {
            ap.yY();
            if (mVar == com.tencent.mm.u.c.vr()) {
                int aC = u.aC(obj);
                if (8193 == aC) {
                    bYs();
                }
                if (42 == aC) {
                    bYs();
                }
            }
        }
    }

    public final void yP() {
        bYs();
    }

    final void cQ(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b view : list) {
            this.wbi.addHeaderView(view.getView());
        }
    }

    final void cR(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            if (bVar.getView() != null) {
                this.wbi.removeHeaderView(bVar.getView());
            }
        }
    }

    final boolean j(List<com.tencent.mm.pluginsdk.ui.b.b> list, boolean z) {
        boolean z2 = false;
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            boolean z3;
            View childAt = ((ViewGroup) bVar.getView()).getChildAt(0);
            if (bVar.Xj()) {
                String str = "MicroMsg.BannerHelper";
                String str2 = "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d";
                Object[] objArr = new Object[4];
                objArr[0] = bVar;
                objArr[1] = Boolean.valueOf(z);
                z3 = childAt != null && childAt.getVisibility() == 0;
                objArr[2] = Boolean.valueOf(z3);
                objArr[3] = Integer.valueOf(hashCode());
                w.i(str, str2, objArr);
                if (!z) {
                    return true;
                }
                z3 = true;
            } else {
                if (childAt != null && childAt.getVisibility() == 0) {
                    w.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", bVar, Boolean.valueOf(z), Integer.valueOf(hashCode()));
                }
                z3 = z2;
            }
            z2 = z3;
        }
        return z2;
    }

    private static void cS(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b visibility : list) {
            visibility.setVisibility(8);
        }
    }

    static void cT(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b release : list) {
            release.release();
        }
    }

    static void cU(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b destroy : list) {
            destroy.destroy();
        }
        list.clear();
    }
}
