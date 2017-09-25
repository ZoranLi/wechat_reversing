package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kx;
import com.tencent.mm.e.a.no;
import com.tencent.mm.e.a.np;
import com.tencent.mm.e.a.nr;
import com.tencent.mm.network.m;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.d.g;
import java.io.IOException;
import java.util.List;

@a(3)
public class BaseScanUI extends MMActivity implements AutoFocusCallback, PreviewCallback, SurfaceTextureListener, b {
    private int fFH = 0;
    private final Object hvG = new Object();
    private boolean lBw = false;
    private boolean nVd = false;
    private int[] nkt = new int[5];
    private boolean oIa = true;
    private SelectScanModePanel oXA;
    private ScanMaskView oXB = null;
    private ScannerFlashSwitcher oXC;
    private boolean oXD = false;
    private boolean oXE = false;
    private boolean oXF = true;
    private i.a oXG;
    private int oXH;
    private int oXI;
    private int oXJ;
    private int oXK;
    private boolean oXL = true;
    private Rect oXM = new Rect();
    private TextView oXN;
    private View oXO;
    private boolean oXP = false;
    private boolean oXQ = true;
    private boolean oXR = false;
    private boolean oXS = false;
    private e oXT = null;
    private TranslateAnimation oXU;
    private ImageView oXV;
    private i oXW;
    private int oXX = 0;
    private boolean oXY = false;
    private boolean oXZ = false;
    private long oXq = 1000;
    private final long oXr = 150;
    private MMTextureView oXs;
    private SurfaceTexture oXt;
    private boolean oXu = false;
    private LinearLayout oXv;
    private TextView oXw;
    private FrameLayout oXx;
    private h oXy;
    private Point oXz;
    private long oYa;
    private long oYb;
    private m oYc = new m.a(this) {
        final /* synthetic */ BaseScanUI oYp;

        {
            this.oYp = r1;
        }

        public final void cU(final int i) {
            if (this.oYp.oXQ) {
                new ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 oYr;

                    public final void run() {
                        if (ap.vd().BR() == 6 || ap.vd().BR() == 4) {
                            if (!this.oYr.oYp.oXF) {
                                if (!(this.oYr.oYp.oXN == null || this.oYr.oYp.oXO == null)) {
                                    this.oYr.oYp.oXN.setVisibility(8);
                                    this.oYr.oYp.oXO.setVisibility(8);
                                }
                                this.oYr.oYp.oXF = true;
                                this.oYr.oYp.oXE = false;
                                this.oYr.oYp.c(true, 0);
                            } else {
                                return;
                            }
                        } else if (this.oYr.oYp.oXF) {
                            if (!(this.oYr.oYp.oXN == null || this.oYr.oYp.oXO == null)) {
                                this.oYr.oYp.oXN.setText(R.l.eOY);
                                this.oYr.oYp.oXO.setVisibility(0);
                                this.oYr.oYp.oXN.setVisibility(0);
                            }
                            if (this.oYr.oYp.oXy != null && this.oYr.oYp.oXy.pdQ) {
                                this.oYr.oYp.oXy.aZg();
                            }
                            if (this.oYr.oYp.oXC != null) {
                                this.oYr.oYp.oXC.aYT();
                                this.oYr.oYp.oXC.hide();
                            }
                            this.oYr.oYp.oXF = false;
                            this.oYr.oYp.oXE = true;
                            this.oYr.oYp.aYq();
                        } else {
                            return;
                        }
                        if (this.oYr.oYp.oXW != null) {
                            this.oYr.oYp.oXW.aYg();
                        }
                    }
                });
            }
        }
    };
    protected ae oYd = new ae(this) {
        final /* synthetic */ BaseScanUI oYp;

        {
            this.oYp = r1;
        }

        public final void handleMessage(Message message) {
            if (message != null && message.what == 1 && this.oYp.oXV != null && this.oYp.oXU != null) {
                if (this.oYp.oXQ && !this.oYp.oXF) {
                    return;
                }
                if (this.oYp.oXW == null || this.oYp.oXW.aYj() <= 0) {
                    w.w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
                    this.oYp.aYq();
                    return;
                }
                this.oYp.oXV.setVisibility(0);
                this.oYp.oXU.setRepeatCount(-1);
                this.oYp.oXU.setDuration(2600);
                this.oYp.oXV.startAnimation(this.oYp.oXU);
            }
        }
    };
    private final int oYe = 2600;
    protected ae oYf = new ae(this) {
        final /* synthetic */ BaseScanUI oYp;

        {
            this.oYp = r1;
        }

        public final void handleMessage(Message message) {
            synchronized (this.oYp.hvG) {
                h f = this.oYp.oXy;
            }
            if (message == null) {
                w.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
            } else if (this.oYp.nVd) {
                w.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", new Object[]{Integer.valueOf(message.what)});
            } else {
                this.oYp.nVd = true;
                if (this.oYp.oXW != null) {
                    if (this.oYp.oXX == message.what) {
                        this.oYp.nVd = false;
                        return;
                    }
                    this.oYp.oXW.onPause();
                    if (this.oYp.oXW.aYh() != null) {
                        this.oYp.oXW.aYh().aKx();
                    }
                    this.oYp.oXW = null;
                }
                if (!this.oYp.oXQ || this.oYp.oXF) {
                    this.oYp.oXE = false;
                } else {
                    this.oYp.oXE = true;
                }
                if (!this.oYp.rh() || message.what == 1) {
                    if (f != null) {
                        f.sj(message.what);
                    }
                    this.oYp.oXX = message.what;
                    switch (message.what) {
                        case 1:
                            if (!this.oYp.oXP) {
                                this.oYp.zi(R.l.eOG);
                                this.oYp.oXW = new p(this.oYp, this.oYp.oXz, this.oYp.fFH, 0);
                                break;
                            }
                            this.oYp.zi(R.l.eOF);
                            this.oYp.oXW = new p(this.oYp, this.oYp.oXz, this.oYp.fFH, 1);
                            break;
                        case 2:
                            this.oYp.qP(p.do(p.pev, this.oYp.getString(R.l.eOO)));
                            this.oYp.oXW = new k(this.oYp, this.oYp.oXz);
                            break;
                        case 3:
                            this.oYp.zi(R.l.eOD);
                            this.oYp.oXW = new o(this.oYp, this.oYp.oXz);
                            break;
                        case 4:
                            this.oYp.zi(R.l.eOG);
                            this.oYp.oXW = new p(this.oYp, this.oYp.oXz, this.oYp.fFH, 2);
                            break;
                        case 5:
                            this.oYp.zi(R.l.eOH);
                            this.oYp.oXW = new q(this.oYp, this.oYp.oXz);
                            boolean a = com.tencent.mm.pluginsdk.i.a.a(this.oYp, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
                            w.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ()});
                            break;
                        case 8:
                            this.oYp.zi(R.l.eOF);
                            this.oYp.oXW = new p(this.oYp, this.oYp.oXz, this.oYp.fFH, 1);
                            break;
                    }
                    if (f != null && f.isOpen() && f.lwK) {
                        f.aZd();
                        f.sl(1);
                    }
                    l.oWo.reset();
                    this.oYp.aYp();
                    this.oYp.aYx();
                    this.oYp.nVd = false;
                    return;
                }
                Toast.makeText(this.oYp, R.l.eOx, 0).show();
                this.oYp.oXA.sg(1);
                this.oYp.nVd = false;
            }
        }
    };
    protected ae oYg = new ae(this) {
        final /* synthetic */ BaseScanUI oYp;

        {
            this.oYp = r1;
        }

        public final void handleMessage(Message message) {
            if (this.oYp.oXy != null && this.oYp.oXu) {
                this.oYp.oXy.a(this.oYp);
            }
        }
    };
    private boolean oYh = false;
    private c oYi = new c<nr>(this) {
        final /* synthetic */ BaseScanUI oYp;

        {
            this.oYp = r2;
            this.usg = nr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nr nrVar = (nr) bVar;
            if (nrVar instanceof nr) {
                w.i("MicroMsg.scanner.BaseScanUI", "autoFocusControlEventListener, isAutoFocus: %s", new Object[]{Boolean.valueOf(nrVar.fUN.fUO)});
                if (!nrVar.fUN.fUO) {
                    this.oYp.cY(1800);
                    this.oYp.cX(0);
                    this.oYp.oYh = false;
                } else if (!this.oYp.oYh) {
                    this.oYp.oYh = true;
                    this.oYp.oYg.removeMessages(0);
                    if (!(this.oYp.oXX == 3 || this.oYp.oXX == 2 || this.oYp.oXy == null || !this.oYp.oXy.lwK)) {
                        this.oYp.cY(this.oYp.oXq);
                    }
                }
            }
            return false;
        }
    };
    private c oYj = new c<no>(this) {
        final /* synthetic */ BaseScanUI oYp;

        {
            this.oYp = r2;
            this.usg = no.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            no noVar = (no) bVar;
            if (this.oYp.oXy != null && this.oYp.oXy.lwK && this.oYp.oXF) {
                if (noVar.fUI.fUJ) {
                    if (!(this.oYp.oXC == null || this.oYp.oXC.isShown())) {
                        ScannerFlashSwitcher g = this.oYp.oXC;
                        w.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", new Object[]{Boolean.valueOf(g.pcd)});
                        if (g.pcd) {
                            g.pcb.setAlpha(0.0f);
                            g.pcc.setAlpha(0.0f);
                            g.setVisibility(0);
                            g.pcc.animate().alpha(1.0f).setListener(null).setDuration(500);
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                            ofFloat.addUpdateListener(new AnimatorUpdateListener(g) {
                                final /* synthetic */ ScannerFlashSwitcher pce;

                                {
                                    this.pce = r1;
                                }

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    this.pce.pcb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            });
                            ofFloat.setRepeatCount(3);
                            ofFloat.setRepeatMode(2);
                            ofFloat.setDuration(500);
                            ofFloat.addListener(new AnimatorListenerAdapter(g) {
                                final /* synthetic */ ScannerFlashSwitcher pce;

                                {
                                    this.pce = r1;
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.pce.pcb.setAlpha(1.0f);
                                }
                            });
                            ofFloat.start();
                            g.pcd = false;
                        } else {
                            g.setVisibility(0);
                            g.pcc.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                            g.pcb.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                        }
                        g.setEnabled(true);
                        l.oWo.oWC = 1;
                        if (this.oYp.oXW != null) {
                            this.oYp.oXW.gL(false);
                        }
                    }
                } else if (!(this.oYp.oXC == null || this.oYp.oXy.pdQ)) {
                    this.oYp.oXC.hide();
                    if (this.oYp.oXW != null) {
                        this.oYp.oXW.gL(true);
                    }
                }
            }
            return false;
        }
    };
    protected ae oYk = new ae(this) {
        final /* synthetic */ BaseScanUI oYp;

        {
            this.oYp = r1;
        }

        public final void handleMessage(Message message) {
            if (this.oYp.oXy != null && this.oYp.oXu && !this.oYp.oXE && message.what == 0) {
                this.oYp.oYb = System.currentTimeMillis();
                h f = this.oYp.oXy;
                AutoFocusCallback autoFocusCallback = this.oYp;
                if (f.gPJ != null && f.lwK) {
                    try {
                        f.k(f.pdN);
                        f.gPJ.autoFocus(autoFocusCallback);
                    } catch (RuntimeException e) {
                        w.w("MicroMsg.scanner.ScanCamera", "autoFocus() " + e.getMessage());
                    }
                }
            }
        }
    };
    private long oYl = 0;
    protected final int oYm = 0;
    protected final int oYn = 1;
    protected final int oYo = 2;
    private WakeLock wakeLock = null;

    public final /* bridge */ /* synthetic */ Activity aYD() {
        return this.uSU.uTo;
    }

    static /* synthetic */ void i(BaseScanUI baseScanUI) {
        w.d("MicroMsg.scanner.BaseScanUI", "backBtn onClick");
        baseScanUI.oXE = true;
        baseScanUI.aYC();
        baseScanUI.overridePendingTransition(0, 0);
    }

    protected final int getLayoutId() {
        if (rh()) {
            w.d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
            return R.i.dmS;
        }
        w.d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
        return R.i.dmR;
    }

    protected final int Ol() {
        if (rh()) {
            w.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
            return 0;
        }
        w.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
        return 1;
    }

    public void onCreate(Bundle bundle) {
        this.oXX = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        super.onCreate(bundle);
        com.tencent.mm.ui.l.et(this);
        getWindow().addFlags(2097280);
        if (ap.vd().BR() == 6 || ap.vd().BR() == 4) {
            this.oXF = true;
        } else {
            this.oXF = false;
        }
        if (7 == this.oXX || 11 == this.oXX) {
            this.oXQ = false;
        }
        com.tencent.mm.sdk.b.a.urY.b(this.oYi);
        com.tencent.mm.sdk.b.a.urY.b(this.oYj);
        KC();
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.pdW;
        try {
            scanCameraLightDetector.peb = com.tencent.mm.sdk.f.e.Qu("ScanCameraLightDetector_detectThread");
            scanCameraLightDetector.peb.start();
            scanCameraLightDetector.handler = new com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.AnonymousClass1(scanCameraLightDetector, scanCameraLightDetector.peb.getLooper());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "start error: %s", new Object[]{e.getMessage()});
        }
        w.i("MicroMsg.ScanCameraLightDetector", "start, sensorManager: %s, lightSensor: %s, isRegister: %s", new Object[]{scanCameraLightDetector.hVM, scanCameraLightDetector.pdY, Boolean.valueOf(scanCameraLightDetector.pdZ)});
    }

    protected final void KC() {
        Button button;
        if (rh()) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.uSU.bQg();
            w.d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
        }
        this.oXO = findViewById(R.h.czU);
        this.oXN = (TextView) findViewById(R.h.czV);
        this.oXv = (LinearLayout) findViewById(R.h.czZ);
        this.oXw = (TextView) findViewById(R.h.cAa);
        this.oXx = (FrameLayout) findViewById(R.h.czQ);
        this.oXC = (ScannerFlashSwitcher) findViewById(R.h.cAd);
        this.oXs = (MMTextureView) findViewById(R.h.csr);
        this.oXs.setOpaque(false);
        this.oXs.setSurfaceTextureListener(this);
        if (7 == this.oXX || 9 == this.oXX || 10 == this.oXX || 11 == this.oXX) {
            button = (Button) findViewById(R.h.czP);
            button.setVisibility(0);
            findViewById(R.h.czR).setVisibility(8);
            findViewById(R.h.cAc).setVisibility(8);
            if (9 == this.oXX || 10 == this.oXX) {
                LayoutParams layoutParams = button.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    button.setLayoutParams(marginLayoutParams);
                }
            }
        } else {
            button = (Button) findViewById(R.h.czO);
        }
        if (button != null) {
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BaseScanUI oYp;

                {
                    this.oYp = r1;
                }

                public final void onClick(View view) {
                    BaseScanUI.i(this.oYp);
                }
            });
        } else {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BaseScanUI oYp;

                {
                    this.oYp = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BaseScanUI.i(this.oYp);
                    return false;
                }
            });
        }
        this.oXV = (ImageView) findViewById(R.h.czT);
        this.fFH = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        this.oXA = (SelectScanModePanel) findViewById(R.h.czX);
        this.oXx.setVisibility(0);
        if (!(7 == this.oXX || 9 == this.oXX || 10 == this.oXX || 11 == this.oXX || !rh())) {
            this.oXX = 1;
            this.oXP = true;
        }
        aYw();
        SE(null);
        if (this.oXX == 2) {
            this.oXW = new k(this, this.oXz);
            aYp();
            qP(p.do(p.pev, getString(R.l.eOO)));
        } else if (this.oXX == 5) {
            this.oXW = new q(this, this.oXz);
            aYp();
            zi(R.l.eOH);
            w.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)), bg.bJZ()});
        } else if (this.oXX == 3) {
            this.oXW = new o(this, this.oXz);
            aYp();
            zi(R.l.eOD);
        } else if (this.oXX == 4 && !rh()) {
            this.oXW = new p(this, this.oXz, this.fFH, 2);
            ((p) this.oXW).pbG = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            aYp();
            this.oXA.setVisibility(8);
            zi(R.l.eOI);
        } else if (this.oXX == 8) {
            this.oXW = new p(this, this.oXz, this.fFH, 1);
            ((p) this.oXW).pbG = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            aYp();
            this.oXA.setVisibility(8);
            zi(R.l.eOF);
        } else if (7 == this.oXX) {
            boolean z;
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.oXW = new j(this, this.oXz, r0, getWindowManager().getDefaultDisplay().getRotation());
            j jVar = (j) this.oXW;
            if (getIntent() == null || !getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false)) {
                z = false;
            } else {
                z = true;
            }
            jVar.paV = z;
            aYp();
            zi(R.l.eOy);
            this.oXA.setVisibility(8);
        } else if (9 == this.oXX) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.oXW = new m(this, this.oXz, r0, getWindowManager().getDefaultDisplay().getRotation());
            aYp();
            zi(R.l.eOA);
            this.oXA.setVisibility(8);
        } else if (10 == this.oXX) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.oXW = new l(this, this.oXz, r0, getWindowManager().getDefaultDisplay().getRotation());
            aYp();
            zi(R.l.eOz);
            this.oXA.setVisibility(8);
        } else if (11 == this.oXX) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.oXW = new n(this, this.oXz, r0, getWindowManager().getDefaultDisplay().getRotation());
            aYp();
            zi(R.l.eOB);
            this.oXA.setVisibility(8);
        } else {
            this.oXX = 1;
            this.oXW = new p(this, this.oXz, this.fFH, rh() ? 1 : 0);
            ((p) this.oXW).pbG = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            aYp();
            if (com.tencent.mm.ai.b.Ho()) {
                this.oXP = true;
                this.oXA.setVisibility(8);
            } else if (getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false)) {
                this.oXP = false;
                this.oXA.setVisibility(8);
            }
            if (this.oXP) {
                zi(R.l.eOF);
            } else {
                zi(R.l.eOG);
            }
        }
        this.oXL = this.oXW.aYl();
        this.oXV.setBackgroundResource(this.oXL ? R.g.biJ : R.g.biK);
        int i = this.oXX;
        if (!(7 == this.oXX || 9 == this.oXX || 10 == this.oXX || 11 == this.oXX)) {
            this.oXA.pcD = new SelectScanModePanel.a(this) {
                final /* synthetic */ BaseScanUI oYp;

                {
                    this.oYp = r1;
                }

                public final void sf(int i) {
                    this.oYp.se(i);
                }
            };
            this.oXA.sg(i);
        }
        if (this.oXy != null) {
            this.oXy.sj(this.oXX);
        }
        w.i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", new Object[]{Integer.valueOf(this.fFH), Integer.valueOf(this.oXX)});
    }

    private void aYp() {
        if (this.oXW != null) {
            this.oXx.removeAllViews();
            View.inflate(this, this.oXW.aYi(), this.oXx);
            this.oXW.cl(this.oXx.getChildAt(0));
            this.oXW.aYk();
            i iVar = this.oXW;
            View view = this.oXx;
            iVar.nlD = new GestureDetector(new SimpleOnGestureListener(iVar) {
                final /* synthetic */ i paR;

                {
                    this.paR = r1;
                }

                public final boolean onDoubleTap(MotionEvent motionEvent) {
                    w.d("MicroMsg.scanner.ScanMode", "double click,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(motionEvent.getActionIndex()), Float.valueOf(motionEvent.getX(motionEvent.getActionIndex())), Float.valueOf(motionEvent.getY(motionEvent.getActionIndex()))});
                    this.paR.paN.M(5, 2, 100);
                    return true;
                }
            });
            view.setOnTouchListener(new OnTouchListener(iVar) {
                final /* synthetic */ i paR;
                private float paS;
                private float paT = 400.0f;

                {
                    this.paR = r2;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    int actionIndex = motionEvent.getActionIndex();
                    w.d("MicroMsg.scanner.ScanMode", "pointIndex:%d", new Object[]{Integer.valueOf(actionIndex)});
                    switch (actionMasked) {
                        case 0:
                            w.d("MicroMsg.scanner.ScanMode", "first down,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY())});
                            break;
                        case 1:
                            w.d("MicroMsg.scanner.ScanMode", "last up,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY())});
                            if (motionEvent.getPointerCount() == 2) {
                                this.paS = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                                break;
                            }
                            break;
                        case 2:
                            if (motionEvent.getPointerCount() == 2) {
                                w.d("MicroMsg.scanner.ScanMode", "move,pointer:0,x:%f,y:%f", new Object[]{Float.valueOf(motionEvent.getX(0)), Float.valueOf(motionEvent.getY(0))});
                                w.d("MicroMsg.scanner.ScanMode", "move,pointer:1,x:%f,y:%f", new Object[]{Float.valueOf(motionEvent.getX(1)), Float.valueOf(motionEvent.getY(1))});
                                float pow = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                                w.d("MicroMsg.scanner.ScanMode", "distance:%f,lastDistance:%f,min move:%f", new Object[]{Float.valueOf(pow), Float.valueOf(this.paS), Float.valueOf(this.paT)});
                                if (Math.abs(pow - this.paS) > this.paT) {
                                    if (this.paR.paP) {
                                        this.paR.paP = false;
                                    }
                                    if (pow - this.paS > 0.0f) {
                                        this.paR.paN.M(2, 2, 100);
                                    } else {
                                        this.paR.paN.M(3, 2, 100);
                                    }
                                    this.paS = pow;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            w.d("MicroMsg.scanner.ScanMode", "down,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex))});
                            if (motionEvent.getPointerCount() == 2) {
                                this.paS = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                                break;
                            }
                            break;
                        case 6:
                            w.d("MicroMsg.scanner.ScanMode", "up,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex))});
                            if (motionEvent.getPointerCount() == 2) {
                                this.paS = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                                break;
                            }
                            break;
                    }
                    this.paR.nlD.onTouchEvent(motionEvent);
                    return true;
                }
            });
            if (this.oXu) {
                aYv();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        w.d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
        this.oXE = true;
        aYC();
        overridePendingTransition(0, 0);
        return true;
    }

    protected void onResume() {
        super.onResume();
        if (!this.oXY) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            this.oXY = true;
        }
        if (this.oIa) {
            w.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, null, null))});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, null, null)) {
                aVK();
            } else {
                return;
            }
        }
        this.oXZ = false;
        if (!this.oXE) {
            if (this.oXX == 1 || this.oXX == 8 || this.oXX == 4) {
                l.oWo.reset();
                l.oWo.sd(l.oWl);
            }
        }
    }

    private void aVK() {
        boolean z = true;
        if (com.tencent.mm.compatible.e.b.rV()) {
            if (!this.oXQ || this.oXF) {
                this.oXE = false;
                c(false, 0);
            } else {
                this.oXE = true;
                aYq();
            }
            this.oXS = false;
            synchronized (this.hvG) {
                w.d("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
                int i = this.oXX;
                if (!(7 == this.oXX || 9 == this.oXX || 10 == this.oXX || 11 == this.oXX)) {
                    z = false;
                }
                this.oXy = new h(this, i, z);
                aYs();
            }
            if (this.oXW != null) {
                if (this.oXW.aYh() != null) {
                    this.oXW.aYh().aYV();
                }
                this.oXW.onResume();
            }
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
                this.wakeLock.acquire();
            }
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
            if (this.oXQ) {
                ap.a(this.oYc);
            }
            if (this.oXT != null) {
                this.oXT.onResume();
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.g.a(this, getString(R.l.dIL), getString(R.l.dHL), getString(R.l.dHM), true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ BaseScanUI oYp;

            {
                this.oYp = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.compatible.e.b.az(this.oYp);
                this.oYp.finish();
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.scanner.BaseScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    aVK();
                    return;
                }
                this.oIa = false;
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BaseScanUI oYp;

                    {
                        this.oYp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oYp.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.oYp.oIa = true;
                        this.oYp.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BaseScanUI oYp;

                    {
                        this.oYp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oYp.oIa = true;
                        this.oYp.finish();
                    }
                });
                return;
            case 64:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BaseScanUI oYp;

                        {
                            this.oYp = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oYp.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        w.i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", new Object[]{this.oXW, this.oXT});
        this.oXE = true;
        if (this.oXW != null) {
            this.oXW.onPause();
            if (this.oXW.aYh() != null) {
                this.oXW.aYh().aKx();
            }
        }
        aYt();
        if (this.oXC != null) {
            this.oXC.aYT();
            this.oXC.hide();
        }
        if (this.wakeLock != null && this.wakeLock.isHeld()) {
            this.wakeLock.release();
            this.wakeLock = null;
        }
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        if (this.oXQ) {
            ap.b(this.oYc);
        }
        if (this.oXT != null) {
            this.oXT.onPause();
        }
        if (this.oXX == 1 || this.oXX == 8 || this.oXX == 4) {
            l.oWo.aEK();
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.oYa);
            w.i("MicroMsg.scanner.BaseScanUI", "scan cost time:" + currentTimeMillis);
            if (l.oWo.oWq) {
                this.nkt[0] = 1;
            } else {
                this.nkt[0] = 0;
            }
            this.nkt[1] = currentTimeMillis;
            this.nkt[2] = 0;
            this.nkt[3] = l.oWo.oWr;
            com.tencent.mm.plugin.report.service.g.oUh.i(14176, new Object[]{Integer.valueOf(this.nkt[0]), Integer.valueOf(this.nkt[1]), Integer.valueOf(this.nkt[2]), Integer.valueOf(this.nkt[3]), Integer.valueOf(this.nkt[4])});
        }
        super.onPause();
    }

    protected void onDestroy() {
        w.i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
        if (this.oXB != null) {
            this.oXB.aYL();
        }
        if (this.oXs != null) {
            this.oXs.setSurfaceTextureListener(null);
        }
        com.tencent.mm.sdk.b.a.urY.c(this.oYi);
        com.tencent.mm.sdk.b.a.urY.c(this.oYj);
        ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.pdW;
        w.i("MicroMsg.ScanCameraLightDetector", "stop, isRegister: %s, sensorManager: %s, lightSensor: %s", new Object[]{Boolean.valueOf(scanCameraLightDetector.pdZ), scanCameraLightDetector.hVM, scanCameraLightDetector.pdY});
        try {
            scanCameraLightDetector.pdX = -1;
            if (scanCameraLightDetector.peb != null) {
                scanCameraLightDetector.peb.quit();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e, "stop error: %s", new Object[]{e.getMessage()});
        }
        super.onDestroy();
    }

    private void c(boolean z, long j) {
        if (this.oXJ >= 0 && this.oXK > 0) {
            if (this.oXW == null || this.oXW.aYm()) {
                if (z) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oXV.getLayoutParams();
                    if (this.oXL) {
                        layoutParams.width = this.oXH;
                        layoutParams.gravity = 1;
                    } else {
                        layoutParams.height = this.oXI;
                        layoutParams.gravity = 48;
                        layoutParams.topMargin = this.oXM.top;
                    }
                    this.oXV.setLayoutParams(layoutParams);
                    this.oXV.invalidate();
                    this.oXV.setVisibility(0);
                    if (this.oXL) {
                        this.oXU = new TranslateAnimation(0.0f, 0.0f, (float) this.oXJ, (float) this.oXK);
                    } else {
                        this.oXU = new TranslateAnimation((float) this.oXJ, (float) this.oXK, 0.0f, 0.0f);
                    }
                }
                this.oYd.removeMessages(1);
                if (j <= 0) {
                    this.oYd.sendEmptyMessage(1);
                    return;
                }
                aYq();
                this.oYd.sendEmptyMessageDelayed(1, j);
            }
        }
    }

    public final void aYq() {
        if (this.oXV != null && this.oXU != null) {
            this.oXV.setVisibility(8);
            this.oXV.clearAnimation();
            this.oXV.setAnimation(null);
        }
    }

    public final void aYr() {
        if (!this.oXE) {
            aq.B(this, R.l.eHm);
        }
    }

    private void aYs() {
        af.f(new Runnable(this) {
            final /* synthetic */ BaseScanUI oYp;

            {
                this.oYp = r1;
            }

            public final void run() {
                try {
                    if (this.oYp.oXy == null) {
                        w.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
                    } else if (!this.oYp.oXR) {
                        this.oYp.oXS = true;
                    } else if (this.oYp.oXt == null) {
                        w.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in openCamera");
                    } else {
                        if (this.oYp.oXy.isOpen()) {
                            w.d("MicroMsg.scanner.BaseScanUI", "camera already open");
                        } else {
                            synchronized (this.oYp.hvG) {
                                h f = this.oYp.oXy;
                                SurfaceTexture n = this.oYp.oXt;
                                if (f.lwK) {
                                    w.w("MicroMsg.scanner.ScanCamera", "in open(), previewing");
                                    f.release();
                                }
                                int rg = com.tencent.mm.compatible.d.c.rg();
                                long NA = bg.NA();
                                com.tencent.mm.compatible.d.c.a.a n2 = com.tencent.mm.compatible.d.c.n(f.fPi, rg);
                                if (n2 == null) {
                                    w.e("MicroMsg.scanner.ScanCamera", "in open(), openCameraRes == null");
                                    throw new IOException();
                                }
                                f.pdQ = false;
                                f.pdR = -1;
                                w.d("MicroMsg.scanner.ScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[]{Integer.valueOf(rg), Long.valueOf(bg.aB(NA))});
                                f.lwP = n2.gPG;
                                f.lwO = n2.gPG % 180 != 0;
                                f.gPJ = n2.gPJ;
                                if (f.gPJ == null) {
                                    w.e("MicroMsg.scanner.ScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[]{Boolean.valueOf(f.lwO)});
                                    throw new IOException();
                                }
                                boolean z;
                                f.gPJ.setPreviewTexture(n);
                                Parameters parameters = f.gPJ.getParameters();
                                Point point = f.lwM;
                                Point point2 = f.lwN;
                                if (9 == f.pdL || 10 == f.pdL || 7 == f.pdL || 11 == f.pdL) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                f.lwL = h.a(parameters, point, point2, z);
                                w.d("MicroMsg.scanner.ScanCamera", "getCameraResolution: " + f.lwM + " camera:" + f.lwL);
                                parameters.setPreviewSize(f.lwL.x, f.lwL.y);
                                f.aZd();
                                try {
                                    List supportedPreviewFormats;
                                    int i;
                                    boolean z2;
                                    if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                                        w.i("MicroMsg.scanner.ScanCamera", "camera not support FOCUS_MODE_AUTO");
                                        supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                                        w.i("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat:" + supportedPreviewFormats);
                                        if (supportedPreviewFormats.contains(Integer.valueOf(17))) {
                                            z = false;
                                            i = 1;
                                        } else if (supportedPreviewFormats.contains(Integer.valueOf(842094169))) {
                                            z = false;
                                            z2 = false;
                                        } else {
                                            z = true;
                                            z2 = false;
                                        }
                                        if (i != 0) {
                                            w.i("MicroMsg.scanner.ScanCamera", "Preview support NV21");
                                            parameters.setPreviewFormat(17);
                                        } else if (z) {
                                            w.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21 and YV12. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                                            parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                                        } else {
                                            w.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21, but support YV12");
                                            parameters.setPreviewFormat(842094169);
                                        }
                                        f.gPJ.setParameters(parameters);
                                        w.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                                    } else {
                                        w.i("MicroMsg.scanner.ScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
                                        parameters.setFocusMode("auto");
                                        supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                                        w.i("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat:" + supportedPreviewFormats);
                                        if (supportedPreviewFormats.contains(Integer.valueOf(17))) {
                                            z = false;
                                            i = 1;
                                        } else if (supportedPreviewFormats.contains(Integer.valueOf(842094169))) {
                                            z = false;
                                            z2 = false;
                                        } else {
                                            z = true;
                                            z2 = false;
                                        }
                                        if (i != 0) {
                                            w.i("MicroMsg.scanner.ScanCamera", "Preview support NV21");
                                            parameters.setPreviewFormat(17);
                                        } else if (z) {
                                            w.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21 and YV12. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                                            parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                                        } else {
                                            w.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21, but support YV12");
                                            parameters.setPreviewFormat(842094169);
                                        }
                                        f.gPJ.setParameters(parameters);
                                        w.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                                    }
                                } catch (Exception e) {
                                    w.e("MicroMsg.scanner.ScanCamera", "set focus mode error: %s", new Object[]{e.getMessage()});
                                }
                            }
                        }
                        this.oYp.oXu = true;
                        this.oYp.oXS = false;
                        this.oYp.aYv();
                    }
                } catch (Throwable e2) {
                    w.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", new Object[]{e2.toString()});
                    w.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e2, "", new Object[0]);
                    this.oYp.aYu();
                }
            }
        }, 25);
        af.f(new Runnable(this) {
            final /* synthetic */ BaseScanUI oYp;

            {
                this.oYp = r1;
            }

            public final void run() {
                try {
                    if (this.oYp.oXy == null) {
                        w.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in startPreview");
                    } else if (!this.oYp.oXy.isOpen()) {
                        w.w("MicroMsg.scanner.BaseScanUI", "camera not open");
                    } else if (this.oYp.oXt == null) {
                        w.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in startPreview");
                    } else {
                        w.d("MicroMsg.scanner.BaseScanUI", "camera startPreview.");
                        synchronized (this.oYp.hvG) {
                            this.oYp.oXy.c(this.oYp.oXt);
                            w.d("MicroMsg.scanner.BaseScanUI", "camera startPreview. done");
                            this.oYp.oYa = System.currentTimeMillis();
                        }
                        if (this.oYp.oXy != null && this.oYp.oXy.isOpen() && this.oYp.oXy.lwK) {
                            this.oYp.oXy.sl(1);
                        }
                        this.oYp.cY(0);
                    }
                } catch (Throwable e) {
                    w.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.startPreview(), [%s]", new Object[]{e.toString()});
                    w.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
                    this.oYp.aYu();
                }
            }
        }, 50);
    }

    private void aYt() {
        this.lBw = true;
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ BaseScanUI oYp;

            {
                this.oYp = r1;
            }

            public final void run() {
                if (this.oYp.oXy != null) {
                    synchronized (this.oYp.hvG) {
                        if (this.oYp.lBw && this.oYp.oXy != null) {
                            w.d("MicroMsg.scanner.BaseScanUI", "closeCamera");
                            this.oYp.oXy.release();
                            this.oYp.oXy = null;
                            this.oYp.lBw = false;
                            w.d("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
                        }
                    }
                }
            }
        }, "BaseScanUI_closeCamera");
    }

    private void aYu() {
        if (!this.oXD) {
            this.oXD = true;
            gH(true);
            com.tencent.mm.sdk.b.b kxVar = new kx();
            kxVar.fRD.type = 2;
            com.tencent.mm.sdk.b.a.urY.m(kxVar);
            if (kxVar.fRE.fRC) {
                w.i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
                this.oXE = true;
                aYt();
                aYC();
                overridePendingTransition(0, 0);
                return;
            }
            com.tencent.mm.ui.base.h a = com.tencent.mm.ui.base.g.a(this, getString(R.l.eOZ), getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ BaseScanUI oYp;

                {
                    this.oYp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oYp.oXE = true;
                    this.oYp.aYt();
                    this.oYp.aYC();
                    this.oYp.overridePendingTransition(0, 0);
                }
            });
            if (a == null) {
                w.d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
                return;
            }
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void aYv() {
        try {
            aYw();
            if (this.oXW == null) {
                w.d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
            } else if (this.oXy != null) {
                this.oXW.c(this.oXz);
                this.oXy.lwN = this.oXz;
                this.oXW.d(this.oXy.lwL);
                h hVar = this.oXy;
                Rect r = this.oXW.r(true, rh());
                int i = this.oXX;
                hVar.lwQ = false;
                hVar.pdP = null;
                hVar.pdN = new Rect();
                if (!hVar.lwO || hVar.pdM) {
                    hVar.pdN.left = (r.left * hVar.lwL.x) / hVar.lwN.x;
                    hVar.pdN.right = (r.right * hVar.lwL.x) / hVar.lwN.x;
                    hVar.pdN.top = (r.top * hVar.lwL.y) / hVar.lwN.y;
                    hVar.pdN.bottom = (r.bottom * hVar.lwL.y) / hVar.lwN.y;
                    if (hVar.pdN.bottom > hVar.lwL.y) {
                        hVar.pdN.bottom = hVar.lwL.y;
                    }
                    if (hVar.pdN.right > hVar.lwL.x) {
                        hVar.pdN.right = hVar.lwL.x;
                    }
                } else {
                    w.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + hVar.lwO + " needLandscape = " + hVar.pdM);
                    hVar.pdN.top = (r.left * hVar.lwL.y) / hVar.lwN.x;
                    hVar.pdN.bottom = (r.right * hVar.lwL.y) / hVar.lwN.x;
                    hVar.pdN.left = (r.top * hVar.lwL.x) / hVar.lwN.y;
                    hVar.pdN.right = (r.bottom * hVar.lwL.x) / hVar.lwN.y;
                    if (hVar.pdN.bottom > hVar.lwL.y) {
                        hVar.pdN.bottom = hVar.lwL.y;
                    }
                    if (hVar.pdN.right > hVar.lwL.x) {
                        hVar.pdN.right = hVar.lwL.x;
                    }
                }
                if (7 == i || 11 == i) {
                    if (!hVar.lwO || hVar.pdM) {
                        if ((((double) hVar.pdN.width()) * 1.0d) / ((double) hVar.pdN.height()) < 1.5859999656677246d) {
                            i = (int) (((float) hVar.pdN.width()) / 1.586f);
                            hVar.pdN.top = ((hVar.pdN.top + hVar.pdN.bottom) / 2) - (i / 2);
                            hVar.pdN.bottom = i + hVar.pdN.top;
                        } else {
                            i = (int) (((float) hVar.pdN.height()) * 1.586f);
                            hVar.pdN.left = ((hVar.pdN.left + hVar.pdN.right) / 2) - (i / 2);
                            hVar.pdN.right = i + hVar.pdN.left;
                        }
                    } else if (((float) hVar.pdN.height()) / 1.586f < ((float) hVar.pdN.width())) {
                        i = (int) (((float) hVar.pdN.height()) / 1.586f);
                        hVar.pdN.left = ((hVar.pdN.left + hVar.pdN.right) / 2) - (i / 2);
                        hVar.pdN.right = i + hVar.pdN.left;
                    } else {
                        i = (int) (((float) hVar.pdN.width()) * 1.586f);
                        hVar.pdN.top = ((hVar.pdN.top + hVar.pdN.bottom) / 2) - (i / 2);
                        hVar.pdN.bottom = i + hVar.pdN.top;
                    }
                }
                w.d("MicroMsg.scanner.ScanCamera", "scanDisplayRect.left: %d, scanDisplayRect.top: %d, scanDisplayRect.right: %d, scanDisplayRect.bottom: %d", new Object[]{Integer.valueOf(hVar.pdN.left), Integer.valueOf(hVar.pdN.top), Integer.valueOf(hVar.pdN.right), Integer.valueOf(hVar.pdN.bottom)});
                hVar.k(r);
                hVar.lwQ = true;
                Rect rect = hVar.pdN;
                w.d("MicroMsg.scanner.BaseScanUI", "CameraScreenHeightRate() = [%s], CameraScreenWidthRate() = [%s], rect = [%s]", new Object[]{Float.valueOf(this.oXy.aZc()), Float.valueOf(this.oXy.aZb()), rect});
                if (rh()) {
                    w.d("MicroMsg.scanner.BaseScanUI", "landscape needRotate:" + this.oXy.lwO);
                    this.oXH = (int) (((float) rect.width()) * this.oXy.aZb());
                    this.oXI = (int) (((float) rect.height()) * this.oXy.aZc());
                } else {
                    w.d("MicroMsg.scanner.BaseScanUI", "portrait needRotate:" + this.oXy.lwO);
                    if (this.oXy.lwO) {
                        this.oXH = (int) (((float) rect.height()) * this.oXy.aZb());
                        this.oXI = (int) (((float) rect.width()) * this.oXy.aZc());
                    } else {
                        this.oXH = (int) (((float) rect.width()) * this.oXy.aZb());
                        this.oXI = (int) (((float) rect.height()) * this.oXy.aZc());
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.oXH, this.oXI, 3);
                if (!this.oXy.lwO || rh()) {
                    layoutParams.leftMargin = (int) (((float) rect.left) * this.oXy.aZb());
                    layoutParams.topMargin = (int) (((float) rect.top) * this.oXy.aZc());
                } else {
                    layoutParams.leftMargin = (int) (((float) rect.top) * this.oXy.aZb());
                    layoutParams.topMargin = (int) (((float) rect.left) * this.oXy.aZc());
                }
                w.d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s], needRotate=[%s]", new Object[]{Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(this.oXH), Integer.valueOf(this.oXI), Boolean.valueOf(this.oXy.lwO)});
                if (1 == this.oXX || 4 == this.oXX || 8 == this.oXX) {
                    i = BackwardSupportUtil.b.a(this, 20.0f);
                    rect = new Rect(layoutParams.leftMargin + i, layoutParams.topMargin + i, (layoutParams.leftMargin + this.oXH) - i, ((layoutParams.topMargin + this.oXI) - i) - i);
                } else {
                    rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + this.oXH, layoutParams.topMargin + this.oXI);
                }
                if (this.oXz.x - rect.right < rect.left) {
                    w.w("MicroMsg.scanner.BaseScanUI", "this is a special device");
                    if (this.oXz.x - rect.left > rect.left) {
                        rect.right = this.oXz.x - rect.left;
                    }
                }
                this.oXH = rect.width();
                if (this.oXB != null) {
                    r = this.oXB.par;
                    this.oXB.aYL();
                    this.oXB = new ScanMaskView((Context) this, r);
                } else {
                    this.oXB = new ScanMaskView((Context) this, rect);
                }
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                this.oXB.setLayoutParams(layoutParams2);
                this.oXx.removeAllViews();
                View.inflate(this, this.oXW.aYi(), this.oXx);
                this.oXW.cl(this.oXx.getChildAt(0));
                this.oXx.addView(this.oXB, 0, layoutParams2);
                ScanMaskView scanMaskView = this.oXB;
                if (!(rect.left == scanMaskView.par.left && rect.right == scanMaskView.par.right && rect.top == scanMaskView.par.top && rect.bottom == scanMaskView.par.bottom)) {
                    scanMaskView.pay = (float) (rect.left - scanMaskView.par.left);
                    scanMaskView.paz = (float) (rect.right - scanMaskView.par.right);
                    scanMaskView.paA = (float) (rect.top - scanMaskView.par.top);
                    scanMaskView.paB = (float) (rect.bottom - scanMaskView.par.bottom);
                    scanMaskView.paw = new Rect(scanMaskView.par.left, scanMaskView.par.top, scanMaskView.par.right, scanMaskView.par.bottom);
                    scanMaskView.pav = true;
                    scanMaskView.paD = new ValueAnimator();
                    scanMaskView.paD.setFloatValues(new float[]{0.0f, 1.0f});
                    scanMaskView.paD.setDuration(200);
                    scanMaskView.paD.addUpdateListener(new AnimatorUpdateListener(scanMaskView) {
                        final /* synthetic */ ScanMaskView paE;

                        {
                            this.paE = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            this.paE.par.left = this.paE.paw.left + ((int) (this.paE.pay * floatValue));
                            this.paE.par.right = this.paE.paw.right + ((int) (this.paE.paz * floatValue));
                            this.paE.par.top = this.paE.paw.top + ((int) (this.paE.paA * floatValue));
                            this.paE.par.bottom = ((int) (floatValue * this.paE.paB)) + this.paE.paw.bottom;
                            this.paE.invalidate();
                        }
                    });
                    scanMaskView.paD.start();
                }
                this.oXW.i(rect);
                this.oXB.setBackgroundColor(0);
                w.d("MicroMsg.scanner.BaseScanUI", "newRect = %s", new Object[]{rect});
                if (this.oXL) {
                    this.oXJ = rect.top;
                    this.oXK = rect.bottom - BackwardSupportUtil.b.a(this, 8.0f);
                    this.oXM = rect;
                } else {
                    this.oXJ = rect.left;
                    this.oXK = rect.right - BackwardSupportUtil.b.a(this, 8.0f);
                    this.oXM = rect;
                }
                if (this.oXC != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.oXC.getLayoutParams();
                    if (this.oXX == 3) {
                        layoutParams3.topMargin = this.oXA.getTop() - com.tencent.mm.bg.a.fromDPToPix(this, 70);
                    } else {
                        layoutParams3.topMargin = this.oXM.top + (this.oXM.height() - com.tencent.mm.bg.a.fromDPToPix(this, 70));
                    }
                    w.j("MicroMsg.scanner.BaseScanUI", "initFlashSwitcher, scanMaskRect: %s, scanLineStart: %s, scanLineEnd: %s", new Object[]{this.oXM, Integer.valueOf(this.oXJ), Integer.valueOf(this.oXK)});
                    this.oXC.setLayoutParams(layoutParams3);
                    this.oXC.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BaseScanUI oYp;

                        {
                            this.oYp = r1;
                        }

                        public final void onClick(View view) {
                            if (this.oYp.oXy != null) {
                                l.oWo.oWC = 2;
                                if (this.oYp.oXy.pdQ) {
                                    this.oYp.oXy.aZg();
                                    this.oYp.oXC.aYT();
                                    return;
                                }
                                h f = this.oYp.oXy;
                                w.i("MicroMsg.scanner.ScanCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[]{f.gPJ, Boolean.valueOf(f.lwK)});
                                if (f.gPJ != null && f.lwK) {
                                    try {
                                        f.pdQ = true;
                                        Parameters parameters = f.gPJ.getParameters();
                                        if (bg.bV(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                                            w.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
                                        } else {
                                            parameters.setFlashMode("torch");
                                            f.gPJ.setParameters(parameters);
                                            w.i("MicroMsg.scanner.ScanCamera", "open flash");
                                        }
                                    } catch (Throwable e) {
                                        w.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "openFlash error: %s", new Object[]{e.getMessage()});
                                    }
                                }
                                ScannerFlashSwitcher g = this.oYp.oXC;
                                w.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
                                g.pcb.setImageResource(R.k.dzr);
                            }
                        }
                    });
                    if (this.oXy == null || !this.oXy.pdQ) {
                        this.oXC.setVisibility(8);
                    } else {
                        this.oXC.setVisibility(0);
                    }
                }
                if (!this.oXQ || this.oXF) {
                    c(true, 350);
                    if (this.oXy != null && this.oXy.lwK) {
                        cY(0);
                        cX(0);
                    }
                    if (this.oXN != null && this.oXO != null) {
                        this.oXN.setVisibility(8);
                        this.oXO.setVisibility(8);
                    }
                } else if (this.oXN != null && this.oXO != null) {
                    this.oXN.setText(R.l.eOY);
                    this.oXO.setVisibility(0);
                    this.oXN.setVisibility(0);
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
        }
    }

    public void onStart() {
        super.onStart();
        aYw();
    }

    private void aYw() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.oXz = new Point(rect.width(), rect.height());
        w.d("MicroMsg.scanner.BaseScanUI", "visible rect: %s", new Object[]{this.oXz});
    }

    public final void j(long j, boolean z) {
        w.i("MicroMsg.scanner.BaseScanUI", "startAutoFocusAndTakeShot, autoFocusInterval: %s, setInterval: %s", new Object[]{Long.valueOf(j), Boolean.valueOf(z)});
        if (z && j > 0) {
            this.oXq = j;
        }
        if (!this.oXE && this.oXy != null && this.oXy.lwK) {
            cX(50);
            if (j == 0) {
                cY(30);
            } else {
                cY(this.oXq);
            }
        }
    }

    public final void aYx() {
        if (this.oXy != null && this.oXu && this.oXt != null) {
            try {
                this.oXy.c(this.oXt);
                cX(50);
                cY(0);
            } catch (Throwable e) {
                w.e("MicroMsg.scanner.BaseScanUI", "in setPreviewState");
                w.printErrStackTrace("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
            }
            c(false, 150);
        }
    }

    public final void se(int i) {
        this.oYf.removeMessages(0);
        this.oYf.sendEmptyMessageDelayed(i, 50);
    }

    public final void cX(long j) {
        w.i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", new Object[]{Long.valueOf(j)});
        this.oYg.removeMessages(0);
        if (this.oXE) {
            w.w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
        } else {
            this.oYg.sendEmptyMessageDelayed(0, j);
        }
    }

    public final void cY(long j) {
        w.i("MicroMsg.scanner.BaseScanUI", "autoFocusDelay: %s", new Object[]{Long.valueOf(j)});
        this.oYk.removeMessages(0);
        if (j == 0) {
            this.oYk.sendEmptyMessageDelayed(0, 100);
            this.oYl = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - this.oYl < this.oXq) {
            w.d("MicroMsg.scanner.BaseScanUI", "autoFocusDelay sendEmptyMessageDelayed [%s]", new Object[]{Long.valueOf(this.oXq - (System.currentTimeMillis() - this.oYl))});
            this.oYk.sendEmptyMessageDelayed(0, this.oXq - (System.currentTimeMillis() - this.oYl));
        } else {
            w.d("MicroMsg.scanner.BaseScanUI", "autoFocusDelay sendEmptyMessageDelayed [%s].", new Object[]{Long.valueOf(j)});
            this.oYk.sendEmptyMessageDelayed(0, j);
            this.oYl = System.currentTimeMillis();
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        String str = "MicroMsg.scanner.BaseScanUI";
        String str2 = "onPreviewFrame, data==null: %s, camera: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr == null);
        objArr[1] = camera;
        w.i(str, str2, objArr);
        if (this.oXE || this.oXW == null || this.oXW.aYh() == null || this.oXW.r(false, rh()) == null) {
            w.w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", new Object[]{Boolean.valueOf(this.oXE)});
        } else if (bArr == null || bArr.length <= 0) {
            str = "MicroMsg.scanner.BaseScanUI";
            str2 = "onPreviewFrame, wrong data, data is null [%s]";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            w.e(str, str2, objArr);
            aYu();
        } else if (this.oXy == null) {
            w.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
        } else {
            if (this.oXy != null) {
                h hVar = this.oXy;
                if (hVar.pdR < 0) {
                    hVar.pdR = hVar.aZf() ? 1 : 0;
                }
                if (!((hVar.pdR == 1 ? 1 : null) == null || this.oXy.pdQ || !this.oXF)) {
                    ScanCameraLightDetector scanCameraLightDetector = ScanCameraLightDetector.pdW;
                    int i = this.oXy.lwL.x;
                    int i2 = this.oXy.lwL.y;
                    if (scanCameraLightDetector.pdX < 0 || (bg.aB(scanCameraLightDetector.pdX) >= 1000 && scanCameraLightDetector.handler != null && scanCameraLightDetector.peb != null && scanCameraLightDetector.peb.isAlive())) {
                        a aVar = new a(scanCameraLightDetector);
                        aVar.nDz = bArr;
                        aVar.width = i;
                        aVar.height = i2;
                        Message obtain = Message.obtain();
                        obtain.what = 233;
                        obtain.obj = aVar;
                        scanCameraLightDetector.handler.sendMessage(obtain);
                        scanCameraLightDetector.pdX = bg.NA();
                    }
                }
            }
            if (!this.oXW.oV() && !this.oXE) {
                com.tencent.mm.plugin.scanner.util.b aYh = this.oXW.aYh();
                Point point = this.oXy.lwL;
                int i3 = this.oXy.lwP;
                h hVar2 = this.oXy;
                Rect gK = this.oXW.gK(rh());
                int i4 = this.oXX;
                if (hVar2.pdO == null) {
                    hVar2.lwQ = false;
                    hVar2.pdP = null;
                    hVar2.pdO = new Rect();
                    if (!hVar2.lwO || hVar2.pdM) {
                        hVar2.pdO.left = (gK.left * hVar2.lwL.x) / hVar2.lwN.x;
                        hVar2.pdO.right = (gK.right * hVar2.lwL.x) / hVar2.lwN.x;
                        hVar2.pdO.top = (gK.top * hVar2.lwL.y) / hVar2.lwN.y;
                        hVar2.pdO.bottom = (gK.bottom * hVar2.lwL.y) / hVar2.lwN.y;
                        if (hVar2.pdO.bottom > hVar2.lwL.y) {
                            hVar2.pdO.bottom = hVar2.lwL.y;
                        }
                        if (hVar2.pdO.right > hVar2.lwL.x) {
                            hVar2.pdO.right = hVar2.lwL.x;
                        }
                    } else {
                        w.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + hVar2.lwO + " needLandscape = " + hVar2.pdM);
                        hVar2.pdO.top = (gK.left * hVar2.lwL.y) / hVar2.lwN.x;
                        hVar2.pdO.bottom = (gK.right * hVar2.lwL.y) / hVar2.lwN.x;
                        hVar2.pdO.left = (gK.top * hVar2.lwL.x) / hVar2.lwN.y;
                        hVar2.pdO.right = (gK.bottom * hVar2.lwL.x) / hVar2.lwN.y;
                        if (hVar2.pdO.bottom > hVar2.lwL.y) {
                            hVar2.pdO.bottom = hVar2.lwL.y;
                        }
                        if (hVar2.pdO.right > hVar2.lwL.x) {
                            hVar2.pdO.right = hVar2.lwL.x;
                        }
                    }
                    if (7 == i4 || 11 == i4) {
                        if (!hVar2.lwO || hVar2.pdM) {
                            if ((((double) hVar2.pdO.width()) * 1.0d) / ((double) hVar2.pdO.height()) < 1.5859999656677246d) {
                                i4 = (int) (((float) hVar2.pdO.width()) / 1.586f);
                                hVar2.pdO.top = ((hVar2.pdO.top + hVar2.pdO.bottom) / 2) - (i4 / 2);
                                hVar2.pdO.bottom = i4 + hVar2.pdO.top;
                            } else {
                                i4 = (int) (((float) hVar2.pdO.height()) * 1.586f);
                                hVar2.pdO.left = ((hVar2.pdO.left + hVar2.pdO.right) / 2) - (i4 / 2);
                                hVar2.pdO.right = i4 + hVar2.pdO.left;
                            }
                        } else if (((float) hVar2.pdO.height()) / 1.586f < ((float) hVar2.pdO.width())) {
                            i4 = (int) (((float) hVar2.pdO.height()) / 1.586f);
                            hVar2.pdO.left = ((hVar2.pdO.left + hVar2.pdO.right) / 2) - (i4 / 2);
                            hVar2.pdO.right = i4 + hVar2.pdO.left;
                        } else {
                            i4 = (int) (((float) hVar2.pdO.width()) * 1.586f);
                            hVar2.pdO.top = ((hVar2.pdO.top + hVar2.pdO.bottom) / 2) - (i4 / 2);
                            hVar2.pdO.bottom = i4 + hVar2.pdO.top;
                        }
                    }
                    w.d("MicroMsg.scanner.ScanCamera", "scanRect.left: %d, scanRect.top: %d, scanRect.right: %d, scanRect.bottom: %d", new Object[]{Integer.valueOf(hVar2.pdO.left), Integer.valueOf(hVar2.pdO.top), Integer.valueOf(hVar2.pdO.right), Integer.valueOf(hVar2.pdO.bottom)});
                }
                hVar2.k(gK);
                hVar2.lwQ = true;
                Rect rect = hVar2.pdO;
                w.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.plugin.scanner.util.b.AnonymousClass1(aYh, bArr, i3, point, rect), "scan_decode", 10);
            }
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        w.i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", new Object[]{Boolean.valueOf(z), camera});
        this.nkt[4] = (int) (System.currentTimeMillis() - this.oYb);
        if (!this.oXE && this.oXW != null && this.oXX != 3 && this.oXX != 2 && this.oXy != null && this.oXy.lwK) {
            if (this.oXy != null && this.oXu) {
                this.oXy.a(this);
            }
            cY(this.oXq);
        }
    }

    public final void a(i.a aVar) {
        this.oXG = aVar;
    }

    public final void aYy() {
        Intent intent = new Intent();
        intent.putExtra("preview_ui_title", R.l.ePp);
        k.a(this, 4660, intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.oXG != null) {
            this.oXG.b(this, i, i2, intent);
        }
    }

    public final void gH(boolean z) {
        this.oXE = z;
        if (z) {
            aYq();
            if (this.oXO != null) {
                this.oXO.setVisibility(0);
                return;
            }
            return;
        }
        j(0, false);
        c(false, 0);
        if (this.oXO != null) {
            this.oXO.setVisibility(8);
        }
    }

    public final void b(int i, final OnClickListener onClickListener) {
        if (this.oXv != null) {
            if (getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
                this.oXv.setVisibility(8);
            } else if (onClickListener != null) {
                this.oXv.setVisibility(i);
                this.oXv.setOnClickListener(onClickListener);
                this.oXw.setBackgroundDrawable(null);
                this.oXw.setText(getString(R.l.eQH));
            }
        } else if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
            if (onClickListener != null) {
                a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                    final /* synthetic */ BaseScanUI oYp;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.oYp.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                        eVar.qJf = new n.c(this) {
                            final /* synthetic */ AnonymousClass13 oYt;

                            {
                                this.oYt = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                lVar.dX(0, R.l.dBZ);
                                if (onClickListener != null) {
                                    lVar.dX(1, R.l.eQG);
                                }
                                if (j.aZh()) {
                                    lVar.dX(2, R.l.eOK);
                                    w.i("MicroMsg.scanner.BaseScanUI", "show history list");
                                }
                                if (r.ijF) {
                                    lVar.e(3, "TestScanner");
                                }
                            }
                        };
                        eVar.qJg = new d(this) {
                            final /* synthetic */ AnonymousClass13 oYt;

                            {
                                this.oYt = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        Context context = this.oYt.oYp;
                                        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                                        intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.l.ekf));
                                        intent.putExtra("duplicate", false);
                                        Parcelable intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                        intent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                                        intent2.addFlags(67108864);
                                        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.g.bji));
                                        intent.putExtra("shortcut_icon_resource_id", R.g.bji);
                                        com.tencent.mm.plugin.base.model.c.k(context, intent);
                                        com.tencent.mm.plugin.report.service.g.oUh.i(11410, new Object[0]);
                                        return;
                                    case 1:
                                        if (onClickListener != null) {
                                            onClickListener.onClick(null);
                                            return;
                                        }
                                        return;
                                    case 2:
                                        Intent intent3 = new Intent();
                                        intent3.setClass(this.oYt.oYp, ScannerHistoryUI.class);
                                        this.oYt.oYp.startActivity(intent3);
                                        com.tencent.mm.plugin.report.service.g.oUh.i(12684, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                                        return;
                                    case 3:
                                        r.ijI = 0;
                                        r.ijG = true;
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        eVar.bzh();
                        return false;
                    }
                });
            } else {
                zn(0);
            }
        }
    }

    public final boolean aYz() {
        if (this.oXy != null) {
            return this.oXy.lwO;
        }
        w.d("MicroMsg.scanner.BaseScanUI", "scanCamera == null, cameraNeedRotate return false");
        return false;
    }

    public final void aYA() {
        aYC();
    }

    public final void aYB() {
        super.finish();
    }

    private void aYC() {
        com.tencent.mm.sdk.b.b npVar = new np();
        npVar.fUK.fRW = 1;
        com.tencent.mm.sdk.b.a.urY.m(npVar);
        setResult(0);
        finish();
    }

    private boolean rh() {
        return 7 == this.oXX || 9 == this.oXX || 10 == this.oXX || 11 == this.oXX || com.tencent.mm.compatible.d.c.rh();
    }

    public final void a(String str, int i, int i2, int i3, e.a aVar) {
        w.d("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.oXT != null) {
            this.oXT.aZa();
        }
        Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
        this.oXZ = true;
        this.oXT = new e();
        this.oXT.a(this, str, i, i2, i3, aVar, bundleExtra);
        if (this.oXX == 1 || this.oXX == 8 || this.oXX == 4) {
            int i4 = l.oWo.oWt;
            i4 = l.oWl;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        w.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
        this.oXs.bSB();
        this.oXt = surfaceTexture;
        this.oXR = true;
        if (this.oXS) {
            aYs();
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        w.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
        this.oXt = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        w.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
        this.oXu = false;
        this.oXR = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(int r13, int r14, int r15) {
        /*
        r12 = this;
        r8 = 6;
        r10 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r7 = 2;
        r6 = 1;
        r1 = r12.hvG;
        monitor-enter(r1);
        r0 = r12.lBw;	 Catch:{ all -> 0x00b1 }
        if (r0 != 0) goto L_0x00af;
    L_0x000c:
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        if (r0 == 0) goto L_0x00af;
    L_0x0010:
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r0 = r0.lwK;	 Catch:{ all -> 0x00b1 }
        if (r0 == 0) goto L_0x00af;
    L_0x0016:
        r0 = "MicroMsg.scanner.BaseScanUI";
        r2 = "zoom camera,action:%d,type:%d,scale:%d";
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b1 }
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x00b1 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x00b1 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
        r4 = 2;
        r5 = java.lang.Integer.valueOf(r15);	 Catch:{ all -> 0x00b1 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);	 Catch:{ all -> 0x00b1 }
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r2 = r0.aZe();	 Catch:{ all -> 0x00b1 }
        r0 = r12.oXX;	 Catch:{ all -> 0x00b1 }
        if (r0 == r6) goto L_0x004c;
    L_0x0041:
        r0 = r12.oXX;	 Catch:{ all -> 0x00b1 }
        r3 = 8;
        if (r0 == r3) goto L_0x004c;
    L_0x0047:
        r0 = r12.oXX;	 Catch:{ all -> 0x00b1 }
        r3 = 4;
        if (r0 != r3) goto L_0x00ba;
    L_0x004c:
        if (r14 != r6) goto L_0x0063;
    L_0x004e:
        r0 = r12.oXW;	 Catch:{ all -> 0x00b1 }
        r0 = (com.tencent.mm.plugin.scanner.ui.p) r0;	 Catch:{ all -> 0x00b1 }
        r0 = r0.aYR();	 Catch:{ all -> 0x00b1 }
        if (r0 != 0) goto L_0x0063;
    L_0x0058:
        r0 = "MicroMsg.scanner.BaseScanUI";
        r2 = "auto zoom is disable";
        com.tencent.mm.sdk.platformtools.w.d(r0, r2);	 Catch:{ all -> 0x00b1 }
        monitor-exit(r1);	 Catch:{ all -> 0x00b1 }
    L_0x0062:
        return;
    L_0x0063:
        if (r14 != r7) goto L_0x006c;
    L_0x0065:
        r0 = r12.oXW;	 Catch:{ all -> 0x00b1 }
        r0 = (com.tencent.mm.plugin.scanner.ui.p) r0;	 Catch:{ all -> 0x00b1 }
        r0.aYQ();	 Catch:{ all -> 0x00b1 }
    L_0x006c:
        if (r13 != r8) goto L_0x00b4;
    L_0x006e:
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r0.sk(r15);	 Catch:{ all -> 0x00b1 }
    L_0x0073:
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r0 = r0.aZe();	 Catch:{ all -> 0x00b1 }
        if (r0 == r2) goto L_0x00af;
    L_0x007b:
        r2 = com.tencent.mm.plugin.scanner.a.l.oWo;	 Catch:{ all -> 0x00b1 }
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r3 = r0.aZe();	 Catch:{ all -> 0x00b1 }
        r0 = "";
        if (r14 != r6) goto L_0x00c8;
    L_0x0088:
        r0 = "(0@%.2f)";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00b1 }
        r5 = 0;
        r6 = (double) r3;	 Catch:{ all -> 0x00b1 }
        r6 = r6 / r10;
        r3 = java.lang.Double.valueOf(r6);	 Catch:{ all -> 0x00b1 }
        r4[r5] = r3;	 Catch:{ all -> 0x00b1 }
        r0 = java.lang.String.format(r0, r4);	 Catch:{ all -> 0x00b1 }
    L_0x009b:
        r3 = r2.oWB;	 Catch:{ all -> 0x00b1 }
        r3 = r3.length();	 Catch:{ all -> 0x00b1 }
        r4 = r0.length();	 Catch:{ all -> 0x00b1 }
        r3 = r3 + r4;
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r3 >= r4) goto L_0x00af;
    L_0x00aa:
        r2 = r2.oWB;	 Catch:{ all -> 0x00b1 }
        r2.append(r0);	 Catch:{ all -> 0x00b1 }
    L_0x00af:
        monitor-exit(r1);	 Catch:{ all -> 0x00b1 }
        goto L_0x0062;
    L_0x00b1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00b1 }
        throw r0;
    L_0x00b4:
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r0.sl(r13);	 Catch:{ all -> 0x00b1 }
        goto L_0x0073;
    L_0x00ba:
        if (r13 != r8) goto L_0x00c2;
    L_0x00bc:
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r0.sk(r15);	 Catch:{ all -> 0x00b1 }
        goto L_0x0073;
    L_0x00c2:
        r0 = r12.oXy;	 Catch:{ all -> 0x00b1 }
        r0.sl(r13);	 Catch:{ all -> 0x00b1 }
        goto L_0x0073;
    L_0x00c8:
        if (r14 != r7) goto L_0x009b;
    L_0x00ca:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b1 }
        r4.<init>();	 Catch:{ all -> 0x00b1 }
        r0 = r4.append(r0);	 Catch:{ all -> 0x00b1 }
        r4 = "(1@%.2f)";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00b1 }
        r6 = 0;
        r8 = (double) r3;	 Catch:{ all -> 0x00b1 }
        r8 = r8 / r10;
        r3 = java.lang.Double.valueOf(r8);	 Catch:{ all -> 0x00b1 }
        r5[r6] = r3;	 Catch:{ all -> 0x00b1 }
        r3 = java.lang.String.format(r4, r5);	 Catch:{ all -> 0x00b1 }
        r0 = r0.append(r3);	 Catch:{ all -> 0x00b1 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b1 }
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.BaseScanUI.M(int, int, int):void");
    }
}
