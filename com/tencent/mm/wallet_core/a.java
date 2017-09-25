package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Class<?>> wDM = new HashMap();
    private static SparseArray<b> wDN = new SparseArray();

    public static void g(String str, Class<?> cls) {
        if (wDM.containsKey(str)) {
            throw new IllegalArgumentException("register process fail, exist process=" + str);
        }
        wDM.put(str, cls);
    }

    private static String ag(Bundle bundle) {
        return bundle == null ? "" : bundle.toString();
    }

    public static void remove(int i) {
        wDN.remove(i);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle) {
        a(activity, (Class) cls, bundle, null);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle, com.tencent.mm.wallet_core.b.a aVar) {
        w.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[]{activity, cls.getSimpleName(), ag(bundle)});
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
                return;
            }
        }
        if (bundle.getLong("key_SessionId", 0) == 0) {
            bundle.putLong("key_SessionId", System.currentTimeMillis());
        }
        b bVar = (b) cls.newInstance();
        bVar.ah(bundle);
        bVar.a(aVar);
        bVar.c(activity, bundle);
        wDN.put(cls.hashCode(), bVar);
    }

    public static void b(Activity activity, String str, Bundle bundle) {
        a(activity, str, bundle, null);
    }

    public static void a(Activity activity, String str, Bundle bundle, com.tencent.mm.wallet_core.b.a aVar) {
        try {
            w.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[]{activity, str, ag(bundle)});
            Class cls = (Class) wDM.get(str);
            if (cls == null) {
                CharSequence format = String.format("start process=%s fail, process not register or plugin no import", new Object[]{str});
                w.e("MicroMsg.ProcessManager", format);
                s.makeText(activity, format, 1).show();
                return;
            }
            a(activity, cls, bundle, aVar);
        } catch (Throwable e) {
            w.e("MicroMsg.ProcessManager", "plugin load failed : " + e.toString());
            w.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
        }
    }

    public static void k(Activity activity, Bundle bundle) {
        b ai = ai(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "forwardProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = ag(bundle);
        objArr[2] = ai == null ? "" : ai.avB();
        w.i(str, str2, objArr);
        if (ai != null) {
            ai.a(activity, 0, bundle);
        }
    }

    public static void af(Activity activity) {
        b ai = ai(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s procname %s";
        Object[] objArr = new Object[2];
        objArr[0] = activity;
        objArr[1] = ai == null ? "" : ai.avB();
        w.i(str, str2, objArr);
        if (ai != null) {
            ai.c(activity, 0);
        }
    }

    public static void j(Activity activity, int i) {
        if (activity == null) {
            w.w("MicroMsg.ProcessManager", "hy: back context is null");
        }
        b ai = ai(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s errCode %s procname %s ";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = ai == null ? "" : ai.avB();
        w.i(str, str2, objArr);
        if (ai != null) {
            ai.c(activity, i);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static void c(Activity activity, Bundle bundle, int i) {
        w.i("MicroMsg.ProcessManager", "endProcess with errCode : " + i);
        if (activity == null) {
            w.w("MicroMsg.ProcessManager", "hy: end context is null");
        }
        b ai = ai(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "endProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = ag(bundle);
        objArr[2] = ai == null ? "" : ai.avB();
        w.i(str, str2, objArr);
        if (ai != null) {
            ai.d(activity, bundle);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static boolean ag(Activity activity) {
        return ai(activity) != null;
    }

    public static Bundle ah(Activity activity) {
        b ai = ai(activity);
        if (ai != null) {
            return ai.lHw;
        }
        return new Bundle();
    }

    public static boolean l(Activity activity, Bundle bundle) {
        b ai = ai(activity);
        if (ai == null) {
            return false;
        }
        ai.ah(bundle);
        return true;
    }

    public static b ai(Activity activity) {
        if (activity == null) {
            w.w("MicroMsg.ProcessManager", "hy: ac is null");
            return null;
        } else if (activity.getIntent() != null) {
            return (b) wDN.get(activity.getIntent().getIntExtra("process_id", 0));
        } else {
            w.w("MicroMsg.ProcessManager", "hy: get intent is null");
            return null;
        }
    }
}
