package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.Vector;

public abstract class g {
    private Vector<b> qdC = new Vector();

    public final b a(b bVar) {
        this.qdC.add(bVar);
        return bVar;
    }

    public final boolean b(b bVar) {
        boolean z;
        Iterator it = this.qdC.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.hTw == bVar.hTw) {
                this.qdC.remove(bVar2);
                z = true;
                break;
            }
        }
        z = false;
        this.qdC.add(bVar);
        return z;
    }

    public final b bl(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator it = this.qdC.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (obj.equals(bVar.hTt)) {
                    this.qdC.remove(bVar);
                    return bVar;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.Ss_log_base_helper", "report by key " + e.getMessage() + " " + obj);
        }
        return null;
    }
}
