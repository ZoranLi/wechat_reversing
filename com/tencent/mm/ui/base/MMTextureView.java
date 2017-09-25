package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView extends TextureView {
    private Field vng;

    public MMTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMTextureView(Context context) {
        super(context);
    }

    @TargetApi(14)
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMTextureView", e, "unkown error", new Object[0]);
        }
    }

    public final void bSB() {
        if (d.ep(16)) {
            w.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
        } else if (d.eq(20)) {
            w.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
        } else if (p.gRl.gQE == 2) {
            w.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
        } else {
            w.i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.vng == null) {
                    this.vng = TextureView.class.getDeclaredField("mSurface");
                    this.vng.setAccessible(true);
                }
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.vng.get(this);
                if (surfaceTexture == null) {
                    w.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                } else if (surfaceTexture instanceof r) {
                    w.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                } else {
                    r rVar = new r();
                    rVar.lBp = surfaceTexture;
                    this.vng.set(this, rVar);
                    w.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMTextureView", e, "", new Object[0]);
                w.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
                w.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.MMTextureView", e22, "", new Object[0]);
                w.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
            }
        }
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        super.setSurfaceTexture(surfaceTexture);
        bSB();
    }
}
