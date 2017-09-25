package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;

public class RegByMobileSetPwdUI extends SetPwdUI {
    private TextView pkN;
    private TextView qUS;
    private String sSn = null;
    private View vav;
    private TextView vaw;
    private boolean vax = false;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] uZE = new int[a.bRj().length];

        static {
            try {
                uZE[a.vbO - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                uZE[a.vbP - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                uZE[a.vbR - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                uZE[a.vbQ - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sSn = getIntent().getStringExtra("kintent_hint");
        this.ppy = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.vax = getIntent().getBooleanExtra("from_unbind", false);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dmz;
    }

    protected final void KC() {
        if (!this.ppy) {
            bPY();
        }
        zi(R.l.eJS);
        this.pkN = (TextView) findViewById(R.h.cLm);
        this.vav = findViewById(R.h.bmN);
        this.qUS = (TextView) findViewById(R.h.cxA);
        this.vaw = (TextView) findViewById(R.h.bmR);
        if (this.sSn != null && this.sSn.length() > 0) {
            this.qUS.setText(this.sSn);
        }
        if (this.vax || !h.vG().uV()) {
            this.vav.setVisibility(8);
        } else {
            this.vav.setVisibility(0);
            CharSequence xM = m.xM();
            if (bg.mA(xM)) {
                xM = m.xL();
                if (x.QQ(xM)) {
                    xM = null;
                }
            }
            if (bg.mA(xM)) {
                ap.yY();
                String str = (String) c.vr().get(6, null);
                ap.yY();
                String str2 = (String) c.vr().get(5, null);
                if (!bg.mA(str)) {
                    if (bg.Qh(str).booleanValue()) {
                        an anVar = new an();
                        str2 = "86";
                        if (str.startsWith("+")) {
                            str2 = str.replace("+", "");
                            str = an.yU(str2);
                            if (str != null) {
                                str2 = str2.substring(str.length());
                            }
                        } else {
                            String str3 = str2;
                            str2 = str;
                            str = str3;
                        }
                        xM = an.formatNumber(str, str2);
                        this.vaw.setText(R.l.eSS);
                        this.pkN.setText(xM);
                    }
                    this.qUS.setText(R.l.eJU);
                } else if (bg.mA(str2)) {
                    this.vav.setVisibility(8);
                } else {
                    this.pkN.setText(str2);
                    this.vaw.setText(R.l.eSr);
                    this.qUS.setText(R.l.eJT);
                }
            } else {
                this.vaw.setText(R.l.eUN);
                this.pkN.setText(xM);
            }
        }
        TextView textView = (TextView) findViewById(R.h.cqG);
        TextView textView2 = (TextView) findViewById(R.h.bEG);
        EditText editText = (EditText) findViewById(R.h.cxE);
        EditText editText2 = (EditText) findViewById(R.h.cxD);
        if (!v.bIJ()) {
            textView.setTextSize(1, 14.0f);
            textView2.setTextSize(1, 14.0f);
            editText.setTextSize(1, 14.0f);
            editText2.setTextSize(1, 14.0f);
        }
        float measureText = this.vaw.getPaint().measureText(this.vaw.getText().toString());
        float measureText2 = textView.getPaint().measureText(textView.getText().toString());
        float max = Math.max(Math.max(measureText, measureText2), textView2.getPaint().measureText(textView2.getText().toString()));
        this.vaw.setWidth((int) max);
        textView.setWidth((int) max);
        textView.setWidth((int) max);
    }

    protected final String bQT() {
        return ((EditText) findViewById(R.h.cxE)).getText().toString();
    }

    protected final String bQU() {
        return ((EditText) findViewById(R.h.cxD)).getText().toString();
    }

    protected final void zB(int i) {
        switch (AnonymousClass1.uZE[i - 1]) {
            case 1:
                g.h(this, R.l.eJN, R.l.eJP);
                return;
            case 2:
                g.h(this, R.l.eJO, R.l.eJP);
                return;
            case 3:
                g.h(this, R.l.eZW, R.l.eJP);
                return;
            case 4:
                g.h(this, R.l.eZY, R.l.eJP);
                return;
            default:
                return;
        }
    }

    protected final boolean s(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return p(i, i2, str);
        }
        finish();
        return true;
    }

    public final boolean bQY() {
        return true;
    }
}
