package com.tencent.mm.modelsfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class FileOp {
    public static ReentrantReadWriteLock hRg = new ReentrantReadWriteLock();
    public static TreeMap<String, SFSContextRec> hRh = new TreeMap();
    private static File hRi;
    private static String hRj = "";
    private static final EnumSet<com.tencent.mm.modelsfs.g.a> hRk = EnumSet.of(com.tencent.mm.modelsfs.g.a.PATHNAME, com.tencent.mm.modelsfs.g.a.PERIOD);

    static class SFSContextRec implements Parcelable {
        public static final Creator<SFSContextRec> CREATOR = new Creator<SFSContextRec>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SFSContextRec(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SFSContextRec[i];
            }
        };
        String hRn;
        String[] hRo;
        boolean hRp;
        boolean hRq;
        SFSContext hRr;
        Builder hRs;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hRn);
            parcel.writeStringArray(this.hRo);
            parcel.writeByte((byte) (this.hRp ? 1 : 0));
            parcel.writeParcelable(this.hRs, i);
        }

        SFSContextRec(Parcel parcel) {
            boolean z;
            this.hRn = parcel.readString();
            this.hRo = parcel.createStringArray();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hRp = z;
            this.hRr = null;
            this.hRq = false;
            this.hRs = (Builder) parcel.readParcelable(Builder.class.getClassLoader());
        }
    }

    class a {
        File hRl;
        File[] hRm = null;
        int pos = 0;

        a(File file) {
            this.hRl = file;
        }
    }

    public static void init(boolean z) {
        Context context = ab.getContext();
        hRi = new File(context.getFilesDir(), "fileop_mapping");
        hRj = av.PE(com.tencent.mm.loader.stub.a.hgs);
        if (z) {
            hRi.delete();
            return;
        }
        w.i("MicroMsg.FileOp", "Initializing FileOp mapping slave.");
        if (hRi.exists()) {
            byte[] c = c(hRi.getAbsolutePath(), 0, -1);
            if (c != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(c, 0, c.length);
                obtain.setDataPosition(0);
                Bundle readBundle = obtain.readBundle(SFSContextRec.class.getClassLoader());
                obtain.recycle();
                hRg.writeLock().lock();
                for (String str : readBundle.keySet()) {
                    SFSContextRec sFSContextRec = (SFSContextRec) hRh.put(str, (SFSContextRec) readBundle.getParcelable(str));
                    if (!(sFSContextRec == null || sFSContextRec.hRr == null)) {
                        sFSContextRec.hRr.release();
                    }
                    w.i("MicroMsg.FileOp", "Load mapping from file: " + str);
                }
                hRg.writeLock().unlock();
            }
        }
        BroadcastReceiver anonymousClass1 = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                SFSContextRec sFSContextRec;
                String str;
                if (intent.getAction().equals("com.tencent.mm.FileOp.registerSFS")) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("rec");
                    if (byteArrayExtra != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                        obtain.setDataPosition(0);
                        sFSContextRec = (SFSContextRec) SFSContextRec.CREATOR.createFromParcel(obtain);
                        if (sFSContextRec != null) {
                            str = sFSContextRec.hRn;
                            FileOp.hRg.writeLock().lock();
                            sFSContextRec = (SFSContextRec) FileOp.hRh.put(str, sFSContextRec);
                            FileOp.hRg.writeLock().unlock();
                            if (!(sFSContextRec == null || sFSContextRec.hRr == null)) {
                                sFSContextRec.hRr.release();
                            }
                            w.i("MicroMsg.FileOp", "Load mapping from broadcast: " + str);
                        }
                    }
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.unregisterSFS")) {
                    str = intent.getStringExtra("prefix");
                    FileOp.hRg.writeLock().lock();
                    sFSContextRec = (SFSContextRec) FileOp.hRh.remove(str);
                    FileOp.hRg.writeLock().unlock();
                    if (!(sFSContextRec == null || sFSContextRec.hRr == null)) {
                        sFSContextRec.hRr.release();
                    }
                    w.i("MicroMsg.FileOp", "Unload mapping from broadcast: " + str);
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.clearSFS")) {
                    FileOp.hRg.writeLock().lock();
                    for (SFSContextRec sFSContextRec2 : FileOp.hRh.values()) {
                        if (!(sFSContextRec2 == null || sFSContextRec2.hRr == null)) {
                            sFSContextRec2.hRr.release();
                        }
                    }
                    FileOp.hRh.clear();
                    FileOp.hRg.writeLock().unlock();
                    w.i("MicroMsg.FileOp", "Clear mapping from broadcast.");
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.FileOp.registerSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.unregisterSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.clearSFS");
        context.registerReceiver(anonymousClass1, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
    }

    private static void IK() {
        Bundle bundle = new Bundle();
        for (SFSContextRec sFSContextRec : hRh.values()) {
            bundle.putParcelable(sFSContextRec.hRn, sFSContextRec);
        }
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        String absolutePath = hRi.getAbsolutePath();
        byte[] marshall = obtain.marshall();
        b(absolutePath, marshall, marshall.length);
        obtain.recycle();
    }

    public static void a(String str, String[] strArr, Builder builder) {
        SFSContextRec sFSContextRec = null;
        if (builder == null) {
            kc(str);
        } else if (hRj.toLowerCase().contains("fat")) {
            w.i("MicroMsg.FileOp", "SFS enabled on file system '%s'", hRj);
            if (new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs").exists()) {
                w.i("MicroMsg.FileOp", "SFS disabled.");
                return;
            }
            if (builder != null) {
                String[] strArr2;
                SFSContextRec sFSContextRec2 = new SFSContextRec();
                sFSContextRec2.hRn = str;
                if (strArr == null || strArr.length == 0) {
                    strArr2 = null;
                } else {
                    strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                }
                sFSContextRec2.hRo = strArr2;
                sFSContextRec2.hRp = false;
                sFSContextRec2.hRr = null;
                sFSContextRec2.hRs = builder;
                sFSContextRec = sFSContextRec2;
            }
            hRg.writeLock().lock();
            SFSContextRec sFSContextRec3 = (SFSContextRec) hRh.put(str, sFSContextRec);
            hRg.writeLock().unlock();
            if (!(sFSContextRec3 == null || sFSContextRec3.hRr == null)) {
                sFSContextRec3.hRr.release();
            }
            Parcel obtain = Parcel.obtain();
            sFSContextRec.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            Context context = ab.getContext();
            context.sendBroadcast(new Intent("com.tencent.mm.FileOp.registerSFS").putExtra("rec", marshall).setPackage(context.getPackageName()), WXApp.WXAPP_BROADCAST_PERMISSION);
            IK();
            w.i("MicroMsg.FileOp", "Register SFS for prefix: " + str);
        } else {
            w.i("MicroMsg.FileOp", "SFS disabled on file system '%s'", hRj);
        }
    }

    public static void kc(String str) {
        hRg.writeLock().lock();
        SFSContextRec sFSContextRec = (SFSContextRec) hRh.remove(str);
        hRg.writeLock().unlock();
        if (!(sFSContextRec == null || sFSContextRec.hRr == null)) {
            sFSContextRec.hRr.release();
        }
        Context context = ab.getContext();
        context.sendBroadcast(new Intent("com.tencent.mm.FileOp.unregisterSFS").putExtra("prefix", str).setPackage(context.getPackageName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        IK();
        w.i("MicroMsg.FileOp", "Unregister SFS for prefix: " + str);
    }

    public static Map<String, Statistics> IL() {
        hRg.readLock().lock();
        Map treeMap = new TreeMap();
        for (SFSContextRec sFSContextRec : hRh.values()) {
            if (!(sFSContextRec == null || sFSContextRec.hRq)) {
                if (sFSContextRec.hRr == null) {
                    synchronized (sFSContextRec) {
                        if (sFSContextRec.hRr == null) {
                            try {
                                sFSContextRec.hRr = sFSContextRec.hRs.create();
                            } catch (Exception e) {
                                w.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.hRn, e.getMessage());
                                sFSContextRec.hRq = true;
                            }
                        }
                    }
                }
                SFSContext sFSContext = sFSContextRec.hRr;
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                treeMap.put(sFSContextRec.hRs.mName, SFSContext.nativeStatistics(sFSContext.mNativePtr));
            }
        }
        hRg.readLock().unlock();
        return treeMap;
    }

    private static boolean a(String str, SFSContextRec sFSContextRec) {
        if (sFSContextRec.hRo == null) {
            return false;
        }
        String substring = str.substring(sFSContextRec.hRn.length());
        int lastIndexOf = substring.lastIndexOf(47);
        if (lastIndexOf == -1) {
            return false;
        }
        String substring2 = substring.substring(lastIndexOf + 1);
        if (substring2.length() == 0) {
            return false;
        }
        for (String a : sFSContextRec.hRo) {
            if (g.a(a, 0, substring2, 0, hRk)) {
                return true;
            }
        }
        return false;
    }

    private static boolean kd(String str) {
        boolean z;
        hRg.readLock().lock();
        Entry floorEntry = hRh.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.hRq || sFSContextRec.hRo != null || sFSContextRec.hRp)) {
                z = false;
                hRg.readLock().unlock();
                return z;
            }
        }
        z = true;
        hRg.readLock().unlock();
        return z;
    }

    private static boolean ke(String str) {
        boolean z;
        hRg.readLock().lock();
        Entry floorEntry = hRh.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.hRq || a(str, sFSContextRec))) {
                z = false;
                hRg.readLock().unlock();
                return z;
            }
        }
        z = true;
        hRg.readLock().unlock();
        return z;
    }

    private static SFSContextRec kf(String str) {
        hRg.readLock().lock();
        Entry floorEntry = hRh.floorEntry(str);
        if (floorEntry == null) {
            return null;
        }
        SFSContextRec sFSContextRec;
        if (str.startsWith((String) floorEntry.getKey())) {
            sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (a(str, sFSContextRec)) {
                sFSContextRec = null;
            }
        } else {
            sFSContextRec = null;
        }
        if (sFSContextRec == null || sFSContextRec.hRq) {
            return null;
        }
        if (sFSContextRec.hRr != null) {
            return sFSContextRec;
        }
        synchronized (sFSContextRec) {
            if (sFSContextRec.hRr == null) {
                try {
                    sFSContextRec.hRr = sFSContextRec.hRs.create();
                } catch (Exception e) {
                    w.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.hRn, e.getMessage());
                    sFSContextRec.hRq = true;
                    return null;
                }
            }
        }
        return sFSContextRec;
    }

    public static java.io.InputStream openRead(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream. bs: [B:7:0x0017, B:22:0x0062]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        if (r7 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r7.length();
        if (r0 != 0) goto L_0x0011;
    L_0x0008:
        r0 = new java.io.FileNotFoundException;
        r1 = "path == null";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r1 = kf(r7);
        if (r1 != 0) goto L_0x0062;
    L_0x0017:
        r0 = com.tencent.mm.modelsfs.f.kp(r7);	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0057 }
    L_0x001d:
        r2 = com.tencent.mm.modelsfs.f.kr(r7);	 Catch:{ all -> 0x0057 }
        r4 = com.tencent.mm.modelsfs.f.kq(r7);	 Catch:{ all -> 0x0057 }
        r0 = new com.tencent.mm.modelsfs.b;	 Catch:{ all -> 0x0057 }
        r0.<init>(r4, r2);	 Catch:{ all -> 0x0057 }
    L_0x002a:
        r2 = hRg;
        r2 = r2.readLock();
        r2.unlock();
        r2 = "MicroMsg.FileOp";
        r3 = "openRead: %s [%s, %s]";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r7;
        r5 = 1;
        r6 = "ok";
        r4[r5] = r6;
        r5 = 2;
        if (r1 != 0) goto L_0x007f;
    L_0x0048:
        r1 = "regular";
    L_0x004b:
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.w.d(r2, r3, r4);
        return r0;
    L_0x0051:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x0057:
        r0 = move-exception;
        r1 = hRg;
        r1 = r1.readLock();
        r1.unlock();
        throw r0;
    L_0x0062:
        r0 = r1.hRn;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r0.length();	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r7.substring(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        r2 = r1.hRr;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r2.openRead(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        goto L_0x002a;
    L_0x0073:
        r0 = move-exception;
        r2 = r1.hRp;	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0079;	 Catch:{ all -> 0x0057 }
    L_0x0078:
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x0079:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x007f:
        r1 = "SFS";
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream");
    }

    public static OutputStream gQ(String str) {
        return kg(str);
    }

    public static OutputStream ah(String str, String str2) {
        return ai(str, str2);
    }

    public static OutputStream kg(String str) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        String str2 = "";
        if (f.kp(str)) {
            str2 = f.ks(str);
            str = f.kq(str);
        }
        return ai(str, str2);
    }

    private static OutputStream ai(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        OutputStream fileOutputStream;
        SFSContextRec kf = kf(str);
        if (kf == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    fileOutputStream = new FileOutputStream(str);
                } else {
                    fileOutputStream = new c(str, str2);
                }
            } catch (Throwable th) {
                hRg.readLock().unlock();
            }
        } else {
            fileOutputStream = kf.hRr.ah(str.substring(kf.hRn.length()), str2);
        }
        hRg.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "openWrite: %s [%s, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = "ok";
        objArr[2] = kf == null ? "regular" : "SFS";
        w.d(str3, str4, objArr);
        return fileOutputStream;
    }

    public static boolean kh(String str) {
        InputStream openRead;
        OutputStream fileOutputStream;
        IOException e;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        if (str == null || str.length() == 0) {
            return false;
        }
        SFSContextRec kf = kf(str);
        if (kf == null) {
            hRg.readLock().unlock();
            return true;
        }
        try {
            openRead = kf.hRr.openRead(str.substring(kf.hRn.length()));
            try {
                String parent = new File(str).getParent();
                if (!bg.mA(parent)) {
                    new File(parent).mkdirs();
                }
                fileOutputStream = new FileOutputStream(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = openRead;
                try {
                    w.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    hRg.readLock().unlock();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    openRead = inputStream;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    hRg.readLock().unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                hRg.readLock().unlock();
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = openRead.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e7) {
                        }
                    }
                }
                openRead.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
                hRg.readLock().unlock();
                return true;
            } catch (IOException e9) {
                e = e9;
                outputStream = fileOutputStream;
                inputStream = openRead;
                w.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                hRg.readLock().unlock();
                return false;
            } catch (Throwable th4) {
                th = th4;
                outputStream = fileOutputStream;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                hRg.readLock().unlock();
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            inputStream = null;
            w.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            hRg.readLock().unlock();
            return false;
        } catch (Throwable th5) {
            th = th5;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            hRg.readLock().unlock();
            throw th;
        }
    }

    public static long ki(String str) {
        long j = 0;
        if (str != null) {
            String str2;
            SFSContextRec kf = kf(str);
            String kq;
            if (kf != null) {
                FileEntry ku = kf.hRr.ku(str.substring(kf.hRn.length()));
                if (ku != null) {
                    j = ku.size;
                } else if (kf.hRp) {
                    if (f.kp(str)) {
                        kq = f.kq(str);
                    } else {
                        kq = str;
                    }
                    j = new File(kq).length();
                }
            } else {
                if (f.kp(str)) {
                    kq = f.kq(str);
                } else {
                    kq = str;
                }
                j = new File(kq).length();
            }
            hRg.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "readFileLength: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (kf == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            w.d(str3, str4, objArr);
        }
        return j;
    }

    public static long kj(String str) {
        long j = 0;
        if (!(str == null || str.length() == 0)) {
            String str2;
            SFSContextRec kf = kf(str);
            if (kf != null) {
                FileEntry ku = kf.hRr.ku(str.substring(kf.hRn.length()));
                if (ku != null) {
                    j = ku.timestamp * 1000;
                } else if (kf.hRp) {
                    j = new File(str).lastModified();
                }
            } else {
                j = new File(str).lastModified();
            }
            hRg.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "getFileTime: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (kf == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            w.d(str3, str4, objArr);
        }
        return j;
    }

    public static byte[] c(String str, int i, int i2) {
        InputStream openRead;
        IOException e;
        Throwable th;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 < 0 ? 2048 : i2);
        try {
            openRead = openRead(str);
            if (i > 0) {
                try {
                    openRead.skip((long) i);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        w.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e3) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
            }
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            while (true) {
                int read = openRead.read(bArr, 0, Math.min(i2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
                if (read != -1 && i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    i2 -= read;
                } else if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e5) {
                    }
                }
            }
            if (openRead != null) {
                openRead.close();
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
            }
            w.d("MicroMsg.FileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
            return bArr;
        } catch (IOException e7) {
            e = e7;
            openRead = null;
            w.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
            if (openRead != null) {
                openRead.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            throw th;
        }
    }

    public static String aT(String str) {
        InputStreamReader inputStreamReader;
        IOException e;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[512];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringBuilder.append(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    }
                }
                inputStreamReader.close();
                return stringBuilder.toString();
            } catch (IOException e3) {
                e = e3;
                try {
                    w.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            w.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
    }

    public static int k(String str, byte[] bArr) {
        return b(str, bArr, bArr.length);
    }

    public static int b(String str, byte[] bArr, int i) {
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        OutputStream outputStream = null;
        try {
            outputStream = kg(str);
            outputStream.write(bArr, 0, i);
            if (outputStream == null) {
                return 0;
            }
            try {
                outputStream.close();
                return 0;
            } catch (IOException e) {
                return 0;
            }
        } catch (IOException e2) {
            w.e("MicroMsg.FileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    public static String kk(String str) {
        return new File(f.kq(str)).getParentFile().getAbsolutePath();
    }

    public static boolean kl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String kq = f.kq(str);
        if (!kd(kq)) {
            return true;
        }
        File file = new File(kq);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static long p(String str, String str2) {
        InputStream openRead;
        IOException e;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        try {
            OutputStream kg;
            openRead = openRead(str);
            try {
                kg = kg(str2);
            } catch (IOException e2) {
                e = e2;
                inputStream = openRead;
                try {
                    w.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    openRead = inputStream;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                long j = 0;
                while (true) {
                    int read = openRead.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    kg.write(bArr, 0, read);
                    j += (long) read;
                }
                w.d("MicroMsg.FileOp", "copyFile: %s -> %s", str, str2);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                if (kg == null) {
                    return j;
                }
                try {
                    kg.close();
                    return j;
                } catch (IOException e8) {
                    return j;
                }
            } catch (IOException e9) {
                e = e9;
                outputStream = kg;
                inputStream = openRead;
                w.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return -1;
            } catch (Throwable th4) {
                th = th4;
                outputStream = kg;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            inputStream = null;
            w.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return -1;
        } catch (Throwable th5) {
            th = th5;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public static boolean aO(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean nativeExists;
        String str2;
        SFSContextRec kf = kf(str);
        if (kf != null) {
            SFSContext sFSContext = kf.hRr;
            String substring = str.substring(kf.hRn.length());
            if (sFSContext.mNativePtr == 0) {
                throw new IllegalArgumentException("Reuse already released SFSContext.");
            }
            if (f.kp(substring)) {
                f.kr(substring);
                substring = f.kq(substring);
            }
            nativeExists = SFSContext.nativeExists(sFSContext.mNativePtr, substring);
            if (!nativeExists && kf.hRp) {
                nativeExists = new File(str).exists();
            }
        } else {
            nativeExists = new File(str).exists();
        }
        hRg.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "fileExists: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(nativeExists);
        if (kf == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        w.d(str3, str4, objArr);
        return nativeExists;
    }

    public static boolean deleteFile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean gR;
        String str2;
        SFSContextRec kf = kf(str);
        String kq;
        if (kf != null) {
            gR = kf.hRr.gR(str.substring(kf.hRn.length()));
            if (!gR && kf.hRp) {
                if (f.kp(str)) {
                    kq = f.kq(str);
                } else {
                    kq = str;
                }
                gR = new File(kq).delete();
            }
        } else {
            if (f.kp(str)) {
                kq = f.kq(str);
            } else {
                kq = str;
            }
            gR = new File(kq).delete();
        }
        hRg.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "deleteFile: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(gR);
        if (kf == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        w.d(str3, str4, objArr);
        return gR;
    }

    public static boolean h(String str, String str2, String str3) {
        return aj(str + str2, str + str3);
    }

    public static boolean aj(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (ke(str) && ke(str2)) {
            if (f.kp(str)) {
                str = f.kq(str);
            }
            if (f.kp(str2)) {
                str2 = f.kq(str2);
            }
            if (new File(str).renameTo(new File(str2))) {
                return true;
            }
        }
        if (p(str, str2) < 0) {
            return false;
        }
        deleteFile(str);
        return true;
    }

    public static List<FileEntry> x(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        List<FileEntry> arrayList;
        SFSContextRec kf = kf(str);
        if (kf != null) {
            str = str.substring(kf.hRn.length());
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            try {
                List<FileEntry> kt = kf.hRr.kt(str);
                arrayList = new ArrayList();
                for (FileEntry fileEntry : kt) {
                    if (fileEntry.name.substring(str.length()).indexOf(47) == -1) {
                        arrayList.add(fileEntry);
                    }
                }
                for (FileEntry fileEntry2 : arrayList) {
                    fileEntry2.name = kf.hRn + fileEntry2.name;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FileOp", e, "listFiles failed with SFS: " + str, new Object[0]);
                arrayList = new ArrayList();
            }
        } else {
            arrayList = new ArrayList();
        }
        if (kf == null || kf.hRo != null || kf.hRp) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new File(str));
            do {
                File[] listFiles = ((File) arrayDeque.pop()).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            FileEntry fileEntry3 = new FileEntry();
                            fileEntry3.name = file.getAbsolutePath();
                            if (z) {
                                fileEntry3.size = file.length();
                                fileEntry3.timestamp = file.lastModified();
                            }
                            arrayList.add(fileEntry3);
                        } else {
                            file.isDirectory();
                        }
                    }
                }
            } while (!arrayDeque.isEmpty());
            hRg.readLock().unlock();
            w.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
            return arrayList;
        }
        hRg.readLock().unlock();
        w.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static boolean y(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean z2;
        SFSContextRec kf = kf(str);
        if (kf != null) {
            try {
                if (str.equals(kf.hRn)) {
                    SFSContext sFSContext = kf.hRr;
                    if (sFSContext.mNativePtr == 0) {
                        throw new IllegalArgumentException("Reuse already released SFSContext.");
                    } else if (SFSContext.nativeClear(sFSContext.mNativePtr) != 0) {
                        throw new IOException(SFSContext.nativeErrorMessage());
                    }
                }
                for (FileEntry fileEntry : kf.hRr.kt(str.substring(kf.hRn.length()))) {
                    kf.hRr.gR(fileEntry.name);
                }
                z2 = true;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FileOp", e, "deleteDirIncludedFiles failed: " + str, new Object[0]);
                z2 = false;
            }
        } else {
            File file = new File(str);
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new a(file));
            do {
                a aVar = (a) arrayDeque.getLast();
                if (aVar.hRm == null) {
                    aVar.hRm = aVar.hRl.listFiles();
                }
                if (aVar.hRm != null) {
                    File[] fileArr = aVar.hRm;
                    for (int i = aVar.pos; i < fileArr.length; i++) {
                        File file2 = fileArr[i];
                        if (file2.isFile()) {
                            file2.delete();
                        } else if (file2.isDirectory()) {
                            aVar.pos = i;
                            arrayDeque.add(new a(file2));
                            break;
                        }
                    }
                    if (!z) {
                        aVar.hRl.delete();
                    }
                    arrayDeque.removeLast();
                } else if (!z) {
                    aVar.hRl.delete();
                }
            } while (!arrayDeque.isEmpty());
            z2 = true;
        }
        hRg.readLock().unlock();
        return z2;
    }

    public static boolean km(String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return z;
        }
        if (!aO(str)) {
            try {
                try {
                    kg(str).close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                w.e("MicroMsg.FileOp", "createNewFile '%s' failed: %s", str, e2.getMessage());
                return z;
            }
        }
        return true;
    }

    public static void kn(String str) {
        if (str != null && str.length() != 0 && kd(str)) {
            try {
                new File(str, ".nomedia").createNewFile();
            } catch (IOException e) {
                w.e("MicroMsg.FileOp", "markNoMedia '%s' failed: %s", str, e.getMessage());
            }
        }
    }

    public static String ko(String str) {
        if (!aO(str)) {
            return null;
        }
        return g.n((str + "-" + ki(str)).getBytes());
    }
}
