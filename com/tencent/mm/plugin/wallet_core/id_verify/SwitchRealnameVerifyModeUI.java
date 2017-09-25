package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements OnClickListener {
    private int hEm = 0;
    private View rCA;
    private View rCB;
    private View rCC;
    private TextView rCD;
    private TextView rCE;
    private TextView rCF;
    private TextView rCG;
    private TextView rCH;
    private TextView rCI;
    private TextView rCJ;
    private String rCK;
    private String rCL;
    private String rCM;
    private boolean rCN;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ccE();
        this.hEm = this.uT.getInt("entry_scene", this.hEm);
        e.a(13, bg.Ny(), this.hEm);
    }

    protected final void KC() {
        zi(R.l.fjp);
        this.rCA = findViewById(R.h.cGV);
        this.rCB = findViewById(R.h.cGW);
        this.rCC = findViewById(R.h.cGX);
        this.rCB.setOnClickListener(this);
        this.rCA.setOnClickListener(this);
        this.rCC.setOnClickListener(this);
        this.rCD = (TextView) findViewById(R.h.bsO);
        this.rCE = (TextView) findViewById(R.h.bsN);
        this.rCF = (TextView) findViewById(R.h.bsS);
        this.rCG = (TextView) findViewById(R.h.bsR);
        this.rCH = (TextView) findViewById(R.h.bNv);
        this.rCI = (TextView) findViewById(R.h.cLx);
        this.rCJ = (TextView) findViewById(R.h.cLw);
        if (!iA(false)) {
            k bVar = new b();
            hn(1666);
            k(bVar);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SwitchRealnameVerifyModeUI rCO;

            {
                this.rCO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.wallet_core.b ccE = this.rCO.ccE();
                if (ccE == null) {
                    return false;
                }
                e.a(14, bg.Ny(), this.rCO.hEm);
                ccE.c(this.rCO, 0);
                this.rCO.finish();
                return true;
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof a) {
            if (i == 0 && i2 == 0) {
                ho(580);
                ((a) kVar).aQZ();
                com.tencent.mm.wallet_core.b ccE = ccE();
                if (ccE == null) {
                    return true;
                }
                Bundle bundle = ccE.lHw;
                bundle.putInt("real_name_verify_mode", 1);
                com.tencent.mm.wallet_core.a.k(this, bundle);
                return true;
            }
        } else if (kVar instanceof b) {
            ho(1666);
            iA(true);
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drm;
    }

    public void onClick(View view) {
        int id = view.getId();
        final com.tencent.mm.wallet_core.b ccE = ccE();
        if (ccE != null) {
            Bundle bundle = ccE.lHw;
            if (id == R.h.cGV) {
                e.a(15, bg.Ny(), this.hEm);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (bg.mA(str)) {
                        str = getString(R.l.fkA);
                    }
                    g.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SwitchRealnameVerifyModeUI rCO;

                        {
                            this.rCO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rCO.finish();
                        }
                    });
                    return;
                } else {
                    hn(580);
                    q(new a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)));
                    return;
                }
            } else if (id == R.h.cGW) {
                e.a(17, bg.Ny(), this.hEm);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == R.h.cGX) {
                e.a(16, bg.Ny(), this.hEm);
                if (!this.rCN || bg.mA(this.rCM)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    g.a(this, this.rCM, "", this.rCL, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SwitchRealnameVerifyModeUI rCO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bundle bundle = ccE.lHw;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            com.tencent.mm.wallet_core.a.k(this.rCO, bundle);
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.wallet_core.a.k(this, bundle);
        }
    }

    private static JSONObject btx() {
        ap.yY();
        Object obj = c.vr().get(w.a.uDJ, "");
        if (obj != null) {
            String str = (String) obj;
            if (!bg.mA(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = jSONObject.getLong("timestamp");
                    long j2 = jSONObject.getLong("cache_time");
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j + ";cachetime=" + j2);
                    if (currentTimeMillis - j <= j2) {
                        return jSONObject;
                    }
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                    return null;
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", e, "", new Object[0]);
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    return null;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        return null;
    }

    private boolean iA(boolean z) {
        JSONObject jSONObject;
        JSONObject btx = btx();
        if (z && btx == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = btx;
        }
        if (jSONObject == null) {
            return z;
        }
        ((TextView) findViewById(R.h.cGU)).setText(bg.ap(jSONObject.optString("cache_header_titles", getString(R.l.eXm)), getString(R.l.eXm)));
        if (jSONObject.optBoolean("isShowBindCardVerify", false)) {
            this.rCI.setText(jSONObject.optString("bindCardVerifyTitle"));
            this.rCJ.setText(jSONObject.optString("bindCardVerifySubtitle"));
            this.rCC.setVisibility(0);
        } else {
            this.rCC.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindCard", false)) {
            this.rCD.setText(jSONObject.optString("bindcardTitle", getString(R.l.eXn)));
            this.rCE.setText(jSONObject.optString("bindcardSubTitle", getString(R.l.eXo)));
            this.rCA.setVisibility(0);
        } else {
            this.rCA.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindId", false)) {
            this.rCF.setText(jSONObject.optString("bindIdTitle", getString(R.l.eXp)));
            this.rCG.setText(jSONObject.optString("bindIdSubTitle", getString(R.l.eXq)));
            this.rCB.setVisibility(0);
        } else {
            this.rCB.setVisibility(8);
        }
        this.rCL = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.rCM = jSONObject.optString("bindCardVerifyAlertViewContent", "");
        this.rCN = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        CharSequence optString = jSONObject.optString("extral_wording", "");
        if (bg.mA(optString)) {
            this.rCH.setVisibility(8);
        } else {
            this.rCH.setText(optString);
            this.rCH.setVisibility(0);
        }
        this.rCL = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.rCM = jSONObject.optString("bindCardVerifyAlertViewContent");
        this.rCN = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        boolean optBoolean = jSONObject.optBoolean("question_answer_switch", false);
        this.rCK = jSONObject.optString("question_answer_url", "");
        if (optBoolean && !bg.mA(this.rCK)) {
            a(0, R.g.blV, new OnMenuItemClickListener(this) {
                final /* synthetic */ SwitchRealnameVerifyModeUI rCO;

                {
                    this.rCO = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e.a(18, bg.Ny(), this.rCO.hEm);
                    e.m(this.rCO.uSU.uTo, this.rCO.rCK, false);
                    return true;
                }
            });
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            com.tencent.mm.wallet_core.b ccE = ccE();
            if (ccE != null) {
                e.a(14, bg.Ny(), this.hEm);
                ccE.c((Activity) this, 0);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
