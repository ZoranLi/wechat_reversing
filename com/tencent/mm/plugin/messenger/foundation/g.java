package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.bd.a;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.bg;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class g implements p {
    public final void a(lu luVar, byte[] bArr, boolean z, r rVar) {
        switch (luVar.tsa) {
            case 1:
                x xVar;
                a aVar = (amw) new amw().aD(bArr);
                int i = aVar.tRr;
                h.vI().vr().get(2, null);
                t vr = h.vI().vr();
                w.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", Integer.valueOf(aVar.tRr), Integer.valueOf(aVar.jNB), Integer.valueOf(aVar.tdB), Integer.valueOf(aVar.tRy));
                String a = n.a(aVar.ttp);
                String a2 = n.a(aVar.tLj);
                String a3 = n.a(aVar.tRs);
                String a4 = n.a(aVar.tRt);
                int i2 = aVar.tdy;
                af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(a);
                if (Rc == null || Rc.field_username == null || !Rc.field_username.equals(a)) {
                    xVar = new x(a);
                } else {
                    af afVar = Rc;
                }
                xVar.bO(aVar.hAI);
                xVar.bR(a2);
                xVar.ck(RegionCodeDecoder.ab(aVar.hAM, aVar.hAE, aVar.hAF));
                xVar.di(aVar.hAD);
                xVar.ce(aVar.hAG);
                xVar.dd(aVar.tMT);
                xVar.ci(aVar.tMR);
                xVar.bU(aVar.tMS);
                xVar.dj(i2);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Q(xVar);
                vr.set(2, a);
                vr.set(4, a2);
                vr.set(5, a3);
                vr.set(6, a4);
                vr.set(9, Integer.valueOf(i2));
                String str = "MicroMsg.UserInfoSyncExtension";
                StringBuilder stringBuilder = new StringBuilder("doCmd : status ");
                int i3 = aVar.jNB;
                String str2 = "code=" + Integer.toHexString(i3) + ", status = " + i3;
                if ((i3 & 1) != 0) {
                    str2 = str2 + ", open";
                }
                if ((i3 & 2) != 0) {
                    str2 = str2 + ", email-verified";
                }
                if ((i3 & 4) != 0) {
                    str2 = str2 + ", mobile-verified";
                }
                if ((i3 & 8) != 0) {
                    str2 = str2 + ", hide-qq-search";
                }
                if ((i3 & 16) != 0) {
                    str2 = str2 + ", hide-qq-promote";
                }
                if ((i3 & 32) != 0) {
                    str2 = str2 + ", need-verify";
                }
                if ((i3 & 64) != 0) {
                    str2 = str2 + ", has-qq-msg";
                }
                if ((i3 & FileUtils.S_IWUSR) != 0) {
                    str2 = str2 + ", no-qq-promote";
                }
                if ((i3 & 256) != 0) {
                    str2 = str2 + ", no-mobile-promote";
                }
                if ((i3 & 512) != 0) {
                    str2 = str2 + ", hide-mobile_search";
                }
                if ((i3 & Downloads.RECV_BUFFER_SIZE) != 0) {
                    str2 = str2 + ", open-float-bottle";
                }
                if ((i3 & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    str2 = str2 + ", bind but not upload";
                }
                w.d(str, stringBuilder.append(str2).toString());
                vr.set(7, Integer.valueOf(aVar.jNB));
                if (aVar.hAH != 0) {
                    bg bgVar = new bg();
                    bgVar.gkA = 1;
                    bgVar.gkr = aVar.hAD;
                    bgVar.signature = aVar.hAG;
                    bgVar.countryCode = aVar.hAM;
                    bgVar.hnP = aVar.hAE;
                    bgVar.hnO = aVar.hAF;
                    bgVar.gkF = aVar.tMR;
                    w.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + bgVar.gkF + " nickName :" + aVar.tMS);
                    bg.a(bgVar);
                }
                str = "MicroMsg.UserInfoSyncExtension";
                stringBuilder = new StringBuilder("userinfo Plugstate: ");
                i3 = aVar.tdB;
                str2 = "code=" + Integer.toHexString(i3) + ", pluginFlag = " + i3;
                str2 = (i3 & 1) != 0 ? str2 + ", QQMAIL_UNINSTALL" : str2 + ", QQMAIL_INSTALL";
                str2 = (i3 & 2) != 0 ? str2 + ", PM_UNINSTALL" : str2 + ", PM_INSTALL";
                str2 = (i3 & 4) != 0 ? str2 + ", FM_UNINSTALL" : str2 + ", FM_INSTALL";
                str2 = (i3 & 8) != 0 ? str2 + ", WEIBO_UNINSTALL" : str2 + ", WEIBO_INSTALL";
                str2 = (i3 & 16) != 0 ? str2 + ", MEDIANOTE_UNINSTALL" : str2 + ", MEDIANOTE_INSTALL";
                str2 = (i3 & 32) != 0 ? str2 + ", QMSG_UNINSTALL" : str2 + ", QMSG_INSTALL";
                str2 = (i3 & 64) != 0 ? str2 + ", BOTTLE_UNINSTALL" : str2 + ", BOTTLE_INSTALL";
                str2 = (i3 & FileUtils.S_IWUSR) != 0 ? str2 + ", QSYNC_UNISTALL" : str2 + ", QSYNC_INSTALL";
                str2 = (i3 & 256) != 0 ? str2 + ", SHAKE_UNISTALL" : str2 + ", SHAKE_INSTALL";
                str2 = (i3 & 512) != 0 ? str2 + ", LBS_UNISTALL" : str2 + ", LBS_INSTALL";
                str2 = (i3 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? str2 + ", BOTTLE_CHART_INSTALL" : str2 + ", BOTTLE_CHART_INSTALL";
                str2 = (i3 & Downloads.RECV_BUFFER_SIZE) != 0 ? str2 + ",CHECKQQF_UNINSTALL" : str2 + ",CHECKQQF_INSTALL";
                w.i(str, stringBuilder.append((i3 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? str2 + ",MM_FEEDSAPP_UNINSTALL" : str2 + ",MM_FEEDSAPP_INSTALL").toString());
                vr.set(34, Integer.valueOf(aVar.tdB));
                vr.set(8200, Boolean.valueOf(com.tencent.mm.sdk.platformtools.bg.b(Boolean.valueOf(1 == aVar.tRb.ttL), false)));
                vr.set(8201, Integer.valueOf(com.tencent.mm.sdk.platformtools.bg.a(Integer.valueOf(aVar.tRb.ttM.ttP), 22)));
                vr.set(8208, Integer.valueOf(com.tencent.mm.sdk.platformtools.bg.a(Integer.valueOf(aVar.tRb.ttM.ttQ), 8)));
                vr.set(66049, Integer.valueOf(aVar.tMP));
                vr.set(66050, aVar.tMQ);
                vr.set(40, Integer.valueOf(aVar.tRy));
                ao.hlW.L("last_login_use_voice", aVar.tRy);
                vr.set(41, Integer.valueOf(aVar.tMT));
                vr.set(43, aVar.tMS);
                w.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + aVar.tRy + " WeiboFlag:" + aVar.tMT);
                vr.set(868518889, Integer.valueOf(aVar.tRn));
                w.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + aVar.tRn);
                vr.set(42, aVar.hAI);
                w.d("MicroMsg.UserInfoSyncExtension", "userid:" + aVar.twD + " username:" + aVar.twE);
                vr.set(65825, aVar.twD);
                vr.set(65826, aVar.twE);
                w.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + aVar.hAJ);
                w.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + aVar.hAK);
                w.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + aVar.hAL);
                str2 = com.tencent.mm.sdk.platformtools.bg.mz((String) h.vI().vr().get(65830, null));
                if (str2 == null || str2.length() == 0) {
                    str2 = aVar.tRB;
                    if (str2 != null && str2.length() > 0) {
                        h.vI().vr().set(65830, str2);
                    }
                }
                s.a(1, aVar);
                return;
            default:
                return;
        }
    }
}
