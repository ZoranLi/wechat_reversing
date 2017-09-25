package com.tencent.mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import com.tencent.mm.bc.d;
import com.tencent.mm.booter.g;
import com.tencent.mm.booter.h;
import com.tencent.mm.booter.i;
import com.tencent.mm.booter.k;
import com.tencent.mm.booter.l;
import com.tencent.mm.booter.n;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.e.a.na;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.modelstat.f;
import com.tencent.mm.modelstat.j;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.o;
import java.util.List;

public final class m extends c<lc> {
    public m() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long Ny;
        long c;
        if (a.hlU != null) {
            a.hlU.yJ();
        }
        Object obj = (ap.zb() && !ap.uP() && (com.tencent.mm.u.m.xW() & 16) == 0) ? 1 : null;
        if (obj != null && h.qf()) {
            alg com_tencent_mm_protocal_c_alg;
            ap.yY();
            t vr = com.tencent.mm.u.c.vr();
            int f = u.f((Integer) vr.get(67073, null));
            int f2 = u.f((Integer) vr.get(67074, null));
            int f3 = u.f((Integer) vr.get(67075, null));
            int f4 = u.f((Integer) vr.get(67076, null));
            ap.yY();
            com.tencent.mm.plugin.messenger.foundation.a.a.c wT = com.tencent.mm.u.c.wT();
            int bl = wT.bl("medianote", 1);
            int bl2 = wT.bl("medianote", 3);
            int bl3 = wT.bl("medianote", 34);
            int bl4 = wT.bl("medianote", 43);
            if (bl - f > 0) {
                alg com_tencent_mm_protocal_c_alg2 = new alg();
                com_tencent_mm_protocal_c_alg2.tPf = bl - f;
                com_tencent_mm_protocal_c_alg2.tPg = 1;
                vr.set(67073, Integer.valueOf(bl));
            }
            if (bl2 - f2 > 0) {
                com_tencent_mm_protocal_c_alg = new alg();
                com_tencent_mm_protocal_c_alg.tPf = bl2 - f2;
                com_tencent_mm_protocal_c_alg.tPg = 3;
                vr.set(67074, Integer.valueOf(bl2));
            }
            if (bl3 - f3 > 0) {
                com_tencent_mm_protocal_c_alg = new alg();
                com_tencent_mm_protocal_c_alg.tPf = bl3 - f3;
                com_tencent_mm_protocal_c_alg.tPg = 34;
                vr.set(67075, Integer.valueOf(bl3));
            }
            if (bl4 - f4 > 0) {
                com_tencent_mm_protocal_c_alg = new alg();
                com_tencent_mm_protocal_c_alg.tPf = bl4 - f4;
                com_tencent_mm_protocal_c_alg.tPg = 43;
                vr.set(67076, Integer.valueOf(bl4));
            }
            ap.yY();
            com.tencent.mm.u.c.vr().set(66817, Long.valueOf(u.Ny()));
        }
        com.tencent.mm.bc.a.run();
        ap.yY();
        boolean a = u.a((Boolean) com.tencent.mm.u.c.vr().get(67841, null));
        if (!(com.tencent.mm.modelfriend.m.Fl() == com.tencent.mm.modelfriend.m.a.SUCC || com.tencent.mm.modelfriend.m.Fl() == com.tencent.mm.modelfriend.m.a.SUCC_UNLOAD)) {
            a = false;
        }
        if (a) {
            w.d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List jb = af.FY().jb("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + bg.my("") + "\" )");
            w.d("MicroMsg.PostTaskUpdateCtRemark", "list " + jb.size());
            for (int i = 0; i < jb.size(); i++) {
                String username = ((com.tencent.mm.modelfriend.b) jb.get(i)).getUsername();
                String trim = ((com.tencent.mm.modelfriend.b) jb.get(i)).ER().trim();
                if (!(username == null || username.equals("") || trim == null || trim.equals(""))) {
                    ap.yY();
                    com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(username);
                    if (com.tencent.mm.j.a.ez(Rc.field_type) && (Rc.field_conRemark == null || Rc.field_conRemark.equals(""))) {
                        w.d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        o.b(Rc, trim);
                    }
                }
            }
            ap.yY();
            com.tencent.mm.u.c.vr().set(67841, Boolean.valueOf(false));
        }
        w.d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
        bm.zN().zO();
        i.run();
        if (d.qf()) {
            d.bGW();
        }
        n.run();
        g.run();
        if (ap.zb() && !ap.uP()) {
            if (bg.mA(com.tencent.mm.bc.c.bGV())) {
                ba.gp("ver" + com.tencent.mm.protocal.d.sYN);
            } else {
                ap.yY();
                if (bg.az(bg.a((Long) com.tencent.mm.u.c.vr().get(77833, null), 0)) * 1000 >= 604800000) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10719, com.tencent.mm.bc.c.bGR(), com.tencent.mm.bc.c.bGS(), com.tencent.mm.bc.c.bGT(), com.tencent.mm.bc.c.getRomInfo(), com.tencent.mm.bc.c.bGU(), "", com.tencent.mm.bc.c.bGV());
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(77833, Long.valueOf(bg.Ny()));
                    w.d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                }
            }
        }
        if (ap.zb() && !ap.uP()) {
            Ny = bg.Ny();
            ap.yY();
            if (bg.a((Long) com.tencent.mm.u.c.vr().get(331777, null), 0) < Ny) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(331777, Long.valueOf(Ny + 259200));
                com.tencent.mm.plugin.report.b.d.aXy();
            }
            com.tencent.mm.plugin.report.b.d.o(3, 0, "");
        }
        com.tencent.mm.bc.b.run();
        if (ap.zb()) {
            ap.yY();
            c = bg.c((Long) com.tencent.mm.u.c.vr().get(74, null));
            if (10010 == r.iiW && r.iiX > 0) {
                c = bg.Ny() - ((long) r.iiX);
                w.d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", Integer.valueOf(r.iiX), Long.valueOf(c));
                r.iiX = 0;
            }
            Ny = bg.Ny();
            w.d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", Long.valueOf(Ny), Long.valueOf(c), Long.valueOf(Ny - c));
            if ((Ny - c) * 1000 >= 86400000) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(74, Long.valueOf(Ny));
                if (p.Kh() == null) {
                    w.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                } else {
                    Ny = (bg.Nz() / 86400000) - 1;
                    j gE = p.Kh().gE((int) Ny);
                    if (gE == null || gE.hWl != ((int) Ny)) {
                        String str = "MicroMsg.PostTaskReportDataFlow";
                        String str2 = "ERR: NetStatInfo:%d lastDate:%d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(gE == null ? -1 : gE.hWl);
                        objArr[1] = Long.valueOf(Ny);
                        w.e(str, str2, objArr);
                    } else if (p.Kf() == null) {
                        w.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                    } else {
                        f.a JZ = p.Kf().JZ();
                        if (JZ == null) {
                            w.w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                            JZ = new f.a();
                        }
                        w.i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", Long.valueOf(Ny), Integer.valueOf(gE.hWl), Integer.valueOf(gE.hWx), Integer.valueOf(gE.hWJ), Integer.valueOf(gE.hWw), Integer.valueOf(gE.hWI), Integer.valueOf(gE.hWv), Integer.valueOf(gE.hWH), Integer.valueOf(gE.hWu), Integer.valueOf(gE.hWG), Integer.valueOf(JZ.hWf), Integer.valueOf(JZ.fEC), JZ.ispName, JZ.extraInfo);
                        com.tencent.mm.plugin.report.service.g.oUh.i(10900, Long.valueOf((Ny * 86400000) / 1000), Integer.valueOf(gE.hWx), Integer.valueOf(gE.hWJ), Integer.valueOf(gE.hWw), Integer.valueOf(gE.hWI), Integer.valueOf(gE.hWv), Integer.valueOf(gE.hWH), Integer.valueOf(gE.hWu), Integer.valueOf(gE.hWG), Integer.valueOf(JZ.hWf), Integer.valueOf(JZ.fEC), JZ.ispName, JZ.extraInfo);
                    }
                }
            }
        } else {
            w.e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
        }
        al.run();
        ap.yY();
        if ((u.aA(u.c((Long) com.tencent.mm.u.c.vr().get(282881, null))) > 172800000 ? 1 : null) != null) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(282881, Long.valueOf(u.Nz()));
            com.tencent.mm.sdk.b.a.urY.m(new na());
        }
        if (ap.zb() && !ap.uP()) {
            Ny = bg.Ny();
            ap.yY();
            if (bg.a((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, null), 0) < Ny) {
                c = 604800 + Ny;
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, Long.valueOf(c));
                obj = com.tencent.mm.u.m.xL();
                if (!TextUtils.isEmpty(obj)) {
                    ap.vd().a(new com.tencent.mm.modelsimple.r(obj), 0);
                }
            }
        }
        if (ap.zb() && !ap.uP()) {
            Ny = bg.Ny();
            ap.yY();
            if (bg.a((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, null), 0) < Ny) {
                c = (bg.bJU() / 1000) + 86400;
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, Long.valueOf(c));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    if (defaultAdapter.getState() == 12) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(11921, Integer.valueOf(1));
                    } else if (defaultAdapter.getState() == 10) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(11921, Integer.valueOf(0));
                    }
                }
            }
        }
        k.run();
        l.run();
        com.tencent.mm.booter.m.run();
        com.tencent.mm.booter.j.run();
        return false;
    }
}
