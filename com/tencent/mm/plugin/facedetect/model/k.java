package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.w;

public final class k {
    public static int mk(int i) {
        if (i < 90000 && i != 0) {
            w.i("MicroMsg.FaceJSAPITranslateCenter", "hy: server error. not translate");
            return i;
        } else if (i > 90099) {
            w.i("MicroMsg.FaceJSAPITranslateCenter", "hy: already translated");
            return i;
        } else {
            switch (i) {
                case 0:
                    return 0;
                case 90001:
                    return 90109;
                case 90002:
                case 90003:
                case 90004:
                case 90005:
                case 90006:
                case 90024:
                case 90025:
                    return 90100;
                case 90008:
                case 90009:
                case 90010:
                    return 90101;
                case 90011:
                case 90013:
                    return 90102;
                case 90015:
                    return 90104;
                case 90016:
                    return 90106;
                case 90017:
                    return 90107;
                case 90019:
                case 90020:
                case 90021:
                    return 90103;
                case 90022:
                    return 90105;
                case 90023:
                    return 90108;
                default:
                    return 90199;
            }
        }
    }
}
