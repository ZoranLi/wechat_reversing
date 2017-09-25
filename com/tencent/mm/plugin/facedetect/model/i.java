package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class i extends c<mr> {
    public i() {
        this.usg = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        if (mrVar == null) {
            return false;
        }
        boolean z;
        mr.b bVar2 = mrVar.fTY;
        f fVar = f.lvS;
        Context context = mrVar.fTX.context;
        Bundle bundle = mrVar.fTX.extras;
        int i = mrVar.fTX.fTZ;
        w.i("MicroMsg.FaceDetectManager", "start face detect process");
        FaceDetectReporter.arN().arO();
        FaceDetectReporter arN = FaceDetectReporter.arN();
        w.v("MicroMsg.FaceDetectReporter", "create interface called session");
        arN.lwF = System.currentTimeMillis();
        arN.lwI = 0;
        arN.lwJ = false;
        arN.lwG = -1;
        arN.lwH = -1;
        long j = arN.lwF;
        FaceDetectReporter.arN().lwG = System.currentTimeMillis();
        if (context == null) {
            z = false;
        } else if (bundle != null) {
            int i2 = bundle.getInt("k_server_scene", 2);
            FaceDetectReporter.arN().appId = bundle.getString("k_app_id", "");
            if (fVar.dV(bundle.getBoolean("is_check_dyncfg", false))) {
                Intent intent = (i2 == 2 || i2 == 5) ? new Intent(context, FaceDetectConfirmUI.class) : new Intent(context, FaceDetectPrepareUI.class);
                intent.putExtras(bundle);
                ((Activity) context).startActivityForResult(intent, i);
                z = true;
            } else {
                w.w("MicroMsg.FaceDetectManager", "alvinluo: not support face detect");
                FaceDetectReporter arN2 = FaceDetectReporter.arN();
                arN2.F(FaceDetectReporter.mj(i2), false);
                arN2.a(FaceDetectReporter.mj(i2), false, 3, 4, 90001);
                z = false;
            }
        } else {
            w.e("MicroMsg.FaceDetectManager", "hy: extras is null! should not happen");
            z = false;
        }
        bVar2.fUa = z;
        if (!mrVar.fTY.fUa) {
            mrVar.fTY.extras = new Bundle();
            mrVar.fTY.extras.putInt("err_code", 90001);
            mrVar.fTY.extras.putString("err_msg", "face detect not support");
        }
        return true;
    }
}
