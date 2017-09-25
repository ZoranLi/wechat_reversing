package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ao.f;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.g;
import junit.framework.Assert;

public class OpenBottleUI extends FrameLayout implements OnClickListener, b, a, g.a, g.b {
    static SensorController jXn;
    au fCZ;
    private com.tencent.mm.c.a.a fyE;
    private boolean jWp = false;
    BottleBeachUI jXf;
    TextView jXg;
    LinearLayout jXh;
    FrameLayout jXi;
    ImageView jXj;
    TextView jXk;
    TextView jXl;
    TextView jXm;
    ThrowBottleAnimUI jXo;
    String jXp;
    private boolean jXq = true;
    private ax jXr;
    private long jXs = -1;
    private boolean jXt;
    TextView jXu;
    MMActivity jXv;
    long jXw = 0;
    private boolean jXx = false;

    public OpenBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXf = (BottleBeachUI) context;
        ap.yY();
        c.wR().a(this);
        if (jXn == null) {
            jXn = new SensorController(context.getApplicationContext());
        }
        if (this.jXr == null) {
            this.jXr = new ax(context.getApplicationContext());
        }
        ap.yY();
        Boolean bool = (Boolean) c.vr().get(26, Boolean.valueOf(false));
        this.jXt = bool.booleanValue();
        this.jXq = !bool.booleanValue();
        if (this.fyE != null) {
            this.fyE.aq(this.jXq);
        }
    }

    public final void onPause() {
        ap.yZ().qS();
        if (this.fCZ != null && this.fCZ.bLZ()) {
            adJ();
        }
        if (this.fyE != null) {
            if (this.fyE.isPlaying()) {
                adL();
            }
            this.fyE.aq(true);
        }
    }

    public final void adJ() {
        if (jXn != null) {
            jXn.bJG();
        }
        this.jXr.bJH();
    }

    public void onClick(View view) {
        if (R.h.bui == view.getId()) {
            ThrowBottleAnimUI throwBottleAnimUI = this.jXo;
            throwBottleAnimUI.jYt = this.fCZ.bLZ();
            throwBottleAnimUI.setVisibility(0);
            throwBottleAnimUI.jXf.jVO = false;
            throwBottleAnimUI.jXf.jU(-1);
            throwBottleAnimUI.adS();
            throwBottleAnimUI.adQ();
            throwBottleAnimUI.adR();
            ap.yY();
            c.wQ().b(new f(this.jXp, 1));
            this.jWp = false;
            Context context = this.jXf;
            this.jXf.getString(R.l.dIO);
            final p a = com.tencent.mm.ui.base.g.a(context, this.jXf.getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ OpenBottleUI jXy;

                {
                    this.jXy = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.jXy.jWp = true;
                }
            });
            ay.a(this.jXp, new ay.a(this) {
                final /* synthetic */ OpenBottleUI jXy;

                public final boolean zs() {
                    return this.jXy.jWp;
                }

                public final void zr() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ap.yY();
            c.wW().Rl(this.jXp);
            adJ();
        } else if (R.h.bug == view.getId()) {
            this.jXf.jU(0);
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.jXp);
            com.tencent.mm.plugin.bottle.a.imv.e(intent, this.jXf);
            adJ();
        } else if (R.h.bum != view.getId()) {
            return;
        } else {
            if (this.fyE == null || !this.fyE.isPlaying()) {
                G(this.fCZ);
                return;
            }
        }
        adL();
    }

    final void adK() {
        String str;
        ap.yY();
        af Rc = c.wR().Rc(this.jXp);
        if (!(Rc == null || this.jXf == null)) {
            this.jXl.setText(this.jXf.getString(R.l.dPs, new Object[]{com.tencent.mm.plugin.bottle.a.c.b(this.jXf, Rc)}));
            this.jXl.setCompoundDrawablesWithIntrinsicBounds(Rc.gkr == 1 ? R.k.dxs : R.k.dxr, 0, 0, 0);
            this.jXl.setCompoundDrawablePadding(8);
            this.jXm.setText(h.b(this.jXf, Rc.signature, this.jXm.getTextSize()));
        }
        String QR = x.QR(this.jXp);
        if (bg.mA(QR)) {
            str = this.jXp;
        } else {
            str = QR;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) findViewById(R.h.buc), str);
    }

    static int jZ(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return ao.CTRL_INDEX;
    }

    private void G(au auVar) {
        if (com.tencent.mm.n.a.aJ(getContext()) || com.tencent.mm.n.a.aH(this.jXf)) {
            w.d("MM.Bottle_OpenBottleUI", "voip is running, can't use the feature");
            return;
        }
        boolean z = auVar != null && auVar.bLZ();
        Assert.assertTrue(z);
        if (!(auVar == null || !auVar.bLZ() || jXn.uvF)) {
            jXn.a(this);
            if (this.jXr.M(new Runnable(this) {
                final /* synthetic */ OpenBottleUI jXy;

                {
                    this.jXy = r1;
                }

                public final void run() {
                    this.jXy.jXs = bg.NA();
                }
            })) {
                this.jXs = 0;
            } else {
                this.jXs = -1;
            }
        }
        ap.yY();
        if (c.isSDCardAvailable() || bg.mA(auVar.field_imgPath)) {
            if (this.fyE == null) {
                this.fyE = new com.tencent.mm.c.a.a(this.jXf);
            }
            ad.Pt("keep_app_silent");
            q.E(auVar);
            this.fyE.ap(false);
            if (auVar == null || !this.fyE.h(auVar.field_imgPath, this.jXq)) {
                Toast.makeText(this.jXf, this.jXf.getString(R.l.dVf), 0).show();
                return;
            }
            ap.yZ().c(this.jXq, false);
            this.fyE.fzb = this;
            this.fyE.fza = this;
            this.jXj.setBackgroundResource(R.a.aQP);
            ((AnimationDrawable) this.jXj.getBackground()).start();
            return;
        }
        s.eP(this.jXf);
    }

    private void adL() {
        ad.Pu("keep_app_silent");
        adJ();
        if (this.jXj.getBackground() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.jXj.getBackground()).stop();
            this.jXj.setBackgroundResource(R.g.bcS);
        }
        if (this.fyE != null) {
            this.fyE.ap(false);
        }
        cV(true);
    }

    public final void oW() {
        w.v("MM.Bottle_OpenBottleUI", "voice play completion");
        adL();
    }

    public final void onError() {
        w.v("MM.Bottle_OpenBottleUI", "voice play error");
        adL();
    }

    public final void a(int i, m mVar, Object obj) {
        w.d("MM.Bottle_OpenBottleUI", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            w.e("MM.Bottle_OpenBottleUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (!bg.mA(this.jXp) && x.QR(this.jXp).equals(x.QR(str))) {
            adK();
        }
    }

    public final boolean adM() {
        if (this.fyE == null || !this.fyE.isPlaying() || this.jXq) {
            return false;
        }
        return true;
    }

    public final void cU(boolean z) {
        boolean z2 = true;
        if (this.fCZ.bLZ() && this.fyE != null) {
            if (this.jXx) {
                if (z) {
                    z2 = false;
                }
                this.jXx = z2;
            } else if (z || this.jXs == -1 || bg.aB(this.jXs) <= 400) {
                this.jXx = false;
                if (bg.NA() - this.jXw > 500 && (z || (!z && this.fyE.isPlaying()))) {
                    cV(z);
                }
                if (this.jXt) {
                    this.fyE.aq(false);
                    ap.yZ().c(false, false);
                    this.jXq = false;
                } else if (this.fyE.isPlaying()) {
                    this.fyE.aq(z);
                    ap.yZ().c(z, false);
                    this.jXq = z;
                    if (!z) {
                        G(this.fCZ);
                    }
                } else {
                    this.fyE.aq(true);
                    ap.yZ().c(true, false);
                    this.jXq = true;
                }
            } else {
                this.jXx = true;
            }
        }
    }

    final void cV(boolean z) {
        this.jXv.cV(z);
    }
}
