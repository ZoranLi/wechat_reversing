package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.zs;
import com.tencent.mm.protocal.c.zt;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a extends k implements j {
    private String filePath = null;
    private e gUD;
    private int hrs = 0;
    private RandomAccessFile ibc = null;
    private int jVf = 0;
    String url;

    public a(String str) {
        this.url = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new zs();
        aVar.hsn = new zt();
        aVar.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        aVar.hsl = com.tencent.mm.plugin.appbrand.jsapi.map.k.CTRL_INDEX;
        aVar.hso = 29;
        aVar.hsp = 1000000029;
        p BE = aVar.BE();
        zs zsVar = (zs) BE.hsj.hsr;
        zsVar.URL = this.url;
        zsVar.tll = this.jVf;
        w.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.jVf + " totallen:" + this.hrs);
        return a(eVar, BE, this);
    }

    protected final int a(p pVar) {
        String str = ((zs) ((b) pVar).hsj.hsr).URL;
        Object obj = str == null ? null : str.indexOf("weixin://") != 0 ? null : 1;
        if (obj == null) {
            w.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            return b.hsU;
        } else if (this.jVf < 0 || this.hrs < 0) {
            w.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.jVf + " total:" + this.hrs);
            return b.hsU;
        } else {
            if (this.jVf == 0) {
                if (this.hrs != 0) {
                    w.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.jVf + " total:" + this.hrs);
                    return b.hsU;
                }
            } else if (this.jVf >= this.hrs) {
                w.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.jVf + " total:" + this.hrs);
                return b.hsU;
            }
            return b.hsT;
        }
    }

    protected final int ub() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            zt ztVar = (zt) ((b) pVar).hsk.hsr;
            w.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.jVf + " Resp[ totallen:" + ztVar.tlk + " bufSize:" + ztVar.tsk.tZn + " ]");
            if (ztVar.tlk > 0) {
                this.hrs = ztVar.tlk;
            }
            if (c(this.url, ztVar.tsk.tZp.sYA, this.jVf)) {
                this.jVf = ztVar.tsk.tZn + this.jVf;
                if (this.hrs <= this.jVf) {
                    w.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.hrs);
                    this.gUD.a(i2, i3, str, this);
                    return;
                } else if (a(this.hsD, this.gUD) < 0) {
                    this.gUD.a(i2, i3, str, this);
                    return;
                } else {
                    return;
                }
            }
            this.gUD.a(3, -1, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    private boolean c(String str, byte[] bArr, int i) {
        if (i == 0) {
            if (this.ibc == null && this.filePath == null) {
                this.filePath = com.tencent.mm.pluginsdk.l.a.a.Mz(str);
                if (this.filePath == null) {
                    w.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    return false;
                }
                try {
                    this.ibc = new RandomAccessFile(this.filePath, "rw");
                } catch (Exception e) {
                    w.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e.getMessage());
                    return false;
                }
            }
            w.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
            return false;
        }
        try {
            this.ibc.seek((long) i);
            this.ibc.write(bArr, 0, bArr.length);
            return true;
        } catch (IOException e2) {
            w.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e2.getMessage());
            return false;
        }
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.k.CTRL_INDEX;
    }
}
