package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.py;
import com.tencent.mm.i.f;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@a(3)
public class WebWXLogoutUI extends MMActivity implements al, e {
    private c pWv = new c<py>(this) {
        final /* synthetic */ WebWXLogoutUI ssf;

        {
            this.ssf = r2;
            this.usg = py.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            py pyVar = (py) bVar;
            w.d("MicroMsg.WebWXLogoutUI", "status Notify function");
            if (pyVar.fWZ.fJA == 8) {
                this.ssf.finish();
            }
            return false;
        }
    };
    private ProgressDialog pjC = null;
    private boolean srP = false;
    private boolean srV;
    private boolean srW;
    private ImageButton srX;
    private ImageButton srY;
    private ImageView srZ;
    private int ssa;
    private int ssb;
    private int ssc;
    private Animator ssd;
    private int sse;

    static /* synthetic */ boolean b(WebWXLogoutUI webWXLogoutUI) {
        if (!ap.zb()) {
            return false;
        }
        int xR = m.xR();
        xR = webWXLogoutUI.srV ? xR | 8192 : xR & -8193;
        f.et(xR);
        ap.yY();
        com.tencent.mm.u.c.vr().set(40, Integer.valueOf(xR));
        webWXLogoutUI.srP = true;
        webWXLogoutUI.WS();
        return true;
    }

