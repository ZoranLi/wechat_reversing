package com.google.android.gms.c;

import com.tencent.wcdb.FileUtils;

public final class aw {
    int aCo;
    int aCp;
    private int aCq;
    int aCr;
    private int aCs;
    private int aCt = Integer.MAX_VALUE;
    private int aCu;
    private int aCv = 64;
    private int aCw = 67108864;
    final byte[] buffer;

    aw(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aCo = 0;
        this.aCp = i2 + 0;
        this.aCr = 0;
    }

    private void ck(int i) {
        if (i < 0) {
            throw bd.lA();
        } else if (this.aCr + i > this.aCt) {
            ck(this.aCt - this.aCr);
            throw bd.lz();
        } else if (i <= this.aCp - this.aCr) {
            this.aCr += i;
        } else {
            throw bd.lz();
        }
    }

    private void lr() {
        this.aCp += this.aCq;
        int i = this.aCp;
        if (i > this.aCt) {
            this.aCq = i - this.aCt;
            this.aCp -= this.aCq;
            return;
        }
        this.aCq = 0;
    }

    private byte lt() {
        if (this.aCr == this.aCp) {
            throw bd.lz();
        }
        byte[] bArr = this.buffer;
        int i = this.aCr;
        this.aCr = i + 1;
        return bArr[i];
    }

    public final void a(be beVar) {
        int lo = lo();
        if (this.aCu >= this.aCv) {
            throw bd.lF();
        }
        lo = cg(lo);
        this.aCu++;
        beVar.a(this);
        ce(0);
        this.aCu--;
        ch(lo);
    }

    public final void ce(int i) {
        if (this.aCs != i) {
            throw bd.lD();
        }
    }

    public final boolean cf(int i) {
        switch (bh.ct(i)) {
            case 0:
                lo();
                return true;
            case 1:
                lq();
                return true;
            case 2:
                ck(lo());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                lp();
                return true;
            default:
                throw bd.lE();
        }
        int ll;
        do {
            ll = ll();
            if (ll != 0) {
            }
            ce(bh.an(bh.cu(i), 4));
            return true;
        } while (cf(ll));
        ce(bh.an(bh.cu(i), 4));
        return true;
    }

    public final int cg(int i) {
        if (i < 0) {
            throw bd.lA();
        }
        int i2 = this.aCr + i;
        int i3 = this.aCt;
        if (i2 > i3) {
            throw bd.lz();
        }
        this.aCt = i2;
        lr();
        return i3;
    }

    public final void ch(int i) {
        this.aCt = i;
        lr();
    }

    public final void ci(int i) {
        if (i > this.aCr - this.aCo) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.aCr - this.aCo));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.aCr = this.aCo + i;
        }
    }

    public final byte[] cj(int i) {
        if (i < 0) {
            throw bd.lA();
        } else if (this.aCr + i > this.aCt) {
            ck(this.aCt - this.aCr);
            throw bd.lz();
        } else if (i <= this.aCp - this.aCr) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aCr, obj, 0, i);
            this.aCr += i;
            return obj;
        } else {
            throw bd.lz();
        }
    }

    public final int getPosition() {
        return this.aCr - this.aCo;
    }

    public final int ll() {
        if ((this.aCr == this.aCp ? 1 : 0) != 0) {
            this.aCs = 0;
            return 0;
        }
        this.aCs = lo();
        if (this.aCs != 0) {
            return this.aCs;
        }
        throw bd.lC();
    }

    public final long lm() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte lt = lt();
            j |= ((long) (lt & 127)) << i;
            if ((lt & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw bd.lB();
    }

    public final boolean ln() {
        return lo() != 0;
    }

    public final int lo() {
        byte lt = lt();
        if (lt >= (byte) 0) {
            return lt;
        }
        int i = lt & 127;
        byte lt2 = lt();
        if (lt2 >= (byte) 0) {
            return i | (lt2 << 7);
        }
        i |= (lt2 & 127) << 7;
        lt2 = lt();
        if (lt2 >= (byte) 0) {
            return i | (lt2 << 14);
        }
        i |= (lt2 & 127) << 14;
        lt2 = lt();
        if (lt2 >= (byte) 0) {
            return i | (lt2 << 21);
        }
        i |= (lt2 & 127) << 21;
        lt2 = lt();
        i |= lt2 << 28;
        if (lt2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (lt() >= (byte) 0) {
                return i;
            }
        }
        throw bd.lB();
    }

    public final int lp() {
        return (((lt() & 255) | ((lt() & 255) << 8)) | ((lt() & 255) << 16)) | ((lt() & 255) << 24);
    }

    public final long lq() {
        byte lt = lt();
        byte lt2 = lt();
        return ((((((((((long) lt2) & 255) << 8) | (((long) lt) & 255)) | ((((long) lt()) & 255) << 16)) | ((((long) lt()) & 255) << 24)) | ((((long) lt()) & 255) << 32)) | ((((long) lt()) & 255) << 40)) | ((((long) lt()) & 255) << 48)) | ((((long) lt()) & 255) << 56);
    }

    public final int ls() {
        if (this.aCt == Integer.MAX_VALUE) {
            return -1;
        }
        return this.aCt - this.aCr;
    }

    public final String readString() {
        int lo = lo();
        if (lo > this.aCp - this.aCr || lo <= 0) {
            return new String(cj(lo), "UTF-8");
        }
        String str = new String(this.buffer, this.aCr, lo, "UTF-8");
        this.aCr = lo + this.aCr;
        return str;
    }
}
