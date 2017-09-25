package com.tencent.mm.plugin.emoji.g;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.bd.b;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a implements com.tencent.mm.u.bp.a {
    public final void a(com.tencent.mm.y.d.a aVar) {
        bu buVar = aVar.hst;
        if (buVar.mtd == CdnLogic.MediaType_FAVORITE_VIDEO) {
            String a = n.a(buVar.tff);
            if (bg.mA(a)) {
                w.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q != null && q.size() > 0) {
                String str = (String) q.get(".sysmsg.$type");
                String bo = bg.bo(b.aU(p.rB().getBytes()).xV(16).sYA);
                int intValue;
                if (!bg.mA(str) && str.equalsIgnoreCase("EmojiBackup")) {
                    intValue = Integer.valueOf((String) q.get(".sysmsg.EmojiBackup.OpCode")).intValue();
                    str = (String) q.get(".sysmsg.EmojiBackup.DeviceID");
                    w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[]{bo, str});
                    if (bg.mA(str) || !str.equalsIgnoreCase(bo)) {
                        ArrayList ux = b.ux(a);
                        if (intValue == 1) {
                            if (ux == null || ux.size() <= 0) {
                                w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[]{Integer.valueOf(ux.size())});
                            ArrayList arrayList = new ArrayList();
                            int size = ux.size();
                            for (int i = 0; i < size; i++) {
                                ov ovVar = (ov) ux.get(i);
                                if (ovVar != null) {
                                    c Si = h.amc().kLa.Si(ovVar.tup);
                                    if (Si != null && Si.bNr() && Si.field_catalog == c.uKY) {
                                        w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "md5:%s not need to download", new Object[]{ovVar.tup});
                                    } else {
                                        arrayList.add(new com.tencent.mm.plugin.emoji.sync.a.a(ovVar.tup, ovVar.msN, ovVar.ohq, ovVar.tuq, ovVar.tur, ovVar.tus, ovVar.tgW, ovVar.tuv));
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                h.alZ().v(arrayList);
                                h.alZ().kNA.amx();
                            }
                        } else if (intValue == 2) {
                            if (ux == null || ux.size() <= 0) {
                                w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            List arrayList2 = new ArrayList();
                            if (ux != null && ux.size() > 0) {
                                Iterator it = ux.iterator();
                                while (it.hasNext()) {
                                    ov ovVar2 = (ov) it.next();
                                    if (ovVar2 != null) {
                                        arrayList2.add(ovVar2.tup);
                                    }
                                }
                            }
                            h.amc().kLa.co(arrayList2);
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzD, Boolean.valueOf(false));
                        } else if (intValue == 3) {
                            w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzO, Long.valueOf(0));
                        }
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzL, Boolean.valueOf(true));
                        return;
                    }
                    w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                } else if (bg.mA(str) || !str.equalsIgnoreCase("EmotionBackup")) {
                    w.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                } else {
                    intValue = Integer.valueOf((String) q.get(".sysmsg.EmotionBackup.OpCode")).intValue();
                    str = (String) q.get(".sysmsg.EmotionBackup.DeviceID");
                    if (bg.mA(str) || !str.equalsIgnoreCase(bo)) {
                        ArrayList uy = b.uy(a);
                        if (uy == null || uy.size() <= 0) {
                            w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            return;
                        } else if (intValue == 1) {
                            w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[]{Integer.valueOf(uy.size())});
                            ArrayList arrayList3 = new ArrayList();
                            intValue = uy.size();
                            for (int i2 = 0; i2 < intValue; i2++) {
                                arrayList3.add(new com.tencent.mm.plugin.emoji.sync.a.b((String) uy.get(i2)));
                            }
                            h.alZ().w(arrayList3);
                            h.alZ().kNA.amx();
                            return;
                        } else if (intValue == 2) {
                            w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[]{Integer.valueOf(uy.size())});
                            h.amc().kLb.ag(uy);
                            return;
                        } else {
                            return;
                        }
                    }
                    w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                }
            }
            return;
        }
        w.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(buVar.mtd)});
    }
}
