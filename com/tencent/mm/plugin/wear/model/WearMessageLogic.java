package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.AnonymousClass1;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.IOException;

public class WearMessageLogic extends BroadcastReceiver {

    private class a extends d {
        public int oWj;
        public int rTS;
        public int rTT;
        public byte[] rTU;
        final /* synthetic */ WearMessageLogic rTV;

        public a(WearMessageLogic wearMessageLogic) {
            this.rTV = wearMessageLogic;
        }

        protected final void execute() {
            w.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[]{toString()});
            com.tencent.mm.plugin.wear.model.e.a vN = a.bvG().rTm.vN(this.rTT);
            if (vN != null) {
                vN.b(this.rTS, this.oWj, this.rTT, this.rTU);
            }
        }

        public final String getName() {
            return "HttpMessageTask";
        }

        public final String toString() {
            return String.format("connectType=%d funId=%d sessionId=%d", new Object[]{Integer.valueOf(this.rTS), Integer.valueOf(this.rTT), Integer.valueOf(this.oWj)});
        }
    }

    private class b extends d {
        public int oWj;
        public int rTS;
        public int rTT;
        public byte[] rTU;
        final /* synthetic */ WearMessageLogic rTV;

        public b(WearMessageLogic wearMessageLogic) {
            this.rTV = wearMessageLogic;
        }

        protected final void execute() {
            switch (this.rTT) {
                case 30001:
                    p pVar = a.bvG().rTo.rTH;
                    int i = this.oWj;
                    byte[] bArr = this.rTU;
                    if (!pVar.rUD.contains(Integer.valueOf(i))) {
                        bor com_tencent_mm_protocal_c_bor = new bor();
                        try {
                            com_tencent_mm_protocal_c_bor.aD(bArr);
                        } catch (IOException e) {
                        }
                        if (pVar.rUB != i) {
                            pVar.reset();
                            pVar.rUB = i;
                            w.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[]{Integer.valueOf(pVar.rUB)});
                            com.tencent.mm.loader.stub.b.deleteFile(p.rUw);
                            if (pVar.rUz == null) {
                                pVar.rUz = new com.tencent.mm.c.c.d();
                                pVar.rUz.bz(p.rUw);
                            }
                            if (pVar.rUy == null) {
                                pVar.rUy = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
                                if (pVar.rUy.start() != 0) {
                                    pVar.rUC = -2;
                                    return;
                                }
                            }
                            String str = com_tencent_mm_protocal_c_bor.umH;
                            if (pVar.rUx == null) {
                                af.v(new AnonymousClass1(pVar, str));
                            }
                            pVar.a(i, com_tencent_mm_protocal_c_bor);
                            return;
                        } else if (com_tencent_mm_protocal_c_bor.unk) {
                            w.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[]{Integer.valueOf(i)});
                            pVar.reset();
                            return;
                        } else if (com_tencent_mm_protocal_c_bor.unj) {
                            pVar.a(i, com_tencent_mm_protocal_c_bor);
                            if (pVar.rUz != null) {
                                pVar.rUz.ps();
                                pVar.rUz = null;
                                w.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                            }
                            if (pVar.rUy != null) {
                                pVar.rUy.stop();
                                pVar.rUy = null;
                                w.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                            }
                            if (pVar.rUx != null) {
                                pVar.rUx.ibh = true;
                                if (!pVar.fZK) {
                                    ap.vd().a(pVar.rUx, 0);
                                }
                                pVar.rUx = null;
                                w.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                                return;
                            }
                            return;
                        } else {
                            pVar.a(i, com_tencent_mm_protocal_c_bor);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }

        public final String getName() {
            return "LongConnectTask";
        }
    }

    private class c extends d {
        final /* synthetic */ WearMessageLogic rTV;

        public c(WearMessageLogic wearMessageLogic) {
            this.rTV = wearMessageLogic;
        }

        protected final void execute() {
            if (a.bvG().rTo.bvM() != null) {
                a.bvG().rTo.bvM().bvR();
            }
        }

        public final String getName() {
            return "RefreshConnectTask";
        }
    }

    public WearMessageLogic() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        ab.getContext().registerReceiver(this, intentFilter, "com.tencent.mm.wear.message", null);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i = extras.getInt("key_connecttype");
            if (i == 1) {
                Runnable aVar = new a(this);
                aVar.rTS = i;
                aVar.rTT = extras.getInt("key_funid");
                aVar.oWj = extras.getInt("key_sessionid");
                aVar.rTU = extras.getByteArray("key_data");
                com.tencent.mm.plugin.wear.model.e.a vN = a.bvG().rTm.vN(aVar.rTT);
                if (vN != null ? vN.vM(aVar.rTT) : false) {
                    af.v(aVar);
                } else {
                    e.post(aVar, "WearHttpMessageTask_" + aVar.rTT);
                }
            } else if (i == 2) {
                d bVar = new b(this);
                bVar.rTS = i;
                bVar.rTT = extras.getInt("key_funid");
                bVar.oWj = extras.getInt("key_sessionid");
                bVar.rTU = extras.getByteArray("key_data");
                a.bvG().rTu.a(bVar);
            } else if (i == 3) {
                a.bvG().rTu.a(new c(this));
            }
        }
    }
}
