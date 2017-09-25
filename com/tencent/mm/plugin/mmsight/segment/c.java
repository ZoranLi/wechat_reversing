package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Point;

public final class c implements e {
    private int duration;
    private int nGB;
    private int nGC;
    private FFmpegMetadataRetriever nGD;
    private Bitmap reuse;

    public c() {
        this.nGD = null;
        this.duration = 0;
        this.reuse = null;
        this.nGD = new FFmpegMetadataRetriever();
    }

    public final void init(String str, int i, int i2, int i3) {
        if (this.nGD == null) {
            throw new IllegalStateException("Retriever has been released.");
        }
        this.nGD.setDataSource(str);
        int videoWidth = this.nGD.getVideoWidth();
        int videoHeight = this.nGD.getVideoHeight();
        Point point = new Point();
        if (i3 <= 0 && i2 <= 0) {
            point.x = videoWidth;
            point.y = videoHeight;
        } else if (i2 <= 0) {
            point.x = (int) (((float) videoWidth) * (((float) i3) / ((float) videoHeight)));
            point.y = i3;
        } else if (i3 <= 0) {
            point.x = i2;
            point.y = (int) ((((float) i2) / ((float) videoWidth)) * ((float) videoHeight));
        } else if (((float) i3) / ((float) i2) > ((float) videoHeight) / ((float) videoWidth)) {
            point.x = (int) ((((float) videoWidth) * ((float) i3)) / ((float) videoHeight));
            point.y = i3;
        } else {
            point.x = i2;
            point.y = (int) ((((float) videoHeight) * ((float) i2)) / ((float) videoWidth));
        }
        this.nGB = point.x;
        this.nGC = point.y;
    }

    public final Bitmap getFrameAtTime(long j) {
        long duration;
        long j2 = 0;
        if (j > ((long) (getDuration() - 100))) {
            duration = (long) (getDuration() - 100);
        } else {
            duration = j;
        }
        if (duration >= 0) {
            j2 = duration;
        }
        this.nGD.reuseBitmap(this.reuse);
        return this.nGD.getScaledFrameAtTime(j2 * 1000, this.nGB, this.nGC);
    }

    public final int getDurationMs() {
        return getDuration();
    }

    public final void reuseBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.reuse != null) {
                this.reuse.recycle();
            }
            this.reuse = bitmap;
        }
    }

    private int getDuration() {
        if (this.duration > 0) {
            return this.duration;
        }
        String extractMetadata = this.nGD.extractMetadata(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
        this.duration = extractMetadata == null ? 0 : Integer.valueOf(extractMetadata).intValue();
        return this.duration;
    }

    public final int getScaledHeight() {
        return this.nGC;
    }

    public final int getScaledWidth() {
        return this.nGB;
    }

    public final void release() {
        if (this.nGD != null) {
            this.nGD.release();
            this.nGD = null;
        }
    }
}
