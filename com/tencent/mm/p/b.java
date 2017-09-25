package com.tencent.mm.p;

import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class b implements e {
    private List<d> gUp = null;
    private List<d> gUq = null;
    private d gUr = null;
    private a gUs;

    public interface a {
        void q(List<d> list);
    }

    public b(List<d> list, a aVar) {
        this.gUp = list;
        this.gUq = new ArrayList();
        this.gUs = aVar;
    }

    public final boolean start() {
        if (this.gUp == null || this.gUp.size() <= 0) {
            return false;
        }
        w.i("MicroMsg.FunctionMsgFetchLooper", "start, fetchItemList.size: %s", Integer.valueOf(this.gUp.size()));
        h.vd().a(825, (e) this);
        tV();
        return true;
    }

    private void tV() {
        w.d("MicroMsg.FunctionMsgFetchLooper", "fetchNext, fetchItemList.size: %s", Integer.valueOf(this.gUp.size()));
        if (this.gUp.size() > 0) {
            this.gUr = (d) this.gUp.remove(0);
            d dVar = this.gUr;
            if (dVar != null) {
                w.i("MicroMsg.FunctionMsgFetchLooper", "fetchInternal, functionMsgId: %s", dVar.field_functionmsgid);
                dVar.field_status = 0;
                h.vd().a(new g(dVar), 0);
                return;
            }
            return;
        }
        h.vd().b(825, (e) this);
        if (this.gUs != null) {
            this.gUs.q(this.gUq);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.FunctionMsgFetchLooper", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() == 825) {
            g gVar = (g) kVar;
            yi yiVar = gVar.gUC;
            d dVar = gVar.gUE;
            if (dVar != null && dVar.field_functionmsgid.equals(this.gUr.field_functionmsgid)) {
                if (i == 0 || i2 == 0) {
                    w.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s", dVar.field_functionmsgid, Long.valueOf(yiVar.tEM), Long.valueOf(dVar.field_version));
                    if (yiVar.tEM >= dVar.field_version) {
                        dVar.field_preVersion = dVar.field_version;
                        dVar.field_version = yiVar.tEM;
                        dVar.field_status = 2;
                        dVar.b(yiVar.tEN);
                        i.uf().a(dVar.field_functionmsgid, dVar);
                        this.gUq.add(dVar);
                    }
                } else {
                    w.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s", dVar.field_functionmsgid, Long.valueOf(dVar.field_preVersion), Long.valueOf(dVar.field_version));
                    dVar.field_status = 3;
                    dVar.field_version = dVar.field_preVersion;
                    i.uf().a(dVar.field_functionmsgid, dVar);
                }
                tV();
            }
        }
    }
}
