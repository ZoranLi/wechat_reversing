package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.w;

public interface b {

    public static class a {
        public String fPf;
        public int lxh;
        public int lxi;

        a(String str) {
            this.lxi = 7;
            this.fPf = str;
        }

        a() {
            this.lxh = 1;
        }
    }

    public static class b {
        public int errCode;
        public String fPf;

        public b(int i, String str) {
            this.errCode = i;
            this.fPf = str;
        }
    }

    public static class c {
        private static String TAG = "MicroMsg.IFaceMotion.Factory";

        public static b a(com.tencent.mm.plugin.facedetect.model.h.a aVar) {
            if (aVar == null) {
                return null;
            }
            if (aVar.type == 4) {
                w.i(TAG, "hy: is read number");
                return new d(aVar.lwe);
            }
            w.i(TAG, "hy: is normal");
            return new c(aVar.iua, aVar.lwb);
        }
    }

    void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2);

    boolean a(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean arX();

    boolean arY();

    void arZ();

    b asa();

    a asb();

    boolean b(FaceCharacteristicsResult faceCharacteristicsResult);
}
