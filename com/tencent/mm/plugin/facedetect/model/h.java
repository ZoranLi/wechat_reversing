package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Arrays;

public final class h {
    public static h lvZ;
    public int kZt = 0;
    public int[] lvX = null;
    public int lvY = -1;

    public static class a {
        public String iua;
        public long lwa;
        public long lwb;
        public boolean lwc;
        public long lwd;
        public String lwe;
        public boolean lwf;
        public boolean lwg;
        public int type;

        public a(int i, String str) {
            this.type = i;
            this.lwe = str;
            switch (this.type) {
                case 0:
                    this.lwa = 30;
                    this.lwb = 7000;
                    this.iua = ab.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.luo);
                    this.lwc = true;
                    this.lwd = 2500;
                    this.lwf = false;
                    this.lwg = false;
                    return;
                case 1:
                    this.lwa = 30;
                    this.lwb = 7000;
                    this.iua = ab.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.ltK);
                    this.lwc = false;
                    this.lwd = -1;
                    this.lwf = true;
                    this.lwg = true;
                    return;
                case 2:
                    this.lwa = 30;
                    this.lwb = 7000;
                    this.iua = ab.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.ltL);
                    this.lwc = false;
                    this.lwd = -1;
                    this.lwf = true;
                    this.lwg = true;
                    return;
                case 3:
                    this.lwa = 30;
                    this.lwb = 7000;
                    this.iua = ab.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.ltJ);
                    this.lwc = true;
                    this.lwd = -1;
                    this.lwf = true;
                    this.lwg = true;
                    return;
                case 4:
                    this.lwa = 30;
                    this.lwb = 7000;
                    this.iua = ab.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.ltM);
                    this.lwc = true;
                    this.lwd = 1000;
                    this.lwf = true;
                    this.lwg = true;
                    return;
                default:
                    w.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
                    this.type = 100;
                    return;
            }
        }

        public final String toString() {
            return "FaceProcessItem{type=" + this.type + ", frameTween=" + this.lwa + ", hintTween=" + this.lwb + ", hintStr='" + this.iua + '\'' + ", isCheckFace=" + this.lwc + ", minSuccTime=" + this.lwd + ", actionData='" + this.lwe + '\'' + '}';
        }
    }

    public static a arM() {
        String str;
        int arI = f.lvS.arI();
        g gVar = f.lvS.lvT.lxY;
        if (gVar.lvW == null) {
            w.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
            str = null;
        } else {
            str = gVar.lvW.engineGetCurrMotionData();
        }
        return new a(arI, str);
    }

    public final String toString() {
        return "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.lvX) + '}';
    }
}
