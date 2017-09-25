package com.tencent.mm.plugin.s;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class h {
    private String nzA;
    long nzB;
    int nzC;
    private BufferInfo nzD = new BufferInfo();
    MediaExtractor nzE;
    private f nzF;
    protected MediaCodec nzG;
    private int nzH;
    private ByteBuffer[] nzI;
    private int nzJ;
    private ByteBuffer[] nzK;
    protected g nzu;
    protected ae nzv;
    private boolean nzw = false;
    public b nzx = null;
    protected long nzy = 0;
    MediaFormat nzz;
    protected String path;
    protected int state;

    abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo);

    abstract boolean a(MediaCodec mediaCodec);

    abstract String aKl();

    public h(g gVar, ae aeVar) {
        this.nzu = gVar;
        this.nzv = aeVar;
        this.state = 0;
        this.nzH = -1;
        this.nzJ = -1;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    private void aKv() {
        if (this.nzx != null) {
            this.nzy = this.nzx.aKm() * 1000;
        }
    }

    public final void aKw() {
        w.i("MicroMsg.TrackDataSource", "%s flush codec", aKs());
        this.nzJ = -1;
        this.nzH = -1;
        try {
            this.nzG.flush();
        } catch (Exception e) {
        }
    }

    public void release() {
        w.i("MicroMsg.TrackDataSource", "%s release", aKs());
        if (this.nzE != null) {
            this.nzE.release();
            this.nzE = null;
        }
        if (this.nzG != null) {
            this.nzG.release();
            this.nzG = null;
        }
        if (this.nzF != null) {
            f fVar = this.nzF;
            if (fVar.nza != null) {
                try {
                    fVar.nza.close();
                } catch (IOException e) {
                }
            }
            fVar.ime.clear();
            fVar.ime = null;
            fVar.imf.clear();
            fVar.imf = null;
            fVar.nzb = null;
        }
        w.i("MicroMsg.TrackDataSource", "%s finish release", aKs());
    }

    protected final void aKx() {
        if (this.nzG != null) {
            w.i("MicroMsg.TrackDataSource", "%s release decoder", aKs());
            aKw();
            this.nzK = null;
            this.nzI = null;
            try {
                this.nzG.stop();
                try {
                    this.nzG.release();
                    w.i("MicroMsg.TrackDataSource", "%s finish release decoder", aKs());
                } finally {
                    this.nzG = null;
                }
            } catch (Exception e) {
                this.nzG.release();
            } catch (Throwable th) {
            } finally {
                this.nzG = null;
            }
        }
    }

    protected final boolean aKy() {
        try {
            w.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", aKs(), this.nzA);
            this.nzG = MediaCodec.createDecoderByType(this.nzA);
            a(this.nzG);
            this.nzG.start();
            this.nzI = this.nzG.getInputBuffers();
            this.nzK = this.nzG.getOutputBuffers();
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s prepare decoder init decoder error ", aKs());
            this.nzu.AL(aKl());
            return false;
        }
    }

    public final void start() {
        w.i("MicroMsg.TrackDataSource", "%s start to play", aKs());
        setState(3);
        onStart();
    }

    public final void pause() {
        w.i("MicroMsg.TrackDataSource", "%s start to pause", aKs());
        setState(4);
        onPause();
    }

    public final long pt(int i) {
        w.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", aKs(), Integer.valueOf(i), Boolean.valueOf(this.nzw));
        aKw();
        this.nzw = false;
        if (this.nzF != null) {
            try {
                f fVar = this.nzF;
                long j = (long) (i * 1000);
                int i2 = 0;
                while (i2 < fVar.imf.size()) {
                    Pair pair = (Pair) fVar.imf.get(i2);
                    if (j < ((Long) pair.second).longValue()) {
                        break;
                    } else if (j == ((Long) pair.second).longValue()) {
                        fVar.nzc = ((Integer) pair.first).intValue();
                        fVar.nzb = (g) fVar.ime.get(fVar.nzc);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0 || i2 == fVar.imf.size() - 1) {
                    fVar.nzc = ((Integer) ((Pair) fVar.imf.get(i2)).first).intValue();
                    fVar.nzb = (g) fVar.ime.get(fVar.nzc);
                    if (this.nzF.nzb.img < 0) {
                        m((long) (i * 1000), -1);
                    }
                    if (this.nzF.nzb.img < 0) {
                        m(0, -1);
                        this.nzu.aKt();
                    }
                    w.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", aKs(), Long.valueOf(this.nzF.nzb.img));
                    return this.nzF.nzb.img / 1000;
                }
                fVar.nzc = ((Integer) ((Pair) fVar.imf.get(i2 - 1)).first).intValue();
                fVar.nzb = (g) fVar.ime.get(fVar.nzc);
                if (this.nzF.nzb.img < 0) {
                    m((long) (i * 1000), -1);
                }
                if (this.nzF.nzb.img < 0) {
                    m(0, -1);
                    this.nzu.aKt();
                }
                w.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", aKs(), Long.valueOf(this.nzF.nzb.img));
                return this.nzF.nzb.img / 1000;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s extractor seek exception %s", aKs(), e.toString());
                return 0;
            }
        }
        try {
            this.nzE.seekTo((long) (i * 1000), 0);
            if (this.nzE.getSampleTime() < 0) {
                m((long) (i * 1000), -1);
            }
            if (this.nzE.getSampleTime() < 0) {
                m(0, -1);
                this.nzu.aKt();
            }
            w.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", aKs(), Long.valueOf(this.nzE.getSampleTime()), Long.valueOf(this.nzE.getCachedDuration()));
            return this.nzE.getSampleTime() / 1000;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s extractor seek exception %s", aKs(), e2.toString());
            return 0;
        }
    }

    public final boolean aKz() {
        w.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", aKs(), this.path);
        try {
            w.i("MicroMsg.TrackDataSource", "%s start to init extractor", aKs());
            this.nzE = new MediaExtractor();
            this.nzE.setDataSource(this.path);
            int trackCount = this.nzE.getTrackCount();
            this.nzC = -1;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.nzE.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.contains(aKl())) {
                    a(trackFormat, string, i);
                    break;
                }
            }
            if (this.nzC < 0) {
                w.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", aKs(), Integer.valueOf(trackCount), Integer.valueOf(this.nzC));
                this.nzu.AK("can not find ");
                return false;
            }
            this.nzE.selectTrack(this.nzC);
            this.nzF = null;
            try {
                w.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", aKs(), this.nzA, Integer.valueOf(this.state));
                if (!d.pp(this.state)) {
                    this.nzG = MediaCodec.createDecoderByType(this.nzA);
                    a(this.nzG);
                    this.nzG.start();
                    this.nzI = this.nzG.getInputBuffers();
                    this.nzK = this.nzG.getOutputBuffers();
                }
                setState(1);
                w.i("MicroMsg.TrackDataSource", "%s finish to prepare", aKs());
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", aKs(), e.toString());
                this.nzu.AL(aKl());
                return false;
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init extractor error", aKs());
            this.nzu.AK(e2.toString());
            return false;
        } catch (Throwable e22) {
            w.e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", aKs(), e22.toString());
            this.nzu.AK(e22.toString());
            return false;
        }
    }

    protected final int l(long j, long j2) {
        g gVar;
        String aKl;
        w.d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", aKs(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.state));
        if (this.nzG != null) {
            ByteBuffer byteBuffer;
            Object obj;
            do {
                try {
                    w.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", aKs(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.nzJ));
                    if (this.nzJ < 0) {
                        this.nzJ = this.nzG.dequeueOutputBuffer(this.nzD, 0);
                        if (this.nzJ >= 0) {
                            if ((this.nzD.flags & 4) != 0) {
                                w.i("MicroMsg.TrackDataSource", "%s process end of stream", aKs());
                                setState(9);
                                this.nzJ = -1;
                            } else {
                                byteBuffer = this.nzK[this.nzJ];
                                if (byteBuffer != null) {
                                    byteBuffer.position(this.nzD.offset);
                                    byteBuffer.limit(this.nzD.offset + this.nzD.size);
                                }
                            }
                        } else if (this.nzJ == -2) {
                            this.nzz = this.nzG.getOutputFormat();
                            b(this.nzG);
                            obj = 1;
                            continue;
                        } else if (this.nzJ == -3) {
                            this.nzK = this.nzG.getOutputBuffers();
                            obj = 1;
                            continue;
                        } else {
                            w.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", aKs(), Integer.valueOf(this.nzJ));
                        }
                        obj = null;
                        continue;
                    }
                    if ((this.state == 1 ? 1 : null) != null) {
                        setState(2);
                    }
                    w.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", aKs(), Integer.valueOf(this.nzJ));
                    if (a(j, j2, this.nzG, this.nzK[this.nzJ], this.nzJ, this.nzD)) {
                        this.nzJ = -1;
                        obj = 1;
                        continue;
                    }
                    obj = null;
                    continue;
                } catch (Exception e) {
                    w.e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", aKs(), e.toString());
                    aKw();
                    gVar = this.nzu;
                    aKl = aKl();
                    if (!gVar.nzr && gVar.nzm) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(354, 158, 1, false);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13836, Integer.valueOf(506), Long.valueOf(bg.Ny()), aKl);
                        gVar.nzr = true;
                    }
                }
            } while (obj != null);
            try {
                w.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", aKs(), Integer.valueOf(this.nzH), Integer.valueOf(this.state), Boolean.valueOf(this.nzw));
                if (d.pp(this.state) || this.nzw) {
                    w.i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", aKs());
                } else {
                    if (this.nzH < 0) {
                        this.nzH = this.nzG.dequeueInputBuffer(0);
                        if (this.nzH < 0) {
                            w.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", aKs());
                        }
                    }
                    byteBuffer = this.nzI[this.nzH];
                    int n;
                    long j3;
                    int i;
                    if (this.nzF != null) {
                        n = this.nzF.n(byteBuffer);
                        j3 = this.nzF.nzb.img;
                        i = this.nzF.nzb.imh;
                        w.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", aKs(), Integer.valueOf(this.nzH), Integer.valueOf(n), Long.valueOf(j3), Integer.valueOf(i));
                        if (n <= 0) {
                            this.nzG.queueInputBuffer(this.nzH, 0, 0, 0, 4);
                            this.nzw = true;
                        } else {
                            this.nzG.queueInputBuffer(this.nzH, 0, n, j3, 0);
                            this.nzH = -1;
                            f fVar = this.nzF;
                            fVar.nzc++;
                            if (fVar.nzc < fVar.nzd) {
                                fVar.nzb = (g) fVar.ime.get(fVar.nzc);
                                w.d("MicroMsg.Mp4Extractor", "curr sample [%s]", fVar.nzb);
                            }
                        }
                    } else if (this.nzu.nzp) {
                        this.nzG.queueInputBuffer(this.nzH, 0, 0, this.nzB * 1000, 4);
                        this.nzw = true;
                        this.nzu.nzp = false;
                    } else {
                        n = this.nzE.readSampleData(byteBuffer, 0);
                        j3 = this.nzE.getSampleTime();
                        w.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", aKs(), Integer.valueOf(this.nzH), Integer.valueOf(n), Long.valueOf(j3), Integer.valueOf(this.nzE.getSampleFlags()));
                        y(i, j3);
                        if (n <= 0) {
                            this.nzG.queueInputBuffer(this.nzH, 0, 0, this.nzB * 1000, 4);
                            this.nzw = true;
                        } else {
                            this.nzG.queueInputBuffer(this.nzH, 0, n, j3, 0);
                            this.nzH = -1;
                            this.nzE.advance();
                            long sampleTime = this.nzE.getSampleTime();
                            if (this.nzu.nzo) {
                                if (this.nzy == 0) {
                                    if (m(j3, sampleTime)) {
                                        w.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", aKs(), Long.valueOf(sampleTime), Long.valueOf(this.nzy));
                                        if (Math.abs(this.nzE.getSampleTime() - j3) >= 3000000) {
                                            w.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", aKs(), Long.valueOf(this.nzE.getSampleTime()), Long.valueOf(j3));
                                            this.nzv.obtainMessage(5, -2, -2).sendToTarget();
                                        }
                                        aKv();
                                    }
                                } else if (sampleTime < 0 || (sampleTime / 1000) + 1200 > this.nzy) {
                                    w.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", aKs(), Long.valueOf(sampleTime), Long.valueOf(this.nzy));
                                    if (m(j3, -1)) {
                                        this.nzv.obtainMessage(5, -3, -3).sendToTarget();
                                    }
                                    aKv();
                                }
                            } else if (m(j3, sampleTime)) {
                                w.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", aKs(), Boolean.valueOf(this.nzu.nzo), Long.valueOf(sampleTime), Long.valueOf(this.nzy));
                                if (Math.abs(this.nzE.getSampleTime() - j3) >= 1000000) {
                                    w.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", aKs(), Long.valueOf(this.nzE.getSampleTime()), Long.valueOf(j3));
                                    this.nzu.nzp = true;
                                }
                            }
                            w.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", aKs(), Long.valueOf(j3), Long.valueOf(sampleTime));
                        }
                    }
                }
            } catch (Exception e2) {
                w.e("MicroMsg.TrackDataSource", "%s do some work feed input buffer error %s", aKs(), e2.toString());
                aKw();
                gVar = this.nzu;
                aKl = aKl();
                if (!gVar.nzq && gVar.nzm) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(354, 157, 1, false);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13836, Integer.valueOf(505), Long.valueOf(bg.Ny()), aKl);
                    gVar.nzq = true;
                }
            }
        }
        w.d("MicroMsg.TrackDataSource", "%s finish to do some work. state %d", aKs(), Integer.valueOf(this.state));
        return this.state;
    }

    protected final boolean m(long j, long j2) {
        long NA = bg.NA();
        try {
            if ((j / 1000) + 1000 < this.nzB && j2 == -1) {
                this.nzu.nzn = true;
                this.nzw = false;
                this.nzE.release();
                this.nzE = new MediaExtractor();
                this.nzE.setDataSource(this.path);
                this.nzE.selectTrack(this.nzC);
                this.nzE.seekTo(j, 2);
                long sampleTime = this.nzE.getSampleTime();
                w.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", aKs(), Long.valueOf(j), Long.valueOf(sampleTime), Long.valueOf(j2), Long.valueOf(this.nzy), Long.valueOf(bg.aB(NA)));
                return true;
            }
        } catch (Exception e) {
            w.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", aKs(), e.toString());
        }
        return false;
    }

    protected boolean y(int i, long j) {
        return false;
    }

    protected void a(MediaFormat mediaFormat, String str, int i) {
        w.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", aKs(), str, Integer.valueOf(i));
        this.nzC = i;
        this.nzA = str;
        this.nzB = mediaFormat.getLong("durationUs") / 1000;
        this.nzz = mediaFormat;
    }

    protected void b(MediaCodec mediaCodec) {
    }

    protected void onStart() {
    }

    protected void onPause() {
    }

    protected final void setState(int i) {
        w.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", aKs(), Integer.valueOf(this.state), Integer.valueOf(i));
        this.state = i;
    }

    public final String aKs() {
        return aKl() + "_" + this.nzu.aKs();
    }
}
