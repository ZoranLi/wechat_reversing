package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ape.ApeDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACDecoder;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Decoder;
import com.tencent.qqmusic.mediaplayer.codec.ogg.VorbisDecoder;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavDecoder;
import com.tencent.qqmusic.mediaplayer.codec.wma.WmaDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class MediaCodecFactory {
    private static final String TAG = "MediaCodecFactory";
    private static HashMap<AudioType, Class<? extends BaseDecoder>> mDecoderMap = new HashMap();
    private static ArrayList<AudioType> mSupportAudioType = new ArrayList();

    static {
        registerDecoder(AudioType.M4A, FfmpegPlayer.class);
        registerDecoder(AudioType.OGG, VorbisDecoder.class);
        registerDecoder(AudioType.FLAC, FLACDecoder.class);
        registerDecoder(AudioType.MP3, MP3Decoder.class);
        registerDecoder(AudioType.APE, ApeDecoder.class);
        registerDecoder(AudioType.WAV, WavDecoder.class);
        registerDecoder(AudioType.WMA, WmaDecoder.class);
        registerDecoder(AudioType.MP4, FfmpegPlayer.class);
        registerDecoder(AudioType.AAC, FfmpegPlayer.class);
    }

    public static void registerDecoder(AudioType audioType, Class<? extends BaseDecoder> cls) {
        mDecoderMap.put(audioType, cls);
        mSupportAudioType.add(audioType);
    }

    public static void unRegisterDecoder(AudioType audioType) {
        mSupportAudioType.remove(audioType);
        mDecoderMap.remove(audioType);
    }

    public static BaseDecoder createDecoderByType(AudioType audioType) {
        Throwable th;
        if (!AudioFormat.isAudioType(audioType)) {
            return null;
        }
        BaseDecoder baseDecoder;
        if (mDecoderMap.containsKey(audioType)) {
            try {
                baseDecoder = (BaseDecoder) ((Class) mDecoderMap.get(audioType)).newInstance();
                try {
                    baseDecoder.setAudioType(audioType);
                } catch (Throwable th2) {
                    th = th2;
                    Logger.e(TAG, "createDecoderByType error", th);
                    return baseDecoder;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                baseDecoder = null;
                th = th4;
                Logger.e(TAG, "createDecoderByType error", th);
                return baseDecoder;
            }
        }
        baseDecoder = null;
        return baseDecoder;
    }

    public static ArrayList<AudioType> getSupportAudioType() {
        return new ArrayList(mSupportAudioType);
    }
}
