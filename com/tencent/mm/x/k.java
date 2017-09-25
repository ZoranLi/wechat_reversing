package com.tencent.mm.x;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.io.OutputStream;

final class k extends com.tencent.mm.y.k implements j {
    private e gUD;
    private int hrH;
    private OutputStream hrI = null;
    private String hrJ;
    private String hrl;
    private int hrp;
    private String hrr;
    private String username;

    public k(String str) {
        this.username = str;
        if (x.eO(str)) {
            this.username = x.QR(str);
        }
        w.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.hrp = 480;
        this.hrH = 480;
        this.hrr = "jpg";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.gUD = eVar2;
        if (this.username == null || this.username.length() == 0) {
            w.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            w.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            return -1;
        } else {
            g By = n.By();
            n.Bl();
            this.hrl = d.r(this.username, true);
            if (FileOp.aO(this.hrl)) {
                w.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                return 0;
            }
            f fVar;
            this.hrJ = this.hrl + ".tmp";
            f hr = By.hr(this.username);
            if (hr == null) {
                FileOp.deleteFile(this.hrJ);
                hr = new f();
                hr.username = this.username;
                hr.hrr = this.hrr;
                hr.hrp = this.hrp;
                hr.hrq = this.hrH;
                hr.fRW = -1;
                By.hnH.insert("hdheadimginfo", "username", hr.pv());
                fVar = hr;
            } else {
                String str = this.hrJ;
                if (hr != null && str != null && str.length() != 0 && hr.Bq().equals(this.hrr) && hr.hrp == this.hrp && hr.hrq == this.hrH && FileOp.ki(str) == ((long) hr.hrt)) {
                    z = true;
                }
                if (!z) {
                    FileOp.deleteFile(this.hrJ);
                    hr.reset();
                    hr.username = this.username;
                    hr.hrr = this.hrr;
                    hr.hrp = this.hrp;
                    hr.hrq = this.hrH;
                    By.a(this.username, hr);
                }
                fVar = hr;
            }
            a aVar = new a();
            aVar.hsm = new yl();
            aVar.hsn = new ym();
            aVar.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            aVar.hsl = 158;
            aVar.hso = 47;
            aVar.hsp = 1000000047;
            p BE = aVar.BE();
            yl ylVar = (yl) BE.hsj.hsr;
            if (!x.eO(this.username)) {
                ylVar.jNj = this.username;
                ylVar.tET = 1;
            } else if (this.username.equals(m.xL() + "@bottle")) {
                ylVar.jNj = m.xL();
                ylVar.tET = 2;
            } else {
                ylVar.jNj = this.username;
                ylVar.tET = 2;
            }
            w.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ylVar.jNj + " outType:" + ylVar.tET);
            ylVar.tEQ = this.hrp;
            ylVar.tER = this.hrH;
            ylVar.tES = this.hrr;
            ylVar.tgJ = fVar.hrs;
            ylVar.tgK = fVar.hrt;
            return a(eVar, BE, this);
        }
    }

    protected final int a(p pVar) {
        if (this.username == null || this.username.length() == 0) {
            return b.hsU;
        }
        return b.hsT;
    }

    protected final int ub() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ym ymVar = (ym) ((b) pVar).hsk.hsr;
        w.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            w.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
            Bv();
        } else if (i2 == 4 || i2 == 5) {
            this.gUD.a(i2, i3, str, this);
            w.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:" + i2);
            Bv();
        } else {
            Object obj;
            int i4 = pVar.zg().sZC;
            if (i4 == -4 || i4 == -54 || i4 == -55) {
                w.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == " + i4);
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                w.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.gUD.a(i2, i3, str, this);
                Bv();
                return;
            }
            i4 = -1;
            if (!(ymVar.tsk == null || ymVar.tsk.tZp == null)) {
                i4 = z(ymVar.tsk.tZp.sYA);
            }
            if (i4 < 0) {
                w.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.gUD.a(i2, i3, str, this);
                Bv();
                return;
            }
            g By = n.By();
            f hr = By.hr(this.username);
            hr.hrt = i4 + ymVar.tgK;
            hr.hrs = ymVar.tgJ;
            By.a(this.username, hr);
            if ((hr.hrt >= hr.hrs ? 1 : null) == null) {
                w.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", Integer.valueOf(hashCode()), this.username, Integer.valueOf(hr.hrt), Integer.valueOf(hr.hrs));
                if (a(this.hsD, this.gUD) < 0) {
                    this.gUD.a(3, -1, "", this);
                    return;
                }
                return;
            }
            FileOp.aj(this.hrJ, this.hrl);
            S(this.hrl, this.username);
            Bv();
            this.gUD.a(i2, i3, str, this);
        }
    }

    public static void S(String str, String str2) {
        n.Bl().R(str, str2);
    }

    protected final void cancel() {
        super.cancel();
        Bv();
    }

    public final int getType() {
        return 158;
    }

    private int z(byte[] bArr) {
        try {
            if (this.hrI == null) {
                this.hrI = FileOp.gQ(this.hrJ);
            }
            this.hrI.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bg.g(e));
            return -1;
        }
    }

    private void Bv() {
        try {
            if (this.hrI != null) {
                this.hrI.flush();
                this.hrI.close();
                this.hrI = null;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bg.g(e));
        }
    }
}
