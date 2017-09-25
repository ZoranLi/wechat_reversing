package com.tencent.qqmusic.mediaplayer.util;

public class CpuInfoUtil {
    private static final String CUR_CPU_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    private static final String TAG = "CpuInfoUtil";
    private static OutputCpuThread mCurrThread = null;

    private static class OutputCpuThread extends Thread {
        public boolean isStop = false;

        public OutputCpuThread(String str) {
            super(str);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r8 = this;
            r2 = 0;
            r4 = 0;
            super.run();
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r0 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0073, all -> 0x008e }
            r1 = "top -m 10 -s cpu -t";
            r1 = r0.exec(r1);	 Catch:{ Exception -> 0x0073, all -> 0x008e }
            r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00ac, all -> 0x00a4 }
            r0 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00ac, all -> 0x00a4 }
            r6 = r1.getInputStream();	 Catch:{ Exception -> 0x00ac, all -> 0x00a4 }
            r0.<init>(r6);	 Catch:{ Exception -> 0x00ac, all -> 0x00a4 }
            r3.<init>(r0);	 Catch:{ Exception -> 0x00ac, all -> 0x00a4 }
            r0 = r4;
        L_0x0024:
            r6 = r3.readLine();	 Catch:{ Exception -> 0x00ae, all -> 0x00a7 }
            if (r6 == 0) goto L_0x0062;
        L_0x002a:
            r2 = r8.isStop;	 Catch:{ Exception -> 0x00ae, all -> 0x00a7 }
            if (r2 != 0) goto L_0x0062;
        L_0x002e:
            r2 = r0 + 1;
            r0 = r5.append(r6);	 Catch:{ Exception -> 0x00ae, all -> 0x00a7 }
            r6 = "\n";
            r0.append(r6);	 Catch:{ Exception -> 0x00ae, all -> 0x00a7 }
            r0 = 15;
            if (r2 <= r0) goto L_0x00b1;
        L_0x003e:
            r0 = "CpuInfoUtil";
            r6 = r5.toString();	 Catch:{ Exception -> 0x0059, all -> 0x00a7 }
            com.tencent.qqmusic.mediaplayer.util.Logger.d(r0, r6);	 Catch:{ Exception -> 0x0059, all -> 0x00a7 }
            r0 = 0;
            r6 = r5.length();	 Catch:{ Exception -> 0x0059, all -> 0x00a7 }
            r6 = r6 + -1;
            r5.delete(r0, r6);	 Catch:{ Exception -> 0x0059, all -> 0x00a7 }
            r6 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            sleep(r6);	 Catch:{ Exception -> 0x0059, all -> 0x00a7 }
            r0 = r4;
            goto L_0x0024;
        L_0x0059:
            r0 = move-exception;
            r6 = "CpuInfoUtil";
            com.tencent.qqmusic.mediaplayer.util.Logger.e(r6, r0);	 Catch:{ Exception -> 0x00ae, all -> 0x00a7 }
            r0 = r2;
            goto L_0x0024;
        L_0x0062:
            r3.close();	 Catch:{ IOException -> 0x006b }
        L_0x0065:
            if (r1 == 0) goto L_0x006a;
        L_0x0067:
            r1.destroy();
        L_0x006a:
            return;
        L_0x006b:
            r0 = move-exception;
            r2 = "CpuInfoUtil";
            com.tencent.qqmusic.mediaplayer.util.Logger.e(r2, r0);
            goto L_0x0065;
        L_0x0073:
            r0 = move-exception;
            r1 = r2;
        L_0x0075:
            r3 = "CpuInfoUtil";
            com.tencent.qqmusic.mediaplayer.util.Logger.e(r3, r0);	 Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x0080;
        L_0x007d:
            r2.close();	 Catch:{ IOException -> 0x0086 }
        L_0x0080:
            if (r1 == 0) goto L_0x006a;
        L_0x0082:
            r1.destroy();
            goto L_0x006a;
        L_0x0086:
            r0 = move-exception;
            r2 = "CpuInfoUtil";
            com.tencent.qqmusic.mediaplayer.util.Logger.e(r2, r0);
            goto L_0x0080;
        L_0x008e:
            r0 = move-exception;
            r1 = r2;
            r3 = r2;
        L_0x0091:
            if (r3 == 0) goto L_0x0096;
        L_0x0093:
            r3.close();	 Catch:{ IOException -> 0x009c }
        L_0x0096:
            if (r1 == 0) goto L_0x009b;
        L_0x0098:
            r1.destroy();
        L_0x009b:
            throw r0;
        L_0x009c:
            r2 = move-exception;
            r3 = "CpuInfoUtil";
            com.tencent.qqmusic.mediaplayer.util.Logger.e(r3, r2);
            goto L_0x0096;
        L_0x00a4:
            r0 = move-exception;
            r3 = r2;
            goto L_0x0091;
        L_0x00a7:
            r0 = move-exception;
            goto L_0x0091;
        L_0x00a9:
            r0 = move-exception;
            r3 = r2;
            goto L_0x0091;
        L_0x00ac:
            r0 = move-exception;
            goto L_0x0075;
        L_0x00ae:
            r0 = move-exception;
            r2 = r3;
            goto L_0x0075;
        L_0x00b1:
            r0 = r2;
            goto L_0x0024;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.util.CpuInfoUtil.OutputCpuThread.run():void");
        }
    }

    public static synchronized void startProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
        }
    }

    public static synchronized void stopProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
            mCurrThread = null;
        }
    }

    public static void outputThreadInfoToLog() {
    }

    public static void outputCpuHZToLog() {
    }
}
