package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.r;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class e implements b {
    private r oPK = new r();
    RecordVoiceBaseView oQb;

    public final View cJ(Context context) {
        View inflate = View.inflate(context, R.i.dmr, null);
        RecordVoiceBaseView recordVoiceBaseView = (RecordVoiceBaseView) inflate.findViewById(R.h.cMZ);
        recordVoiceBaseView.oPK = this.oPK;
        r rVar = recordVoiceBaseView.oPK;
        for (Object obj : rVar.gJv) {
            if (recordVoiceBaseView == obj) {
                break;
            }
        }
        rVar.gJv.add(recordVoiceBaseView);
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        View findViewById = view.findViewById(R.h.bMe);
        this.oQb = (RecordVoiceBaseView) view.findViewById(R.h.cMZ);
        if (bVar.aMw == 0) {
            this.oQb.setVisibility(8);
            findViewById.setVisibility(0);
        } else if (bVar.aMw == 1) {
            findViewById.setVisibility(8);
            this.oQb.setVisibility(0);
            String a = d.a(bVar);
            com.tencent.mm.sdk.b.b fpVar = new fp();
            fpVar.fKp.type = 17;
            fpVar.fKp.fKr = bVar.fKe;
            a.urY.m(fpVar);
            int i2 = fpVar.fKq.ret;
            if (!com.tencent.mm.a.e.aO(a)) {
                if (bg.mA(bVar.fKe.txi)) {
                    findViewById.setVisibility(0);
                    this.oQb.setVisibility(8);
                } else {
                    w.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[]{Long.valueOf(bVar.oOR.field_localId), bVar.fKe.txi});
                    com.tencent.mm.sdk.b.b fpVar2 = new fp();
                    fpVar2.fKp.type = 16;
                    fpVar2.fKp.fFx = bVar.oOR.field_localId;
                    a.urY.m(fpVar2);
                }
            }
            RecordVoiceBaseView recordVoiceBaseView = this.oQb;
            int i3 = bVar.fKe.duration;
            recordVoiceBaseView.path = bg.ap(a, "");
            recordVoiceBaseView.fKw = i2;
            if (recordVoiceBaseView.duration != i3) {
                recordVoiceBaseView.duration = i3;
                recordVoiceBaseView.setText(((int) q.aw((long) i3)) + "''");
            }
        }
    }

    public final void destroy() {
        r rVar = this.oPK;
        rVar.adL();
        rVar.adJ();
        r.jXn = null;
        rVar.gJv.clear();
    }

    public final void pause() {
        if (this.oPK != null && this.oPK.gJv.size() > 0) {
            for (r.a onFinish : this.oPK.gJv) {
                onFinish.onFinish();
            }
        }
    }
}
