package com.tencent.mm.x;

import android.annotation.SuppressLint;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;

public final class e implements com.tencent.mm.y.e {
    h hqY = null;
    b hrh = null;
    k hri = null;
    boolean hrj = false;
    private ar hrk = null;

    public interface b {
        int aM(int i, int i2);
    }

    @SuppressLint({"DefaultLocale"})
    class a implements com.tencent.mm.sdk.platformtools.ar.a {
        public h hqU = null;
        public String hrl = null;
        public boolean hrm = true;
        private com.tencent.mm.compatible.util.g.a hrn;
        final /* synthetic */ e hro;

        public a(e eVar, h hVar) {
            this.hro = eVar;
            this.hqU = hVar;
            n.Bl();
            this.hrl = d.r(hVar.getUsername(), true);
            this.hrn = new com.tencent.mm.compatible.util.g.a();
        }

        public final boolean Bn() {
            Throwable e;
            Object obj;
            OutputStream outputStream;
            InputStream inputStream = null;
            if (this.hqU == null) {
                return false;
            }
            String Bs = this.hqU.Bs();
            String str = "";
            if (h.vG().uV()) {
                r4 = new Object[4];
                h.vG();
                r4[1] = o.getString(com.tencent.mm.kernel.a.uH());
                r4[2] = Integer.valueOf(am.getNetTypeForStat(ab.getContext()));
                r4[3] = Integer.valueOf(am.getStrength(ab.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r4);
            }
            w.d("MicroMsg.GetHDHeadImgHelper", "dkreferer dkavatar user: %s referer: %s  url:%s", this.hqU.getUsername(), str, Bs);
            this.hrm = true;
            t tVar;
            try {
                t a = com.tencent.mm.network.b.a(Bs, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
                    a.setReadTimeout(Downloads.MIN_RETYR_AFTER);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        w.e("MicroMsg.GetHDHeadImgHelper", "checkHttpConnection failed! url:%s", Bs);
                        return true;
                    }
                    InputStream inputStream2 = a.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            w.d("MicroMsg.GetHDHeadImgHelper", "getInputStream failed. url:%s", Bs);
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            tVar = a;
                            inputStream = inputStream2;
                            obj = null;
                            w.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bg.g(e));
                            this.hrm = true;
                            if (tVar != null) {
                                try {
                                    tVar.ieZ.disconnect();
                                } catch (Throwable e3) {
                                    w.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bg.g(e3));
                                    w.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e3.getMessage());
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    OutputStream gQ = FileOp.gQ(this.hrl + ".tmp");
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            gQ.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e3 = e4;
                            inputStream = inputStream2;
                            outputStream = gQ;
                            tVar = a;
                        }
                    }
                    this.hrm = false;
                    gQ.close();
                    a.ieZ.disconnect();
                    try {
                        inputStream2.close();
                        outputStream = null;
                        tVar = null;
                    } catch (Exception e5) {
                        e3 = e5;
                        tVar = null;
                        inputStream = inputStream2;
                        obj = null;
                        w.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bg.g(e3));
                        this.hrm = true;
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return true;
                    }
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                } catch (Exception e6) {
                    e3 = e6;
                    outputStream = null;
                    tVar = a;
                    w.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bg.g(e3));
                    this.hrm = true;
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                }
            } catch (Exception e7) {
                e3 = e7;
                outputStream = null;
                tVar = null;
                w.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bg.g(e3));
                this.hrm = true;
                if (tVar != null) {
                    tVar.ieZ.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return true;
            }
        }

        public final boolean Bo() {
            if (this.hro.hrj) {
                return false;
            }
            if (this.hrm || bg.mA(this.hrl)) {
                this.hro.hrh.aM(4, -1);
                return false;
            }
            w.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.hqU.getUsername() + " urltime:" + this.hrn.se());
            if (com.tencent.mm.u.ag.a.hlT != null) {
                com.tencent.mm.u.ag.a.hlT.aH((int) FileOp.ki(this.hrl + ".tmp"), 0);
            }
            FileOp.deleteFile(this.hrl);
            FileOp.aj(this.hrl + ".tmp", this.hrl);
            k.S(this.hrl, this.hro.hqY.getUsername());
            this.hro.hrh.aM(0, 0);
            return true;
        }
    }

    public e() {
        h.vd().a(158, (com.tencent.mm.y.e) this);
    }

    public final void Bp() {
        h.vd().b(158, (com.tencent.mm.y.e) this);
    }

    public final int a(String str, b bVar) {
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (bg.mA(str)) {
            bVar.aM(3, -101);
            return -101;
        }
        String QR;
        this.hrh = bVar;
        if (x.eO(str)) {
            QR = x.QR(str);
        } else {
            QR = str;
        }
        this.hqY = n.Bm().hs(QR);
        w.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", QR);
        if (this.hqY == null || !this.hqY.getUsername().equals(QR)) {
            this.hqY = new h();
            this.hqY.username = QR;
        }
        if (bg.mA(this.hqY.Bs())) {
            w.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.hqY.gkq));
            this.hri = new k(QR);
            if (h.vd().a(this.hri, 0)) {
                return 0;
            }
            bVar.aM(3, -102);
            return -102;
        }
        h hVar = this.hqY;
        if (this.hrk == null || this.hrk.bJx()) {
            this.hrk = new ar(1, "get-hd-headimg", 1);
        }
        if (this.hrk.c(new a(this, hVar)) == 0) {
            return 0;
        }
        bVar.aM(3, -103);
        return -103;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.hrh.aM(i, i2);
    }
}
