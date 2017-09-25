package com.tencent.mm.plugin.facedetect.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;

public class FaceDetectProcessService extends Service {
    private a lxX = new a(this);
    public g lxY = null;
    private Messenger lxZ = null;
    private a lya = null;

    public class a extends Binder {
        public final /* synthetic */ FaceDetectProcessService lyb;

        public a(FaceDetectProcessService faceDetectProcessService) {
            this.lyb = faceDetectProcessService;
        }
    }

    static /* synthetic */ void a(FaceDetectProcessService faceDetectProcessService, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.setData(bundle);
        faceDetectProcessService.j(obtain);
    }

    public void onCreate() {
        w.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", new Object[]{Integer.valueOf(hashCode())});
        super.onCreate();
        this.lxY = new g();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        w.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
        if (intent == null) {
            w.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
            return super.onStartCommand(intent, i, i2);
        }
        Messenger messenger = (Messenger) intent.getParcelableExtra("k_messenger");
        if (messenger != null) {
            this.lxZ = messenger;
            return super.onStartCommand(intent, i, i2);
        }
        w.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", new Object[]{Integer.valueOf(intent.getIntExtra("k_cmd", -1))});
        switch (intent.getIntExtra("k_cmd", -1)) {
            case 0:
                a aVar;
                int engineInit;
                String stringExtra = intent.getStringExtra("k_bio_id");
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_bio_config");
                FaceContextData.a((FaceContextData) intent.getParcelableExtra("k_ontext_data"));
                switch (intent.getIntExtra("k_server_scene", 2)) {
                    case 0:
                    case 1:
                        aVar = null;
                        break;
                    case 2:
                    case 5:
                        aVar = new b();
                        break;
                    default:
                        aVar = null;
                        break;
                }
                this.lya = aVar;
                g gVar = this.lxY;
                if (gVar.lvW != null) {
                    w.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
                    gVar.arL();
                }
                if (o.arR()) {
                    gVar.lvW = new FaceProNative();
                    engineInit = gVar.lvW.engineInit(stringExtra, byteArrayExtra, o.arT(), o.arU());
                    w.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", new Object[]{Integer.valueOf(engineInit)});
                } else {
                    w.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
                    engineInit = -4;
                }
                bV(0, engineInit);
                break;
            case 1:
                final p anonymousClass1 = new p(this) {
                    final /* synthetic */ FaceDetectProcessService lyb;

                    {
                        this.lyb = r1;
                    }

                    public final void b(final FaceResult faceResult) {
                        int i = -1;
                        String str = "MicroMsg.FaceDetectProcessService";
                        String str2 = "alvinluo release out result == null:%b, result: %d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(faceResult == null);
                        objArr[1] = Integer.valueOf(faceResult != null ? faceResult.result : -1);
                        w.i(str, str2, objArr);
                        if (faceResult == null || faceResult.result != 0) {
                            w.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
                            if (faceResult != null) {
                                i = faceResult.result;
                            }
                            this.lyb.bV(1, i);
                            return;
                        }
                        f.t(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 lyd;

                            public final void run() {
                                String a = o.a(faceResult);
                                Bundle bundle = new Bundle();
                                bundle.putInt("key_face_result_code", 0);
                                bundle.putString("key_face_result_file_path", a);
                                FaceDetectProcessService.a(this.lyd.lyb, bundle);
                            }
                        });
                    }
                };
                f.t(new Runnable(this) {
                    final /* synthetic */ FaceDetectProcessService lyb;

                    public final void run() {
                        w.i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
                        final FaceResult arK = this.lyb.lxY.arK();
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 lyg;

                            public final void run() {
                                anonymousClass1.b(arK);
                            }
                        });
                    }
                });
                break;
            case 4:
                com.tencent.mm.plugin.facedetect.e.a.asA().lAH = intent.getBooleanExtra("key_is_need_video", false);
                break;
            case 5:
                if (this.lya != null) {
                    this.lya.w(intent);
                    break;
                }
                break;
            default:
                w.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
                break;
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        w.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", new Object[]{Integer.valueOf(hashCode())});
        this.lxX = new a(this);
        return this.lxX;
    }

    public boolean onUnbind(Intent intent) {
        w.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        w.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
        super.onDestroy();
    }

    private void j(Message message) {
        try {
            if (this.lxZ != null) {
                w.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", new Object[]{Integer.valueOf(message.what), message.toString(), Integer.valueOf(this.lxZ.hashCode())});
                this.lxZ.send(message);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FaceDetectProcessService", e, "", new Object[0]);
        }
    }

    private void bV(int i, int i2) {
        w.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        j(message);
    }
}
