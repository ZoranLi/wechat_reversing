package com.tencent.tinker.lib.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.c.c.f;
import com.tencent.tinker.c.c.g;
import com.tencent.tinker.c.c.h;
import com.tencent.tinker.lib.d.a;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class d extends b {
    private static ArrayList<File> xgb = new ArrayList();
    private static ArrayList<ShareDexDiffPatchInfo> xgc = new ArrayList();
    private static HashMap<ShareDexDiffPatchInfo, File> xgd = new HashMap();
    private static boolean xge = ShareTinkerInternals.cgV();

    protected static boolean a(a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (ShareTinkerInternals.DW(aVar.tinkerFlags)) {
            String str2 = (String) shareSecurityCheck.xiS.get("assets/dex_meta.txt");
            if (str2 == null) {
                com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
                return true;
            }
            boolean a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = str + "/dex/";
            if (b(context, str3, str2, file)) {
                File[] listFiles = new File(str3).listFiles();
                a = a(context, listFiles != null ? Arrays.asList(listFiles) : null, str + "/odex/", file);
            } else {
                com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                a = false;
            }
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", new Object[]{Boolean.valueOf(a), Long.valueOf(elapsedRealtime)});
            return a;
        }
        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
        return true;
    }

    protected static boolean a(File file, a aVar) {
        if (xgb.isEmpty()) {
            return true;
        }
        int size = xgc.size() * 8;
        if (size > 30) {
            size = 30;
        }
        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", new Object[]{Integer.valueOf(xgc.size()), Integer.valueOf(xgb.size()), Integer.valueOf(size)});
        for (int i = 0; i < size; i++) {
            int i2;
            int i3 = i + 1;
            Iterator it = xgb.iterator();
            while (it.hasNext()) {
                if (!SharePatchFileUtil.U((File) it.next())) {
                    com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", new Object[]{((File) it.next()).getName(), Integer.valueOf(i3)});
                    i2 = 0;
                    break;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:" + e, new Object[0]);
                }
            }
        }
        List arrayList = new ArrayList();
        Iterator it2 = xgb.iterator();
        while (it2.hasNext()) {
            File file2 = (File) it2.next();
            com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", new Object[]{file2.getPath(), Long.valueOf(file2.length())});
            if (!SharePatchFileUtil.U(file2)) {
                com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", new Object[]{file2.getName()});
                arrayList.add(file2);
            }
        }
        if (arrayList.isEmpty()) {
            if (VERSION.SDK_INT >= 21) {
                Iterator it3 = xgb.iterator();
                Throwable th = null;
                while (it3.hasNext()) {
                    file2 = (File) it3.next();
                    com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", new Object[]{file2.getName(), Long.valueOf(file2.length())});
                    try {
                        if (ShareElfFile.S(file2) == 1) {
                            try {
                                try {
                                    new ShareElfFile(file2).close();
                                } catch (IOException e2) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not elf format, return false", new Object[]{file2.getName()});
                                arrayList.add(file2);
                            }
                        } else {
                            continue;
                        }
                    } catch (IOException e3) {
                    }
                }
                if (!arrayList.isEmpty()) {
                    aVar.xgr.a(file, arrayList, th == null ? new TinkerRuntimeException("checkDexOptFormat failed") : new TinkerRuntimeException("checkDexOptFormat failed", th));
                    return false;
                }
            }
            return true;
        }
        aVar.xgr.a(file, arrayList, new TinkerRuntimeException("checkDexOptExist failed"));
        return false;
    }

    private static boolean VN(String str) {
        File file = null;
        if (xgc.isEmpty() || !xge) {
            return false;
        }
        File file2;
        Iterator it = xgc.iterator();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2;
            File file3;
            ShareDexDiffPatchInfo shareDexDiffPatchInfo3 = (ShareDexDiffPatchInfo) it.next();
            file2 = new File(str + shareDexDiffPatchInfo3.gTY);
            if (ShareConstants.xhA.matcher(file2.getName()).matches()) {
                xgd.put(shareDexDiffPatchInfo3, file2);
            }
            if (shareDexDiffPatchInfo3.xhB.startsWith("test.dex")) {
                File file4 = file2;
                shareDexDiffPatchInfo2 = shareDexDiffPatchInfo3;
                file3 = file4;
            } else {
                file3 = file;
                shareDexDiffPatchInfo2 = shareDexDiffPatchInfo;
            }
            file = file3;
            shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
        }
        if (shareDexDiffPatchInfo != null) {
            xgd.put(ShareTinkerInternals.a(shareDexDiffPatchInfo, xgd.size() + 1), file);
        }
        file2 = new File(str, "tinker_classN.apk");
        if (!file2.exists()) {
            return false;
        }
        boolean z;
        for (ShareDexDiffPatchInfo shareDexDiffPatchInfo32 : xgd.keySet()) {
            if (!SharePatchFileUtil.b(file2, shareDexDiffPatchInfo32.xhB, shareDexDiffPatchInfo32.xhD)) {
                com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[]{shareDexDiffPatchInfo32.xhB, Long.valueOf(file2.length())});
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            return z;
        }
        SharePatchFileUtil.W(file2);
        return z;
    }

    private static boolean a(Context context, File file, String str) {
        InputStream a;
        boolean z;
        Throwable th;
        if (xgc.isEmpty() || !xge) {
            return true;
        }
        File file2 = new File(str, "tinker_classN.apk");
        if (xgd.isEmpty()) {
            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "classNDexInfo size: %d, no need to merge classN dex files", new Object[]{Integer.valueOf(xgd.size())});
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Closeable closeable = null;
        Closeable hVar;
        try {
            hVar = new h(new BufferedOutputStream(new FileOutputStream(file2)));
            try {
                for (ShareDexDiffPatchInfo shareDexDiffPatchInfo : xgd.keySet()) {
                    File file3 = (File) xgd.get(shareDexDiffPatchInfo);
                    if (shareDexDiffPatchInfo.xhI) {
                        g gVar = new g(file3);
                        f VL = gVar.VL("classes.dex");
                        f fVar = new f(VL, shareDexDiffPatchInfo.xhB);
                        a = gVar.a(VL);
                        com.tencent.tinker.c.b.a.a(fVar, a, (h) hVar);
                        SharePatchFileUtil.c(a);
                    } else {
                        com.tencent.tinker.c.b.a.a(new f(shareDexDiffPatchInfo.xhB), file3, Long.parseLong(shareDexDiffPatchInfo.xhF), hVar);
                    }
                }
                SharePatchFileUtil.c(hVar);
                z = true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            hVar = null;
            SharePatchFileUtil.c(hVar);
            throw th;
        }
        if (z) {
            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo2 : xgd.keySet()) {
                if (SharePatchFileUtil.b(file2, shareDexDiffPatchInfo2.xhB, shareDexDiffPatchInfo2.xhD)) {
                    com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[]{shareDexDiffPatchInfo2.xhB, Long.valueOf(file2.length())});
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            while (r3.hasNext()) {
                SharePatchFileUtil.W(r0);
            }
        } else {
            com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "merge classN dex error, try delete temp file", new Object[0]);
            SharePatchFileUtil.W(file2);
            a.hp(context).xgr.a(file, file2, file2.getName(), 7);
        }
        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "merge classN dex file %s, result: %b, size: %d, use: %dms", new Object[]{file2.getPath(), Boolean.valueOf(z), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return z;
    }

    private static boolean a(Context context, List<File> list, String str, File file) {
        a hp = a.hp(context);
        xgb.clear();
        if (list != null) {
            File file2 = new File(str);
            if (file2.exists() || file2.mkdirs()) {
                for (File l : list) {
                    xgb.add(new File(SharePatchFileUtil.l(l, file2)));
                }
                com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[]{Integer.valueOf(list.size()), str});
                final List vector = new Vector();
                final Throwable[] thArr = new Throwable[1];
                TinkerDexOptimizer.a(list, file2, new ResultCallback() {
                    long startTime;

                    public final void N(File file) {
                        this.startTime = System.currentTimeMillis();
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", new Object[]{file.getPath(), Long.valueOf(file.length())});
                    }

                    public final void j(File file, File file2) {
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", new Object[]{file.getPath(), file2.getPath(), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                    }

                    public final void b(File file, Throwable th) {
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", new Object[]{file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                        vector.add(file);
                        thArr[0] = th;
                    }
                });
                if (!vector.isEmpty()) {
                    hp.xgr.a(file, vector, thArr[0]);
                    return false;
                }
            }
            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
            return false;
        }
        return true;
    }

    private static boolean b(Context context, String str, String str2, File file) {
        Throwable th;
        ZipFile zipFile;
        Throwable th2;
        xgc.clear();
        ShareDexDiffPatchInfo.k(str2, xgc);
        if (xgc.isEmpty()) {
            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", new Object[]{ShareTinkerInternals.DZ(3)});
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        a hp = a.hp(context);
        ZipFile zipFile2;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                SharePatchFileUtil.a(null);
                SharePatchFileUtil.a(null);
                return false;
            }
            ZipFile zipFile3 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile2 = new ZipFile(file);
                try {
                    if (VN(str)) {
                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "class n dex file %s is already exist, and md5 match, just continue", new Object[]{"tinker_classN.apk"});
                        SharePatchFileUtil.a(zipFile3);
                        SharePatchFileUtil.a(zipFile2);
                        return true;
                    }
                    Iterator it = xgc.iterator();
                    while (it.hasNext()) {
                        String str3;
                        ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (shareDexDiffPatchInfo.path.equals("")) {
                            str3 = shareDexDiffPatchInfo.xhB;
                        } else {
                            str3 = shareDexDiffPatchInfo.path + "/" + shareDexDiffPatchInfo.xhB;
                        }
                        String str4 = shareDexDiffPatchInfo.xhG;
                        String str5 = shareDexDiffPatchInfo.xhE;
                        if (xge || !shareDexDiffPatchInfo.xhC.equals("0")) {
                            String str6 = xge ? shareDexDiffPatchInfo.xhD : shareDexDiffPatchInfo.xhC;
                            if (SharePatchFileUtil.VU(str6)) {
                                File file3 = new File(str + shareDexDiffPatchInfo.gTY);
                                if (!file3.exists()) {
                                    file3.getParentFile().mkdirs();
                                } else if (SharePatchFileUtil.f(file3, str6)) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", new Object[]{file3.getPath()});
                                } else {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                    file3.delete();
                                }
                                ZipEntry entry = zipFile2.getEntry(str3);
                                ZipEntry entry2 = zipFile3.getEntry(str3);
                                if (str5.equals("0")) {
                                    if (entry == null) {
                                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                        hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile2);
                                        return false;
                                    } else if (!a(zipFile2, entry, file3, shareDexDiffPatchInfo)) {
                                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                        hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile2);
                                        return false;
                                    }
                                } else if (str4.equals("0")) {
                                    if (!xge) {
                                        continue;
                                    } else if (entry2 == null) {
                                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                        hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                        SharePatchFileUtil.a(zipFile3);
                                        SharePatchFileUtil.a(zipFile2);
                                        return false;
                                    } else {
                                        if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                            a(zipFile3, entry2, file3, shareDexDiffPatchInfo);
                                            if (!SharePatchFileUtil.f(file3, str6)) {
                                                com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                                SharePatchFileUtil.W(file3);
                                                SharePatchFileUtil.a(zipFile3);
                                                SharePatchFileUtil.a(zipFile2);
                                                return false;
                                            }
                                        } else {
                                            com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                            hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                            SharePatchFileUtil.a(zipFile3);
                                            SharePatchFileUtil.a(zipFile2);
                                            return false;
                                        }
                                    }
                                } else if (entry == null) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                    hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                } else if (!SharePatchFileUtil.VU(str4)) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.DZ(3), shareDexDiffPatchInfo.xhB, str4});
                                    hp.xgr.d(file, b.DV(3));
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                } else if (entry2 == null) {
                                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                    hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                } else {
                                    if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                        a(zipFile3, zipFile2, entry2, entry, shareDexDiffPatchInfo, file3);
                                        if (SharePatchFileUtil.f(file3, str6)) {
                                            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, size: %d, use time: %d", new Object[]{file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                        } else {
                                            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                            hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                            SharePatchFileUtil.W(file3);
                                            SharePatchFileUtil.a(zipFile3);
                                            SharePatchFileUtil.a(zipFile2);
                                            return false;
                                        }
                                    }
                                    com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                    hp.xgr.a(file, file3, shareDexDiffPatchInfo.xhB, 3);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile2);
                                    return false;
                                }
                            }
                            com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.DZ(3), shareDexDiffPatchInfo.xhB, str6});
                            hp.xgr.d(file, b.DV(3));
                            SharePatchFileUtil.a(zipFile3);
                            SharePatchFileUtil.a(zipFile2);
                            return false;
                        }
                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", new Object[]{str3});
                    }
                    if (a(context, file, str)) {
                        SharePatchFileUtil.a(zipFile3);
                        SharePatchFileUtil.a(zipFile2);
                        return true;
                    }
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(zipFile2);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    zipFile = zipFile3;
                    th2 = th;
                }
            } catch (Throwable th4) {
                th = th4;
                zipFile2 = null;
                zipFile = zipFile3;
                th2 = th;
                SharePatchFileUtil.a(zipFile);
                SharePatchFileUtil.a(zipFile2);
                throw th2;
            }
        } catch (Throwable th5) {
            th2 = th5;
            zipFile = null;
            zipFile2 = null;
            SharePatchFileUtil.a(zipFile);
            SharePatchFileUtil.a(zipFile2);
            throw th2;
        }
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        int i = 0;
        while (i < 2 && !z) {
            Closeable bufferedInputStream;
            int i2 = i + 1;
            OutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                Closeable zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[16384];
                        zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                        for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.closeEntry();
                        SharePatchFileUtil.c(bufferedInputStream);
                        SharePatchFileUtil.c(zipOutputStream);
                        z = SharePatchFileUtil.f(file, str);
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", new Object[]{Boolean.valueOf(z)});
                        if (!z) {
                            file.delete();
                            if (file.exists()) {
                                com.tencent.tinker.lib.e.a.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                            }
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = zipOutputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                    closeable = zipOutputStream;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        }
        return z;
        SharePatchFileUtil.c(bufferedInputStream);
        SharePatchFileUtil.c(closeable);
        throw th;
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        String str = xge ? shareDexDiffPatchInfo.xhD : shareDexDiffPatchInfo.xhC;
        String str2 = shareDexDiffPatchInfo.xhB;
        boolean z = shareDexDiffPatchInfo.xhI;
        if (SharePatchFileUtil.VV(str2) && z) {
            return a(zipFile, zipEntry, file, str);
        }
        return b.a(zipFile, zipEntry, file, str, true);
    }

    private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
        Throwable th;
        Closeable closeable;
        Closeable closeable2;
        OutputStream outputStream = null;
        try {
            InputStream bufferedInputStream;
            InputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            if (zipEntry2 != null) {
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                } catch (Throwable th2) {
                    th = th2;
                    Object obj = bufferedInputStream2;
                    SharePatchFileUtil.c(closeable);
                    SharePatchFileUtil.c(closeable2);
                    throw th;
                }
            }
            Closeable closeable3 = null;
            try {
                boolean VV = SharePatchFileUtil.VV(shareDexDiffPatchInfo.xhB);
                if (!VV || shareDexDiffPatchInfo.xhI) {
                    try {
                        Closeable zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                            if (VV) {
                                new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream).b(zipOutputStream);
                            } else {
                                try {
                                    ZipEntry nextEntry;
                                    InputStream zipInputStream = new ZipInputStream(bufferedInputStream2);
                                    do {
                                        try {
                                            nextEntry = zipInputStream.getNextEntry();
                                            if (nextEntry == null) {
                                                break;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    } while (!"classes.dex".equals(nextEntry.getName()));
                                    if (nextEntry == null) {
                                        throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                    }
                                    new com.tencent.tinker.c.a.a(zipInputStream, bufferedInputStream).b(zipOutputStream);
                                    SharePatchFileUtil.c(zipInputStream);
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable = null;
                                    SharePatchFileUtil.c(closeable);
                                    throw th;
                                }
                            }
                            zipOutputStream.closeEntry();
                            SharePatchFileUtil.c(zipOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            closeable2 = zipOutputStream;
                            SharePatchFileUtil.c(closeable2);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        SharePatchFileUtil.c(closeable2);
                        throw th;
                    }
                }
                com.tencent.tinker.c.a.a aVar = new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream);
                try {
                    OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        aVar.b(bufferedOutputStream);
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        outputStream = bufferedOutputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
                SharePatchFileUtil.c(bufferedInputStream2);
                SharePatchFileUtil.c(bufferedInputStream);
            } catch (Throwable th9) {
                th = th9;
                closeable2 = bufferedInputStream;
                closeable = bufferedInputStream2;
            }
        } catch (Throwable th10) {
            th = th10;
            closeable = null;
            SharePatchFileUtil.c(closeable);
            SharePatchFileUtil.c(closeable2);
            throw th;
        }
    }
}
