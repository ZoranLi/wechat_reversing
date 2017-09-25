package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.f;
import com.tencent.mm.e.a.pc;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Date;

public final class an {
    public boolean hZl = false;
    public boolean hZm = false;
    long pXl = 0;
    private boolean pXm = false;
    int pXn = 0;
    int pXo = 1440;
    c<pc> pXp = new c<pc>(this) {
        final /* synthetic */ an pXs;

        {
            this.pXs = r2;
            this.usg = pc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return bfm();
        }

        private boolean bfm() {
            int minutes;
            int i = 1200;
            an anVar = this.pXs;
            try {
                if (anVar.bfl()) {
                    Date date = new Date();
                    minutes = date.getMinutes() + (date.getHours() * 60);
                    if (minutes >= anVar.pXn && minutes <= anVar.pXo) {
                        w.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[]{Integer.valueOf(minutes), Integer.valueOf(anVar.pXn), Integer.valueOf(anVar.pXo)});
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            int i2 = g.sV().getInt("SnsImgPreLoadingSmallImage", 1);
            int i3 = g.sV().getInt("SnsImgPreLoadingBigImage", 1);
            int i4 = g.sV().getInt("SnsPreLoadingVideo", 1);
            minutes = g.sV().getInt("SnsImgPreLoadingInterval", 1200);
            w.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minutes)});
            if (i2 > 0 || i3 > 0 || i4 > 0) {
                if (minutes > 0) {
                    i = minutes;
                }
                if (anVar.hZl || anVar.hZm || bg.az(anVar.pXl) < ((long) r0)) {
                    w.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[]{Boolean.valueOf(anVar.hZl), Boolean.valueOf(anVar.hZm)});
                } else if (x.Fb("@__weixintimtline")) {
                    h.vJ();
                    if (!h.vH().gXC.a(new s(), 0)) {
                        w.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                        x.Fc("@__weixintimtline");
                    }
                    anVar.pXl = bg.Ny();
                } else {
                    w.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
                }
            }
            return false;
        }
    };
    c pXq = new c<f>(this) {
        final /* synthetic */ an pXs;

        {
            this.pXs = r2;
            this.usg = f.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            f fVar = (f) bVar;
            if (fVar.fCo.className.equals("En_424b8e16")) {
                this.pXs.hZm = fVar.fCo.fCp;
                w.i("MicroMsg.SnsPreTimelineService", "set isInSnsTimeline:%b", new Object[]{Boolean.valueOf(this.pXs.hZm)});
            }
            return false;
        }
    };
    c pXr = new c<ar>(this) {
        final /* synthetic */ an pXs;

        {
            this.pXs = r2;
            this.usg = ar.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ar arVar = (ar) bVar;
            this.pXs.hZl = arVar.fEf.fEg;
            w.i("MicroMsg.SnsPreTimelineService", "set isInChatting:%b", new Object[]{Boolean.valueOf(this.pXs.hZl)});
            return false;
        }
    };

    an() {
    }

    final boolean bfl() {
        String value = g.sV().getValue("SnsImgPreLoadingTimeLimit");
        w.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[]{value});
        if (bg.mA(value)) {
            return false;
        }
        try {
            String[] split = value.split("-");
            String[] split2 = split[0].split(":");
            this.pXn = bg.PY(split2[1]) + (bg.PY(split2[0]) * 60);
            split = split[1].split(":");
            this.pXo = bg.PY(split[1]) + (bg.PY(split[0]) * 60);
            w.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[]{Integer.valueOf(this.pXn), Integer.valueOf(this.pXo)});
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
