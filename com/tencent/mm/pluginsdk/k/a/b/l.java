package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.k.a.e.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

final class l {
    private final int fEB;
    private final int fEC;
    private final int fED;
    private final boolean fEE;
    private final boolean fEH;
    final String filePath;
    final String sEX;
    final boolean sFG;
    final boolean sFH;
    private final String sFa;
    private final int sFb;
    private final byte[] sFc;
    private final String sFd;
    private final long sFf;
    private final String sFg;
    private final int sFh;
    private final int sFi;
    volatile String sGg = null;
    volatile String sGh = null;
    volatile int state = -1;
    private final String url;

    l(int i, int i2, String str, boolean z, boolean z2, String str2, int i3, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j, String str5, int i4, int i5, int i6) {
        this.sEX = i.dG(i, i2);
        this.fEB = i;
        this.fEC = i2;
        this.filePath = str;
        this.sFH = z;
        this.sFG = z2;
        this.sFa = str2;
        this.sFb = i3;
        this.sFc = bArr;
        this.sFd = str3;
        this.fEH = z3;
        this.fEE = z4;
        this.sFg = str4;
        this.sFf = j;
        this.url = str5;
        this.sFh = i4;
        this.sFi = i5;
        this.fED = i6;
    }

    final l bDw() {
        Throwable e;
        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", this.sEX, bDz(), this.sGg, this.sGh, Boolean.valueOf(bg.mA(this.sFa)));
        if (1 == this.state) {
            if (bg.mA(this.sFa)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", this.sEX);
                this.sGg = null;
                this.state = 8;
                j.u(this.sFf, 54);
                j.u(this.sFf, 45);
            } else {
                boolean z;
                try {
                    String str = this.sGg;
                    String str2 = this.sGh;
                    String str3 = this.sFa;
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        file = new File(str2);
                        file.getParentFile().mkdirs();
                        file.delete();
                        byte[] Mx = a.Mx(str);
                        if (bg.bm(Mx)) {
                            w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
                            j.u(this.sFf, 56);
                            j.u(this.sFf, 45);
                            j.u(this.sFf, 18);
                            z = false;
                        } else {
                            Mx = MMProtocalJni.aesDecrypt(Mx, str3.getBytes());
                            if (bg.bm(Mx)) {
                                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
                                j.u(this.sFf, 55);
                                j.u(this.sFf, 45);
                                j.u(this.sFf, 18);
                                z = false;
                            } else {
                                z = a.v(str2, Mx);
                                if (!z) {
                                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
                                    j.u(this.sFf, 57);
                                    j.u(this.sFf, 45);
                                    j.u(this.sFf, 18);
                                }
                            }
                        }
                    } else {
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                        z = false;
                    }
                    try {
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", this.sEX, Boolean.valueOf(z));
                    } catch (Exception e2) {
                        e = e2;
                        w.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.sEX, e);
                        j.u(this.sFf, 45);
                        j.u(this.sFf, 18);
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.sEX, Boolean.valueOf(z));
                        if (z) {
                            j.u(this.sFf, 17);
                            this.sGg = this.sGh;
                            if (this.sFG) {
                                this.sGh = this.filePath + ".decompressed";
                                this.state = 2;
                            } else {
                                this.state = 4;
                            }
                        } else {
                            this.sGg = null;
                            this.state = 8;
                        }
                        return this;
                    }
                } catch (Throwable e3) {
                    e = e3;
                    z = false;
                    w.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.sEX, e);
                    j.u(this.sFf, 45);
                    j.u(this.sFf, 18);
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.sEX, Boolean.valueOf(z));
                    if (z) {
                        j.u(this.sFf, 17);
                        this.sGg = this.sGh;
                        if (this.sFG) {
                            this.state = 4;
                        } else {
                            this.sGh = this.filePath + ".decompressed";
                            this.state = 2;
                        }
                    } else {
                        this.sGg = null;
                        this.state = 8;
                    }
                    return this;
                }
                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.sEX, Boolean.valueOf(z));
                if (z) {
                    this.sGg = null;
                    this.state = 8;
                } else {
                    j.u(this.sFf, 17);
                    this.sGg = this.sGh;
                    if (this.sFG) {
                        this.sGh = this.filePath + ".decompressed";
                        this.state = 2;
                    } else {
                        this.state = 4;
                    }
                }
            }
        }
        return this;
    }

    final l bDx() {
        Throwable e;
        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", this.sEX, bDz(), this.sGg, this.sGh);
        if (2 == this.state) {
            boolean z;
            try {
                String str = this.sGg;
                String str2 = this.sGh;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    new File(str2).delete();
                    byte[] q = q.q(a.Mx(str));
                    if (bg.bm(q)) {
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
                        z = false;
                    } else {
                        z = a.v(str2, q);
                    }
                } else {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                    z = false;
                }
                try {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", this.sEX, Boolean.valueOf(z));
                } catch (Exception e2) {
                    e = e2;
                    w.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.sEX, e);
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.sEX, Boolean.valueOf(z));
                    if (z) {
                        this.sGg = this.sGh;
                        this.state = 4;
                        j.u(this.sFf, 19);
                    } else {
                        this.sGg = null;
                        this.state = 8;
                        j.u(this.sFf, 20);
                        j.u(this.sFf, 46);
                        if (this.sFH) {
                            j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, false, false, this.sFg);
                        } else {
                            j.a(this.fEB, this.fEC, this.url, this.fED, this.sFh > this.sFi ? j.a.sGa : j.a.sFY, false, this.fEH, false, this.sFg);
                        }
                    }
                    return this;
                }
            } catch (Throwable e3) {
                e = e3;
                z = false;
                w.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.sEX, e);
                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.sEX, Boolean.valueOf(z));
                if (z) {
                    this.sGg = null;
                    this.state = 8;
                    j.u(this.sFf, 20);
                    j.u(this.sFf, 46);
                    if (this.sFH) {
                        if (this.sFh > this.sFi) {
                        }
                        j.a(this.fEB, this.fEC, this.url, this.fED, this.sFh > this.sFi ? j.a.sGa : j.a.sFY, false, this.fEH, false, this.sFg);
                    } else {
                        j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, false, false, this.sFg);
                    }
                } else {
                    this.sGg = this.sGh;
                    this.state = 4;
                    j.u(this.sFf, 19);
                }
                return this;
            }
            w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.sEX, Boolean.valueOf(z));
            if (z) {
                this.sGg = this.sGh;
                this.state = 4;
                j.u(this.sFf, 19);
            } else {
                this.sGg = null;
                this.state = 8;
                j.u(this.sFf, 20);
                j.u(this.sFf, 46);
                if (this.sFH) {
                    j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, false, false, this.sFg);
                } else if (this.sFG && this.fEE) {
                    if (this.sFh > this.sFi) {
                    }
                    j.a(this.fEB, this.fEC, this.url, this.fED, this.sFh > this.sFi ? j.a.sGa : j.a.sFY, false, this.fEH, false, this.sFg);
                }
            }
        } else if (8 == this.state && this.sFH) {
            j.a(this.fEB, this.fEC, this.sFb, this.fEH, false, false, false, this.sFg);
        }
        return this;
    }

    final String bDy() {
        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + bDz(), this.sEX);
        if (16 == this.state) {
            return this.sGg;
        }
        if (4 != this.state && 32 != this.state) {
            return null;
        }
        String str;
        if (!bg.mA(this.sGg)) {
            String str2;
            String str3 = "MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer";
            String str4 = "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s";
            Object[] objArr = new Object[4];
            objArr[0] = this.sEX;
            objArr[1] = bDz();
            objArr[2] = this.sFd;
            if (this.sFc == null) {
                str2 = "null";
            } else {
                str2 = String.valueOf(this.sFc.length);
            }
            objArr[3] = str2;
            w.i(str3, str4, objArr);
            if (bg.mA(this.sFd) || !bg.mz(g.aV(this.sGg)).equals(this.sFd)) {
                if (this.state == 4) {
                    j.u(this.sFf, 24);
                }
                if (!bg.bm(this.sFc) && UtilsJni.doEcdsaSHAVerify(i.sFJ, a.Mx(this.sGg), this.sFc) > 0) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", this.sEX, bDz());
                    if (this.state == 4) {
                        j.u(this.sFf, 25);
                    }
                    str = this.sGg;
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.sEX, str);
                    if (this.state == 4) {
                        return str;
                    }
                    if (bg.mA(str) && !this.sFG) {
                        j.u(this.sFf, 58);
                        j.u(this.sFf, 45);
                    }
                    if (bg.mA(str)) {
                        if (this.sFH) {
                            j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, true, false, this.sFg);
                            return str;
                        } else if (this.sFG && this.fEE) {
                            j.a(this.fEB, this.fEC, this.url, this.fED, this.sFh > this.sFi ? j.a.sGa : j.a.sFY, false, this.fEH, true, this.sFg);
                            return str;
                        }
                    } else if (this.sFH) {
                        j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, true, true, this.sFg);
                        return str;
                    } else if (this.sFG && this.fEE) {
                        j.a(this.fEB, this.fEC, this.url, this.fED, this.sFh > this.sFi ? j.a.sGa : j.a.sFY, true, this.fEH, true, this.sFg);
                        return str;
                    }
                } else if (this.state == 4) {
                    j.u(this.sFf, 26);
                }
            } else {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", this.sEX, bDz());
                if (this.state == 4) {
                    j.u(this.sFf, 23);
                }
                str = this.sGg;
                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.sEX, str);
                if (this.state == 4) {
                    return str;
                }
                j.u(this.sFf, 58);
                j.u(this.sFf, 45);
                if (bg.mA(str)) {
                    if (this.sFH) {
                        return this.sFG ? str : str;
                    } else {
                        j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, true, true, this.sFg);
                        return str;
                    }
                } else if (this.sFH) {
                    return this.sFG ? str : str;
                } else {
                    j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, true, false, this.sFg);
                    return str;
                }
            }
        }
        str = null;
        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.sEX, str);
        if (this.state == 4) {
            return str;
        }
        j.u(this.sFf, 58);
        j.u(this.sFf, 45);
        if (bg.mA(str)) {
            if (this.sFH) {
                j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, true, false, this.sFg);
                return str;
            } else if (this.sFG) {
            }
        } else if (this.sFH) {
            j.a(this.fEB, this.fEC, this.sFb, this.fEH, true, true, true, this.sFg);
            return str;
        } else if (this.sFG) {
        }
    }

    final String bDz() {
        switch (this.state) {
            case 1:
                return "state_decrypt";
            case 2:
                return "state_decompress";
            case 4:
                return "state_check_sum";
            case 8:
                return "state_file_invalid";
            case 16:
                return "state_file_valid";
            case 32:
                return "state_pre_verify_check_sum";
            default:
                return this.state;
        }
    }
}
