package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class q extends r {
    protected int nDX = -1;

    public q(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i, i2, i3, i4, i5, i6, i7, z);
    }

    public final int cp(int i, int i2) {
        this.nDX = i;
        return super.cp(i, i2);
    }

    protected final void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.nDX >= 0 && byteBuffer != null && bufferInfo != null) {
            long NA = bg.NA();
            SightVideoJNI.writeH264Data(this.nDX, byteBuffer, bufferInfo.size);
            w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s", new Object[]{Long.valueOf(bg.aB(NA)), Integer.valueOf(bufferInfo.size)});
        }
    }

    public final void clear() {
        super.clear();
        SightVideoJNI.releaseBigSightDataBuffer(this.nDX);
    }
}
