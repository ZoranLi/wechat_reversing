package a.a.a.b.a;

import com.tencent.wcdb.FileUtils;
import java.io.InputStream;
import java.util.LinkedList;

public final class a {
    private int aIh = 0;
    public int aIi;
    public int aIj = 0;
    private int aIk = Integer.MAX_VALUE;
    private int aIn = 67108864;
    public byte[] buffer;
    public int bufferSize;
    private InputStream xmH;
    private int xmI = 0;

    public final double readDouble() {
        byte mP = mP();
        byte mP2 = mP();
        return Double.longBitsToDouble(((((((((((long) mP2) & 255) << 8) | (((long) mP) & 255)) | ((((long) mP()) & 255) << 16)) | ((((long) mP()) & 255) << 24)) | ((((long) mP()) & 255) << 32)) | ((((long) mP()) & 255) << 40)) | ((((long) mP()) & 255) << 48)) | ((((long) mP()) & 255) << 56));
    }

    public final float readFloat() {
        return Float.intBitsToFloat((((mP() & 255) | ((mP() & 255) << 8)) | ((mP() & 255) << 16)) | ((mP() & 255) << 24));
    }

    public final LinkedList<byte[]> En(int i) {
        LinkedList<byte[]> linkedList = new LinkedList();
        int mL = mL();
        try {
            Object obj = new byte[mL];
            System.arraycopy(this.buffer, this.aIi, obj, 0, mL);
            linkedList.add(obj);
            this.aIi = mL + this.aIi;
            mL = this.aIi;
            if (this.aIi == this.bufferSize) {
                return linkedList;
            }
            int[] Eo = Eo(mL);
            mL = Eo[0];
            while (a.a.a.b.a.cL(mL) == i) {
                this.aIi = Eo[1];
                mL = mL();
                obj = new byte[mL];
                System.arraycopy(this.buffer, this.aIi, obj, 0, mL);
                linkedList.add(obj);
                this.aIi = mL + this.aIi;
                if (this.aIi == this.bufferSize) {
                    break;
                }
                Eo = Eo(this.aIi);
                mL = Eo[0];
            }
            return linkedList;
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("alloc bytes:" + mL);
        }
    }

    public final String readString() {
        int mL = mL();
        if (mL >= this.bufferSize - this.aIi || mL <= 0) {
            return new String(cD(mL), "UTF-8");
        }
        String str = new String(this.buffer, this.aIi, mL, "UTF-8");
        this.aIi = mL + this.aIi;
        return str;
    }

    private int[] Eo(int i) {
        byte b = this.buffer[i];
        int i2 = i + 1;
        if (b >= (byte) 0) {
            return new int[]{b, i2};
        }
        int i3;
        int i4 = b & 127;
        byte b2 = this.buffer[i2];
        if (b2 >= (byte) 0) {
            i3 = i2 + 1;
            i4 |= b2 << 7;
        } else {
            i4 |= (b2 & 127) << 7;
            b2 = this.buffer[i2];
            if (b2 >= (byte) 0) {
                i3 = i2 + 1;
                i4 |= b2 << 14;
            } else {
                i4 |= (b2 & 127) << 14;
                b2 = this.buffer[i2];
                if (b2 >= (byte) 0) {
                    i3 = i2 + 1;
                    i4 |= b2 << 21;
                } else {
                    i4 |= (b2 & 127) << 21;
                    b2 = this.buffer[i2];
                    i4 |= b2 << 28;
                    i3 = i2 + 1;
                    if (b2 < (byte) 0) {
                        for (i4 = 0; i4 < 5; i4++) {
                            if (this.buffer[i3] >= (byte) 0) {
                                i3++;
                                return new int[]{b2, i3};
                            }
                        }
                        throw b.cig();
                    }
                }
            }
        }
        return new int[]{i4, i3};
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
        throw b.cig();
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
        throw b.cig();
    }

