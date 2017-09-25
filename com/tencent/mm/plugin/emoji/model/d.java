package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.e.a.co;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private co kLJ = new co();
    public final Map<String, Integer> kLK = new HashMap();

    public final void d(String str, int i, int i2, String str2) {
        this.kLJ.fFZ.fGa = str;
        this.kLJ.fFZ.status = i;
        this.kLJ.fFZ.progress = i2;
        this.kLJ.fFZ.fGb = str2;
        a.urY.m(this.kLJ);
        if (i != 6) {
            this.kLK.remove(str);
        } else if (i2 < 0 || i2 >= 100) {
            this.kLK.remove(str);
        } else {
            this.kLK.put(str, Integer.valueOf(i2));
        }
    }
}
