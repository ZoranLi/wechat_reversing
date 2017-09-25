package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.plugin.welab.c.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b ssM = new b();
    public a ssN;
    public Map<String, com.tencent.mm.plugin.welab.a.a.b> ssO = new HashMap();
    public com.tencent.mm.plugin.welab.a.a.b ssP;
    public c ssQ;

    public b() {
        c.a aVar = new c.a();
        aVar.hIL = true;
        aVar.hIK = true;
        this.ssQ = aVar.Hg();
    }

    public static b bAG() {
        return ssM;
    }

    public static String a(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b KT = ssM.KT(aVar.field_LabsAppId);
        if (KT != null) {
            str = aVar.field_LabsAppId;
            str = KT.bAO();
            w.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[]{aVar.field_LabsAppId, str});
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.Lb("field_Title");
        }
        return str;
    }

    public static String b(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b KT = ssM.KT(aVar.field_LabsAppId);
        if (KT != null) {
            str = aVar.field_LabsAppId;
            str = KT.bAN();
            w.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[]{aVar.field_LabsAppId, str});
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.field_Icon;
        }
        return str;
    }

    private com.tencent.mm.plugin.welab.a.a.b KT(String str) {
        return (com.tencent.mm.plugin.welab.a.a.b) this.ssO.get(str);
    }

    public static void D(boolean z, boolean z2) {
        f.E(z, z2);
    }

    public final List<com.tencent.mm.plugin.welab.c.a.a> bAH() {
        List<com.tencent.mm.plugin.welab.c.a.a> bAP = this.ssN.bAP();
        Iterator it = bAP.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.welab.c.a.a aVar = (com.tencent.mm.plugin.welab.c.a.a) it.next();
            if (!(aVar.isRunning() && (aVar.field_Switch == 2 || aVar.field_Switch == 1))) {
                it.remove();
            }
        }
        return bAP;
    }

    public final com.tencent.mm.plugin.welab.c.a.a KU(String str) {
        a aVar = this.ssN;
        com.tencent.mm.sdk.e.c aVar2 = new com.tencent.mm.plugin.welab.c.a.a();
        aVar2.field_LabsAppId = str;
        aVar.b(aVar2, new String[0]);
        return aVar2;
    }
}
