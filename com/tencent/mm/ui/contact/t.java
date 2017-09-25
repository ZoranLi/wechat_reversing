package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.g;
import java.util.List;

public final class t extends o implements b {
    private Cursor ipM;
    private int oRR;
    private List<String> vZh;
    private int vZi;
    private boolean vZj;
    private int vZk;

    public t(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list) {
        this(mMBaseSelectContactUI, list, true, false, false, 0);
    }

    public t(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, boolean z3, int i) {
        super(mMBaseSelectContactUI, list, z, z2);
        this.vZk = 0;
        w.i("MicroMsg.RecentConversationAdapter", "create!");
        this.vZj = z3;
        this.vZk = i;
        aue();
        ap.yY();
        c.wW().a(this);
    }

    private void aue() {
        int i;
        int i2 = 0;
        w.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
        if (s.ee(this.vZk, 4)) {
            ap.yY();
            this.ipM = c.wW().b(o.hlv, this.jBA, this.vYw, "");
        } else if (s.ee(this.vZk, 16)) {
            ap.yY();
            this.ipM = c.wW().b(o.hlx, this.jBA, this.vYw, "");
        } else {
            ap.yY();
            this.ipM = c.wW().b(o.hlr, this.jBA, this.vYw, "");
        }
        if (this.vZj) {
            i = 2;
        } else {
            i = 0;
        }
        if (this.vZh != null) {
            i2 = this.vZh.size();
        }
        this.vZi = i2;
        this.oRR = i + this.vZi;
        clearCache();
    }

    public final int getCount() {
        return (this.ipM.getCount() + this.oRR) + 1;
    }

    protected final a hg(int i) {
        a gVar;
        a gVar2;
        if (this.oRR > this.vZi) {
            if (i == this.vZi) {
                gVar = new g(i);
                gVar.mdo = this.vYf.getActivity().getResources().getString(R.l.dCJ);
            } else if (i == this.vZi + 1) {
                gVar = new com.tencent.mm.ui.contact.a.b(i);
                String string = this.vYf.getActivity().getResources().getString(R.l.dCJ);
                gVar.rqp = R.k.dwv;
                gVar.aIO = string;
            }
            if (i == this.oRR) {
                gVar2 = new g(i);
                gVar2.mdo = this.vYf.getActivity().getResources().getString(R.l.eQt);
                return gVar2;
            } else if (i < this.vZi) {
                if (this.vZh != null || i < 0 || i >= this.vZh.size()) {
                    return null;
                }
                gVar2 = new com.tencent.mm.ui.contact.a.b(i);
                gVar2.username = (String) this.vZh.get(i);
                return gVar2;
            } else if (i > this.oRR || !this.ipM.moveToPosition((i - this.oRR) - 1)) {
                w.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
                return gVar;
            } else {
                gVar2 = new e(i);
                aj aeVar = new ae();
                aeVar.b(this.ipM);
                ap.yY();
                gVar2.jiL = c.wR().QX(aeVar.field_username);
                if (gVar2.jiL == null) {
                    ap.yY();
                    gVar2.jiL = c.wR().Rb(aeVar.field_username);
                }
                gVar2.vYg = bcP();
                return gVar2;
            }
        }
        gVar = null;
        if (i == this.oRR) {
            gVar2 = new g(i);
            gVar2.mdo = this.vYf.getActivity().getResources().getString(R.l.eQt);
            return gVar2;
        } else if (i < this.vZi) {
            return this.vZh != null ? null : null;
        } else {
            if (i > this.oRR) {
            }
            w.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return gVar;
        }
    }

    public final void finish() {
        super.finish();
        w.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
        ap.yY();
        c.wW().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aue();
        notifyDataSetChanged();
    }
}
