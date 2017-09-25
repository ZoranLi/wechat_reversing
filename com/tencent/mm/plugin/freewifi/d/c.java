package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public abstract class c extends k implements j {
    protected Activity activity;
    protected b gUA;
    protected e gUD;
    protected e lTU;

    protected abstract void awJ();

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        m.wD("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i2 + "," + i3 + "]");
        if (this.lTU != null) {
            this.lTU.a(i2, i3, str, this);
        }
        if ((this.activity == null || !this.activity.isFinishing()) && this.gUD != null) {
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final p pVar2 = pVar;
            final byte[] bArr2 = bArr;
            af.v(new Runnable(this) {
                final /* synthetic */ c lTV;

                public final void run() {
                    this.lTV.b(i4, i5, i6, str2);
                    if (this.lTV.gUD != null) {
                        this.lTV.gUD.a(i5, i6, str2, this.lTV);
                    }
                }
            });
        }
    }

    protected void b(int i, int i2, int i3, String str) {
    }

    public final void b(e eVar) {
        this.gUD = eVar;
        m.wD("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        ap.vd().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.lTU = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final c C(Activity activity) {
        this.activity = activity;
        return this;
    }
}
