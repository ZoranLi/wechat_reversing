package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class VideoSightCenterView extends VideoSightView {
    private boolean fOV = false;
    private int qiK = 0;
    private volatile boolean sWZ = false;
    private MediaMetadataRetriever sXa;

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void sF(int i) {
        super.sF(i);
        bGG();
    }

    public final void cR(int i, int i2) {
        super.cR(i, i2);
        bGG();
    }

    private void bGG() {
        if (getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
    }

    protected final void init() {
        if (bg.ap(p.gRl.gQD, "").equals("other")) {
            w.i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            hb(true);
        }
        a(new e(this) {
            final /* synthetic */ VideoSightCenterView sXb;

            {
                this.sXb = r1;
            }

            public final void a(b bVar, int i) {
                if (-1 == i) {
                    w.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[]{Boolean.valueOf(this.sXb.sWZ)});
                    if (this.sXb.pvi != null && !this.sXb.sWZ) {
                        this.sXb.pvi.onError(0, 0);
                    }
                } else if (i == 0) {
                    w.i("MicroMsg.VideoSightCenterView", "normal stop");
                    this.sXb.sWZ = true;
                    if (this.sXb.pvi != null) {
                        this.sXb.pvi.oW();
                    }
                }
            }
        });
    }

    public final void he(boolean z) {
        if (z) {
            a(new f(this) {
                final /* synthetic */ VideoSightCenterView sXb;

                {
                    this.sXb = r1;
                }

                public final void a(b bVar, long j) {
                    if (this.sXb.duration == 0) {
                        this.sXb.duration = this.sXb.getDuration();
                    }
                    if (this.sXb.pvi != null) {
                        w.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[]{Long.valueOf(j), Integer.valueOf(this.sXb.duration)});
                        this.sXb.qiK = (int) (1000 * j);
                        this.sXb.pvi.bI((int) j, this.sXb.duration);
                    }
                }
            });
        } else {
            a(null);
        }
    }

    public final int getDuration() {
        w.i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!bg.mA(this.ptO)) {
            try {
                if (this.sXa == null) {
                    this.sXa = new MediaMetadataRetriever();
                    this.sXa.setDataSource(this.ptO);
                }
                w.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[]{Integer.valueOf(Integer.valueOf(this.sXa.extractMetadata(9)).intValue())});
                return Integer.valueOf(this.sXa.extractMetadata(9)).intValue();
            } catch (Exception e) {
                w.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[]{e.getMessage()});
            }
        }
        return super.getDuration();
    }

    public final int getCurrentPosition() {
        w.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[]{Integer.valueOf(this.qiK)});
        return this.qiK;
    }

    public final boolean start() {
        w.v("MicroMsg.VideoSightCenterView", "start");
        this.fOV = true;
        return super.start();
    }

    public final void stop() {
        w.v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.qiK = 0;
        this.fOV = false;
    }

    public final void pause() {
        w.v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
    }

    public final double bcw() {
        return super.bcw();
    }

    public final void k(double d) {
        w.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[]{Double.valueOf(d), Boolean.valueOf(this.fOV), Integer.valueOf(this.qiK), Double.valueOf(super.bcw())});
        if (this.fOV && super.bcw() > 0.0d) {
            super.k(d / 1000.0d);
        }
    }

    public final boolean isPlaying() {
        w.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[]{Boolean.valueOf(this.fOV), Integer.valueOf(this.qiK)});
        return this.fOV;
    }
}
