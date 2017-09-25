package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.e.a.cm;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.protocal.c.pa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    private c fEk;
    private final b gUA;
    private e gUD;
    private boolean kMR = true;

    public f(c cVar) {
        this.fEk = cVar;
        a aVar = new a();
        aVar.hsm = new oz();
        aVar.hsn = new pa();
        aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        aVar.hsl = 703;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        oz ozVar = (oz) this.gUA.hsj.hsr;
        bhh com_tencent_mm_protocal_c_bhh = new bhh();
        if (this.fEk != null) {
            h.amc().kLa.a(ab.getContext(), this.fEk);
            com_tencent_mm_protocal_c_bhh.tuy = this.fEk.EP();
            com_tencent_mm_protocal_c_bhh.tgJ = this.fEk.field_size;
            ozVar.tuF.add(com_tencent_mm_protocal_c_bhh);
        }
    }

    public final int getType() {
        return 703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        int i2 = -1;
        this.gUD = eVar2;
        bhh com_tencent_mm_protocal_c_bhh = (bhh) ((oz) this.gUA.hsj.hsr).tuF.get(0);
        int i3;
        Object a;
        byte[] bArr;
        Object obj;
        if (this.kMR) {
            w.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + com_tencent_mm_protocal_c_bhh.tuy);
            com_tencent_mm_protocal_c_bhh.tgK = 0;
            i3 = this.fEk.field_size + 0;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.fEk.field_reserved4 & c.uLn) == c.uLn) {
                a = com.tencent.mm.plugin.emoji.e.e.alz().a(this.fEk);
                if (bg.bm(a)) {
                    w.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    w.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                    System.arraycopy(a, 0, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.fEk.dP(0, i);
            }
            if (bArr == null || bArr.length <= 0) {
                w.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            com_tencent_mm_protocal_c_bhh.tgK = 0;
            com_tencent_mm_protocal_c_bhh.ugU = new com.tencent.mm.bd.b(bArr);
            String str = "MicroMsg.emoji.NetSceneEmojiUpload";
            String str2 = "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bArr.length);
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bhh.ugU.sYA.length);
            objArr[2] = Integer.valueOf(this.fEk == null ? -1 : this.fEk.field_start);
            if (this.fEk != null) {
                i2 = this.fEk.field_size;
            }
            objArr[3] = Integer.valueOf(i2);
            w.i(str, str2, objArr);
            return a(eVar, this.gUA, this);
        } else if (this.fEk == null || this.fEk.field_start == 0) {
            w.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            return -1;
        } else {
            i3 = this.fEk.field_size - this.fEk.field_start;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.fEk.field_reserved4 & c.uLn) == c.uLn) {
                a = com.tencent.mm.plugin.emoji.e.e.alz().a(this.fEk);
                if (bg.bm(a)) {
                    w.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    w.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                    System.arraycopy(a, this.fEk.field_start, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.fEk.dP(this.fEk.field_start, i);
            }
            if (bArr == null || bArr.length <= 0) {
                w.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            i3 = bArr.length;
            com_tencent_mm_protocal_c_bhh.tgK = this.fEk.field_start;
            com_tencent_mm_protocal_c_bhh.ugU = new com.tencent.mm.bd.b(bArr);
            w.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(com_tencent_mm_protocal_c_bhh.ugU.sYA.length)});
            w.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.fEk.field_start + ", total:" + this.fEk.field_size + ", len:" + i3);
            return a(eVar, this.gUA, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i2 + " errcode:" + i3);
        if (i2 == 0 && i3 == 0) {
            oz ozVar = (oz) ((b) pVar).hsj.hsr;
            pa paVar = (pa) ((b) pVar).hsk.hsr;
            if (ozVar.tuF.size() != paVar.tuF.size()) {
                w.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + ozVar.tuF.size() + ", resp size:" + paVar.tuF.size());
                amm();
                this.gUD.a(i2, i3, str, this);
                d(this.fEk, false);
                return;
            }
            bhi com_tencent_mm_protocal_c_bhi = null;
            if (paVar.tuF != null && paVar.tuF.size() > 0) {
                com_tencent_mm_protocal_c_bhi = (bhi) paVar.tuF.get(0);
            }
            String str2;
            if (com_tencent_mm_protocal_c_bhi == null || com_tencent_mm_protocal_c_bhi.tuy == null || !com_tencent_mm_protocal_c_bhi.tuy.equals(this.fEk.EP()) || com_tencent_mm_protocal_c_bhi.tgK < this.fEk.field_start) {
                int i4;
                String str3 = "MicroMsg.emoji.NetSceneEmojiUpload";
                str2 = "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d";
                Object[] objArr = new Object[5];
                objArr[0] = com_tencent_mm_protocal_c_bhi.tuy;
                objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bhi.tgJ);
                objArr[2] = Integer.valueOf(com_tencent_mm_protocal_c_bhi == null ? -1 : com_tencent_mm_protocal_c_bhi.tgK);
                if (this.fEk == null) {
                    i4 = -1;
                } else {
                    i4 = this.fEk.field_start;
                }
                objArr[3] = Integer.valueOf(i4);
                if (this.fEk == null) {
                    i4 = -1;
                } else {
                    i4 = this.fEk.field_size;
                }
                objArr[4] = Integer.valueOf(i4);
                w.e(str3, str2, objArr);
                amm();
                this.gUD.a(4, -2, "", this);
                d(this.fEk, false);
                return;
            } else if (com_tencent_mm_protocal_c_bhi != null && this.fEk != null && com_tencent_mm_protocal_c_bhi.thX != 0 && com_tencent_mm_protocal_c_bhi.tgK == com_tencent_mm_protocal_c_bhi.tgJ && com_tencent_mm_protocal_c_bhi.tgK > 0) {
                w.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[]{this.fEk.EP(), Integer.valueOf(com_tencent_mm_protocal_c_bhi.thX), Integer.valueOf(com_tencent_mm_protocal_c_bhi.tgK), Integer.valueOf(com_tencent_mm_protocal_c_bhi.tgJ)});
                amm();
                this.gUD.a(i2, i3, "", this);
                return;
            } else if (paVar.tZe.thX == 0 && (com_tencent_mm_protocal_c_bhi == null || com_tencent_mm_protocal_c_bhi.thX == 0)) {
                if (this.kMR) {
                    this.kMR = false;
                }
                if (com_tencent_mm_protocal_c_bhi.tgK >= com_tencent_mm_protocal_c_bhi.tgJ) {
                    this.fEk.field_start = 0;
                    this.fEk.field_state = c.uLg;
                    this.fEk.field_needupload = c.uLl;
                    h.amc().kLa.t(this.fEk);
                    this.gUD.a(i2, i3, "", this);
                    d(this.fEk, true);
                    w.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    return;
                }
                w.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bhi.tgK)});
                this.fEk.field_start = com_tencent_mm_protocal_c_bhi.tgK;
                h.amc().kLa.t(this.fEk);
                if (a(this.hsD, this.gUD) < 0) {
                    this.gUD.a(3, -1, "", this);
                    d(this.fEk, false);
                    return;
                }
                return;
            } else {
                str2 = "MicroMsg.emoji.NetSceneEmojiUpload";
                String str4 = "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(paVar.tZe.thX);
                objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_bhi == null ? -1 : com_tencent_mm_protocal_c_bhi.thX);
                w.e(str2, str4, objArr2);
                amm();
                this.gUD.a(i2, i3, "", this);
                return;
            }
        }
        amm();
        this.gUD.a(i2, i3, str, this);
        d(this.fEk, false);
    }

    protected final int ub() {
        return 256;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    private void amm() {
        this.fEk.field_start = 0;
        h.amc().kLa.t(this.fEk);
    }

    private static void d(c cVar, boolean z) {
        if (cVar != null && !bg.mA(cVar.EP())) {
            w.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[]{cVar.EP(), Boolean.valueOf(z)});
            com.tencent.mm.sdk.b.b cmVar = new cm();
            cmVar.fFV.fFW = cVar.EP();
            cmVar.fFV.fEG = 0;
            cmVar.fFV.success = z;
            com.tencent.mm.sdk.b.a.urY.m(cmVar);
        }
    }
}
