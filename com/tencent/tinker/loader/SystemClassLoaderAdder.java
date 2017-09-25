package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.zip.ZipFile;

public class SystemClassLoaderAdder {
    private static int xha = 0;

    private static final class V14 {
        private V14() {
        }

        public static void a(ClassLoader classLoader, List<File> list, File file) {
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList(list);
            ShareReflectUtil.a(obj, "dexElements", (Object[]) ShareReflectUtil.a(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file}));
        }
    }

    private static final class V19 {
        private V19() {
        }

        public static void a(ClassLoader classLoader, List<File> list, File file) {
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw ((IOException) it.next());
                }
            }
        }

        public static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method a;
            try {
                a = ShareReflectUtil.a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                try {
                    a = ShareReflectUtil.a(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    throw e2;
                }
            }
            return (Object[]) a.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class V23 {
        private V23() {
        }

        public static void a(ClassLoader classLoader, List<File> list, File file) {
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.a(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw ((IOException) it.next());
                }
            }
        }

        private static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method a;
            try {
                a = ShareReflectUtil.a(obj, "makePathElements", List.class, File.class, List.class);
            } catch (NoSuchMethodException e) {
                try {
                    a = ShareReflectUtil.a(obj, "makePathElements", ArrayList.class, File.class, ArrayList.class);
                } catch (NoSuchMethodException e2) {
                    try {
                        return V19.a(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e3) {
                        throw e3;
                    }
                }
            }
            return (Object[]) a.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class V4 {
        private V4() {
        }

        public static void a(ClassLoader classLoader, List<File> list, File file) {
            int size = list.size();
            Field a = ShareReflectUtil.a((Object) classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) a.get(classLoader));
            Object[] objArr = new String[size];
            Object[] objArr2 = new File[size];
            Object[] objArr3 = new ZipFile[size];
            Object[] objArr4 = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file2 = (File) listIterator.next();
                String absolutePath = file2.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                objArr[previousIndex] = absolutePath;
                objArr2[previousIndex] = file2;
                objArr3[previousIndex] = new ZipFile(file2);
                objArr4[previousIndex] = DexFile.loadDex(absolutePath, SharePatchFileUtil.l(file2, file), 0);
            }
            a.set(classLoader, stringBuilder.toString());
            ShareReflectUtil.a((Object) classLoader, "mPaths", objArr);
            ShareReflectUtil.a((Object) classLoader, "mFiles", objArr2);
            ShareReflectUtil.a((Object) classLoader, "mZips", objArr3);
            try {
                ShareReflectUtil.a((Object) classLoader, "mDexs", objArr4);
            } catch (Exception e) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application, PathClassLoader pathClassLoader, File file, List<File> list) {
        new StringBuilder("installDexes dexOptDir: ").append(file.getAbsolutePath()).append(", dex size:").append(list.size());
        if (!list.isEmpty()) {
            List da = da(list);
            if (VERSION.SDK_INT >= 24 && !cZ(da)) {
                pathClassLoader = AndroidNClassLoader.a(pathClassLoader, application);
            }
            if (VERSION.SDK_INT >= 23) {
                V23.a(pathClassLoader, da, file);
            } else if (VERSION.SDK_INT >= 19) {
                V19.a(pathClassLoader, da, file);
            } else if (VERSION.SDK_INT >= 14) {
                V14.a(pathClassLoader, da, file);
            } else {
                V4.a(pathClassLoader, da, file);
            }
            xha = da.size();
            new StringBuilder("after loaded classloader: ").append(pathClassLoader).append(", dex size:").append(xha);
            if (!((Boolean) ShareReflectUtil.b(Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, pathClassLoader), "isPatch").get(null)).booleanValue()) {
                a(pathClassLoader);
                throw new TinkerRuntimeException("checkDexInstall failed");
            }
        }
    }

    public static void a(ClassLoader classLoader) {
        if (xha > 0) {
            if (VERSION.SDK_INT >= 14) {
                ShareReflectUtil.a(ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader), "dexElements", xha);
                return;
            }
            ShareReflectUtil.a((Object) classLoader, "mPaths", xha);
            ShareReflectUtil.a((Object) classLoader, "mFiles", xha);
            ShareReflectUtil.a((Object) classLoader, "mZips", xha);
            try {
                ShareReflectUtil.a((Object) classLoader, "mDexs", xha);
            } catch (Exception e) {
            }
        }
    }

    private static boolean cZ(List<File> list) {
        if (!list.isEmpty()) {
            for (File file : list) {
                if (file != null && file.getName().startsWith("changed_classes.dex")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<File> da(List<File> list) {
        List<File> arrayList = new ArrayList(list);
        final Map hashMap = new HashMap();
        for (File name : arrayList) {
            CharSequence name2 = name.getName();
            hashMap.put(name2, Boolean.valueOf(ShareConstants.xhA.matcher(name2).matches()));
        }
        Collections.sort(arrayList, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file == null && file2 == null) {
                    return 0;
                }
                if (file == null) {
                    return -1;
                }
                if (file2 == null) {
                    return 1;
                }
                String name = file.getName();
                String name2 = file2.getName();
                if (name.equals(name2)) {
                    return 0;
                }
                if (name.startsWith("test.dex")) {
                    return 1;
                }
                if (name2.startsWith("test.dex")) {
                    return -1;
                }
                boolean booleanValue = ((Boolean) hashMap.get(name)).booleanValue();
                boolean booleanValue2 = ((Boolean) hashMap.get(name2)).booleanValue();
                if (booleanValue && booleanValue2) {
                    int indexOf = name.indexOf(46);
                    int indexOf2 = name2.indexOf(46);
                    int parseInt = indexOf > 7 ? Integer.parseInt(name.substring(7, indexOf)) : 1;
                    indexOf = indexOf2 > 7 ? Integer.parseInt(name2.substring(7, indexOf2)) : 1;
                    if (parseInt == indexOf) {
                        return 0;
                    }
                    return parseInt < indexOf ? -1 : 1;
                } else if (booleanValue) {
                    return -1;
                } else {
                    return booleanValue2 ? 1 : name.compareTo(name2);
                }
            }
        });
        return arrayList;
    }
}
