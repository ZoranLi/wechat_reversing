package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.j.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.pb.talkroom.sdk.f;
import java.util.concurrent.LinkedBlockingQueue;

public final class k implements Runnable {
    boolean fBn;
    protected a nPt;
    protected LinkedBlockingQueue<c> nQc = new LinkedBlockingQueue();
    protected ae[] nQd;
    m nQe = new m("multitalk_network");
    private int nQf;
    private int nQg = 5;
    private int nQh;
    private int nQi;

    private class a implements Runnable {
        int index;
        final /* synthetic */ k nQj;

        a(k kVar, int i) {
            this.nQj = kVar;
            this.index = i;
        }

        public final void run() {
            Looper.prepare();
            w.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
            this.nQj.nQd[this.index] = new ae();
            Looper.loop();
        }
    }

    protected class b implements Runnable {
        final /* synthetic */ k nQj;
        private c nQk;

        public b(k kVar, c cVar) {
            this.nQj = kVar;
            this.nQk = cVar;
        }

        public final void run() {
            if (this.nQk != null) {
                w.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", new Object[]{this.nQk.username, Long.valueOf(Thread.currentThread().getId())});
                if (this.nQj.nPt != null) {
                    this.nQj.nPt.a(this.nQk.username, this.nQk.nQl, this.nQk.nQn, this.nQk.nQo, OpenGlRender.rpI);
                }
                try {
                    this.nQj.nQc.put(this.nQk);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public class c {
        boolean hoD;
        final /* synthetic */ k nQj;
        int[] nQl;
        int nQm;
        int nQn;
        int nQo;
        String username;

        c(k kVar, boolean z) {
            this.nQj = kVar;
            this.hoD = z;
        }
    }

    public k(a aVar) {
        this.nPt = aVar;
    }

    public final void start() {
        int i;
        w.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", new Object[]{Integer.valueOf(this.nQf)});
        this.fBn = true;
        e.d(this, "MultiTalk_videoReceiver1", 1).start();
        e.d(this, "MultiTalk_videoReceiver2", 1).start();
        this.nQd = new ae[2];
        for (i = 0; i < this.nQd.length; i++) {
            e.d(new a(this, i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
        }
        for (i = 0; i < 36; i++) {
            this.nQc.add(new c(this, false));
        }
    }

    public final void stop() {
        int i = 0;
        this.nPt = null;
        this.fBn = false;
        this.nQf = 0;
        if (this.nQd != null) {
            while (i < this.nQd.length) {
                if (this.nQd[i] != null) {
                    this.nQd[i].removeCallbacksAndMessages(null);
                    this.nQd[i].getLooper().quit();
                    this.nQd[i] = null;
                }
                i++;
            }
        }
        this.nQc.clear();
        this.nQc.add(new c(this, true));
        this.nQc.add(new c(this, true));
    }

    public final void run() {
        w.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.nQg);
        while (this.fBn) {
            this.nQe.Mn("_total");
            c cVar = null;
            try {
                cVar = (c) this.nQc.take();
            } catch (InterruptedException e) {
            }
            boolean z = false;
            if (cVar != null) {
                if (cVar.hoD) {
                    break;
                }
                z = a(cVar);
            }
            if (!z) {
                try {
                    Thread.sleep((long) this.nQg);
                } catch (InterruptedException e2) {
                }
            }
        }
        w.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
    }

    public final void pV(int i) {
        this.nQf = i;
        w.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize " + i);
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            if (cVar != null) {
                if (cVar.nQl == null) {
                    cVar.nQl = new int[25600];
                }
                cVar.nQl[0] = 0;
                if (Thread.currentThread().getName().contains("MultiTalk_videoReceiver2")) {
                    cVar.nQl[0] = 1;
                }
                f s = o.aNm().nOT.s(cVar.nQl);
                if (this.nPt == null || s.ret <= 0 || bg.mA(s.wPk)) {
                    if (s.ret == 0) {
                        this.nQh++;
                    }
                    this.nQe.Mn("_fail");
                    w.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj fail ret %d", new Object[]{Integer.valueOf(s.ret)});
                    if ((this.nQh + this.nQi) % 100 == 0) {
                        w.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%f 1:%f", new Object[]{Float.valueOf(((float) this.nQh) / ((float) (this.nQh + this.nQi))), Float.valueOf(((float) this.nQi) / ((float) (this.nQh + this.nQi)))});
                    }
                    try {
                        this.nQc.put(cVar);
                    } catch (InterruptedException e) {
                    }
                    z = false;
                } else {
                    int AV = this.nPt.AV(s.wPk);
                    cVar.username = s.wPk;
                    cVar.nQn = s.wPo;
                    cVar.nQo = s.wPp;
                    cVar.nQm = s.wPn;
                    w.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj get username: %s, position: %d", new Object[]{cVar.username, Integer.valueOf(AV)});
                    if (AV >= 0 && this.nQd[AV % 2] != null) {
                        this.nQd[AV % 2].post(new b(this, cVar));
                    }
                    this.nQe.Mn("_success");
                    this.nQi++;
                    if ((this.nQh + this.nQi) % 100 == 0) {
                        w.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%d 1:%d", new Object[]{Integer.valueOf(this.nQh / (this.nQh + this.nQi)), Integer.valueOf(this.nQi / (this.nQh + this.nQi))});
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }
}
