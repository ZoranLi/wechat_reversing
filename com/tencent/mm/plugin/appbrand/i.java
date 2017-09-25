package com.tencent.mm.plugin.appbrand;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class i {
    public LinkedList<h> iwW = new LinkedList();
    public HashMap<String, h> iwX = new HashMap();
    c iwY;
    MMActivity iwk;
    public FrameLayout iws;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ h iwZ;
        final /* synthetic */ i ixc;

        AnonymousClass3(i iVar, h hVar) {
            this.ixc = iVar;
            this.iwZ = hVar;
        }

        public final void run() {
            if (this.iwZ.Pw()) {
                this.ixc.a(this.iwZ);
            }
        }
    }

    public i(MMActivity mMActivity, c cVar) {
        this.iwk = mMActivity;
        this.iws = new FrameLayout(mMActivity);
        this.iws.setLayoutParams(new LayoutParams(-1, -1));
        this.iwY = cVar;
    }

    public final void a(final h hVar, final AppBrandInitConfig appBrandInitConfig, final AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null && appBrandStatObject != null) {
            if (hVar == null) {
                PG();
            }
            if (no(appBrandInitConfig.appId) == null) {
                this.iwk.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ i ixc;

                    public final void run() {
                        i iVar = this.ixc;
                        h hVar = hVar;
                        AppBrandInitConfig appBrandInitConfig = appBrandInitConfig;
                        AppBrandStatObject appBrandStatObject = appBrandStatObject;
                        if (hVar != null) {
                            hVar.iwG = true;
                            hVar.onPause();
                        }
                        h hVar2 = new h(iVar.iwk, iVar);
                        hVar2.a(appBrandInitConfig, appBrandStatObject);
                        hVar2.iwm = hVar;
                        hVar2.Pr();
                        iVar.iwW.push(hVar2);
                        iVar.iws.addView(hVar2.iws);
                        if (hVar != null) {
                            hVar.i(null);
                            hVar2.PB();
                        }
                    }
                });
            } else {
                this.iwk.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ i ixc;

                    public final void run() {
                        boolean z = false;
                        i iVar = this.ixc;
                        h hVar = hVar;
                        AppBrandInitConfig appBrandInitConfig = appBrandInitConfig;
                        AppBrandStatObject appBrandStatObject = appBrandStatObject;
                        h no = iVar.no(appBrandInitConfig.appId);
                        int indexOf = iVar.iwW.indexOf(no) - 1;
                        if (indexOf >= 0) {
                            LinkedList linkedList = new LinkedList();
                            int i = indexOf;
                            while (i >= 0 && ((h) iVar.iwW.get(i)).Pw()) {
                                linkedList.add(iVar.iwW.get(i));
                                i--;
                            }
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                h hVar2 = (h) it.next();
                                if (hVar2 != hVar) {
                                    iVar.a(hVar2);
                                }
                            }
                        }
                        if (!iVar.iwW.contains(no)) {
                            iVar.iwW.push(no);
                            iVar.iws.addView(no.iws);
                            iVar.iwX.remove(no.ivH);
                        }
                        iVar.iwW.remove(no);
                        iVar.iwW.push(no);
                        iVar.iws.removeView(no.iws);
                        iVar.iws.addView(no.iws);
                        no.iwm = hVar;
                        if (no.gZN) {
                            boolean z2;
                            if (appBrandInitConfig == null || appBrandInitConfig.izM == no.iwn.izM) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            no.iwD = z2;
                            if (!(appBrandInitConfig == null || appBrandStatObject == null || appBrandStatObject.scene == 1022 || (bg.mA(appBrandInitConfig.iEI) && bg.mA(appBrandInitConfig.hpT) && bg.mA(no.iwn.iEI) && bg.mA(no.iwn.hpT)))) {
                                z = true;
                            }
                            no.iwE = z;
                            no.iwn = appBrandInitConfig;
                            no.a(appBrandStatObject, appBrandInitConfig.iEI);
                        }
                        if (hVar != null) {
                            hVar.iwG = true;
                            hVar.onPause();
                            hVar.i(new AnonymousClass3(iVar, hVar));
                            no.PB();
                            no.onResume();
                        }
                    }
                });
            }
        }
    }

    public final void D(boolean z) {
        if (z) {
            this.iwk.finish();
            return;
        }
        this.iwk.moveTaskToBack(true);
        if (this.iwW.size() > 1) {
            PF().onPause();
            PG();
        }
    }

    public final h PF() {
        return (h) this.iwW.peek();
    }

    final h no(String str) {
        Iterator it = this.iwW.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar.ivH.equals(str)) {
                return hVar;
            }
        }
        return (h) this.iwX.get(str);
    }

    public final void a(final h hVar) {
        this.iwk.runOnUiThread(new Runnable(this) {
            final /* synthetic */ i ixc;

            public final void run() {
                i iVar = this.ixc;
                h hVar = hVar;
                if (hVar != null) {
                    hVar.Po();
                    iVar.iws.removeView(hVar.iws);
                    iVar.iwX.remove(hVar.ivH);
                    iVar.iwW.remove(hVar);
                }
            }
        });
    }

    private void PG() {
        Iterator it = this.iwW.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            this.iws.removeView(hVar.iws);
            this.iwX.put(hVar.ivH, hVar);
            hVar.iwC.iAk.hx(12);
        }
        this.iwW.clear();
    }
}
