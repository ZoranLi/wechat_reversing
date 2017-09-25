package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;

public class VoiceUnLockUI extends BaseVoicePrintUI implements a {
    private q rem;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rem = new q(this);
        w.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        ap.vd().a(new d(73, ""), 0);
    }

    protected final void boG() {
        w.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[]{this.rdd});
        if (!bg.mA(this.rdd) && !bg.mA(this.rem.rcG)) {
            k jVar = new j(this.rdd, this.rem.rcH);
            jVar.rcn = true;
            ap.vd().a(jVar, 0);
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
        this.rcG = str;
        this.rdb.boR();
        this.rdb.HB(str);
        this.rdb.boQ();
        this.rcY.setEnabled(true);
    }

    public final void ia(boolean z) {
        this.rdb.boQ();
        this.rcY.setEnabled(true);
        if (z) {
            w.d("MicroMsg.VoiceUnLockUI", "unlock success");
            boO();
            return;
        }
        this.rdb.uI(R.l.faA);
        this.rdb.boT();
    }

    protected void boO() {
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        startActivity(intent);
        finish();
    }

    public final void boz() {
        boF();
    }

    protected void onDestroy() {
        super.onDestroy();
        Object obj = this.rem;
        ap.vd().b(611, obj);
        ap.vd().b(613, obj);
        obj.rcX = null;
    }
}
