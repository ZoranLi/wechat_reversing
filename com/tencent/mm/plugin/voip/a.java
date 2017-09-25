package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.a.rr.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.nio.ByteBuffer;

public final class a extends c<rr> {
    public a() {
        this.usg = rr.class.getName().hashCode();
    }

    private static boolean a(rr rrVar) {
        boolean z = true;
        if ((rrVar instanceof rr) && ap.zb()) {
            m bpd;
            Object obj;
            Object obj2;
            bla com_tencent_mm_protocal_c_bla;
            n nVar;
            switch (rrVar.fYI.fJK) {
                case 1:
                    d.bpd();
                    com.tencent.mm.plugin.voip.model.i.a HC = m.HC(rrVar.fYI.content);
                    if (HC != null) {
                        if (!HC.bpA()) {
                            if (HC.rhp != com.tencent.mm.plugin.voip.model.i.a.rhv) {
                                z = false;
                            }
                            if (z) {
                                rrVar.fYJ.type = 3;
                                break;
                            }
                        }
                        rrVar.fYJ.type = 2;
                        break;
                    }
                    break;
                case 2:
                    rrVar.fYJ.fYK = d.bpd().fyR;
                    break;
                case 3:
                    bpd = d.bpd();
                    obj = rrVar.fYI.fYC;
                    if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                        obj2 = new byte[(obj.length - 1)];
                        System.arraycopy(obj, 1, obj2, 0, obj2.length);
                        h hVar = bpd.riE.rew.rfQ.rlo;
                        hVar.rhj = System.currentTimeMillis();
                        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.VoipDailReport", "devin:recvInvite:" + hVar.rhj);
                        try {
                            bla com_tencent_mm_protocal_c_bla2 = (bla) new bla().aD(obj2);
                            w.d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
                            if (!bpd.riE.bqr()) {
                                g.oUh.a(11523, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla2.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla2.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla2.ukj), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                                bpd.a(com_tencent_mm_protocal_c_bla2);
                                break;
                            }
                            g.oUh.a(11523, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla2.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla2.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla2.ukj), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                            break;
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            break;
                        }
                    }
                case 4:
                    b bVar = rrVar.fYJ;
                    m bpd2 = d.bpd();
                    Context context = ab.getContext();
                    if (bpd2.fyR && bpd2.riP && !bpd2.riQ) {
                        w.d("MicroMsg.Voip.VoipService", "isVideoCalling " + bpd2.riG + " isAudioCalling " + bpd2.riH);
                        if (!bg.mA(bpd2.fJL)) {
                            ap.yY();
                            if (com.tencent.mm.u.c.wR().Rc(bpd2.fJL) != null) {
                                m.a(context, bpd2.fJL, true, bpd2.riG, true);
                                bVar.fYL = z;
                                break;
                            }
                        }
                    }
                    z = false;
                    bVar.fYL = z;
                case 5:
                    if (!com.tencent.mm.n.a.tQ()) {
                        if (rrVar.fYI.fYD != 2) {
                            if (rrVar.fYI.fYD != 3) {
                                if (rrVar.fYI.fYD == 4) {
                                    l.aC(rrVar.fYI.context, rrVar.fYI.fJL);
                                    break;
                                }
                            }
                            l.aB(rrVar.fYI.context, rrVar.fYI.fJL);
                            break;
                        }
                        l.aA(rrVar.fYI.context, rrVar.fYI.fJL);
                        break;
                    }
                    com.tencent.mm.ui.base.g.h(rrVar.fYI.context, R.l.eCb, R.l.dIO);
                    break;
                    break;
                case 6:
                    bpd = d.bpd();
                    byte[] bArr = rrVar.fYI.fYC;
                    if (bArr != null) {
                        w.d("MicroMsg.Voip.VoipService", "voipNotify with data size:" + bArr.length);
                        int i = ByteBuffer.wrap(bArr, 0, 4).getInt();
                        long j = ByteBuffer.wrap(bArr, 4, 8).getLong();
                        w.d("MicroMsg.Voip.VoipService", "voipNotify roomid:" + i + " roomkey:" + j);
                        if (bpd.riR == null) {
                            w.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[]{Integer.valueOf(bpd.riE.rew.rfQ.mNL), Integer.valueOf(i)});
                            if (i == 0 || r5.rew.rfQ.mNL != i) {
                                z = false;
                            }
                            if (!z) {
                                w.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                                break;
                            }
                        }
                        if (bArr.length > 12) {
                            bpd.a(m.y(bArr, bArr.length - 12), i, j);
                        }
                        n nVar2 = bpd.riE;
                        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sd() + " need doSync by notify, status:" + nVar2.rew.mStatus);
                        nVar2.rew.rfT.a(null, false, 7);
                        break;
                    }
                    w.d("MicroMsg.Voip.VoipService", "sidney:notify content null");
                    break;
                case 9:
                    bpd = d.bpd();
                    obj = rrVar.fYI.fYC;
                    if (!bg.bm(obj) && obj[0] == (byte) 3) {
                        try {
                            w.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            com_tencent_mm_protocal_c_bla = new bla();
                            com_tencent_mm_protocal_c_bla.aD(obj2);
                            bpd.uX(com_tencent_mm_protocal_c_bla.tvL);
                            if (!(bpd.riR == null || com_tencent_mm_protocal_c_bla.tvL != bpd.riR.tvL || bpd.nPx.bJq())) {
                                bpd.riR = null;
                                bpd.riS = 0;
                                bpd.nPx.KH();
                            }
                            nVar = bpd.riE;
                            w.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL)});
                            if (nVar.rew.rfV != null && com_tencent_mm_protocal_c_bla.tvL == nVar.rew.rfV.tvL) {
                                nVar.bqw();
                                nVar.rew.shutdown();
                                break;
                            }
                        } catch (Exception e2) {
                            w.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[]{e2.getMessage()});
                            break;
                        }
                    }
                case 10:
                    bpd = d.bpd();
                    obj = rrVar.fYI.fYC;
                    if (!bg.bm(obj) && obj[0] == (byte) 2) {
                        try {
                            w.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            com_tencent_mm_protocal_c_bla = new bla();
                            com_tencent_mm_protocal_c_bla.aD(obj2);
                            nVar = bpd.riE;
                            w.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL)});
                            if (com_tencent_mm_protocal_c_bla.tvL == nVar.rew.rfV.tvL) {
                                if (!nVar.rew.fSy) {
                                    w.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                                    nVar.bqw();
                                    nVar.rew.shutdown();
                                    break;
                                }
                                w.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                                break;
                            }
                        } catch (Exception e22) {
                            w.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[]{e22.getMessage()});
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
