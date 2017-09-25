package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.f.a.l;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public abstract class WalletBaseUI extends MMActivity implements c {
    private static g wFt = null;
    public MyKeyboardWindow mKeyboard;
    public View npM;
    public a npY;
    public Bundle uT = new Bundle();
    private OnMenuItemClickListener vKJ;
    private b wFq = null;
    public f wFr = null;
    private d wFs = null;
    private OnMenuItemClickListener wFu;
    public boolean wFv = false;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public final String bsF() {
        if (this.uT == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.fJH;
        }
        return "";
    }

    public void aHT() {
        w.d("MicroMsg.WalletBaseUI", "cancelforceScene");
        this.wFr.aHT();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ap.zb()) {
            w.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
            com.tencent.mm.ui.base.g.a(this, getString(R.l.fcY), "", false, new OnClickListener(this) {
                final /* synthetic */ WalletBaseUI wFw;

                {
                    this.wFw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.c(this.wFw, null, -10000);
                }
            });
        }
        this.wFr = new f(this, this);
        this.wFr.hn(385);
        this.wFr.hn(1518);
        w.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
        b ai = a.ai(this);
        if (ai != null) {
            this.wFr.gWO = ai.avB();
        }
        w.d("MicroMsg.WalletBaseUI", "proc " + ai);
        this.uT = a.ah(this);
        if (this.uT == null) {
            this.uT = new Bundle();
        }
        this.wFr.uT = this.uT;
        if (aJc() && !a.ag((Activity) this)) {
            w.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            String str = "";
            if (!bg.mA(str)) {
                SE(str);
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletBaseUI wFw;

            {
                this.wFw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.wFw.bsP()) {
                    this.wFw.aHf();
                    this.wFw.showDialog(1000);
                } else {
                    this.wFw.finish();
                }
                return true;
            }
        });
        this.wFs = ccF();
        if (this.wFs != null && this.wFs.o(new Object[0])) {
            re(4);
        } else if (getLayoutId() <= 0) {
            re(4);
        } else if (aIY()) {
            re(4);
        } else {
            re(0);
        }
    }

    public final int ccA() {
        return this.uSU.ipu.getVisibility();
    }

    public final void b(OnMenuItemClickListener onMenuItemClickListener) {
        this.vKJ = onMenuItemClickListener;
        super.b(onMenuItemClickListener);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.wFu = onMenuItemClickListener;
        super.a(i, str, onMenuItemClickListener);
    }

    public void onResume() {
        super.onResume();
        if (m.cca()) {
            k bVar;
            if (com.tencent.mm.u.m.xY()) {
                bVar = new com.tencent.mm.wallet_core.e.a.b();
            } else {
                bVar = new l();
            }
            this.wFr.a(bVar, false);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.wFr.ho(385);
        this.wFr.ho(1518);
    }

    public void b(int i, int i2, String str, k kVar, boolean z) {
        w.d("MicroMsg.WalletBaseUI", "errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(m.ccb());
        if (kVar instanceof g) {
            g gVar = (g) kVar;
            wFt = gVar;
            if (this.uT != null) {
                if (gVar.rED > 0) {
                    this.uT.putInt("key_is_gen_cert", gVar.rED);
                }
                if (gVar.rEF > 0) {
                    this.uT.putInt("key_is_hint_crt", gVar.rEF);
                }
                if (gVar.rEH > 0) {
                    this.uT.putInt("key_is_ignore_cert", gVar.rEH);
                }
                if (!bg.mA(gVar.rEE)) {
                    this.uT.putString("key_crt_token", gVar.rEE);
                }
                if (!bg.mA(gVar.rEG)) {
                    this.uT.putString("key_crt_wording", gVar.rEG);
                }
            }
        }
        i(i, i2, str, kVar);
        f.a(this, i, i2, str, kVar, z);
    }

    public void qU(int i) {
    }

    public boolean i(int i, int i2, String str, k kVar) {
        return true;
    }

    public boolean aJc() {
        return true;
    }

    public boolean aJb() {
        return false;
    }

    public boolean aIY() {
        if (getLayoutId() > 0 && !this.wFr.aHU()) {
            return false;
        }
        return true;
    }

    public boolean bsP() {
        return false;
    }

    public final void ccB() {
        PayInfo payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
        if (payInfo == null) {
            payInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        if (payInfo != null && !bg.mA(payInfo.mry)) {
            this.wFr.a(new com.tencent.mm.wallet_core.c.d(payInfo.mry, payInfo.fJH), true, true);
            payInfo.mry = null;
        }
    }

    public boolean Op() {
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.npM != null && this.npM.isShown()) {
                Om();
                return true;
            } else if (bsP()) {
                aHf();
                showDialog(1000);
                return true;
            } else if (this.vKJ != null && Op()) {
                this.vKJ.onMenuItemClick(null);
                return true;
            } else if (this.wFu != null) {
                this.wFu.onMenuItemClick(null);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final boolean byk() {
        if (this.vKJ != null) {
            this.vKJ.onMenuItemClick(null);
            return true;
        } else if (this.wFu == null) {
            return super.byk();
        } else {
            this.wFu.onMenuItemClick(null);
            return true;
        }
    }

    public Dialog onCreateDialog(int i) {
        w.i("MicroMsg.WalletBaseUI", "onCreateDialog id = " + i);
        switch (i) {
            case 1000:
                int b;
                b ai = a.ai(this);
                if (ai != null) {
                    b = ai.b(this, 1);
                } else {
                    b = -1;
                }
                if (b != -1) {
                    return com.tencent.mm.ui.base.g.a(this, true, getString(b), "", getString(R.l.dJe), getString(R.l.dHQ), new OnClickListener(this) {
                        final /* synthetic */ WalletBaseUI wFw;

                        {
                            this.wFw = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.wFw.ccB();
                            b ai = a.ai(this.wFw);
                            if (ai == null) {
                                this.wFw.finish();
                            } else if (!ai.i(this.wFw, this.wFw.uT)) {
                                ai.d(this.wFw, this.wFw.uT);
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletBaseUI wFw;

                        {
                            this.wFw = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            View findFocus = this.wFw.uSU.ipu == null ? null : this.wFw.uSU.ipu.findFocus();
                            if (findFocus != null && (findFocus instanceof EditText)) {
                                this.wFw.aHj();
                            }
                        }
                    });
                }
                if (ai != null) {
                    ai.d(this, this.uT);
                } else {
                    finish();
                }
                return super.onCreateDialog(i);
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void d(View view, int i, boolean z) {
        a(view, i, z, true);
    }

    @TargetApi(14)
    public void a(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.h.cHC);
        this.npM = findViewById(R.h.cHB);
        View findViewById = findViewById(R.h.bkI);
        final EditText editText = (EditText) view.findViewById(R.h.cQh);
        if (this.mKeyboard != null && editText != null && this.npM != null) {
            e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ WalletBaseUI wFw;

                public final void onFocusChange(final View view, boolean z) {
                    if (!view.isFocused() || z3) {
                        new ae().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 wFx;

                            {
                                this.wFx = r1;
                            }

                            public final void run() {
                                this.wFx.wFw.Om();
                                ((InputMethodManager) this.wFx.wFw.uSU.uTo.getSystemService("input_method")).showSoftInput(editText, 0);
                            }
                        }, 200);
                        return;
                    }
                    ((InputMethodManager) this.wFw.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 wFx;

                        public final void run() {
                            if (!this.wFx.wFw.npM.isShown() && view.isShown() && (z4 || this.wFx.wFw.wFv)) {
                                this.wFx.wFw.wFv = true;
                                this.wFx.wFw.ccD();
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((com.tencent.mm.u.m.xY() || walletFormView.wGc == 100) && (!com.tencent.mm.u.m.xY() || walletFormView.wGc == 0)) {
                                    this.wFx.wFw.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    AccessibilityDelegate cVar = new com.tencent.mm.ui.a.c();
                                    this.wFx.wFw.mKeyboard.setSecureAccessibility(cVar);
                                    editText.setAccessibilityDelegate(cVar);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                cVar = new com.tencent.mm.ui.a.c();
                                this.wFx.wFw.mKeyboard.setSecureAccessibility(cVar);
                                editText.setAccessibilityDelegate(cVar);
                            }
                            this.wFx.wFw.CJ(i2);
                            this.wFx.wFw.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) this.wFx.wFw.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }, 300);
                }
            });
            editText.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletBaseUI wFw;

                public final void onClick(View view) {
                    if (!this.wFw.npM.isShown() && !z) {
                        this.wFw.ccD();
                        this.wFw.CJ(i);
                    } else if (z) {
                        this.wFw.Om();
                        ((InputMethodManager) this.wFw.uSU.uTo.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletBaseUI wFw;

                {
                    this.wFw = r1;
                }

                public final void onClick(View view) {
                    this.wFw.Om();
                }
            });
        }
    }

    public final boolean lX(boolean z) {
        if (wFt == null || (!wFt.aQi() && !z)) {
            return false;
        }
        this.wFr.a(wFt, true);
        return true;
    }

    public static void ccC() {
        f.ccC();
    }

    public void Om() {
        if (this.npM.isShown()) {
            this.npM.setVisibility(8);
            if (this.npY != null) {
                this.npY.gC(false);
            }
        }
    }

    public final void ccD() {
        if (!this.npM.isShown()) {
            this.npM.setVisibility(0);
            if (this.npY != null) {
                this.npY.gC(true);
            }
        }
    }

    public final void CJ(int i) {
        this.mKeyboard.setXMode(i);
    }

    public final b ccE() {
        if (this.wFq == null) {
            this.wFq = a.ai(this);
        }
        return this.wFq;
    }

    public final d ccF() {
        if (this.wFs == null) {
            b ccE = ccE();
            if (ccE != null) {
                this.wFs = ccE.a(this, this.wFr);
            }
            if (this.wFs == null) {
                this.wFs = new d(this, this, this.wFr) {
                    final /* synthetic */ WalletBaseUI wFw;

                    public final boolean d(int i, int i2, String str, k kVar) {
                        return false;
                    }

                    public final boolean j(Object... objArr) {
                        return false;
                    }
                };
            }
        }
        return this.wFs;
    }

    public final CharSequence qK(int i) {
        if (this.wFs == null) {
            return null;
        }
        return this.wFs.qK(i);
    }

    public void bsp() {
        ccE().a((Activity) this, 0, this.uT);
    }

    public final void hn(int i) {
        this.wFr.hn(i);
    }

    public final void ho(int i) {
        this.wFr.ho(i);
    }

    public final void b(k kVar, boolean z) {
        ccG();
        this.wFr.a(kVar, z, true);
    }

    public final void k(k kVar) {
        ccG();
        this.wFr.a(kVar, true, true);
    }

    public final void q(k kVar) {
        ccG();
        this.wFr.a(kVar, true);
    }

    public void ccG() {
        b ccE = ccE();
        if (ccE != null) {
            this.wFr.uT = ccE.lHw;
        }
    }

    public void re(int i) {
        super.re(i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i == -1) {
                w.i("MicroMsg.WalletBaseUI", "process end ok!");
                setResult(-1, getIntent());
            } else {
                w.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : " + i);
                setResult(0, getIntent());
            }
            finish();
        }
    }
}
