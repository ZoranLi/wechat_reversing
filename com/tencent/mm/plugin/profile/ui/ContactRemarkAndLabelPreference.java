package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference extends Preference {
    private TextView jhl;
    private String lAm;
    private Context mContext;
    private TextView otB;
    private TextView otC;
    private boolean otD = false;
    private String otE;
    private String otF;

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diT, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        int i;
        this.jhl = (TextView) view.findViewById(R.h.title);
        this.otB = (TextView) view.findViewById(R.h.cxM);
        this.otC = (TextView) view.findViewById(R.h.label);
        if (!(this.jhl == null || bg.mA(this.lAm))) {
            this.jhl.setVisibility(0);
            this.jhl.setText(this.lAm);
            LayoutParams layoutParams = (LayoutParams) this.jhl.getLayoutParams();
            layoutParams.width = a.T(this.mContext, R.f.aXk);
            this.jhl.setLayoutParams(layoutParams);
        }
        if (this.otB != null) {
            if (this.otD) {
                this.otB.setVisibility(0);
                this.otB.setCompoundDrawablesWithIntrinsicBounds(R.k.dvu, 0, 0, 0);
                i = 1;
            } else {
                this.otB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                i = 0;
            }
            if (!bg.mA(this.otE)) {
                this.otB.setVisibility(0);
                this.otB.setText(h.b(this.mContext, bg.mz(this.otE), this.otB.getTextSize()));
                i = 1;
            }
        } else {
            i = 0;
        }
        if (!(this.otC == null || bg.mA(this.otF))) {
            i |= 2;
            this.otC.setVisibility(0);
            this.otC.setText(this.otF);
        }
        int i2 = i;
        if (i2 == 1) {
            ((LayoutParams) this.otB.getLayoutParams()).addRule(15);
        }
        if (i2 == 2) {
            layoutParams = (LayoutParams) this.otC.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.addRule(15);
        }
        super.onBindView(view);
    }
}
