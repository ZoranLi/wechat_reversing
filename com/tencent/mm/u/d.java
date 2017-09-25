package com.tencent.mm.u;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    private com.tencent.mm.compatible.util.b fAP;
    private com.tencent.mm.compatible.util.b.a hkW;
    public a hkX;
    private boolean hkY = false;
    private Context ty = ab.getContext();

    public interface a {
    }

    private class b implements com.tencent.mm.compatible.util.b.a {
        final /* synthetic */ d hkZ;

        public b(d dVar) {
            this.hkZ = dVar;
        }

        public final void cX(int i) {
            switch (i) {
                case -3:
                    w.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    if (this.hkZ.hkX == null) {
                        return;
                    }
                    return;
                case -2:
                    w.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                    if (this.hkZ.hkX == null) {
                        return;
                    }
                    return;
                case -1:
                    w.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                    if (this.hkZ.hkX == null) {
                        return;
                    }
                    return;
                case 1:
                    w.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                    if (this.hkZ.hkX == null) {
                        return;
                    }
                    return;
                default:
                    w.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                    return;
            }
        }
    }

    public final boolean a(a aVar) {
        this.hkX = aVar;
        com.tencent.mm.compatible.util.b.a bVar = new b(this);
        if (this.fAP == null) {
            this.fAP = new com.tencent.mm.compatible.util.b(this.ty);
        }
        if (this.hkW != bVar) {
            this.hkW = bVar;
        }
        this.fAP.a(this.hkW);
        if (this.fAP == null || this.hkY) {
            return false;
        }
        this.fAP.requestFocus();
        this.hkY = true;
        return this.hkY;
    }

    public final boolean aS(boolean z) {
        boolean rY;
        if (this.fAP != null) {
            rY = this.fAP.rY();
        } else {
            rY = false;
        }
        this.hkY = false;
        if (z) {
            this.fAP = null;
            this.hkW = null;
            this.hkX = null;
        }
        return rY;
    }
}
