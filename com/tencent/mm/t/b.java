package com.tencent.mm.t;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.t.f.a;
import java.util.Map;

public class b extends c {
    public String hhk;

    public final c wD() {
        return new b();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        if (aVar.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            this.hhk = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.locallogoicon"));
        }
    }
}
