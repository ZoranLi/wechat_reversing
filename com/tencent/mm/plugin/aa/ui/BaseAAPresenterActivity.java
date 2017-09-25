package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int ipO = a.fromDPToPix(ab.getContext(), e.CTRL_INDEX);
    private c gZG = new c();
    protected View ipN;

    static /* synthetic */ void a(BaseAAPresenterActivity baseAAPresenterActivity, EditText editText) {
        if (baseAAPresenterActivity.ipN != null) {
            int[] iArr = new int[2];
            editText.getLocationInWindow(iArr);
            int height = r1 - (iArr[1] + editText.getHeight());
            w.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + editText.getHeight()), Integer.valueOf(baseAAPresenterActivity.getWindow().getDecorView().getHeight() - baseAAPresenterActivity.cO().cP().getHeight()), Integer.valueOf(height), Integer.valueOf(ipO)});
            if (height > 0 && height < ipO) {
                w.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf((ipO - height) + a.fromDPToPix(baseAAPresenterActivity, 5))});
                baseAAPresenterActivity.ipN.scrollBy(0, r0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZG.C(getIntent(), this);
        this.wFv = true;
    }

    public void onResume() {
        super.onResume();
        this.gZG.CF(2);
    }

    public void onPause() {
        super.onPause();
        this.gZG.CF(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.gZG.onDestroy();
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T m(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.gZG.a(this, cls);
    }

    public final <T extends com.tencent.mm.vending.app.a> T p(Class<? extends com.tencent.mm.vending.app.a> cls) {
        return this.gZG.b(this, cls);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final void a(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.h.cHC);
        this.npM = findViewById(R.h.cHB);
        View findViewById = findViewById(R.h.bkI);
        final EditText editText = (EditText) view.findViewById(R.h.cQh);
        if (this.mKeyboard != null && editText != null && this.npM != null) {
            this.npM.setVisibility(8);
            com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ BaseAAPresenterActivity ipU;

                public final void onFocusChange(final View view, boolean z) {
                    if (!view.isFocused() || z3) {
                        new ae().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 ipV;

                            {
                                this.ipV = r1;
                            }

                            public final void run() {
                                this.ipV.ipU.Om();
                                ((InputMethodManager) this.ipV.ipU.uSU.uTo.getSystemService("input_method")).showSoftInput(editText, 0);
                            }
                        }, 200);
                        return;
                    }
                    ((InputMethodManager) this.ipU.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 ipV;

                        public final void run() {
                            if (!this.ipV.ipU.npM.isShown() && view.isShown()) {
                                if (z4) {
                                    this.ipV.ipU.ccD();
                                } else if (!this.ipV.ipU.wFv) {
                                    this.ipV.ipU.ccD();
                                }
                                this.ipV.ipU.wFv = false;
                                BaseAAPresenterActivity.a(this.ipV.ipU, editText);
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((m.xY() || walletFormView.wGc == 100) && (!m.xY() || walletFormView.wGc == 0)) {
                                    this.ipV.ipU.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    AccessibilityDelegate cVar = new com.tencent.mm.ui.a.c();
                                    this.ipV.ipU.mKeyboard.setSecureAccessibility(cVar);
                                    editText.setAccessibilityDelegate(cVar);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                cVar = new com.tencent.mm.ui.a.c();
                                this.ipV.ipU.mKeyboard.setSecureAccessibility(cVar);
                                editText.setAccessibilityDelegate(cVar);
                            }
                            this.ipV.ipU.CJ(i2);
                            this.ipV.ipU.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) this.ipV.ipU.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }, 300);
                }
            });
            editText.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BaseAAPresenterActivity ipU;

                public final void onClick(View view) {
                    if (!this.ipU.npM.isShown() && !z) {
                        this.ipU.ccD();
                        BaseAAPresenterActivity.a(this.ipU, editText);
                        this.ipU.CJ(i);
                    } else if (z) {
                        this.ipU.Om();
                        ((InputMethodManager) this.ipU.uSU.uTo.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                }
            });
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BaseAAPresenterActivity ipU;

                {
                    this.ipU = r1;
                }

                public final void onClick(View view) {
                    this.ipU.Om();
                }
            });
        }
    }

    protected final void Om() {
        super.Om();
        if (this.ipN != null) {
            this.ipN.scrollTo(0, 0);
        }
    }
}
