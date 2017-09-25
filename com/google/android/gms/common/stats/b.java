package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.c.aa;
import com.google.android.gms.c.u;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.stats.c.a;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b {
    private static final Object aqT = new Object();
    private static b asg;
    private static final ComponentName asl = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    private static Integer asn;
    private final List<String> ash;
    private final List<String> asi;
    private final List<String> asj;
    private final List<String> ask;
    private e asm;

    private b() {
        if (getLogLevel() == d.LOG_LEVEL_OFF) {
            this.ash = Collections.EMPTY_LIST;
            this.asi = Collections.EMPTY_LIST;
            this.asj = Collections.EMPTY_LIST;
            this.ask = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) a.asq.get();
        this.ash = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.asr.get();
        this.asi = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.ass.get();
        this.asj = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.ast.get();
        this.ask = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.asm = new e(((Long) a.asu.get()).longValue());
    }

    private static ServiceInfo b(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, FileUtils.S_IWUSR);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.cd(20)});
            return null;
        }
        if (queryIntentServices.size() > 1) {
            String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.cd(20)});
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                String str = ((ResolveInfo) it.next()).serviceInfo.name;
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private static int getLogLevel() {
        if (asn == null) {
            try {
                asn = Integer.valueOf(u.kU() ? ((Integer) a.asp.get()).intValue() : d.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                asn = Integer.valueOf(d.LOG_LEVEL_OFF);
            }
        }
        return asn.intValue();
    }

    public static b kw() {
        synchronized (aqT) {
            if (asg == null) {
                asg = new b();
            }
        }
        return asg;
    }

    public final void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        a(context, serviceConnection, null, null, 1);
    }

    public final void a(Context context, ServiceConnection serviceConnection, String str, Intent intent, int i) {
        if (f.apP) {
            Object obj;
            String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
            int logLevel = getLogLevel();
            if (logLevel == d.LOG_LEVEL_OFF || this.asm == null) {
                obj = null;
            } else if (i == 4 || i == 1) {
                obj = this.asm.Z(valueOf) ? 1 : null;
            } else {
                ServiceInfo b = b(context, intent);
                if (b == null) {
                    String.format("Client %s made an invalid request %s", new Object[]{str, intent.toUri(0)});
                    obj = null;
                } else {
                    String K = aa.K(context);
                    String str2 = b.processName;
                    String str3 = b.name;
                    if (this.ash.contains(K) || this.asi.contains(str) || this.asj.contains(str2) || this.ask.contains(str3) || (str2.equals(K) && (logLevel & d.asz) != 0)) {
                        obj = null;
                    } else {
                        this.asm.Y(valueOf);
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                Parcelable connectionEvent;
                long currentTimeMillis = System.currentTimeMillis();
                String str4 = null;
                if ((getLogLevel() & d.asy) != 0) {
                    str4 = aa.cd(5);
                }
                long j = 0;
                if ((getLogLevel() & d.asA) != 0) {
                    j = Debug.getNativeHeapAllocatedSize();
                }
                if (i == 1 || i == 4) {
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str4, valueOf, SystemClock.elapsedRealtime(), j);
                } else {
                    ServiceInfo b2 = b(context, intent);
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, aa.K(context), str, b2.processName, b2.name, str4, valueOf, SystemClock.elapsedRealtime(), j);
                }
                context.startService(new Intent().setComponent(asl).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
            }
        }
    }

    public final boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        boolean h = (component == null || (f.apP && "com.google.android.gms".equals(component.getPackageName()))) ? false : u.h(context, component.getPackageName());
        if (h) {
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            a(context, serviceConnection, str, intent, 2);
        }
        return bindService;
    }
}
