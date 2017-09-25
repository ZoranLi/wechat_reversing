package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@a(3)
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    private Dialog ita = null;
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ LuckyMoneyNewYearSendUI ntG;

        {
            this.ntG = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.cfr) {
                g.oUh.i(13079, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                if (this.ntG.nnE == 1 && this.ntG.ntk && !TextUtils.isEmpty(this.ntG.ntE) && !TextUtils.isEmpty(this.ntG.ntl) && !TextUtils.isEmpty(this.ntG.ntm) && this.ntG.ntn > 0) {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with last post image data!");
                    LuckyMoneyNewYearSendUI.g(this.ntG);
                } else if (this.ntG.nnE == 1 && this.ntG.ntk && !TextUtils.isEmpty(this.ntG.ntE)) {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with new image data!");
                    this.ntG.aIF();
                    if (this.ntG.nto == null) {
                        this.ntG.nto = new j();
                    }
                    h.a i = this.ntG.nto;
                    String c = this.ntG.ntE;
                    j.a anonymousClass1 = new j.a(this) {
                        final /* synthetic */ AnonymousClass1 ntH;

                        {
                            this.ntH = r1;
                        }

                        public final void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z) {
                            if (z) {
                                w.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image success, to send HB");
                                this.ntH.ntG.ntl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                                this.ntH.ntG.ntm = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                                this.ntH.ntG.ntn = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                                this.ntH.ntG.mHandler.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 ntI;

                                    {
                                        this.ntI = r1;
                                    }

                                    public final void run() {
                                        LuckyMoneyNewYearSendUI.g(this.ntI.ntH.ntG);
                                    }
                                });
                                return;
                            }
                            this.ntH.ntG.mHandler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 ntI;

                                {
                                    this.ntI = r1;
                                }

                                public final void run() {
                                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image fail!");
                                    if (this.ntI.ntH.ntG.ita != null && this.ntI.ntH.ntG.ita.isShowing()) {
                                        this.ntI.ntH.ntG.ita.hide();
                                    }
                                    com.tencent.mm.ui.base.g.bl(this.ntI.ntH.ntG, this.ntI.ntH.ntG.getString(R.l.eyC));
                                }
                            });
                        }
                    };
                    i.lfn = j.aHW();
                    i.nmS = anonymousClass1;
                    i.nmT = c;
                    w.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: sendImg. imageId:%s", new Object[]{i.lfn});
                    h hVar = new h();
                    hVar.fZK = true;
                    hVar.hze = i;
                    hVar.field_mediaId = r2;
                    hVar.field_fullpath = c;
                    hVar.field_thumbpath = "";
                    hVar.field_fileType = b.MediaType_FILE;
                    hVar.field_talker = "";
                    hVar.field_priority = b.hxL;
                    hVar.field_needStorage = false;
                    hVar.field_isStreamMedia = false;
                    hVar.field_appType = 0;
                    hVar.field_bzScene = 0;
                    if (!com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                        w.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. clientid:%s", new Object[]{r2});
                    }
                } else {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with not image data!");
                    this.ntG.ntE = "";
                    this.ntG.ntl = "";
                    this.ntG.ntm = "";
                    this.ntG.ntn = 0;
                    LuckyMoneyNewYearSendUI.g(this.ntG);
                }
            } else if (view.getId() == R.h.cfm) {
                this.ntG.finish();
                g.oUh.i(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
            } else if (view.getId() == R.h.cfj || view.getId() == R.h.cfl) {
                LuckyMoneyNewYearSendUI.l(this.ntG);
                g.oUh.i(13079, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
            } else if (view.getId() == R.h.cfn) {
                this.ntG.ntl = "";
                this.ntG.ntm = "";
                this.ntG.ntn = 0;
                LuckyMoneyNewYearSendUI.m(this.ntG);
                g.oUh.i(13079, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            } else if (view.getId() == R.h.cfq) {
                LuckyMoneyAutoScrollView n = this.ntG.nta;
                n.nqV = false;
                n.nqM.setVisibility(0);
                n.nqN.setVisibility(0);
                n.nqO.setVisibility(0);
                n.nqP.setVisibility(4);
                n.nqQ.setVisibility(4);
                n.nqR.setVisibility(4);
                this.ntG.aIG();
                g.oUh.i(13079, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
            } else if (view.getId() == R.h.cfo) {
                LuckyMoneyNewYearSendUI.p(this.ntG);
            }
        }
    };
    private Button kYj;
    private Bitmap mBitmap;
    private ae mHandler = new ae();
    private int nnE = 0;
    private LinkedList<k> nnF;
    private String nnx;
    private int nnz;
    private int npS;
    private String npW;
    private int npX;
    private TextView nqk;
    private ImageView ntA;
    private LinearLayout ntB;
    private String ntC;
    private boolean ntD = true;
    private String ntE = "";
    private int ntF = 0;
    private LuckyMoneyAutoScrollView nta;
    private TextView ntb;
    private ImageView ntg;
    private View nth;
    private ImageView nti;
    private boolean ntk = false;
    private String ntl = "";
    private String ntm = "";
    private int ntn;
    private j nto;
    private View ntw;
    private View ntx;
    private ImageView nty;
    private TextView ntz;

    static /* synthetic */ void g(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        g.oUh.i(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
        String xL = m.xL();
        luckyMoneyNewYearSendUI.b(new ad(luckyMoneyNewYearSendUI.nnz, luckyMoneyNewYearSendUI.nnx, n.zL(xL), luckyMoneyNewYearSendUI.ntC, xL, m.xN(), luckyMoneyNewYearSendUI.npS, luckyMoneyNewYearSendUI.ntl, luckyMoneyNewYearSendUI.ntm, luckyMoneyNewYearSendUI.ntn), false);
        luckyMoneyNewYearSendUI.aIF();
    }

    static /* synthetic */ void l(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSelectPicture");
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "galleryMode %s", new Object[]{luckyMoneyNewYearSendUI.uSU.uTo.getSharedPreferences(ab.bIX(), 0).getString("gallery", "1")});
        if (luckyMoneyNewYearSendUI.uSU.uTo.getSharedPreferences(ab.bIX(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.k.a(luckyMoneyNewYearSendUI, 2, null);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.k.Y(luckyMoneyNewYearSendUI);
        }
    }

    static /* synthetic */ void m(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "doDeletePic");
        luckyMoneyNewYearSendUI.ntk = false;
        luckyMoneyNewYearSendUI.ntE = "";
        luckyMoneyNewYearSendUI.ntl = "";
        luckyMoneyNewYearSendUI.ntm = "";
        luckyMoneyNewYearSendUI.ntn = 0;
        luckyMoneyNewYearSendUI.ar();
    }

    static /* synthetic */ void p(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearSendUI.ntE)) {
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "image path is empty!");
            return;
        }
        g.oUh.i(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
        new h(luckyMoneyNewYearSendUI, m.xL(), luckyMoneyNewYearSendUI.ntE).l(false, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.ntC = getIntent().getStringExtra("key_username");
        this.npS = getIntent().getIntExtra("key_way", 0);
        this.npX = getIntent().getIntExtra("pay_channel", -1);
        if (bg.mA(this.ntC)) {
            w.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        KC();
        k(new v("v1.0"));
        g.oUh.i(13079, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
    }

    protected void onDestroy() {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uDv, this.ntE);
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uDw, this.ntl);
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uDx, this.ntm);
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uDy, Integer.valueOf(this.ntn));
        super.onDestroy();
        if (this.ita != null && this.ita.isShowing()) {
            this.ita.dismiss();
        }
    }

    protected final void KC() {
        re(8);
        this.ntw = findViewById(R.h.cfG);
        this.ntb = (TextView) findViewById(R.h.cdr);
        this.nta = (LuckyMoneyAutoScrollView) findViewById(R.h.cfi);
        this.nqk = (TextView) findViewById(R.h.cfs);
        this.kYj = (Button) findViewById(R.h.cfr);
        this.kYj.setOnClickListener(this.iuW);
        ((ImageView) findViewById(R.h.cfm)).setOnClickListener(this.iuW);
        this.ntx = findViewById(R.h.cfk);
        this.nty = (ImageView) findViewById(R.h.cfj);
        this.nty.setOnClickListener(this.iuW);
        this.ntg = (ImageView) findViewById(R.h.cft);
        this.ntz = (TextView) findViewById(R.h.cfl);
        this.ntz.setOnClickListener(this.iuW);
        this.nth = findViewById(R.h.cfp);
        this.nti = (ImageView) findViewById(R.h.cfo);
        this.nti.setOnClickListener(this.iuW);
        this.ntA = (ImageView) findViewById(R.h.cfn);
        this.ntA.setOnClickListener(this.iuW);
        this.ntB = (LinearLayout) findViewById(R.h.cfq);
        this.ntB.setOnClickListener(this.iuW);
        ap.yY();
        this.ntE = (String) c.vr().get(com.tencent.mm.storage.w.a.uDv, "");
        ap.yY();
        this.ntl = (String) c.vr().get(com.tencent.mm.storage.w.a.uDw, "");
        ap.yY();
        this.ntm = (String) c.vr().get(com.tencent.mm.storage.w.a.uDx, "");
        ap.yY();
        this.ntn = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDy, Integer.valueOf(0))).intValue();
        if (TextUtils.isEmpty(this.ntE) || TextUtils.isEmpty(this.ntl) || TextUtils.isEmpty(this.ntm) || this.ntn <= 0) {
            w.e("MicroMsg.LuckyMoneyNewYearSendUI", "count not fetch last post image data!");
        } else {
            this.ntk = true;
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "last post image data is valid");
        }
        if (!this.ntk || TextUtils.isEmpty(this.ntE)) {
            w.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:initPictureImage() mIsShowPic:" + this.ntk + ", mImagePath:" + this.ntE);
            return;
        }
        Bitmap aa = n.aa(this.ntE, false);
        if (aa != null) {
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
            Bitmap bitmap = this.mBitmap;
            this.mBitmap = aa;
            this.nti.setImageBitmap(this.mBitmap);
            if (bitmap != null && bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        w.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
    }

    private void ar() {
        LayoutParams layoutParams;
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if (this.ntk && this.nnE == 1) {
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the picture!");
            this.ntx.setVisibility(8);
            this.nth.setVisibility(0);
            this.ntg.setVisibility(8);
        } else if (this.nnE == 1) {
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the camera btn!");
            this.ntx.setVisibility(0);
            this.nth.setVisibility(8);
            this.ntg.setVisibility(0);
        } else {
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the new year wording!");
            this.ntx.setVisibility(8);
            this.nth.setVisibility(8);
            this.ntg.setVisibility(0);
        }
        if (this.nnF == null || this.nnF.size() <= 0) {
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
            this.ntB.setVisibility(8);
        } else {
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
            this.ntB.setVisibility(0);
        }
        if (this.nnE == 1) {
            layoutParams = (LayoutParams) this.ntg.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.baA);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.f.bay);
            this.ntg.setLayoutParams(layoutParams);
            this.ntg.invalidate();
        } else {
            layoutParams = (LayoutParams) this.ntg.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.baz);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.f.bax);
            this.ntg.setLayoutParams(layoutParams);
            this.ntg.invalidate();
        }
        if (this.ntk) {
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
            layoutParams = (LayoutParams) this.ntB.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.bau);
            this.ntB.setLayoutParams(layoutParams);
            this.ntB.invalidate();
            return;
        }
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
        layoutParams = (LayoutParams) this.ntB.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.f.bat);
        this.ntB.setLayoutParams(layoutParams);
        this.ntB.invalidate();
    }

    protected final int getLayoutId() {
        return R.i.dhq;
    }

    private void aIF() {
        if (this.ita == null) {
            this.ita = com.tencent.mm.wallet_core.ui.g.a(this.uSU.uTo, true, new OnCancelListener(this) {
                final /* synthetic */ LuckyMoneyNewYearSendUI ntG;

                {
                    this.ntG = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.ntG.ita != null && this.ntG.ita.isShowing()) {
                        this.ntG.ita.hide();
                    }
                    if (this.ntG.uSU.ipu.getVisibility() == 8 || this.ntG.uSU.ipu.getVisibility() == 4) {
                        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
                        this.ntG.finish();
                    }
                    this.ntG.nqY.aHT();
                }
            });
        } else if (!this.ita.isShowing()) {
            this.ita.show();
        }
    }

    private void aIG() {
        int i;
        if (this.nnF == null || this.nnF.size() <= 0) {
            w.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i = -1;
        } else {
            ap.yY();
            i = c.uH();
            int size = this.nnF.size();
            i = (new Random((long) i).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:" + i);
        }
        this.ntF = i;
        if (this.ntF >= 0 && this.ntF < this.nnF.size()) {
            this.nnz = ((k) this.nnF.get(this.ntF)).nmV;
            this.nnx = ((k) this.nnF.get(this.ntF)).nmW;
        }
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.ntF + " randomAmount:" + this.nnz + " randomWishing:" + this.nnx);
        this.nta.zN(e.n(((double) this.nnz) / 100.0d));
        this.nta.a(new LuckyMoneyAutoScrollView.a(this) {
            final /* synthetic */ LuckyMoneyNewYearSendUI ntG;

            {
                this.ntG = r1;
            }

            public final void aIq() {
                if (this.ntG.ntD) {
                    this.ntG.nqk.setVisibility(4);
                    n.a(this.ntG.uSU.uTo, this.ntG.nqk, this.ntG.nnx);
                    Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass3 ntJ;

                        {
                            this.ntJ = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                            this.ntJ.ntG.nqk.setVisibility(0);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                        }
                    });
                    this.ntG.nqk.startAnimation(alphaAnimation);
                    this.ntG.ntD = false;
                    return;
                }
                n.a(this.ntG.uSU.uTo, this.ntG.nqk, this.ntG.nnx);
                this.ntG.nqk.invalidate();
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + kVar.getType());
        if (kVar instanceof v) {
            if (i == 0 && i2 == 0) {
                v vVar = (v) kVar;
                this.nnz = vVar.nnz;
                this.nnx = vVar.nnx;
                this.nnE = vVar.nnE;
                this.nnF = vVar.nnF;
                if (this.nnE == 0) {
                    w.e("MicroMsg.LuckyMoneyNewYearSendUI", "scenePicSwitch is 0, clear local picture data!");
                } else {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "cans how picture!");
                }
                aIG();
                ar();
                re(0);
                n.a(this.ntw, null);
                return true;
            }
            finish();
        } else if (kVar instanceof ac) {
            if (this.ita != null && this.ita.isShowing()) {
                this.ita.hide();
            }
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ac acVar = (ac) kVar;
                this.npW = acVar.nnM;
                r1 = new PayInfo();
                r1.fJH = acVar.nnL;
                r1.fRv = 37;
                r1.fRr = this.npX;
                com.tencent.mm.pluginsdk.wallet.e.a(this, r1, 1);
                return true;
            }
            w.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (kVar instanceof ad) {
            if (this.ita != null && this.ita.isShowing()) {
                this.ita.hide();
            }
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ad adVar = (ad) kVar;
                this.npW = adVar.nnM;
                r1 = new PayInfo();
                r1.fJH = adVar.nnL;
                r1.fRv = 37;
                r1.fRr = this.npX;
                com.tencent.mm.pluginsdk.wallet.e.a(this, r1, 1);
                return true;
            }
            w.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    g.oUh.i(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)});
                    if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                        RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                        if (realnameGuideHelper != null) {
                            boolean z2;
                            if (realnameGuideHelper.a(this, null, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ LuckyMoneyNewYearSendUI ntG;

                                {
                                    this.ntG = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.ntG.finish();
                                }
                            })) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            z = z2;
                        }
                    }
                    com.tencent.mm.ui.base.g.bl(this, getString(R.l.esl));
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb!");
                    n.z(this.npW, this.ntC, 3);
                    if (!z) {
                        finish();
                        return;
                    }
                    return;
                }
                w.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                return;
            case 2:
                if (intent == null) {
                    w.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_PIC");
                    return;
                } else if (i2 == -1) {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    CharSequence stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (!TextUtils.isEmpty(stringExtra) || (stringArrayListExtra != null && stringArrayListExtra.size() > 0)) {
                        if (TextUtils.isEmpty(stringExtra)) {
                            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePathList is valid!");
                            str = (String) stringArrayListExtra.get(0);
                        } else {
                            w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePath is valid!");
                            str = stringExtra;
                        }
                        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "REQUEST_CODE_FROM_PIC filePath %s", new Object[]{stringExtra});
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.gSI + "temp.avatar");
                        intent2.putExtra("CropImage_ImgPath", str);
                        intent2.putExtra("CropImage_Filter", false);
                        intent2.putExtra("CropImage_from_scene", 1);
                        com.tencent.mm.plugin.luckymoney.a.imv.a(this, intent2, 3);
                        return;
                    }
                    w.e("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture failed, imagePath and imagePathList is null!");
                    return;
                } else {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture cancel or failed!");
                    return;
                }
            case 3:
                if (intent == null) {
                    w.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_CROP");
                    return;
                } else if (i2 == -1) {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    str = intent.getStringExtra("CropImage_OutputPath");
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "new crop image path:" + str);
                    if (TextUtils.isEmpty(str) || !str.equals(this.ntE)) {
                        this.ntl = "";
                        this.ntm = "";
                        this.ntn = 0;
                    } else {
                        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "the path is same as last image");
                    }
                    this.ntE = str;
                    Bitmap aa = n.aa(this.ntE, false);
                    if (aa != null) {
                        w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
                        Bitmap bitmap = this.mBitmap;
                        this.mBitmap = aa;
                        this.nti.setImageBitmap(this.mBitmap);
                        this.ntk = true;
                        ar();
                        if (bitmap != null && bitmap.isRecycled()) {
                            bitmap.recycle();
                            return;
                        }
                        return;
                    }
                    w.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
                    return;
                } else {
                    w.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:do crop image fail for REQUEST_CODE_FROM_CROP");
                    return;
                }
            default:
                return;
        }
    }
}
