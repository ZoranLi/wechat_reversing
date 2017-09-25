package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public final class b {

    public static final class a {
        public String desc;
        public String fTO;
        public String fUY;
        public String thumbUrl;
        public String title;
        public String url;
    }

    public static boolean a(cb cbVar, a aVar) {
        if (!bg.mA(aVar.url)) {
            rv rvVar = new rv();
            rw rwVar = new rw();
            rm rmVar = new rm();
            rmVar.NR(aVar.url);
            rmVar.NL(aVar.title);
            rmVar.NM(aVar.desc);
            rmVar.NU(aVar.thumbUrl);
            rmVar.Oj(aVar.fUY);
            rmVar.jJ(true);
            rmVar.jK(true);
            rmVar.yb(5);
            sf sfVar = new sf();
            sfVar.OT(aVar.thumbUrl);
            rvVar.b(sfVar);
            rwVar.OD(m.xL());
            rwVar.OE(m.xL());
            rwVar.yj(3);
            rwVar.ep(bg.Nz());
            rwVar.OJ(aVar.fTO);
            rwVar.OK(aVar.url);
            cbVar.fFA.title = rmVar.title;
            cbVar.fFA.fFC = rvVar;
            cbVar.fFA.type = 5;
            rvVar.a(rwVar);
            rvVar.tzn.add(rmVar);
            return true;
        }
        w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
        cbVar.fFA.fFG = R.l.eib;
        return false;
    }
}
