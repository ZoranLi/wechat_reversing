package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements a {
    int h = e.CTRL_INDEX;
    HashMap<Long, WeakReference<ImageView>> nbp = new HashMap();
    HashMap<Long, b> nbq = new HashMap();
    HashMap<Long, WeakReference<ProgressBar>> nbr = new HashMap();
    HashMap<Long, WeakReference<ImageView>> nbs = new HashMap();
    HashMap<b, au> nbt = new HashMap();
    HashMap<Long, Integer> nbu = new HashMap();
    HashSet<Long> nbv = new HashSet();
    int w = e.CTRL_INDEX;

    public j() {
        start();
    }

    public final void start() {
        k aGc = l.aGc();
        if (this != null) {
            for (a equals : aGc.gJv) {
                if (equals(equals)) {
                    return;
                }
            }
            aGc.gJv.add(this);
            w.i("MicroMsg.StaticMapServer", "addMapCallBack " + aGc.gJv.size());
            if (aGc.gJv.size() == 1) {
                aGc.start();
            }
        }
    }

    public final void a(String str, com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.nbq.containsKey(Long.valueOf(bVar.sBS))) {
            au auVar = (au) this.nbt.remove((b) this.nbq.get(Long.valueOf(bVar.sBS)));
            if (auVar != null) {
                WeakReference weakReference = (WeakReference) this.nbp.get(Long.valueOf(auVar.field_msgId));
                if (weakReference != null && weakReference.get() != null && this.nbu.containsKey(Long.valueOf(auVar.field_msgId))) {
                    ((ImageView) weakReference.get()).setImageBitmap(n.GS().a(auVar.field_msgId, str, ((Integer) this.nbu.remove(Long.valueOf(auVar.field_msgId))).intValue(), this.w, this.h, auVar.field_isSend == 0));
                    weakReference = (WeakReference) this.nbr.remove(Long.valueOf(auVar.field_msgId));
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((ProgressBar) weakReference.get()).setVisibility(8);
                    }
                    WeakReference weakReference2 = (WeakReference) this.nbs.remove(Long.valueOf(auVar.field_msgId));
                    if (weakReference2 != null && weakReference2.get() != null) {
                        ((ImageView) weakReference2.get()).setVisibility(0);
                    }
                }
            }
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.nbq.containsKey(Long.valueOf(bVar.sBS))) {
            au auVar = (au) this.nbt.remove((b) this.nbq.get(Long.valueOf(bVar.sBS)));
            if (auVar != null) {
                this.nbp.get(Long.valueOf(auVar.field_msgId));
                if (auVar == null) {
                    return;
                }
                if (auVar.gxL < 0 || auVar.gxL > 5) {
                    auVar.dJ(0);
                    auVar.dJ(auVar.gxL + 1);
                    if (ap.zb()) {
                        ap.yY();
                        c.wT().a(auVar.field_msgId, auVar);
                        w.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[]{Integer.valueOf(auVar.gxL)});
                    }
                }
            }
        }
    }
}
