package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.b.j;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(3)
public class WalletCheckPwdUI extends WalletBaseUI {
    private String lOq;
    private boolean rKN = false;
    private boolean rKO = false;
    private boolean rKP = false;
    private String rKQ;
    public EditHintPasswdView rwi;

    protected final int getLayoutId() {
        return R.i.dqu;
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        CharSequence qK = qK(1);
        if (bg.J(qK)) {
            qP(s.fl(this));
        } else {
            qP(qK.toString());
        }
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            b ai = com.tencent.mm.wallet_core.a.ai(this);
            if (ai != null) {
                int i2 = ai.lHw.getInt("scene", -1);
                boolean z = i2 == 1 && "UnbindProcess".equals(ai.avB());
                this.rKP = z;
                i = i2;
            }
        } else {
            i = intent.getIntExtra("scene", -1);
        }
        if (i == 1) {
            this.rKO = true;
            w.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            Bundle bundle2 = null;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            k aVar;
            if (this.rKP) {
                b ai2 = com.tencent.mm.wallet_core.a.ai(this);
                if (ai2 != null) {
                    bundle2 = ai2.lHw;
                }
                if (bundle2 == null) {
                    w.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    finish();
                }
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (this.rKP) {
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 5);
                } else {
                    w.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bg.mA(string));
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 10);
                }
                q(aVar);
            } else if (getIntent() == null) {
                w.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
            } else {
                bundle2 = getIntent().getExtras();
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (this.rKP) {
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 5);
                } else {
                    w.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bg.mA(string));
                    aVar = new com.tencent.mm.plugin.wallet_core.b.a(string, string2, string3, string4, string5, string6, string7, 10);
                }
                q(aVar);
            }
            KC();
        } else {
            re(0);
            if (!this.uT.getBoolean("key_is_expired_bankcard", false)) {
                KC();
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletCheckPwdUI rKR;

            {
                this.rKR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                b ccE = this.rKR.ccE();
                w.i("Micromsg.WalletCheckPwdUI", "onbackbtn click");
                if (ccE != null) {
                    if (ccE instanceof com.tencent.mm.plugin.wallet_core.id_verify.a) {
                        ccE.c(this.rKR, 0);
                    } else if (this.rKR.rKP) {
                        ccE.lHw.putInt("key_process_result_code", 0);
                        ccE.d(this.rKR, ccE.lHw);
                    }
                }
                this.rKR.finish();
                return false;
            }
        });
    }

    protected final void aHT() {
        w.d("Micromsg.WalletCheckPwdUI", "check pwd ");
        this.wFr.aHT();
    }

    public void onResume() {
        if (this.rwi != null) {
            this.rwi.aWw();
        }
        hn(580);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        ho(580);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        TextView textView = (TextView) findViewById(R.h.bXM);
        CharSequence qK = qK(0);
        if (bg.J(qK)) {
            textView.setText(R.l.ffb);
        } else {
            textView.setText(qK);
            if (qK instanceof SpannableString) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        this.rwi = (EditHintPasswdView) findViewById(R.h.bXJ);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rwi);
        this.rwi.wFT = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletCheckPwdUI rKR;

            {
                this.rKR = r1;
            }

            public final void gA(boolean z) {
                if (z) {
                    this.rKR.lOq = this.rKR.rwi.getText();
                    b ai = com.tencent.mm.wallet_core.a.ai(this.rKR);
                    Object obj = null;
                    if (ai != null) {
                        obj = ai.avB();
                    }
                    if (!this.rKR.rKO || "UnbindProcess".equals(r0)) {
                        if (!this.rKR.ccF().j(this.rKR.lOq, this.rKR.bsF())) {
                            this.rKR.k(new i(this.rKR.lOq, 1, this.rKR.bsF()));
                            return;
                        }
                        return;
                    }
                    this.rKR.k(new j(this.rKR.lOq, this.rKR.rKQ));
                }
            }
        };
        d(this.rwi, 0, false);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        w.d("Micromsg.WalletCheckPwdUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof i) {
                Bundle bundle = this.uT;
                bundle.putString("key_pwd1", this.rwi.getText());
                com.tencent.mm.wallet_core.a.k(this, bundle);
                if (this.rwi != null) {
                    this.rwi.aWw();
                }
                finish();
            } else if (kVar instanceof m) {
                g.bl(this, getString(R.l.fff));
                b ai = com.tencent.mm.wallet_core.a.ai(this);
                if (ai != null) {
                    ai.lHw.putInt("key_process_result_code", -1);
                }
                com.tencent.mm.wallet_core.a.k(this, ai.lHw);
                if (this.rwi != null) {
                    this.rwi.aWw();
                }
                finish();
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
                this.rKQ = ((com.tencent.mm.plugin.wallet_core.b.a) kVar).aQZ();
                setResult(-1);
                re(0);
            } else if (kVar instanceof j) {
                j jVar = (j) kVar;
                if (jVar.btt()) {
                    w.i("Micromsg.WalletCheckPwdUI", "need free sms");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key_pwd1", this.lOq);
                    bundle2.putString("key_jsapi_token", this.rKQ);
                    bundle2.putString("key_relation_key", jVar.rBU);
                    bundle2.putString("key_mobile", jVar.rBT);
                    com.tencent.mm.wallet_core.a.a((Activity) this, j.class, bundle2, new b.a(this) {
                        final /* synthetic */ WalletCheckPwdUI rKR;

                        {
                            this.rKR = r1;
                        }

                        public final Intent j(int i, Bundle bundle) {
                            Intent intent = new Intent();
                            intent.putExtra("token", bundle.getString("key_jsapi_token"));
                            intent.putExtra("key_process_result_code", i);
                            intent.setClass(this.rKR.uSU.uTo, WalletCheckPwdUI.class);
                            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                            intent.putExtra("key_process_is_stay", false);
                            return intent;
                        }
                    });
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", ((j) kVar).rBR);
                    setResult(-1, intent);
                    finish();
                }
            }
            return true;
        }
        if (this.rwi != null) {
            this.rwi.aWw();
        }
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a)) {
            return false;
        }
        w.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
        b ai2 = com.tencent.mm.wallet_core.a.ai(this);
        if (ai2 == null || !ai2.avB().equals("UnbindProcess")) {
            setResult(0);
            finish();
        } else {
            setResult(1);
            ai2.lHw.putInt("key_process_result_code", 1);
            com.tencent.mm.wallet_core.a.k(this, ai2.lHw);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.npM == null || !this.npM.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.npM.setVisibility(8);
        return true;
    }

    public boolean bsP() {
        if (this.uT.getInt("key_pay_flag", 0) != 0) {
            return true;
        }
        return false;
    }

    public final void qU(int i) {
        if (this.rKN) {
            finish();
        } else if (this.rwi != null) {
            this.rwi.aWw();
        }
    }

    public final boolean aIY() {
        return this.rKN;
    }

    public int Ol() {
        return 1;
    }
}
