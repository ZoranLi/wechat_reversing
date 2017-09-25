package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a implements g {
    private String kOx;
    String nGh;
    String nGi;
    private MediaExtractor nGj;
    private List<a> nGk = new ArrayList();
    private List<a> nGl = new ArrayList();
    long nGm;
    long nGn;
    int nGo = -1;
    private boolean nGp = false;
    VideoTransPara nGq;
    int nGr = -1;

    class a {
        int index;
        MediaFormat nFS;
        final /* synthetic */ a nGs;

        a(a aVar, MediaFormat mediaFormat, int i) {
            this.nGs = aVar;
            this.nFS = mediaFormat;
            this.index = i;
        }
    }

    public abstract int AS(String str);

    public void a(String str, String str2, VideoTransPara videoTransPara) {
        w.d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long NA = bg.NA();
        if (bg.mA(str) || bg.mA(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (FileOp.aO(str) && file.canRead() && file.length() != 0) {
            this.nGi = str;
            this.nGh = str2;
            this.nGq = videoTransPara;
            this.nGj = new MediaExtractor();
            this.nGj.setDataSource(str);
            a(this.nGj);
            if (this.nGk == null || this.nGk.size() == 0) {
                throw new o("Can not find video or audio track in this video file.");
            }
            this.nGo = aLC();
            this.nGr = AS(str);
            this.nGp = true;
            w.e("BaseMediaCodecClipper", "init cost time %dms", new Object[]{Long.valueOf(bg.aB(NA))});
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
    }

    private void a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !bg.mA(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                w.i("BaseMediaCodecClipper", "mime: %s", new Object[]{string});
                if (string.startsWith("audio/")) {
                    this.nGl.add(new a(this, trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.nGk.add(new a(this, trackFormat, i));
                }
            }
        }
        w.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[]{Integer.valueOf(this.nGl.size()), Integer.valueOf(this.nGk.size())});
    }

    public int n(long j, long j2) {
        if (this.nGp) {
            if (j < 0) {
                j = 0;
            }
            this.nGm = j;
            MediaFormat mediaFormat = ((a) this.nGk.get(0)).nFS;
            if (mediaFormat.containsKey("durationUs")) {
                if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
                    j2 = mediaFormat.getLong("durationUs") / 1000;
                }
                this.nGn = j2;
                return a(this.nGj, this.nGl, this.nGk);
            }
            throw new o("Can not find duration.");
        }
        w.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
        throw new IllegalStateException("Please init this component first.");
    }

    protected int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        return 0;
    }

    protected final String aLB() {
        if (this.kOx == null) {
            this.kOx = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4";
        }
        return this.kOx;
    }

    public final void release() {
        this.nGp = false;
        if (this.nGj != null) {
            this.nGj.release();
        }
    }

    private int aLC() {
        int i;
        int i2 = -1;
        if (!(this.nGl == null || this.nGl.size() == 0)) {
            i = -1;
            for (a aVar : this.nGl) {
                if (aVar.nFS.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.nFS.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            i2 = i;
        }
        if (this.nGk == null || this.nGk.size() == 0) {
            return i2;
        }
        i = i2;
        for (a aVar2 : this.nGk) {
            if (aVar2.nFS.containsKey("max-input-size")) {
                i2 = Math.max(aVar2.nFS.getInteger("max-input-size"), i);
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }
}
