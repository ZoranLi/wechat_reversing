package com.tencent.mm.plugin.welab.a;

import android.text.TextUtils;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.welab.a.a.a;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import java.util.HashMap;
import java.util.Map;

public final class b implements a {
    private Map<String, Integer> ssT = new HashMap();
    private String tag = "";

    public b() {
        bAJ();
    }

    private void bAJ() {
        this.tag = (String) h.vI().vr().get(w.a.uHC, null);
        com.tencent.mm.sdk.platformtools.w.i("LabAppLifeService", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (Object obj : this.tag.split("&")) {
                if (!TextUtils.isEmpty(obj)) {
                    String[] split = obj.split("=");
                    if (split != null && split.length == 2) {
                        this.ssT.put(split[0], Integer.valueOf(bg.PY(split[1])));
                    }
                }
            }
        }
    }

    public final boolean KY(String str) {
        if (com.tencent.mm.plugin.welab.b.bAG().KU(str).field_Switch == 2) {
            return true;
        }
        return false;
    }

    public final boolean KZ(String str) {
        return this.ssT.get(str) == null || ((Integer) this.ssT.get(str)).intValue() == 0;
    }

    public final void open(String str) {
        this.ssT.put(str, Integer.valueOf(1));
        this.tag += "&" + str + "=1";
        h.vI().vr().a(w.a.uHC, this.tag);
        com.tencent.mm.plugin.welab.c.a.a KU = com.tencent.mm.plugin.welab.b.bAG().KU(str);
        e.a aVar = new e.a();
        aVar.fTO = str;
        aVar.ssR = KU.field_expId;
        aVar.hTv = System.currentTimeMillis();
        aVar.action = 3;
        e.a(aVar);
    }

    public final boolean La(String str) {
        return com.tencent.mm.plugin.welab.b.bAG().KU(str).isRunning();
    }
}
