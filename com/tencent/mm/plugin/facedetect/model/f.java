package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public enum f {
    ;
    
    private static af lvU;
    public FaceDetectProcessService lvT;

    private f(String str) {
        this.lvT = null;
    }

    static {
        lvU = new af("face_process");
    }

    public static void t(Runnable runnable) {
        lvU.D(runnable);
    }

    public static void arD() {
        lvU.bJl().removeCallbacksAndMessages(null);
    }

    public static ae arE() {
        return lvU.bJl();
    }

    public final boolean dV(boolean z) {
        w.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[]{Boolean.valueOf(z)});
        boolean arF = arF();
        boolean arR = o.arR();
        if (z) {
            w.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", new Object[]{Boolean.valueOf(bg.getInt(((a) h.h(a.class)).sV().getValue("BioSigFaceEntry"), 0) == 1), Boolean.valueOf(arF), Boolean.valueOf(arR)});
            if (!(bg.getInt(((a) h.h(a.class)).sV().getValue("BioSigFaceEntry"), 0) == 1) || (arF & arR) == 0) {
                return false;
            }
            return true;
        }
        w.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", new Object[]{Boolean.valueOf(arF), Boolean.valueOf(arR)});
        if (arR && arF) {
            return true;
        }
        return false;
    }

    public static boolean arF() {
        return ab.getContext().getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    public static boolean arG() {
        return o.arR();
    }

    public final int arH() {
        g gVar = this.lvT.lxY;
        if (gVar.lvW != null) {
            return gVar.lvW.engineReleaseCurrMotion();
        }
        w.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        return -3;
    }

    public final int arI() {
        g gVar = this.lvT.lxY;
        if (gVar.lvW != null) {
            return gVar.lvW.engineGetCurrMotion();
        }
        w.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
        return -1;
    }

    public static int arJ() {
        return FaceProNative.engineVersion();
    }
}
