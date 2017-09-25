package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.account.h;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@a(3)
public class ShareToFacebookRedirectUI extends MMActivity implements e {
    private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
    private String isL;
    private String isM;
    private String isN;
    private String isO;
    private p isP;

    static /* synthetic */ void a(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        w.e(TAG, "dealWithRefreshTokenFail");
        shareToFacebookRedirectUI.av(shareToFacebookRedirectUI.uSU.uTo.getString(R.l.dIO), shareToFacebookRedirectUI.uSU.uTo.getString(R.l.ehf));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(433, this);
        this.isL = getIntent().getStringExtra("title");
        this.isM = getIntent().getStringExtra("digest");
        this.isN = getIntent().getStringExtra("img");
        this.isO = getIntent().getStringExtra("link");
        w.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[]{this.isL, this.isM, this.isN, this.isO});
        if (m.ym()) {
            OO();
            OP();
            return;
        }
        Intent intent = new Intent(this, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        startActivityForResult(intent, 0);
    }

    protected void onDestroy() {
        ap.vd().b(433, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i(TAG, "type:%d, code:%d, msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        aHf();
        this.isP.dismiss();
        if (i == 4 && i2 == -68) {
            if (bg.mA(str)) {
                str = "error";
            }
            av(getString(R.l.dIO), str);
        } else if (i == 0 && i2 == 0) {
            String string = getString(R.l.eWg);
            AnonymousClass1 anonymousClass1 = new OnDismissListener(this) {
                final /* synthetic */ ShareToFacebookRedirectUI isQ;

                {
                    this.isQ = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            g.bl(this, string);
            finish();
        } else {
            g.a(this.uSU.uTo, "err(" + i2 + "," + i + ")", getString(R.l.dIO), new OnClickListener(this) {
                final /* synthetic */ ShareToFacebookRedirectUI isQ;

                {
                    this.isQ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.isQ.finish();
                }
            }, null);
        }
    }

    private void OO() {
        w.i(TAG, "refreshFacebookToken");
        ap.yY();
        long c = bg.c((Long) c.vr().get(65831, null));
        ap.yY();
        String mz = bg.mz((String) c.vr().get(65830, null));
        if (bg.aA(c) <= 86400000 || mz.length() <= 0) {
            OP();
            return;
        }
        com.tencent.mm.ui.g.a.c cVar = new com.tencent.mm.ui.g.a.c("290293790992170");
        cVar.TX(mz);
        new h(cVar, new com.tencent.mm.v.a(this) {
            final /* synthetic */ ShareToFacebookRedirectUI isQ;

            {
                this.isQ = r1;
            }

            public final void m(Bundle bundle) {
                super.m(bundle);
            }

            public final void onError(int i, String str) {
                w.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", new Object[]{Integer.valueOf(i), str});
                super.onError(i, str);
                if (i == 3) {
                    ShareToFacebookRedirectUI.a(this.isQ);
                }
            }
        }).bQS();
    }

    private void OP() {
        w.i(TAG, "doSend");
        final d.a aVar = new d.a(this);
        String str = this.isL;
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(aVar.mContext, (int) (20.0f * com.tencent.mm.bg.a.dI(aVar.mContext)));
        if (!bg.mA(str)) {
            aVar.sMq.M(com.tencent.mm.bi.g.bKH().b(aVar.mContext, str.toString(), fromDPToPix));
        }
        aVar.MQ(this.isN).MP(this.isM).MS(getString(R.l.dGv)).xp(R.l.dIE).a(new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
            final /* synthetic */ ShareToFacebookRedirectUI isQ;

            public final void a(boolean z, String str, int i) {
                this.isQ.aHf();
                aVar.oHT.dismiss();
                if (z) {
                    axy com_tencent_mm_protocal_c_axy = new axy();
                    if (bg.mA(str)) {
                        str = " ";
                    }
                    com_tencent_mm_protocal_c_axy.msK = str;
                    com_tencent_mm_protocal_c_axy.msj = this.isQ.isL;
                    com_tencent_mm_protocal_c_axy.tgT = this.isQ.isM;
                    com_tencent_mm_protocal_c_axy.nXf = this.isQ.isO;
                    com_tencent_mm_protocal_c_axy.uan = this.isQ.isN;
                    ap.vd().a(new com.tencent.mm.plugin.accountsync.model.c(com_tencent_mm_protocal_c_axy), 0);
                    this.isQ.isP = g.a(this.isQ, "", false, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass4 isS;

                        {
                            this.isS = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.isS.isQ.isP.dismiss();
                            this.isS.isQ.finish();
                        }
                    });
                    return;
                }
                this.isQ.finish();
            }
        }).oHT.show();
    }

    private void av(String str, String str2) {
        g.a(this.uSU.uTo, str2, str, new OnClickListener(this) {
            final /* synthetic */ ShareToFacebookRedirectUI isQ;

            {
                this.isQ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(this.isQ.uSU.uTo, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                this.isQ.uSU.uTo.startActivityForResult(intent, 0);
            }
        }, null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.i(str, str2, objArr);
        if (i == 0 && i2 == -1 && intent != null) {
            w.i(TAG, "bind facebooksucc %b", new Object[]{Boolean.valueOf(intent.getBooleanExtra("bind_facebook_succ", false))});
            if (intent.getBooleanExtra("bind_facebook_succ", false)) {
                OO();
                OP();
                return;
            }
        }
        finish();
    }
}
