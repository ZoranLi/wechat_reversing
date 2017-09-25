package com.tencent.mm.plugin.webwx.a;

import android.content.Intent;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.py;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.modelbiz.a.i;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements d {
    public final b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar != null && buVar.mtd == 51) {
            w.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[]{Integer.valueOf(buVar.mtd), Integer.valueOf(51)});
            String a = n.a(buVar.tfe);
            if (!bg.mA(a)) {
                String trim = n.a(buVar.tff).trim();
                Map q = bh.q(trim, "msg");
                if (q != null) {
                    int i = bg.getInt((String) q.get(".msg.op.$id"), 0);
                    w.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[]{Integer.valueOf(i)});
                    if (i == 1 || i == 2 || i == 5) {
                        w.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = " + a);
                        com.tencent.mm.plugin.webwx.a.imv.cancelNotification(a);
                        if (o.eZ(a)) {
                            ap.yY();
                            c.vr().set(143618, Integer.valueOf(0));
                            l.Ky().Kl();
                        } else {
                            w.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                            ap.yY();
                            c.wW().Ro(a);
                            if (o.dH(a)) {
                                ap.yY();
                                aj Rm = c.wW().Rm(a);
                                if (Rm != null && Rm.field_unReadCount > 0 && Rm.field_UnDeliverCount > 0) {
                                    w.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[]{a, Integer.valueOf(Rm.field_UnDeliverCount), Integer.valueOf(Rm.field_unReadCount)});
                                    com.tencent.mm.plugin.webwx.a.imw.bp(a);
                                    Rm.dt(0);
                                    ap.yY();
                                    c.wW().a(Rm, a);
                                }
                            }
                        }
                    } else if (i == 3) {
                        ap.yY();
                        List bLI = c.wW().bLI();
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = 0;
                        while (i2 < bLI.size()) {
                            stringBuilder.append(i2 > 0 ? "," : "");
                            stringBuilder.append((String) bLI.get(i2));
                            i2++;
                        }
                        ap.vd().a(new ag(stringBuilder.toString(), 4), 0);
                    } else if (i == 6) {
                        w.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                    } else if (i == 7) {
                        w.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        r3 = new Object[2];
                        ap.yY();
                        r3[0] = Integer.valueOf(c.wN());
                        r3[1] = Integer.valueOf(q.Jd());
                        w.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", r3);
                        a = bg.mz((String) q.get(".msg.op.name")).trim();
                        r0 = bg.mz((String) q.get(".msg.op.arg")).trim();
                        if ("WeixinStatus".equals(a)) {
                            ap.yY();
                            if (c.wN() == q.Jd() && q.hSm != null && q.hSm.trim().length() > 0) {
                                Intent intent = new Intent(ab.getContext(), WebWXLogoutUI.class);
                                intent.setFlags(603979776);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("intent.key.online_version", q.Jd());
                                ab.getContext().startActivity(intent);
                            }
                        } else if ("MomentsUnreadMsgStatus".equals(a)) {
                            r3 = new py();
                            r3.fWZ.fJA = 7;
                            r3.fWZ.fXa = a;
                            r3.fWZ.fXb = (long) bg.getInt(r0, 0);
                            w.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[]{Integer.valueOf(r3.fWZ.fJA), r3.fWZ.fXa, Long.valueOf(r3.fWZ.fXb)});
                            com.tencent.mm.sdk.b.a.urY.m(r3);
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            com.tencent.mm.modelbiz.w.DS();
                            i.f(i, a, r0);
                        }
                    } else if (i == 8) {
                        w.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = bg.mz((String) q.get(".msg.op.name")).trim();
                        r0 = bg.mz((String) q.get(".msg.op.arg")).trim();
                        if ("EnterpriseChatStatus".equals(a)) {
                            com.tencent.mm.modelbiz.w.DS();
                            i.f(i, a, r0);
                        } else {
                            com.tencent.mm.sdk.b.b pyVar = new py();
                            pyVar.fWZ.fJA = 8;
                            com.tencent.mm.sdk.b.a.urY.m(pyVar);
                        }
                    } else if (i == 9) {
                        w.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = bg.mz((String) q.get(".msg.op.name")).trim();
                        r0 = bg.mz((String) q.get(".msg.op.arg")).trim();
                        if ("MomentsTimelineStatus".equals(a)) {
                            String[] split = r0.split(",");
                            if (split.length == 2) {
                                r3 = new py();
                                r3.fWZ.fJA = 9;
                                r3.fWZ.fXa = a;
                                r3.fWZ.fXb = (long) bg.getInt(split[1], 0);
                                r3.fWZ.fXc = split[0];
                                com.tencent.mm.sdk.b.a.urY.m(r3);
                            }
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            com.tencent.mm.modelbiz.w.DS();
                            i.f(i, a, r0);
                        }
                    } else if (i == 12) {
                        w.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock " + trim, new Object[]{Integer.valueOf(i)});
                        try {
                            if (q.get(".msg.op.arg") != null) {
                                r0 = new JSONObject((String) q.get(".msg.op.arg")).get("deviceName").toString();
                                if (q.Jc()) {
                                    Intent intent2 = new Intent(ab.getContext(), WebWXPopupUnlockUI.class);
                                    intent2.setFlags(872415232);
                                    intent2.putExtra("deviceName", r0);
                                    ab.getContext().startActivity(intent2);
                                }
                            } else {
                                w.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                            }
                        } catch (JSONException e) {
                            w.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e.getMessage());
                        }
                    } else {
                        w.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[]{Integer.valueOf(i)});
                    }
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
