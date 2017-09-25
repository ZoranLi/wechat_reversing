package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;

public class LoaddingView extends LinearLayout implements c {
    private TextView ncN;
    private ProgressBar ncO;
    private Animation ncP;
    private View ncQ;
    private boolean ncR = false;
    private String ncS = "";

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.ncP = AnimationUtils.loadAnimation(context, R.a.aRT);
        View inflate = LayoutInflater.from(context).inflate(R.i.dgS, this, true);
        this.ncO = (ProgressBar) inflate.findViewById(R.h.cch);
        this.ncN = (TextView) inflate.findViewById(R.h.ccr);
        this.ncQ = inflate.findViewById(R.h.cbZ);
        this.ncN.setText("");
        this.ncN.setVisibility(0);
        this.ncO.setVisibility(0);
    }

    public final void setText(String str) {
        if (this.ncN != null && this.ncO != null && !this.ncR) {
            if (bg.mA(str)) {
                this.ncN.setText("");
                this.ncN.setVisibility(0);
                this.ncO.setVisibility(0);
                return;
            }
            this.ncN.setText(str);
            this.ncO.setVisibility(8);
            this.ncN.setVisibility(0);
        }
    }

    public final String aGw() {
        return this.ncS;
    }
}
