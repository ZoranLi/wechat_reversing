package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;

public abstract class b extends c {
    protected final String c(String str, au auVar) {
        if (o.dH(str)) {
            String d = d(str, auVar);
            return String.format(ab.getContext().getString(R.l.eEo), new Object[]{h.IH(d), Character.valueOf('​'), h.R(auVar).opI});
        }
        return String.format(ab.getContext().getString(R.l.eEp), new Object[]{h.R(auVar).opI});
    }

    protected static String d(String str, au auVar) {
        if (!o.dH(str)) {
            return str;
        }
        int gh = ay.gh(auVar.field_content);
        if (gh == -1) {
            return str;
        }
        String trim = auVar.field_content.substring(0, gh).trim();
        if (trim == null || trim.length() <= 0) {
            return str;
        }
        return trim;
    }
}
