package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends OrientationEventListener {
    private a rYY = a.NONE;
    private int rYZ = 45;
    private b rZa;

    public enum a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE
    }

    public interface b {
        void a(a aVar, a aVar2);
    }

    public e(Context context, b bVar) {
        super(context);
        this.rZa = bVar;
    }

    public final void enable() {
        super.enable();
    }

    public final void disable() {
        super.disable();
        this.rYY = a.NONE;
    }

    public final void onOrientationChanged(int i) {
        if (i != -1) {
            a aVar = this.rYY;
            if ((i >= 360 - this.rYZ && i < 360) || (i >= 0 && i <= this.rYZ + 0)) {
                aVar = a.PORTRAIT;
            } else if (i >= 270 - this.rYZ && i <= this.rYZ + 270) {
                aVar = a.LANDSCAPE;
            } else if (i >= 180 - this.rYZ && i <= this.rYZ + 180) {
                aVar = a.REVERSE_PORTRAIT;
            } else if (i >= 90 - this.rYZ && i <= this.rYZ + 90) {
                aVar = a.REVERSE_LANDSCAPE;
            }
            if (aVar != this.rYY) {
                if (!(this.rZa == null || this.rYY == a.NONE)) {
                    this.rZa.a(this.rYY, aVar);
                }
                this.rYY = aVar;
            }
            w.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:" + i);
        }
    }
}
