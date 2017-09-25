package com.tencent.mm.aw;

import android.os.Message;
import com.tencent.mm.aw.g.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.n;
import com.tencent.mm.y.n.AnonymousClass4;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b extends a implements j {
    private int fEX = 0;
    private String filename = null;
    private e gUD;
    private int hTM = 0;
    private boolean ibh = false;
    private int icA = 120;
    g icB;
    private boolean icC = false;
    private boolean icD = false;
    private int icE = 0;
    private avx icF = null;
    private String[] icG = new String[0];
    private int icH = 3960;
    private ae icI = new ae(this, h.vL().nJF.getLooper()) {
        final /* synthetic */ b icK;

        public final void handleMessage(Message message) {
            if (message.what == 291 && this.icK.LK()) {
                h.vd().a(this.icK, 0);
            }
        }
    };

    public final void LG() {
        this.ibh = true;
    }

    public final String[] LH() {
        return this.icG;
    }

    public final long LI() {
        return 0;
    }

    public final Set<String> LJ() {
        g gVar = this.icB;
        Set<String> hashSet = new HashSet();
        gVar.ido.readLock().lock();
        for (a aVar : gVar.idn.values()) {
            if (aVar.idr) {
                hashSet.add(aVar.idq);
            }
        }
        gVar.ido.readLock().unlock();
        return hashSet;
    }

    public b(String str, String str2, String str3) {
        this.filename = str;
        this.icB = new g(str2);
        this.icF = new avx().OV(str3);
        w.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s", str, str2, str3);
    }

    public final boolean LK() {
        w.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.icI.removeMessages(291);
        if ((this.icB.LX() && this.ibh) || this.icC) {
            w.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
            return false;
        }
        a gT = this.icB.gT(this.hTM);
        if (gT != null) {
            int min = Math.min(com.tencent.mm.a.e.aN(this.filename), gT.idt);
            w.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", Integer.valueOf(r3), Integer.valueOf(gT.idt), Integer.valueOf(min));
            if (min <= 0) {
                w.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", this.filename);
                this.fEX = g.sb() + 40000;
                this.icE = 0;
                LL();
                this.gUD.a(3, -1, "ReadFileLengthError", null);
                return false;
            }
            this.icE = min - this.hTM;
            if (this.icE < 0) {
                w.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", Integer.valueOf(this.icE));
                this.fEX = g.sb() + 40000;
                this.icI.sendEmptyMessageDelayed(291, (long) (this.icA * 2));
                return false;
            }
            w.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", Integer.valueOf(this.icE), Integer.valueOf(gT.idu), Integer.valueOf(this.icA));
            if (this.icE >= 500 || gT.idu <= 5) {
                this.icI.sendEmptyMessageDelayed(291, (long) this.icA);
            } else {
                w.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", Integer.valueOf(this.icE));
                this.icI.sendEmptyMessageDelayed(291, (long) (this.icA * 2));
            }
            return true;
        }
        this.icI.sendEmptyMessageDelayed(291, (long) (this.icA * 2));
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bjs();
        aVar.hsn = new bju();
        aVar.uri = "/cgi-bin/micromsg-bin/voicetrans";
        aVar.hsl = 235;
        aVar.hso = 381;
        aVar.hsp = 1000000381;
        p BE = aVar.BE();
        BE.BG().sZx = false;
        bjs com_tencent_mm_protocal_c_bjs = (bjs) BE.hsj.hsr;
        a gT = this.icB.gT(this.hTM);
        if (gT == null) {
            com_tencent_mm_protocal_c_bjs.tsk = new avw();
            com_tencent_mm_protocal_c_bjs.tll = this.hTM;
            com_tencent_mm_protocal_c_bjs.ugY = "0";
            com_tencent_mm_protocal_c_bjs.tiL = 1;
            com_tencent_mm_protocal_c_bjs.uha = 2;
            com_tencent_mm_protocal_c_bjs.tlQ = 0;
            com_tencent_mm_protocal_c_bjs.ujg = this.icB.LV();
            com_tencent_mm_protocal_c_bjs.ujf = com_tencent_mm_protocal_c_bjs.ujg == null ? 0 : com_tencent_mm_protocal_c_bjs.ujg.size();
            com_tencent_mm_protocal_c_bjs.tYK = this.icF;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            Iterator it = com_tencent_mm_protocal_c_bjs.ujg.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((avx) it.next()).tZr).append(", ");
            }
            stringBuilder.append("]");
            w.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
            return a(eVar, BE, this);
        }
        int i;
        gT.idr = true;
        if (this.icD) {
            gT.ids = true;
            com_tencent_mm_protocal_c_bjs.tsk = new avw();
            w.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.icE > this.icH) {
                this.icE = this.icH;
                gT.ids = false;
            } else if (this.icE <= this.icH && (gT.idt != Integer.MAX_VALUE || this.ibh)) {
                gT.ids = true;
            }
            com_tencent_mm_protocal_c_bjs.tsk = new avw().bb(com.tencent.mm.a.e.c(this.filename, this.hTM, this.icE));
        }
        com_tencent_mm_protocal_c_bjs.tll = this.hTM;
        com_tencent_mm_protocal_c_bjs.ugY = gT.idq;
        if (gT.ids) {
            i = 1;
        } else {
            i = 0;
        }
        com_tencent_mm_protocal_c_bjs.tiL = i;
        com_tencent_mm_protocal_c_bjs.uha = 2;
        i = gT.idu + 1;
        gT.idu = i;
        com_tencent_mm_protocal_c_bjs.tlQ = i;
        com_tencent_mm_protocal_c_bjs.ujg = this.icB.LV();
        com_tencent_mm_protocal_c_bjs.ujf = com_tencent_mm_protocal_c_bjs.ujg == null ? 0 : com_tencent_mm_protocal_c_bjs.ujg.size();
        com_tencent_mm_protocal_c_bjs.tYK = this.icF;
        w.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s", g.sd(), this.filename, Integer.valueOf(gT.idt), Integer.valueOf(this.hTM), Integer.valueOf(this.icE), Integer.valueOf(com_tencent_mm_protocal_c_bjs.tsk.tZn), Boolean.valueOf(gT.ids), Integer.valueOf(com_tencent_mm_protocal_c_bjs.tlQ), com_tencent_mm_protocal_c_bjs.ujg, com_tencent_mm_protocal_c_bjs.tYK);
        this.hTM = com_tencent_mm_protocal_c_bjs.tsk.tZn + this.hTM;
        w.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", gT.idq, Integer.valueOf(this.hTM));
        if (gT.idu == 1) {
            w.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", Long.valueOf(System.currentTimeMillis()));
        }
        w.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", Long.valueOf(System.currentTimeMillis()));
        return a(eVar, BE, this);
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    }

    protected final void a(a aVar) {
        w.w("MicroMsg.NetSceneNewVoiceInput", g.sd() + " setSecurityCheckError e: %s", aVar);
        if (aVar == a.EReachMaxLimit) {
            LL();
            this.gUD.a(3, -1, "SecurityCheckError", this);
        }
    }

    protected final boolean BK() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", g.sd(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 3 && i3 == -1) {
            w.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", bg.bJZ(), Long.valueOf(Thread.currentThread().getId()));
        }
        bjs com_tencent_mm_protocal_c_bjs = (bjs) ((com.tencent.mm.y.b) pVar).hsj.hsr;
        bju com_tencent_mm_protocal_c_bju = (bju) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", com_tencent_mm_protocal_c_bjs.ugY, Integer.valueOf(com_tencent_mm_protocal_c_bjs.tlQ), Long.valueOf(System.currentTimeMillis()));
            this.icB.P(com_tencent_mm_protocal_c_bju.ujk);
            if (this.icB.LX() && this.ibh) {
                w.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                LM();
            }
            this.icG = new String[]{this.icB.LW()};
            this.gUD.a(i2, i3, str, this);
            this.icH = com_tencent_mm_protocal_c_bju.ujl <= 0 ? this.icH : com_tencent_mm_protocal_c_bju.ujl;
            this.icA = com_tencent_mm_protocal_c_bju.tXl < 0 ? 120 : com_tencent_mm_protocal_c_bju.tXl;
            w.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", Integer.valueOf(this.icH), Integer.valueOf(this.icA));
            return;
        }
        w.i("MicroMsg.NetSceneNewVoiceInput", g.sd() + " onGYNetEnd file: %s errType:%s errCode:%s", this.filename, Integer.valueOf(i2), Integer.valueOf(i3));
        LL();
        this.gUD.a(i2, i3, str, this);
    }

    public final void LL() {
        w.d("MicroMsg.NetSceneNewVoiceInput", g.sd());
        if (!this.icD) {
            this.icD = true;
            LM();
            n vd = h.vd();
            w.j("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(hashCode()));
            vd.hta.D(new AnonymousClass4(vd, r1));
            final a gT = this.icB.gT(this.hTM);
            if (gT != null) {
                this.icE = 0;
                h.vL().D(new Runnable(this) {
                    final /* synthetic */ b icK;

                    public final void run() {
                        w.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", gT.idq, Integer.valueOf(gT.idt), Integer.valueOf(this.icK.hashCode()));
                        h.vd().a(this.icK, 0);
                    }
                });
            }
        }
    }

    private void LM() {
        w.d("MicroMsg.NetSceneNewVoiceInput", g.sd());
        if (this.icI != null) {
            this.icI.removeMessages(291);
        }
        this.icC = true;
    }

    public final int getType() {
        return 235;
    }

    public final void gS(int i) {
        w.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", g.sd(), Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException();
        }
        this.icB.gS(i);
    }
}
