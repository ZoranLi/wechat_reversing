package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.protocal.c.azv;
import com.tencent.mm.protocal.c.azw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public final class h extends k implements j {
    private final b gUA;
    private e gUD;

    public h() {
        a aVar = new a();
        aVar.hsm = new azv();
        aVar.hsn = new azw();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        aVar.hsl = 906;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        azv com_tencent_mm_protocal_c_azv = (azv) this.gUA.hsj.hsr;
        ap.yY();
        com_tencent_mm_protocal_c_azv.ubf = ((Long) c.vr().get(w.a.uAO, Long.valueOf(0))).longValue();
    }

    public final int getType() {
        return 906;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(906), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            azw com_tencent_mm_protocal_c_azw = (azw) this.gUA.hsk.hsr;
            List<azu> list = com_tencent_mm_protocal_c_azw.hkm == null ? null : com_tencent_mm_protocal_c_azw.hkm;
            String str2 = "MicroMsg.NetSceneShareCardSync";
            String str3 = "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_azw.ubg);
            objArr[2] = Long.valueOf(com_tencent_mm_protocal_c_azw.ube);
            com.tencent.mm.sdk.platformtools.w.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                com.tencent.mm.plugin.card.sharecard.a.a agh = al.agh();
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (agh.hAl) {
                    agh.kcF.addAll(agh.kcG);
                    agh.kcG.clear();
                }
                agh.afv();
            } else {
                int i4 = 0;
                for (azu a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[]{Integer.valueOf(i4)});
                al.agh().afv();
            }
            ap.yY();
            c.vr().a(w.a.uAO, Long.valueOf(com_tencent_mm_protocal_c_azw.ube));
            al.agh().kgN = com_tencent_mm_protocal_c_azw.kgN;
            if (com_tencent_mm_protocal_c_azw.ubg > 0) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azw.ubg)});
                com.tencent.mm.plugin.card.sharecard.a.a agh2 = al.agh();
                agh2.mHandler.post(new Runnable(agh2) {
                    final /* synthetic */ a kgO;

                    {
                        this.kgO = r1;
                    }

                    public final void run() {
                        ap.vd().a(new h(), 0);
                    }
                });
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gUD.a(i2, i3, str, this);
    }

    private static boolean a(azu com_tencent_mm_protocal_c_azu) {
        if (com_tencent_mm_protocal_c_azu == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
            return false;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[]{com_tencent_mm_protocal_c_azu.fVl, Long.valueOf(com_tencent_mm_protocal_c_azu.ube)});
        try {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azu.kgV)});
            switch (com_tencent_mm_protocal_c_azu.kgV) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    com.tencent.mm.plugin.card.sharecard.a.a agh = al.agh();
                    if (com_tencent_mm_protocal_c_azu != null) {
                        long j;
                        ShareCardInfo sH = al.agi().sH(com_tencent_mm_protocal_c_azu.fVl);
                        String str = "MicroMsg.ShareCardBatchGetCardMgr";
                        String str2 = "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = com_tencent_mm_protocal_c_azu.fVl;
                        if (sH == null) {
                            j = 0;
                        } else {
                            j = sH.field_updateSeq;
                        }
                        objArr[1] = Long.valueOf(j);
                        objArr[2] = Long.valueOf(com_tencent_mm_protocal_c_azu.ube);
                        com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
                        if (sH != null && sH.field_updateSeq == com_tencent_mm_protocal_c_azu.ube) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
                            break;
                        }
                        com.tencent.mm.sdk.e.c b = n.b(com_tencent_mm_protocal_c_azu);
                        synchronized (agh.hAl) {
                            if (!agh.kcF.contains(b)) {
                                if (!agh.kcG.contains(b)) {
                                    agh.kcF.add(b);
                                    boolean b2 = al.agj().b(b);
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[]{Boolean.valueOf(b2)});
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
                    break;
                case 6:
                    com.tencent.mm.plugin.card.sharecard.a.a agh2 = al.agh();
                    if (com_tencent_mm_protocal_c_azu != null) {
                        com.tencent.mm.plugin.card.base.b sH2 = al.agi().sH(com_tencent_mm_protocal_c_azu.fVl);
                        al.agi().sG(com_tencent_mm_protocal_c_azu.fVl);
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + com_tencent_mm_protocal_c_azu.fVl);
                        if (sH2 != null) {
                            com.tencent.mm.plugin.card.sharecard.a.b.a(ab.getContext(), sH2);
                        } else {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                        }
                        agh2.adZ();
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azu.kgV)});
                    return false;
            }
            if (!(com_tencent_mm_protocal_c_azu.kgV == 0 || com_tencent_mm_protocal_c_azu.kgV == 5)) {
                ap.yY();
                String str3 = (String) c.vr().get(w.a.uAW, "");
                ap.yY();
                boolean booleanValue = ((Boolean) c.vr().get(w.a.uAX, Boolean.valueOf(false))).booleanValue();
                if (booleanValue && !TextUtils.isEmpty(str3) && str3.equals(com_tencent_mm_protocal_c_azu.fVl)) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                    com.tencent.mm.plugin.card.a.k.afO();
                } else if (booleanValue) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                } else {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneShareCardSync", "need check is false");
                }
            }
            return true;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
