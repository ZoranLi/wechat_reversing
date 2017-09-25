package com.google.a.a;

import com.tencent.wcdb.FileUtils;

public final class a {
    private int aIg;
    private int aIh;
    private int aIi;
    private int aIj;
    private int aIk = Integer.MAX_VALUE;
    private int aIl;
    private int aIm = 64;
    private int aIn = 67108864;
    private final byte[] buffer;
    private int bufferSize;

    public final int mK() {
        if ((this.aIi == this.bufferSize ? 1 : 0) != 0) {
            this.aIj = 0;
            return 0;
        }
        this.aIj = mL();
        if (this.aIj != 0) {
            return this.aIj;
        }
        throw d.mT();
    }

    public final void cy(int i) {
        if (this.aIj != i) {
            throw d.mU();
        }
    }

    public final boolean cz(int i) {
        switch (g.cK(i)) {
            case 0:
                mL();
                return true;
            case 1:
                mP();
                mP();
                mP();
                mP();
                mP();
                mP();
                mP();
                mP();
                return true;
            case 2:
                cE(mL());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                mP();
                mP();
                mP();
                mP();
                return true;
            default:
                throw d.mV();
        }
        int mK;
        do {
            mK = mK();
            if (mK != 0) {
            }
            cy(g.au(g.cL(i), 4));
            return true;
        } while (cz(mK));
        cy(g.au(g.cL(i), 4));
        return true;
    }

    public final String readString() {
        int mL = mL();
        if (mL > this.bufferSize - this.aIi || mL <= 0) {
            return new String(cD(mL), "UTF-8");
        }
        String str = new String(this.buffer, this.aIi, mL, "UTF-8");
        this.aIi = mL + this.aIi;
        return str;
    }

    public final void a(e eVar) {
        int mL = mL();
        if (this.aIl >= this.aIm) {
            throw d.mW();
        }
        mL = cA(mL);
        this.aIl++;
        eVar.a(this);
        cy(0);
        this.aIl--;
        cB(mL);
    }

    public final byte[] readBytes() {
        int mL = mL();
        if (mL > this.bufferSize - this.aIi || mL <= 0) {
            return cD(mL);
        }
        Object obj = new byte[mL];
        System.arraycopy(this.buffer, this.aIi, obj, 0, mL);
        this.aIi = mL + this.aIi;
        return obj;
    }

    public final int mL() {
        byte mP = mP();
        if (mP >= (byte) 0) {
            return mP;
        }
        int i = mP & 127;
        byte mP2 = mP();
        if (mP2 >= (byte) 0) {
            return i | (mP2 << 7);
        }
        i |= (mP2 & 127) << 7;
        mP2 = mP();
        if (mP2 >= (byte) 0) {
            return i | (mP2 << 14);
        }
        i |= (mP2 & 127) << 14;
        mP2 = mP();
        if (mP2 >= (byte) 0) {
            return i | (mP2 << 21);
        }
        i |= (mP2 & 127) << 21;
        mP2 = mP();
        i |= mP2 << 28;
        if (mP2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (mP() >= (byte) 0) {
                return i;
            }
        }
        throw d.mS();
    }

    public final long mM() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte mP = mP();
            j |= ((long) (mP & 127)) << i;
            if ((mP & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw d.mS();
    }

    a(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aIg = 0;
        this.bufferSize = i2 + 0;
        this.aIi = 0;
    }

    public final int cA(int i) {
        if (i < 0) {
            throw d.mR();
        }
        int i2 = this.aIi + i;
        int i3 = this.aIk;
        if (i2 > i3) {
            throw d.mQ();
        }
        this.aIk = i2;
        mN();
        return i3;
    }

    private void mN() {
        this.bufferSize += this.aIh;
        int i = this.bufferSize;
        if (i > this.aIk) {
            this.aIh = i - this.aIk;
            this.bufferSize -= this.aIh;
            return;
        }
        this.aIh = 0;
    }

    public final void cB(int i) {
        this.aIk = i;
        mN();
    }

    public final int mO() {
        if (this.aIk == Integer.MAX_VALUE) {
            return -1;
        }
        return this.aIk - this.aIi;
    }

    public final int getPosition() {
        return this.aIi - this.aIg;
    }

    public final void cC(int i) {
        if (i > this.aIi - this.aIg) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.aIi - this.aIg));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.aIi = this.aIg + i;
        }
    }

    private byte mP() {
        if (this.aIi == this.bufferSize) {
            throw d.mQ();
        }
        byte[] bArr = this.buffer;
        int i = this.aIi;
        this.aIi = i + 1;
        return bArr[i];
    }

    private byte[] cD(int i) {
        if (i < 0) {
            throw d.mR();
        } else if (this.aIi + i > this.aIk) {
            cE(this.aIk - this.aIi);
            throw d.mQ();
        } else if (i <= this.bufferSize - this.aIi) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aIi, obj, 0, i);
            this.aIi += i;
            return obj;
        } else {
            throw d.mQ();
        }
    }

    private void cE(int i) {
        if (i < 0) {
            throw d.mR();
        } else if (this.aIi + i > this.aIk) {
            cE(this.aIk - this.aIi);
            throw d.mQ();
        } else if (i <= this.bufferSize - this.aIi) {
            this.aIi += i;
        } else {
            throw d.mQ();
        }
    }
}
