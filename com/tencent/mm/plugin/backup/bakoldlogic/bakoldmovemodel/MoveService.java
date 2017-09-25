package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui.BakMoveErrUI;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class MoveService extends Service implements e {
    private boolean jGP = true;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        w.i("summerbak.MicroMsg.MoveService", "onCreate()");
        super.onCreate();
        ap.vd().a(595, this);
        b.a(1, this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        w.i("summerbak.MicroMsg.MoveService", "onStartCommand()");
        if (intent == null) {
            w.w("summerbak.MicroMsg.MoveService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bg.mA(stringExtra)) {
                w.e("summerbak.MicroMsg.MoveService", "onStartCommand url is null");
                stopSelf();
            } else {
                w.i("summerbak.MicroMsg.MoveService", "Broadcast url:%s, isMove:%b", new Object[]{stringExtra, Boolean.valueOf(this.jGP)});
                ap.vd().a(new com.tencent.mm.plugin.backup.bakoldlogic.c.e(stringExtra), 0);
                b.b(1, this);
            }
        }
        return 2;
    }

    public void onDestroy() {
        ap.vd().b(595, this);
        b.b(1, this);
        super.onDestroy();
        w.i("summerbak.MicroMsg.MoveService", "onDestroy" + Thread.currentThread().getName());
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        Intent className;
        if (kVar instanceof b) {
            if (kVar.getType() == 1 && i == 0 && i2 == 0) {
                className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                startActivity(className);
            }
            stopSelf();
        } else if (!(kVar instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.e)) {
        } else {
            if (i == 0 && i2 == 0) {
                String str3;
                int intValue;
                xa acy = ((com.tencent.mm.plugin.backup.bakoldlogic.c.e) kVar).acy();
                a.abR().jBm = acy.ID;
                a.abR().jBn = acy.tib;
                a.abR().jBo = acy.tic;
                b.a(a.abR().abU());
                b.a(a.abR().aaE());
                b.jg(2);
                if (acy.thR > 0) {
                    me meVar = (me) acy.thS.getFirst();
                    str3 = meVar.tsr;
                    intValue = ((Integer) meVar.tss.getFirst()).intValue();
                } else {
                    w.e("summerbak.MicroMsg.MoveService", "addr convMsgCount is empty");
                    intValue = 0;
                    str3 = null;
                }
                if (m.xL().equals(acy.thU)) {
                    str2 = str3;
                } else {
                    w.e("summerbak.MicroMsg.MoveService", "convName not equal:self:%s, resp.acc:%s", new Object[]{m.xL(), acy.thU});
                }
                if (bg.mA(str2)) {
                    className = new Intent(ab.getContext(), BakMoveErrUI.class);
                    className.putExtra("getConnectInfoErr", true);
                    className.addFlags(335544320);
                    ab.getContext().startActivity(className);
                } else {
                    a.abR().aaE().connect(str2, intValue);
                    a.abR().abU().a(true, acy.thV, str2, intValue);
                }
                stopSelf();
                return;
            }
            className = new Intent(ab.getContext(), BakMoveErrUI.class);
            className.putExtra("getConnectInfoErr", true);
            className.addFlags(335544320);
            ab.getContext().startActivity(className);
            stopSelf();
        }
    }
}
