package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.tn;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l extends k implements j {
    public final b gUA;
    private e gUD;

    private l() {
        this.gUA = kA("");
        tn tnVar = (tn) this.gUA.hsj.hsr;
        ap.yY();
        String mz = bg.mz((String) c.vr().get(46, null));
        tnVar.thn = new avw().bb(bg.PT(mz));
        ap.yY();
        String mz2 = bg.mz((String) c.vr().get(72, null));
        tnVar.tBy = new avw().bb(bg.PT(mz2));
        w.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + mz + " newa2=" + mz2);
    }

    private l(String str) {
        this.gUA = kA(str);
        tn tnVar = (tn) this.gUA.hsj.hsr;
        ap.yY();
        String mz = bg.mz((String) c.vr().get(46, null));
        tnVar.thn = new avw().bb(bg.PT(mz));
        ap.yY();
        String mz2 = bg.mz((String) c.vr().get(72, null));
        tnVar.tBy = new avw().bb(bg.PT(mz2));
        w.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + mz + " newa2=" + mz2);
    }

    private l(byte b) {
        this.gUA = gw(1);
        tn tnVar = (tn) this.gUA.hsj.hsr;
        ap.yY();
        String mz = bg.mz((String) c.vr().get(46, null));
        tnVar.thn = new avw().bb(bg.PT(mz));
        ap.yY();
        String mz2 = bg.mz((String) c.vr().get(72, null));
        tnVar.tBy = new avw().bb(bg.PT(mz2));
        w.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + mz + " newa2=" + mz2);
    }

    private static b kA(String str) {
        w.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%d", str, Integer.valueOf(kB(str)));
        return gw(kB(str));
    }

    private static b gw(int i) {
        a aVar = new a();
        aVar.hsm = new tn();
        aVar.hsn = new to();
        switch (i) {
            case 0:
                aVar.uri = "/cgi-bin/micromsg-bin/geta8key";
                aVar.hsl = 233;
                aVar.hso = 155;
                aVar.hsp = 1000000155;
                break;
            case 1:
                aVar.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
                aVar.hsl = av.CTRL_BYTE;
                aVar.hso = 345;
                aVar.hsp = 1000000345;
                break;
            case 2:
                aVar.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
                aVar.hsl = 835;
                aVar.hso = 346;
                aVar.hsp = 1000000346;
                break;
            default:
                aVar.uri = "/cgi-bin/micromsg-bin/geta8key";
                aVar.hsl = 233;
                aVar.hso = 155;
                aVar.hsp = 1000000155;
                break;
        }
        return aVar.BE();
    }

    private static int kB(String str) {
        if (bg.mA(str)) {
            w.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
            return 0;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 0;
            }
            String toLowerCase = bg.mz(parse.getHost()).toLowerCase();
            w.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", toLowerCase, bg.mA(parse.getFragment()) ? "" : "#" + parse.getFragment());
            if (toLowerCase.equals("open.weixin.qq.com") || toLowerCase.equals("mp.weixin.qq.com") || toLowerCase.equals("mp.weixinbridge.com")) {
                return 1;
            }
            if (toLowerCase.equals("weixin.qq.com") || toLowerCase.equals("wx.qq.com") || toLowerCase.equals("weixin110.qq.com") || toLowerCase.equals("view.inews.qq.com") || toLowerCase.contains("support.weixin.qq.com") || !r3.contains("wechat_pay")) {
                return 0;
            }
            return 2;
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", e.getMessage());
            return 0;
        }
    }

    public l(String str, String str2, String str3, int i) {
        this((byte) 0);
        tn tnVar = (tn) this.gUA.hsj.hsr;
        tnVar.tce = 1;
        tnVar.tBr = new avx().OV(str);
        tnVar.tBs = new avx().OV(str2);
        tnVar.tBt = new avx().OV(str3);
        tnVar.tBE = i;
        w.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", str, Integer.valueOf(i));
    }

    public l(String str, String str2, int i, int i2) {
        this(str);
        tn tnVar = (tn) this.gUA.hsj.hsr;
        tnVar.tce = 2;
        tnVar.tBu = new avx().OV(str);
        tnVar.tdM = i;
        tnVar.jNj = str2;
        tnVar.tBz = 0;
        tnVar.tBE = i2;
        w.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i + ", reason = 0, requestId = " + i2);
    }

    public l(String str, int i, int i2, int i3, String str2, int i4) {
        this(str);
        tn tnVar = (tn) this.gUA.hsj.hsr;
        tnVar.tce = 2;
        tnVar.tBu = new avx().OV(str);
        tnVar.tdM = i;
        tnVar.jNj = null;
        tnVar.tBz = 0;
        tnVar.tBC = i2;
        tnVar.tBD = i3;
        tnVar.tBE = i4;
        tnVar.tBr = new avx().OV(str2);
        w.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + null + ", scene = " + i + ", reason = 0, codeType = " + i2 + ", codeVersion = " + i3 + ", requestId = " + i4);
    }

    public l(String str, String str2, int i, int i2, int i3, String str3, String str4, int i4) {
        this(str);
        tn tnVar = (tn) this.gUA.hsj.hsr;
        tnVar.tce = 2;
        tnVar.tBu = new avx().OV(str);
        tnVar.tdM = i;
        tnVar.jNj = str2;
        tnVar.tBz = i2;
        tnVar.teT = i3;
        tnVar.tBB = str3;
        tnVar.tBE = i4;
        tnVar.tBr = new avx().OV(str4);
        w.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4), str4);
    }

    public l(int i, int i2) {
        this();
        tn tnVar = (tn) this.gUA.hsj.hsr;
        tnVar.tce = 3;
        tnVar.tdM = 5;
        tnVar.tBw = i;
        tnVar.tBE = i2;
        w.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", Integer.valueOf(i), Integer.valueOf(tnVar.thn.tZn), Integer.valueOf(i2));
    }

    public final int getType() {
        return 233;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", Integer.valueOf(i2), Integer.valueOf(i3), IQ(), ((to) this.gUA.hsk.hsr).tBG);
        this.gUD.a(i2, i3, str, this);
    }

    public final String IQ() {
        return ((to) this.gUA.hsk.hsr).tBF;
    }

    public final String IR() {
        avx com_tencent_mm_protocal_c_avx = ((tn) this.gUA.hsj.hsr).tBu;
        if (com_tencent_mm_protocal_c_avx != null) {
            return com_tencent_mm_protocal_c_avx.tZr;
        }
        return null;
    }

    public final String getTitle() {
        return ((to) this.gUA.hsk.hsr).fDC;
    }

    public final String pM() {
        return ((to) this.gUA.hsk.hsr).opI;
    }

    public final int IS() {
        return ((to) this.gUA.hsk.hsr).tcm;
    }

    public final byte[] IT() {
        to toVar = (to) this.gUA.hsk.hsr;
        if (toVar.tBO == null) {
            return null;
        }
        try {
            return n.a(toVar.tBO);
        } catch (Exception e) {
            return null;
        }
    }

    public final String IU() {
        return ((to) this.gUA.hsk.hsr).tBJ;
    }

    public final ArrayList<byte[]> IV() {
        to toVar = (to) this.gUA.hsk.hsr;
        ArrayList<byte[]> arrayList = new ArrayList();
        if (toVar == null || toVar.tBL == null) {
            return arrayList;
        }
        Iterator it = toVar.tBL.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((hl) it.next()).toByteArray());
            } catch (Throwable e) {
                w.e("MicroMsg.NetSceneGetA8Key", "exception:%s", bg.g(e));
            }
        }
        w.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public final long IW() {
        to toVar = (to) this.gUA.hsk.hsr;
        return toVar.tBN != null ? toVar.tBN.tto : -1;
    }

    public final List<afe> IX() {
        return ((to) this.gUA.hsk.hsr).tBQ;
    }

    public final int IY() {
        return ((tn) this.gUA.hsj.hsr).tBE;
    }
}
