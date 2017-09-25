package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.c.b.c;
import com.tencent.mm.plugin.talkroom.component.d.a;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends a {
    private c.a fAv = new c.a(this) {
        final /* synthetic */ f qXf;

        {
            this.qXf = r1;
        }

        public final void d(byte[] bArr, int i) {
            w.d("MicroMsg.MicRecoder", "pcm len: " + i);
            if (i <= 0) {
                w.e("MicroMsg.MicRecoder", "pcm data too low");
                return;
            }
            f.a(this.qXf, bArr, i);
            int Send = this.qXf.qXc.Send(bArr, (short) i);
            if (Send < 0) {
                w.e("MicroMsg.MicRecoder", "send failed, ret: " + Send);
            }
        }

        public final void ax(int i, int i2) {
        }
    };
    private c fzv;
    private v2engine qXc;
    private short qXd;
    private short qXe;

    static /* synthetic */ void a(f fVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > fVar.qXd) {
                fVar.qXd = s;
            }
        }
    }

    public f(v2engine com_tencent_mm_plugin_talkroom_component_v2engine) {
        this.qXc = com_tencent_mm_plugin_talkroom_component_v2engine;
    }

    public final void bnw() {
        if (this.fzv != null) {
            this.fzv.oX();
            this.fzv = null;
        }
    }

    public final void bnx() {
        this.fzv = new c(com.tencent.mm.plugin.talkroom.model.a.qXr, 2);
        this.fzv.r(8, false);
        this.fzv.fAe = this.fAv;
        this.fzv.cY(20);
        this.fzv.pf();
        this.qXe = (short) 0;
        this.qXd = (short) 0;
    }

    public final int bny() {
        if (this.qXe < this.qXd) {
            this.qXe = this.qXd;
        }
        if (this.qXe == (short) 0) {
            return 0;
        }
        short s = (short) ((this.qXd * 100) / this.qXe);
        this.qXd = (short) 0;
        return s;
    }

    public final void start() {
    }

    public final void release() {
        bnw();
    }
}
