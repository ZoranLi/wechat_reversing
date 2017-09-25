package com.tencent.tinker.a.a.a;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.u;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a implements com.tencent.tinker.a.a.b.a, b {
    private static final short[] xce = new short[0];
    private static final g.b[] xde = new g.b[0];
    private static final com.tencent.tinker.a.a.g.a[] xdf = new com.tencent.tinker.a.a.g.a[0];
    public ByteBuffer xcn;
    public int xdg;
    private boolean xdh;

    public a() {
        this.xcn = ByteBuffer.allocate(512);
        this.xcn.order(ByteOrder.LITTLE_ENDIAN);
        this.xdg = this.xcn.position();
        this.xcn.limit(this.xcn.capacity());
        this.xdh = true;
    }

    public a(ByteBuffer byteBuffer) {
        this.xcn = byteBuffer;
        this.xcn.order(ByteOrder.LITTLE_ENDIAN);
        this.xdg = byteBuffer.limit();
        this.xdh = false;
    }

    public final void Dl(int i) {
        if (this.xcn.position() + i > this.xcn.limit() && this.xdh) {
            Object array = this.xcn.array();
            Object obj = new byte[((array.length + i) + (array.length >> 1))];
            System.arraycopy(array, 0, obj, 0, this.xcn.position());
            int position = this.xcn.position();
            this.xcn = ByteBuffer.wrap(obj);
            this.xcn.order(ByteOrder.LITTLE_ENDIAN);
            this.xcn.position(position);
            this.xcn.limit(this.xcn.capacity());
        }
    }

    public final byte readByte() {
        return this.xcn.get();
    }

    private int readUnsignedShort() {
        return this.xcn.getShort() & 65535;
    }

    public final byte[] Dm(int i) {
        byte[] bArr = new byte[i];
        this.xcn.get(bArr);
        return bArr;
    }

    private short[] Dn(int i) {
        if (i == 0) {
            return xce;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.xcn.getShort();
        }
        return sArr;
    }

    private int cgE() {
        return o.b(this);
    }

    private int cgF() {
        return o.b(this) - 1;
    }

    private int cgG() {
        return o.a(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tinker.a.a.s cgf() {
        /*
        r9 = this;
        r0 = 0;
        r8 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = r9.xcn;
        r2 = r1.position();
        r3 = com.tencent.tinker.a.a.o.b(r9);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4 = new char[r3];	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x000f:
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r1 & 255;
        r5 = (char) r1;	 Catch:{ UTFDataFormatException -> 0x0049 }
        if (r5 != 0) goto L_0x0050;
    L_0x0018:
        r1 = new java.lang.String;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r5 = 0;
        r1.<init>(r4, r5, r0);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0 = r1.length();	 Catch:{ UTFDataFormatException -> 0x0049 }
        if (r0 == r3) goto L_0x00be;
    L_0x0024:
        r0 = new com.tencent.tinker.a.a.j;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4 = "Declared length ";
        r2.<init>(r4);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r2 = r2.append(r3);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r3 = " doesn't match decoded length of ";
        r2 = r2.append(r3);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r1.length();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r2.append(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r1.toString();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x0049:
        r0 = move-exception;
        r1 = new com.tencent.tinker.a.a.j;
        r1.<init>(r0);
        throw r1;
    L_0x0050:
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        if (r5 >= r8) goto L_0x0057;
    L_0x0054:
        r0 = r0 + 1;
        goto L_0x000f;
    L_0x0057:
        r1 = r5 & 224;
        r6 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        if (r1 != r6) goto L_0x007e;
    L_0x005d:
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r6 = r1 & 255;
        r1 = r6 & 192;
        if (r1 == r8) goto L_0x0070;
    L_0x0067:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = "bad second byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x0070:
        r1 = r0 + 1;
        r5 = r5 & 31;
        r5 = r5 << 6;
        r6 = r6 & 63;
        r5 = r5 | r6;
        r5 = (char) r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0 = r1;
        goto L_0x000f;
    L_0x007e:
        r1 = r5 & 240;
        r6 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        if (r1 != r6) goto L_0x00b5;
    L_0x0084:
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r6 = r1 & 255;
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r7 = r1 & 255;
        r1 = r6 & 192;
        if (r1 != r8) goto L_0x0098;
    L_0x0094:
        r1 = r7 & 192;
        if (r1 == r8) goto L_0x00a1;
    L_0x0098:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = "bad second or third byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x00a1:
        r1 = r0 + 1;
        r5 = r5 & 15;
        r5 = r5 << 12;
        r6 = r6 & 63;
        r6 = r6 << 6;
        r5 = r5 | r6;
        r6 = r7 & 63;
        r5 = r5 | r6;
        r5 = (char) r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0 = r1;
        goto L_0x000f;
    L_0x00b5:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = "bad byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x00be:
        r0 = new com.tencent.tinker.a.a.s;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0.<init>(r2, r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.a.a.a.a.cgf():com.tencent.tinker.a.a.s");
    }

    public u cgg() {
        return new u(this.xcn.position(), Dn(this.xcn.getInt()));
    }

    public n cgh() {
        return new n(this.xcn.position(), readUnsignedShort(), readUnsignedShort(), this.xcn.getInt());
    }

    public p cgi() {
        return new p(this.xcn.position(), readUnsignedShort(), readUnsignedShort(), this.xcn.getInt());
    }

    public r cgj() {
        return new r(this.xcn.position(), this.xcn.getInt(), this.xcn.getInt(), this.xcn.getInt());
    }

    public f cgk() {
        return new f(this.xcn.position(), this.xcn.getInt(), this.xcn.getInt(), this.xcn.getInt(), this.xcn.getInt(), this.xcn.getInt(), this.xcn.getInt(), this.xcn.getInt(), this.xcn.getInt());
    }

    public g cgl() {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        g.b[] bVarArr;
        int position = this.xcn.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int i = this.xcn.getInt();
        short[] Dn = Dn(this.xcn.getInt());
        if (readUnsignedShort4 > 0) {
            int position2;
            int a;
            int i2;
            if ((Dn.length & 1) == 1) {
                skip(2);
            }
            int position3 = this.xcn.position();
            skip(readUnsignedShort4 * 8);
            int position4 = this.xcn.position();
            int b = o.b(this);
            aVarArr = new com.tencent.tinker.a.a.g.a[b];
            for (int i3 = 0; i3 < b; i3++) {
                position2 = this.xcn.position() - position4;
                a = o.a(this);
                int abs = Math.abs(a);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (i2 = 0; i2 < abs; i2++) {
                    iArr[i2] = o.b(this);
                    iArr2[i2] = o.b(this);
                }
                aVarArr[i3] = new com.tencent.tinker.a.a.g.a(iArr, iArr2, a <= 0 ? o.b(this) : -1, position2);
            }
            position4 = this.xcn.position();
            this.xcn.position(position3);
            bVarArr = new g.b[readUnsignedShort4];
            position3 = 0;
            while (position3 < readUnsignedShort4) {
                b = this.xcn.getInt();
                position2 = readUnsignedShort();
                a = readUnsignedShort();
                i2 = 0;
                while (i2 < aVarArr.length) {
                    if (aVarArr[i2].offset == a) {
                        bVarArr[position3] = new g.b(b, position2, i2);
                        position3++;
                    } else {
                        i2++;
                    }
                }
                throw new IllegalArgumentException();
            }
            this.xcn.position(position4);
        } else {
            bVarArr = xde;
            aVarArr = xdf;
        }
        return new g(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, i, Dn, bVarArr, aVarArr);
    }

    public h cgm() {
        final ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        int position = this.xcn.position();
        int b = o.b(this);
        int b2 = o.b(this);
        int[] iArr = new int[b2];
        for (int i = 0; i < b2; i++) {
            iArr[i] = o.b(this) - 1;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
            b anonymousClass1 = new b(this) {
                final /* synthetic */ a xdj;

                public final void writeByte(int i) {
                    byteArrayOutputStream.write(i);
                }
            };
            while (true) {
                byte b3 = this.xcn.get();
                byteArrayOutputStream.write(b3);
                switch (b3) {
                    case (byte) 0:
                        h hVar = new h(position, b, iArr, byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                        }
                        return hVar;
                    case (byte) 1:
                        o.a(anonymousClass1, cgE());
                        break;
                    case (byte) 2:
                        try {
                            o.c(anonymousClass1, cgG());
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            break;
                        }
                    case (byte) 3:
                    case (byte) 4:
                        o.a(anonymousClass1, cgE());
                        o.b(anonymousClass1, cgF());
                        o.b(anonymousClass1, cgF());
                        if (b3 != (byte) 4) {
                            break;
                        }
                        o.b(anonymousClass1, cgF());
                        break;
                    case (byte) 5:
                    case (byte) 6:
                        o.a(anonymousClass1, cgE());
                        break;
                    case (byte) 9:
                        o.b(anonymousClass1, cgF());
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }

    public e cgn() {
        return new e(this.xcn.position(), Do(o.b(this)), Do(o.b(this)), Dp(o.b(this)), Dp(o.b(this)));
    }

    private com.tencent.tinker.a.a.e.a[] Do(int i) {
        int i2 = 0;
        com.tencent.tinker.a.a.e.a[] aVarArr = new com.tencent.tinker.a.a.e.a[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.b(this);
            aVarArr[i2] = new com.tencent.tinker.a.a.e.a(i3, o.b(this));
            i2++;
        }
        return aVarArr;
    }

    private e.b[] Dp(int i) {
        int i2 = 0;
        e.b[] bVarArr = new e.b[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.b(this);
            bVarArr[i2] = new e.b(i3, o.b(this), o.b(this));
            i2++;
        }
        return bVarArr;
    }

    private byte[] Dq(int i) {
        byte[] bArr = new byte[(this.xcn.position() - i)];
        this.xcn.position(i);
        this.xcn.get(bArr);
        return bArr;
    }

    public com.tencent.tinker.a.a.a cgo() {
        int position = this.xcn.position();
        byte b = this.xcn.get();
        int position2 = this.xcn.position();
        new m((com.tencent.tinker.a.a.b.a) this, 29).skipValue();
        return new com.tencent.tinker.a.a.a(position, b, new k(position2, Dq(position2)));
    }

    public com.tencent.tinker.a.a.b cgp() {
        int position = this.xcn.position();
        int i = this.xcn.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.xcn.getInt();
        }
        return new com.tencent.tinker.a.a.b(position, iArr);
    }

    public c cgq() {
        int position = this.xcn.position();
        int i = this.xcn.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.xcn.getInt();
        }
        return new c(position, iArr);
    }

    public d cgr() {
        int i;
        int position = this.xcn.position();
        int i2 = this.xcn.getInt();
        int i3 = this.xcn.getInt();
        int i4 = this.xcn.getInt();
        int i5 = this.xcn.getInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i3, 2});
        for (i = 0; i < i3; i++) {
            iArr[i][0] = this.xcn.getInt();
            iArr[i][1] = this.xcn.getInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i4, 2});
        for (i = 0; i < i4; i++) {
            iArr2[i][0] = this.xcn.getInt();
            iArr2[i][1] = this.xcn.getInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i5, 2});
        for (i = 0; i < i5; i++) {
            iArr3[i][0] = this.xcn.getInt();
            iArr3[i][1] = this.xcn.getInt();
        }
        return new d(position, i2, iArr, iArr2, iArr3);
    }

    public k cgs() {
        int position = this.xcn.position();
        new m((com.tencent.tinker.a.a.b.a) this, 28).skipValue();
        return new k(position, Dq(position));
    }

    private void skip(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.xcn.position(this.xcn.position() + i);
    }

    public final void writeByte(int i) {
        Dl(1);
        this.xcn.put((byte) i);
        if (this.xcn.position() > this.xdg) {
            this.xdg = this.xcn.position();
        }
    }

    public final void writeShort(short s) {
        Dl(2);
        this.xcn.putShort(s);
        if (this.xcn.position() > this.xdg) {
            this.xdg = this.xcn.position();
        }
    }

    private void Dr(int i) {
        short s = (short) i;
        if (i != (65535 & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: " + i);
        }
        writeShort(s);
    }

    public final void writeInt(int i) {
        Dl(4);
        this.xcn.putInt(i);
        if (this.xcn.position() > this.xdg) {
            this.xdg = this.xcn.position();
        }
    }

    public final void write(byte[] bArr) {
        Dl(bArr.length * 1);
        this.xcn.put(bArr);
        if (this.xcn.position() > this.xdg) {
            this.xdg = this.xcn.position();
        }
    }

    public int a(s sVar) {
        int position = this.xcn.position();
        try {
            o.a(this, sVar.value.length());
            String str = sVar.value;
            long j = 0;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                j = (charAt == '\u0000' || charAt > '') ? charAt <= '߿' ? j + 2 : j + 3 : j + 1;
                if (j > 65535) {
                    throw new UTFDataFormatException("String more than 65535 UTF bytes long");
                }
            }
            byte[] bArr = new byte[((int) j)];
            q.a(bArr, 0, str);
            write(bArr);
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public int a(u uVar) {
        int position = this.xcn.position();
        short[] sArr = uVar.xdd;
        writeInt(sArr.length);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        return position;
    }

    public int a(n nVar) {
        int position = this.xcn.position();
        Dr(nVar.xcv);
        Dr(nVar.xbH);
        writeInt(nVar.xcw);
        return position;
    }

    public int a(p pVar) {
        int position = this.xcn.position();
        Dr(pVar.xcv);
        Dr(pVar.xcx);
        writeInt(pVar.xcw);
        return position;
    }

    public int a(r rVar) {
        int position = this.xcn.position();
        writeInt(rVar.xcy);
        writeInt(rVar.xcz);
        writeInt(rVar.xcA);
        return position;
    }

    public int a(f fVar) {
        int position = this.xcn.position();
        writeInt(fVar.xbH);
        writeInt(fVar.xbE);
        writeInt(fVar.xbI);
        writeInt(fVar.xbJ);
        writeInt(fVar.xbK);
        writeInt(fVar.xbL);
        writeInt(fVar.xbM);
        writeInt(fVar.xbN);
        return position;
    }

    public int a(g gVar) {
        int length;
        int position;
        int i = 0;
        int position2 = this.xcn.position();
        Dr(gVar.xbO);
        Dr(gVar.xbP);
        Dr(gVar.xbQ);
        Dr(gVar.xbT.length);
        writeInt(gVar.xbR);
        writeInt(gVar.xbS.length);
        short[] sArr = gVar.xbS;
        Dl(sArr.length * 2);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        if (this.xcn.position() > this.xdg) {
            this.xdg = this.xcn.position();
        }
        if (gVar.xbT.length > 0) {
            if ((gVar.xbS.length & 1) == 1) {
                writeShort((short) 0);
            }
            position = this.xcn.position();
            length = gVar.xbT.length * 8;
            Dl(length * 1);
            skip(length);
            com.tencent.tinker.a.a.g.a[] aVarArr = gVar.xbU;
            int position3 = this.xcn.position();
            o.a(this, aVarArr.length);
            int[] iArr = new int[aVarArr.length];
            for (length = 0; length < aVarArr.length; length++) {
                iArr[length] = this.xcn.position() - position3;
                com.tencent.tinker.a.a.g.a aVar = aVarArr[length];
                int i2 = aVar.xbX;
                int[] iArr2 = aVar.xbV;
                int[] iArr3 = aVar.xbW;
                if (i2 != -1) {
                    o.c(this, -iArr2.length);
                } else {
                    o.c(this, iArr2.length);
                }
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    o.a(this, iArr2[i3]);
                    o.a(this, iArr3[i3]);
                }
                if (i2 != -1) {
                    o.a(this, i2);
                }
            }
            length = this.xcn.position();
            this.xcn.position(position);
            g.b[] bVarArr = gVar.xbT;
            position = bVarArr.length;
            while (i < position) {
                g.b bVar = bVarArr[i];
                writeInt(bVar.xbY);
                Dr(bVar.xbZ);
                Dr(iArr[bVar.xca]);
                i++;
            }
            this.xcn.position(length);
        }
        return position2;
    }

    public int a(h hVar) {
        int position = this.xcn.position();
        o.a(this, hVar.xcb);
        o.a(this, r2);
        for (int i : hVar.xcc) {
            o.a(this, i + 1);
        }
        write(hVar.xcd);
        return position;
    }

    public int a(e eVar) {
        int position = this.xcn.position();
        o.a(this, eVar.xbz.length);
        o.a(this, eVar.xbA.length);
        o.a(this, eVar.xbB.length);
        o.a(this, eVar.xbC.length);
        a(eVar.xbz);
        a(eVar.xbA);
        a(eVar.xbB);
        a(eVar.xbC);
        return position;
    }

    private void a(com.tencent.tinker.a.a.e.a[] aVarArr) {
        int i = 0;
        int length = aVarArr.length;
        int i2 = 0;
        while (i < length) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            o.a(this, aVar.xbD - i2);
            i2 = aVar.xbD;
            o.a(this, aVar.xbE);
            i++;
        }
    }

    private void a(e.b[] bVarArr) {
        int i = 0;
        int length = bVarArr.length;
        int i2 = 0;
        while (i < length) {
            e.b bVar = bVarArr[i];
            o.a(this, bVar.xbF - i2);
            i2 = bVar.xbF;
            o.a(this, bVar.xbE);
            o.a(this, bVar.xbG);
            i++;
        }
    }

    public int a(com.tencent.tinker.a.a.a aVar) {
        int position = this.xcn.position();
        writeByte(aVar.xbr);
        a(aVar.xbs);
        return position;
    }

    public int a(com.tencent.tinker.a.a.b bVar) {
        int position = this.xcn.position();
        writeInt(bVar.xbt.length);
        for (int writeInt : bVar.xbt) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(c cVar) {
        int position = this.xcn.position();
        writeInt(cVar.xbu.length);
        for (int writeInt : cVar.xbu) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(d dVar) {
        int position = this.xcn.position();
        writeInt(dVar.xbv);
        writeInt(dVar.xbw.length);
        writeInt(dVar.xbx.length);
        writeInt(dVar.xby.length);
        for (int[] iArr : dVar.xbw) {
            writeInt(iArr[0]);
            writeInt(iArr[1]);
        }
        for (int[] iArr2 : dVar.xbx) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        for (int[] iArr22 : dVar.xby) {
            writeInt(iArr22[0]);
            writeInt(iArr22[1]);
        }
        return position;
    }

    public int a(k kVar) {
        int position = this.xcn.position();
        write(kVar.data);
        return position;
    }
}
