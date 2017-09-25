package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class n extends c<ms> {
    public n() {
        this.usg = ms.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        ms msVar = (ms) bVar;
        if (msVar == null) {
            w.e("MicroMsg.FaceStartManageListener", "hy: event is null");
            return false;
        }
        Context context = msVar.fUb.context;
        ms.b bVar2 = msVar.fUc;
        f fVar = f.lvS;
        w.i("MicroMsg.FaceDetectManager", "hy: start face manage process");
        if (context == null) {
            w.e("MicroMsg.FaceDetectManager", "hy: context is null. abort");
        } else if (fVar.dV(true)) {
            context.startActivity(new Intent(context, SettingsFacePrintManagerUI.class));
            z = true;
        } else {
            w.w("MicroMsg.FaceDetectManager", "hy: not support face detect. abort");
        }
        bVar2.fUa = z;
        return true;
    }
}
