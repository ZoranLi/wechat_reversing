package com.tencent.mm.plugin.game.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.e.a.gj;
import com.tencent.mm.e.a.gk;
import com.tencent.mm.e.a.gl;
import com.tencent.mm.e.a.gm;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.hb;
import com.tencent.mm.e.a.hc;
import com.tencent.mm.e.a.kp;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.mm;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.e.a.qd;
import com.tencent.mm.e.a.ss;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import com.tencent.mm.y.d;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SubCoreGameCenter implements am {
    private static String mrK = "";
    @SuppressLint({"UseSparseArrays"})
    static HashMap<Integer, c> mrL;
    private com.tencent.mm.sdk.b.c iyu = new com.tencent.mm.sdk.b.c<ad>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            b aeVar = new ae();
            aeVar.fDk.fDm = new com.tencent.mm.plugin.game.gamewebview.model.c(ab.getContext());
            a.urY.m(aeVar);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c ksx = new com.tencent.mm.sdk.b.c<qd>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = qd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qd qdVar = (qd) bVar;
            if (qdVar.fXi.fXj.equals(gm.class.getName())) {
                if (qdVar.fXi.fJA == 1) {
                    this.msb.mrU.Rg();
                } else {
                    this.msb.mrU.unregister();
                }
            }
            return false;
        }
    };
    private bp.a lew = new bp.a(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r1;
        }

        public final void a(d.a aVar) {
            com.tencent.mm.sdk.e.c cVar;
            Object obj;
            t aBC = SubCoreGameCenter.aBC();
            String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[]{Long.valueOf(r1.tfk)});
            w.i("MicroMsg.GameMessageService", "Message content: %s" + a);
            new Thread(new com.tencent.mm.plugin.game.model.t.AnonymousClass1(aBC, a)).start();
            if (bg.mA(a)) {
                w.e("MicroMsg.GameMessageParser", "msg content is null");
                cVar = null;
            } else {
                Map q = bh.q(a, "sysmsg");
                if (q == null || q.size() == 0) {
                    w.e("MicroMsg.GameMessageParser", "Parse failed");
                    cVar = null;
                } else if ("gamecenter".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
                    com.tencent.mm.sdk.e.c qVar = new q();
                    qVar.field_showInMsgList = true;
                    qVar.field_msgId = System.currentTimeMillis();
                    qVar.field_rawXML = a;
                    qVar.field_msgType = bg.getInt((String) q.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                    long j;
                    if (qVar.field_msgType == 100) {
                        x.aAZ();
                        qVar.field_gameMsgId = bg.ap((String) q.get(".sysmsg.gamecenter.msg_id"), "");
                        qVar.field_appId = (String) q.get(".sysmsg.gamecenter.appid");
                        qVar.field_createTime = bg.getLong((String) q.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        j = bg.getLong((String) q.get(".sysmsg.gamecenter.time_info.expire_time"), 0);
                        if (j == 0) {
                            qVar.field_expireTime = Long.MAX_VALUE;
                        } else {
                            qVar.field_expireTime = j + bg.getLong((String) q.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        }
                        qVar.field_isHidden = bg.getInt((String) q.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        qVar.field_mergerId = bg.ap((String) q.get(".sysmsg.gamecenter.merge_id"), "");
                        qVar.field_weight = bg.ap((String) q.get(".sysmsg.gamecenter.weight"), "");
                        qVar.field_receiveTime = System.currentTimeMillis() / 1000;
                        x.d(q, qVar);
                        qVar.mqe = bg.getLong((String) q.get(".sysmsg.gamecenter.filter_flag"), 0);
                        qVar.mqf = bg.getInt((String) q.get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                        qVar.mpQ = bg.getInt((String) q.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) > 0;
                        qVar.mpR.mqE = bg.ap((String) q.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        if (bg.mA((String) q.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url")) && bg.mA((String) q.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"))) {
                            qVar.mpS = false;
                        } else {
                            qVar.mpS = true;
                        }
                        x.e(q, qVar);
                        qVar.mqw.mqR = bg.ap((String) q.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        qVar.mqw.kiv = bg.getInt((String) q.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        if (!bg.mA(qVar.mqw.mqR)) {
                            qVar.field_isHidden = true;
                        }
                        qVar.mqw.mqS = bg.getLong((String) q.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                    } else {
                        qVar.field_gameMsgId = bg.ap((String) q.get(".sysmsg.gamecenter.msg_id"), "");
                        qVar.field_msgType = bg.getInt((String) q.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                        if (qVar.field_msgType == 0) {
                            qVar.field_msgType = bg.getInt((String) q.get(".sysmsg.gamecenter.$msgtype"), 0);
                        }
                        qVar.field_appId = (String) q.get(".sysmsg.gamecenter.appinfo.appid");
                        qVar.field_showInMsgList = !bg.mA(s.s(q));
                        qVar.field_createTime = bg.getLong((String) q.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        j = bg.getLong((String) q.get(".sysmsg.game_control_info.expiredtime"), 0);
                        if (j == 0) {
                            qVar.field_expireTime = Long.MAX_VALUE;
                        } else {
                            qVar.field_expireTime = j + bg.getLong((String) q.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        }
                        qVar.field_isHidden = bg.getInt((String) q.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        qVar.field_mergerId = bg.ap((String) q.get(".sysmsg.gamecenter.merge_id"), "");
                        if (qVar.field_msgType == 10) {
                            qVar.field_weight = "6";
                        } else {
                            qVar.field_weight = "2";
                        }
                        qVar.field_receiveTime = System.currentTimeMillis() / 1000;
                        qVar.mqe = bg.getLong((String) q.get(".sysmsg.game_control_info.filter_flag"), 0);
                        qVar.mqd = s.t(q);
                        qVar.mqf = bg.getInt((String) q.get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                        qVar.mpS = bg.getInt((String) q.get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) > 0;
                        qVar.mqz = bg.ap((String) q.get(".sysmsg.gamecenter.noticeid"), "");
                        qVar.mpR.mqG = bg.getInt((String) q.get(".sysmsg.gamecenter.badge_display_type"), 0);
                        qVar.mpQ = qVar.mpR.mqG > 0;
                        if ((qVar.mqd & 4) == 0) {
                            qVar.mpQ = false;
                        }
                        s.b(q, qVar);
                    }
                    if (qVar.mqf == 1) {
                        qVar.field_showInMsgList = false;
                    }
                    cVar = qVar;
                } else {
                    w.e("MicroMsg.GameMessageParser", "Type not matched");
                    cVar = null;
                }
            }
            w.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", new Object[]{Integer.valueOf(cVar.field_msgType), cVar.field_appId, Long.valueOf(cVar.field_msgId)});
            if (cVar == null) {
                w.e("MicroMsg.GameMessageService", "msg is null");
                obj = null;
            } else {
                long j2;
                q aAO;
                String str = cVar.field_gameMsgId;
                if (!bg.mA(str)) {
                    int i = 0;
                    Cursor rawQuery = SubCoreGameCenter.aBB().rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + str + "\"", new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            i = rawQuery.getInt(0);
                        }
                        rawQuery.close();
                        if (i > 0) {
                            obj = 1;
                            if (obj == null) {
                                w.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{Long.valueOf(cVar.field_msgId)});
                                obj = null;
                            } else {
                                if ((cVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                                    w.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{Long.valueOf(cVar.field_msgId)});
                                    obj = null;
                                } else {
                                    j2 = cVar.mqe;
                                    a = cVar.field_appId;
                                    if (j2 != 1) {
                                        if (bg.mA(a) || !g.n(ab.getContext(), a)) {
                                        }
                                        obj = 1;
                                    } else {
                                        if (j2 == 2 && (bg.mA(a) || g.n(ab.getContext(), a))) {
                                        }
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        w.e("MicroMsg.GameMessageService", "checkFilter failed,%s", new Object[]{Long.valueOf(cVar.field_msgId)});
                                        obj = null;
                                    } else {
                                        if (cVar.field_msgType != 20) {
                                            aAO = t.aAO();
                                            if (aAO == null) {
                                                aAO = t.aAQ();
                                            }
                                            if (aAO == null) {
                                                aAO = t.aAS();
                                            }
                                            if (aAO == null || t.a(cVar, aAO)) {
                                                if (cVar.mpQ) {
                                                    ap.yY();
                                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0));
                                                } else {
                                                    ap.yY();
                                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCh, Long.valueOf(cVar.field_msgId));
                                                }
                                            }
                                            aAO = t.aAO();
                                            if (aAO == null) {
                                                aAO = t.aAQ();
                                            }
                                            if (aAO == null) {
                                                aAO = t.aAS();
                                            }
                                            if (aAO == null || t.a(cVar, aAO)) {
                                                if (bg.mA(cVar.mqg.url)) {
                                                    ap.yY();
                                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCl, Long.valueOf(cVar.field_msgId));
                                                } else {
                                                    t.aAR();
                                                }
                                            }
                                            aAO = t.aAO();
                                            if (aAO == null) {
                                                aAO = t.aAQ();
                                            }
                                            if (aAO == null) {
                                                aAO = t.aAS();
                                            }
                                            if (aAO == null || t.a(cVar, aAO)) {
                                                if (cVar.mpS) {
                                                    t.aAT();
                                                } else {
                                                    ap.yY();
                                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCi, Long.valueOf(cVar.field_msgId));
                                                }
                                            }
                                            if (cVar.field_msgType == 4) {
                                                ap.yY();
                                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCk, Long.valueOf(cVar.field_msgId));
                                            }
                                            if (!(cVar == null || bg.mA(cVar.mpR.mqE))) {
                                                com.tencent.mm.plugin.game.d.c.ye(cVar.mpR.mqE);
                                            }
                                        }
                                        obj = 1;
                                    }
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    if (cVar.field_expireTime > System.currentTimeMillis() / 1000) {
                    }
                    if ((cVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                        j2 = cVar.mqe;
                        a = cVar.field_appId;
                        obj = j2 != 1 ? null : null;
                        if (obj != null) {
                            if (cVar.field_msgType != 20) {
                                aAO = t.aAO();
                                if (aAO == null) {
                                    aAO = t.aAQ();
                                }
                                if (aAO == null) {
                                    aAO = t.aAS();
                                }
                                if (cVar.mpQ) {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0));
                                } else {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCh, Long.valueOf(cVar.field_msgId));
                                }
                                aAO = t.aAO();
                                if (aAO == null) {
                                    aAO = t.aAQ();
                                }
                                if (aAO == null) {
                                    aAO = t.aAS();
                                }
                                if (bg.mA(cVar.mqg.url)) {
                                    t.aAR();
                                } else {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCl, Long.valueOf(cVar.field_msgId));
                                }
                                aAO = t.aAO();
                                if (aAO == null) {
                                    aAO = t.aAQ();
                                }
                                if (aAO == null) {
                                    aAO = t.aAS();
                                }
                                if (cVar.mpS) {
                                    t.aAT();
                                } else {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCi, Long.valueOf(cVar.field_msgId));
                                }
                                if (cVar.field_msgType == 4) {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCk, Long.valueOf(cVar.field_msgId));
                                }
                                com.tencent.mm.plugin.game.d.c.ye(cVar.mpR.mqE);
                            }
                            obj = 1;
                        } else {
                            w.e("MicroMsg.GameMessageService", "checkFilter failed,%s", new Object[]{Long.valueOf(cVar.field_msgId)});
                            obj = null;
                        }
                    } else {
                        w.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{Long.valueOf(cVar.field_msgId)});
                        obj = null;
                    }
                } else {
                    w.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{Long.valueOf(cVar.field_msgId)});
                    obj = null;
                }
            }
            if (obj != null) {
                if (cVar.field_msgType == 20) {
                    com.tencent.mm.sdk.e.c xP = SubCoreGameCenter.aBB().xP(cVar.field_appId);
                    if (xP != null) {
                        SubCoreGameCenter.aBB().a(xP, new String[0]);
                        w.i("MicroMsg.GameMessageService", "duplicated appId, type = %d, appId = %s, msgId = %s", new Object[]{Integer.valueOf(xP.field_msgType), xP.field_appId, Long.valueOf(xP.field_msgId)});
                    }
                }
                t.e(cVar);
                w.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[]{Boolean.valueOf(SubCoreGameCenter.aBB().b(cVar))});
                if (SubCoreGameCenter.aBB().b(cVar)) {
                    int i2 = cVar.field_msgType;
                    if (cVar.field_msgType == 100) {
                        i2 = cVar.mqy;
                    }
                    ai.a(ab.getContext(), 0, 0, 0, 18, 0, cVar.field_appId, 0, i2, cVar.field_gameMsgId, cVar.mqz, ai.co("resource", String.valueOf(cVar.mpR.mqG)));
                    if (cVar.field_msgType == 20) {
                        d.a(cVar);
                    }
                }
            }
        }
    };
    private u mrE;
    private t mrF;
    private b mrG;
    private ah mrH;
    private w mrI;
    private z mrJ;
    private com.tencent.mm.sdk.b.c mrM = new com.tencent.mm.sdk.b.c<gk>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = gk.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            gk gkVar = (gk) bVar;
            l.a(gkVar.fLI.url, gkVar.fLI.fFW, gkVar.fLI.scene != 0 ? gkVar.fLI.scene : 1000, gkVar.fLI.appId, gkVar.fLI.extInfo);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrN = new com.tencent.mm.sdk.b.c<lj>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = lj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            lj ljVar = (lj) bVar;
            if (bg.mA(ljVar.fSk.content)) {
                SubCoreGameCenter.aBC();
                ap.yY();
                long longValue = ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0))).longValue();
                q cn = longValue != 0 ? SubCoreGameCenter.aBB().cn(longValue) : null;
                if (cn != null) {
                    boolean z2;
                    cn.aAN();
                    if (System.currentTimeMillis() / 1000 <= cn.field_receiveTime + cn.mqw.mqS) {
                        b ssVar;
                        switch (cn.mqw.kiv) {
                            case 0:
                                z2 = true;
                                break;
                            case 1:
                                ssVar = new ss();
                                ssVar.gaE.fEG = 2;
                                ssVar.gaE.gaF = cn.mqw.mqR;
                                a.urY.m(ssVar);
                                if (!ssVar.gaE.gaG) {
                                    z2 = false;
                                    break;
                                }
                                z2 = true;
                                break;
                            case 2:
                                ssVar = new ss();
                                ssVar.gaE.fEG = 4;
                                ssVar.gaE.gaF = cn.mqw.mqR;
                                a.urY.m(ssVar);
                                if (ssVar.gaE.gaH <= 0) {
                                    z2 = false;
                                    break;
                                }
                                z2 = true;
                                break;
                            default:
                                z2 = false;
                                break;
                        }
                    }
                    z2 = true;
                    if (cn.mqc > 0) {
                        if (com.tencent.mm.sdk.platformtools.am.isWifi(ab.getContext())) {
                            w.i("MicroMsg.GameWifiStrategy", "WifiStrategy:isInWifi");
                        } else {
                            GregorianCalendar gregorianCalendar = new GregorianCalendar();
                            int i = gregorianCalendar.get(11);
                            gregorianCalendar.get(12);
                            int i2 = i >= 21 ? 3 : i < 12 ? 0 : i < 14 ? 1 : i < 18 ? 0 : 2;
                            w.i("MicroMsg.GameWifiStrategy", "WifiStrategy:inWhichTimeRange = " + i2);
                            if (i2 != 0) {
                                if (i2 != 3) {
                                    if (i2 == 1) {
                                        w.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", new Object[]{Integer.valueOf(((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50), Integer.valueOf(bg.dM(100, 0))});
                                        if (((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50 <= bg.dM(100, 0)) {
                                        }
                                    } else if (i2 == 2) {
                                        gregorianCalendar = new GregorianCalendar();
                                        w.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", new Object[]{Integer.valueOf((((gregorianCalendar.get(12) > 30 ? 1 : 0) + (gregorianCalendar.get(11) - 18)) * 10) + 50), Integer.valueOf(bg.dM(100, 0))});
                                        if ((((gregorianCalendar.get(12) > 30 ? 1 : 0) + (gregorianCalendar.get(11) - 18)) * 10) + 50 <= bg.dM(100, 0)) {
                                        }
                                    }
                                }
                            }
                            if (!z && z2) {
                                SubCoreGameCenter.aBB().aAW();
                            }
                        }
                        z = false;
                        SubCoreGameCenter.aBB().aAW();
                    } else if (z2) {
                        SubCoreGameCenter.aBB().aAW();
                    }
                    SubCoreGameCenter.aBC().a(ljVar);
                }
            } else {
                String str = ljVar.fSk.content;
                if (str != null && str.startsWith("//gamemsg:")) {
                    new bu().tff = n.mw(str.substring(10));
                    str = str.substring(10);
                    if (!bg.mA(str)) {
                        if (str.equals("jumpnative")) {
                            Intent intent = new Intent();
                            intent.putExtra("from_find_more_friend", true);
                            com.tencent.mm.bb.d.b(ab.getContext(), "game", ".ui.GameCenterUI2", intent);
                        } else if (str.equals("jumpLibrary")) {
                            com.tencent.mm.bb.d.b(ab.getContext(), "game", ".ui.GameLibraryUI", new Intent());
                        } else if (str.contains("jumpDetail:")) {
                            str = str.substring(11, str.length());
                            Intent intent2 = new Intent();
                            intent2.putExtra("game_app_id", str);
                            com.tencent.mm.bb.d.b(ab.getContext(), "game", ".ui.GameDetailUI2", intent2);
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrO = new com.tencent.mm.sdk.b.c<gh>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = gh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gh ghVar = (gh) bVar;
            int i;
            switch (ghVar.fLB.actionCode) {
                case 1:
                    e.a(ghVar.fLB.context, ghVar.fLB.appId, ghVar.fLB.messageAction, ghVar.fLB.messageExt, null);
                    ai.a(ghVar.fLB.context, ghVar.fLB.scene, ghVar.fLB.scene, 1, 3, ghVar.fLB.appId, 0, null);
                    break;
                case 2:
                    i = ghVar.fLB.scene;
                    w.i("MicroMsg.SubCoreGameCenter", "scene = %d, extinfo = %s", new Object[]{Integer.valueOf(i), ghVar.fLB.extMsg});
                    Bundle bundle = new Bundle();
                    bundle.putInt("game_report_from_scene", i);
                    bundle.putCharSequence("game_app_id", ghVar.fLB.appId);
                    bundle.putCharSequence("game_report_extra_click_extinfo", r1);
                    ai.a(ghVar.fLB.context, ghVar.fLB.scene, ghVar.fLB.scene, 1, com.tencent.mm.plugin.game.d.c.a(ghVar.fLB.context, ghVar.fLB.appId, null, bundle), ghVar.fLB.appId, 0, null);
                    break;
                case 3:
                    p.update();
                    break;
                case 5:
                    i = ghVar.fLB.scene;
                    SubCoreGameCenter.aBC();
                    com.tencent.mm.plugin.game.d.c.a(t.aAQ(), i);
                    break;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrP = new com.tencent.mm.sdk.b.c<gl>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = gl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return AnonymousClass22.b((gl) bVar);
        }

        private static boolean b(gl glVar) {
            q qVar;
            switch (glVar.fLJ.ou) {
                case 1:
                    String str = glVar.fLJ.fLE;
                    LinkedList linkedList = new LinkedList();
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int i = bg.getInt(jSONObject.optString(Columns.TYPE), 0);
                            int i2 = bg.getInt(jSONObject.optString("limit"), 0);
                            long j = bg.getLong(jSONObject.optString("lastLocalId"), -1);
                            int i3 = bg.getInt(jSONObject.optString("isUnread"), -1);
                            if (i2 > 0 && i2 <= 10000 && j >= 0 && i3 >= 0) {
                                Object b = SubCoreGameCenter.aBB().b(i, j, i3, i2);
                                if (!bg.bV(b)) {
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it = b.iterator();
                                    while (it.hasNext()) {
                                        qVar = (q) it.next();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("localId", qVar.field_msgId);
                                        jSONObject2.put("content", qVar.field_rawXML);
                                        jSONArray.put(jSONObject2);
                                    }
                                    glVar.fLK.fLL = jSONArray.toString();
                                    break;
                                }
                            }
                        } catch (JSONException e) {
                            w.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                            break;
                        }
                    }
                    break;
                case 2:
                    v.a(glVar);
                    break;
                case 3:
                    SubCoreGameCenter.aBC();
                    qVar = t.aAS();
                    if (qVar != null) {
                        glVar.fLK.fLL = qVar.field_rawXML;
                        break;
                    }
                    break;
                case 4:
                    SubCoreGameCenter.aBC();
                    t.aAT();
                    break;
                case 5:
                    SubCoreGameCenter.aBC();
                    ap.yY();
                    qVar = SubCoreGameCenter.aBB().cn(((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCj, Long.valueOf(0))).longValue());
                    if (qVar == null || qVar.field_isHidden) {
                        qVar = null;
                    }
                    if (qVar != null) {
                        glVar.fLK.fLL = qVar.field_rawXML;
                        break;
                    }
                    break;
                case 6:
                    SubCoreGameCenter.aBC();
                    ap.yY();
                    qVar = SubCoreGameCenter.aBB().cn(((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCj, Long.valueOf(0))).longValue());
                    if (!(qVar == null || qVar.field_isHidden)) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCj, Long.valueOf(0));
                        break;
                    }
                case 9:
                    SubCoreGameCenter.aBC();
                    qVar = t.aAU();
                    if (qVar != null) {
                        glVar.fLK.fLL = qVar.field_rawXML;
                        break;
                    }
                    break;
                case 10:
                    SubCoreGameCenter.aBC();
                    ap.yY();
                    if (SubCoreGameCenter.aBB().cn(((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCk, Long.valueOf(0))).longValue()) != null) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCk, Long.valueOf(0));
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrQ = new com.tencent.mm.sdk.b.c<kp>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = kp.class.getName().hashCode();
        }

        private static boolean a(kp kpVar) {
            String optString;
            int i;
            JSONException e;
            Intent intent;
            Exception e2;
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(kpVar.fRg.extraInfo);
                optString = jSONObject.optString("appId");
                try {
                    i = bg.getInt(jSONObject.optString("ssid"), 0);
                } catch (JSONException e3) {
                    e = e3;
                    w.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                    i = 0;
                    intent = new Intent();
                    switch (kpVar.fRg.fRh) {
                        case 0:
                            intent.setClass(kpVar.fRg.context, GameCenterUI.class);
                            if (kpVar.fRg.jumpType == 1) {
                                intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                        case 1:
                            intent.setClass(kpVar.fRg.context, GameLibraryUI.class);
                            if (kpVar.fRg.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                        case 2:
                            if (!bg.mA(optString)) {
                                intent.setClass(kpVar.fRg.context, GameDetailUI.class);
                                intent.putExtra("game_app_id", optString);
                                if (kpVar.fRg.jumpType == 1) {
                                    intent.putExtra("jump_game_center", "jump_game_center");
                                }
                                intent.putExtra("game_report_from_scene", 5);
                                kpVar.fRg.context.startActivity(intent);
                                ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                                break;
                            }
                            break;
                        case 3:
                            intent.setClass(kpVar.fRg.context, GameMessageUI.class);
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                    }
                    return false;
                } catch (Exception e4) {
                    e2 = e4;
                    w.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e2.getMessage()});
                    i = 0;
                    intent = new Intent();
                    switch (kpVar.fRg.fRh) {
                        case 0:
                            intent.setClass(kpVar.fRg.context, GameCenterUI.class);
                            if (kpVar.fRg.jumpType == 1) {
                                intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                        case 1:
                            intent.setClass(kpVar.fRg.context, GameLibraryUI.class);
                            if (kpVar.fRg.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                        case 2:
                            if (bg.mA(optString)) {
                                intent.setClass(kpVar.fRg.context, GameDetailUI.class);
                                intent.putExtra("game_app_id", optString);
                                if (kpVar.fRg.jumpType == 1) {
                                    intent.putExtra("jump_game_center", "jump_game_center");
                                }
                                intent.putExtra("game_report_from_scene", 5);
                                kpVar.fRg.context.startActivity(intent);
                                ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                                break;
                            }
                            break;
                        case 3:
                            intent.setClass(kpVar.fRg.context, GameMessageUI.class);
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                    }
                    return false;
                }
            } catch (JSONException e5) {
                JSONException jSONException = e5;
                optString = str;
                e = jSONException;
                w.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                i = 0;
                intent = new Intent();
                switch (kpVar.fRg.fRh) {
                    case 0:
                        intent.setClass(kpVar.fRg.context, GameCenterUI.class);
                        if (kpVar.fRg.jumpType == 1) {
                            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        kpVar.fRg.context.startActivity(intent);
                        ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                        break;
                    case 1:
                        intent.setClass(kpVar.fRg.context, GameLibraryUI.class);
                        if (kpVar.fRg.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        kpVar.fRg.context.startActivity(intent);
                        ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                        break;
                    case 2:
                        if (bg.mA(optString)) {
                            intent.setClass(kpVar.fRg.context, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (kpVar.fRg.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                        }
                        break;
                    case 3:
                        intent.setClass(kpVar.fRg.context, GameMessageUI.class);
                        intent.putExtra("game_report_from_scene", 5);
                        kpVar.fRg.context.startActivity(intent);
                        ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                        break;
                }
                return false;
            } catch (Exception e6) {
                Exception exception = e6;
                optString = str;
                e2 = exception;
                w.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e2.getMessage()});
                i = 0;
                intent = new Intent();
                switch (kpVar.fRg.fRh) {
                    case 0:
                        intent.setClass(kpVar.fRg.context, GameCenterUI.class);
                        if (kpVar.fRg.jumpType == 1) {
                            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        kpVar.fRg.context.startActivity(intent);
                        ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                        break;
                    case 1:
                        intent.setClass(kpVar.fRg.context, GameLibraryUI.class);
                        if (kpVar.fRg.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        kpVar.fRg.context.startActivity(intent);
                        ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                        break;
                    case 2:
                        if (bg.mA(optString)) {
                            intent.setClass(kpVar.fRg.context, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (kpVar.fRg.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            kpVar.fRg.context.startActivity(intent);
                            ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                            break;
                        }
                        break;
                    case 3:
                        intent.setClass(kpVar.fRg.context, GameMessageUI.class);
                        intent.putExtra("game_report_from_scene", 5);
                        kpVar.fRg.context.startActivity(intent);
                        ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                        break;
                }
                return false;
            }
            intent = new Intent();
            switch (kpVar.fRg.fRh) {
                case 0:
                    intent.setClass(kpVar.fRg.context, GameCenterUI.class);
                    if (kpVar.fRg.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    kpVar.fRg.context.startActivity(intent);
                    ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(kpVar.fRg.context, GameLibraryUI.class);
                    if (kpVar.fRg.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    kpVar.fRg.context.startActivity(intent);
                    ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (bg.mA(optString)) {
                        intent.setClass(kpVar.fRg.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", optString);
                        if (kpVar.fRg.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        kpVar.fRg.context.startActivity(intent);
                        ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(kpVar.fRg.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    kpVar.fRg.context.startActivity(intent);
                    ai.a(kpVar.fRg.context, 5, 5, 1, 6, i, null);
                    break;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrR = new com.tencent.mm.sdk.b.c<mm>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = mm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mm mmVar = (mm) bVar;
            ai.a(ab.getContext(), mmVar.fTK.scene, mmVar.fTK.fTL, 1, mmVar.fTK.action, 0, mmVar.fTK.appId, 0, mmVar.fTK.msgType, mmVar.fTK.fSm, mmVar.fTK.fDE, mmVar.fTK.fTM);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrS = new com.tencent.mm.sdk.b.c<mn>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = mn.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            mn mnVar = (mn) bVar;
            ai.a(mnVar.fTN.context, mnVar.fTN.fTO, mnVar.fTN.packageName, mnVar.fTN.fOu, mnVar.fTN.msgType, mnVar.fTN.scene, mnVar.fTN.fTP, mnVar.fTN.mediaTagName, mnVar.fTN.fTQ, mnVar.fTN.fTR);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrT = new com.tencent.mm.sdk.b.c<gi>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = gi.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            f.a((gi) bVar);
            return false;
        }
    };
    com.tencent.mm.pluginsdk.e.d mrU = new com.tencent.mm.pluginsdk.e.d(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r1;
        }

        public final b xW(String str) {
            b gmVar = new gm();
            gmVar.fLM.fDz = str;
            return gmVar;
        }

        public final j aBJ() {
            return SubCoreGameCenter.aBB();
        }
    };
    private com.tencent.mm.sdk.b.c mrV = new com.tencent.mm.sdk.b.c<gj>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = gj.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            gj gjVar = (gj) bVar;
            k.fLG = gjVar.fLF.fLG;
            k.countryCode = gjVar.fLF.countryCode;
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrW = new com.tencent.mm.sdk.b.c<hb>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = hb.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ((hb) bVar).fMw.fLG = k.fLG;
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrX = new com.tencent.mm.sdk.b.c<gn>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = gn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gn gnVar = (gn) bVar;
            switch (gnVar.fLN.opType) {
                case 2:
                    l.aAJ();
                    l.a(gnVar.fLN.appId, gnVar.fLN.fLO, false, gnVar.fLN.fFs);
                    break;
                case 6:
                    l.aAJ();
                    l.cn(gnVar.fLN.appId, gnVar.fLN.fFs);
                    break;
                default:
                    SubCoreGameCenter.aBE();
                    w.b(gnVar.fLN.appId, gnVar.fLN.opType, gnVar.fLN.fLO, gnVar.fLN.openId, gnVar.fLN.fFs);
                    break;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrY = new com.tencent.mm.sdk.b.c<lc>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = lc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            h.aAH().update();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mrZ = new com.tencent.mm.sdk.b.c<hc>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = hc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hc hcVar = (hc) bVar;
            hcVar.fMy.className = com.tencent.mm.plugin.game.gamewebview.model.b.xz(hcVar.fMx.url);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c msa = new com.tencent.mm.sdk.b.c<pu>(this) {
        final /* synthetic */ SubCoreGameCenter msb;

        {
            this.msb = r2;
            this.usg = pu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pu puVar = (pu) bVar;
            StartGameProcessTask startGameProcessTask = new StartGameProcessTask(ab.getContext());
            startGameProcessTask.fCw = puVar.fWR.bundle.getLong("extra_download_id", -1);
            startGameProcessTask.avz();
            return false;
        }
    };

    public static class StartGameProcessTask extends GameProcessActivityTask {
        public static final Creator<StartGameProcessTask> CREATOR = new Creator<StartGameProcessTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartGameProcessTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartGameProcessTask[i];
            }
        };
        public long fCw;

        public final void a(Context context, GameProcessActivityTask.a aVar) {
            Intent intent = new Intent(context, FileDownloadConfirmUI.class);
            intent.putExtra("extra_download_id", this.fCw);
            context.startActivity(intent);
            aVar.TP();
        }

        public final void SK() {
        }

        public final void f(Parcel parcel) {
            this.fCw = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.fCw);
        }

        public StartGameProcessTask(Context context) {
            super(context);
        }

        public StartGameProcessTask(Parcel parcel) {
            f(parcel);
        }
    }

    public SubCoreGameCenter() {
        l.a.sBw = new k(this) {
            final /* synthetic */ SubCoreGameCenter msb;

            {
                this.msb = r1;
            }

            public final boolean aBI() {
                try {
                    boolean z;
                    g aAF = g.aAF();
                    if (aAF.mpl != null) {
                        z = aAF.mpl.mtL;
                    } else {
                        aAF.OU();
                        w.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[]{v.d(ab.getContext().getSharedPreferences(ab.bIX(), 0))});
                        w.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[]{bg.ap(com.tencent.mm.i.g.sV().getValue("HideGameCenter"), "zh_CN".equals(v.d(ab.getContext().getSharedPreferences(ab.bIX(), 0))) ? "0" : "1")});
                        z = r0.equalsIgnoreCase("0");
                    }
                    w.i("MicroMsg.GameConfigManager", "getShowEntrance : " + z);
                    return z;
                } catch (Exception e) {
                    return true;
                }
            }

            public final void a(String str, String str2, int i, int i2, String str3, int i3) {
                ai.a(str, str2, i, i2, str3, i3);
            }

            public final void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
                ai.a(context, str, str2, str3, i, str4, i2);
            }

            public final void a(String str, String str2, int i, int i2, String str3, long j) {
                ai.a(str, str2, i, i2, str3, j);
            }

            public final void B(String str, int i, int i2) {
                ai.e(str, 1, i, i2);
            }

            public final void I(String str, String str2, String str3) {
                ai.I(str, str2, str3);
            }

            public final void m(Context context, String str, String str2) {
                ai.m(context, str, str2);
            }

            public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
                ai.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
            }

            public final void cl(Context context) {
                context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
                context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
                context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
            }
        };
    }

    static {
        HashMap hashMap = new HashMap();
        mrL = hashMap;
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return u.gUx;
            }
        });
        mrL.put(Integer.valueOf("GAME_CENTER_JSON_CACHE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return o.gUx;
            }
        });
        mrL.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return z.gUx;
            }
        });
    }

    public static String aBz() {
        return mrK;
    }

    private static SubCoreGameCenter aBA() {
        SubCoreGameCenter subCoreGameCenter = (SubCoreGameCenter) ap.yR().gs("plugin.game");
        if (subCoreGameCenter != null) {
            return subCoreGameCenter;
        }
        Object subCoreGameCenter2 = new SubCoreGameCenter();
        ap.yR().a("plugin.game", subCoreGameCenter2);
        return subCoreGameCenter2;
    }

    public static u aBB() {
        h.vG().uQ();
        if (aBA().mrE == null) {
            SubCoreGameCenter aBA = aBA();
            ap.yY();
            aBA.mrE = new u(com.tencent.mm.u.c.wO());
        }
        return aBA().mrE;
    }

    public static t aBC() {
        h.vG().uQ();
        if (aBA().mrF == null) {
            aBA().mrF = new t();
        }
        return aBA().mrF;
    }

    public static ah aBD() {
        h.vG().uQ();
        if (aBA().mrH == null) {
            aBA().mrH = new ah();
        }
        return aBA().mrH;
    }

    public static w aBE() {
        h.vG().uQ();
        if (aBA().mrI == null) {
            aBA().mrI = new w();
        }
        return aBA().mrI;
    }

    public static z aBF() {
        h.vG().uQ();
        if (aBA().mrJ == null) {
            SubCoreGameCenter aBA = aBA();
            ap.yY();
            aBA.mrJ = new z(com.tencent.mm.u.c.wO());
        }
        return aBA().mrJ;
    }

    public static com.tencent.mm.pluginsdk.model.app.d aBG() {
        return an.aBG();
    }

    public static b aBH() {
        h.vG().uQ();
        if (aBA().mrG == null) {
            aBA().mrG = new b();
        }
        return aBA().mrG;
    }

    public final HashMap<Integer, c> uh() {
        return mrL;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        ap.getSysCmdMsgExtension().a("gamecenter", this.lew, true);
        a.urY.b(this.mrM);
        a.urY.b(this.mrN);
        a.urY.b(this.ksx);
        a.urY.b(this.mrO);
        a.urY.b(this.mrP);
        a.urY.b(this.mrQ);
        a.urY.b(this.mrR);
        a.urY.b(this.mrS);
        a.urY.b(this.mrV);
        a.urY.b(this.mrW);
        a.urY.b(this.mrT);
        a.urY.b(this.mrX);
        a.urY.b(this.mrY);
        a.urY.b(this.mrZ);
        a.urY.b(this.iyu);
        a.urY.b(this.msa);
        l.aAz();
        d.aAz();
        g.aAF().OU();
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).registerIndexStorage(new com.tencent.mm.plugin.game.b.a());
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).registerNativeLogic(5, new com.tencent.mm.plugin.game.b.b());
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("gamecenter", this.lew, true);
        a.urY.c(this.mrM);
        a.urY.c(this.mrN);
        a.urY.c(this.ksx);
        a.urY.c(this.mrO);
        a.urY.c(this.mrP);
        a.urY.c(this.mrQ);
        a.urY.c(this.mrR);
        a.urY.c(this.mrS);
        a.urY.c(this.mrV);
        a.urY.c(this.mrW);
        a.urY.c(this.mrT);
        a.urY.c(this.mrX);
        a.urY.c(this.mrY);
        a.urY.c(this.mrZ);
        a.urY.c(this.iyu);
        a.urY.c(this.msa);
        com.tencent.mm.plugin.game.d.c.XI();
        if (this.mrH != null) {
            e eVar = this.mrH;
            if (eVar.mrv != null) {
                eVar.mrv.clear();
            }
            ap.vd().b(427, eVar);
        }
        if (this.mrI != null) {
            ap.vd().b(1223, this.mrI);
        }
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).unregisterIndexStorage(16);
        ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).unregisterNativeLogic(5);
        com.tencent.mm.plugin.fts.d.h.mV(80);
        com.tencent.mm.plugin.fts.d.h.mV(4144);
        l.aAA();
        d.aAA();
    }
}
