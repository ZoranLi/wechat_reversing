package com.tencent.mm.plugin.sns.a.a;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.bd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.bbi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i implements e {
    public static int pPA = 20480;
    public static int pPB = 30720;
    public static int pPC = 51200;
    public static int pPD = 60;
    public static int pPE = 1800;
    public static int pPF = 43200;
    public long pPG = 0;
    public bbi pPH = new bbi();
    public boolean pPI = false;
    long pPJ = 0;
    int pPK = 0;
    int pPz = 0;
    private Random random = new Random(System.currentTimeMillis());

    public final void i(final int i, final Object... objArr) {
        ae.bey().post(new Runnable(this) {
            final /* synthetic */ i pPN;

            public final void run() {
                aig com_tencent_mm_protocal_c_aig = new aig();
                com_tencent_mm_protocal_c_aig.tMh = i;
                com_tencent_mm_protocal_c_aig.tMp = (int) (System.currentTimeMillis() / 1000);
                com_tencent_mm_protocal_c_aig.jNd = 1;
                String k = i.k(objArr);
                com_tencent_mm_protocal_c_aig.tMi = new b(k.getBytes());
                this.pPN.pPH.teH.add(com_tencent_mm_protocal_c_aig);
                w.i("MicroMsg.SnsLogMgr", "snsadlog " + i + " " + k);
                if (this.pPN.pPG == 0) {
                    this.pPN.pPG = System.currentTimeMillis();
                }
            }
        });
        if (!this.pPI) {
            this.pPI = true;
            ae.bey().postDelayed(new Runnable(this) {
                final /* synthetic */ i pPN;

                {
                    this.pPN = r1;
                }

                public final void run() {
                    this.pPN.pPI = false;
                    this.pPN.bdq();
                }
            }, 2000);
        }
    }

    public final void bdq() {
        if (ae.pVr) {
            h.vJ();
            int intValue = ((Integer) h.vI().vr().get(a.uBv, Integer.valueOf(0))).intValue();
            h.vJ();
            int intValue2 = ((Integer) h.vI().vr().get(a.uBu, Integer.valueOf(-1))).intValue();
            if (intValue2 > pPF || intValue2 < 0) {
                intValue2 = this.random.nextInt((pPE - pPD) + 1) + pPD;
            }
            if ((System.currentTimeMillis() / 1000) - ((long) intValue) > ((long) intValue2)) {
                intValue2 = 1;
            } else {
                intValue2 = 0;
            }
            if (intValue2 == 0) {
                bdr();
                w.d("MicroMsg.SnsLogMgr", "pass report ");
                return;
            }
            p beE = ae.beE();
            String str = "select rowid from SnsReportKv order by rowid desc  limit 1";
            w.i("MicroMsg.SnsKvReportStg", " getLast " + str);
            Cursor a = beE.hnH.a(str, null, 2);
            if (a.moveToFirst()) {
                intValue2 = a.getInt(0);
            } else {
                intValue2 = 0;
            }
            a.close();
            this.pPz = intValue2;
            bds();
            bdr();
        }
    }

    private void bdr() {
        ae.bey().post(new Runnable(this) {
            final /* synthetic */ i pPN;

            {
                this.pPN = r1;
            }

            public final void run() {
                if (System.currentTimeMillis() - this.pPN.pPG >= 60000 || this.pPN.pPH.teH.size() > 1000) {
                    if (this.pPN.pPH != null && this.pPN.pPH.teH.size() > 0) {
                        this.pPN.bdt();
                    }
                    this.pPN.pPG = 0;
                }
            }
        });
    }

    private void bds() {
        ae.bey().post(new Runnable(this) {
            final /* synthetic */ i pPN;

            {
                this.pPN = r1;
            }

            public final void run() {
                int i;
                String str;
                int i2;
                i iVar = this.pPN;
                if (bg.aB(iVar.pPJ) >= 100 || iVar.pPK <= 0) {
                    iVar.pPK = i.pPA;
                    if (am.isWifi(ab.getContext())) {
                        iVar.pPK = i.pPC;
                    }
                    if (am.is3G(ab.getContext()) || am.is4G(ab.getContext())) {
                        iVar.pPK = i.pPB;
                    }
                    if (am.is2G(ab.getContext())) {
                        iVar.pPK = i.pPA;
                    }
                    iVar.pPJ = SystemClock.elapsedRealtime();
                    i = iVar.pPK;
                } else {
                    i = iVar.pPK;
                }
                List linkedList = new LinkedList();
                bbi cX = ae.beE().cX(i, iVar.pPz);
                aig com_tencent_mm_protocal_c_aig;
                if (cX.teH.size() == 0) {
                    str = "read from memery";
                    i2 = 0;
                    while (iVar.pPH.teH.size() > 0) {
                        com_tencent_mm_protocal_c_aig = (aig) iVar.pPH.teH.remove();
                        if (com_tencent_mm_protocal_c_aig.tMi.sYA.length + i2 >= i) {
                            break;
                        }
                        i2 += com_tencent_mm_protocal_c_aig.tMi.sYA.length;
                        linkedList.add(com_tencent_mm_protocal_c_aig);
                    }
                } else {
                    str = "read from db";
                    i2 = 0;
                    while (cX.teH.size() > 0) {
                        com_tencent_mm_protocal_c_aig = (aig) cX.teH.remove();
                        linkedList.add(com_tencent_mm_protocal_c_aig);
                        i2 = com_tencent_mm_protocal_c_aig.tMi.sYA.length + i2;
                    }
                }
                String str2 = str;
                if (linkedList.size() == 0) {
                    w.i("MicroMsg.SnsLogMgr", "nothing for report");
                    return;
                }
                w.i("MicroMsg.SnsLogMgr", "size " + i2 + " " + linkedList.size() + " " + i + " logItemList.LogList.size  " + iVar.pPH.teH.size() + " label:  " + str2);
                k eVar = new e(linkedList);
                h.vJ();
                h.vH().gXC.a(eVar, 0);
            }
        });
    }

    public static String k(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            w.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        return stringBuilder.toString();
    }

    public final void bdt() {
        if (this.pPH.teH.size() > 0) {
            w.i("MicroMsg.SnsLogMgr", "trigerSave " + this.pPH.teH.size());
            ae.beE().a(this.pPH);
            this.pPH.teH.clear();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1802 && (kVar instanceof e)) {
            e eVar = (e) kVar;
            if (i == 0 && i2 == 0) {
                h.vJ();
                h.vI().vr().a(a.uBv, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                bds();
                return;
            }
            List<aig> list = eVar.pOW;
            p beE = ae.beE();
            bbi com_tencent_mm_protocal_c_bbi = new bbi();
            for (aig add : list) {
                com_tencent_mm_protocal_c_bbi.teH.add(add);
            }
            beE.a(com_tencent_mm_protocal_c_bbi);
        }
    }
}
