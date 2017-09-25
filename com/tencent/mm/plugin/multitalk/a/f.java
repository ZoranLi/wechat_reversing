package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.google.a.a.e;
import com.tencent.mm.R;
import com.tencent.mm.al.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.y.d.a;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.ay;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private Map<String, Long> nPG = new ConcurrentHashMap();

    final void a(String str, a aVar) {
        String a = n.a(aVar.hst.tff);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a + " buffer len " + decode.length);
        try {
            ay ayVar = (ay) e.a(new ay(), decode, decode.length);
            if (ayVar == null) {
                w.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:" + a);
            } else if (this.nPG.get(ayVar.groupId) == null || ((Long) this.nPG.get(ayVar.groupId)).longValue() < ayVar.wOP) {
                this.nPG.put(ayVar.groupId, Long.valueOf(ayVar.wOP));
                bu buVar = aVar.hst;
                String a2 = n.a(buVar.tfd);
                String a3 = n.a(buVar.tfe);
                ap.yY();
                String str2 = (String) c.vr().get(2, null);
                if (str2 == null) {
                    w.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    return;
                }
                String str3 = str2.equals(a2) ? a3 : a2;
                String str4 = ayVar.wON;
                Object obj;
                String str5;
                Object obj2;
                if (ayVar.wOM == 1) {
                    w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = ayVar.wOO;
                    obj = null;
                    str5 = "";
                    for (as asVar : ayVar.wMX) {
                        str5 = str5 + asVar.wNl + ",";
                        if (asVar.wNl != null && asVar.wNl.equals(str2)) {
                            w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str6 : strArr) {
                        if (str6 != null && str6.equals(str2)) {
                            w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        o.aNp().Bi(str3);
                        o.aNp().aMZ().remove(str3);
                    } else if (!(o.aNp().aMZ().contains(str3) || r5 == null)) {
                        o.aNp().aMZ().add(str3);
                    }
                    if (str2.equals(str4)) {
                        o.aNn().b(str3, str4, false, false);
                    } else if (obj != null && r5 == null) {
                        o.aNn().b(str3, str4, false, false);
                    } else if (obj == null || r5 == null) {
                        o.aNn().b(str3, str4, true, false);
                    } else {
                        o.aNn().b(str3, str4, true, true);
                    }
                    o.aNp().a(str3, ayVar);
                    o.aNm().nOT.aK(bg.f((Integer) ap.yW().get(1)), m.xL());
                } else if (ayVar.wOM == 2) {
                    w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + ayVar.wMX.length);
                    String[] strArr2 = ayVar.wOO;
                    obj = null;
                    str5 = "";
                    for (as asVar2 : ayVar.wMX) {
                        str5 = str5 + asVar2.wNl + ",";
                        if (asVar2.wNl != null && asVar2.wNl.equals(str2)) {
                            w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str7 : strArr2) {
                        if (str7 != null && str7.equals(str2)) {
                            w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        if (!o.aNp().Bj(str3) && o.aNp().aMZ().contains(str3) && o.aNp().cS(str3, str2)) {
                            o.aNn();
                            e.AX(str3);
                        }
                        o.aNp().Bi(str3);
                        o.aNp().aMZ().remove(str3);
                    } else if (!(o.aNp().aMZ().contains(str3) || r5 == null)) {
                        o.aNp().aMZ().add(str3);
                    }
                    g aNp = o.aNp();
                    w.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[]{str3});
                    b Bl = o.aNj().Bl(str3);
                    if (Bl == null) {
                        w.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        aNp.a(str3, ayVar);
                    } else if (Bl.field_roomId != ayVar.rhn) {
                        w.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + Bl.field_roomId + "bannerinfo.roomid:" + ayVar.rhn);
                    } else if (g.c(str3, ayVar)) {
                        aNp.Bk(str3);
                    } else {
                        w.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                    }
                } else if (ayVar.wOM == 0) {
                    w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!o.aNp().Bj(str3) && o.aNp().aMZ().contains(str3) && o.aNp().cS(str3, str2)) {
                        o.aNn();
                        e.AX(str3);
                    }
                    e aNn = o.aNn();
                    ce auVar = new au();
                    auVar.setType(64);
                    auVar.z(System.currentTimeMillis());
                    auVar.dv(6);
                    auVar.setContent(ab.getContext().getString(R.l.eCr));
                    if (j.eu(str3)) {
                        auVar.cH(str3);
                        auVar.setContent(auVar.field_content);
                        ap.yY();
                        c.wT().L(auVar);
                    }
                    if (!(aNn.nPv == null || !str3.equals(aNn.nPv.wPh) || aNn.nPx.bJq())) {
                        w.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
                        aNn.nPv = null;
                        aNn.nPw = 0;
                        aNn.nPx.KH();
                    }
                    o.aNp().Bh(str3);
                    o.aNp().Bi(str3);
                    o.aNp().aMZ().remove(str3);
                } else if (ayVar.wOM == 3) {
                    for (as asVar3 : ayVar.wMX) {
                        if (asVar3.wNl != null && asVar3.wNl.equals(str2)) {
                            w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                } else {
                    w.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + ayVar.wOM);
                }
            } else {
                w.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + ayVar.groupId + " is early than last msg, so we do not process,now return.");
            }
        } catch (Exception e) {
            w.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:" + a, new Object[]{e.getMessage()});
        }
    }
}
