package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public final class b extends c {
    public String[] fFb;
    public byte[] htN;
    public byte[] idY;
    public byte[] iea;
    public int uin;
    private int uqo = 0;
    private final int uqp = 5;
    public int uqq = 0;
    public com.tencent.mm.sandbox.b.a uqr;
    private a uqs = null;
    private com.tencent.mm.sandbox.b.a uqt = new com.tencent.mm.sandbox.b.a(this) {
        final /* synthetic */ b uqu;

        {
            this.uqu = r1;
        }

        public final void a(int i, int i2, avp com_tencent_mm_protocal_c_avp) {
            int a;
            if (i == m.CTRL_INDEX && i2 == 0 && (com_tencent_mm_protocal_c_avp == null || com_tencent_mm_protocal_c_avp.tZe.thX == 0)) {
                acc com_tencent_mm_protocal_c_acc = (acc) com_tencent_mm_protocal_c_avp;
                w.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + e.hgs);
                w.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + com_tencent_mm_protocal_c_acc.tgJ);
                w.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + com_tencent_mm_protocal_c_acc.tgK);
                w.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + com_tencent_mm_protocal_c_acc.tgL);
                if (com_tencent_mm_protocal_c_acc.tgL <= 0 || com_tencent_mm_protocal_c_acc.tsk == null) {
                    w.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
                    this.uqu.uqr.a(i, -1, null);
                    return;
                } else if (com_tencent_mm_protocal_c_acc.tsk.tZn != com_tencent_mm_protocal_c_acc.tgL) {
                    w.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + com_tencent_mm_protocal_c_acc.tgL + " data buf len = " + com_tencent_mm_protocal_c_acc.tsk.tZn);
                    this.uqu.uqr.a(4, -1, null);
                    return;
                } else if (com_tencent_mm_protocal_c_acc.tgK < 0 || com_tencent_mm_protocal_c_acc.tgK + com_tencent_mm_protocal_c_acc.tgL > com_tencent_mm_protocal_c_acc.tgJ) {
                    w.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + com_tencent_mm_protocal_c_acc.tgK + " dataLen = " + com_tencent_mm_protocal_c_acc.tgL + " totalLen = " + com_tencent_mm_protocal_c_acc.tgJ);
                    this.uqu.uqr.a(4, -1, null);
                    return;
                } else if (com_tencent_mm_protocal_c_acc.tgJ <= 0) {
                    w.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + com_tencent_mm_protocal_c_acc.tgJ);
                    this.uqu.uqr.a(4, -1, null);
                    return;
                } else {
                    a = com.tencent.mm.a.e.a(c.upU, this.uqu.upY, ".temp", com_tencent_mm_protocal_c_acc.tsk.tZp.toByteArray());
                    if (a != 0) {
                        w.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : " + a);
                        this.uqu.uqr.a(4, -1, null);
                        return;
                    }
                    this.uqu.upX = com_tencent_mm_protocal_c_acc.tgL + com_tencent_mm_protocal_c_acc.tgK;
                    this.uqu.upW = com_tencent_mm_protocal_c_acc.tgJ;
                    this.uqu.uqr.cx(com_tencent_mm_protocal_c_acc.tgJ, com_tencent_mm_protocal_c_acc.tgK);
                    if (com_tencent_mm_protocal_c_acc.tgK + com_tencent_mm_protocal_c_acc.tgL >= com_tencent_mm_protocal_c_acc.tgJ) {
                        try {
                            if (this.uqu.upY.equalsIgnoreCase(g.aV(this.uqu.aLB()))) {
                                com.tencent.mm.a.e.h(c.upU, this.uqu.upY + ".temp", this.uqu.upY + ".apk");
                                this.uqu.uqr.a(m.CTRL_INDEX, 0, com_tencent_mm_protocal_c_avp);
                                return;
                            }
                            w.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
                            new File(this.uqu.aLB()).delete();
                            this.uqu.uqr.a(-1, -1, com_tencent_mm_protocal_c_avp);
                            return;
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e, "", new Object[0]);
                            return;
                        }
                    }
                    this.uqu.a(this.uqu.uqr);
                    return;
                }
            }
            if (!this.uqu.bHN()) {
                b bVar = this.uqu;
                a = bVar.uqq + 1;
                bVar.uqq = a;
                if (a < this.uqu.fFb.length * 5) {
                    this.uqu.a(this.uqu.uqr);
                    return;
                }
            }
            this.uqu.uqr.a(i, i2, com_tencent_mm_protocal_c_avp);
        }

        public final void eq(long j) {
            this.uqu.uqr.eq(j);
        }

        public final void er(long j) {
            this.uqu.uqr.er(j);
        }

        public final void cx(int i, int i2) {
        }
    };

    private class a extends AsyncTask<acb, Integer, acc> {
        private String host = null;
        private t oBf = null;
        private com.tencent.mm.sandbox.b.a uqr = null;
        final /* synthetic */ b uqu;
        private int uqv = m.CTRL_INDEX;
        private PInt uqw = new PInt();

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((acb[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            acc com_tencent_mm_protocal_c_acc = (acc) obj;
            w.d("MicroMsg.NetSceneGetUpdatePack", "onPostExecute, netRet=" + this.uqv + ", svrRet=" + this.uqw.value + ", result=" + com_tencent_mm_protocal_c_acc);
            this.uqr.a(this.uqv, this.uqw.value, com_tencent_mm_protocal_c_acc);
        }

        public a(b bVar, String str, com.tencent.mm.sandbox.b.a aVar) {
            this.uqu = bVar;
            this.host = str;
            this.uqr = aVar;
        }

        private acc a(acb... com_tencent_mm_protocal_c_acbArr) {
            OutputStream outputStream;
            Throwable e;
            InputStream inputStream;
            OutputStream outputStream2;
            if (com_tencent_mm_protocal_c_acbArr.length == 0 || com_tencent_mm_protocal_c_acbArr[0] == null) {
                this.uqv = -1;
                return null;
            }
            w.d("MicroMsg.NetSceneGetUpdatePack", "doInBackground, params=" + com_tencent_mm_protocal_c_acbArr[0]);
            acb com_tencent_mm_protocal_c_acb = com_tencent_mm_protocal_c_acbArr[0];
            PByteArray pByteArray = new PByteArray();
            int i = 6;
            if (com.tencent.mm.sdk.a.b.foreground) {
                i = 7;
            }
            try {
                MMProtocalJni.pack(com_tencent_mm_protocal_c_acb.toByteArray(), pByteArray, this.uqu.idY, this.uqu.htN, p.rB(), this.uqu.uin, 113, 0, new byte[0], new byte[0], this.uqu.iea, i);
                InputStream inputStream2 = null;
                try {
                    this.oBf = com.tencent.mm.network.b.a("http://" + this.host + "/cgi-bin/micromsg-bin/getupdatepack", null);
                    this.oBf.setRequestMethod("POST");
                    this.oBf.MA();
                    this.oBf.MB();
                    this.oBf.setUseCaches(false);
                    this.oBf.setRequestProperty("User-Agent", "Android QQMail HTTP Client");
                    this.oBf.setRequestProperty("Connection", "Keep-Alive");
                    this.oBf.setRequestProperty("Cache-Control", "no-cache");
                    this.oBf.setRequestProperty("Content-Type", "application/octet-stream");
                    this.oBf.setRequestProperty("accept", "*/*");
                    this.oBf.setRequestProperty("Accept-Charset", "UTF-8");
                    this.oBf.setConnectTimeout(15000);
                    this.oBf.connect();
                    outputStream = this.oBf.getOutputStream();
                    try {
                        outputStream.write(pByteArray.value);
                        outputStream.flush();
                        this.uqr.eq(150 + ((long) pByteArray.value.length));
                        this.uqv = this.oBf.getResponseCode();
                        if (this.uqv != m.CTRL_INDEX) {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                                }
                            }
                            if (this.oBf != null) {
                                this.oBf.ieZ.disconnect();
                                this.oBf = null;
                            }
                            return null;
                        }
                        Object obj;
                        InputStream inputStream3;
                        String headerField = this.oBf.getHeaderField("Content-Encoding");
                        InputStream inputStream4 = this.oBf.getInputStream();
                        long j = 150;
                        if (headerField == null || !headerField.contains("gzip")) {
                            obj = null;
                            inputStream3 = inputStream4;
                        } else {
                            inputStream3 = new GZIPInputStream(inputStream4);
                            obj = 1;
                        }
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = inputStream3.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                j += (long) read;
                            }
                            if (obj == null || !inputStream4.markSupported()) {
                                this.uqr.er(j);
                            } else {
                                inputStream4.mark(1);
                                j = 150;
                                while (true) {
                                    int read2 = inputStream4.read(bArr);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    j += (long) read2;
                                }
                                this.uqr.er(j);
                            }
                            PByteArray pByteArray2 = new PByteArray();
                            MMProtocalJni.unpack(pByteArray2, byteArrayOutputStream.toByteArray(), this.uqu.idY, new PByteArray(), this.uqw, new PInt(), new PInt(0));
                            acc com_tencent_mm_protocal_c_acc = (acc) new acc().aD(pByteArray2.value);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e3) {
                                    w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3, "", new Object[0]);
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Throwable e32) {
                                    w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e32, "", new Object[0]);
                                }
                            }
                            if (this.oBf == null) {
                                return com_tencent_mm_protocal_c_acc;
                            }
                            this.oBf.ieZ.disconnect();
                            this.oBf = null;
                            return com_tencent_mm_protocal_c_acc;
                        } catch (Exception e4) {
                            e2 = e4;
                            inputStream = inputStream3;
                            outputStream2 = outputStream;
                            try {
                                w.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e2.getMessage());
                                w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                                this.uqv = -1;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Throwable e22) {
                                        w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e22, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e222) {
                                        w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                                    }
                                }
                                if (this.oBf != null) {
                                    this.oBf.ieZ.disconnect();
                                    this.oBf = null;
                                }
                                return null;
                            } catch (Throwable th) {
                                e222 = th;
                                outputStream = outputStream2;
                                inputStream2 = inputStream;
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable e322) {
                                        w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e322, "", new Object[0]);
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e3222) {
                                        w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3222, "", new Object[0]);
                                    }
                                }
                                if (this.oBf != null) {
                                    this.oBf.ieZ.disconnect();
                                    this.oBf = null;
                                }
                                throw e222;
                            }
                        } catch (Throwable th2) {
                            e222 = th2;
                            inputStream2 = inputStream3;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (this.oBf != null) {
                                this.oBf.ieZ.disconnect();
                                this.oBf = null;
                            }
                            throw e222;
                        }
                    } catch (Exception e5) {
                        e222 = e5;
                        inputStream = null;
                        outputStream2 = outputStream;
                        w.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e222.getMessage());
                        w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                        this.uqv = -1;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (this.oBf != null) {
                            this.oBf.ieZ.disconnect();
                            this.oBf = null;
                        }
                        return null;
                    } catch (Throwable th3) {
                        e222 = th3;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (this.oBf != null) {
                            this.oBf.ieZ.disconnect();
                            this.oBf = null;
                        }
                        throw e222;
                    }
                } catch (Exception e6) {
                    e222 = e6;
                    inputStream = null;
                    outputStream2 = null;
                    w.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e222.getMessage());
                    w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                    this.uqv = -1;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (this.oBf != null) {
                        this.oBf.ieZ.disconnect();
                        this.oBf = null;
                    }
                    return null;
                } catch (Throwable th4) {
                    e222 = th4;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (this.oBf != null) {
                        this.oBf.ieZ.disconnect();
                        this.oBf = null;
                    }
                    throw e222;
                }
            } catch (Throwable e2222) {
                w.e("MicroMsg.NetSceneGetUpdatePack", "Exception in MMProtocalJni.pack(), [%s]", e2222.getMessage());
                w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2222, "", new Object[0]);
                return null;
            }
        }

        protected final void onCancelled() {
            w.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
            if (this.oBf != null) {
                this.oBf.ieZ.disconnect();
            }
        }
    }

    public b(int i, String str, int i2, int i3, byte[] bArr, byte[] bArr2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.fFb = strArr;
        if (strArr == null || strArr.length == 0) {
            this.fFb = new String[]{"short.weixin.qq.com"};
        }
        this.uin = i3;
        this.idY = bArr;
        this.htN = bArr2;
    }

    public final void a(com.tencent.mm.sandbox.b.a aVar) {
        this.uqr = aVar;
        int i = this.uqo + 1;
        this.uqo = i;
        if (i > 1000) {
            w.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
            this.uqr.a(-1, -1, null);
        } else if (f.G((long) this.upW)) {
            avh com_tencent_mm_protocal_c_acb = new acb();
            em emVar = new em();
            emVar.tiC = d.sYN;
            emVar.tdM = 0;
            emVar.leD = this.uin;
            emVar.tiB = com.tencent.mm.bd.b.aU(p.rB().getBytes());
            if (emVar.tiB.sYA.length >= 16) {
                emVar.tiB = emVar.tiB.xV(16);
            }
            emVar.tiD = com.tencent.mm.bd.b.aU(d.DEVICE_TYPE.getBytes());
            if (emVar.tiD.sYA.length >= 132) {
                emVar.tiD = emVar.tiD.xV(132);
            }
            emVar.tiA = com.tencent.mm.bd.b.aU(this.idY);
            if (emVar.tiA.sYA.length >= 36) {
                emVar.tiA = emVar.tiA.xV(36);
            }
            com_tencent_mm_protocal_c_acb.tYN = emVar;
            com_tencent_mm_protocal_c_acb.tHy = this.upV;
            com_tencent_mm_protocal_c_acb.tgK = this.upX;
            com_tencent_mm_protocal_c_acb.tgJ = this.upW;
            a aVar2 = new a(this, this.fFb[this.uqq / 5], this.uqt);
            this.uqs = aVar2;
            aVar2.execute(new acb[]{com_tencent_mm_protocal_c_acb});
        } else {
            w.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", Integer.valueOf(this.upW));
            aVar.a(-1, -1, null);
        }
    }

    public final void cancel() {
        w.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.upV);
        if (this.uqs != null && !this.uqs.isCancelled()) {
            this.uqs.cancel(true);
        }
    }
}
