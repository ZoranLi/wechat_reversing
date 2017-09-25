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

public class VoipSmallIconButton extends FrameLayout {
    private TextView kH;
    private ImageView kZz;
    private Drawable rlV = null;
    private Drawable rlW = null;
    private OnTouchListener rlX = new OnTouchListener(this) {
        final /* synthetic */ VoipSmallIconButton rlZ;

        {
            this.rlZ = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.rlZ.kZz.setImageDrawable(this.rlZ.rlW);
                    this.rlZ.kH.setTextColor(-855638017);
                    break;
                case 1:
                    this.rlZ.kZz.setImageDrawable(this.rlZ.rlV);
                    this.rlZ.kH.setTextColor(-1);
                    break;
            }
            return false;
        }
    };

    public void setOnClickListener(OnClickListener onClickListener) {
        this.kZz.setOnClickListener(onClickListener);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        CharSequence charSequence = 0;
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.dgI, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.frH, 0, 0);
        try {
            this.rlV = obtainStyledAttributes.getDrawable(R.n.frK);
            this.rlW = obtainStyledAttributes.getDrawable(R.n.frL);
            charSequence = obtainStyledAttributes.getString(R.n.frM);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.frM, -1);
            this.kZz = (ImageView) findViewById(R.h.cFE);
            this.kZz.setImageDrawable(this.rlV);
            this.kZz.setOnTouchListener(this.rlX);
            this.kZz.setContentDescription(charSequence);
            this.kH = (TextView) findViewById(R.h.cFG);
            if (resourceId != -1) {
                this.kH.setText(getContext().getString(resourceId));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.kZz.setEnabled(z);
        this.kH.setEnabled(z);
    }
}
