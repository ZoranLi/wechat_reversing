package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.g;
import com.tencent.mm.e.b.di;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k extends i<g> {
    public static final String[] gUx = new String[]{i.a(g.gTP, "VoiceRemindInfo")};
    private static long iaA = 0;
    e gUz;
    Map<String, c> qTv = new HashMap();

    public k(e eVar) {
        super(eVar, g.gTP, "VoiceRemindInfo", di.gaK);
        this.gUz = eVar;
    }

    public static String lu(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.n(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = iaA;
        iaA = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    public final boolean gR(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.gUz.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            w.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final void lW(String str) {
        c cVar = (c) this.qTv.get(str);
        if (cVar != null) {
            cVar.Lu();
            this.qTv.remove(str);
        }
    }
}
