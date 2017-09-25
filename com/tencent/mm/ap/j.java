package com.tencent.mm.ap;

import com.tencent.mm.e.a.lm;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.m;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public final class j extends k implements com.tencent.mm.network.j, m {
    public int fFz;
    private b gUA;
    private e gUD;
    public int hOj;
    private int offset = 0;

    public j(int i, int i2) {
        this.hOj = i;
        this.fFz = i2;
        m aQ = t.Ic().aQ(i, i2);
        if (aQ == null) {
            w.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:" + i);
            return;
        }
        aQ.status = 3;
        aQ.fRW = 64;
        t.Ic().b(aQ);
        if (i2 == 5) {
            com.tencent.mm.loader.stub.b.deleteFile(h.vI().cachePath + "brand_i18n.apk");
            return;
        }
        com.tencent.mm.loader.stub.b.deleteFile(n.HY() + t.Ic().aS(i, i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", Integer.valueOf(this.hOj), Integer.valueOf(this.fFz));
        m aQ = t.Ic().aQ(this.hOj, this.fFz);
        if (aQ == null) {
            w.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.hOj + " type:" + this.fFz);
            return -1;
        } else if (aQ.status != 3) {
            w.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.hOj + " stat:" + aQ.status);
            return -1;
        } else if (aQ.size <= 0) {
            w.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.hOj + " size:" + aQ.size);
            return -1;
        } else {
            a aVar = new a();
            aVar.hsm = new oh();
            aVar.hsn = new oi();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            aVar.hsl = JsApiSetBackgroundAudioState.CTRL_INDEX;
            aVar.hso = 0;
            aVar.hsp = 0;
            this.gUA = aVar.BE();
            oh ohVar = (oh) this.gUA.hsj.hsr;
            apb com_tencent_mm_protocal_c_apb = new apb();
            com_tencent_mm_protocal_c_apb.mvT = aQ.id;
            com_tencent_mm_protocal_c_apb.jOb = aQ.version;
            ohVar.ttS = com_tencent_mm_protocal_c_apb;
            ohVar.tll = this.offset;
            ohVar.ttT = 65536;
            ohVar.jOc = this.fFz;
            return a(eVar, this.gUA, this);
        }
    }

    protected final int a(p pVar) {
        oh ohVar = (oh) ((b) pVar).hsj.hsr;
        m aQ = t.Ic().aQ(this.hOj, this.fFz);
        if (aQ == null) {
            w.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.hOj);
            return b.hsU;
        } else if (ohVar.ttS.mvT == this.hOj && ohVar.tll == this.offset && ohVar.tll < aQ.size && ohVar.ttT == 65536 && aQ.size > 0 && aQ.status == 3) {
            return b.hsT;
        } else {
            w.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.hOj);
            return b.hsU;
        }
    }

    protected final int ub() {
        return 50;
    }

    protected final void a(a aVar) {
        t.Ic().aU(this.hOj, this.fFz);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.hOj + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 || i3 == 0) {
            oi oiVar = (oi) ((b) pVar).hsk.hsr;
            if (oiVar.jOc != this.fFz) {
                w.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                t.Ic().aU(this.hOj, this.fFz);
                this.gUD.a(3, -1, "", this);
                return;
            }
            byte[] a = n.a(oiVar.ttU);
            if (a == null || a.length == 0) {
                w.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.hOj);
                t.Ic().aU(this.hOj, this.fFz);
                this.gUD.a(3, -1, str, this);
                return;
            }
            m aQ = t.Ic().aQ(this.hOj, this.fFz);
            if (aQ == null) {
                w.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.hOj);
                t.Ic().aU(this.hOj, this.fFz);
                this.gUD.a(3, -1, str, this);
                return;
            } else if (aQ.size != oiVar.ttV) {
                w.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                t.Ic().aU(this.hOj, this.fFz);
                h.vH().gXC.a(new k(this.fFz), 0);
                this.gUD.a(3, -1, str, this);
                return;
            } else {
                String str2;
                String str3;
                if (this.fFz == 5) {
                    str2 = h.vI().cachePath;
                    str3 = "brand_i18n.apk";
                } else {
                    t.Ic();
                    str2 = n.HY();
                    str3 = t.Ic().aS(this.hOj, this.fFz);
                }
                w.d("MicroMsg.NetSceneDownloadPackage", "packagePath " + str2);
                w.d("MicroMsg.NetSceneDownloadPackage", "packageName " + str3);
                int a2 = com.tencent.mm.a.e.a(str2, str3, a);
                if (a2 != 0) {
                    t.Ic().aU(this.hOj, this.fFz);
                    w.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = " + a2);
                    this.gUD.a(3, -1, str, this);
                    return;
                }
                this.offset = a.length + this.offset;
                if (this.offset >= aQ.size) {
                    String aT;
                    boolean z = false;
                    if (this.fFz == 1) {
                        aT = t.Ic().aT(this.hOj, this.fFz);
                        a2 = bg.eA(str2 + str3, aT);
                        if (a2 < 0) {
                            w.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + aT);
                            t.Ic().aU(this.hOj, this.fFz);
                            this.gUD.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.fFz == 8) {
                        z = ae(str2, str3);
                    }
                    if (this.fFz == 23) {
                        if (bg.mA(str2) || bg.mA(str3)) {
                            w.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", str2, str3);
                            t.Ic().aU(this.hOj, this.fFz);
                            this.gUD.a(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.p(str2 + str3, com.tencent.mm.compatible.util.e.hgq + "permissioncfg.cfg")) {
                                w.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                t.Ic().aU(this.hOj, this.fFz);
                                this.gUD.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            w.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", str2, str3);
                            t.Ic().aU(this.hOj, this.fFz);
                            this.gUD.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.fFz == 7) {
                        z = true;
                    }
                    if (this.fFz == 9) {
                        z = true;
                    }
                    if (this.fFz == 5) {
                        z = true;
                        w.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
                    }
                    if (this.fFz == 12) {
                        com.tencent.mm.sdk.b.b lmVar = new lm();
                        lmVar.fSt.fSv = str2 + str3;
                        com.tencent.mm.sdk.b.a.urY.m(lmVar);
                        z = true;
                    }
                    if (this.fFz == 18) {
                        aT = t.Ic().aT(this.hOj, this.fFz);
                        a2 = bg.eA(str2 + str3, aT);
                        if (a2 < 0) {
                            w.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + aT);
                            t.Ic().aU(this.hOj, this.fFz);
                            this.gUD.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            w.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", aT);
                            z = true;
                        }
                    }
                    if (this.fFz == 20) {
                        z = true;
                    }
                    if (this.fFz == 21) {
                        z = true;
                    }
                    if (this.fFz == 26) {
                        if (bg.mA(str2) || bg.mA(str3)) {
                            w.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", str2, str3);
                            this.gUD.a(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.p(str2 + str3, com.tencent.mm.compatible.util.e.hgq + "ipcallCountryCodeConfig.cfg")) {
                                w.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                t.Ic().aU(this.hOj, this.fFz);
                                this.gUD.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                w.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        } else {
                            w.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", str2, str3);
                            t.Ic().aU(this.hOj, this.fFz);
                            this.gUD.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.fFz == 36) {
                        z = ad(str2, str3);
                    }
                    if (z) {
                        aQ.status = 2;
                        aQ.fRW = 64;
                        t.Ic().b(aQ);
                        this.gUD.a(0, 0, "", this);
                        return;
                    }
                    return;
                } else if (a(this.hsD, this.gUD) < 0) {
                    t.Ic().aU(this.hOj, this.fFz);
                    this.gUD.a(3, -1, str, this);
                    return;
                } else {
                    return;
                }
            }
        }
        w.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        t.Ic().aU(this.hOj, this.fFz);
        this.gUD.a(i2, i3, str, this);
    }

    private static boolean ad(String str, String str2) {
        Throwable e;
        boolean z = true;
        if (bg.mA(str) || bg.mA(str2)) {
            return false;
        }
        try {
            String str3 = str + str2;
            Object aT = com.tencent.mm.a.e.aT(str3);
            if (bg.mA(aT)) {
                z = false;
            } else {
                h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_SENSE_WHERE_LOCATION_STRING, aT);
            }
            try {
                com.tencent.mm.loader.stub.b.deleteFile(str3);
                w.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", Boolean.valueOf(z), str3, bg.Qj(aT));
                return z;
            } catch (IOException e2) {
                e = e2;
                w.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
                return z;
            }
        } catch (Throwable e3) {
            e = e3;
            z = false;
            w.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
            return z;
        }
    }

    private boolean ae(String str, String str2) {
        InputStream fileInputStream;
        Throwable e;
        Throwable th;
        InputStream inputStream = null;
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, no file assigned, packagePath:" + str + " ,packageName:" + str2);
            t.Ic().aU(this.hOj, this.fFz);
            this.gUD.a(3, 0, "open regioncode file fail", this);
            return false;
        }
        File file = new File(str + str2);
        if (file.exists()) {
            Map hashMap = new HashMap();
            BufferedWriter bufferedWriter;
            try {
                String RQ;
                File file2;
                fileInputStream = new FileInputStream(file);
                Reader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.trim().split("\\|");
                    if (split.length < 2 || bg.mA(split[0]) || bg.mA(split[1])) {
                        w.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, error line = " + readLine);
                    } else {
                        bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                        if (bufferedWriter == null) {
                            RegionCodeDecoder.bMP();
                            RQ = RegionCodeDecoder.RQ(split[0]);
                            if (bg.mA(RQ)) {
                                w.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, output language unsupported");
                            } else {
                                try {
                                    file2 = new File(RQ);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                                    hashMap.put(split[0], bufferedWriter);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(split[1]);
                        stringBuffer.append('|');
                        stringBuffer.append(split[2]);
                        stringBuffer.append('\n');
                        bufferedWriter.write(stringBuffer.toString());
                    }
                }
                for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.flush();
                    }
                }
                if (!bg.mA(RQ)) {
                    for (File file22 : new File(RQ).getParentFile().listFiles(new FileFilter(this) {
                        final /* synthetic */ j hOk;

                        {
                            this.hOk = r1;
                        }

                        public final boolean accept(File file) {
                            return file.getName().endsWith("txt");
                        }
                    })) {
                        RegionCodeDecoder.bMP();
                        RegionCodeDecoder.d(file22, file22.getParentFile());
                    }
                    RegionCodeDecoder.bMP().bKR();
                }
                bufferedReader.close();
                inputStreamReader.close();
                file.delete();
                try {
                    fileInputStream.close();
                    for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                        if (bufferedWriter22 != null) {
                            bufferedWriter22.close();
                        }
                    }
                } catch (Throwable e3) {
                    w.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bg.g(e3));
                }
                return true;
            } catch (Exception e4) {
                e3 = e4;
                fileInputStream = null;
                try {
                    w.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bg.g(e3));
                    t.Ic().aU(this.hOj, this.fFz);
                    this.gUD.a(3, 0, e3.getMessage(), this);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e32) {
                            w.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bg.g(e32));
                            return false;
                        }
                    }
                    for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                        if (bufferedWriter222 != null) {
                            bufferedWriter222.close();
                        }
                    }
                    return false;
                } catch (Throwable e322) {
                    inputStream = fileInputStream;
                    th = e322;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3222) {
                            w.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bg.g(e3222));
                            throw th;
                        }
                    }
                    for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                        if (bufferedWriter2222 != null) {
                            bufferedWriter2222.close();
                        }
                    }
                    throw th;
                }
            } catch (Throwable e32222) {
                th = e32222;
                if (inputStream != null) {
                    inputStream.close();
                }
                for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                    if (bufferedWriter22222 != null) {
                        bufferedWriter22222.close();
                    }
                }
                throw th;
            }
        }
        w.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, file not exist, packagePath:" + str + " ,packageName:" + str2);
        t.Ic().aU(this.hOj, this.fFz);
        this.gUD.a(3, 0, "no regioncode file found", this);
        return false;
    }

    public final int getType() {
        return JsApiSetBackgroundAudioState.CTRL_INDEX;
    }

    public final int BQ() {
        return this.fFz;
    }
}
