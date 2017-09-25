package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.l.p;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI extends MMBaseActivity implements p, e {
    private List<String> fPq = new LinkedList();
    private TextView ioX;
    private com.tencent.mm.ui.base.p isP;
    private TextView mVF;
    private boolean neO = true;
    private String neP;
    private String neQ;
    private boolean neS = false;
    private int neT = 0;
    private long neU = 500;
    private long neV = 0;
    private aj neW = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ TalkRoomUI qZF;

        {
            this.qZF = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
            this.qZF.aGK();
            return false;
        }
    }, false);
    private aj neX = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ TalkRoomUI qZF;

        {
            this.qZF = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
            TalkRoomUI.a(this.qZF);
            return false;
        }
    }, false);
    private aj neY = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ TalkRoomUI qZF;

        {
            this.qZF = r1;
        }

        public final boolean oQ() {
            this.qZF.aGM();
            return false;
        }
    }, false);
    private float nfX = -1.0f;
    private final aj nfb = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ TalkRoomUI qZF;

        {
            this.qZF = r1;
        }

        public final boolean oQ() {
            short bnU;
            int i = 15;
            int i2 = 0;
            if (this.qZF.neT == 3) {
                bnU = b.bnB().bnU();
            } else if (bg.mA(this.qZF.neQ)) {
                this.qZF.bob();
                return false;
            } else {
                bnU = b.bnB().bnV();
            }
            if (bnU <= (short) 15) {
                if (!this.qZF.qZx) {
                    i = 0;
                }
                this.qZF.qZy = this.qZF.qZy + 1;
                if (this.qZF.qZy >= 5) {
                    boolean z;
                    TalkRoomUI talkRoomUI = this.qZF;
                    if (this.qZF.qZx) {
                        z = false;
                    } else {
                        z = true;
                    }
                    talkRoomUI.qZx = z;
                    this.qZF.qZy = 0;
                }
            } else {
                short s = bnU;
            }
            this.qZF.bob();
            a aVar = this.qZF.qZu.qZL;
            if (i >= 0) {
                i2 = i > aVar.max ? aVar.max : i;
            }
            aVar.value = i2;
            aVar.rac = aVar.qZR - ((aVar.qZR - aVar.qZQ) * ((((float) aVar.value) * 1.0f) / ((float) aVar.max)));
            return true;
        }
    }, true);
    private boolean nfc = true;
    private Chronometer nfh;
    private int nfi = 0;
    private AlphaAnimation qZA;
    private AlphaAnimation qZB;
    private AlphaAnimation qZC;
    private float qZD = -1.0f;
    private float qZE = -1.0f;
    private TextView qZq;
    private ImageButton qZr;
    private Button qZs;
    private ImageView qZt;
    private TalkRoomVolumeMeter qZu;
    private TalkRoomAvatarsFrame qZv;
    private a qZw;
    private boolean qZx = true;
    private int qZy = 0;
    private AlphaAnimation qZz;
    private WakeLock wakeLock;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ TalkRoomUI qZF;
        final /* synthetic */ i qZG;

        AnonymousClass2(TalkRoomUI talkRoomUI, i iVar) {
            this.qZF = talkRoomUI;
            this.qZG = iVar;
        }

        public final void onClick(View view) {
            this.qZG.dismiss();
        }
    }

    private abstract class a {
        float jXG;
        float jzV;
        final /* synthetic */ TalkRoomUI qZF;
        long qZK;

        public abstract void bof();

        public a(TalkRoomUI talkRoomUI) {
            this.qZF = talkRoomUI;
        }
    }

    static /* synthetic */ void a(TalkRoomUI talkRoomUI) {
        if (talkRoomUI.neT == 5) {
            talkRoomUI.neT = 3;
            b.bnB().bnx();
            talkRoomUI.nfb.v(100, 100);
        }
    }

    static /* synthetic */ boolean a(TalkRoomUI talkRoomUI, MotionEvent motionEvent) {
        if (talkRoomUI.nfX < 0.0f) {
            talkRoomUI.nfX = (((float) talkRoomUI.qZr.getWidth()) - (((float) talkRoomUI.qZr.getPaddingLeft()) * 2.0f)) / 2.0f;
            talkRoomUI.qZD = (((float) talkRoomUI.qZr.getWidth()) * 1.0f) / 2.0f;
            talkRoomUI.qZE = (((float) talkRoomUI.qZr.getHeight()) * 1.0f) / 2.0f;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return Math.sqrt((double) (((x - talkRoomUI.qZD) * (x - talkRoomUI.qZD)) + ((y - talkRoomUI.qZE) * (y - talkRoomUI.qZE)))) < ((double) talkRoomUI.nfX);
    }

    private void bob() {
        if (this.neT == 3 || this.neT == 5) {
            this.qZu.hX(true);
        } else if (bg.mA(this.neQ)) {
            this.qZu.hX(false);
        } else {
            this.qZu.hX(true);
        }
    }

    public void onCreate(Bundle bundle) {
        w.d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("enter_room_username");
        w.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[]{stringExtra});
        w.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[]{stringExtra});
        this.neP = stringExtra;
        if (bg.mA(this.neP)) {
            Hu("");
        } else {
            if (o.dH(stringExtra)) {
                List eA = j.eA(stringExtra);
                if (eA == null) {
                    com.tencent.mm.u.ag.a.hlS.J(stringExtra, "");
                } else {
                    this.fPq = eA;
                }
            } else {
                this.fPq.clear();
                this.fPq.add(stringExtra);
                this.fPq.add(m.xL());
            }
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ TalkRoomUI qZF;

                public final void run() {
                    b.bnB().bR(stringExtra, 0);
                }
            });
        }
        w.d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(r.eC(ab.getContext()).inflate(R.i.doY, null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.ioX = (TextView) findViewById(R.h.cJh);
        this.qZq = (TextView) findViewById(R.h.cjQ);
        this.mVF = (TextView) findViewById(R.h.bGN);
        this.qZs = (Button) findViewById(R.h.bXB);
        this.nfh = (Chronometer) findViewById(R.h.bCn);
        this.qZt = (ImageView) findViewById(R.h.caY);
        this.qZw = new a(this);
        this.qZs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI qZF;

            {
                this.qZF = r1;
            }

            public final void onClick(View view) {
                g.a(this.qZF, this.qZF.getString(R.l.eXE), this.qZF.getString(R.l.eXD), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 qZH;

                    {
                        this.qZH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.qZH.qZF.nfc = false;
                        b.bnB().aGN();
                        this.qZH.qZF.finish();
                    }
                }, null);
            }
        });
        findViewById(R.h.cKM).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI qZF;

            {
                this.qZF = r1;
            }

            public final void onClick(View view) {
                boolean z;
                Context context = this.qZF;
                ap.yY();
                if (bg.a((Integer) c.vr().get(144641, null), 0) > 0) {
                    z = false;
                } else {
                    i iVar = new i(context, R.m.foN);
                    LinearLayout linearLayout = (LinearLayout) r.eC(ab.getContext()).inflate(R.i.dpb, null);
                    linearLayout.setMinimumWidth(10000);
                    Button button = (Button) linearLayout.findViewById(R.h.bWu);
                    iVar.setCanceledOnTouchOutside(true);
                    iVar.setOnDismissListener(new OnDismissListener(context) {
                        final /* synthetic */ TalkRoomUI qZF;

                        {
                            this.qZF = r1;
                        }

                        public final void onDismiss(DialogInterface dialogInterface) {
                            ap.yY();
                            int a = bg.a((Integer) c.vr().get(144641, null), 0) + 1;
                            ap.yY();
                            c.vr().set(144641, Integer.valueOf(a));
                            this.qZF.onBackPressed();
                        }
                    });
                    iVar.setCancelable(false);
                    button.setOnClickListener(new AnonymousClass2(context, iVar));
                    iVar.setContentView(linearLayout);
                    iVar.show();
                    z = true;
                }
                if (!z) {
                    this.qZF.onBackPressed();
                }
            }
        });
        this.qZr = (ImageButton) findViewById(R.h.cjP);
        this.qZr.setEnabled(false);
        this.qZr.setImageResource(R.g.bkA);
        this.qZr.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TalkRoomUI qZF;

            {
                this.qZF = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
                /*
                r5 = this;
                r4 = 0;
                r0 = r7.getAction();
                switch(r0) {
                    case 0: goto L_0x0009;
                    case 1: goto L_0x006f;
                    case 2: goto L_0x005f;
                    case 3: goto L_0x006f;
                    default: goto L_0x0008;
                };
            L_0x0008:
                return r4;
            L_0x0009:
                r0 = r5.qZF;
                r1 = r5.qZF;
                r1 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r1, r7);
                r0.neS = r1;
                r0 = r5.qZF;
                r0 = r0.neS;
                if (r0 == 0) goto L_0x0008;
            L_0x001c:
                r0 = r5.qZF;
                r0 = r0.qZr;
                r1 = com.tencent.mm.R.g.bkz;
                r0.setImageResource(r1);
                r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
                r1 = com.tencent.mm.R.l.eXV;
                r2 = new com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$1;
                r2.<init>(r5);
                com.tencent.mm.sdk.platformtools.aq.b(r0, r1, r2);
                r0 = r5.qZF;
                r1 = 1;
                r0.neT = r1;
                r0 = r5.qZF;
                r0.bob();
                r0 = "MicroMsg.TalkRoomUI";
                r1 = "micBtn pressed down";
                com.tencent.mm.sdk.platformtools.w.i(r0, r1);
                r0 = r5.qZF;
                r2 = com.tencent.mm.sdk.platformtools.bg.NA();
                r0.neV = r2;
                r0 = com.tencent.mm.plugin.talkroom.model.b.bnB();
                r0.bnO();
                r0 = r5.qZF;
                r0.aGM();
                goto L_0x0008;
            L_0x005f:
                r0 = r5.qZF;
                r0 = r0.neS;
                if (r0 == 0) goto L_0x0008;
            L_0x0067:
                r0 = r5.qZF;
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r0, r7);
                if (r0 != 0) goto L_0x0008;
            L_0x006f:
                r0 = r5.qZF;
                r0 = r0.neS;
                if (r0 == 0) goto L_0x0008;
            L_0x0077:
                r0 = r5.qZF;
                r0.neS = r4;
                r0 = r5.qZF;
                r0 = r0.neT;
                r1 = 5;
                if (r0 != r1) goto L_0x00a0;
            L_0x0085:
                r0 = "MicroMsg.TalkRoomUI";
                r1 = "cancel during seize-success prepare time";
                com.tencent.mm.sdk.platformtools.w.i(r0, r1);
                r0 = r5.qZF;
                r0 = r0.neW;
                r0.KH();
                r0 = r5.qZF;
                r0 = r0.neX;
                r0.KH();
            L_0x00a0:
                r0 = r5.qZF;
                r0 = r0.qZr;
                r1 = com.tencent.mm.R.g.bky;
                r0.setImageResource(r1);
                r0 = r5.qZF;
                r0.neT = r4;
                r0 = r5.qZF;
                r0.bob();
                r0 = r5.qZF;
                r0 = r0.nfb;
                r0.KH();
                r0 = com.tencent.mm.plugin.talkroom.model.b.bnB();
                r0.bnP();
                r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
                r1 = com.tencent.mm.R.l.eXX;
                r2 = new com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$2;
                r2.<init>(r5);
                com.tencent.mm.sdk.platformtools.aq.b(r0, r1, r2);
                r0 = r5.qZF;
                r0.aGM();
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.13.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        this.qZu = (TalkRoomVolumeMeter) findViewById(R.h.cOY);
        final a anonymousClass14 = new a(this) {
            final /* synthetic */ TalkRoomUI qZF;

            {
                this.qZF = r1;
            }

            public final void bof() {
                this.qZF.onBackPressed();
            }
        };
        findViewById(R.h.cJx).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TalkRoomUI qZF;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                a aVar = anonymousClass14;
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.jXG = motionEvent.getX();
                    aVar.jzV = motionEvent.getY();
                    aVar.qZK = bg.NA();
                    return true;
                }
                if (action == 1 || action == 3) {
                    float abs = Math.abs(motionEvent.getX() - aVar.jXG);
                    float y = aVar.jzV - motionEvent.getY();
                    if (y >= 100.0f && y / abs > 2.0f && y / ((float) bg.aB(aVar.qZK)) > 0.6f) {
                        aVar.bof();
                        return true;
                    }
                }
                return false;
            }
        });
        this.qZv = (TalkRoomAvatarsFrame) findViewById(R.h.bqK);
        this.ioX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI qZF;

            {
                this.qZF = r1;
            }

            public final void onClick(View view) {
                this.qZF.onBackPressed();
            }
        });
        this.qZz = new AlphaAnimation(0.0f, 1.0f);
        this.qZz.setDuration(300);
        this.qZz.setFillAfter(true);
        this.qZA = new AlphaAnimation(1.0f, 0.0f);
        this.qZA.setDuration(300);
        this.qZA.setFillAfter(true);
        this.qZB = new AlphaAnimation(0.0f, 1.0f);
        this.qZB.setDuration(300);
        this.qZB.setFillAfter(true);
        this.qZC = new AlphaAnimation(1.0f, 0.0f);
        this.qZC.setDuration(300);
        this.qZC.setFillAfter(true);
        ap.vd().a(364, this);
        w.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        b.bnB().a(this);
        w.d("MicroMsg.TalkRoomUI", "onCreate end");
    }

    protected void onResume() {
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.acquire();
        this.ioX.setText(h.b(this, com.tencent.mm.plugin.talkroom.model.h.ay(this, this.neP), this.ioX.getTextSize()));
        b.bnA().qXH.qXM = true;
        b.bnA();
        w.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.bnA();
        com.tencent.mm.plugin.talkroom.model.c.bnH();
        com.tencent.mm.sdk.b.b ktVar = new kt();
        ktVar.fRn.fRo = true;
        com.tencent.mm.sdk.b.a.urY.a(ktVar, getMainLooper());
        w.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    }

    protected void onPause() {
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.release();
        this.nfb.KH();
        b.bnA().qXH.qXM = false;
        b.bnA();
        com.tencent.mm.plugin.talkroom.model.c cVar = b.bnA().qXH;
        if (cVar.neO) {
            cVar.Hp(ab.getContext().getString(R.l.eXK));
        } else if (bg.mA(cVar.nek)) {
            cVar.Hp(com.tencent.mm.plugin.talkroom.model.h.ay(ab.getContext(), b.bnB().qYD));
        } else {
            String string = ab.getContext().getString(R.l.eXQ, new Object[]{n.eK(cVar.nek)});
            com.tencent.mm.plugin.talkroom.model.c.bnH();
            cVar.Hp(string);
        }
        com.tencent.mm.sdk.b.b ktVar = new kt();
        ktVar.fRn.fRo = false;
        com.tencent.mm.sdk.b.a.urY.a(ktVar, getMainLooper());
        w.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
    }

    protected void onDestroy() {
        b.bnB().b(this);
        ap.vd().b(364, this);
        if (this.isP != null && this.isP.isShowing()) {
            this.isP.cancel();
        }
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            ap.yZ().ec(3);
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            ap.yZ().eb(3);
            return true;
        }
    }

    public final void aGO() {
        this.neO = false;
        this.qZr.setEnabled(true);
        this.qZr.setImageResource(R.g.bky);
        this.qZs.setVisibility(0);
        aGM();
        bod();
        boc();
    }

    public final void C(String str, int i, int i2) {
        w.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[]{str});
        String str2 = "";
        if (i == 4) {
            if (i2 != -1) {
                this.nfc = false;
                finish();
                return;
            }
            str2 = getString(R.l.eXH);
        }
        Hu(str2);
    }

    public final void oE(int i) {
        w.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
        if (i == 340) {
            if (this.neT == 3) {
                this.neT = 4;
            } else {
                return;
            }
        } else if (this.neT == 1) {
            this.neT = 2;
        } else {
            return;
        }
        bob();
        aGM();
        aq.a(ab.getContext(), R.l.eXW, new com.tencent.mm.sdk.platformtools.aq.a(this) {
            final /* synthetic */ TalkRoomUI qZF;

            {
                this.qZF = r1;
            }

            public final void oW() {
            }
        });
    }

    public final void aGP() {
        w.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.neT == 1) {
            this.neT = 5;
            if (bg.aB(this.neV) < this.neU) {
                w.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
                long aB = this.neU - bg.aB(this.neV);
                this.neW.v(aB, aB);
                return;
            }
            aGK();
        }
    }

    private void aGK() {
        if (this.neT == 5) {
            this.neW.KH();
            aGM();
            bob();
            aq.b(ab.getContext(), R.l.eXT, new com.tencent.mm.sdk.platformtools.aq.a(this) {
                final /* synthetic */ TalkRoomUI qZF;

                {
                    this.qZF = r1;
                }

                public final void oW() {
                    this.qZF.neX.KH();
                    TalkRoomUI.a(this.qZF);
                }
            });
            this.neX.v(1000, 1000);
        }
    }

    public final void k(int i, int i2, String str) {
        w.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        Hu("");
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 364 && this.isP != null && this.isP.isShowing()) {
            this.isP.cancel();
        }
    }

    private void Hu(String str) {
        if (this.nfc) {
            this.nfc = false;
            b.bnB().aGN();
            if (bg.mA(str)) {
                if (am.isConnected(getApplication())) {
                    str = getString(R.l.eXH);
                } else {
                    str = getString(R.l.eXI);
                }
            }
            if (!isFinishing()) {
                g.a(this, str, "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ TalkRoomUI qZF;

                    {
                        this.qZF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.qZF.finish();
                    }
                });
                return;
            }
            return;
        }
        w.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void zC(String str) {
        w.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[]{str});
        this.neQ = str;
        bob();
        aGM();
        if (bg.mA(str)) {
            this.nfb.KH();
            return;
        }
        aq.b(ab.getContext(), R.l.eXU, new com.tencent.mm.sdk.platformtools.aq.a(this) {
            final /* synthetic */ TalkRoomUI qZF;

            {
                this.qZF = r1;
            }

            public final void oW() {
            }
        });
        this.nfb.v(100, 100);
    }

    public final void aGQ() {
        if (this.nfc) {
            this.nfc = false;
            finish();
            return;
        }
        w.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void aGR() {
        aGM();
    }

    public final void aGS() {
        aGM();
    }

    public final void aGT() {
        b(getString(R.l.eXL), R.e.aVY);
    }

    private void boc() {
        List<beu> aGm = b.bnB().aGm();
        List linkedList = new LinkedList();
        for (beu com_tencent_mm_protocal_c_beu : aGm) {
            linkedList.add(com_tencent_mm_protocal_c_beu.jNj);
        }
        TalkRoomAvatarsFrame talkRoomAvatarsFrame = this.qZv;
        if (talkRoomAvatarsFrame.qZk != null) {
            a aVar = talkRoomAvatarsFrame.qZk;
            aVar.qZo = linkedList;
            aVar.notifyDataSetChanged();
        }
    }

    public final void cI(String str, String str2) {
        w.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[]{str, str2});
        boc();
        if (!this.neO) {
            bod();
            if (!bg.mA(str)) {
                bS(getString(R.l.eXy, new Object[]{n.eK(str)}), R.e.aVX);
                this.neY.v(3000, 3000);
            }
            if (!bg.mA(str2)) {
                bS(getString(R.l.eXC, new Object[]{n.eK(str2)}), R.e.aVX);
                this.neY.v(3000, 3000);
            }
        }
    }

    private void aGM() {
        if (!this.neO) {
            if (b.bnB().qYR) {
                b(getString(R.l.eXJ), R.e.aVY);
                this.qZv.Ht(null);
                this.qZt.setImageResource(R.g.bku);
                boe();
                return;
            }
            switch (this.neT) {
                case 0:
                    if (bg.mA(this.neQ)) {
                        CharSequence string;
                        if (b.bnB().aGm().size() == 1) {
                            string = getString(R.l.eXS);
                        } else {
                            string = "";
                        }
                        b(string, R.e.aVX);
                        this.qZv.Ht(null);
                        this.qZt.setImageResource(R.g.bku);
                        boe();
                        return;
                    }
                    bS(n.eK(this.neQ), R.e.aVX);
                    this.qZv.Ht(this.neQ);
                    this.qZt.setImageResource(R.g.bku);
                    uE(1);
                    return;
                case 1:
                    b(getString(R.l.eXx), R.e.aVX);
                    this.qZt.setImageResource(R.g.bkx);
                    return;
                case 2:
                    b(getString(R.l.eXM), R.e.aVY);
                    this.qZt.setImageResource(R.g.bkw);
                    return;
                case 3:
                case 5:
                    b(getString(R.l.eXN), R.e.aVX);
                    this.qZv.Ht(m.xL());
                    this.qZt.setImageResource(R.g.bkv);
                    uE(2);
                    return;
                case 4:
                    b(getString(R.l.eXP), R.e.aVY);
                    this.qZt.setImageResource(R.g.bkw);
                    boe();
                    return;
                default:
                    return;
            }
        }
    }

    private void bod() {
        w.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[]{Integer.valueOf(b.bnB().aGm().size())});
        this.mVF.setText(String.valueOf(r0));
    }

    private void bS(String str, int i) {
        b(h.b(this, str, this.qZq.getTextSize()), i);
    }

    private void b(CharSequence charSequence, int i) {
        if (bg.mA(charSequence.toString())) {
            this.qZq.startAnimation(this.qZC);
            return;
        }
        this.qZq.setTextColor(getResources().getColor(i));
        this.qZq.setText(charSequence);
        this.qZq.startAnimation(this.qZB);
    }

    private void uE(int i) {
        if (i == 0 || this.nfi != i) {
            this.nfh.setVisibility(0);
            this.nfh.startAnimation(this.qZz);
            this.nfh.setBase(bg.NA());
            this.nfh.start();
            this.nfi = i;
        }
    }

    private void boe() {
        if (this.nfi != 0) {
            this.nfh.stop();
            this.nfi = 0;
            this.nfh.startAnimation(this.qZA);
        }
    }
}
