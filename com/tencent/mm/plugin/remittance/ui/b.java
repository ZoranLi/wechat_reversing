package com.tencent.mm.plugin.remittance.ui;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.mm.R;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class b extends o implements com.tencent.mm.sdk.e.m.b {
    private int fromScene;
    private Cursor ipM;
    int oRQ;
    int oRR;
    private List<String> oRS;
    private int oRT = 0;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, int i) {
        super(mMBaseSelectContactUI, list2, true, false);
        this.oRS = list;
        this.fromScene = i;
        w.i("MicroMsg.RecentConversationAdapter", "create!");
        aue();
        ap.yY();
        c.wW().a(this);
    }

    private void aue() {
        int i;
        Cursor b;
        w.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
        this.oRT = 0;
        List arrayList = new ArrayList();
        this.oRQ = -1;
        this.oRR = -1;
        if (this.oRS == null || this.oRS.size() <= 0) {
            i = 0;
        } else {
            ap.yY();
            Cursor cf = c.wR().cf(this.oRS);
            arrayList.add(cf);
            i = cf.getCount();
            if (i > 0) {
                this.oRQ = this.vYf.bcW().getHeaderViewsCount();
                this.oRT++;
            } else {
                this.oRQ = -1;
            }
        }
        List list = this.jBA;
        if (list != null) {
            list.addAll(this.oRS);
        } else {
            list = this.oRS;
        }
        if (this.fromScene == 1) {
            ap.yY();
            b = c.wW().b(com.tencent.mm.u.o.hlr, list, this.vYw, "");
        } else {
            ap.yY();
            b = c.wW().b(com.tencent.mm.u.o.hlv, list, this.vYw, "");
        }
        if (b.getCount() > 0) {
            this.oRT++;
            if (i > 0) {
                this.oRR = (i + this.oRQ) + 1;
            } else {
                this.oRR = this.vYf.bcW().getHeaderViewsCount();
            }
        } else {
            this.oRR = -1;
        }
        arrayList.add(b);
        this.ipM = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
    }

    protected final a hg(int i) {
        a gVar;
        if (i == this.oRR || i == this.oRQ) {
            gVar = new g(i);
            if (i == this.oRQ) {
                if (this.fromScene == 1) {
                    gVar.mdo = this.vYf.getActivity().getResources().getString(R.l.dBu);
                    return gVar;
                }
                gVar.mdo = this.vYf.getActivity().getResources().getString(R.l.eLq);
                return gVar;
            } else if (i != this.oRR) {
                return gVar;
            } else {
                gVar.mdo = this.vYf.getActivity().getResources().getString(R.l.eQt);
                return gVar;
            }
        }
        int i2;
        if (this.oRT == 2) {
            if (i > this.oRR) {
                i2 = i - 2;
            } else {
                i2 = i - 1;
            }
        } else if (this.oRT == 1) {
            i2 = i - 1;
        } else {
            w.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[]{Integer.valueOf(i)});
            i2 = i;
        }
        if (!this.ipM.moveToPosition(i2)) {
            return null;
        }
        gVar = new e(i);
        aj aeVar = new ae();
        aeVar.b(this.ipM);
        ap.yY();
        gVar.jiL = c.wR().QX(aeVar.field_username);
        if (gVar.jiL != null) {
            return gVar;
        }
        ap.yY();
        gVar.jiL = c.wR().Rb(aeVar.field_username);
        return gVar;
    }

    public final int getCount() {
        return this.ipM.getCount() + this.oRT;
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
