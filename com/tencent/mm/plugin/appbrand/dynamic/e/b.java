package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.AppBrandX5BasedJsEngine;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ac;
import com.tencent.smtt.sdk.ae;

public final class b extends AppBrandX5BasedJsEngine {
    public b(Context context, Object obj, String str) {
        super(context, obj, str);
    }

    public final void pause() {
        ae aeVar = this.ixF;
        if (ae.wXd) {
            try {
                ac cfb = ac.cfb();
                if (cfb != null && cfb.cfc()) {
                    cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "pauseTimers", new Class[]{Object.class}, new Object[]{aeVar.wXh});
                }
            } catch (Exception e) {
            }
        }
    }

    public final void resume() {
        ae aeVar = this.ixF;
        if (ae.wXd) {
            try {
                ac cfb = ac.cfb();
                if (cfb != null && cfb.cfc()) {
                    cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "resumeTimers", new Class[]{Object.class}, new Object[]{aeVar.wXh});
                }
            } catch (Exception e) {
            }
        }
    }

    public final boolean Pp() {
        return ae.gH(ab.getContext()) && QbSdk.getTbsVersion(ab.getContext()) >= 43500;
    }
}
