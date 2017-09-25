package com.tencent.mm.au;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.au.d.b;
import com.tencent.mm.c.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import java.io.File;

public final class e {
    private static e hUf = null;
    byte[] gWC = new byte[0];
    public ar hCV = new ar(1, "speex_worker");
    public String hUg;
    public com.tencent.mm.y.e hUh = new com.tencent.mm.y.e(this) {
        final /* synthetic */ e hUi;

        {
            this.hUi = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.hUi.hUg != null) {
                w.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a) kVar).filename + " filepath " + this.hUi.hUg + " errCode " + i2);
                if (((a) kVar).filename.equals(this.hUi.hUg)) {
                    h.vd().b(240, this.hUi.hUh);
                    if (i2 == 0) {
                        d.JK();
                        d.JM();
                    }
                    try {
                        w.d("MicroMsg.SpeexUploadCore", "delete " + this.hUi.hUg + " delete " + new File(this.hUi.hUg).delete() + " errCode " + i2);
                    } catch (Throwable e) {
                        w.e("MicroMsg.SpeexUploadCore", "exception:%s", bg.g(e));
                    } finally {
                        e.JR().start();
                        this.hUi.hUg = null;
                    }
                }
            }
        }
    };

    public static e JR() {
        if (hUf == null) {
            hUf = new e();
        }
        return hUf;
    }

    public final void b(a aVar) {
        w.d("MicroMsg.SpeexUploadCore", "pushWork");
        this.hCV.c(aVar);
    }

    public final void start() {
        if (am.isWifi(ab.getContext())) {
            new ae(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ e hUi;

                {
                    this.hUi = r1;
                }

                public final void run() {
                    Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                        final /* synthetic */ AnonymousClass2 hUj;

                        {
                            this.hUj = r1;
                        }

                        public final boolean queueIdle() {
                            this.hUj.hUi.b(new a(this) {
                                final /* synthetic */ AnonymousClass1 hUk;

                                {
                                    this.hUk = r1;
                                }

                                public final boolean Bn() {
                                    return true;
                                }

                                public final boolean Bo() {
                                    e eVar = this.hUk.hUj.hUi;
                                    w.d("MicroMsg.SpeexUploadCore", "uploadOneFile");
                                    synchronized (eVar.gWC) {
                                        if (eVar.hUg != null) {
                                            w.d("MicroMsg.SpeexUploadCore", "uploading...");
                                        } else {
                                            d.a JQ = d.a.JQ();
                                            if (JQ != null) {
                                                boolean z;
                                                File aZ;
                                                File file;
                                                String name;
                                                b bVar;
                                                String[] split;
                                                if (1 != g.j("EnableSpeexVoiceUpload", 0)) {
                                                    if (JQ.JO() == 0) {
                                                        z = false;
                                                    } else if (am.isWifi(ab.getContext())) {
                                                        h.vJ();
                                                        z = JQ.gkr == 0 ? true : JQ.gkr == bg.a((Integer) h.vI().vr().get(12290, null), 0);
                                                        w.d("upload", "fitSex " + JQ.gkr + " " + z + " " + JQ.gkr);
                                                        if (!z) {
                                                            z = false;
                                                        } else if (!JQ.JN()) {
                                                            z = false;
                                                        }
                                                    } else {
                                                        z = false;
                                                    }
                                                    if (z) {
                                                        aZ = e.aZ(JQ.hTY, JQ.hTZ);
                                                        if (aZ != null) {
                                                            w.d("MicroMsg.SpeexUploadCore", "no target to upload");
                                                        } else {
                                                            try {
                                                                file = new File(aZ.getPath().replace(".spx", ".uploading"));
                                                                if (aZ.renameTo(file)) {
                                                                    w.d("MicroMsg.SpeexUploadCore", "delete " + aZ.getPath());
                                                                    aZ.delete();
                                                                } else {
                                                                    eVar.hUg = file.getPath();
                                                                    name = file.getName();
                                                                    w.d("MicroMsg.SpeexUploadCore", "upload file " + eVar.hUg);
                                                                    bVar = new b();
                                                                    split = name.substring(0, name.indexOf(46)).split("_");
                                                                    if (split.length == 5) {
                                                                        try {
                                                                            bVar.hRn = split[0];
                                                                            bVar.sampleRate = bg.getInt(split[1], 0);
                                                                            bVar.hTK = bg.getInt(split[2], 0);
                                                                            bVar.hTL = bg.getInt(split[3], 0);
                                                                        } catch (NumberFormatException e) {
                                                                            w.e("upload", "wrong format", e);
                                                                        }
                                                                    }
                                                                    h.vd().a(240, eVar.hUh);
                                                                    h.vd().a(new a(eVar.hUg, d.kN(name), bVar.sampleRate, bVar.hTK, bVar.hTL), 0);
                                                                }
                                                            } catch (Throwable e2) {
                                                                w.e("MicroMsg.SpeexUploadCore", "exception:%s", bg.g(e2));
                                                            }
                                                        }
                                                    }
                                                }
                                                z = true;
                                                if (z) {
                                                    aZ = e.aZ(JQ.hTY, JQ.hTZ);
                                                    if (aZ != null) {
                                                        file = new File(aZ.getPath().replace(".spx", ".uploading"));
                                                        if (aZ.renameTo(file)) {
                                                            w.d("MicroMsg.SpeexUploadCore", "delete " + aZ.getPath());
                                                            aZ.delete();
                                                        } else {
                                                            eVar.hUg = file.getPath();
                                                            name = file.getName();
                                                            w.d("MicroMsg.SpeexUploadCore", "upload file " + eVar.hUg);
                                                            bVar = new b();
                                                            split = name.substring(0, name.indexOf(46)).split("_");
                                                            if (split.length == 5) {
                                                                bVar.hRn = split[0];
                                                                bVar.sampleRate = bg.getInt(split[1], 0);
                                                                bVar.hTK = bg.getInt(split[2], 0);
                                                                bVar.hTL = bg.getInt(split[3], 0);
                                                            }
                                                            h.vd().a(240, eVar.hUh);
                                                            h.vd().a(new a(eVar.hUg, d.kN(name), bVar.sampleRate, bVar.hTK, bVar.hTL), 0);
                                                        }
                                                    } else {
                                                        w.d("MicroMsg.SpeexUploadCore", "no target to upload");
                                                    }
                                                }
                                            }
                                            w.d("MicroMsg.SpeexUploadCore", "SpeexConfig not allow");
                                        }
                                    }
                                    return false;
                                }
                            });
                            return false;
                        }
                    });
                }
            }, 100);
        }
    }

    static File aZ(int i, int i2) {
        File file = new File(b.JJ());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        int i3 = 0;
        file = null;
        while (listFiles != null && i3 < listFiles.length) {
            file = listFiles[i3];
            if (file != null && file.isFile()) {
                w.d("MicroMsg.SpeexUploadCore", "file " + file.getPath());
                String path = file.getPath();
                long length = file.length();
                if (!file.getName().endsWith(".spx")) {
                    file = null;
                } else if (length >= ((long) i) && length <= ((long) i2)) {
                    return file;
                } else {
                    w.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", path, Integer.valueOf(i), Integer.valueOf(i2));
                    com.tencent.mm.loader.stub.b.deleteFile(path);
                    file = null;
                }
            }
            i3++;
        }
        return file;
    }
}
