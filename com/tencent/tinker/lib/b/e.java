package com.tencent.tinker.lib.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.c.c.d;
import com.tencent.tinker.c.c.f;
import com.tencent.tinker.c.c.g;
import com.tencent.tinker.c.c.g.AnonymousClass1;
import com.tencent.tinker.c.c.h;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class e extends b {
    static boolean c(Context context, String str, String str2, File file) {
        Throwable th;
        g gVar;
        h hVar;
        LargeModeInfo largeModeInfo;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.a(str2, shareResPatchInfo);
        a.i("Tinker.ResDiffPatchInternal", "res dir: %s, meta: %s", new Object[]{str, shareResPatchInfo.toString()});
        com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(context);
        if (SharePatchFileUtil.VU(shareResPatchInfo.xiK)) {
            File file2 = new File(str);
            File file3 = new File(file2, "resources.apk");
            if (!file3.exists()) {
                file3.getParentFile().mkdirs();
            } else if (SharePatchFileUtil.g(file3, shareResPatchInfo.xiK)) {
                a.w("Tinker.ResDiffPatchInternal", "resource file %s is already exist, and md5 match, just return true", new Object[]{file3.getPath()});
                return true;
            } else {
                a.w("Tinker.ResDiffPatchInternal", "have a mismatch corrupted resource " + file3.getPath(), new Object[0]);
                file3.delete();
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo == null) {
                    a.w("Tinker.ResDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                    return false;
                }
                String str3 = applicationInfo.sourceDir;
                if (!a(context, str3, file2, file, shareResPatchInfo, 6)) {
                    return false;
                }
                g gVar2 = null;
                try {
                    g gVar3;
                    h hVar2 = new h(new BufferedOutputStream(new FileOutputStream(file3)));
                    try {
                        gVar3 = new g(str3);
                    } catch (Throwable th2) {
                        th = th2;
                        gVar = null;
                        hVar = hVar2;
                        if (hVar != null) {
                            hVar.close();
                        }
                        if (gVar2 != null) {
                            gVar2.close();
                        }
                        if (gVar != null) {
                            gVar.close();
                        }
                        for (LargeModeInfo largeModeInfo2 : shareResPatchInfo.xiP.values()) {
                            SharePatchFileUtil.W(largeModeInfo2.file);
                        }
                        throw th;
                    }
                    try {
                        f fVar;
                        gVar2 = new g(file);
                        gVar3.cgM();
                        Enumeration anonymousClass1 = new AnonymousClass1(gVar3, gVar3.xfJ.values().iterator());
                        int i = 0;
                        while (anonymousClass1.hasMoreElements()) {
                            fVar = (f) anonymousClass1.nextElement();
                            if (fVar == null) {
                                throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                            }
                            try {
                                String str4 = fVar.name;
                                if (!str4.contains("../")) {
                                    int i2;
                                    if (!ShareResPatchInfo.a(shareResPatchInfo.xiQ, str4) || shareResPatchInfo.xiM.contains(str4) || shareResPatchInfo.xiN.contains(str4) || shareResPatchInfo.xiO.contains(str4) || str4.equals("AndroidManifest.xml")) {
                                        i2 = i;
                                    } else {
                                        com.tencent.tinker.c.b.a.a(gVar3, fVar, hVar2);
                                        i2 = i + 1;
                                    }
                                    i = i2;
                                }
                            } catch (Throwable th22) {
                                th = th22;
                                hVar = hVar2;
                                gVar = gVar2;
                                gVar2 = gVar3;
                            }
                        }
                        fVar = gVar3.VL("AndroidManifest.xml");
                        if (fVar == null) {
                            a.w("Tinker.ResDiffPatchInternal", "manifest patch entry is null. path:AndroidManifest.xml", new Object[0]);
                            hp.xgr.a(file, file3, "AndroidManifest.xml", 6);
                            hVar2.close();
                            gVar3.close();
                            gVar2.close();
                            for (LargeModeInfo largeModeInfo22 : shareResPatchInfo.xiP.values()) {
                                SharePatchFileUtil.W(largeModeInfo22.file);
                            }
                            return false;
                        }
                        String str5;
                        f VL;
                        com.tencent.tinker.c.b.a.a(gVar3, fVar, hVar2);
                        i++;
                        Iterator it = shareResPatchInfo.xiO.iterator();
                        while (it.hasNext()) {
                            str5 = (String) it.next();
                            VL = gVar3.VL(str5);
                            if (VL == null) {
                                a.w("Tinker.ResDiffPatchInternal", "large patch entry is null. path:" + str5, new Object[0]);
                                hp.xgr.a(file, file3, str5, 6);
                                hVar2.close();
                                gVar3.close();
                                gVar2.close();
                                for (LargeModeInfo largeModeInfo222 : shareResPatchInfo.xiP.values()) {
                                    SharePatchFileUtil.W(largeModeInfo222.file);
                                }
                                return false;
                            }
                            largeModeInfo222 = (LargeModeInfo) shareResPatchInfo.xiP.get(str5);
                            com.tencent.tinker.c.b.a.a(VL, largeModeInfo222.file, largeModeInfo222.xfC, hVar2);
                            i++;
                        }
                        it = shareResPatchInfo.xiL.iterator();
                        while (it.hasNext()) {
                            str5 = (String) it.next();
                            VL = gVar2.VL(str5);
                            if (VL == null) {
                                a.w("Tinker.ResDiffPatchInternal", "add patch entry is null. path:" + str5, new Object[0]);
                                hp.xgr.a(file, file3, str5, 6);
                                hVar2.close();
                                gVar3.close();
                                gVar2.close();
                                for (LargeModeInfo largeModeInfo2222 : shareResPatchInfo.xiP.values()) {
                                    SharePatchFileUtil.W(largeModeInfo2222.file);
                                }
                                return false;
                            }
                            com.tencent.tinker.c.b.a.a(gVar2, VL, hVar2);
                            i++;
                        }
                        it = shareResPatchInfo.xiN.iterator();
                        while (it.hasNext()) {
                            str5 = (String) it.next();
                            VL = gVar2.VL(str5);
                            if (VL == null) {
                                a.w("Tinker.ResDiffPatchInternal", "mod patch entry is null. path:" + str5, new Object[0]);
                                hp.xgr.a(file, file3, str5, 6);
                                hVar2.close();
                                gVar3.close();
                                gVar2.close();
                                for (LargeModeInfo largeModeInfo22222 : shareResPatchInfo.xiP.values()) {
                                    SharePatchFileUtil.W(largeModeInfo22222.file);
                                }
                                return false;
                            }
                            com.tencent.tinker.c.b.a.a(gVar2, VL, hVar2);
                            i++;
                        }
                        gVar3.cgM();
                        str5 = gVar3.ubd;
                        if (str5 == null) {
                            hVar2.xfU = h.xfQ;
                        } else {
                            byte[] bytes = str5.getBytes(d.UTF_8);
                            h.y("Comment", bytes);
                            hVar2.xfU = bytes;
                        }
                        hVar2.close();
                        gVar3.close();
                        gVar2.close();
                        for (LargeModeInfo largeModeInfo222222 : shareResPatchInfo.xiP.values()) {
                            SharePatchFileUtil.W(largeModeInfo222222.file);
                        }
                        if (SharePatchFileUtil.g(file3, shareResPatchInfo.xiK)) {
                            a.i("Tinker.ResDiffPatchInternal", "final new resource file:%s, entry count:%d, size:%d", new Object[]{file3.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file3.length())});
                            return true;
                        }
                        a.i("Tinker.ResDiffPatchInternal", "check final new resource file fail path:%s, entry count:%d, size:%d", new Object[]{file3.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file3.length())});
                        SharePatchFileUtil.W(file3);
                        hp.xgr.a(file, file3, "resources.apk", 6);
                        return false;
                    } catch (Throwable th222) {
                        th = th222;
                        gVar2 = gVar3;
                        gVar = null;
                        hVar = hVar2;
                        if (hVar != null) {
                            hVar.close();
                        }
                        if (gVar2 != null) {
                            gVar2.close();
                        }
                        if (gVar != null) {
                            gVar.close();
                        }
                        while (r4.hasNext()) {
                            SharePatchFileUtil.W(largeModeInfo222222.file);
                        }
                        throw th;
                    }
                } catch (Throwable th2222) {
                    th = th2222;
                    gVar = null;
                    hVar = null;
                    if (hVar != null) {
                        hVar.close();
                    }
                    if (gVar2 != null) {
                        gVar2.close();
                    }
                    if (gVar != null) {
                        gVar.close();
                    }
                    while (r4.hasNext()) {
                        SharePatchFileUtil.W(largeModeInfo222222.file);
                    }
                    throw th;
                }
            } catch (Throwable th22222) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("patch " + ShareTinkerInternals.DZ(6) + " extract failed (" + th22222.getMessage() + ").", th22222);
            }
        } else {
            a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, md5: %s", new Object[]{ShareTinkerInternals.DZ(6), shareResPatchInfo.xiK});
            hp.xgr.d(file, b.DV(6));
            return false;
        }
    }

    private static boolean a(Context context, String str, File file, File file2, ShareResPatchInfo shareResPatchInfo, int i) {
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(context);
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3;
        ZipFile zipFile4;
        try {
            zipFile3 = new ZipFile(str);
            try {
                Closeable closeable;
                Closeable closeable2;
                ZipEntry entry = zipFile3.getEntry("resources.arsc");
                File file3 = new File(file, "resources.arsc");
                if (entry == null) {
                    a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:resources.arsc", new Object[0]);
                    hp.xgr.a(file2, file3, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                }
                if (!String.valueOf(entry.getCrc()).equals(shareResPatchInfo.xiJ)) {
                    a.e("Tinker.ResDiffPatchInternal", "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", new Object[]{shareResPatchInfo.xiJ, String.valueOf(entry.getCrc())});
                    hp.xgr.a(file2, file3, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                } else if (shareResPatchInfo.xiO.isEmpty()) {
                    a.i("Tinker.ResDiffPatchInternal", "no large modify resources, just return", new Object[0]);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return true;
                } else {
                    Iterator it = shareResPatchInfo.xiO.iterator();
                    zipFile = null;
                    while (it.hasNext()) {
                        try {
                            String str2 = (String) it.next();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.xiP.get(str2);
                            if (largeModeInfo == null) {
                                a.w("Tinker.ResDiffPatchInternal", "resource not found largeModeInfo, type:%s, name: %s", new Object[]{ShareTinkerInternals.DZ(6), str2});
                                hp.xgr.d(file2, b.DV(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile);
                                return false;
                            }
                            largeModeInfo.file = new File(file, str2);
                            SharePatchFileUtil.Y(largeModeInfo.file);
                            if (SharePatchFileUtil.VU(largeModeInfo.fFW)) {
                                zipFile4 = new ZipFile(file2);
                                try {
                                    ZipEntry entry2 = zipFile4.getEntry(str2);
                                    if (entry2 == null) {
                                        a.w("Tinker.ResDiffPatchInternal", "large mod patch entry is null. path:" + str2, new Object[0]);
                                        hp.xgr.a(file2, largeModeInfo.file, str2, 6);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile4);
                                        return false;
                                    }
                                    ZipEntry entry3 = zipFile3.getEntry(str2);
                                    if (entry3 == null) {
                                        a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:" + str2, new Object[0]);
                                        hp.xgr.a(file2, largeModeInfo.file, str2, 6);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile4);
                                        return false;
                                    }
                                    Closeable closeable3 = null;
                                    closeable = null;
                                    try {
                                        closeable3 = zipFile3.getInputStream(entry3);
                                        try {
                                            closeable = zipFile4.getInputStream(entry2);
                                            try {
                                                com.tencent.tinker.b.a.a(closeable3, closeable, largeModeInfo.file);
                                                SharePatchFileUtil.c(closeable3);
                                                SharePatchFileUtil.c(closeable);
                                                if (SharePatchFileUtil.e(largeModeInfo.file, largeModeInfo.fFW)) {
                                                    a.w("Tinker.ResDiffPatchInternal", "success recover large modify file:%s, file size:%d, use time:%d", new Object[]{largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                                                    zipFile = zipFile4;
                                                } else {
                                                    a.w("Tinker.ResDiffPatchInternal", "Failed to recover large modify file:%s", new Object[]{largeModeInfo.file.getPath()});
                                                    SharePatchFileUtil.W(largeModeInfo.file);
                                                    hp.xgr.a(file2, largeModeInfo.file, str2, 6);
                                                    SharePatchFileUtil.a(zipFile3);
                                                    SharePatchFileUtil.a(zipFile4);
                                                    return false;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                closeable2 = closeable;
                                                closeable = closeable3;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            closeable2 = closeable;
                                            closeable = closeable3;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        closeable2 = closeable;
                                        closeable = closeable3;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            } else {
                                a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.DZ(6), str2, largeModeInfo.fFW});
                                hp.xgr.d(file2, b.DV(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile);
                                return false;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            zipFile4 = zipFile;
                        }
                    }
                    a.w("Tinker.ResDiffPatchInternal", "success recover all large modify use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(zipFile);
                    return true;
                }
                SharePatchFileUtil.c(closeable);
                SharePatchFileUtil.c(closeable2);
                throw th;
            } catch (Throwable th7) {
                th = th7;
                zipFile4 = null;
                SharePatchFileUtil.a(zipFile3);
                SharePatchFileUtil.a(zipFile4);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.a(zipFile3);
            SharePatchFileUtil.a(zipFile4);
            throw th;
        }
    }
}
