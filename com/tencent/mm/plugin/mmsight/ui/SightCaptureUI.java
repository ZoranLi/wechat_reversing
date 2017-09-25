package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.e.a.ky;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONObject;

@a(3)
public class SightCaptureUI extends MMActivity implements d.a, c.a {
    private b ict;
    private d ivE;
    private com.tencent.mm.remoteservice.d lvq = new com.tencent.mm.remoteservice.d(ab.getContext());
    private int mNV = -1;
    private int nAD = 2;
    private VideoTransPara nAE;
    private SightParams nEC;
    private int nKW = 1;
    private boolean nKX = true;
    private e nKY;
    private ObservableTextureView nKZ;
    private c nLA;
    private boolean nLB = false;
    private boolean nLC = false;
    private boolean nLD = false;
    private int nLE = 0;
    private boolean nLF = false;
    private int nLG = 0;
    private Thread nLH = null;
    private long nLI = -1;
    private long nLJ = -1;
    private Runnable nLK = new Runnable(this) {
        final /* synthetic */ SightCaptureUI nLR;

        {
            this.nLR = r1;
        }

        public final void run() {
            if (this.nLR.mNV == 6 && this.nLR.nLa != null) {
                w.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
                MMSightRecordButton h = this.nLR.nLa;
                w.i("MicroMsg.MMSightRecordButton", "showProgressBar");
                h.nKp.setVisibility(0);
            }
        }
    };
    private String nLL;
    private String nLM;
    private boolean nLN;
    private Bundle nLO;
    private Runnable nLP = new Runnable(this) {
        final /* synthetic */ SightCaptureUI nLR;

        {
            this.nLR = r1;
        }

        public final void run() {
            if (this.nLR.mNV != 4) {
                w.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
                this.nLR.updateState(8);
            }
        }
    };
    private f.a nLQ = new f.a(this) {
        final /* synthetic */ SightCaptureUI nLR;

        {
            this.nLR = r1;
        }

        public final void onError(int i, int i2) {
            w.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[]{Integer.valueOf(this.nLR.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        }

        public final void Uc() {
            if (this.nLR.nLq != null) {
                this.nLR.nLq.start();
                this.nLR.nLq.bN(true);
            }
            af.I(this.nLR.nLP);
            this.nLR.nLq.sWP = new f.e(this) {
                final /* synthetic */ AnonymousClass18 nLX;

                {
                    this.nLX = r1;
                }

                public final void aMm() {
                    af.f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 nLY;

                        {
                            this.nLY = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                            if (this.nLY.nLX.nLR.nLq != null) {
                                this.nLY.nLX.nLR.nLq.setAlpha(1.0f);
                                this.nLY.nLX.nLR.updateState(4);
                                SightCaptureUI.E(this.nLY.nLX.nLR);
                            }
                        }
                    }, 50);
                }
            };
        }

        public final void oW() {
        }

        public final int bI(int i, int i2) {
            return 0;
        }

        public final void bp(int i, int i2) {
        }
    };
    private MMSightRecordButton nLa;
    private View nLb;
    private View nLc;
    private ViewGroup nLd;
    private ViewGroup nLe;
    private ImageView nLf;
    private ImageView nLg;
    private SurfaceTexture nLh;
    CameraFrontSightView nLi;
    private ViewGroup nLj;
    private ImageView nLk;
    private MMSightCameraGLSurfaceView nLl;
    private com.tencent.mm.plugin.mmsight.ui.cameraglview.a nLm;
    private TextView nLn;
    private MMSightCaptureTouchView nLo;
    private View nLp;
    private VideoTextureView nLq;
    private boolean nLr = true;
    private aks nLs = new aks();
    private byte[] nLt;
    private int nLu;
    private int nLv;
    private int nLw;
    private int nLx;
    private byte[] nLy;
    private int nLz;
    private View ngX;

    static /* synthetic */ void n(com.tencent.mm.plugin.mmsight.ui.SightCaptureUI r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = 0;
        r4 = -1;
        r8 = 1;
        r9 = 0;
        r0 = r10.nKY;
        if (r0 == 0) goto L_0x00c5;
    L_0x0008:
        r0 = r10.nKY;
        r0 = r0.nBJ;
        if (r0 == 0) goto L_0x00c5;
    L_0x000e:
        r0 = r10.nLA;
        if (r0 == 0) goto L_0x00c5;
    L_0x0012:
        r0 = r10.nLF;
        if (r0 != 0) goto L_0x00c5;
    L_0x0016:
        r0 = r10.nLJ;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x002a;
    L_0x001e:
        r0 = r10.nLJ;
        r0 = com.tencent.mm.sdk.platformtools.bg.aB(r0);
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x00c5;
    L_0x002a:
        r10.nLF = r8;
        r0 = r10.nLn;
        if (r0 == 0) goto L_0x003b;
    L_0x0030:
        r0 = r10.nKX;
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r0 = r10.nLn;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x003b:
        r0 = 6;
        r10.updateState(r0);
        r0 = r10.nLa;
        r0.fK(r9);
        r0 = r10.nLA;
        r0 = r0.aKK();
        r10.nLD = r0;
        r10.nLy = r5;
        r10.nLz = r4;
        r6 = r10.nKY;
        r0 = new com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$5;
        r0.<init>(r10);
        r1 = r10.nLD;
        r2 = r10.nLA;
        r5 = r2.getOrientation();
        r2 = "MicroMsg.MMSightCamera";
        r3 = "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r4[r9] = r0;
        r7 = r6.nCh;
        r4[r8] = r7;
        r7 = 2;
        r1 = java.lang.Boolean.valueOf(r1);
        r4[r7] = r1;
        r1 = 3;
        r7 = java.lang.Integer.valueOf(r5);
        r4[r1] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r1 = r6.nCh;
        if (r1 == 0) goto L_0x00bf;
    L_0x0083:
        r1 = 1;
        r6.nCi = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3 = new android.graphics.Point;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3.<init>();	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r6.nBT;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        if (r1 == 0) goto L_0x00c6;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
    L_0x008f:
        r1 = r6.nBT;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.x;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3.x = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r6.nBT;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.y;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3.y = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
    L_0x009b:
        r1 = com.tencent.mm.plugin.mmsight.model.a.j.nEA;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r2 = r6.nCh;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r2 = r2.length;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.h(r2);	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r2 = r6.nCh;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r4 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r7 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r8 = r6.nCh;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r8 = r8.length;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        java.lang.System.arraycopy(r2, r4, r1, r7, r8);	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r2 = r6.nBM;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r4 = r2.gPG;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r2 = r3.x;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3 = r3.y;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r6.nCi = r9;
    L_0x00bf:
        r0 = com.tencent.mm.sdk.platformtools.bg.NA();
        r10.nLJ = r0;
    L_0x00c5:
        return;
    L_0x00c6:
        r1 = r6.nBV;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        if (r1 == 0) goto L_0x00fd;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
    L_0x00ca:
        r1 = r6.nBW;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        if (r1 == 0) goto L_0x00fd;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
    L_0x00ce:
        r1 = r6.nBS;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.x;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3.x = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r6.nBS;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.y;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3.y = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        goto L_0x009b;
    L_0x00db:
        r1 = move-exception;
        r2 = "MicroMsg.MMSightCamera";	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3 = "takePicture error: %s";	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r4 = 1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r5 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.getMessage();	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r4[r5] = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r6.nCi = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r2 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r4 = -1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r5 = 0;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r6.nCi = r9;
        goto L_0x00bf;
    L_0x00fd:
        r1 = r6.nBG;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.lAJ;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3.x = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r6.nBG;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r1 = r1.lAK;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        r3.y = r1;	 Catch:{ Exception -> 0x00db, all -> 0x010a }
        goto L_0x009b;
    L_0x010a:
        r0 = move-exception;
        r6.nCi = r9;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.n(com.tencent.mm.plugin.mmsight.ui.SightCaptureUI):void");
    }

