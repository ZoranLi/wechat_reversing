package com.tencent.c.d.a;

import com.tencent.c.d.b.d.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class g implements b {
    private final Pattern vPN = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");
    private final List<a> wSg = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0 && aVar.wSn == 1) {
            this.wSg.add(aVar);
        }
    }

    public final boolean cdG() {
        for (a aVar : this.wSg) {
            com.tencent.c.e.g.d("SingleProcessAnalyzer : " + aVar.toString());
            if (aVar.name != null && this.vPN.matcher(aVar.name).find()) {
                com.tencent.c.e.g.Vi("SingleProcessAnalyzer match : " + aVar.toString());
                return true;
            }
        }
        return false;
    }
}
