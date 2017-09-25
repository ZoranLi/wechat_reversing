package com.tencent.mm.plugin.appbrand.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService.b;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.c;
import com.tencent.mm.sdk.platformtools.w;

abstract class f extends g {
    int iAG = 0;
    private final b iAH = new b(this) {
        final /* synthetic */ f iAJ;

        {
            this.iAJ = r1;
        }

        public final void QI() {
            this.iAJ.hz(1);
        }

        public final void onStop() {
            this.iAJ.hz(1);
        }
    };
    private final c iAI = new c(this) {
        final /* synthetic */ f iAJ;

        {
            this.iAJ = r1;
        }

        public final void S(String str, int i) {
            if (!this.iAJ.ixr.ivH.equals(str)) {
                this.iAJ.hz(2);
            }
        }
    };
    public final h ixr;

    abstract void QF();

    f(h hVar, h hVar2) {
        super(hVar);
        this.ixr = hVar2;
    }

    public void enter() {
        int i;
        super.enter();
        this.iAG = 0;
        String str = this.ixr.ivH;
        int i2 = this.ixr.iwn.izM;
        if (this.ixr.iwo == null || !this.ixr.iwo.iFh) {
            i = 0;
        } else {
            i = 1;
        }
        AppBrandMusicClientService appBrandMusicClientService;
        if (i == 0) {
            appBrandMusicClientService = AppBrandMusicClientService.jao;
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase(appBrandMusicClientService.jap)) {
                    MainProcessTask stopBackgroundMusicTask = new StopBackgroundMusicTask();
                    stopBackgroundMusicTask.appId = str;
                    AppBrandMainProcessService.a(stopBackgroundMusicTask);
                } else {
                    w.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
                }
            }
        } else if (AppBrandMusicClientService.pN(str)) {
            hy(1);
            appBrandMusicClientService = AppBrandMusicClientService.jao;
            b bVar = this.iAH;
            if (!(TextUtils.isEmpty(str) || bVar == null)) {
                if (appBrandMusicClientService.jan.containsKey(str)) {
                    appBrandMusicClientService.jan.remove(str);
                    appBrandMusicClientService.jan.put(str, bVar);
                } else {
                    appBrandMusicClientService.jan.put(str, bVar);
                }
            }
        }
        if (e.nk(str) == e.c.HANG || a.ap(str, i2)) {
            hy(2);
            a.b(this.iAI);
        }
        switch (e.nk(str)) {
            case LAUNCH_MINI_PROGRAM:
                hy(16);
                break;
            case LAUNCH_NATIVE_PAGE:
                hy(4);
                break;
            case HOME_PRESSED:
                hy(8);
                break;
        }
        this.iAG = this.iAG;
        hz(0);
    }

    public void exit() {
        super.exit();
        this.iAG = 0;
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.jao;
        CharSequence charSequence = this.ixr.ivH;
        if (!TextUtils.isEmpty(charSequence) && appBrandMusicClientService.jan.containsKey(charSequence)) {
            appBrandMusicClientService.jan.remove(charSequence);
        }
        a.a(this.iAI);
    }

    private void hy(int i) {
        this.iAG |= i;
    }

    public final void hz(int i) {
        this.iAG &= i ^ -1;
        if (this.iAG == 0) {
            QF();
        }
    }
}
