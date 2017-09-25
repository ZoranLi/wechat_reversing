package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
    public boolean aJi = false;
    public com.tencent.mm.modelgeo.a.a iNl = null;
    ae iNm = null;
    public com.tencent.mm.modelgeo.a lWL = null;

    class AnonymousClass1 implements com.tencent.mm.modelgeo.a.a {
        final /* synthetic */ a lWM;
        final /* synthetic */ c lWN;

        AnonymousClass1(c cVar, a aVar) {
            this.lWN = cVar;
            this.lWM = aVar;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            w.v(c.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
            if (this.lWN.lWL != null) {
                this.lWN.lWL.c(this.lWN.iNl);
            }
            if (this.lWN.iNl == null) {
                w.w(c.TAG, "already callback");
                return false;
            }
            this.lWN.iNl = null;
            this.lWM.p(f, f2);
            return false;
        }
    }

    public interface a {
        void p(float f, float f2);
    }

    private static class b {
        public static c lWO = new c();
    }

    public static c axs() {
        return b.lWO;
    }
}
