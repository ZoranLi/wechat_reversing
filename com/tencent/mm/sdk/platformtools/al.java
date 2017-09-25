package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import android.util.LruCache;
import android.util.Xml;
import com.tencent.mm.sdk.f.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class al implements SharedPreferences {
    public static ae utJ = null;
    private static final Object utR = new Object();
    private static final LruCache<String, al> utT = new LruCache(5);
    private static Class<?> utU = null;
    private static Method utV = null;
    private static Method utW = null;
    private static boolean utX = false;
    boolean gXy = false;
    public Map<String, Object> iGX = null;
    public File iyI = null;
    public int mMode = 0;
    public FLock utK = null;
    public File utL = null;
    public boolean utM = false;
    public int utN = 0;
    public long utO = 0;
    public long utP = 0;
    public final Object utQ = new Object();
    public final WeakHashMap<OnSharedPreferenceChangeListener, Object> utS = new WeakHashMap();

    public static class a {
        private static SharedPreferences mPref = ab.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
        public static String utZ = "pref_key_is_enable_MultiProcSP";
        public static String uua = "pref_key_is_disabled_MultiProcSP_manually";

        public static void jS(boolean z) {
            setValue(uua, z);
        }

        public static boolean bJt() {
            return !Py(uua) && Py(utZ);
        }

        private static boolean Py(String str) {
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
            mPref = sharedPreferences;
            if (sharedPreferences == null) {
                w.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return false;
            }
            w.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", Boolean.valueOf(mPref.getBoolean(str, false)));
            return mPref.getBoolean(str, false);
        }

        public static void setValue(String str, boolean z) {
            if (mPref == null) {
                w.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return;
            }
            Editor edit = mPref.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    private final class b implements Editor {
        final /* synthetic */ al utY;
        private final Map<String, Object> uub = new HashMap();
        private boolean uuc = false;

        public b(al alVar) {
            this.utY = alVar;
        }

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.uub.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.uub.put(str, set);
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            synchronized (this) {
                this.uub.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            synchronized (this) {
                this.uub.put(str, Long.valueOf(j));
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            synchronized (this) {
                this.uub.put(str, Float.valueOf(f));
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.uub.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final Editor remove(String str) {
            synchronized (this) {
                this.uub.put(str, this);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.uuc = true;
            }
            return this;
        }

        public final boolean commit() {
            c bJu = bJu();
            a(bJu, null);
            try {
                bJu.uuk.await();
                a(bJu);
                return bJu.uul;
            } catch (InterruptedException e) {
                return false;
            }
        }

        public final void apply() {
            final c bJu = bJu();
            final Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ b uue;

                public final void run() {
                    try {
                        bJu.uuk.await();
                    } catch (InterruptedException e) {
                    }
                }
            };
            as.K(anonymousClass1);
            a(bJu, new Runnable(this) {
                final /* synthetic */ b uue;

                public final void run() {
                    anonymousClass1.run();
                    as.L(anonymousClass1);
                }
            });
            a(bJu);
        }

        private c bJu() {
            c cVar = new c();
            synchronized (this.utY) {
                if (this.utY.utN > 0) {
                    this.utY.iGX = new HashMap(this.utY.iGX);
                }
                cVar.uuj = this.utY.iGX;
                al alVar = this.utY;
                alVar.utN++;
                Object obj = this.utY.utS.size() > 0 ? 1 : null;
                if (obj != null) {
                    cVar.uui = new ArrayList();
                    cVar.gNx = new HashSet(this.utY.utS.keySet());
                }
                synchronized (this) {
                    if (this.uuc) {
                        if (!this.utY.iGX.isEmpty()) {
                            cVar.uuh = true;
                            this.utY.iGX.clear();
                        }
                        this.uuc = false;
                    }
                    for (Entry entry : this.uub.entrySet()) {
                        String str = (String) entry.getKey();
                        b value = entry.getValue();
                        if (value != this) {
                            if (this.utY.iGX.containsKey(str)) {
                                Object obj2 = this.utY.iGX.get(str);
                                if (obj2 != null && obj2.equals(value)) {
                                }
                            }
                            this.utY.iGX.put(str, value);
                        } else if (this.utY.iGX.containsKey(str)) {
                            this.utY.iGX.remove(str);
                        }
                        cVar.uuh = true;
                        if (obj != null) {
                            cVar.uui.add(str);
                        }
                    }
                    this.uub.clear();
                }
            }
            return cVar;
        }

        private void a(final c cVar, final Runnable runnable) {
            Object obj = 1;
            Runnable anonymousClass3 = new Runnable(this) {
                final /* synthetic */ b uue;

                public final void run() {
                    al alVar;
                    synchronized (this.uue.utY.utQ) {
                        b bVar = this.uue;
                        c cVar = cVar;
                        if (bVar.utY.utM) {
                            try {
                                bVar.utY.utK.bIE();
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e, "", new Object[0]);
                            }
                        }
                        try {
                            if (bVar.utY.iyI.exists()) {
                                if (!cVar.uuh) {
                                    cVar.jT(true);
                                    if (bVar.utY.utM) {
                                        try {
                                            bVar.utY.utK.unlock();
                                        } catch (Exception e2) {
                                        }
                                    }
                                } else if (bVar.utY.utL.exists()) {
                                    bVar.utY.iyI.delete();
                                } else if (!bVar.utY.iyI.renameTo(bVar.utY.utL)) {
                                    w.e("MicroMsg.MultiProcSharedPreferences", "Couldn't rename file " + bVar.utY.iyI + " to backup file " + bVar.utY.utL);
                                    cVar.jT(false);
                                    if (bVar.utY.utM) {
                                        try {
                                            bVar.utY.utK.unlock();
                                        } catch (Exception e3) {
                                        }
                                    }
                                }
                            }
                            try {
                                OutputStream x = bVar.x(bVar.utY.iyI);
                                if (x == null) {
                                    cVar.jT(false);
                                    if (bVar.utY.utM) {
                                        try {
                                            bVar.utY.utK.unlock();
                                        } catch (Exception e4) {
                                        }
                                    }
                                } else {
                                    Map map = cVar.uuj;
                                    XmlSerializer newSerializer = Xml.newSerializer();
                                    newSerializer.setOutput(x, ProtocolPackage.ServerEncoding);
                                    newSerializer.startDocument(null, Boolean.valueOf(true));
                                    newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                                    bi.a(map, null, newSerializer);
                                    newSerializer.endDocument();
                                    x.getFD().sync();
                                    x.close();
                                    al.e(bVar.utY.iyI, bVar.utY.mMode);
                                    synchronized (bVar) {
                                        bVar.utY.utO = bVar.utY.iyI.lastModified();
                                        bVar.utY.utP = bVar.utY.iyI.length();
                                    }
                                    bVar.utY.utL.delete();
                                    cVar.jT(true);
                                    if (bVar.utY.utM) {
                                        try {
                                            bVar.utY.utK.unlock();
                                        } catch (Exception e5) {
                                        }
                                    }
                                }
                            } catch (XmlPullParserException e6) {
                                w.w("MicroMsg.MultiProcSharedPreferences", "writeToFile: Got exception:", e6);
                                if (bVar.utY.iyI.exists() && !bVar.utY.iyI.delete()) {
                                    w.e("MicroMsg.MultiProcSharedPreferences", "Couldn't clean up partially-written file " + bVar.utY.iyI);
                                }
                                cVar.jT(false);
                                if (bVar.utY.utM) {
                                    try {
                                        bVar.utY.utK.unlock();
                                    } catch (Exception e7) {
                                    }
                                }
                                synchronized (this.uue.utY) {
                                    alVar = this.uue.utY;
                                    alVar.utN--;
                                }
                                if (runnable == null) {
                                    runnable.run();
                                    return;
                                }
                                return;
                            } catch (IOException e8) {
                                w.w("MicroMsg.MultiProcSharedPreferences", "writeToFile: Got exception:", e8);
                                w.e("MicroMsg.MultiProcSharedPreferences", "Couldn't clean up partially-written file " + bVar.utY.iyI);
                                cVar.jT(false);
                                if (bVar.utY.utM) {
                                    bVar.utY.utK.unlock();
                                }
                                synchronized (this.uue.utY) {
                                    alVar = this.uue.utY;
                                    alVar.utN--;
                                }
                                if (runnable == null) {
                                    runnable.run();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            if (bVar.utY.utM) {
                                try {
                                    bVar.utY.utK.unlock();
                                } catch (Exception e9) {
                                }
                            }
                        }
                    }
                    synchronized (this.uue.utY) {
                        alVar = this.uue.utY;
                        alVar.utN--;
                    }
                    if (runnable == null) {
                        runnable.run();
                        return;
                    }
                    return;
                }
            };
            if ((runnable == null ? 1 : null) != null) {
                synchronized (this.utY) {
                    if (this.utY.utN != 1) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    anonymousClass3.run();
                    return;
                }
            }
            as.bJy().execute(anonymousClass3);
        }

        final FileOutputStream x(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                File parentFile = file.getParentFile();
                if (parentFile.mkdir()) {
                    al.e(parentFile, this.utY.mMode);
                    try {
                        return new FileOutputStream(file);
                    } catch (FileNotFoundException e2) {
                        w.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file " + file, e2);
                        return null;
                    }
                }
                w.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file " + file);
                return null;
            }
        }

        public final void a(final c cVar) {
            if (cVar.gNx != null && cVar.uui != null && cVar.uui.size() != 0) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    for (int size = cVar.uui.size() - 1; size >= 0; size--) {
                        String str = (String) cVar.uui.get(size);
                        for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : cVar.gNx) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.utY, str);
                            }
                        }
                    }
                    return;
                }
                al.utJ.post(new Runnable(this) {
                    final /* synthetic */ b uue;

                    public final void run() {
                        this.uue.a(cVar);
                    }
                });
            }
        }
    }

    private static class c {
        public Set<OnSharedPreferenceChangeListener> gNx = null;
        public boolean uuh = false;
        public List<String> uui = null;
        public Map<String, Object> uuj = null;
        public final CountDownLatch uuk = new CountDownLatch(1);
        public volatile boolean uul = false;

        public final void jT(boolean z) {
            this.uul = z;
            this.uuk.countDown();
        }
    }

    public static SharedPreferences ba(Context context, String str) {
        int i = 1;
        if (a.bJt()) {
            w.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", str);
            al alVar = (al) utT.get(str);
            if (alVar == null) {
                SharedPreferences alVar2 = new al(context, str, 4);
                utT.put(str, alVar2);
                return alVar2;
            }
            synchronized (alVar) {
                if (alVar.utN > 0 || (alVar.utO == alVar.iyI.lastModified() && alVar.utP == alVar.iyI.length())) {
                    i = 0;
                }
                if (i == 0) {
                    return alVar;
                }
                alVar.bJr();
                return alVar;
            }
        }
        w.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", str);
        return context.getSharedPreferences(str, 4);
    }

    private al() {
        throw new RuntimeException("Not supported.");
    }

    private al(Context context, String str, int i) {
        Context applicationContext = context.getApplicationContext();
        if (utJ == null) {
            utJ = new ae(Looper.getMainLooper());
        }
        String str2 = applicationContext.getApplicationInfo().dataDir;
        if (str2 == null || str2.length() == 0) {
            w.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            str2 = "/data/data/" + applicationContext.getPackageName();
        }
        w.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: " + str2);
        File file = new File(str2, "shared_prefs");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!(file.canRead() && file.canWrite())) {
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
        this.iyI = new File(file, str + ".xml");
        this.utL = new File(this.iyI.getPath() + ".bak");
        this.mMode = 4;
        this.utM = true;
        if (this.utM) {
            this.utK = new FLock(this.iyI.getPath() + ".lock");
        }
        bJr();
    }

    private void bJr() {
        synchronized (this) {
            this.gXy = false;
        }
        e.b(new Runnable(this) {
            final /* synthetic */ al utY;

            {
                this.utY = r1;
            }

            public final void run() {
                Object obj;
                XmlPullParserException xmlPullParserException;
                FileNotFoundException fileNotFoundException;
                IOException iOException;
                Map map = null;
                synchronized (this.utY) {
                    al alVar = this.utY;
                    if (alVar.utM) {
                        try {
                            alVar.utK.bIC();
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e, "", new Object[0]);
                        } catch (Throwable th) {
                            if (alVar.utM) {
                                try {
                                    alVar.utK.unlock();
                                } catch (Exception e2) {
                                }
                            }
                        }
                    }
                    if (!alVar.gXy) {
                        if (alVar.utL.exists()) {
                            alVar.iyI.delete();
                            alVar.utL.renameTo(alVar.iyI);
                        }
                        if (alVar.iyI.exists() && !alVar.iyI.canRead()) {
                            w.w("MicroMsg.MultiProcSharedPreferences", "Attempt to read preferences file " + alVar.iyI + " without permission");
                        }
                        if (alVar.iyI.canRead()) {
                            try {
                                InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(alVar.iyI), 16384);
                                XmlPullParser newPullParser = Xml.newPullParser();
                                newPullParser.setInput(bufferedInputStream, null);
                                HashMap hashMap = (HashMap) bi.a(newPullParser, new String[1]);
                                try {
                                    bufferedInputStream.close();
                                    map = hashMap;
                                } catch (XmlPullParserException e3) {
                                    XmlPullParserException xmlPullParserException2 = e3;
                                    obj = hashMap;
                                    xmlPullParserException = xmlPullParserException2;
                                    w.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", xmlPullParserException);
                                    alVar.gXy = true;
                                    if (map != null) {
                                        alVar.iGX = map;
                                        alVar.utO = alVar.iyI.lastModified();
                                        alVar.utP = alVar.iyI.length();
                                    } else {
                                        alVar.iGX = new HashMap();
                                    }
                                    alVar.notifyAll();
                                    if (alVar.utM) {
                                        try {
                                            alVar.utK.unlock();
                                        } catch (Exception e4) {
                                        }
                                    }
                                    return;
                                } catch (FileNotFoundException e5) {
                                    FileNotFoundException fileNotFoundException2 = e5;
                                    obj = hashMap;
                                    fileNotFoundException = fileNotFoundException2;
                                    w.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", fileNotFoundException);
                                    alVar.gXy = true;
                                    if (map != null) {
                                        alVar.iGX = new HashMap();
                                    } else {
                                        alVar.iGX = map;
                                        alVar.utO = alVar.iyI.lastModified();
                                        alVar.utP = alVar.iyI.length();
                                    }
                                    alVar.notifyAll();
                                    if (alVar.utM) {
                                        alVar.utK.unlock();
                                    }
                                    return;
                                } catch (IOException e6) {
                                    IOException iOException2 = e6;
                                    obj = hashMap;
                                    iOException = iOException2;
                                    w.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", iOException);
                                    alVar.gXy = true;
                                    if (map != null) {
                                        alVar.iGX = map;
                                        alVar.utO = alVar.iyI.lastModified();
                                        alVar.utP = alVar.iyI.length();
                                    } else {
                                        alVar.iGX = new HashMap();
                                    }
                                    alVar.notifyAll();
                                    if (alVar.utM) {
                                        alVar.utK.unlock();
                                    }
                                    return;
                                }
                            } catch (XmlPullParserException e7) {
                                xmlPullParserException = e7;
                                w.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", xmlPullParserException);
                                alVar.gXy = true;
                                if (map != null) {
                                    alVar.iGX = new HashMap();
                                } else {
                                    alVar.iGX = map;
                                    alVar.utO = alVar.iyI.lastModified();
                                    alVar.utP = alVar.iyI.length();
                                }
                                alVar.notifyAll();
                                if (alVar.utM) {
                                    alVar.utK.unlock();
                                }
                                return;
                            } catch (FileNotFoundException e8) {
                                fileNotFoundException = e8;
                                w.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", fileNotFoundException);
                                alVar.gXy = true;
                                if (map != null) {
                                    alVar.iGX = map;
                                    alVar.utO = alVar.iyI.lastModified();
                                    alVar.utP = alVar.iyI.length();
                                } else {
                                    alVar.iGX = new HashMap();
                                }
                                alVar.notifyAll();
                                if (alVar.utM) {
                                    alVar.utK.unlock();
                                }
                                return;
                            } catch (IOException e9) {
                                iOException = e9;
                                w.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", iOException);
                                alVar.gXy = true;
                                if (map != null) {
                                    alVar.iGX = new HashMap();
                                } else {
                                    alVar.iGX = map;
                                    alVar.utO = alVar.iyI.lastModified();
                                    alVar.utP = alVar.iyI.length();
                                }
                                alVar.notifyAll();
                                if (alVar.utM) {
                                    alVar.utK.unlock();
                                }
                                return;
                            }
                        }
                        alVar.gXy = true;
                        if (map != null) {
                            alVar.iGX = map;
                            alVar.utO = alVar.iyI.lastModified();
                            alVar.utP = alVar.iyI.length();
                        } else {
                            alVar.iGX = new HashMap();
                        }
                        alVar.notifyAll();
                        if (alVar.utM) {
                            alVar.utK.unlock();
                        }
                    } else if (alVar.utM) {
                        try {
                            alVar.utK.unlock();
                        } catch (Exception e10) {
                        }
                    }
                }
                return;
            }
        }, "MultiProcessSP-LoadThread").start();
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.utS.put(onSharedPreferenceChangeListener, utR);
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.utS.remove(onSharedPreferenceChangeListener);
        }
    }

    private void bJs() {
        if (!(this.gXy || utX)) {
            if (utU == null) {
                try {
                    utU = Class.forName("dalvik.system.BlockGuard");
                } catch (Throwable th) {
                    utX = true;
                }
            }
            if (utV == null) {
                try {
                    Method declaredMethod = utU.getDeclaredMethod("getThreadPolicy", new Class[0]);
                    utV = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Throwable th2) {
                    utX = true;
                }
            }
            try {
                if (utV != null) {
                    Object invoke = utV.invoke(null, new Object[0]);
                    if (utW == null) {
                        Method declaredMethod2 = invoke.getClass().getDeclaredMethod("onReadFromDisk", new Class[0]);
                        utW = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    }
                    utW.invoke(invoke, new Object[0]);
                }
            } catch (Throwable th3) {
                utX = true;
            }
        }
        while (!this.gXy) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public final Map<String, ?> getAll() {
        Map hashMap;
        synchronized (this) {
            bJs();
            hashMap = new HashMap(this.iGX);
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        synchronized (this) {
            bJs();
            str3 = (String) this.iGX.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            bJs();
            set2 = (Set) this.iGX.get(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        synchronized (this) {
            bJs();
            Integer num = (Integer) this.iGX.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        synchronized (this) {
            bJs();
            Long l = (Long) this.iGX.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        synchronized (this) {
            bJs();
            Float f2 = (Float) this.iGX.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            bJs();
            Boolean bool = (Boolean) this.iGX.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            bJs();
            containsKey = this.iGX.containsKey(str);
        }
        return containsKey;
    }

    public final Editor edit() {
        synchronized (this) {
            bJs();
        }
        return new b(this);
    }

    public static void e(File file, int i) {
        boolean z;
        boolean z2 = false;
        if ((i & 1) == 0) {
            z = true;
        } else {
            z = false;
        }
        file.setReadable(true, z);
        if ((i & 2) == 0) {
            z2 = true;
        }
        file.setWritable(true, z2);
    }
}
