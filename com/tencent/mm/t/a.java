package com.tencent.mm.t;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public class a extends c {
    public boolean hhi;
    public String hhj;

    public final c wD() {
        c aVar = new a();
        aVar.hhi = this.hhi;
        aVar.hhj = this.hhj;
        return aVar;
    }

    public final void a(StringBuilder stringBuilder, com.tencent.mm.t.f.a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
        stringBuilder.append("<weappinfo>");
        if (!bg.mA(aVar.hjL)) {
            stringBuilder.append("<pagepath>" + com.tencent.mm.t.f.a.el(aVar.hjL) + "</pagepath>");
        }
        stringBuilder.append("<username>" + bg.PW(aVar.hjM) + "</username>");
        stringBuilder.append("<appid>" + bg.PW(aVar.hjN) + "</appid>");
        if (aVar.hjU != 0) {
            stringBuilder.append("<version>" + aVar.hjU + "</version>");
        }
        if (aVar.hjO != 0) {
            stringBuilder.append("<type>" + aVar.hjO + "</type>");
        }
        if (!bg.mA(aVar.hjV)) {
            stringBuilder.append("<weappiconurl>" + com.tencent.mm.t.f.a.el(aVar.hjV) + "</weappiconurl>");
        }
        if (!bg.mA(aVar.hjR)) {
            stringBuilder.append("<shareId>" + com.tencent.mm.t.f.a.el(aVar.hjR) + "</shareId>");
        }
        if (aVar.hjT == 1 || aVar.hjT == 2) {
            stringBuilder.append("<pkginfo>");
            stringBuilder.append("<type>");
            stringBuilder.append(aVar.hjT);
            stringBuilder.append("</type>");
            stringBuilder.append("<md5>");
            stringBuilder.append(aVar.hjP);
            stringBuilder.append("</md5>");
            stringBuilder.append("</pkginfo>");
        }
        if (!bg.mA(aVar.hjS)) {
            stringBuilder.append("<sharekey>" + com.tencent.mm.t.f.a.el(aVar.hjS) + "</sharekey>");
        }
        if (this.hhi) {
            stringBuilder.append("<wadynamicpageinfo>");
            stringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
            stringBuilder.append("<cacheKey>");
            stringBuilder.append(com.tencent.mm.t.f.a.el(this.hhj));
            stringBuilder.append("</cacheKey>");
            stringBuilder.append("</wadynamicpageinfo>");
        }
        stringBuilder.append("</weappinfo>");
    }

    public final void a(Map<String, String> map, com.tencent.mm.t.f.a aVar) {
        boolean z;
        if (bg.getInt((String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hhi = z;
        this.hhj = (String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey");
    }
}
