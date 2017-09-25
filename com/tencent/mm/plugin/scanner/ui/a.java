package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a extends Preference implements com.tencent.mm.platformtools.j.a {
    public f jid;
    public ImageView jrI;
    String lia;
    private View mView = null;
    private TextView oXe = null;
    String oXf = null;

    public a(Context context) {
        super(context);
        setLayoutResource(R.i.dna);
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
        this.oXe = (TextView) view.findViewById(R.h.bJv);
        this.jrI = (ImageView) view.findViewById(R.h.bnh);
        if (bg.mA(this.oXf)) {
            this.oXe.setVisibility(8);
        } else {
            this.oXe.setText(this.oXf);
            this.oXe.setVisibility(0);
        }
        if (!bg.mA(this.lia)) {
            Bitmap a = j.a(new o(this.lia));
            if (a != null && !a.isRecycled()) {
                this.jrI.setImageBitmap(a);
                this.jrI.setVisibility(0);
            }
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        if (!bg.mA(str) && str.equals(this.lia) && bitmap != null && !bitmap.isRecycled() && this.jrI != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ a oXg;

                public final void run() {
                    this.oXg.jrI.setImageBitmap(bitmap);
                    this.oXg.jrI.setVisibility(0);
                    if (this.oXg.jid != null) {
                        this.oXg.jid.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
