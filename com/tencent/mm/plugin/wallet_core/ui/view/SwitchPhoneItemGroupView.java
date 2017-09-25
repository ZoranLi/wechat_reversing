package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> rOX = new ArrayList();
    public a rOY;
    private OnClickListener rOZ = new OnClickListener(this) {
        final /* synthetic */ SwitchPhoneItemGroupView rPa;

        {
            this.rPa = r1;
        }

        public final void onClick(View view) {
            for (SwitchPhoneItemView switchPhoneItemView : this.rPa.rOX) {
                switchPhoneItemView.rPd.setImageResource(R.k.dzd);
            }
            ((SwitchPhoneItemView) view).rPd.setImageResource(R.k.dze);
            if (this.rPa.rOY != null) {
                this.rPa.rOY.cL(view);
            }
        }
    };

    public interface a {
        void cL(View view);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(SwitchPhoneItemView switchPhoneItemView, int i) {
        addView(switchPhoneItemView, i);
        this.rOX.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.rOZ);
    }
}
