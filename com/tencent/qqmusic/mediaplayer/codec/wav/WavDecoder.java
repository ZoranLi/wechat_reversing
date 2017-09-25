package com.tencent.qqmusic.mediaplayer.codec.wav;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;

public class WavDecoder extends FfmpegPlayer {
    public AudioType getAudioType(String str, byte[] bArr) {
        if (WaveReader.isWavFormat(str)) {
            return AudioType.WAV;
        }
        return AudioType.UNSUPPORT;
    }

    public AudioType guessAudioType(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".wav")) {
            return AudioType.UNSUPPORT;
        }
        return AudioType.WAV;
    }

    public int getErrorCodeMask() {
        return 100663295;
    }
}
