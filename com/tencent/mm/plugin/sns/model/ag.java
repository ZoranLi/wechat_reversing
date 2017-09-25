package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag implements g {
    public HashMap<String, k> pWS = new HashMap();

    public final k Fj(String str) {
        return (k) this.pWS.get(str);
    }

    public final boolean bfb() {
        ae.bev().post(new Runnable(this) {
            final /* synthetic */ ag pWT;

            {
                this.pWT = r1;
            }

            public final void run() {
                if (this.pWT.pWS.size() > 50) {
                    this.pWT.td(10);
                }
            }
        });
        return true;
    }

    public final boolean bfc() {
        ae.bev().post(new Runnable(this) {
            final /* synthetic */ ag pWT;

            {
                this.pWT = r1;
            }

            public final void run() {
                this.pWT.td(this.pWT.pWS.size());
            }
        });
        return true;
    }

    public final void td(int i) {
        if (this.pWS == null || this.pWS.size() == 0) {
            w.i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            return;
        }
        Object obj;
        long cs;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (ae.wO() != null) {
            obj = 1;
            cs = ae.wO().cs(Thread.currentThread().getId());
        } else {
            obj = null;
            cs = 0;
        }
        w.d("MicroMsg.SnsExtCache", "writeNums " + i + " " + cs);
        LinkedList linkedList = new LinkedList();
        for (String str2 : this.pWS.keySet()) {
            linkedList.add(str2);
            if (linkedList.size() >= i) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (this.pWS.containsKey(str2) && !ae.beu()) {
                ae.beO().b((k) this.pWS.get(str2));
                this.pWS.remove(str2);
            }
        }
        if (obj != null) {
            ae.wO().aD(cs);
        }
        w.d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final boolean a(final k kVar) {
        if (kVar == null || bg.mA(kVar.field_userName)) {
            return false;
        }
        ae.bev().post(new Runnable(this) {
            final /* synthetic */ ag pWT;

            public final void run() {
                this.pWT.pWS.put(kVar.field_userName, kVar);
            }
        });
        return true;
    }
}
