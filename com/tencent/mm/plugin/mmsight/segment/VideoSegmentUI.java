package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.l.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.g;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI extends MMActivity {
    private String fKz;
    private int hTi;
    private ProgressDialog isv = null;
    private RelativeLayout lMj;
    private com.tencent.mm.remoteservice.d lvq = new com.tencent.mm.remoteservice.d(this);
    private VideoTransPara nCg;
    private String nIS = null;
    private g nIT;
    private com.tencent.mm.plugin.mmsight.segment.a.c nIU;
    private boolean nIV = false;
    private d nIW;
    private Surface nIX;
    private CountDownLatch nIY = new CountDownLatch(2);
    private int nIZ = 10000;
    private String nJa = "";
    private boolean nJb = false;
    private boolean nJc = false;
    private boolean nJd = false;
    private com.tencent.mm.plugin.mmsight.segment.d.b nJe = new com.tencent.mm.plugin.mmsight.segment.d.b(this) {
        final /* synthetic */ VideoSegmentUI nJh;

        {
            this.nJh = r1;
        }

        public final void v(float f, float f2) {
            if (this.nJh.nIU != null) {
                int e = this.nJh.hTi;
                this.nJh.nIU.setLoop((int) (((float) e) * f), (int) (((float) e) * f2));
                this.nJh.nIU.seekTo((int) (((float) e) * f));
            }
        }

        public final void aLH() {
            if (this.nJh.nIU != null) {
                this.nJh.nIU.pause();
            }
        }

        public final void w(float f, float f2) {
            if (this.nJh.nIU != null) {
                int e = (int) (((float) this.nJh.hTi) * f);
                this.nJh.nIU.setLoop(e, (int) (((float) this.nJh.hTi) * f2));
                this.nJh.nIU.seekTo(e);
            }
        }

        public final void x(float f, float f2) {
            if ((f2 - f) * ((float) this.nJh.hTi) <= ((float) this.nJh.nIZ)) {
                this.nJh.kr(true);
            } else {
                this.nJh.kr(false);
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.a.c.a nJf = new com.tencent.mm.plugin.mmsight.segment.a.c.a(this) {
        final /* synthetic */ VideoSegmentUI nJh;
        private Runnable nJi;

        {
            this.nJh = r1;
        }

        public final void pK(int i) {
            if (this.nJh.nIW != null) {
                if (this.nJi != null) {
                    ((View) this.nJh.nIW).removeCallbacks(this.nJi);
                }
                this.nJi = new c(this.nJh.nIW, i, this.nJh.hTi);
                ((View) this.nJh.nIW).post(this.nJi);
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.a.a.d nJg = new com.tencent.mm.plugin.mmsight.segment.a.a.d(this) {
        final /* synthetic */ VideoSegmentUI nJh;

        {
            this.nJh = r1;
        }

        public final void H(int i, int i2, int i3) {
            if (i <= 0 || i2 <= 0) {
                w.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.nJh.nJd)});
            } else if (this.nJh.nJd) {
                w.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
            } else {
                w.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.nJh.nJd = true;
                if (i2 <= 0 || i <= 0) {
                    w.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    this.nJh.nJc = true;
                    this.nJh.finish();
                    VideoSegmentUI.b(this.nJh);
                    return;
                }
                Runnable aVar = new a(this.nJh, this.nJh.lMj, i2, i, i3, new b(this.nJh));
                if (this.nJh.lMj.getWidth() <= 0 || this.nJh.lMj.getHeight() <= 0) {
                    w.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                    this.nJh.lMj.post(aVar);
                    return;
                }
                aVar.run();
            }
        }
    };

    private class a implements Runnable {
        private Context context;
        final /* synthetic */ VideoSegmentUI nJh;
        public int nJm;
        public int nJn;
        public int nJo;
        private ViewGroup nJp;
        private b nJq;

        public a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i, int i2, int i3, b bVar) {
            this.nJh = videoSegmentUI;
            this.nJm = i;
            this.nJn = i2;
            this.nJo = i3;
            this.context = viewGroup.getContext();
            this.nJp = viewGroup;
            this.nJq = bVar;
        }

        public final void run() {
            if (!this.nJh.isFinishing()) {
                View anonymousClass1 = new MMTextureView(this, this.context) {
                    final /* synthetic */ a nJr;

                    protected final void onMeasure(int i, int i2) {
                        w.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", new Object[]{Integer.valueOf(this.nJr.nJn), Integer.valueOf(this.nJr.nJm), Integer.valueOf(this.nJr.nJo), Integer.valueOf(View.getDefaultSize(1, i)), Integer.valueOf(View.getDefaultSize(1, i2))});
                        if (this.nJr.nJo == 90 || this.nJr.nJo == 270) {
                            Matrix matrix = new Matrix();
                            matrix.set(getMatrix());
                            int defaultSize = View.getDefaultSize(1, i);
                            int defaultSize2 = View.getDefaultSize(1, i2);
                            float f = ((float) defaultSize) / 2.0f;
                            float f2 = ((float) defaultSize2) / 2.0f;
                            float f3 = ((float) defaultSize2) / ((float) defaultSize);
                            matrix.postRotate((float) this.nJr.nJo, f, f2);
                            matrix.postScale(1.0f / f3, f3, f, f2);
                            setTransform(matrix);
                            w.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", new Object[]{Integer.valueOf(this.nJr.nJo), Integer.valueOf(defaultSize), Integer.valueOf(defaultSize2)});
                        }
                        super.onMeasure(i, i2);
                    }
                };
                int width = this.nJp.getWidth();
                int T = com.tencent.mm.bg.a.T(this.context, com.tencent.mm.plugin.mmsight.segment.l.b.nHp);
                int top = ((View) this.nJh.nIW).getTop() - (T * 2);
                int i = this.nJn;
                int i2 = this.nJm;
                Point point = new Point();
                float f = ((float) i2) / ((float) i) > ((float) top) / ((float) width) ? ((float) top) / ((float) i2) : ((float) width) / ((float) i);
                point.x = (int) (((float) i) * f);
                point.y = (int) (f * ((float) i2));
                w.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.nJn), Integer.valueOf(this.nJm), Integer.valueOf(this.nJo), Integer.valueOf(T), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
                if (point.x <= 0 || point.y <= 0) {
                    w.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.nJn), Integer.valueOf(this.nJm), Integer.valueOf(T), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
                    if (this.nJq != null) {
                        b bVar = this.nJq;
                        w.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
                        bVar.nJh.nJc = true;
                        bVar.nJh.finish();
                        VideoSegmentUI.b(bVar.nJh);
                        return;
                    }
                    return;
                }
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
                T += (int) (((float) (top - point.y)) / 2.0f);
                layoutParams.topMargin = T;
                layoutParams.bottomMargin = T;
                width = (int) (((float) (width - point.x)) / 2.0f);
                layoutParams.leftMargin = width;
                layoutParams.rightMargin = width;
                anonymousClass1.setSurfaceTextureListener(this.nJq);
                this.nJp.addView(anonymousClass1, 0, layoutParams);
            }
        }
    }

    private class b implements SurfaceTextureListener {
        final /* synthetic */ VideoSegmentUI nJh;

        public b(VideoSegmentUI videoSegmentUI) {
            this.nJh = videoSegmentUI;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.nJh.nJb);
            objArr[1] = Boolean.valueOf(this.nJh.nIU == null);
            w.i(str, str2, objArr);
            this.nJh.nIX = new Surface(surfaceTexture);
            if (this.nJh.nIU == null && this.nJh.nJb) {
                w.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    this.nJh.a(false, this.nJh.nIX);
                    if (!(this.nJh.nIW == null || this.nJh.nIU == null)) {
                        this.nJh.nIU.setLoop((int) (((float) this.nJh.hTi) * this.nJh.nIW.aLF()), (int) (((float) this.nJh.hTi) * this.nJh.nIW.aLG()));
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "ResumeMediaPlayer error %s", new Object[]{e.getMessage()});
                }
                this.nJh.nJb = false;
            }
            this.nJh.nIY.countDown();
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            w.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", new Object[]{bg.bJZ()});
            try {
                if (this.nJh.nIU != null) {
                    w.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
                    this.nJh.nIU.release();
                    this.nJh.nIU = null;
                    this.nJh.nJb = true;
                }
                this.nJh.nIX = null;
            } catch (Exception e) {
            }
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    private static class c implements Runnable {
        private int hTi;
        private WeakReference<d> hqr;
        private int nJs;

        public c(d dVar, int i, int i2) {
            this.hqr = new WeakReference(dVar);
            this.nJs = i;
            this.hTi = i2;
        }

        public final void run() {
            d dVar = (d) this.hqr.get();
            if (dVar != null) {
                dVar.Y(((float) this.nJs) / ((float) this.hTi));
            }
        }
    }

    private class d implements Runnable {
        final /* synthetic */ VideoSegmentUI nJh;

        public d(VideoSegmentUI videoSegmentUI) {
            this.nJh = videoSegmentUI;
        }

        public final void run() {
            boolean await;
            try {
                await = this.nJh.nIY.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                w.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[]{e});
                await = false;
            }
            if (await) {
                try {
                    if (!(this.nJh.nJc || this.nJh.isFinishing() || this.nJh.nIX == null || !this.nJh.nIX.isValid())) {
                        if (this.nJh.nIU != null) {
                            this.nJh.nIU.a(null);
                            this.nJh.nIU.a(null);
                            this.nJh.nIU.release();
                            this.nJh.nIU = null;
                        }
                        try {
                            this.nJh.a(false, this.nJh.nIX);
                            this.nJh.nIU.setSurface(this.nJh.nIX);
                            af.v(new Runnable(this) {
                                final /* synthetic */ d nJt;

                                {
                                    this.nJt = r1;
                                }

                                public final void run() {
                                    if (this.nJt.nJh.nJc || this.nJt.nJh.isFinishing() || this.nJt.nJh.nIW == null || this.nJt.nJh.nIU == null) {
                                        w.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                                        return;
                                    }
                                    ((View) this.nJt.nJh.nIW).setAlpha(0.0f);
                                    ((View) this.nJt.nJh.nIW).setVisibility(0);
                                    ((View) this.nJt.nJh.nIW).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
                                    float aLF = this.nJt.nJh.nIW.aLF();
                                    float aLG = this.nJt.nJh.nIW.aLG();
                                    if ((aLG - aLF) * ((float) this.nJt.nJh.hTi) <= ((float) this.nJt.nJh.nIZ)) {
                                        this.nJt.nJh.kr(true);
                                    }
                                    this.nJt.nJh.nIU.setLoop((int) (aLF * ((float) this.nJt.nJh.hTi)), (int) (aLG * ((float) this.nJt.nJh.hTi)));
                                }
                            });
                            return;
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "init segmentPlayer second time %s", new Object[]{e2.getMessage()});
                            this.nJh.finish();
                            return;
                        }
                    }
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.VideoSegmentUI", e22, "Finished when init", new Object[0]);
                    this.nJh.finish();
                    return;
                }
            }
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(await);
            objArr[1] = Boolean.valueOf(this.nJh.nJc);
            objArr[2] = Boolean.valueOf(this.nJh.isFinishing());
            objArr[3] = Boolean.valueOf(this.nJh.nIX == null);
            w.w(str, str2, objArr);
            this.nJh.finish();
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI) {
        boolean z = false;
        videoSegmentUI.b(new OnMenuItemClickListener(videoSegmentUI) {
            final /* synthetic */ VideoSegmentUI nJh;

            {
                this.nJh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nJh.finish();
                VideoSegmentUI.b(this.nJh);
                return true;
            }
        });
        videoSegmentUI.zi(f.nHu);
        videoSegmentUI.a(0, com.tencent.mm.bg.a.V(videoSegmentUI.uSU.uTo, f.dHp), new OnMenuItemClickListener(videoSegmentUI) {
            final /* synthetic */ VideoSegmentUI nJh;

            {
                this.nJh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                VideoSegmentUI.c(this.nJh);
                return true;
            }
        }, com.tencent.mm.ui.l.b.uTY);
        videoSegmentUI.kr(false);
        Intent intent = videoSegmentUI.getIntent();
        if (intent == null || bg.mA(intent.getStringExtra("key_video_path"))) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "is Intent null ? %b, is path null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.e(str, str2, objArr);
            videoSegmentUI.finish();
            return;
        }
        videoSegmentUI.nIS = intent.getStringExtra("key_video_path");
        w.i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", new Object[]{videoSegmentUI.nIS});
        if (videoSegmentUI.nIS == null || videoSegmentUI.nIS.length() == 0) {
            w.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            return;
        }
        videoSegmentUI.KC();
        try {
            videoSegmentUI.a(true, null);
            videoSegmentUI.nIW.a(new com.tencent.mm.plugin.mmsight.segment.d.a(videoSegmentUI) {
                final /* synthetic */ VideoSegmentUI nJh;

                {
                    this.nJh = r1;
                }

                public final void fH(boolean z) {
                    if (z) {
                        Toast.makeText(this.nJh, f.nHv, 1).show();
                        w.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
                        this.nJh.nJc = true;
                        this.nJh.finish();
                        VideoSegmentUI.b(this.nJh);
                        return;
                    }
                    if (!(this.nJh.isFinishing() || this.nJh.nIW == null)) {
                        this.nJh.hTi = this.nJh.nIW.getDurationMs();
                        w.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", new Object[]{Integer.valueOf(this.nJh.hTi)});
                        try {
                            if (this.nJh.nIU != null) {
                                this.nJh.nIU.setLoop((int) (((float) this.nJh.hTi) * this.nJh.nIW.aLF()), (int) (((float) this.nJh.hTi) * this.nJh.nIW.aLG()));
                            }
                        } catch (Exception e) {
                        }
                    }
                    this.nJh.nIY.countDown();
                }
            });
            videoSegmentUI.nIW.a(videoSegmentUI.nJe);
            videoSegmentUI.nIW.AT(videoSegmentUI.nIS);
            videoSegmentUI.nIT = new p();
            e.a(new d(videoSegmentUI), "waiting_for_component_prepared.");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "MediaPlayer set data source error : [%s]", new Object[]{e.getMessage()});
            videoSegmentUI.finish();
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.nJa);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.fKz);
            videoSegmentUI.setResult(-1, intent);
            videoSegmentUI.finish();
            return;
        }
        w.e("MicroMsg.VideoSegmentUI", "Clip not success. %s", new Object[]{str});
    }

    static /* synthetic */ void b(VideoSegmentUI videoSegmentUI) {
        int i = 0;
        while (true) {
            try {
                if (((long) i) < videoSegmentUI.nIY.getCount()) {
                    videoSegmentUI.nIY.countDown();
                    i++;
                } else {
                    return;
                }
            } catch (Exception e) {
                w.e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", new Object[]{e});
                return;
            }
        }
    }

    static /* synthetic */ void c(VideoSegmentUI videoSegmentUI) {
        videoSegmentUI.nJa = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        videoSegmentUI.fKz = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        e.post(new Runnable(videoSegmentUI) {
            final /* synthetic */ VideoSegmentUI nJh;

            {
                this.nJh = r1;
            }

            public final void run() {
                List<FileEntry> x = FileOp.x(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (x != null && x.size() != 0) {
                    for (FileEntry fileEntry : x) {
                        if (fileEntry.name != null && ((fileEntry.name.contains("vsg_output_") && !fileEntry.name.contains(this.nJh.nJa)) || (fileEntry.name.contains("vsg_thumb_") && !fileEntry.name.contains(this.nJh.fKz)))) {
                            com.tencent.mm.loader.stub.b.deleteFile(fileEntry.name);
                        }
                    }
                }
            }
        }, "delete_old_temp_video_file");
        if (bg.mA(videoSegmentUI.nJa) || bg.mA(videoSegmentUI.fKz)) {
            w.e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            return;
        }
        videoSegmentUI.nCg = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.nCg == null) {
            w.e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
        } else if (videoSegmentUI.nIS == null) {
            w.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
        } else if (videoSegmentUI.nIY.getCount() != 0) {
            w.e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
        } else {
            w.i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(f.dIO);
            videoSegmentUI.isv = g.a(videoSegmentUI, videoSegmentUI.getString(f.dJd), false, null);
            videoSegmentUI.nIW.fG(true);
            e.post(new Runnable(videoSegmentUI) {
                final /* synthetic */ VideoSegmentUI nJh;

                {
                    this.nJh = r1;
                }

                public final void run() {
                    boolean z = true;
                    String str = null;
                    try {
                        this.nJh.nIU.stop();
                        int e = this.nJh.hTi;
                        long NA = bg.NA();
                        this.nJh.nIT.a(this.nJh.nIS, this.nJh.nJa, this.nJh.nCg);
                        if (this.nJh.nIT.n((long) (this.nJh.nIW.aLF() * ((float) e)), (long) (((float) e) * this.nJh.nIW.aLG())) < 0) {
                            w.i("MicroMsg.VideoSegmentUI", "clip failed! %s", new Object[]{Integer.valueOf(this.nJh.nIT.n((long) (this.nJh.nIW.aLF() * ((float) e)), (long) (((float) e) * this.nJh.nIW.aLG())))});
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass7 nJj;

                                {
                                    this.nJj = r1;
                                }

                                public final void run() {
                                    if (this.nJj.nJh.isv != null) {
                                        this.nJj.nJh.isv.dismiss();
                                    }
                                    if (this.nJj.nJh.nIW != null) {
                                        this.nJj.nJh.nIW.fG(false);
                                    }
                                    Toast.makeText(this.nJj.nJh, f.nHv, 1).show();
                                }
                            });
                            return;
                        }
                        Bitmap kE = com.tencent.mm.plugin.mmsight.d.kE(this.nJh.nJa);
                        if (kE != null) {
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            if (com.tencent.mm.plugin.mmsight.d.a(kE.getWidth(), kE.getHeight(), this.nJh.nCg.hzZ, pInt, pInt2)) {
                                kE = Bitmap.createScaledBitmap(kE, pInt.value, pInt2.value, true);
                            }
                            w.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", new Object[]{Integer.valueOf(kE.getWidth()), Integer.valueOf(kE.getHeight())});
                            com.tencent.mm.sdk.platformtools.d.a(kE, 80, CompressFormat.JPEG, this.nJh.fKz, true);
                            w.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", new Object[]{Long.valueOf(bg.aB(NA))});
                        } else {
                            w.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
                        }
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 nJj;

                            public final void run() {
                                if (this.nJj.nJh.isv != null) {
                                    this.nJj.nJh.isv.dismiss();
                                }
                                if (this.nJj.nJh.nIW != null) {
                                    this.nJj.nJh.nIW.fG(false);
                                }
                                VideoSegmentUI.a(this.nJj.nJh, z, str);
                            }
                        });
                    } catch (Throwable e2) {
                        Throwable th = e2;
                        str = th.getMessage();
                        w.printErrStackTrace("MicroMsg.VideoSegmentUI", th, "UnexpectedException when clip : [%s]", new Object[]{th.getMessage()});
                        z = false;
                    }
                }
            }, "clip_video");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.lvq));
        this.lvq.G(new Runnable(this) {
            final /* synthetic */ VideoSegmentUI nJh;

            {
                this.nJh = r1;
            }

            public final void run() {
                w.i("MicroMsg.VideoSegmentUI", "has connect");
                if (CaptureMMProxy.getInstance() != null) {
                    p.du(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                VideoSegmentUI.a(this.nJh);
            }
        });
    }

    protected final void KC() {
        this.nIW = (d) findViewById(com.tencent.mm.plugin.mmsight.segment.l.c.nHq);
        this.lMj = (RelativeLayout) findViewById(com.tencent.mm.plugin.mmsight.segment.l.c.czn);
    }

    private void a(boolean z, Surface surface) {
        if (this.nIU != null) {
            w.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            return;
        }
        this.nIU = new com.tencent.mm.plugin.mmsight.segment.a.c();
        this.nIV = false;
        this.nIU.setDataSource(this.nIS);
        this.nIU.a(new com.tencent.mm.plugin.mmsight.segment.a.a.a(this) {
            final /* synthetic */ VideoSegmentUI nJh;

            {
                this.nJh = r1;
            }

            public final boolean cr(int i, int i2) {
                w.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.nJh.nJc = true;
                this.nJh.finish();
                VideoSegmentUI.b(this.nJh);
                return true;
            }
        });
        if (z) {
            this.nIU.a(this.nJg);
        }
        this.nIU.setAudioStreamType(3);
        this.nIU.setLooping(true);
        if (surface != null) {
            this.nIU.setSurface(surface);
        }
        this.nIU.nJf = this.nJf;
        this.nIU.a(new com.tencent.mm.plugin.mmsight.segment.a.a.b(this) {
            final /* synthetic */ VideoSegmentUI nJh;

            {
                this.nJh = r1;
            }

            public final void ba(Object obj) {
                w.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[]{obj});
                try {
                    if (this.nJh.nIU != null) {
                        this.nJh.nIV = true;
                        this.nJh.nIU.start();
                    }
                } catch (Exception e) {
                }
            }
        });
        this.nIU.prepareAsync();
        this.nIU.a(new com.tencent.mm.plugin.mmsight.segment.a.a.c(this) {
            final /* synthetic */ VideoSegmentUI nJh;

            {
                this.nJh = r1;
            }

            public final void bb(Object obj) {
                if (this.nJh.nIU != null) {
                    this.nJh.nIU.start();
                }
            }
        });
    }

    protected void onResume() {
        if (this.nIU != null && this.nIV) {
            w.i("MicroMsg.VideoSegmentUI", "onResume start player");
            this.nIU.start();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.nIU != null) {
            w.i("MicroMsg.VideoSegmentUI", "onPause pause player");
            this.nIU.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        w.i("MicroMsg.VideoSegmentUI", "onDestroy");
        super.onDestroy();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        this.lvq.release();
        if (this.nIW != null) {
            this.nIW.release();
        }
        if (this.nIU != null) {
            this.nIU.release();
        }
        if (this.nIX != null) {
            this.nIX.release();
        }
        if (this.nIT != null) {
            this.nIT.release();
        }
        j.nEA.wl();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.mmsight.segment.l.d.nHr;
    }
}
