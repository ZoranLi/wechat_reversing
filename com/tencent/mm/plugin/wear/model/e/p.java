package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.c.c.d;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public final class p implements e {
    public static final String rUw = (w.hgq + "tmp_wearvoicetotext.spx");
    public boolean fZK = false;
    private int rUA = 0;
    public int rUB;
    public int rUC;
    public LinkedList<Integer> rUD = new LinkedList();
    public c rUx;
    public com.tencent.qqpinyin.voicerecoapi.c rUy;
    public d rUz;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String gTC;
        final /* synthetic */ p rUE;

        public AnonymousClass1(p pVar, String str) {
            this.rUE = pVar;
            this.gTC = str;
        }

        public final void run() {
            this.rUE.rUx = new c(p.rUw, this.gTC, this.rUE.rUB);
            ap.vd().a(349, this.rUE);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
        }
    }

    class a extends com.tencent.mm.plugin.wear.model.f.c {
        public int oWj;
        public int rTS = 2;
        public int rTT;
        final /* synthetic */ p rUE;
        public bos rUF;

        public a(p pVar, int i, bos com_tencent_mm_protocal_c_bos) {
            this.rUE = pVar;
            this.oWj = i;
            this.rTT = 30001;
            this.rUF = com_tencent_mm_protocal_c_bos;
        }

        protected final void send() {
            try {
                byte[] aQ = com.tencent.mm.plugin.wear.model.a.bvG().rTo.aQ(this.rUF.toByteArray());
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeInt(this.rTS);
                    dataOutputStream.writeInt(this.oWj);
                    dataOutputStream.writeInt(this.rTT);
                    if (aQ == null || aQ.length <= 0) {
                        dataOutputStream.writeInt(0);
                    } else {
                        dataOutputStream.writeInt(aQ.length);
                        dataOutputStream.write(aQ);
                    }
                    aQ = byteArrayOutputStream.toByteArray();
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "send data funId=%d length=%d", new Object[]{Integer.valueOf(this.rTT), Integer.valueOf(aQ.length)});
                    com.tencent.mm.plugin.wear.model.a.bvG().rTo.aO(byteArrayOutputStream.toByteArray());
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(this.rTS), Integer.valueOf(this.oWj), Integer.valueOf(this.rTT)});
                }
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e2, "", new Object[0]);
            }
        }

        public final String getName() {
            return "WearVoiceToTextTask";
        }
    }

    public final void reset() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[]{Integer.valueOf(this.rUB)});
        if (this.rUz != null) {
            this.rUz.ps();
            this.rUz = null;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.rUy != null) {
            this.rUy.stop();
            this.rUy = null;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.rUx != null) {
            this.rUx.ibh = true;
            ap.vd().b(349, this);
            ap.vd().c(this.rUx);
            this.rUx = null;
        }
        this.rUC = 0;
        this.fZK = false;
        this.rUA = 0;
        this.rUB = -1;
        this.rUD.clear();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            bos com_tencent_mm_protocal_c_bos;
            if (i != 0 || i2 != 0) {
                ap.vd().b(349, this);
                com_tencent_mm_protocal_c_bos = new bos();
                com_tencent_mm_protocal_c_bos.umH = cVar.fJL;
                com_tencent_mm_protocal_c_bos.tGa = "";
                com_tencent_mm_protocal_c_bos.tcm = -1;
                com_tencent_mm_protocal_c_bos.unl = false;
                com.tencent.mm.plugin.wear.model.a.bvG().rTu.a(new a(this, cVar.oWj, com_tencent_mm_protocal_c_bos));
            } else if (cVar.rUn) {
                ap.vd().b(349, this);
                com_tencent_mm_protocal_c_bos = new bos();
                com_tencent_mm_protocal_c_bos.umH = cVar.fJL;
                if (bg.mA(cVar.rUm)) {
                    com_tencent_mm_protocal_c_bos.tGa = "";
                    com_tencent_mm_protocal_c_bos.tcm = -1;
                    com_tencent_mm_protocal_c_bos.unl = false;
                } else {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[]{cVar.rUm});
                    com_tencent_mm_protocal_c_bos.tGa = cVar.rUm;
                    com_tencent_mm_protocal_c_bos.tcm = 0;
                    com_tencent_mm_protocal_c_bos.unl = true;
                }
                com.tencent.mm.plugin.wear.model.a.bvG().rTu.a(new a(this, cVar.oWj, com_tencent_mm_protocal_c_bos));
            }
        }
    }

    public final void a(int i, bor com_tencent_mm_protocal_c_bor) {
        if (com_tencent_mm_protocal_c_bor.tgI == null) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            return;
        }
        byte[] toByteArray = com_tencent_mm_protocal_c_bor.tgI.toByteArray();
        this.rUA += this.rUz.a(new com.tencent.mm.c.b.g.a(toByteArray, com_tencent_mm_protocal_c_bor.tuc), 0, false);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[]{Integer.valueOf(this.rUA)});
        short[] sArr = new short[(com_tencent_mm_protocal_c_bor.tuc / 2)];
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bor.tuc / 2; i2++) {
            sArr[i2] = (short) ((toByteArray[i2 * 2] & 255) | (toByteArray[(i2 * 2) + 1] << 8));
        }
        com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
        this.rUy.a(sArr, com_tencent_mm_protocal_c_bor.tuc / 2, aVar);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + aVar.wPH);
        if (aVar.wPH == 2) {
            this.rUC = 1;
        } else if (aVar.wPH == 3) {
            this.rUC = 2;
        }
        if (this.rUC != 0) {
            if (this.rUC < 0) {
                if (this.rUD.size() > 10) {
                    this.rUD.removeLast();
                }
                this.rUD.addFirst(Integer.valueOf(i));
            }
            if (this.rUC == 1) {
                bos com_tencent_mm_protocal_c_bos = new bos();
                com_tencent_mm_protocal_c_bos.umH = this.rUx.fJL;
                com_tencent_mm_protocal_c_bos.tGa = "";
                com_tencent_mm_protocal_c_bos.tcm = this.rUC;
                com_tencent_mm_protocal_c_bos.unl = true;
                com.tencent.mm.plugin.wear.model.a.bvG().rTu.a(new a(this, this.rUx.oWj, com_tencent_mm_protocal_c_bos));
                this.rUC = 0;
            }
        }
        if (!this.fZK && this.rUA > 3300) {
            this.fZK = true;
            ap.vd().a(this.rUx, 0);
        }
    }
}
