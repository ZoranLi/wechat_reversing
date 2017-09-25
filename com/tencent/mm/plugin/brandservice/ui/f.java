package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.plugin.brandservice.ui.base.c;
import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class f extends c {
    List<auf> kbq = null;
    private SparseArray<c> kbr = new SparseArray();
    private int kbs;

    public final /* synthetic */ Object getItem(int i) {
        return kh(i);
    }

    public f(Context context) {
        super(context);
        a(new b(this) {
            final /* synthetic */ f kbt;

            {
                this.kbt = r1;
            }

            public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
                hv kb = this.kbt.kb(i3);
                String str2 = bg.mz(this.kbt.jZL) + "," + i + "," + bg.mz(str) + "," + i2 + "," + cVar.jZV + "," + (kb == null ? "" : kb.tmb + ",0");
                g.oUh.A(10866, str2);
                w.d("MicroMsg.SearchOrRecommendBizAdapter", "report : " + str2);
            }
        });
    }

    public final void c(String str, List<hv> list) {
        super.c(str, list);
        this.kbs = super.getCount();
    }

    public final void a(hv hvVar, boolean z) {
        super.a(hvVar, z);
        if (this.kbs == 0) {
            this.kbs = super.getCount();
        }
    }

    public final int getCount() {
        int count = super.getCount();
        if (count != 0 || this.kbq == null) {
            return count;
        }
        int i = count;
        for (auf com_tencent_mm_protocal_c_auf : this.kbq) {
            if (com_tencent_mm_protocal_c_auf == null || com_tencent_mm_protocal_c_auf.tXY == null) {
                count = i;
            } else {
                count = i + com_tencent_mm_protocal_c_auf.tXY.size();
            }
            i = count;
        }
        return i;
    }

    public final void aeg() {
        super.aeg();
    }

    public final a kh(int i) {
        String str = null;
        int count = super.getCount();
        if (count != 0) {
            return super.kh(i);
        }
        c cVar = (c) this.kbr.get(i);
        if (cVar != null || this.kbq.size() <= 0) {
            return cVar;
        }
        Object obj;
        for (auf com_tencent_mm_protocal_c_auf : this.kbq) {
            if (count == i) {
                String com_tencent_mm_protocal_c_avx = com_tencent_mm_protocal_c_auf.tXW == null ? null : com_tencent_mm_protocal_c_auf.tXW.toString();
                obj = (axg) com_tencent_mm_protocal_c_auf.tXY.get(0);
                str = com_tencent_mm_protocal_c_avx;
            } else if (i < com_tencent_mm_protocal_c_auf.tXY.size() + count) {
                axg com_tencent_mm_protocal_c_axg = (axg) com_tencent_mm_protocal_c_auf.tXY.get(i - count);
                break;
            } else {
                count = com_tencent_mm_protocal_c_auf.tXY.size() + count;
            }
        }
        obj = null;
        a bVar = new b(obj, str);
        bVar.ki(i);
        bVar.kj(i);
        this.kbr.put(i, bVar);
        return bVar;
    }

    protected final Object[] kf(int i) {
        a ka = ka(i);
        hv kb = kb(i);
        if (ka == null) {
            return super.kf(i);
        }
        Object[] objArr = new Object[4];
        objArr[0] = this;
        objArr[1] = ka.jZZ;
        objArr[2] = Integer.valueOf(i < this.kbs ? 39 : 56);
        objArr[3] = kb != null ? kb.tmb : "";
        return objArr;
    }
}
