package com.tencent.mm.plugin.appbrand.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.plugin.appbrand.widget.j.a;

public class i extends FrameLayout implements a {
    public static final boolean jrv = j.jrz;
    private int jkQ;
    private final Paint jrw;
    private boolean jrx;
    private int jry;
    public final Activity qb;

    public final void ix(int i) {
        this.jkQ = Math.max(0, i);
        setPadding(0, this.jkQ, 0, 0);
        postInvalidate();
    }

    public i(Context context) {
        super(context);
        if (jrv) {
            this.qb = g.bB(context);
            j.s(this.qb).a(this);
            this.jrw = new Paint(1);
            this.jrw.setStyle(Style.FILL);
            setWillNotDraw(false);
            return;
        }
        this.qb = null;
        this.jrw = null;
    }

    public final void C(int i, boolean z) {
        this.jry = i;
        this.jrx = z;
        if (jrv) {
            i iVar;
            Window window = this.qb.getWindow();
            if (VERSION.SDK_INT < 23 || g.sf()) {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        i = g.g(i, 0.78f);
                        iVar = this;
                    } else {
                        iVar = this;
                    }
                }
                g.a(window);
                postInvalidate();
            }
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= 8192;
            } else {
                systemUiVisibility &= -8193;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            iVar = this;
            iVar.jry = i;
            g.a(window);
            postInvalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.jkQ > 0 && jrv) {
            this.jrw.setColor(this.jry);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.jkQ, this.jrw);
        }
        super.onDraw(canvas);
    }
}
