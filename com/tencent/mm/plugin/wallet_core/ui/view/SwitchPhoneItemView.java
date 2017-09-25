package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class SwitchPhoneItemView extends RelativeLayout {
    private TextView rPb;
    private TextView rPc;
    ImageView rPd;

    public SwitchPhoneItemView(Context context) {
        super(context);
        bV(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bV(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bV(context);
    }

    private void bV(Context context) {
        View inflate = inflate(context, R.i.drt, this);
        this.rPb = (TextView) inflate.findViewById(R.h.cry);
        this.rPc = (TextView) inflate.findViewById(R.h.crt);
        this.rPd = (ImageView) inflate.findViewById(R.h.crs);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        if (bg.J(charSequence)) {
            this.rPb.setVisibility(8);
        } else {
            if (charSequence.toString().startsWith("86")) {
                w.i("SwitchPhoneItemView", "cut 86 prefix");
                charSequence = charSequence.subSequence(2, charSequence.length());
            }
            this.rPb.setText(charSequence);
        }
        if (bg.J(charSequence2)) {
            this.rPc.setVisibility(8);
            return;
        }
        this.rPc.setMaxLines(2);
        this.rPc.setSelected(true);
        this.rPc.setEllipsize(TruncateAt.MIDDLE);
        this.rPc.setText(charSequence2);
        this.rPc.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
