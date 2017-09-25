package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bd;
import com.tencent.mm.u.m;

public final class b {
    public static boolean a(cb cbVar, bd bdVar, int i) {
        if (cbVar == null || bdVar == null) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (cbVar != null) {
                cbVar.fFA.fFG = R.l.eib;
            }
            return false;
        }
        String n;
        rv rvVar = new rv();
        rw rwVar = new rw();
        rm rmVar = new rm();
        rwVar.OD("newsapp");
        rwVar.OE(m.xL());
        rwVar.OE(m.xL());
        rwVar.yj(1);
        rwVar.ep(bdVar.hnz);
        rwVar.OH(bdVar.hnE);
        rwVar.OK(bdVar.getUrl());
        rwVar.OL("newsapp");
        rmVar.Od(String.valueOf(bdVar.hnE));
        if (i == 0) {
            n = s.n(bdVar.zH(), bdVar.type, "@T");
        } else {
            n = s.n(bdVar.zH(), bdVar.type, "@S");
        }
        if (FileOp.aO(n)) {
            rmVar.Oa(n);
        } else {
            rmVar.jK(true);
            rmVar.NU(bdVar.zH());
            sf sfVar = new sf();
            sfVar.OT(bdVar.zH());
            rvVar.b(sfVar);
        }
        rmVar.yb(5);
        rmVar.NL(bdVar.getTitle());
        rmVar.NM(bdVar.zI());
        rmVar.jJ(true);
        rvVar.a(rwVar);
        rvVar.tzn.add(rmVar);
        cbVar.fFA.desc = bdVar.getTitle();
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 5;
        return true;
    }
}
