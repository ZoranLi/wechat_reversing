package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import java.lang.reflect.Field;
import java.util.Map;

public final class e {
    private static Class<?> fwX = null;
    public static boolean uNl = false;
    private static a uNm;
    private static LongSparseArray<ConstantState>[] uNn;
    private static LongSparseArray<ConstantState> uNo;
    private static c<ConstantState> uNp;
    private static c<ConstantState> uNq;
    protected static Application uNr;
    protected static String uNs;
    protected static Class<d> uNt;

    public static class a {
        Resources Cu;
        TypedValue uMR = new TypedValue();
        Map<Integer, com.tencent.mm.svg.c> uMW;
        Application uNu;

        public a(Map<Integer, com.tencent.mm.svg.c> map, Application application) {
            this.uMW = map;
            this.uNu = application;
            this.Cu = application.getResources();
        }

        public final void a(Integer num, com.tencent.mm.svg.c cVar) {
            this.uMW.put(num, cVar);
            e.a(this.uNu, this.Cu, num.intValue(), this.uMR);
        }
    }

    protected static class b extends ConstantState {
        private Resources Cu;
        private int rcB = 0;

        public b(int i, Resources resources) {
            if (i == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", Integer.valueOf(i));
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
            }
            this.rcB = i;
            this.Cu = resources;
        }

        public final Drawable newDrawable() {
            return a.c(this.Cu, this.rcB);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    @TargetApi(16)
    public static class c<T> extends LongSparseArray<T> {
        public static boolean uNv = false;
        LongSparseArray<T> uNo = null;

        public final T get(long j, T t) {
            if (this.uNo.indexOfKey(j) < 0) {
                return super.get(j, t);
            }
            if (!e.uNl) {
                e.bNY();
            }
            return this.uNo.get(j, t);
        }

        public final void delete(long j) {
            super.delete(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", Long.valueOf(j));
        }

        public final void remove(long j) {
            super.remove(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", Long.valueOf(j));
        }

        public final void clear() {
            super.clear();
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
        }
    }

    public static void d(Class<?> cls) {
        fwX = cls;
    }

    public static void a(com.tencent.mm.svg.b.c.a aVar) {
        com.tencent.mm.svg.b.c.b(aVar);
    }

    public static void b(Application application, String str) {
        long nanoTime;
        int i;
        Throwable th;
        int i2;
        uNs = str;
        a.bl(str);
        com.tencent.mm.svg.b.b.bl(str);
        String str2 = str + ".svg.SVGPreload";
        uNr = application;
        try {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "try to load SVGPreload", new Object[0]);
            Class cls = Class.forName(str2);
            nanoTime = System.nanoTime();
            ey(application);
            a(application, cls);
            try {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "load SVGPreload spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            } catch (ClassNotFoundException e) {
                i = 1;
            } catch (InstantiationException e2) {
                i = 1;
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
                if (i == 0) {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ey(application);
                    try {
                        f(application);
                    } catch (ClassNotFoundException e3) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
            } catch (IllegalAccessException e4) {
                i = 1;
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
                if (i == 0) {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ey(application);
                    try {
                        f(application);
                    } catch (ClassNotFoundException e5) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 1;
                if (i2 == 0) {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ey(application);
                    try {
                        f(application);
                    } catch (ClassNotFoundException e6) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
                throw th;
            }
        } catch (ClassNotFoundException e7) {
            i = 0;
            try {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "ClassNotFoundException %s. Go fallback logic.", str2);
                if (i == 0) {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ey(application);
                    try {
                        f(application);
                    } catch (ClassNotFoundException e8) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                i2 = i;
                th = th4;
                if (i2 == 0) {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ey(application);
                    f(application);
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
                throw th;
            }
        } catch (InstantiationException e9) {
            i = 0;
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
            if (i == 0) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                ey(application);
                f(application);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
        } catch (IllegalAccessException e10) {
            i = 0;
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
            if (i == 0) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                ey(application);
                f(application);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
        } catch (Throwable th5) {
            th = th5;
            i2 = 0;
            if (i2 == 0) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                ey(application);
                f(application);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
            throw th;
        }
    }

    private static a e(Application application) {
        if (uNm == null) {
            uNm = new a(a.bNT(), application);
        }
        return uNm;
    }

    @TargetApi(16)
    private static void ey(Context context) {
        int i = 1;
        if (uNp == null) {
            try {
                Object obj;
                uNo = new LongSparseArray();
                c cVar = new c();
                uNp = cVar;
                cVar.uNo = uNo;
                cVar = new c();
                uNq = cVar;
                cVar.uNo = uNo;
                if (VERSION.SDK_INT >= 23) {
                    com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "mResourcesImpl");
                    aVar.prepare();
                    if (aVar.gRV == null) {
                        i = 0;
                    }
                    if (i != 0) {
                        obj = aVar.get();
                    } else {
                        obj = context.getResources();
                    }
                } else {
                    obj = context.getResources();
                }
                a(context, obj);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", context.getResources());
            } catch (Throwable e) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
            } catch (Throwable e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
            } catch (Throwable e22) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e22, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
            }
        }
    }

    @TargetApi(16)
    private static void a(Context context, Object obj) {
        Object obj2 = new com.tencent.mm.svg.b.a(obj, "sPreloadedDrawables").get();
        if (obj2 == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
        } else if (obj2 instanceof LongSparseArray[]) {
            int i;
            long keyAt;
            uNn = (LongSparseArray[]) obj2;
            com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", uNn[0]);
            for (i = 0; i < uNn[0].size(); i++) {
                keyAt = uNn[0].keyAt(i);
                uNp.put(keyAt, uNn[0].get(keyAt));
            }
            for (i = 0; i < uNn[1].size(); i++) {
                keyAt = uNn[1].keyAt(i);
                uNq.put(keyAt, uNn[1].get(keyAt));
            }
            uNn[0] = uNp;
            uNn[1] = uNq;
        } else if (obj2 instanceof LongSparseArray) {
            com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "sPreloadedDrawables");
            LongSparseArray longSparseArray = (LongSparseArray) aVar.get();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt2 = longSparseArray.keyAt(i2);
                uNp.put(keyAt2, longSparseArray.get(keyAt2));
            }
            c cVar = uNp;
            aVar.prepare();
            if (aVar.gRV == null) {
                throw new NoSuchFieldException();
            }
            aVar.gRV.set(aVar.obj, cVar);
            if (aVar.get() == null) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
            }
        } else {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
        }
    }

