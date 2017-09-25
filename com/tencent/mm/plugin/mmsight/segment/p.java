package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends a {
    private int nDX;
    private a nIL;
    private a nIM;

    public final void a(String str, String str2, VideoTransPara videoTransPara) {
        super.a(str, str2, videoTransPara);
    }

    public final int n(long j, long j2) {
        int aLN = i.aLN();
        g.oUh.a(440, 165, 1, false);
        if (aLN == 1) {
            g.oUh.a(440, 166, 1, false);
        } else if (aLN == 2) {
            g.oUh.a(440, 167, 1, false);
        } else if (aLN == 3) {
            g.oUh.a(440, 168, 1, false);
        }
        aLN = super.n(j, j2);
        if (aLN == -1) {
            int aLN2 = i.aLN();
            g.oUh.a(440, 169, 1, false);
            if (aLN2 == 1) {
                g.oUh.a(440, 170, 1, false);
            } else if (aLN2 == 2) {
                g.oUh.a(440, 171, 1, false);
            } else if (aLN2 == 3) {
                g.oUh.a(440, 172, 1, false);
            }
        }
        return aLN;
    }

    protected final int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        this.nIL = (a) list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.nIM = (a) list.get(0);
        }
        if (a(mediaExtractor, this.nGo <= 0 ? 1048576 : this.nGo, this.nDX, this.nGi) != -1) {
            return 0;
        }
        w.e("VideoClipperAPI18", "transcodeAndMux error");
        release();
        return -1;
    }

    private int a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        w.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(88) ");
        i iVar = null;
        try {
            i iVar2 = new i();
            try {
                int i3;
                iVar2.nGv = this.nGm;
                iVar2.nGw = this.nGn;
                VideoTransPara videoTransPara = this.nGq;
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "setVideoPara: %s", new Object[]{videoTransPara});
                iVar2.nGL = videoTransPara;
                if (this.nGr == 90 || this.nGr == 270) {
                    iVar2.cq(videoTransPara.height, videoTransPara.width);
                } else {
                    iVar2.cq(videoTransPara.width, videoTransPara.height);
                }
                iVar2.nGu = str;
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "setSrcVideoRotate: %s", new Object[]{Integer.valueOf(this.nGr)});
                iVar2.gPG = i3;
                w.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    w.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.nIL.index);
                    mediaExtractor.seekTo(this.nGm * 1000, 0);
                    try {
                        VideoTransPara videoTransPara2 = this.nGq;
                        this.nDX = MP4MuxerJNI.initDataBuf(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                        long NA = bg.NA();
                        i3 = this.nIL.index;
                        iVar2.nHd = mediaExtractor;
                        iVar2.nHe = i3;
                        if (iVar2.c(this.nIL.nFS) < 0) {
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.nDX);
                                mediaExtractor.release();
                                j.nEA.wl();
                            } catch (Exception e2) {
                            }
                            throw new m("init decoder error");
                        }
                        long NA2;
                        if (!bg.mA(iVar2.nGu)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(iVar2.nGu);
                            w.i("MicroMsg.MediaCodecFFMpegTranscoder", "src file: %s", new Object[]{simpleMp4Info});
                            if (!bg.mA(simpleMp4Info)) {
                                try {
                                    int i4 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (iVar2.nGL == null || iVar2.nGL.gPE <= 0) ? 30.0d : (double) iVar2.nGL.gPE;
                                    iVar2.nGy = (int) Math.ceil(((double) i4) / d);
                                    w.i("MicroMsg.MediaCodecFFMpegTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", new Object[]{Integer.valueOf(iVar2.nGy), Integer.valueOf(i4), Double.valueOf(d)});
                                } catch (Throwable e3) {
                                    w.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e3, "calcFrameDropCount error: %s", new Object[]{e3.getMessage()});
                                }
                            }
                        }
                        iVar2.nHf.pH(iVar2.nGy);
                        iVar2.nHf.B(new Runnable(iVar2) {
                            final /* synthetic */ i nHj;

                            {
                                this.nHj = r1;
                            }

                            public final void run() {
                                i iVar = this.nHj;
                                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", new Object[]{iVar.nHa, iVar.nHb});
                                if (iVar.nHa != null && iVar.nHb != null) {
                                    iVar.nHa.nHk = true;
                                    try {
                                        iVar.nHb.join();
                                        e.remove(iVar.nHa);
                                    } catch (Throwable e) {
                                        w.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e, "waitEncoderFinish, join error: %s", new Object[]{e.getMessage()});
                                    }
                                }
                            }
                        });
                        long aB = bg.aB(NA);
                        mediaExtractor.unselectTrack(this.nIL.index);
                        boolean z = false;
                        if (this.nIM != null) {
                            NA = bg.NA();
                            z = a(mediaExtractor, i, i2);
                            w.i("VideoClipperAPI18", "process audio used %sms, compressAudio: %s", new Object[]{Long.valueOf(bg.aB(NA)), Boolean.valueOf(z)});
                        }
                        long NA3 = bg.NA();
                        String aLB = aLB();
                        w.i("VideoClipperAPI18", "process video used %sms", new Object[]{Long.valueOf(aB)});
                        w.i("VideoClipperAPI18", "start muxing, tempPath: %s", new Object[]{aLB});
                        int aLN = i.aLN();
                        if (aLN == 1) {
                            g.oUh.a(440, 150, 1, false);
                            g.oUh.a(440, 151, aB, false);
                        } else if (aLN == 2) {
                            g.oUh.a(440, 155, 1, false);
                            g.oUh.a(440, 156, aB, false);
                        } else if (aLN == 3) {
                            g.oUh.a(440, 159, 1, false);
                            g.oUh.a(440, 160, aB, false);
                        }
                        int i5 = 1;
                        aLN = videoTransPara2.audioSampleRate;
                        int i6 = videoTransPara2.hzL;
                        if (!z) {
                            try {
                                i5 = this.nIM.nFS.getInteger("channel-count");
                                aLN = this.nIM.nFS.getInteger("sample-rate");
                                i6 = i5;
                                int i7 = aLN;
                                aLN = this.nIM.nFS.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                                i3 = i7;
                            } catch (Exception e4) {
                                w.e("VideoClipperAPI18", "get audio channel count error: %s", new Object[]{e4.getMessage()});
                            }
                            w.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(aLN)});
                            if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i6, aLB, (float) videoTransPara2.gPE, (int) (this.nGn - this.nGm), null, 0) >= 0) {
                                w.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i6, aLB, (float) videoTransPara2.gPE, (int) (this.nGn - this.nGm), null, 0))});
                                throw new m("muxingForX264 failed!");
                            }
                            if (this.nGr <= 0) {
                                SightVideoJNI.tagRotateVideo(aLB(), this.nGh, this.nGr);
                            } else {
                                FileOp.aj(aLB(), this.nGh);
                            }
                            w.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(bg.aB(NA3))});
                            NA2 = bg.NA();
                            SightVideoJNI.tagMP4Dscp(this.nGh, CaptureMMProxy.getInstance().getWeixinMeta());
                            w.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bg.aB(NA2))});
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.nDX);
                                mediaExtractor.release();
                                j.nEA.wl();
                            } catch (Exception e5) {
                            }
                            try {
                                iVar2.release();
                            } catch (Exception e6) {
                            }
                            return 0;
                        }
                        i3 = aLN;
                        aLN = i6;
                        i6 = i5;
                        w.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(aLN)});
                        if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i6, aLB, (float) videoTransPara2.gPE, (int) (this.nGn - this.nGm), null, 0) >= 0) {
                            if (this.nGr <= 0) {
                                FileOp.aj(aLB(), this.nGh);
                            } else {
                                SightVideoJNI.tagRotateVideo(aLB(), this.nGh, this.nGr);
                            }
                            w.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(bg.aB(NA3))});
                            NA2 = bg.NA();
                            SightVideoJNI.tagMP4Dscp(this.nGh, CaptureMMProxy.getInstance().getWeixinMeta());
                            w.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bg.aB(NA2))});
                            MP4MuxerJNI.releaseDataBuf(this.nDX);
                            mediaExtractor.release();
                            j.nEA.wl();
                            iVar2.release();
                            return 0;
                        }
                        w.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i6, aLB, (float) videoTransPara2.gPE, (int) (this.nGn - this.nGm), null, 0))});
                        throw new m("muxingForX264 failed!");
                    } catch (Throwable e32) {
                        w.w("VideoClipperAPI18", "The source video file is malformed %s", new Object[]{e32.getMessage()});
                        throw new RuntimeException(e32);
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.nDX);
                            mediaExtractor.release();
                            j.nEA.wl();
                        } catch (Exception e7) {
                        }
                    }
                } catch (Throwable e322) {
                    try {
                        w.printErrStackTrace("VideoClipperAPI18", e322, "Transcode and mux failed %s", new Object[]{e322.getMessage()});
                        return -1;
                    } finally {
                        try {
                            iVar2.release();
                        } catch (Exception e8) {
                        }
                    }
                }
            } catch (Exception e9) {
                e322 = e9;
                iVar = iVar2;
                w.printErrStackTrace("VideoClipperAPI18", e322, "trascodeAndMux error", new Object[0]);
                if (iVar != null) {
                    iVar.release();
                }
                return -1;
            }
        } catch (Exception e10) {
            e322 = e10;
            w.printErrStackTrace("VideoClipperAPI18", e322, "trascodeAndMux error", new Object[0]);
            if (iVar != null) {
                iVar.release();
            }
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.media.MediaExtractor r13, int r14, int r15) {
        /*
        r12 = this;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = 0;
        r10 = 1;
        r9 = 0;
        r0 = r12.nIM;
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r9;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r12.nIM;
        r0 = r0.index;
        r13.selectTrack(r0);
        r0 = r12.nGm;
        r0 = r0 * r6;
        r13.seekTo(r0, r9);
        r1 = java.nio.ByteBuffer.allocateDirect(r14);
        r0 = r12.nIM;	 Catch:{ Exception -> 0x00ec }
        r0 = r0.nFS;	 Catch:{ Exception -> 0x00ec }
        r2 = "channel-count";
        r0.getInteger(r2);	 Catch:{ Exception -> 0x00ec }
    L_0x0026:
        r0 = "VideoClipperAPI18";
        r2 = "audio channel count";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r2 = com.tencent.mm.storage.w.a.uFi;
        r3 = java.lang.Integer.valueOf(r9);
        r0 = r0.get(r2, r3);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != r10) goto L_0x0140;
    L_0x0045:
        r1 = new com.tencent.mm.plugin.mmsight.segment.h;
        r0 = r12.nIM;
        r3 = r0.nFS;
        r4 = r12.nGm;
        r6 = r12.nGn;
        r8 = r12.nGq;
        r2 = r13;
        r1.<init>(r2, r3, r4, r6, r8);
        r1.nGM = r10;
        r0 = r1.nzA;	 Catch:{ Exception -> 0x0100 }
        r0 = android.media.MediaCodec.createDecoderByType(r0);	 Catch:{ Exception -> 0x0100 }
        r1.nGH = r0;	 Catch:{ Exception -> 0x0100 }
        r0 = r1.nGH;	 Catch:{ Exception -> 0x0100 }
        r2 = r1.nGJ;	 Catch:{ Exception -> 0x0100 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0.configure(r2, r3, r4, r5);	 Catch:{ Exception -> 0x0100 }
        r0 = r1.nGH;	 Catch:{ Exception -> 0x0100 }
        r0.start();	 Catch:{ Exception -> 0x0100 }
        r0 = r1.nGH;	 Catch:{ Exception -> 0x0100 }
        r0 = r0.getOutputFormat();	 Catch:{ Exception -> 0x0100 }
        r1.nGJ = r0;	 Catch:{ Exception -> 0x0100 }
    L_0x0076:
        r0 = new android.media.MediaFormat;	 Catch:{ Exception -> 0x0114 }
        r0.<init>();	 Catch:{ Exception -> 0x0114 }
        r1.nGK = r0;	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGK;	 Catch:{ Exception -> 0x0114 }
        r2 = "mime";
        r3 = "audio/mp4a-latm";
        r0.setString(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGK;	 Catch:{ Exception -> 0x0114 }
        r2 = "aac-profile";
        r3 = 2;
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGK;	 Catch:{ Exception -> 0x0114 }
        r2 = "sample-rate";
        r3 = r1.nGL;	 Catch:{ Exception -> 0x0114 }
        r3 = r3.audioSampleRate;	 Catch:{ Exception -> 0x0114 }
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGK;	 Catch:{ Exception -> 0x0114 }
        r2 = "channel-count";
        r3 = 1;
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGK;	 Catch:{ Exception -> 0x0114 }
        r2 = "bitrate";
        r3 = r1.nGL;	 Catch:{ Exception -> 0x0114 }
        r3 = r3.hzL;	 Catch:{ Exception -> 0x0114 }
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGK;	 Catch:{ Exception -> 0x0114 }
        r2 = "max-input-size";
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nzA;	 Catch:{ Exception -> 0x0114 }
        r0 = android.media.MediaCodec.createEncoderByType(r0);	 Catch:{ Exception -> 0x0114 }
        r1.nGI = r0;	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGI;	 Catch:{ Exception -> 0x0114 }
        r2 = r1.nGK;	 Catch:{ Exception -> 0x0114 }
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0.configure(r2, r3, r4, r5);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.nGH;	 Catch:{ Exception -> 0x0114 }
        r0.start();	 Catch:{ Exception -> 0x0114 }
    L_0x00d3:
        r0 = "MicroMsg.MediaCodecAACTranscoder";
        r2 = "init finish, canEncodeDecodeBothExist: %s";
        r3 = new java.lang.Object[r10];
        r4 = r1.nGM;
        r4 = java.lang.Boolean.valueOf(r4);
        r3[r9] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);
        r1.aLK();
        r0 = r10;
        goto L_0x000a;
    L_0x00ec:
        r0 = move-exception;
        r0 = "VideoClipperAPI18";
        r2 = "get channel count error: %s";
        r3 = new java.lang.Object[r10];
        r4 = java.lang.Integer.valueOf(r10);
        r3[r9] = r4;
        com.tencent.mm.sdk.platformtools.w.e(r0, r2, r3);
        goto L_0x0026;
    L_0x0100:
        r0 = move-exception;
        r2 = "MicroMsg.MediaCodecAACTranscoder";
        r3 = "init decoder error: %s";
        r4 = new java.lang.Object[r10];
        r5 = r0.getMessage();
        r4[r9] = r5;
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);
        goto L_0x0076;
    L_0x0114:
        r0 = move-exception;
        r2 = "MicroMsg.MediaCodecAACTranscoder";
        r3 = "init encoder error: %s";
        r4 = new java.lang.Object[r10];
        r0 = r0.getMessage();
        r4[r9] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        r1.nGM = r9;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1.nGN = r0;
        r0 = r1.nGI;
        r0.release();
        r1.nGI = r11;
        goto L_0x00d3;
    L_0x0137:
        r1.position(r9);
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.writeAACData(r15, r1, r0);
        r13.advance();
    L_0x0140:
        r1.clear();
        r0 = r13.readSampleData(r1, r9);
        r2 = "VideoClipperAPI18";
        r3 = "sampleSize: %d";
        r4 = new java.lang.Object[r10];
        r5 = java.lang.Integer.valueOf(r0);
        r4[r9] = r5;
        com.tencent.mm.sdk.platformtools.w.d(r2, r3, r4);
        if (r0 > 0) goto L_0x016e;
    L_0x015a:
        r1 = "VideoClipperAPI18";
        r2 = "VideoClipperAPI18.muxAudio size = %d. Saw eos.";
        r3 = new java.lang.Object[r10];
        r0 = java.lang.Integer.valueOf(r0);
        r3[r9] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
    L_0x016b:
        r0 = r9;
        goto L_0x000a;
    L_0x016e:
        r2 = r13.getSampleTime();
        r4 = r12.nGn;
        r4 = r4 * r6;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x016b;
    L_0x0179:
        r2 = r13.getSampleTrackIndex();
        r3 = r12.nIM;
        r3 = r3.index;
        if (r2 == r3) goto L_0x0137;
    L_0x0183:
        r0 = "VideoClipperAPI18";
        r1 = "track index not match! break";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x016b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.p.a(android.media.MediaExtractor, int, int):boolean");
    }

    public final int AS(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                String extractMetadata;
                mediaMetadataRetriever.setDataSource(str);
                if (d.eo(17)) {
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    extractMetadata = SightVideoJNI.getMp4Rotate(str);
                }
                w.d("VideoClipperAPI18", "findRotationMessage sDegree = " + extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                w.d("VideoClipperAPI18", "findRotationMessage sHeight = " + extractMetadata2);
                w.d("VideoClipperAPI18", "findRotationMessage sWidth = " + extractMetadata3);
                int i = bg.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }
}
