package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.nio.charset.Charset;

public final class f {
    Context context = ab.getContext();
    public boolean gLX = false;
    public MediaPlayer gLY = null;
    @SuppressLint({"HandlerLeak"})
    ae gLZ = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ f gMb;

        public final void handleMessage(Message message) {
            w.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", Boolean.valueOf(this.gMb.gLX));
            try {
                if (this.gMb.gLY != null) {
                    if (this.gMb.gLY.isPlaying()) {
                        this.gMb.gLY.stop();
                    }
                    this.gMb.gLY.release();
                    this.gMb.gLX = false;
                    w.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", Boolean.valueOf(this.gMb.gLX));
                }
            } catch (IllegalStateException e) {
                w.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", Boolean.valueOf(this.gMb.gLX));
                if (this.gMb.gLY != null) {
                    this.gMb.gLY.release();
                }
            }
        }
    };
    private ae gMa;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ f gMb;
        final /* synthetic */ String gMc;
        final /* synthetic */ boolean gMd = false;

        AnonymousClass2(f fVar, String str, boolean z) {
            this.gMb = fVar;
            this.gMc = str;
        }

        public final void run() {
            f fVar = this.gMb;
            String str = this.gMc;
            boolean z = this.gMd;
            if (fVar.context == null) {
                fVar.context = ab.getContext();
            }
            if (fVar.context == null) {
                w.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
                return;
            }
            try {
                AudioManager audioManager = (AudioManager) fVar.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager.getStreamVolume(5) != 0) {
                    Uri defaultUri;
                    fVar.gLZ.removeMessages(305419896);
                    fVar.gLZ.sendEmptyMessageDelayed(305419896, 8000);
                    w.i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", Boolean.valueOf(fVar.gLX));
                    if (fVar.gLX) {
                        try {
                            if (fVar.gLY != null) {
                                if (fVar.gLY.isPlaying()) {
                                    fVar.gLY.stop();
                                }
                                fVar.gLY.release();
                                w.i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", Boolean.valueOf(fVar.gLX));
                            }
                        } catch (IllegalStateException e) {
                            w.w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
                            if (fVar.gLY != null) {
                                fVar.gLY.release();
                            }
                        }
                        fVar.gLX = false;
                    }
                    fVar.gLY = new i();
                    w.i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", fVar.gLY);
                    MediaPlayer mediaPlayer = fVar.gLY;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (bg.mA(str)) {
                        defaultUri = RingtoneManager.getDefaultUri(2);
                    } else if (z) {
                        AssetFileDescriptor openFd = fVar.context.getAssets().openFd(str);
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                        defaultUri = null;
                    } else {
                        defaultUri = Uri.parse(str);
                    }
                    if (defaultUri != null) {
                        try {
                            mediaPlayer.setDataSource(fVar.context, defaultUri);
                        } catch (IOException e2) {
                            if (bg.mA(str)) {
                                w.i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", str, Boolean.valueOf(z));
                            } else {
                                mediaPlayer.setDataSource(fVar.context, RingtoneManager.getDefaultUri(2));
                            }
                        }
                    }
                    w.i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (audioManager.isWiredHeadsetOn()) {
                        e.qK();
                        w.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", Integer.valueOf(0));
                        float streamVolume = (float) audioManager.getStreamVolume(0);
                        float streamMaxVolume = (float) audioManager.getStreamMaxVolume(0);
                        float streamVolume2 = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                        w.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", Float.valueOf(streamVolume), Float.valueOf(streamMaxVolume), Float.valueOf(streamVolume / streamMaxVolume));
                        w.d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", Float.valueOf(r3), Float.valueOf(r5), Float.valueOf(streamVolume2));
                        if (streamVolume / streamMaxVolume > streamVolume2) {
                            streamVolume = streamMaxVolume * streamVolume2;
                            w.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", Float.valueOf(streamVolume));
                        }
                        audioManager.setSpeakerphoneOn(false);
                        w.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", Integer.valueOf(p.gRl.gQI));
                        if (p.gRl.gQI == 1) {
                            w.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                            if (audioManager.getMode() == 0) {
                                audioManager.setMode(3);
                            }
                            fVar.gLY.setOnCompletionListener(new AnonymousClass3(fVar, audioManager));
                            fVar.gLY.setOnErrorListener(new AnonymousClass4(fVar, audioManager));
                        } else {
                            fVar.gLY.setOnCompletionListener(new OnCompletionListener(fVar) {
                                final /* synthetic */ f gMb;

                                {
                                    this.gMb = r1;
                                }

                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    w.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", this.gMb.gLY);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (this.gMb.gLY != null) {
                                        this.gMb.gLY.release();
                                    }
                                }
                            });
                            fVar.gLY.setOnErrorListener(new OnErrorListener(fVar) {
                                final /* synthetic */ f gMb;

                                {
                                    this.gMb = r1;
                                }

                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    w.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", this.gMb.gLY);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (this.gMb.gLY != null) {
                                        this.gMb.gLY.release();
                                    }
                                    return false;
                                }
                            });
                        }
                        fVar.gLY.setAudioStreamType(0);
                        fVar.gLY.setLooping(true);
                        fVar.gLY.prepare();
                        fVar.gLY.setVolume(streamVolume / streamMaxVolume, streamVolume / streamMaxVolume);
                        fVar.gLY.setLooping(false);
                        fVar.gLY.start();
                        fVar.gLX = true;
                        return;
                    }
                    w.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", Integer.valueOf(audioManager.getStreamVolume(5)), str);
                    fVar.gLY.setOnCompletionListener(new OnCompletionListener(fVar) {
                        final /* synthetic */ f gMb;

                        {
                            this.gMb = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            w.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", this.gMb.gLY);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (this.gMb.gLY != null) {
                                this.gMb.gLY.release();
                                w.i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", this.gMb.gLY, Boolean.valueOf(this.gMb.gLX));
                            }
                        }
                    });
                    fVar.gLY.setOnErrorListener(new OnErrorListener(fVar) {
                        final /* synthetic */ f gMb;

                        {
                            this.gMb = r1;
                        }

                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            w.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", this.gMb.gLY);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (this.gMb.gLY != null) {
                                this.gMb.gLY.release();
                                w.i("MicroMsg.Notification.Tool.Sound", "play sound real error, player: %s,playerIsInit:%s", this.gMb.gLY, Boolean.valueOf(this.gMb.gLX));
                            }
                            return false;
                        }
                    });
                    fVar.gLY.setAudioStreamType(5);
                    fVar.gLY.setLooping(true);
                    fVar.gLY.prepare();
                    fVar.gLY.setLooping(false);
                    fVar.gLY.start();
                    fVar.gLX = true;
                    String str2 = "MicroMsg.Notification.Tool.Sound";
                    String str3 = "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(fVar.gLX);
                    objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                    objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                    w.i(str2, str3, objArr);
                }
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e3, "PlaySound Exception:", new Object[0]);
                try {
                    if (fVar.gLY != null) {
                        fVar.gLY.release();
                    }
                } catch (Throwable e32) {
                    w.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e32, "try to release player in Exception:", new Object[0]);
                }
            }
        }
    }

    class AnonymousClass3 implements OnCompletionListener {
        final /* synthetic */ f gMb;
        final /* synthetic */ AudioManager gMe;

        AnonymousClass3(f fVar, AudioManager audioManager) {
            this.gMb = fVar;
            this.gMe = audioManager;
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            w.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", this.gMb.gLY);
            this.gMe.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (this.gMb.gLY != null) {
                this.gMb.gLY.release();
            }
        }
    }

    class AnonymousClass4 implements OnErrorListener {
        final /* synthetic */ f gMb;
        final /* synthetic */ AudioManager gMe;

        AnonymousClass4(f fVar, AudioManager audioManager) {
            this.gMb = fVar;
            this.gMe = audioManager;
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            w.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", this.gMb.gLY);
            this.gMe.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (this.gMb.gLY != null) {
                this.gMb.gLY.release();
            }
            return false;
        }
    }

    private static class a {
        public static final f gMf = new f();
    }

    public f() {
        String str = null;
        String str2 = com.tencent.mm.storage.w.hgq + "deviceconfig.cfg";
        w.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", str2, Boolean.valueOf(com.tencent.mm.a.e.aO(str2)));
        if (com.tencent.mm.a.e.aO(str2)) {
            byte[] d = com.tencent.mm.a.e.d(str2, 0, -1);
            if (!bg.bm(d)) {
                str2 = new String(d, Charset.defaultCharset());
                if (!bg.mA(str2)) {
                    str = str2;
                }
            }
        }
        p.du(str);
    }

    public final synchronized void di(String str) {
        if (this.gMa == null) {
            w.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
            HandlerThread cE = com.tencent.mm.sdk.f.e.cE("playSoundThread", 0);
            cE.start();
            this.gMa = new ae(cE.getLooper());
        }
        this.gMa.post(new AnonymousClass2(this, str, false));
    }
}
