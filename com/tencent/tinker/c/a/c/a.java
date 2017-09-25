package com.tencent.tinker.c.a.c;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public abstract class a {

    class AnonymousClass1 implements com.tencent.tinker.a.a.b.a {
        final /* synthetic */ ByteArrayInputStream xeS;
        final /* synthetic */ a xeT;

        public AnonymousClass1(a aVar, ByteArrayInputStream byteArrayInputStream) {
            this.xeT = aVar;
            this.xeS = byteArrayInputStream;
        }

        public final byte readByte() {
            return (byte) (this.xeS.read() & 255);
        }
    }

    class AnonymousClass2 implements b {
        final /* synthetic */ ByteArrayOutputStream xdi;
        final /* synthetic */ a xeT;

        public AnonymousClass2(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
            this.xeT = aVar;
            this.xdi = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.xdi.write(i);
        }
    }

    class AnonymousClass3 implements b {
        final /* synthetic */ a xeT;
        final /* synthetic */ ByteArrayOutputStream xeU;

        public AnonymousClass3(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
            this.xeT = aVar;
            this.xeU = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.xeU.write(i);
        }
    }

    class AnonymousClass4 implements b {
        final /* synthetic */ a xeT;
        final /* synthetic */ ByteArrayOutputStream xeU;

        public AnonymousClass4(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
            this.xeT = aVar;
            this.xeU = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.xeU.write(i);
        }
    }

    private final class a {
        final /* synthetic */ a xeT;
        private final b xeV;

        public a(a aVar, b bVar) {
            this.xeT = aVar;
            this.xeV = bVar;
        }

        private void a(m mVar) {
            int i = 0;
            switch (mVar.cgt()) {
                case 0:
                    l.a(this.xeV, 0, (long) mVar.readByte());
                    return;
                case 2:
                    l.a(this.xeV, 2, (long) mVar.readShort());
                    return;
                case 3:
                    l.b(this.xeV, 3, (long) mVar.readChar());
                    return;
                case 4:
                    l.a(this.xeV, 4, (long) mVar.readInt());
                    return;
                case 6:
                    l.a(this.xeV, 6, mVar.readLong());
                    return;
                case 16:
                    l.c(this.xeV, 16, ((long) Float.floatToIntBits(mVar.readFloat())) << 32);
                    return;
                case 17:
                    l.c(this.xeV, 17, Double.doubleToLongBits(mVar.readDouble()));
                    return;
                case 23:
                    l.b(this.xeV, 23, (long) this.xeT.DH(mVar.cgx()));
                    return;
                case 24:
                    l.b(this.xeV, 24, (long) this.xeT.DI(mVar.cgy()));
                    return;
                case 25:
                    l.b(this.xeV, 25, (long) this.xeT.DK(mVar.cgz()));
                    return;
                case 26:
                    l.b(this.xeV, 26, (long) this.xeT.DL(mVar.cgB()));
                    return;
                case 27:
                    l.b(this.xeV, 27, (long) this.xeT.DK(mVar.cgA()));
                    return;
                case 28:
                    eJ(28, 0);
                    c(mVar);
                    return;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    eJ(29, 0);
                    b(mVar);
                    return;
                case 30:
                    mVar.cgC();
                    eJ(30, 0);
                    return;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    if (mVar.readBoolean()) {
                        i = 1;
                    }
                    eJ(31, i);
                    return;
                default:
                    throw new j("Unexpected type: " + Integer.toHexString(mVar.cgt()));
            }
        }

        public final void b(m mVar) {
            int cgv = mVar.cgv();
            o.a(this.xeV, this.xeT.DI(mVar.xct));
            o.a(this.xeV, cgv);
            for (int i = 0; i < cgv; i++) {
                o.a(this.xeV, this.xeT.DH(mVar.cgw()));
                a(mVar);
            }
        }

        public final void c(m mVar) {
            int cgu = mVar.cgu();
            o.a(this.xeV, cgu);
            for (int i = 0; i < cgu; i++) {
                a(mVar);
            }
        }

        private void eJ(int i, int i2) {
            this.xeV.writeByte((i2 << 5) | i);
        }
    }

    public abstract int DH(int i);

    public abstract int DI(int i);

    public abstract int DJ(int i);

    public abstract int DK(int i);

    public abstract int DL(int i);

    public abstract int DM(int i);

    public abstract int DN(int i);

    public abstract int DO(int i);

    public abstract int DP(int i);

    public abstract int DQ(int i);

    public abstract int DR(int i);

    public abstract int DS(int i);

    public abstract int DT(int i);

    public abstract int DU(int i);

    public final com.tencent.tinker.a.a.e.a[] b(com.tencent.tinker.a.a.e.a[] aVarArr) {
        com.tencent.tinker.a.a.e.a[] aVarArr2 = new com.tencent.tinker.a.a.e.a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            aVarArr2[i] = new com.tencent.tinker.a.a.e.a(DK(aVar.xbD), aVar.xbE);
        }
        return aVarArr2;
    }

    public final e.b[] b(e.b[] bVarArr) {
        e.b[] bVarArr2 = new e.b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            e.b bVar = bVarArr[i];
            bVarArr2[i] = new e.b(DL(bVar.xbF), bVar.xbE, DU(bVar.xbG));
        }
        return bVarArr2;
    }
}
