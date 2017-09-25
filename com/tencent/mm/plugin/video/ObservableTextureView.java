package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView extends MMTextureView implements SurfaceTextureListener {
    protected SurfaceTexture nSd;
    protected b rca;
    private boolean rcb = false;

    public ObservableTextureView(Context context) {
        super(context);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        setSurfaceTextureListener(this);
        this.nSd = getSurfaceTexture();
    }

    public boolean isAvailable() {
        return this.rcb;
    }

    public final void a(b bVar) {
        this.rca = bVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        w.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        bSB();
        this.rcb = true;
        if (this.rca != null) {
            this.rca.b(surfaceTexture);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        w.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        w.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.rcb = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
