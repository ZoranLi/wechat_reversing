package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    Bitmap hqW = null;
    OnClickListener mOnClickListener;
    private View mView = null;
    private TextView odW;
    private ImageView oip;
    String oiq = "";

    public c(Context context) {
        super(context);
        setLayoutResource(R.i.dhS);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.odW = (TextView) view.findViewById(R.h.chq);
        this.oip = (ImageView) view.findViewById(R.h.chp);
        this.odW.setText(this.oiq);
        this.oip.setImageBitmap(this.hqW);
        this.oip.setOnClickListener(this.mOnClickListener);
        if (this.oiq != null && this.oiq.length() > 48) {
            this.odW.setTextSize(0, (float) a.T(this.mContext, R.f.aXs));
        }
    }
}
