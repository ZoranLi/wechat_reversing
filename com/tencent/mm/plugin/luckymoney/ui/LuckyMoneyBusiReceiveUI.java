package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.r;
import com.tencent.mm.plugin.luckymoney.b.s;
import com.tencent.mm.plugin.luckymoney.b.t;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import java.io.IOException;

@a(3)
public class LuckyMoneyBusiReceiveUI extends LuckyMoneyBaseUI {
    private p irJ = null;
    private ImageView nkY;
    private ImageView nqi;
    private TextView nqj;
    private Button nql;
    private View nqp;
    private String nqq = null;
    private String nqr = null;
    private TextView nrA;
    private View nrB;
    private ImageView nrC;
    private TextView nrD;
    private View nrE;
    private TextView nrF;
    private Button nrG;
    private TextView nrH;
    private CheckBox nrI;
    private int nrJ;
    private String nrK = null;
    private int nrL = 0;
    private t nrM;
    private RealnameGuideHelper nrN;
    private TextView nrd;
    private int nrn = 0;
    private TextView nrz;

    static /* synthetic */ void i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        luckyMoneyBusiReceiveUI.b(new s(luckyMoneyBusiReceiveUI.nrM.njw, luckyMoneyBusiReceiveUI.nrM.fZF, luckyMoneyBusiReceiveUI.nrM.nnm, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        n.a(luckyMoneyBusiReceiveUI.nql);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nqr = getIntent().getStringExtra("key_native_url");
        this.nrJ = getIntent().getIntExtra("key_way", 5);
        this.nrn = getIntent().getIntExtra("key_static_from_scene", 0);
        w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bg.mz(this.nqr) + ", mWay=" + this.nrJ);
        init();
        g.oUh.i(11701, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        KC();
        hn(980);
    }

    private void init() {
        this.irJ = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.cbS), true, new OnCancelListener(this) {
            final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

            {
                this.nrO = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.nrO.irJ != null && this.nrO.irJ.isShowing()) {
                    this.nrO.irJ.dismiss();
                }
                this.nrO.nqY.aHT();
                if (this.nrO.uSU.ipu.getVisibility() == 8 || this.nrO.uSU.ipu.getVisibility() == 4) {
                    w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
                    this.nrO.finish();
                }
            }
        });
        if (this.nrJ == 3) {
            b(new r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)), false);
        } else if (this.nrJ == 4) {
            b(new r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.nqq = Uri.parse(bg.mz(this.nqr)).getQueryParameter("sendid");
            } catch (Exception e) {
            }
            if (bg.mA(this.nqq)) {
                finish();
                w.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
                return;
            }
            b(new t(this.nqq, this.nqr, this.nrJ, getIntent().getStringExtra("packageExt")), false);
        }
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                return;
            }
            w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            setResult(-1);
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
        ho(980);
    }

    protected final void KC() {
        this.nqp = findViewById(R.h.cdv);
        this.nqi = (ImageView) findViewById(R.h.cdz);
        this.nqj = (TextView) findViewById(R.h.cdA);
        this.nrA = (TextView) findViewById(R.h.cdw);
        this.nrz = (TextView) findViewById(R.h.cdD);
        this.nql = (Button) findViewById(R.h.cdx);
        this.nkY = (ImageView) findViewById(R.h.cdG);
        this.nrB = findViewById(R.h.cdu);
        this.nrd = (TextView) findViewById(R.h.cdt);
        this.nrC = (ImageView) findViewById(R.h.cdH);
        this.nrD = (TextView) findViewById(R.h.cdF);
        this.nrE = findViewById(R.h.cdB);
        this.nrF = (TextView) findViewById(R.h.cdC);
        this.nrG = (Button) findViewById(R.h.cdI);
        this.nrH = (TextView) findViewById(R.h.cdy);
        this.nrI = (CheckBox) findViewById(R.h.cdJ);
        this.nkY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

            {
                this.nrO = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (this.nrO.nrN == null || !this.nrO.nrN.a(this.nrO, bundle, null, true)) {
                    this.nrO.finish();
                } else {
                    this.nrO.nrN = null;
                }
            }
        });
        re(8);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof t) {
            if (i == 0 && i2 == 0) {
                this.nrM = (t) kVar;
                this.nqq = this.nrM.njw;
                this.nrL = this.nrM.nme;
                g.oUh.i(13050, new Object[]{Integer.valueOf(this.nrn), Integer.valueOf(1), this.nrM.nni});
                if (this.nrM.fZH == 2) {
                    b(new u(this.nqq, 11, 0, this.nqr, "v1.0"), false);
                } else {
                    if (this.irJ != null && this.irJ.isShowing()) {
                        this.irJ.hide();
                    }
                    n.a(this.nqi, this.nrM.nnn, true);
                    n.a(this.uSU.uTo, this.nqj, this.nrM.nnc);
                    n.f(this.nrC, this.nrM.nmy);
                    if (this.nrM.fZH == 1 || this.nrM.fZG == 4 || this.nrM.fZG == 5 || this.nrM.fZG == 1) {
                        g.oUh.i(11701, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                        this.nrz.setVisibility(4);
                        this.nrA.setText(this.nrM.nmf);
                        this.nql.setVisibility(8);
                        if (this.nrL == 1) {
                            this.nrD.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                                {
                                    this.nrO = r1;
                                }

                                public final void onClick(View view) {
                                    g.oUh.i(11701, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                                    Intent intent = new Intent();
                                    intent.setClass(this.nrO.uSU.uTo, LuckyMoneyBusiDetailUI.class);
                                    intent.putExtra("key_native_url", this.nrO.nqr);
                                    intent.putExtra("key_sendid", this.nrO.nrM.njw);
                                    intent.putExtra("key_static_from_scene", this.nrO.nrn);
                                    this.nrO.startActivity(intent);
                                    this.nrO.finish();
                                }
                            });
                            this.nrD.setVisibility(0);
                        } else {
                            this.nrD.setVisibility(8);
                        }
                    } else {
                        if (!bg.mA(this.nrM.nni)) {
                            this.nrK = this.nrM.nni;
                            if (this.nrM.nnj == 1) {
                                this.nrI.setVisibility(8);
                            } else {
                                w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.nrM.nni);
                                if (this.nrM.nng == 1) {
                                    this.nrI.setChecked(true);
                                } else {
                                    this.nrI.setChecked(false);
                                }
                                this.nrI.setText(this.nrM.nnh);
                            }
                        }
                        this.nql.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                            {
                                this.nrO = r1;
                            }

                            public final void onClick(View view) {
                                g.oUh.i(11701, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                                if (this.nrO.nrI.isChecked()) {
                                    g.oUh.i(13050, new Object[]{Integer.valueOf(this.nrO.nrn), Integer.valueOf(2), this.nrO.nrM.nni});
                                } else {
                                    g.oUh.i(13050, new Object[]{Integer.valueOf(this.nrO.nrn), Integer.valueOf(2), ""});
                                }
                                if ("0".equals(this.nrO.nrM.nnq)) {
                                    com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this.nrO, this.nrO.nqY, this.nrO.nrM.nnr, this.nrO.nrM.nns, this.nrO.nrM.nnt, this.nrO.nrM.nnu, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                                        final /* synthetic */ AnonymousClass4 nrP;

                                        {
                                            this.nrP = r1;
                                        }

                                        public final boolean a(int i, int i2, String str, boolean z) {
                                            w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                                            if (i == 0 || z) {
                                                LuckyMoneyBusiReceiveUI.i(this.nrP.nrO);
                                            }
                                            return true;
                                        }
                                    }, false, MMBitmapFactory.ERROR_IO_FAILED);
                                } else {
                                    LuckyMoneyBusiReceiveUI.i(this.nrO);
                                }
                            }
                        });
                        if (bg.mA(this.nrM.nmf)) {
                            this.nrz.setVisibility(8);
                        } else {
                            this.nrz.setText(this.nrM.nmf);
                        }
                        if (bg.mA(this.nrM.nno)) {
                            this.nrA.setVisibility(8);
                        } else {
                            this.nrA.setText(this.nrM.nno);
                        }
                    }
                    n.a(this.nqp, null);
                    this.uSU.ipu.setVisibility(0);
                }
                return true;
            }
        } else if (kVar instanceof s) {
            n.c(this.nql);
            if (i == 0 && i2 == 0) {
                final s sVar = (s) kVar;
                if (sVar.fZH != 2) {
                    this.nrz.setVisibility(4);
                    this.nrA.setText(sVar.nmf);
                    this.nql.setVisibility(8);
                    if (this.nrL == 1) {
                        this.nrD.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                            public final void onClick(View view) {
                                Intent intent = new Intent();
                                intent.setClass(this.nrO.uSU.uTo, LuckyMoneyBusiDetailUI.class);
                                if (sVar.nnl != null) {
                                    intent.putExtra("key_realname_guide_helper", sVar.nnl);
                                }
                                intent.putExtra("key_native_url", this.nrO.nqr);
                                intent.putExtra("key_sendid", sVar.njw);
                                intent.putExtra("key_static_from_scene", this.nrO.nrn);
                                this.nrO.startActivity(intent);
                                this.nrO.finish();
                            }
                        });
                        this.nrD.setVisibility(0);
                    } else {
                        this.nrD.setVisibility(8);
                    }
                } else if (sVar.kAx <= 1 || !(sVar.nmv == null || sVar.nmv.gPD == 1)) {
                    w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    r1 = new Intent();
                    r1.putExtra("key_sendid", sVar.njw);
                    r1.putExtra("key_static_from_scene", this.nrn);
                    if (sVar.nnl != null) {
                        r1.putExtra("key_realname_guide_helper", sVar.nnl);
                    }
                    try {
                        r1.putExtra("key_detail_info", sVar.nnk.toByteArray());
                        r1.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        w.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    if (com.tencent.mm.i.g.sV().getInt("PlayCoinSound", 0) > 0) {
                        r1.putExtra("play_sound", true);
                    }
                    d.b(this.uSU.uTo, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", r1);
                    finish();
                    return true;
                } else {
                    CharSequence string;
                    final View findViewById = findViewById(R.h.cdE);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            findViewById.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.nrd.setText(e.n(((double) sVar.fZT) / 100.0d));
                    this.nqj.setText(sVar.nnc);
                    this.nrz.setVisibility(8);
                    this.nrA.setVisibility(8);
                    this.nrB.setVisibility(0);
                    this.nql.setVisibility(8);
                    if (bg.mA(sVar.nnf)) {
                        string = getString(R.l.eyu);
                    } else {
                        string = sVar.nnf;
                    }
                    this.nrG.setText(string);
                    this.nrH.setVisibility(0);
                    g.oUh.i(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                    w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + sVar.kAx);
                    if (sVar.kAx > 1 || (sVar.nmv != null && sVar.nmv.gPD == 1)) {
                        w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.nrN = sVar.nnl;
                        this.nrG.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                            public final void onClick(View view) {
                                CharSequence string;
                                this.nrO.nqp.setVisibility(4);
                                this.nrO.nrH.setVisibility(8);
                                this.nrO.nrB.setVisibility(8);
                                if (sVar.nmv == null || bg.mA(sVar.nmv.nlQ)) {
                                    string = this.nrO.getString(R.l.eyv);
                                } else {
                                    string = sVar.nmv.nlQ;
                                }
                                this.nrO.nrG.setText(string);
                                this.nrO.nrF.setText(sVar.nnd);
                                this.nrO.nrE.setVisibility(0);
                                this.nrO.nrG.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass7 nrS;

                                    {
                                        this.nrS = r1;
                                    }

                                    public final void onClick(View view) {
                                        g.oUh.i(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                                        n.a(this.nrS.nrO, 1, false);
                                    }
                                });
                                n.a(this.nrO.nqp, new AnimationListener(this) {
                                    final /* synthetic */ AnonymousClass7 nrS;

                                    {
                                        this.nrS = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                        this.nrS.nrO.nqp.setVisibility(0);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                    }
                                });
                            }
                        });
                    } else {
                        this.nrG.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                            {
                                this.nrO = r1;
                            }

                            public final void onClick(View view) {
                                this.nrO.finish();
                            }
                        });
                    }
                    this.nrG.setVisibility(0);
                }
                return true;
            } else if (i2 == 416) {
                if (this.irJ != null && this.irJ.isShowing()) {
                    this.irJ.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.nql.setBackgroundResource(R.g.bfd);
                return n.a(this, i2, kVar, bundle, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                    {
                        this.nrO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new b.a(this) {
                    final /* synthetic */ LuckyMoneyBusiReceiveUI nrO;

                    {
                        this.nrO = r1;
                    }

                    public final Intent j(int i, Bundle bundle) {
                        w.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
                        return null;
                    }
                }, MMBitmapFactory.ERROR_IO_FAILED);
            }
        } else if (kVar instanceof af) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.g.bl(this, getString(R.l.esl));
                g.oUh.i(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                finish();
                return true;
            }
            com.tencent.mm.ui.base.g.bl(this, str);
            return true;
        } else if (kVar instanceof r) {
            if (i == 0 && i2 == 0) {
                setResult(-1);
                k(new t(this.nqq, this.nqr, this.nrJ, getIntent().getStringExtra("packageExt")));
                return true;
            } else if (this.nrJ == 4) {
                finish();
                return false;
            } else {
                setResult(0);
                finish();
                return true;
            }
        } else if (kVar instanceof o) {
            return true;
        } else {
            if (kVar instanceof u) {
                if (this.irJ != null && this.irJ.isShowing()) {
                    this.irJ.hide();
                }
                if (i == 0 && i2 == 0) {
                    u uVar = (u) kVar;
                    r1 = new Intent();
                    r1.setClass(this.uSU.uTo, LuckyMoneyBusiDetailUI.class);
                    try {
                        r1.putExtra("key_detail_info", uVar.nnk.toByteArray());
                        r1.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        w.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    r1.putExtra("key_native_url", this.nqr);
                    r1.putExtra("key_sendid", this.nqq);
                    r1.putExtra("key_static_from_scene", this.nrn);
                    startActivity(r1);
                    finish();
                    return true;
                }
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    g.oUh.i(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), stringExtra});
                    if (!bg.mA(stringExtra)) {
                        k(new af(stringExtra, this.nqq, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return R.i.dhc;
    }
}
