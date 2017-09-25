package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g {
    public FaceProNative lvW = null;

    public final FaceResult arK() {
        if (this.lvW == null) {
            w.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
            return null;
        }
        try {
            long NA = bg.NA();
            w.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[]{Integer.valueOf(this.lvW.engineReleaseOut().result), Long.valueOf(bg.NA() - NA)});
            this.lvW = null;
            return this.lvW.engineReleaseOut();
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.FaceDetectNativeManager", th, "hy: face lib release crash!!!", new Object[0]);
            this.lvW.engineRelease();
            this.lvW = null;
            return null;
        }
    }

    public final int arL() {
        String str = "MicroMsg.FaceDetectNativeManager";
        String str2 = "alvinluo cutDown sFaceProNative == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.lvW == null);
        w.v(str, str2, objArr);
        if (this.lvW == null) {
            w.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
            return -101;
        }
        w.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[]{Integer.valueOf(this.lvW.engineRelease())});
        this.lvW = null;
        return this.lvW.engineRelease();
    }
}
