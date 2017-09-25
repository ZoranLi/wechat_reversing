package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference extends Preference {
    private ImageView ovk;
    private int ovl;
    private Bitmap ovm;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ovk = null;
        this.ovl = -1;
        this.ovm = null;
        setLayoutResource(R.i.diC);
        setWidgetLayoutResource(0);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.djp, viewGroup2);
        return onCreateView;
    }

    public final void x(Bitmap bitmap) {
        this.ovm = bitmap;
        if (this.ovk != null) {
            this.ovk.setImageBitmap(bitmap);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ovk = (ImageView) view.findViewById(R.h.cso);
        if (this.ovk != null) {
            this.ovk.setVisibility(8);
            if (this.ovl != -1) {
                this.ovk.setImageResource(this.ovl);
                this.ovk.setVisibility(0);
            } else if (this.ovm != null) {
                this.ovk.setImageBitmap(this.ovm);
                this.ovk.setVisibility(0);
            }
        }
    }
}
