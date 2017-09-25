package com.tencent.mm.plugin.accountsync.b;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static a irZ = new a();
    private Map<String, String> isa;

    public final Map<String, String> bs(Context context) {
        try {
            String l = bg.l(context.getAssets().open("config/EmailAddress.xml"));
            if (bg.mA(l)) {
                return null;
            }
            Map q = bh.q(l, "config");
            if (q == null || q.isEmpty()) {
                w.d("MicroMsg.EmailFormater", "values null");
                return null;
            } else if (this.isa != null) {
                return this.isa;
            } else {
                this.isa = new HashMap();
                int i = 0;
                while (true) {
                    l = ".config.format" + (i == 0 ? "" : Integer.valueOf(i));
                    if (q.get(l) == null) {
                        return this.isa;
                    }
                    String str = l + ".emaildomain";
                    String str2 = l + ".loginpage";
                    l = (String) q.get(str);
                    str = (String) q.get(str2);
                    if (!(bg.mA(l) || bg.mA(str))) {
                        this.isa.put(l, str);
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.EmailFormater", "parse email failed:[%s]", e.getMessage());
            return null;
        }
    }
}
