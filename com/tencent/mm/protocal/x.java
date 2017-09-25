package com.tencent.mm.protocal;

import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class x {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] fKo = null;
        public long hMJ = -1;

        public final byte[] zh() {
            Object obj = new byte[(this.fKo.length + 8)];
            int Nz = (int) (bg.Nz() - this.hMJ);
            obj[0] = (byte) ((Nz >> 24) & 255);
            obj[1] = (byte) ((Nz >> 16) & 255);
            obj[2] = (byte) ((Nz >> 8) & 255);
            obj[3] = (byte) (Nz & 255);
            obj[4] = (byte) ((this.fKo.length >> 24) & 255);
            obj[5] = (byte) ((this.fKo.length >> 16) & 255);
            obj[6] = (byte) ((this.fKo.length >> 8) & 255);
            obj[7] = (byte) (this.fKo.length & 255);
            System.arraycopy(this.fKo, 0, obj, 8, this.fKo.length);
            bg.bl(obj);
            return obj;
        }

        public final int getCmdId() {
            return 1000000190;
        }

        public final int zi() {
            return 268369922;
        }

        public final boolean Cl() {
            return false;
        }
    }

    public static class b extends e implements c {
        public final int y(byte[] bArr) {
            return 0;
        }

        public final int getCmdId() {
            return -1;
        }
    }
}
