package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.r;

public final class a {
    public String appId = "";
    public Context context;
    public com.tencent.mm.ui.widget.e jcm;
    public WxaExposedParams jjq = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a().RL();
    public int scene;
    public String username;
    public h veN;
    public String veO = "";
    public boolean veP;

    public interface h {
        void a(l lVar);

        View bRw();

        void c(MenuItem menuItem, int i);
    }

    public class c implements h {
        final /* synthetic */ a veQ;

        public c(a aVar) {
            this.veQ = aVar;
        }

        public View bRw() {
            return null;
        }

        public void a(l lVar) {
        }

        public void c(MenuItem menuItem, int i) {
            boolean z = true;
            switch (menuItem.getItemId()) {
                case 2:
                    af.f(new Runnable(this) {
                        final /* synthetic */ c veR;

                        {
                            this.veR = r1;
                        }

                        public final void run() {
                            this.veR.veQ.show(3);
                        }
                    }, 100);
                    break;
                case 3:
                    af.f(new Runnable(this) {
                        final /* synthetic */ c veR;

                        {
                            this.veR = r1;
                        }

                        public final void run() {
                            this.veR.veQ.show(4);
                        }
                    }, 100);
                    break;
                case 4:
                    this.veQ.jcm.bzi();
                    break;
                case 5:
                    if (!bg.mA(this.veQ.username)) {
                        b.j(this.veQ.context, this.veQ.username, true);
                        if (!this.veQ.veP) {
                            this.veQ.dU(this.veQ.scene, 4);
                            break;
                        } else {
                            this.veQ.zF(6);
                            break;
                        }
                    }
                    break;
                case 6:
                    if (!bg.mA(this.veQ.username)) {
                        b.j(this.veQ.context, this.veQ.username, false);
                        if (!this.veQ.veP) {
                            this.veQ.dU(this.veQ.scene, 2);
                            break;
                        } else {
                            this.veQ.zF(1);
                            break;
                        }
                    }
                    break;
                case 7:
                    a aVar = this.veQ;
                    Context context = this.veQ.context;
                    Parcelable parcelable = this.veQ.jjq;
                    if (parcelable != null) {
                        w.i("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams : %s", parcelable.toString());
                        if (!bg.mA(parcelable.username)) {
                            Intent intent = new Intent();
                            intent.putExtra("key_username", parcelable.username);
                            intent.putExtra("key_from_scene", 4);
                            intent.putExtra("key_scene_exposed_params", parcelable);
                            com.tencent.mm.bb.d.b(context, "appbrand", ".ui.AppBrandProfileUI", intent);
                            aVar.dU(aVar.scene, 1);
                            break;
                        }
                    }
                    w.e("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams is null");
                    break;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                this.veQ.jcm.bzi();
            }
        }
    }

    public class a extends c {
        final /* synthetic */ a veQ;

        public a(a aVar) {
            this.veQ = aVar;
            super(aVar);
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(2, this.veQ.context.getString(R.l.dFW));
            lVar.e(7, this.veQ.bRv());
        }

        public final void c(MenuItem menuItem, int i) {
            super.c(menuItem, i);
        }
    }

    public class b extends c {
        final /* synthetic */ a veQ;

        public b(a aVar) {
            this.veQ = aVar;
            super(aVar);
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(3, this.veQ.context.getString(R.l.dFY));
            lVar.e(7, this.veQ.bRv());
        }

        public final void c(MenuItem menuItem, int i) {
            super.c(menuItem, i);
        }
    }

    public class d extends c {
        final /* synthetic */ a veQ;

        public d(a aVar) {
            this.veQ = aVar;
            super(aVar);
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(2, this.veQ.context.getString(R.l.dFW));
            lVar.e(7, this.veQ.bRv());
        }

        public final void c(MenuItem menuItem, int i) {
            super.c(menuItem, i);
        }
    }

    public class e extends c {
        final /* synthetic */ a veQ;

        public e(a aVar) {
            this.veQ = aVar;
            super(aVar);
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(3, this.veQ.context.getString(R.l.dFY));
            lVar.e(7, this.veQ.bRv());
        }

