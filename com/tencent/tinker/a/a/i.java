package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import java.util.zip.Adler32;

public final class i {
    static final short[] xce = new short[0];
    public final t xcf = new t();
    public final f xcg = new f();
    private final g xch = new g();
    private final h xci = new h();
    private final d xcj = new d();
    private final b xck = new b();
    private final c xcl = new c();
    private final a xcm = new a();
    public ByteBuffer xcn;
    private int xco = 0;
    private byte[] xcp = null;

    private final class a extends AbstractList<f> implements RandomAccess {
        final /* synthetic */ i xcq;

        private a(i iVar) {
            this.xcq = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.eC(i, this.xcq.xcf.xcH.size);
            return this.xcq.Dh(this.xcq.xcf.xcH.dyd + (i * 32)).cgk();
        }

        public final int size() {
            return this.xcq.xcf.xcH.size;
        }
    }

    private final class b extends AbstractList<n> implements RandomAccess {
        final /* synthetic */ i xcq;

        private b(i iVar) {
            this.xcq = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.eC(i, this.xcq.xcf.xcF.size);
            return this.xcq.Dh(this.xcq.xcf.xcF.dyd + (i * 8)).cgh();
        }

        public final int size() {
            return this.xcq.xcf.xcF.size;
        }
    }

    private final class c extends AbstractList<p> implements RandomAccess {
        final /* synthetic */ i xcq;

        private c(i iVar) {
            this.xcq = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.eC(i, this.xcq.xcf.xcG.size);
            return this.xcq.Dh(this.xcq.xcf.xcG.dyd + (i * 8)).cgi();
        }

        public final int size() {
            return this.xcq.xcf.xcG.size;
        }
    }

    private final class d extends AbstractList<r> implements RandomAccess {
        final /* synthetic */ i xcq;

        private d(i iVar) {
            this.xcq = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            i.eC(i, this.xcq.xcf.xcE.size);
            return this.xcq.Dh(this.xcq.xcf.xcE.dyd + (i * 12)).cgj();
        }

        public final int size() {
            return this.xcq.xcf.xcE.size;
        }
    }

    private final class f extends AbstractList<String> implements RandomAccess {
        final /* synthetic */ i xcq;

        private f(i iVar) {
            this.xcq = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            return pP(i);
        }

        public final String pP(int i) {
            i.eC(i, this.xcq.xcf.xcC.size);
            return this.xcq.Dh(this.xcq.Dh(this.xcq.xcf.xcC.dyd + (i * 4)).xcn.getInt()).cgf().value;
        }

        public final int size() {
            return this.xcq.xcf.xcC.size;
        }
    }

    private final class g extends AbstractList<Integer> implements RandomAccess {
        final /* synthetic */ i xcq;

        private g(i iVar) {
            this.xcq = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            return Integer.valueOf(this.xcq.Di(i));
        }

        public final int size() {
            return this.xcq.xcf.xcD.size;
        }
    }

    private final class h extends AbstractList<String> implements RandomAccess {
        final /* synthetic */ i xcq;

        private h(i iVar) {
            this.xcq = iVar;
        }

        public final /* synthetic */ Object get(int i) {
            return this.xcq.xcg.pP(this.xcq.Di(i));
        }

        public final int size() {
            return this.xcq.xcf.xcD.size;
        }
    }

    public final class e extends com.tencent.tinker.a.a.a.a {
        private final String name;
        final /* synthetic */ i xcq;

        public e(i iVar, String str, ByteBuffer byteBuffer) {
            this.xcq = iVar;
            super(byteBuffer);
            this.name = str;
        }

        public final s cgf() {
            a(this.xcq.xcf.xcO, false);
            return super.cgf();
        }

        public final u cgg() {
            a(this.xcq.xcf.xcJ, false);
            return super.cgg();
        }

        public final n cgh() {
            a(this.xcq.xcf.xcF, false);
            return super.cgh();
        }

        public final p cgi() {
            a(this.xcq.xcf.xcG, false);
            return super.cgi();
        }

        public final r cgj() {
            a(this.xcq.xcf.xcE, false);
            return super.cgj();
        }

        public final f cgk() {
            a(this.xcq.xcf.xcH, false);
            return super.cgk();
        }

        public final g cgl() {
            a(this.xcq.xcf.xcN, false);
            return super.cgl();
        }

        public final h cgm() {
            a(this.xcq.xcf.xcP, false);
            return super.cgm();
        }

        public final e cgn() {
            a(this.xcq.xcf.xcM, false);
            return super.cgn();
        }

        public final a cgo() {
            a(this.xcq.xcf.xcQ, false);
            return super.cgo();
        }

        public final b cgp() {
            a(this.xcq.xcf.xcL, false);
            return super.cgp();
        }

        public final c cgq() {
            a(this.xcq.xcf.xcK, false);
            return super.cgq();
        }

        public final d cgr() {
            a(this.xcq.xcf.xcS, false);
            return super.cgr();
        }

        public final k cgs() {
            a(this.xcq.xcf.xcR, false);
            return super.cgs();
        }

        private void a(com.tencent.tinker.a.a.t.a aVar, boolean z) {
            if (!aVar.xda) {
                return;
            }
            if (z) {
                super.Dl((((this.xcn.position() + 3) & -4) - this.xcn.position()) * 1);
                while ((this.xcn.position() & 3) != 0) {
                    this.xcn.put((byte) 0);
                }
                if (this.xcn.position() > this.xdg) {
                    this.xdg = this.xcn.position();
                    return;
                }
                return;
            }
            this.xcn.position((this.xcn.position() + 3) & -4);
        }

