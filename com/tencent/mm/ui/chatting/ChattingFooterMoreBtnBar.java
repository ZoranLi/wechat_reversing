package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;

public class ChattingFooterMoreBtnBar extends LinearLayout {
    private ImageButton lJH;
    private LayoutParams mBJ;
    private ImageButton vBQ;
    private ImageButton vBR;
    private ImageButton vBS;
    private ImageButton vBT;

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.g.bcX);
        this.mBJ = new LayoutParams(0, getResources().getDimensionPixelSize(R.f.aXQ), 1.0f);
        this.mBJ.topMargin = a.fromDPToPix(getContext(), 0);
        this.vBQ = new ImageButton(getContext());
        this.vBQ.setImageResource(R.g.bdP);
        this.vBQ.setScaleType(ScaleType.CENTER);
        this.vBQ.setBackgroundResource(0);
        this.vBQ.setContentDescription(context.getString(R.l.dUK));
        this.vBT = new ImageButton(getContext());
        this.vBT.setImageResource(R.g.bdN);
        this.vBT.setScaleType(ScaleType.CENTER);
        this.vBT.setBackgroundResource(0);
        this.vBT.setContentDescription(context.getString(R.l.dUJ));
        this.lJH = new ImageButton(getContext());
        this.lJH.setImageResource(R.g.bdL);
        this.lJH.setScaleType(ScaleType.CENTER);
        this.lJH.setBackgroundResource(0);
        this.lJH.setContentDescription(context.getString(R.l.dUH));
        this.vBS = new ImageButton(getContext());
        this.vBS.setImageResource(R.g.bdO);
        this.vBS.setScaleType(ScaleType.CENTER);
        this.vBS.setBackgroundResource(0);
        this.vBS.setContentDescription(context.getString(R.l.dUG));
        this.vBR = new ImageButton(getContext());
        this.vBR.setImageResource(R.g.bdM);
        this.vBR.setScaleType(ScaleType.CENTER);
        this.vBR.setBackgroundResource(0);
        this.vBR.setContentDescription(context.getString(R.l.dUI));
        bUm();
    }

    public final void bUm() {
        removeAllViews();
        addView(this.vBQ, this.mBJ);
        addView(this.vBT, this.mBJ);
        addView(this.lJH, this.mBJ);
        if (aa.bTZ().size() > 0) {
            addView(this.vBS, this.mBJ);
        } else {
            addView(this.vBR, this.mBJ);
        }
    }

    public final void AP(int i) {
        boolean z = i > 0;
        this.vBQ.setClickable(z);
        this.vBQ.setEnabled(z);
        if (aa.bTZ().size() > 0) {
            this.vBS.setClickable(z);
            this.vBS.setEnabled(z);
        } else {
            this.vBR.setClickable(z);
            this.vBR.setEnabled(z);
        }
        this.lJH.setClickable(z);
        this.lJH.setEnabled(z);
        this.vBT.setClickable(z);
        this.vBT.setEnabled(z);
    }

    public final void c(int i, OnClickListener onClickListener) {
        switch (i) {
            case 0:
                this.vBQ.setOnClickListener(onClickListener);
                return;
            case 1:
                this.vBR.setOnClickListener(onClickListener);
                return;
            case 2:
                this.vBS.setOnClickListener(onClickListener);
                return;
            case 3:
                this.lJH.setOnClickListener(onClickListener);
                return;
            case 4:
                this.vBT.setOnClickListener(onClickListener);
                return;
            default:
                w.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", Integer.valueOf(i));
                return;
        }
    }
}
