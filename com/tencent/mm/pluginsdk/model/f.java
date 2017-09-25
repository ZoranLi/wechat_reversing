package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.m;

public final class f implements b {
    public final boolean a(cb cbVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        rv rvVar = new rv();
        rw rwVar = new rw();
        rm rmVar = new rm();
        rmVar.yb(5);
        rmVar.Oa(str7);
        rmVar.NR(str3);
        rmVar.ya(i);
        rmVar.NL(str);
        rmVar.NM(str2);
        rmVar.Oj(str11);
        rp rpVar = new rp();
        rpVar.hjF = str;
        rpVar.tyZ = i;
        rpVar.hjD = str3;
        rpVar.hjH = str5;
        rpVar.hjG = str4;
        rpVar.hjI = str6;
        rpVar.hjJ = str9;
        rpVar.hjK = str10;
        rmVar.a(rpVar);
        rwVar.OD(str8);
        rwVar.OE(m.xL());
        rwVar.yj(0);
        rwVar.ep(bg.Nz());
        rvVar.a(rwVar);
        rvVar.tzn.add(rmVar);
        cbVar.fFA.title = rmVar.title;
        cbVar.fFA.desc = rmVar.title;
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 4;
        return true;
    }

    public final boolean a(cb cbVar, Intent intent) {
        return e.a(cbVar, intent);
    }

    public final boolean a(cb cbVar, long j) {
        return e.a(cbVar, j);
    }

    public final boolean a(cb cbVar, String str, String str2, String str3, String str4, String str5, String str6) {
        String format = String.format("%s#%s", new Object[]{str, ""});
        rv rvVar = new rv();
        rw rwVar = new rw();
        rwVar.OD(str2);
        rwVar.yj(2);
        rwVar.ep(System.currentTimeMillis());
        rwVar.OI(str);
        rwVar.OF(format);
        rm rmVar = new rm();
        rmVar.Od(format);
        rmVar.jK(true);
        rmVar.yb(5);
        rmVar.NL(str3);
        rmVar.NM(str4);
        rmVar.Ok(str5);
        rmVar.jJ(true);
        rvVar.tzn.add(rmVar);
        sf sfVar = new sf();
        sfVar.OT(str6);
        rvVar.b(sfVar);
        rvVar.a(rwVar);
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.desc = str3;
        cbVar.fFA.type = 5;
        return true;
    }
}
