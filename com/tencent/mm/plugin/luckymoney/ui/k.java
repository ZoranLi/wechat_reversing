package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.sdk.platformtools.w;

public final class k {

    private enum a {
        NOTSET,
        ON,
        OFF
    }

    public static void B(Context context, int i) {
        a aVar = a.NOTSET;
        if (context == null || aVar == null) {
            w.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", new Object[]{context, Integer.valueOf(i), aVar, Boolean.valueOf(false)});
        } else if (com.tencent.mm.i.a.sl() && com.tencent.mm.i.a.so()) {
            final String string = context.getString(i);
            MediaPlayer iVar = new i();
            if (aVar != a.NOTSET) {
                iVar.setAudioStreamType(aVar == a.ON ? 5 : 0);
            }
            w.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", new Object[]{Integer.valueOf(iVar.hashCode()), string, context, Integer.valueOf(i), aVar, Boolean.valueOf(false)});
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(string);
                iVar.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                iVar.setLooping(false);
                iVar.prepare();
                iVar.start();
                iVar.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        w.i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        return false;
                    }
                });
                iVar.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        String str = "MicroMsg.LuckySoundUtil";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        w.i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    }
                });
            } catch (Throwable e) {
                w.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", new Object[]{Integer.valueOf(i), e.getMessage()});
                w.printErrStackTrace("MicroMsg.LuckySoundUtil", e, "", new Object[0]);
            }
        }
    }
}
