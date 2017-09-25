package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qbar.QbarNative;

public abstract class b {
    protected static int pcZ = 0;
    protected int fFo;
    protected int fFp;
    protected a pcV = null;
    protected byte[] pcW = null;
    protected byte[] pcX = null;
    public String pcY;
    public boolean[] pda = null;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] ifT;
        final /* synthetic */ int pdb;
        final /* synthetic */ Point pdc;
        final /* synthetic */ Rect pdd;
        final /* synthetic */ b pde;

        public AnonymousClass1(b bVar, byte[] bArr, int i, Point point, Rect rect) {
            this.pde = bVar;
            this.ifT = bArr;
            this.pdb = i;
            this.pdc = point;
            this.pdd = rect;
        }

        public final void run() {
            byte[] bArr = this.ifT;
            if (270 == this.pdb) {
                byte[] bArr2 = new byte[this.ifT.length];
                QbarNative.a(bArr2, this.ifT, this.pdc.x, this.pdc.y);
                bArr = new byte[this.ifT.length];
                QbarNative.a(bArr, bArr2, this.pdc.y, this.pdc.x);
                QbarNative.nativeRelease();
            }
            w.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", new Object[]{this.pdc.toString(), this.pdd.toString()});
            if (this.ifT == null || !this.pde.a(r0, this.pdc, this.pdd)) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pdf;

                    {
                        this.pdf = r1;
                    }

                    public final void run() {
                        if (this.pdf.pde.pcV != null) {
                            w.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", new Object[]{this.pdf.pdc.toString(), this.pdf.pdd.toString()});
                            this.pdf.pde.pcV.aYn();
                        }
                    }
                });
            } else {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pdf;

                    {
                        this.pdf = r1;
                    }

                    public final void run() {
                        if (this.pdf.pde.pcV != null) {
                            this.pdf.pde.pcV.a(b.pcZ, this.pdf.pde.pcY, this.pdf.pde.pcX, this.pdf.pde.fFo, this.pdf.pde.fFp);
                        }
                    }
                });
            }
        }
    }

    public interface a {
        public static final boolean[] pdg = new boolean[2];

        void A(Bundle bundle);

        void a(int i, String str, byte[] bArr, int i2, int i3);

        void aYn();
    }

    public abstract boolean a(byte[] bArr, Point point, Rect rect);

    public abstract void aKx();

    public abstract void aYV();

    public b(a aVar) {
        this.pcV = aVar;
    }
}
