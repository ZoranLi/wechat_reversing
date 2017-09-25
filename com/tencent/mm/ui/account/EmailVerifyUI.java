package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditText;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;

public class EmailVerifyUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private String oVk;
    private TextView uXo;
    private TextView uXp;
    private MMAutoSwitchEditTextView uXq;
    private Button uXr;
    private Button uXs;
    private String uXt;
    private String uXu;
    private String uXv;
    private String uXw;
    private boolean uXx = false;

    static /* synthetic */ void a(EmailVerifyUI emailVerifyUI, String str) {
        if (emailVerifyUI.uXx) {
            w.i("MicroMsg.EmailVerifyUI", "is verifying, wait a minute");
            return;
        }
        emailVerifyUI.uXx = true;
        final k uVar = new u(emailVerifyUI.uXt, emailVerifyUI.uXv, str);
        ap.vd().a(uVar, 0);
        emailVerifyUI.getString(R.l.dIO);
        emailVerifyUI.isv = g.a((Context) emailVerifyUI, emailVerifyUI.getString(R.l.eJu), true, new OnCancelListener(emailVerifyUI) {
            final /* synthetic */ EmailVerifyUI uXy;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(uVar);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        this.oVk = b.Oz();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(481, (e) this);
        b.b(true, ap.uY() + "," + getClass().getName() + ",R500_200," + ap.ec("R500_200") + ",1");
        b.mM("R500_200");
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(481, (e) this);
        b.b(false, ap.uY() + "," + getClass().getName() + ",R500_200," + ap.ec("R500_200") + ",2");
    }

    protected final int getLayoutId() {
        return R.i.dpr;
    }

    protected final void KC() {
        zi(R.l.eJw);
        this.uXo = (TextView) findViewById(R.h.cLz);
        this.uXo.setText(Html.fromHtml(getString(R.l.eJj)));
        this.uXp = (TextView) findViewById(R.h.bKR);
        this.uXt = getIntent().getStringExtra("email_address");
        if (bg.mA(this.uXt)) {
            w.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        } else {
            this.uXp.setText(this.uXt);
        }
        this.uXv = getIntent().getStringExtra("password");
        this.uXu = getIntent().getStringExtra("email_login_page");
        w.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", this.uXt, this.uXu);
        this.uXq = (MMAutoSwitchEditTextView) findViewById(R.h.bqD);
        this.uXq.viN = new a(this) {
            final /* synthetic */ EmailVerifyUI uXy;

            {
                this.uXy = r1;
            }

            public final void SL(String str) {
                this.uXy.kr(true);
                EmailVerifyUI.a(this.uXy, str);
            }
        };
        this.uXq.viO = new MMAutoSwitchEditTextView.b(this) {
            final /* synthetic */ EmailVerifyUI uXy;

            {
                this.uXy = r1;
            }

            public final void bQJ() {
                this.uXy.kr(false);
            }
        };
        this.uXs = (Button) findViewById(R.h.cvo);
        this.uXs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmailVerifyUI uXy;

            {
                this.uXy = r1;
            }

            public final void onClick(View view) {
                b.mO(ap.uY() + "," + getClass().getName() + ",R500_250," + ap.ec("R500_250") + ",3");
                g.a(this.uXy, R.l.eJn, R.l.eJh, R.l.dHT, R.l.dGs, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 uXz;

                    {
                        this.uXz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        final k uVar = new u(this.uXz.uXy.uXt, this.uXz.uXy.uXv);
                        ap.vd().a(uVar, 0);
                        EmailVerifyUI emailVerifyUI = this.uXz.uXy;
                        Context context = this.uXz.uXy;
                        this.uXz.uXy.getString(R.l.dIO);
                        emailVerifyUI.isv = g.a(context, this.uXz.uXy.getString(R.l.eJv), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 uXB;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(uVar);
                            }
                        });
                    }
                }, null);
            }
        });
        this.uXr = (Button) findViewById(R.h.cps);
        if (bg.mA(this.uXu) || bg.mA(this.uXt)) {
            this.uXr.setVisibility(8);
        } else {
            this.uXr.setVisibility(0);
            this.uXr.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EmailVerifyUI uXy;

                {
                    this.uXy = r1;
                }

                public final void onClick(View view) {
                    bg.F(this.uXy, this.uXy.uXu);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmailVerifyUI uXy;

            {
                this.uXy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uXy.goBack();
                return true;
            }
        });
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ EmailVerifyUI uXy;

            {
                this.uXy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmailVerifyUI emailVerifyUI = this.uXy;
                String str = "";
                Iterator it = this.uXy.uXq.viL.iterator();
                while (it.hasNext()) {
                    String str2;
                    MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                    if (bg.mA(mMAutoSwitchEditText.getText().toString().trim())) {
                        str2 = str;
                    } else {
                        str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                    }
                    str = str2;
                }
                emailVerifyUI.uXw = str;
                if (bg.mA(this.uXy.uXw) || this.uXy.uXw.length() != 12) {
                    this.uXy.kr(false);
                } else {
                    EmailVerifyUI.a(this.uXy, this.uXy.uXw);
                }
                return true;
            }
        });
        kr(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        b.mN(this.oVk);
        finish();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        this.uXx = false;
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (kVar.getType() != 481) {
            w.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", Integer.valueOf(kVar.getType()));
            return;
        }
        int i3 = ((p.a) ((u) kVar).htt.BG()).sZO.thO;
        if (i != 0 || i2 != 0) {
            int i4;
            if (!com.tencent.mm.plugin.c.a.imw.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -34:
                        Toast.makeText(this, R.l.eJf, 0).show();
                        i4 = 1;
                        break;
                    case -33:
                        g.a((Context) this, R.l.eJg, R.l.eJh, null);
                        i4 = 1;
                        break;
                    case -32:
                        g.a((Context) this, R.l.eJi, R.l.eJh, null);
                        b.mO(ap.uY() + "," + getClass().getName() + ",R500_260," + ap.ec("R500_260") + ",3");
                        i4 = 1;
                        break;
                    default:
                        boolean z = false;
                        break;
                }
            }
            i4 = 1;
            if (i4 != 0) {
                return;
            }
            if (i3 == 2) {
                Toast.makeText(this, getString(R.l.eJx, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i3 == 1) {
                Toast.makeText(this, getString(R.l.eJo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (i3 == 2) {
            b.mN("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((p.b) ((u) kVar).htt.zg()).sZP.tuo);
            intent.putExtra("regsetinfo_user", this.uXt);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((u) kVar).FB());
            intent.putExtra("regsetinfo_pwd", this.uXv);
            intent.putExtra("regsetinfo_bind_email", this.uXt);
            startActivity(intent);
        } else if (i3 == 1) {
            b.mO(ap.uY() + "," + getClass().getName() + ",R22_resend_email_code_alert," + ap.ec("R22_resend_email_code_alert") + ",3");
            g.bl(this, getString(R.l.eJp));
        } else {
            w.e("MicroMsg.EmailVerifyUI", "err opcode");
        }
    }
}
