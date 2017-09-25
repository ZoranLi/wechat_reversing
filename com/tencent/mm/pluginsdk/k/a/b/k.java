package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.pluginsdk.k.a.d.f;
import com.tencent.mm.pluginsdk.k.a.d.f.b;
import com.tencent.mm.pluginsdk.k.a.d.t;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k extends f<a> {
    private final a sGf = new a(this, 0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new t());

    private static final class a extends d<a> {
        protected a(a aVar) {
            super(aVar);
        }

        public final void run() {
            w.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", ((a) Qv()).sEX);
            a aVar = (a) Qv();
            int i = aVar.fEB;
            int i2 = aVar.fEC;
            int i3 = aVar.fED;
            try {
                l lVar;
                aVar = (a) Qv();
                l lVar2 = new l(aVar.fEB, aVar.fEC, aVar.filePath, aVar.sEY, aVar.sEZ, aVar.sFa, aVar.sFb, aVar.sFe, aVar.fEE, aVar.sFc, aVar.sFd, aVar.sFg, aVar.sFf, aVar.url, aVar.sFh, aVar.sFi, aVar.fED);
                if (lVar2.sFG) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", lVar2.sEX);
                    lVar2.sGg = lVar2.filePath + ".decompressed";
                    lVar2.state = 32;
                    if (lVar2.bDy() != null) {
                        lVar2.state = 16;
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.sEX);
                    }
                    lVar = lVar2;
                } else if (lVar2.sFH) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", lVar2.sEX);
                    lVar2.sGg = lVar2.filePath + ".decrypted";
                    lVar2.state = 32;
                    if (lVar2.bDy() != null) {
                        lVar2.state = 16;
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.sEX);
                    }
                    lVar = lVar2;
                } else {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", lVar2.sEX);
                    lVar2.sGg = lVar2.filePath;
                    lVar2.state = 32;
                    if (lVar2.bDy() != null) {
                        lVar2.state = 16;
                        w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.sEX);
                    }
                    lVar = lVar2;
                }
                w.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + lVar.bDz(), lVar.sEX);
                if (16 != lVar.state) {
                    if (lVar.sFH) {
                        lVar.sGg = lVar.filePath;
                        lVar.sGh = lVar.filePath + ".decrypted";
                        lVar.state = 1;
                    } else if (lVar.sFG) {
                        lVar.sGg = lVar.filePath;
                        lVar.sGh = lVar.filePath + ".decompressed";
                        lVar.state = 2;
                    } else {
                        lVar.sGg = lVar.filePath;
                        lVar.state = 4;
                    }
                }
                String bDy = lVar.bDw().bDx().bDy();
                if (bg.mA(bDy)) {
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath + ".decompressed");
                } else {
                    c.sFE.b(i, i2, bDy, i3);
                }
                if (Thread.interrupted()) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) Qv()).sEX);
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath);
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath + ".decompressed");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (Thread.interrupted()) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) Qv()).sEX);
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath);
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.k.a.e.a.My(((a) Qv()).filePath + ".decompressed");
                }
            }
        }
    }

    protected final /* synthetic */ d a(b bVar) {
        return new a((a) bVar);
    }

    k() {
    }

    final void a(a aVar) {
        if (Ms(aVar.sEX)) {
            w.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", aVar.sEX);
            return;
        }
        int i;
        if (!(aVar.sEY && aVar.fED == aVar.sFb && aVar.sFb >= 0) && (aVar.sEY || !aVar.sEZ)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            w.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", aVar.sEX);
            super.b(aVar);
        }
    }

    protected final a bDv() {
        return this.sGf;
    }
}
