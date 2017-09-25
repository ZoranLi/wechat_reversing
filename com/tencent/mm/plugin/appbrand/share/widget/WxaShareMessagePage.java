package com.tencent.mm.plugin.appbrand.share.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage extends LinearLayout implements h {
    public TextView jhl;
    public ImageView jhm;
    public ImageView jhn;
    public IPCDynamicPageView jho;
    public ThreeDotsLoadingView jhp;

    public WxaShareMessagePage(Context context) {
        super(context);
        init(context);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, R.i.dsa, this);
        this.jhm = (ImageView) inflate.findViewById(R.h.bHc);
        this.jhn = (ImageView) inflate.findViewById(R.h.bMt);
        this.jho = (IPCDynamicPageView) inflate.findViewById(R.h.cTf);
        this.jhl = (TextView) inflate.findViewById(R.h.cJh);
        this.jhp = (ThreeDotsLoadingView) inflate.findViewById(R.h.cbU);
        setGravity(17);
    }

    public final void Ba() {
    }

    public final void h(Bitmap bitmap) {
        this.jhp.setVisibility(4);
        this.jhp.Wd();
        if (bitmap == null || bitmap.isRecycled()) {
            this.jhm.setImageBitmap(null);
            this.jhn.setVisibility(0);
            return;
        }
        this.jhm.setImageBitmap(bitmap);
        this.jhn.setVisibility(4);
    }

    public final void Bb() {
        this.jhp.setVisibility(4);
        this.jhp.Wd();
        this.jhm.setImageBitmap(null);
        this.jhn.setVisibility(0);
    }

    public final String Bc() {
        return b.aM(this);
    }

    public final void qG(String str) {
        this.jhp.setVisibility(0);
        this.jhp.caQ();
        this.jhn.setVisibility(4);
        this.jhm.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.AY().a(this, str, null, ((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aL(MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 90));
    }

    public final void n(Bitmap bitmap) {
        this.jhm.setVisibility(0);
        this.jhp.setVisibility(4);
        this.jhn.setVisibility(4);
        if (bitmap == null || bitmap.isRecycled()) {
            this.jhm.setImageBitmap(null);
            return;
        }
        this.jhm.setImageBitmap(((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).AO().i(bitmap));
    }

    public static int WA() {
        return com.tencent.mm.plugin.appbrand.m.h.iD(224);
    }

    public static int WB() {
        return com.tencent.mm.plugin.appbrand.m.h.iD(180);
    }
}
