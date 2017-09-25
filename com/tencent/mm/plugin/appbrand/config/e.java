package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ab;
import java.util.Locale;

public final class e {
    public final ab RD() {
        return new ab(this) {
            final /* synthetic */ e iEN;

            {
                this.iEN = r1;
            }

            public final void transfer(int i) {
                if (eX(i)) {
                    try {
                        w.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
                        g PO = c.PN().PO();
                        c.PR();
                        PO.eE("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[]{"WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo"}));
                    } catch (Exception e) {
                        w.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", new Object[]{e});
                    }
                }
            }

            public final boolean eX(int i) {
                return i >= 637863936 && i <= 637863988;
            }

            public final String getTag() {
                return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
            }
        };
    }
}
