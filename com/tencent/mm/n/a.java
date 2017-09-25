package com.tencent.mm.n;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.y;

public final class a {
    private static y fxg;

    public static boolean aH(Context context) {
        if (!tQ()) {
            return false;
        }
        w.i("MicroMsg.DeviceOccupy", "isMultiTalking");
        Toast.makeText(context, g.kER, 0).show();
        return true;
    }

    public static boolean tQ() {
        b jaVar = new ja();
        jaVar.fOT.action = 1;
        com.tencent.mm.sdk.b.a.urY.m(jaVar);
        return jaVar.fOU.fOV;
    }

    public static boolean aI(Context context) {
        b rqVar = new rq();
        com.tencent.mm.sdk.b.a.urY.m(rqVar);
        if (rqVar.fYE.fYG) {
            w.i("MicroMsg.DeviceOccupy", "isCameraUsing");
            Toast.makeText(context, d(context, rqVar.fYE.fYF), 0).show();
        }
        return rqVar.fYE.fYG;
    }

    public static boolean aJ(Context context) {
        b rqVar = new rq();
        com.tencent.mm.sdk.b.a.urY.m(rqVar);
        if (rqVar.fYE.fYH) {
            w.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            Toast.makeText(context, d(context, rqVar.fYE.fYF), 0).show();
        }
        return rqVar.fYE.fYH;
    }

    private static String d(Context context, boolean z) {
        if (z) {
            return context.getString(g.kEd);
        }
        return context.getString(g.kEe);
    }

    public static y oH() {
        if (fxg == null) {
            fxg = com.tencent.mm.booter.a.pQ();
        }
        return fxg;
    }
}
