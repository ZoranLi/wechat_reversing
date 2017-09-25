package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.y.k;
import java.io.IOException;

@a(3)
public class En_fba4b94f extends LuckyMoneyBaseUI {
    private p irJ = null;
    private long jXw = 0;
    private TextView kCp;
    private int maxSize = 0;
    private String mqJ;
    private ImageView nkY;
    private ae noa;
    private ImageView nqi;
    private TextView nqj;
    private TextView nqk;
    private Button nql;
    private View nqm;
    private ImageView nqn;
    private TextView nqo;
    private View nqp;
    private String nqq;
    private String nqr;
    private w nqs = null;
    private int textSize = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nqr = getIntent().getStringExtra("key_native_url");
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyReceiveUI", "nativeUrl= " + bg.mz(this.nqr));
        KC();
        Uri parse = Uri.parse(bg.mz(this.nqr));
        try {
            this.nqq = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        this.nqs = m.btP().If(this.nqr);
        if (this.nqs != null && this.nqs.field_receiveAmount > 0 && bg.aA(this.nqs.field_receiveTime) < 86400000) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyReceiveUI", "use cache this item %s %s", new Object[]{Long.valueOf(this.nqs.field_receiveTime), bg.mz(this.nqr)});
            Intent intent = new Intent();
            intent.setClass(this.uSU.uTo, LuckyMoneyDetailUI.class);
            intent.putExtra("key_native_url", this.nqs.field_mNativeUrl);
            intent.putExtra("key_sendid", this.nqq);
            startActivity(intent);
            finish();
        } else if (bg.mA(this.nqq)) {
            finish();
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.LuckyMoneyReceiveUI", "sendid null & finish");
        } else {
            int i = bg.getInt(parse.getQueryParameter("channelid"), 1);
            this.mqJ = parse.getQueryParameter("sendusername");
            b(new ae(i, this.nqq, this.nqr, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
            if (this.irJ != null) {
                this.irJ.show();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        this.jXw = bg.Ny();
    }

    protected void onPause() {
        super.onPause();
        d.d("LEn_01a721a4", this.jXw, bg.Ny());
    }

    protected final void KC() {
        this.nqp = findViewById(R.h.cfY);
        this.nqi = (ImageView) findViewById(R.h.cga);
        this.nqj = (TextView) findViewById(R.h.cgb);
        this.kCp = (TextView) findViewById(R.h.cgc);
        this.nqk = (TextView) findViewById(R.h.cgd);
        this.nql = (Button) findViewById(R.h.cgh);
        this.nqo = (TextView) findViewById(R.h.cge);
        this.nqm = findViewById(R.h.cgf);
        this.nqn = (ImageView) findViewById(R.h.cds);
        this.nkY = (ImageView) findViewById(R.h.cgg);
        this.nkY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ En_fba4b94f nqt;

            {
                this.nqt = r1;
            }

            public final void onClick(View view) {
                this.nqt.finish();
            }
        });
        this.maxSize = (int) (((float) com.tencent.mm.bg.a.U(this.uSU.uTo, R.f.baq)) * 1.375f);
        this.textSize = com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.baq);
        this.textSize = this.textSize > this.maxSize ? this.maxSize : this.textSize;
        this.nqk.setTextSize(0, (float) this.textSize);
        this.uSU.ipu.setVisibility(8);
        this.irJ = g.a(this.uSU.uTo, getString(R.l.cbS), true, new OnCancelListener(this) {
            final /* synthetic */ En_fba4b94f nqt;

            {
                this.nqt = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.nqt.irJ != null && this.nqt.irJ.isShowing()) {
                    this.nqt.irJ.dismiss();
                }
                this.nqt.nqY.aHT();
                if (this.nqt.uSU.ipu.getVisibility() == 8 || this.nqt.uSU.ipu.getVisibility() == 4) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyReceiveUI", "user cancel & finish");
                    this.nqt.finish();
                }
            }
        });
        if (this.nql != null) {
            String d = v.d(ab.getContext().getSharedPreferences(ab.bIX(), 0));
            if (d == null || d.length() <= 0 || !(d.equals("zh_CN") || d.equals("zh_TW") || d.equals("zh_HK"))) {
                this.nql.setBackgroundResource(R.g.bgP);
                this.nql.setText(R.l.eyc);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dhu;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        LayoutParams layoutParams;
        if (!(kVar instanceof ae)) {
            if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.ab) {
                n.c(this.nql);
                if (i == 0 && i2 == 0) {
                    final com.tencent.mm.plugin.luckymoney.b.ab abVar = (com.tencent.mm.plugin.luckymoney.b.ab) kVar;
                    e eVar = abVar.nnk;
                    if (eVar.fZH == 2) {
                        Intent intent = new Intent();
                        intent.setClass(this.uSU.uTo, LuckyMoneyDetailUI.class);
                        try {
                            intent.putExtra("key_detail_info", abVar.nnk.toByteArray());
                            intent.putExtra("key_jump_from", 2);
                        } catch (IOException e) {
                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                        }
                        intent.putExtra("key_native_url", abVar.fZF);
                        intent.putExtra("key_sendid", abVar.njw);
                        if (com.tencent.mm.i.g.sV().getInt("PlayCoinSound", 0) > 0) {
                            intent.putExtra("play_sound", true);
                        }
                        if (abVar.nnl != null) {
                            intent.putExtra("key_realname_guide_helper", abVar.nnl);
                        }
                        startActivity(intent);
                        w wVar = new w();
                        wVar.field_mNativeUrl = this.nqr;
                        wVar.field_hbType = eVar.nme;
                        wVar.field_receiveAmount = eVar.fZT;
                        wVar.field_receiveTime = System.currentTimeMillis();
                        wVar.field_hbStatus = eVar.fZG;
                        wVar.field_receiveStatus = eVar.fZH;
                        if (wVar.field_receiveAmount > 0) {
                            m.btP().a(wVar);
                        }
                        finish();
                    } else {
                        this.nql.setBackgroundResource(R.g.bgO);
                        this.nql.setText(R.l.exZ);
                        this.nql.setOnClickListener(null);
                        this.nql.setVisibility(8);
                        if (bg.mA(eVar.njD)) {
                            this.kCp.setVisibility(8);
                        } else {
                            this.kCp.setText(eVar.njD);
                            this.kCp.setVisibility(0);
                        }
                        this.nqk.setText(eVar.nmf);
                        layoutParams = (LayoutParams) this.nqm.getLayoutParams();
                        layoutParams.bottomMargin = b.a(this.uSU.uTo, 30.0f);
                        this.nqm.setLayoutParams(layoutParams);
                        if (com.tencent.mm.u.m.xL().equals(this.mqJ) || eVar.nme == 1) {
                            this.nqm.setVisibility(0);
                            this.nqm.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ En_fba4b94f nqt;

                                public final void onClick(View view) {
                                    Intent intent = new Intent();
                                    if (abVar.nnl != null) {
                                        intent.putExtra("key_realname_guide_helper", abVar.nnl);
                                    }
                                    intent.setClass(this.nqt.uSU.uTo, LuckyMoneyDetailUI.class);
                                    intent.putExtra("key_native_url", abVar.fZF);
                                    intent.putExtra("key_sendid", abVar.njw);
                                    this.nqt.startActivity(intent);
                                    this.nqt.finish();
                                }
                            });
                            this.nqn.setVisibility(8);
                        } else {
                            this.nqm.setVisibility(8);
                            this.nqn.setVisibility(0);
                        }
                    }
                    return true;
                } else if (i2 == 416) {
                    if (this.irJ != null && this.irJ.isShowing()) {
                        this.irJ.hide();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.En_fba4b94f");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    this.nql.setBackgroundResource(R.g.bfd);
                    return n.a(this, i2, kVar, bundle, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ En_fba4b94f nqt;

                        {
                            this.nqt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, null, MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                }
            } else if (kVar instanceof u) {
                if (this.irJ != null && this.irJ.isShowing()) {
                    this.irJ.hide();
                }
                if (i == 0 && i2 == 0) {
                    u uVar = (u) kVar;
                    Intent intent2 = new Intent();
                    intent2.setClass(this.uSU.uTo, LuckyMoneyDetailUI.class);
                    try {
                        intent2.putExtra("key_detail_info", uVar.nnk.toByteArray());
                        intent2.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    intent2.putExtra("key_native_url", this.nqr);
                    intent2.putExtra("key_sendid", this.nqq);
                    startActivity(intent2);
                    finish();
                    return true;
                }
                g.bl(this, str);
                finish();
                return true;
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            this.noa = (ae) kVar;
            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(oT(this.noa.nme)), Integer.valueOf(aIm()), Integer.valueOf(0), Integer.valueOf(1)});
            w wVar2 = new w();
            wVar2.field_mNativeUrl = this.nqr;
            wVar2.field_hbType = this.noa.nme;
            wVar2.field_receiveAmount = this.noa.nnT;
            wVar2.field_receiveTime = System.currentTimeMillis();
            wVar2.field_hbStatus = this.noa.fZG;
            wVar2.field_receiveStatus = this.noa.fZH;
            m.btP().a(wVar2);
            if (this.noa.fZH == 2) {
                b(new u(this.nqq, 11, 0, this.nqr, "v1.0"), false);
            } else {
                if (this.irJ != null && this.irJ.isShowing()) {
                    this.irJ.hide();
                }
                n.a(this.nqi, this.noa.nmj, this.noa.nmD);
                n.a(this.uSU.uTo, this.nqj, this.noa.nnS);
                boolean z = false;
                if (this.noa.fZH == 1 || this.noa.fZG == 4 || this.noa.fZG == 5 || this.noa.fZG == 1) {
                    this.nql.setBackgroundResource(R.g.bgO);
                    this.nql.setText(R.l.exZ);
                    this.nql.setOnClickListener(null);
                    this.nql.setVisibility(8);
                    if (bg.mA(this.noa.njD)) {
                        this.kCp.setVisibility(8);
                    } else {
                        this.kCp.setText(this.noa.njD);
                        this.kCp.setVisibility(0);
                    }
                    this.nqk.setText(this.noa.nmf);
                    layoutParams = (LayoutParams) this.nqm.getLayoutParams();
                    layoutParams.bottomMargin = b.a(this.uSU.uTo, 30.0f);
                    this.nqm.setLayoutParams(layoutParams);
                    z = true;
                } else {
                    if (!bg.mA(this.noa.nmf)) {
                        this.kCp.setText(this.noa.nmf);
                        this.kCp.setVisibility(0);
                    }
                    if (!bg.mA(this.noa.nmh)) {
                        n.a(this.uSU.uTo, this.nqk, this.noa.nmh);
                        this.nqk.setVisibility(0);
                    }
                    this.nql.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ En_fba4b94f nqt;

                        {
                            this.nqt = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(En_fba4b94f.oT(this.nqt.noa.nme)), Integer.valueOf(this.nqt.aIm()), Integer.valueOf(0), Integer.valueOf(2)});
                            if ("0".equals(this.nqt.noa.nnq)) {
                                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this.nqt, this.nqt.nqY, this.nqt.noa.nnr, this.nqt.noa.nns, this.nqt.noa.nnt, this.nqt.noa.nnu, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                                    final /* synthetic */ AnonymousClass3 nqu;

                                    {
                                        this.nqu = r1;
                                    }

                                    public final boolean a(int i, int i2, String str, boolean z) {
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                                        if (i == 1) {
                                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyReceiveUI", "showDisclaimerDialog cancel");
                                        } else if (z || i == 2) {
                                            this.nqu.nqt.aIn();
                                        }
                                        return true;
                                    }
                                }, false, MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                            } else {
                                this.nqt.aIn();
                            }
                        }
                    });
                }
                if (com.tencent.mm.u.m.xL().equals(this.mqJ) || (this.noa.nme == 1 && z)) {
                    if (this.noa.nme == 1) {
                        this.nqo.setText(R.l.exo);
                    }
                    this.nqm.setVisibility(0);
                    this.nqm.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ En_fba4b94f nqt;

                        public final void onClick(View view) {
                            if (z) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(6), Integer.valueOf(En_fba4b94f.oT(this.nqt.noa.nme)), Integer.valueOf(this.nqt.aIm()), Integer.valueOf(0), Integer.valueOf(1)});
                            }
                            Intent intent = new Intent();
                            intent.setClass(this.nqt.uSU.uTo, LuckyMoneyDetailUI.class);
                            intent.putExtra("key_native_url", this.nqt.noa.fZF);
                            intent.putExtra("key_sendid", this.nqt.noa.njw);
                            this.nqt.startActivity(intent);
                            this.nqt.finish();
                        }
                    });
                    this.nqn.setVisibility(8);
                } else {
                    this.nqm.setVisibility(8);
                    this.nqn.setVisibility(0);
                }
                n.a(this.nqp, null);
                this.uSU.ipu.setVisibility(0);
                if (this.noa.fZG == 5 && wVar2.field_receiveAmount > 0) {
                    this.nqn.setVisibility(8);
                    this.nqm.setVisibility(0);
                    this.kCp.setVisibility(0);
                    this.kCp.setText(R.l.eyo);
                    this.nqk.setVisibility(8);
                    findViewById(R.h.cfZ).setVisibility(0);
                    ((WalletTextView) findViewById(R.h.cdK)).setText(com.tencent.mm.wallet_core.ui.e.n(((double) wVar2.field_receiveAmount) / 100.0d));
                    this.nqm.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ En_fba4b94f nqt;

                        {
                            this.nqt = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setClass(this.nqt.uSU.uTo, LuckyMoneyDetailUI.class);
                            intent.putExtra("key_native_url", this.nqt.noa.fZF);
                            intent.putExtra("key_sendid", this.nqt.noa.njw);
                            this.nqt.startActivity(intent);
                            this.nqt.finish();
                        }
                    });
                }
            }
            return true;
        } else {
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.hide();
            }
            return false;
        }
    }

    private int aIm() {
        if (com.tencent.mm.u.m.xL().equals(this.mqJ)) {
            return 1;
        }
        return 0;
    }

    private static int oT(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 2;
        }
        return 0;
    }

    public final void aIn() {
        b(new com.tencent.mm.plugin.luckymoney.b.ab(this.noa.msgType, this.noa.fuV, this.noa.njw, this.noa.fZF, n.aHX(), com.tencent.mm.u.m.xN(), getIntent().getStringExtra("key_username"), "v1.0", this.noa.nnW), false);
        n.b(this.nql);
    }
}
