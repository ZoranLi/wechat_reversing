package com.tencent.c.d.a;

import android.text.TextUtils;
import com.tencent.c.d.b.d.a;
import com.tencent.c.e.g;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    private final List<a> wSg = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0 && !TextUtils.isEmpty(aVar.wSo) && "u:r:zygote:s0".equals(aVar.wSo) && !TextUtils.isEmpty(aVar.name) && !"zygote".equals(aVar.name) && !"zygote64".equals(aVar.name)) {
            g.Vi("JavaProcessAnalyzer match : " + aVar.toString());
            this.wSg.add(aVar);
        }
    }

    public final boolean cdG() {
        return this.wSg.size() > 0;
    }
}
