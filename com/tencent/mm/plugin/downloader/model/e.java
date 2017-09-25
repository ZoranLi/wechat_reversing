package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.y.d;
import com.tencent.mm.b.c;
import com.tencent.mm.e.a.hb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class e {
    public static Map<Long, Long> kGF = new HashMap();
    private static int kGL = 2;
    private static e kGN;
    n kGG;
    private n kGH;
    private n kGI;
    private n kGJ;
    private n kGK;
    public b kGM;

    public static e akM() {
        if (kGN == null) {
            kGN = new e();
        }
        return kGN;
    }

    private e() {
        akR();
        if (h.vG().uV()) {
            h.vG();
            if (!a.uP()) {
                kGL = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("FileDownloaderType"), 2);
                w.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(kGL));
                this.kGM = new b();
            }
        }
        w.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        this.kGM = new b();
    }

    private n akN() {
        w.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + kGL);
        if (this.kGG != null) {
            return this.kGG;
        }
        b hbVar = new hb();
        com.tencent.mm.sdk.b.a.urY.m(hbVar);
        int i = hbVar.fMw.fLG;
        if (i > 0) {
            kGL = i;
        }
        if (kGL == 1) {
            this.kGG = akO();
        } else {
            if (this.kGJ == null) {
                this.kGJ = new k(this.kGM);
            }
            this.kGG = this.kGJ;
        }
        return this.kGG;
    }

    public final n akO() {
        if (this.kGI == null) {
            this.kGI = new h(this.kGM);
        }
        return this.kGI;
    }

    public final n akP() {
        if (this.kGH == null) {
            this.kGH = new j(this.kGM);
        }
        return this.kGH;
    }

    public final n akQ() {
        if (this.kGK == null) {
            this.kGK = new a(this.kGM);
        }
        return this.kGK;
    }

    public final long a(f fVar) {
        if (h.vG().uV()) {
            h.vG();
            if (!a.uP()) {
                return akN().a(fVar);
            }
        }
        long a = akO().a(fVar);
        if (a >= 0) {
            kGF.put(Long.valueOf(a), Long.valueOf(0));
            ab.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            w.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            return a;
        }
        w.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        akP().a(fVar);
        return a;
    }

    public final int aT(long j) {
        if (bc(j)) {
            return akO().aT(j);
        }
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null || ba.field_downloaderType != 3) {
            return akN().aT(j);
        }
        return akQ().aT(j);
    }

    public final FileDownloadTaskInfo aU(long j) {
        if (bc(j)) {
            return akO().aU(j);
        }
        FileDownloadTaskInfo fileDownloadTaskInfo;
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba != null && ba.field_status == 3 && com.tencent.mm.a.e.aO(ba.field_filePath)) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.url = ba.field_downloadUrl;
            fileDownloadTaskInfo.status = 3;
            fileDownloadTaskInfo.path = ba.field_filePath;
            fileDownloadTaskInfo.fFW = ba.field_md5;
            fileDownloadTaskInfo.fLg = ba.field_downloadedSize;
            fileDownloadTaskInfo.fLh = ba.field_totalSize;
            fileDownloadTaskInfo.kHg = ba.field_autoDownload;
            fileDownloadTaskInfo.fLG = ba.field_downloaderType;
        } else if (ba == null || ba.field_downloaderType != 3) {
            fileDownloadTaskInfo = akN().aU(j);
            if (ba != null) {
                fileDownloadTaskInfo.kHg = ba.field_autoDownload;
                fileDownloadTaskInfo.fLG = ba.field_downloaderType;
            }
        } else {
            fileDownloadTaskInfo = akQ().aU(j);
        }
        w.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(fileDownloadTaskInfo.id), fileDownloadTaskInfo.url, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.path, fileDownloadTaskInfo.fFW, Long.valueOf(fileDownloadTaskInfo.fLh), Boolean.valueOf(fileDownloadTaskInfo.kHg), Integer.valueOf(fileDownloadTaskInfo.fLG));
        return fileDownloadTaskInfo;
    }

    public final FileDownloadTaskInfo tI(String str) {
        com.tencent.mm.plugin.downloader.b.a tE = d.tE(str);
        if (tE != null) {
            return aU(tE.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public final FileDownloadTaskInfo tJ(String str) {
        com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
        if (tH != null) {
            return aU(tH.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public static ArrayList<FileDownloadTaskInfo> q(ArrayList<String> arrayList) {
        ArrayList arrayList2 = null;
        com.tencent.mm.plugin.downloader.b.b wX = d.wX();
        if (wX != null) {
            Cursor rawQuery = wX.rawQuery("select * from FileDownloadInfo where " + com.tencent.mm.plugin.downloader.b.b.r(arrayList), new String[0]);
            if (rawQuery != null) {
                arrayList2 = new ArrayList();
                if (rawQuery.moveToFirst()) {
                    do {
                        com.tencent.mm.plugin.downloader.b.a aVar = new com.tencent.mm.plugin.downloader.b.a();
                        aVar.b(rawQuery);
                        arrayList2.add(aVar);
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        ArrayList<FileDownloadTaskInfo> arrayList3 = new ArrayList();
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.b.a aVar2 = (com.tencent.mm.plugin.downloader.b.a) it.next();
                FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
                if (aVar2.field_status != 3 || com.tencent.mm.a.e.aO(aVar2.field_filePath)) {
                    fileDownloadTaskInfo.status = aVar2.field_status;
                } else {
                    fileDownloadTaskInfo.status = 0;
                }
                fileDownloadTaskInfo.appId = aVar2.field_appId;
                fileDownloadTaskInfo.id = aVar2.field_downloadId;
                fileDownloadTaskInfo.url = aVar2.field_downloadUrl;
                fileDownloadTaskInfo.path = aVar2.field_filePath;
                fileDownloadTaskInfo.fFW = aVar2.field_md5;
                fileDownloadTaskInfo.fLg = aVar2.field_downloadedSize;
                fileDownloadTaskInfo.fLh = aVar2.field_totalSize;
                fileDownloadTaskInfo.kHg = aVar2.field_autoDownload;
                fileDownloadTaskInfo.fLG = aVar2.field_downloaderType;
                arrayList3.add(fileDownloadTaskInfo);
            }
        }
        return arrayList3;
    }

    public final boolean aV(long j) {
        if (bc(j)) {
            return akO().aV(j);
        }
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null || ba.field_downloaderType != 3) {
            return akN().aV(j);
        }
        return akQ().aV(j);
    }

    public final boolean aW(long j) {
        if (bc(j)) {
            return akO().aW(j);
        }
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null || ba.field_downloaderType != 3) {
            return akN().aW(j);
        }
        return akQ().aW(j);
    }

    private static void akR() {
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences != null) {
            Map all = sharedPreferences.getAll();
            if (all != null && all.size() != 0) {
                kGF.clear();
                for (Entry entry : all.entrySet()) {
                    if (!(entry == null || bg.mA((String) entry.getKey()))) {
                        try {
                            long j = bg.getLong((String) entry.getKey(), 0);
                            long longValue = ((Long) entry.getValue()).longValue();
                            long currentTimeMillis = System.currentTimeMillis() - j;
                            if (currentTimeMillis - j > 0 && currentTimeMillis - j < 86400000) {
                                kGF.put(Long.valueOf(j), Long.valueOf(longValue));
                            }
                        } catch (Throwable e) {
                            w.e("MicroMsg.FileDownloadManager", "parse download task failed: " + e.toString());
                            w.printErrStackTrace("MicroMsg.FileDownloadManager", e, "", new Object[0]);
                        }
                    }
                }
                sharedPreferences.edit().clear();
                for (Entry entry2 : kGF.entrySet()) {
                    sharedPreferences.edit().putLong(entry2.getKey(), ((Long) entry2.getValue()).longValue());
                }
                sharedPreferences.edit().commit();
            }
        }
    }

    public static void tK(String str) {
        w.i("MicroMsg.FileDownloadManager", "APK File Path: %s", str);
        if (!bg.mA(str)) {
            q.e(ab.getContext(), Uri.fromFile(new File(str)));
        }
    }

    public static void a(String str, String str2, PendingIntent pendingIntent) {
        d dVar = new d(ab.getContext());
        dVar.a(str);
        dVar.b((CharSequence) str2);
        dVar.L(17301634);
        dVar.o(true);
        if (pendingIntent != null) {
            dVar.rR = pendingIntent;
        } else {
            dVar.rR = PendingIntent.getActivity(ab.getContext(), 0, new Intent(), 0);
        }
        ((com.tencent.mm.plugin.notification.b.a) h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build());
        w.i("MicroMsg.FileDownloadManager", "show notification");
    }

    static boolean bc(long j) {
        return kGF.containsKey(Long.valueOf(j));
    }

    static void g(long j, long j2) {
        kGF.put(Long.valueOf(j), Long.valueOf(j2));
        ab.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j), j2).commit();
    }

    static long bd(long j) {
        Long l = (Long) kGF.get(Long.valueOf(j));
        return l == null ? -1 : l.longValue();
    }

    final void g(long j, boolean z) {
        w.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j), bg.bJZ());
        final Context context = ab.getContext();
        if (bc(j)) {
            this.kGM.b(j, aU(j).path, z);
            return;
        }
        final com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba != null) {
            if (bg.mA(ba.field_packageName)) {
                String Ml = q.Ml(ba.field_filePath);
                if (!bg.mA(Ml)) {
                    ba.field_packageName = Ml;
                    w.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", ba.field_filePath, Ml);
                    d.b(ba);
                }
            }
            final int Mm = q.Mm(ba.field_filePath);
            w.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", ba.field_packageName, ba.field_filePath, Integer.valueOf(Mm));
            final long j2 = j;
            final boolean z2 = z;
            h.vL().D(new Runnable(this) {
                final /* synthetic */ e kGP;

                public final void run() {
                    new ak(ba.field_packageName, Mm).a(h.vH().gXC.hsZ, new com.tencent.mm.y.e(this) {
                        final /* synthetic */ AnonymousClass1 kGQ;

                        {
                            this.kGQ = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            kVar.hsJ = true;
                            g gVar;
                            Object[] objArr;
                            if (i == 0 && i2 == 0) {
                                String string = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "yyb_pkg_sig_prefs", 4).getString(ba.field_packageName, "");
                                w.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", string);
                                if (bg.mA(string)) {
                                    g.oUh.a(322, 26, 1, false);
                                    gVar = g.oUh;
                                    objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(4026);
                                    objArr[1] = String.format("%s,%s", new Object[]{ba.field_packageName, ba.field_filePath});
                                    gVar.i(11098, objArr);
                                } else {
                                    g gVar2;
                                    Object[] objArr2;
                                    try {
                                        c.a(new File(ba.field_filePath), string);
                                        w.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                                        g.oUh.a(322, 25, 1, false);
                                        gVar2 = g.oUh;
                                        objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(4025);
                                        objArr2[1] = String.format("%s,%s,%s", new Object[]{ba.field_packageName, ba.field_filePath, string});
                                        gVar2.i(11098, objArr2);
                                    } catch (Exception e) {
                                        w.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e.getMessage());
                                        g.oUh.a(322, 27, 1, false);
                                        gVar2 = g.oUh;
                                        objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(4027);
                                        objArr2[1] = String.format("%s,%s,%s", new Object[]{ba.field_packageName, ba.field_filePath, e.getMessage()});
                                        gVar2.i(11098, objArr2);
                                    }
                                }
                            } else {
                                w.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                                g.oUh.a(322, 28, 1, false);
                                gVar = g.oUh;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf(4028);
                                objArr[1] = String.format("%s,%s,%d,%d", new Object[]{ba.field_packageName, ba.field_filePath, Integer.valueOf(i), Integer.valueOf(i2)});
                                gVar.i(11098, objArr);
                            }
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 kGR;

                                {
                                    this.kGR = r1;
                                }

                                public final void run() {
                                    PendingIntent pendingIntent = null;
                                    if (ba.field_fileType == 1) {
                                        pendingIntent = e.bH(ba.field_filePath, ba.field_md5);
                                    }
                                    String str;
                                    if (ba.field_showNotification && bg.mA(ba.field_fileName)) {
                                        str = ba.field_downloadUrl;
                                        e.a(context.getString(com.tencent.mm.plugin.downloader.b.c.kGc), "", pendingIntent);
                                    } else if (ba.field_showNotification && !bg.mA(ba.field_fileName)) {
                                        str = ba.field_downloadUrl;
                                        e.a(ba.field_fileName, context.getString(com.tencent.mm.plugin.downloader.b.c.kGc), pendingIntent);
                                    }
                                    if (ba.field_autoInstall && ba.field_fileType == 1) {
                                        e.tK(ba.field_filePath);
                                    }
                                    this.kGR.kGQ.kGP.kGM.b(j2, ba.field_filePath, z2);
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    public static PendingIntent bH(String str, String str2) {
        Intent intent = new Intent();
        Context context = ab.getContext();
        intent.setClass(context, FileDownloadService.class);
        intent.putExtra(FileDownloadService.kHc, 3);
        intent.putExtra(FileDownloadService.kHd, str);
        intent.putExtra(FileDownloadService.kHe, str2);
        return PendingIntent.getService(context, (int) System.currentTimeMillis(), intent, 0);
    }
}
