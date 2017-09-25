package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static SparseArray<b> gWB = new SparseArray();
    private static final byte[] gWC = new byte[0];
    private static ae mHandler = new ae(Looper.getMainLooper());

    private static class a implements Runnable {
        private WakerLock gWD = null;

        public a(WakerLock wakerLock) {
            this.gWD = wakerLock;
        }

        public final void run() {
            int i = 1;
            b bVar = (b) a.gWB.get(this.gWD.hashCode());
            String str = "MicroMsg.WakeLockManager";
            String str2 = "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(this.gWD.hashCode());
            objArr[1] = Integer.valueOf(this.gWD.innerWakeLockHashCode());
            objArr[2] = this.gWD.getCreatePosStackLine();
            Collection<a> values = bVar.gWG.values();
            StringBuilder stringBuilder = new StringBuilder();
            for (a aVar : values) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append(',');
                }
                if (aVar.gWI != 0) {
                    stringBuilder.append('{').append(aVar.gWH).append(',').append(SystemClock.elapsedRealtime() - aVar.gWI).append('}');
                }
            }
            if (stringBuilder.length() == 0) {
                stringBuilder.append("<empty>");
            }
            objArr[3] = stringBuilder.toString();
            w.w(str, str2, objArr);
            this.gWD.unLock();
        }
    }

    private static class b {
        volatile boolean gWE = false;
        a gWF = null;
        public Map<String, a> gWG = new HashMap();

        private static class a {
            public String gWH = null;
            public long gWI = 0;

            public a(String str, long j) {
                this.gWH = str;
                this.gWI = j;
            }
        }

        public b(WakerLock wakerLock) {
            this.gWF = new a(wakerLock);
        }
    }

    private static class c {
        private static long fxD = 0;
        private static int gWJ = 0;
        private static long gWK = 0;
        private static HashMap<String, a> gWL = null;
        private static final byte[] gWM = new byte[0];
        private static BroadcastReceiver gWN = null;

        private static class a implements Externalizable {
            public String gWH = "";
            public String gWO = "";
            public String gWP = "";
            public boolean gWQ = false;
            public int gWR = 0;
            public int gWS = 0;
            public long gWT = 0;
            public long gWU = 0;
            public AtomicInteger gWV = new AtomicInteger(0);

            public final void readExternal(ObjectInput objectInput) {
                this.gWO = objectInput.readUTF();
                this.gWH = objectInput.readUTF();
                this.gWR = objectInput.readInt();
                this.gWS = objectInput.readInt();
                this.gWT = objectInput.readLong();
                this.gWP = "";
                this.gWQ = false;
                this.gWU = 0;
                this.gWV = new AtomicInteger(0);
            }

            public final void writeExternal(ObjectOutput objectOutput) {
                objectOutput.writeUTF(this.gWO);
                objectOutput.writeUTF(this.gWH);
                objectOutput.writeInt(this.gWR);
                objectOutput.writeInt(this.gWS);
                objectOutput.writeLong(this.gWT);
            }
        }

        public static void uA() {
            ObjectInputStream objectInputStream;
            IntentFilter intentFilter;
            Throwable th;
            ObjectInputStream objectInputStream2 = null;
            if (gWJ == 0) {
                gWJ = Process.myPid();
                gWN = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        String action = intent.getAction();
                        if (!bg.mA(action)) {
                            int intExtra = intent.getIntExtra("pid", 0);
                            if (intExtra != 0) {
                                String stringExtra = intent.getStringExtra("processName");
                                if (!bg.mA(stringExtra) && stringExtra.equals(bg.q(ab.getContext(), intExtra))) {
                                    String stringExtra2 = intent.getStringExtra("traceMsg");
                                    long longExtra = intent.getLongExtra("tick", 0);
                                    if ("com.tencent.mm.ACTION.note_tracemsg_lock".equals(action)) {
                                        c.a(stringExtra, stringExtra2, longExtra);
                                    } else if ("com.tencent.mm.ACTION.note_tracemsg_unlock".equals(action)) {
                                        c.b(stringExtra, stringExtra2, longExtra);
                                    }
                                }
                            }
                        }
                    }
                };
                synchronized (gWM) {
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(new File(ab.getContext().getCacheDir(), "wakelock/wakelock_stats.bin")));
                        try {
                            fxD = objectInputStream3.readLong();
                            gWL = (HashMap) objectInputStream3.readObject();
                            try {
                                objectInputStream3.close();
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            objectInputStream = objectInputStream3;
                            try {
                                w.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                                fxD = SystemClock.elapsedRealtime();
                                gWL = new HashMap();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                intentFilter = new IntentFilter();
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                                ab.getContext().registerReceiver(gWN, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                                w.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ab.um());
                            } catch (Throwable th2) {
                                objectInputStream2 = objectInputStream;
                                th = th2;
                                if (objectInputStream2 != null) {
                                    try {
                                        objectInputStream2.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream2 = objectInputStream3;
                            if (objectInputStream2 != null) {
                                objectInputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        objectInputStream = null;
                        w.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                        fxD = SystemClock.elapsedRealtime();
                        gWL = new HashMap();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                        ab.getContext().registerReceiver(gWN, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                        w.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ab.um());
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectInputStream2 != null) {
                            objectInputStream2.close();
                        }
                        throw th;
                    }
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                ab.getContext().registerReceiver(gWN, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                w.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ab.um());
            }
        }

        public static void detach() {
            if (gWJ > 0) {
                ab.getContext().unregisterReceiver(gWN);
                uC();
                gWJ = 0;
                w.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", ab.um());
            }
        }

        public static void dY(String str) {
            j(str, true);
        }

        public static void dZ(String str) {
            j(str, false);
        }

        private static void j(String str, boolean z) {
            int myPid = Process.myPid();
            String um = ab.um();
            if (myPid == gWJ) {
                if (z) {
                    a(um, str, SystemClock.elapsedRealtime());
                } else {
                    b(um, str, SystemClock.elapsedRealtime());
                }
            } else if (z) {
                r2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                r2.putExtra("pid", myPid);
                r2.putExtra("processName", um);
                r2.putExtra("traceMsg", str);
                r2.putExtra("tick", SystemClock.elapsedRealtime());
                ab.getContext().sendBroadcast(r2, WXApp.WXAPP_BROADCAST_PERMISSION);
            } else {
                r2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                r2.putExtra("pid", myPid);
                r2.putExtra("processName", um);
                r2.putExtra("traceMsg", str);
                r2.putExtra("tick", SystemClock.elapsedRealtime());
                ab.getContext().sendBroadcast(r2, WXApp.WXAPP_BROADCAST_PERMISSION);
            }
        }

        public static void a(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            synchronized (gWM) {
                a aVar = (a) gWL.get(str3);
                if (aVar == null) {
                    aVar = new a();
                    aVar.gWO = str;
                    aVar.gWH = str2;
                    aVar.gWT = 0;
                    aVar.gWR = 0;
                    aVar.gWS = 0;
                    gWL.put(str3, aVar);
                }
                if (aVar.gWV.getAndIncrement() == 0) {
                    aVar.gWU = j;
                    aVar.gWP = am.getNetTypeString(ab.getContext());
                    aVar.gWQ = com.tencent.mm.sdk.a.b.foreground;
                }
            }
        }

        public static void b(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            long j2 = 0;
            synchronized (gWM) {
                a aVar = (a) gWL.get(str3);
                if (aVar != null && aVar.gWV.get() > 0) {
                    aVar.gWR++;
                    if (aVar.gWV.decrementAndGet() == 0) {
                        j2 = j - aVar.gWU;
                        aVar.gWT += j2;
                        aVar.gWS++;
                    }
                }
                long j3 = j2;
            }
            uB();
            j2 = SystemClock.elapsedRealtime();
            if (j3 >= 14000 || j2 - gWK >= 3600000) {
                w.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                uC();
                gWK = j2;
            }
        }

        private static void uB() {
            synchronized (gWM) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - fxD >= 21600000) {
                    if (!gWL.isEmpty()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Entry value : gWL.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar.gWS > 0) {
                                stringBuilder.setLength(0);
                                stringBuilder.append(aVar.gWO).append(',').append(aVar.gWH.replace(",", "##")).append(',').append(aVar.gWS).append(',').append(aVar.gWR).append(',').append(aVar.gWT).append(',').append(aVar.gWQ ? 1 : 0).append(',').append(aVar.gWP);
                                String stringBuilder2 = stringBuilder.toString();
                                com.tencent.mm.sdk.b.b mpVar = new mp();
                                mpVar.fTU.fTV = stringBuilder2;
                                com.tencent.mm.sdk.b.a.urY.m(mpVar);
                                w.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", stringBuilder.toString());
                            }
                        }
                        gWL.clear();
                    }
                    fxD = elapsedRealtime;
                }
            }
        }

        private static void uC() {
            Throwable e;
            synchronized (gWM) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    File file = new File(ab.getContext().getCacheDir(), "wakelock");
                    if (FileOp.kl(file.getAbsolutePath())) {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(file, "wakelock_stats.bin")));
                        try {
                            objectOutputStream2.writeLong(fxD);
                            objectOutputStream2.writeObject(gWL);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                w.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            } catch (Throwable th) {
                                e = th;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw e;
                        }
                    } else {
                        throw new IOException("failed to call FileOp.mkdirs(" + file.getAbsolutePath() + ")");
                    }
                } catch (IOException e6) {
                    e = e6;
                    w.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                }
            }
        }
    }

    public static void uy() {
        c.uA();
    }

    public static void uz() {
        c.detach();
    }

    public static void a(WakerLock wakerLock, String str) {
        synchronized (gWC) {
            b bVar = (b) gWB.get(wakerLock.hashCode());
            if (bVar == null) {
                bVar = new b(wakerLock);
                gWB.put(wakerLock.hashCode(), bVar);
            }
            if (!bVar.gWG.containsKey(str)) {
                bVar.gWG.put(str, new a(str, SystemClock.elapsedRealtime()));
            }
            c.dY(str);
            ae aeVar = mHandler;
            if (!bVar.gWE) {
                bVar.gWE = true;
                aeVar.postDelayed(bVar.gWF, 60000);
            }
        }
    }

    public static void c(WakerLock wakerLock) {
        synchronized (gWC) {
            b bVar = (b) gWB.get(wakerLock.hashCode());
            if (bVar != null) {
                ae aeVar = mHandler;
                if (bVar.gWE) {
                    bVar.gWE = false;
                    aeVar.removeCallbacks(bVar.gWF);
                }
                for (a aVar : bVar.gWG.values()) {
                    c.dZ(aVar.gWH);
                }
                bVar.gWG.clear();
            }
        }
    }
}
