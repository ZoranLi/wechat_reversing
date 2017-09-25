package com.tencent.mm.platformtools;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import com.tencent.mm.bb.a;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.d.e;

public final class l {

    static class AnonymousClass1 implements a {
        final /* synthetic */ Bundle fym;
        final /* synthetic */ String hRW;
        final /* synthetic */ String ihZ;
        final /* synthetic */ String iia;
        final /* synthetic */ int iib;
        final /* synthetic */ String val$jumpUrl;

        public AnonymousClass1(String str, String str2, Bundle bundle, String str3, String str4, int i) {
            this.val$jumpUrl = str;
            this.ihZ = str2;
            this.fym = bundle;
            this.iia = str3;
            this.hRW = str4;
            this.iib = i;
        }

        public final void onDone() {
            Time time = new Time();
            time.setToNow();
            if (com.tencent.mm.i.a.az(time.hour, time.minute)) {
                try {
                    Context context = ab.getContext();
                    boolean sq = com.tencent.mm.i.a.sq();
                    boolean so = com.tencent.mm.i.a.so();
                    w.d("MiroMsg.NotificationUtil", "shake " + sq + "sound " + so);
                    if (sq) {
                        w.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
                        bg.k(context, true);
                    }
                    if (so) {
                        String sp = com.tencent.mm.i.a.sp();
                        Uri defaultUri = sp == e.gTd ? RingtoneManager.getDefaultUri(2) : Uri.parse(sp);
                        MediaPlayer iVar = new i();
                        try {
                            iVar.setDataSource(context, defaultUri);
                            iVar.setOnCompletionListener(new OnCompletionListener() {
                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    try {
                                        mediaPlayer.release();
                                    } catch (Throwable e) {
                                        w.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                                    }
                                }
                            });
                            if (ap.yZ().getStreamVolume(5) != 0) {
                                if (ap.yZ().qO()) {
                                    int streamVolume = ap.yZ().getStreamVolume(8);
                                    int streamMaxVolume = ap.yZ().getStreamMaxVolume(8);
                                    int streamVolume2 = ap.yZ().getStreamVolume(5);
                                    if (streamVolume2 <= streamMaxVolume) {
                                        streamMaxVolume = streamVolume2;
                                    }
                                    ap.yZ().ed(streamMaxVolume);
                                    iVar.setAudioStreamType(8);
                                    iVar.setLooping(true);
                                    iVar.prepare();
                                    iVar.setLooping(false);
                                    iVar.start();
                                    ap.yZ().ed(streamVolume);
                                    w.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                                } else {
                                    iVar.setAudioStreamType(5);
                                    iVar.setLooping(true);
                                    iVar.prepare();
                                    iVar.setLooping(false);
                                    iVar.start();
                                }
                            }
                        } catch (Throwable e) {
                            w.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                        }
                    }
                } catch (Throwable e2) {
                    w.printErrStackTrace("MiroMsg.NotificationUtil", e2, "", new Object[0]);
                }
            } else {
                w.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
            }
            Intent intent = new Intent();
            intent.setClassName(ab.getPackageName(), ab.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", this.val$jumpUrl);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.setFlags(872415232);
            w.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", this.ihZ, this.fym);
            if (!(this.ihZ == null || this.fym == null)) {
                intent.putExtra("bizofstartfrom", this.ihZ);
                intent.putExtra("startwebviewparams", this.fym);
            }
            Notification notification = new Builder(ab.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.iia).setContentText(this.hRW).setContentIntent(PendingIntent.getActivity(ab.getContext(), 0, intent, 134217728)).getNotification();
            notification.icon = com.tencent.mm.ba.a.bCk();
            notification.flags |= 16;
            ((NotificationManager) ab.getContext().getSystemService("notification")).notify(this.iib, notification);
        }
    }
}
