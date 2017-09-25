package com.tencent.mm.wallet_core.ui.formview;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.f;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

final class b {
    public static int nOL = 0;
    public static int nOM = 0;
    public static final int wFV = R.h.cQq;

    static void a(TenpaySecureEditText tenpaySecureEditText, int i) {
        if (tenpaySecureEditText == null) {
            w.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
        } else if (i == 1) {
            tenpaySecureEditText.setIsPasswordFormat(true);
        } else if (i == 2) {
            tenpaySecureEditText.setIsSecurityAnswerFormat(true);
        } else if (i == 3) {
            tenpaySecureEditText.setIsCvvPaymentFormat(true);
        } else if (i == 4) {
            tenpaySecureEditText.setIsCvv4PaymentFormat(true);
        } else if (i == 5) {
            tenpaySecureEditText.setIsValidThru(true);
        } else if (i == 6) {
            tenpaySecureEditText.setIsBankcardFormat(true);
        } else if (i == 7) {
            tenpaySecureEditText.setIsMoneyAmountFormat(true);
        } else {
            tenpaySecureEditText.setIsCvv4PaymentFormat(false);
        }
    }

    public static void f(final MMActivity mMActivity, final WalletFormView walletFormView) {
        walletFormView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(System.currentTimeMillis());
                instance.add(2, 1);
                b.nOL = instance.get(1);
                b.nOM = instance.get(2);
                DatePickerDialog datePickerDialog = (DatePickerDialog) walletFormView.getTag(b.wFV);
                if (datePickerDialog == null) {
                    datePickerDialog = new f(mMActivity, new OnDateSetListener(this) {
                        final /* synthetic */ AnonymousClass1 wFW;

                        {
                            this.wFW = r1;
                        }

                        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            if (i >= b.nOL || i2 >= b.nOM) {
                                DecimalFormat decimalFormat = new DecimalFormat("00");
                                if (m.xY()) {
                                    walletFormView.setTag(decimalFormat.format((long) (i2 + 1)) + i);
                                } else {
                                    walletFormView.setTag(decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1)));
                                }
                                walletFormView.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
                            } else {
                                g.b(mMActivity, mMActivity.getString(R.l.ffA), null, true);
                            }
                            if (walletFormView.wFY != null) {
                                walletFormView.wFY.gA(walletFormView.Pb());
                            }
                        }
                    }, b.nOL, b.nOM, instance.get(5), instance.getTimeInMillis(), 2);
                    walletFormView.setTag(b.wFV, datePickerDialog);
                    mMActivity.a(datePickerDialog);
                }
                datePickerDialog.show();
            }
        });
    }

    public static void a(MMActivity mMActivity, int i, int i2) {
        if (i != -1) {
            mMActivity.a(com.tencent.mm.wallet_core.ui.b.a(mMActivity, i, mMActivity.getResources().getString(i2), mMActivity.getResources().getString(R.l.eOW), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }));
        }
    }
}
