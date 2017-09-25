package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.m.o;

public final class q extends h {
    private m iYE;
    private String mUrl;

    public q(Context context, j jVar) {
        super(context, jVar);
    }

    protected final View Vw() {
        if (this.iYE == null) {
            this.iYE = this.iwr.VO();
        }
        return this.iYE.jbY;
    }

    public final void loadUrl(String str) {
        if (this.mUrl == null) {
            this.mUrl = str;
            this.iYE.qo(str);
            VH();
        }
    }

    public final boolean qh(String str) {
        return o.qW(this.mUrl).equals(o.qW(str));
    }

    protected final void VB() {
        super.VB();
        this.iYE.onDestroy();
    }

    public final void Po() {
        super.Po();
        this.iYE.Po();
    }

    public final void Vz() {
        super.Vz();
        this.iYE.UA();
    }

    public final void VA() {
        super.VA();
        this.iYE.SY();
    }

    public final void b(String str, String str2, int[] iArr) {
        if (h.c(iArr, this.iYE.hashCode())) {
            this.iYE.f(str, str2, 0);
        }
    }

    public final m VC() {
        return this.iYE;
    }

    public final String VD() {
        return this.mUrl;
    }
}
