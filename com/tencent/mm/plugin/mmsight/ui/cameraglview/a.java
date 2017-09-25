package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public f nMj = new f(this) {
        final /* synthetic */ a nMl;

        {
            this.nMl = r1;
        }

        public final boolean ax(byte[] bArr) {
            if (this.nMl.nMk != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.nMl.nMk;
                if (bArr == null || mMSightCameraGLSurfaceView.nMH == null || mMSightCameraGLSurfaceView.nMH.lPZ) {
                    w.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    mMSightCameraGLSurfaceView.nMH.a(bArr, mMSightCameraGLSurfaceView.nFQ, mMSightCameraGLSurfaceView.nFR, mMSightCameraGLSurfaceView.nMJ, false);
                    mMSightCameraGLSurfaceView.requestRender();
                }
            }
            return false;
        }
    };
    public MMSightCameraGLSurfaceView nMk;

    public final void a(byte[] bArr, boolean z, int i) {
        if (this.nMk != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.nMk;
            if (bArr == null || mMSightCameraGLSurfaceView.nMH == null || mMSightCameraGLSurfaceView.nMH.lPZ) {
                w.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                return;
            }
            mMSightCameraGLSurfaceView.nMH.a(bArr, mMSightCameraGLSurfaceView.nFQ, mMSightCameraGLSurfaceView.nFR, i, z);
            mMSightCameraGLSurfaceView.requestRender();
        }
    }

    public a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        this.nMk = mMSightCameraGLSurfaceView;
    }

    public final void I(int i, int i2, int i3) {
        if (this.nMk != null) {
            int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.nMk;
            w.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), mMSightCameraGLSurfaceView});
            mMSightCameraGLSurfaceView.nFQ = i4;
            mMSightCameraGLSurfaceView.nFR = i;
            mMSightCameraGLSurfaceView.nMJ = i3;
        }
    }

    public final void aMn() {
        if (this.nMk != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.nMk;
            if (mMSightCameraGLSurfaceView.nMH != null) {
                mMSightCameraGLSurfaceView.nMH.nMF = true;
                mMSightCameraGLSurfaceView.requestRender();
            }
        }
    }
}
