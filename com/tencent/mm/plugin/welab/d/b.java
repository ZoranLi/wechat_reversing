package com.tencent.mm.plugin.welab.d;

import android.text.TextUtils;
import com.tencent.mm.kernel.h;
import com.tencent.mm.q.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b stv = new b();
    public Map<String, Integer> ssT = new HashMap();
    public String tag = "";

    public static b bAV() {
        return stv;
    }

    private b() {
        bAJ();
    }

    private void bAJ() {
        this.tag = (String) h.vI().vr().get(a.uHB, null);
        w.i("WeLabRedPointMgr", "load red tag " + this.tag);
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

    public final boolean e(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (aVar.field_RedPoint != 1) {
            return false;
        }
        boolean z = aVar.bAQ() || aVar.field_Switch == 3;
        if (z || Ld(aVar.field_LabsAppId)) {
            return false;
        }
        return true;
    }

    private boolean Ld(String str) {
        return this.ssT.containsKey(str) && ((Integer) this.ssT.get(str)).intValue() == 1;
    }

    public final void f(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (aVar.field_RedPoint == 1 && !Ld(aVar.field_LabsAppId) && aVar.bAR()) {
            c.uk().t(266267, true);
        }
    }

    public static void bAW() {
        List<com.tencent.mm.plugin.welab.c.a.a> bAH = com.tencent.mm.plugin.welab.b.bAG().bAH();
        if (bAH == null || bAH.isEmpty()) {
        } else {
        }
        for (com.tencent.mm.plugin.welab.c.a.a aVar : bAH) {
            if (aVar != null && stv.e(aVar)) {
                Object obj = null;
                break;
            }
        }
        int i = 1;
        if (obj != null) {
            c.uk().aE(266267, 266241);
        }
    }

    public static boolean bAX() {
        return c.uk().aD(266267, 266241);
    }

    public static boolean bAY() {
        return ab.bIY().getBoolean("key_has_enter_welab", false);
    }
}
