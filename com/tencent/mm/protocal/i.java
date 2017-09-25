package com.tencent.mm.protocal;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ba;

public final class i {

    public interface c {

        public static class a {
            public static c sZi;
        }

        void a(f fVar, g gVar, int i, int i2, String str);

        p aI(int i, int i2);

        int zd();
    }

    public static abstract class f extends com.tencent.mm.protocal.k.d implements com.tencent.mm.protocal.k.b {
        public byte[] sZl;

        public abstract String getUri();

        public final void aV(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.sZl = bArr;
        }
    }

    public static abstract class g extends com.tencent.mm.protocal.k.e implements com.tencent.mm.protocal.k.c {
        public byte[] idY;
        public String ieb;
        public bgf sZm = new bgf();
        public byte[] sZn;
        public int sZo = 0;

        public final void aW(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.idY = bArr;
        }
    }

    public static class a extends f implements com.tencent.mm.protocal.k.b {
        public dw sZh = new dw();
        public String username;

        public final byte[] zh() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.ea("");
            if (this.sZw == 12) {
                i = 1;
            } else {
                h.vJ();
                i = h.vI().gXW.yA(46);
            }
            w.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r3), Integer.valueOf(i));
            this.sZA = ac.bHs();
            if (CdnLogic.MediaType_FAVORITE_VIDEO == r.iiW && r.iiX > 0) {
                r.iiX = 0;
                ac.G("", "", 0);
            }
            avh com_tencent_mm_protocal_c_avh = this.sZh.thH;
            com_tencent_mm_protocal_c_avh.tYN = k.a(this);
            w.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf[%d]", Integer.valueOf(this.sZs));
            com_tencent_mm_protocal_c_avh.thz = com.tencent.mm.compatible.d.p.rA();
            com_tencent_mm_protocal_c_avh.thA = com.tencent.mm.plugin.normsg.a.d.nZC.qx(i);
            com_tencent_mm_protocal_c_avh.thB = 0;
            com_tencent_mm_protocal_c_avh.thC = com.tencent.mm.kernel.a.uY();
            com_tencent_mm_protocal_c_avh.hAG = bg.ep(ab.getContext());
            com_tencent_mm_protocal_c_avh.jNn = d.sYL;
            com_tencent_mm_protocal_c_avh.thD = ba.bMW();
            com_tencent_mm_protocal_c_avh.leO = v.bIN();
            com_tencent_mm_protocal_c_avh.leN = bg.bJS();
            h.vJ();
            w.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", (String) h.vI().gXW.get(18), Integer.valueOf(com_tencent_mm_protocal_c_avh.thy.tiw));
            com_tencent_mm_protocal_c_avh.thy.tiu.tjZ = new avw().bb(bg.PT(r0));
            dx dxVar = this.sZh.thG;
            os osVar = new os();
            osVar.tuk = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(osVar.tuk, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            aV(bArr2);
            String str = "MicroMsg.AutoReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(osVar.tuk);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bg.bl(bArr);
            objArr[5] = bg.bl(bArr2);
            w.d(str, str2, objArr);
            osVar.thF = new avw().bb(bArr);
            dxVar.thJ = osVar;
            try {
                return this.sZh.toByteArray();
            } catch (Throwable e) {
                w.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", bg.g(e));
                return null;
            }
        }

        public final int zi() {
            return 702;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    public static class b extends g implements com.tencent.mm.protocal.k.c {
        public final int y(byte[] bArr) {
            try {
                this.sZm = (bgf) this.sZm.aD(bArr);
                k.a(this, this.sZm.tZe);
                this.sZo = 0;
                if (this.sZm.tZe.thX == 0 && (this.sZm.ugy == null || this.sZm.ugy.leD == 0 || bg.bm(n.a(this.sZm.ugy.the)))) {
                    w.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.sZm.tZe.thX = -1;
                }
                w.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", this.sZD);
                com.tencent.mm.kernel.a.ea(r0);
                return this.sZm.tZe.thX;
            } catch (Throwable e) {
                w.e("MicroMsg.MMAuth", "toProtoBuf :%s", bg.g(e));
                this.sZm.tZe.thX = -1;
                return -1;
            }
        }
    }

    public static class d extends f implements com.tencent.mm.protocal.k.b {
        public aku sZj = new aku();
        public boolean sZk = false;

        public final byte[] zh() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.ea("");
            if (this.sZw == 16) {
                i = 1;
            } else if (this.sZk) {
                i = 3;
            } else {
                h.vJ();
                i = h.vI().gXW.yA(46);
            }
            w.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r4), Integer.valueOf(i));
            if (CdnLogic.MediaType_FAVORITE_VIDEO == r.iiW && r.iiX > 0) {
                r.iiX = 0;
                ac.G("", "", 0);
            }
            this.sZA = ac.bHs();
            avh com_tencent_mm_protocal_c_avh = this.sZj.tOC;
            com_tencent_mm_protocal_c_avh.tYN = k.a(this);
            com_tencent_mm_protocal_c_avh.thz = com.tencent.mm.compatible.d.p.rA();
            com_tencent_mm_protocal_c_avh.thA = com.tencent.mm.plugin.normsg.a.d.nZC.qx(i);
            com_tencent_mm_protocal_c_avh.thB = 0;
            com_tencent_mm_protocal_c_avh.thC = com.tencent.mm.kernel.a.uY();
            com_tencent_mm_protocal_c_avh.hAG = bg.ep(ab.getContext());
            com_tencent_mm_protocal_c_avh.jNn = d.sYL;
            com_tencent_mm_protocal_c_avh.thD = ba.bMW();
            com_tencent_mm_protocal_c_avh.leO = v.bIN();
            com_tencent_mm_protocal_c_avh.leN = bg.bJS();
            com_tencent_mm_protocal_c_avh.tcg = com.tencent.mm.sdk.platformtools.f.usq;
            if (10012 == r.iiW && r.iiX > 0) {
                com_tencent_mm_protocal_c_avh.tcg = r.iiX;
            }
            com_tencent_mm_protocal_c_avh.tlv = d.sYG;
            com_tencent_mm_protocal_c_avh.tlu = d.sYH;
            com_tencent_mm_protocal_c_avh.tOx = d.sYI;
            com_tencent_mm_protocal_c_avh.tum = com.tencent.mm.compatible.d.p.getSimCountryIso();
            h.vJ();
            w.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", (String) h.vI().gXW.get(18), Integer.valueOf(com_tencent_mm_protocal_c_avh.thy.tiw));
            com_tencent_mm_protocal_c_avh.thy.tiu.tjZ = new avw().bb(bg.PT(r0));
            akv com_tencent_mm_protocal_c_akv = this.sZj.tOB;
            com_tencent_mm_protocal_c_akv.tjF = new avw().bb(bg.bJQ());
            os osVar = new os();
            osVar.tuk = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(osVar.tuk, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            aV(bArr2);
            String str = "MicroMsg.ManualReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(osVar.tuk);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bg.bl(bArr);
            objArr[5] = bg.bl(bArr2);
            w.d(str, str2, objArr);
            osVar.thF = new avw().bb(bArr);
            com_tencent_mm_protocal_c_akv.thJ = osVar;
            w.i("MicroMsg.ManualReq", "summerauth IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", com_tencent_mm_protocal_c_avh.thz, com_tencent_mm_protocal_c_avh.thA, com_tencent_mm_protocal_c_avh.thC, com_tencent_mm_protocal_c_avh.hAG, com_tencent_mm_protocal_c_avh.jNn, com_tencent_mm_protocal_c_avh.thD, com_tencent_mm_protocal_c_avh.leO, com_tencent_mm_protocal_c_avh.leN, Integer.valueOf(com_tencent_mm_protocal_c_avh.tcg), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fuV), com_tencent_mm_protocal_c_avh.tlv, com_tencent_mm_protocal_c_avh.tlu, com_tencent_mm_protocal_c_avh.tOx, com_tencent_mm_protocal_c_avh.tum);
            try {
                return this.sZj.toByteArray();
            } catch (Throwable e) {
                w.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", bg.g(e));
                return null;
            }
        }

        public final int zi() {
            return 701;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    public static class e extends g implements com.tencent.mm.protocal.k.c {
        public final int y(byte[] bArr) {
            try {
                this.sZm = (bgf) this.sZm.aD(bArr);
                k.a(this, this.sZm.tZe);
                this.sZo = 0;
                if (this.sZm.tZe.thX == 0 && (this.sZm.ugy == null || this.sZm.ugy.leD == 0 || bg.bm(n.a(this.sZm.ugy.the)))) {
                    w.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.sZm.tZe.thX = -1;
                }
                w.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", this.sZD);
                com.tencent.mm.kernel.a.ea(r0);
                return this.sZm.tZe.thX;
            } catch (Throwable e) {
                w.e("MicroMsg.MMAuth", "toProtoBuf :%s", bg.g(e));
                this.sZm.tZe.thX = -1;
                return -1;
            }
        }
    }
}
