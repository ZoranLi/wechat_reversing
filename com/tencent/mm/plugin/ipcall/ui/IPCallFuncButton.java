package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;

public class IPCallFuncButton extends LinearLayout {
    private boolean kdV = false;
    private boolean lPM = true;
    private ImageView mUO;
    private TextView mUP;
    private Drawable mUQ;
    private Drawable mUR;
    private Drawable mUS;
    private boolean mUT;
    a mUU;
    private OnTouchListener mUV = new OnTouchListener(this) {
        final /* synthetic */ IPCallFuncButton mUW;

        {
            this.mUW = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.mUW.lPM) {
                if (motionEvent.getAction() == 0) {
                    if (this.mUW.mUT) {
                        if (this.mUW.kdV) {
                            this.mUW.mUO.setImageDrawable(this.mUW.mUQ);
                            this.mUW.kdV = false;
                        } else {
                            this.mUW.mUO.setImageDrawable(this.mUW.mUR);
                            this.mUW.kdV = true;
                        }
                        if (this.mUW.mUU != null) {
                            this.mUW.mUU.ff(this.mUW.kdV);
                        }
                    } else if (this.mUW.mUR != null) {
                        this.mUW.mUO.setImageDrawable(this.mUW.mUR);
                    }
                } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !this.mUW.mUT) {
                    if (this.mUW.mUQ != null) {
                        this.mUW.mUO.setImageDrawable(this.mUW.mUQ);
                    }
                    if (this.mUW.mUU != null) {
                        this.mUW.mUU.ff(false);
                    }
                }
            }
            return false;
        }
    };
    private String text;

    public interface a {
        void ff(boolean z);
    }

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.i.dgf, this);
        this.mUO = (ImageView) findViewById(R.h.button);
        this.mUP = (TextView) findViewById(R.h.text);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.n.fqi, 0, 0);
        this.mUQ = obtainStyledAttributes.getDrawable(R.n.fql);
        this.mUR = obtainStyledAttributes.getDrawable(R.n.fqm);
        this.mUT = obtainStyledAttributes.getBoolean(R.n.fqj, false);
        this.mUS = obtainStyledAttributes.getDrawable(R.n.fqk);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.fqn, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (bg.mA(this.text)) {
            this.mUP.setVisibility(8);
        } else {
            this.mUP.setText(this.text);
        }
        if (this.mUQ != null) {
            this.mUO.setImageDrawable(this.mUQ);
        }
        this.mUO.setClickable(true);
        this.mUO.setOnTouchListener(this.mUV);
    }

    public final boolean isChecked() {
        if (this.mUT) {
            return this.kdV;
        }
        return false;
    }

    public final void fe(boolean z) {
        if (z != this.lPM) {
            this.lPM = z;
            if (this.lPM || this.mUS == null) {
                this.mUO.setImageDrawable(this.mUQ);
            } else {
                this.mUO.setImageDrawable(this.mUS);
            }
            this.kdV = false;
        }
    }

    public final void setChecked(boolean z) {
        if (z != this.kdV && this.mUT) {
            this.kdV = z;
            if (this.kdV) {
                this.mUO.setImageDrawable(this.mUR);
            } else {
                this.mUO.setImageDrawable(this.mUQ);
            }
        }
    }
}
