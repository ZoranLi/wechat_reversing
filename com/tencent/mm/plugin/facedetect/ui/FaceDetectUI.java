package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI extends MMActivity implements e, com.tencent.mm.plugin.facedetect.views.a {
    private String gLD = null;
    boolean lcX = false;
    private int luz = -1;
    h lzI = null;
    private b lzJ = null;
    private boolean lzK = false;
    private boolean lzL = false;
    private View lzM = null;
    private RelativeLayout lzN;
    FaceDetectView lzO = null;
    FaceScanRect lzP = null;
    private TextView lzQ = null;
    private Button lzR = null;
    private FaceDetectProcessService lzS = null;
    private ServiceConnection lzT = null;
    private boolean lzU = false;
    private boolean lzV = false;
    private c lzW = null;
    private com.tencent.mm.plugin.facedetect.c.a lzj = null;
    private a lzk = null;
    private b lzl = null;
    private boolean lzm = false;
    private WakeLock wakeLock = null;

    private interface a {
        void onFinish();
    }

    private class b {
        private boolean lAe = true;
        public boolean lAf = false;
        private boolean lAg = true;
        private final boolean lAh = true;
        final /* synthetic */ FaceDetectUI lzX;

        public b(FaceDetectUI faceDetectUI) {
            this.lzX = faceDetectUI;
        }

        public final synchronized void asy() {
            this.lAf = true;
        }

        final synchronized void reset() {
            this.lAf = false;
        }

        final synchronized void asz() {
            w.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[]{toString()});
            if (this.lAe && this.lAf && this.lAg) {
                this.lzX.lzN.setVisibility(0);
            }
        }

        public final String toString() {
            return "InitHandler{isCgiInitDone=" + this.lAe + ", isCameraInitDone=" + this.lAf + ", isLightInitDone=true, isLibraryInitDone=" + this.lAg + '}';
        }
    }

    static /* synthetic */ void e(FaceDetectUI faceDetectUI) {
        w.i("MicroMsg.FaceDetectUI", "alvinluo start");
        faceDetectUI.arp();
    }

    static /* synthetic */ void f(FaceDetectUI faceDetectUI) {
        w.v("MicroMsg.FaceDetectUI", "alvinluo onPreviewDone");
        if (com.tencent.mm.plugin.facedetect.e.a.asA().lAH) {
            com.tencent.mm.plugin.facedetect.e.a asA = com.tencent.mm.plugin.facedetect.e.a.asA();
            int rotation = faceDetectUI.lzO.lCa.lBG.getRotation();
            int arP = faceDetectUI.lzO.lCa.lBG.arP();
            int asN = faceDetectUI.lzO.asN();
            int i = faceDetectUI.lzO.lCa.lBG.asL().x;
            int asN2 = faceDetectUI.lzO.asN();
            w.i("MicroMsg.FaceVideoRecorder", "hy: init record");
            w.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d", new Object[]{Integer.valueOf(rotation), Integer.valueOf(arP), Integer.valueOf(asN), Boolean.valueOf(false), Integer.valueOf(0)});
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.isDefault = true;
            videoTransPara.width = asA.lAJ;
            videoTransPara.height = asA.lAK;
            videoTransPara.gPE = 30;
            videoTransPara.hzY = 1200000;
            videoTransPara.hzM = 1;
            videoTransPara.hzL = 64000;
            videoTransPara.hzN = 2;
            videoTransPara.hzO = 1;
            videoTransPara.audioSampleRate = 16000;
            videoTransPara.duration = 15;
            asA.lAM.a(asA.lvq, videoTransPara);
            asA.lAz.D(new com.tencent.mm.plugin.facedetect.e.a.AnonymousClass1(asA, rotation, asN, arP, false, 0, i, asN2));
        }
        faceDetectUI.lzO.e(false, faceDetectUI.gLD);
        af.f(new Runnable(faceDetectUI) {
            final /* synthetic */ FaceDetectUI lzX;

            {
                this.lzX = r1;
            }

            public final void run() {
                int[] iArr = null;
                w.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
                this.lzX.lzJ.asy();
                this.lzX.lzJ.asz();
                FaceDetectUI faceDetectUI = this.lzX;
                if (h.lvZ == null) {
                    h.lvZ = new h();
                }
                faceDetectUI.lzI = h.lvZ;
                h hVar = faceDetectUI.lzI;
                hVar.kZt = 0;
                hVar.lvX = null;
                hVar.lvY = -1;
                hVar = faceDetectUI.lzI;
                g gVar = f.lvS.lvT.lxY;
                if (gVar.lvW == null) {
                    w.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
                } else {
                    iArr = gVar.lvW.engineGetAllMotions();
                }
                hVar.lvX = iArr;
                hVar.lvY = hVar.lvX == null ? 0 : hVar.lvX.length;
                faceDetectUI.lcX = true;
                FaceDetectView faceDetectView = faceDetectUI.lzO;
                RectF rectF = new RectF((float) faceDetectUI.lzP.getLeft(), (float) faceDetectUI.lzP.getTop(), (float) faceDetectUI.lzP.getRight(), (float) faceDetectUI.lzP.getBottom());
                FaceDetectDecorView faceDetectDecorView = faceDetectView.lCb;
                String str = "MicroMsg.FaceDetectDecorView";
                String str2 = "hy: trigger showCover cover: %s, old: %s";
                Object[] objArr = new Object[2];
                objArr[0] = rectF.toString();
                objArr[1] = faceDetectDecorView.lBY == null ? "null" : faceDetectDecorView.lBY.toString();
                w.i(str, str2, objArr);
                faceDetectDecorView.lBW = true;
                if (faceDetectDecorView.lBY == null || !faceDetectDecorView.lBY.equals(rectF)) {
                    faceDetectDecorView.lBY = rectF;
                    w.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", new Object[]{faceDetectDecorView.lBY.toString()});
                    faceDetectDecorView.invalidate();
                }
                faceDetectUI.asu();
            }
        }, 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.gLD = getIntent().getStringExtra("k_user_name");
        this.lzm = getIntent().getBooleanExtra("k_need_signature", false);
        this.luz = getIntent().getIntExtra("k_server_scene", -1);
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.arN().a(faceDetectReporter);
        }
        int i = com.tencent.mm.plugin.facedetect.c.b.lvt;
        this.lzj = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.luz, getIntent().getExtras());
        o.w(this);
        this.lzR = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.caZ);
        this.lzR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FaceDetectUI lzX;

            {
                this.lzX = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
                this.lzX.asl();
            }
        });
        this.lzM = findViewById(com.tencent.mm.plugin.facedetect.a.e.lsM);
        this.lzM.setVisibility(8);
        this.lzN = (RelativeLayout) findViewById(com.tencent.mm.plugin.facedetect.a.e.lsQ);
        this.lzP = (FaceScanRect) findViewById(com.tencent.mm.plugin.facedetect.a.e.lsP);
        this.lzO = (FaceDetectView) findViewById(com.tencent.mm.plugin.facedetect.a.e.lsO);
        this.lzQ = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.lsJ);
        this.lzO.lCe = this;
        FaceDetectView faceDetectView = this.lzO;
        ViewGroup viewGroup = this.lzN;
        ViewGroup viewGroup2 = this.lzP.lDk;
        faceDetectView.lCc = viewGroup;
        faceDetectView.lCd = viewGroup2;
        this.lzO.lzQ = this.lzQ;
        this.lzO.e(true, this.gLD);
        this.lzP.lDj = new com.tencent.mm.plugin.facedetect.views.FaceScanRect.b(this) {
            final /* synthetic */ FaceDetectUI lzX;

            {
                this.lzX = r1;
            }

            public final void asx() {
                FaceDetectView c = this.lzX.lzO;
                RectF rectF = new RectF((float) this.lzX.lzP.getLeft(), (float) this.lzX.lzP.getTop(), (float) this.lzX.lzP.getRight(), (float) this.lzX.lzP.getBottom());
                FaceDetectDecorView faceDetectDecorView = c.lCb;
                faceDetectDecorView.lBW = true;
                faceDetectDecorView.lBX = true;
                faceDetectDecorView.lBY = rectF;
                faceDetectDecorView.invalidate();
            }
        };
        this.lzP.setVisibility(4);
        this.lzJ = new b(this);
    }

    private void apc() {
        w.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[]{Boolean.valueOf(this.lzU)});
        if (this.lzU) {
            w.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
            unbindService(this.lzT);
            this.lzU = false;
        }
    }

    public void onStart() {
        super.onStart();
        w.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
        }
        if (!this.wakeLock.isHeld()) {
            w.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
            this.wakeLock.acquire();
        }
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("key_face_service_connection_from", 2);
        this.lzT = new ServiceConnection(this) {
            final /* synthetic */ FaceDetectUI lzX;

            {
                this.lzX = r1;
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                w.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[]{componentName});
                this.lzX.lzU = true;
                this.lzX.lzS = ((com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a) iBinder).lyb;
                f fVar = f.lvS;
                FaceDetectProcessService d = this.lzX.lzS;
                w.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[]{bg.q(ab.getContext(), Process.myPid()), Integer.valueOf(fVar.hashCode())});
                fVar.lvT = d;
                w.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", new Object[]{Integer.valueOf(this.lzX.lzS.hashCode())});
                FaceDetectUI.e(this.lzX);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                w.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", new Object[]{componentName.toString()});
                this.lzX.lzU = false;
            }
        };
        w.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
        bindService(intent, this.lzT, 1);
    }

    protected void onStop() {
        super.onStop();
        w.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
        apc();
        if (this.lzV) {
            finish();
        } else {
            b(1, 90006, "cancel with on stop", null);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.facedetect.a.g.ltA;
    }

    public final void arp() {
        w.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.9f) {
            attributes.screenBrightness = 0.9f;
            getWindow().setAttributes(attributes);
        }
        this.lzP.lDm = a.lDp;
        FaceScanRect faceScanRect = this.lzP;
        if (faceScanRect.lDm == a.lDn) {
            w.w("MicroMsg.FaceScanRect", "hy: already opened");
        } else {
            faceScanRect.lDl.setVisibility(0);
            faceScanRect.lCU.setBackgroundResource(d.lsG);
            faceScanRect.lDl.startAnimation(faceScanRect.lDi);
            for (View view : faceScanRect.lDd) {
                view.clearAnimation();
                view.setBackgroundColor(faceScanRect.getResources().getColor(com.tencent.mm.plugin.facedetect.a.b.white));
            }
            faceScanRect.lDm = a.lDn;
        }
        this.lzO.lCb.lBV = false;
        this.lzP.setVisibility(0);
        w.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[]{Integer.valueOf(this.lzP.getTop()), Integer.valueOf(this.lzP.getRight()), Integer.valueOf(this.lzP.getLeft()), Integer.valueOf(this.lzP.getBottom())});
        this.lzK = true;
        this.lcX = false;
        this.lzJ.reset();
        if (this.lzK) {
            this.lzW = new c(this) {
                final /* synthetic */ FaceDetectUI lzX;

                {
                    this.lzX = r1;
                }

                public final void mr(int i) {
                    w.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", new Object[]{Integer.valueOf(i)});
                    if (i == 0) {
                        FaceDetectUI.f(this.lzX);
                    } else if (i == 1) {
                        this.lzX.b(4, 90016, "preview error", this.lzX.getString(com.tencent.mm.plugin.facedetect.a.h.lup));
                    } else if (i == 2) {
                        this.lzX.b(4, 90008, "camera permission not granted", this.lzX.getString(com.tencent.mm.plugin.facedetect.a.h.eFG));
                    }
                }
            };
            w.i("MicroMsg.FaceDetectUI", "hy: start preview");
            c cVar = this.lzW;
            FaceDetectView faceDetectView = this.lzO;
            faceDetectView.lCa.a(new com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass4(faceDetectView, cVar));
        }
    }

    public final void arr() {
        w.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
        if (!this.lzL) {
            this.lzW = null;
            this.lzL = true;
            if (this.lzJ.lAf) {
                asv();
                this.lzO.lCa.lBG.asJ();
            }
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ FaceDetectUI lzX;

                {
                    this.lzX = r1;
                }

                public final void run() {
                    long NA = bg.NA();
                    Runtime.getRuntime().gc();
                    w.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", new Object[]{Long.valueOf(bg.aB(NA))});
                }
            }, "Face_active_gc");
        }
        apc();
    }

    public final void b(int i, int i2, String str, Bundle bundle) {
        w.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 0 && i2 != 0 && com.tencent.mm.plugin.facedetect.e.a.asA().isStarted() && com.tencent.mm.plugin.facedetect.e.a.asA().lAH) {
            com.tencent.mm.plugin.facedetect.e.a.asA().asD();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.arN());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("err_type", i);
        bundle3.putInt("err_code", i2);
        bundle3.putString("err_msg", str);
        bundle3.putAll(bundle2);
        Intent intent = new Intent();
        intent.putExtras(bundle3);
        setResult(-1, intent);
        finish();
    }

    final void asu() {
        if (this.lcX) {
            w.i("MicroMsg.FaceDetectUI", "hy: start capture face");
            FaceDetectView faceDetectView = this.lzO;
            Rect rect = new Rect(this.lzP.getLeft(), this.lzP.getTop(), this.lzP.getRight(), this.lzP.getBottom());
            com.tencent.mm.plugin.facedetect.model.h.a arM = h.arM();
            if (arM.type != 100) {
                if (faceDetectView.lCf != null) {
                    faceDetectView.lCf.arZ();
                }
                faceDetectView.kgf = false;
                faceDetectView.isPaused = false;
                faceDetectView.lCl = bg.NA();
                faceDetectView.lCj = arM.lwc;
                faceDetectView.lCi = arM.iua;
                faceDetectView.lwd = arM.lwd;
                faceDetectView.lCg = true;
                faceDetectView.lCk = arM.lwg;
                faceDetectView.lCf = com.tencent.mm.plugin.facedetect.d.b.c.a(arM);
                if (faceDetectView.lCf != null) {
                    if (faceDetectView.lCc != null) {
                        faceDetectView.lCc.removeAllViews();
                    }
                    if (faceDetectView.lCd != null) {
                        faceDetectView.lCd.removeAllViews();
                    }
                    faceDetectView.lCf.a(faceDetectView.getContext(), faceDetectView.lCc, faceDetectView.lCd);
                }
                if (faceDetectView.lCa != null) {
                    faceDetectView.lCa.a(rect, arM.lwa);
                }
                faceDetectView.lCh = false;
            }
        }
    }

    private void asv() {
        this.lcX = false;
        this.lzO.dX(false);
        w.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
        this.lzK = false;
        this.lzO.lCa.lBG.stopPreview();
        w.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (z) {
            asv();
        }
        if (z2) {
            w.i("MicroMsg.FaceDetectUI", "hy: need blur");
            final Bitmap asw = asw();
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ FaceDetectUI lzX;

                public final void run() {
                    final Bitmap m = o.m(this.lzX.gLD, asw);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 lAa;

                        public final void run() {
                            this.lAa.lzX.lzk.r(m);
                        }
                    });
                }
            }, "FaceDetectUI_BlurBgMap");
        }
        this.lzk.a(bVar);
    }

    private void b(int i, int i2, String str, String str2) {
        w.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(4), Integer.valueOf(i2), str});
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        asv();
        b(4, i2, str, bundle);
    }

    public final void R(int i, String str) {
        boolean z = true;
        w.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[]{Integer.valueOf(i)});
        if (!FaceCharacteristicsResult.mg(i)) {
            h hVar = this.lzI;
            if (hVar.kZt >= hVar.lvY + -1) {
                w.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
                this.lzO.dX(true);
                final Bitmap asw = asw();
                String str2 = "MicroMsg.FaceDetectUI";
                String str3 = "alvinluo bitmap == null: %b";
                Object[] objArr = new Object[1];
                if (asw != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                w.i(str2, str3, objArr);
                final a anonymousClass9 = new a(this) {
                    final /* synthetic */ FaceDetectUI lzX;

                    {
                        this.lzX = r1;
                    }

                    public final void onFinish() {
                        w.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
                        this.lzX.lzV = true;
                        this.lzX.b(0, 0, "collect data ok", null);
                    }
                };
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ FaceDetectUI lzX;

                    public final void run() {
                        o.m(this.lzX.gLD, asw);
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass8 lAd;

                            {
                                this.lAd = r1;
                            }

                            public final void run() {
                                if (anonymousClass9 != null) {
                                    anonymousClass9.onFinish();
                                }
                            }
                        });
                    }
                }, "save_face_bitmap");
                return;
            }
            hVar = this.lzI;
            g gVar = f.lvS.lvT.lxY;
            if (gVar.lvW == null) {
                w.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
            } else {
                w.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
                gVar.lvW.engineNextMotion();
            }
            hVar.kZt++;
            int i2 = h.arM().type;
            w.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[]{Integer.valueOf(i2)});
            if (h.arM().lwf) {
                this.lzP.b(new AnimationListener(this) {
                    final /* synthetic */ FaceDetectUI lzX;

                    {
                        this.lzX = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        this.lzX.asu();
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                return;
            }
            w.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[]{Integer.valueOf(i2)});
            asu();
        } else if (i == 3) {
            b(4, 90017, "face detect time out", str);
        } else if (i == 6 || i == 5) {
            b(4, 90023, "face track failed or not stable", str);
        } else if (i == 7) {
            b(4, 90009, "audio permission not granted", ab.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.eFJ));
        } else {
            b(4, 90018, "system error", str);
        }
    }

    public final void mq(int i) {
        if (i == 1) {
            this.lzP.b(null);
        }
    }

    private void asl() {
        w.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
        FaceDetectView faceDetectView = this.lzO;
        com.tencent.mm.plugin.facedetect.d.b.b asa = faceDetectView.lCf != null ? faceDetectView.lCf.asa() : new com.tencent.mm.plugin.facedetect.d.b.b(90004, "user cancelled in processing");
        b(1, asa.errCode, asa.fPf, null);
    }

    protected void onDestroy() {
        w.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[]{Integer.valueOf(hashCode())});
        super.onDestroy();
    }

    public void finish() {
        w.i("MicroMsg.FaceDetectUI", "alvinluo finish");
        if (this.lzk != null && this.lzk.asn()) {
            this.lzk.dismiss();
        }
        if (this.lzl != null) {
            this.lzl.dismiss();
        }
        w.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
        arr();
        super.finish();
    }

    public void onBackPressed() {
        w.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
        asl();
    }

    private Bitmap asw() {
        return this.lzO.lCa.getBitmap();
    }
}
