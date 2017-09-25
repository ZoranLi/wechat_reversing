package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;

public final class t {
    public int fileSize;
    public final a xcB = new a(0, true);
    public final a xcC = new a(1, true);
    public final a xcD = new a(2, true);
    public final a xcE = new a(3, true);
    public final a xcF = new a(4, true);
    public final a xcG = new a(5, true);
    public final a xcH = new a(6, true);
    public final a xcI = new a(Downloads.RECV_BUFFER_SIZE, true);
    public final a xcJ = new a(4097, true);
    public final a xcK = new a(4098, true);
    public final a xcL = new a(4099, true);
    public final a xcM = new a(8192, false);
    public final a xcN = new a(8193, true);
    public final a xcO = new a(8194, false);
    public final a xcP = new a(8195, false);
    public final a xcQ = new a(8196, false);
    public final a xcR = new a(8197, false);
    public final a xcS = new a(8198, true);
    public final a[] xcT = new a[]{this.xcB, this.xcC, this.xcD, this.xcE, this.xcF, this.xcG, this.xcH, this.xcI, this.xcJ, this.xcK, this.xcL, this.xcM, this.xcN, this.xcO, this.xcP, this.xcQ, this.xcR, this.xcS};
    public int xcU;
    public int xcV;
    public int xcW;
    public int xcX;
    public int xcY;
    public byte[] xcp = new byte[20];

    public static class a implements Comparable<a> {
        public int dyd = -1;
        public int size = 0;
        public final short xcZ;
        public boolean xda;
        public int xdb = 0;

        public static abstract class a<T> implements Comparable<T> {
            public int dyd;

            public a(int i) {
                this.dyd = i;
            }

            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (this.dyd != aVar.dyd) {
                return this.dyd < aVar.dyd ? -1 : 1;
            } else {
                int Dk = Dk(this.xcZ);
                int Dk2 = Dk(aVar.xcZ);
                if (Dk != Dk2) {
                    return Dk >= Dk2 ? 1 : -1;
                } else {
                    return 0;
                }
            }
        }

        public a(int i, boolean z) {
            this.xcZ = (short) i;
            this.xda = z;
            if (i == 0) {
                this.dyd = 0;
                this.size = 1;
                this.xdb = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            } else if (i == Downloads.RECV_BUFFER_SIZE) {
                this.size = 1;
            }
        }

        public final boolean exists() {
            return this.size > 0;
        }

        private static int Dk(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    return 17;
                case 4097:
                    return 8;
                case 4098:
                    return 11;
                case 4099:
                    return 10;
                case 8192:
                    return 15;
                case 8193:
                    return 14;
                case 8194:
                    return 7;
                case 8195:
                    return 13;
                case 8196:
                    return 9;
                case 8197:
                    return 16;
                case 8198:
                    return 12;
                default:
                    throw new IllegalArgumentException("unknown section type: " + i);
            }
        }

        public final String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.xcZ), Integer.valueOf(this.dyd), Integer.valueOf(this.size)});
        }
    }

    final void a(e eVar) {
        int i = eVar.xcn.getInt();
        int i2 = 0;
        a aVar = null;
        while (i2 < i) {
            int i3;
            short s = eVar.xcn.getShort();
            eVar.xcn.getShort();
            for (a aVar2 : this.xcT) {
                if (aVar2.xcZ == s) {
                    i3 = eVar.xcn.getInt();
                    int i4 = eVar.xcn.getInt();
                    if ((aVar2.size == 0 || aVar2.size == i3) && (aVar2.dyd == -1 || aVar2.dyd == i4)) {
                        aVar2.size = i3;
                        aVar2.dyd = i4;
                        if (aVar == null || aVar.dyd <= aVar2.dyd) {
                            i2++;
                            aVar = aVar2;
                        } else {
                            throw new j("Map is unsorted at " + aVar + ", " + aVar2);
                        }
                    }
                    throw new j("Unexpected map value for 0x" + Integer.toHexString(s));
                }
            }
            throw new IllegalArgumentException("No such map item: " + s);
        }
        this.xcB.dyd = 0;
        Arrays.sort(this.xcT);
        for (i3 = 1; i3 < this.xcT.length; i3++) {
            if (this.xcT[i3].dyd == -1) {
                this.xcT[i3].dyd = this.xcT[i3 - 1].dyd;
            }
        }
    }

    public final void cgD() {
        int i = this.fileSize;
        for (int length = this.xcT.length - 1; length >= 0; length--) {
            a aVar = this.xcT[length];
            if (aVar.dyd != -1) {
                if (aVar.dyd > i) {
                    throw new j("Map is unsorted at " + aVar);
                }
                aVar.xdb = i - aVar.dyd;
                i = aVar.dyd;
            }
        }
        this.xcY = (((((this.xcB.xdb + this.xcC.xdb) + this.xcD.xdb) + this.xcE.xdb) + this.xcF.xdb) + this.xcG.xdb) + this.xcH.xdb;
        this.xcX = this.fileSize - this.xcY;
    }

    public final void b(e eVar) {
        int i = 0;
        for (a exists : this.xcT) {
            if (exists.exists()) {
                i++;
            }
        }
        eVar.writeInt(i);
        for (a aVar : this.xcT) {
            if (aVar.exists()) {
                eVar.writeShort(aVar.xcZ);
                eVar.writeShort((short) 0);
                eVar.writeInt(aVar.size);
                eVar.writeInt(aVar.dyd);
            }
        }
    }
}
