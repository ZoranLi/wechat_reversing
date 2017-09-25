package com.tencent.mm.plugin.backup.c;

import android.os.Looper;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class e {
    public f jBp;
    public LinkedList<me> jEB;
    public String jEC;
    private String jED = "";
    private boolean jEE = false;
    public a jEF;
    public aj jEG = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ e jEJ;

        {
            this.jEJ = r1;
        }

        public final boolean oQ() {
            this.jEJ.aaR();
            this.jEJ.jEG.v(5000, 5000);
            return true;
        }
    }, true);
    final com.tencent.mm.y.e jEH = new com.tencent.mm.y.e(this) {
        final /* synthetic */ e jEJ;

        {
            this.jEJ = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            b.b(704, this.jEJ.jEH);
            w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.backup.d.b bVar = (com.tencent.mm.plugin.backup.d.b) kVar;
                eg egVar = (eg) bVar.gUA.hsk.hsr;
                b.aaD().jBm = "";
                b.aaD().jBn = egVar.tib;
                b.aaD().jBo = egVar.tic;
                b.aaD().jDy = egVar.thW;
                egVar = (eg) bVar.gUA.hsk.hsr;
                byte[] bArr = egVar == null ? null : egVar.thY == null ? null : egVar.thY.tZp.sYA;
                if (bArr != null) {
                    this.jEJ.jBp.jBu = 51;
                    this.jEJ.jEF.a(this.jEJ.jBp, bArr);
                    return;
                }
                return;
            }
            w.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:" + str);
            w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i2 == -100) {
                ap.vd().a(1000, this.jEJ.jEI);
                ap.vd().a(new com.tencent.mm.plugin.backup.d.a(this.jEJ.jEB, this.jEJ.jEC, b.aaD().jDy), 0);
                return;
            }
            this.jEJ.jBp.jBu = -11;
            this.jEJ.jEF.a(this.jEJ.jBp, null);
        }
    };
    final com.tencent.mm.y.e jEI = new com.tencent.mm.y.e(this) {
        final /* synthetic */ e jEJ;

        {
            this.jEJ = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            b.b(1000, this.jEJ.jEI);
            w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                ef efVar = ((j.b) ((com.tencent.mm.plugin.backup.d.a) kVar).htt.zg()).sZr;
                String str2 = "MicroMsg.BackupCreateQRCodeOfflineScene";
                String str3 = "onGYNetEnd QRCodeUrl:%s";
                Object[] objArr = new Object[1];
                objArr[0] = efVar == null ? "null" : efVar.thZ;
                w.i(str2, str3, objArr);
                byte[] bArr = efVar == null ? null : efVar.thY == null ? null : efVar.thY.tZp.sYA;
                if (bArr != null) {
                    this.jEJ.jBp.jBu = 51;
                    this.jEJ.jEF.a(this.jEJ.jBp, bArr);
                    return;
                }
                return;
            }
            w.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:" + str);
            this.jEJ.jBp.jBu = -11;
            this.jEJ.jEF.a(this.jEJ.jBp, null);
        }
    };

    public interface a {
        void a(f fVar, byte[] bArr);
    }

    public e(a aVar, f fVar) {
        this.jEF = aVar;
        this.jBp = fVar;
    }

    public final void start() {
        w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[]{Boolean.valueOf(this.jEE), Boolean.valueOf(this.jEG.bJq()), this, bg.bJZ()});
        if (!this.jEE) {
            this.jEE = true;
            if (aaS()) {
                this.jED = null;
                aaR();
            } else {
                this.jBp.jBu = -4;
                this.jEF.a(this.jBp, null);
            }
            this.jEG.v(500, 500);
        }
    }

    public final void stop() {
        w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
        this.jEE = false;
        ap.vd().b(704, this.jEH);
        ap.vd().b(1000, this.jEI);
        this.jEG.KH();
    }

    public final void aaR() {
        String bH = h.bH(ab.getContext());
        w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[]{bH, this.jED, Boolean.valueOf(ap.zb()), Boolean.valueOf(ap.uP())});
        if (!bH.equals(this.jED) && ap.zb()) {
            this.jED = bH;
            if (aaS()) {
                this.jEE = false;
                if (ap.uP()) {
                    w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
                    ap.vd().a(1000, this.jEI);
                    ap.vd().a(new com.tencent.mm.plugin.backup.d.a(this.jEB, this.jEC, b.aaD().jDy), 0);
                    return;
                }
                w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
                ap.vd().a(704, this.jEH);
                ap.vd().a(new com.tencent.mm.plugin.backup.d.b(this.jEB, this.jEC), 0);
                return;
            }
            this.jEE = false;
        }
    }

    private boolean aaS() {
        this.jEB = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        this.jEC = h.bH(ab.getContext());
        w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[]{this.jEC});
        if (bg.mA(this.jEC)) {
            this.jBp.jBu = -4;
            this.jEF.a(this.jBp, null);
            this.jED = "";
            return false;
        } else if (b.aaD().aaE().a(pString, pInt)) {
            w.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[]{pString.value, Integer.valueOf(pInt.value)});
            me meVar = new me();
            meVar.tsr = pString.value;
            meVar.tss = new LinkedList();
            meVar.tss.add(Integer.valueOf(pInt.value));
            this.jEB.add(meVar);
            return true;
        } else {
            this.jBp.jBu = -4;
            this.jEF.a(this.jBp, null);
            this.jED = "";
            return false;
        }
    }
}
