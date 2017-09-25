package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    String lia;
    String mName;
    OnClickListener mOnClickListener;
    private View mView = null;

    public d(Context context) {
        super(context);
        setLayoutResource(R.i.dhT);
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
        ImageView imageView = (ImageView) view.findViewById(R.h.chs);
        TextView textView = (TextView) view.findViewById(R.h.cht);
        imageView.setImageBitmap(null);
        if (!bg.mA(this.lia)) {
            a aVar = new a();
            b.aRw();
            aVar.hIO = b.aHI();
            aVar.hIL = true;
            aVar.hJh = true;
            aVar.hJi = true;
            n.GW().a(this.lia, imageView, aVar.Hg());
        }
        textView.setText(this.mName);
        view.findViewById(R.h.chr).setOnClickListener(this.mOnClickListener);
    }
}