    static /* synthetic */ void B(SightCaptureUI sightCaptureUI) {
        if (bg.bm(sightCaptureUI.nLt) || sightCaptureUI.nLv <= 0 || sightCaptureUI.nLu <= 0) {
            w.e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                Bitmap b;
                YuvImage yuvImage = new YuvImage(sightCaptureUI.nLt, 17, sightCaptureUI.nLu, sightCaptureUI.nLv, null);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.nLu, sightCaptureUI.nLv), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                if (!sightCaptureUI.nLD || sightCaptureUI.nLx == 180) {
                    int i = sightCaptureUI.nLw;
                    if (sightCaptureUI.nLx == 180) {
                        i += 180;
                        if (i > 360) {
                            i -= 360;
                        }
                    }
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) i);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.nLw - sightCaptureUI.nLx) == 0) {
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    b = decodeByteArray;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 90, CompressFormat.JPEG, sightCaptureUI.ivE.aLd(), false);
                    w.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", new Object[]{Long.valueOf(FileOp.ki(r1))});
                } catch (Exception e) {
                    w.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", new Object[]{e.getMessage()});
                }
                j.nEA.x(sightCaptureUI.nLt);
                sightCaptureUI.nLv = 0;
                sightCaptureUI.nLu = 0;
                sightCaptureUI.nLx = 0;
                sightCaptureUI.nLw = 0;
                sightCaptureUI.nLt = null;
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "saveCaptureYuvDataToBitmap error: %s", new Object[]{e2.getMessage()});
            }
        }
        sightCaptureUI.nLF = false;
    }

    static /* synthetic */ void E(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.nLb.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI nLR;

            {
                this.nLR = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.nLR.nLb.setEnabled(true);
            }

            public final void onAnimationStart(Animator animator) {
                this.nLR.nLb.setEnabled(false);
            }
        }).start();
        sightCaptureUI.ngX.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI nLR;

            {
                this.nLR = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.nLR.ngX.setEnabled(true);
            }

            public final void onAnimationStart(Animator animator) {
                this.nLR.ngX.setEnabled(false);
            }
        }).start();
    }

    static /* synthetic */ void J(SightCaptureUI sightCaptureUI) {
        w.i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.ict != null) {
            sightCaptureUI.ict.requestFocus();
        }
        sightCaptureUI.nLq.setVisibility(0);
        sightCaptureUI.nLq.setAlpha(0.0f);
        sightCaptureUI.nLq.setVideoPath(sightCaptureUI.ivE.getFilePath());
        sightCaptureUI.nLq.bN(true);
        VideoTextureView videoTextureView = sightCaptureUI.nLq;
        videoTextureView.sWN = true;
        videoTextureView.sWX.sWN = videoTextureView.sWN;
        sightCaptureUI.nLq.pvi = sightCaptureUI.nLQ;
    }

    static /* synthetic */ void L(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.mNV == 1 || sightCaptureUI.mNV == 2) {
            String aKN = sightCaptureUI.nKY.aKN();
            if (!bg.mA(aKN)) {
                StringBuilder append = new StringBuilder().append(aKN + "\n" + String.format("CPU: cur %s max:%s", new Object[]{l.ro(), l.rm()})).append("\n");
                Object[] objArr = new Object[1];
                k.aLr();
                objArr[0] = k.aLv();
                aKN = append.append(String.format("RecorderType %s", objArr)).toString() + "\n" + String.format("MemoryClass: %sMB, TotalMem: %sMB", new Object[]{Integer.valueOf(((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass()), Integer.valueOf(com.tencent.mm.plugin.mmsight.d.cz(sightCaptureUI))});
                af.v(new Runnable(sightCaptureUI) {
                    final /* synthetic */ SightCaptureUI nLR;

                    public final void run() {
                        w.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", new Object[]{aKN});
                        k.aLr();
                        if (k.aLu()) {
                            TextView textView = (TextView) this.nLR.findViewById(com.tencent.mm.plugin.u.a.d.nOa);
                            textView.setVisibility(0);
                            textView.setText(aKN);
                        }
                    }
                });
            }
        }
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.nEC == null) {
            w.e("MicroMsg.SightCaptureUI", "sightParams error!");
            return;
        }
        sightCaptureUI.nLE = com.tencent.mm.compatible.d.c.getNumberOfCameras();
        w.i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", new Object[]{Integer.valueOf(sightCaptureUI.nLE)});
        sightCaptureUI.ict = new b(sightCaptureUI);
        sightCaptureUI.nKX = sightCaptureUI.nEC.nAK;
        sightCaptureUI.nAD = sightCaptureUI.nEC.nAD;
        sightCaptureUI.nLr = sightCaptureUI.nAD == 2;
        k.aLr().nEC = sightCaptureUI.nEC;
        sightCaptureUI.nKW = sightCaptureUI.nEC.mode;
        w.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", new Object[]{Integer.valueOf(sightCaptureUI.nKW), Boolean.valueOf(sightCaptureUI.nKX), Integer.valueOf(sightCaptureUI.nAD), Integer.valueOf(sightCaptureUI.nEC.scene)});
        sightCaptureUI.nAE = sightCaptureUI.nEC.nAE;
        if (sightCaptureUI.nAE == null) {
            w.e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            return;
        }
        w.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", new Object[]{sightCaptureUI.nAE});
        sightCaptureUI.getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.eo(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.fD(true);
        } else {
            sightCaptureUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            com.tencent.mm.plugin.mmsight.d.fD(false);
        }
        sightCaptureUI.nLA = new c(sightCaptureUI);
        sightCaptureUI.nLA.nBD = sightCaptureUI;
        sightCaptureUI.nLA.enable();
        sightCaptureUI.nLd = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNK);
        sightCaptureUI.nLe = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNL);
        sightCaptureUI.nLi = (CameraFrontSightView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNO);
        sightCaptureUI.nKZ = (ObservableTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNT);
        sightCaptureUI.nLa = (MMSightRecordButton) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNU);
        sightCaptureUI.nLb = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNW);
        sightCaptureUI.ngX = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNX);
        sightCaptureUI.nLc = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNJ);
        sightCaptureUI.nLj = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.cMd);
        sightCaptureUI.nLn = (TextView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNH);
        if (sightCaptureUI.nKW == 2) {
            sightCaptureUI.nLn.setText(com.tencent.mm.plugin.u.a.f.nOg);
        } else if (sightCaptureUI.nKW == 1) {
            sightCaptureUI.nLn.setText(com.tencent.mm.plugin.u.a.f.nOh);
        } else if (sightCaptureUI.nKW == 0) {
            sightCaptureUI.nLn.setText(com.tencent.mm.plugin.u.a.f.nOf);
        }
        sightCaptureUI.nLq = (VideoTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNS);
        sightCaptureUI.nLf = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNY);
        sightCaptureUI.nLg = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNN);
        sightCaptureUI.nLg.setOnClickListener(new OnClickListener(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI nLR;

            {
                this.nLR = r1;
            }

            public final void onClick(View view) {
                SightCaptureUI.e(this.nLR);
            }
        });
        sightCaptureUI.nLk = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNZ);
        sightCaptureUI.nLl = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNM);
        sightCaptureUI.nLo = (MMSightCaptureTouchView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNQ);
        sightCaptureUI.nLp = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.nNV);
        sightCaptureUI.nLm = new com.tencent.mm.plugin.mmsight.ui.cameraglview.a(sightCaptureUI.nLl);
        if (sightCaptureUI.nKX) {
            sightCaptureUI.nLn.setVisibility(0);
        } else {
            sightCaptureUI.nLn.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(sightCaptureUI.uSU.uTo, 120);
        CameraFrontSightView cameraFrontSightView = sightCaptureUI.nLi;
        cameraFrontSightView.nJX = cameraFrontSightView.getLayoutParams();
        if (cameraFrontSightView.nJX != null) {
            cameraFrontSightView.nJX.width = fromDPToPix;
            cameraFrontSightView.nJX.height = fromDPToPix;
        }
        cameraFrontSightView.aar = fromDPToPix;
        cameraFrontSightView.RQ = fromDPToPix;
        cameraFrontSightView.nJV = cameraFrontSightView.aar / 2;
        cameraFrontSightView.nJW = cameraFrontSightView.RQ / 2;
        cameraFrontSightView.jrn = com.tencent.mm.bg.a.fromDPToPix(cameraFrontSightView.getContext(), 1);
        cameraFrontSightView.fu.setColor(-12206054);
        cameraFrontSightView.fu.setStrokeWidth((float) cameraFrontSightView.jrn);
        if (com.tencent.mm.compatible.util.d.eo(19)) {
            int eE = x.eE(sightCaptureUI);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.nLa.getLayoutParams();
            marginLayoutParams.bottomMargin += eE;
            sightCaptureUI.nLa.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.nLc.getLayoutParams();
            marginLayoutParams.bottomMargin += eE;
            sightCaptureUI.nLc.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.nLb.getLayoutParams();
            marginLayoutParams.bottomMargin += eE;
            sightCaptureUI.nLb.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.ngX.getLayoutParams();
            marginLayoutParams.bottomMargin = eE + marginLayoutParams.bottomMargin;
            sightCaptureUI.ngX.setLayoutParams(marginLayoutParams);
        }
        if (sightCaptureUI.nKW == 1 || sightCaptureUI.nKW == 0) {
            sightCaptureUI.nLa.nKA = new MMSightRecordButton.b(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void aMa() {
                    w.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", new Object[]{Integer.valueOf(this.nLR.mNV)});
                    if (this.nLR.mNV != 0 && this.nLR.nKY != null && this.nLR.nKY.nBJ) {
                        int[] iArr = new int[2];
                        this.nLR.nLa.getLocationOnScreen(iArr);
                        e g = this.nLR.nKY;
                        int i = iArr[1];
                        if (g.nBF <= 0) {
                            int i2 = x.eG(ab.getContext()).y;
                            w.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[]{Integer.valueOf(i), r2});
                            if (i2 / 2 < i) {
                                try {
                                    if (g.gPJ != null) {
                                        g.nBF = ((int) (((double) g.gPJ.getParameters().getMaxZoom()) / ((((double) i) / 3.0d) / 10.0d))) + 1;
                                        w.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[]{Integer.valueOf(g.nBF), Integer.valueOf(r2)});
                                    }
                                } catch (Exception e) {
                                    w.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[]{e.getMessage()});
                                }
                            }
                        }
                        if (this.nLR.nKW == 0) {
                            this.nLR.nLG = this.nLR.aMg();
                        }
                    }
                }

                public final void aMb() {
                    if (this.nLR.mNV != 0 && this.nLR.nKY != null && this.nLR.nKY.nBJ) {
                        SightCaptureUI.k(this.nLR);
                        w.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", new Object[]{bg.bJZ().toString()});
                        SightCaptureUI.l(this.nLR);
                    }
                }

                public final void aMc() {
                    String str = "MicroMsg.TestCaptureUiEvent";
                    String str2 = "onLongPressFinish %s, recorder: %s, recordTime: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = bg.bJZ().toString();
                    objArr[1] = this.nLR.ivE;
                    objArr[2] = Long.valueOf(this.nLR.ivE != null ? this.nLR.ivE.aLf() : 0);
                    w.i(str, str2, objArr);
                    if (this.nLR.nKW == 0) {
                        if (this.nLR.ivE == null || this.nLR.ivE.aLf() > 1000 || this.nLR.ivE.aLh() != d.c.Start) {
                            this.nLR.oP();
                            return;
                        }
                        w.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
                        this.nLR.ivE.cancel();
                        if (this.nLR.nKW == 0) {
                            SightCaptureUI.n(this.nLR);
                        }
                    } else if (this.nLR.nKW != 1) {
                    } else {
                        if ((this.nLR.ivE == null || this.nLR.ivE.aLf() > 1000) && this.nLR.ivE != null) {
                            this.nLR.oP();
                            return;
                        }
                        w.i("MicroMsg.SightCaptureUI", "video record too short");
                        Toast.makeText(this.nLR, com.tencent.mm.plugin.u.a.f.nOj, 1).show();
                        this.nLR.aMf();
                    }
                }
            };
            sightCaptureUI.nLa.nKC = new MMSightRecordButton.a(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void aLZ() {
                    w.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", new Object[]{bg.bJZ().toString()});
                    if (this.nLR.ivE != null) {
                        this.nLR.ivE.cancel();
                        if (this.nLR.nKW == 0) {
                            SightCaptureUI.n(this.nLR);
                        }
                    }
                }
            };
            sightCaptureUI.nLa.nKB = new MMSightRecordButton.c(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void pL(int i) {
                    if (this.nLR.nKY != null) {
                        this.nLR.nKY.b(true, true, i);
                    }
                }

                public final void pM(int i) {
                    if (this.nLR.nKY != null) {
                        this.nLR.nKY.b(false, true, i);
                    }
                }
            };
        }
        if (sightCaptureUI.nKW == 0 || sightCaptureUI.nKW == 2) {
            sightCaptureUI.nLa.nKz = new MMSightRecordButton.d(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void aMd() {
                    w.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", new Object[]{bg.bJZ().toString()});
                    if (this.nLR.ivE != null) {
                        w.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", new Object[]{this.nLR.ivE.aLh()});
                        this.nLR.ivE.cancel();
                    }
                    com.tencent.mm.plugin.mmsight.d.AO("TIME_RECODER_2_PLAY");
                    SightCaptureUI.n(this.nLR);
                }
            };
        }
        if (sightCaptureUI.nLE > 1) {
            sightCaptureUI.nLf.setOnClickListener(new OnClickListener(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void onClick(View view) {
                    if (this.nLR.nKY != null) {
                        SightCaptureUI.q(this.nLR);
                    }
                }
            });
        } else {
            sightCaptureUI.nLf.setVisibility(8);
        }
        sightCaptureUI.ngX.setOnClickListener(new OnClickListener(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI nLR;

            {
                this.nLR = r1;
            }

            public final void onClick(View view) {
                if (this.nLR.mNV == 4) {
                    SightCaptureUI.r(this.nLR);
                } else if (this.nLR.mNV == 3) {
                    SightCaptureUI.s(this.nLR);
                    this.nLR.fM(false);
                }
            }
        });
        sightCaptureUI.nLb.setOnClickListener(new OnClickListener(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI nLR;

            {
                this.nLR = r1;
            }

            public final void onClick(View view) {
                if (this.nLR.ict != null) {
                    this.nLR.ict.rY();
                }
                this.nLR.aMf();
                this.nLR.fM(true);
            }
        });
        sightCaptureUI.nLc.setOnClickListener(new OnClickListener(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI nLR;

            {
                this.nLR = r1;
            }

            public final void onClick(View view) {
                if (this.nLR.aMl()) {
                    this.nLR.finish();
                    this.nLR.overridePendingTransition(-1, com.tencent.mm.plugin.u.a.a.nNA);
                }
            }
        });
        sightCaptureUI.nLo.nKb = new MMSightCaptureTouchView.a(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI nLR;

            {
                this.nLR = r1;
            }

            public final void y(float f, float f2) {
                if (this.nLR.mNV != 0 && this.nLR.mNV != 3 && this.nLR.mNV != 4 && this.nLR.nLl != null) {
                    e g = this.nLR.nKY;
                    int width = this.nLR.nLl.getWidth();
                    int height = this.nLR.nLl.getHeight();
                    if (!com.tencent.mm.compatible.util.d.ep(14)) {
                        g.nCm.removeMessages(4354);
                        g.nCm.nCw = f;
                        g.nCm.mTA = f2;
                        g.nCm.nCx = width;
                        g.nCm.nCy = height;
                        g.nCm.sendMessageDelayed(g.nCm.obtainMessage(4354, g.gPJ), 400);
                    }
                    SightCaptureUI sightCaptureUI = this.nLR;
                    if (sightCaptureUI.nLi != null) {
                        LayoutParams layoutParams = (LayoutParams) sightCaptureUI.nLi.getLayoutParams();
                        layoutParams.leftMargin = ((int) f) - (sightCaptureUI.nLi.aar / 2);
                        layoutParams.topMargin = ((int) f2) - (sightCaptureUI.nLi.RQ / 2);
                        sightCaptureUI.nLi.setLayoutParams(layoutParams);
                        CameraFrontSightView cameraFrontSightView = sightCaptureUI.nLi;
                        cameraFrontSightView.setVisibility(0);
                        cameraFrontSightView.nJQ = true;
                        cameraFrontSightView.nJR = false;
                        cameraFrontSightView.nJS = false;
                        cameraFrontSightView.nJT = false;
                        cameraFrontSightView.nJU = System.currentTimeMillis();
                        cameraFrontSightView.invalidate();
                    }
                }
            }

            public final void aLU() {
                if (this.nLR.mNV != 0 && this.nLR.nLE > 1) {
                    this.nLR.nKY.nCm.removeMessages(4354);
                    SightCaptureUI.q(this.nLR);
                }
            }

            public final void aLV() {
                if (this.nLR.mNV != 0 && this.nLR.nKY != null) {
                    this.nLR.nKY.b(true, false, 1);
                }
            }

            public final void aLW() {
                if (this.nLR.mNV != 0 && this.nLR.nKY != null) {
                    this.nLR.nKY.b(false, false, 1);
                }
            }
        };
        sightCaptureUI.updateState(0);
        sightCaptureUI.aMf();
    }

    static /* synthetic */ void e(SightCaptureUI sightCaptureUI) {
        w.i("MicroMsg.SightCaptureUI", "[gotoPhotoEditUI]");
        if (sightCaptureUI.ivE == null) {
            w.e("MicroMsg.SightCaptureUI", "mediaRecorder == NULL");
            return;
        }
        String stringExtra = sightCaptureUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = sightCaptureUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        if (sightCaptureUI.nEC.scene == 1) {
            intent.putExtra("from_scene", 290);
        } else if (sightCaptureUI.nEC.scene == 2) {
            intent.putExtra("from_scene", 289);
        }
        intent.putExtra("before_photo_edit", bg.mA(sightCaptureUI.nLL) ? sightCaptureUI.ivE.aLd() : sightCaptureUI.nLL);
        com.tencent.mm.bb.d.b(sightCaptureUI, "photoedit", ".ui.MMPhotoEditUI", intent, 4369);
    }

    static /* synthetic */ void k(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.nLn != null && sightCaptureUI.nKX) {
            sightCaptureUI.nLn.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    this.nLR.nLn.setVisibility(8);
                }
            }).start();
        }
    }

    static /* synthetic */ void l(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.ivE != null) {
            w.v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", new Object[]{sightCaptureUI.ivE.aLh(), bg.bJZ().toString()});
            sightCaptureUI.updateState(5);
            if (sightCaptureUI.ivE.aLh() == d.c.Stop) {
                sightCaptureUI.nLG = sightCaptureUI.aMg();
                if (sightCaptureUI.nLG < 0) {
                    sightCaptureUI.aMh();
                    return;
                }
            } else if (sightCaptureUI.nLG < 0) {
                sightCaptureUI.aMh();
                return;
            }
            sightCaptureUI.updateState(2);
            if (sightCaptureUI.nKY != null) {
                e eVar = sightCaptureUI.nKY;
                w.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
                if (eVar.gPJ != null && eVar.nBJ) {
                    try {
                        Parameters parameters = eVar.gPJ.getParameters();
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                            w.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                            parameters.setFocusMode("continuous-video");
                        }
                        eVar.gPJ.setParameters(parameters);
                    } catch (Exception e) {
                        w.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[]{e.getMessage()});
                    }
                }
            }
            MMSightRecordButton mMSightRecordButton = sightCaptureUI.nLa;
            int i = (sightCaptureUI.nAE.duration * 1000) - 500;
            w.j("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[]{Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(i), new MMSightCircularProgressBar.a(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void aLX() {
                    this.nLR.oP();
                }
            }});
            MMSightCircularProgressBar mMSightCircularProgressBar = mMSightRecordButton.nKq;
            w.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(mMSightCircularProgressBar.fOV)});
            if (!mMSightCircularProgressBar.fOV) {
                mMSightCircularProgressBar.nKd = 0;
            }
            mMSightCircularProgressBar = mMSightRecordButton.nKq;
            w.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[]{Integer.valueOf(100)});
            mMSightCircularProgressBar.nKe = 100;
            mMSightCircularProgressBar = mMSightRecordButton.nKq;
            w.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[]{Integer.valueOf(i)});
            mMSightCircularProgressBar.duration = i;
            mMSightRecordButton.nKq.setVisibility(0);
            mMSightRecordButton.nKq.nKh = new com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass1(mMSightRecordButton, r2);
            MMSightCircularProgressBar mMSightCircularProgressBar2 = mMSightRecordButton.nKq;
            w.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", new Object[]{Integer.valueOf(mMSightCircularProgressBar2.nKd), Integer.valueOf(mMSightCircularProgressBar2.nKe), Integer.valueOf(mMSightCircularProgressBar2.duration)});
            mMSightCircularProgressBar2.nKc = 0.0f;
            mMSightCircularProgressBar2.nKg = new a((float) mMSightCircularProgressBar2.nKd, (float) mMSightCircularProgressBar2.nKe, mMSightCircularProgressBar2.duration);
            a aVar = mMSightCircularProgressBar2.nKg;
            w.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[]{new a.a(mMSightCircularProgressBar2) {
                final /* synthetic */ MMSightCircularProgressBar nKj;

                {
                    this.nKj = r1;
                }

                public final void aa(float f) {
                    this.nKj.nKc = f;
                    this.nKj.invalidate();
                }

                public final void onAnimationEnd() {
                    w.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 nKk;

                        {
                            this.nKk = r1;
                        }

                        public final void run() {
                            if (this.nKk.nKj.nKh != null) {
                                this.nKk.nKj.nKh.aLX();
                            }
                        }
                    });
                }
            }});
            aVar.nKT = r2;
            a aVar2 = mMSightCircularProgressBar2.nKg;
            w.i("MicroMsg.ProgressHandlerAnimator", "Start");
            aVar2.fOV = true;
            aVar2.nKR = bg.NA();
            aVar2.hMA.v(20, 20);
        }
    }

    static /* synthetic */ void q(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.nLI <= 0 || bg.aB(sightCaptureUI.nLI) > 500) {
            w.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[]{bg.bJZ().toString(), Integer.valueOf(sightCaptureUI.mNV)});
            sightCaptureUI.aMi();
            sightCaptureUI.nLB = true;
            if (sightCaptureUI.mNV == 2) {
                if (sightCaptureUI.ivE == null || !sightCaptureUI.ivE.aLl()) {
                    w.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    String str = "MicroMsg.SightCaptureUI";
                    String str2 = "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(sightCaptureUI.mNV);
                    objArr[1] = sightCaptureUI.ivE != null ? sightCaptureUI.ivE.aLh() : "";
                    w.i(str, str2, objArr);
                    if (sightCaptureUI.mNV == 2 && sightCaptureUI.ivE != null && sightCaptureUI.ivE.aLh() == d.c.Start) {
                        sightCaptureUI.ivE.pause();
                        sightCaptureUI.nKY.a(sightCaptureUI, sightCaptureUI.nLh, false);
                        sightCaptureUI.nLr = sightCaptureUI.nKY.nCn;
                        if (sightCaptureUI.nLm != null) {
                            sightCaptureUI.nLm.I(sightCaptureUI.nKY.arP(), sightCaptureUI.nKY.arQ(), sightCaptureUI.nKY.getOrientation());
                        }
                        if (sightCaptureUI.ivE.aLh() != d.c.Pause) {
                            w.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[]{sightCaptureUI.ivE.aLh()});
                        } else {
                            int arP = sightCaptureUI.nKY.arP();
                            int arQ = sightCaptureUI.nKY.arQ();
                            int orientation = sightCaptureUI.nKY.getOrientation();
                            Point aLj = sightCaptureUI.ivE.aLj();
                            w.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[]{Integer.valueOf(arP), Integer.valueOf(arQ), aLj, Integer.valueOf(orientation), Integer.valueOf(sightCaptureUI.ivE.aLk())});
                            if (!(sightCaptureUI.ivE.aLk() == orientation && aLj.x == arP && aLj.y == arQ)) {
                                w.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
                            }
                            sightCaptureUI.ivE.j(sightCaptureUI.nKY.arP(), sightCaptureUI.nKY.arQ(), sightCaptureUI.nKY.nBS.x, sightCaptureUI.nKY.nBS.y);
                            sightCaptureUI.ivE.F(orientation, sightCaptureUI.nKY.nBS.x, sightCaptureUI.nKY.nBS.y);
                        }
                    }
                    sightCaptureUI.nLC = true;
                }
            } else if (sightCaptureUI.mNV == 1) {
                sightCaptureUI.updateState(5);
                if (sightCaptureUI.fL(true)) {
                    sightCaptureUI.updateState(1);
                }
            }
            sightCaptureUI.aMj();
            sightCaptureUI.nLI = bg.NA();
            return;
        }
        w.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
    }

    static /* synthetic */ void r(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.nEC.scene == 1 || sightCaptureUI.nEC.scene == 2) {
            int i = sightCaptureUI.nLB ? sightCaptureUI.nLC ? 2 : 1 : 0;
            g.oUh.i(13820, new Object[]{Integer.valueOf(i), Integer.valueOf(sightCaptureUI.nEC.scene)});
        }
        Intent intent = new Intent();
        String filePath = sightCaptureUI.ivE.getFilePath();
        String Eo = com.tencent.mm.plugin.sight.base.d.Eo(filePath);
        sightCaptureUI.ac(filePath, false);
        if (com.tencent.mm.plugin.mmsight.model.a.aKH() != null) {
            sightCaptureUI.nLs.tOv = com.tencent.mm.plugin.mmsight.model.a.aKH().aKI();
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.nKY.nCn, filePath, Eo, sightCaptureUI.ivE.getFileName(), sightCaptureUI.ivE.EP(), sightCaptureUI.ivE.aLi(), sightCaptureUI.nLs));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
    }

    static /* synthetic */ void s(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.nLH != null && sightCaptureUI.nLH.isAlive()) {
            try {
                sightCaptureUI.nLH.join();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SightCaptureUI", e, "wait saveCaptureImageThread error: %s", new Object[]{e.getMessage()});
            }
        }
        if (sightCaptureUI.nEC.scene == 1 || sightCaptureUI.nEC.scene == 2) {
            int i = 0;
            if (sightCaptureUI.nLB) {
                i = 1;
            }
            g.oUh.i(13820, new Object[]{Integer.valueOf(i), Integer.valueOf(sightCaptureUI.nEC.scene)});
        }
        if (sightCaptureUI.nEC.scene == 1) {
            g.oUh.i(13858, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
        } else if (sightCaptureUI.nEC.scene == 2) {
            g.oUh.i(13858, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
        }
        Intent intent = new Intent();
        Object obj = (bg.mA(sightCaptureUI.nLM) || sightCaptureUI.ivE == null || !sightCaptureUI.nLM.equals(sightCaptureUI.ivE.aLd())) ? null : 1;
        if (obj == null) {
            w.i("MicroMsg.SightCaptureUI", "is not Photo editted!");
            sightCaptureUI.ac(sightCaptureUI.ivE.aLd(), true);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.nKY.nCn, sightCaptureUI.ivE.aLd()));
        sightCaptureUI.setResult(-1, intent);
        Bundle bundle = sightCaptureUI.nLO;
        if (bundle == null) {
            w.e("MicroMsg.SightCaptureUI", "[reportPhotoEdit] date == null");
        } else if (sightCaptureUI.nLN) {
            int i2 = bundle.getInt("report_info_emotion_count");
            int i3 = bundle.getInt("report_info_text_count");
            int i4 = bundle.getInt("report_info_mosaic_count");
            int i5 = bundle.getInt("report_info_doodle_count");
            boolean z = bundle.getBoolean("report_info_iscrop");
            int i6 = bundle.getInt("report_info_undo_count");
            boolean z2 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.SightCaptureUI";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i4);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            objArr[5] = Integer.valueOf(i6);
            objArr[6] = Boolean.valueOf(z2);
            w.i(str, str2, objArr);
            g gVar = g.oUh;
            objArr = new Object[10];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i5);
            objArr[6] = Integer.valueOf(z ? 1 : 0);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = Integer.valueOf(3);
            objArr[9] = Integer.valueOf(z2 ? 1 : 0);
            gVar.i(13857, objArr);
        } else {
            w.i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] reportPhotoEdit == false");
        }
        sightCaptureUI.finish();
    }

    static /* synthetic */ void y(SightCaptureUI sightCaptureUI) {
        w.i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        if (sightCaptureUI.nLg.getVisibility() == 8) {
            sightCaptureUI.nLo.setVisibility(8);
        } else {
            sightCaptureUI.nLo.setVisibility(0);
        }
        Point cy = com.tencent.mm.plugin.mmsight.d.cy(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.nNB);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.nND);
        sightCaptureUI.nLa.getX();
        sightCaptureUI.nLb.setTranslationX(((((float) cy.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.ngX.setTranslationX(((((float) (-cy.x)) / 2.0f) + ((float) dimensionPixelSize2)) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.nLb.setEnabled(false);
        sightCaptureUI.ngX.setEnabled(false);
    }

    public void onCreate(Bundle bundle) {
        aq(1);
        super.onCreate(bundle);
        this.nEC = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.nEC == null) {
            w.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.lvq));
        final long NA = bg.NA();
        this.lvq.G(new Runnable(this) {
            final /* synthetic */ SightCaptureUI nLR;

            public final void run() {
                w.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[]{Long.valueOf(bg.aB(NA))});
                com.tencent.mm.plugin.mmsight.model.j.b(this.nLR.nEC.nAE);
                SightCaptureUI.b(this.nLR);
            }
        });
    }

    protected void onPause() {
        super.onPause();
        w.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[]{pN(this.mNV)});
        if (this.mNV == 2) {
            oP();
        } else if (this.mNV == 1) {
            aMk();
        } else if (this.mNV == 4 && this.nLq != null) {
            this.nLq.pause();
        }
    }

    protected void onResume() {
        boolean z = false;
        super.onResume();
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "onResume, currentState: %s, textureview available: %s";
        Object[] objArr = new Object[2];
        objArr[0] = pN(this.mNV);
        if (this.nKZ != null && this.nKZ.isAvailable()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        if (this.mNV == 2 || this.mNV == 1) {
            aMf();
        } else if (this.mNV == 4) {
            if (this.nKZ != null) {
                if (this.nKZ.isAvailable()) {
                    this.nLm.aMn();
                } else {
                    this.nKZ.a(new com.tencent.mm.plugin.video.b(this) {
                        final /* synthetic */ SightCaptureUI nLR;

                        {
                            this.nLR = r1;
                        }

                        public final void b(SurfaceTexture surfaceTexture) {
                            this.nLR.nLm.aMn();
                            this.nLR.nKZ.a(null);
                        }
                    });
                }
            }
            if (this.nLq != null) {
                this.nLq.start();
            }
        } else if (this.mNV == 3) {
            if (this.nKZ != null) {
                this.nKZ.a(null);
            }
            this.nLm.a(this.nLy, this.nLD, this.nLz);
        }
    }

    protected final int Ol() {
        return 1;
    }

    private void oP() {
        w.j("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[]{Integer.valueOf(this.mNV)});
        if (this.mNV == 2) {
            updateState(6);
            this.nLa.fK(false);
            final int arP = this.nKY.arP();
            final int arQ = this.nKY.arQ();
            this.ivE.A(new Runnable(this) {
                final /* synthetic */ SightCaptureUI nLR;

                public final void run() {
                    w.j("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[]{SightCaptureUI.pN(this.nLR.mNV)});
                    this.nLR.nKY.a(e.a.Stoping);
                    this.nLR.aMk();
                    final long AP = com.tencent.mm.plugin.mmsight.d.AP("TIME_RECODER_2_PLAY");
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 nLU;

                        public final void run() {
                            String filePath = this.nLU.nLR.ivE.getFilePath();
                            try {
                                if (!bg.mA(filePath) && FileOp.aO(filePath)) {
                                    int i;
                                    int i2;
                                    int i3;
                                    int i4;
                                    int i5;
                                    g.oUh.a(440, 87, 1, false);
                                    int i6 = (int) new JSONObject(SightVideoJNI.getSimpleMp4Info(filePath)).getDouble("videoFPS");
                                    w.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s", new Object[]{Integer.valueOf(i6)});
                                    com.tencent.mm.plugin.mmsight.model.a aKH = com.tencent.mm.plugin.mmsight.model.a.aKH();
                                    aKH.nBl = com.tencent.mm.plugin.mmsight.model.j.nCL.gRq;
                                    aKH.hzY = com.tencent.mm.plugin.mmsight.model.j.nCL.hzY;
                                    aKH.gRr = com.tencent.mm.plugin.mmsight.model.j.nCL.nCV ? 1 : 0;
                                    aKH.nBm = com.tencent.mm.plugin.mmsight.model.j.nCL.nCW ? 1 : 0;
                                    aKH.nBn = com.tencent.mm.plugin.mmsight.model.j.nCL.nBn;
                                    aKH.nBo = i6;
                                    aKH.fileSize = FileOp.ki(filePath);
                                    com.tencent.mm.plugin.sight.base.a Er = com.tencent.mm.plugin.sight.base.d.Er(filePath);
                                    if (Er != null) {
                                        aKH.nBr = Er.width;
                                        aKH.nBs = Er.height;
                                        aKH.nBt = Er.hzY;
                                        aKH.nBp = Er.lMh;
                                    }
                                    if (com.tencent.mm.plugin.mmsight.model.j.nCL.gRq == 1) {
                                        g.oUh.a(440, 89, 1, false);
                                        g.oUh.a(440, 49, (long) i6, false);
                                        i = 93;
                                        i2 = 73;
                                        i3 = 69;
                                    } else {
                                        g.oUh.a(440, 88, 1, false);
                                        g.oUh.a(440, 48, (long) i6, false);
                                        i = 90;
                                        i2 = 54;
                                        i3 = 50;
                                    }
                                    if (com.tencent.mm.plugin.mmsight.model.j.nCL.nBn == 720) {
                                        i2 += 6;
                                        i4 = i + 1;
                                        i5 = i3 + 6;
                                    } else if (com.tencent.mm.plugin.mmsight.model.j.nCL.aKV()) {
                                        i2 += 12;
                                        i4 = i + 2;
                                        i5 = i3 + 12;
                                    } else {
                                        i4 = i;
                                        i5 = i3;
                                    }
                                    g.oUh.a(440, (long) i2, (long) i6, false);
                                    g.oUh.a(440, (long) i4, 1, false);
                                    g.oUh.a(440, 47, (long) i6, false);
                                    w.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[]{filePath, Integer.valueOf(i5)});
                                    if (i6 >= 0 && i6 <= 10) {
                                        g.oUh.a(440, (long) i5, 1, false);
                                    } else if (i6 > 10 && i6 <= 15) {
                                        g.oUh.a(440, (long) (i5 + 1), 1, false);
                                    } else if (i6 > 15 && i6 <= 20) {
                                        g.oUh.a(440, (long) (i5 + 2), 1, false);
                                    } else if (i6 > 20 && i6 <= 30) {
                                        g.oUh.a(440, (long) (i5 + 3), 1, false);
                                    }
                                }
                            } catch (Exception e) {
                                w.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[]{e.getMessage()});
                            }
                            com.tencent.mm.plugin.mmsight.model.k.b(false, AP);
                        }
                    }, "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
                    w.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[]{bg.bJZ().toString()});
                    w.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[]{this.nLR.ivE.getFilePath(), Long.valueOf(FileOp.ki(this.nLR.ivE.getFilePath())), Long.valueOf(AP)});
                    SightCaptureUI.y(this.nLR);
                    i.y(new Runnable(this.nLR) {
                        final /* synthetic */ SightCaptureUI nLR;

                        {
                            this.nLR = r1;
                        }

                        public final void run() {
                            String AN = com.tencent.mm.plugin.mmsight.d.AN(this.nLR.ivE.getFilePath());
                            if (!bg.mA(AN)) {
                                AN = ((AN + "\n" + String.format("FPS: %s", new Object[]{Float.valueOf(this.nLR.ivE.aLe())})) + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[]{Long.valueOf(com.tencent.mm.plugin.mmsight.d.AP("TIME_RECODER_2_PLAY"))})) + "\n" + String.format("CPU: cur %s max:%s", new Object[]{l.ro(), l.rm()});
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass10 nLW;

                                    public final void run() {
                                        w.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", new Object[]{AN});
                                        k.aLr();
                                        if (k.aLu()) {
                                            TextView textView = (TextView) this.nLW.nLR.findViewById(com.tencent.mm.plugin.u.a.d.nOa);
                                            textView.setVisibility(0);
                                            textView.setText(AN);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    SightCaptureUI.J(this.nLR);
                    af.f(this.nLR.nLP, 1000);
                    if (this.nLR.nEC.scene == 1 || this.nLR.nEC.scene == 2) {
                        g.oUh.i(13819, new Object[]{Integer.valueOf(2), Integer.valueOf(this.nLR.nEC.scene)});
                    }
                }
            });
        }
    }

    private void aMf() {
        updateState(0);
        this.nLG = 0;
        this.nLF = false;
        this.nLq.stop();
        this.nLq.pvi = null;
        try {
            ViewGroup.LayoutParams layoutParams = this.nLq.getLayoutParams();
            this.nLd.removeView(this.nLq);
            this.nLd.addView(this.nLq, 0, layoutParams);
        } catch (Exception e) {
            w.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[]{e.getMessage()});
        }
        this.nLk.setImageBitmap(null);
        aMk();
        this.nKY = new e(this.nAE, this.nEC.scene);
        this.nKY.a(this.nLm.nMj);
        if (this.nKY.f(this, this.nLr)) {
            if (this.nKZ.isAvailable()) {
                w.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface");
                this.nLh = this.nKZ.getSurfaceTexture();
                if (fL(false)) {
                    updateState(1);
                } else {
                    updateState(7);
                }
            } else {
                this.nKZ.a(new com.tencent.mm.plugin.video.b(this) {
                    final /* synthetic */ SightCaptureUI nLR;

                    {
                        this.nLR = r1;
                    }

                    public final void b(SurfaceTexture surfaceTexture) {
                        w.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface");
                        this.nLR.nLh = surfaceTexture;
                        if (this.nLR.fL(false)) {
                            this.nLR.updateState(1);
                        } else {
                            this.nLR.updateState(7);
                        }
                    }
                });
            }
            if (this.nLn != null && this.nKX) {
                this.nLn.setAlpha(1.0f);
                this.nLn.setVisibility(0);
            }
            c cVar = this.nLA;
            w.i("MicroMsg.DeviceOrientationListener", "reset");
            cVar.nBA = -1;
            cVar.orientation = -1;
            cVar.nBz = -1;
            this.nLB = false;
            this.nLC = false;
            return;
        }
        updateState(7);
    }

    private boolean fL(boolean z) {
        w.h("MicroMsg.SightCaptureUI", "createRecorder", new Object[0]);
        if (this.ivE != null) {
            if (this.nKY != null) {
                e eVar = this.nKY;
                com.tencent.mm.plugin.mmsight.model.f aLg = this.ivE.aLg();
                if (aLg != null) {
                    eVar.nBY.remove(aLg);
                }
            }
            this.ivE.cancel();
        }
        if (this.nKY == null) {
            return false;
        }
        this.nLs = new aks();
        this.nLs.tOs = true;
        if (z) {
            boolean a = this.nKY.a(this, this.nLh, true);
            this.nLr = this.nKY.nCn;
            if (!a) {
                return false;
            }
        } else if (this.nKY.a(this.nLh, true) < 0) {
            return false;
        }
        if (this.nKY.nBS == null) {
            return false;
        }
        k.aLr();
        this.ivE = k.c(this.nAE);
        if (this.ivE == null) {
            w.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            return false;
        }
        com.tencent.mm.plugin.mmsight.d.a(this.ivE, this.nEC);
        this.ivE.a(this);
        this.nKY.a(this.ivE.aLg());
        if (this.nLm != null) {
            this.nLm.I(this.nKY.arP(), this.nKY.arQ(), this.nKY.getOrientation());
        }
        this.ivE.j(this.nKY.arP(), this.nKY.arQ(), this.nKY.nBS.x, this.nKY.nBS.y);
        w.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[]{Boolean.valueOf(this.ivE.pE(this.nKY.getOrientation()))});
        return this.ivE.pE(this.nKY.getOrientation());
    }

    private int aMg() {
        w.i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int b = this.ivE.b(this.nKY.getOrientation(), this.nLA.aKK(), this.nLA.getOrientation());
        w.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[]{Integer.valueOf(b)});
        if (b >= 0) {
            this.nKY.a(e.a.Recording);
        }
        return b;
    }

    private void aMh() {
        updateState(7);
        if (this.ivE != null) {
            try {
                this.ivE.cancel();
                this.ivE = null;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SightCaptureUI", e, "", new Object[0]);
            }
        }
    }

    private void aMi() {
        k.aLr();
        if (k.aLu()) {
            TextView textView = (TextView) findViewById(com.tencent.mm.plugin.u.a.d.nOa);
            textView.setVisibility(8);
            textView.setText("");
        }
    }

    private void aMj() {
        k.aLr();
        if (k.aLu()) {
            w.i("MicroMsg.SightCaptureUI", "test for debug " + bg.bJZ().toString());
            i.z(new Runnable(this) {
                final /* synthetic */ SightCaptureUI nLR;

                {
                    this.nLR = r1;
                }

                public final void run() {
                    SightCaptureUI.L(this.nLR);
                }
            });
        }
    }

    private String ac(String str, boolean z) {
        String mr;
        boolean booleanValue = ((Boolean) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFN, Boolean.valueOf(true))).booleanValue();
        boolean booleanValue2 = ((Boolean) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFO, Boolean.valueOf(true))).booleanValue();
        if (z) {
            mr = com.tencent.mm.plugin.mmsight.d.mr("jpg");
        } else {
            mr = com.tencent.mm.plugin.mmsight.d.mr("mp4");
        }
        if ((booleanValue && z) || (booleanValue2 && !z)) {
            w.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[]{str, mr, Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2)});
            FileOp.p(str, mr);
            com.tencent.mm.platformtools.d.b(mr, this);
        }
        return mr;
    }

    private void aMk() {
        if (this.nKZ != null) {
            this.nKZ.a(null);
        }
        if (this.nKY != null) {
            this.nLr = this.nKY.nCn;
            this.nKY.aKL();
            this.nLI = -1;
            this.nLJ = -1;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.SightCaptureUI", "onDestroy");
        this.lvq.release();
        if (this.ivE != null) {
            this.ivE.A(null);
        }
        if ((this.mNV == -1 ? 1 : null) == null) {
            aMk();
            if (this.nLq != null) {
                this.nLq.stop();
                this.nLq.pvi = null;
            }
            if (this.ict != null) {
                this.ict.rY();
            }
        }
        if (this.nLA != null) {
            this.nLA.disable();
            this.nLA = null;
        }
        j.nEA.wl();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.u.a.e.nOb;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "[onActivityResult] requestCode:%s  resultCode:%s data is null?:";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.i(str, str2, objArr);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4369:
                w.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[]{Integer.valueOf(i2)});
                if (i2 == -1 && intent != null && this.ivE != null) {
                    this.nLN = true;
                    this.nLO = intent.getBundleExtra("report_info");
                    this.nLL = intent.getStringExtra("before_photo_edit");
                    this.nLM = intent.getStringExtra("after_photo_edit");
                    w.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[]{this.nLL, this.nLM, Boolean.valueOf(((Boolean) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFN, Boolean.valueOf(true))).booleanValue())});
                    if (((Boolean) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFN, Boolean.valueOf(true))).booleanValue()) {
                        this.ivE.AR(this.nLM);
                    } else {
                        String subCoreImageFullPath = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
                        w.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[]{subCoreImageFullPath});
                        FileOp.p(this.nLM, subCoreImageFullPath);
                        FileOp.deleteFile(this.nLM);
                        com.tencent.mm.platformtools.d.b(this.nLM, this);
                        this.ivE.AR(subCoreImageFullPath);
                        this.nLM = subCoreImageFullPath;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.nLM, options);
                    w.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)});
                    Bitmap a = com.tencent.mm.sdk.platformtools.d.a(this.nLM, options.outHeight, options.outWidth, true, false, 0);
                    this.nLk.setVisibility(0);
                    this.nLk.setImageBitmap(a);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static String pN(int i) {
        if (i == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i == 5) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i == 6) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i == 7) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i == 8) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void updateState(int i) {
        w.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[]{Integer.valueOf(this.mNV), pN(this.mNV), Integer.valueOf(i), pN(i)});
        w.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[]{Integer.valueOf(this.mNV), pN(this.mNV), Integer.valueOf(i), pN(i), bg.bJZ().toString()});
        if (i != this.mNV) {
            com.tencent.mm.plugin.mmsight.d.AO("TIME_RECODER_2_PLAY");
            this.mNV = i;
            if (this.mNV != 6) {
                af.I(this.nLK);
            }
            if (this.mNV == 0) {
                this.nLd.setVisibility(8);
                this.nLg.setVisibility(8);
                this.nLe.setVisibility(8);
                this.nLk.setVisibility(8);
                if (this.nLE > 1) {
                    this.nLf.setVisibility(0);
                }
                if (this.nKY != null) {
                    this.nKY.a(e.a.Preview);
                }
                com.tencent.mm.plugin.mmsight.model.a.reset();
                if (this.nLH != null) {
                    try {
                        this.nLH.interrupt();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SightCaptureUI", e, "update to state init, interrupt failed: %s", new Object[]{e.getMessage()});
                    }
                    this.nLH = null;
                }
            } else if (this.mNV == 1 || this.mNV == 2) {
                this.nLd.setVisibility(0);
                this.nLg.setVisibility(8);
                this.nLe.setVisibility(0);
                this.nLe.setClipChildren(false);
                this.nLb.setVisibility(8);
                this.ngX.setVisibility(8);
                this.nLc.setVisibility(0);
                this.nLa.setVisibility(0);
                this.nLq.setVisibility(8);
                if (this.mNV == 1) {
                    this.nLa.reset();
                } else {
                    this.nLa.fK(true);
                    MMSightRecordButton mMSightRecordButton = this.nLa;
                    w.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
                    mMSightRecordButton.nKp.setVisibility(8);
                }
                this.nLp.setVisibility(8);
                this.nLk.setVisibility(8);
                this.nLo.setVisibility(0);
                if (this.nLE > 1) {
                    this.nLf.setVisibility(0);
                }
                this.nLo.bringToFront();
                this.nLf.bringToFront();
                aMi();
                aMj();
            } else if (this.mNV == 4 || this.mNV == 3) {
                this.nLd.setVisibility(0);
                this.nLe.setVisibility(0);
                this.nLe.setClipChildren(false);
                this.nLb.setVisibility(0);
                this.ngX.setVisibility(0);
                this.nLc.setVisibility(8);
                this.nLa.setVisibility(8);
                if (this.mNV == 3) {
                    this.nLg.setVisibility(0);
                    this.nLk.setVisibility(0);
                    this.nLq.setVisibility(8);
                } else {
                    this.nLk.setVisibility(8);
                    this.nLq.setVisibility(0);
                    if (this.ivE.aKK()) {
                        this.nLm.aMn();
                    }
                }
                if (this.nLg.getVisibility() == 8) {
                    this.nLo.setVisibility(8);
                } else {
                    this.nLo.setVisibility(0);
                }
            } else if (this.mNV == 5) {
                this.nLb.setVisibility(8);
                this.ngX.setVisibility(8);
                this.nLg.setVisibility(8);
                this.nLc.setVisibility(8);
                this.nLa.setVisibility(8);
            } else if (this.mNV == 6) {
                this.nLb.setVisibility(8);
                this.ngX.setVisibility(8);
                this.nLc.setVisibility(8);
                this.nLf.setVisibility(8);
                this.nLg.setVisibility(8);
                this.nLa.fK(false);
                af.f(this.nLK, 1500);
                this.nLa.aLY();
            } else if (this.mNV == 7) {
                this.nLd.setVisibility(0);
                this.nLe.setVisibility(0);
                this.nLe.setClipChildren(false);
                this.nLb.setVisibility(8);
                this.ngX.setVisibility(8);
                this.nLg.setVisibility(8);
                this.nLc.setVisibility(0);
                if (this.nLE > 1) {
                    this.nLf.setVisibility(0);
                }
                this.nLa.setVisibility(0);
                this.nLo.setVisibility(0);
                this.nLq.setVisibility(8);
                this.nLp.setVisibility(8);
                this.nLk.setVisibility(8);
                Toast.makeText(this, com.tencent.mm.plugin.u.a.f.nOi, 1).show();
                this.nLa.fK(false);
                this.nLa.setEnabled(false);
            } else if (this.mNV == 8) {
                this.nLb.setVisibility(8);
                this.ngX.setVisibility(8);
                this.nLg.setVisibility(8);
                this.nLc.setVisibility(0);
                this.nLf.setVisibility(8);
                this.nLa.reset();
                this.nLa.fK(false);
                this.nLa.setEnabled(false);
                Toast.makeText(this, com.tencent.mm.plugin.u.a.f.nOe, 1).show();
            }
        }
    }

    private void fM(boolean z) {
        w.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[]{Boolean.valueOf(z), this.nLM, this.nLL});
        if (!bg.mA(this.nLM) && z) {
            FileOp.deleteFile(this.nLM);
        }
        if (!bg.mA(this.nLL)) {
            FileOp.deleteFile(this.nLL);
        }
        this.nLM = null;
        this.nLL = null;
        com.tencent.mm.sdk.b.b kyVar = new ky();
        kyVar.fRF.fEG = 0;
        com.tencent.mm.sdk.b.a.urY.m(kyVar);
    }

    public void onBackPressed() {
        w.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[]{Integer.valueOf(this.mNV)});
        if (aMl()) {
            super.onBackPressed();
            overridePendingTransition(-1, com.tencent.mm.plugin.u.a.a.nNA);
            fM(true);
        }
    }

    private boolean aMl() {
        return this.mNV == 4 || this.mNV == 3 || this.mNV == 1 || this.mNV == 7 || this.mNV == 8;
    }

    public final void pC(int i) {
        if (this.nLE > 1 && this.mNV != 2) {
            w.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[]{Integer.valueOf(i)});
            if (i >= 0) {
                float f;
                if (i != 90 && i != 270) {
                    f = (float) i;
                } else if (i == 270) {
                    f = 90.0f;
                } else {
                    f = -90.0f;
                }
                if (this.nLf.getRotation() != f) {
                    this.nLf.animate().rotation(f).setDuration(100).start();
                }
            }
        }
    }

    public final void asE() {
        w.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[]{Integer.valueOf(1)});
        try {
            if (this.ivE != null) {
                this.ivE.reset();
            }
        } catch (Exception e) {
            w.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[]{e.getMessage()});
        }
        updateState(8);
    }
}
