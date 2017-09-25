package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.x.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class h implements t, b, e {
    private List<String> pmb;
    private List<String> sCZ;
    public Map<String, Integer> sDa;
    private aj sDb;
    private List<String> sDn;
    private List<String> sDo;
    private volatile boolean sDp;

    public h() {
        this.sCZ = null;
        this.pmb = null;
        this.sDa = null;
        this.sDp = false;
        this.sDb = new aj(Looper.getMainLooper(), new a(this) {
            final /* synthetic */ h sDq;

            {
                this.sDq = r1;
            }

            public final boolean oQ() {
                this.sDq.sDa.clear();
                return false;
            }
        }, false);
        this.sCZ = new ArrayList();
        this.pmb = new ArrayList();
        this.sDa = new HashMap();
        this.sDn = new Vector();
        this.sDo = new ArrayList();
        this.sDb.v(600000, 600000);
        com.tencent.mm.kernel.h.vH().gXC.a(231, (e) this);
        com.tencent.mm.plugin.w.a.aBG().a(7, (t) this);
    }

    public final String m(Context context, String str) {
        return g.m(context, str);
    }

    public final void at(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            w.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Mb((String) it.next());
        }
        bCZ();
    }

    private synchronized void Mb(String str) {
        if (bg.mA(str) || this.sDn.contains(str)) {
            w.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", str);
        } else if (Md(str)) {
            w.i("MicroMsg.AppInfoService", "add appid:[%s]", str);
            this.sDn.add(str);
        } else {
            w.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", str);
        }
    }

    public final void Mc(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppInfoService", "push fail, appId is null");
            return;
        }
        w.i("MicroMsg.AppInfoService", "push appid : " + str);
        Mb(str);
        bCZ();
    }

    private void bCZ() {
        int i = 20;
        if (this.sDp) {
            w.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
        } else if (this.sDn == null || this.sDn.isEmpty()) {
            w.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
        } else {
            int size = this.sDn.size();
            if (size <= 20) {
                i = size;
            }
            synchronized (this) {
                this.sDo.addAll(this.sDn.subList(0, i));
            }
            if (this.sDo != null && !this.sDo.isEmpty()) {
                this.sDp = true;
                com.tencent.mm.kernel.h.vH().gXC.a(new x(7, new ad(this.sDo)), 0);
            }
        }
    }

    private boolean Md(String str) {
        if (str == null) {
            w.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
            return false;
        }
        Integer valueOf = Integer.valueOf(bg.a((Integer) this.sDa.get(str), 0));
        if (valueOf.intValue() >= 5) {
            w.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
            return false;
        }
        this.sDa.put(str, Integer.valueOf(valueOf.intValue() + 1));
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        switch (type) {
            case 231:
                String str2 = ((ac) kVar).appId;
                if (this.sCZ.contains(str2)) {
                    this.sCZ.remove(str2);
                }
                while (this.pmb.size() > 0) {
                    boolean z;
                    str2 = (String) this.pmb.remove(0);
                    if (str2 == null || str2.length() == 0) {
                        w.e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
                        z = false;
                        continue;
                    } else if (Md(str2)) {
                        com.tencent.mm.kernel.h.vH().gXC.a(new ac(str2), 0);
                        z = true;
                        continue;
                    } else {
                        w.e("MicroMsg.AppInfoService", "increaseCounter fail");
                        z = false;
                        continue;
                    }
                    if (z) {
                        this.sCZ.add(str2);
                        return;
                    }
                }
                return;
            case 451:
                synchronized (this) {
                    if (!(this.sDo == null || this.sDo.isEmpty())) {
                        this.sDn.removeAll(this.sDo);
                        this.sDo.clear();
                    }
                }
                this.sDp = false;
                bCZ();
                return;
            default:
                w.e("MicroMsg.AppInfoService", "error type: " + type);
                return;
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (wVar.getType() != 7) {
            w.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            return;
        }
        synchronized (this) {
            if (!(this.sDo == null || this.sDo.isEmpty())) {
                this.sDn.removeAll(this.sDo);
                this.sDo.clear();
            }
        }
        this.sDp = false;
        bCZ();
    }
}
