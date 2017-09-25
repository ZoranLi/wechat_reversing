package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class d extends Preference implements a {
    private f isJ;
    private TextView jhl = null;
    private ImageView kDl = null;
    private View mView = null;
    String mqI;
    String oRg;
    private TextView oYv = null;
    String oYw;

    public d(Context context) {
        super(context);
        setLayoutResource(R.i.dkR);
        j.a(this);
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
        this.kDl = (ImageView) view.findViewById(R.h.bEm);
        this.jhl = (TextView) view.findViewById(R.h.bEp);
        this.oYv = (TextView) view.findViewById(R.h.bEo);
        if (bg.mA(this.oYw)) {
            this.kDl.setVisibility(8);
        } else {
            Bitmap a = j.a(new o(this.oYw));
            if (a == null || a.isRecycled()) {
                try {
                    this.kDl.setImageBitmap(b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null)));
                } catch (IOException e) {
                    this.kDl.setImageBitmap(null);
                }
            } else {
                this.kDl.setImageBitmap(a);
                this.kDl.setBackgroundColor(0);
            }
        }
        if (bg.mA(this.oRg)) {
            this.jhl.setVisibility(8);
        } else {
            this.jhl.setText(h.b(this.mContext, this.oRg, this.jhl.getTextSize()));
        }
        if (bg.mA(this.mqI)) {
            this.oYv.setVisibility(8);
        } else {
            this.oYv.setText(this.mqI);
        }
        if (bg.mA(this.oRg) && bg.mA(this.oYw)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.bEn);
            LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.f.baN);
            linearLayout.setPadding(b.a(this.mContext, 9.0f), 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public final void k(String str, Bitmap bitmap) {
        if (!bg.mA(str) && str.equals(this.oYw) && bitmap != null && !bitmap.isRecycled()) {
            this.kDl.setImageBitmap(bitmap);
            this.kDl.setBackgroundColor(0);
            if (this.isJ != null) {
                this.isJ.notifyDataSetChanged();
            }
        }
    }
}
