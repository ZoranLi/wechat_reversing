package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.bg;

public final class m implements a {
    public TextView ioX;
    public ImageView jla;
    public n.a orR;

    public final void k(String str, final Bitmap bitmap) {
        if (this.orR != null && !bg.mA(this.orR.iconUrl) && str.equals(this.orR.iconUrl)) {
            this.jla.post(new Runnable(this) {
                final /* synthetic */ m orS;

                public final void run() {
                    this.orS.jla.setImageBitmap(bitmap);
                }
            });
        }
    }
}
