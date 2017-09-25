package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.fi;
import com.tencent.mm.e.a.jt;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.g.5;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

public final class g implements am {
    private static ae lQh;
    private static HandlerThread lQi = new HandlerThread("fps_thread");
    public d lQg = null;
    public b lQj;
    public e lQk;
    c<fi> lQl = new c<fi>(this) {
        final /* synthetic */ g lQn;

        {
            this.lQn = r2;
            this.usg = fi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fi fiVar = (fi) bVar;
            if (fiVar.fJU.fEG == 1) {
                this.lQn.stop();
                this.lQn.start();
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uGH, Boolean.valueOf(true));
            } else if (fiVar.fJU.fEG == 0) {
                this.lQn.stop();
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uGH, Boolean.valueOf(false));
            }
            return true;
        }
    };
    c<jt> lQm = new c<jt>(this) {
        final /* synthetic */ g lQn;

        {
            this.lQn = r2;
            this.usg = jt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jt jtVar = (jt) bVar;
            w.i("MicroMsg.SubCoreFPSLighter", "[NotifyFragmentChangeEvent] name:%s id:%s visible:%s", new Object[]{jtVar.fQh.name, Integer.valueOf(jtVar.fQh.id), Boolean.valueOf(jtVar.fQh.visible)});
            if (this.lQn.lQg != null) {
                if (!jtVar.fQh.visible) {
                    this.lQn.lQg.wr("FRAGMENT_UNKNOW");
                } else if (jtVar.fQh.id == 1) {
                    this.lQn.lQg.wr("FRAGMENT_ADDRESS");
                } else if (jtVar.fQh.id == 0) {
                    this.lQn.lQg.wr("FRAGMENT_MAINUI");
                } else if (jtVar.fQh.id == Integer.MAX_VALUE) {
                    this.lQn.lQg.wr("FRAGMENT_CHATTING");
                } else {
                    this.lQn.lQg.wr("FRAGMENT_UNKNOW");
                }
            }
            return true;
        }
    };

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.d("MicroMsg.SubCoreFPSLighter", "[onAccountRelease]");
        stop();
        this.lQl.dead();
        this.lQm.dead();
    }

    public static g avJ() {
        g gVar = (g) ap.yR().gs("plugin.fps_lighter");
        if (gVar != null) {
            return gVar;
        }
        w.e("MicroMsg.SubCoreFPSLighter", "not found in MMCore, new one");
        Object gVar2 = new g();
        ap.yR().a("plugin.fps_lighter", gVar2);
        return gVar2;
    }

    public final void aM(boolean z) {
        this.lQl.bIy();
        this.lQm.bIy();
        try {
            start();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SubCoreFPSLighter", e, "", new Object[0]);
        }
    }

    public final void start() {
        if (VERSION.SDK_INT < 16) {
            w.w("MicroMsg.SubCoreFPSLighter", "[start] API is low 16");
            return;
        }
        ap.yY();
        if (!com.tencent.mm.u.c.vr().c(a.uGH, true)) {
            w.w("MicroMsg.SubCoreFPSLighter", "[start] isValid:%s", new Object[]{Boolean.valueOf(com.tencent.mm.u.c.vr().c(a.uGH, true))});
        } else if (!e.usp) {
            w.w("MicroMsg.SubCoreFPSLighter", "[start] never open gmtrace when build");
        } else if (d.sYQ) {
            ap.yY();
            if (com.tencent.mm.u.c.uH() != 0) {
                w.i("MicroMsg.SubCoreFPSLighter", "[start]");
                final c cVar = new c();
                com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100166");
                if (dX.isValid() && dX.bKK().containsKey("percent")) {
                    w.i("MicroMsg.SubCoreFPSLighter", "[start] :%s", new Object[]{Integer.valueOf(bg.getInt((String) dX.bKK().get("percent"), 100))});
                    cVar.lPR = r0;
                } else {
                    w.w("MicroMsg.SubCoreFPSLighter", "[start] never has abtest:100166");
                    cVar.lPR = 100;
                }
                if (cVar.lPR > 0) {
                    w.i("MicroMsg.SubCoreFPSLighter", "it real open rand:%s", new Object[]{Integer.valueOf(cVar.lPR)});
                    cVar.lPL = true;
                    cVar.lPK = true;
                    GMTrace.init(true);
                    if (this.lQk == null) {
                        this.lQk = new e(cVar);
                    }
                    GMTrace.registerHandler(this.lQk);
                    if (this.lQj == null) {
                        this.lQj = new b();
                    }
                    b bVar = this.lQj;
                    if (!bVar.isInit) {
                        bVar.isInit = true;
                        bVar.lPE = new Timer();
                        bVar.lPE.scheduleAtFixedRate(new TimerTask(bVar) {
                            final /* synthetic */ b lPF;

                            {
                                this.lPF = r1;
                            }

                            public final void run() {
                                w.i("MicroMsg.FPSAnalyser", "begin report analyse result!");
                                synchronized (this.lPF.lPD) {
                                    b bVar = this.lPF;
                                    w.i("MicroMsg.FPSAnalyser", "[report] size:%s", new Object[]{Integer.valueOf(bVar.lPD.size())});
                                    List arrayList = new ArrayList(100);
                                    for (Entry value : bVar.lPD.entrySet()) {
                                        w.d("MicroMsg.FPSAnalyser", "[report] results size:%s key:%s", new Object[]{Integer.valueOf(((LinkedList) value.getValue()).size()), ((Entry) r3.next()).getKey()});
                                        Iterator it = r1.iterator();
                                        while (it.hasNext()) {
                                            com.tencent.mm.plugin.fps_lighter.c.d dVar = (com.tencent.mm.plugin.fps_lighter.c.d) it.next();
                                            if (dVar.lQF.lQr) {
                                                w.w("MicroMsg.FPSAnalyser.report", dVar.toString());
                                            } else {
                                                Map hashMap = new HashMap();
                                                Map hashMap2 = new HashMap();
                                                hashMap2.put("scene", Integer.valueOf(dVar.lQF.scene));
                                                hashMap2.put("maskTimeStamp", Long.valueOf(dVar.lQF.lQq));
                                                hashMap2.put("dropCount", Integer.valueOf(dVar.lQF.lQs));
                                                hashMap2.put("dropTime", Long.valueOf(dVar.lQF.avK()));
                                                hashMap2.put("cpu", dVar.lQF.lQt + "%");
                                                hashMap2.put("methodId", Long.valueOf(dVar.lQy));
                                                hashMap2.put("costTime", Long.valueOf(dVar.lQE));
                                                hashMap2.put("percent", Math.round(((((double) dVar.lQE) * 1.0d) / ((double) dVar.lQF.avK())) * 100.0d) + "%");
                                                hashMap2.put("exec num", Integer.valueOf(dVar.hXR));
                                                hashMap2.put("rawCostTime", Long.valueOf(dVar.lQv));
                                                hashMap2.put("isDrawing", Boolean.valueOf(dVar.lQw));
                                                hashMap2.put("revision", e.REV);
                                                hashMap.put(dVar.avM(), hashMap2);
                                                w.i("MicroMsg.FPSAnalyser.report", dVar.toString());
                                                arrayList.add(hashMap);
                                            }
                                        }
                                    }
                                    g gVar = g.oUh;
                                    String str = "fps";
                                    if (arrayList.size() > 0) {
                                        String xL = (ab.bJb() && h.vG().uV()) ? m.xL() : null;
                                        com.tencent.mm.sdk.f.e.post(new 5(gVar, arrayList, str, System.currentTimeMillis(), xL), "ReportManager_cLog");
                                    }
                                    bVar.lPD.clear();
                                }
                            }
                        }, 3600000, 3600000);
                    }
                    if (lQi == null || !lQi.isAlive()) {
                        HandlerThread handlerThread = new HandlerThread("analyse_thread");
                        lQi = handlerThread;
                        handlerThread.setPriority(1);
                        lQi.start();
                        lQh = new ae(lQi.getLooper());
                    }
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ g lQn;

                        public final void run() {
                            if (this.lQn.lQg == null) {
                                this.lQn.lQg = new d(cVar);
                            }
                            d dVar = this.lQn.lQg;
                            Context context = ab.getContext();
                            w.i("MicroMsg.FPSFinder", "[start]");
                            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                            dVar.lPk.lPH = 1000.0f / defaultDisplay.getRefreshRate();
                            dVar.lPk.lPG = defaultDisplay.getRefreshRate();
                            w.i("MicroMsg.FPSFinder", "refreshRate %s", new Object[]{Float.valueOf(dVar.lPk.lPG)});
                            dVar.lPS = new f(dVar.lPk);
                            if (dVar.lPk.lPL) {
                                dVar.lPS.a(new com.tencent.mm.plugin.fps_lighter.a.a(dVar.lPk));
                            }
                            if (dVar.lPk.lPK) {
                                dVar.lPS.a(new com.tencent.mm.plugin.fps_lighter.a.b(dVar.lPk));
                            }
                            dVar.lPS.c((Application) context.getApplicationContext());
                        }
                    });
                    return;
                }
                w.i("MicroMsg.SubCoreFPSLighter", "[start] is disable!");
            }
        } else {
            w.w("MicroMsg.SubCoreFPSLighter", "is not alpha version");
        }
    }

    public final void stop() {
        if (VERSION.SDK_INT >= 16) {
            w.i("MicroMsg.SubCoreFPSLighter", "[stop]");
            if (this.lQg != null) {
                d dVar = this.lQg;
                Context context = ab.getContext();
                w.i("MicroMsg.FPSFinder", "[stop]");
                if (dVar.lPS != null) {
                    dVar.lPS.d((Application) context.getApplicationContext());
                }
                if (dVar.lPk.lPL) {
                    avJ().lQk.stopTrace();
                }
            }
            if (this.lQj != null) {
                b bVar = this.lQj;
                w.i("MicroMsg.FPSAnalyser", "[stop]");
                bVar.isInit = false;
                bVar.lPE.cancel();
            }
            if (lQi != null) {
                lQi.quit();
                lQi = null;
            }
            if (this.lQk != null) {
                this.lQk.stopTrace();
                GMTrace.unregisterHandler(this.lQk);
            }
        }
    }

    public static ae MM() {
        return lQh;
    }
}
