package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;

public final class z {
    private static boolean hasInit = false;
    private static boolean ifB = false;
    private static z ifs;
    private s gJy;
    private ae handler;
    private v ifA;
    private aa ift;
    private ab ifu;
    private Context ifv;
    private a ifw;
    private y ifx;
    private x ify;
    private Looper ifz;

    public interface a {
        void av(boolean z);
    }

    private z() {
    }

    private static z MF() {
        if (ifs == null) {
            ifs = new z();
        }
        return ifs;
    }

    private static SharedPreferences MG() {
        return ab.getContext().getSharedPreferences("notify_key_pref_no_account", 4);
    }

    public static SharedPreferences MH() {
        String string = MG().getString("login_weixin_username", "");
        if (bg.mA(string)) {
            string = ao.hlW.A("login_weixin_username", "");
            if (!bg.mA(string)) {
                MG().edit().putString("login_weixin_username", string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        return ab.getContext().getSharedPreferences("notify_key_pref" + string, 4);
    }

    public static void MI() {
        if (!hasInit) {
            SharedPreferences MH = MH();
            long j = MH.getLong("wakeup_alarm_last_tick", 0);
            int i = MH.getInt("wakeup_alarm_last_cnt", 0);
            if (j == 0 || j > bg.Nz()) {
                w.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i));
                MH.edit().putLong("wakeup_alarm_last_tick", bg.Nz()).commit();
                MH.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                return;
            } else if (bg.aA(j) > 86400000) {
                MH.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
                MH.edit().putLong("wakeup_alarm_last_tick", bg.Nz()).commit();
                MH.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                w.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i));
            } else {
                MH.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
                w.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i + 1));
            }
        }
        hasInit = true;
    }

    public static boolean MJ() {
        String A = ao.hlW.A("login_user_name", "");
        if (A != null) {
            A = A.replace("[\\/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("notify_key_pref" + A, 4);
        w.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0)), Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_last_cnt", 0)));
        return (r0 > 10 ? 1 : 0) | (sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0) > 10 ? 1 : 0);
    }

    public static aa MK() {
        return MF().ift;
    }

    public static void a(aa aaVar) {
        MF().ift = aaVar;
    }

    public static ab ML() {
        return MF().ifu;
    }

    public static void a(ab abVar) {
        MF().ifu = abVar;
    }

    public static Context getContext() {
        return MF().ifv;
    }

    public static void setContext(Context context) {
        MF().ifv = context;
    }

    public static ae MM() {
        return MF().handler;
    }

    public static void a(ae aeVar) {
        MF().handler = aeVar;
    }

    public static a MN() {
        return MF().ifw;
    }

    public static void a(a aVar) {
        MF().ifw = aVar;
    }

    public static s MO() {
        return MF().gJy;
    }

    public static void b(s sVar) {
        MF().gJy = sVar;
    }

    public static y MP() {
        return MF().ifx;
    }

    public static void a(y yVar) {
        MF().ifx = yVar;
    }

    public static x MQ() {
        return MF().ify;
    }

    public static void a(x xVar) {
        MF().ify = xVar;
    }

    public static Looper MR() {
        if (MF().ifz == null) {
            HandlerThread Qu = e.Qu("MMPushCore_handlerThread");
            Qu.start();
            MF().ifz = Qu.getLooper();
        }
        return MF().ifz;
    }

    public static v MS() {
        return MF().ifA;
    }

    public static void a(v vVar) {
        MF().ifA = vVar;
    }

    public static void bA(boolean z) {
        MF();
        ifB = z;
    }

    public static boolean MT() {
        MF();
        return ifB;
    }
}
