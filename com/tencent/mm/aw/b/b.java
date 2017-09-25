package com.tencent.mm.aw.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.Set;

public final class b implements e {

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Set idO;
        final /* synthetic */ String idP;
        final /* synthetic */ String idQ;
        final /* synthetic */ b idR;

        public AnonymousClass1(b bVar, Set set, String str, String str2) {
            this.idR = bVar;
            this.idO = set;
            this.idP = str;
            this.idQ = str2;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            for (String OV : this.idO) {
                linkedList.add(new avx().OV(OV));
                w.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", OV);
            }
            avx OV2 = new avx().OV(this.idP);
            avx OV3 = new avx().OV(this.idQ);
            h.vd().a((int) JsApiOpenWeRunSetting.CTRL_INDEX, this.idR);
            h.vd().a(new a(linkedList.size(), linkedList, OV2, OV3), 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        h.vd().b((int) JsApiOpenWeRunSetting.CTRL_INDEX, (e) this);
        if (kVar instanceof a) {
            w.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
    }
}
