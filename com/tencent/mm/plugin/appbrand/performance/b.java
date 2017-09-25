package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;

public final class b {
    public static final int[] jeQ = new int[4];
    public static final SparseArray<Integer> jeR = new SparseArray();

    static {
        jeQ[0] = R.l.dFa;
        jeQ[1] = R.l.dFn;
        jeQ[2] = R.l.dFs;
        jeQ[3] = R.l.dFq;
        jeR.put(101, Integer.valueOf(R.l.dFb));
        jeR.put(102, Integer.valueOf(R.l.dFp));
        jeR.put(bh.CTRL_INDEX, Integer.valueOf(R.l.dFe));
        jeR.put(f.CTRL_INDEX, Integer.valueOf(R.l.dFo));
        jeR.put(aq.CTRL_INDEX, Integer.valueOf(R.l.dFu));
        jeR.put(com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX, Integer.valueOf(R.l.dFl));
        jeR.put(302, Integer.valueOf(R.l.dFr));
        jeR.put(303, Integer.valueOf(R.l.dFm));
        jeR.put(401, Integer.valueOf(R.l.dFt));
        jeR.put(402, Integer.valueOf(R.l.dFw));
        jeR.put(403, Integer.valueOf(R.l.dFx));
        jeR.put(TencentLocation.ERROR_UNKNOWN, Integer.valueOf(R.l.dFy));
        jeR.put(405, Integer.valueOf(R.l.dFz));
        jeR.put(406, Integer.valueOf(R.l.dFA));
        jeR.put(407, Integer.valueOf(R.l.dFB));
    }
}
