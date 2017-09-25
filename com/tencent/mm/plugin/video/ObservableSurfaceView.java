package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.sdk.platformtools.w;

public class ObservableSurfaceView extends SurfaceView implements Callback {
    protected SurfaceHolder iDu;
    private a rbW = null;
    protected boolean rbX = false;
    protected boolean rbY = false;
    protected boolean rbZ = false;

    public ObservableSurfaceView(Context context) {
        super(context);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iDu = getHolder();
        this.iDu.addCallback(this);
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.iDu;
    }

    public final void bow() {
        this.rbZ = true;
        if (this.rbZ) {
            this.iDu.setType(3);
        }
    }

    public final void a(a aVar) {
        this.rbW = aVar;
        if (this.rbZ) {
            this.iDu.setType(3);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.rbX = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        w.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.rbY = true;
        try {
            this.iDu.removeCallback(this);
        } catch (Exception e) {
        }
        this.iDu = surfaceHolder;
        this.iDu.addCallback(this);
        if (this.rbW != null) {
            this.rbW.a(this.iDu);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.rbX = false;
        this.rbY = false;
    }

    public final boolean box() {
        return this.rbX;
    }
}
