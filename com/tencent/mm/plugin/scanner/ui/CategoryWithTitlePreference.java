package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference extends Preference implements a {
    private Context context;
    private String iconUrl;
    private TextView ioX;
    public f isJ;
    public ImageView jla;
    private int oVH;
    private int oVI;
    private String title;

    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }

    public CategoryWithTitlePreference(Context context) {
        this(context, null);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.title = "";
        this.oVH = 34;
        this.oVI = 34;
        setLayoutResource(R.i.diD);
        this.context = context;
        j.a(this);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.ioX != null) {
                this.ioX.setVisibility(0);
                this.ioX.setText(charSequence);
                w.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.ioX.getText());
            }
        } else if (this.ioX != null) {
            this.ioX.setVisibility(8);
        }
        super.setTitle(charSequence);
    }

    public final void setTitle(int i) {
        if (this.ioX != null) {
            if (this.context != null) {
                this.title = this.context.getString(i);
            }
            if (bg.mA(this.title)) {
                this.ioX.setVisibility(8);
            } else {
                this.ioX.setVisibility(0);
                this.ioX.setText(this.title);
            }
        }
        super.setTitle(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ioX = (TextView) view.findViewById(16908310);
        this.jla = (ImageView) view.findViewById(R.h.icon);
        LayoutParams layoutParams = this.jla.getLayoutParams();
        layoutParams.width = b.a(this.context, (float) (this.oVH / 2));
        layoutParams.height = b.a(this.context, (float) (this.oVI / 2));
        this.jla.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.ioX == null)) {
            this.ioX.setVisibility(0);
            this.ioX.setText(this.title);
            w.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.ioX.getText());
        }
        if (!bg.mA(this.iconUrl)) {
            Bitmap a = j.a(new o(this.iconUrl));
            if (a != null && !a.isRecycled()) {
                this.jla.setImageBitmap(a);
                this.jla.setVisibility(0);
            }
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        w.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!bg.mA(str) && str.equals(this.iconUrl) && bitmap != null && !bitmap.isRecycled() && this.jla != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ CategoryWithTitlePreference oYu;

                public final void run() {
                    this.oYu.jla.setImageBitmap(bitmap);
                    this.oYu.jla.setVisibility(0);
                    if (this.oYu.isJ != null) {
                        this.oYu.isJ.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
