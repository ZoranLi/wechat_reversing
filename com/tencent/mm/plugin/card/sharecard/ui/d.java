package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;

public final class d implements a {
    private c kiw;

    public final /* synthetic */ b kl(int i) {
        return this.kiw != null ? (ShareCardInfo) this.kiw.getItem(i) : null;
    }

    public d(c cVar) {
        this.kiw = cVar;
    }

    public final void onCreate() {
        if (this.kiw != null) {
            al.aga().c(this.kiw);
        }
    }

    public final void onDestroy() {
        if (this.kiw != null) {
            al.aga().f(this.kiw);
            c cVar = this.kiw;
            cVar.kiu.release();
            cVar.kiu = null;
            cVar.aEW();
            int i = (int) (cVar.endTime - cVar.beginTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(24);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(25);
            iDKey2.SetValue(i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.oUh.b(arrayList, true);
            this.kiw = null;
        }
    }

    public final void zm() {
        if (this.kiw != null) {
            this.kiw.a(null, null);
        }
    }
}
