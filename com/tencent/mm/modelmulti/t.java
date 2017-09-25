package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class t {
    public static ArrayList<bu> hMN = new ArrayList();
    public static ArrayList<x> hMO = new ArrayList();

    public static void HC() {
        ap.yY();
        Cursor d = c.wR().d(null, null, new ArrayList());
        while (d.moveToNext()) {
            x xVar = new x();
            xVar.b(d);
            hMO.add(xVar);
        }
        d.close();
    }

    public static void jR(String str) {
        Throwable e;
        int i = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        i++;
                        String[] split = readLine.split("###");
                        if (split == null || split.length != 3) {
                            int i2;
                            String str2 = "MicroMsg.TestSyncAddMsg";
                            String str3 = "readMsgFromFile parse line %d failed : len:%d ";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i);
                            if (split == null) {
                                i2 = -1;
                            } else {
                                i2 = split.length;
                            }
                            objArr[1] = Integer.valueOf(i2);
                            w.e(str2, str3, objArr);
                        } else {
                            bu buVar = new bu();
                            buVar.tfe = new avx().OV(m.xL());
                            buVar.jNB = 2;
                            buVar.tfh = new avw().bb(new byte[0]);
                            buVar.mtd = bg.getInt(split[0], 0);
                            buVar.tfg = bg.getInt(split[1], 0);
                            buVar.tff = new avx().OV(split[2]);
                            hMN.add(buVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            try {
                w.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
                w.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            } catch (Throwable th) {
                e = th;
                try {
                    bufferedReader.close();
                } catch (Exception e6) {
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bufferedReader.close();
            throw e;
        }
    }

    public static void aP(final int i, final int i2) {
        ap.vL().D(new Runnable() {
            public final void run() {
                t.HC();
                t.jR(e.hgu + "/testaddmsg.txt");
                if (t.hMO.size() <= 0 || t.hMN.size() <= 0) {
                    w.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", Integer.valueOf(t.hMN.size()), Integer.valueOf(t.hMO.size()));
                    return;
                }
                new aj(ap.vL().nJF.getLooper(), new a(this) {
                    int hMR = i;
                    final /* synthetic */ AnonymousClass1 hMS;

                    {
                        this.hMS = r2;
                    }

                    public final boolean oQ() {
                        if (this.hMR <= 0) {
                            return false;
                        }
                        this.hMR--;
                        b bVar = new b();
                        bVar.tad.toe = new lv();
                        int dM = bg.dM(i2, 1);
                        for (int i = 0; i < dM; i++) {
                            bu buVar = (bu) t.hMN.get(bg.dM(t.hMN.size() - 1, 0));
                            buVar.tfd = new avx().OV(((x) t.hMO.get(bg.dM(t.hMO.size() - 1, 0))).field_username);
                            buVar.ogM = (int) bg.Ny();
                            buVar.tfk = (long) Math.abs(((int) bg.Nz()) % 10000000);
                            try {
                                lu luVar = new lu();
                                luVar.tsb = new avw();
                                luVar.tsb.bb(buVar.toByteArray());
                                luVar.tsa = 5;
                                bVar.tad.toe.jNe.add(luVar);
                                lv lvVar = bVar.tad.toe;
                                lvVar.jNd++;
                                w.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", Integer.valueOf(this.hMR), Integer.valueOf(i), Integer.valueOf(dM), Integer.valueOf(bVar.tad.toe.jNe.size()), Long.valueOf(buVar.tfk), buVar.tfd.tZr);
                            } catch (Throwable e) {
                                w.d("MicroMsg.TestSyncAddMsg", e.getMessage());
                                w.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                            }
                        }
                        bVar.tad.tlZ = 0;
                        anu com_tencent_mm_protocal_c_anu = bVar.tad;
                        ap.yY();
                        com_tencent_mm_protocal_c_anu.tob = n.G(bg.PT(bg.mz((String) c.vr().get(8195, new byte[0]))));
                        bVar.tad.thX = 0;
                        bVar.tad.jNB = 0;
                        q.Hy().a(bVar, 0, bg.Ny());
                        return true;
                    }
                }, true).v(3000, 3000);
            }
        });
    }
}
