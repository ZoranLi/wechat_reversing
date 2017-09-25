package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import java.lang.ref.WeakReference;

public class AudioTrackMonitor {
    private static final boolean ENABLE = false;
    private static final String TAG = "AudioTrackMonitor";
    public WeakReference<AudioTrack> mAudioTrackRef = null;
    public StringBuilder mBuilder = new StringBuilder(100);
    public long mLastPosition = 0;
    public long mLastTime = System.nanoTime();
    public int mLooperTime = m.CTRL_INDEX;
    private Thread mMonitorThread = new Thread("Monitor-AudioTrack") {
        public void run() {
            super.run();
            while (!AudioTrackMonitor.this.mStop) {
                try {
                    Thread.currentThread();
                    Thread.sleep((long) AudioTrackMonitor.this.mLooperTime);
                } catch (Throwable th) {
                    Logger.e(AudioTrackMonitor.TAG, th);
                }
                try {
                    if (AudioTrackMonitor.this.mAudioTrackRef != null && AudioTrackMonitor.this.mAudioTrackRef.get() != null) {
                        AudioTrack audioTrack = (AudioTrack) AudioTrackMonitor.this.mAudioTrackRef.get();
                        if (audioTrack != null) {
                            int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                            long j = ((long) playbackHeadPosition) - AudioTrackMonitor.this.mLastPosition;
                            AudioTrackMonitor.this.mLastPosition = (long) playbackHeadPosition;
                            long nanoTime = System.nanoTime() - AudioTrackMonitor.this.mLastTime;
                            AudioTrackMonitor.this.mLastTime = System.nanoTime();
                            AudioTrackMonitor.this.mBuilder.append("play-speedTime-").append(nanoTime).append(",play-speedPosition-").append(j);
                            AudioTrackMonitor.this.mBuilder.append(",playstate-").append(audioTrack.getPlayState());
                            Logger.e(AudioTrackMonitor.TAG, AudioTrackMonitor.this.mBuilder.toString());
                            AudioTrackMonitor.this.mBuilder.delete(0, AudioTrackMonitor.this.mBuilder.length());
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Logger.e(AudioTrackMonitor.TAG, th2);
                }
            }
        }
    };
    public boolean mStop = false;

    public AudioTrackMonitor(AudioTrack audioTrack) {
        this.mAudioTrackRef = new WeakReference(audioTrack);
    }

    public void start() {
    }

    public void stop() {
    }
}
