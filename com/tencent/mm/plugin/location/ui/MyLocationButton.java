package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ae;

public class MyLocationButton extends FrameLayout {
    private Context context;
    public a gKp = new a(this) {
        final /* synthetic */ MyLocationButton nde;

        {
            this.nde = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            this.nde.ndb.setVisibility(8);
            this.nde.nda.setVisibility(0);
            if (this.nde.ndc != null && this.nde.ndd) {
                this.nde.ndc.getIController().setCenter((double) f2, (double) f);
                if (this.nde.ndc.getZoomLevel() < 16) {
                    this.nde.ndc.getIController().setZoom(16);
                }
            }
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 ndf;

                {
                    this.ndf = r1;
                }

                public final void run() {
                    c.Gk().c(this.ndf.nde.gKp);
                }
            });
            return false;
        }
    };
    public ImageButton nda;
    public LinearLayout ndb;
    public d ndc;
    public boolean ndd = true;

    public MyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public MyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.context, R.i.djO, this);
        this.nda = (ImageButton) inflate.findViewById(R.h.cbX);
        this.ndb = (LinearLayout) inflate.findViewById(R.h.ctp);
    }

    public final void aGx() {
        this.nda.setImageResource(R.g.bis);
    }

    public final void aGy() {
        this.nda.setImageResource(R.g.bit);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.nda.setOnClickListener(onClickListener);
    }
}
