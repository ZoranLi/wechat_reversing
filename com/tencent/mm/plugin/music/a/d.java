package com.tencent.mm.plugin.music.a;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.a.c.g;
import com.tencent.mm.am.c;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public f<String, Bitmap> gKW = new f(5);
    public a nSu;
    public g nSv = new g(this) {
        final /* synthetic */ d nSx;

        {
            this.nSx = r1;
        }

        public final void jK(String str) {
        }

        public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
            String str2 = "MicroMsg.Music.MusicImageLoader";
            String str3 = "onImageLoadFinish %s %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bVar.bitmap != null);
            w.i(str2, str3, objArr);
            if (bVar != null && bVar.bitmap != null) {
                final com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) view.getTag();
                this.nSx.a(aVar, bVar.bitmap);
                final int[] m = c.m(bVar.bitmap);
                if (!aVar.f(m)) {
                    i.aNT().F(aVar.field_musicId, m[0], m[1]);
                }
                if (this.nSx.nSu != null) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 nSz;

                        public final void run() {
                            this.nSz.nSx.nSu.a(aVar, m);
                        }
                    });
                }
            }
        }
    };
    public ae nSw = new ae(Looper.getMainLooper());

    public interface a {
        void a(com.tencent.mm.am.a aVar, int[] iArr);
    }

    private class b implements Runnable {
        com.tencent.mm.am.a fPd;
        final /* synthetic */ d nSx;

        public b(d dVar, com.tencent.mm.am.a aVar) {
            this.nSx = dVar;
            this.fPd = aVar;
        }

        public final void run() {
            alh com_tencent_mm_protocal_c_alh = new alh();
            com_tencent_mm_protocal_c_alh.mQY = this.fPd.field_songMediaId;
            com_tencent_mm_protocal_c_alh.tPi = this.fPd.field_songAlbumUrl;
            com_tencent_mm_protocal_c_alh.tPj = this.fPd.field_songAlbumType;
            com_tencent_mm_protocal_c_alh.msN = com_tencent_mm_protocal_c_alh.tPi;
            Bitmap b = m.pQA.b(com_tencent_mm_protocal_c_alh);
            if (b != null) {
                b = com.tencent.mm.sdk.platformtools.d.c(b, 10);
                this.nSx.a(this.fPd, b);
                int[] m = c.m(b);
                if (!this.fPd.f(m)) {
                    this.fPd = i.aNT().F(this.fPd.field_musicId, m[0], m[1]);
                }
                if (this.nSx.nSu != null) {
                    this.nSx.nSu.a(this.fPd, m);
                }
            }
        }
    }

    public final void a(com.tencent.mm.am.a aVar, Bitmap bitmap) {
        w.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[]{aVar.field_musicId});
        this.gKW.put(aVar.field_musicId, bitmap);
    }
}
