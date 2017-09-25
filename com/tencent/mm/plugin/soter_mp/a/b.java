package com.tencent.mm.plugin.soter_mp.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.b.c.a;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter_mp.b.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;

public final class b extends c implements e {
    public a lOA = null;
    public TextView nte = null;
    public boolean qQH = false;
    private h qQI = null;
    public ImageView qQJ = null;
    private final int qQK = 3;
    private int qQL = 0;
    private final long qQM = 500;
    Animation qQN = null;
    Animation qQO = null;
    public Runnable qQP = new Runnable(this) {
        final /* synthetic */ b qQQ;

        {
            this.qQQ = r1;
        }

        public final void run() {
            this.qQQ.nte.setTextColor(this.qQQ.nte.getResources().getColor(R.e.aUm));
            this.qQQ.nte.setText(this.qQQ.nte.getResources().getString(R.l.eWZ));
            this.qQQ.qQJ.setImageResource(R.k.bPX);
        }
    };

    class AnonymousClass7 implements AnimationListener {
        final /* synthetic */ CharSequence li;
        final /* synthetic */ b qQQ;

        AnonymousClass7(b bVar, CharSequence charSequence) {
            this.qQQ = bVar;
            this.li = charSequence;
        }

        public final void onAnimationStart(Animation animation) {
            this.qQQ.qQJ.setImageResource(R.k.dxl);
            this.qQQ.nte.setText(this.li);
            this.qQQ.nte.setTextColor(this.qQQ.nte.getResources().getColor(R.e.aWq));
            this.qQQ.nte.removeCallbacks(this.qQQ.qQP);
        }

