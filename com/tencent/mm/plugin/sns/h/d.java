package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.s;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static d qdx = new d();
    public s gKF;
    public int gVo = 0;
    public int qdA = 86400;
    public HashMap<String, Integer> qdy;
    public int qdz = m.CTRL_INDEX;

    private d() {
        c dX = com.tencent.mm.u.c.c.Az().dX("100077");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            this.qdz = bg.getInt((String) bKK.get("maxCacheFeedCount"), m.CTRL_INDEX);
            this.qdA = bg.getInt((String) bKK.get("maxCacheSeconds"), 86400);
            this.gVo = bg.getInt((String) bKK.get("needUploadData"), 0);
        }
        w.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[]{Integer.valueOf(this.qdz), Integer.valueOf(this.qdA), Integer.valueOf(this.gVo)});
        this.gKF = new s(com.tencent.mm.storage.w.hgq + "snsreport.cfg");
        Object obj = this.gKF.get(3, new HashMap());
        if (obj instanceof HashMap) {
            this.qdy = (HashMap) obj;
            return;
        }
        FileOp.deleteFile(com.tencent.mm.storage.w.hgq + "snsreport.cfg");
        this.qdy = new HashMap();
    }

    public final void FT(String str) {
        if (this.gVo != 0) {
            this.qdy.put(str, Integer.valueOf(this.qdy.containsKey(str) ? ((Integer) this.qdy.get(str)).intValue() + 1 : 1));
        }
    }
}
