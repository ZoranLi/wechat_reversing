package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class PCMDataCut {
    private static final String TAG = "PCMDataCut";
    private AudioCut mAudioCut = null;
    private BaseDecoder mDecoder = null;
    private String mFileName = null;

    private static class AudioCut {
        AudioType audioType;
        int bufferSize;
        AudioInformation information;
        int sampleBit = 0;
    }

    public PCMDataCut(String str) {
        this.mFileName = str;
        prepareDecoder();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean cutPCMData(java.lang.String r21, int r22, int r23, int r24, boolean r25) {
        /*
        r20 = this;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r5 = r20.initDecoder();	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        if (r5 == 0) goto L_0x000e;
    L_0x0009:
        r5 = 0;
        r5 = r20.getAudioFormation();	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
    L_0x000e:
        if (r5 == 0) goto L_0x0015;
    L_0x0010:
        r5 = 0;
        r5 = r20.calculateBufferSize();	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
    L_0x0015:
        r0 = r20;
        r2 = r0.mAudioCut;	 Catch:{ Exception -> 0x02fe, all -> 0x02ba }
        r2 = r2.information;	 Catch:{ Exception -> 0x02fe, all -> 0x02ba }
        if (r2 == 0) goto L_0x002d;
    L_0x001d:
        r0 = r20;
        r2 = r0.mAudioCut;	 Catch:{ Exception -> 0x02fe, all -> 0x02ba }
        r2 = r2.information;	 Catch:{ Exception -> 0x02fe, all -> 0x02ba }
        r6 = r2.getDuration();	 Catch:{ Exception -> 0x02fe, all -> 0x02ba }
        r8 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x0040;
    L_0x002d:
        r2 = "PCMDataCut";
        r6 = "cutPCMData 歌曲时长小于30S，不适用音频指纹";
        com.tencent.qqmusic.mediaplayer.util.Logger.d(r2, r6);	 Catch:{ Exception -> 0x02fe, all -> 0x02ba }
        r2 = "MatchManager.Finger";
        r6 = "[cutPCMData] too short";
        com.tencent.qqmusic.mediaplayer.util.Logger.i(r2, r6);	 Catch:{ Exception -> 0x02fe, all -> 0x02ba }
        r5 = 0;
    L_0x0040:
        r0 = r22;
        r10 = r0 * 1000;
        r0 = r23;
        r11 = r0 * 1000;
        if (r5 == 0) goto L_0x0317;
    L_0x004a:
        r2 = r11 - r10;
        r2 = r2 / 1000;
        r6 = (long) r2;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r0 = r20;
        r2 = r0.mAudioCut;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r2 = r2.information;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r8 = r2.getSampleRate();	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r6 = r6 * r8;
        r0 = r20;
        r2 = r0.mAudioCut;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r2 = r2.information;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r2 = r2.getChannels();	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r8 = (long) r2;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r6 = r6 * r8;
        r7 = (int) r6;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r0 = r20;
        r2 = r0.mAudioCut;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r2 = r2.bufferSize;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r12 = new short[r2];	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r0 = r20;
        r2 = r0.mDecoder;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r2 = r2 instanceof com.tencent.qqmusic.mediaplayer.codec.ape.ApeDecoder;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        if (r2 == 0) goto L_0x00f9;
    L_0x0077:
        r0 = r20;
        r2 = r0.mDecoder;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r2 = (com.tencent.qqmusic.mediaplayer.codec.ape.ApeDecoder) r2;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r6 = r10 / 1000;
        r2.nSeekToExactly(r6);	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
    L_0x0082:
        r6 = 0;
        r8 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r0 = r21;
        r2.<init>(r0);	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r3 = new com.tencent.qqmusic.mediaplayer.WaveWriter;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r0 = r20;
        r9 = r0.mAudioCut;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r9 = r9.information;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r14 = r9.getSampleRate();	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r9 = (int) r14;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r0 = r20;
        r13 = r0.mAudioCut;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r13 = r13.information;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r13 = r13.getChannels();	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r0 = r20;
        r14 = r0.mAudioCut;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r14 = r14.sampleBit;	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r3.<init>(r2, r9, r13, r14);	 Catch:{ Exception -> 0x0306, all -> 0x02e8 }
        r3.createWaveFile();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = -1;
        r9 = r6;
        r6 = r7;
        r7 = r4;
    L_0x00b2:
        if (r9 > r6) goto L_0x0276;
    L_0x00b4:
        r0 = r20;
        r4 = r0.mDecoder;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r14 = r4.getCurrentTime();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r11 + 2000;
        r0 = (long) r4;
        r16 = r0;
        r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r4 >= 0) goto L_0x0276;
    L_0x00c5:
        r0 = r20;
        r4 = r0.mDecoder;	 Catch:{ UnsatisfiedLinkError -> 0x0217 }
        r0 = r20;
        r13 = r0.mAudioCut;	 Catch:{ UnsatisfiedLinkError -> 0x0217 }
        r13 = r13.bufferSize;	 Catch:{ UnsatisfiedLinkError -> 0x0217 }
        r13 = r13 * 2;
        r4 = r4.decodeData(r13, r12);	 Catch:{ UnsatisfiedLinkError -> 0x0217 }
        if (r4 > 0) goto L_0x0142;
    L_0x00d7:
        r0 = r20;
        r4 = r0.mDecoder;
        if (r4 == 0) goto L_0x00e9;
    L_0x00dd:
        r0 = r20;
        r4 = r0.mDecoder;
        r4.release();
        r4 = 0;
        r0 = r20;
        r0.mDecoder = r4;
    L_0x00e9:
        r3.closeWaveFile();	 Catch:{ IOException -> 0x013a }
        if (r5 != 0) goto L_0x00f7;
    L_0x00ee:
        r3 = r2.exists();	 Catch:{ IOException -> 0x013a }
        if (r3 == 0) goto L_0x00f7;
    L_0x00f4:
        r2.delete();	 Catch:{ IOException -> 0x013a }
    L_0x00f7:
        r4 = 0;
    L_0x00f8:
        return r4;
    L_0x00f9:
        r0 = r20;
        r2 = r0.mDecoder;	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        r2.seekTo(r10);	 Catch:{ Exception -> 0x0101, all -> 0x02ba }
        goto L_0x0082;
    L_0x0101:
        r2 = move-exception;
        r18 = r4;
        r4 = r5;
        r5 = r18;
    L_0x0107:
        r6 = "PCMDataCut";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r6, r2);	 Catch:{ all -> 0x02f7 }
        r4 = 0;
        r0 = r20;
        r2 = r0.mDecoder;
        if (r2 == 0) goto L_0x0120;
    L_0x0114:
        r0 = r20;
        r2 = r0.mDecoder;
        r2.release();
        r2 = 0;
        r0 = r20;
        r0.mDecoder = r2;
    L_0x0120:
        if (r5 == 0) goto L_0x0125;
    L_0x0122:
        r5.closeWaveFile();	 Catch:{ IOException -> 0x0131 }
    L_0x0125:
        if (r3 == 0) goto L_0x00f8;
    L_0x0127:
        r2 = r3.exists();	 Catch:{ IOException -> 0x0131 }
        if (r2 == 0) goto L_0x00f8;
    L_0x012d:
        r3.delete();	 Catch:{ IOException -> 0x0131 }
        goto L_0x00f8;
    L_0x0131:
        r2 = move-exception;
        r4 = 0;
        r3 = "PCMDataCut";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r3, r2);
        goto L_0x00f8;
    L_0x013a:
        r2 = move-exception;
        r3 = "PCMDataCut";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r3, r2);
        goto L_0x00f7;
    L_0x0142:
        r8 = r4;
    L_0x0143:
        r0 = r20;
        r4 = r0.mDecoder;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r14 = r4.getCurrentTime();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r10 + r11;
        r4 = r4 / 2;
        r0 = (long) r4;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r16 = r0;
        r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r4 <= 0) goto L_0x0313;
    L_0x0156:
        r4 = -1;
        if (r7 != r4) goto L_0x0313;
    L_0x0159:
        r0 = r20;
        r4 = r0.mDecoder;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r4.getCurrentTime();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r14 = (long) r10;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6 - r14;
        r4 = (float) r6;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r4 = r4 / r6;
        r6 = "PCMDataCut";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r13 = "speedtime=";
        r7.<init>(r13);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.append(r4);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r13 = ",size=";
        r7 = r7.append(r13);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.append(r9);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        com.tencent.qqmusic.mediaplayer.util.Logger.d(r6, r7);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = (float) r9;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6 * r7;
        r0 = r20;
        r7 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.information;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r14 = r7.getSampleRate();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = (float) r14;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4 * r7;
        r0 = r20;
        r7 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.information;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.getChannels();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = (float) r7;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4 * r7;
        r4 = r6 / r4;
        r0 = r20;
        r6 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = java.lang.Math.round(r4);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4 * 8;
        r6.sampleBit = r4;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = "PCMDataCut";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = "sampleBit=";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r0 = r20;
        r7 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.sampleBit;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        com.tencent.qqmusic.mediaplayer.util.Logger.d(r4, r6);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r0 = r20;
        r4 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4.sampleBit;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = 8;
        if (r4 >= r6) goto L_0x0232;
    L_0x01d8:
        r4 = "PCMDataCut";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = "sampleBit=";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r0 = r20;
        r7 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r7 = r7.sampleBit;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r4, r6);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r0 = r20;
        r4 = r0.mDecoder;
        if (r4 == 0) goto L_0x0206;
    L_0x01fa:
        r0 = r20;
        r4 = r0.mDecoder;
        r4.release();
        r4 = 0;
        r0 = r20;
        r0.mDecoder = r4;
    L_0x0206:
        r3.closeWaveFile();	 Catch:{ IOException -> 0x022a }
        if (r5 != 0) goto L_0x0214;
    L_0x020b:
        r3 = r2.exists();	 Catch:{ IOException -> 0x022a }
        if (r3 == 0) goto L_0x0214;
    L_0x0211:
        r2.delete();	 Catch:{ IOException -> 0x022a }
    L_0x0214:
        r4 = 0;
        goto L_0x00f8;
    L_0x0217:
        r4 = move-exception;
        r13 = "PCMDataCut";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r13, r4);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        goto L_0x0143;
    L_0x0220:
        r4 = move-exception;
        r18 = r4;
        r4 = r5;
        r5 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x0107;
    L_0x022a:
        r2 = move-exception;
        r3 = "PCMDataCut";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r3, r2);
        goto L_0x0214;
    L_0x0232:
        r4 = r11 - r10;
        r4 = r4 / 1000;
        r6 = (long) r4;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r0 = r20;
        r4 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4.information;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r14 = r4.getSampleRate();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6 * r14;
        r0 = r20;
        r4 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4.information;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4.getChannels();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r14 = (long) r4;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6 * r14;
        r0 = r20;
        r4 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r4 = r4.sampleBit;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r14 = (long) r4;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6 * r14;
        r14 = 16;
        r6 = r6 / r14;
        r4 = (int) r6;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r0 = r20;
        r6 = r0.mAudioCut;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r6.sampleBit;	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r3.setSampleByte(r6);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r6 = r4;
    L_0x0264:
        r7 = r8 / 2;
        r7 = r7 + r9;
        r9 = r8 / 2;
        r13 = -1;
        if (r6 == r13) goto L_0x02ac;
    L_0x026c:
        if (r7 < r6) goto L_0x02ac;
    L_0x026e:
        r4 = 0;
        r6 = r7 - r6;
        r6 = r9 - r6;
        r3.write(r12, r4, r6);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
    L_0x0276:
        if (r25 == 0) goto L_0x02b5;
    L_0x0278:
        r4 = r3.reSamplerTo8K();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
    L_0x027c:
        r0 = r20;
        r5 = r0.mDecoder;
        if (r5 == 0) goto L_0x028e;
    L_0x0282:
        r0 = r20;
        r5 = r0.mDecoder;
        r5.release();
        r5 = 0;
        r0 = r20;
        r0.mDecoder = r5;
    L_0x028e:
        if (r3 == 0) goto L_0x0293;
    L_0x0290:
        r3.closeWaveFile();	 Catch:{ IOException -> 0x02a2 }
    L_0x0293:
        if (r4 != 0) goto L_0x00f8;
    L_0x0295:
        if (r2 == 0) goto L_0x00f8;
    L_0x0297:
        r3 = r2.exists();	 Catch:{ IOException -> 0x02a2 }
        if (r3 == 0) goto L_0x00f8;
    L_0x029d:
        r2.delete();	 Catch:{ IOException -> 0x02a2 }
        goto L_0x00f8;
    L_0x02a2:
        r2 = move-exception;
        r4 = 0;
        r3 = "PCMDataCut";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r3, r2);
        goto L_0x00f8;
    L_0x02ac:
        r13 = 0;
        r3.write(r12, r13, r9);	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        r9 = r7;
        r7 = r6;
        r6 = r4;
        goto L_0x00b2;
    L_0x02b5:
        r4 = r3.reSampler();	 Catch:{ Exception -> 0x0220, all -> 0x02ef }
        goto L_0x027c;
    L_0x02ba:
        r2 = move-exception;
    L_0x02bb:
        r0 = r20;
        r6 = r0.mDecoder;
        if (r6 == 0) goto L_0x02cd;
    L_0x02c1:
        r0 = r20;
        r6 = r0.mDecoder;
        r6.release();
        r6 = 0;
        r0 = r20;
        r0.mDecoder = r6;
    L_0x02cd:
        if (r4 == 0) goto L_0x02d2;
    L_0x02cf:
        r4.closeWaveFile();	 Catch:{ IOException -> 0x02e0 }
    L_0x02d2:
        if (r5 != 0) goto L_0x02df;
    L_0x02d4:
        if (r3 == 0) goto L_0x02df;
    L_0x02d6:
        r4 = r3.exists();	 Catch:{ IOException -> 0x02e0 }
        if (r4 == 0) goto L_0x02df;
    L_0x02dc:
        r3.delete();	 Catch:{ IOException -> 0x02e0 }
    L_0x02df:
        throw r2;
    L_0x02e0:
        r3 = move-exception;
        r4 = "PCMDataCut";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r4, r3);
        goto L_0x02df;
    L_0x02e8:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x02bb;
    L_0x02ef:
        r4 = move-exception;
        r18 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x02bb;
    L_0x02f7:
        r2 = move-exception;
        r18 = r5;
        r5 = r4;
        r4 = r18;
        goto L_0x02bb;
    L_0x02fe:
        r2 = move-exception;
        r18 = r4;
        r4 = r5;
        r5 = r18;
        goto L_0x0107;
    L_0x0306:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        r19 = r4;
        r4 = r5;
        r5 = r19;
        goto L_0x0107;
    L_0x0313:
        r4 = r6;
        r6 = r7;
        goto L_0x0264;
    L_0x0317:
        r2 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x027c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.PCMDataCut.cutPCMData(java.lang.String, int, int, int, boolean):boolean");
    }

    private boolean initDecoder() {
        if (this.mDecoder == null) {
            return false;
        }
        try {
            int init = this.mDecoder.init(this.mFileName, false);
            Logger.i(TAG, "nativeOpen return=" + init);
            if (init != 0) {
                init = this.mDecoder.init(this.mFileName, false);
            }
            if (init == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Logger.e(TAG, e);
            return false;
        }
    }

    private boolean getAudioFormation() {
        if (this.mDecoder != null) {
            try {
                this.mAudioCut.information = this.mDecoder.getAudioInformation();
            } catch (Throwable e) {
                Logger.e(TAG, e);
            }
        }
        if (this.mAudioCut.information != null) {
            return true;
        }
        return false;
    }

    private boolean calculateBufferSize() {
        if (this.mDecoder == null) {
            return false;
        }
        int i;
        int minBufferSize = AudioTrack.getMinBufferSize((int) this.mAudioCut.information.getSampleRate(), this.mAudioCut.information.getChannels() == 1 ? 4 : 12, 2);
        try {
            if (this.mDecoder instanceof FLACDecoder) {
                i = ((FLACDecoder) this.mDecoder).getminBufferSize();
                Logger.i(TAG, "decoder_buf_size = " + i + ", playback_buf_size = " + minBufferSize);
                if (AudioType.FLAC.equals(this.mAudioCut.audioType)) {
                    this.mAudioCut.bufferSize = minBufferSize;
                } else {
                    this.mAudioCut.bufferSize = i;
                }
                if (this.mDecoder instanceof FfmpegPlayer) {
                    this.mAudioCut.bufferSize = Math.max(Downloads.RECV_BUFFER_SIZE, minBufferSize);
                }
                return true;
            }
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
        i = 0;
        Logger.i(TAG, "decoder_buf_size = " + i + ", playback_buf_size = " + minBufferSize);
        if (AudioType.FLAC.equals(this.mAudioCut.audioType)) {
            this.mAudioCut.bufferSize = minBufferSize;
        } else {
            this.mAudioCut.bufferSize = i;
        }
        if (this.mDecoder instanceof FfmpegPlayer) {
            this.mAudioCut.bufferSize = Math.max(Downloads.RECV_BUFFER_SIZE, minBufferSize);
        }
        return true;
    }

    private void prepareDecoder() {
        if (this.mFileName == null) {
            throw new NullPointerException("the path is null!");
        }
        this.mAudioCut = new AudioCut();
        try {
            this.mAudioCut.audioType = AudioRecognition.recognitionAudioFormatExactly(this.mFileName);
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
        this.mDecoder = MediaCodecFactory.createDecoderByType(this.mAudioCut.audioType);
    }
}
