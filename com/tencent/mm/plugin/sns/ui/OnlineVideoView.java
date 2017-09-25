package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.e.a.oq;
import com.tencent.mm.e.a.ot;
import com.tencent.mm.e.a.po;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.u.d;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.File;

public class OnlineVideoView extends RelativeLayout implements com.tencent.mm.plugin.sns.ui.ae.a, com.tencent.mm.pluginsdk.ui.tools.f.a, com.tencent.mm.u.d.a {
    private int duration;
    private String fJz;
    private alh fVV;
    private int fWs;
    private boolean fWt;
    private int fWu;
    private int hFf;
    private d iXd;
    ae klG;
    boolean kmK;
    f kmM;
    private aj kmT;
    ImageView lKn;
    private TextView lKo;
    private boolean lKp;
    private boolean lKq;
    private int lKr;
    private ProgressBar lKt;
    private MMPinProgressBtn lKu;
    private RelativeLayout lMj;
    private Context mContext;
    private b nzx;
    private an pQT;
    private c pXE;
    private a qvA;
    private TextView qvB;
    private ae qvC;
    private boolean qvD;
    private boolean qvE;
    private int qvF;
    private int qvG;
    private long qvH;
    private long qvI;
    private aj qvJ;
    private com.tencent.mm.plugin.sns.model.b.b qvK;
    private c qvL;
    c qvM;
    private long qvN;
    private int qvO;
    private boolean qvp;
    private e qvs;
    private int qvw;
    boolean qvx;
    String qvy;
    private boolean qvz;

