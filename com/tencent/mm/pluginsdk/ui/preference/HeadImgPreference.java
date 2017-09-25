package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference extends Preference {
    private int height;
    private ImageView jki;
    public OnClickListener sAw;
    private Bitmap sSl;

    public HeadImgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.diJ, viewGroup2);
        this.jki = (ImageView) onCreateView.findViewById(R.h.bWS);
        return onCreateView;
    }

    public final void I(Bitmap bitmap) {
        this.sSl = null;
        if (this.jki != null) {
            this.jki.setImageBitmap(bitmap);
        } else {
            this.sSl = bitmap;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.jki == null) {
            this.jki = (ImageView) view.findViewById(R.h.bWS);
        }
        if (this.sAw != null) {
            this.jki.setOnClickListener(this.sAw);
        }
        if (this.sSl != null) {
            this.jki.setImageBitmap(this.sSl);
            this.sSl = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.ckj);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
    }
}