    public a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.bufferSize = i + 0;
        this.aIi = 0;
        this.xmH = null;
    }

    public final boolean mn(boolean z) {
        if (this.aIi < this.bufferSize) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.xmI + this.bufferSize != this.aIk) {
            this.xmI += this.bufferSize;
            this.aIi = 0;
            this.bufferSize = this.xmH == null ? -1 : this.xmH.read(this.buffer);
            if (this.bufferSize == -1) {
                this.bufferSize = 0;
                if (!z) {
                    return false;
                }
                throw b.cie();
            }
            this.bufferSize += this.aIh;
            int i = this.xmI + this.bufferSize;
            if (i > this.aIk) {
                this.aIh = i - this.aIk;
                this.bufferSize -= this.aIh;
            } else {
                this.aIh = 0;
            }
            i = (this.xmI + this.bufferSize) + this.aIh;
            if (i <= this.aIn && i >= 0) {
                return true;
            }
            throw b.cii();
        } else if (!z) {
            return false;
        } else {
            throw b.cie();
        }
    }

    private byte mP() {
        if (this.aIi == this.bufferSize) {
            mn(true);
        }
        byte[] bArr = this.buffer;
        int i = this.aIi;
        this.aIi = i + 1;
        return bArr[i];
    }

    public final byte[] cD(int i) {
        if (i < 0) {
            throw b.cif();
        } else if ((this.xmI + this.aIi) + i > this.aIk) {
            cE((this.aIk - this.xmI) - this.aIi);
            throw b.cie();
        } else if (i <= this.bufferSize - this.aIi) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aIi, obj, 0, i);
            this.aIi += i;
            return obj;
        } else if (i < 2048) {
            Object obj2 = new byte[i];
            r0 = this.bufferSize - this.aIi;
            System.arraycopy(this.buffer, this.aIi, obj2, 0, r0);
            this.aIi = this.bufferSize;
            mn(true);
            while (i - r0 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, obj2, r0, this.bufferSize);
                r0 += this.bufferSize;
                this.aIi = this.bufferSize;
                mn(true);
            }
            System.arraycopy(this.buffer, 0, obj2, r0, i - r0);
            this.aIi = i - r0;
            return obj2;
        } else {
            int read;
            int i2 = this.aIi;
            int i3 = this.bufferSize;
            this.xmI += this.bufferSize;
            this.aIi = 0;
            this.bufferSize = 0;
            r0 = i - (i3 - i2);
            LinkedList linkedList = new LinkedList();
            int i4 = r0;
            while (i4 > 0) {
                Object obj3 = new byte[Math.min(i4, 2048)];
                r0 = 0;
                while (r0 < obj3.length) {
                    read = this.xmH == null ? -1 : this.xmH.read(obj3, r0, obj3.length - r0);
                    if (read == -1) {
                        throw b.cie();
                    }
                    this.xmI += read;
                    r0 += read;
                }
                r0 = i4 - obj3.length;
                linkedList.add(obj3);
                i4 = r0;
            }
            Object obj4 = new byte[i];
            r0 = i3 - i2;
            System.arraycopy(this.buffer, i2, obj4, 0, r0);
            int i5 = r0;
            for (read = 0; read < linkedList.size(); read++) {
                byte[] bArr = (byte[]) linkedList.get(read);
                System.arraycopy(bArr, 0, obj4, i5, bArr.length);
                i5 += bArr.length;
            }
            return obj4;
        }
    }

    private void cE(int i) {
        if (i < 0) {
            throw b.cif();
        } else if ((this.xmI + this.aIi) + i > this.aIk) {
            cE((this.aIk - this.xmI) - this.aIi);
            throw b.cie();
        } else if (i < this.bufferSize - this.aIi) {
            this.aIi += i;
        } else {
            int i2 = this.bufferSize - this.aIi;
            this.xmI += i2;
            this.aIi = 0;
            this.bufferSize = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.xmH == null ? -1 : (int) this.xmH.skip((long) (i - i3));
                if (i2 <= 0) {
                    throw b.cie();
                }
                i3 += i2;
                this.xmI = i2 + this.xmI;
            }
        }
    }
}
