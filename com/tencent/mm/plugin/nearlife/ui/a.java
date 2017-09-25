package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends BaseAdapter {
    String igL = "";
    OnClickListener lJz;
    Context mContext;
    protected String nXl = "";
    boolean nXp = false;
    ArrayList<com.tencent.mm.plugin.nearlife.b.a> nXq = new ArrayList();
    HashSet<String> nXr = new HashSet();
    ArrayList<LatLongData> nXs = null;
    private Map<LatLongData, avw> nXt;
    private Map<LatLongData, Integer> nXu;
    Map<String, LatLongData> nXv;
    LatLongData nXw;
    boolean nXx = true;
    int nXy = 0;

    public /* synthetic */ Object getItem(int i) {
        return qs(i);
    }

    public a(Context context, OnClickListener onClickListener, String str, boolean z) {
        this.mContext = context;
        this.lJz = onClickListener;
        this.igL = str;
        this.nXp = z;
        this.nXs = new ArrayList();
        this.nXt = new HashMap();
        this.nXu = new HashMap();
        this.nXv = new HashMap();
    }

    public final void aON() {
        this.nXq.clear();
        this.nXr.clear();
        this.nXu.clear();
        this.nXt.clear();
        this.nXv.clear();
        this.nXy = 0;
        notifyDataSetChanged();
    }

    public final void a(com.tencent.mm.plugin.nearlife.b.a aVar, int i) {
        if (!this.nXr.contains(aVar.nWY) && i <= this.nXq.size()) {
            this.nXq.add(i, aVar);
            this.nXr.add(aVar.nWY);
            this.nXv.put(aVar.nWY, this.nXw);
        }
    }

    public final void a(LatLongData latLongData, List<com.tencent.mm.plugin.nearlife.b.a> list) {
        w.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[]{this.igL, Integer.valueOf(list.size())});
        for (com.tencent.mm.plugin.nearlife.b.a aVar : list) {
            if (!this.nXr.contains(aVar.nWY)) {
                this.nXq.add(aVar);
                this.nXr.add(aVar.nWY);
                this.nXv.put(aVar.nWY, latLongData);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.nXq.size();
    }

    public final com.tencent.mm.plugin.nearlife.b.a qs(int i) {
        if (i < 0 || i >= this.nXq.size()) {
            return new com.tencent.mm.plugin.nearlife.b.a("", new aix());
        }
        return (com.tencent.mm.plugin.nearlife.b.a) this.nXq.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public static String aV(List<avx> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            avx com_tencent_mm_protocal_c_avx = (avx) list.get(i);
            if (!(com_tencent_mm_protocal_c_avx == null || com_tencent_mm_protocal_c_avx.tZr == null || com_tencent_mm_protocal_c_avx.tZr.equals("") || com_tencent_mm_protocal_c_avx.tZr.toLowerCase().equals("null"))) {
                stringBuffer.append(com_tencent_mm_protocal_c_avx.tZr);
                if (i < list.size() - 1) {
                    stringBuffer.append("·");
                }
            }
        }
        return stringBuffer.toString();
    }

    public final void BH(String str) {
        if (str != null) {
            this.nXl = str;
        }
    }

    public final String aOO() {
        return this.nXl;
    }

    public final void K(ArrayList<LatLongData> arrayList) {
        if (arrayList != null) {
            this.nXs = arrayList;
        }
    }

    public final avw a(LatLongData latLongData) {
        if (this.nXt.containsKey(latLongData)) {
            return (avw) this.nXt.get(latLongData);
        }
        return null;
    }

    public final int b(LatLongData latLongData) {
        if (this.nXu.containsKey(latLongData)) {
            return ((Integer) this.nXu.get(latLongData)).intValue();
        }
        return 1;
    }

    public final boolean aOP() {
        Iterator it = this.nXs.iterator();
        while (it.hasNext()) {
            if (b((LatLongData) it.next()) > 0) {
                return true;
            }
        }
        if (this.nXx) {
            return b(this.nXw) > 0;
        } else {
            return false;
        }
    }

    public final void a(LatLongData latLongData, int i, avw com_tencent_mm_protocal_c_avw) {
        int i2 = 0;
        String str = "MicroMsg.BaseLifeAdapter";
        String str2 = "set flag & buf, lat:%f long:%f flag:%d len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Float.valueOf(latLongData.fOb);
        objArr[1] = Float.valueOf(latLongData.hGU);
        objArr[2] = Integer.valueOf(i);
        if (com_tencent_mm_protocal_c_avw != null) {
            i2 = com_tencent_mm_protocal_c_avw.tZn;
        }
        objArr[3] = Integer.valueOf(i2);
        w.d(str, str2, objArr);
        if (this.nXs.contains(latLongData) || (this.nXw != null && this.nXw.equals(latLongData))) {
            this.nXu.put(latLongData, Integer.valueOf(i));
            this.nXt.put(latLongData, com_tencent_mm_protocal_c_avw);
        }
    }

    public final LatLongData BI(String str) {
        if (this.nXv.containsKey(str)) {
            return (LatLongData) this.nXv.get(str);
        }
        return null;
    }

    public final int BJ(String str) {
        Iterator it = this.nXq.iterator();
        int i = -1;
        while (it.hasNext()) {
            i++;
            if (((com.tencent.mm.plugin.nearlife.b.a) it.next()).nWY.equals(str)) {
                break;
            }
        }
        return i;
    }
}
