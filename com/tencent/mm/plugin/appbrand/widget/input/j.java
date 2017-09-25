package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.m.b;
import com.tencent.mm.plugin.appbrand.g.m.c;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class j implements b, c {
    final WeakReference<m> jsp;

    j(m mVar) {
        this.jsp = new WeakReference(mVar);
        mVar.a((b) this);
        mVar.a((c) this);
    }

    public final void SY() {
        m mVar = (m) this.jsp.get();
        if (mVar != null) {
            m.i(mVar);
        }
    }

    public final void onDestroy() {
        m mVar = (m) this.jsp.get();
        if (mVar != null) {
            if (mVar.mContext instanceof MMActivity) {
                ((MMActivity) mVar.mContext).aHf();
            }
            m.i(mVar);
            m.k(mVar);
            mVar.b((b) this);
            mVar.b((c) this);
            if (mVar.jde != null) {
                f.Yv().m(mVar.jde);
            }
        }
    }
}