    @TargetApi(16)
    public static void a(Application application, Resources resources, int i, TypedValue typedValue) {
        if (i == 0) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", Integer.valueOf(i), typedValue);
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
        }
        resources.getValue(i, typedValue, true);
        uNo.put((((long) typedValue.assetCookie) << 32) | ((long) typedValue.data), new b(i, application.getResources()));
    }

    private static void a(Application application, Class<d> cls) {
        uNr = application;
        uNt = cls;
        try {
            if (uNt != null) {
                ((d) cls.newInstance()).load(e(application));
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s", Integer.valueOf(e(application).uMW.size()));
                uNl = true;
            }
        } catch (Throwable e) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "We found one NotFoundException.", new Object[0]);
            uNl = false;
        }
    }

    private static Class<?> bNX() {
        if (fwX != null) {
            return fwX;
        }
        Class<?> cls;
        try {
            cls = Class.forName(uNs + ".R$raw");
            if (cls != null) {
                return cls;
            }
        } catch (ClassNotFoundException e) {
        }
        cls = com.tencent.mm.svg.b.b.bOb();
        return cls == null ? null : cls;
    }

    private static void f(Application application) {
        Class bNX = bNX();
        if (bNX == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
            return;
        }
        Field[] declaredFields = bNX.getDeclaredFields();
        a e = e(application);
        try {
            a aVar = new a();
            for (Field field : declaredFields) {
                int i = field.getInt(null);
                if (aVar.d(application.getResources(), i)) {
                    a(e.uNu, e.Cu, i, e.uMR);
                }
            }
            uNl = true;
        } catch (IllegalAccessException e2) {
            uNl = false;
        } catch (IllegalArgumentException e3) {
            uNl = false;
        }
    }

    public static void bNY() {
        try {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Reach here, why?", new Object[0]);
            if (uNt == null) {
                f(uNr);
            } else {
                a(uNr, uNt);
            }
        } catch (Throwable e) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
        } catch (Throwable e2) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
        } catch (Throwable e22) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e22, "", new Object[0]);
        }
    }
}
