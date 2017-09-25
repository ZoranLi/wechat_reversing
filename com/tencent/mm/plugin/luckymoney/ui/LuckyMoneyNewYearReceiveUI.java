package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.ab;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;
import java.io.File;

@a(3)
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private String imagePath = "";
    private p irJ = null;
    private ImageView kDl;
    private ae mHandler = new ae();
    private int nnE = 0;
    private TextView nqk;
    private View nqp;
    private String nqq;
    private LuckyMoneyAutoScrollView nta;
    private TextView ntb;
    private TextView ntc;
    private LinearLayout ntd;
    private TextView nte;
    private ImageView ntf;
    private ImageView ntg;
    private View nth;
    private ImageView nti;
    private boolean ntj = false;
    private boolean ntk = false;
    private String ntl = "";
    private String ntm = "";
    private int ntn;
    private j nto;
    private boolean ntp = false;

    static /* synthetic */ void a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearReceiveUI.imagePath)) {
            w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "image path is empty!");
            return;
        }
        g.oUh.i(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(2)});
        new h(luckyMoneyNewYearReceiveUI, m.xL(), luckyMoneyNewYearReceiveUI.imagePath).l(true, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_native_url");
        this.ntl = getIntent().getStringExtra("key_image_id");
        this.ntm = getIntent().getStringExtra("key_image_aes_key");
        this.ntn = getIntent().getIntExtra("key_image_length", 0);
        w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageId:" + this.ntl + ", imageLength:" + this.ntn);
        Uri parse = Uri.parse(bg.mz(stringExtra));
        try {
            this.nqq = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        KC();
        if (bg.mA(this.nqq)) {
            finish();
            w.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
            return;
        }
        b(new com.tencent.mm.plugin.luckymoney.b.ae(bg.getInt(parse.getQueryParameter("channelid"), 1), this.nqq, stringExtra, 1, "v1.0"), false);
        if (this.irJ != null) {
            this.irJ.show();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.ntp) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
    }

    protected final void KC() {
        this.nqp = findViewById(R.h.cfz);
        this.nta = (LuckyMoneyAutoScrollView) findViewById(R.h.cfu);
        this.ntb = (TextView) findViewById(R.h.cdr);
        this.nqk = (TextView) findViewById(R.h.cfF);
        this.kDl = (ImageView) findViewById(R.h.cfv);
        this.ntd = (LinearLayout) findViewById(R.h.cfD);
        this.nte = (TextView) findViewById(R.h.cfB);
        this.ntf = (ImageView) findViewById(R.h.cfC);
        this.ntc = (TextView) findViewById(R.h.cfE);
        this.ntg = (ImageView) findViewById(R.h.cft);
        this.nth = findViewById(R.h.cfp);
        this.nti = (ImageView) findViewById(R.h.cfo);
        this.nti.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI ntq;

            {
                this.ntq = r1;
            }

            public final void onClick(View view) {
                LuckyMoneyNewYearReceiveUI.a(this.ntq);
            }
        });
        ((ImageView) findViewById(R.h.cfw)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI ntq;

            {
                this.ntq = r1;
            }

            public final void onClick(View view) {
                this.ntq.finish();
                g.oUh.i(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
            }
        });
        re(8);
        this.irJ = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.cbS), true, new OnCancelListener(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI ntq;

            {
                this.ntq = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.ntq.irJ != null && this.ntq.irJ.isShowing()) {
                    this.ntq.irJ.dismiss();
                }
                this.ntq.nqY.aHT();
                if (this.ntq.uSU.ipu.getVisibility() == 8 || this.ntq.uSU.ipu.getVisibility() == 4) {
                    w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
                    this.ntq.finish();
                }
            }
        });
    }

    private void aIE() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI ntq;

            {
                this.ntq = r1;
            }

            public final void run() {
                if (new File(this.ntq.imagePath).exists()) {
                    final Bitmap aa = n.aa(this.ntq.imagePath, true);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 ntt;

                        public final void run() {
                            this.ntt.ntq.nti.setImageBitmap(aa);
                        }

                        public final String toString() {
                            return super.toString() + "|renderView";
                        }
                    });
                    return;
                }
                w.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.ntq.imagePath + " is not exist!");
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.luckymoney.b.ae)) {
            if (kVar instanceof ab) {
                if (this.irJ != null && this.irJ.isShowing()) {
                    this.irJ.hide();
                }
                if (i == 0 && i2 == 0) {
                    final ab abVar = (ab) kVar;
                    e eVar = abVar.nnk;
                    this.nte.setText(abVar.nnk.nmf);
                    this.nta.zN(com.tencent.mm.wallet_core.ui.e.n(((double) abVar.nnk.fZT) / 100.0d));
                    this.nta.a(new LuckyMoneyAutoScrollView.a(this) {
                        final /* synthetic */ LuckyMoneyNewYearReceiveUI ntq;

                        public final void aIq() {
                            this.ntq.nqk.setVisibility(4);
                            n.a(this.ntq.uSU.uTo, this.ntq.nqk, abVar.nnk.nmh);
                            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(500);
                            alphaAnimation.setAnimationListener(new AnimationListener(this) {
                                final /* synthetic */ AnonymousClass7 ntv;

                                {
                                    this.ntv = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                    this.ntv.ntq.nqk.setVisibility(0);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    if (com.tencent.mm.i.g.sV().getInt("PlayCoinSound", 0) > 0) {
                                        k.B(this.ntv.ntq, R.l.exe);
                                    }
                                    if (abVar.nnl != null) {
                                        abVar.nnl.a(this.ntv.ntq, null, null);
                                    }
                                }
                            });
                            this.ntq.nqk.startAnimation(alphaAnimation);
                        }
                    });
                    if (eVar.fZG == 4 && !TextUtils.isEmpty(abVar.nnk.nmf)) {
                        this.ntf.setVisibility(8);
                    }
                    re(0);
                    n.a(this.nqp, null);
                    return true;
                } else if (i2 == 416) {
                    if (this.irJ != null && this.irJ.isShowing()) {
                        this.irJ.hide();
                    }
                    this.ntp = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    return n.a(this, i2, kVar, bundle, true, null, null, MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED);
                }
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            LayoutParams layoutParams;
            final com.tencent.mm.plugin.luckymoney.b.ae aeVar = (com.tencent.mm.plugin.luckymoney.b.ae) kVar;
            this.nnE = aeVar.nnE;
            if (this.nnE == 1) {
                w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image data!");
                if (TextUtils.isEmpty(this.ntm)) {
                    w.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageaeskey is empty!");
                }
                if (TextUtils.isEmpty(this.ntl) || TextUtils.isEmpty(this.ntm) || this.ntn <= 0) {
                    w.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage() the parameter is illegeal!");
                } else {
                    w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage()!");
                    if (this.nto == null) {
                        this.nto = new j();
                    }
                    this.imagePath = n.zM(this.ntl) + ".temp";
                    if (new File(this.imagePath).exists()) {
                        w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:imagePath file is exist! update image");
                        aIE();
                    } else {
                        w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.imagePath + " is not exist!");
                        this.nto.a(this.ntl, this.ntm, this.ntn, this.imagePath, new j.a(this) {
                            final /* synthetic */ LuckyMoneyNewYearReceiveUI ntq;

                            {
                                this.ntq = r1;
                            }

                            public final void a(final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, final boolean z) {
                                this.ntq.mHandler.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 nts;

                                    public final void run() {
                                        if (z) {
                                            w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "the download image data is success!");
                                            if (!TextUtils.isEmpty(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) && com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId.equals(this.nts.ntq.ntl)) {
                                                this.nts.ntq.aIE();
                                                return;
                                            }
                                            return;
                                        }
                                        w.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image fail!");
                                        com.tencent.mm.ui.base.g.bl(this.nts.ntq, this.nts.ntq.getString(R.l.exp));
                                    }
                                });
                            }
                        });
                    }
                }
            } else {
                w.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "not to download image data!");
            }
            if (aeVar.aIa()) {
                this.ntj = true;
                w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                b.m(this.kDl, m.xL());
                findViewById(R.h.cfA).setVisibility(8);
                findViewById(R.h.cft).setVisibility(0);
            } else {
                w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    b.m(this.kDl, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(aeVar.nmj)) {
                    n.a(this.kDl, aeVar.nmj, aeVar.nmD);
                }
                n.a(this.uSU.uTo, this.ntc, aeVar.nnS);
                this.ntj = false;
            }
            if (aeVar.aIa() || aeVar.fZH != 0 || aeVar.fZG == 4 || aeVar.fZG == 5 || aeVar.fZG == 1) {
                if (this.irJ != null && this.irJ.isShowing()) {
                    this.irJ.hide();
                }
                if (aeVar.fZG != 5) {
                    this.nta.zN(com.tencent.mm.wallet_core.ui.e.n(((double) aeVar.nnT) / 100.0d));
                    LuckyMoneyAutoScrollView luckyMoneyAutoScrollView = this.nta;
                    luckyMoneyAutoScrollView.nqM.setVisibility(8);
                    luckyMoneyAutoScrollView.nqN.setVisibility(8);
                    luckyMoneyAutoScrollView.nqO.setVisibility(8);
                    luckyMoneyAutoScrollView.nqP.setVisibility(0);
                    luckyMoneyAutoScrollView.nqQ.setVisibility(0);
                    luckyMoneyAutoScrollView.nqR.setVisibility(0);
                    n.a(this.uSU.uTo, this.nqk, aeVar.nmh);
                    this.nte.setText(aeVar.nmf);
                    if (aeVar.fZG == 4 && !TextUtils.isEmpty(aeVar.nmf)) {
                        this.ntf.setVisibility(8);
                    }
                } else {
                    findViewById(R.h.cfx).setVisibility(8);
                    ((TextView) findViewById(R.h.cfy)).setText(aeVar.nmf);
                    ((TextView) findViewById(R.h.cfy)).setVisibility(0);
                }
                re(0);
                n.a(this.nqp, null);
            } else if ("0".equals(aeVar.nnq)) {
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.nqY, aeVar.nnr, aeVar.nns, aeVar.nnt, aeVar.nnu, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                    final /* synthetic */ LuckyMoneyNewYearReceiveUI ntq;

                    public final boolean a(int i, int i2, String str, boolean z) {
                        w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                        if (i == 1) {
                            this.ntq.finish();
                        } else if (i == 2) {
                            this.ntq.a(aeVar.msgType, aeVar.fuV, aeVar.njw, aeVar.fZF, aeVar.nnW);
                        } else if (i == 0 && z) {
                            this.ntq.a(aeVar.msgType, aeVar.fuV, aeVar.njw, aeVar.fZF, aeVar.nnW);
                        }
                        return true;
                    }
                }, true, MMBitmapFactory.ERROR_IO_FAILED);
            } else {
                a(aeVar.msgType, aeVar.fuV, aeVar.njw, aeVar.fZF, aeVar.nnW);
            }
            w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "scenePicSwitch:" + this.nnE + ", imageId:" + this.ntl + ", imageLength:" + this.ntn);
            if (this.nnE != 1 || TextUtils.isEmpty(this.ntl) || TextUtils.isEmpty(this.ntm) || this.ntn <= 0) {
                this.ntk = false;
                w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "don't show the picture!");
            } else {
                this.ntk = true;
                w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "show the picture!");
            }
            boolean z = (aeVar.fZG == 5 || aeVar.fZG == 1) ? false : true;
            w.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + aeVar.fZG + ", isValidStatus is " + z);
            if (this.ntk && z) {
                this.nth.setVisibility(0);
                this.ntg.setVisibility(8);
            } else {
                this.nth.setVisibility(8);
                this.ntg.setVisibility(0);
            }
            if (this.ntk && z) {
                layoutParams = (LayoutParams) this.nqk.getLayoutParams();
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.f.baw);
                this.nqk.setLayoutParams(layoutParams);
                this.nqk.invalidate();
                this.nqk.setTextSize(1, 17.0f);
                this.ntb.setTextSize(1, 16.0f);
                this.nta.cn(getResources().getDimensionPixelOffset(R.f.baE), getResources().getDimensionPixelOffset(R.f.baC));
                layoutParams = (LayoutParams) this.nta.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.bas);
                this.nta.setLayoutParams(layoutParams);
                this.nta.invalidate();
            } else {
                layoutParams = (LayoutParams) this.nqk.getLayoutParams();
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.f.bav);
                this.nqk.setLayoutParams(layoutParams);
                this.nqk.invalidate();
                this.nqk.setTextSize(1, 20.0f);
                this.ntb.setTextSize(1, 18.0f);
                this.nta.cn(getResources().getDimensionPixelOffset(R.f.baD), getResources().getDimensionPixelOffset(R.f.baB));
                layoutParams = (LayoutParams) this.nta.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.bar);
                this.nta.setLayoutParams(layoutParams);
                this.nta.invalidate();
            }
            if (this.ntj) {
                layoutParams = (LayoutParams) this.ntd.getLayoutParams();
                if (this.ntk) {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.baG);
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.baH);
                }
                this.ntd.setLayoutParams(layoutParams);
                this.ntd.invalidate();
                this.nte.setTextSize(1, 18.0f);
                return true;
            }
            layoutParams = (LayoutParams) this.ntd.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.baF);
            this.ntd.setLayoutParams(layoutParams);
            this.ntd.invalidate();
            this.nte.setTextSize(1, 12.0f);
            return true;
        } else {
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.hide();
            }
            return false;
        }
    }

    private void a(int i, int i2, String str, String str2, String str3) {
        b(new ab(i, i2, str, str2, n.aHX(), m.xN(), getIntent().getStringExtra("key_username"), "v1.0", str3), false);
    }

    protected final int getLayoutId() {
        return R.i.dhr;
    }
}