    static /* synthetic */ void e(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.srW) {
            ap.vd().a(new com.tencent.mm.plugin.webwx.a.a(2), 0);
            w.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            return;
        }
        ap.vd().a(new com.tencent.mm.plugin.webwx.a.a(1), 0);
        w.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
    }

    static /* synthetic */ boolean f(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.sse == q.Jd()) {
            g.a(webWXLogoutUI.uSU.uTo, q.hSj, webWXLogoutUI.getString(R.l.dIO), webWXLogoutUI.getString(R.l.fmO), webWXLogoutUI.getString(R.l.dGs), new OnClickListener(webWXLogoutUI) {
                final /* synthetic */ WebWXLogoutUI ssf;

                {
                    this.ssf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    final k ajVar = new aj(1);
                    ap.vd().a(ajVar, 0);
                    WebWXLogoutUI webWXLogoutUI = this.ssf;
                    Context context = this.ssf.uSU.uTo;
                    this.ssf.getString(R.l.dIO);
                    webWXLogoutUI.pjC = g.a(context, null, true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass8 ssh;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(ajVar);
                            if (this.ssh.ssf.pjC != null) {
                                this.ssh.ssf.pjC.cancel();
                            }
                        }
                    });
                }
            }, null);
        } else {
            webWXLogoutUI.finish();
        }
        return true;
    }

    static /* synthetic */ int g(WebWXLogoutUI webWXLogoutUI) {
        int[] iArr = new int[2];
        View findViewById = webWXLogoutUI.findViewById(R.h.cSI);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        w.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height)});
        return (((int) (((double) point.y) / 4.0d)) - i) - height;
    }

    protected final int getLayoutId() {
        return R.i.drT;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.aQL, R.a.aRo);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cO().cP().hide();
        if (getIntent() != null) {
            this.sse = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        KC();
        overridePendingTransition(R.a.aRq, R.a.aQL);
        ap.vd().a(281, this);
        ap.vd().a(792, this);
        ap.yY();
        com.tencent.mm.u.c.a(this);
        com.tencent.mm.sdk.b.a.urY.b(this.pWv);
    }

    protected void onPause() {
        super.onPause();
        if (this.srP && ap.zb()) {
            com.tencent.mm.bd.a suVar = new su();
            suVar.tAG = 27;
            suVar.tAH = m.eV(m.xR()) ? 1 : 2;
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, suVar));
            this.srP = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.a.aQL, R.a.aRo);
        ap.vd().b(281, this);
        ap.vd().b(792, this);
        ap.yY();
        com.tencent.mm.u.c.b(this);
        com.tencent.mm.sdk.b.a.urY.c(this.pWv);
    }

    protected final void KC() {
        qP("");
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.aVV));
        }
        if (f.sl()) {
            this.srY = (ImageButton) findViewById(R.h.cSy);
            if (m.eV(m.xR())) {
                this.srV = true;
            } else {
                this.srV = false;
            }
            jf(this.srV);
            this.srY.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI ssf;

                {
                    this.ssf = r1;
                }

                public final void onClick(View view) {
                    this.ssf.srV = !this.ssf.srV;
                    this.ssf.jf(this.ssf.srV);
                    WebWXLogoutUI.b(this.ssf);
                }
            });
        } else {
            findViewById(R.h.bCy).setVisibility(8);
            this.srV = false;
        }
        this.srZ = (ImageView) findViewById(R.h.cGv);
        w.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + q.Je());
        if (q.Je()) {
            findViewById(R.h.ccs).setVisibility(8);
        } else {
            final Animator loadAnimator = AnimatorInflater.loadAnimator(this, R.b.aRW);
            loadAnimator.setTarget(findViewById(R.h.cSD));
            this.ssd = AnimatorInflater.loadAnimator(this, R.b.aRX);
            this.ssd.setTarget(findViewById(R.h.cSD));
            this.ssd.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ WebWXLogoutUI ssf;

                {
                    this.ssf = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    this.ssf.je(this.ssf.srW);
                }
            });
            this.srW = q.Jc();
            this.srX = (ImageButton) findViewById(R.h.cSB);
            je(this.srW);
            this.srX.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI ssf;

                public final void onClick(View view) {
                    if (this.ssf.srW) {
                        this.ssf.srX.setImageResource(R.k.dvX);
                    } else {
                        this.ssf.srX.setImageResource(R.k.dvW);
                    }
                    WebWXLogoutUI.e(this.ssf);
                    this.ssf.findViewById(R.h.cSD).setVisibility(0);
                    loadAnimator.start();
                }
            });
        }
        ImageButton imageButton = (ImageButton) findViewById(R.h.cSz);
        w.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + q.Jf());
        if (q.Jf()) {
            imageButton.setVisibility(8);
        } else {
            imageButton.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI ssf;

                {
                    this.ssf = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", "filehelper");
                    intent.putExtra("key_show_bottom_app_panel", true);
                    com.tencent.mm.plugin.webwx.a.imv.e(intent, this.ssf);
                    w.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
                    this.ssf.finish();
                }
            });
        }
        Button button = (Button) findViewById(R.h.cSJ);
        button.setText(q.hSm);
        button.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WebWXLogoutUI ssf;

            {
                this.ssf = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.WebWXLogoutUI", "logout webwx");
                WebWXLogoutUI.f(this.ssf);
            }
        });
        ((TextView) findViewById(R.h.cSK)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WebWXLogoutUI ssf;

            {
                this.ssf = r1;
            }

            public final void onClick(View view) {
                this.ssf.finish();
            }
        });
        Drawable drawable;
        Drawable drawable2;
        if (q.Ja() == 1) {
            drawable = getResources().getDrawable(R.k.dwd);
            drawable2 = getResources().getDrawable(R.k.dwe);
            if (!(drawable == null || drawable2 == null)) {
                this.ssa = drawable.getIntrinsicWidth();
                this.ssb = drawable2.getIntrinsicWidth();
            }
        } else if (q.Ja() == 2) {
            drawable = getResources().getDrawable(R.k.dvZ);
            drawable2 = getResources().getDrawable(R.k.dwb);
            if (!(drawable == null || drawable2 == null)) {
                this.ssa = drawable.getIntrinsicWidth();
                this.ssb = drawable2.getIntrinsicWidth();
            }
        }
        this.srZ.post(new Runnable(this) {
            final /* synthetic */ WebWXLogoutUI ssf;

            {
                this.ssf = r1;
            }

            public final void run() {
                this.ssf.ssc = WebWXLogoutUI.g(this.ssf);
                this.ssf.WS();
            }
        });
    }

    private void WS() {
        if (!bg.mA(q.hSe)) {
            ((TextView) findViewById(R.h.cGt)).setText(q.hSe);
            if (q.Ja() == 1) {
                if (!this.srV) {
                    this.srZ.setImageResource(R.k.dwe);
                    this.srZ.setPadding(this.ssb - this.ssa, this.ssc, 0, 0);
                    return;
                }
            } else if (q.Ja() == 2) {
                if (this.srV) {
                    ((TextView) findViewById(R.h.ctt)).setText(R.l.fmR);
                } else if (!f.sl()) {
                    ((TextView) findViewById(R.h.ctt)).setText("");
                }
                if (this.srW) {
                    ((TextView) findViewById(R.h.cGt)).setText(getString(R.l.fmH, new Object[]{"Mac"}));
                    this.srZ.setImageResource(R.k.dwa);
                    this.srZ.setPadding(0, this.ssc, 0, 0);
                    if (f.sl() && !this.srV) {
                        ((TextView) findViewById(R.h.ctt)).setText(R.l.fmG);
                        this.srZ.setImageResource(R.k.dwc);
                        this.srZ.setPadding(this.ssb - this.ssa, this.ssc, 0, 0);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.h.cGt)).setText(getString(R.l.fmJ, new Object[]{"Mac"}));
                this.srZ.setImageResource(R.k.dvZ);
                this.srZ.setPadding(0, this.ssc, 0, 0);
                if (f.sl() && !this.srV) {
                    ((TextView) findViewById(R.h.ctt)).setText(R.l.fmG);
                    this.srZ.setImageResource(R.k.dwb);
                    this.srZ.setPadding(this.ssb - this.ssa, this.ssc, 0, 0);
                    return;
                }
                return;
            } else if (q.Ja() == 3) {
                this.srZ.setImageResource(R.k.dvY);
                this.srZ.setPadding(0, this.ssc, 0, 0);
                return;
            }
            this.srZ.setImageResource(R.k.dwd);
            this.srZ.setPadding(0, this.ssc, 0, 0);
        }
    }

    private void je(boolean z) {
        if (this.srX == null) {
            return;
        }
        if (z) {
            this.srX.setImageResource(R.g.bmc);
            ((TextView) findViewById(R.h.cSC)).setText(R.l.fmS);
            return;
        }
        this.srX.setImageResource(R.g.bma);
        ((TextView) findViewById(R.h.cSC)).setText(R.l.cSB);
    }

    private void jf(boolean z) {
        if (this.srY == null) {
            return;
        }
        if (z) {
            this.srY.setImageResource(R.g.blZ);
        } else {
            this.srY.setImageResource(R.g.bmb);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.pjC != null) {
            this.pjC.dismiss();
            this.pjC = null;
        }
        if (kVar.getType() == 281) {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, R.l.fmP, 1).show();
            }
            finish();
        } else if (kVar.getType() == 792) {
            int i3 = ((com.tencent.mm.plugin.webwx.a.a) kVar).fJA;
            if (this.ssd != null) {
                this.ssd.start();
            }
            if (i == 0 && i2 == 0) {
                boolean z;
                if (i3 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.srW = z;
                q.bo(this.srW);
                WS();
                String str2 = "MicroMsg.WebWXLogoutUI";
                String str3 = "%s extDevice success";
                Object[] objArr = new Object[1];
                objArr[0] = this.srW ? "lock" : "unlock";
                w.d(str2, str3, objArr);
            } else if (i3 == 1) {
                Toast.makeText(this, R.l.fmI, 0).show();
            } else {
                Toast.makeText(this, R.l.fmT, 0).show();
            }
        }
    }

    public final void yP() {
        ap.yY();
        if (!com.tencent.mm.u.c.wM()) {
            finish();
        } else if (q.Jc() && !this.srW) {
            w.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
            this.srW = true;
            je(this.srW);
            WS();
        }
    }
}
