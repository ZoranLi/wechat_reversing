package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.b.c.a;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.zzab;

public final class SignInButton extends FrameLayout implements OnClickListener {
    private View amk;
    private OnClickListener aml;
    private int hP;
    private int sl;

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        int o;
        super(context, attributeSet, i);
        this.aml = null;
        w.a(true, "Unknown button size %d", new Object[]{Integer.valueOf(0)});
        w.a(true, "Unknown color scheme %s", new Object[]{Integer.valueOf(0)});
        this.hP = 0;
        this.sl = 0;
        Context context2 = getContext();
        if (this.amk != null) {
            removeView(this.amk);
        }
        try {
            this.amk = b.a(context2, this.hP, this.sl);
        } catch (a e) {
            int i2 = this.hP;
            int i3 = this.sl;
            View com_google_android_gms_common_internal_zzab = new zzab(context2);
            Resources resources = context2.getResources();
            boolean z = i2 >= 0 && i2 < 3;
            w.a(z, "Unknown button size %d", new Object[]{Integer.valueOf(i2)});
            z = i3 >= 0 && i3 < 2;
            w.a(z, "Unknown color scheme %s", new Object[]{Integer.valueOf(i3)});
            com_google_android_gms_common_internal_zzab.setTypeface(Typeface.DEFAULT_BOLD);
            com_google_android_gms_common_internal_zzab.setTextSize(14.0f);
            float f = resources.getDisplayMetrics().density;
            com_google_android_gms_common_internal_zzab.setMinHeight((int) ((48.0f * f) + 0.5f));
            com_google_android_gms_common_internal_zzab.setMinWidth((int) ((f * 48.0f) + 0.5f));
            switch (i2) {
                case 0:
                case 1:
                    o = zzab.o(i3, R.drawable.common_signin_btn_text_dark, R.drawable.common_signin_btn_text_light);
                    break;
                case 2:
                    o = zzab.o(i3, R.drawable.common_signin_btn_icon_dark, R.drawable.common_signin_btn_icon_light);
                    break;
                default:
                    throw new IllegalStateException("Unknown button size: " + i2);
            }
            if (o == -1) {
                throw new IllegalStateException("Could not find background resource!");
            }
            com_google_android_gms_common_internal_zzab.setBackgroundDrawable(resources.getDrawable(o));
            com_google_android_gms_common_internal_zzab.setTextColor(resources.getColorStateList(zzab.o(i3, R.color.common_signin_btn_text_dark, R.color.common_signin_btn_text_light)));
            switch (i2) {
                case 0:
                    com_google_android_gms_common_internal_zzab.setText(resources.getString(R.string.common_signin_button_text));
                    break;
                case 1:
                    com_google_android_gms_common_internal_zzab.setText(resources.getString(R.string.common_signin_button_text_long));
                    break;
                case 2:
                    com_google_android_gms_common_internal_zzab.setText(null);
                    break;
                default:
                    throw new IllegalStateException("Unknown button size: " + i2);
            }
            this.amk = com_google_android_gms_common_internal_zzab;
        }
        addView(this.amk);
        this.amk.setEnabled(isEnabled());
        this.amk.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.aml != null && view == this.amk) {
            this.aml.onClick(this);
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.amk.setEnabled(z);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.aml = onClickListener;
        if (this.amk != null) {
            this.amk.setOnClickListener(this);
        }
    }
}
