package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;

public final class aq {

    public interface a {
        void oW();
    }

    private enum b {
        NOTSET,
        ON,
        OFF
    }

    public static MediaPlayer a(Context context, int i, b bVar, boolean z, final a aVar) {
        AssetFileDescriptor openFd;
        Throwable e;
        AssetFileDescriptor assetFileDescriptor;
        Throwable e2;
        if (context == null || bVar == null) {
            w.e("MicroMsg.PlaySound", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", context, Integer.valueOf(i), bVar, Boolean.valueOf(false), aVar);
            return null;
        }
        final String string = context.getString(i);
        final MediaPlayer mediaPlayer = new MediaPlayer();
        if (bVar != b.NOTSET) {
            mediaPlayer.setAudioStreamType(bVar == b.ON ? 3 : 0);
        }
        w.i("MicroMsg.PlaySound", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(i), bVar, Boolean.valueOf(false), aVar);
        try {
            openFd = context.getAssets().openFd(string);
            try {
                mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                mediaPlayer.setLooping(false);
                mediaPlayer.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        w.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e) {
                            }
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        String str = "MicroMsg.PlaySound";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        w.i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (aVar != null) {
                            aVar.oW();
                        }
                    }
                });
                mediaPlayer.prepare();
                mediaPlayer.start();
                String str = "MicroMsg.PlaySound";
                String str2 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                w.i(str, str2, objArr);
                if (openFd == null) {
                    return mediaPlayer;
                }
                try {
                    openFd.close();
                    return mediaPlayer;
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.PlaySound", e3, "", new Object[0]);
                    return mediaPlayer;
                }
            } catch (Exception e4) {
                e3 = e4;
                assetFileDescriptor = openFd;
                try {
                    w.e("MicroMsg.PlaySound", "play failed pathId:%d e:%s", Integer.valueOf(i), e3.getMessage());
                    w.printErrStackTrace("MicroMsg.PlaySound", e3, "", new Object[0]);
                    mediaPlayer.release();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (Throwable e22) {
                            w.printErrStackTrace("MicroMsg.PlaySound", e22, "", new Object[0]);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e22 = th;
                    openFd = assetFileDescriptor;
                    if (openFd != null) {
                        try {
                            openFd.close();
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.PlaySound", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                if (openFd != null) {
                    openFd.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e32 = e5;
            assetFileDescriptor = null;
            w.e("MicroMsg.PlaySound", "play failed pathId:%d e:%s", Integer.valueOf(i), e32.getMessage());
            w.printErrStackTrace("MicroMsg.PlaySound", e32, "", new Object[0]);
            mediaPlayer.release();
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            return null;
        } catch (Throwable th3) {
            e22 = th3;
            openFd = null;
            if (openFd != null) {
                openFd.close();
            }
            throw e22;
        }
    }

    public static void a(Context context, int i, a aVar) {
        a(context, i, b.ON, false, aVar);
    }

    public static void b(Context context, int i, a aVar) {
        a(context, i, b.NOTSET, false, aVar);
    }

    public static void B(Context context, int i) {
        a(context, i, b.NOTSET, false, null);
    }
}
