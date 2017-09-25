package com.tencent.mm.x;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.io.OutputStream;

public final class l extends k implements j {
    private String fOa;
    private e gUD;
    private String hrK;
    private String hrL;
    private String hrM = m.xL();
    private int hrs;
    private int hrt;
    private int hru;

    private static int T(String str, String str2) {
        Options Pe = d.Pe(str);
        if (Pe.outHeight >= 640 || Pe.outWidth >= 640) {
            w.d("MicroMsg.NetSceneUploadHDHeadImg", "src w:%d h:%d samp:%d", Integer.valueOf(Pe.outWidth), Integer.valueOf(Pe.outHeight), Integer.valueOf(Math.max(Pe.outWidth / 640, Pe.outHeight / 640)));
            Pe = new Options();
            Pe.inPreferredConfig = Config.ARGB_8888;
            Pe.inSampleSize = r2;
            Bitmap decodeFile = d.decodeFile(str, Pe);
            if (decodeFile == null) {
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(r2));
                return 0 - g.sb();
            }
            w.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, 640, 640, true);
            if (decodeFile != createScaledBitmap) {
                w.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                decodeFile.recycle();
            }
            if (createScaledBitmap == null) {
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                return 0 - g.sb();
            }
            OutputStream outputStream = null;
            try {
                outputStream = FileOp.gQ(str2);
                createScaledBitmap.compress(CompressFormat.JPEG, 40, outputStream);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
                w.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
                return 0;
            } catch (Throwable e2) {
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", bg.g(e2));
                w.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
                int sb = 0 - g.sb();
                if (outputStream == null) {
                    return sb;
                }
                try {
                    outputStream.close();
                    return sb;
                } catch (IOException e3) {
                    return sb;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } else {
            FileOp.p(str, str2);
            w.v("MicroMsg.NetSceneUploadHDHeadImg", "outHeight and outWidth: %d,%d , do not scale.", Integer.valueOf(Pe.outHeight), Integer.valueOf(Pe.outWidth));
            return 0;
        }
    }

    public l(int i, String str) {
        if (i == 2) {
            this.hrM = x.QR(this.hrM);
        }
        n.Bl();
        this.hrK = d.r(this.hrM, true);
        String str2 = this.hrK + ".tmp";
        if (T(str, str2) == 0) {
            this.fOa = str2;
            this.hru = i;
            n.Bl();
            this.hrL = com.tencent.mm.a.g.n(FileOp.c(d.r(this.hrM, true), 0, -1));
            this.hrs = 0;
            this.hrt = 0;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (this.fOa == null || this.fOa.length() == 0) {
            w.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            return -1;
        } else if (FileOp.aO(this.fOa)) {
            if (this.hrs == 0) {
                this.hrs = (int) FileOp.ki(this.fOa);
            }
            byte[] c = FileOp.c(this.fOa, this.hrt, Math.min(this.hrs - this.hrt, 8192));
            if (c == null) {
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                return -1;
            }
            w.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(c.length), Integer.valueOf(this.hrs));
            a aVar = new a();
            aVar.hsm = new bhn();
            aVar.hsn = new bho();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            aVar.hsl = 157;
            aVar.hso = 46;
            aVar.hsp = 1000000046;
            p BE = aVar.BE();
            bhn com_tencent_mm_protocal_c_bhn = (bhn) BE.hsj.hsr;
            com_tencent_mm_protocal_c_bhn.tgJ = this.hrs;
            com_tencent_mm_protocal_c_bhn.tgK = this.hrt;
            com_tencent_mm_protocal_c_bhn.tET = this.hru;
            com_tencent_mm_protocal_c_bhn.tsk = new avw().bb(c);
            com_tencent_mm_protocal_c_bhn.ugW = this.hrL;
            return a(eVar, BE, this);
        } else {
            w.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.fOa);
            return -1;
        }
    }

    protected final int a(p pVar) {
        if (this.fOa == null || this.fOa.length() == 0) {
            return b.hsU;
        }
        return b.hsT;
    }

    protected final int ub() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        int i4 = 0;
        bho com_tencent_mm_protocal_c_bho = (bho) ((b) pVar).hsk.hsr;
        w.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            w.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 4 || i2 == 5) {
            this.gUD.a(i2, i3, str, this);
            w.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:" + i2);
        } else {
            if (pVar.zg().sZC == -4) {
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(pVar.zg().sZC));
                i4 = 1;
            }
            if (i4 != 0) {
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.gUD.a(i2, i3, str, this);
                return;
            }
            this.hrt = com_tencent_mm_protocal_c_bho.tgK;
            if (this.hrt < this.hrs) {
                if (a(this.hsD, this.gUD) < 0) {
                    w.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.gUD.a(3, -1, "", this);
                }
                w.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                return;
            }
            try {
                FileOp.aj(this.fOa, this.hrK);
                h.vI().vr().set(12297, com_tencent_mm_protocal_c_bho.ugX);
                n.Bl().d(this.hrM, d.Pg(this.hrK));
                String xL = m.xL();
                if (!bg.mA(xL)) {
                    h hVar = new h();
                    hVar.username = xL;
                    hVar.aV(true);
                    hVar.fRW = 32;
                    hVar.gkq = 3;
                    hVar.fRW = 34;
                    n.Bm().a(hVar);
                }
                this.gUD.a(i2, i3, str, this);
            } catch (Exception e) {
                w.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e.getMessage());
                this.gUD.a(3, -1, "", this);
            }
        }
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 157;
    }
}
