package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c extends com.tencent.mm.plugin.brandservice.ui.base.b {
    protected int hPi;
    protected String jZL;
    protected int jZN;
    private List<a> jZQ = new ArrayList();
    private int jZR;
    private boolean jZS;
    protected boolean jZT;
    protected boolean jZU;
    int jZV;
    protected long[] jZW;
    protected b jZX;

    protected static class a {
        public int count;
        public long fDt;
        public int jZY;
        public List<String> jZZ;
        public List<ia> kaa;
        public boolean kab;
        public boolean kac;
        public List<hv> kad;

        protected a() {
        }
    }

    public interface b {
        void a(c cVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar, int i, String str, int i2, int i3);
    }

    public c(Context context) {
        super(context);
        g(true, true);
        this.jZS = true;
        c(1);
    }

    public void c(String str, List<hv> list) {
        this.jZQ.clear();
        this.kbC.clear();
        af.v(this.kbD);
        this.jZR = 0;
        this.jZL = str;
        if (list != null) {
            this.jZV = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < list.size(); i++) {
                hv hvVar = (hv) list.get(i);
                if (!(hvVar == null || hvVar.muY == null || hvVar.muY.size() <= 0)) {
                    a a = a(hvVar);
                    this.jZR += a(a);
                    this.jZQ.add(a);
                    w.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[]{Long.valueOf(a.fDt), Integer.valueOf(a.count), Integer.valueOf(this.jZR)});
                }
            }
            aef();
        }
        af.v(this.kbD);
    }

    private a a(hv hvVar) {
        a aVar = new a();
        aVar.kad = new LinkedList();
        aVar.kad.add(hvVar);
        aVar.fDt = hvVar.tlY;
        aVar.count = hvVar.muY.size();
        aVar.jZY = hvVar.tlZ;
        aVar.kaa = new LinkedList();
        aVar.kaa.addAll(hvVar.muY);
        aVar.jZZ = hvVar.tma;
        aVar.kab = this.jZU;
        boolean z = this.jZT && aVar.jZY != 0;
        aVar.kac = z;
        return aVar;
    }

    public void a(hv hvVar, boolean z) {
        if ((this.jZS && hvVar == null) || hvVar.muY == null) {
            w.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
            return;
        }
        if (isEmpty()) {
            this.jZV = (int) (System.currentTimeMillis() / 1000);
        }
        a aM = aM(hvVar.tlY);
        if (aM != null) {
            if (aM.kaa == null) {
                aM.kaa = new LinkedList();
            }
            aM.kaa.addAll(hvVar.muY);
            if (aM.kad == null) {
                aM.kad = new LinkedList();
            }
            aM.kad.add(hvVar);
            aM.count += hvVar.muY.size();
            this.jZR += hvVar.muY.size();
        } else if (z) {
            this.jZQ.add(a(hvVar));
            aef();
        } else {
            w.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[]{Long.valueOf(hvVar.tlY)});
            return;
        }
        af.v(this.kbD);
    }

    final a aM(long j) {
        int i = 0;
        while (i < this.jZQ.size()) {
            if (((a) this.jZQ.get(i)).fDt == j) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            return (a) this.jZQ.get(i);
        }
        return null;
    }

    protected final a ka(int i) {
        if (i >= 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.jZQ.size(); i3++) {
                a aVar = (a) this.jZQ.get(i3);
                i2 += a(aVar);
                if (i < i2) {
                    return aVar;
                }
            }
        }
        return null;
    }

    protected final hv kb(int i) {
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.jZQ.size()) {
                a aVar = (a) this.jZQ.get(i3);
                int a = a(aVar);
                i4 += a;
                if (i < i4) {
                    i4 = (aVar.kab ? 1 : 0) + (i4 - a);
                    while (i2 < aVar.kad.size()) {
                        hv hvVar = (hv) aVar.kad.get(i2);
                        i4 += hvVar.muY.size();
                        if (i < i4) {
                            return hvVar;
                        }
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        return null;
    }

    private static int a(a aVar) {
        int i = 1;
        if (aVar == null) {
            return 0;
        }
        int i2 = (aVar.kab ? 1 : 0) + aVar.count;
        if (!aVar.kac) {
            i = 0;
        }
        return i2 + i;
    }

    private synchronized void aef() {
        boolean z = true;
        synchronized (this) {
            Map hashMap = new HashMap();
            for (int i = 0; i < this.jZQ.size(); i++) {
                a aVar = (a) this.jZQ.get(i);
                if (aVar != null) {
                    hashMap.put(Long.valueOf(aVar.fDt), aVar);
                }
            }
            this.jZQ.clear();
            this.jZR = 0;
            for (long valueOf : this.jZW) {
                aVar = (a) hashMap.get(Long.valueOf(valueOf));
                if (aVar != null) {
                    this.jZQ.add(aVar);
                    this.jZR = a(aVar) + this.jZR;
                }
            }
            if (this.jZQ.size() > 0) {
                aVar = (a) this.jZQ.get(this.jZQ.size() - 1);
                if (aVar.kac == this.jZS) {
                    this.jZR = (aVar.kac ? -1 : 1) + this.jZR;
                    if (this.jZS) {
                        z = false;
                    }
                    aVar.kac = z;
                }
            }
            hashMap.clear();
        }
    }

    public final void g(boolean z, boolean z2) {
        this.jZU = z;
        this.jZT = z2;
    }

    public final void kc(int i) {
        this.hPi = i;
    }

    public final void kd(int i) {
        this.jZN = i;
    }

    public final void c(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.jZW = jArr;
        }
    }

    public int getCount() {
        return this.jZR;
    }

    public void aeg() {
        c(null, null);
        this.jZV = 0;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final com.tencent.mm.plugin.brandservice.ui.base.a ke(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.jZQ.size(); i4++) {
            a aVar = (a) this.jZQ.get(i4);
            int a = a(aVar);
            i3 += a;
            if (aVar.kab && i == i3 - a) {
                hv hvVar = aVar.kad.size() == 0 ? null : (hv) aVar.kad.get(0);
                if (hvVar != null) {
                    return new d(hvVar.fDC);
                }
            } else if (aVar.kac && i == i3 - 1) {
                return new e(null, aVar.fDt, aVar.count, this.jZL);
            } else {
                if (i < i3) {
                    i4 = (i - i3) + aVar.count;
                    if (aVar.kac) {
                        i2 = 1;
                    }
                    i2 += i4;
                    ia iaVar = (ia) aVar.kaa.get(i2);
                    long j = aVar.fDt;
                    b bVar = this.jZX;
                    if (iaVar == null) {
                        w.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                        return null;
                    }
                    com.tencent.mm.plugin.brandservice.ui.base.a aVar2;
                    if (j == 1) {
                        w.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                        aVar2 = new a(iaVar);
                    } else {
                        aVar2 = j == 4 ? new g(iaVar) : j == 1073741824 ? new g(iaVar) : new g(iaVar);
                    }
                    if (!(aVar2 instanceof com.tencent.mm.plugin.brandservice.ui.base.c)) {
                        return aVar2;
                    }
                    com.tencent.mm.plugin.brandservice.ui.base.c cVar = (com.tencent.mm.plugin.brandservice.ui.base.c) aVar2;
                    cVar.ki(i2);
                    cVar.kj(i);
                    cVar.a(bVar);
                    return aVar2;
                }
            }
        }
        return new g(null);
    }

    protected Object[] kf(int i) {
        a ka = ka(i);
        hv kb = kb(i);
        if (kb != null) {
            Object obj = kb.tmb;
        } else {
            String str = "";
        }
        if (ka == null) {
            return null;
        }
        return new Object[]{this, ka.jZZ, Integer.valueOf(this.jZN), obj};
    }

    public final void a(b bVar) {
        this.jZX = bVar;
    }
}
