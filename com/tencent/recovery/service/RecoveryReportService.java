package com.tencent.recovery.service;

import android.app.IntentService;
import android.content.Intent;
import com.tencent.recovery.log.RecoveryLog;

public class RecoveryReportService extends IntentService {
    public RecoveryReportService() {
        super(RecoveryReportService.class.getName());
    }

    protected void onHandleIntent(Intent intent) {
        al(intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void al(android.content.Intent r9) {
        /*
        r8 = this;
        r2 = 1;
        r0 = 0;
        monitor-enter(r8);
        r1 = 0;
        r3 = "KeyReportType";
        r1 = r9.getStringExtra(r3);	 Catch:{ Exception -> 0x0014 }
        r3 = r1;
    L_0x000c:
        r1 = com.tencent.recovery.util.Util.mA(r3);	 Catch:{ all -> 0x0043 }
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r8);
        return;
    L_0x0014:
        r3 = move-exception;
        r3 = r1;
        goto L_0x000c;
    L_0x0017:
        r1 = "KeyReportUploadClassName";
        r4 = r9.getStringExtra(r1);	 Catch:{ all -> 0x0043 }
        r1 = "Recovery.RecoveryReportService";
        r5 = "handle report intent %s %s";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0043 }
        r7 = 0;
        r6[r7] = r3;	 Catch:{ all -> 0x0043 }
        r7 = 1;
        r6[r7] = r4;	 Catch:{ all -> 0x0043 }
        com.tencent.recovery.log.RecoveryLog.i(r1, r5, r6);	 Catch:{ all -> 0x0043 }
        r1 = -1;
        r5 = r3.hashCode();	 Catch:{ all -> 0x0043 }
        switch(r5) {
            case -1125171110: goto L_0x0046;
            case 2120497953: goto L_0x0050;
            default: goto L_0x0038;
        };	 Catch:{ all -> 0x0043 }
    L_0x0038:
        r0 = r1;
    L_0x0039:
        switch(r0) {
            case 0: goto L_0x005b;
            case 1: goto L_0x0066;
            default: goto L_0x003c;
        };	 Catch:{ all -> 0x0043 }
    L_0x003c:
        com.tencent.recovery.service.RecoveryUploadService.startAlarm(r8, r4);	 Catch:{ all -> 0x0043 }
        r8.stopSelf();	 Catch:{ all -> 0x0043 }
        goto L_0x0012;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0046:
        r2 = "HandleStatus";
        r2 = r3.equals(r2);	 Catch:{ all -> 0x0043 }
        if (r2 == 0) goto L_0x0038;
    L_0x004f:
        goto L_0x0039;
    L_0x0050:
        r0 = "ProcessStatus";
        r0 = r3.equals(r0);	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0038;
    L_0x0059:
        r0 = r2;
        goto L_0x0039;
    L_0x005b:
        r0 = "KeyReportItem";
        r0 = r9.getParcelableArrayListExtra(r0);	 Catch:{ all -> 0x0043 }
        com.tencent.recovery.report.RecoveryReporter.c(r8, r3, r0);	 Catch:{ all -> 0x0043 }
        goto L_0x003c;
    L_0x0066:
        r0 = "KeyReportItem";
        r0 = r9.getParcelableExtra(r0);	 Catch:{ all -> 0x0043 }
        r0 = (com.tencent.recovery.model.RecoveryStatusItem) r0;	 Catch:{ all -> 0x0043 }
        com.tencent.recovery.report.RecoveryReporter.a(r8, r3, r0);	 Catch:{ all -> 0x0043 }
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.service.RecoveryReportService.al(android.content.Intent):void");
    }

    public void onDestroy() {
        RecoveryLog.cdx();
        super.onDestroy();
    }
}
