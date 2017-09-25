package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.w;

public class MaskLayout extends RelativeLayout {
    private ImageView lNh;
    public View view;
    private Drawable vnR;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] vnS = new int[a.bSI().length];

        static {
            try {
                vnS[a.vnV - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vnS[a.vnW - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vnS[a.vnU - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                vnS[a.vnT - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum a {
        ;

        public static int[] bSI() {
            return (int[]) vnY.clone();
        }

        static {
            vnT = 1;
            vnU = 2;
            vnV = 3;
            vnW = 4;
            vnX = 5;
            vnY = new int[]{vnT, vnU, vnV, vnW, vnX};
        }
    }

    public MaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.frt, i, 0);
        this.vnR = obtainStyledAttributes.getDrawable(m.hfS);
        obtainStyledAttributes.recycle();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.view = findViewById(g.content);
        if (this.view == null) {
            w.d("MicroMsg.MaskLayout", "%s", "not found view by id, new one");
            this.view = new View(getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.view.setLayoutParams(layoutParams);
            addView(this.view);
        }
        this.lNh = new ImageView(getContext());
        this.lNh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.lNh.setImageDrawable(this.vnR);
        addView(this.lNh);
    }

    public final void bSG() {
        Am(a.vnX);
        this.lNh.setImageBitmap(null);
    }

    public final void bSH() {
        Am(a.vnX);
        this.lNh.setImageDrawable(null);
    }

    public final void d(Bitmap bitmap, int i) {
        Am(i);
        this.lNh.setImageBitmap(bitmap);
    }

    private void Am(int i) {
        removeView(this.lNh);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (AnonymousClass1.vnS[i - 1]) {
            case 1:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            case 3:
                break;
            case 4:
                layoutParams.addRule(11);
                break;
            default:
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                break;
        }
        addView(this.lNh, layoutParams);
    }
}
