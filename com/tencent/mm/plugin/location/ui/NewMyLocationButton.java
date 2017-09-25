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

public class NewMyLocationButton extends FrameLayout {
    private Context context;
    private a gKp = new a(this) {
        final /* synthetic */ NewMyLocationButton ndz;

        {
            this.ndz = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            this.ndz.ndb.setVisibility(8);
            this.ndz.nda.setVisibility(0);
            if (this.ndz.ndc != null && this.ndz.ndd) {
                this.ndz.ndc.getIController().setCenter((double) f2, (double) f);
                if (this.ndz.ndc.getZoomLevel() < 16) {
                    this.ndz.ndc.getIController().setZoom(16);
                }
            }
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 ndA;

                {
                    this.ndA = r1;
                }

                public final void run() {
                    c.Gk().c(this.ndA.ndz.gKp);
                }
            });
            return false;
        }
    };
    private ImageButton nda;
    private LinearLayout ndb;
    private d ndc;
    private boolean ndd = true;

    public NewMyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.context, R.i.dki, this);
        this.nda = (ImageButton) inflate.findViewById(R.h.cnN);
        this.ndb = (LinearLayout) inflate.findViewById(R.h.cnR);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.nda.setOnClickListener(onClickListener);
    }
}
