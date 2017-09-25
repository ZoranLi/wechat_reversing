package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;

public class LoginPasswordUI extends LoginHistoryUI {
    private static String TAG = "LoginPasswordUI";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.uYx) {
            this.iQX = 2;
            this.uYv.setVisibility(0);
            this.uYf.setVisibility(0);
            this.ljL.setTypeface(Typeface.DEFAULT);
            this.ljL.setTransformationMethod(new PasswordTransformationMethod());
            this.ljL.setOnEditorActionListener(new OnEditorActionListener(this) {
                final /* synthetic */ LoginPasswordUI uYR;

                {
                    this.uYR = r1;
                }

                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 6 && i != 5) {
                        return false;
                    }
                    this.uYR.Tq();
                    return true;
                }
            });
            this.ljL.setOnKeyListener(new OnKeyListener(this) {
                final /* synthetic */ LoginPasswordUI uYR;

                {
                    this.uYR = r1;
                }

                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (66 != i || keyEvent.getAction() != 0) {
                        return false;
                    }
                    this.uYR.Tq();
                    return true;
                }
            });
            this.ljL.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ LoginPasswordUI uYR;

                {
                    this.uYR = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    if (this.uYR.ljL.getText().toString().length() > 0) {
                        this.uYR.uYf.setEnabled(true);
                    } else {
                        this.uYR.uYf.setEnabled(false);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.ljL.getText().toString().length() > 0) {
                this.uYf.setEnabled(true);
            } else {
                this.uYf.setEnabled(false);
            }
            this.uYf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginPasswordUI uYR;

                {
                    this.uYR = r1;
                }

                public final void onClick(View view) {
                    this.uYR.Tq();
                }
            });
            this.oVg = getIntent().getStringExtra("auth_ticket");
            if (!bg.mA(this.oVg)) {
                this.uYe.setText(bg.mz(f.bQQ()));
                this.ljL.setText(bg.mz(f.bQR()));
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ LoginPasswordUI uYR;

                    {
                        this.uYR = r1;
                    }

                    public final void run() {
                        this.uYR.Tq();
                    }
                }, 500);
            }
        }
    }

    protected final void Tq() {
        super.Tq();
        if (isFinishing() || getWindow() == null) {
            w.e(TAG, "LoginHistoryUI is finishing");
            return;
        }
        this.uYk.uYS = this.ljL.getText().toString();
        if (this.uYk.hSs.equals("")) {
            g.h(this, R.l.faa, R.l.ewN);
        } else if (this.uYk.uYS.equals("")) {
            g.h(this, R.l.eZX, R.l.ewN);
        } else {
            aHf();
            bQM();
            final k uVar = new u(this.uYk.hSs, this.uYk.uYS, this.oVg, 0);
            ap.vd().a(uVar, 0);
            getString(R.l.dIO);
            this.isv = g.a((Context) this, getString(R.l.ewX), true, new OnCancelListener(this) {
                final /* synthetic */ LoginPasswordUI uYR;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(uVar);
                    this.uYR.bQN();
                }
            });
        }
    }
}
