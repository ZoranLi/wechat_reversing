package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ae;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView extends TextView {
    private int RQ;
    private ae mHandler = new ae(this) {
        final /* synthetic */ IPCallDynamicTextView mUk;

        {
            this.mUk = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if ((this.mUk.mUb <= 0.0d || this.mUk.mUc >= this.mUk.mUd) && (this.mUk.mUb >= 0.0d || this.mUk.mUc <= this.mUk.mUd)) {
                        this.mUk.mUe = false;
                        IPCallDynamicTextView.a(this.mUk, this.mUk.mUd);
                        return;
                    }
                    this.mUk.mUe = true;
                    IPCallDynamicTextView.a(this.mUk, this.mUk.mUc);
                    this.mUk.mUc = this.mUk.mUc + this.mUk.mUb;
                    this.mUk.mHandler.sendEmptyMessageDelayed(1, (long) this.mUk.mUg);
                    return;
                default:
                    return;
            }
        }
    };
    private double mUb;
    private double mUc;
    private double mUd;
    private boolean mUe;
    private int mUf = 4000;
    private int mUg = 50;
    DecimalFormat mUh = new DecimalFormat("0.00");
    private String mUi = "";
    private String mUj = "";
    private String mValue;

    static /* synthetic */ void a(IPCallDynamicTextView iPCallDynamicTextView, double d) {
        if (d == iPCallDynamicTextView.mUd) {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.mValue);
        } else {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.mUi + iPCallDynamicTextView.mUh.format(d) + iPCallDynamicTextView.mUj);
        }
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ IPCallDynamicTextView mUk;

            {
                this.mUk = r1;
            }

            public final void onGlobalLayout() {
                if (this.mUk.mUc != this.mUk.mUd) {
                    this.mUk.mHandler.sendEmptyMessage(1);
                }
            }
        });
    }

    public final void cA(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            setText(str2);
            return;
        }
        try {
            this.mUc = Double.parseDouble(yI(str));
            this.mUi = "";
            int i = 0;
            while (i < str2.length() && !Character.isDigit(str2.charAt(i))) {
                this.mUi += str2.charAt(i);
                i++;
            }
            this.mUj = "";
            i = str2.length() - 1;
            while (i > 0 && !Character.isDigit(str2.charAt(i))) {
                this.mUj += str2.charAt(i);
                i--;
            }
            try {
                this.mUd = Double.parseDouble(str2.substring(this.mUi.length(), str2.length() - this.mUj.length()));
                this.mValue = str2;
                this.mUb = (this.mUd - this.mUc) / ((double) (this.mUf / this.mUg));
                if (this.mUb == 0.0d) {
                    setText(str2);
                    return;
                }
                this.mUb = new BigDecimal(this.mUb).setScale(2, 4).doubleValue();
                if (isShown()) {
                    this.mHandler.sendEmptyMessage(1);
                }
            } catch (NumberFormatException e) {
                setText(str2);
            }
        } catch (NumberFormatException e2) {
            setText(str2);
        }
    }

    public static String yI(String str) {
        String str2 = "";
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            str2 = str2 + str.charAt(i);
            i++;
        }
        String str3 = "";
        i = str.length() - 1;
        while (i > 0 && !Character.isDigit(str.charAt(i))) {
            str3 = str3 + str.charAt(i);
            i--;
        }
        return str.substring(str2.length(), str.length() - str3.length());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.RQ = getMeasuredHeight();
    }
}
