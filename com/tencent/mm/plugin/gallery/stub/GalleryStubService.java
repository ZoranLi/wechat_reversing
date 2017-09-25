package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.e.a.hy;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public class GalleryStubService extends Service {
    private a mfh = new a(this) {
        final /* synthetic */ GalleryStubService mfi;

        {
            this.mfi = r1;
        }

        public final void aa(int i, String str) {
            g.oUh.A(i, str);
        }

        public final void a(String str, String str2, boolean z, int i, boolean z2) {
            if (com.tencent.mm.sdk.b.a.urY != null) {
                b hyVar = new hy();
                hyVar.fNz.fNA = Boolean.valueOf(z);
                hyVar.fNz.imagePath = str;
                hyVar.fNz.fNB = i;
                hyVar.fNz.toUser = str2;
                hyVar.fNz.fNC = Boolean.valueOf(z2);
                com.tencent.mm.sdk.b.a.urY.m(hyVar);
            }
        }

        public final void om() {
            f.rZ(19);
        }

        public final int ayP() {
            return bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitVideoSize"), 20971520);
        }

        public final int sC() {
            return com.tencent.mm.i.b.sC();
        }

        public final int sB() {
            return com.tencent.mm.i.b.sB();
        }

        public final boolean es(boolean z) {
            ap.yY();
            return c.vr().c(w.a.uFN, z);
        }

        public final int xp(String str) {
            PInt pInt = new PInt();
            t.a(str, pInt, new PInt());
            return pInt.value;
        }
    };

    public IBinder onBind(Intent intent) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", new Object[]{intent});
        return this.mfh;
    }
}
