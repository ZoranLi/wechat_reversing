package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.og;
import com.tencent.mm.e.a.z;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.b;
import com.tencent.mm.u.c;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class a extends com.tencent.mm.plugin.backup.a.a {
    public static String TAG = "MicroMsg.BackupTempDbModel";
    private static a jIb;
    public static int jIe = 0;
    private c jIc;
    private b jId;

    public static class a implements Runnable {
        public long dbSize = 0;
        public boolean jIp = true;
        public long jIq = 0;
        public long jIr = 0;

        public void run() {
        }
    }

    public static a abC() {
        if (jIb == null) {
            com.tencent.mm.plugin.backup.a.a aVar = new a();
            jIb = aVar;
            com.tencent.mm.plugin.backup.a.a.a(aVar);
        }
        return jIb;
    }

    public final void ZY() {
        jIb = null;
    }

    public final c abD() {
        if (this.jIc == null) {
            this.jIc = new c();
        }
        return this.jIc;
    }

    public final b abE() {
        if (this.jId == null) {
            this.jId = new b();
        }
        return this.jId;
    }

    public final void abF() {
        w.i(TAG, "backupInitTempDb");
        c abD = abD();
        ap.yY();
        String xv = c.xv();
        ap.yY();
        String xu = c.xu();
        ap.yY();
        abD.k(xv, xu, c.uH());
        abD = abD();
        ap.yY();
        w.i("MicroMsg.TempStorage", "setDataDB isTempDb:%s db:%s %s", new Object[]{abD.jIK, c.wO(), bg.bJZ()});
        abD.jIK = Boolean.valueOf(false);
        abD.gYg = r1;
        abD.abJ();
    }

    public final void a(a aVar, boolean z, int i) {
        final long Nz = bg.Nz();
        w.i(TAG, "initTempDB needSyncPauser:%b %s", new Object[]{Boolean.valueOf(z), bg.bJZ()});
        final a aVar2 = aVar;
        final int i2 = i;
        af.f(new Runnable(this) {
            final /* synthetic */ a jIh;

            public final void run() {
                a.abI();
                w.i(a.TAG, "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[]{Integer.valueOf(a.jIe), Long.valueOf(bg.aA(Nz))});
                a.jIe++;
                ap.vL().a(new com.tencent.mm.sdk.platformtools.af.a(this) {
                    final /* synthetic */ AnonymousClass1 jIi;

                    {
                        this.jIi = r1;
                    }

                    public final boolean Bo() {
                        w.i(a.TAG, "initTempDB onPostExecute");
                        aVar2.run();
                        a.jIe--;
                        return false;
                    }

                    public final boolean Bn() {
                        a.abH();
                        this.jIi.jIh.a(new PLong(), new PLong(), new PLong(), aVar2, i2);
                        return true;
                    }

                    public final String toString() {
                        return super.toString() + "|initTempDB";
                    }
                });
            }
        }, 1000);
    }

    public final boolean a(PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i) {
        ap.yY();
        c.wL();
        w.d(TAG, "initTempDBimp after close db");
        ap.yY();
        int aN = e.aN(c.vo());
        ap.yY();
        pLong3.value = (long) (aN + e.aN(c.vp()));
        long j = pLong3.value;
        ap.yY();
        if (h.a(j, pLong, pLong2, c.xv())) {
            ap.yY();
            String vo = c.vo();
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            j.p(vo, stringBuilder.append(c.vo()).append(".tem").toString(), false);
            ap.yY();
            vo = c.vp();
            stringBuilder = new StringBuilder();
            ap.yY();
            j.p(vo, stringBuilder.append(c.vp()).append(".tem").toString(), false);
            w.i(TAG, "initTempDBimp before resetAccUin");
            com.tencent.mm.kernel.h.vG().release();
            com.tencent.mm.kernel.h.vG().initialize();
            w.i(TAG, "initTempDBimp before closeDB");
            w.i(TAG, "initTempDBimp before TemAccStg setAccInfo");
            c abD = abD();
            ap.yY();
            String xv = c.xv();
            ap.yY();
            String xu = c.xu();
            ap.yY();
            abD.k(xv, xu, c.uH());
            w.i(TAG, "initTempDBimp before TemAccStg initDB");
            c abD2 = abD();
            StringBuilder stringBuilder2 = new StringBuilder();
            ap.yY();
            xv = stringBuilder2.append(c.vo()).append(".tem").toString();
            ap.yY();
            int uH = c.uH();
            stringBuilder2 = new StringBuilder();
            ap.yY();
            w.i("MicroMsg.TempStorage", "initDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[]{abD2.jIK, xv, Integer.valueOf(uH), stringBuilder2.append(c.vp()).append(".tem").toString(), bg.bJZ()});
            if (i > 0) {
                if (!(abD2.jIK == null || abD2.jIK.booleanValue())) {
                    w.e("MicroMsg.TempStorage", "initDB isTempDB is false!!!");
                    abD2.wL();
                }
                Assert.assertTrue("initDB here  isTempDb should null :" + abD2.jIK, abD2.jIK == null);
            }
            abD2.jIK = Boolean.valueOf(true);
            abD2.gYg = new g(new com.tencent.mm.bj.g.a(abD2) {
                final /* synthetic */ c jIL;

                {
                    this.jIL = r1;
                }

                public final void vy() {
                    if (this.jIL.jIJ != null) {
                        f fVar = this.jIL.jIJ;
                        for (Object obj : fVar.uLU.keySet()) {
                            ((com.tencent.mm.bj.h) fVar.uLU.get(obj)).bNO();
                        }
                    }
                }

                public final void vz() {
                }

                public final void vA() {
                    if (this.jIL.jIJ != null) {
                        f fVar = this.jIL.jIJ;
                        if (fVar.uLV.size() != 0) {
                            w.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", new Object[]{"stg_null", Integer.valueOf(fVar.uLV.size())});
                            if (fVar.uLy == null) {
                                w.e("MicroMsg.MemoryStorage", "attachTable db is null");
                            } else if (fVar.uLS.inTransaction()) {
                                w.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", new Object[]{Integer.valueOf(fVar.uLV.size())});
                            } else {
                                while (fVar.uLV.size() > 0) {
                                    if (fVar.uLS.inTransaction()) {
                                        w.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", new Object[]{Integer.valueOf(fVar.uLV.size())});
                                        return;
                                    }
                                    a aVar = (a) fVar.uLV.peek();
                                    if (aVar == null) {
                                        fVar.uLV.poll();
                                    } else {
                                        String tableName = aVar.getTableName();
                                        if (bg.mA(tableName)) {
                                            w.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", new Object[]{tableName});
                                            fVar.uLV.poll();
                                        } else if (com.tencent.mm.bj.e.a(fVar.uLy, tableName)) {
                                            w.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", new Object[]{tableName});
                                            fVar.uLV.poll();
                                        } else {
                                            if (fVar.St(tableName) != 0) {
                                                try {
                                                    if (fVar.sDZ) {
                                                        fVar.uLy.execSQL("DETACH DATABASE old");
                                                        w.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                                                        fVar.sDZ = false;
                                                    }
                                                    if (bg.mA(fVar.uLS.getKey())) {
                                                        fVar.uLy.execSQL("ATTACH DATABASE '" + fVar.uLS.getPath() + "' AS old ");
                                                    } else {
                                                        fVar.uLy.execSQL("ATTACH DATABASE '" + fVar.uLS.getPath() + "' AS old KEY '" + fVar.uLS.getKey() + "'");
                                                    }
                                                    w.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                                                    fVar.sDZ = true;
                                                } catch (Throwable e) {
                                                    fVar.sDZ = false;
                                                    w.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", new Object[]{e.getMessage()});
                                                    w.e("MicroMsg.MemoryStorage", "exception:%s", new Object[]{bg.g(e)});
                                                }
                                                if (fVar.St(tableName) != 0) {
                                                    w.e("MicroMsg.MemoryStorage", "copy table failed :" + tableName);
                                                    return;
                                                }
                                            }
                                            w.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", new Object[]{tableName, Integer.valueOf(fVar.uLV.size()), Integer.valueOf(fVar.uLU.size())});
                                            fVar.uLU.put(tableName, new com.tencent.mm.bj.h(fVar.uLS, tableName));
                                            aVar.a(fVar);
                                            fVar.uLV.poll();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });
            if (abD2.gYg.a(xv, xu, "", (long) uH, p.rA(), new HashMap(), false)) {
                abD2.abJ();
                w.i(TAG, "initTempDBimp after TemAccStg initDB");
                yX();
                aVar.jIp = true;
                aVar.jIq = pLong.value;
                aVar.jIr = pLong2.value;
                aVar.dbSize = pLong3.value;
                h.rz(h.aan());
                return true;
            }
            throw new b((byte) 0);
        }
        w.e(TAG, "data free error, len %d", new Object[]{Long.valueOf(pLong3.value)});
        aVar.jIp = false;
        aVar.jIq = pLong.value;
        aVar.jIr = pLong2.value;
        aVar.dbSize = pLong3.value;
        return false;
    }

    public final void n(final Runnable runnable) {
        a(new Runnable(this) {
            final /* synthetic */ a jIh;

            public final void run() {
                w.i(a.TAG, "recoverFromTempDB closeTempDB ok");
                w.bIP();
                ap.vL().a(new com.tencent.mm.sdk.platformtools.af.a(this) {
                    final /* synthetic */ AnonymousClass2 jIk;

                    {
                        this.jIk = r1;
                    }

                    public final boolean Bo() {
                        runnable.run();
                        com.tencent.mm.sdk.b.a.urY.m(new og());
                        return false;
                    }

                    public final boolean Bn() {
                        w.i(a.TAG, "doInBackground start");
                        w.bIP();
                        a.abG();
                        e.d(new File(h.aan()));
                        b abE = this.jIk.jIh.abE();
                        abE.handler.post(new Runnable(abE) {
                            final /* synthetic */ b jIu;

                            {
                                this.jIu = r1;
                            }

                            public final void run() {
                                Iterator it = this.jIu.jIs.iterator();
                                while (it.hasNext()) {
                                    a aVar = (a) it.next();
                                    if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                                        String str = (String) aVar.obj;
                                        w.d("MicroMsg.RecoverDelayData", "getContact" + str);
                                        com.tencent.mm.u.ag.a.hlS.J(str, "");
                                    } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                                        an.aRq().Mc((String) aVar.obj);
                                    }
                                }
                                this.jIu.jIs.clear();
                            }
                        });
                        w.i(a.TAG, "doInBackground end");
                        w.bIP();
                        return true;
                    }

                    public final String toString() {
                        return super.toString() + "|recoverFromTempDB";
                    }
                });
            }
        }, 10);
    }

    public static void abG() {
        long Nz = bg.Nz();
        ap.yY();
        c.wL();
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        String stringBuilder2 = stringBuilder.append(c.vo()).append(".tem").toString();
        ap.yY();
        j.p(stringBuilder2, c.vo(), false);
        stringBuilder = new StringBuilder();
        ap.yY();
        stringBuilder2 = stringBuilder.append(c.vp()).append(".tem").toString();
        ap.yY();
        j.p(stringBuilder2, c.vp(), false);
        com.tencent.mm.kernel.h.vG().release();
        com.tencent.mm.kernel.h.vG().initialize();
        abH();
        yX();
        w.i(TAG, "recoverFromTempDBImp finish :%d", new Object[]{Long.valueOf(bg.aA(Nz))});
    }

    public final void o(final Runnable runnable) {
        w.i(TAG, "backupCloseTempDb");
        a(new Runnable(this) {
            final /* synthetic */ a jIh;

            public final void run() {
                w.i(a.TAG, "backupFromTempDB closeTempDB ok");
                w.bIP();
                ap.vL().a(new com.tencent.mm.sdk.platformtools.af.a(this) {
                    final /* synthetic */ AnonymousClass3 jIm;

                    {
                        this.jIm = r1;
                    }

                    public final boolean Bo() {
                        runnable.run();
                        return false;
                    }

                    public final boolean Bn() {
                        w.i(a.TAG, "doInBackground.");
                        a.abH();
                        return true;
                    }

                    public final String toString() {
                        return super.toString() + "|backupcloseTempDB";
                    }
                });
            }
        }, 10);
    }

    public final void a(final Runnable runnable, final int i) {
        if (i < 0 || jIe == 0) {
            if (i < 0) {
                w.e(TAG, "closeTempDB no left tryCount!!");
            }
            w.i(TAG, "closeDB before");
            abD().wL();
            w.i(TAG, "closeDB after");
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        new ae(Looper.getMainLooper()).postDelayed(new Runnable(this) {
            final /* synthetic */ a jIh;

            public final void run() {
                this.jIh.a(runnable, i - 1);
            }
        }, 500);
    }

    public static void abH() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.vo()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        ap.yY();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.vo()).append(".ini.tem").toString());
        stringBuilder = new StringBuilder();
        ap.yY();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.vp()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        ap.yY();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.vp()).append(".ini.tem").toString());
    }

    public static boolean abI() {
        com.tencent.mm.kernel.h.vG().uQ();
        return true;
    }

    private static void yX() {
        com.tencent.mm.sdk.b.a.urY.m(new z());
    }
}
