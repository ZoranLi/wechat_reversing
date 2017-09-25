package com.tencent.mm.pluginsdk.k.a.b;

import android.os.Looper;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.bc;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.k.a.d.d;
import com.tencent.mm.pluginsdk.k.a.d.g;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.o;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.baf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b {
    private final d rYK = new d(this) {
        final /* synthetic */ b sFp;

        {
            this.sFp = r1;
        }

        public final void a(String str, l lVar) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = " + str);
            q Mu = a.sGQ.Mu(str);
            if (Mu != null) {
                j.u(Mu.field_reportId, 10);
                j.u(Mu.field_reportId, 15);
                if ((!Mu.field_fileCompress || Mu.field_fileEncrypt) && Mu.field_fileUpdated) {
                    j.a(Mu.field_resType, Mu.field_subType, Mu.field_url, bg.getInt(Mu.field_fileVersion, 0), Mu.field_maxRetryTimes > Mu.field_retryTimes ? com.tencent.mm.pluginsdk.k.a.b.j.a.sGa : com.tencent.mm.pluginsdk.k.a.b.j.a.sFY, true, bg.mz(Mu.field_groupId2).equals("NewXml"), false, Mu.field_sampleId);
                }
                if (Mu.field_fileCompress || Mu.field_fileEncrypt) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                    this.sFp.a(Mu);
                    return;
                }
                com.tencent.mm.sdk.b.b bbVar = new bb();
                bbVar.fEA.filePath = Mu.field_filePath;
                bbVar.fEA.fEE = Mu.field_fileUpdated;
                bbVar.fEA.fED = bg.getInt(Mu.field_fileVersion, 0);
                bbVar.fEA.fEB = Mu.field_resType;
                bbVar.fEA.fEC = Mu.field_subType;
                com.tencent.mm.sdk.b.a.urY.a(bbVar, Looper.getMainLooper());
                Mu.field_fileUpdated = false;
                a.sGQ.e(Mu);
            }
        }

        public final void b(String str, l lVar) {
            i.Mq(str);
            q Mu = a.sGQ.Mu(str);
            if (Mu != null) {
                boolean z = true;
                if (!(lVar == null || lVar.sGI == null)) {
                    if (lVar.sGI instanceof com.tencent.mm.pluginsdk.k.a.c.a) {
                        j.u(Mu.field_reportId, 7);
                        z = false;
                    } else if (lVar.sGI instanceof com.tencent.mm.pluginsdk.k.a.c.c) {
                        j.u(Mu.field_reportId, 16);
                        z = false;
                    }
                }
                if (z) {
                    j.u(Mu.field_reportId, 11);
                }
                j.u(Mu.field_reportId, 44);
                j.a(Mu.field_resType, Mu.field_subType, Mu.field_url, bg.getInt(Mu.field_fileVersion, 0), com.tencent.mm.pluginsdk.k.a.b.j.a.sFZ, false, "NewXml".equalsIgnoreCase(Mu.field_groupId2), false, Mu.field_sampleId);
            }
        }

        public final void Ji(String str) {
            o oVar = a.sGQ;
            if (!(oVar.rXW ? oVar.sGO.isDownloading(str) : false)) {
                i.Mq(str);
            }
        }

        public final String Qo() {
            return "CheckResUpdate";
        }
    };
    private final Set<b> sFj = Collections.newSetFromMap(new android.support.v4.e.a(i.sFM.length));
    private final k sFk = new k();

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ String iih;
        final /* synthetic */ boolean sFA;
        final /* synthetic */ int sFl;
        final /* synthetic */ int sFm;
        final /* synthetic */ b sFp;
        final /* synthetic */ int sFz;

        AnonymousClass8(b bVar, int i, int i2, String str, int i3, boolean z) {
            this.sFp = bVar;
            this.sFl = i;
            this.sFm = i2;
            this.iih = str;
            this.sFz = i3;
            this.sFA = z;
        }

        public final void run() {
            com.tencent.mm.sdk.b.b bbVar = new bb();
            bbVar.fEA.fEB = this.sFl;
            bbVar.fEA.fEC = this.sFm;
            bbVar.fEA.filePath = this.iih;
            bbVar.fEA.fED = this.sFz;
            bbVar.fEA.fEE = this.sFA;
            com.tencent.mm.sdk.b.a.urY.m(bbVar);
        }
    }

    public interface b {
        boolean bDr();
    }

    private static final class c {
        public static final b sFE = new b();
    }

    public static final class a implements g {
        private final com.tencent.mm.u.bp.a rYj = new com.tencent.mm.u.bp.a(this) {
            final /* synthetic */ a sFD;

            {
                this.sFD = r1;
            }

            public final void a(com.tencent.mm.y.d.a aVar) {
                String a = n.a(aVar.hst.tff);
                if (bg.mA(a)) {
                    w.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
                    return;
                }
                w.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n" + a);
                if (!bg.mA(a)) {
                    Map q = bh.q(a, "sysmsg");
                    j.u(0, 0);
                    String str = "MicroMsg.CheckResUpdateNewXmlParser";
                    String str2 = "parsed values.size = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = q == null ? "null" : String.valueOf(q.size());
                    w.i(str, str2, objArr);
                    if (q == null) {
                        j.u(0, 30);
                    } else {
                        j.u(0, 31);
                    }
                    if (q != null && q.size() > 0 && bg.mz((String) q.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                        e.f(".sysmsg", "delete", q);
                        e.f(".sysmsg", "cache", q);
                        e.f(".sysmsg", "decrypt", q);
                    }
                }
            }
        };
        private final com.tencent.mm.sdk.b.c sFB = new com.tencent.mm.sdk.b.c<lc>(this) {
            final /* synthetic */ a sFD;

            {
                this.sFD = r2;
                this.usg = lc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (h.vG().uV()) {
                    h.vG();
                    if (!com.tencent.mm.kernel.a.uP()) {
                        long Ny = bg.Ny();
                        long a = bg.a((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, null), 0);
                        if (a != 0 && a < Ny) {
                            p.acH();
                        }
                    }
                }
                return false;
            }
        };
        private final h sFC = new h();

        public final void bwP() {
            com.tencent.mm.sdk.b.a.urY.b(this.sFB);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("resourcemgr", this.rYj, true);
            h.vL().e(new Runnable(this) {
                final /* synthetic */ a sFD;

                {
                    this.sFD = r1;
                }

                public final void run() {
                    p.acH();
                }
            }, 10000);
        }

        public final void onAccountRelease() {
            com.tencent.mm.sdk.b.a.urY.c(this.sFB);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("resourcemgr", this.rYj, true);
        }

        public final String Qo() {
            return "CheckResUpdate";
        }

        public final com.tencent.mm.pluginsdk.k.a.d.m.a c(k kVar) {
            if (kVar instanceof c) {
                w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
                return new d((c) kVar);
            }
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
            return null;
        }

        public final com.tencent.mm.pluginsdk.k.a.d.h bwQ() {
            return this.sFC;
        }
    }

    final Set<b> bDq() {
        Set<b> newSetFromMap;
        synchronized (this.sFj) {
            newSetFromMap = Collections.newSetFromMap(new android.support.v4.e.a(this.sFj.size()));
            for (b add : this.sFj) {
                newSetFromMap.add(add);
            }
        }
        return newSetFromMap;
    }

    public final void e(int i, int i2, int i3, boolean z) {
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        a.sGQ.y(new Runnable(this) {
            final /* synthetic */ b sFp;

            public final void run() {
                q Mu = a.sGQ.Mu(i.dG(i4, i5));
                if (Mu != null && String.valueOf(i6).equals(Mu.field_fileVersion)) {
                    Mu.field_needRetry = !z2;
                    a.sGQ.e(Mu);
                }
            }
        });
    }

    public final void R(int i, int i2, int i3) {
        e(i, i2, i3, true);
    }

    public b() {
        a.sGQ.a("CheckResUpdate", this.rYK);
    }

    public static String dF(int i, int i2) {
        q Mu = a.sGQ.Mu(i.dG(i, i2));
        if (Mu == null) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        }
        w.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", Boolean.valueOf(Mu.field_deleted), Mu.field_filePath, Mu.field_md5, Boolean.valueOf(Mu.field_fileCompress), Boolean.valueOf(Mu.field_fileEncrypt), Mu.field_originalMd5);
        if (Mu.field_fileCompress || Mu.field_fileEncrypt) {
            String str;
            if (Mu.field_fileCompress) {
                str = Mu.field_filePath + ".decompressed";
            } else if (Mu.field_fileEncrypt) {
                str = Mu.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (bg.mA(str)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", Integer.valueOf(i), Integer.valueOf(i2));
                return null;
            } else if (bg.mA(Mu.field_originalMd5) || !bg.mz(com.tencent.mm.a.g.aV(str)).equals(Mu.field_originalMd5)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", Integer.valueOf(i), Integer.valueOf(i2));
                return null;
            } else {
                w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                return str;
            }
        } else if (Mu.field_deleted || bg.mA(Mu.field_filePath) || !bg.mz(com.tencent.mm.a.g.aV(Mu.field_filePath)).equals(Mu.field_md5)) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        } else {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", Integer.valueOf(i), Integer.valueOf(i2), Mu.field_filePath);
            return Mu.field_filePath;
        }
    }

    final void a(q qVar) {
        w.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + qVar.field_urlKey);
        k kVar = this.sFk;
        if (kVar.Ms(qVar.field_urlKey)) {
            w.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
            return;
        }
        kVar.a(new a(qVar.field_urlKey, qVar.field_resType, qVar.field_subType, bg.getInt(qVar.field_fileVersion, 0), qVar.field_fileUpdated, qVar.field_filePath, qVar.field_fileEncrypt, qVar.field_fileCompress, qVar.field_encryptKey, qVar.field_keyVersion, qVar.field_eccSignature, qVar.field_originalMd5, bg.mz(qVar.field_groupId2).equals("NewXml"), qVar.field_reportId, qVar.field_sampleId, qVar.field_url, qVar.field_maxRetryTimes, qVar.field_retryTimes));
    }

    final void a(int i, avi com_tencent_mm_protocal_c_avi, boolean z) {
        final String dG = i.dG(i, com_tencent_mm_protocal_c_avi.tVQ);
        if (com_tencent_mm_protocal_c_avi.tYO == null) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            return;
        }
        w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_avi.tVQ), Integer.valueOf(com_tencent_mm_protocal_c_avi.tYO.tYY));
        j.u((long) com_tencent_mm_protocal_c_avi.tYQ, 3);
        final int i2 = com_tencent_mm_protocal_c_avi.tYO.tYY;
        final int i3 = com_tencent_mm_protocal_c_avi.tVQ;
        final int i4 = com_tencent_mm_protocal_c_avi.tYQ;
        final String str = com_tencent_mm_protocal_c_avi.tYR;
        final int i5 = i;
        final boolean z2 = z;
        a.sGQ.y(new Runnable(this) {
            final /* synthetic */ b sFp;

            public final void run() {
                q Mu = a.sGQ.Mu(dG);
                int i = i5;
                int i2 = i3;
                int i3 = i2;
                int i4 = i4;
                String str = str;
                boolean z = z2;
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record " + Mu);
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", Integer.valueOf(i3));
                boolean z2 = false;
                if (Mu == null) {
                    j.u((long) i4, 47);
                    j.u((long) i4, 22);
                    z2 = true;
                } else if (bg.getInt(Mu.field_fileVersion, 0) <= i3) {
                    z2 = true;
                } else {
                    j.u(Mu.field_reportId, 47);
                    j.u(Mu.field_reportId, 22);
                }
                String dG = i.dG(i, i2);
                String Mp = i.Mp(dG);
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", Boolean.valueOf(z2), Mp);
                if (z2) {
                    a.sGQ.Mw(dG);
                    c.sFE.f(i, i2, 2, z);
                    if ((((com.tencent.mm.pluginsdk.k.a.e.a.My(Mp) & 1) & com.tencent.mm.pluginsdk.k.a.e.a.My(Mp + ".decompressed")) & com.tencent.mm.pluginsdk.k.a.e.a.My(Mp + ".decrypted")) != 0) {
                        if (Mu != null) {
                            j.u(Mu.field_reportId, 21);
                            j.a(Mu.field_resType, Mu.field_subType, i3, z, Mu.field_sampleId);
                        }
                    } else if (Mu != null) {
                        j.u(Mu.field_reportId, 22);
                        j.u(Mu.field_reportId, 47);
                    }
                    if (Mu == null) {
                        q qVar = new q();
                        qVar.field_urlKey = dG;
                        qVar.field_resType = i;
                        qVar.field_subType = i2;
                        qVar.field_deleted = true;
                        qVar.field_fileVersion = String.valueOf(i3);
                        qVar.field_reportId = (long) i4;
                        qVar.field_sampleId = str;
                        a.sGQ.e(qVar);
                        return;
                    }
                    Mu.field_deleted = true;
                    Mu.field_fileVersion = String.valueOf(i3);
                    a.sGQ.e(Mu);
                }
            }
        });
    }

    final void b(int i, avi com_tencent_mm_protocal_c_avi, boolean z) {
        String dG = i.dG(i, com_tencent_mm_protocal_c_avi.tVQ);
        if (com_tencent_mm_protocal_c_avi.tYO == null) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(), resource.Info = null, return");
            return;
        }
        String str;
        String str2 = "MicroMsg.ResDownloader.CheckResUpdateHelper";
        String str3 = "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_avi.tVQ);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_avi.tYO.tYY);
        if (com_tencent_mm_protocal_c_avi.tYO.tZa == null) {
            str = "null";
        } else {
            str = String.valueOf(com_tencent_mm_protocal_c_avi.tYO.tZa.size());
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_avi.tYQ);
        objArr[6] = com_tencent_mm_protocal_c_avi.tYR;
        objArr[7] = com_tencent_mm_protocal_c_avi.tYO.msN;
        objArr[8] = com_tencent_mm_protocal_c_avi.tYO.tug;
        w.i(str2, str3, objArr);
        if (com_tencent_mm_protocal_c_avi.tYO.tZa != null) {
            Iterator it = com_tencent_mm_protocal_c_avi.tYO.tZa.iterator();
            while (it.hasNext()) {
                baf com_tencent_mm_protocal_c_baf = (baf) it.next();
                w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", Integer.valueOf(com_tencent_mm_protocal_c_baf.jOb), com_tencent_mm_protocal_c_baf.ubt.bGX());
            }
        }
        j.eh((long) com_tencent_mm_protocal_c_avi.tYQ);
        if (!z) {
            j.u((long) com_tencent_mm_protocal_c_avi.tYQ, 1);
        }
        if (com_tencent_mm_protocal_c_avi.tmG != 0 && ((long) com_tencent_mm_protocal_c_avi.tmG) <= bg.Ny()) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", dG, Integer.valueOf(com_tencent_mm_protocal_c_avi.tmG), Integer.valueOf(com_tencent_mm_protocal_c_avi.tYO.tYY));
            j.u((long) com_tencent_mm_protocal_c_avi.tYQ, 14);
            j.u((long) com_tencent_mm_protocal_c_avi.tYQ, 44);
            j.a(i, com_tencent_mm_protocal_c_avi.tVQ, com_tencent_mm_protocal_c_avi.tYO.msN, com_tencent_mm_protocal_c_avi.tYO.tYY, com.tencent.mm.pluginsdk.k.a.b.j.a.sGc, false, z, false, com_tencent_mm_protocal_c_avi.tYR);
        } else if (bg.mA(com_tencent_mm_protocal_c_avi.tYO.msN) && com_tencent_mm_protocal_c_avi.tYO.tug == null) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
        } else {
            com.tencent.mm.pluginsdk.k.a.d.a.a aVar = new com.tencent.mm.pluginsdk.k.a.b.g.a(com_tencent_mm_protocal_c_avi.tYO.msN);
            aVar.sEX = dG;
            aVar.fEB = i;
            aVar.fEC = com_tencent_mm_protocal_c_avi.tVQ;
            aVar.hVj = (long) com_tencent_mm_protocal_c_avi.tmG;
            aVar.fED = com_tencent_mm_protocal_c_avi.tYO.tYY;
            aVar.fFW = com_tencent_mm_protocal_c_avi.tYO.tuy;
            aVar.sFG = a.xd(com_tencent_mm_protocal_c_avi.tYO.tYZ);
            aVar.sFH = a.xc(com_tencent_mm_protocal_c_avi.tYO.tYZ);
            aVar.sFf = (long) com_tencent_mm_protocal_c_avi.tYQ;
            aVar.sFg = com_tencent_mm_protocal_c_avi.tYR;
            aVar.sFh = com_tencent_mm_protocal_c_avi.tYS > 0 ? com_tencent_mm_protocal_c_avi.tYS : 3;
            aVar.sFI = com_tencent_mm_protocal_c_avi.sFI;
            aVar.networkType = com_tencent_mm_protocal_c_avi.tYT;
            aVar.fEH = z;
            if (!bg.bV(com_tencent_mm_protocal_c_avi.tYO.tZa)) {
                aVar.sFc = ((baf) com_tencent_mm_protocal_c_avi.tYO.tZa.get(0)).ubt.sYA;
            }
            if (!(com_tencent_mm_protocal_c_avi.tYP == null || bg.mA(com_tencent_mm_protocal_c_avi.tYP.tYX))) {
                aVar.sFa = com_tencent_mm_protocal_c_avi.tYP.tYX;
                aVar.sFb = com_tencent_mm_protocal_c_avi.tYP.tYW;
            }
            if (com_tencent_mm_protocal_c_avi.tYO.tug != null && com_tencent_mm_protocal_c_avi.tYO.tug.sYA.length > 0) {
                aVar.sFF = com_tencent_mm_protocal_c_avi.tYO.tug.toByteArray();
            }
            aVar.sFd = com_tencent_mm_protocal_c_avi.tYO.tZb;
            aVar.fileSize = (long) com_tencent_mm_protocal_c_avi.tYO.tsR;
            aVar.priority = com_tencent_mm_protocal_c_avi.tKt;
            final g gVar = new g(aVar.url, aVar.sEX, aVar.fED, aVar.networkType, aVar.sFh, aVar.hVj, aVar.fFW, aVar.fEB, aVar.fEC, aVar.sFf, aVar.sFg, aVar.sFc, aVar.sFd, aVar.sFG, aVar.sFH, aVar.sFa, aVar.sFb, aVar.sFI, aVar.sFF, aVar.fileSize, aVar.fEH, aVar.fEE, aVar.priority);
            w.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", gVar.toString());
            final String str4 = dG;
            a.sGQ.y(new Runnable(this) {
                final /* synthetic */ b sFp;

                public final void run() {
                    a.a(a.sGQ.Mu(str4), gVar);
                }
            });
        }
    }

    final void c(int i, avi com_tencent_mm_protocal_c_avi, boolean z) {
        final String dG = i.dG(i, com_tencent_mm_protocal_c_avi.tVQ);
        if (com_tencent_mm_protocal_c_avi.tYP == null) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
        } else if (bg.mA(com_tencent_mm_protocal_c_avi.tYP.tYX)) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
        } else {
            w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_avi.tVQ), Integer.valueOf(com_tencent_mm_protocal_c_avi.tYP.tYW));
            w.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", com_tencent_mm_protocal_c_avi.tYP.tYX);
            j.u((long) com_tencent_mm_protocal_c_avi.tYQ, 4);
            final String str = com_tencent_mm_protocal_c_avi.tYO.tZb;
            final String str2 = com_tencent_mm_protocal_c_avi.tYP.tYX;
            final int i2 = com_tencent_mm_protocal_c_avi.tYP.tYW;
            final int i3 = com_tencent_mm_protocal_c_avi.tYQ;
            final String str3 = com_tencent_mm_protocal_c_avi.tYR;
            a.sGQ.y(new Runnable(this) {
                final /* synthetic */ b sFp;

                public final void run() {
                    q Mu = a.sGQ.Mu(dG);
                    String str = str;
                    String str2 = str2;
                    int i = i2;
                    int i2 = i3;
                    String str3 = str3;
                    if (Mu == null) {
                        Mu = new q();
                        Mu.field_keyVersion = i;
                        Mu.field_encryptKey = str2;
                        Mu.field_reportId = (long) i2;
                        Mu.field_sampleId = str3;
                        Mu.field_originalMd5 = str;
                        a.sGQ.e(Mu);
                        j.u((long) i2, 51);
                        j.u((long) i2, 45);
                    } else if (Mu.field_keyVersion < i) {
                        Mu.field_keyVersion = i;
                        Mu.field_encryptKey = str2;
                        Mu.field_reportId = (long) i2;
                        Mu.field_sampleId = str3;
                        if (bg.mA(Mu.field_originalMd5)) {
                            Mu.field_originalMd5 = str;
                        }
                        a.sGQ.e(Mu);
                        b.a(Mu, true);
                    }
                }
            });
        }
    }

    final void b(int i, int i2, String str, int i3) {
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final int i6 = i3;
        a.sGQ.y(new Runnable(this) {
            final /* synthetic */ b sFp;

            public final void run() {
                b bVar = this.sFp;
                int i = i4;
                int i2 = i5;
                String str = str2;
                int i3 = i6;
                q Mu = a.sGQ.Mu(i.dG(i, i2));
                if (Mu != null) {
                    boolean z = Mu.field_fileUpdated;
                    Mu.field_fileUpdated = false;
                    a.sGQ.e(Mu);
                    if (i3 != bg.getInt(Mu.field_fileVersion, 0)) {
                        return;
                    }
                    if (a.sGQ.handler == null) {
                        w.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
                    } else {
                        a.sGQ.handler.post(new AnonymousClass8(bVar, i, i2, str, i3, z));
                    }
                }
            }
        });
    }

    final void f(int i, int i2, int i3, boolean z) {
        if (a.sGQ.handler == null) {
            w.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
            return;
        }
        final int i4 = i3;
        final int i5 = i;
        final int i6 = i2;
        final boolean z2 = z;
        a.sGQ.handler.post(new Runnable(this) {
            final /* synthetic */ b sFp;

            public final void run() {
                com.tencent.mm.sdk.b.b bcVar = new bc();
                bcVar.fEF.fEG = i4;
                bcVar.fEF.fEB = i5;
                bcVar.fEF.fEC = i6;
                bcVar.fEF.fEH = z2;
                com.tencent.mm.sdk.b.a.urY.m(bcVar);
            }
        });
    }
}
