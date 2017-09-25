package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class g {
    private static int rUd = 0;
    private HashMap<String, f> rUe = new HashMap();

    public final synchronized f IC(String str) {
        f fVar;
        if (this.rUe.containsKey(str)) {
            fVar = (f) ((f) this.rUe.get(str)).clone();
        } else {
            rUd++;
            fVar = new f();
            fVar.fJL = str;
            fVar.id = rUd;
            fVar.rTX = a.rTY;
            this.rUe.put(str, fVar);
            fVar = (f) fVar.clone();
        }
        return fVar;
    }

    public final synchronized void ID(String str) {
        w.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", new Object[]{str});
        if (this.rUe.containsKey(str)) {
            ((f) this.rUe.get(str)).rTX = a.rTY;
            ((f) this.rUe.get(str)).rTW = 0;
        }
    }

    public final synchronized void a(f fVar) {
        w.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", new Object[]{fVar});
        this.rUe.put(fVar.fJL, fVar);
    }

    public final synchronized void IE(String str) {
        if (this.rUe.containsKey(str)) {
            f fVar = (f) this.rUe.get(str);
            fVar.rTX = a.REPLY;
            fVar.rTW = 0;
            w.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void bZ(String str, int i) {
        if (this.rUe.containsKey(str)) {
            f fVar = (f) this.rUe.get(str);
            fVar.rTX = a.IGNORE;
            fVar.rTW = i;
            w.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void IF(String str) {
        if (this.rUe.containsKey(str)) {
            ((f) this.rUe.get(str)).rTX = a.SHOWING;
            w.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", new Object[]{r0});
        }
    }
}
