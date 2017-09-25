package com.tencent.mm.plugin.accountsync.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;

public final class b implements e, f {
    public Context context;
    public k fGg;
    private ae handler = new ae(Looper.getMainLooper());
    public p irJ;
    public a irK;

    public interface a {
        void OA();
    }

    public b(Context context, a aVar) {
        this.context = context;
        this.irK = aVar;
    }

    public final void a(int i, int i2, k kVar) {
        final int i3 = i2 != 0 ? (int) ((((long) i) * 100) / ((long) i2)) : 0;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ b irL;

            public final void run() {
                if (this.irL.irJ != null) {
                    this.irL.irJ.setMessage(this.irL.context.getString(R.l.dHA) + i3 + "%");
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == w.CTRL_INDEX) {
            ap.vd().b((int) w.CTRL_INDEX, (e) this);
        } else if (kVar.getType() == 138) {
            ap.vd().b(138, (e) this);
        }
        if (i2 == 0 && i == 0) {
            this.irK.OA();
        } else {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.DoInit", "do init failed, err=" + i + "," + i2);
            this.irK.OA();
        }
        if (this.irJ != null) {
            this.irJ.dismiss();
        }
    }
}
