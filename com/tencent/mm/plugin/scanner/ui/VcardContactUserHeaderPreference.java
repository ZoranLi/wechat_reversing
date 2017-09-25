package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference extends Preference {
    String aIO;
    private final Context context;
    private TextView mDM;
    String oWW;
    private ImageView pcM;
    private TextView pcN;
    private TextView pcO;
    private TextView pcP;
    String pcQ;
    String title;

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        w.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.pcM = (ImageView) view.findViewById(R.h.cLp);
        this.mDM = (TextView) view.findViewById(R.h.cLq);
        if (this.pcQ != null) {
            this.mDM.setText(this.pcQ);
        }
        this.pcN = (TextView) view.findViewById(R.h.cLr);
        if (this.aIO != null) {
            this.pcN.setText(this.context.getString(R.l.eZG, new Object[]{this.aIO}));
            this.pcN.setVisibility(0);
        }
        this.pcO = (TextView) view.findViewById(R.h.cLs);
        if (this.oWW != null) {
            this.pcO.setText(this.context.getString(R.l.eZI, new Object[]{this.oWW}));
            this.pcO.setVisibility(0);
        }
        this.pcP = (TextView) view.findViewById(R.h.cLt);
        if (this.title != null) {
            this.pcP.setText(this.context.getString(R.l.eZJ, new Object[]{this.title}));
            this.pcP.setVisibility(0);
        }
    }
}
