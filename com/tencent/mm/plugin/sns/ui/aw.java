package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public final class aw extends BaseAdapter implements w {
    private static HashMap<Long, a> qHZ = new HashMap();
    private boolean gXy = false;
    au qHX;
    public av qHY;

    static class a {
        String id;
        int mbS;
        int networkType;
        int pXP;
        HashSet<Integer> qIb;
        HashSet<Integer> qIc;
        HashSet<Integer> qId;
        HashSet<Integer> qIe;
        int qIf;
        long qIg;
        int qIh;
        int qIi;

        a() {
        }
    }

    public final /* bridge */ /* synthetic */ Vending biX() {
        return this.qHY;
    }

    public final /* synthetic */ Object getItem(int i) {
        return tM(i);
    }

    public aw(MMActivity mMActivity, ListView listView, b bVar, i iVar, String str) {
        this.qHX = new au(mMActivity, listView, bVar, iVar, 10, this);
        this.qHX.qze = true;
        this.qHY = new av();
        av avVar = this.qHY;
        au auVar = this.qHX;
        avVar.mContext = mMActivity;
        avVar.qHO = auVar;
        avVar.qrl = str;
        h.vJ();
        avVar.hnQ = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
        com.tencent.mm.vending.base.b bVar2 = this.qHY;
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[]{Integer.valueOf(10)});
        bVar2.wBY = 10;
        this.qHY.addVendingDataChangedCallback(new d(this) {
            final /* synthetic */ aw qIa;

            {
                this.qIa = r1;
            }

            public final void bla() {
                this.qIa.notifyDataSetChanged();
            }
        });
    }

    public final void sL() {
        if (!this.gXy) {
            this.gXy = true;
            this.qHY.notifyVendingDataChangeSynchronize();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.qHX.g(i, view);
    }

    public final int getViewTypeCount() {
        return 12;
    }

    public final int getItemViewType(int i) {
        return this.qHX.getItemViewType(i);
    }

    public final void biW() {
        this.qHY.notifyVendingDataChange();
    }

    public final m tM(int i) {
        ax axVar = (ax) this.qHY.get(i);
        if (axVar == null) {
            return null;
        }
        return axVar.pyJ;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.qHY.mCount;
    }

    public static void B(m mVar) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (!qHZ.containsKey(Long.valueOf(j))) {
                a aVar = new a();
                if (mVar.bhd() != null && mVar.bhd().ufB != null && mVar.bhd().ufB.tsN == 1 && mVar.bhd().ufB.tsO != null && mVar.bhd().ufB.tsO.size() > 0) {
                    aVar.pXP = mVar.bhd().ufB.tsO.size();
                    aVar.qIb = new HashSet();
                    aVar.qIc = new HashSet();
                    aVar.qId = new HashSet();
                    aVar.qIe = new HashSet();
                    aVar.id = mVar.bhd().mQY;
                    try {
                        bbk n = ai.n(mVar);
                        aVar.qIh = n.ucl;
                        aVar.qIi = n.uco;
                    } catch (Exception e) {
                        aVar.qIh = 0;
                        aVar.qIi = 0;
                    }
                    try {
                        h.vJ();
                        aVar.mbS = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().Ax(mVar.field_userName);
                        long currentTimeMillis = System.currentTimeMillis();
                        h.vJ();
                        aVar.qIg = (currentTimeMillis - ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().AD(mVar.field_userName)) / 1000;
                    } catch (Exception e2) {
                        aVar.mbS = 0;
                        aVar.qIg = 0;
                    }
                    qHZ.put(Long.valueOf(j), aVar);
                }
            }
        }
    }

    public static void b(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (qHZ.containsKey(Long.valueOf(j))) {
                a aVar = (a) qHZ.get(Long.valueOf(j));
                if (aVar.qIf == 0) {
                    aVar.qIf = i + 1;
                }
                if (aVar.qIb == null) {
                    aVar.qIb = new HashSet();
                }
                aVar.qIb.add(Integer.valueOf(i + 1));
            }
        }
    }

    public static void c(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (qHZ.containsKey(Long.valueOf(j))) {
                a aVar = (a) qHZ.get(Long.valueOf(j));
                if (aVar.qIc == null) {
                    aVar.qIc = new HashSet();
                }
                if (!aVar.qIc.contains(Integer.valueOf(i + 1))) {
                    aVar.qIc.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void d(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (qHZ.containsKey(Long.valueOf(j))) {
                a aVar = (a) qHZ.get(Long.valueOf(j));
                if (aVar.qId == null) {
                    aVar.qId = new HashSet();
                }
                if (!aVar.qId.contains(Integer.valueOf(i + 1))) {
                    aVar.qId.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void e(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (qHZ.containsKey(Long.valueOf(j))) {
                a aVar = (a) qHZ.get(Long.valueOf(j));
                if (aVar.qIe == null) {
                    aVar.qIe = new HashSet();
                }
                if (!aVar.qIe.contains(Integer.valueOf(i + 1))) {
                    aVar.qIe.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void bkZ() {
        for (Entry value : qHZ.entrySet()) {
            a aVar = (a) value.getValue();
            aVar.networkType = i.bdC();
            w.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[]{Integer.valueOf(aVar.pXP), Integer.valueOf(aVar.qIb.size()), Integer.valueOf(aVar.qIf), Integer.valueOf(aVar.networkType), aVar.id});
            Iterator it = aVar.qIc.iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + ((Integer) it.next()) + "|";
            }
            if (str.length() >= 2) {
                str = str.substring(0, str.length() - 1);
            }
            Iterator it2 = aVar.qId.iterator();
            String str2 = "";
            while (it2.hasNext()) {
                str2 = str2 + ((Integer) it2.next()) + "|";
            }
            if (str2.length() >= 2) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            Iterator it3 = aVar.qIe.iterator();
            String str3 = "";
            while (it3.hasNext()) {
                str3 = str3 + ((Integer) it3.next()) + "|";
            }
            if (str3.length() >= 2) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            g.oUh.i(11599, new Object[]{Integer.valueOf(aVar.pXP), Integer.valueOf(aVar.qIb.size()), Integer.valueOf(aVar.qIf), Integer.valueOf(aVar.networkType), Integer.valueOf(0), aVar.id, Long.valueOf(aVar.qIg), Integer.valueOf(aVar.mbS), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar.qIh), Integer.valueOf(aVar.qIi), Integer.valueOf(0), str, str2, str3});
        }
        qHZ.clear();
    }
}
