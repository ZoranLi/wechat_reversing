package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.pluginsdk.l.o;
import com.tencent.mm.pluginsdk.l.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import java.util.LinkedList;
import java.util.List;

public final class k implements p, e {
    private Activity activity;
    private List<String> fPq = new LinkedList();
    public Button neL;
    public VolumeMeter neM;
    public RelativeLayout neN;
    private boolean neO = true;
    private String neP;
    public String neQ;
    private String neR;
    public boolean neS = false;
    public int neT = 0;
    private long neU = 500;
    public long neV = 0;
    public aj neW = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ k nfd;

        {
            this.nfd = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
            this.nfd.aGK();
            return false;
        }
    }, false);
    public aj neX = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ k nfd;

        {
            this.nfd = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
            this.nfd.aGL();
            return false;
        }
    }, false);
    private aj neY = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ k nfd;

        {
            this.nfd = r1;
        }

        public final boolean oQ() {
            this.nfd.aGM();
            return false;
        }
    }, false);
    public o neZ;
    public a nfa;
    public final aj nfb = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ k nfd;

        {
            this.nfd = r1;
        }

        public final boolean oQ() {
            int bnU;
            if (this.nfd.neT == 3) {
                bnU = this.nfd.neZ.bnU();
            } else if (bg.mA(this.nfd.neQ)) {
                return false;
            } else {
                bnU = this.nfd.neZ.bnV();
            }
            k kVar = this.nfd;
            float f = (float) bnU;
            if (f < 10.0f) {
                f = 10.0f;
            }
            if (f > 100.0f) {
                f = 100.0f;
            }
            VolumeMeter volumeMeter = kVar.neM;
            f /= 100.0f;
            volumeMeter.nfM = volumeMeter.nfN;
            volumeMeter.nfN = f;
            kVar.neM.invalidate();
            return true;
        }
    }, true);
    private boolean nfc = true;

    public interface a {
        void aGE();

        void aGF();

        void aGG();

        void zA(String str);

        void zB(String str);
    }

    public k(Activity activity, Button button) {
        this.activity = activity;
        this.neL = button;
        this.neN = (RelativeLayout) this.activity.findViewById(R.h.cOX);
        this.neN.setVisibility(8);
        this.neM = (VolumeMeter) this.neN.findViewById(R.h.cOY);
        this.neM.nfI = this.neL;
        VolumeMeter volumeMeter = this.neM;
        if (volumeMeter.nfL == null) {
            com.tencent.mm.sdk.f.e.d(new Runnable(volumeMeter) {
                final /* synthetic */ VolumeMeter nga;

                {
                    this.nga = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.nga.nfL = new ae();
                    Looper.loop();
                }
            }, "VolumeMeter_handler", 1).start();
        }
        this.neZ = com.tencent.mm.pluginsdk.l.a.sBs;
        if (this.neZ == null) {
            w.e("MicroMsg.TalkMgr", "cannot get talkroom server");
        }
    }

    public final void aGJ() {
        this.neR = this.activity.getIntent().getStringExtra("map_talker_name");
        this.neZ.a(this);
        w.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[]{this.neR});
        final String str = this.neR;
        this.neP = str;
        if (!bg.mA(this.neP)) {
            if (com.tencent.mm.u.o.dH(str)) {
                List eA = j.eA(str);
                if (eA == null) {
                    com.tencent.mm.u.ag.a.hlS.J(str, "");
                } else {
                    this.fPq = eA;
                }
            } else {
                this.fPq.clear();
                this.fPq.add(str);
                this.fPq.add(m.xL());
            }
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ k nfd;

                public final void run() {
                    this.nfd.neZ.bR(str, 1);
                }
            });
            this.neL.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ k nfd;

                {
                    this.nfd = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            this.nfd.neS = true;
                            this.nfd.neN.setVisibility(0);
                            this.nfd.neM.reset();
                            VolumeMeter volumeMeter = this.nfd.neM;
                            if (!volumeMeter.nfH) {
                                volumeMeter.nfG = true;
                                volumeMeter.aGZ();
                            }
                            this.nfd.neL.setPressed(true);
                            if (this.nfd.neS) {
                                aq.b(ab.getContext(), R.l.eXV, new com.tencent.mm.sdk.platformtools.aq.a(this) {
                                    final /* synthetic */ AnonymousClass7 nff;

                                    {
                                        this.nff = r1;
                                    }

                                    public final void oW() {
                                        w.i("MicroMsg.TalkMgr", "play press sound end");
                                    }
                                });
                                this.nfd.neT = 1;
                                w.i("MicroMsg.TalkMgr", "micBtn pressed down");
                                this.nfd.neV = bg.NA();
                                this.nfd.neZ.bnO();
                                this.nfd.aGM();
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            this.nfd.neL.setPressed(false);
                            this.nfd.neN.setVisibility(8);
                            this.nfd.neM.reset();
                            this.nfd.neM.nfG = false;
                            if (this.nfd.neS) {
                                this.nfd.neS = false;
                                if (this.nfd.neT == 5) {
                                    w.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                                    this.nfd.neW.KH();
                                    this.nfd.neX.KH();
                                }
                                this.nfd.neT = 0;
                                this.nfd.nfb.KH();
                                this.nfd.neZ.bnP();
                                aq.B(ab.getContext(), R.l.eXX);
                                this.nfd.aGM();
                                if (this.nfd.nfa != null) {
                                    this.nfd.nfa.aGF();
                                    break;
                                }
                            }
                            break;
                        case 2:
                            if (this.nfd.neS) {
                                break;
                            }
                            break;
                    }
                    return false;
                }
            });
        }
    }

    public final void aGK() {
        if (this.neT == 5) {
            this.neW.KH();
            aGM();
            aq.b(ab.getContext(), R.l.eXT, new com.tencent.mm.sdk.platformtools.aq.a(this) {
                final /* synthetic */ k nfd;

                {
                    this.nfd = r1;
                }

                public final void oW() {
                    this.nfd.neX.KH();
                    this.nfd.aGL();
                }
            });
            this.neX.v(1000, 1000);
        }
    }

    public final void aGL() {
        if (this.neT == 5) {
            this.neT = 3;
            this.neZ.bnx();
            this.nfb.v(100, 100);
        }
    }

    public final void aGM() {
        if (!this.neO) {
            if (com.tencent.mm.pluginsdk.l.a.sBs.bnW()) {
                w.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
                if (this.nfa != null) {
                    this.nfa.zA(null);
                    this.nfa.aGF();
                }
            }
            switch (this.neT) {
                case 0:
                    w.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[]{this.neQ});
                    if (this.nfa == null) {
                        return;
                    }
                    if (bg.mA(this.neQ)) {
                        this.nfa.zA(null);
                        return;
                    } else {
                        this.nfa.zA(this.neQ);
                        return;
                    }
                case 1:
                    w.d("MicroMsg.TalkMgr", "seize, state seizing");
                    if (this.nfa != null) {
                        this.nfa.aGG();
                        return;
                    }
                    return;
                case 2:
                    w.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[]{this.neQ});
                    if (this.nfa != null && !bg.mA(this.neQ)) {
                        this.nfa.zB(this.neQ);
                        return;
                    }
                    return;
                case 3:
                case 5:
                    w.d("MicroMsg.TalkMgr", "seize, state success or prepare");
                    if (this.nfa != null) {
                        this.nfa.aGE();
                        return;
                    }
                    return;
                case 4:
                    w.d("MicroMsg.TalkMgr", "seize time out");
                    return;
                default:
                    return;
            }
        }
    }

    public static void aGN() {
        b qkVar = new qk();
        qkVar.fXu.fXx = true;
        com.tencent.mm.sdk.b.a.urY.m(qkVar);
        com.tencent.mm.compatible.b.e.qE().setMode(0);
    }

    public final void aGO() {
        this.neO = false;
        this.neL.setEnabled(true);
        aGM();
    }

    public final void C(String str, int i, int i2) {
        w.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[]{str});
        l.aGe().oD(3);
        this.activity.finish();
    }

    public final void aGP() {
        if (this.neT == 1) {
            this.neT = 5;
            if (bg.aB(this.neV) < this.neU) {
                w.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
                long aB = this.neU - bg.aB(this.neV);
                this.neW.v(aB, aB);
                return;
            }
            aGK();
        }
    }

    public final void oE(int i) {
        w.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
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
        aGM();
        aq.a(ab.getContext(), R.l.eXW, null);
    }

    public final void zC(String str) {
        w.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[]{str});
        this.neQ = str;
        aGM();
        if (bg.mA(str)) {
            this.nfb.KH();
            return;
        }
        aq.B(ab.getContext(), R.l.eXU);
        this.nfb.v(100, 100);
    }

    public final void cI(String str, String str2) {
        w.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[]{str, str2});
        if (!this.neO) {
        }
    }

    public final void k(int i, int i2, String str) {
    }

    public final void aGQ() {
    }

    public final void aGR() {
        aGM();
    }

    public final void aGS() {
        aGM();
    }

    public final void aGT() {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
    }
}
