package com.tencent.mm.u;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.lr;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.i.g;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.p.i;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.b;
import com.tencent.mm.y.d.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class f implements l {
    private long hlg = -1;
    public a hlh;

    public interface a {
        void br(String str);
    }

    public final b a(String str, Map<String, String> map, com.tencent.mm.y.d.a aVar) {
        String str2;
        String str3;
        String str4;
        int i;
        ae Rm;
        String str5;
        au auVar;
        int i2;
        int i3;
        String str6;
        int i4;
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_aij;
        int i5;
        bu buVar = aVar.hst;
        String a = n.a(buVar.tff);
        b bVar = null;
        if (str != null) {
            if (str.equals("addcontact")) {
                buVar.tff = n.mw((String) map.get(".sysmsg.addcontact.content"));
                buVar.mtd = 1;
                d aB = c.aB(Integer.valueOf(1));
                bVar = aB == null ? null : aB.b(aVar);
            }
        }
        if (str != null) {
            if (str.equals("dynacfg")) {
                g.sV().a(a, map, false);
                g.sW();
                if (com.tencent.mm.i.c.sF() == 2) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(10879, "");
                }
                w.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(bg.getInt(g.sV().getValue("MuteRoomDisable"), 0)));
            }
        }
        if (str != null) {
            if (str.equals("dynacfg_split")) {
                g.sV().a(a, map, true);
            }
        }
        if (str != null) {
            if (str.equals("banner")) {
                str2 = (String) map.get(".sysmsg.mainframebanner.$type");
                str3 = (String) map.get(".sysmsg.mainframebanner.showtype");
                str4 = (String) map.get(".sysmsg.mainframebanner.data");
                if (str2 != null && str2.length() > 0) {
                    try {
                        ax.zj().a(new aw(Integer.valueOf(str2).intValue(), Integer.valueOf(str3).intValue(), str4));
                    } catch (Exception e) {
                        w.e("MicroMsg.BigBallSysCmdMsgConsumer", e.toString());
                    }
                }
                str3 = (String) map.get(".sysmsg.friendrecommand.touser");
                if (!(((String) map.get(".sysmsg.friendrecommand.fromuser")) == null || str3 == null)) {
                    try {
                        ap.yY().xy().a(str3, true, null);
                    } catch (Exception e2) {
                        w.e("MicroMsg.BigBallSysCmdMsgConsumer", e2.toString());
                    }
                }
                str2 = (String) map.get(".sysmsg.banner.securitybanner.chatname");
                str3 = (String) map.get(".sysmsg.banner.securitybanner.wording");
                str4 = (String) map.get(".sysmsg.banner.securitybanner.showtype");
                if (!(bg.mA(str2) || bg.mA(str4))) {
                    try {
                        boolean z;
                        if (str4.equals("1")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ap.yY().xz().a(str2, z, new String[]{str3});
                    } catch (Exception e22) {
                        w.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + e22.toString());
                    }
                }
                ap.yY().xA().k(map);
            }
        }
        if (!bg.mA(str)) {
            if (str.equals("midinfo")) {
                str2 = (String) map.get(".sysmsg.midinfo.json_buffer");
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", (String) map.get(".sysmsg.midinfo.time_interval"), str2, a);
                i = bg.getInt(str3, 0);
                if (((long) i) > 86400 && ((long) i) < 864000) {
                    ap.yY();
                    c.vr().set(331777, Long.valueOf(bg.Ny() + ((long) i)));
                }
                if (!bg.mA(str2)) {
                    com.tencent.mm.plugin.report.b.d.Dz(str2);
                }
            }
        }
        if (str != null) {
            if (str.equals("revokemsg")) {
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                str2 = (String) map.get(".sysmsg.revokemsg.session");
                str4 = (String) map.get(".sysmsg.revokemsg.replacemsg");
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", (String) map.get(".sysmsg.revokemsg.newmsgid"), str4);
                long j = 0;
                try {
                    j = bg.getLong((String) map.get(".sysmsg.revokemsg.newmsgid"), 0);
                    ap.yY();
                    au x = c.wT().x(str2, j);
                    au Y = au.Y(x);
                    x.setContent(str4);
                    x.setType(10000);
                    ay.a(x, aVar);
                    ap.yY();
                    c.wT().a(x.field_msgId, x);
                    ap.yY();
                    Rm = c.wW().Rm(x.field_talker);
                    if (Rm != null && Rm.field_unReadCount > 0) {
                        ap.yY();
                        if (Rm.field_unReadCount >= c.wT().K(x)) {
                            Rm.dt(Rm.field_unReadCount - 1);
                            ap.yY();
                            c.wW().a(Rm, Rm.field_username);
                        }
                    }
                    if (aVar != null && aVar.hsu) {
                        com.tencent.mm.sdk.e.c aoVar = new ao();
                        aoVar.field_originSvrId = j;
                        if (x.field_msgId == 0) {
                            w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", Long.valueOf(j));
                            aoVar.field_content = a;
                            aoVar.field_createTime = (long) buVar.ogM;
                            aoVar.field_flag = ay.c(aVar);
                            aoVar.field_fromUserName = n.a(buVar.tfd);
                            aoVar.field_toUserName = n.a(buVar.tfe);
                            aoVar.field_newMsgId = buVar.tfk;
                            w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", Boolean.valueOf(ap.yY().xD().b(aoVar)), Long.valueOf(aoVar.uxb));
                            return null;
                        }
                        w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info,  originSvrId[%d]", Long.valueOf(j));
                        ap.yY().xD().b(aoVar, true, new String[0]);
                        ap.yY();
                        c.wT().cE(j);
                    }
                    if (x.field_msgId == 0 && (aVar == null || !aVar.hsu)) {
                        w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", Long.valueOf(j));
                        ap.yY();
                        c.wT().cE(j);
                    }
                    com.tencent.mm.sdk.b.b ndVar = new nd();
                    ndVar.fUm.fGM = x.field_msgId;
                    ndVar.fUm.fUn = str4;
                    ndVar.fUm.fTk = x;
                    ndVar.fUm.fUo = Y;
                    ndVar.fUm.fUp = j;
                    com.tencent.mm.sdk.b.a.urY.m(ndVar);
                } catch (Throwable e3) {
                    long j2 = j;
                    w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3, "[oneliang][revokeMsg] msgId:%d,error:%s", Long.valueOf(j2), e3.toString());
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("clouddelmsg")) {
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                str2 = (String) map.get(".sysmsg.clouddelmsg.delcommand");
                str3 = (String) map.get(".sysmsg.clouddelmsg.msgid");
                str4 = (String) map.get(".sysmsg.clouddelmsg.fromuser");
                int indexOf = a.indexOf("<msg>");
                int indexOf2 = a.indexOf("</msg>");
                if (indexOf == -1 || indexOf2 == -1) {
                    str5 = "";
                } else {
                    str5 = aw.ae(bh.q(a.substring(indexOf, indexOf2 + 6), "msg"));
                }
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", str2, str3, str4, str5);
                try {
                    ap.yY();
                    LinkedList cQ = c.wT().cQ(str4, str3);
                    if (cQ == null || cQ.size() <= 0) {
                        w.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                        return null;
                    }
                    Iterator it = cQ.iterator();
                    while (it.hasNext()) {
                        auVar = (au) it.next();
                        if (auVar == null) {
                            w.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                        } else if (auVar.field_msgSvrId < 0) {
                            w.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
                        } else {
                            w.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
                            i2 = bg.getInt(str2, 0);
                            if (i2 == 1) {
                                ap.yY();
                                c.wT().E(auVar.field_talker, auVar.field_msgSvrId);
                            } else if (i2 == 2 && (auVar.bLX() || auVar.bLY())) {
                                auVar.setContent(str5);
                                ay.a(auVar, aVar);
                                ap.yY();
                                c.wT().b(auVar.field_msgSvrId, auVar);
                                ap.yY();
                                ae Rm2 = c.wW().Rm(auVar.field_talker);
                                if (Rm2 != null && Rm2.field_unReadCount > 0) {
                                    ap.yY();
                                    if (Rm2.field_unReadCount >= c.wT().K(auVar)) {
                                        Rm2.dt(Rm2.field_unReadCount - 1);
                                        ap.yY();
                                        c.wW().a(Rm2, Rm2.field_username);
                                    }
                                }
                            }
                            com.tencent.mm.sdk.b.b ndVar2 = new nd();
                            ndVar2.fUm.fGM = auVar.field_msgId;
                            ndVar2.fUm.fUn = str5;
                            ndVar2.fUm.fTk = auVar;
                            com.tencent.mm.sdk.b.a.urY.m(ndVar2);
                        }
                    }
                    return null;
                } catch (Throwable e32) {
                    w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e32, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", str3, e32.toString());
                }
            }
        }
        if (str != null) {
            if (str.equals("updatepackage")) {
                aB = c.aB(Integer.valueOf(-1879048175));
                if (aB == null) {
                    bVar = null;
                } else {
                    bVar = aB.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("deletepackage")) {
                aB = c.aB(Integer.valueOf(-1879048174));
                if (aB == null) {
                    bVar = null;
                } else {
                    bVar = aB.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("delchatroommember")) {
                str3 = n.a(buVar.tfd);
                ap.yY();
                auVar = c.wT().x(str3, buVar.tfk);
                Object obj = null;
                if (auVar.field_msgId > 0) {
                    obj = 1;
                }
                auVar.y(buVar.tfk);
                if (!(aVar != null && aVar.hsu && aVar.hsw)) {
                    auVar.z(ay.i(str3, (long) buVar.ogM));
                }
                auVar.setType(CdnLogic.MediaType_FAVORITE_VIDEO);
                auVar.setContent(a);
                auVar.dw(0);
                auVar.cH(str3);
                auVar.cN(buVar.tfi);
                ay.a(auVar, aVar);
                if (obj == null) {
                    ay.i(auVar);
                } else {
                    ap.yY();
                    c.wT().b(buVar.tfk, auVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("WakenPush") && this.hlg != buVar.tfk) {
                this.hlg = buVar.tfk;
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                bv bvVar = new bv(map);
                String str7 = (String) bvVar.hjZ.get(".sysmsg.WakenPush.PushContent");
                str3 = (String) bvVar.hjZ.get(".sysmsg.WakenPush.Jump");
                str2 = (String) bvVar.hjZ.get(".sysmsg.WakenPush.ExpiredTime");
                String str8 = (String) bvVar.hjZ.get(".sysmsg.WakenPush.Username");
                w.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", str7, str3, str2);
                str2 = g.sV().getValue("WakenPushDeepLinkBitSet");
                w.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", str2);
                j2 = !bg.mA(str2) ? bg.getLong(str2, 0) : 0;
                Bitmap a2 = com.tencent.mm.x.b.a(str8, false, -1);
                af notification = ap.getNotification();
                if (bg.mA(str3)) {
                    w.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                    str4 = "com.tencent.mm.ui.LauncherUI";
                } else if ((4 & j2) == 4 && str3.startsWith("weixin://dl/moments")) {
                    str4 = "com.tencent.mm.plugin.sns.ui.En_424b8e16";
                } else if ((j2 & 262144) == 262144 && str3.startsWith("weixin://dl/recommendation")) {
                    str4 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                } else {
                    w.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", str3);
                    str4 = "com.tencent.mm.ui.LauncherUI";
                }
                Intent intent = new Intent();
                intent.setClassName(ab.getContext(), str4);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.putExtra("LauncherUI.Show.Update.DialogMsg", (String) bvVar.hjZ.get(".sysmsg.WakenPush.PushContent"));
                if (!str3.equals("weixin://dl/update_newest_version")) {
                    intent.putExtra("LauncherUI.Show.Update.Url", (String) bvVar.hjZ.get(".sysmsg.WakenPush.Jump"));
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(405, 32, 1, true);
                Notification a3 = notification.a(PendingIntent.getActivity(ab.getContext(), UUID.randomUUID().hashCode(), intent, 134217728), ab.getContext().getString(R.l.bpJ), str7, str7, a2, str8);
                a3.flags |= 16;
                ap.getNotification().a(a3, false);
                com.tencent.mm.plugin.report.service.g.oUh.a(405, 31, 1, true);
                bVar = null;
            }
        }
        if (str != null) {
            if (str.equals("DisasterNotice")) {
                str2 = (String) map.get(".sysmsg.NoticeId");
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", str2, (String) map.get(".sysmsg.Content"));
                SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("disaster_pref", 4);
                str5 = sharedPreferences.getString("disaster_noticeid_list_key", "");
                if (!str5.contains(str2)) {
                    String[] split = str5.split(";");
                    if (split == null || split.length <= 10) {
                        str4 = str5;
                    } else {
                        str4 = "";
                        for (String str62 : split) {
                            String[] split2 = str62.split(",");
                            try {
                                if (bg.az(bg.getLong(split2[0], 0)) < 1296000) {
                                    str4 = str4 + split2[0] + "," + split2[1] + ";";
                                }
                            } catch (Exception e4) {
                                w.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", e4);
                            }
                        }
                    }
                    w.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", str5, str4 + bg.Ny() + "," + str2 + ";");
                    sharedPreferences.edit().putString("disaster_noticeid_list_key", str4).commit();
                }
                new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ f hlj;

                    public final void run() {
                        if (this.hlj.hlh != null) {
                            this.hlj.hlh.br(str2);
                        }
                    }
                });
                buVar.tff = n.mw(str3);
                buVar.mtd = 1;
                aB = c.aB(Integer.valueOf(1));
                if (aB == null) {
                    bVar = null;
                } else {
                    bVar = aB.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("EmotionKv")) {
                str2 = (String) map.get(".sysmsg.EmotionKv.K");
                a = (String) map.get(".sysmsg.EmotionKv.I");
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", Integer.valueOf(str3.length()), str3, a);
                byte[] bytes = ac.bHs().tal.getBytes();
                byte[] bytes2 = ac.bHs().tam.getBytes();
                byte[] bArr = null;
                try {
                    bArr = ap.vd().hsZ.Cc().BZ();
                } catch (Throwable e322) {
                    w.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", bg.g(e322));
                }
                if (bg.bm(bArr)) {
                    w.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    return null;
                }
                PByteArray pByteArray = new PByteArray();
                if (bg.mA(str3) || bg.bm(bytes2) || bg.bm(bytes) || bg.bm(bArr)) {
                    String str9 = "MicroMsg.BigBallSysCmdMsgConsumer";
                    String str10 = "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d";
                    Object[] objArr = new Object[4];
                    if (str3 == null) {
                        i4 = -1;
                    } else {
                        i4 = str3.length();
                    }
                    objArr[0] = Integer.valueOf(i4);
                    objArr[1] = Integer.valueOf(bytes2 == null ? -1 : bytes2.length);
                    objArr[2] = Integer.valueOf(bytes == null ? -1 : bytes.length);
                    objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                    w.w(str9, str10, objArr);
                } else {
                    ap.yY();
                    MMProtocalJni.genClientCheckKVRes(c.uH(), str3, bytes, bytes2, bArr, pByteArray);
                }
                byte[] bArr2 = pByteArray.value;
                com_tencent_mm_protocal_c_aij = new aij();
                if (pByteArray.value != null) {
                    com_tencent_mm_protocal_c_aij.oTN = new String(pByteArray.value);
                } else {
                    com_tencent_mm_protocal_c_aij.oTN = "";
                }
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summercck emotionkv res len:%d val len:%d, content[%s]";
                Object[] objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_aij.oTN.length());
                objArr2[2] = com.tencent.mm.a.g.n(com_tencent_mm_protocal_c_aij.oTN.getBytes());
                w.i(str4, str5, objArr2);
                com_tencent_mm_protocal_c_aij.tMr = a;
                ap.yY();
                c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(59, com_tencent_mm_protocal_c_aij));
                return null;
            }
        }
        if (str != null) {
            if (str.equals("globalalert")) {
                str2 = (String) map.get(".sysmsg.uuid");
                i3 = bg.getInt((String) map.get(".sysmsg.id"), -1);
                int i6 = bg.getInt((String) map.get(".sysmsg.important"), -1);
                if (bg.mA(str2) || i3 < 0 || i6 < 0) {
                    w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", str2, Integer.valueOf(i3), Integer.valueOf(i6));
                    return null;
                }
                str3 = (String) map.get(".sysmsg.title");
                str4 = (String) map.get(".sysmsg.msg");
                if (bg.mA(str3) && bg.mA(str4)) {
                    w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", str3, str4);
                    return null;
                }
                str5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                int i7 = bg.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                i5 = bg.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                str62 = (String) map.get(".sysmsg.btnlist.btn");
                if (bg.mA(str5) || i7 < 0 || i5 < 0) {
                    w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                    return null;
                }
                String str11 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                int i8 = bg.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                int i9 = bg.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                a = (String) map.get(".sysmsg.btnlist.btn1");
                boolean z2 = true;
                if (bg.mA(str11) || i8 < 0 || i9 < 0) {
                    z2 = false;
                    w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                }
                com.tencent.mm.sdk.b.b hrVar = new hr();
                com.tencent.mm.protocal.b.a.b bVar2 = new com.tencent.mm.protocal.b.a.b();
                hrVar.fNi.fNj = bVar2;
                bVar2.id = i3;
                bVar2.title = str3;
                bVar2.fEr = str4;
                bVar2.tbf = new LinkedList();
                com.tencent.mm.protocal.b.a.a aVar2 = new com.tencent.mm.protocal.b.a.a();
                aVar2.id = i7;
                aVar2.actionType = i5;
                aVar2.tbd = str5;
                aVar2.tbe = str62;
                bVar2.tbf.add(aVar2);
                if (z2) {
                    com.tencent.mm.protocal.b.a.a aVar3 = new com.tencent.mm.protocal.b.a.a();
                    aVar3.id = i8;
                    aVar3.actionType = i9;
                    aVar3.tbd = str11;
                    aVar3.tbe = a;
                    bVar2.tbf.add(aVar3);
                }
                boolean m = com.tencent.mm.sdk.b.a.urY.m(hrVar);
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", str2, Integer.valueOf(i3), Integer.valueOf(i6), str3, str4, Boolean.valueOf(z2), Boolean.valueOf(m));
                return null;
            }
        }
        if (str != null) {
            if (str.equals("yybsigcheck")) {
                com.tencent.mm.plugin.report.service.g.oUh.a(322, 14, 1, false);
                long currentTimeMillis = System.currentTimeMillis();
                str2 = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", str2, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url"));
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                Object[] objArr3 = new Object[2];
                objArr3[0] = Integer.valueOf(4014);
                objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                gVar.i(11098, objArr3);
                if (bg.mA(str2)) {
                    w.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                    com.tencent.mm.plugin.report.service.g.oUh.a(322, 15, 1, false);
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.oUh;
                    Object[] objArr4 = new Object[2];
                    objArr4[0] = Integer.valueOf(4015);
                    objArr4[1] = String.format("%s|%s", new Object[]{str7, str8});
                    gVar2.i(11098, objArr4);
                    return null;
                }
                String[] split3 = str2.split(";");
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summertoken newxml infoStrs len is %d";
                objArr2 = new Object[1];
                objArr2[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                w.d(str4, str5, objArr2);
                if (split3 == null || split3.length == 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(322, 16, 1, false);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11098, Integer.valueOf(4016), str2);
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (String str12 : split3) {
                    if (bg.mA(str12)) {
                        w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", Integer.valueOf(i5));
                    } else {
                        String[] split4 = str12.split(",");
                        str5 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str62 = "summertoken newxml fields len is %d";
                        Object[] objArr5 = new Object[1];
                        objArr5[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                        w.d(str5, str62, objArr5);
                        if (split4 == null || split4.length != 3) {
                            w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", Integer.valueOf(i5));
                        } else {
                            try {
                                arrayList.add(new v.c(split4[0], Integer.valueOf(split4[1]).intValue(), split4[2]));
                            } catch (Exception e5) {
                                w.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", Integer.valueOf(i5), e5.getMessage());
                                com.tencent.mm.plugin.report.service.g.oUh.a(322, 17, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.i(11098, Integer.valueOf(4017), str12);
                            }
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    w.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                    com.tencent.mm.plugin.report.service.g.oUh.a(322, 18, 1, false);
                    gVar = com.tencent.mm.plugin.report.service.g.oUh;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4018);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    gVar.i(11098, objArr3);
                    return null;
                }
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", Integer.valueOf(arrayList.size()), Boolean.valueOf(bg.getInt(g.sV().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(v.a(ab.getContext(), arrayList, bg.getInt(g.sV().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (v.a(ab.getContext(), arrayList, bg.getInt(g.sV().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                    ap.yW().setInt(46, 0);
                    com.tencent.mm.plugin.report.service.g.oUh.a(322, 19, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.oUh;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4019);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    gVar.i(11098, objArr3);
                } else {
                    ap.yW().setInt(46, 4);
                    com.tencent.mm.sdk.b.b icVar = new ic();
                    icVar.fNF.fNG = str7;
                    icVar.fNF.url = str8;
                    com.tencent.mm.sdk.b.a.urY.m(icVar);
                    com.tencent.mm.plugin.report.service.g.oUh.a(322, 20, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.oUh;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4020);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    gVar.i(11098, objArr3);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("qy_status_notify")) {
                str2 = (String) map.get(".sysmsg.chat_id");
                map.get(".sysmsg.last_create_time");
                str3 = (String) map.get(".sysmsg.brand_username");
                j2 = e.iy(str2);
                if (j2 == -1) {
                    w.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", str2);
                    return null;
                }
                i4 = com.tencent.mm.modelbiz.w.DK().U(j2).field_newUnReadCount;
                com.tencent.mm.modelbiz.w.DK().W(j2);
                com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(j2);
                ap.yY();
                Rm = c.wW().Rm(str3);
                if (Rm == null) {
                    w.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", str3);
                    return null;
                } else if (aa.fu(1)) {
                    if (Rm.field_unReadMuteCount <= i4) {
                        Rm.dA(0);
                        ap.yY();
                        c.wW().a(Rm, str3);
                        ap.getNotification().cancelNotification(str3);
                    } else {
                        Rm.dA(Rm.field_unReadMuteCount - i4);
                        ap.yY();
                        c.wW().a(Rm, str3);
                    }
                    return null;
                } else {
                    if (Rm.field_unReadCount <= i4) {
                        ap.yY();
                        c.wW().Ro(str3);
                        ap.getNotification().cancelNotification(str3);
                    } else {
                        Rm.dz(0);
                        Rm.dC(0);
                        Rm.dt(Rm.field_unReadCount - i4);
                        ap.yY();
                        c.wW().a(Rm, str3);
                    }
                    return null;
                }
            }
        }
        if (str != null) {
            if (str.equals("qy_chat_update")) {
                e.l((String) map.get(".sysmsg.brand_username"), (String) map.get(".sysmsg.chat_id"), (String) map.get(".sysmsg.ver"));
            }
        }
        if (str != null) {
            if (str.equals("bindmobiletip")) {
                i = bg.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                str4 = bg.mz((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                Object mz = bg.mz((String) map.get(".sysmsg.bindmobiletip.wording"));
                str2 = new String(Base64.decode(str4.getBytes(), 0));
                w.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", Integer.valueOf(i), str2, new String(com.tencent.mm.bd.b.aU(p.rB().getBytes()).xV(16).sYA), mz);
                if (bg.mA(str2) || str2.equals(r4)) {
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(true));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(i == 1));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, mz);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckConsistency")) {
                com_tencent_mm_protocal_c_aij = new aoh();
                com_tencent_mm_protocal_c_aij.hNZ = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                com_tencent_mm_protocal_c_aij.tTs = bg.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                com_tencent_mm_protocal_c_aij.tTt = bg.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                com_tencent_mm_protocal_c_aij.tlQ = bg.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                com_tencent_mm_protocal_c_aij.tTu = c(com_tencent_mm_protocal_c_aij.hNZ, (long) com_tencent_mm_protocal_c_aij.tTs, (long) com_tencent_mm_protocal_c_aij.tTt);
                com_tencent_mm_protocal_c_aij.tsR = (int) ep(com_tencent_mm_protocal_c_aij.hNZ);
                com_tencent_mm_protocal_c_aij.tTv = com.tencent.mm.plugin.normsg.a.d.nZC.aPk() ? 1 : 0;
                com_tencent_mm_protocal_c_aij.trD = com.tencent.mm.compatible.d.v.rR();
                com_tencent_mm_protocal_c_aij.tTw = c(com_tencent_mm_protocal_c_aij.hNZ, Integer.valueOf(com_tencent_mm_protocal_c_aij.tTs), Integer.valueOf(com_tencent_mm_protocal_c_aij.tTt), Integer.valueOf(com_tencent_mm_protocal_c_aij.tlQ), com_tencent_mm_protocal_c_aij.tTu, Integer.valueOf(com_tencent_mm_protocal_c_aij.tsR), Integer.valueOf(com_tencent_mm_protocal_c_aij.tTv), Integer.valueOf(com_tencent_mm_protocal_c_aij.trD));
                ap.yY();
                c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(61, com_tencent_mm_protocal_c_aij));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckHook")) {
                com_tencent_mm_protocal_c_aij = new aoj();
                com_tencent_mm_protocal_c_aij.tlQ = bg.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                com_tencent_mm_protocal_c_aij.tTy = com.tencent.mm.plugin.normsg.a.d.nZC.gb(false);
                com_tencent_mm_protocal_c_aij.tTv = com.tencent.mm.plugin.normsg.a.d.nZC.aPk() ? 1 : 0;
                com_tencent_mm_protocal_c_aij.trD = com.tencent.mm.compatible.d.v.rR();
                com_tencent_mm_protocal_c_aij.tTw = c(Integer.valueOf(com_tencent_mm_protocal_c_aij.tlQ), com_tencent_mm_protocal_c_aij.tTy, Integer.valueOf(com_tencent_mm_protocal_c_aij.tTv), Integer.valueOf(com_tencent_mm_protocal_c_aij.trD));
                ap.yY();
                c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(62, com_tencent_mm_protocal_c_aij));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetAppList")) {
                com_tencent_mm_protocal_c_aij = new aoi();
                com_tencent_mm_protocal_c_aij.tlQ = bg.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                com_tencent_mm_protocal_c_aij.tTx = com.tencent.mm.plugin.normsg.a.d.nZC.aPj();
                com_tencent_mm_protocal_c_aij.tTv = com.tencent.mm.plugin.normsg.a.d.nZC.aPk() ? 1 : 0;
                com_tencent_mm_protocal_c_aij.trD = com.tencent.mm.compatible.d.v.rR();
                com_tencent_mm_protocal_c_aij.tTw = c(Integer.valueOf(com_tencent_mm_protocal_c_aij.tlQ), com_tencent_mm_protocal_c_aij.tTx, Integer.valueOf(com_tencent_mm_protocal_c_aij.tTv), Integer.valueOf(com_tencent_mm_protocal_c_aij.trD));
                ap.yY();
                c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(63, com_tencent_mm_protocal_c_aij));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetExtInfo")) {
                com.tencent.mm.plugin.secinforeport.a.b.phI.bC(com.tencent.mm.plugin.normsg.a.d.nZC.l(true, true), bg.getInt((String) map.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0));
            }
        }
        if (!bg.mA(str)) {
            if (str.equals("functionmsg")) {
                w.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                com.tencent.mm.p.c ug = i.ug();
                w.j("MicroMsg.FunctionMsgFetcher", "fetchFromNewXml, newXmlMsgQueue.size: %s, addMsg.createTime: %s", Integer.valueOf(ug.gUv.size()), Integer.valueOf(buVar.ogM));
                map.put("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY", String.valueOf(buVar.ogM));
                ug.gUv.add(map);
                ug.tW();
            }
        }
        if (!bg.mA(str)) {
            if (str.equals("paymsg")) {
                w.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", Integer.valueOf(bg.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(buVar.tfk), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent"));
                try {
                    str2 = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (!bg.mA(str2)) {
                        com.tencent.mm.sdk.b.b lrVar = new lr();
                        lrVar.fSP.type = i2;
                        lrVar.fSP.content = str2;
                        lrVar.fSP.fOu = str3;
                        lrVar.fSP.toUser = str4;
                        lrVar.fSP.fSQ = str5;
                        com.tencent.mm.sdk.b.a.urY.m(lrVar);
                    }
                } catch (Throwable e3222) {
                    w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3222, "", new Object[0]);
                    w.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", e3222.getMessage());
                }
            }
        }
        return bVar;
    }

    private static String c(String str, long j, long j2) {
        ZipFile zipFile;
        Throwable e;
        String str2;
        InputStream inputStream = null;
        try {
            if (str.startsWith("@")) {
                zipFile = new ZipFile(ab.getContext().getApplicationInfo().sourceDir);
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(str.substring(1)));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                        str2 = "";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw e;
                    }
                }
            }
            zipFile = null;
            inputStream = FileOp.openRead(str);
            while (j > 0) {
                j -= inputStream.skip(j);
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[2048];
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, (int) Math.min(AppSupportContentFlag.MMAPP_SUPPORT_XLSX, j2));
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
                j2 -= (long) read;
            }
            str2 = bg.bo(instance.digest());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e8) {
                }
            }
        } catch (Exception e9) {
            e = e9;
            zipFile = null;
            w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            str2 = "";
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return str2;
        } catch (Throwable th2) {
            e = th2;
            zipFile = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw e;
        }
        return str2;
    }

    private static long ep(String str) {
        Throwable e;
        Throwable th;
        long j = -1;
        if (!str.startsWith("@")) {
            return FileOp.ki(str);
        }
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(ab.getContext().getApplicationInfo().sourceDir);
            try {
                ZipEntry entry = zipFile.getEntry(str.substring(1));
                if (entry == null) {
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e2) {
                        return j;
                    }
                }
                j = entry.getSize();
                try {
                    zipFile.close();
                    return j;
                } catch (IOException e3) {
                    return j;
                }
            } catch (IOException e4) {
                e = e4;
                try {
                    w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                    if (zipFile != null) {
                        return j;
                    }
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e5) {
                        return j;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            zipFile = null;
            w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            if (zipFile != null) {
                return j;
            }
            zipFile.close();
            return j;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    private static String c(Object... objArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    byteArrayOutputStream.write(((String) obj).getBytes());
                } else if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    for (r0 = 0; r0 < 4; r0++) {
                        byteArrayOutputStream.write(intValue & 255);
                        intValue >>= 8;
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    for (r0 = 0; r0 < 8; r0++) {
                        byteArrayOutputStream.write((int) (255 & longValue));
                        longValue >>= 8;
                    }
                } else if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        r0 = 1;
                    } else {
                        r0 = 0;
                    }
                    byteArrayOutputStream.write(r0);
                } else {
                    w.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", obj);
                    return "";
                }
            }
            return bg.bo(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            return "";
        }
    }
}
