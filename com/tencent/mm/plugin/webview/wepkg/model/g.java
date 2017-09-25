package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass10;
import com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass11;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.bmy;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g {

    public interface a {
        void y(JSONObject jSONObject);
    }

    private static class b {
        String qpr;
        List<String> sqK;
        String version;
    }

    public static synchronized f KC(String str) {
        f fVar;
        synchronized (g.class) {
            String KO = d.KO(str);
            String KP = d.KP(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (bg.mA(KO) || bg.mA(KP)) {
                w.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[]{KO, KP});
                fVar = null;
            } else {
                fVar = com.tencent.mm.plugin.webview.wepkg.utils.b.sru.KM(KO);
                if (fVar == null || fVar.sqr == null || !KP.equalsIgnoreCase(fVar.sqr.gaj)) {
                    WepkgVersion KI = h.KI(KO);
                    String str2;
                    if (KI == null) {
                        KP = "MicroMsg.Wepkg.WepkgManager";
                        str2 = "DB dont have valid record, pkgid:%s, domain:%s, version:%s:";
                        Object[] objArr = new Object[3];
                        objArr[0] = KO;
                        objArr[1] = KI != null ? KI.gaj : "";
                        objArr[2] = KI != null ? KI.version : "";
                        w.i(KP, str2, objArr);
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, KO, null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.wN(14));
                        fVar = null;
                    } else if (!KP.equalsIgnoreCase(KI.gaj)) {
                        w.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[]{KO, KI.version, KP, KI.gaj});
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, KO, null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.wN(13));
                        fVar = null;
                    } else if (bg.mA(KI.version)) {
                        w.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[]{KO});
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, KO, null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.wN(15));
                        fVar = null;
                    } else if (!KI.sri || (!KI.srj && KI.srk)) {
                        w.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[]{KI.sqL, KI.version, Boolean.valueOf(KI.sri), Boolean.valueOf(KI.srj), Boolean.valueOf(KI.srk)});
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, KO, KI.version, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.wN(16));
                        fVar = null;
                    } else {
                        e eVar;
                        str2 = KI.version;
                        String str3 = KI.iAe;
                        KP = KI.fFW;
                        int i = KI.srg;
                        if (bg.mA(KO) || bg.mA(str3) || bg.mA(KP)) {
                            w.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
                            eVar = null;
                        } else {
                            File file = new File(str3);
                            if (!file.exists()) {
                                w.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[]{str3});
                                KG(KO);
                                com.tencent.mm.plugin.webview.wepkg.utils.a.b("PkgModified", null, KO, str2, 1, 0, null);
                                eVar = null;
                            } else if (file.length() != ((long) i)) {
                                w.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[]{Integer.valueOf(i), Long.valueOf(file.length())});
                                file.delete();
                                KG(KO);
                                com.tencent.mm.plugin.webview.wepkg.utils.a.b("PkgModified", null, KO, str2, 2, 0, null);
                                eVar = null;
                            } else {
                                if (file.length() <= 5242880) {
                                    if (!KP.equalsIgnoreCase(com.tencent.mm.a.g.f(file))) {
                                        w.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[]{KP, com.tencent.mm.a.g.f(file)});
                                        file.delete();
                                        KG(KO);
                                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("PkgModified", null, KO, str2, 3, 0, null);
                                        eVar = null;
                                    }
                                } else {
                                    w.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[]{Long.valueOf(file.length()), Long.valueOf(5242880)});
                                }
                                e eVar2 = new e(file);
                                if (!eVar2.iyK || eVar2.sqo == null) {
                                    KD(KO);
                                    eVar = null;
                                } else {
                                    eVar = eVar2;
                                }
                            }
                        }
                        if (eVar != null || bg.mA(KI.iAe)) {
                            Map aD = aD(KO, KI.srk);
                            if (aD == null) {
                                com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, KO, KI.version, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.wN(18));
                                fVar = null;
                            } else {
                                fVar = new f(KI, eVar, aD);
                                com.tencent.mm.plugin.webview.wepkg.utils.b.sru.srw.put(KO, fVar);
                                w.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            }
                        } else {
                            com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, KO, KI.version, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.wN(17));
                            fVar = null;
                        }
                    }
                } else {
                    w.i("MicroMsg.Wepkg.WepkgManager", "memory has pkgid:%s record, version:%s", new Object[]{fVar.sqr.sqL, fVar.sqr.version});
                }
            }
        }
        return fVar;
    }

    public static void KD(String str) {
        w.i("MicroMsg.Wepkg.WepkgManager", "clear all wepkg info");
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN;
        wepkgCrossProcessTask.sqr.sqL = str;
        if (ab.bJb()) {
            d.vL().D(new com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass2(wepkgCrossProcessTask, null));
            return;
        }
        wepkgCrossProcessTask.iMD = new com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass3(null, wepkgCrossProcessTask);
        wepkgCrossProcessTask.SM();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static void KE(final String str) {
        c anonymousClass1 = new c() {
            public final void m(Message message) {
                final String string = message.getData().getString("used_wepkg_version");
                d.vL().D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 sqD;

                    public final void run() {
                        int i = 0;
                        String KN = d.KN(str);
                        String str = "";
                        WepkgVersion KH = h.KH(str);
                        if (KH != null) {
                            str = KH.version;
                        }
                        w.i("MicroMsg.Wepkg.WepkgManager", "clear all local wepkg, pkgid:%s, currVersion:%s, usedVersion:%s", new Object[]{str, str, string});
                        try {
                            if (bg.mA(string) && bg.mA(str)) {
                                g.KF(KN);
                                return;
                            }
                            File file = new File(KN);
                            if (file.exists() && !file.isFile()) {
                                File[] listFiles = file.listFiles();
                                if (listFiles == null || listFiles.length == 0) {
                                    file.delete();
                                    return;
                                }
                                int length = listFiles.length;
                                while (i < length) {
                                    File file2 = listFiles[i];
                                    if (file2.isFile()) {
                                        file2.delete();
                                    }
                                    if (!(!file2.isDirectory() || file2.getName().equalsIgnoreCase(string) || file2.getName().equalsIgnoreCase(str))) {
                                        w.i("MicroMsg.Wepkg.WepkgManager", "delete local path:%s", new Object[]{file2.getAbsolutePath()});
                                        g.KF(file2.getAbsolutePath());
                                    }
                                    i++;
                                }
                            }
                        } catch (Exception e) {
                            w.i("MicroMsg.Wepkg.WepkgManager", "clearAllLocalWepkg err:" + e.getMessage());
                        }
                    }
                });
            }
        };
        Bundle bundle = new Bundle(1);
        bundle.putInt("call_cmd_type", 1);
        bundle.putString("call_pkg_id", str);
        WepkgProcessPreloadService.a(anonymousClass1, bundle);
    }

    private static Map<String, WepkgPreloadFile> aD(String str, boolean z) {
        if (bg.mA(str)) {
            return null;
        }
        Map<String, WepkgPreloadFile> hashMap = new HashMap();
        List<WepkgPreloadFile> KK = h.KK(str);
        if (bg.bV(KK)) {
            return hashMap;
        }
        Object obj = null;
        for (WepkgPreloadFile wepkgPreloadFile : KK) {
            if (wepkgPreloadFile != null) {
                if (bg.mA(wepkgPreloadFile.filePath)) {
                    w.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[]{Boolean.valueOf(z)});
                    if (z) {
                        eb(wepkgPreloadFile.sqL, wepkgPreloadFile.sqw);
                        obj = 1;
                    } else {
                        h.a(str, wepkgPreloadFile.sqw, "", null);
                    }
                } else {
                    File file = new File(wepkgPreloadFile.filePath);
                    if (!file.exists()) {
                        w.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[]{wepkgPreloadFile.filePath, Boolean.valueOf(z)});
                        if (z) {
                            eb(wepkgPreloadFile.sqL, wepkgPreloadFile.sqw);
                            obj = 1;
                        } else {
                            h.a(str, wepkgPreloadFile.sqw, "", null);
                        }
                    } else if (file.length() != ((long) wepkgPreloadFile.size)) {
                        w.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[]{Integer.valueOf(wepkgPreloadFile.size), Long.valueOf(file.length()), Boolean.valueOf(z)});
                        if (z) {
                            eb(wepkgPreloadFile.sqL, wepkgPreloadFile.sqw);
                            file.delete();
                            obj = 1;
                        } else {
                            h.a(str, wepkgPreloadFile.sqw, "", null);
                        }
                    } else {
                        hashMap.put(wepkgPreloadFile.sqw, wepkgPreloadFile);
                    }
                }
            }
        }
        return obj != null ? null : hashMap;
    }

    public static boolean KF(String str) {
        try {
            File file = new File(str);
            File file2 = new File(file.getParent(), file.getName() + "_temp");
            if (file.renameTo(file2)) {
                e.d(file2);
                return true;
            }
        } catch (Exception e) {
            w.i("MicroMsg.Wepkg.WepkgManager", "safeDeleteDir err:" + e.getMessage());
        }
        return false;
    }

    public static void a(final a aVar) {
        final String str = com.tencent.mm.plugin.webview.wepkg.utils.b.iAV;
        final File file = new File(str);
        if (!(file.exists() && file.isDirectory())) {
            aVar.y(null);
        }
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
        wepkgCrossProcessTask.iMD = new Runnable() {
            public final void run() {
                if (wepkgCrossProcessTask.fDU) {
                    d.vL().D(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 sqI;

                        {
                            this.sqI = r1;
                        }

                        public final void run() {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("rootDir", str);
                                Map hashMap = new HashMap();
                                g.a(file, hashMap);
                                JSONArray jSONArray = new JSONArray();
                                for (Entry entry : hashMap.entrySet()) {
                                    if (((List) entry.getValue()).size() != 0) {
                                        JSONArray jSONArray2;
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("pkgId", entry.getKey());
                                        WepkgVersion KH = h.KH((String) entry.getKey());
                                        if (KH != null) {
                                            jSONObject2.put("controlInfo", KH.bAA());
                                        }
                                        List<WepkgPreloadFile> KK = h.KK((String) entry.getKey());
                                        if (!bg.bV(KK)) {
                                            jSONArray2 = new JSONArray();
                                            for (WepkgPreloadFile bAA : KK) {
                                                jSONArray2.put(bAA.bAA());
                                            }
                                            jSONObject2.put("preloadFilesInfo", jSONArray2);
                                        }
                                        jSONArray2 = new JSONArray();
                                        for (b bVar : (List) entry.getValue()) {
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("version", bVar.version);
                                            if (!bg.mA(bVar.qpr)) {
                                                File file = new File(bVar.qpr);
                                                if (file.exists() && file.isFile()) {
                                                    jSONObject3.put("md5", com.tencent.mm.a.g.f(file));
                                                    jSONObject3.put("size", file.length());
                                                    bmy com_tencent_mm_protocal_c_bmy = new e(file).sqo;
                                                    if (com_tencent_mm_protocal_c_bmy != null) {
                                                        jSONObject3.put("charset", com_tencent_mm_protocal_c_bmy.umt);
                                                        jSONObject3.put("desc", com_tencent_mm_protocal_c_bmy.msk);
                                                        if (com_tencent_mm_protocal_c_bmy.ums != null) {
                                                            JSONArray jSONArray3 = new JSONArray();
                                                            Iterator it = com_tencent_mm_protocal_c_bmy.ums.iterator();
                                                            while (it.hasNext()) {
                                                                sh shVar = (sh) it.next();
                                                                JSONObject jSONObject4 = new JSONObject();
                                                                jSONObject4.put("rid", shVar.tAk);
                                                                jSONObject4.put("offset", shVar.tAl);
                                                                jSONObject4.put("size", shVar.jNW);
                                                                jSONObject4.put("mimeType", shVar.tAm);
                                                                jSONArray3.put(jSONObject4);
                                                            }
                                                            jSONObject3.put("resList", jSONArray3);
                                                        }
                                                    }
                                                }
                                            }
                                            List<String> list = bVar.sqK;
                                            if (!bg.bV(list)) {
                                                JSONArray jSONArray4 = new JSONArray();
                                                for (String put : list) {
                                                    jSONArray4.put(put);
                                                }
                                                jSONObject3.put("preloadFiles", jSONArray4);
                                            }
                                            jSONArray2.put(jSONObject3);
                                        }
                                        jSONObject2.put("versionList", jSONArray2);
                                        jSONArray.put(jSONObject2);
                                    }
                                }
                                jSONObject.put("pkgList", jSONArray);
                                if (aVar != null) {
                                    aVar.y(jSONObject);
                                }
                            } catch (Exception e) {
                                if (aVar != null) {
                                    aVar.y(null);
                                }
                            }
                        }
                    });
                }
                wepkgCrossProcessTask.SN();
            }
        };
        wepkgCrossProcessTask.SM();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static boolean a(File file, Map<String, List<b>> map) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            File[] listFiles2 = file2.listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                List arrayList = new ArrayList();
                for (File file3 : listFiles2) {
                    b bVar = new b();
                    bVar.version = file3.getName();
                    String str = file3.getAbsolutePath() + File.separator + "package";
                    if (e.aO(str)) {
                        bVar.qpr = str;
                    }
                    File file4 = new File(file3.getAbsolutePath() + File.separator + "preload_files");
                    if (file4.isDirectory()) {
                        File[] listFiles3 = file4.listFiles();
                        if (listFiles3 == null || listFiles3.length == 0) {
                            arrayList.add(bVar);
                        } else {
                            List arrayList2 = new ArrayList();
                            for (File name : listFiles3) {
                                arrayList2.add(name.getName());
                            }
                            bVar.sqK = arrayList2;
                            arrayList.add(bVar);
                        }
                    } else {
                        arrayList.add(bVar);
                    }
                }
                map.put(file2.getName(), arrayList);
            }
        }
        return true;
    }

    private static void KG(String str) {
        if (!bg.mA(str)) {
            h.a(str, "", false, new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            });
        }
    }

    private static void eb(final String str, String str2) {
        if (!bg.mA(str) && !bg.mA(str2)) {
            final a anonymousClass5 = new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            };
            h.a(str, str2, "", new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    String str = str;
                    a aVar = anonymousClass5;
                    WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.ou = 3006;
                    wepkgCrossProcessTask.sqr.sqL = str;
                    wepkgCrossProcessTask.sqr.srj = false;
                    if (ab.bJb()) {
                        d.vL().D(new AnonymousClass10(wepkgCrossProcessTask, aVar));
                        return;
                    }
                    wepkgCrossProcessTask.iMD = new AnonymousClass11(aVar, wepkgCrossProcessTask);
                    wepkgCrossProcessTask.SM();
                    WepkgMainProcessService.a(wepkgCrossProcessTask);
                }
            });
        }
    }
}
