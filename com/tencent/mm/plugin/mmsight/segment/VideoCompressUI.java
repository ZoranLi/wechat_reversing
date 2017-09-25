package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.l.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import java.util.List;

@TargetApi(16)
public class VideoCompressUI extends MMBaseActivity {
    private String fKz;
    private String fVB;
    private d lvq = new d(this);
    private VideoTransPara nGL;
    private ProgressDialog nIN;
    private a nIO = new a(this);
    private Runnable nIP = new Runnable(this) {
        final /* synthetic */ VideoCompressUI nIQ;

        {
            this.nIQ = r1;
        }

        public final void run() {
            try {
                VideoCompressUI.a(this.nIQ, this.nIQ.fVB);
                Intent intent = new Intent();
                Point l = VideoCompressUI.l(this.nIQ.nIO.hTk, this.nIQ.nIO.hTj, this.nIQ.nGL.width, this.nIQ.nGL.height);
                if (VideoCompressUI.b(this.nIQ, this.nIQ.nGL) || l != null) {
                    Point point;
                    if (l == null) {
                        point = new Point(this.nIQ.nIO.hTk, this.nIQ.nIO.hTj);
                    } else {
                        point = l;
                    }
                    String e = VideoCompressUI.e(this.nIQ);
                    SightVideoJNI.remuxing(this.nIQ.fVB, e, point.x, point.y, this.nIQ.nGL.hzY, this.nIQ.nGL.hzO, 8, this.nIQ.nGL.hzN, 25.0f, (float) this.nIQ.nGL.gPE, null, 0, b.pty);
                    intent.putExtra("K_SEGMENTVIDEOPATH", e);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", this.nIQ.cR(e, null));
                } else {
                    intent.putExtra("K_SEGMENTVIDEOPATH", this.nIQ.fVB);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", this.nIQ.cR(this.nIQ.fVB, this.nIQ.fKz));
                }
                this.nIQ.setResult(-1, intent);
            } catch (Throwable e2) {
                w.printErrStackTrace("VideoCompressUI", e2, "video compress failed e [%s]", new Object[]{e2.getMessage()});
            } finally {
                this.nIQ.finish();
            }
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 nIR;

                {
                    this.nIR = r1;
                }

                public final void run() {
                    if (this.nIR.nIQ.nIN != null) {
                        this.nIR.nIQ.nIN.dismiss();
                    }
                }
            });
        }
    };

    private class a {
        public int audioBitRate = -1;
        public String hTg;
        public String hTh;
        public int hTi = -1;
        public int hTj = -1;
        public int hTk = -1;
        public int hTl = -1;
        final /* synthetic */ VideoCompressUI nIQ;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;

        public a(VideoCompressUI videoCompressUI) {
            this.nIQ = videoCompressUI;
        }
    }

    static /* synthetic */ void a(VideoCompressUI videoCompressUI, String str) {
        MediaFormat mediaFormat = null;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            MediaFormat mediaFormat2 = null;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    w.i("VideoCompressUI", "find video mime : %s", new Object[]{string});
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            if (mediaFormat2 == null) {
                                mediaFormat2 = trackFormat;
                            }
                        } else if (string.startsWith("audio/") && r0 == null) {
                            mediaFormat = trackFormat;
                        }
                        if (!(mediaFormat == null || r1 == null)) {
                            break;
                        }
                    }
                    continue;
                }
            }
            MediaFormat mediaFormat3 = mediaFormat2;
            mediaFormat2 = mediaFormat;
            try {
                com.tencent.mm.plugin.sight.base.a Er = com.tencent.mm.plugin.sight.base.d.Er(str);
                if (Er == null) {
                    w.e("VideoCompressUI", "Get Media Info failed.");
                    videoCompressUI.finish();
                    return;
                }
                if (videoCompressUI.nIO != null && videoCompressUI.nIO.hTi == -1) {
                    videoCompressUI.nIO.videoBitRate = Er.hzY;
                    videoCompressUI.nIO.audioBitRate = Er.hzL;
                    if (mediaFormat3 != null) {
                        videoCompressUI.nIO.hTi = !mediaFormat3.containsKey("durationUs") ? 0 : (int) (mediaFormat3.getLong("durationUs") / 1000);
                        videoCompressUI.nIO.hTj = !mediaFormat3.containsKey("height") ? 0 : mediaFormat3.getInteger("height");
                        videoCompressUI.nIO.hTk = !mediaFormat3.containsKey("width") ? 0 : mediaFormat3.getInteger("width");
                        videoCompressUI.nIO.hTg = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
                        videoCompressUI.nIO.hTl = !mediaFormat3.containsKey("i-frame-interval") ? 0 : mediaFormat3.getInteger("i-frame-interval");
                        videoCompressUI.nIO.videoFrameRate = !mediaFormat3.containsKey("frame-rate") ? 0 : mediaFormat3.getInteger("frame-rate");
                    }
                    if (mediaFormat2 != null) {
                        videoCompressUI.nIO.hTh = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                    }
                }
                mediaExtractor.release();
            } catch (Throwable e) {
                w.printErrStackTrace("VideoCompressUI", e, "Get MediaInfo failed", new Object[0]);
                videoCompressUI.finish();
                mediaExtractor.release();
            }
        } catch (Exception e2) {
            w.e("VideoCompressUI", "Video extractor init failed. video path = [%s] e = [%s]", new Object[]{str, e2.getMessage()});
        } finally {
            mediaExtractor.release();
        }
    }

    static /* synthetic */ boolean b(VideoCompressUI videoCompressUI, VideoTransPara videoTransPara) {
        boolean z = false;
        if (videoTransPara.hzM < videoCompressUI.nIO.hTl) {
            z = true;
        }
        if (videoTransPara.hzY < videoCompressUI.nIO.videoBitRate) {
            z = true;
        }
        if (videoTransPara.gPE < videoCompressUI.nIO.videoFrameRate) {
            z = true;
        }
        return videoTransPara.hzL < videoCompressUI.nIO.audioBitRate ? true : z;
    }

    static /* synthetic */ String e(VideoCompressUI videoCompressUI) {
        final String str = CaptureMMProxy.getInstance().getAccVideoPath() + "video_send_preprocess_tmp_" + System.currentTimeMillis() + ".mp4";
        e.post(new Runnable(videoCompressUI) {
            final /* synthetic */ VideoCompressUI nIQ;

            public final void run() {
                List<FileEntry> x = FileOp.x(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (x != null) {
                    for (FileEntry fileEntry : x) {
                        if (!(bg.mA(fileEntry.name) || !fileEntry.name.contains("video_send_preprocess_tmp_") || str.equals(fileEntry.name))) {
                            FileOp.deleteFile(fileEntry.name);
                        }
                    }
                }
            }
        }, "delete other tmp path");
        return str;
    }

    static /* synthetic */ Point l(int i, int i2, int i3, int i4) {
        w.d("VideoCompressUI", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                int i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) i5)));
                    } else {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) max)));
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    w.i("VideoCompressUI", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(max)});
                    point.x = i5;
                    point.y = max;
                    return point;
                }
                w.i("VideoCompressUI", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            }
            w.i("VideoCompressUI", "calc scale, same len divide by 16, no need scale");
            return null;
        }
        w.i("VideoCompressUI", "calc scale, small or equal to spec size");
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(l.d.cVc);
        Intent intent = getIntent();
        if (intent == null || bg.mA(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
            setResult(0);
            finish();
            return;
        }
        this.nIN = g.a(this, getString(f.dJd), false, null);
        this.fVB = intent.getStringExtra("K_SEGMENTVIDEOPATH");
        this.fKz = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.lvq));
        this.lvq.G(new Runnable(this) {
            final /* synthetic */ VideoCompressUI nIQ;

            {
                this.nIQ = r1;
            }

            public final void run() {
                this.nIQ.nGL = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
                if (this.nIQ.nGL == null) {
                    w.e("VideoCompressUI", "VideoSendPreprocessTask para is null");
                    this.nIQ.setResult(0);
                    this.nIQ.finish();
                    return;
                }
                e.post(this.nIQ.nIP, "video_remuxing_if_needed");
            }
        });
    }

    private String cR(String str, String str2) {
        Throwable e;
        if (!bg.mA(str2)) {
            return str2;
        }
        final String str3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
            str3 = CaptureMMProxy.getInstance().getAccVideoPath() + "video_send_preprocess_thumb_" + System.currentTimeMillis() + ".jpg";
            e.post(new Runnable(this) {
                final /* synthetic */ VideoCompressUI nIQ;

                public final void run() {
                    List<FileEntry> x = FileOp.x(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                    if (x != null) {
                        for (FileEntry fileEntry : x) {
                            if (!(bg.mA(fileEntry.name) || !fileEntry.name.contains("video_send_preprocess_thumb_") || str3.equals(fileEntry.name))) {
                                FileOp.deleteFile(fileEntry.name);
                            }
                        }
                    }
                }
            }, "delete_thumb_path");
            try {
                com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, str3, true);
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    w.printErrStackTrace("VideoCompressUI", e, "get thumb error e [%s] videoMediaItem [%s] ", new Object[]{e.getMessage(), this.nIO});
                    return str3;
                } finally {
                    mediaMetadataRetriever.release();
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            str3 = null;
            e = th;
            w.printErrStackTrace("VideoCompressUI", e, "get thumb error e [%s] videoMediaItem [%s] ", new Object[]{e.getMessage(), this.nIO});
            return str3;
        }
        return str3;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lvq != null) {
            this.lvq.release();
        }
    }
}
