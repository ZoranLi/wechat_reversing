package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.w;

public abstract class b {
    public a jyg;

    public abstract View TT();

    public final <T extends i> T q(Class<T> cls) {
        g cB = cB(true);
        this.jyg = cB;
        if (cB == null) {
            return null;
        }
        if (!cls.isInstance(cB.jyE)) {
            try {
                i iVar = (i) cls.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{cB.getContext()});
                if (cB.jyE == null || iVar == null || iVar.getClass() != cB.jyE.getClass()) {
                    if (cB.jyE != null) {
                        cB.jyE.ZE();
                    }
                    cB.jyE = iVar;
                    if (cB.jyE != null) {
                        cB.jyE.b(cB);
                    }
                    if (!(cB.jyF == null || cB.jyE == null || cB.jyE.getView() == null)) {
                        cB.jyF.removeAllViews();
                        cB.ZI();
                        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 17;
                        cB.jyF.addView(cB.jyE.getView(), layoutParams);
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", new Object[]{cls.getSimpleName(), e});
                return null;
            }
        }
        return cB.jyE;
    }

    public final a cB(boolean z) {
        if (this.jyg != null) {
            return this.jyg;
        }
        if (TT() == null) {
            return null;
        }
        View bN = l.bN(TT());
        if (bN == null) {
            return null;
        }
        a bZ = a.bZ(bN);
        if (bZ != null || !z) {
            return bZ;
        }
        bZ = new a(TT().getContext());
        bN.h(bZ, true);
        return bZ;
    }
}
