package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.bu;
import com.tencent.recovery.Recovery;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k implements c, d {
    public static final long fwB = bg.Nz();
    private static final String fwJ;
    private static final String fwK;
    private static String fwL = "";
    private static final String fwM = ("version:" + com.tencent.mm.protocal.d.sYN);
    public static long[] fwN = new long[]{0, 0, 0};
    private ai fwC = null;
    private a fwD;
    public volatile long fwE = 0;
    HashSet<String> fwF;
    String fwG;
    String fwH;
    ConditionVariable fwI;
    volatile b fwO;

    private class a extends FileObserver {
        final /* synthetic */ k fwQ;

        a(k kVar, String str) {
            this.fwQ = kVar;
            super(str, 712);
        }

        public final void onEvent(int i, String str) {
            if ((System.currentTimeMillis() - this.fwQ.fwE < 120000 ? 1 : null) == null) {
                synchronized (this.fwQ.fwF) {
                    switch (i) {
                        case 8:
                            w.i("MicroMsg.MMCrashReporter", "Detected trace file changed: " + str);
                            this.fwQ.fwI.open();
                            if (this.fwQ.fwO == null) {
                                this.fwQ.fwO = new b(this.fwQ);
                                e.post(this.fwQ.fwO, "MMCrashReporter_parseANRTrace");
                                break;
                            }
                            break;
                        case 64:
                        case 512:
                            this.fwQ.fwF.remove(str);
                            break;
                        case FileUtils.S_IWUSR /*128*/:
                            break;
                    }
                    this.fwQ.fwF.add(str);
                }
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ k fwQ;

        public b(k kVar) {
            this.fwQ = kVar;
        }

        private static ProcessErrorStateInfo or() {
            List<ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) ab.getContext().getSystemService("activity")).getProcessesInErrorState();
            if (processesInErrorState == null) {
                return null;
            }
            for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                    return processErrorStateInfo;
                }
            }
            return null;
        }

        public final void run() {
            ArrayList arrayList;
            long currentTimeMillis = System.currentTimeMillis();
            w.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
            ProcessErrorStateInfo processErrorStateInfo = null;
            while (this.fwQ.fwI.block(10000)) {
                this.fwQ.fwI.close();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                processErrorStateInfo = or();
                if (processErrorStateInfo != null) {
                    break;
                }
            }
            if (processErrorStateInfo == null) {
                processErrorStateInfo = or();
                if (processErrorStateInfo == null) {
                    w.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                    this.fwQ.fwO = null;
                    return;
                }
            }
            ProcessErrorStateInfo processErrorStateInfo2 = processErrorStateInfo;
            w.i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo2.processName + " @ " + processErrorStateInfo2.pid);
            synchronized (this.fwQ.fwF) {
                String str;
                arrayList = new ArrayList(this.fwQ.fwF.size());
                int lastIndexOf = this.fwQ.fwH.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    str = this.fwQ.fwH.substring(0, lastIndexOf) + '_' + processErrorStateInfo2.processName + this.fwQ.fwH.substring(lastIndexOf);
                    if (this.fwQ.fwF.remove(str)) {
                        arrayList.add(str);
                    }
                }
                if (this.fwQ.fwF.remove(this.fwQ.fwH)) {
                    arrayList.add(this.fwQ.fwH);
                }
                arrayList.addAll(this.fwQ.fwF);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str = k.a(this.fwQ.fwG + '/' + ((String) it.next()), processErrorStateInfo2.pid, currentTimeMillis, processErrorStateInfo2);
                if (str != null) {
                    w.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", r0);
                    this.fwQ.h(str, processErrorStateInfo2.pid);
                    break;
                }
                w.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", r0);
            }
            w.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
            this.fwQ.fwO = null;
        }
    }

    static {
        String rB = p.rB();
        fwJ = rB;
        fwK = o.getString(rB.hashCode());
    }

    private static String op() {
        String A = ao.hlW.A("login_weixin_username", "");
        if (bg.mA(A)) {
            return ao.hlW.A("login_user_name", "never_login_crash");
        }
        return A;
    }

    public static boolean bi(String str) {
        Object obj = null;
        fwL = str;
        if (y.bCs() == null) {
            Object cls;
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMCrashReporter", e, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = obj;
            }
            try {
                obj = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ab.getContext().getClassLoader());
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            w.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + fwL);
            w.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + obj + " thisProcName: " + fwL);
            Class es = com.tencent.mm.bb.d.es("sandbox", ".SubCoreSandBox");
            w.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + es + " thisProcName: " + fwL);
            if (es != null) {
                try {
                    v vVar = (v) es.newInstance();
                    y.a(vVar);
                    w.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + vVar + " thisProcName: " + fwL);
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "", new Object[0]);
                    w.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        c cVar;
        try {
            cVar = (c) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            cVar.ag(ab.getContext());
            ao.hlW.A("last_login_uin", fwK);
            com.tencent.mm.sdk.a.b.a(cVar);
            AnonymousClass1 anonymousClass1 = new Object() {
            };
            return true;
        } catch (Exception e4) {
            w.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            cVar = new k();
            cVar.ag(ab.getContext());
            com.tencent.mm.sdk.a.b.a(cVar);
            String str2 = x.get("ro.product.cpu.abi");
            if (str2 == null || str2.length() == 0 || !(str2.equals("x86") || str2.equals("x86-64"))) {
                com.tencent.mm.compatible.util.k.b("wechatCrashForJni", k.class.getClassLoader());
                CrashMonitorForJni.setClientVersionMsg(fwM);
            }
            bu.gt(com.tencent.mm.compatible.util.e.hgq);
            return false;
        }
    }

    public static void a(ai.c cVar) {
        ai.a(cVar);
    }

    private static void bj(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, 896).lastIndexOf("\n");
                if (-1 == lastIndexOf) {
                    break;
                }
                w.e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        w.e("MicroMsg.MMCrashReporter", str);
    }

    public final void ag(final Context context) {
        Throwable e;
        BufferedReader bufferedReader;
        ai.a((d) this);
        if (fwL.endsWith(":push")) {
            String str;
            try {
                str = x.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.fwG = file.getParent();
            if (this.fwG == null || this.fwG.length() == 0) {
                this.fwG = "/";
            }
            this.fwH = file.getName();
            this.fwI = new ConditionVariable();
            w.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: " + str);
            this.fwF = new HashSet();
            this.fwD = new a(this, this.fwG);
            this.fwD.startWatching();
            File[] listFiles = new File(context.getFilesDir(), "crash").listFiles(new FilenameFilter(this) {
                String fwP = context.getPackageName();
                final /* synthetic */ k fwQ;

                public final boolean accept(File file, String str) {
                    return str.startsWith(this.fwP);
                }
            });
            if (listFiles != null) {
                StringBuilder stringBuilder = new StringBuilder(16384);
                Pattern compile = Pattern.compile("^signal (\\d+) \\([A-Z]+\\), code ");
                for (File file2 : listFiles) {
                    int i = -1;
                    w.i("MicroMsg.MMCrashReporter", "Uploading previous crash: " + file2);
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file2));
                        try {
                            stringBuilder.setLength(0);
                            while (true) {
                                Object readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i < 0) {
                                    Matcher matcher = compile.matcher(readLine);
                                    if (matcher.matches()) {
                                        i = bg.getInt(matcher.group(1), 0);
                                    }
                                }
                                stringBuilder.append(readLine).append('\n');
                            }
                            if (stringBuilder.toString().startsWith(fwM)) {
                                String substring = stringBuilder.toString().substring(stringBuilder.toString().indexOf(fwM) + fwM.length());
                                if (substring != null && substring.trim().length() > 0) {
                                    a(i, substring, true);
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            try {
                                w.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                file2.delete();
                            } catch (Throwable th) {
                                e2 = th;
                            }
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        bufferedReader = null;
                        w.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        file2.delete();
                    } catch (Throwable th2) {
                        e2 = th2;
                        bufferedReader = null;
                    }
                    file2.delete();
                }
                return;
            }
            return;
        }
        return;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e7) {
            }
        }
        throw e2;
        throw e2;
    }

    public final void r(String str, String str2) {
        if (y.bCs() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", op());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            y.bCs().o(ab.getContext(), intent);
        }
    }

    public final void a(com.tencent.mm.sdk.a.a aVar) {
        ai.a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.sdk.platformtools.ai r8, java.lang.String r9, java.lang.Throwable r10) {
        /*
        r7 = this;
        r6 = 0;
        r2 = "";
        r0 = r10 instanceof junit.framework.AssertionFailedError;
        if (r0 == 0) goto L_0x0072;
    L_0x0008:
        r3 = r10.getMessage();
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r0 != 0) goto L_0x0072;
    L_0x0012:
        r0 = r8.utr;
        r0 = r0.entrySet();
        r4 = r0.iterator();
        if (r4 == 0) goto L_0x006e;
    L_0x001e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x006e;
    L_0x0024:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 != 0) goto L_0x001e;
    L_0x0036:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x001e;
    L_0x003c:
        r1 = r3.startsWith(r1);
        if (r1 == 0) goto L_0x001e;
    L_0x0042:
        r0 = r0.getValue();
        r0 = (com.tencent.mm.sdk.platformtools.ai.b) r0;
        r0 = r0.AF();
    L_0x004c:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 != 0) goto L_0x0072;
    L_0x0052:
        com.tencent.mm.app.n.c(r10);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = bk(r0);
        r0 = r1.append(r0);
        r0 = r0.append(r9);
        r0 = r0.toString();
        b(r0, r6, r6);
        return;
    L_0x006e:
        r0 = "";
        goto L_0x004c;
    L_0x0072:
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.k.a(com.tencent.mm.sdk.platformtools.ai, java.lang.String, java.lang.Throwable):void");
    }

    private static void b(String str, int i, boolean z) {
        bj(str);
        g.oUh.a(11338, true, true, Integer.valueOf(2));
        g.oUh.a(25, 0, 1, true);
        if (ab.um().endsWith(":push")) {
            g.oUh.a(25, 2, 1, true);
        } else if (ab.um().endsWith(":tools")) {
            g.oUh.a(25, 3, 1, true);
        } else if (ab.um().endsWith(":exdevice")) {
            g.oUh.a(25, 4, 1, true);
        } else if (ab.bJb()) {
            g.oUh.a(25, 1, 1, true);
        }
        g gVar = g.oUh;
        g.aXK();
        if (e.ae(ab.getContext()) == 1) {
            str = str.substring(0, e.af(ab.getContext()));
        }
        e.d(ab.getContext(), ab.um(), z ? "jni" : "java");
        if (i > 0 && str.length() > i) {
            str = str.substring(0, i);
        }
        if (y.bCs() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", op());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            y.bCs().o(ab.getContext(), intent);
        }
    }

    public final void h(int i, String str) {
        a(i, str, false);
    }

    private static void a(int i, String str, boolean z) {
        String str2 = null;
        if (i == 6) {
            try {
                String oq = oq();
                if (oq != null) {
                    str2 = a(oq, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed reporting JNI crash.", new Object[0]);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("#[jin_crash]sig=").append(i).append('\n');
        stringBuilder.append("#crash.previous=").append(z).append('\n');
        stringBuilder.append(bk(""));
        stringBuilder.append(str).append('\n');
        if (str2 != null) {
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str2);
        }
        b(stringBuilder.toString(), i == 6 ? 0 : 8192, true);
        w.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!z) {
            w.appenderClose();
        }
    }

    private static String oq() {
        String str;
        try {
            str = x.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String um = ab.um();
            if (um == null || um.length() == 0) {
                um = "com.tencent.mm";
            }
            um = str.substring(0, lastIndexOf) + '_' + um + str.substring(lastIndexOf);
            if (new File(um).isFile()) {
                return um;
            }
        }
        return !new File(str).isFile() ? null : str;
    }

    static String a(String str, int i, long j, ProcessErrorStateInfo processErrorStateInfo) {
        Throwable e;
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2 = "----- pid " + i + " at ";
        if (processErrorStateInfo != null) {
            stringBuilder.append(processErrorStateInfo.longMsg).append('\n');
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    switch (obj) {
                        case null:
                            if (!readLine.startsWith(str2)) {
                                break;
                            }
                            int length = str2.length();
                            long time = simpleDateFormat.parse(readLine.substring(length, length + 19)).getTime() - j;
                            if (time >= -60000 && time <= 60000) {
                                obj = 1;
                                break;
                            }
                        case 1:
                            stringBuilder.append(readLine).append('\n');
                            if (!readLine.startsWith("DALVIK THREADS")) {
                                if (!readLine.startsWith("-----")) {
                                    break;
                                }
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                }
                                return null;
                            }
                            obj = 2;
                            break;
                        case 2:
                            try {
                                if (!readLine.startsWith("----- end ")) {
                                    stringBuilder.append(readLine).append('\n');
                                    break;
                                }
                                String stringBuilder2 = stringBuilder.toString();
                                try {
                                    bufferedReader.close();
                                    return stringBuilder2;
                                } catch (IOException e3) {
                                    return stringBuilder2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                break;
                            }
                        default:
                            break;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            try {
                w.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    final void h(String str, int i) {
        Recovery.cdu();
        g.oUh.a(11339, true, true, Integer.valueOf(Downloads.MIN_RETYR_AFTER), Integer.valueOf(0));
        g.oUh.a(26, 0, 1, true);
        bj(str);
        g gVar = g.oUh;
        g.aXK();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.fwE >= 120000) {
            this.fwE = currentTimeMillis;
            e.d(ab.getContext(), ab.um(), "anr");
            StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
            stringBuilder.append(bk(""));
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str);
            if (y.bCs() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", ao.hlW.A("login_user_name", "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                y.bCs().o(ab.getContext(), intent);
            }
        }
    }

    private static String bk(String str) {
        String crashExtraMessage;
        RandomAccessFile randomAccessFile;
        Throwable e;
        int[] iArr;
        MemoryInfo[] processMemoryInfo;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ab.getContext();
        stringBuilderPrinter.println("#client.version=" + com.tencent.mm.protocal.d.sYN);
        stringBuilderPrinter.println("#client.verhistory=" + bu.Ab());
        stringBuilderPrinter.println("#client.imei=" + p.rA());
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        stringBuilderPrinter.println("#accinfo.uin=" + ao.hlW.A("last_login_uin", fwK));
        stringBuilderPrinter.println("#accinfo.dev=" + fwJ);
        stringBuilderPrinter.println("#accinfo.runtime=" + (bg.Nz() - fwB) + "(" + bg.mz(fwL) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fuV);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        stringBuilderPrinter.println("#qbmin.ver=" + QbSdk.getMiniQBVersion(context));
        if (fwL.contains(":tools") || fwL.contains(":appbrand")) {
            crashExtraMessage = WebView.getCrashExtraMessage(context);
            if (crashExtraMessage != null && crashExtraMessage.length() > 0) {
                if (crashExtraMessage.length() > 8192) {
                    crashExtraMessage = crashExtraMessage.substring(crashExtraMessage.length() - 8192);
                }
                stringBuilderPrinter.println("#qbrowser.crashmsg=" + Base64.encodeToString(crashExtraMessage.getBytes(), 2));
                w.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", crashExtraMessage);
            }
        }
        stringBuilderPrinter.println("#accinfo.env=" + (com.tencent.mm.sdk.a.b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + com.tencent.mm.sdk.a.b.urS);
        String str2 = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.hgs);
            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
            Context context2 = ab.getContext();
            String packageName = ab.getContext().getPackageName();
            synchronized (fwN) {
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context2.getPackageManager(), new Object[]{packageName, new Stub() {
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            k.fwN[0] = packageStats.cacheSize;
                            k.fwN[1] = packageStats.dataSize;
                            k.fwN[2] = packageStats.codeSize;
                            w.i("MicroMsg.MMCrashReporter", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                            synchronized (k.fwN) {
                                k.fwN.notify();
                            }
                        }
                    }});
                    fwN.wait(500);
                } catch (Throwable e2) {
                    Throwable e22;
                    fwN[0] = -1;
                    fwN[1] = -1;
                    fwN[2] = -1;
                    w.printErrStackTrace("MicroMsg.MMCrashReporter", e22, "crash e:", new Object[0]);
                    synchronized (fwN) {
                        fwN.notify();
                    }
                }
            }
            crashExtraMessage = String.format("%dMB %dMB %s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), Long.valueOf(fwN[0]), Long.valueOf(fwN[1]), Long.valueOf(fwN[2]), com.tencent.mm.compatible.util.e.hgs, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e3) {
            w.e("MicroMsg.MMCrashReporter", "check data size failed :%s", e3.getMessage());
            crashExtraMessage = str2;
        }
        stringBuilderPrinter.println("#accinfo.data=" + crashExtraMessage);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        String str3 = "";
        ActivityManager activityManager = (ActivityManager) ab.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = 0;
        if (com.tencent.mm.compatible.util.d.eo(16)) {
            j = memoryInfo.totalMem;
        } else {
            try {
                randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    char[] toCharArray = randomAccessFile.readLine().toCharArray();
                    int length = toCharArray.length;
                    int i = 0;
                    while (i < length) {
                        if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                            stringBuffer.append(toCharArray[i]);
                        }
                        i++;
                    }
                    long j2 = bg.getLong(stringBuffer.toString(), -1);
                    if (j2 > 0) {
                        j = j2 << 10;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Exception e4) {
                    }
                } catch (Exception e5) {
                    e = e5;
                    try {
                        w.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e6) {
                            }
                        }
                        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                        iArr = new int[]{Process.myPid()};
                        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                        if (processMemoryInfo != null) {
                        }
                        crashExtraMessage = str2;
                        stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
                        if (!bg.mA(str)) {
                            stringBuilderPrinter.println("#" + str);
                        }
                        stringBuilderPrinter.println("#crashContent=");
                        return stringBuilder.toString();
                    } catch (Throwable th) {
                        e22 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e7) {
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e8) {
                e = e8;
                randomAccessFile = null;
                w.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                iArr = new int[]{Process.myPid()};
                processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                if (processMemoryInfo != null) {
                }
                crashExtraMessage = str2;
                stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
                if (bg.mA(str)) {
                    stringBuilderPrinter.println("#" + str);
                }
                stringBuilderPrinter.println("#crashContent=");
                return stringBuilder.toString();
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e22;
            }
        }
        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
        iArr = new int[]{Process.myPid()};
        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
        if (processMemoryInfo != null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
            crashExtraMessage = str2;
        } else {
            MemoryInfo memoryInfo2 = processMemoryInfo[0];
            crashExtraMessage = str2 + "[pid(" + iArr[0] + "):" + (memoryInfo2.getTotalPss() << 10) + " " + (memoryInfo2.getTotalPrivateDirty() << 10) + " " + (memoryInfo2.getTotalSharedDirty() << 10) + "]";
        }
        stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
        if (bg.mA(str)) {
            stringBuilderPrinter.println("#" + str);
        }
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }
}
