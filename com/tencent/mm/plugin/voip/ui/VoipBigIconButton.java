package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class VoipBigIconButton extends FrameLayout {
    private TextView kH;
    private ImageView kZz;
    private Drawable rlT = null;
    private Drawable rlU = null;
    private Drawable rlV = null;
    private Drawable rlW = null;
    private OnTouchListener rlX = new OnTouchListener(this) {
        final /* synthetic */ VoipBigIconButton rlY;

        {
            this.rlY = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.rlY.kZz.setBackgroundDrawable(this.rlY.rlU);
                    this.rlY.kZz.setImageDrawable(this.rlY.rlW);
                    this.rlY.kH.setTextColor(-855638017);
                    break;
                case 1:
                    this.rlY.kZz.setBackgroundDrawable(this.rlY.rlT);
                    this.rlY.kZz.setImageDrawable(this.rlY.rlV);
                    this.rlY.kH.setTextColor(-1);
                    break;
            }
            return false;
        }
    };

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.dgH, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.frH, 0, 0);
        try {
            CharSequence string;
            this.rlT = obtainStyledAttributes.getDrawable(R.n.frI);
            this.rlU = obtainStyledAttributes.getDrawable(R.n.frJ);
            this.rlV = obtainStyledAttributes.getDrawable(R.n.frK);
            this.rlW = obtainStyledAttributes.getDrawable(R.n.frL);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.frM, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(R.n.frM, 0);
            if (resourceId2 != 0) {
                string = getContext().getString(resourceId2);
            } else {
                string = null;
            }
            obtainStyledAttributes.recycle();
            this.rlU = this.rlU == null ? this.rlT : this.rlU;
            this.rlW = this.rlW == null ? this.rlV : this.rlW;
            this.kZz = (ImageView) findViewById(R.h.bsF);
            this.kZz.setBackgroundDrawable(this.rlT);
            this.kZz.setImageDrawable(this.rlV);
            this.kZz.setOnTouchListener(this.rlX);
            this.kZz.setContentDescription(string);
            this.kH = (TextView) findViewById(R.h.bsH);
            if (resourceId != -1) {
                this.kH.setText(getContext().getString(resourceId));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.kZz.setEnabled(z);
        this.kH.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.kZz.setOnClickListener(onClickListener);
    }
}
