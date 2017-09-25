package com.tencent.tinker.c.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.a.a.i;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import com.tencent.tinker.c.a.c.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class a {
    private final c xdA;
    private i<s> xdB;
    private i<Integer> xdC;
    private i<r> xdD;
    private i<n> xdE;
    private i<p> xdF;
    private i<f> xdG;
    private i<u> xdH;
    private i<com.tencent.tinker.a.a.c> xdI;
    private i<b> xdJ;
    private i<e> xdK;
    private i<g> xdL;
    private i<h> xdM;
    private i<com.tencent.tinker.a.a.a> xdN;
    private i<k> xdO;
    private i<d> xdP;
    private final com.tencent.tinker.a.a.i xdx;
    private final com.tencent.tinker.a.a.i xdy;
    private final com.tencent.tinker.c.a.b.a xdz;

    public a(InputStream inputStream, InputStream inputStream2) {
        this(new com.tencent.tinker.a.a.i(inputStream), new com.tencent.tinker.c.a.b.a(inputStream2));
    }

    private a(com.tencent.tinker.a.a.i iVar, com.tencent.tinker.c.a.b.a aVar) {
        this.xdx = iVar;
        this.xdz = aVar;
        this.xdy = new com.tencent.tinker.a.a.i(aVar.xey);
        this.xdA = new c();
    }

    public final void b(OutputStream outputStream) {
        int i = 0;
        byte[] mj = this.xdx.mj(false);
        if (mj == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.xdz == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (com.tencent.tinker.a.a.b.c.l(mj, this.xdz.xeR) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(mj), Arrays.toString(this.xdz.xeR)}));
            }
            t tVar = this.xdy.xcf;
            tVar.xcB.dyd = 0;
            tVar.xcB.size = 1;
            tVar.xcI.size = 1;
            tVar.xcC.dyd = this.xdz.xeA;
            tVar.xcD.dyd = this.xdz.xeB;
            tVar.xcJ.dyd = this.xdz.xeH;
            tVar.xcE.dyd = this.xdz.xeC;
            tVar.xcF.dyd = this.xdz.xeD;
            tVar.xcG.dyd = this.xdz.xeE;
            tVar.xcH.dyd = this.xdz.xeF;
            tVar.xcI.dyd = this.xdz.xeG;
            tVar.xcO.dyd = this.xdz.xeM;
            tVar.xcQ.dyd = this.xdz.xeO;
            tVar.xcL.dyd = this.xdz.xeJ;
            tVar.xcK.dyd = this.xdz.xeI;
            tVar.xcS.dyd = this.xdz.xeQ;
            tVar.xcR.dyd = this.xdz.xeP;
            tVar.xcP.dyd = this.xdz.xeN;
            tVar.xcN.dyd = this.xdz.xeL;
            tVar.xcM.dyd = this.xdz.xeK;
            tVar.fileSize = this.xdz.xey;
            Arrays.sort(tVar.xcT);
            tVar.cgD();
            this.xdB = new com.tencent.tinker.c.a.a.a.n(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdC = new o(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdD = new l(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdE = new j(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdF = new com.tencent.tinker.c.a.a.a.k(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdG = new com.tencent.tinker.c.a.a.a.f(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdH = new com.tencent.tinker.c.a.a.a.p(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdI = new com.tencent.tinker.c.a.a.a.b(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdJ = new com.tencent.tinker.c.a.a.a.c(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdK = new com.tencent.tinker.c.a.a.a.e(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdL = new com.tencent.tinker.c.a.a.a.g(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdM = new com.tencent.tinker.c.a.a.a.h(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdN = new com.tencent.tinker.c.a.a.a.a(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdO = new m(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdP = new com.tencent.tinker.c.a.a.a.d(this.xdz, this.xdx, this.xdy, this.xdA);
            this.xdB.execute();
            this.xdC.execute();
            this.xdH.execute();
            this.xdD.execute();
            this.xdE.execute();
            this.xdF.execute();
            this.xdN.execute();
            this.xdJ.execute();
            this.xdI.execute();
            this.xdP.execute();
            this.xdM.execute();
            this.xdL.execute();
            this.xdK.execute();
            this.xdO.execute();
            this.xdG.execute();
            com.tencent.tinker.a.a.i.e Dh = this.xdy.Dh(tVar.xcB.dyd);
            Dh.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
            Dh.writeInt(tVar.xcU);
            Dh.write(tVar.xcp);
            Dh.writeInt(tVar.fileSize);
            Dh.writeInt(MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            Dh.writeInt(305419896);
            Dh.writeInt(tVar.xcV);
            Dh.writeInt(tVar.xcW);
            Dh.writeInt(tVar.xcI.dyd);
            Dh.writeInt(tVar.xcC.size);
            Dh.writeInt(tVar.xcC.exists() ? tVar.xcC.dyd : 0);
            Dh.writeInt(tVar.xcD.size);
            Dh.writeInt(tVar.xcD.exists() ? tVar.xcD.dyd : 0);
            Dh.writeInt(tVar.xcE.size);
            Dh.writeInt(tVar.xcE.exists() ? tVar.xcE.dyd : 0);
            Dh.writeInt(tVar.xcF.size);
            Dh.writeInt(tVar.xcF.exists() ? tVar.xcF.dyd : 0);
            Dh.writeInt(tVar.xcG.size);
            Dh.writeInt(tVar.xcG.exists() ? tVar.xcG.dyd : 0);
            Dh.writeInt(tVar.xcH.size);
            if (tVar.xcH.exists()) {
                i = tVar.xcH.dyd;
            }
            Dh.writeInt(i);
            Dh.writeInt(tVar.xcX);
            Dh.writeInt(tVar.xcY);
            tVar.b(this.xdy.Dh(tVar.xcI.dyd));
            this.xdy.cge();
            outputStream.write(this.xdy.xcn.array());
            outputStream.flush();
        }
    }
}