        public final int a(s sVar) {
            a(this.xcq.xcf.xcO, true);
            return super.a(sVar);
        }

        public final int a(u uVar) {
            a(this.xcq.xcf.xcJ, true);
            return super.a(uVar);
        }

        public final int a(n nVar) {
            a(this.xcq.xcf.xcF, true);
            return super.a(nVar);
        }

        public final int a(p pVar) {
            a(this.xcq.xcf.xcG, true);
            return super.a(pVar);
        }

        public final int a(r rVar) {
            a(this.xcq.xcf.xcE, true);
            return super.a(rVar);
        }

        public final int a(f fVar) {
            a(this.xcq.xcf.xcH, true);
            return super.a(fVar);
        }

        public final int a(g gVar) {
            a(this.xcq.xcf.xcN, true);
            return super.a(gVar);
        }

        public final int a(h hVar) {
            a(this.xcq.xcf.xcP, true);
            return super.a(hVar);
        }

        public final int a(e eVar) {
            a(this.xcq.xcf.xcM, true);
            return super.a(eVar);
        }

        public final int a(a aVar) {
            a(this.xcq.xcf.xcQ, true);
            return super.a(aVar);
        }

        public final int a(b bVar) {
            a(this.xcq.xcf.xcL, true);
            return super.a(bVar);
        }

        public final int a(c cVar) {
            a(this.xcq.xcf.xcK, true);
            return super.a(cVar);
        }

        public final int a(d dVar) {
            a(this.xcq.xcf.xcS, true);
            return super.a(dVar);
        }

        public final int a(k kVar) {
            a(this.xcq.xcf.xcR, true);
            return super.a(kVar);
        }
    }

    public i(int i) {
        this.xcn = ByteBuffer.wrap(new byte[i]);
        this.xcn.order(ByteOrder.LITTLE_ENDIAN);
        this.xcf.fileSize = i;
    }

    public i(InputStream inputStream) {
        Object obj = -1;
        this.xcn = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.b(inputStream, 0));
        this.xcn.order(ByteOrder.LITTLE_ENDIAN);
        t tVar = this.xcf;
        com.tencent.tinker.a.a.a.a a = a(tVar.xcB);
        byte[] Dm = a.Dm(8);
        if (Dm.length == 8 && Dm[0] == (byte) 100 && Dm[1] == (byte) 101 && Dm[2] == (byte) 120 && Dm[3] == (byte) 10 && Dm[7] == (byte) 0) {
            String str = ((char) Dm[4]) + ((char) Dm[5]) + ((char) Dm[6]);
            if (str.equals("036")) {
                obj = 14;
            } else if (str.equals("035")) {
                int i = 13;
            }
        }
        if (obj != 13) {
            throw new j("Unexpected magic: " + Arrays.toString(Dm));
        }
        tVar.xcU = a.xcn.getInt();
        tVar.xcp = a.Dm(20);
        tVar.fileSize = a.xcn.getInt();
        i = a.xcn.getInt();
        if (i != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            throw new j("Unexpected header: 0x" + Integer.toHexString(i));
        }
        i = a.xcn.getInt();
        if (i != 305419896) {
            throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
        }
        tVar.xcV = a.xcn.getInt();
        tVar.xcW = a.xcn.getInt();
        tVar.xcI.dyd = a.xcn.getInt();
        if (tVar.xcI.dyd == 0) {
            throw new j("Cannot merge dex files that do not contain a map");
        }
        tVar.xcC.size = a.xcn.getInt();
        tVar.xcC.dyd = a.xcn.getInt();
        tVar.xcD.size = a.xcn.getInt();
        tVar.xcD.dyd = a.xcn.getInt();
        tVar.xcE.size = a.xcn.getInt();
        tVar.xcE.dyd = a.xcn.getInt();
        tVar.xcF.size = a.xcn.getInt();
        tVar.xcF.dyd = a.xcn.getInt();
        tVar.xcG.size = a.xcn.getInt();
        tVar.xcG.dyd = a.xcn.getInt();
        tVar.xcH.size = a.xcn.getInt();
        tVar.xcH.dyd = a.xcn.getInt();
        tVar.xcX = a.xcn.getInt();
        tVar.xcY = a.xcn.getInt();
        tVar.a(Dh(tVar.xcI.dyd));
        tVar.cgD();
    }

    public static void eC(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public final e Dh(int i) {
        if (i < 0 || i >= this.xcn.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.xcn.capacity());
        }
        ByteBuffer duplicate = this.xcn.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.xcn.capacity());
        return new e(this, "temp-section", duplicate);
    }

    public final e a(com.tencent.tinker.a.a.t.a aVar) {
        int i = aVar.dyd;
        if (i < 0 || i >= this.xcn.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.xcn.capacity());
        }
        ByteBuffer duplicate = this.xcn.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + aVar.xdb);
        return new e(this, "section", duplicate);
    }

    public final byte[] mj(boolean z) {
        if (this.xcp != null && !z) {
            return this.xcp;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.xcn.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.xcp = digest;
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final void cge() {
        Dh(12).write(mj(true));
        e Dh = Dh(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.xcn.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        Dh.writeInt((int) adler32.getValue());
    }

    public final int Di(int i) {
        eC(i, this.xcf.xcD.size);
        return this.xcn.getInt(this.xcf.xcD.dyd + (i * 4));
    }
}
