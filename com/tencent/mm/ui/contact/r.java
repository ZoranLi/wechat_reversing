package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r extends q {
    private String fRM;
    private ae handler = new ae(Looper.getMainLooper());
    private Map<String, String> vYL = new HashMap();
    private List<String> vYM = new ArrayList();
    private a vYe;
    private List<String> vYx;

    public r(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, String str) {
        super(mMBaseSelectContactUI, list, z, 0);
        this.vYx = list;
        if (!bg.mA(str)) {
            this.vYM = bg.f(str.split(","));
            if (this.vYM != null) {
                for (String str2 : this.vYM) {
                    String eK = n.eK(str2);
                    if (!bg.mA(eK)) {
                        this.vYL.put(eK, str2);
                    }
                }
            }
        }
        Oe();
    }

    public final void a(a aVar) {
        this.vYe = aVar;
    }

    public final void aZ(String str, boolean z) {
        if (this.vYe != null) {
            this.vYe.r(str, getCount(), z);
        }
    }

    private void Oe() {
        this.fRM = null;
        clearCache();
    }

    public final int getCount() {
        return this.vYM == null ? 0 : this.vYM.size();
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        com.tencent.mm.ui.contact.a.a dVar = new d(i);
        dVar.fRM = this.fRM;
        ap.yY();
        dVar.jiL = c.wR().Ra((String) this.vYM.get(i));
        dVar.vYg = bcP();
        return dVar;
    }

    public final void finish() {
        super.finish();
        Oe();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
