package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;

public final class d {
    private static final Object mLock = new Object();
    private static d tC;
    private final Handler mHandler;
    private final HashMap<String, ArrayList<b>> tA = new HashMap();
    final ArrayList<a> tB = new ArrayList();
    final Context ty;
    final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> tz = new HashMap();

    private static class a {
        final Intent intent;
        final ArrayList<b> tE;

        a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.tE = arrayList;
        }
    }

    private static class b {
        final IntentFilter filter;
        final BroadcastReceiver tF;
        boolean tG;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.tF = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.tF);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static d k(Context context) {
        d dVar;
        synchronized (mLock) {
            if (tC == null) {
                tC = new d(context.getApplicationContext());
            }
            dVar = tC;
        }
        return dVar;
    }

    private d(Context context) {
        this.ty = context;
        this.mHandler = new Handler(this, context.getMainLooper()) {
            final /* synthetic */ d tD;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r10) {
                /*
                r9 = this;
                r2 = 0;
                r0 = r10.what;
                switch(r0) {
                    case 1: goto L_0x000a;
                    default: goto L_0x0006;
                };
            L_0x0006:
                super.handleMessage(r10);
            L_0x0009:
                return;
            L_0x000a:
                r4 = r9.tD;
            L_0x000c:
                r1 = r4.tz;
                monitor-enter(r1);
                r0 = r4.tB;	 Catch:{ all -> 0x0019 }
                r0 = r0.size();	 Catch:{ all -> 0x0019 }
                if (r0 > 0) goto L_0x001c;
            L_0x0017:
                monitor-exit(r1);	 Catch:{ all -> 0x0019 }
                goto L_0x0009;
            L_0x0019:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0019 }
                throw r0;
            L_0x001c:
                r5 = new android.support.v4.content.d.a[r0];	 Catch:{ all -> 0x0019 }
                r0 = r4.tB;	 Catch:{ all -> 0x0019 }
                r0.toArray(r5);	 Catch:{ all -> 0x0019 }
                r0 = r4.tB;	 Catch:{ all -> 0x0019 }
                r0.clear();	 Catch:{ all -> 0x0019 }
                monitor-exit(r1);	 Catch:{ all -> 0x0019 }
                r3 = r2;
            L_0x002a:
                r0 = r5.length;
                if (r3 >= r0) goto L_0x000c;
            L_0x002d:
                r6 = r5[r3];
                r1 = r2;
            L_0x0030:
                r0 = r6.tE;
                r0 = r0.size();
                if (r1 >= r0) goto L_0x004d;
            L_0x0038:
                r0 = r6.tE;
                r0 = r0.get(r1);
                r0 = (android.support.v4.content.d.b) r0;
                r0 = r0.tF;
                r7 = r4.ty;
                r8 = r6.intent;
                r0.onReceive(r7, r8);
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x0030;
            L_0x004d:
                r0 = r3 + 1;
                r3 = r0;
                goto L_0x002a;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.1.handleMessage(android.os.Message):void");
            }
        };
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.tz) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.tz.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.tz.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                arrayList = (ArrayList) this.tA.get(action);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.tA.put(action, arrayList);
                }
                arrayList.add(bVar);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.tz) {
            ArrayList arrayList = (ArrayList) this.tz.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.tA.get(action);
                    if (arrayList2 != null) {
                        int i3 = 0;
                        while (i3 < arrayList2.size()) {
                            int i4;
                            if (((b) arrayList2.get(i3)).tF == broadcastReceiver) {
                                arrayList2.remove(i3);
                                i4 = i3 - 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4 + 1;
                        }
                        if (arrayList2.size() <= 0) {
                            this.tA.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.content.Intent r16) {
        /*
        r15 = this;
        r13 = r15.tz;
        monitor-enter(r13);
        r2 = r16.getAction();	 Catch:{ all -> 0x00c4 }
        r1 = r15.ty;	 Catch:{ all -> 0x00c4 }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x00c4 }
        r5 = r16.getData();	 Catch:{ all -> 0x00c4 }
        r4 = r16.getScheme();	 Catch:{ all -> 0x00c4 }
        r6 = r16.getCategories();	 Catch:{ all -> 0x00c4 }
        r1 = r16.getFlags();	 Catch:{ all -> 0x00c4 }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x0097;
    L_0x0027:
        r1 = 1;
        r12 = r1;
    L_0x0029:
        if (r12 == 0) goto L_0x004e;
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Resolving type ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x00c4 }
        r7 = " scheme ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00c4 }
        r1 = r1.append(r4);	 Catch:{ all -> 0x00c4 }
        r7 = " of intent ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r1.append(r0);	 Catch:{ all -> 0x00c4 }
    L_0x004e:
        r1 = r15.tA;	 Catch:{ all -> 0x00c4 }
        r7 = r16.getAction();	 Catch:{ all -> 0x00c4 }
        r1 = r1.get(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r1;
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x00c4 }
        r8 = r0;
        if (r8 == 0) goto L_0x011a;
    L_0x005e:
        if (r12 == 0) goto L_0x006b;
    L_0x0060:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Action list: ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r1.append(r8);	 Catch:{ all -> 0x00c4 }
    L_0x006b:
        r10 = 0;
        r1 = 0;
        r11 = r1;
    L_0x006e:
        r1 = r8.size();	 Catch:{ all -> 0x00c4 }
        if (r11 >= r1) goto L_0x00e5;
    L_0x0074:
        r1 = r8.get(r11);	 Catch:{ all -> 0x00c4 }
        r0 = r1;
        r0 = (android.support.v4.content.d.b) r0;	 Catch:{ all -> 0x00c4 }
        r9 = r0;
        if (r12 == 0) goto L_0x008b;
    L_0x007e:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Matching against filter ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r7 = r9.filter;	 Catch:{ all -> 0x00c4 }
        r1.append(r7);	 Catch:{ all -> 0x00c4 }
    L_0x008b:
        r1 = r9.tG;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x009a;
    L_0x008f:
        if (r12 == 0) goto L_0x011d;
    L_0x0091:
        r1 = r10;
    L_0x0092:
        r7 = r11 + 1;
        r11 = r7;
        r10 = r1;
        goto L_0x006e;
    L_0x0097:
        r1 = 0;
        r12 = r1;
        goto L_0x0029;
    L_0x009a:
        r1 = r9.filter;	 Catch:{ all -> 0x00c4 }
        r7 = "LocalBroadcastManager";
        r1 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00c4 }
        if (r1 < 0) goto L_0x00c7;
    L_0x00a5:
        if (r12 == 0) goto L_0x00b6;
    L_0x00a7:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r14 = "  Filter matched!  match=0x";
        r7.<init>(r14);	 Catch:{ all -> 0x00c4 }
        r1 = java.lang.Integer.toHexString(r1);	 Catch:{ all -> 0x00c4 }
        r7.append(r1);	 Catch:{ all -> 0x00c4 }
    L_0x00b6:
        if (r10 != 0) goto L_0x0120;
    L_0x00b8:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00c4 }
        r1.<init>();	 Catch:{ all -> 0x00c4 }
    L_0x00bd:
        r1.add(r9);	 Catch:{ all -> 0x00c4 }
        r7 = 1;
        r9.tG = r7;	 Catch:{ all -> 0x00c4 }
        goto L_0x0092;
    L_0x00c4:
        r1 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
        throw r1;
    L_0x00c7:
        if (r12 == 0) goto L_0x011d;
    L_0x00c9:
        switch(r1) {
            case -4: goto L_0x00d6;
            case -3: goto L_0x00d1;
            case -2: goto L_0x00db;
            case -1: goto L_0x00e0;
            default: goto L_0x00cc;
        };
    L_0x00cc:
        r1 = "unknown reason";
        r1 = r10;
        goto L_0x0092;
    L_0x00d1:
        r1 = "action";
        r1 = r10;
        goto L_0x0092;
    L_0x00d6:
        r1 = "category";
        r1 = r10;
        goto L_0x0092;
    L_0x00db:
        r1 = "data";
        r1 = r10;
        goto L_0x0092;
    L_0x00e0:
        r1 = "type";
        r1 = r10;
        goto L_0x0092;
    L_0x00e5:
        if (r10 == 0) goto L_0x011a;
    L_0x00e7:
        r1 = 0;
        r2 = r1;
    L_0x00e9:
        r1 = r10.size();	 Catch:{ all -> 0x00c4 }
        if (r2 >= r1) goto L_0x00fc;
    L_0x00ef:
        r1 = r10.get(r2);	 Catch:{ all -> 0x00c4 }
        r1 = (android.support.v4.content.d.b) r1;	 Catch:{ all -> 0x00c4 }
        r3 = 0;
        r1.tG = r3;	 Catch:{ all -> 0x00c4 }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x00e9;
    L_0x00fc:
        r1 = r15.tB;	 Catch:{ all -> 0x00c4 }
        r2 = new android.support.v4.content.d$a;	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r2.<init>(r0, r10);	 Catch:{ all -> 0x00c4 }
        r1.add(r2);	 Catch:{ all -> 0x00c4 }
        r1 = r15.mHandler;	 Catch:{ all -> 0x00c4 }
        r2 = 1;
        r1 = r1.hasMessages(r2);	 Catch:{ all -> 0x00c4 }
        if (r1 != 0) goto L_0x0117;
    L_0x0111:
        r1 = r15.mHandler;	 Catch:{ all -> 0x00c4 }
        r2 = 1;
        r1.sendEmptyMessage(r2);	 Catch:{ all -> 0x00c4 }
    L_0x0117:
        r1 = 1;
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
    L_0x0119:
        return r1;
    L_0x011a:
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
        r1 = 0;
        goto L_0x0119;
    L_0x011d:
        r1 = r10;
        goto L_0x0092;
    L_0x0120:
        r1 = r10;
        goto L_0x00bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.b(android.content.Intent):boolean");
    }
}
