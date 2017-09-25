package com.tencent.mm.plugin.fps_lighter.b;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fps_lighter.c.d;
import com.tencent.mm.plugin.fps_lighter.d.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public final class b implements a {
    boolean isInit = false;
    public HashMap<String, LinkedList<d>> lPD = new HashMap();
    Timer lPE = new Timer();

    public final void K(LinkedList<d> linkedList) {
        synchronized (this.lPD) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                w.i("MicroMsg.FPSAnalyser.result", dVar.toString());
                String avM = dVar.avM();
                if (!this.lPD.containsKey(avM)) {
                    this.lPD.put(avM, new LinkedList());
                }
                ((LinkedList) this.lPD.get(avM)).add(dVar);
            }
        }
        linkedList.clear();
        new ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ b lPF;

            {
                this.lPF = r1;
            }

            public final void run() {
                GMTrace.releaseBuffer();
            }
        });
    }
}
