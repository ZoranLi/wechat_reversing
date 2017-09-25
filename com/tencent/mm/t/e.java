package com.tencent.mm.t;

import android.util.Base64;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f.a;
import java.util.Map;

public final class e extends c {
    public final c wD() {
        return new e();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
        if (!bg.mA(aVar.appId)) {
            String replace;
            String str2 = aVar.fUY;
            bdi com_tencent_mm_protocal_c_bdi = new bdi();
            if (str2 != null) {
                try {
                    com_tencent_mm_protocal_c_bdi.aD(Base64.decode(str2, 0));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e, "", new Object[0]);
                }
            }
            com_tencent_mm_protocal_c_bdi.ueC = new bdg();
            com_tencent_mm_protocal_c_bdi.ueC.mpy = aVar.appId;
            try {
                str2 = Base64.encodeToString(com_tencent_mm_protocal_c_bdi.toByteArray(), 0);
                replace = str2.replace("\n", "");
            } catch (Throwable e2) {
                Throwable th = e2;
                replace = str2;
                w.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", th, "", new Object[0]);
            }
            aVar.fUY = replace;
        }
        stringBuilder.append("<statextstr>" + bg.PW(aVar.fUY) + "</statextstr>");
    }

    public final void a(Map<String, String> map, a aVar) {
    }
}
