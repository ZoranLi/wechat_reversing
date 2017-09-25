package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.storage.w.a;

public final class k {
    private static k nEB = new k();
    public SightParams nEC;

    public static k aLr() {
        return nEB;
    }

    public static d c(VideoTransPara videoTransPara) {
        switch (j.nCL.gRq) {
            case 1:
                return new l(videoTransPara);
            case 2:
                return new n(videoTransPara);
            default:
                return null;
        }
    }

    public static int aLs() {
        return j.nCL.hzY;
    }

    public static int aLt() {
        return j.nCL.nBn;
    }

    public static boolean aLu() {
        return ((Integer) CaptureMMProxy.getInstance().get(a.uEZ, Integer.valueOf(0))).intValue() == 1;
    }

    public static String aLv() {
        switch (j.nCL.gRq) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
