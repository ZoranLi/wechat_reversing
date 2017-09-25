package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

@TargetApi(14)
class AndroidNClassLoader extends PathClassLoader {
    private final PathClassLoader xgY;
    private String xgZ;

    private AndroidNClassLoader(String str, PathClassLoader pathClassLoader, Application application) {
        super(str, pathClassLoader.getParent());
        this.xgY = pathClassLoader;
        String name = application.getClass().getName();
        if (name != null && !name.equals("android.app.Application")) {
            this.xgZ = name;
        }
    }

    public static AndroidNClassLoader a(PathClassLoader pathClassLoader, Application application) {
        ClassLoader androidNClassLoader = new AndroidNClassLoader("", pathClassLoader, application);
        Field a = ShareReflectUtil.a((Object) pathClassLoader, "pathList");
        Object obj = a.get(pathClassLoader);
        Object[] objArr = (Object[]) ShareReflectUtil.a(obj, "dexElements").get(obj);
        List<File> list = (List) ShareReflectUtil.a(obj, "nativeLibraryDirectories").get(obj);
        StringBuilder stringBuilder = new StringBuilder();
        Field b = ShareReflectUtil.b(objArr.getClass().getComponentType(), "dexFile");
        Object obj2 = 1;
        for (Object obj3 : objArr) {
            DexFile dexFile = (DexFile) b.get(obj3);
            if (dexFile != null) {
                if (obj2 != null) {
                    obj2 = null;
                } else {
                    stringBuilder.append(File.pathSeparator);
                }
                stringBuilder.append(dexFile.getName());
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        Object obj4 = 1;
        for (File file : list) {
            if (file != null) {
                if (obj4 != null) {
                    obj4 = null;
                } else {
                    stringBuilder3.append(File.pathSeparator);
                }
                stringBuilder3.append(file.getAbsolutePath());
            }
        }
        String stringBuilder4 = stringBuilder3.toString();
        a.set(androidNClassLoader, ShareReflectUtil.a(obj, ClassLoader.class, String.class, String.class, File.class).newInstance(new Object[]{androidNClassLoader, stringBuilder2, stringBuilder4, null}));
        Object obj5 = (Context) ShareReflectUtil.a((Object) application, "mBase").get(application);
        obj5 = ShareReflectUtil.a(obj5, "mPackageInfo").get(obj5);
        Field a2 = ShareReflectUtil.a(obj5, "mClassLoader");
        Thread.currentThread().setContextClassLoader(androidNClassLoader);
        a2.set(obj5, androidNClassLoader);
        return androidNClassLoader;
    }

    public Class<?> findClass(String str) {
        if ((str == null || !str.startsWith("com.tencent.tinker.loader.") || str.equals("com.tencent.tinker.loader.TinkerTestDexLoad")) && (this.xgZ == null || !this.xgZ.equals(str))) {
            return super.findClass(str);
        }
        return this.xgY.loadClass(str);
    }

    public String findLibrary(String str) {
        return super.findLibrary(str);
    }
}