        public final void c(MenuItem menuItem, int i) {
            super.c(menuItem, i);
        }
    }

    public class f extends c {
        final /* synthetic */ a veQ;

        public f(a aVar) {
            this.veQ = aVar;
            super(aVar);
        }

        public final View bRw() {
            View inflate = r.eC(this.veQ.context).inflate(R.i.cXq, null);
            ((TextView) inflate.findViewById(R.h.bpR)).setText(this.veQ.context.getString(R.l.dFV));
            return inflate;
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(5, this.veQ.context.getString(R.l.dES));
            lVar.e(4, this.veQ.context.getString(R.l.dFU));
        }

        public final void c(MenuItem menuItem, int i) {
            super.c(menuItem, i);
        }
    }

    public class g extends c {
        final /* synthetic */ a veQ;

        public g(a aVar) {
            this.veQ = aVar;
            super(aVar);
        }

        public final View bRw() {
            View inflate = r.eC(this.veQ.context).inflate(R.i.cXq, null);
            ((TextView) inflate.findViewById(R.h.bpR)).setText(this.veQ.context.getString(R.l.dFX));
            return inflate;
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(6, this.veQ.context.getString(R.l.dET));
            lVar.e(4, this.veQ.context.getString(R.l.dFU));
        }

        public final void c(MenuItem menuItem, int i) {
            super.c(menuItem, i);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final void show(int i) {
        this.jcm = new com.tencent.mm.ui.widget.e(this.context, com.tencent.mm.ui.widget.e.wuP, true);
        switch (i) {
            case 1:
                this.veN = new a(this);
                break;
            case 2:
                this.veN = new b(this);
                break;
            case 3:
                this.veN = new f(this);
                break;
            case 4:
                this.veN = new g(this);
                break;
            case 5:
                this.veN = new d(this);
                break;
            case 6:
                this.veN = new e(this);
                break;
            default:
                return;
        }
        if (this.veN == null) {
            w.e("MicroMsg.AppBrandSerivceActionSheet", "resetTitleView, state is null");
        } else {
            View bRw = this.veN.bRw();
            if (bRw != null) {
                this.jcm.dE(bRw);
            }
        }
        this.jcm.qJf = new com.tencent.mm.ui.base.n.c(this) {
            final /* synthetic */ a veQ;

            {
                this.veQ = r1;
            }

            public final void a(l lVar) {
                if (this.veQ.veN == null) {
                    w.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
                } else {
                    this.veQ.veN.a(lVar);
                }
            }
        };
        this.jcm.qJg = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ a veQ;

            {
                this.veQ = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                if (this.veQ.veN == null) {
                    w.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
                } else {
                    this.veQ.veN.c(menuItem, i);
                }
            }
        };
        this.jcm.bzh();
    }

    private String getAppId() {
        if (bg.mA(this.username)) {
            return null;
        }
        if (bg.mA(this.appId)) {
            WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(this.username);
            if (og != null) {
                this.appId = og.field_appId;
            }
        }
        return this.appId;
    }

    public final void zF(int i) {
        if (!bg.mA(getAppId())) {
            w.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), this.appId, this.veO);
            com.tencent.mm.plugin.report.service.g.oUh.i(13798, Integer.valueOf(i), getAppId(), Integer.valueOf(0), this.veO, Long.valueOf(bg.Ny()));
        }
    }

    public final void dU(int i, int i2) {
        if (!bg.mA(getAppId())) {
            w.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", Integer.valueOf(13918), this.appId, Integer.valueOf(i), this.veO, Integer.valueOf(i2));
            com.tencent.mm.plugin.report.service.g.oUh.i(13918, getAppId(), Integer.valueOf(i), this.veO, Integer.valueOf(i2), Long.valueOf(bg.Ny()));
        }
    }

    public final String bRv() {
        if (this.jjq == null) {
            return "";
        }
        if (bg.mA(this.jjq.fFa)) {
            this.jjq.fFa = "";
        }
        return this.context.getString(R.l.dDo, new Object[]{this.jjq.fFa});
    }
}