        public final void onAnimationEnd(Animation animation) {
            this.qQQ.nte.post(this.qQQ.qQP);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public b(WeakReference<Activity> weakReference, c cVar, d dVar) {
        super(weakReference, cVar, dVar);
    }

    @TargetApi(23)
    public final void cQ() {
        if (!com.tencent.d.a.a.hd(ab.getContext())) {
            this.qQV.errCode = 90011;
            this.qQV.fPf = "no fingerprint enrolled";
            bmg();
        }
        try {
            if (ab.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                String[] strArr = new String[]{"android.permission.USE_FINGERPRINT"};
                if (SoterAuthenticationUI.qRb != null) {
                    Message obtainMessage = SoterAuthenticationUI.qRb.obtainMessage(3);
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("permissions", strArr);
                    bundle.putInt("request_code", 0);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    return;
                }
                w.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
                return;
            }
            this.qQH = true;
        } catch (NoSuchMethodError e) {
            w.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.qQH = true;
        }
    }

    private boolean bmb() {
        if (SoterAuthenticationUI.qRb != null) {
            SoterAuthenticationUI.qRb.obtainMessage(4).sendToTarget();
        } else {
            w.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
        w.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>(this) {
            final /* synthetic */ b qQQ;

            {
                this.qQQ = r1;
            }

            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                w.i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fPf});
                c.bmd();
                if (cVar.isSuccess()) {
                    this.qQQ.hR(false);
                } else {
                    com.tencent.mm.plugin.soter.c.a.dj(2, cVar.errCode);
                }
                if (cVar.errCode == 12) {
                    w.e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
                    this.qQQ.qQV.errCode = 90007;
                    this.qQQ.qQV.fPf = "auth key can not be retrieved";
                    this.qQQ.bmg();
                } else if (cVar.errCode == 5) {
                    w.v("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
                    com.tencent.d.b.a.De(2);
                    this.qQQ.qQV.errCode = 90007;
                    this.qQQ.qQV.fPf = "auth key generate failed";
                    this.qQQ.bmg();
                } else if (cVar.errCode == 10) {
                    w.i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
                    com.tencent.d.b.a.De(2);
                    this.qQQ.qQV.errCode = 90007;
                    this.qQQ.qQV.fPf = "auth key update error";
                    this.qQQ.bmg();
                }
            }
        }, false, 2, new com.tencent.mm.plugin.soter_mp.b.b(), new com.tencent.mm.plugin.soter.b.e());
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 0) {
            return;
        }
        if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
            w.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
            this.qQV.errCode = 90002;
            this.qQV.fPf = "user not grant to use fingerprint";
            bmg();
            return;
        }
        w.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        bmb();
        this.qQH = true;
    }

    @TargetApi(16)
    public final void hR(boolean z) {
        if (this.qQI == null || !this.qQI.isShowing()) {
            if (this.qQW == null || this.qQW.get() == null) {
                w.e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
                this.qQV.errCode = 90007;
                this.qQV.fPf = "internal error occurred: ui released";
                bmg();
            } else {
                if (this.qQI == null) {
                    Activity activity = (Activity) this.qQW.get();
                    h.a aVar = new h.a(activity);
                    View inflate = activity.getLayoutInflater().inflate(R.i.dde, null, false);
                    this.qQJ = (ImageView) inflate.findViewById(R.h.bPX);
                    this.nte = (TextView) inflate.findViewById(R.h.bPZ);
                    ((TextView) inflate.findViewById(R.h.bPW)).setText(this.qQU.content);
                    aVar.dd(inflate);
                    aVar.kK(true);
                    aVar.Aa(R.l.dGs).b(new OnClickListener(this) {
                        final /* synthetic */ b qQQ;

                        {
                            this.qQQ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
                            this.qQQ.lOA.mh(true);
                            this.qQQ.bmf();
                        }
                    });
                    aVar.d(new OnCancelListener(this) {
                        final /* synthetic */ b qQQ;

                        {
                            this.qQQ = r1;
                        }

                        @TargetApi(16)
                        public final void onCancel(DialogInterface dialogInterface) {
                            w.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
                            this.qQQ.bmf();
                        }
                    });
                    this.qQI = aVar.WJ();
                    c.a(this.qQI);
                    this.qQI.setCanceledOnTouchOutside(false);
                }
                if (!this.qQI.isShowing()) {
                    this.qQI.show();
                }
            }
        }
        if (z) {
            boolean z2;
            if (VERSION.SDK_INT < 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                w.i("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
                return;
            }
        }
        if (this.lOA != null) {
            w.e("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
            this.lOA.mh(true);
            af.f(new Runnable(this) {
                final /* synthetic */ b qQQ;

                {
                    this.qQQ = r1;
                }

                public final void run() {
                    this.qQQ.lOA = new a();
                    this.qQQ.bmc();
                }
            }, 500);
            return;
        }
        bmc();
    }

    public final void bmc() {
        this.lOA = new a();
        com.tencent.d.b.a.b anonymousClass3 = new com.tencent.d.b.a.b<com.tencent.d.b.a.a>(this) {
            final /* synthetic */ b qQQ;

            {
                this.qQQ = r1;
            }

            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                final com.tencent.d.b.a.a aVar = (com.tencent.d.b.a.a) eVar;
                w.i("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(aVar.errCode), aVar.fPf});
                this.qQQ.qQH = false;
                if (aVar.isSuccess()) {
                    af.f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 qQS;

                        public final void run() {
                            com.tencent.d.a.c.h hVar = (com.tencent.d.a.c.h) aVar.wZO;
                            this.qQS.qQQ.qQV.errCode = 0;
                            this.qQS.qQQ.qQV.fPf = "OK";
                            this.qQS.qQQ.qQV.qQY = (byte) 1;
                            this.qQS.qQQ.qQV.fUG = hVar.wZN;
                            this.qQS.qQQ.qQV.qQZ = hVar.signature;
                            this.qQS.qQQ.bme();
                        }
                    }, 500);
                    return;
                }
                com.tencent.mm.plugin.soter.c.a.dj(3, aVar.errCode);
                if (aVar.errCode == 13 || aVar.errCode == 20) {
                    w.i("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
                    com.tencent.d.b.a.De(2);
                    this.qQQ.qQV.errCode = 90007;
                    this.qQQ.qQV.fPf = "start fingerprint authen failed";
                } else if (aVar.errCode == 25) {
                    this.qQQ.qQV.errCode = 90010;
                    this.qQQ.qQV.fPf = "authenticate freeze. please try again later";
                } else {
                    this.qQQ.qQV.errCode = 90007;
                    this.qQQ.qQV.fPf = "authenticate error: " + aVar.fPf;
                }
                this.qQQ.bmg();
            }
        };
        com.tencent.d.b.c.b anonymousClass4 = new com.tencent.d.b.c.b(this) {
            final /* synthetic */ b qQQ;

            {
                this.qQQ = r1;
            }

            public final void avw() {
                w.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
                this.qQQ.qQH = true;
            }

            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                w.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), charSequence});
            }

            public final void avx() {
                w.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
                this.qQQ.qQH = false;
                this.qQQ.lOA = null;
                b bVar = this.qQQ;
                bVar.nte.removeCallbacks(bVar.qQP);
                bVar.qQJ.setImageResource(R.k.dxm);
                bVar.nte.setTextColor(bVar.nte.getResources().getColor(R.e.aVW));
                bVar.nte.setText(bVar.nte.getResources().getString(R.l.eXa));
            }

            public final void onAuthenticationFailed() {
                w.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
                b bVar = this.qQQ;
                CharSequence string = ab.getContext().getString(R.l.eWY);
                if (bVar.qQN == null) {
                    bVar.qQN = com.tencent.mm.ui.c.a.eH(bVar.qQJ.getContext());
                }
                if (bVar.qQO == null) {
                    bVar.qQO = com.tencent.mm.ui.c.a.eH(bVar.qQJ.getContext());
                }
                bVar.qQN.setAnimationListener(new AnonymousClass7(bVar, string));
                bVar.nte.startAnimation(bVar.qQN);
                bVar.qQJ.startAnimation(bVar.qQO);
                af.f(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qQT;

                    {
                        this.qQT = r1;
                    }

                    public final void run() {
                        this.qQT.qQQ.qQH = false;
                        this.qQT.qQQ.hR(true);
                    }
                }, 500);
            }

            public final void avy() {
                w.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
                this.qQQ.lOA = null;
            }

            public final void onAuthenticationError(int i, CharSequence charSequence) {
                w.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), charSequence});
            }
        };
        com.tencent.d.b.f.b.a VK = new com.tencent.d.b.f.b.a().Df(2).ho(ab.getContext()).a(this.lOA).VK(this.qQU.lOH);
        VK.xan.xal = null;
        com.tencent.d.b.a.a(anonymousClass3, VK.a(anonymousClass4).xan);
    }

    public final void onResume() {
        if (this.qQH) {
            bmb();
        }
    }

    @TargetApi(16)
    public final void onPause() {
        if (this.qQH && this.lOA != null) {
            this.lOA.mh(true);
        }
        if (this.qQI != null && this.qQI.isShowing()) {
            this.qQI.dismiss();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }
}
