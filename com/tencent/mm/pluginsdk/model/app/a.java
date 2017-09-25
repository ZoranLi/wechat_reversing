package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.g;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import java.util.Map;

public final class a {
    public String desc;
    public String fFW;
    public int fNd;
    public long hVj;
    public long sCY;
    public int size;
    public String url;

    public static a bCQ() {
        ap.yY();
        String str = (String) c.vr().get(352273, (Object) "");
        if (bg.mA(str)) {
            return null;
        }
        a aVar = new a(str);
        if (aVar.isValid() && !aVar.bAQ()) {
            return aVar;
        }
        bCR();
        return null;
    }

    public a(String str) {
        Map q = bh.q(str, "msg");
        this.desc = (String) q.get(".msg.appmsg.des");
        this.fNd = bg.getInt((String) q.get(".msg.alphainfo.clientVersion"), 0);
        this.url = (String) q.get(".msg.alphainfo.url");
        this.size = bg.getInt((String) q.get(".msg.alphainfo.size"), 0);
        this.fFW = (String) q.get(".msg.alphainfo.md5");
        this.sCY = bg.getLong((String) q.get(".msg.alphainfo.maxAge"), 0);
        this.hVj = bg.getLong((String) q.get(".msg.alphainfo.expireTime"), 0);
        w.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", str, Integer.valueOf(this.fNd), this.url, Integer.valueOf(this.size), this.fFW, this.desc, Long.valueOf(this.sCY), Long.valueOf(this.hVj));
    }

    private boolean isValid() {
        boolean z;
        if (this.fNd <= d.sYN || bg.mA(this.url) || bg.mA(this.fFW) || bg.mA(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        w.i("MicroMsg.AlphaUpdateInfo", "isValid %b", Boolean.valueOf(z));
        return z;
    }

    private boolean bAQ() {
        boolean z;
        ap.yY();
        if (System.currentTimeMillis() - ((Long) c.vr().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.sCY || System.currentTimeMillis() > this.hVj) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", Boolean.valueOf(z));
        return z;
    }

    public static void bCR() {
        ap.yY();
        c.vr().set(352273, null);
        ap.yY();
        c.vr().set(352274, null);
    }

    public final void bCS() {
        ce auVar = new au();
        auVar.z(ay.i("weixin", bg.Ny()));
        auVar.setType(1);
        auVar.setContent(this.desc);
        w.d("MicroMsg.AlphaUpdateInfo", auVar.field_content);
        auVar.dw(0);
        auVar.cH("weixin");
        auVar.dv(3);
        ay.i(auVar);
        w.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        bCR();
    }

    public final void bCT() {
        w.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (isValid() && !bAQ()) {
            int i;
            if (bg.PY(g.sV().getValue("SilentDownloadApkAtWiFi")) != 0) {
                i = 0;
            } else {
                ap.yY();
                i = (!am.isWifi(ab.getContext()) || ((((Integer) c.vr().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : 0) == 0) ? 0 : 1;
                if ((f.fuX & 1) != 0) {
                    w.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
                    i = 0;
                } else {
                    w.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                }
            }
            if (i == 0) {
                bCS();
                return;
            }
            w.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", this.fFW, Integer.valueOf(this.size), this.desc, this.url);
            y.bCs().d(this.fFW, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
        }
    }
}
