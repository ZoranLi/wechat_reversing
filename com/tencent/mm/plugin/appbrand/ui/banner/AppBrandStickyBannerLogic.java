package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum AppBrandStickyBannerLogic {
    ;

    public static final class a {
        private static final Watcher jls = null;
        private static final Set<c> jlt = null;
        public static volatile boolean jlu;
        public static String jlv;
        private static c jlw;
        private static final Map<String, String> jlx = null;

        static {
            jls = new Watcher();
            jlt = new HashSet();
            jlw = new c() {
                public final void S(String str, int i) {
                    boolean z;
                    AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(a.jlv);
                    int i2;
                    if (mY != null) {
                        i2 = mY.iFk.izV;
                    } else {
                        i2 = 0;
                    }
                    if (a.jlv != null && a.jlv.equals(str) && r0 == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a.jlu = z;
                    w.i("MicroMsg.AppBrandStickyBannerLogic", "onStickyBannerChanged(appId : %s, openType : %s), isStick(appId : %s) = %s", new Object[]{str, Integer.valueOf(i), a.jlv, Boolean.valueOf(a.jlu)});
                }
            };
            jlx = new HashMap();
        }

        static void ao(String str, int i) {
            synchronized (jlt) {
                for (c S : jlt) {
                    S.S(str, i);
                }
            }
        }

        public static void a(Context context, String str, int i, String str2, String str3) {
            if (!bg.mA(str)) {
                Context context2;
                String str4;
                if (context == null) {
                    context2 = ab.getContext();
                } else {
                    context2 = context;
                }
                Intent addFlags = new Intent().setClassName(context2, "com.tencent.mm.ui.LauncherUI").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                synchronized (jlx) {
                    str4 = (String) jlx.get(str);
                }
                a.a(addFlags, str, i, str2, str3, bg.mz(str4));
                context2.startActivity(addFlags);
                if (context2 instanceof Activity) {
                    try {
                        ((Activity) context2).moveTaskToBack(false);
                    } catch (Exception e) {
                        w.e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", new Object[]{e.getMessage()});
                    }
                }
            }
        }

        public static boolean ap(String str, int i) {
            if (bg.mA(str) || i < 0) {
                return false;
            }
            MainProcessTask ar = OperateTask.ar(str, i);
            boolean b = AppBrandMainProcessService.b(ar);
            if (!b) {
                w.w("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "execSync process task failed(%s, %s) use local state(%s).", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(jlu)});
                return jlu;
            } else if (b && ar.jly) {
                return true;
            } else {
                return false;
            }
        }

        public static void a(c cVar) {
            if (cVar != null) {
                synchronized (jlt) {
                    jlt.remove(cVar);
                }
            }
        }

        public static void b(c cVar) {
            jls.jlB = ab.um();
            AppBrandMainProcessService.a(jls);
            if (cVar != null) {
                synchronized (jlt) {
                    jlt.add(cVar);
                }
            }
        }

        public static void ch(boolean z) {
            jlu = z;
        }

        public static void qR(String str) {
            jlv = "";
            a(jlw);
            w.i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", new Object[]{str});
        }

        public static void qS(String str) {
            if (!bg.mA(str)) {
                int i = com.tencent.mm.plugin.appbrand.b.mY(str).iFk.izV;
                if (i >= 0) {
                    h.pd(str);
                    AppBrandMainProcessService.a(OperateTask.as(str, i));
                }
            }
        }

        public static void bj(String str, String str2) {
            if (!bg.mA(str)) {
                synchronized (jlx) {
                    jlx.put(str, bg.mz(str2));
                }
                AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(str);
                if (mY != null) {
                    AppBrandMainProcessService.a(OperateTask.i(str, mY.iFk.izV, str2));
                }
            }
        }
    }

    public static final class b {
        static final Set<c> gNx = null;

        static {
            gNx = new HashSet();
        }

        public static void t(final Intent intent) {
            if (intent != null && com.tencent.mm.kernel.h.vG().uV()) {
                com.tencent.mm.kernel.h.vL().D(new Runnable() {
                    public final void run() {
                        if (a.s(intent)) {
                            b.Xm();
                        }
                    }
                });
            }
        }

        static void b(OperateTask operateTask) {
            if (a.a(operateTask)) {
                Xm();
            }
        }

        static void Xl() {
            BannerModel Xn = BannerModel.Xn();
            if (Xn != null) {
                String str = Xn.appId;
                int i = Xn.iPk;
                if (!com.tencent.mm.plugin.appbrand.task.b.qM(str)) {
                    a.Xg();
                    Xm();
                }
            }
        }

        public static void Xm() {
            BannerModel Xn = BannerModel.Xn();
            String str = Xn == null ? null : Xn.appId;
            int i = Xn == null ? -1 : Xn.iPk;
            synchronized (gNx) {
                for (c S : gNx) {
                    S.S(str, i);
                }
            }
        }

        public static void b(c cVar) {
            if (cVar != null) {
                synchronized (gNx) {
                    gNx.add(cVar);
                }
            }
        }

        public static void a(c cVar) {
            if (cVar != null) {
                synchronized (gNx) {
                    gNx.remove(cVar);
                }
            }
        }

        public static boolean ap(String str, int i) {
            BannerModel Xo = BannerModel.Xo();
            return Xo != null && !bg.mA(str) && str.equals(Xo.appId) && i == Xo.iPk;
        }

        public static void aq(String str, int i) {
            if (ap(str, i)) {
                a.Xg();
                Xm();
            }
        }
    }

    static final class OperateTask extends MainProcessTask {
        public static final Creator<OperateTask> CREATOR = null;
        String iOs;
        String jlA;
        boolean jly;
        int jlz;
        int op;

        OperateTask() {
            this.op = 0;
        }

        public final void PM() {
            switch (this.op) {
                case 1:
                    this.jly = b.ap(this.iOs, this.jlz);
                    SL();
                    return;
                case 2:
                    b.b(this);
                    return;
                case 3:
                    b.aq(this.iOs, this.jlz);
                    return;
                default:
                    return;
            }
        }

        static OperateTask ar(String str, int i) {
            OperateTask operateTask = new OperateTask();
            operateTask.op = 1;
            operateTask.iOs = str;
            operateTask.jlz = i;
            return operateTask;
        }

        static OperateTask i(String str, int i, String str2) {
            OperateTask operateTask = new OperateTask();
            operateTask.op = 2;
            operateTask.iOs = str;
            operateTask.jlz = i;
            operateTask.jlA = str2;
            return operateTask;
        }

        static OperateTask as(String str, int i) {
            OperateTask operateTask = new OperateTask();
            operateTask.op = 3;
            operateTask.iOs = str;
            operateTask.jlz = i;
            return operateTask;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.op);
            parcel.writeByte(this.jly ? (byte) 1 : (byte) 0);
            parcel.writeString(this.iOs);
            parcel.writeInt(this.jlz);
            parcel.writeString(this.jlA);
        }

        public final void f(Parcel parcel) {
            this.op = parcel.readInt();
            this.jly = parcel.readByte() != (byte) 0;
            this.iOs = parcel.readString();
            this.jlz = parcel.readInt();
            this.jlA = parcel.readString();
        }

        static {
            CREATOR = new Creator<OperateTask>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    OperateTask operateTask = new OperateTask();
                    operateTask.f(parcel);
                    return operateTask;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new OperateTask[i];
                }
            };
        }
    }

    private static final class Watcher extends MainProcessTask {
        public static final Creator<Watcher> CREATOR = null;
        private static final transient Map<String, Boolean> jlE = null;
        String jlB;
        String jlC;
        int jlD;

        static {
            jlE = new HashMap();
            CREATOR = new Creator<Watcher>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    Watcher watcher = new Watcher();
                    watcher.f(parcel);
                    return watcher;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new Watcher[i];
                }
            };
        }

        public final int describeContents() {
            return 0;
        }

        public final void PM() {
            if (!bg.mA(this.jlB)) {
                synchronized (jlE) {
                    if (jlE.containsKey(this.jlB) && ((Boolean) jlE.get(this.jlB)).booleanValue()) {
                        return;
                    }
                    d.aN(this);
                    b.b(new c(this) {
                        final /* synthetic */ Watcher jlF;

                        {
                            this.jlF = r1;
                        }

                        public final void S(String str, int i) {
                            this.jlF.jlC = str;
                            this.jlF.jlD = i;
                            this.jlF.SL();
                        }
                    });
                    jlE.put(this.jlB, Boolean.valueOf(true));
                }
            }
        }

        public final void SK() {
            a.ao(this.jlC, this.jlD);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jlB);
            parcel.writeString(this.jlC);
            parcel.writeInt(this.jlD);
        }

        public final void f(Parcel parcel) {
            this.jlB = parcel.readString();
            this.jlC = parcel.readString();
            this.jlD = parcel.readInt();
        }

        Watcher() {
        }
    }
}
