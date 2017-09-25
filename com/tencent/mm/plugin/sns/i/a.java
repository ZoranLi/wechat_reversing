package com.tencent.mm.plugin.sns.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static boolean a(cb cbVar, m mVar) {
        if (mVar == null) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            cbVar.fFA.fFG = j.eib;
            return false;
        }
        rv rvVar = new rv();
        rw rwVar = new rw();
        bfc bhd = mVar.bhd();
        alh com_tencent_mm_protocal_c_alh = (alh) bhd.ufB.tsO.get(0);
        if (mVar.tE(32) && bhd.ufB.tsN == 15) {
            bhd.ufG.hjJ = mVar.bhc().pZI;
            bhd.ufG.hjK = bhd.mQY;
        }
        String df = i.df(mVar.field_snsId);
        df = String.format("%s#%s", new Object[]{df, com_tencent_mm_protocal_c_alh.mQY});
        rwVar.OD(mVar.field_userName);
        rwVar.OE(com.tencent.mm.u.m.xL());
        rwVar.yj(2);
        rwVar.ep(bg.Nz());
        rwVar.OI(mVar.bhe());
        rwVar.OF(df);
        rvVar.a(rwVar);
        rm rmVar = new rm();
        rmVar.Od(df);
        String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
        String j = i.j(com_tencent_mm_protocal_c_alh);
        String e = i.e(com_tencent_mm_protocal_c_alh);
        if (bg.mA(ap.a(mVar.bhy(), com_tencent_mm_protocal_c_alh))) {
            w.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            cbVar.fFA.fFG = j.pJH;
            return false;
        } else if (FileOp.aO(du + j)) {
            int i;
            int i2;
            if (!FileOp.aO(du + e)) {
                int i3 = 320;
                i = 240;
                if (com_tencent_mm_protocal_c_alh.tPl != null && com_tencent_mm_protocal_c_alh.tPl.tPZ > 0.0f && com_tencent_mm_protocal_c_alh.tPl.tPY > 0.0f) {
                    i3 = (int) com_tencent_mm_protocal_c_alh.tPl.tPY;
                    i = (int) com_tencent_mm_protocal_c_alh.tPl.tPZ;
                }
                Bitmap J = d.J(du + j, i3, i);
                if (J == null) {
                    w.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + FileOp.aO(du + e));
                    cbVar.fFA.fFG = j.pJH;
                    return false;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(J, 60, CompressFormat.JPEG, du + e, true);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", e2, "save bmp error %s", new Object[]{e2.getMessage()});
                    w.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + FileOp.aO(du + e));
                    cbVar.fFA.fFG = j.pJH;
                    return false;
                }
            }
            rmVar.NZ(du + j);
            rmVar.Oa(du + e);
            rmVar.NL(bg.mA(com_tencent_mm_protocal_c_alh.tPt) ? bhd.ufy : com_tencent_mm_protocal_c_alh.tPt);
            rmVar.Ok(bhd.qsQ);
            if (!bg.mA(bhd.qsQ)) {
                Map q = bh.q(bhd.qsQ, "adxml");
                if (q.size() > 0) {
                    rmVar.NL(bg.ap((String) q.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    rmVar.NM(bg.ap((String) q.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            if (mVar.tE(32)) {
                b bha = mVar.bha();
                rp rpVar = new rp();
                rpVar.hjF = bg.mA(com_tencent_mm_protocal_c_alh.tPt) ? bhd.ufy : com_tencent_mm_protocal_c_alh.tPt;
                rpVar.tyZ = com_tencent_mm_protocal_c_alh.qLq;
                rpVar.hjD = com_tencent_mm_protocal_c_alh.tPp;
                rpVar.hjJ = bhd.ufG.hjJ;
                rpVar.hjK = bhd.ufG.hjK;
                if (bg.mA(rpVar.hjK)) {
                    rpVar.hjK = bhd.mQY;
                }
                rpVar.hjI = bg.mA(com_tencent_mm_protocal_c_alh.tPs) ? com_tencent_mm_protocal_c_alh.tPi : com_tencent_mm_protocal_c_alh.tPs;
                if (bha != null && bha.qef == 0) {
                    rpVar.hjH = bha.qeh;
                    rpVar.hjG = bha.qeg;
                }
                rmVar.a(rpVar);
                i = 15;
                i2 = 16;
            } else {
                i2 = 4;
                i = 4;
            }
            rmVar.yb(i);
            com.tencent.mm.plugin.sight.base.a Er = d.Er(rmVar.txG);
            if (Er != null) {
                rmVar.ya(Er.bbO());
            } else {
                rmVar.ya(1);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(rmVar);
            rvVar.av(linkedList);
            cbVar.fFA.fFC = rvVar;
            cbVar.fFA.type = i2;
            a(rmVar, mVar);
            w.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return true;
        } else {
            w.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + FileOp.aO(du + j) + " thumb:" + FileOp.aO(du + e));
            cbVar.fFA.fFG = j.pJH;
            return false;
        }
    }

    public static boolean a(cb cbVar, String str, String str2) {
        if (cbVar == null || !u.GC(str2) || str == null) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (cbVar != null) {
                cbVar.fFA.fFG = j.eib;
            }
            return false;
        } else if (ae.beu()) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cbVar.fFA.fFG = j.pJI;
            return false;
        } else {
            m Gg = h.Gg(str2);
            if (Gg == null) {
                w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cbVar.fFA.fFG = j.eic;
                return false;
            }
            sf sfVar;
            String str3 = "0";
            alh a = ai.a(Gg, 0);
            if (a != null) {
                str3 = a.mQY;
            }
            String df = i.df(Gg.field_snsId);
            str3 = String.format("%s#%s", new Object[]{df, str3});
            rv rvVar = new rv();
            rw rwVar = new rw();
            w.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[]{Gg.field_userName});
            rwVar.OD(Gg.field_userName);
            rwVar.OE(com.tencent.mm.u.m.xL());
            rwVar.yj(2);
            rwVar.ep(((long) Gg.field_createTime) * 1000);
            rwVar.OI(Gg.bhe());
            rwVar.OF(str3);
            rwVar.OK(str);
            rm rmVar = new rm();
            rmVar.Od(str3);
            if (a != null) {
                str3 = am.du(ae.getAccSnsPath(), a.mQY) + i.e(a);
                if (FileOp.aO(str3)) {
                    rmVar.Oa(str3);
                } else {
                    rmVar.jK(true);
                    rmVar.NU(a.tPi);
                    sfVar = new sf();
                    sfVar.OT(a.tPi);
                    rvVar.b(sfVar);
                }
            } else {
                rmVar.jK(true);
            }
            rmVar.yb(5);
            bfc bhd = Gg.bhd();
            rmVar.NL(bhd.ufB.fDC);
            rmVar.NM(bhd.ufB.msk);
            rmVar.Ok(bhd.qsQ);
            if (!bg.mA(bhd.qsQ)) {
                Map q = bh.q(bhd.qsQ, "adxml");
                if (q.size() > 0) {
                    rmVar.NL(bg.ap((String) q.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    rmVar.NM(bg.ap((String) q.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            a(rmVar, bhd);
            rmVar.jJ(true);
            rvVar.tzn.add(rmVar);
            sfVar = new sf();
            sfVar.yl(bhd.hhv);
            rvVar.b(sfVar);
            rvVar.a(rwVar);
            cbVar.fFA.fFC = rvVar;
            cbVar.fFA.desc = bhd.ufB.fDC;
            cbVar.fFA.type = 5;
            return true;
        }
    }

    public static boolean a(cb cbVar, String str, CharSequence charSequence) {
        if (u.GD(str) || charSequence == null) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            cbVar.fFA.fFG = j.eib;
            return false;
        } else if (ae.beu()) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cbVar.fFA.fFG = j.pJI;
            return false;
        } else {
            m Gg = ae.beL().Gg(str);
            if (Gg == null) {
                w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cbVar.fFA.fFG = j.eic;
                return false;
            } else if (0 == Gg.field_snsId) {
                w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                cbVar.fFA.fFG = j.eia;
                return false;
            } else {
                String df = i.df(Gg.field_snsId);
                df = String.format("%s#0", new Object[]{df});
                rv rvVar = new rv();
                rw rwVar = new rw();
                w.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[]{Gg.field_userName});
                rwVar.OD(Gg.field_userName);
                rwVar.OE(com.tencent.mm.u.m.xL());
                rwVar.yj(2);
                rwVar.ep(((long) Gg.field_createTime) * 1000);
                rwVar.OI(Gg.bhe());
                rwVar.OF(df);
                rvVar.a(rwVar);
                cbVar.fFA.fFC = rvVar;
                cbVar.fFA.desc = charSequence.toString();
                cbVar.fFA.type = 1;
                return true;
            }
        }
    }

    public static boolean a(cb cbVar, m mVar, String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            cbVar.fFA.fFG = j.eib;
            return false;
        } else if (mVar == null) {
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            cbVar.fFA.fFG = j.eic;
            return false;
        } else {
            alh a = ai.a(mVar, str);
            if (a == null) {
                w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                cbVar.fFA.fFG = j.eic;
                return false;
            }
            String df = i.df(mVar.field_snsId);
            df = String.format("%s#%s", new Object[]{df, str});
            rv rvVar = new rv();
            rw rwVar = new rw();
            rm rmVar = new rm();
            w.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[]{mVar.field_userName});
            rwVar.OD(mVar.field_userName);
            rwVar.OE(com.tencent.mm.u.m.xL());
            rwVar.yj(2);
            rwVar.ep(((long) mVar.field_createTime) * 1000);
            rwVar.OI(mVar.bhe());
            rwVar.OF(df);
            rmVar.Od(df);
            rmVar.NZ(am.du(ae.getAccSnsPath(), str) + i.l(a));
            if (mVar.bhd() != null) {
                rmVar.Ok(mVar.bhd().qsQ);
                if (!bg.mA(mVar.bhd().qsQ)) {
                    Map q = bh.q(mVar.bhd().qsQ, "adxml");
                    if (q.size() > 0) {
                        rmVar.NL(bg.ap((String) q.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        rmVar.NM(bg.ap((String) q.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            a(rmVar, mVar);
            df = am.du(ae.getAccSnsPath(), a.mQY) + i.e(a);
            if (FileOp.aO(rmVar.txG) || !mVar.field_userName.endsWith(ae.ber())) {
                if (FileOp.aO(df)) {
                    rmVar.Oa(df);
                } else {
                    rmVar.jK(true);
                    rmVar.NU(a.tPi);
                    sf sfVar = new sf();
                    sfVar.OT(a.tPi);
                    rvVar.b(sfVar);
                }
                rmVar.yb(2);
                rvVar.tzn.add(rmVar);
                rvVar.a(rwVar);
                cbVar.fFA.fFC = rvVar;
                cbVar.fFA.type = 2;
                return true;
            }
            w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            cbVar.fFA.fFG = j.eic;
            return false;
        }
    }

    private static void a(rm rmVar, bfc com_tencent_mm_protocal_c_bfc) {
        if (rmVar != null && com_tencent_mm_protocal_c_bfc != null && !bg.mA(com_tencent_mm_protocal_c_bfc.qui)) {
            rmVar.Oj(com_tencent_mm_protocal_c_bfc.qui);
        }
    }

    public static void a(rm rmVar, m mVar) {
        if (mVar != null) {
            a(rmVar, mVar.bhd());
        }
    }
}
