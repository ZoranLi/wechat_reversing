package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView extends LinearLayout implements OnClickListener {
    private CollectRadioBtnView kDp;
    private CollectRadioBtnView kDq;
    private CollectRadioBtnView kDr;
    MMSpinnerDatePicker kDs;
    TextView kDt;
    TextView kDu;
    int kDv = 0;

    public DatePickerDialogView(Context context) {
        super(context);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = r.eC(context).inflate(R.i.cYX, this);
        this.kDp = (CollectRadioBtnView) inflate.findViewById(R.h.cTq);
        this.kDq = (CollectRadioBtnView) inflate.findViewById(R.h.clc);
        this.kDr = (CollectRadioBtnView) inflate.findViewById(R.h.bHM);
        this.kDt = (TextView) inflate.findViewById(R.h.bEu);
        this.kDu = (TextView) inflate.findViewById(R.h.bvK);
        this.kDp.setOnClickListener(this);
        this.kDq.setOnClickListener(this);
        this.kDr.setOnClickListener(this);
        this.kDp.tC("年");
        this.kDq.tC("月");
        this.kDr.tC("日");
        this.kDs = (MMSpinnerDatePicker) inflate.findViewById(R.h.bHL);
        this.kDs.Cs(R.e.transparent);
        MMSpinnerDatePicker mMSpinnerDatePicker = this.kDs;
        int i = R.f.aXI;
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.wwh, i);
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.wwi, i);
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.wwj, i);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.h.cTq) {
            this.kDv = 2;
        } else if (id == R.h.clc) {
            this.kDv = 1;
        } else if (id == R.h.bHM) {
            this.kDv = 0;
        } else {
            w.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[]{view.getClass().toString()});
        }
        akG();
    }

    final void akG() {
        if (this.kDv == 2) {
            this.kDp.kY(R.k.dze);
            this.kDq.kY(R.k.dzd);
            this.kDr.kY(R.k.dzd);
        } else if (this.kDv == 1) {
            this.kDp.kY(R.k.dzd);
            this.kDq.kY(R.k.dze);
            this.kDr.kY(R.k.dzd);
        } else {
            this.kDp.kY(R.k.dzd);
            this.kDq.kY(R.k.dzd);
            this.kDr.kY(R.k.dze);
        }
        this.kDs.Cr(this.kDv);
    }
}
