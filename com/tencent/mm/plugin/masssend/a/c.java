package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private LinkedList<d> nwX;

    public final void aJp() {
        a aVar = null;
        boolean aJr = aJr();
        ap.yY();
        boolean booleanValue = ((Boolean) com.tencent.mm.u.c.vr().get(102408, Boolean.valueOf(false))).booleanValue();
        boolean z = (m.xW() & 65536) == 0;
        w.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[]{Boolean.valueOf(booleanValue)});
        if (z && !booleanValue && aJr) {
            w.d("MicroMsg.MassSendService", "set top conversation");
            ap.yY();
            if (com.tencent.mm.u.c.wW().Rm("masssendapp") == null) {
                ap.yY();
                if (com.tencent.mm.u.c.wW().Rm("masssendapp") == null) {
                    ae aeVar = new ae();
                    aeVar.setUsername("masssendapp");
                    aeVar.setContent(ab.getContext().getResources().getString(R.l.dYJ));
                    aeVar.s(bg.Nz() + 2000);
                    aeVar.dw(0);
                    aeVar.dt(0);
                    ap.yY();
                    com.tencent.mm.u.c.wW().d(aeVar);
                }
            } else {
                String string;
                Cursor a = h.aJt().hnH.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
                if (a != null) {
                    a aVar2;
                    if (a.moveToFirst()) {
                        aVar2 = new a();
                        aVar2.b(a);
                    } else {
                        aVar2 = null;
                    }
                    a.close();
                    aVar = aVar2;
                }
                if (aVar == null) {
                    string = ab.getContext().getResources().getString(R.l.dYJ);
                } else {
                    h.aJt();
                    string = b.a(aVar);
                }
                ae aeVar2 = new ae();
                aeVar2.setUsername("masssendapp");
                aeVar2.setContent(string);
                aeVar2.s(bg.Nz() + 2000);
                aeVar2.dw(0);
                aeVar2.dt(0);
                ap.yY();
                com.tencent.mm.u.c.wW().a(aeVar2, "masssendapp");
            }
            g.oUh.A(10425, "");
            ap.yY();
            com.tencent.mm.u.c.vr().set(102409, Long.valueOf(bg.Nz()));
            ap.yY();
            com.tencent.mm.u.c.vr().set(102408, Boolean.valueOf(true));
        } else if (!aJr) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(102408, Boolean.valueOf(false));
        }
    }

    public static void cz(long j) {
        ap.yY();
        com.tencent.mm.u.c.vr().set(102409, Long.valueOf(j));
    }

    private static String aJq() {
        if (!ap.zb()) {
            return "";
        }
        r1 = new Object[2];
        ap.yY();
        r1[0] = com.tencent.mm.u.c.xu();
        r1[1] = v.bIN();
        w.d("MicroMsg.MassSendService", "config file path is %s", new Object[]{String.format("%s/masssend_%s.ini", r1)});
        return String.format("%s/masssend_%s.ini", r1);
    }

    private boolean aJr() {
        if (this.nwX == null) {
            String aJq = aJq();
            byte[] d = e.d(aJq, 0, -1);
            if (d == null) {
                return false;
            }
            try {
                this.nwX = ((e) new e().aD(d)).nwY;
            } catch (Exception e) {
                b.deleteFile(aJq);
                return false;
            }
        }
        if (this.nwX == null) {
            w.w("MicroMsg.MassSendService", "info list is empty");
            return false;
        }
        w.i("MicroMsg.MassSendService", "info list[%s]", new Object[]{this.nwX.toString()});
        long Ny = bg.Ny();
        Iterator it = this.nwX.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (((long) dVar.fuQ) <= Ny && Ny <= ((long) dVar.end)) {
                return true;
            }
        }
        return false;
    }

    public final void zU(String str) {
        if (!bg.mA(str)) {
            Map q = bh.q(str, "Festivals");
            if (q != null) {
                e eVar = new e();
                int i = 0;
                while (true) {
                    String str2 = ".Festivals.Festival" + (i == 0 ? "" : String.valueOf(i));
                    if (!q.containsKey(str2)) {
                        break;
                    }
                    d dVar = new d();
                    dVar.fuQ = bg.PP((String) q.get(str2 + ".StartTime"));
                    dVar.end = bg.PP((String) q.get(str2 + ".EndTime")) + Downloads.MAX_RETYR_AFTER;
                    eVar.nwY.add(dVar);
                    i++;
                }
                eVar.count = eVar.nwY.size();
                this.nwX = eVar.nwY;
                try {
                    byte[] toByteArray = eVar.toByteArray();
                    String aJq = aJq();
                    if (bg.mA(aJq)) {
                        w.w("MicroMsg.MassSendService", "mass send config file path is null, return");
                        return;
                    }
                    File file = new File(aJq);
                    if (file.exists()) {
                        int i2;
                        if (com.tencent.mm.a.g.f(file).equals(com.tencent.mm.a.g.n(toByteArray))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(102408, Boolean.valueOf(false));
                        }
                    } else {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(102408, Boolean.valueOf(false));
                    }
                    w.d("MicroMsg.MassSendService", "save to config file : %s", new Object[]{eVar.toString()});
                    e.b(aJq, toByteArray, toByteArray.length);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MassSendService", e, "", new Object[0]);
                }
            }
        }
    }
}
