package com.tencent.mm.u;

import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class n {
    private static Set<String> hlq = new HashSet();

    public static String eI(String str) {
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc == null || bg.mA(Rc.field_nickname)) {
            return str;
        }
        return Rc.field_nickname;
    }

    public static String E(String str, String str2) {
        if (bg.mA(str2)) {
            return eK(str);
        }
        String eL = eL(str);
        if (!bg.mA(eL)) {
            return eL;
        }
        eL = j.D(str, str2);
        if (bg.mA(eL)) {
            return eK(str);
        }
        return eL;
    }

    public static String eJ(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        w.d("MicroMsg.ContactCommDisplay", "username: %s", str);
        if (Rc == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && bg.mA(Rc.field_nickname)) {
            String eK = ((a) com.tencent.mm.kernel.h.h(a.class)).xa().eK(str);
            if (!bg.mA(eK)) {
                return eK;
            }
        }
        if (Rc.tK() == null || Rc.tK().length() <= 0) {
            return str;
        }
        return Rc.tK();
    }

    public static String eK(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return o.a(((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str), str);
    }

    public static String a(x xVar, String str) {
        return o.a(xVar, str);
    }

    public static String a(x xVar, String str, boolean z) {
        if (xVar == null) {
            return str;
        }
        if (z && bg.mA(xVar.field_nickname)) {
            return ((a) com.tencent.mm.kernel.h.h(a.class)).xa().eK(str);
        }
        if (xVar.tL() != null && xVar.tL().length() > 0) {
            return xVar.tL();
        }
        if (bg.mA(xVar.field_nickname) && o.fD(str)) {
            return com.tencent.mm.j.a.dM(str);
        }
        return str;
    }

    public static String c(x xVar) {
        String eK = eK(xVar.field_username);
        if (!o.dH(xVar.field_username) || !eK.equals(xVar.field_username)) {
            return eK;
        }
        List<String> fZ = ((a) com.tencent.mm.kernel.h.h(a.class)).xa().fZ(xVar.field_username);
        if (fZ == null || fZ.size() <= 0) {
            return ab.getResources().getString(b.a.dCs);
        }
        List arrayList = new ArrayList();
        for (String eK2 : fZ) {
            arrayList.add(eK(eK2));
        }
        return "(" + bg.c(arrayList, ", ") + ")";
    }

    public static String eL(String str) {
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc == null) {
            return "";
        }
        if (bg.mA(Rc.field_conRemark)) {
            return "";
        }
        return Rc.field_conRemark;
    }

    public static void c(Set<String> set) {
        hlq = set;
    }

    public static String eM(String str) {
        if (hlq.contains(str)) {
            return "";
        }
        return str;
    }
}
