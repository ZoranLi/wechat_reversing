package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ac;
import com.tencent.mm.u.bu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class e {
    private static HashMap<Integer, com.tencent.mm.bj.g.c> gJr;
    public String cachePath;
    public final s gXW = vk();
    b gXX;
    c gXY;
    public a gXZ;
    public e gYa = new e();
    e gYb = new e();
    public List<com.tencent.mm.kernel.api.a> gYc;
    public List<ac> gYd;
    public String gYe;
    public String gYf;
    public g gYg = null;
    public g gYh = null;
    public t gYi;
    ba gYj;
    bu gYk;
    ConcurrentHashMap<String, SharedPreferences> gYl = new ConcurrentHashMap();
    private long gYm = 0;
    private ae gYn = null;
    private volatile Boolean gYo = null;
    private d gYp = new d(this);
    private long gYq = 0;

    private class d implements Runnable {
        final /* synthetic */ e gYr;

        public d(e eVar) {
            this.gYr = eVar;
        }

        public final void run() {
            this.gYr.vt();
        }
    }

    public static class f {
        public int gYA = 0;
        public boolean gYz = false;
    }

    static class a extends com.tencent.mm.bn.a<com.tencent.mm.kernel.api.b> implements com.tencent.mm.kernel.api.b {
        a() {
        }

        public final List<String> collectStoragePaths() {
            LinkedList cbx = cbx();
            List<String> linkedList = new LinkedList();
            Iterator it = cbx.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vending.b.b bVar = (com.tencent.mm.vending.b.b) it.next();
                if (bVar != null) {
                    Collection collectStoragePaths = ((com.tencent.mm.kernel.api.b) bVar.wCz).collectStoragePaths();
                    if (collectStoragePaths != null) {
                        linkedList.addAll(collectStoragePaths);
                    }
                }
            }
            return linkedList;
        }
    }

    static class b extends com.tencent.mm.bn.a<com.tencent.mm.kernel.api.e> implements com.tencent.mm.kernel.api.e {
        b() {
        }

        public final void onDataBaseOpened(final g gVar, final g gVar2) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.kernel.api.e>(this) {
                final /* synthetic */ b gYu;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseOpened(gVar, gVar2);
                }
            });
        }

        public final void onDataBaseClosed(final g gVar, final g gVar2) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.kernel.api.e>(this) {
                final /* synthetic */ b gYu;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseClosed(gVar, gVar2);
                }
            });
        }
    }

    static class c extends com.tencent.mm.bn.a<com.tencent.mm.kernel.api.f> implements com.tencent.mm.kernel.api.f {
        c() {
        }

        public final void aR(final boolean z) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.kernel.api.f>(this) {
                final /* synthetic */ c gYw;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.kernel.api.f) obj).aR(z);
                }
            });
        }

        public final void vB() {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.kernel.api.f>(this) {
                final /* synthetic */ c gYw;

                {
                    this.gYw = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.kernel.api.f) obj).vB();
                }
            });
        }

        public final void eg(final String str) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.kernel.api.f>(this) {
                final /* synthetic */ c gYw;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.kernel.api.f) obj).eg(str);
                }
            });
        }
    }

    static class e extends com.tencent.mm.bn.a<com.tencent.mm.bj.g.a> implements com.tencent.mm.bj.g.a {
        e() {
        }

        public final void vy() {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.bj.g.a>(this) {
                final /* synthetic */ e gYy;

                {
                    this.gYy = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.bj.g.a) obj).vy();
                }
            });
        }

        public final void vz() {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.bj.g.a>(this) {
                final /* synthetic */ e gYy;

                {
                    this.gYy = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.bj.g.a) obj).vz();
                }
            });
        }

        public final void vA() {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.bj.g.a>(this) {
                final /* synthetic */ e gYy;

                {
                    this.gYy = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.bj.g.a) obj).vA();
                }
            });
        }
    }

    public e(List<com.tencent.mm.kernel.api.a> list, a aVar, List<ac> list2, b bVar, c cVar) {
        String str = w.hgq + "alphahold.ini";
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(com.tencent.mm.protocal.d.sYN), Boolean.valueOf(com.tencent.mm.protocal.d.sYQ), str);
        if (com.tencent.mm.protocal.d.sYQ || com.tencent.mm.protocal.d.sYR) {
            String value = com.tencent.mm.sdk.e.a.getValue(str, "noneedhold");
            int i = com.tencent.mm.protocal.d.sYN;
            try {
                i = Integer.decode(BaseBuildInfo.CLIENT_VERSION).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i).equals(value)) {
                com.tencent.mm.sdk.platformtools.w.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.sYQ));
                a.uK();
                com.tencent.mm.sdk.e.a.aa(str, "noneedhold", String.valueOf(i));
            }
        } else {
            com.tencent.mm.loader.stub.b.deleteFile(str);
        }
        this.gYe = vq();
        this.gXZ = aVar;
        this.gYc = list;
        this.gYd = list2;
        this.gXX = bVar;
        this.gXY = cVar;
    }

    public final com.tencent.mm.vending.b.b a(com.tencent.mm.kernel.api.e eVar) {
        return this.gXX.bI(eVar);
    }

    private static s vk() {
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", com.tencent.mm.sdk.platformtools.e.aKs(), Integer.valueOf(com.tencent.mm.protocal.d.sYN));
        File file = new File(w.hgq);
        if (!file.exists()) {
            file.mkdirs();
        }
        s sVar = new s(w.hgq + "systemInfo.cfg");
        String str = (String) sVar.get(258);
        if (str != null) {
            k.rj().set(258, str);
        }
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", r0.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "check data size failed :%s", e.getMessage());
        }
        return sVar;
    }

    final boolean vl() {
        int f = bg.f((Integer) this.gYi.get(14, null));
        int i = com.tencent.mm.protocal.d.sYN;
        com.tencent.mm.sdk.platformtools.w.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + f + ", cVer = " + i);
        List<ab> dataTransferList = new ac(this) {
            final /* synthetic */ e gYr;

            {
                this.gYr = r1;
            }

            public final List<ab> getDataTransferList() {
                List<ab> arrayList = new ArrayList();
                synchronized (this.gYr.gYd) {
                    for (ac dataTransferList : this.gYr.gYd) {
                        Collection dataTransferList2 = dataTransferList.getDataTransferList();
                        if (dataTransferList2 != null) {
                            arrayList.addAll(dataTransferList2);
                        }
                    }
                }
                return arrayList;
            }
        }.getDataTransferList();
        if (dataTransferList == null) {
            com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
            return false;
        }
        if (r.iiO > 0 && r.iiP > 0) {
            com.tencent.mm.sdk.platformtools.w.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
        } else if (f == i) {
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + f + ", cVer = " + i);
            return false;
        } else {
            boolean z = false;
            for (ab eX : dataTransferList) {
                z = eX.eX(f);
                if (z) {
                    break;
                }
            }
            com.tencent.mm.sdk.platformtools.w.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = " + z);
            if (!z) {
                return false;
            }
        }
        com.tencent.mm.sdk.platformtools.w.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + dataTransferList.size());
        com.tencent.mm.sdk.platformtools.w.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
        long cs = this.gYg.cs(Thread.currentThread().getId());
        for (ab eX2 : dataTransferList) {
            long currentTimeMillis = System.currentTimeMillis();
            eX2.transfer(f);
            eX2.hlR = System.currentTimeMillis() - currentTimeMillis;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + eX2.hlR + ", tag = " + eX2.getTag());
        }
        if (!(r.iiO == 0 || r.iiP == 0)) {
            for (i = 0; i < r.iiO; i++) {
                try {
                    Thread.sleep((long) r.iiP);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "exception:%s", bg.g(e));
                }
            }
        }
        if (cs > 0) {
            this.gYg.aD(cs);
        }
        return true;
    }

    final void vm() {
        List collectStoragePaths = this.gXZ.collectStoragePaths();
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "all account storage folder %s", collectStoragePaths.toString());
        String[] strArr = new String[(collectStoragePaths.size() + 1)];
        strArr[0] = this.gYf;
        for (int i = 0; i < collectStoragePaths.size(); i++) {
            strArr[i + 1] = this.gYf + ((String) collectStoragePaths.get(i));
        }
        com.tencent.mm.a.e.c(strArr);
        this.gXY.eg(this.gYf);
        File file = new File(this.gYf + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "exception:%s", bg.g(e));
            }
        }
    }

    public final String vn() {
        File file = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        file = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        String[] list = new File(this.cachePath).list(new FilenameFilter(this) {
            final /* synthetic */ e gYr;

            {
                this.gYr = r1;
            }

            public final boolean accept(File file, String str) {
                return str.startsWith("EnMicroMsg.dberr");
            }
        });
        if (list == null || list.length <= 0) {
            return null;
        }
        String str = list[0];
        for (int i = 1; i < list.length; i++) {
            String str2 = list[i];
            if (str2.compareTo(str) > 0) {
                str = str2;
            }
        }
        return this.cachePath + '/' + str;
    }

    public final void cQ(String str) {
        this.gXX.onDataBaseClosed(this.gYg, this.gYh);
        if (this.gYh != null) {
            this.gYh.wL();
        }
        if (this.gYg != null) {
            this.gYg.cQ(str);
        }
    }

    public final String vo() {
        return this.cachePath + "MicroMsg.db";
    }

    public final String vp() {
        return this.cachePath + "EnMicroMsg.db";
    }

    public final SharedPreferences ef(String str) {
        h.vJ();
        h.vG();
        int uH = a.uH();
        if (uH == 0) {
            return null;
        }
        if (this.gYl.containsKey(str)) {
            return (SharedPreferences) this.gYl.get(str);
        }
        try {
            String str2 = com.tencent.mm.sdk.platformtools.ab.getContext().getFilesDir().getParent() + "/shared_prefs/";
            String str3 = com.tencent.mm.sdk.platformtools.ab.bIX() + str + uH + ".xml";
            String str4 = com.tencent.mm.sdk.platformtools.ab.bIX() + str + uH + ".xml.bak";
            File file = new File(str2 + str3);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str2 + str4);
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = com.tencent.mm.sdk.platformtools.ab.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ab.bIX() + str + aa.Pq(uH + aa.Pq(String.valueOf(uH / 2))), 0);
        this.gYl.put(str, sharedPreferences);
        return sharedPreferences;
    }

    private static String vq() {
        String str = w.hgq;
        File file = new File(com.tencent.mm.compatible.util.e.hgs);
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.hgs + "] file.exists:" + file.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.f.rZ());
        if (file.exists() && com.tencent.mm.compatible.util.f.rZ()) {
            if (aS(com.tencent.mm.compatible.util.e.hgu)) {
                str = com.tencent.mm.compatible.util.e.hgu;
            }
            file = new File(com.tencent.mm.compatible.util.e.gSz);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gSA);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gSB);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gSC);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gSA + ".nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "exception:%s", bg.g(e));
                }
            }
        }
        file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: " + str);
        return str;
    }

    private static final boolean aS(String str) {
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            return false;
        }
        File file = new File(str);
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
        if (file.exists() && file.isDirectory()) {
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
            return false;
        }
        String str2 = "/";
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
        for (int i = 0; i < split.length; i++) {
            if (!bg.mA(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", file2.getName());
                    return false;
                } else if (!(file2.exists() || file2.mkdir())) {
                    com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", file2.getName());
                    return false;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
        return true;
    }

    public final t vr() {
        h.vJ();
        h.vG().uQ();
        return this.gYi;
    }

    public final ba vs() {
        h.vJ();
        h.vG().uQ();
        return this.gYj;
    }

    public final void vt() {
        this.gYo = Boolean.valueOf(isSDCardAvailable());
    }

    public final boolean vu() {
        if (this.gYo == null) {
            this.gYo = Boolean.valueOf(isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.gYq;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                if (this.gYn == null) {
                    this.gYn = new ae(h.vL().nJF.getLooper());
                }
                this.gYn.removeCallbacksAndMessages(null);
                this.gYn.postDelayed(this.gYp, 1000);
                this.gYq = System.currentTimeMillis();
            }
        }
        return this.gYo.booleanValue();
    }

    public final boolean isSDCardAvailable() {
        boolean startsWith = this.gYe.startsWith(com.tencent.mm.compatible.util.e.hgs);
        long Nz = bg.Nz();
        long j = Nz - this.gYm;
        if (startsWith) {
            h.vJ();
            if (h.vG().uV() && j > 0 && j < 1000 && new File(this.gYe).exists()) {
                return true;
            }
        }
        this.gYm = Nz;
        boolean rZ = com.tencent.mm.compatible.util.f.rZ();
        r8 = new Object[6];
        h.vJ();
        h.vG();
        r8[1] = o.getString(a.uH());
        r8[2] = Long.valueOf(j);
        r8[3] = this.gYe;
        r8[4] = com.tencent.mm.compatible.util.e.hgs;
        r8[5] = Boolean.valueOf(h.vG().uV());
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", r8);
        if (!rZ) {
            return false;
        }
        if (startsWith) {
            return true;
        }
        h.vJ();
        if (!h.vG().uV()) {
            return true;
        }
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
        vv();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void vv() {
        /*
        r7 = this;
        com.tencent.mm.kernel.h.vJ();
        r0 = com.tencent.mm.kernel.h.vG();
        r1 = r0.gXf;
        monitor-enter(r1);
        r0 = vq();	 Catch:{ all -> 0x009c }
        r2 = "MMKernel.CoreStorage";
        r3 = "remount begin uin:%d oldpath:[%s] newPath:[%s] init:[%b]";
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x009c }
        r5 = 0;
        r6 = com.tencent.mm.kernel.a.uH();	 Catch:{ all -> 0x009c }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 1;
        r6 = r7.gYe;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 2;
        r4[r5] = r0;	 Catch:{ all -> 0x009c }
        r5 = 3;
        r6 = com.tencent.mm.kernel.h.vG();	 Catch:{ all -> 0x009c }
        r6 = r6.uV();	 Catch:{ all -> 0x009c }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ all -> 0x009c }
        if (r2 != 0) goto L_0x013e;
    L_0x0042:
        r2 = r7.gYe;	 Catch:{ all -> 0x009c }
        r2 = r0.equalsIgnoreCase(r2);	 Catch:{ all -> 0x009c }
        if (r2 == 0) goto L_0x00bb;
    L_0x004a:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0080 }
        r3 = "testSdcardWritable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0080 }
        r3 = vw();	 Catch:{ Exception -> 0x0080 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0080 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0080 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ Exception -> 0x0080 }
    L_0x0064:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009f }
        r3 = "testSdcardReadable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x009f }
        r3 = vx();	 Catch:{ Exception -> 0x009f }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x009f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x009f }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ Exception -> 0x009f }
    L_0x007e:
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
    L_0x007f:
        return;
    L_0x0080:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r4 = "testSdcardWritable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x009c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x009c }
        r0 = r3.append(r0);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.w.w(r2, r0);	 Catch:{ all -> 0x009c }
        goto L_0x0064;
    L_0x009c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
        throw r0;
    L_0x009f:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r4 = "testSdcardReadable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x009c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x009c }
        r0 = r3.append(r0);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.w.w(r2, r0);	 Catch:{ all -> 0x009c }
        goto L_0x007e;
    L_0x00bb:
        r2 = "MMKernel.CoreStorage";
        r3 = "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]";
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x009c }
        r5 = 0;
        r6 = r7.gYe;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 1;
        r4[r5] = r0;	 Catch:{ all -> 0x009c }
        r5 = 2;
        r6 = r7.gYf;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 3;
        r6 = r7.cachePath;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ all -> 0x009c }
        if (r2 != 0) goto L_0x0122;
    L_0x00df:
        r7.gYe = r0;	 Catch:{ all -> 0x009c }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r2 = "mm";
        r0.<init>(r2);	 Catch:{ all -> 0x009c }
        com.tencent.mm.kernel.h.vJ();	 Catch:{ all -> 0x009c }
        com.tencent.mm.kernel.h.vG();	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.kernel.a.uH();	 Catch:{ all -> 0x009c }
        r0 = r0.append(r2);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        r0 = r0.getBytes();	 Catch:{ all -> 0x009c }
        r0 = com.tencent.mm.a.g.n(r0);	 Catch:{ all -> 0x009c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r2.<init>();	 Catch:{ all -> 0x009c }
        r3 = r7.gYe;	 Catch:{ all -> 0x009c }
        r2 = r2.append(r3);	 Catch:{ all -> 0x009c }
        r0 = r2.append(r0);	 Catch:{ all -> 0x009c }
        r2 = "/";
        r0 = r0.append(r2);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        r7.gYf = r0;	 Catch:{ all -> 0x009c }
        r7.vm();	 Catch:{ all -> 0x009c }
    L_0x0122:
        r0 = r7.gXY;	 Catch:{ all -> 0x009c }
        r0.vB();	 Catch:{ all -> 0x009c }
        r0 = "MMKernel.CoreStorage";
        r2 = "remout isSDCardAvail :[%b] done";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x009c }
        r4 = 0;
        r5 = com.tencent.mm.compatible.util.f.rZ();	 Catch:{ all -> 0x009c }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x009c }
        r3[r4] = r5;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);	 Catch:{ all -> 0x009c }
    L_0x013e:
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.vv():void");
    }

    private static boolean vw() {
        boolean canWrite;
        Exception e;
        Throwable th;
        boolean z = false;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.hgs.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canWrite = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
            canWrite = false;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                boolean delete = file.delete();
                try {
                    fileOutputStream.close();
                    z = delete;
                } catch (Throwable e3) {
                    com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "exception:%s", bg.g(e3));
                    z = delete;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    com.tencent.mm.sdk.platformtools.w.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e5) {
                            com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "exception:%s", bg.g(e5));
                        }
                    }
                    com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.hgs + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e52) {
                            com.tencent.mm.sdk.platformtools.w.e("MMKernel.CoreStorage", "exception:%s", bg.g(e52));
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            com.tencent.mm.sdk.platformtools.w.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.hgs + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.hgs + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
        return z;
    }

    private static boolean vx() {
        boolean canRead;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.hgs.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e) {
            Exception exception = e;
            canRead = false;
            com.tencent.mm.sdk.platformtools.w.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + exception.getMessage());
        }
        File file = new File(com.tencent.mm.compatible.util.e.hgu);
        boolean exists = file.exists();
        if (exists) {
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + file.isDirectory() + " isFile:" + file.isFile());
        }
        com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.hgs + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.hgu + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + canRead + " canTrueRead:" + exists);
        return exists;
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return t.gUx;
            }
        });
    }

    final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        HashMap<Integer, com.tencent.mm.bj.g.c> hashMap = new HashMap();
        hashMap.putAll(gJr);
        synchronized (this.gYc) {
            com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "storage getBaseDBFactories");
            for (com.tencent.mm.kernel.api.a collectDatabaseFactory : this.gYc) {
                Object collectDatabaseFactory2 = collectDatabaseFactory.collectDatabaseFactory();
                if (collectDatabaseFactory2 != null) {
                    hashMap.putAll(collectDatabaseFactory2);
                }
                if (collectDatabaseFactory2 != null) {
                    com.tencent.mm.sdk.platformtools.w.i("MMKernel.CoreStorage", "storage add db provider %s %s %s", collectDatabaseFactory, Integer.valueOf(collectDatabaseFactory2.size()), Integer.valueOf(hashMap.size()));
                }
            }
        }
        for (Integer num : hashMap.keySet()) {
            for (Object obj : ((com.tencent.mm.bj.g.c) hashMap.get(num)).pP()) {
                com.tencent.mm.sdk.platformtools.w.d("MMKernel.CoreStorage", "create table key %s table %s", num, obj);
            }
        }
        return hashMap;
    }
}
