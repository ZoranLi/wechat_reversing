package com.tencent.mm.i;

import com.tencent.mm.a.g;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private HashMap<String, String> gTn = new HashMap();
    private boolean gTo = false;

    public final synchronized String getValue(String str) {
        if (!this.gTo) {
            w.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            sL();
        }
        w.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.gTn.get(str));
        return (String) this.gTn.get(str);
    }

    public final int getInt(String str, int i) {
        try {
            i = Integer.parseInt(getValue(str));
        } catch (Exception e) {
            w.e("MicroMsg.DynamicConfig", "parseInt failed, val: " + str);
        }
        return i;
    }

    public final synchronized List<String> dC(String str) {
        List<String> arrayList;
        if (!this.gTo) {
            w.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            sL();
        }
        arrayList = new ArrayList();
        if (!bg.mA(str)) {
            for (String str2 : this.gTn.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.gTn.get(str2));
                }
            }
        }
        w.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        if (!(str == null || str2 == null)) {
            w.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.gTn.put(str, str2);
        }
    }

    public final synchronized void sL() {
        h.vJ();
        if (h.vI() != null) {
            h.vJ();
            if (h.vI().vr() != null) {
                this.gTo = true;
                h.vJ();
                i((String) h.vI().vr().get(278529, null), false);
            }
        }
        h.vJ();
        if (h.vI() != null) {
            h.vJ();
            if (h.vI().vr() != null) {
                this.gTo = true;
                h.vJ();
                i((String) h.vI().vr().get(278530, null), true);
            }
        }
    }

    public final synchronized void a(String str, Map<String, String> map, boolean z) {
        if (!bg.mA(str)) {
            w.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), g.aV(str));
            if (z) {
                h.vJ();
                h.vI().vr().set(278530, str);
            } else {
                h.vJ();
                h.vI().vr().set(278529, str);
                h.vJ();
                h.vI().vr().set(278530, "");
            }
            if (map != null) {
                a(map, z);
            } else {
                i(str, z);
            }
            a.urY.m(new cg());
        }
    }

    private void i(String str, boolean z) {
        a(bh.q(str, "sysmsg"), z);
    }

    private void a(Map<String, String> map, boolean z) {
        if (map != null) {
            if (!z) {
                this.gTn.clear();
            }
            int i = 0;
            while (i < 10000) {
                String str;
                if (z) {
                    str = ".sysmsg.dynacfg_split.Item" + (i == 0 ? "" : Integer.valueOf(i));
                } else {
                    str = ".sysmsg.dynacfg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                }
                String str2 = str + ".$key";
                str = (String) map.get(str);
                str2 = (String) map.get(str2);
                if (str2 == null || bg.mA(str2.trim())) {
                    break;
                }
                this.gTn.put(str2.trim(), str != null ? str : "");
                w.d("MicroMsg.DynamicConfig", "put %s %s", str2.trim(), str);
                i++;
            }
            w.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.gTn.toString());
        }
    }
}
