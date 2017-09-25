package com.tencent.mm.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.wcdb.database.SQLiteDatabase;
import dalvik.system.PathClassLoader;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static boolean fBW = false;
    private static String fBX;
    private static String fBY;
    private static String fBZ;
    private static Set<a> fCa;
    private static final boolean fCb = bA(System.getProperty("java.vm.version"));

    private static class a {
        String fCc;
        String fCd;
        String fCe;

        public a(String str, String str2, String str3) {
            this.fCc = str;
            this.fCd = str2;
            this.fCe = str3;
        }
    }

    private static final class b {
        static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method a;
            try {
                a = a.a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                w.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    a = a.a(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    w.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    try {
                        a = a.a(obj, "makePathElements", List.class, File.class, List.class);
                    } catch (NoSuchMethodException e3) {
                        w.e("MicroMsg.MultiDex", "NoSuchMethodException: makePathElements(List,File,List) failure");
                        throw e3;
                    }
                }
            }
            return (Object[]) a.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    public static boolean b(Context context, boolean z) {
        w.i("MicroMsg.MultiDex", "install multidex hasinit: %b, force: %b", Boolean.valueOf(fBW), Boolean.valueOf(z));
        if (fCb) {
            w.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return true;
        } else if (fBW) {
            return true;
        } else {
            if (context.getClassLoader() != null) {
                w.i("MicroMsg.MultiDex", "classloader: " + context.getClassLoader().toString());
            } else {
                w.e("MicroMsg.MultiDex", "classloader is null");
            }
            long currentTimeMillis = System.currentTimeMillis();
            an(context);
            if (fCa == null || fCa.size() <= 0) {
                return false;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return false;
            }
            fBX = context.getDir("cache", 0).getAbsolutePath();
            fBY = context.getDir("dex", 0).getAbsolutePath();
            fBZ = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
            File file = new File(fBY);
            if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                int size = fCa.size();
                File file2 = new File(fBX);
                if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                    w.i("MicroMsg.MultiDex", "install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                    if (z || (file.list().length >= size && file2.list().length >= size)) {
                        List arrayList = new ArrayList(fCa.size());
                        Object obj = null;
                        for (int i = 0; i < 5 && r0 == null; i++) {
                            arrayList.clear();
                            for (a aVar : fCa) {
                                w.i("MicroMsg.MultiDex", "prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.fCc, aVar.fCd, aVar.fCe);
                                if (a(aVar)) {
                                    w.i("MicroMsg.MultiDex", "verify dex for check md5: targetFilePath: [%s] time: %d", aVar.fCc, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    if (b(context, aVar.fCe, false)) {
                                        w.i("MicroMsg.MultiDex", "dex has been loaded, skip. targetFilePath: [%s]", aVar.fCc);
                                    } else {
                                        try {
                                            w.w("MicroMsg.MultiDex", "dex [%s] is not load, it should be reload in further steps.", aVar.fCc);
                                        } catch (Exception e) {
                                            w.w("MicroMsg.MultiDex", "base apk file close quietly failed");
                                        } catch (Throwable th) {
                                            long blockSize;
                                            Throwable th2 = th;
                                            w.e("MicroMsg.MultiDex", "Multidex installation failure", th2);
                                            w.printErrStackTrace("MicroMsg.MultiDex", th2, "Multidex installation failure", new Object[0]);
                                            long j = 0;
                                            try {
                                                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                                                j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
                                                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
                                            } catch (Exception e2) {
                                                blockSize = 0;
                                                w.e("MicroMsg.MultiDex", "get db spare space error");
                                            }
                                            w.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(j), Long.valueOf(blockSize));
                                            if (blockSize != 0 && j < 31457280) {
                                                String q = d.q(context, Process.myPid());
                                                w.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", q, Long.valueOf(j), Long.valueOf(31457280));
                                                if (!(q.equals("") || q.endsWith(":nospace"))) {
                                                    Intent intent = new Intent();
                                                    intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                                                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                                    context.startActivity(intent);
                                                    Process.killProcess(Process.myPid());
                                                }
                                            }
                                            RuntimeException runtimeException = new RuntimeException("Multi dex installation failed (" + th2.getMessage() + ").", th2);
                                        }
                                    }
                                } else {
                                    w.e("MicroMsg.MultiDex", "targetDexFile md5 mismatch or not exists: %s, force: %b", aVar.fCc, Boolean.valueOf(z));
                                    if (z) {
                                        ZipFile zipFile = new ZipFile(applicationInfo.sourceDir);
                                        boolean a = a(zipFile, aVar);
                                        zipFile.close();
                                        if (!a) {
                                            throw new Exception("overwriteLocalSecondaryDexFromApk fail");
                                        }
                                    }
                                    w.w("MicroMsg.MultiDex", "skip rest steps in non-force mode with any dexes' md5 mismatching.");
                                    return false;
                                }
                                arrayList.add(new File(fBY + "/" + aVar.fCc));
                            }
                            if (arrayList.isEmpty()) {
                                w.i("MicroMsg.MultiDex", "Nothing needs to be installed.");
                                obj = 1;
                                break;
                            }
                            a(context, fBX, arrayList);
                            for (a aVar2 : fCa) {
                                if (!b(context, aVar2.fCe, true)) {
                                    w.w("MicroMsg.MultiDex", "Failed to load dex [%s] in %d round, retry.", aVar2.fCc, Integer.valueOf(i + 1));
                                    String name = new File(fBY + "/" + aVar2.fCc).getName();
                                    if (!name.endsWith(".dex")) {
                                        size = name.lastIndexOf(".");
                                        if (size < 0) {
                                            name = name + ".dex";
                                        } else {
                                            StringBuilder stringBuilder = new StringBuilder(size + 4);
                                            stringBuilder.append(name, 0, size);
                                            stringBuilder.append(".dex");
                                            name = stringBuilder.toString();
                                        }
                                    }
                                    File file3 = new File(file2, name);
                                    if (file3.exists()) {
                                        w.w("MicroMsg.MultiDex", "Remove perhaps broken odex file: " + file3.getAbsolutePath());
                                        if (!file3.delete()) {
                                            w.w("MicroMsg.MultiDex", "Failed to remove perhaps broken odex file: " + file3.getAbsolutePath());
                                        }
                                    }
                                    obj = null;
                                }
                            }
                            int i2 = 1;
                        }
                        if (obj == null) {
                            throw new RuntimeException("Some dex is not installed successfully after 5 times retry !!");
                        }
                        fBW = true;
                        w.i("MicroMsg.MultiDex", "install done");
                        return true;
                    }
                    w.w("MicroMsg.MultiDex", "just return load later force:%b", Boolean.valueOf(z));
                    return false;
                }
                w.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dexopt directory failed");
                return false;
            }
            w.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dex directory failed");
            return false;
        }
    }

    private static boolean b(Context context, String str, boolean z) {
        try {
            if (Class.forName(str, false, context.getClassLoader()) != null) {
                return true;
            }
        } catch (Throwable e) {
            if (z) {
                w.printErrStackTrace("MicroMsg.MultiDex", e, "Failed to load a dex.", new Object[0]);
            }
        }
        if (!z) {
            return false;
        }
        w.w("MicroMsg.MultiDex", "checkDexLoaded fail.... " + str);
        return false;
    }

    private static boolean a(ZipFile zipFile, a aVar) {
        w.i("MicroMsg.MultiDex", "enter overwriteLocalSecondaryDexFromApk, please keep concerned at which process calls it.");
        File file = new File(fBZ);
        String str = fBY + "/" + aVar.fCc;
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            shareFileLockHelper = ShareFileLockHelper.T(file);
            w.i("MicroMsg.MultiDex", "extract dex waiting for write lock cost %dms on file: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), fBZ);
            Closeable inputStream = zipFile.getInputStream(zipFile.getEntry(aVar.fCc));
            BufferedOutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.close();
                c(inputStream);
                w.i("MicroMsg.MultiDex", "extract dex from apk done: %s", fBZ);
                try {
                    shareFileLockHelper.close();
                    return true;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    return true;
                }
            } catch (Throwable th) {
                c(inputStream);
            }
        } catch (Throwable e2) {
            try {
                w.printErrStackTrace("MicroMsg.MultiDex", e2, "", new Object[0]);
                w.e("MicroMsg.MultiDex", "overwrite local secondary dex failed, cannot lock file: %s", file.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.MultiDex", e22, "", new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e3) {
                        w.printErrStackTrace("MicroMsg.MultiDex", e3, "", new Object[0]);
                    }
                }
            }
        }
    }

    private static boolean bA(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        w.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static boolean a(a aVar) {
        ShareFileLockHelper T;
        Closeable fileInputStream;
        Throwable e;
        ShareFileLockHelper shareFileLockHelper = null;
        String str = fBY + "/" + aVar.fCc;
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            File file2 = new File(fBZ);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                T = ShareFileLockHelper.T(file2);
                try {
                    w.i("MicroMsg.MultiDex", "extract dex waiting for verify lock cost %dms on file: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), fBZ);
                    fileInputStream = new FileInputStream(str);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                    shareFileLockHelper = T;
                    try {
                        w.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                        w.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                        if (shareFileLockHelper != null) {
                            try {
                                shareFileLockHelper.close();
                            } catch (Exception e3) {
                                w.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        c(fileInputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        T = shareFileLockHelper;
                        if (T != null) {
                            try {
                                T.close();
                            } catch (Exception e4) {
                                w.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        c(fileInputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (T != null) {
                        T.close();
                    }
                    c(fileInputStream);
                    throw e;
                }
                try {
                    str = g.a(fileInputStream, 102400);
                    if (str == null || !str.equalsIgnoreCase(aVar.fCd)) {
                        try {
                            T.close();
                        } catch (Exception e5) {
                            w.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                        c(fileInputStream);
                        return false;
                    }
                    try {
                        T.close();
                    } catch (Exception e6) {
                        w.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                    }
                    c(fileInputStream);
                    return true;
                } catch (IOException e7) {
                    e = e7;
                    shareFileLockHelper = T;
                    w.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    w.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                    if (shareFileLockHelper != null) {
                        shareFileLockHelper.close();
                    }
                    c(fileInputStream);
                    return false;
                } catch (Throwable th3) {
                    e = th3;
                    if (T != null) {
                        T.close();
                    }
                    c(fileInputStream);
                    throw e;
                }
            } catch (IOException e8) {
                e = e8;
                fileInputStream = null;
                w.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                w.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    shareFileLockHelper.close();
                }
                c(fileInputStream);
                return false;
            } catch (Throwable th4) {
                e = th4;
                fileInputStream = null;
                T = null;
                if (T != null) {
                    T.close();
                }
                c(fileInputStream);
                throw e;
            }
        }
        w.i("MicroMsg.MultiDex", "dex file not exist: %s", str);
        return false;
    }

    private static void a(Context context, String str, List<File> list) {
        Object obj = (PathClassLoader) context.getClassLoader();
        w.i("MicroMsg.MultiDex", "before reflectPathClassLoader for debug: ClassLoader " + obj);
        Collections.sort(list, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file == null || file2 == null) {
                    return 0;
                }
                String name = file.getName();
                String name2 = file2.getName();
                return (name.contains("classes") && name2.contains("classes")) ? name.charAt(7) - name2.charAt(7) : 0;
            }
        });
        for (File name : list) {
            w.i("MicroMsg.MultiDex", "real reflectPathClassLoader dexname: " + name.getName());
        }
        File name2 = new File(str);
        if (!list.isEmpty()) {
            Object obj2;
            if (VERSION.SDK_INT >= 19) {
                obj2 = a(obj, "pathList").get(obj);
                ArrayList arrayList = new ArrayList();
                a(obj2, "dexElements", b.a(obj2, new ArrayList(list), name2, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        w.w("MicroMsg.MultiDex", "Exception in makeDexElement", (IOException) it.next());
                        throw ((IOException) it.next());
                    }
                }
            }
            obj2 = a(obj, "pathList").get(obj);
            ArrayList arrayList2 = new ArrayList(list);
            a(obj2, "dexElements", (Object[]) a(obj2, "makeDexElements", ArrayList.class, File.class).invoke(obj2, new Object[]{arrayList2, name2}));
        }
        w.i("MicroMsg.MultiDex", "after reflectPathClassloader for debug: ClassLoader " + obj);
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                w.w("MicroMsg.MultiDex", "Failed to close resource", e);
            }
        }
    }

    private static int an(Context context) {
        if (fCa != null) {
            w.w("MicroMsg.MultiDex", "preloaded dex files not empty, skipped preloading");
            return 1;
        }
        try {
            Set set;
            String convertStreamToString = d.convertStreamToString(context.getAssets().open("secondary-program-dex-jars/metadata.txt"));
            if (convertStreamToString == null || convertStreamToString.length() <= 0) {
                set = null;
            } else {
                set = new HashSet();
                for (String str : convertStreamToString.split("\n")) {
                    if (str != null && str.length() > 0) {
                        String[] split = str.split(" ", 3);
                        if (split != null && split.length >= 3) {
                            String trim = split[0].trim();
                            w.i("MicroMsg.MultiDex", "try parse dexname: %s, dexmd5:%s, classname:%s", trim, split[1].trim(), split[2].trim());
                            if (trim != null && trim.length() > 0) {
                                set.add(new a(trim, r7, str));
                            }
                        }
                    }
                }
            }
            fCa = set;
        } catch (Throwable e) {
            w.e("MicroMsg.MultiDex", "load preload libraries failed");
            w.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
        }
        return 0;
    }

    private static Field a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void a(Object obj, String str, Object[] objArr) {
        Field a = a(obj, str);
        Object[] objArr2 = (Object[]) a.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        a.set(obj, objArr3);
    }
}
