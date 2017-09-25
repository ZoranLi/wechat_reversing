package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.i;

public final class b extends i {
    TextView itE = ((TextView) this.view.findViewById(R.h.btX));
    private Button jWt = ((Button) this.view.findViewById(R.h.btW));
    private View view;

    public b(Context context) {
        super(context, R.m.foP);
        this.view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.cVS, null);
        setContentView(this.view, new LayoutParams(-2, -2));
        this.jWt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b jWu;

            {
                this.jWu = r1;
            }

            public final void onClick(View view) {
                this.jWu.dismiss();
            }
        });
    }
}
