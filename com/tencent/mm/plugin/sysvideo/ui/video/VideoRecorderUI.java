package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.m.b;
import com.tencent.mm.pluginsdk.m.e;
import com.tencent.mm.pluginsdk.m.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.x;

public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI qWQ;
    private String fJL = null;
    private String fVB = null;
    private ProgressDialog isv = null;
    private long jYB = -1;
    private aj jYV = new aj(new a(this) {
        final /* synthetic */ VideoRecorderUI qWZ;

        {
            this.qWZ = r1;
        }

        public final boolean oQ() {
            if (this.qWZ.jYB == -1) {
                this.qWZ.jYB = SystemClock.elapsedRealtime();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.qWZ.jYB;
            this.qWZ.qWL.setText(e.hb((int) (elapsedRealtime / 1000)));
            if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
                this.qWZ.qWG.setVisibility(8);
            } else {
                long j = (30000 - elapsedRealtime) / 1000;
                this.qWZ.qWG.setVisibility(0);
                this.qWZ.qWG.setText(this.qWZ.getResources().getQuantityString(R.j.dsF, (int) j, new Object[]{Long.valueOf(j)}));
            }
            if (elapsedRealtime >= 30000) {
                w.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
                VideoRecorderUI.d(this.qWZ);
                this.qWZ.jYB = -1;
                return false;
            }
            this.qWZ.qWO = this.qWZ.qWO % 2;
            if (this.qWZ.qWO == 0) {
                this.qWZ.qWK.setVisibility(4);
            } else {
                this.qWZ.qWK.setVisibility(0);
            }
            this.qWZ.qWO = this.qWZ.qWO + 1;
            return true;
        }
    }, true);
    private boolean pdM;
    private SurfaceView qWA = null;
    private SurfaceHolder qWB = null;
    private b qWC;
    private ImageButton qWD;
    private boolean qWE = false;
    private boolean qWF = false;
    private TextView qWG;
    private LinearLayout qWH;
    private ImageView qWI;
    private ImageButton qWJ = null;
    private ImageView qWK;
    private TextView qWL;
    private TextView qWM;
    private TextView qWN;
    private int qWO = 0;
    private ImageButton qWP;
    private boolean qWR = false;
    private boolean qWS = true;
    private String qWT = null;
    private String qWU = null;
    private View qWV;
    private View qWW;
    private ae qWX = new ae(this) {
        final /* synthetic */ VideoRecorderUI qWZ;

        {
            this.qWZ = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.qWZ.qWP.setEnabled(true);
        }
    };
    Callback qWY = new Callback(this) {
        final /* synthetic */ VideoRecorderUI qWZ;

        {
            this.qWZ = r1;
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            w.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
            if (this.qWZ.qWC.g(this.qWZ, this.qWZ.qWR) != 0) {
                this.qWZ.bnt();
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            w.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
            this.qWZ.qWS = true;
            this.qWZ.qWC.bDM();
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            w.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
            if (this.qWZ.qWC.b(surfaceHolder) != 0) {
                this.qWZ.bnt();
            }
            this.qWZ.qWR = false;
            this.qWZ.qWS = false;
            VideoRecorderUI.x(this.qWZ);
        }
    };
    private String qWw = null;

    static /* synthetic */ void d(VideoRecorderUI videoRecorderUI) {
        Bitmap createVideoThumbnail;
        videoRecorderUI.qWF = false;
        videoRecorderUI.releaseWakeLock();
        videoRecorderUI.qWD.setImageResource(R.g.bkY);
        videoRecorderUI.qWD.setEnabled(false);
        videoRecorderUI.getString(R.l.dIO);
        videoRecorderUI.isv = g.a(videoRecorderUI, videoRecorderUI.getString(R.l.fac, new Object[]{Integer.valueOf(0)}), true, new OnCancelListener(videoRecorderUI) {
            final /* synthetic */ VideoRecorderUI qWZ;

            {
                this.qWZ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                w.d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
                if (this.qWZ.qWC != null) {
                    this.qWZ.aED();
                    this.qWZ.qWH.setVisibility(0);
                    this.qWZ.qWA.setVisibility(0);
                }
            }
        });
        long elapsedRealtime = SystemClock.elapsedRealtime() - videoRecorderUI.jYB;
        videoRecorderUI.jYV.KH();
        videoRecorderUI.qWG.setVisibility(8);
        videoRecorderUI.qWE = true;
        b bVar = videoRecorderUI.qWC;
        if (bVar.nEx != null) {
            try {
                bVar.nEx.stop();
                bVar.nEx.release();
            } catch (Exception e) {
                w.e("MicroMsg.SceneVideo", "video[tiger] video stop failed");
            }
            bVar.nEx = null;
            bVar.pxW.iap = (int) (elapsedRealtime / 1000);
            bVar.pxW.iap = bVar.pxW.iap > 0 ? bVar.pxW.iap : 1;
            bVar.pxW.nDl = bVar.pxW.iap * bVar.pxW.gPE;
            if (!(!com.tencent.mm.a.e.aO(bVar.pxW.nDk) || com.tencent.mm.a.e.aO(bVar.pxW.nDi) || bVar.context == null)) {
                createVideoThumbnail = d.eo(8) ? ThumbnailUtils.createVideoThumbnail(bVar.pxW.nDk, 1) : null;
                if (createVideoThumbnail != null) {
                    try {
                        w.d("MicroMsg.SceneVideo", "saveBitmapToImage " + bVar.pxW.nDi);
                        e.a(createVideoThumbnail, CompressFormat.JPEG, bVar.pxW.nDi);
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.SceneVideo", e2, "", new Object[0]);
                    }
                } else {
                    try {
                        e.a(BitmapFactory.decodeStream(bVar.context.getResources().openRawResource(R.g.ber)), CompressFormat.JPEG, bVar.pxW.nDi);
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.SceneVideo", e22, "", new Object[0]);
                    }
                }
            }
            if (com.tencent.mm.a.e.aO(bVar.pxW.nDk)) {
                bVar.fileSize = com.tencent.mm.a.e.aN(bVar.pxW.nDk);
            }
        }
        String str = videoRecorderUI.qWC.pxW.nDi;
        if (str == null || str.length() <= 0) {
            createVideoThumbnail = null;
        } else {
            Bitmap c = BackwardSupportUtil.b.c(str.trim(), com.tencent.mm.bg.a.getDensity(videoRecorderUI));
            if (c != null) {
                int width = c.getWidth();
                int height = c.getHeight();
                int a = BackwardSupportUtil.b.a(videoRecorderUI, 224.0f);
                createVideoThumbnail = Bitmap.createScaledBitmap(c, a, (int) (((float) height) / (((float) width) / ((float) a))), true);
                if (c != createVideoThumbnail) {
                    w.i("MicroMsg.SceneVideo", "recycle bitmap:%s", new Object[]{c.toString()});
                    c.recycle();
                }
            } else {
                createVideoThumbnail = c;
            }
        }
        if (createVideoThumbnail != null) {
            videoRecorderUI.qWA.setVisibility(8);
            videoRecorderUI.qWI.setVisibility(0);
            videoRecorderUI.qWI.setImageBitmap(createVideoThumbnail);
        }
        if (videoRecorderUI.isv != null) {
            videoRecorderUI.isv.dismiss();
            videoRecorderUI.isv = null;
        }
        videoRecorderUI.qWG.setVisibility(8);
        videoRecorderUI.qWW.setVisibility(0);
        TextView textView = videoRecorderUI.qWM;
        elapsedRealtime = (long) videoRecorderUI.qWC.fileSize;
        r0 = (elapsedRealtime >> 20) > 0 ? (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1048576.0f)) / 10.0f) + "MB" : (elapsedRealtime >> 9) > 0 ? (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1024.0f)) / 10.0f) + "KB" : elapsedRealtime + "B";
        textView.setText(r0);
        videoRecorderUI.qWN.setText(e.hb(videoRecorderUI.qWC.pxW.iap));
        videoRecorderUI.qWH.setVisibility(8);
        videoRecorderUI.qWJ.setVisibility(0);
        videoRecorderUI.qWV.setVisibility(8);
        videoRecorderUI.qWP.setVisibility(8);
        videoRecorderUI.qWD.setVisibility(8);
        videoRecorderUI.qWD.setEnabled(true);
        videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        videoRecorderUI.cO().cP().show();
    }

    static /* synthetic */ void n(VideoRecorderUI videoRecorderUI) {
        videoRecorderUI.uSU.bQg();
        videoRecorderUI.qWH.setVisibility(0);
        videoRecorderUI.qWA.setVisibility(0);
        videoRecorderUI.qWP.setVisibility(8);
        videoRecorderUI.qWW.setVisibility(8);
        videoRecorderUI.qWF = true;
        videoRecorderUI.qWI.setVisibility(8);
        videoRecorderUI.qWJ.setVisibility(8);
        videoRecorderUI.qWV.setVisibility(0);
        videoRecorderUI.qWG.setVisibility(0);
        videoRecorderUI.jYB = -1;
        videoRecorderUI.jYV.v(300, 300);
        videoRecorderUI.qWA.setKeepScreenOn(true);
        b bVar = videoRecorderUI.qWC;
        SurfaceHolder surfaceHolder = videoRecorderUI.qWB;
        if (surfaceHolder == null) {
            w.e("MicroMsg.SceneVideo", "start fail, holder is null");
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        bVar.sHo = 0;
        bVar.a(surface, bVar.pxW.gPE, 0);
    }

    static /* synthetic */ void x(VideoRecorderUI videoRecorderUI) {
        int arP;
        int arQ;
        LayoutParams layoutParams = (LayoutParams) videoRecorderUI.qWA.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (videoRecorderUI.pdM) {
            arP = videoRecorderUI.qWC.arP();
            arQ = videoRecorderUI.qWC.arQ();
        } else {
            arP = videoRecorderUI.qWC.arQ();
            arQ = videoRecorderUI.qWC.arP();
        }
        w.i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", new Object[]{Integer.valueOf(arP), Integer.valueOf(arQ), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        if (((float) arP) / ((float) arQ) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            w.i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            arQ = (int) (((float) arQ) * (((float) displayMetrics.widthPixels) / ((float) arP)));
            arP = displayMetrics.widthPixels;
        } else {
            w.i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            arP = (int) ((((float) displayMetrics.heightPixels) / ((float) arQ)) * ((float) arP));
            arQ = displayMetrics.heightPixels;
        }
        w.i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", new Object[]{Integer.valueOf(arP), Integer.valueOf(arQ)});
        layoutParams.width = arP;
        layoutParams.height = arQ;
        videoRecorderUI.qWA.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l.et(this);
        qWQ = this;
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        cO().cP().hide();
        zi(R.l.fat);
        a(0, getString(R.l.dIA), new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoRecorderUI qWZ;

            {
                this.qWZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("VideoRecorder_FileName", this.qWZ.qWC.filename);
                intent.putExtra("VideoRecorder_VideoLength", this.qWZ.qWC.pxW.iap);
                intent.putExtra("VideoRecorder_ToUser", this.qWZ.fJL);
                this.qWZ.setResult(-1, intent);
                this.qWZ.finish();
                return true;
            }
        }, l.b.uTY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoRecorderUI qWZ;

            {
                this.qWZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qWZ.bns();
                return true;
            }
        });
        this.fJL = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.fVB = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.qWw = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.qWT = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.qWU = getIntent().getStringExtra("VideoRecorder_FileName");
        w.d("MicroMsg.VideoRecorderUI", "talker :" + this.fJL);
        w.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.fVB + " videoFullPath " + this.qWw + " videoThumbPath " + this.qWT + " KFileName " + this.qWU);
        KC();
        aED();
        ap.oH().pS();
    }

    public void onStart() {
        super.onStart();
        if (this.pdM) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected void onDestroy() {
        qWQ = null;
        w.v("MicroMsg.VideoRecorderUI", "on destroy");
        ap.oH().pR();
        super.onDestroy();
    }

    protected final void KC() {
        int i = 1;
        this.qWA = (SurfaceView) findViewById(R.h.cGR);
        this.qWH = (LinearLayout) findViewById(R.h.cMd);
        this.qWB = this.qWA.getHolder();
        this.qWB.addCallback(this.qWY);
        this.qWB.setType(3);
        this.qWK = (ImageView) findViewById(R.h.cMg);
        this.qWP = (ImageButton) findViewById(R.h.cMs);
        this.qWL = (TextView) findViewById(R.h.cMe);
        this.qWV = findViewById(R.h.cMf);
        this.qWW = findViewById(R.h.cLZ);
        this.qWL.setText(e.hb(0));
        this.qWC = new b();
        this.qWG = (TextView) findViewById(R.h.cMu);
        this.qWM = (TextView) findViewById(R.h.cMh);
        this.qWN = (TextView) findViewById(R.h.cMa);
        this.qWD = (ImageButton) findViewById(R.h.cMt);
        this.qWD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI qWZ;

            {
                this.qWZ = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                if (!c.isSDCardAvailable()) {
                    s.eP(this.qWZ);
                } else if (this.qWZ.qWF) {
                    VideoRecorderUI.d(this.qWZ);
                } else if (this.qWZ.qWE) {
                    g.a(this.qWZ, this.qWZ.getString(R.l.fas), this.qWZ.getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 qXa;

                        {
                            this.qXa = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.qXa.qWZ.qWD.setImageResource(R.g.bkZ);
                            VideoRecorderUI.n(this.qXa.qWZ);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 qXa;

                        {
                            this.qXa = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    this.qWZ.qWD.setImageResource(R.g.bkZ);
                    VideoRecorderUI.n(this.qWZ);
                }
            }
        });
        if (com.tencent.mm.compatible.d.c.getNumberOfCameras() > 1) {
            this.qWP.setVisibility(0);
        } else {
            this.qWP.setVisibility(4);
        }
        this.qWP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI qWZ;

            {
                this.qWZ = r1;
            }

            public final void onClick(View view) {
                this.qWZ.qWP.setEnabled(false);
                this.qWZ.qWX.sendEmptyMessageDelayed(0, 3000);
                this.qWZ.qWR = true;
                this.qWZ.qWC.bDM();
                if (this.qWZ.qWC.g(this.qWZ, this.qWZ.qWR) != 0 || this.qWZ.qWC.b(this.qWZ.qWB) != 0) {
                    this.qWZ.bnt();
                }
            }
        });
        this.qWJ = (ImageButton) findViewById(R.h.cLW);
        this.qWI = (ImageView) findViewById(R.h.cMc);
        this.qWJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI qWZ;

            {
                this.qWZ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.qWZ, VideoRecorderPreviewUI.class);
                intent.putExtra("VideoRecorder_FileName", this.qWZ.qWC.filename);
                intent.putExtra("VideoRecorder_VideoLength", this.qWZ.qWC.pxW.iap);
                intent.putExtra("VideoRecorder_VideoSize", this.qWZ.qWC.fileSize);
                intent.putExtra("VideoRecorder_ToUser", this.qWZ.fJL);
                intent.putExtra("VideoRecorder_VideoFullPath", this.qWZ.qWw);
                this.qWZ.startActivityForResult(intent, 0);
                this.qWZ.overridePendingTransition(0, 0);
            }
        });
        b bVar = this.qWC;
        int i2 = !this.pdM ? 1 : 0;
        String str = this.fVB;
        String str2 = this.qWw;
        String str3 = this.qWT;
        String str4 = this.qWU;
        bVar.hYB = 0;
        if (1 == bVar.hYB) {
            bVar.pxW = com.tencent.mm.pluginsdk.m.a.bDL();
        } else {
            bVar.pxW = com.tencent.mm.pluginsdk.m.a.bDK();
        }
        if (p.gRe.gRC) {
            bVar.pxW.nDc = p.gRe.gRE;
            bVar.pxW.nDd = p.gRe.gRD;
            bVar.pxW.nDb = p.gRe.gRG;
        }
        bVar.filename = str4;
        bVar.pxW.nDk = str2;
        bVar.pxW.nDi = str3;
        bVar.pxW.nDh = str + "temp.pcm";
        bVar.pxW.nDg = str + "temp.yuv";
        bVar.pxW.nDj = str + "temp.vid";
        bVar.pxW.nDm = com.tencent.mm.compatible.d.c.getNumberOfCameras();
        com.tencent.mm.pluginsdk.m.a aVar = bVar.pxW;
        if (i2 == 0) {
            i = 0;
        }
        aVar.gPG = i;
        bVar.pxW.iap = 0;
        bVar.sHn = new f();
    }

    protected final void bE(View view) {
        x.d(x.a(getWindow(), null), this.uSU.uTa);
        ((ViewGroup) this.uSU.uTa.getParent()).removeView(this.uSU.uTa);
        ((ViewGroup) getWindow().getDecorView()).addView(this.uSU.uTa, 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        w.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
        if (this.qWF) {
            return true;
        }
        bns();
        return true;
    }

    private void bns() {
        if (this.qWE) {
            g.a(this, getString(R.l.far), getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ VideoRecorderUI qWZ;

                {
                    this.qWZ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.qWZ.finish();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ VideoRecorderUI qWZ;

                {
                    this.qWZ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else {
            finish();
        }
    }

    private void aED() {
        cO().cP().hide();
        this.qWL.setText(e.hb(0));
        this.qWV.setVisibility(8);
        this.qWW.setVisibility(8);
        this.qWK.setVisibility(0);
        this.qWE = false;
        this.qWH.setVisibility(0);
        this.qWA.setVisibility(0);
        this.qWG.setVisibility(8);
        this.qWJ.setVisibility(8);
        this.qWL.setText(e.hb(0));
        this.qWI.setVisibility(8);
        this.qWD.setEnabled(true);
        this.qWP.setVisibility(0);
    }

    protected void onResume() {
        if (!(this.qWS || (this.qWC.g(this, false) == 0 && this.qWC.b(this.qWB) == 0))) {
            bnt();
        }
        this.qWS = false;
        w.v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
    }

    protected void onPause() {
        if (this.qWF) {
            b bVar = this.qWC;
            if (bVar.nEx != null) {
                bVar.nEx.stop();
                bVar.nEx.release();
                bVar.nEx = null;
            }
            aED();
            this.qWF = false;
            releaseWakeLock();
            this.qWD.setImageResource(R.g.bkY);
            this.jYV.KH();
            this.qWG.setVisibility(8);
            this.qWH.setVisibility(0);
            this.qWA.setVisibility(0);
        }
        this.qWC.bDM();
        w.v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 0) {
                setResult(-1, intent);
                finish();
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void bnt() {
        g.a(this, R.l.fad, R.l.dIO, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI qWZ;

            {
                this.qWZ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.qWZ.qWC.bDM();
                this.qWZ.finish();
            }
        });
    }

    private void releaseWakeLock() {
        this.qWA.setKeepScreenOn(false);
    }

    protected final int getLayoutId() {
        this.pdM = com.tencent.mm.compatible.d.c.rh();
        if (!this.pdM) {
            return R.i.dpt;
        }
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        setRequestedOrientation(0);
        return R.i.dpu;
    }
}
