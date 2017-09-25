package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.h;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class VoiceLoginUI extends BaseVoicePrintUI implements a {
    private String jia = null;
    private n rdE = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.oUh.i(11557, new Object[]{Integer.valueOf(1)});
        this.jia = bg.ap(getIntent().getStringExtra("Kusername"), null);
        w.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[]{this.jia, Boolean.valueOf(bg.mA(bg.ap(getIntent().getStringExtra("Kvertify_key"), null)))});
        if (bg.mA(this.jia)) {
            w.e("MicroMsg.VoiceLoginUI", "onCreate error, username is null");
            return;
        }
        this.rdE = new n();
        this.rdE.jia = this.jia;
        this.rdE.rcJ = r0;
        this.rdE.rcK = this;
        n nVar = this.rdE;
        if (bg.mA(nVar.rcJ)) {
            ap.vd().a(new e(nVar.jia), 0);
        } else {
            nVar.boA();
        }
        boolean a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
        w.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bg.bJZ(), this});
    }

    protected final void boG() {
        w.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[]{this.rdd});
        if (!bg.mA(this.rdd) && !bg.mA(this.rcG)) {
            n nVar = this.rdE;
            k hVar = new h(this.rdd, nVar.rcH, nVar.rcJ);
            hVar.rcn = true;
            ap.vd().a(hVar, 0);
            this.rcY.setEnabled(false);
            this.rdb.boP();
        }
    }

    protected final void aHe() {
        findViewById(R.h.cyU).setVisibility(8);
        this.rdb.boP();
        this.rdb.uH(R.l.faB);
        this.rdb.boS();
        this.rcY.setEnabled(false);
    }

    public final void HA(String str) {
        w.d("MicroMsg.VoiceLoginUI", "onGetText");
        this.rcG = str;
        this.rdb.boR();
        this.rdb.HB(str);
        this.rdb.boQ();
        this.rcY.setEnabled(true);
    }

    public final void hZ(boolean z) {
        this.rdb.boQ();
        this.rcY.setEnabled(true);
        if (z) {
            w.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[]{bg.Qj(this.rdE.rcw)});
            Intent intent = new Intent();
            intent.putExtra("VoiceLoginAuthPwd", this.rdE.rcw);
            setResult(-1, intent);
            finish();
            return;
        }
        w.i("MicroMsg.VoiceLoginUI", "login failed");
        this.rdb.uI(R.l.faA);
        this.rdb.boT();
    }

    public final void boz() {
        uG(R.l.faE);
    }

    public final void boB() {
        this.rcY.setEnabled(false);
        this.rcY.setVisibility(4);
        this.rdb.boQ();
        this.rdb.uI(R.l.faD);
        this.rdb.boT();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.rdE != null) {
            Object obj = this.rdE;
            ap.vd().b(618, obj);
            ap.vd().b(616, obj);
            ap.vd().b(617, obj);
            obj.rcK = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.VoiceLoginUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] == 0) {
                    boD();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ VoiceLoginUI rdF;

                        {
                            this.rdF = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.rdF.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ VoiceLoginUI rdF;

                        {
                            this.rdF = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
