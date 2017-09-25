package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    int gPG;
    int lKi;
    byte[] nDA;
    int nDB = 0;
    int nDC = 0;
    long nDD = bg.NA();
    int nDE;
    int nDF;
    int nDG;
    int nDH;
    boolean nDI;
    boolean nDJ;
    byte[] nDz;
    int neJ;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a nDK;
        final /* synthetic */ b nDL;

        AnonymousClass1(b bVar, a aVar) {
            this.nDL = bVar;
            this.nDK = aVar;
        }

        public final void run() {
            b bVar = this.nDL;
            w.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", new Object[]{Integer.valueOf(bVar.nDE), Integer.valueOf(bVar.nDF), Integer.valueOf(bVar.neJ), Integer.valueOf(bVar.lKi), Integer.valueOf(bVar.nDC)});
            if (bVar.nDG == 21 || bVar.nDG == 2130706688) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.nDz, bVar.nDA, bVar.nDE, bVar.nDF, bVar.neJ, bVar.lKi, 1, bVar.gPG, bVar.nDH, bVar.nDJ, bVar.nDI);
            } else if (bVar.nDG == 19) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.nDz, bVar.nDA, bVar.nDE, bVar.nDF, bVar.neJ, bVar.lKi, 2, bVar.gPG, bVar.nDH, bVar.nDJ, bVar.nDI);
            }
            w.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", new Object[]{Long.valueOf(bg.aB(bVar.nDD)), Integer.valueOf(bVar.nDz.length), Integer.valueOf(bVar.nDA.length), Integer.valueOf(bVar.nDC)});
            this.nDK.a(this.nDL);
            j.nEA.x(this.nDL.nDz);
        }
    }

    public interface a {
        void a(b bVar);
    }

    public b(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) {
        this.nDG = i3;
        this.neJ = i4;
        this.lKi = i5;
        this.nDE = i;
        this.nDF = i2;
        this.nDJ = z2;
        this.nDI = z;
        this.gPG = i6;
        this.nDz = bArr;
        this.nDB = bArr.length;
        this.nDA = j.nEA.h(Integer.valueOf(((i4 * i5) * 3) / 2));
    }
}
