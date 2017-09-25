package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends e {
    private static final int CTRL_INDEX = 110;
    private static final String NAME = "insertTextArea";

    private static final class a extends e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onKeyboardShow";
    }

    private static final class b extends e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTextAreaHeightChange";
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
    }

    protected final boolean TG() {
        return false;
    }

    protected final boolean TH() {
        return false;
    }

    protected final boolean a(com.tencent.mm.plugin.appbrand.widget.input.a.e eVar, JSONObject jSONObject, m mVar, int i) {
        if (!super.a(eVar, jSONObject, mVar, i)) {
            return false;
        }
        eVar.jxr = Boolean.valueOf(true);
        eVar.jwS = "emoji";
        eVar.jwT = false;
        eVar.jwU = false;
        eVar.jxx = Boolean.valueOf(false);
        eVar.jxs = Boolean.valueOf(true);
        return true;
    }

    protected final void a(final g gVar) {
        super.a(gVar);
        gVar.jsK = new com.tencent.mm.plugin.appbrand.widget.input.g.c(this) {
            final /* synthetic */ c iSz;

            public final void bo(int i, int i2) {
                String str = gVar.jsR;
                if (!bg.mA(str)) {
                    m pr = a.pr(str);
                    if (pr != null && pr.aaI) {
                        b bVar = new b();
                        Map hashMap = new HashMap();
                        hashMap.put("height", Integer.valueOf(h.iC(i2)));
                        hashMap.put("lineCount", Integer.valueOf(i));
                        hashMap.put("inputId", str);
                        bVar.ad(pr.ivH, 0).q(hashMap).g(new int[]{pr.hashCode()});
                    }
                }
            }
        };
        gVar.jsL = new com.tencent.mm.plugin.appbrand.widget.input.g.a(this) {
            final /* synthetic */ c iSz;

            public final void bM(boolean z) {
                if (z) {
                    String str = gVar.jsR;
                    if (!bg.mA(str)) {
                        m pr = a.pr(str);
                        if (pr != null && pr.aaI) {
                            a aVar = new a();
                            Map hashMap = new HashMap();
                            hashMap.put("inputId", gVar.jsR);
                            aVar.ad(pr.ivH, 0).q(hashMap).g(new int[]{pr.hashCode()});
                        }
                    }
                }
            }
        };
    }

    protected final boolean TI() {
        return false;
    }
}
