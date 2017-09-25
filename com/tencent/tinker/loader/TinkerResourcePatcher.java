package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class TinkerResourcePatcher {
    private static Collection<WeakReference<Resources>> xhn = null;
    private static Object xho = null;
    private static AssetManager xhp = null;
    private static Method xhq = null;
    private static Method xhr = null;
    private static Field xhs = null;
    private static Field xht = null;
    private static Field xhu = null;
    private static Field xhv = null;
    private static Field xhw = null;
    private static Field xhx = null;

    TinkerResourcePatcher() {
    }

    public static void hv(Context context) {
        Class cls;
        Class cls2 = Class.forName("android.app.ActivityThread");
        xho = ShareReflectUtil.c(context, cls2);
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        Field declaredField = cls.getDeclaredField("mResDir");
        xhu = declaredField;
        declaredField.setAccessible(true);
        declaredField = cls2.getDeclaredField("mPackages");
        xhv = declaredField;
        declaredField.setAccessible(true);
        declaredField = cls2.getDeclaredField("mResourcePackages");
        xhw = declaredField;
        declaredField.setAccessible(true);
        if (context.getAssets().getClass().getName().equals("android.content.res.BaiduAssetManager")) {
            xhp = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
        } else {
            xhp = (AssetManager) AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[]{String.class});
        xhq = declaredMethod;
        declaredMethod.setAccessible(true);
        declaredMethod = AssetManager.class.getDeclaredMethod("ensureStringBlocks", new Class[0]);
        xhr = declaredMethod;
        declaredMethod.setAccessible(true);
        if (VERSION.SDK_INT >= 19) {
            cls2 = Class.forName("android.app.ResourcesManager");
            declaredMethod = cls2.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            try {
                declaredField = cls2.getDeclaredField("mActiveResources");
                declaredField.setAccessible(true);
                xhn = ((ArrayMap) declaredField.get(invoke)).values();
            } catch (NoSuchFieldException e2) {
                declaredField = cls2.getDeclaredField("mResourceReferences");
                declaredField.setAccessible(true);
                xhn = (Collection) declaredField.get(invoke);
            }
        } else {
            declaredField = cls2.getDeclaredField("mActiveResources");
            declaredField.setAccessible(true);
            xhn = ((HashMap) declaredField.get(xho)).values();
        }
        if (xhn == null) {
            throw new IllegalStateException("resource references is null");
        }
        if (VERSION.SDK_INT >= 24) {
            try {
                declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                xht = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                declaredField = Resources.class.getDeclaredField("mAssets");
                xhs = declaredField;
                declaredField.setAccessible(true);
            }
        } else {
            declaredField = Resources.class.getDeclaredField("mAssets");
            xhs = declaredField;
            declaredField.setAccessible(true);
        }
        try {
            xhx = ShareReflectUtil.b(ApplicationInfo.class, "publicSourceDir");
        } catch (NoSuchFieldException e3) {
        }
    }

    public static void bK(Context context, String str) {
        if (str != null) {
            Object obj;
            Field[] fieldArr = new Field[]{xhv, xhw};
            for (int i = 0; i < 2; i++) {
                for (Entry value : ((Map) fieldArr[i].get(xho)).entrySet()) {
                    obj = ((WeakReference) value.getValue()).get();
                    if (!(obj == null || str == null)) {
                        xhu.set(obj, str);
                    }
                }
            }
            if (((Integer) xhq.invoke(xhp, new Object[]{str})).intValue() == 0) {
                throw new IllegalStateException("Could not create new AssetManager");
            }
            xhr.invoke(xhp, new Object[0]);
            for (WeakReference weakReference : xhn) {
                Resources resources = (Resources) weakReference.get();
                if (resources != null) {
                    Field a;
                    try {
                        xhs.set(resources, xhp);
                    } catch (Throwable th) {
                        obj = xht.get(resources);
                        a = ShareReflectUtil.a(obj, "mAssets");
                        a.setAccessible(true);
                        a.set(obj, xhp);
                    }
                    try {
                        a = ShareReflectUtil.b(Resources.class, "mTypedArrayPool");
                        obj = a.get(resources);
                        Field a2 = ShareReflectUtil.a(obj, "mPool");
                        Constructor constructor = obj.getClass().getConstructor(new Class[]{Integer.TYPE});
                        constructor.setAccessible(true);
                        a.set(resources, constructor.newInstance(new Object[]{Integer.valueOf(((Object[]) a2.get(obj)).length)}));
                    } catch (Throwable th2) {
                        new StringBuilder("clearPreloadTypedArrayIssue failed, ignore error: ").append(th2);
                    }
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
            if (VERSION.SDK_INT >= 24) {
                try {
                    if (xhx != null) {
                        xhx.set(context.getApplicationInfo(), str);
                    }
                } catch (Throwable th3) {
                }
            }
            if (!hw(context)) {
                throw new TinkerRuntimeException("checkResInstall failed");
            }
        }
    }

    private static boolean hw(Context context) {
        try {
            context.getAssets().open("only_use_to_test_tinker_resource.txt");
            return true;
        } catch (Throwable th) {
            new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:").append(th.getMessage());
            return false;
        }
    }
}
