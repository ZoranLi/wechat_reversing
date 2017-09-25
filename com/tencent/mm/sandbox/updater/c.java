package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public final class c extends com.tencent.mm.sandbox.monitor.c {
    public String fvo;
    public boolean hKd = false;
    public int kdg = 0;
    public String mLR;
    public ae uqA = new ae(this) {
        final /* synthetic */ c uqC;

        {
            this.uqC = r1;
        }

        public final void handleMessage(Message message) {
            if (1 == message.what && !this.uqC.hKd) {
                new File(this.uqC.aLB()).delete();
                if (message.arg1 == 0) {
                    w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                    this.uqC.uqr.a(m.CTRL_INDEX, 0, (avp) message.obj);
                } else if (message.arg1 == 3) {
                    this.uqC.uqr.a(3, -1, (avp) message.obj);
                } else if (message.arg1 == 4) {
                    this.uqC.uqr.a(4, -1, (avp) message.obj);
                }
            }
            super.handleMessage(message);
        }
    };
    private com.tencent.mm.sandbox.b.a uqB = new com.tencent.mm.sandbox.b.a(this) {
        final /* synthetic */ c uqC;

        {
            this.uqC = r1;
        }

        public final void cx(int i, int i2) {
            w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i + ", offset=" + i2);
            this.uqC.uqr.cx(i, i2);
        }

        public final void a(int i, int i2, avp com_tencent_mm_protocal_c_avp) {
            if (i != 0) {
                w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + i);
                if (i == -2) {
                    new File(this.uqC.aLB()).delete();
                }
                c cVar = this.uqC;
                cVar.kdg++;
                this.uqC.a(this.uqC.uqr);
                return;
            }
            w.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
            try {
                if (e.aN(this.uqC.aLB()) < this.uqC.upW) {
                    w.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                    this.uqC.a(this.uqC.uqr);
                } else if (this.uqC.uqz) {
                    if (this.uqC.fvo.equalsIgnoreCase(g.aV(this.uqC.aLB()))) {
                        c cVar2 = this.uqC;
                        try {
                            w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
                            com.tencent.mm.sdk.f.e.post(new AnonymousClass2(cVar2, com_tencent_mm_protocal_c_avp), "NetSceneGetUpdatePackFromCDN_genApk");
                            return;
                        } catch (Throwable e) {
                            w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
                            w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.arg1 = 3;
                            obtain.obj = com_tencent_mm_protocal_c_avp;
                            cVar2.uqA.sendMessage(obtain);
                            return;
                        }
                    }
                    w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                    new File(this.uqC.aLB()).delete();
                    this.uqC.uqr.a(2, -1, com_tencent_mm_protocal_c_avp);
                } else if (this.uqC.upY.equalsIgnoreCase(g.aV(this.uqC.aLB()))) {
                    e.h(com.tencent.mm.sandbox.monitor.c.upU, this.uqC.upY + ".temp", this.uqC.upY + ".apk");
                    this.uqC.uqr.a(m.CTRL_INDEX, 0, com_tencent_mm_protocal_c_avp);
                } else {
                    w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                    new File(this.uqC.aLB()).delete();
                    this.uqC.uqr.a(-1, -1, com_tencent_mm_protocal_c_avp);
                }
            } catch (Throwable e2) {
                w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
                w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                this.uqC.uqr.a(-1, -1, com_tencent_mm_protocal_c_avp);
            }
        }

        public final void eq(long j) {
            this.uqC.uqr.eq(j);
        }

        public final void er(long j) {
            this.uqC.uqr.er(j);
        }
    };
    public com.tencent.mm.sandbox.b.a uqr;
    private String[] uqx;
    private a uqy = null;
    public boolean uqz = false;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ c uqC;
        final /* synthetic */ avp uqD;

        AnonymousClass2(c cVar, avp com_tencent_mm_protocal_c_avp) {
            this.uqC = cVar;
            this.uqD = com_tencent_mm_protocal_c_avp;
        }

        public final void run() {
            w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = this.uqD;
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            int e = i.e(ab.getContext(), this.uqC.aLB(), this.uqC.bHM(), this.uqC.mLR);
            w.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
            if (e == 0) {
                w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
                obtain.arg1 = 0;
                this.uqC.uqA.sendMessage(obtain);
                return;
            }
            w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
            File file = new File(this.uqC.bHM());
            if (file.exists()) {
                file.delete();
            }
            if (e == -1) {
                w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
                obtain.arg1 = 3;
                this.uqC.uqA.sendMessage(obtain);
            } else if (e == -2) {
                w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
                obtain.arg1 = 4;
                this.uqC.uqA.sendMessage(obtain);
            }
        }
    }

    private class a extends AsyncTask<String, Integer, Integer> {
        private int aPh;
        private HttpClient ozy = null;
        private int size;
        final /* synthetic */ c uqC;
        private HttpPost uqE = null;
        private HttpResponse uqF = null;
        private HttpEntity uqG = null;
        private OutputStream uqH = new OutputStream(this) {
            private ae handler = new ae(Looper.getMainLooper());
            private ByteArrayOutputStream uqI = new ByteArrayOutputStream();
            final /* synthetic */ a uqJ;

            {
                this.uqJ = r3;
            }

            public final void write(byte[] bArr, int i, int i2) {
                this.uqI.write(bArr, i, i2);
                if (this.uqI.size() >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || this.uqJ.aPh + this.uqI.size() >= this.uqJ.size) {
                    final int size = this.uqI.size();
                    int a = e.a(this.uqJ.uqC.aLB(), this.uqI.toByteArray(), size);
                    this.uqI.reset();
                    if (a != 0) {
                        throw new IOException("appendToFile failed :" + a);
                    }
                    this.uqJ.aPh = this.uqJ.aPh + size;
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 uqL;

                        public final void run() {
                            if (this.uqL.uqJ.aPh <= this.uqL.uqJ.size) {
                                this.uqL.uqJ.uqr.cx(this.uqL.uqJ.size, this.uqL.uqJ.aPh);
                            }
                            this.uqL.uqJ.uqr.er((long) size);
                        }
                    });
                    if (this.uqJ.uqC.hKd) {
                        throw new IOException("manual force cancel!");
                    }
                }
            }

            public final void write(int i) {
                throw new IOException("unexpected operation");
            }
        };
        private com.tencent.mm.sandbox.b.a uqr;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return C((String[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            this.uqr.a(((Integer) obj).intValue(), 0, null);
        }

        public a(c cVar, int i, int i2, com.tencent.mm.sandbox.b.a aVar) {
            this.uqC = cVar;
            this.size = i;
            this.aPh = i2;
            this.uqr = aVar;
        }

        private Integer C(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                return Integer.valueOf(-1);
            }
            w.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.aPh);
            this.ozy = new DefaultHttpClient();
            this.ozy.getParams().setIntParameter("http.connection.timeout", 15000);
            this.uqE = new HttpPost(str);
            this.uqE.addHeader("RANGE", "bytes=" + this.aPh + "-" + (this.size - this.aPh > 1048576 ? Integer.valueOf((this.aPh + 1048576) - 1) : ""));
            this.uqr.eq(50);
            this.uqF = this.ozy.execute(this.uqE);
            int statusCode = this.uqF.getStatusLine().getStatusCode();
            Integer valueOf;
            if (statusCode == m.CTRL_INDEX || statusCode == v.CTRL_INDEX) {
                try {
                    if (this.uqC.uqz && r.iiL && Math.random() > 0.2d) {
                        w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                        valueOf = Integer.valueOf(-1);
                        if (this.uqE != null) {
                            this.uqE.abort();
                        }
                        if (this.uqG != null) {
                            try {
                                this.uqG.consumeContent();
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                            }
                        }
                        if (this.ozy == null) {
                            return valueOf;
                        }
                        this.ozy.getConnectionManager().shutdown();
                        return valueOf;
                    }
                    this.uqF.getHeaders("Content-Length");
                    if (this.aPh > this.size) {
                        w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                        valueOf = Integer.valueOf(-2);
                        if (this.uqE != null) {
                            this.uqE.abort();
                        }
                        if (this.uqG != null) {
                            try {
                                this.uqG.consumeContent();
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                            }
                        }
                        if (this.ozy == null) {
                            return valueOf;
                        }
                        this.ozy.getConnectionManager().shutdown();
                        return valueOf;
                    }
                    this.uqG = this.uqF.getEntity();
                    this.uqG.writeTo(this.uqH);
                    this.uqG.consumeContent();
                    valueOf = Integer.valueOf(0);
                    if (this.uqE != null) {
                        this.uqE.abort();
                    }
                    if (this.uqG != null) {
                        try {
                            this.uqG.consumeContent();
                        } catch (Throwable e22) {
                            w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22, "", new Object[0]);
                        }
                    }
                    if (this.ozy == null) {
                        return valueOf;
                    }
                    this.ozy.getConnectionManager().shutdown();
                    return valueOf;
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "", new Object[0]);
                    w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "exception current in download pack", new Object[0]);
                    if (this.uqE != null) {
                        this.uqE.abort();
                    }
                    if (this.uqG != null) {
                        try {
                            this.uqG.consumeContent();
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e32, "", new Object[0]);
                        }
                    }
                    if (this.ozy != null) {
                        this.ozy.getConnectionManager().shutdown();
                    }
                    return Integer.valueOf(-1);
                } catch (Throwable th) {
                    if (this.uqE != null) {
                        this.uqE.abort();
                    }
                    if (this.uqG != null) {
                        try {
                            this.uqG.consumeContent();
                        } catch (Throwable e222) {
                            w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e222, "", new Object[0]);
                        }
                    }
                    if (this.ozy != null) {
                        this.ozy.getConnectionManager().shutdown();
                    }
                }
            } else {
                w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:" + statusCode);
                if (statusCode == 416) {
                    valueOf = Integer.valueOf(-2);
                    if (this.uqE != null) {
                        this.uqE.abort();
                    }
                    if (this.uqG != null) {
                        try {
                            this.uqG.consumeContent();
                        } catch (Throwable e2222) {
                            w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2222, "", new Object[0]);
                        }
                    }
                    if (this.ozy == null) {
                        return valueOf;
                    }
                    this.ozy.getConnectionManager().shutdown();
                    return valueOf;
                }
                valueOf = Integer.valueOf(-1);
                if (this.uqE != null) {
                    this.uqE.abort();
                }
                if (this.uqG != null) {
                    try {
                        this.uqG.consumeContent();
                    } catch (Throwable e22222) {
                        w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22222, "", new Object[0]);
                    }
                }
                if (this.ozy == null) {
                    return valueOf;
                }
                this.ozy.getConnectionManager().shutdown();
                return valueOf;
            }
        }

        protected final void onCancelled() {
            w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
            if (this.uqE != null) {
                this.uqE.abort();
            }
            if (this.uqG != null) {
                try {
                    this.uqG.consumeContent();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                }
            }
            if (this.ozy != null) {
                w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
                this.ozy.getConnectionManager().shutdown();
            }
        }
    }

    public c(int i, String str, int i2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.uqx = strArr;
    }

    public c(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        super(i, str, i2, z);
        this.uqx = new String[]{str2};
        this.uqz = true;
        this.fvo = str3;
        this.mLR = str4;
    }

    public final void a(com.tencent.mm.sandbox.b.a aVar) {
        this.uqr = aVar;
        if (!h.getExternalStorageState().equals("mounted")) {
            w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            aVar.a(-1, -1, null);
        } else if (this.hKd) {
            w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            aVar.a(-1, -1, null);
        } else if (bHN() || bHU() >= this.uqx.length) {
            w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.uqx.length);
            if (this.uqz) {
                aVar.a(1, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        } else if (f.G((long) this.upW)) {
            this.uqy = new a(this, this.upW, e.aN(aLB()), this.uqB);
            this.uqy.execute(new String[]{this.uqx[bHU()]});
        } else {
            w.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.uqz) {
                aVar.a(13, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        }
    }

    protected final String aLB() {
        if (this.uqz) {
            return upU + this.fvo + ".temp";
        }
        return super.aLB();
    }

    public final String bHM() {
        if (this.uqz) {
            return upU + this.mLR + ".apk";
        }
        return upU + this.upY + ".apk";
    }

    public final void cancel() {
        w.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.hKd = true;
        if (this.uqy != null && !this.uqy.isCancelled()) {
            this.uqy.cancel(true);
        }
    }

    private int bHU() {
        w.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.kdg + ", curLinkIdx = " + (this.kdg / 5));
        return this.kdg / 5;
    }
}
