package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference extends Preference {
    public boolean fEq = false;
    public CharSequence iJF;
    private LinearLayout rBc;
    private TextView sST;
    public CharSequence sSU;

    public RoomCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomCardPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, R.i.djk, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.h.content).findViewById(R.h.cwd);
        if (this.rBc == null) {
            this.rBc = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.sST == null) {
            this.sST = (TextView) viewGroup.findViewById(R.h.cze);
        }
        if (this.fEq) {
            this.rBc.setVisibility(0);
            this.sST.setVisibility(0);
        } else {
            this.rBc.setVisibility(8);
            this.sST.setVisibility(8);
        }
        if (this.sSU != null) {
            this.sST.setText(this.sSU);
        }
    }
}
