package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.model.ae;

public final class h {
    public static m Gf(String str) {
        if (u.Eu(str)) {
            return ae.beL().dG(u.GA(str));
        }
        e dz = ae.beN().dz(u.GA(str));
        if (dz != null) {
            return dz.bhf();
        }
        return null;
    }

    public static boolean a(String str, m mVar) {
        if (u.Eu(str)) {
            return ae.beL().b(u.GA(str), mVar);
        }
        return ae.beN().b(u.GA(str), mVar.bhJ());
    }

    public static m Gg(String str) {
        if (u.Eu(str)) {
            return ae.beL().tH(u.GB(str));
        }
        e tD = ae.beN().tD(u.GB(str));
        if (tD != null) {
            return tD.bhf();
        }
        return null;
    }
}
