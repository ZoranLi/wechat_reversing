package com.tencent.qqmusic.mediaplayer.codec.ogg;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;

public class VorbisDecoder extends FfmpegPlayer {
    public AudioType getAudioType(String str, byte[] bArr) {
        if (bArr == null || bArr.length <= 0 || !new String(bArr).startsWith("OggS")) {
            return AudioType.UNSUPPORT;
        }
        return AudioType.OGG;
    }

    public AudioType guessAudioType(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".ogg")) {
            return AudioType.UNSUPPORT;
        }
        return AudioType.OGG;
    }

    public int getErrorCodeMask() {
        return 83886079;
    }
}
