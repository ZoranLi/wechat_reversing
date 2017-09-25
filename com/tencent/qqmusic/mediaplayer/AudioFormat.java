package com.tencent.qqmusic.mediaplayer;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class AudioFormat {
    private static final String EXTENSION_AAC = "aac";
    private static final String EXTENSION_AMR = "amr";
    private static final String EXTENSION_APE = "ape";
    private static final String EXTENSION_FLAC = "flac";
    private static final String EXTENSION_M4A = "m4a";
    private static final String EXTENSION_MP3 = "mp3";
    private static final String EXTENSION_MP4 = "mp4";
    private static final String EXTENSION_OGG = "ogg";
    private static final String EXTENSION_WAV = "wav";
    private static final String EXTENSION_WMA = "wma";
    private static final int VALUE_AAC = 11;
    private static final int VALUE_AMR = 6;
    private static final int VALUE_APE = 5;
    private static final int VALUE_FLAC = 2;
    private static final int VALUE_M4A = 3;
    private static final int VALUE_MP3 = 9;
    private static final int VALUE_MP4 = 10;
    private static final int VALUE_OGG = 4;
    private static final int VALUE_UNSUPPORT = 1;
    private static final int VALUE_WAV = 8;
    private static final int VALUE_WMA = 7;

    public enum AudioType {
        UNSUPPORT(1, "Unknown"),
        MP3(9, AudioFormat.EXTENSION_MP3),
        OGG(4, AudioFormat.EXTENSION_OGG),
        M4A(3, AudioFormat.EXTENSION_M4A),
        FLAC(2, AudioFormat.EXTENSION_FLAC),
        APE(5, AudioFormat.EXTENSION_APE),
        WAV(8, AudioFormat.EXTENSION_WAV),
        WMA(7, AudioFormat.EXTENSION_WMA),
        AMR(6, AudioFormat.EXTENSION_AMR),
        MP4(10, AudioFormat.EXTENSION_MP4),
        AAC(11, AudioFormat.EXTENSION_AAC);
        
        private String extension;
        private int value;

        private AudioType(int i, String str) {
            this.value = 0;
            this.value = i;
            this.extension = str;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static boolean isAudioType(AudioType audioType) {
        return (audioType == null || AudioType.UNSUPPORT.equals(audioType)) ? false : true;
    }

    public static AudioType getAudioTypeFromExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (AudioType audioType : AudioType.values()) {
            if (audioType.extension.equalsIgnoreCase(str)) {
                return audioType;
            }
        }
        return AudioType.UNSUPPORT;
    }

    public static AudioType getAudioType(int i) {
        for (AudioType audioType : AudioType.values()) {
            if (audioType.value == i) {
                return audioType;
            }
        }
        return AudioType.UNSUPPORT;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType getAudioType(java.lang.String r3) {
        /*
        r1 = 0;
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector.sIsLoadSuccess;
        if (r0 == 0) goto L_0x0032;
    L_0x000c:
        r0 = com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector.getAudioFormat(r3);
        r2 = isAudioType(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x0016:
        r1 = isAudioType(r0);
        if (r1 != 0) goto L_0x0030;
    L_0x001c:
        r0 = 46;
        r0 = r3.lastIndexOf(r0);
        r0 = r0 + 1;
        r0 = r3.substring(r0);
        r0 = r0.toLowerCase();
        r0 = getAudioTypeFromExtension(r0);
    L_0x0030:
        r1 = r0;
        goto L_0x0007;
    L_0x0032:
        r0 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.AudioFormat.getAudioType(java.lang.String):com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType");
    }

    public static AudioType getAudioType(IDataSource iDataSource) {
        if (iDataSource == null) {
            throw new IllegalArgumentException("dataSource can't be null!");
        }
        AudioType audioType = AudioType.UNSUPPORT;
        if (FormatDetector.sIsLoadSuccess) {
            AudioType audioFormat = FormatDetector.getAudioFormat(iDataSource, false);
            if (isAudioType(audioFormat)) {
                return audioFormat;
            }
        }
        return audioType;
    }
}
