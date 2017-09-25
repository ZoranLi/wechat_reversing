package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.r;

public class MMDatePickerView extends LinearLayout implements OnClickListener {
    private MMSpinnerDatePicker kDs;
    private Button wvk;
    private Button wvl;
    private Button wvm;

    public MMDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MMDatePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = r.eC(context).inflate(h.hef, this);
        this.wvk = (Button) inflate.findViewById(g.cTq);
        this.wvl = (Button) inflate.findViewById(g.clc);
        this.wvm = (Button) inflate.findViewById(g.bHM);
        this.kDs = (MMSpinnerDatePicker) inflate.findViewById(g.hcF);
        this.wvk.setOnClickListener(this);
        this.wvl.setOnClickListener(this);
        this.wvm.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == g.cTq) {
            this.kDs.Cr(0);
        } else if (id == g.clc) {
            this.kDs.Cr(1);
        } else {
            this.kDs.Cr(2);
        }
    }
}
