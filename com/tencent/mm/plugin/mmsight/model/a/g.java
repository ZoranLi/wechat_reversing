package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class g extends h {
    private int nDX = -1;

    public g(int i, int i2) {
        super(i, i2);
    }

    public final int ad(int i, String str) {
        this.nDX = i;
        return super.ad(i, str);
    }

    protected final void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.nDX >= 0 && byteBuffer != null && bufferInfo != null && !this.nEo) {
            SightVideoJNI.writeAACData(this.nDX, byteBuffer, bufferInfo.size);
        }
    }

    protected final boolean aLq() {
        return true;
    }
}
