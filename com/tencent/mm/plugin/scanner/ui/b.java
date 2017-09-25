package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b extends Preference implements a {
    f isJ;
    String kOm;
    private Context mContext;
    private View mView = null;
    private ImageView oXh = null;

    public b(Context context) {
        super(context);
        setLayoutResource(R.i.dkP);
        j.a(this);
        this.mContext = context;
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
        this.oXh = (ImageView) view.findViewById(R.h.bsw);
        if (!bg.mA(this.kOm)) {
            Bitmap a = j.a(new o(this.kOm));
            if (a == null || a.isRecycled()) {
                this.oXh.setBackgroundColor(this.mContext.getResources().getColor(R.e.aUj));
                this.oXh.setImageBitmap(null);
                return;
            }
            this.oXh.setImageBitmap(a);
            this.oXh.setBackgroundColor(0);
        }
    }

    public final void k(String str, Bitmap bitmap) {
        if (!bg.mA(str) && str.equals(this.kOm) && bitmap != null && !bitmap.isRecycled()) {
            this.oXh.setImageBitmap(bitmap);
            this.oXh.setBackgroundColor(0);
            if (this.isJ != null) {
                this.isJ.notifyDataSetChanged();
            }
        }
    }
}
