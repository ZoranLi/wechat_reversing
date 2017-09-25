package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.text.format.Time;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.i.a;
import com.tencent.mm.i.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> gLV;
    public boolean gLW;

    static {
        Set hashSet = new HashSet();
        gLV = hashSet;
        hashSet.add("readerapp");
        gLV.add("blogapp");
        gLV.add("newsapp");
    }

    public static boolean dg(String str) {
        if (ad.Pv("keep_chatting_silent" + str)) {
            w.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            return true;
        }
        w.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        return false;
    }

    public static boolean a(boolean[] zArr, boolean z, boolean z2) {
        boolean z3;
        if (z || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z2;
        return z3;
    }

    public static boolean a(boolean[] zArr, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z;
        return z2;
    }

    public static boolean dh(String str) {
        boolean z = true;
        boolean contains = gLV.contains(str);
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Siler User: %B";
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.i(str2, str3, objArr);
        return contains;
    }

    public static boolean qv() {
        Time time = new Time();
        time.setToNow();
        if (a.az(time.hour, time.minute)) {
            return false;
        }
        w.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
        return true;
    }

    public static boolean qw() {
        w.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", Boolean.valueOf(a.so()));
        return a.so();
    }

    public static boolean dV(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", Boolean.valueOf(z));
        return z;
    }

    public static boolean a(String str, au auVar) {
        boolean z;
        boolean z2 = true;
        if (!f.dI(str) || f.e(auVar)) {
            z = false;
        } else {
            z = true;
        }
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Must Mute: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        w.i(str2, str3, objArr);
        return z;
    }

    public static boolean qx() {
        boolean z;
        boolean z2 = true;
        try {
            b rrVar = new rr();
            rrVar.fYI.fJK = 2;
            com.tencent.mm.sdk.b.a.urY.m(rrVar);
            z = rrVar.fYJ.fYK;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Notification.Silent.Handle", e, "", new Object[0]);
            z = false;
        }
        String str = "MicroMsg.Notification.Silent.Handle";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        w.d(str, str2, objArr);
        return z;
    }

    public static boolean k(int i, String str) {
        boolean sT;
        if (f.eu(i)) {
            if (f.dD(str)) {
                sT = f.sT();
            } else if (f.dE(str)) {
                sT = f.sU();
            }
            w.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(sT));
            return sT;
        }
        sT = true;
        w.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(sT));
        return sT;
    }

    public static boolean qy() {
        boolean sq = a.sq();
        if (qz() == 0) {
            sq = false;
        }
        w.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", Boolean.valueOf(sq), Integer.valueOf(qz()));
        return sq;
    }

    public static int qz() {
        return ((AudioManager) ab.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getRingerMode();
    }

    public static boolean dW(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", Boolean.valueOf(z));
        return z;
    }
}
