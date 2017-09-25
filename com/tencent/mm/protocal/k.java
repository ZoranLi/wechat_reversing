package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.sdk.platformtools.w;

public final class k {

    public interface a {
        boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2);
    }

    public interface b {
        boolean bHp();

        byte[] zh();

        int zi();
    }

    public interface c {
        boolean bHp();

        int y(byte[] bArr);
    }

    public static class d {
        public byte[] aMt = new byte[0];
        public ac sZA = new ac("", "", 0);
        public long sZB = 0;
        public int sZs = 0;
        public int sZt = 0;
        public String sZu = "";
        public String sZv = "";
        public int sZw = 0;
        public boolean sZx = true;
        public a sZy;
        public byte[] sZz;

        public void dj(int i) {
            this.sZs = i;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean bHp() {
            return false;
        }

        public boolean Cl() {
            return this.sZx;
        }
    }

    public static class e {
        public long sZB = 0;
        public int sZC = -99;
        public String sZD = "";

        public int getCmdId() {
            return 0;
        }

        public boolean bHp() {
            return false;
        }
    }

    public static em a(d dVar) {
        em emVar = new em();
        emVar.tiC = dVar.sZt;
        emVar.tdM = dVar.sZw;
        emVar.leD = dVar.sZs;
        emVar.tiB = com.tencent.mm.bd.b.aU(dVar.sZv.getBytes());
        if (emVar.tiB.sYA.length >= 16) {
            emVar.tiB = emVar.tiB.xV(16);
        }
        emVar.tiD = com.tencent.mm.bd.b.aU(dVar.sZu.getBytes());
        if (emVar.tiD.sYA.length >= 132) {
            emVar.tiD = emVar.tiD.xV(132);
        }
        emVar.tiA = com.tencent.mm.bd.b.aU(dVar.aMt);
        if (emVar.tiA.sYA.length >= 36) {
            emVar.tiA = emVar.tiA.xV(36);
        }
        return emVar;
    }

    public static void a(e eVar, en enVar) {
        if (enVar.tiE != null) {
            eVar.sZD = enVar.tiE.tZr;
            return;
        }
        eVar.sZD = "";
        w.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    }
}
