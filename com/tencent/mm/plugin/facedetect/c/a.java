package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.lang.ref.WeakReference;

public abstract class a {
    protected d luA = null;
    protected c luB = null;
    private int luz;
    protected WeakReference<e> lvn;
    protected boolean lvo = false;
    int lvp = -1;
    private com.tencent.mm.remoteservice.d lvq = null;
    protected com.tencent.mm.plugin.facedetect.b.a lvr = null;
    protected boolean lvs = false;
    private Context mContext;

    public abstract void O(int i, String str);

    protected abstract k ars();

    public abstract Bundle art();

    public abstract boolean d(int i, int i2, String str, Bundle bundle);

    public abstract void g(int i, int i2, String str);

    public abstract void g(int i, int i2, String str, k kVar);

    public abstract void h(int i, int i2, String str);

    public abstract void onRelease();

    protected abstract void onStart();

    a(Context context, e eVar, int i) {
        this.mContext = context;
        this.luz = i;
        this.lvn = new WeakReference(eVar);
        this.lvr = new com.tencent.mm.plugin.facedetect.b.a(i);
        this.lvp = FaceDetectReporter.mj(i);
    }

    public final void a(c cVar) {
        if (this.lvr != null) {
            this.luB = cVar;
            this.lvr.luB = this.luB;
        }
    }

    public final void a(d dVar) {
        if (this.lvr != null) {
            this.luA = dVar;
            this.lvr.luA = dVar;
        }
    }

    public final void aro() {
        if (this.lvr != null) {
            e eVar = this.lvr;
            h.vG();
            eVar.fCk = com.tencent.mm.kernel.a.uU();
            w.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[]{Boolean.valueOf(eVar.fCk)});
            if (eVar.fCk) {
                h.vd().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, eVar);
            } else {
                h.vd().a(733, eVar);
            }
            com.tencent.mm.plugin.facedetect.b.a aVar = this.lvr;
            aVar.luD = 0;
            aVar.luE = 0;
            if (aVar.luF != null) {
                h.vd().c(aVar.luF);
            }
            if (com.tencent.mm.plugin.facedetect.model.e.arx()) {
                com.tencent.mm.plugin.facedetect.model.e.bN(aVar.luD);
            }
            if (aVar.fCk) {
                aVar.luF = new u(aVar.luz);
            } else {
                aVar.luF = new v(aVar.luz);
            }
            h.vd().a(aVar.luF, 0);
        }
    }

    public final void arp() {
        if (!(this.lvn == null || this.lvn.get() == null)) {
            ((e) this.lvn.get()).arp();
        }
        onStart();
    }

    public final void vG(String str) {
        if (this.lvr != null) {
            com.tencent.mm.plugin.facedetect.b.a aVar = this.lvr;
            if (!aVar.luC) {
                aVar.luE = 1;
                if (bg.mA(str)) {
                    w.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
                    aVar.f(4, 90011, "face file null");
                } else if (!FileOp.aO(str)) {
                    w.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
                    aVar.f(4, 90011, "get image failed");
                } else if (aVar.luD == 0) {
                    w.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
                    aVar.f(4, 90014, "uploadId not init");
                } else {
                    w.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[]{str});
                    if (!aVar.luC) {
                        com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
                        hVar.hze = aVar.luJ;
                        hVar.field_mediaId = o.vJ(str);
                        hVar.field_fullpath = str;
                        hVar.field_thumbpath = "";
                        hVar.field_fileType = b.MediaType_FILE;
                        hVar.field_talker = "";
                        hVar.field_priority = b.hxL;
                        hVar.field_needStorage = false;
                        hVar.field_isStreamMedia = false;
                        hVar.field_appType = 0;
                        hVar.field_bzScene = 0;
                        hVar.field_largesvideo = false;
                        if (!g.El().b(hVar)) {
                            w.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[]{hVar.field_mediaId});
                            aVar.f(4, 90019, "add to cdn failed");
                        }
                    }
                }
            }
        }
    }

    public final long arq() {
        if (this.lvr != null) {
            return this.lvr.luD;
        }
        return -1;
    }

    public final void arr() {
        w.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
        if (!(this.lvn == null || this.lvn.get() == null)) {
            ((e) this.lvn.get()).arr();
        }
        this.lvn = null;
        String q = bg.q(ab.getContext(), Process.myPid());
        String packageName = ab.getPackageName();
        w.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[]{q});
        if (q.equalsIgnoreCase(packageName)) {
            if (this.lvr != null) {
                e eVar = this.lvr;
                String str = "MicroMsg.FaceUploadProcessor";
                String str2 = "alvinluo uinit mCurrentNetScene == null: %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(eVar.luF == null);
                w.v(str, str2, objArr);
                eVar.luC = true;
                if (eVar.luF != null) {
                    w.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[]{eVar.luF.getClass().getSimpleName()});
                    h.vd().c(eVar.luF);
                }
                if (eVar.fCk) {
                    h.vd().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, eVar);
                } else {
                    h.vd().b(733, eVar);
                }
                eVar.arj();
            }
            this.lvr = null;
        }
        onRelease();
    }

    protected final void b(int i, int i2, String str, Bundle bundle) {
        boolean z = true;
        String str2 = "MicroMsg.FaceDetectBaseController";
        String str3 = "alvinluo finishWithResult mUIModel == null: %b";
        Object[] objArr = new Object[1];
        if (this.lvn != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.i(str2, str3, objArr);
        if (this.lvn != null && this.lvn.get() != null) {
            ((e) this.lvn.get()).b(i, i2, str, bundle);
        }
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (this.lvn != null && this.lvn.get() != null) {
            ((e) this.lvn.get()).a(z, z2, bVar);
        }
    }

    public final void c(int i, int i2, String str, Bundle bundle) {
        if (i == 0 && i2 == 0 && !d(i, i2, str, bundle)) {
            w.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
            this.lvo = true;
            if (this.lvs) {
                k ars = ars();
                if (ars == null) {
                    w.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
                    return;
                }
                w.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[]{Integer.valueOf(ars.getType())});
                if (!this.lvo) {
                    w.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[]{Boolean.valueOf(this.lvo)});
                } else if (this.lvr != null) {
                    Object obj = this.lvr;
                    if (ars == null) {
                        w.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
                        return;
                    }
                    w.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[]{Integer.valueOf(ars.getType())});
                    obj.arj();
                    obj.luG = ars;
                    obj.luE = 2;
                    h.vd().a(ars.getType(), obj);
                    h.vd().a(ars, 0);
                    obj.luH = System.currentTimeMillis();
                }
            }
        }
    }
}