    public interface a {
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i) {
        if (onlineVideoView.fWu > 0) {
            w.w("MicroMsg.OnlineVideoView", "send video now, do nothing.");
            return;
        }
        w.i("MicroMsg.OnlineVideoView", "%d retransmit video req code %d, download finish path %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), ap.a(onlineVideoView.fJz, onlineVideoView.fVV)});
        if (bg.mA(ap.a(onlineVideoView.fJz, onlineVideoView.fVV))) {
            onlineVideoView.fWu = i;
            onlineVideoView.n(true, 33);
            onlineVideoView.Xy();
            g.oUh.a(354, 223, 1, false);
            return;
        }
        onlineVideoView.tP(i);
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i, boolean z) {
        if (onlineVideoView.fWs > 0) {
            w.w("MicroMsg.OnlineVideoView", "fav video now, do nothing.");
            return;
        }
        w.i("MicroMsg.OnlineVideoView", "%d fav video req code %d fromMain %b, download finish path %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), Boolean.valueOf(z), ap.a(onlineVideoView.fJz, onlineVideoView.fVV)});
        if (bg.mA(ap.a(onlineVideoView.fJz, onlineVideoView.fVV))) {
            onlineVideoView.fWs = i;
            onlineVideoView.fWt = z;
            onlineVideoView.n(true, 35);
            onlineVideoView.Xy();
            g.oUh.a(354, 224, 1, false);
            return;
        }
        onlineVideoView.S(i, z);
    }

    static /* synthetic */ void p(OnlineVideoView onlineVideoView) {
        w.i("MicroMsg.OnlineVideoView", "%d save video, download finish path %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), ap.a(onlineVideoView.fJz, onlineVideoView.fVV)});
        if (bg.mA(ap.a(onlineVideoView.fJz, onlineVideoView.fVV))) {
            onlineVideoView.qvz = true;
            onlineVideoView.n(true, 34);
            onlineVideoView.Xy();
            g.oUh.a(354, 220, 1, false);
            return;
        }
        onlineVideoView.bjm();
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qvw = 0;
        this.qvx = false;
        this.lKp = false;
        this.kmK = false;
        this.fVV = null;
        this.qvz = false;
        this.qvC = null;
        this.qvE = false;
        this.duration = 0;
        this.qvF = 0;
        this.qvG = 0;
        this.qvH = 0;
        this.qvI = 0;
        this.lKr = 0;
        this.klG = new ae(Looper.getMainLooper());
        this.qvJ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final boolean oQ() {
                if (this.qvR.qvC == null || this.qvR.kmM == null) {
                    return false;
                }
                if (((View) this.qvR.kmM).getAlpha() < 1.0f) {
                    this.qvR.a(true, 1.0f);
                }
                if (this.qvR.kmM.isPlaying()) {
                    this.qvR.aFI();
                }
                try {
                    Object obj;
                    if (bg.mA(this.qvR.qvC.hYc)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        return false;
                    }
                    return this.qvR.qvC.gL(this.qvR.kmM.getCurrentPosition() / 1000);
                } catch (Exception e) {
                    w.e("MicroMsg.OnlineVideoView", "online video timer check error : " + e.toString());
                    return false;
                }
            }
        }, true);
        this.kmT = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final boolean oQ() {
                if (this.qvR.kmM == null) {
                    return false;
                }
                if (((View) this.qvR.kmM).getAlpha() < 1.0f) {
                    this.qvR.a(true, 1.0f);
                }
                if (this.qvR.kmM.isPlaying()) {
                    this.qvR.aFI();
                    this.qvR.kmM.getCurrentPosition();
                }
                return true;
            }
        }, true);
        this.qvK = new com.tencent.mm.plugin.sns.model.b.b(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final void ES(String str) {
            }

            public final void ao(String str, boolean z) {
            }

            public final void bdD() {
            }

            public final void ap(final String str, final boolean z) {
                this.qvR.klG.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 qvS;

                    public final void run() {
                        w.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[]{Integer.valueOf(this.qvS.qvR.hashCode()), Boolean.valueOf(z)});
                        if (this.qvS.qvR.fVV != null && z && bg.eB(this.qvS.qvR.fVV.mQY, str)) {
                            ap.dw(this.qvS.qvR.fJz, "");
                            String a = ap.a(this.qvS.qvR.fJz, this.qvS.qvR.fVV);
                            if (!bg.mA(a)) {
                                this.qvS.qvR.as(a, false);
                            }
                        }
                    }
                }, 100);
            }
        };
        this.qvL = new c<po>(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r2;
                this.usg = po.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                po poVar = (po) bVar;
                w.i("MicroMsg.OnlineVideoView", "%d sns video menu event local id[%s, %s]", new Object[]{Integer.valueOf(this.qvR.hashCode()), poVar.fWr.fJz, this.qvR.fJz});
                if (bg.eB(poVar.fWr.fJz, this.qvR.fJz)) {
                    if (poVar.fWr.fJK == 1) {
                        OnlineVideoView.a(this.qvR, poVar.fWr.fWu);
                    } else if (poVar.fWr.fJK == 2) {
                        OnlineVideoView.a(this.qvR, poVar.fWr.fWs, poVar.fWr.fWt);
                    } else if (poVar.fWr.fJK == 3) {
                        OnlineVideoView.p(this.qvR);
                    }
                }
                return false;
            }
        };
        this.qvM = new c<ot>(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r2;
                this.usg = ot.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                final ot otVar = (ot) bVar;
                w.i("MicroMsg.OnlineVideoView", "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", new Object[]{Integer.valueOf(this.qvR.hashCode()), otVar.fVN.fJz, this.qvR.fJz, Integer.valueOf(otVar.fVN.fJK), Boolean.valueOf(this.qvR.qvE)});
                if (otVar.fVN.fJK == 2) {
                    this.qvR.qvE = false;
                    this.qvR.bjl();
                    this.qvR.onDestroy();
                } else if (otVar.fVN.fJK == 1) {
                    this.qvR.klG.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 qvU;

                        public final void run() {
                            if (!bg.eB(otVar.fVN.fJz, this.qvU.qvR.fJz)) {
                                this.qvU.qvR.qvE = false;
                                this.qvU.qvR.bjl();
                                this.qvU.qvR.onDestroy();
                            } else if (this.qvU.qvR.qvE) {
                                this.qvU.qvR.requestLayout();
                            } else {
                                this.qvU.qvR.qvE = true;
                                this.qvU.qvR.onResume();
                            }
                        }
                    });
                }
                return false;
            }
        };
        this.pXE = new c<kk>(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r2;
                this.usg = kk.class.getName().hashCode();
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private boolean a(com.tencent.mm.e.a.kk r14) {
                /*
                r13 = this;
                r3 = 2;
                r2 = 1;
                r12 = 0;
                r0 = r13.qvR;
                r0 = r0.qvC;
                if (r0 != 0) goto L_0x0023;
            L_0x000b:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d online video helper is null.";
                r2 = new java.lang.Object[r2];
                r3 = r13.qvR;
                r3 = r3.hashCode();
                r3 = java.lang.Integer.valueOf(r3);
                r2[r12] = r3;
                com.tencent.mm.sdk.platformtools.w.w(r0, r1, r2);
            L_0x0022:
                return r12;
            L_0x0023:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.qvC;	 Catch:{ Exception -> 0x0054 }
                r1 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.mediaId;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.GO(r1);	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x0022;
            L_0x0033:
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fEX;	 Catch:{ Exception -> 0x0054 }
                r1 = -21112; // 0xffffffffffffad88 float:NaN double:NaN;
                if (r0 != r1) goto L_0x0070;
            L_0x003b:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ Exception -> 0x0054 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 218; // 0xda float:3.05E-43 double:1.077E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0054 }
                r1 = r0.klG;	 Catch:{ Exception -> 0x0054 }
                r2 = new com.tencent.mm.plugin.sns.ui.OnlineVideoView$9;	 Catch:{ Exception -> 0x0054 }
                r2.<init>(r0);	 Catch:{ Exception -> 0x0054 }
                r1.post(r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0054:
                r0 = move-exception;
                r1 = "MicroMsg.OnlineVideoView";
                r2 = new java.lang.StringBuilder;
                r3 = "online video callback error: ";
                r2.<init>(r3);
                r0 = r0.toString();
                r0 = r2.append(r0);
                r0 = r0.toString();
                com.tencent.mm.sdk.platformtools.w.e(r1, r0);
                goto L_0x0022;
            L_0x0070:
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fEX;	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x00a3;
            L_0x0076:
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fEX;	 Catch:{ Exception -> 0x0054 }
                r1 = -21006; // 0xffffffffffffadf2 float:NaN double:NaN;
                if (r0 == r1) goto L_0x00a3;
            L_0x007e:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d stream download online video error. retCode %d ";
                r2 = 2;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
                r3 = 0;
                r4 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 1;
                r4 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.fEX;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.w(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x00a3:
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fJK;	 Catch:{ Exception -> 0x0054 }
                switch(r0) {
                    case 1: goto L_0x00d0;
                    case 2: goto L_0x0205;
                    case 3: goto L_0x02c9;
                    case 4: goto L_0x02d1;
                    case 5: goto L_0x03c4;
                    case 6: goto L_0x043f;
                    default: goto L_0x00aa;
                };	 Catch:{ Exception -> 0x0054 }
            L_0x00aa:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d unknown event opcode %d";
                r2 = 2;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
                r3 = 0;
                r4 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 1;
                r4 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.fJK;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.w(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x00d0:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r2 = r0.qvC;	 Catch:{ Exception -> 0x0054 }
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.offset;	 Catch:{ Exception -> 0x0054 }
                r4 = (long) r0;	 Catch:{ Exception -> 0x0054 }
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fQP;	 Catch:{ Exception -> 0x0054 }
                r3 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r3 = r3.fQQ;	 Catch:{ Exception -> 0x0054 }
                r6 = "MicroMsg.OnlineVideoViewHelper";
                r7 = "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]";
                r8 = 5;
                r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0054 }
                r9 = 0;
                r10 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 1;
                r10 = r2.hYi;	 Catch:{ Exception -> 0x0054 }
                r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 2;
                r10 = r2.hYc;	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 3;
                r10 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 4;
                r10 = r2.hzq;	 Catch:{ Exception -> 0x0054 }
                r10 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.i(r6, r7, r8);	 Catch:{ Exception -> 0x0054 }
                r6 = r2.hYi;	 Catch:{ Exception -> 0x0054 }
                if (r6 == 0) goto L_0x0128;
            L_0x0118:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "moov had callback, do nothing.";
                com.tencent.mm.sdk.platformtools.w.w(r0, r1);	 Catch:{ Exception -> 0x0054 }
            L_0x0121:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0.qvD = true;	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0128:
                r6 = r2.hzq;	 Catch:{ Exception -> 0x0054 }
                r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
                if (r6 <= 0) goto L_0x0160;
            L_0x012e:
                r2.hzq = r0;	 Catch:{ Exception -> 0x0054 }
                r0 = com.tencent.mm.sdk.platformtools.bg.Nz();	 Catch:{ Exception -> 0x0054 }
                r2.qvZ = r0;	 Catch:{ Exception -> 0x0054 }
                r0 = r2.hYh;	 Catch:{ Exception -> 0x0144 }
                if (r0 != 0) goto L_0x0163;
            L_0x013a:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "parser is null, thread is error.";
                com.tencent.mm.sdk.platformtools.w.w(r0, r1);	 Catch:{ Exception -> 0x0144 }
                goto L_0x0121;
            L_0x0144:
                r0 = move-exception;
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r3 = "deal moov ready error: ";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                r0 = r2.append(r0);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.e(r1, r0);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0121;
            L_0x0160:
                r0 = r2.hzq;	 Catch:{ Exception -> 0x0054 }
                goto L_0x012e;
            L_0x0163:
                r0 = r2.hYh;	 Catch:{ Exception -> 0x0144 }
                r1 = r2.hYd;	 Catch:{ Exception -> 0x0144 }
                r0 = r0.m(r1, r4);	 Catch:{ Exception -> 0x0144 }
                if (r0 == 0) goto L_0x01b8;
            L_0x016d:
                r0 = r2.hYh;	 Catch:{ Exception -> 0x0144 }
                r0 = r0.imd;	 Catch:{ Exception -> 0x0144 }
                r2.hYi = r0;	 Catch:{ Exception -> 0x0144 }
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b";
                r4 = 3;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0144 }
                r5 = 0;
                r6 = r2.hYi;	 Catch:{ Exception -> 0x0144 }
                r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0144 }
                r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
                r5 = 1;
                r6 = r2.hYc;	 Catch:{ Exception -> 0x0144 }
                r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
                r5 = 2;
                r6 = java.lang.Boolean.valueOf(r3);	 Catch:{ Exception -> 0x0144 }
                r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.sdk.platformtools.w.i(r0, r1, r4);	 Catch:{ Exception -> 0x0144 }
                if (r3 != 0) goto L_0x019e;
            L_0x0196:
                r0 = new com.tencent.mm.plugin.sns.ui.ae$1;	 Catch:{ Exception -> 0x0144 }
                r0.<init>(r2);	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.sdk.platformtools.af.v(r0);	 Catch:{ Exception -> 0x0144 }
            L_0x019e:
                r0 = r2.hYj;	 Catch:{ Exception -> 0x0144 }
                r1 = -1;
                if (r0 != r1) goto L_0x01b4;
            L_0x01a3:
                r0 = 1;
                r2.hYg = r0;	 Catch:{ Exception -> 0x0144 }
            L_0x01a6:
                r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ Exception -> 0x0144 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0144 }
                goto L_0x0121;
            L_0x01b4:
                r0 = 2;
                r2.hYg = r0;	 Catch:{ Exception -> 0x0144 }
                goto L_0x01a6;
            L_0x01b8:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "mp4 parse moov error. cdnMediaId %s";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0144 }
                r4 = 0;
                r5 = r2.hYc;	 Catch:{ Exception -> 0x0144 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.sdk.platformtools.w.w(r0, r1, r3);	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.modelvideo.o.KW();	 Catch:{ Exception -> 0x0144 }
                r0 = r2.hYc;	 Catch:{ Exception -> 0x0144 }
                r1 = 0;
                r2 = -1;
                com.tencent.mm.modelcdntran.f.e(r0, r1, r2);	 Catch:{ Exception -> 0x0144 }
                r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ Exception -> 0x0144 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0144 }
                r0 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ Exception -> 0x0144 }
                r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
                r2 = 3;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0144 }
                r3 = 0;
                r4 = 402; // 0x192 float:5.63E-43 double:1.986E-321;
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0144 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
                r3 = 1;
                r4 = com.tencent.mm.sdk.platformtools.bg.Ny();	 Catch:{ Exception -> 0x0144 }
                r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0144 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
                r3 = 2;
                r4 = "";
                r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
                r0.i(r1, r2);	 Catch:{ Exception -> 0x0144 }
                goto L_0x0121;
            L_0x0205:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = r0.qvC;	 Catch:{ Exception -> 0x0054 }
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.mediaId;	 Catch:{ Exception -> 0x0054 }
                r2 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.offset;	 Catch:{ Exception -> 0x0054 }
                r3 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r3 = r3.length;	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r1.hYp = r4;	 Catch:{ Exception -> 0x0054 }
                if (r2 < 0) goto L_0x021e;
            L_0x021c:
                if (r3 >= 0) goto L_0x0246;
            L_0x021e:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "deal data available error offset[%d], length[%d]";
                r4 = 2;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0054 }
                r5 = 0;
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0054 }
                r4[r5] = r2;	 Catch:{ Exception -> 0x0054 }
                r2 = 1;
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0054 }
                r4[r2] = r3;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.w(r0, r1, r4);	 Catch:{ Exception -> 0x0054 }
            L_0x0238:
                r0 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.length;	 Catch:{ Exception -> 0x0054 }
                if (r0 <= 0) goto L_0x0022;
            L_0x023e:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = 1;
                r0.bs(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0246:
                r0 = r1.GO(r0);	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x0238;
            L_0x024c:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r0.<init>();	 Catch:{ Exception -> 0x0054 }
                r4 = r1.hYc;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.append(r4);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.append(r2);	 Catch:{ Exception -> 0x0054 }
                r4 = "_";
                r0 = r0.append(r4);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                r4 = r1.qvV;	 Catch:{ Exception -> 0x0054 }
                r0 = r4.get(r0);	 Catch:{ Exception -> 0x0054 }
                r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x02a4;
            L_0x0274:
                r4 = r0.intValue();	 Catch:{ Exception -> 0x0054 }
                if (r4 <= 0) goto L_0x02a4;
            L_0x027a:
                r0 = r0.intValue();	 Catch:{ Exception -> 0x0054 }
                r1.hYm = r0;	 Catch:{ Exception -> 0x0054 }
            L_0x0280:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r4 = "deal data available. offset[%d] length[%d] cachePlayTime[%d]";
                r5 = 3;
                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0054 }
                r6 = 0;
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0054 }
                r5[r6] = r2;	 Catch:{ Exception -> 0x0054 }
                r2 = 1;
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0054 }
                r5[r2] = r3;	 Catch:{ Exception -> 0x0054 }
                r2 = 2;
                r1 = r1.hYm;	 Catch:{ Exception -> 0x0054 }
                r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0054 }
                r5[r2] = r1;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.i(r0, r4, r5);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0238;
            L_0x02a4:
                r0 = r1.hYh;	 Catch:{ Exception -> 0x02ad }
                r0 = r0.bi(r2, r3);	 Catch:{ Exception -> 0x02ad }
                r1.hYm = r0;	 Catch:{ Exception -> 0x02ad }
                goto L_0x0280;
            L_0x02ad:
                r0 = move-exception;
                r4 = "MicroMsg.OnlineVideoViewHelper";
                r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r6 = "deal data available file pos to video time error: ";
                r5.<init>(r6);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                r0 = r5.append(r0);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.e(r4, r0);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0280;
            L_0x02c9:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = 1;
                r0.bs(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x02d1:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d";
                r2 = 4;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
                r3 = 0;
                r4 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 1;
                r4 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.mediaId;	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 2;
                r4 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.fWu;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 3;
                r4 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.fWs;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.qvC;	 Catch:{ Exception -> 0x0054 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal stream finish. playStatus %d cdnMediaId %s";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r5 = r0.hYg;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 1;
                r5 = r0.hYc;	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
                r1 = 0;
                r0.hYp = r1;	 Catch:{ Exception -> 0x0054 }
                r1 = 3;
                r0.hYf = r1;	 Catch:{ Exception -> 0x0054 }
                r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ Exception -> 0x0054 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 206; // 0xce float:2.89E-43 double:1.02E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0054 }
                r1 = r0.hYg;	 Catch:{ Exception -> 0x0054 }
                if (r1 != 0) goto L_0x0367;
            L_0x0341:
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "it had not moov callback and download finish start to play video.";
                com.tencent.mm.sdk.platformtools.w.w(r1, r2);	 Catch:{ Exception -> 0x0054 }
                r0.bjx();	 Catch:{ Exception -> 0x0054 }
            L_0x034d:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fWu;	 Catch:{ Exception -> 0x0054 }
                if (r0 <= 0) goto L_0x0388;
            L_0x0355:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0.aFI();	 Catch:{ Exception -> 0x0054 }
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.fWu;	 Catch:{ Exception -> 0x0054 }
                r0.tP(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0367:
                r1 = r0.hYg;	 Catch:{ Exception -> 0x0054 }
                r2 = 5;
                if (r1 != r2) goto L_0x034d;
            L_0x036c:
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r3 = "it had play error, it request all video data finish, start to play.";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0054 }
                r3 = r0.hYc;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0054 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.w(r1, r2);	 Catch:{ Exception -> 0x0054 }
                r0.bjx();	 Catch:{ Exception -> 0x0054 }
                goto L_0x034d;
            L_0x0388:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fWs;	 Catch:{ Exception -> 0x0054 }
                if (r0 <= 0) goto L_0x03a8;
            L_0x0390:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0.aFI();	 Catch:{ Exception -> 0x0054 }
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.fWs;	 Catch:{ Exception -> 0x0054 }
                r2 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.fWt;	 Catch:{ Exception -> 0x0054 }
                r0.S(r1, r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x03a8:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.qvz;	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x03bc;
            L_0x03b0:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0.aFI();	 Catch:{ Exception -> 0x0054 }
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0.bjm();	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x03bc:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = 1;
                r0.bs(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x03c4:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.qvw;	 Catch:{ Exception -> 0x0054 }
                if (r0 != r2) goto L_0x0428;
            L_0x03cc:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.qvC;	 Catch:{ Exception -> 0x0054 }
                r1 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.mediaId;	 Catch:{ Exception -> 0x0054 }
                r2 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.offset;	 Catch:{ Exception -> 0x0054 }
                r3 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r3 = r3.length;	 Catch:{ Exception -> 0x0054 }
                r1 = r0.GO(r1);	 Catch:{ Exception -> 0x0054 }
                if (r1 == 0) goto L_0x041d;
            L_0x03e4:
                r0.progress = r2;	 Catch:{ Exception -> 0x0054 }
                r0.piG = r3;	 Catch:{ Exception -> 0x0054 }
                r1 = r0.progress;	 Catch:{ Exception -> 0x0054 }
                r1 = r1 * 100;
                r2 = r0.piG;	 Catch:{ Exception -> 0x0054 }
                r1 = r1 / r2;
                r0.qvX = r1;	 Catch:{ Exception -> 0x0054 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]";
                r3 = 4;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r5 = r0.hYc;	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 1;
                r5 = r0.progress;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 2;
                r5 = r0.piG;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 3;
                r5 = r0.qvX;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
            L_0x041d:
                r1 = r0.qvX;	 Catch:{ Exception -> 0x0054 }
                r2 = 100;
                if (r1 < r2) goto L_0x0022;
            L_0x0423:
                r1 = 3;
                r0.hYf = r1;	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0428:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.qvw;	 Catch:{ Exception -> 0x0054 }
                if (r0 != r3) goto L_0x0022;
            L_0x0430:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r1 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.offset;	 Catch:{ Exception -> 0x0054 }
                r2 = r14.fQO;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.length;	 Catch:{ Exception -> 0x0054 }
                r0.klG.post(new com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass12(r0, r1, r2));	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x043f:
                r0 = r13.qvR;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.qvC;	 Catch:{ Exception -> 0x0054 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal had dup video. cdnMediaId %s";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r5 = r0.hYc;	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
                r0.bjx();	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.OnlineVideoView.5.a(com.tencent.mm.e.a.kk):boolean");
            }
        };
        this.qvs = new e(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final void aMm() {
                w.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[]{Integer.valueOf(this.qvR.hashCode())});
                try {
                    this.qvR.a(true, 1.0f);
                } catch (Exception e) {
                    w.e("MicroMsg.OnlineVideoView", "texture view update. error " + e.toString());
                }
            }
        };
        this.nzx = new b(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final long aKm() {
                w.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[]{Integer.valueOf(this.qvR.hashCode())});
                h.vJ();
                h.vI().vr().a(com.tencent.mm.storage.w.a.uGb, Boolean.valueOf(true));
                try {
                    if (this.qvR.qvD && this.qvR.qvC != null) {
                        return (long) this.qvR.qvC.hYm;
                    }
                } catch (Exception e) {
                }
                return 0;
            }
        };
        this.mContext = context;
        w.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(context).inflate(i.g.pIy, this);
        this.lKn = (ImageView) findViewById(i.f.cMj);
        this.lMj = (RelativeLayout) findViewById(i.f.cMi);
        this.qvB = (TextView) findViewById(i.f.cLN);
        this.qvB.setVisibility(8);
        this.lKu = (MMPinProgressBtn) findViewById(i.f.cLY);
        this.lKt = (ProgressBar) findViewById(i.f.cLT);
        this.lKo = (TextView) findViewById(i.f.cMl);
        com.tencent.mm.modelcontrol.d.Eu();
        if (com.tencent.mm.modelcontrol.d.EB()) {
            this.lKq = true;
            this.kmM = new VideoPlayerTextureView(context);
            ((VideoPlayerTextureView) this.kmM).nzx = this.nzx;
            ((VideoPlayerTextureView) this.kmM).sWO = true;
            g.oUh.a(354, 148, 1, false);
        } else {
            this.lKq = false;
            this.kmM = new VideoTextureView(context);
            g.oUh.a(354, 149, 1, false);
        }
        this.kmM.a(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.lMj.addView((View) this.kmM, layoutParams);
        a(false, 0.0f);
    }

    public final void bjl() {
        w.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[]{Integer.valueOf(hashCode())});
        com.tencent.mm.sdk.b.a.urY.c(this.qvM);
    }

    public final void a(alh com_tencent_mm_protocal_c_alh, String str, int i) {
        this.fJz = str;
        this.hFf = i;
        an bLV = an.bLV();
        bLV.cIm = this.hFf;
        this.pQT = bLV;
        if (this.fVV != com_tencent_mm_protocal_c_alh) {
            this.fVV = com_tencent_mm_protocal_c_alh;
            boolean c = com.tencent.mm.plugin.sns.model.ae.beI().c(this.fVV, this.lKn, i.e.black, this.mContext.hashCode(), this.pQT);
            w.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(c)});
        }
        this.qvx = false;
        w.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", new Object[]{Integer.valueOf(hashCode()), this.fJz, Integer.valueOf(this.hFf), Boolean.valueOf(this.qvx)});
    }

    public final void onResume() {
        w.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[]{Integer.valueOf(hashCode()), bg.bJZ()});
        this.qvH = bg.Nz();
        if (this.qvC == null) {
            w.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[]{Integer.valueOf(hashCode())});
            this.qvC = new ae(this);
            com.tencent.mm.sdk.b.a.urY.b(this.pXE);
            com.tencent.mm.sdk.b.a.urY.b(this.qvL);
            com.tencent.mm.plugin.sns.model.ae.beG().a(this.qvK);
            this.iXd = new d();
            this.iXd.a(this);
            if (com.tencent.mm.n.a.oH() != null) {
                com.tencent.mm.n.a.oH().pS();
            }
        }
        if (!this.lKp) {
            bji();
        }
        this.qvp = true;
    }

    public final void onPause() {
        w.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[]{Integer.valueOf(hashCode()), bg.bJZ()});
        bjn();
        if (this.kmM != null) {
            this.kmM.stop();
        }
    }

    public final void onDestroy() {
        w.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[]{Integer.valueOf(hashCode()), bg.bJZ()});
        this.qvI = bg.Nz();
        w.i("MicroMsg.OnlineVideoView", "%d logic unInit", new Object[]{Integer.valueOf(hashCode())});
        bjq();
        this.kmM.stop();
        com.tencent.mm.sdk.b.a.urY.c(this.pXE);
        com.tencent.mm.sdk.b.a.urY.c(this.qvL);
        com.tencent.mm.plugin.sns.model.ae.beG().b(this.qvK);
        bjn();
        this.klG.removeCallbacksAndMessages(null);
        if (this.qvC != null) {
            this.qvC.bjw();
            this.qvC.clear();
        }
        if (com.tencent.mm.n.a.oH() != null) {
            com.tencent.mm.n.a.oH().pR();
        }
        if (this.iXd != null) {
            this.iXd.aS(false);
        }
        this.iXd = null;
        this.fVV = null;
        this.fJz = null;
        this.qvC = null;
        this.qvG = 0;
    }

    private void tP(int i) {
        String str = am.du(com.tencent.mm.plugin.sns.model.ae.getAccSnsPath(), this.fVV.mQY) + com.tencent.mm.plugin.sns.data.i.e(this.fVV);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        w.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[]{str, Integer.valueOf(i)});
        com.tencent.mm.bb.d.a(this.mContext, ".ui.transmit.SelectConversationUI", intent, i);
        this.fWu = 0;
    }

    private void S(final int i, final boolean z) {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView qvR;

            public final void run() {
                m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(this.qvR.fJz);
                if (Gg != null) {
                    w.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[]{this.qvR.fJz, Integer.valueOf(i), Boolean.valueOf(z)});
                    cb cbVar = new cb();
                    cbVar.fFA.fFH = i;
                    cbVar.fFA.activity = (Activity) this.qvR.mContext;
                    com.tencent.mm.plugin.sns.i.a.a(cbVar, Gg);
                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    if (cbVar.fFB.ret == 0) {
                        g.oUh.a(354, 225, 1, false);
                    } else {
                        g.oUh.a(354, 226, 1, false);
                    }
                    if (z) {
                        com.tencent.mm.sdk.b.b oqVar = new oq();
                        oqVar.fVK.fGN = Gg.bhy();
                        oqVar.fVK.fVJ = com.tencent.mm.plugin.sns.data.i.g(Gg);
                        com.tencent.mm.sdk.b.a.urY.m(oqVar);
                    }
                    this.qvR.fWs = 0;
                    if (this.qvR.kmM == null) {
                        return;
                    }
                    if (bg.mA(this.qvR.kmM.Ls())) {
                        w.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[]{Integer.valueOf(this.qvR.hashCode())});
                        String a = ap.a(this.qvR.fJz, this.qvR.fVV);
                        if (!bg.mA(a)) {
                            this.qvR.as(a, false);
                        }
                    } else if (!this.qvR.kmM.isPlaying()) {
                        this.qvR.kmM.start();
                    }
                }
            }
        });
    }

    private void bjm() {
        long NA = bg.NA();
        String lI = t.lI(ap.a(this.fJz, this.fVV));
        if (bg.mA(lI)) {
            Toast.makeText(this.mContext, this.mContext.getString(j.fal), 1).show();
            g.oUh.a(354, 222, 1, false);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(j.fam, new Object[]{lI}), 1).show();
            com.tencent.mm.platformtools.d.b(lI, this.mContext);
            g.oUh.a(354, 221, 1, false);
        }
        this.qvz = false;
        w.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(bg.aB(NA)), r0});
        this.klG.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final void run() {
                if (this.qvR.kmM == null) {
                    return;
                }
                if (bg.mA(this.qvR.kmM.Ls())) {
                    w.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[]{Integer.valueOf(this.qvR.hashCode())});
                    String a = ap.a(this.qvR.fJz, this.qvR.fVV);
                    if (!bg.mA(a)) {
                        this.qvR.as(a, false);
                    }
                } else if (!this.qvR.kmM.isPlaying()) {
                    this.qvR.kmM.start();
                }
            }
        });
    }

    private void a(final boolean z, final float f) {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView qvR;

            public final void run() {
                w.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[]{Integer.valueOf(this.qvR.hashCode()), Boolean.valueOf(z), Float.valueOf(f)});
                View view = (View) this.qvR.kmM;
                if (z) {
                    this.qvR.lMj.setAlpha(f);
                    this.qvR.lMj.setVisibility(0);
                    view.setAlpha(f);
                    view.setVisibility(0);
                    if (((double) f) >= 1.0d) {
                        this.qvR.lKn.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.qvR.lMj.setVisibility(8);
                view.setVisibility(8);
                this.qvR.lKn.setVisibility(0);
            }
        });
    }

    private void bji() {
        String str;
        if (this.qvx) {
            str = this.qvy;
        } else {
            str = ap.a(this.fJz, this.fVV);
        }
        w.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[]{Integer.valueOf(hashCode()), this.fJz, str, Boolean.valueOf(this.qvx)});
        if (bg.mA(str)) {
            a(false, 0.0f);
            n(false, 0);
            Xy();
            return;
        }
        w.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[]{Integer.valueOf(hashCode())});
        a(true, 0.0f);
        as(str, false);
    }

    private void n(boolean z, int i) {
        if (this.fVV == null) {
            w.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[]{Integer.valueOf(hashCode())});
        } else if (this.qvC == null) {
            w.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[]{Integer.valueOf(hashCode())});
        } else if (this.fVV.tPh == 2) {
            w.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[]{Integer.valueOf(hashCode())});
            this.qvw = 3;
            com.tencent.mm.plugin.sns.model.ae.beG().a(this.fVV, 4, null, this.pQT);
        } else {
            boolean z2;
            int i2;
            ae aeVar;
            alh com_tencent_mm_protocal_c_alh;
            int i3;
            String str;
            if (!z) {
                com.tencent.mm.modelcontrol.d.Eu();
                if (com.tencent.mm.modelcontrol.d.EA()) {
                    w.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[]{Integer.valueOf(hashCode())});
                    this.qvw = 1;
                    z2 = true;
                    if (i == 0) {
                        i = 30;
                    }
                    i2 = i;
                    aeVar = this.qvC;
                    com_tencent_mm_protocal_c_alh = this.fVV;
                    i3 = this.hFf;
                    str = this.fJz;
                    aeVar.fVV = com_tencent_mm_protocal_c_alh;
                    aeVar.hFf = i3;
                    aeVar.fGN = str;
                    aeVar.hYd = ap.C(com_tencent_mm_protocal_c_alh);
                    aeVar.hYc = ap.ap(i3, com_tencent_mm_protocal_c_alh.msN);
                    if (!bg.mA(aeVar.hYd) && !bg.mA(aeVar.hYc)) {
                        w.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[]{aeVar.hYc, Boolean.valueOf(z2)});
                        com.tencent.mm.plugin.sns.model.ae.beJ().a(com_tencent_mm_protocal_c_alh, i3, str, z2, true, i2);
                        aeVar.hYf = 1;
                        aeVar.hzq = bg.Nz();
                        if (z2) {
                            g.oUh.a(354, 201, 1, false);
                            return;
                        } else {
                            g.oUh.a(354, 202, 1, false);
                            return;
                        }
                    }
                }
            }
            w.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[]{Integer.valueOf(hashCode())});
            this.qvw = 2;
            z2 = false;
            if (i == 0) {
                i = 31;
            }
            i2 = i;
            aeVar = this.qvC;
            com_tencent_mm_protocal_c_alh = this.fVV;
            i3 = this.hFf;
            str = this.fJz;
            aeVar.fVV = com_tencent_mm_protocal_c_alh;
            aeVar.hFf = i3;
            aeVar.fGN = str;
            aeVar.hYd = ap.C(com_tencent_mm_protocal_c_alh);
            aeVar.hYc = ap.ap(i3, com_tencent_mm_protocal_c_alh.msN);
            if (!bg.mA(aeVar.hYd)) {
            }
        }
    }

    private void Xy() {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final void run() {
                w.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[]{Integer.valueOf(this.qvR.hashCode()), Integer.valueOf(this.qvR.qvw)});
                if (this.qvR.qvw == 1) {
                    if (!(this.qvR.lKt == null || this.qvR.lKt.getVisibility() == 0)) {
                        this.qvR.lKt.setVisibility(0);
                    }
                    if (!(this.qvR.lKu == null || this.qvR.lKu.getVisibility() == 8)) {
                        this.qvR.lKu.setVisibility(8);
                    }
                }
                if (this.qvR.qvw == 2) {
                    if (!(this.qvR.lKu == null || this.qvR.lKu.getVisibility() == 0)) {
                        this.qvR.lKu.setVisibility(0);
                    }
                    if (!(this.qvR.lKt == null || this.qvR.lKt.getVisibility() == 8)) {
                        this.qvR.lKt.setVisibility(8);
                    }
                }
                if (this.qvR.qvw == 3) {
                    if (!(this.qvR.lKu == null || this.qvR.lKu.getVisibility() == 0)) {
                        this.qvR.lKu.setVisibility(0);
                        this.qvR.lKu.caB();
                    }
                    if (this.qvR.lKt != null && this.qvR.lKt.getVisibility() != 8) {
                        this.qvR.lKt.setVisibility(8);
                    }
                }
            }
        });
    }

    private void aFI() {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView qvR;

            {
                this.qvR = r1;
            }

            public final void run() {
                if (!(this.qvR.lKt == null || this.qvR.lKt.getVisibility() == 8)) {
                    w.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[]{Integer.valueOf(this.qvR.hashCode())});
                    this.qvR.lKt.setVisibility(8);
                }
                if (this.qvR.lKu != null && this.qvR.lKu.getVisibility() != 8) {
                    w.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[]{Integer.valueOf(this.qvR.hashCode())});
                    this.qvR.lKu.setVisibility(8);
                }
            }
        });
    }

    protected final void bs(boolean z) {
        if (!this.qvD) {
            this.kmT.v(500, 500);
        } else if (z) {
            af.v(new Runnable(this) {
                final /* synthetic */ OnlineVideoView qvR;

                {
                    this.qvR = r1;
                }

                public final void run() {
                    if (!(this.qvR.kmM == null || this.qvR.qvC == null)) {
                        this.qvR.qvC.gL(this.qvR.kmM.getCurrentPosition() / 1000);
                    }
                    this.qvR.qvJ.v(500, 500);
                }
            });
        } else {
            this.qvJ.v(500, 500);
        }
    }

    protected final void bjn() {
        this.qvJ.KH();
        this.kmT.KH();
    }

    public final void onError(int i, int i2) {
        w.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.qvD), Boolean.valueOf(this.lKq)});
        if (this.qvD) {
            g.oUh.a(354, 230, 1, false);
        } else {
            g.oUh.a(354, 231, 1, false);
        }
        this.lKr = i2;
        bjq();
        final String Ls = this.kmM.Ls();
        this.qvF = this.kmM.getCurrentPosition() / 1000;
        if (this.qvD) {
            if (i == -2) {
                this.kmM.stop();
            } else if (i == -3) {
                this.qvG = i;
                this.kmM.pause();
            }
            try {
                Xy();
                if (this.qvC != null) {
                    ae aeVar = this.qvC;
                    String str = aeVar.hYc + 0 + "_-1";
                    if (!aeVar.qvV.containsKey(str)) {
                        w.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[]{aeVar.hYc});
                        o.KW();
                        com.tencent.mm.modelcdntran.f.e(aeVar.hYc, 0, -1);
                        aeVar.qvV.put(str, Integer.valueOf(0));
                        g.oUh.a(354, 207, 1, false);
                        g.oUh.i(13836, new Object[]{Integer.valueOf(403), Long.valueOf(bg.Ny()), ""});
                    }
                    aeVar.hYg = 5;
                    aeVar.hYl = true;
                    aeVar.hYo = false;
                }
                bjq();
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.kmM.stop();
        this.lKp = true;
        a(false, 0.0f);
        if (!bg.mA(Ls)) {
            w.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[]{Integer.valueOf(hashCode())});
            this.klG.post(new Runnable(this) {
                final /* synthetic */ OnlineVideoView qvR;

                public final void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(Ls)), "video/*");
                    try {
                        this.qvR.getContext().startActivity(intent);
                    } catch (Exception e) {
                        w.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.g.h(this.qvR.getContext(), j.eiL, j.eiM);
                    }
                }
            });
        }
    }

    public final void Uc() {
        w.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.lKr), Integer.valueOf(this.qvF)});
        this.lKr = 0;
        if (this.qvF > 0) {
            pu(this.qvF);
            this.qvF = 0;
            return;
        }
        this.qvG = 0;
        aFI();
        bjp();
        this.kmM.start();
        this.duration = this.kmM.getDuration() / 1000;
        w.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.fJz});
        bs(false);
    }

    public final void oW() {
        w.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        if (this.qvA != null) {
            return;
        }
        if (com.tencent.mm.compatible.util.d.eq(18) || !this.lKq) {
            pu(0);
        } else if (this.kmM != null) {
            String Ls = this.kmM.Ls();
            this.kmM.stop();
            as(Ls, this.qvD);
        }
    }

    public final int bI(int i, int i2) {
        return 0;
    }

    public final void bp(int i, int i2) {
    }

    public final void as(String str, boolean z) {
        w.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), str});
        if (bg.mA(str)) {
            w.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        this.qvD = z;
        if (this.kmM != null) {
            VideoPlayerTextureView videoPlayerTextureView;
            if (this.qvG != -3) {
                if (this.kmM instanceof VideoPlayerTextureView) {
                    boolean c;
                    videoPlayerTextureView = (VideoPlayerTextureView) this.kmM;
                    if (this.qvD) {
                        h.vJ();
                        c = h.vI().vr().c(com.tencent.mm.storage.w.a.uGb, false);
                    } else {
                        c = false;
                    }
                    videoPlayerTextureView.fB(c);
                    ((VideoPlayerTextureView) this.kmM).fC(z);
                }
                this.kmM.a(this.qvs);
                this.kmM.setVideoPath(str);
                a(true, 0.0f);
            } else {
                w.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", new Object[]{Integer.valueOf(hashCode())});
                if (this.kmM instanceof VideoPlayerTextureView) {
                    videoPlayerTextureView = (VideoPlayerTextureView) this.kmM;
                    w.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[]{Integer.valueOf(videoPlayerTextureView.hashCode())});
                    if (videoPlayerTextureView.sWJ != null) {
                        com.tencent.mm.plugin.s.i iVar = videoPlayerTextureView.sWJ;
                        if (iVar.nzQ != null) {
                            iVar.nzQ.aKB();
                        }
                    }
                }
                pu(this.qvF);
            }
        }
        h.vJ();
        if (((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uEZ, Integer.valueOf(0))).intValue() == 1) {
            this.lKo.setText(com.tencent.mm.plugin.sight.base.d.AN(str));
            this.lKo.setVisibility(0);
        }
    }

    public final boolean bjo() {
        w.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[]{Integer.valueOf(hashCode())});
        if (this.kmM.isPlaying()) {
            return true;
        }
        bjp();
        boolean start = this.kmM.start();
        aFI();
        return start;
    }

    public final void KG() {
        w.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[]{Integer.valueOf(hashCode())});
        bjq();
        Xy();
        if (this.kmM.isPlaying()) {
            w.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[]{Integer.valueOf(hashCode())});
            bjq();
            this.kmM.pause();
        }
    }

    public final void pu(int i) {
        w.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(true)});
        this.qvG = 0;
        aFI();
        this.kmM.c((double) (i * 1000), true);
        bs(false);
    }

    private void bjp() {
        this.qvN = bg.Nz();
        w.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.qvN)});
    }

    private void bjq() {
        if (this.qvN > 0) {
            this.qvO = (int) (((long) this.qvO) + ((bg.Nz() - this.qvN) / 1000));
        }
        w.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.qvO)});
        this.qvN = 0;
    }

    public final int bjr() {
        if (this.qvO < 0) {
            this.qvO = 0;
        }
        w.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.qvO)});
        return this.qvO;
    }

    public final int bjs() {
        return this.lKr;
    }

    public final int bjt() {
        int i;
        if (this.qvI <= 0 || this.qvH <= 0) {
            i = 0;
        } else {
            i = (int) (this.qvI - this.qvH);
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
