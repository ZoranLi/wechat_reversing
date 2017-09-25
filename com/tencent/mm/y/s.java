package com.tencent.mm.y;

import android.os.Looper;
import com.tencent.mm.network.i;
import com.tencent.mm.network.p;
import com.tencent.mm.network.q.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.aq;

public final class s extends a {
    ae handler;
    g htG;
    h htH;
    private p htt;

    public s(p pVar) {
        this(pVar, Looper.myLooper() == null ? new ae(Looper.getMainLooper()) : new ae());
    }

    public s(p pVar, ae aeVar) {
        this.htt = pVar;
        this.htG = new r(pVar.BG(), pVar.getType());
        this.htH = new t(pVar.zg(), pVar.getType());
        this.handler = aeVar;
    }

    public final boolean BH() {
        return this.htt.BH();
    }

    public final int BM() {
        return this.htt.hashCode();
    }

    public final int BD() {
        return this.htt.BD();
    }

    public final g Cm() {
        return this.htG;
    }

    public final h Cn() {
        return this.htH;
    }

    public final int getType() {
        return this.htt.getType();
    }

    public final String getUri() {
        return this.htt.getUri();
    }

    public final void hz(String str) {
    }

    public final void a(i iVar, final int i, final int i2, final String str) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s htI;

            public final void run() {
                w.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(this.htI.htt.getType()), bg.bJZ());
                f fVar = (f) this.htI.htt.BG();
                com.tencent.mm.protocal.i.g gVar = (com.tencent.mm.protocal.i.g) this.htI.htt.zg();
                if (gVar == null) {
                    w.f("MicroMsg.RemoteReqResp", "null auth.resp");
                } else {
                    c.a.sZi.a(fVar, gVar, i, i2, str);
                }
            }
        });
    }

    public final void a(final i iVar, final int i, final int i2) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s htI;

            public final void run() {
                int i;
                int i2 = aq.ze().getInt("key_auth_update_version", 0);
                int i3 = i2 <= 637665332 ? 701 : 702;
                if (i2 == 0) {
                    if (bg.mA(ab.getContext().getSharedPreferences("ticket_prefs", 4).getString("_auth_ticket", ""))) {
                        w.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
                        com.tencent.mm.plugin.report.c.oTb.a(148, 50, 1, true);
                        i3 = 702;
                    } else {
                        com.tencent.mm.plugin.report.c.oTb.a(148, 49, 1, true);
                        w.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", bg.Qj(r13.getString("_auth_ticket", "")));
                    }
                }
                w.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(d.sYN), Integer.valueOf(637665332), Integer.valueOf(i3));
                if (i3 == 701) {
                    com.tencent.mm.plugin.report.c.oTb.a(148, 48, 1, true);
                }
                if ((this.htI.htt.getType() == 702 || this.htI.htt.getType() == 701) && ((com.tencent.mm.protocal.i.g) this.htI.htt.zg()).sZo == 2) {
                    i = 1;
                } else {
                    i = 0;
                }
                w.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(this.htI.htt.getType()), Integer.valueOf(i3), Integer.valueOf(i));
                p aI = c.a.sZi.aI(i3, i);
                try {
                    iVar.a(aI == null ? null : new s(aI, this.htI.handler), i, i2, "");
                } catch (Throwable e) {
                    w.e("MicroMsg.RemoteReqResp", "exception:%s", bg.g(e));
                }
            }
        });
    }

    public final void a(com.tencent.mm.network.d dVar, final i iVar, final int i, final int i2) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s htI;

            public final void run() {
                try {
                    iVar.a(new s(new j(), this.htI.handler), i, i2, "");
                } catch (Throwable e) {
                    w.e("MicroMsg.RemoteReqResp", "exception:%s", bg.g(e));
                }
            }
        });
    }

    public final int Co() {
        int i = -1;
        w.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(getType()));
        switch (getType()) {
            case 126:
                p pVar = this.htt;
                y.a aVar = (y.a) pVar.BG();
                b bVar = (b) pVar.zg();
                w.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(126), bg.bJZ());
                if (bVar.sZo != 0) {
                    w.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(bVar.sZo));
                } else {
                    axk com_tencent_mm_protocal_c_axk = bVar.taf.tSL;
                    if (com_tencent_mm_protocal_c_axk != null) {
                        int i2 = com_tencent_mm_protocal_c_axk.tht;
                        os osVar = com_tencent_mm_protocal_c_axk.thd;
                        byte[] a = n.a(com_tencent_mm_protocal_c_axk.the);
                        String str = "MicroMsg.MMReqRespReg2";
                        String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(osVar.thF.tZn);
                        objArr[1] = Integer.valueOf(osVar.tuk);
                        objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
                        objArr[3] = bg.Qj(bg.bl(a));
                        w.d(str, str2, objArr);
                        byte[] a2 = n.a(osVar.thF);
                        byte[] bArr = aVar.sZl;
                        byte[] bArr2 = null;
                        if (bg.bm(a2)) {
                            w.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        } else {
                            String str3 = "MicroMsg.MMReqRespReg2";
                            String str4 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a2.length);
                            objArr2[1] = bg.Qj(bg.bl(a2));
                            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr2[3] = bg.Qj(bg.bl(bArr));
                            w.d(str3, str4, objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(osVar.tuk, a2, bArr, pByteArray, 0);
                            bArr2 = pByteArray.value;
                            str = "MicroMsg.MMReqRespReg2";
                            str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                            objArr[1] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr[2] = bg.Qj(bg.bl(bArr2));
                            w.i(str, str2, objArr);
                        }
                        bVar.sZn = bArr2 != null ? bArr2 : new byte[0];
                        if ((i2 & 4) != 0) {
                            w.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (bg.bm(bArr2)) {
                                w.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                bVar.aW(new byte[0]);
                                bVar.sZo = 2;
                            } else {
                                bArr2 = MMProtocalJni.aesDecrypt(a, bArr2);
                                String str5 = "MicroMsg.MMReqRespReg2";
                                String str6 = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                                Object[] objArr3 = new Object[4];
                                objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                                objArr3[1] = bg.bl(a);
                                if (bArr2 != null) {
                                    i = bArr2.length;
                                }
                                objArr3[2] = Integer.valueOf(i);
                                objArr3[3] = bg.Qj(bg.bl(bArr2));
                                w.d(str5, str6, objArr3);
                                if (bg.bm(bArr2)) {
                                    w.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    bVar.aW(new byte[0]);
                                    bVar.sZo = 2;
                                } else {
                                    w.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", bg.Qj(bg.bl(bArr2)));
                                    bVar.aW(bArr2);
                                    bVar.sZo = 1;
                                }
                            }
                        } else {
                            w.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            bVar.aW(a);
                            bVar.sZo = 1;
                        }
                    } else {
                        w.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        bVar.aW(new byte[0]);
                        bVar.sZo = 2;
                    }
                }
                return bVar.sZo;
            case 701:
            case 702:
                return aq.b(this.htt);
            default:
                return -1;
        }
    }
}
