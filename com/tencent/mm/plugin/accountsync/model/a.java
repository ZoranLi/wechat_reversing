package com.tencent.mm.plugin.accountsync.model;

import android.os.Message;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a implements e {
    public b hAf = new b(this) {
        final /* synthetic */ a isf;

        {
            this.isf = r1;
        }

        public final void bg(boolean z) {
            w.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", Boolean.valueOf(z));
            if (!z) {
                return;
            }
            if (m.Fs().size() > 0) {
                w.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
                ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, this.isf);
                System.currentTimeMillis();
                ap.vd().a(new aa(m.Fs(), m.Fr()), 0);
                return;
            }
            w.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
            String[] strArr = (String[]) this.isf.isc.toArray(new String[0]);
            this.isf.isc.clear();
            List arrayList = new ArrayList();
            for (String iZ : strArr) {
                com.tencent.mm.modelfriend.b iZ2 = af.FY().iZ(iZ);
                if (iZ2 == null || bg.mA(iZ2.EX())) {
                    w.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", iZ);
                } else {
                    arrayList.add(iZ2.EX());
                    w.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", iZ2.EX(), iZ);
                }
            }
            ap.vd().a(32, this.isf);
            if (arrayList.size() == 0) {
                w.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
                ap.vd().a(new v(), 0);
                return;
            }
            w.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", Integer.valueOf(arrayList.size()));
            ap.vd().a(new v(arrayList, null), 0);
        }
    };
    public boolean hTa = false;
    public Set<String> isc = Collections.synchronizedSet(new HashSet());
    public c isd = new c<iw>(this) {
        final /* synthetic */ a isf;

        {
            this.isf = r2;
            this.usg = iw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", ((iw) bVar).fOH.username, Boolean.valueOf(this.isf.hTa));
            this.isf.isc.add(r7.fOH.username);
            if (!this.isf.hTa) {
                this.isf.ise.removeMessages(0);
                this.isf.ise.sendEmptyMessageDelayed(0, 10000);
            }
            return false;
        }
    };
    public ae ise = new ae(this) {
        final /* synthetic */ a isf;

        {
            this.isf = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.isf.hTa = true;
                    if (!com.tencent.mm.modelfriend.a.a(this.isf.hAf)) {
                        this.isf.hTa = false;
                    }
                    w.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", Boolean.valueOf(r0));
                    return;
                default:
                    return;
            }
        }
    };

    public a() {
        com.tencent.mm.sdk.b.a.urY.b(this.isd);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX) {
            ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, (e) this);
            if (i == 0 && i2 == 0) {
                ap.vd().a(32, (e) this);
                aa aaVar = (aa) kVar;
                ap.vd().a(new v(aaVar.hBO, aaVar.hBP), 0);
            } else {
                w.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i + ", errCode = " + i2);
                this.hTa = false;
            }
        }
        if (kVar.getType() == 32) {
            this.hTa = false;
            ap.vd().b(32, (e) this);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                d.be(ab.getContext());
                return;
            }
            w.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
    }
}
