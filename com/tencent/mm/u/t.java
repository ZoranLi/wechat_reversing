package com.tencent.mm.u;

import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.ay;

public final class t {
    public static aq fT(String str) {
        return new aq("@black.android", null, str, null, true, true);
    }

    public static aq fU(String str) {
        ap.yY();
        ay AH = c.wZ().AH("@t.qq.com");
        if (AH == null) {
            return null;
        }
        return new aq("@t.qq.com", null, str, null, AH.isEnable(), AH.bMS());
    }

    public static aq I(String str, String str2) {
        aq aqVar = null;
        if (str != null && str.length() > 0) {
            ap.yY();
            ay AH = c.wZ().AH(str);
            if (AH != null) {
                if (AH.uKK == 1) {
                    String str3 = "@domain.android";
                    String str4 = AH.name;
                    String RU = AH.uKJ.RU("");
                    String str5 = "";
                    if (RU != null) {
                        str5 = str5 + RU.replace("@", "");
                    }
                    if (str2 != null) {
                        str5 = str5 + str2;
                    }
                    aqVar = new aq(str3, str4, str5, AH.uKJ.RU(""), AH.isEnable(), true);
                }
            }
        }
        return aqVar;
    }
}
