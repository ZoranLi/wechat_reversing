package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.AttributeSet;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.e;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import java.io.File;

public class AdlandingVideoSightView extends AdlandingSightPlayImageView implements f {
    protected int duration = 0;
    private boolean kmK = false;
    protected String ptO;
    private boolean qlc;
    private boolean qld = true;

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (bg.ap(p.gRl.gQD, "").equals("other")) {
            w.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            hb(true);
        }
        this.qkZ.qkQ = new e(this) {
            final /* synthetic */ AdlandingVideoSightView qle;

            {
                this.qle = r1;
            }

            public final void tv(int i) {
                if (-1 == i) {
                    if (this.qle.pvi != null) {
                        this.qle.pvi.onError(0, 0);
                    }
                } else if (i == 0 && this.qle.pvi != null) {
                    this.qle.pvi.oW();
                }
            }
        };
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        w.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.pvj)});
        if (this.pvj && i3 - i > 0) {
            sF(i3 - i);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.qld) {
            sF(getResources().getDisplayMetrics().widthPixels);
        }
    }

    public final boolean isPlaying() {
        return this.qkZ.bbZ();
    }

    public final void setVideoPath(String str) {
        String str2 = "MicroMsg.VideoSightView";
        String str3 = "set sight path %s, callback null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.pvi == null);
        w.i(str2, str3, objArr);
        this.duration = 0;
        this.ptO = str;
        if (this.pvi != null) {
            this.pvi.Uc();
        }
    }

    public final void stop() {
        this.qkZ.clear();
    }

    public final void pause() {
        ak(this.ptO, true);
    }

    public final void bN(boolean z) {
        if (this.qkZ != null) {
            this.qkZ.mNI = z;
        }
    }

    public final void a(a aVar) {
        this.pvi = aVar;
    }

    public final int getCurrentPosition() {
        w.v("MicroMsg.VideoSightView", "get current position");
        return 0;
    }

    public final int getDuration() {
        int duration = super.getDuration();
        w.v("MicroMsg.VideoSightView", "get duration " + duration);
        return duration;
    }

    public final void onDetach() {
        com.tencent.mm.sdk.b.a.urY.c(this.qkZ.bcd());
    }

    public final boolean start() {
        return i(getContext(), false);
    }

    public final boolean i(Context context, boolean z) {
        boolean z2 = false;
        if (this.ptO == null) {
            w.e("MicroMsg.VideoSightView", "start::use path is null!");
            return false;
        } else if (bg.ap(p.gRl.gQD, "").equals("other") || !b.Es(this.ptO)) {
            w.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[]{this.ptO, Boolean.valueOf(this.qlc)});
            if (this.qlc && !z) {
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.ptO)), "video/*");
            try {
                context.startActivity(Intent.createChooser(intent, context.getString(j.ejL)));
            } catch (Exception e) {
                w.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                g.bl(context, context.getResources().getString(j.fak));
            }
            this.qlc = true;
            return false;
        } else {
            ak(this.ptO, false);
            if (!this.kmK) {
                z2 = true;
            }
            hb(z2);
            return true;
        }
    }

    public final double bcw() {
        if (this.qkZ == null) {
            return 0.0d;
        }
        a aVar = this.qkZ;
        return aVar.puq != -1.0d ? aVar.puq : aVar.pun;
    }

    public final void k(double d) {
        if (this.qkZ != null) {
            a aVar = this.qkZ;
            w.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[]{Double.valueOf(d), bg.bJZ().toString()});
            o.b(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.AnonymousClass2(aVar, d), 0);
        }
    }

    public final void he(boolean z) {
        if (z) {
            a(new a.f(this) {
                final /* synthetic */ AdlandingVideoSightView qle;

                {
                    this.qle = r1;
                }

                public final void dy(long j) {
                    if (this.qle.duration == 0) {
                        this.qle.duration = this.qle.getDuration();
                    }
                    if (this.qle.pvi != null) {
                        w.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[]{Long.valueOf(j), Integer.valueOf(this.qle.duration)});
                        this.qle.pvi.bI((int) j, this.qle.duration);
                    }
                }
            });
        } else {
            a(null);
        }
    }

    public final long bcx() {
        return 0;
    }

    public final void bQ(boolean z) {
        this.kmK = z;
        hb(!this.kmK);
    }

    public final void c(double d, boolean z) {
        k(d);
    }

    public final void a(f.e eVar) {
    }

    public final void a(c cVar) {
    }

    public final void a(f.b bVar) {
    }

    public final void a(d dVar) {
    }
}
