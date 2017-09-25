package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;

public class a {
    private static a gWA;

    private static class a implements i<IPCString, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object al(Object obj) {
            IPCString iPCString = (IPCString) obj;
            if (h.vJ().gYJ.gZf && h.vG().gXp) {
                c dX = com.tencent.mm.u.c.c.Az().dX(iPCString.value);
                Object bundle = new Bundle();
                bundle.putString("layerId", dX.field_layerId);
                bundle.putString("business", dX.field_business);
                bundle.putString("expId", dX.field_expId);
                bundle.putString("rawXML", dX.field_rawXML);
                bundle.putLong("startTime", dX.field_startTime);
                bundle.putLong("endTime", dX.field_endTime);
                bundle.putLong("sequence", dX.field_sequence);
                bundle.putInt("prioritylevel", dX.field_prioritylevel);
                bundle.putBoolean("needReport", dX.field_needReport);
                return bundle;
            }
            w.i("MicroMsg.IPCInvokeTask_GetABTestItem", "kernel or account not ready.");
            return null;
        }
    }

    public static a uw() {
        if (gWA == null) {
            synchronized (a.class) {
                if (gWA == null) {
                    gWA = new a();
                }
            }
        }
        return gWA;
    }

    public static c dX(String str) {
        if (str.length() == 0) {
            w.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[]{str});
            return null;
        } else if (ab.bJb()) {
            return com.tencent.mm.u.c.c.Az().dX(str);
        } else {
            Bundle bundle = (Bundle) e.a("com.tencent.mm", new IPCString(str), a.class);
            if (bundle == null) {
                return null;
            }
            c cVar = new c();
            cVar.field_layerId = bundle.getString("layerId");
            cVar.field_business = bundle.getString("business");
            cVar.field_expId = bundle.getString("expId");
            cVar.field_rawXML = bundle.getString("rawXML");
            cVar.field_startTime = bundle.getLong("startTime");
            cVar.field_endTime = bundle.getLong("endTime");
            cVar.field_sequence = bundle.getLong("sequence");
            cVar.field_prioritylevel = bundle.getInt("prioritylevel");
            cVar.field_needReport = bundle.getBoolean("needReport");
            return cVar;
        }
    }
}
