package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;

public final class ImagePreference extends Preference {
    private ImageView ouX;
    private e vre;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ouX = null;
        this.vre = new e();
        setLayoutResource(h.hev);
        setWidgetLayoutResource(h.djm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fqp);
        int resourceId = obtainStyledAttributes.getResourceId(m.hfK, 0);
        if (resourceId > 0) {
            e eVar = this.vre;
            eVar.rqp = resourceId;
            eVar.bitmap = null;
            this.vre.h(this.ouX);
        }
        obtainStyledAttributes.recycle();
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.hci);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.hev, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ouX = (ImageView) view.findViewById(g.bWV);
        this.vre.h(this.ouX);
    }
}
