package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.f2f.a.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.x.n;
import com.tencent.mm.y.k;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI extends LuckyMoneyBaseUI {
    private int boy;
    private DisplayMetrics ihQ;
    private String lfx;
    private String njD;
    private ImageView njR;
    private TextView njS;
    private String njw;
    private String njy;
    private View nkW;
    private TextView nkX;
    private ImageView nkY;
    private ValueAnimator nkZ;
    private ValueAnimator nla;
    private Intent nlb;
    private boolean nlc = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nkW = findViewById(R.h.cfY);
        this.njR = (ImageView) findViewById(R.h.cga);
        this.njS = (TextView) findViewById(R.h.cgb);
        this.nkX = (TextView) findViewById(R.h.cgc);
        this.nkY = (ImageView) findViewById(R.h.cgg);
        this.nkY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

            {
                this.nld = r1;
            }

            public final void onClick(View view) {
                this.nld.nla.cancel();
                this.nld.finish();
            }
        });
        this.uSU.ipu.setVisibility(8);
        this.lfx = getIntent().getStringExtra("key_share_url");
        h.h(this, 6);
        b(new b(this.lfx), true);
        this.ihQ = getResources().getDisplayMetrics();
        this.nkZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        this.nla = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        this.nla.setStartDelay(1000);
        this.nkZ.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

            {
                this.nld = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.nld.nkW.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) this.nld.ihQ.heightPixels));
            }
        });
        this.nkZ.addListener(new AnimatorListener(this) {
            final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

            {
                this.nld = r1;
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                w.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
                this.nld.nla.start();
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.nla.addListener(new AnimatorListener(this) {
            final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

            {
                this.nld = r1;
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                w.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
                if (this.nld.nlb != null) {
                    this.nld.a(LuckyMoneyDetailUI.class, this.nld.nlb);
                }
                this.nld.setResult(-1, null);
                this.nld.finish();
                if (this.nld.nlb != null) {
                    this.nld.overridePendingTransition(R.a.aRm, R.a.aRn);
                }
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dhi;
    }

    protected void onResume() {
        super.onResume();
        hn(1997);
        if (this.nlc) {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        ho(1997);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        w.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof b)) {
            return true;
        }
        b bVar = (b) kVar;
        int i3 = bVar.fZG;
        int i4 = bVar.njx;
        this.boy = bVar.boy;
        int i5 = bVar.njA;
        String str2 = bVar.njB;
        String str3 = bVar.njC;
        w.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[]{Integer.valueOf(bVar.fZG), Integer.valueOf(bVar.njx), Integer.valueOf(bVar.fFG)});
        aua com_tencent_mm_protocal_c_aua;
        if (i4 == 2) {
            if (i3 == 5) {
                g.a(this, getString(R.l.ext), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

                    {
                        this.nld = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.nld.finish();
                    }
                });
            } else {
                this.njw = bVar.njw;
                this.njy = bVar.njy;
                this.njD = bVar.njD;
                this.nlb = new Intent();
                if (!(bg.mA(this.njy) || o.eU(this.njy))) {
                    com.tencent.mm.x.h hVar = new com.tencent.mm.x.h();
                    hVar.username = this.njy;
                    n.Bm().a(hVar);
                }
                com.tencent.mm.plugin.luckymoney.b.n.a(this.njR, null, this.njy);
                e eVar = new e();
                eVar.fZT = (long) this.boy;
                eVar.njw = this.njw;
                eVar.fZG = i3;
                eVar.fZH = i4;
                eVar.njC = str3;
                eVar.njA = i5;
                eVar.nmD = this.njy;
                eVar.njB = str2;
                eVar.nmi = com.tencent.mm.plugin.luckymoney.b.n.eJ(this.njy);
                eVar.njD = this.njD;
                eVar.nme = 2;
                w.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[]{Integer.valueOf(bVar.njE)});
                if (bVar.njE > 0) {
                    eVar.nmg = getString(R.l.exO);
                }
                eVar.nmj = com.tencent.mm.plugin.luckymoney.b.n.zL(this.njy);
                try {
                    this.nlb.putExtra("key_detail_info", eVar.toByteArray());
                    com_tencent_mm_protocal_c_aua = bVar.njz;
                    if (com_tencent_mm_protocal_c_aua != null) {
                        Parcelable realnameGuideHelper = new RealnameGuideHelper();
                        realnameGuideHelper.a(String.valueOf(com_tencent_mm_protocal_c_aua.tca), com_tencent_mm_protocal_c_aua.nnO, com_tencent_mm_protocal_c_aua.nnP, com_tencent_mm_protocal_c_aua.nnQ, com_tencent_mm_protocal_c_aua.nnR, kVar.getType());
                        this.nlb.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    }
                } catch (IOException e) {
                    w.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + e.getMessage());
                }
                if (!bg.D(new String[]{this.njw, this.njy})) {
                    com.tencent.mm.plugin.luckymoney.b.n.a((Context) this, this.njS, com.tencent.mm.plugin.luckymoney.b.n.eJ(this.njy));
                    com.tencent.mm.plugin.luckymoney.b.n.a((Context) this, this.nkX, this.njD);
                    this.nkZ.start();
                    this.uSU.ipu.setVisibility(0);
                }
            }
            return true;
        }
        if (bVar.njz != null) {
            w.i("LuckyMoneyF2FReceiveUI", "need real name verify");
            com_tencent_mm_protocal_c_aua = bVar.njz;
            RealnameGuideHelper realnameGuideHelper2 = new RealnameGuideHelper();
            realnameGuideHelper2.a(String.valueOf(com_tencent_mm_protocal_c_aua.tca), com_tencent_mm_protocal_c_aua.nnO, com_tencent_mm_protocal_c_aua.nnP, com_tencent_mm_protocal_c_aua.nnQ, com_tencent_mm_protocal_c_aua.nnR, kVar.getType());
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            DialogInterface.OnClickListener anonymousClass6 = new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

                {
                    this.nld = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nld.finish();
                }
            };
            AnonymousClass7 anonymousClass7 = new com.tencent.mm.wallet_core.b.a(this) {
                final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

                {
                    this.nld = r1;
                }

                public final Intent j(int i, Bundle bundle) {
                    this.nld.finish();
                    return null;
                }
            };
            if (realnameGuideHelper2.a(this, bundle, anonymousClass6, false)) {
                this.nlc = true;
                return true;
            }
        }
        if (bg.mA(str)) {
            str = getString(R.l.exx);
        }
        g.a(this, str, "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FReceiveUI nld;

            {
                this.nld = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.nld.finish();
            }
        });
        return true;
    }
}
