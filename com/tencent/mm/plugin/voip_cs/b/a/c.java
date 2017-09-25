package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.c.b.c.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class c {
    private a mOP = new a(this) {
        final /* synthetic */ c rta;

        {
            this.rta = r1;
        }

        public final void d(byte[] bArr, int i) {
            if (i <= 0) {
                w.e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
                return;
            }
            w.d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
            w.d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:" + b.brN().mOV.recordCallback(bArr, i, m.CTRL_INDEX));
        }

        public final void ax(int i, int i2) {
            w.i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    };
    public com.tencent.mm.c.b.c nOV = new com.tencent.mm.c.b.c(v2protocal.nON, 1);
    private com.tencent.mm.plugin.voip.model.a nOY = new com.tencent.mm.plugin.voip.model.a(this) {
        final /* synthetic */ c rta;

        {
            this.rta = r1;
        }

        public final int x(byte[] bArr, int i) {
            w.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack,pcm data len:" + bArr.length);
            int playCallback = b.brN().mOV.playCallback(bArr, i);
            if (playCallback != 0) {
                w.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + bArr.length + ",ret:" + playCallback);
            }
            return playCallback != 0 ? 1 : 0;
        }
    };
    public com.tencent.mm.plugin.voip.model.b rgk;

    public c() {
        this.nOV.cY(20);
        this.nOV.at(true);
        this.nOV.pe();
        this.nOV.r(1, false);
        this.nOV.as(true);
        this.nOV.fAe = this.mOP;
        this.rgk = new com.tencent.mm.plugin.voip.model.b();
        this.rgk.O(v2protocal.nON, 20, 0);
        this.rgk.j(ab.getContext(), false);
        this.rgk.reE = this.nOY;
    }

    private boolean ib(boolean z) {
        if (this.rgk != null) {
            return this.rgk.ib(z);
        }
        return false;
    }

    public final void id(boolean z) {
        w.h("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: " + z, new Object[0]);
        w.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + ap.yZ().qM());
        if (ap.yZ().qI()) {
            z = false;
        }
        if (p.gRd.gNN) {
            p.gRd.dump();
            if (p.gRd.gNO > 0) {
                ib(z);
            }
        }
        if (p.gRd.gOp >= 0 || p.gRd.gOq >= 0) {
            ib(z);
        }
        if (this.rgk != null) {
            ap.yZ().a(z, this.rgk.bpb());
            com.tencent.mm.plugin.voip_cs.b.b.a brN = b.brN();
            int pQ = z ? brN.mOV.pQ(401) : brN.mOV.pQ(402);
            if (pQ < 0) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:" + pQ);
            }
        }
    }
}
