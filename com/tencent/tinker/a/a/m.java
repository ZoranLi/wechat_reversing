package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m {
    private int type;
    protected final a xcs;
    public int xct;
    private int xcu;

    public m(a aVar, int i) {
        this.type = -1;
        this.xcs = aVar;
        this.type = i;
    }

    public m(k kVar, int i) {
        this(new a(kVar) {
            private int position = 0;
            final /* synthetic */ k xcr;

            {
                this.xcr = r2;
            }

            public final byte readByte() {
                byte[] bArr = this.xcr.data;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            }
        }, i);
    }

    public final int cgt() {
        if (this.type == -1) {
            int readByte = this.xcs.readByte() & 255;
            this.type = readByte & 31;
            this.xcu = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public final int cgu() {
        Dj(28);
        this.type = -1;
        return o.b(this.xcs);
    }

    public final int cgv() {
        Dj(29);
        this.type = -1;
        this.xct = o.b(this.xcs);
        return o.b(this.xcs);
    }

    public final int cgw() {
        return o.b(this.xcs);
    }

    public final byte readByte() {
        Dj(0);
        this.type = -1;
        return (byte) l.a(this.xcs, this.xcu);
    }

    public final short readShort() {
        Dj(2);
        this.type = -1;
        return (short) l.a(this.xcs, this.xcu);
    }

    public final char readChar() {
        Dj(3);
        this.type = -1;
        return (char) l.a(this.xcs, this.xcu, false);
    }

    public final int readInt() {
        Dj(4);
        this.type = -1;
        return l.a(this.xcs, this.xcu);
    }

    public final long readLong() {
        Dj(6);
        this.type = -1;
        a aVar = this.xcs;
        int i = this.xcu;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float readFloat() {
        Dj(16);
        this.type = -1;
        return Float.intBitsToFloat(l.a(this.xcs, this.xcu, true));
    }

    public final double readDouble() {
        Dj(17);
        this.type = -1;
        a aVar = this.xcs;
        long j = 0;
        for (int i = this.xcu; i >= 0; i--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int cgx() {
        Dj(23);
        this.type = -1;
        return l.a(this.xcs, this.xcu, false);
    }

    public final int cgy() {
        Dj(24);
        this.type = -1;
        return l.a(this.xcs, this.xcu, false);
    }

    public final int cgz() {
        Dj(25);
        this.type = -1;
        return l.a(this.xcs, this.xcu, false);
    }

    public final int cgA() {
        Dj(27);
        this.type = -1;
        return l.a(this.xcs, this.xcu, false);
    }

    public final int cgB() {
        Dj(26);
        this.type = -1;
        return l.a(this.xcs, this.xcu, false);
    }

    public final void cgC() {
        Dj(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        Dj(31);
        this.type = -1;
        return this.xcu != 0;
    }

    public final void skipValue() {
        int i = 0;
        int cgu;
        switch (cgt()) {
            case 0:
                readByte();
                return;
            case 2:
                readShort();
                return;
            case 3:
                readChar();
                return;
            case 4:
                readInt();
                return;
            case 6:
                readLong();
                return;
            case 16:
                readFloat();
                return;
            case 17:
                readDouble();
                return;
            case 23:
                cgx();
                return;
            case 24:
                cgy();
                return;
            case 25:
                cgz();
                return;
            case 26:
                cgB();
                return;
            case 27:
                cgA();
                return;
            case 28:
                cgu = cgu();
                while (i < cgu) {
                    skipValue();
                    i++;
                }
                return;
            case JsApiChooseImage.CTRL_INDEX /*29*/:
                cgu = cgv();
                while (i < cgu) {
                    o.b(this.xcs);
                    skipValue();
                    i++;
                }
                return;
            case 30:
                cgC();
                return;
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                readBoolean();
                return;
            default:
                throw new j("Unexpected type: " + Integer.toHexString(this.type));
        }
    }

    private void Dj(int i) {
        if (cgt() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(cgt())}));
        }
    }
}
