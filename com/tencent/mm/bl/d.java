package com.tencent.mm.bl;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d implements EventListener {
    static ae hgN = new ae() {
        public final void handleMessage(Message message) {
            w.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", Integer.valueOf(message.what));
            if (message.what == 0) {
                d.uNH.b((a) message.obj);
            } else if (message.what != 1) {
                d.uNH.a((a) message.obj);
            } else if (d.uNH.uNN != null) {
                b bVar = (b) d.uNH.uNN.get();
                if (bVar != null) {
                    bVar.bOk();
                }
            }
            super.handleMessage(message);
        }
    };
    public static a uNC = null;
    public static d uNH;
    private static int uNI = 5242880;
    public static final String uNK = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    private volatile boolean hTa;
    public volatile boolean uNJ;
    public LinkedBlockingQueue<a> uNL;
    ExecutorService uNM;
    public WeakReference<b> uNN;

    public static final class a {
        String className;
        int fXF;
        String savePath;
        int uNQ;
        int uNR;

        public a(String str, int i, int i2, int i3) {
            this.className = str;
            this.fXF = i;
            this.uNQ = i2;
            this.uNR = i3;
            StringBuilder stringBuilder = new StringBuilder();
            if (bg.mA(str)) {
                stringBuilder.append(d.uNK).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
            } else {
                StringBuilder append = stringBuilder.append(d.uNK).append(str).append("_");
                String str2 = "";
                switch (i) {
                    case 1:
                        str2 = "onResume";
                        break;
                    case 2:
                        str2 = "onPause";
                        break;
                    case 3:
                        str2 = "onCreate";
                        break;
                    case 4:
                        str2 = "onScrool";
                        break;
                    case 5:
                        str2 = "all";
                        break;
                }
                append.append(str2).append(".trace");
            }
            w.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", stringBuilder.toString(), Integer.valueOf(i2));
            this.savePath = stringBuilder.toString();
        }
    }

    public interface b {
        void bOk();
    }

    public static d bOi() {
        if (uNH == null) {
            uNH = new d();
        }
        return uNH;
    }

    public final void a(a aVar) {
        if (!this.uNJ) {
            if (c.rZ()) {
                bOj();
                try {
                    File file = new File(uNK);
                    if (aVar.fXF != 6 && file.exists()) {
                        w.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                        C(file);
                    }
                    file.mkdirs();
                    Debug.startMethodTracing(aVar.savePath, aVar.uNQ <= 0 ? uNI : (aVar.uNQ * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    this.uNJ = true;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable e2) {
                    this.uNJ = false;
                    w.printErrStackTrace("MicroMsg.TraceDebugManager", e2, "TRACE startMethodTracing ERROR", new Object[0]);
                }
                if (aVar.fXF == 6) {
                    w.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                    return;
                } else if (this.uNJ) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = aVar;
                    if (bg.mA(aVar.className) || aVar.fXF == 5) {
                        hgN.sendMessageDelayed(obtain, 15000);
                        return;
                    } else {
                        hgN.sendMessageDelayed(obtain, 10000);
                        return;
                    }
                } else {
                    return;
                }
            }
            w.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
        }
    }

    private static void bOj() {
        hgN.removeMessages(0);
        hgN.removeMessages(2);
        hgN.removeMessages(1);
    }

    private static void C(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File C : listFiles) {
                C(C);
            }
            file.delete();
        }
    }

    public final boolean b(final a aVar) {
        bOj();
        if (!this.uNJ || this.hTa) {
            w.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", Boolean.valueOf(this.uNJ), Boolean.valueOf(this.hTa));
            return false;
        } else if (c.rZ()) {
            this.uNM.execute(new Runnable(this) {
                final /* synthetic */ d uNP;

                public final void run() {
                    try {
                        Debug.stopMethodTracing();
                        String str = aVar.savePath;
                        int i = aVar.uNR;
                        if (aVar.savePath == null) {
                            this.uNP.uNJ = false;
                            return;
                        }
                        File file = new File(str);
                        File file2 = new File(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
                        long currentTimeMillis = System.currentTimeMillis();
                        file.renameTo(file2);
                        file.delete();
                        w.i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
                        Process.setThreadPriority(10);
                        if (aVar.fXF == 6) {
                            Collection arrayList = new ArrayList();
                            arrayList.add(file2);
                            try {
                                p.a(arrayList, new File(file2.getAbsolutePath() + ".zip"));
                                d.hgN.sendEmptyMessage(1);
                                this.uNP.uNJ = false;
                                return;
                            } catch (Throwable e) {
                                w.e("MicroMsg.TraceDebugManager", "exception:%s", bg.g(e));
                                w.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
                                this.uNP.uNJ = false;
                                return;
                            }
                        }
                        if (this.uNP.uNL == null || this.uNP.uNL.size() == 0) {
                            str = d.D(file2);
                            if (!bg.mA(str)) {
                                d dVar = this.uNP;
                                if (i == 1 || (i == 3 && am.isWifi(ab.getContext()))) {
                                    dVar.SA(str);
                                }
                            }
                        }
                        this.uNP.uNJ = false;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
                    } catch (Throwable th) {
                        this.uNP.uNJ = false;
                    }
                }
            });
            return true;
        } else {
            w.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            return false;
        }
    }

    public static String D(File file) {
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            w.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                w.e("MicroMsg.TraceDebugManager", " get file list failed");
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(file);
        }
        File file2 = new File(uNK + bg.Nz() + ".zip");
        try {
            p.a(arrayList, file2);
            for (int i = 0; i < arrayList.size(); i++) {
                ((File) arrayList.get(i)).delete();
            }
            if (file2.length() <= 3145728) {
                return file2.getAbsolutePath();
            }
            w.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", Long.valueOf(file2.length()));
            return null;
        } catch (Throwable e) {
            w.e("MicroMsg.TraceDebugManager", "exception:%s", bg.g(e));
            w.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
            return null;
        }
    }

    private d() {
    }

    public final void cJ(String str, int i) {
        if (this.uNL != null && this.uNL.size() > 0) {
            w.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", Boolean.valueOf(this.hTa), Boolean.valueOf(this.uNJ), str, Integer.valueOf(i));
            if (!this.hTa && !this.uNJ) {
                Iterator it = this.uNL.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.className == null) {
                        a(null);
                        this.uNL.remove(aVar);
                        return;
                    } else if (aVar.className.equals(str) && aVar.fXF == i) {
                        a(aVar);
                        this.uNL.remove(aVar);
                        return;
                    }
                }
            }
        }
    }

    public final void SA(String str) {
        if (str != null) {
            this.hTa = true;
            if (bg.mA(str)) {
                w.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", str);
            } else if (c.rZ()) {
                File file = new File(str);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        str = D(file);
                    }
                    if (str != null && new File(str).length() >= 131072) {
                        if (uNC == null) {
                            w.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
                        } else {
                            w.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", Boolean.valueOf(uNC.Cw(str)));
                            if (uNC.Cw(str)) {
                                e.d(new File(uNK));
                            }
                        }
                    }
                } else {
                    w.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
                }
            } else {
                w.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
            }
            this.hTa = false;
        }
    }

    public final void c(a aVar) {
        if (aVar.fXF > 0) {
            if (this.uNM == null) {
                this.uNM = Executors.newSingleThreadExecutor();
            }
            if (this.hTa || this.uNJ) {
                w.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", Boolean.valueOf(this.hTa), Boolean.valueOf(this.uNJ));
                return;
            }
            hgN.removeMessages(0);
            if (aVar.uNR == 4 || aVar.uNR == 5) {
                final int i = aVar.uNR;
                this.uNM.execute(new Runnable(this) {
                    final /* synthetic */ d uNP;

                    public final void run() {
                        this.uNP.SA(i == 4 ? "/data/anr/" : d.uNK);
                    }
                });
            } else if (aVar.fXF == 6 || aVar.fXF == 5) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = aVar;
                if (aVar.fXF == 5) {
                    hgN.sendMessage(obtain);
                } else {
                    hgN.sendMessageDelayed(obtain, 500);
                }
            } else {
                if (this.uNL == null) {
                    this.uNL = new LinkedBlockingQueue();
                }
                this.uNL.clear();
                this.uNL.add(aVar);
            }
            w.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", aVar.className, Integer.valueOf(aVar.fXF), Integer.valueOf(aVar.uNR));
        }
    }
}
