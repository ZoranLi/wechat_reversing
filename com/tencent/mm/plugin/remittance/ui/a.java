package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class a extends i implements OnClickListener {
    private int hPi;
    protected View khv;
    private OnClickListener oRO;

    private a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        super(context, R.m.foO);
        this.hPi = 0;
        int i = R.i.dmE;
        if (i > 0) {
            this.khv = View.inflate(context, i, null);
        }
        setContentView(this.khv);
        ((Button) this.khv.findViewById(R.h.bvK)).setOnClickListener(this);
        ((Button) this.khv.findViewById(R.h.bWB)).setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (view.getId() != R.h.cpm) {
            w.i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() != R.h.bvK) {
            return;
        }
        if (this.hPi == 1) {
            g.oUh.i(12689, new Object[]{Integer.valueOf(11), Integer.valueOf(1)});
            return;
        }
        g.oUh.i(12689, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
    }

    public static void a(Context context, int i, String str, double d) {
        w.i("RemittanceChargeDialog", "showAlert");
        Dialog aVar = new a(context);
        aVar.hPi = i;
        w.i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) aVar.findViewById(R.h.cya);
        if (bg.mA(str)) {
            w.e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) aVar.findViewById(R.h.bXF)).setText(context.getResources().getString(R.l.eLk, new Object[]{e.o(d)}));
        aVar.findViewById(R.h.cIB).setVisibility(0);
        aVar.findViewById(R.h.bXG).setVisibility(0);
        aVar.show();
        com.tencent.mm.ui.base.g.a(context, aVar);
    }

    public static a a(Context context, int i, double d, double d2, double d3, String str, OnClickListener onClickListener) {
        w.i("RemittanceChargeDialog", "showCostDetail");
        Dialog aVar = new a(context);
        aVar.hPi = i;
        if (d == 0.0d) {
            w.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) aVar.findViewById(R.h.cyu)).setText(e.o(d));
        ((TextView) aVar.findViewById(R.h.bMA)).setText(e.o(d2));
        if (d3 == 0.0d) {
            w.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) aVar.findViewById(R.h.cJE)).setText(e.o(d3));
        aVar.findViewById(R.h.cxP).setVisibility(0);
        if (!bg.mA(str)) {
            TextView textView = (TextView) aVar.findViewById(R.h.cya);
            textView.setText(str);
            textView.setVisibility(0);
        }
        aVar.findViewById(R.h.cIH).setVisibility(0);
        aVar.oRO = onClickListener;
        aVar.findViewById(R.h.cpm).setOnClickListener(new OnClickListener(aVar) {
            final /* synthetic */ a oRP;

            {
                this.oRP = r1;
            }

            public final void onClick(View view) {
                if (this.oRP.oRO != null) {
                    this.oRP.oRO.onClick(view);
                    this.oRP.dismiss();
                }
            }
        });
        aVar.show();
        com.tencent.mm.ui.base.g.a(context, aVar);
        if (i == 1) {
            g.oUh.i(12689, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
        } else {
            g.oUh.i(12689, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        }
        return aVar;
    }
}
