package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Map;

public class RegByEmailUI extends MMActivity implements e {
    private static String[] uZB;
    private String gku;
    private ProgressDialog isv = null;
    private String oVk;
    private String uYS;
    private Map<String, String> uZA;
    private MMAutoCompleteTextView uZw;
    private EditText uZx;
    private CheckBox uZy;
    private String uZz;

    static /* synthetic */ void b(RegByEmailUI regByEmailUI) {
        if (bg.mA(regByEmailUI.uZw.getText().toString().trim()) || bg.mA(regByEmailUI.uZx.getText().toString().trim()) || !regByEmailUI.uZy.isChecked()) {
            regByEmailUI.kr(false);
        } else {
            regByEmailUI.kr(true);
        }
    }

    static /* synthetic */ void c(RegByEmailUI regByEmailUI) {
        regByEmailUI.gku = regByEmailUI.uZw.getText().toString().trim();
        regByEmailUI.uYS = regByEmailUI.uZx.getText().toString();
        if (bg.mA(regByEmailUI.gku)) {
            g.h(regByEmailUI, R.l.eJl, R.l.eJh);
        } else if (!bg.PK(regByEmailUI.gku)) {
            g.h(regByEmailUI, R.l.eJk, R.l.eJh);
        } else if (bg.mA(regByEmailUI.uYS)) {
            g.h(regByEmailUI, R.l.eJm, R.l.eJh);
        } else if (bg.PM(regByEmailUI.uYS)) {
            regByEmailUI.aHf();
            final k uVar = new u(regByEmailUI.gku, regByEmailUI.uYS);
            ap.vd().a(uVar, 0);
            regByEmailUI.getString(R.l.dIO);
            regByEmailUI.isv = g.a((Context) regByEmailUI, regByEmailUI.getString(R.l.dJd), true, new OnCancelListener(regByEmailUI) {
                final /* synthetic */ RegByEmailUI uZC;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(uVar);
                }
            });
        } else {
            g.h(regByEmailUI, R.l.eZY, R.l.eJh);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.l.eJq);
        if (d.sYQ) {
            string = getString(R.l.bpJ) + getString(R.l.dDc);
        }
        qP(string);
        a.imw.ox();
        this.uZz = com.tencent.mm.modelsimple.d.bj(this);
        w.i("MicroMsg.RegByEmailUI", "get google account:[%s]", this.uZz);
        this.uZA = com.tencent.mm.plugin.accountsync.b.a.irZ.bs(this);
        if (!(this.uZA == null || this.uZA.isEmpty())) {
            uZB = new String[this.uZA.size()];
            this.uZA.keySet().toArray(uZB);
        }
        this.oVk = b.Oz();
        KC();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(481, (e) this);
        b.b(true, ap.uY() + "," + getClass().getName() + ",R500_100," + ap.ec("R500_100") + ",1");
        b.mM("R500_100");
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(481, (e) this);
        b.b(false, ap.uY() + "," + getClass().getName() + ",R500_100," + ap.ec("R500_100") + ",2");
    }

    protected final int getLayoutId() {
        return R.i.dmu;
    }

    protected final void KC() {
        this.uZw = (MMAutoCompleteTextView) findViewById(R.h.cxp);
        this.uZx = (EditText) findViewById(R.h.cxv);
        this.uZy = (CheckBox) findViewById(R.h.bnW);
        if (!bg.mA(this.uZz)) {
            this.uZx.postDelayed(new Runnable(this) {
                final /* synthetic */ RegByEmailUI uZC;

                {
                    this.uZC = r1;
                }

                public final void run() {
                    this.uZC.uZx.requestFocus();
                }
            }, 500);
            this.uZw.setText(this.uZz);
        }
        if (uZB != null) {
            ListAdapter cVar = new c(this, uZB, "@");
            MMAutoCompleteTextView mMAutoCompleteTextView = this.uZw;
            String str = "@";
            if (!bg.mA(str)) {
                mMAutoCompleteTextView.viy = new a(mMAutoCompleteTextView, str);
                mMAutoCompleteTextView.addTextChangedListener(mMAutoCompleteTextView.viy);
            }
            this.uZw.setDropDownAnchor(R.h.cxq);
            this.uZw.setDropDownVerticalOffset(this.uZw.getPaddingBottom());
            this.uZw.setAdapter(cVar);
        }
        findViewById(R.h.bnV).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final void onClick(View view) {
                bg.F(this.uZC, this.uZC.getString(R.l.eZp));
            }
        });
        this.uZy.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RegByEmailUI.b(this.uZC);
            }
        });
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByEmailUI.c(this.uZC);
                return true;
            }
        });
        kr(false);
        this.uZw.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final void afterTextChanged(Editable editable) {
                RegByEmailUI.b(this.uZC);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.uZx.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final void afterTextChanged(Editable editable) {
                RegByEmailUI.b(this.uZC);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.uZx.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i != 6 && i != 5) || !this.uZC.uZy.isChecked()) {
                    return false;
                }
                RegByEmailUI.c(this.uZC);
                return true;
            }
        });
        this.uZx.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0 || !this.uZC.uZy.isChecked()) {
                    return false;
                }
                RegByEmailUI.c(this.uZC);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uZC.goBack();
                return true;
            }
        });
    }

    private void goBack() {
        g.a((Context) this, R.l.eJe, R.l.eJh, R.l.dHT, R.l.dGs, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RegByEmailUI uZC;

            {
                this.uZC = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                b.mN(this.uZC.oVk);
                this.uZC.aHf();
                this.uZC.finish();
            }
        }, null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (kVar.getType() != 481) {
            w.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", Integer.valueOf(kVar.getType()));
        } else if (i == 0 && i2 == 0) {
            b.mN("R500_200");
            Intent intent = new Intent(this, EmailVerifyUI.class);
            intent.putExtra("email_address", this.gku);
            intent.putExtra("password", this.uYS);
            if (!(this.uZA == null || this.uZA.isEmpty())) {
                String[] split = this.gku.split("@");
                if (split != null && split.length == 2) {
                    intent.putExtra("email_login_page", (String) this.uZA.get(split[1]));
                }
            }
            startActivity(intent);
        } else {
            boolean z;
            if (!a.imw.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -111:
                        g.h(this, R.l.eJk, R.l.eJh);
                        z = true;
                        break;
                    case -75:
                        g.h(this, R.l.dDf, R.l.eJb);
                        z = true;
                        break;
                    case -34:
                        Toast.makeText(this, R.l.eJf, 0).show();
                        z = true;
                        break;
                    case -7:
                        b.mO(ap.uY() + "," + getClass().getName() + ",R20_email_duplicate_confirm," + ap.ec("R20_email_duplicate_confirm") + ",3");
                        g.a((Context) this, R.l.eJr, R.l.eJh, R.l.eJt, R.l.eJs, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ RegByEmailUI uZC;

                            {
                                this.uZC = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.uZC.finish();
                                b.mN("L2_signup");
                                Intent intent = new Intent(this.uZC, LoginPasswordUI.class);
                                intent.putExtra("email_address", this.uZC.gku);
                                this.uZC.startActivity(intent);
                            }
                        }, null);
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            z = true;
            if (!z) {
                if (!bg.mA(str)) {
                    Map q = bh.q(str, "e");
                    if (q != null && q.size() > 0) {
                        String str2 = (String) q.get(".e.Content");
                        if (!bg.mA(str2)) {
                            g.b(this, str2, getString(R.l.eJh), true);
                            return;
                        }
                    }
                }
                Toast.makeText(this, getString(R.l.eJo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
