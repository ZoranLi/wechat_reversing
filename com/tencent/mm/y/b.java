package com.tencent.mm.y;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bah;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class b extends i {
    public int fYs = 0;
    public b hsj = null;
    public c hsk = null;
    public int hsl;
    public String uri;

    public static class a {
        public int hsl = 396;
        public com.tencent.mm.bd.a hsm;
        public com.tencent.mm.bd.a hsn;
        public int hso = 0;
        public int hsp = 0;
        public boolean hsq = true;
        public String uri;

        public final b BE() {
            if (this.hsm != null && this.hsn != null && !bg.mA(this.uri) && this.hsl > 0 && this.hso != Integer.MIN_VALUE && this.hsp != Integer.MIN_VALUE) {
                return new b(this.hsm, this.hsn, this.uri, this.hsl, this.hso, this.hsp, this.hsq);
            }
            throw new IllegalArgumentException();
        }
    }

    public static final class b extends d implements com.tencent.mm.protocal.k.b {
        public int cmdId;
        private int hsl;
        public com.tencent.mm.bd.a hsr;
        private boolean hss;

        public b(com.tencent.mm.bd.a aVar, int i, int i2, boolean z) {
            this.hsr = aVar;
            this.hsl = i;
            this.cmdId = i2;
            this.hss = z;
        }

        public final int getCmdId() {
            return this.cmdId;
        }

        public final int zi() {
            return this.hsl;
        }

        public final byte[] zh() {
            if (this.hsr instanceof avh) {
                ((avh) this.hsr).tYN = k.a(this);
            }
            return this.hsr.toByteArray();
        }
    }

    public static final class c extends e implements com.tencent.mm.protocal.k.c {
        public int cmdId;
        public com.tencent.mm.bd.a hsr = null;
        private boolean hss;

        public c(com.tencent.mm.bd.a aVar, int i, boolean z) {
            this.hsr = aVar;
            this.cmdId = i;
            this.hss = z;
        }

        public final int y(byte[] bArr) {
            this.hsr = this.hsr.aD(bArr);
            if (this.hsr instanceof bah) {
                return ((bah) this.hsr).getRet();
            }
            k.a(this, ((avp) this.hsr).tZe);
            return ((avp) this.hsr).tZe.thX;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    protected final /* bridge */ /* synthetic */ d zf() {
        return this.hsj;
    }

    public final /* bridge */ /* synthetic */ e zg() {
        return this.hsk;
    }

    public b(com.tencent.mm.bd.a aVar, com.tencent.mm.bd.a aVar2, String str, int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        if (z && (aVar instanceof avh)) {
            z2 = true;
        }
        this.hsj = new b(aVar, i, i2, z2);
        this.hsk = new c(aVar2, i3, z);
        this.uri = str;
        this.hsl = i;
    }

    public final int getType() {
        return this.hsl;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void a(ac acVar) {
        this.hsj.sZA = acVar;
    }

    public final int BD() {
        return this.fYs;
    }
}
