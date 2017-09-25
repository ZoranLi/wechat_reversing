package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI extends SnsTagDetailUI implements b, e {
    public final void bjM() {
        w.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
        h.vJ();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(this);
    }

    protected final void bjN() {
        w.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
        h.vJ();
        if (h.vG().uV()) {
            h.vJ();
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    }

    public void onDestroy() {
        if (this.irJ != null) {
            this.irJ.dismiss();
        }
        h.vJ();
        h.vH().gXC.b(290, this);
        h.vJ();
        h.vH().gXC.b(291, this);
        h.vJ();
        h.vH().gXC.b(292, this);
        h.vJ();
        h.vH().gXC.b(293, this);
        h.vJ();
        if (h.vG().uV()) {
            h.vJ();
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(this);
        }
        super.onDestroy();
    }

    protected final void bjO() {
    }

    protected final void aHd() {
        if ((this.qGV + " " + bg.c(this.qGU, ",")).equals(this.fFW) && this.pUF != 0) {
            finish();
        } else if (ae.beQ().o(this.pUF, this.qGV)) {
            g.b(this, getString(j.pMt, new Object[]{this.qGV}), getString(j.dIO), true);
        } else {
            List<String> bjP = bjP();
            List<String> linkedList = new LinkedList();
            List<String> linkedList2 = new LinkedList();
            for (String str : bjP) {
                if (!this.qGU.contains(str)) {
                    linkedList.add(str);
                }
            }
            for (String str2 : this.qGU) {
                if (!bjP.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            for (String str22 : linkedList) {
                o.k(str22, false);
            }
            for (String str222 : linkedList2) {
                o.k(str222, true);
            }
            a.imw.ou();
            finish();
        }
    }

    protected final List<String> bjP() {
        List<String> linkedList = new LinkedList();
        if (this.pUF != 4) {
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        return o.yA();
    }

    protected final void tq(String str) {
        super.tq(str);
    }

    protected final void bB(List<String> list) {
        ar bez = ae.bez();
        String xL = m.xL();
        for (String str : list) {
            if (!(this.qGU.contains(str) || !com.tencent.mm.j.a.ez(bez.Rc(str).field_type) || xL.equals(str))) {
                this.qGU.add(str);
            }
        }
        if (this.ktf != null) {
            this.ktf.aN(this.qGU);
        }
        ajj();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.irJ != null) {
            this.irJ.dismiss();
        }
    }
}
