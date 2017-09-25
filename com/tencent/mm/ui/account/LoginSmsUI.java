package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class LoginSmsUI extends LoginHistoryUI {
    private static String TAG = "LoginSmsUI";

    static /* synthetic */ void a(LoginSmsUI loginSmsUI, String str) {
        if (!bg.mA(str)) {
            final k sVar = new s(str, 16, "", 0, "");
            ap.vd().a(sVar, 0);
            loginSmsUI.getString(R.l.dIO);
            loginSmsUI.isv = g.a((Context) loginSmsUI, loginSmsUI.getString(R.l.dJd), true, new OnCancelListener(loginSmsUI) {
                final /* synthetic */ LoginSmsUI uZb;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(sVar);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.uYx) {
            this.iQX = 3;
            if (!bg.Qh(this.uYr).booleanValue() && bg.Qh(this.uYm).booleanValue()) {
                this.uYe.setText(Di(this.uYm));
            }
            this.uYw.setVisibility(0);
            this.uYw.bRT();
            this.uYw.vjC = new OnClickListener(this) {
                final /* synthetic */ LoginSmsUI uZb;

                {
                    this.uZb = r1;
                }

                public final void onClick(View view) {
                    g.a(this.uZb, this.uZb.getString(R.l.eJV) + this.uZb.uYm, this.uZb.getString(R.l.eJW), this.uZb.getString(R.l.dHT), this.uZb.getString(R.l.dGs), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 uZc;

                        {
                            this.uZc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.uZc.uZb.uYw.bRS();
                            LoginSmsUI.a(this.uZc.uZb, this.uZc.uZb.uYm);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 uZc;

                        {
                            this.uZc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.uZc.uZb.uYw.reset();
                        }
                    });
                }
            };
            MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.uYw;
            TextWatcher anonymousClass2 = new TextWatcher(this) {
                final /* synthetic */ LoginSmsUI uZb;

                {
                    this.uZb = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    if (this.uZb.uYw.getText().toString().length() > 0) {
                        this.uZb.uYf.setEnabled(true);
                    } else {
                        this.uZb.uYf.setEnabled(false);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            };
            if (mMFormVerifyCodeInputView.oBT != null) {
                mMFormVerifyCodeInputView.oBT.addTextChangedListener(anonymousClass2);
            } else {
                w.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", anonymousClass2, mMFormVerifyCodeInputView.oBT);
            }
            if (this.uYw.getText().toString().length() > 0) {
                this.uYf.setEnabled(true);
            } else {
                this.uYf.setEnabled(false);
            }
            this.uYf.setVisibility(0);
            this.uYf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginSmsUI uZb;

                {
                    this.uZb = r1;
                }

                public final void onClick(View view) {
                    this.uZb.Tq();
                }
            });
        }
    }

    protected final void Tq() {
        super.Tq();
        if (isFinishing() || getWindow() == null) {
            w.e(TAG, "LoginHistoryUI is finishing");
        } else if (!bg.mA(this.uYm)) {
            this.uYk.hSs = this.uYm;
            aHf();
            bQM();
            final k sVar = new s(this.uYm, 17, this.uYw.getText().toString().trim(), 0, "");
            ap.vd().a(sVar, 0);
            getString(R.l.dIO);
            this.isv = g.a((Context) this, getString(R.l.ewX), true, new OnCancelListener(this) {
                final /* synthetic */ LoginSmsUI uZb;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(sVar);
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        ap.vd().a((int) a.CTRL_INDEX, (e) this);
    }

    protected void onStop() {
        super.onStop();
        ap.vd().b((int) a.CTRL_INDEX, (e) this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.uYw.reset();
    }
}
