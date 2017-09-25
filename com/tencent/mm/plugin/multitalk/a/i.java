package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.m;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public final class i {
    public static final float[][] nPQ;

    public enum a {
        WIFI,
        _4G,
        _3GOr_2G,
        None
    }

    static {
        r0 = new float[6][];
        nPQ = r0;
        r0[0] = null;
        nPQ[1] = new float[]{0.5f, 0.5f};
        nPQ[2] = new float[]{0.0f, 0.5f, 1.0f, 0.5f};
        nPQ[3] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.5f, 1.0f};
        nPQ[4] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        nPQ[5] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 2.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 2.0f, 1.0f, 0.0f, 2.0f, 1.0f, 2.0f, 2.0f, 2.0f};
    }

    public static String h(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<MultiTalkGroupMember> list = multiTalkGroup.wPj;
        stringBuffer.append("->[usernamelist]");
        if (list != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : list) {
                stringBuffer.append(multiTalkGroupMember.wPk + "|");
                stringBuffer.append(multiTalkGroupMember.status + ", ");
            }
        }
        stringBuffer.append(" ->createname:" + multiTalkGroup.wPi);
        stringBuffer.append(" ->talkgroupId:" + multiTalkGroup.wPf);
        stringBuffer.append(" ->wxGroupId:" + multiTalkGroup.wPh);
        return stringBuffer.toString();
    }

    public static boolean a(MultiTalkGroup multiTalkGroup, MultiTalkGroup multiTalkGroup2) {
        if (multiTalkGroup == null || multiTalkGroup2 == null) {
            return false;
        }
        if (!bg.mA(multiTalkGroup.wPf) && !bg.mA(multiTalkGroup2.wPf) && multiTalkGroup.wPf.equals(multiTalkGroup2.wPf)) {
            return true;
        }
        if (bg.mA(multiTalkGroup.wPg) || bg.mA(multiTalkGroup2.wPg) || !multiTalkGroup.wPg.equals(multiTalkGroup2.wPg)) {
            return false;
        }
        return true;
    }

    public static boolean i(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.wPj) {
            boolean z3;
            if (multiTalkGroupMember.wPk.equals(m.xL())) {
                if (multiTalkGroupMember.status == 10) {
                    if (z) {
                        return true;
                    }
                    z2 = true;
                }
                z3 = z;
            } else {
                if (multiTalkGroupMember.status == 10) {
                    if (z2) {
                        return true;
                    }
                    z3 = true;
                }
                z3 = z;
            }
            z = z3;
        }
        return false;
    }

    public static boolean j(MultiTalkGroup multiTalkGroup) {
        int i = 0;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.wPj) {
            int i2;
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 1) {
            return true;
        }
        return false;
    }

    public static boolean c(e eVar) {
        if (eVar == e.Starting || eVar == e.Talking || eVar == e.Inviting) {
            return true;
        }
        return false;
    }

    public static boolean k(MultiTalkGroup multiTalkGroup) {
        return multiTalkGroup.wPi.equals(m.xL());
    }

    public static String l(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        String str = multiTalkGroup.wPf;
        if (bg.mA(str)) {
            str = multiTalkGroup.wPg;
        }
        return bg.ap(str, "");
    }

    public static String aNd() {
        return l(o.aNn().nPl);
    }

    public static String m(MultiTalkGroup multiTalkGroup) {
        String str = null;
        int i = 0;
        while (i < multiTalkGroup.wPj.size()) {
            String str2;
            if (((MultiTalkGroupMember) multiTalkGroup.wPj.get(i)).wPk.equals(m.xL())) {
                str2 = ((MultiTalkGroupMember) multiTalkGroup.wPj.get(i)).wPl;
            } else {
                str2 = str;
            }
            i++;
            str = str2;
        }
        return str;
    }

    public static String aNe() {
        return m(o.aNn().nPl);
    }

    public static boolean aNf() {
        return am.is3G(ab.getContext()) || am.is2G(ab.getContext());
    }

    public static int n(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("state");
            if (stringExtra != null) {
                if (stringExtra.equals("IDLE")) {
                    return 0;
                }
                if (stringExtra.equals("RINGING")) {
                    return 1;
                }
                if (stringExtra.equals("OFFHOOK")) {
                    return 2;
                }
            }
        }
        return ((TelephonyManager) context.getSystemService("phone")).getCallState();
    }

    public static boolean pT(int i) {
        return i == 2 || i == 3;
    }

    public static boolean pU(int i) {
        return i == 1 || i == 3;
    }

    public static a aNg() {
        if (am.isWifi(ab.getContext())) {
            return a.WIFI;
        }
        if (am.is4G(ab.getContext())) {
            return a._4G;
        }
        if (am.is3G(ab.getContext()) || am.is2G(ab.getContext())) {
            return a._3GOr_2G;
        }
        return a.None;
    }
}
