package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.k;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI extends WalletBaseUI {
    private Button rKT;
    private TenpaySegmentEditText rKU;
    private boolean rKV = true;

    protected final int getLayoutId() {
        return R.i.dqv;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletConfirmCardIDUI rKW;

            {
                this.rKW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                n.ccf();
                this.rKW.finish();
                return false;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        Object string = this.uT.getString("key_bankcard_id");
        String string2 = this.uT.getString("key_bankcard_des");
        Bitmap bitmap = (Bitmap) this.uT.getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            w.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
        } else if (bitmap == null) {
            w.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
        } else {
            zi(R.l.ffg);
            this.rKT = (Button) findViewById(R.h.cnY);
            this.rKU = (TenpaySegmentEditText) findViewById(R.h.bKI);
            this.rKU.setText(string, string2);
            this.mKeyboard = (MyKeyboardWindow) findViewById(R.h.cHC);
            this.npM = findViewById(R.h.cHB);
            ((ImageView) findViewById(R.h.bxs)).setImageBitmap(bitmap);
            this.rKU.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) this.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(this.rKU.getWindowToken(), 0);
            this.npM.setVisibility(8);
            this.rKU.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletConfirmCardIDUI rKW;

                {
                    this.rKW = r1;
                }

                public final void onClick(View view) {
                    if (!(this.rKW.npM.isShown() || this.rKW.rKV)) {
                        this.rKW.npM.setVisibility(0);
                        this.rKW.mKeyboard.setVisibility(0);
                    }
                    this.rKW.rKV = false;
                }
            });
            final String str = this.rKU.get3DesEncrptData();
            this.rKT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletConfirmCardIDUI rKW;

                public final void onClick(View view) {
                    String str = this.rKW.rKU.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        g.oUh.i(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(2)});
                    } else {
                        g.oUh.i(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                    }
                    this.rKW.k(new k(this.rKW.bsF(), this.rKW.rKU.getEncryptDataWithHash(false), (PayInfo) this.rKW.uT.getParcelable("key_pay_info"), this.rKW.uT.getInt("entry_scene", -1)));
                }
            });
            this.mKeyboard = (MyKeyboardWindow) findViewById(R.h.cHC);
            this.npM = findViewById(R.h.cHB);
            View findViewById = findViewById(R.h.bkI);
            if (!(this.mKeyboard == null || this.npM == null)) {
                findViewById.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletConfirmCardIDUI rKW;

                    {
                        this.rKW = r1;
                    }

                    public final void onClick(View view) {
                        this.rKW.Om();
                    }
                });
            }
            this.rKU.setFocusable(false);
            this.rKU.setFocusableInTouchMode(true);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof k) {
                k kVar2 = (k) kVar;
                bundle.putBoolean("key_need_area", kVar2.btu());
                bundle.putBoolean("key_need_profession", kVar2.btv());
                bundle.putParcelableArray("key_profession_list", kVar2.rCb);
                if (kVar2.rBW == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.rKU.getEncryptDataWithHash(false));
                    a.k(this, bundle);
                } else if (kVar2.rBW.rEQ && kVar2.rBW.isError()) {
                    com.tencent.mm.ui.base.g.h(this, R.l.fdN, R.l.dIO);
                    return true;
                } else {
                    bundle.putString("bank_name", kVar2.rBW.mMa);
                    bundle.putParcelable("elemt_query", kVar2.rBW);
                    bundle.putString("key_card_id", this.rKU.getEncryptDataWithHash(false));
                    a.k(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof k)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.rKU.getEncryptDataWithHash(false));
            a.k(this, bundle);
            return true;
        }
        return false;
    }
}
