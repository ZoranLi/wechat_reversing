package com.tencent.mm.plugin.search.a;

import com.tencent.mm.a.e;
import com.tencent.mm.ap.t;
import com.tencent.mm.as.d;
import com.tencent.mm.e.a.az;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.ns;
import com.tencent.mm.e.a.ra;
import com.tencent.mm.plugin.fts.d.g;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.search.ui.b.f;
import com.tencent.mm.plugin.search.ui.b.i;
import com.tencent.mm.plugin.search.ui.b.j;
import com.tencent.mm.plugin.search.ui.b.k;
import com.tencent.mm.plugin.search.ui.b.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class c implements am {
    private com.tencent.mm.sdk.b.c irS = new com.tencent.mm.sdk.b.c<bb>(this) {
        final /* synthetic */ c peF;

        {
            this.peF = r2;
            this.usg = bb.class.getName().hashCode();
        }

        private static boolean a(bb bbVar) {
            InputStream fileInputStream;
            Throwable e;
            if ((bbVar instanceof bb) && bbVar.fEA.fEB == 27 && bbVar.fEA.fEC == 1) {
                File file = new File(bbVar.fEA.filePath);
                if (file.exists()) {
                    int intValue;
                    w.i("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(d.Ij(), "temp");
                    File file3 = new File(file2, "fts_template.zip");
                    file2.mkdirs();
                    e.p(file.getAbsolutePath(), file3.getAbsolutePath());
                    if (bg.eA(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0) {
                        Properties properties = new Properties();
                        try {
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                properties.load(fileInputStream);
                                e.b(fileInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    w.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                    e.b(fileInputStream);
                                    intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                    e.d(file2);
                                    w.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(d.hPo), Integer.valueOf(intValue)});
                                    c.k(file);
                                    return false;
                                } catch (Throwable th) {
                                    e = th;
                                    e.b(fileInputStream);
                                    throw e;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream = null;
                            w.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                            e.b(fileInputStream);
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                            e.d(file2);
                            w.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(d.hPo), Integer.valueOf(intValue)});
                            c.k(file);
                            return false;
                        } catch (Throwable th2) {
                            e = th2;
                            fileInputStream = null;
                            e.b(fileInputStream);
                            throw e;
                        }
                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                    } else {
                        intValue = 1;
                    }
                    e.d(file2);
                    w.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(d.hPo), Integer.valueOf(intValue)});
                    c.k(file);
                } else {
                    w.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                }
            }
            return false;
        }
    };
    private long peC;
    private m peD = new m(this) {
        final /* synthetic */ c peF;

        {
            this.peF = r1;
        }

        public final void b(String str, Map<String, String> map) {
            if (map != null && str != null && str.equals("mmsearch_reddot")) {
                int PY = bg.PY((String) map.get(".sysmsg.mmsearch_reddot.msgid"));
                int PY2 = bg.PY((String) map.get(".sysmsg.mmsearch_reddot.discovery"));
                int PY3 = bg.PY((String) map.get(".sysmsg.mmsearch_reddot.entrance"));
                int PY4 = bg.PY((String) map.get(".sysmsg.mmsearch_reddot.expire_time"));
                int PY5 = bg.PY((String) map.get(".sysmsg.mmsearch_reddot.h5_template_version"));
                com.tencent.mm.as.m Iw = com.tencent.mm.as.m.Iw();
                String str2 = "SearchRedPointMgr";
                String str3 = "recv msg id %d,discovery %d, entrance %d, ttlSec %d, h5TemplateVersion %d, curr %s,curr id %d";
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(PY);
                objArr[1] = Integer.valueOf(PY2);
                objArr[2] = Integer.valueOf(PY3);
                objArr[3] = Integer.valueOf(PY4);
                objArr[4] = Integer.valueOf(PY5);
                objArr[5] = Iw.hQm == null ? "" : Iw.hQm.Ix();
                objArr[6] = Integer.valueOf(Iw.hQl);
                w.i(str2, str3, objArr);
                if (PY > Iw.hQl) {
                    if (Iw.hQm == null) {
                        Iw.hQm = new com.tencent.mm.as.m.a(Iw);
                    }
                    Iw.hQl = PY;
                    Iw.hQm.hQo = PY2;
                    Iw.hQm.hQp = PY3;
                    Iw.hQm.hQq = System.currentTimeMillis() + ((long) (PY4 * 1000));
                    Iw.hQm.hQr = PY5;
                    Iw.save();
                }
                com.tencent.mm.sdk.b.a.urY.m(new ns());
            }
        }
    };
    private com.tencent.mm.sdk.b.c peE = new com.tencent.mm.sdk.b.c<az>(this) {
        final /* synthetic */ c peF;

        {
            this.peF = r2;
            this.usg = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.peF.aZn();
            return false;
        }
    };

    private class a implements Runnable {
        final /* synthetic */ c peF;
        boolean peI;

        a(c cVar, boolean z) {
            this.peF = cVar;
            this.peI = z;
        }

        public final void run() {
            boolean z = this.peI;
            File file = new File(d.Ij());
            w.i("MicroMsg.FTS.SubCoreSearch", "copy to path %s", new Object[]{file.getAbsolutePath()});
            if (com.tencent.mm.protocal.d.sYQ || com.tencent.mm.protocal.d.sYR) {
                w.i("MicroMsg.FTS.SubCoreSearch", "need to init search template folder %b", new Object[]{Boolean.valueOf(z)});
                e.d(file);
                c.j(file);
            } else {
                d.hPo = d.EI();
                if (z) {
                    w.i("MicroMsg.FTS.SubCoreSearch", "need update assetVersion=%d currentVersion=%d", new Object[]{Integer.valueOf(d.EJ()), Integer.valueOf(d.hPo)});
                    if (d.hPo < d.EJ()) {
                        e.d(file);
                        c.j(file);
                    }
                } else if (d.hPo == 1) {
                    w.i("MicroMsg.FTS.SubCoreSearch", "need init template");
                    e.d(file);
                    c.j(file);
                } else {
                    w.i("MicroMsg.FTS.SubCoreSearch", "currentVersion=%d", new Object[]{Integer.valueOf(d.hPo)});
                }
            }
            e.d(new File(com.tencent.mm.compatible.util.e.hgu, "fts"));
        }
    }

    private static c aZk() {
        c cVar = (c) ap.yR().gs("plugin.search");
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        ap.yR().a(c.class.getName(), cVar2);
        return cVar2;
    }

    public static g aZl() {
        return h.aye();
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        h.a(new com.tencent.mm.plugin.search.ui.h());
        this.peE.bIy();
        this.irS.bIy();
        ((n) com.tencent.mm.kernel.h.j(n.class)).getSysCmdMsgExtension().a("mmsearch_reddot", this.peD);
        aZn();
        com.tencent.mm.sdk.f.e.post(new a(this, z), "CopySearchTemplateTask");
        h.a(new l());
        h.a(new com.tencent.mm.plugin.search.ui.b.e());
        h.a(new com.tencent.mm.plugin.search.ui.b.c());
        h.a(new f());
        h.a(new com.tencent.mm.plugin.search.ui.b.h());
        h.a(new j());
        h.a(new com.tencent.mm.plugin.search.ui.b.d());
        h.a(new com.tencent.mm.plugin.search.ui.b.b());
        h.a(new com.tencent.mm.plugin.search.ui.b.g());
        h.a(new i());
        h.a(new com.tencent.mm.plugin.search.ui.b.a());
        h.a(new k());
    }

    public final void onAccountRelease() {
        this.peE.dead();
        this.irS.dead();
        ((n) com.tencent.mm.kernel.h.j(n.class)).getSysCmdMsgExtension().b("mmsearch_reddot", this.peD);
        h.ayd();
        com.tencent.mm.as.f.hPJ = null;
    }

    static void j(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(file, "fts_template.zip");
        if (d.iW(file2.getAbsolutePath())) {
            int eA = bg.eA(file2.getAbsolutePath(), file2.getParent());
            if (eA < 0) {
                w.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + eA + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            d.hPo = d.EI();
            w.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file2.getParent(), Integer.valueOf(d.hPo)});
            return;
        }
        w.i("MicroMsg.FTS.SubCoreSearch", "copy template file from asset fail %s", new Object[]{file2.getAbsolutePath()});
    }

    public static void k(File file) {
        File file2 = new File(d.Ij());
        e.d(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(file2, "fts_template.zip");
        e.p(file.getAbsolutePath(), file3.getAbsolutePath());
        int eA = bg.eA(file3.getAbsolutePath(), file3.getParent());
        if (eA < 0) {
            w.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + eA + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        d.hPo = d.EI();
        w.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file3.getParent(), Integer.valueOf(d.hPo)});
    }

    public static void aZm() {
        if (t.Ic().aQ(0, 18) != null) {
            if (new File(t.Ic().aT(0, 18)).exists()) {
                w.i("MicroMsg.FTS.SubCoreSearch", "Exist Uzip Folder path=%s", new Object[]{t.Ic().aT(0, 18)});
            } else {
                w.i("MicroMsg.FTS.SubCoreSearch", "Not Exist Uzip Folder， path=%s", new Object[]{t.Ic().aT(0, 18)});
                ap.vd().a(new com.tencent.mm.ap.j(0, 18), 0);
                return;
            }
        }
        if (System.currentTimeMillis() - aZk().peC > 7200000) {
            aZk().peC = System.currentTimeMillis();
            ap.vd().a(new com.tencent.mm.ap.k(18), 0);
        }
    }

    public final void aZn() {
        ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSTaskDaemon().a(65536, new com.tencent.mm.plugin.fts.a.a.a(this) {
            final /* synthetic */ c peF;
            String peG = v.ea(ab.getContext());
            boolean peH = false;

            {
                this.peF = r2;
            }

            public final boolean execute() {
                this.peH = ((int) ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSIndexDB().h(-3, 0)) != this.peG.hashCode();
                if (this.peH) {
                    com.tencent.mm.sdk.b.a.urY.m(new ra());
                }
                return true;
            }

            public final String toString() {
                return "CheckLanguageUpdate [" + (this.peH ? "changed: " + this.peG : "not changed") + "]";
            }
        });
    }
}
