package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.bb;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.widget.d;

public class ProfileDescribeView extends ProfileItemView {
    public TextView sJE;
    public TextView sJF;

    public ProfileDescribeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aTQ() {
        return R.i.dlm;
    }

    public final void init() {
        this.sJE = (TextView) findViewById(R.h.bFc);
        this.sJF = (TextView) findViewById(R.h.bFd);
        setClickable(true);
    }

    public final boolean aTR() {
        if (this.sJF != null) {
            LayoutParams layoutParams = this.sJF.getLayoutParams();
            layoutParams.width = a.T(getContext(), R.f.aXk);
            this.sJF.setLayoutParams(layoutParams);
        }
        if (this.kWy == null) {
            setVisibility(8);
            return false;
        }
        String str = this.kWy.gkK;
        if (bg.mA(this.kWy.gkL)) {
            boolean z = false;
        } else {
            int i = 1;
        }
        if (!com.tencent.mm.j.a.ez(this.kWy.field_type)) {
            bb AI;
            String str2 = this.kWy.field_encryptUsername;
            if (bg.mA(str2)) {
                ap.yY();
                AI = c.wS().AI(this.kWy.field_username);
            } else {
                ap.yY();
                AI = c.wS().AI(str2);
            }
            if (AI == null || bg.mA(AI.field_conDescription)) {
                setVisibility(8);
                return false;
            }
            this.sJE.setText(h.b(getContext(), bg.mz(AI.field_conDescription), this.sJE.getTextSize()));
            return true;
        } else if (!bg.mA(str) && r0 != 0) {
            r0 = getContext().getResources().getDrawable(R.k.dvu);
            r0.setBounds(0, 0, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            d dVar = new d(r0);
            dVar.wuA = (int) ((((float) r0.getIntrinsicHeight()) - this.sJE.getTextSize()) / 2.0f);
            r0 = new SpannableString("  " + str);
            r0.setSpan(dVar, 0, 1, 33);
            this.sJE.setText(h.b(getContext(), r0, this.sJE.getTextSize()));
            return true;
        } else if (!bg.mA(str) && r0 == 0) {
            this.sJE.setText(h.b(getContext(), bg.mz(str), this.sJE.getTextSize()));
            return true;
        } else if (bg.mA(str) && r0 != 0) {
            r0 = getContext().getResources().getDrawable(R.k.dvu);
            r0.setBounds(0, 0, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            d dVar2 = new d(r0);
            dVar2.wuA = (int) ((((float) r0.getIntrinsicHeight()) - this.sJE.getTextSize()) / 2.0f);
            r0 = new SpannableString("  " + getContext().getString(R.l.dZq));
            r0.setSpan(dVar2, 0, 1, 33);
            this.sJE.setText(h.b(getContext(), r0, this.sJE.getTextSize()));
            return true;
        } else if (bg.mA(str) && r0 == 0) {
            setVisibility(8);
            return false;
        } else {
            setVisibility(8);
            return false;
        }
    }
}
