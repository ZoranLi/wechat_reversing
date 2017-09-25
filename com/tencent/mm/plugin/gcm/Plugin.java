package com.tencent.mm.plugin.gcm;

import com.tencent.mm.e.a.av;
import com.tencent.mm.e.a.go;
import com.tencent.mm.plugin.gcm.modelgcm.GcmBroadcastReceiver;
import com.tencent.mm.plugin.gcm.modelgcm.a;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public class Plugin implements c {
    com.tencent.mm.sdk.b.c mHv = new com.tencent.mm.sdk.b.c<av>(this) {
        final /* synthetic */ Plugin mHx;

        {
            this.mHx = r2;
            this.usg = av.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a aCn = a.aCn();
            if (aCn == null) {
                return false;
            }
            aCn.aCo();
            return true;
        }
    };
    com.tencent.mm.sdk.b.c mHw = new com.tencent.mm.sdk.b.c<go>(this) {
        final /* synthetic */ Plugin mHx;

        {
            this.mHx = r2;
            this.usg = go.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a aCn = a.aCn();
            if (aCn == null) {
                return false;
            }
            w.i("GcmRegister", "GCM onLogout. isRegToSvr:" + aCn.aCt());
            GcmBroadcastReceiver.aCm();
            if (aCn.aCt()) {
                aCn.aCs();
            }
            return true;
        }
    };

    public Plugin() {
        com.tencent.mm.sdk.b.a.urY.b(this.mHv);
        com.tencent.mm.sdk.b.a.urY.b(this.mHw);
    }

    public k createApplication() {
        return new com.tencent.mm.plugin.gcm.a.a();
    }

    public com.tencent.mm.pluginsdk.d.b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new com.tencent.mm.plugin.gcm.modelgcm.b();
    }
}
