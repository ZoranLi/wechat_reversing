package com.tencent.mm.plugin.card.model;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.gu;
import com.tencent.mm.e.a.na;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.a.k;
import com.tencent.mm.plugin.card.a.m;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.plugin.card.ui.b;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import com.tencent.mm.y.d;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class al implements am {
    private static HashMap<Integer, c> gJr;
    private com.tencent.mm.sdk.b.c kgA = new a();
    private b kgB = new b();
    private com.tencent.mm.sdk.b.c kgC = new com.tencent.mm.sdk.b.c<gu>(this) {
        final /* synthetic */ al kgG;

        {
            this.kgG = r2;
            this.usg = gu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            final gu guVar = (gu) bVar;
            w.i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
            if (guVar instanceof gu) {
                this.kgG.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 kgI;

                    public final void run() {
                        if (ap.zb()) {
                            boolean z = guVar.fMf.fMg;
                            w.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is " + z);
                            boolean aiJ = l.aiJ();
                            boolean aiL = l.aiL();
                            if (aiJ && aiL) {
                                w.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                                return;
                            }
                            if (z) {
                                ap.vd().a(new y(), 0);
                            } else {
                                int intValue;
                                ap.yY();
                                Integer num = (Integer) com.tencent.mm.u.c.vr().get(282882, null);
                                if (num != null) {
                                    intValue = num.intValue();
                                } else {
                                    intValue = 0;
                                }
                                if (((int) (System.currentTimeMillis() / 1000)) - intValue >= 7200) {
                                    ap.vd().a(new y(), 0);
                                }
                            }
                            if (aiL) {
                                ap.yY();
                                Long l = (Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAO, Long.valueOf(0));
                                if (l != null && l.longValue() == 0) {
                                    al.agh().agr();
                                }
                            }
                            if (aiJ) {
                                ap.yY();
                                if (TextUtils.isEmpty((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAE, null))) {
                                    al.afZ();
                                    com.tencent.mm.plugin.card.a.b.kn(1);
                                }
                            }
                        }
                    }
                }, 10000);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c kgD = new com.tencent.mm.sdk.b.c<na>(this) {
        final /* synthetic */ al kgG;

        {
            this.kgG = r2;
            this.usg = na.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
            ak agb = al.agb();
            w.d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
            agb.gUz.eE("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
            return false;
        }
    };
    private bp.a kgE = new bp.a(this) {
        final /* synthetic */ al kgG;

        {
            this.kgG = r1;
        }

        public final void a(final d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
            } else {
                this.kgG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 kgJ;

                    public final void run() {
                        k age = al.age();
                        Object obj = a;
                        String str = aVar.hst.tfk;
                        w.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is " + str);
                        if (!TextUtils.isEmpty(obj)) {
                            g gVar;
                            String str2;
                            Map q = bh.q(obj, "sysmsg");
                            if (q == null) {
                                gVar = null;
                            } else {
                                g gVar2 = new g();
                                str2 = (String) q.get(".sysmsg.carditemmsg.card_type");
                                if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                    gVar2.field_card_type = 0;
                                } else {
                                    gVar2.field_card_type = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_title = (String) q.get(".sysmsg.carditemmsg.title");
                                gVar2.field_description = (String) q.get(".sysmsg.carditemmsg.description");
                                gVar2.field_logo_url = (String) q.get(".sysmsg.carditemmsg.logo_url");
                                gVar2.field_logo_color = (String) q.get(".sysmsg.carditemmsg.logo_color");
                                str2 = (String) q.get(".sysmsg.carditemmsg.time");
                                if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                    gVar2.field_time = (int) (System.currentTimeMillis() / 1000);
                                } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                    gVar2.field_time = Integer.MAX_VALUE;
                                } else {
                                    gVar2.field_time = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_card_id = (String) q.get(".sysmsg.carditemmsg.card_id");
                                gVar2.field_card_tp_id = (String) q.get(".sysmsg.carditemmsg.card_tp_id");
                                gVar2.field_msg_id = (String) q.get(".sysmsg.carditemmsg.msg_id");
                                str2 = (String) q.get(".sysmsg.carditemmsg.msg_type");
                                if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                    gVar2.field_msg_type = 0;
                                } else {
                                    gVar2.field_msg_type = Integer.valueOf(str2).intValue();
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.jump_type");
                                if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                    gVar2.field_jump_type = 1;
                                } else {
                                    gVar2.field_jump_type = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_url = (String) q.get(".sysmsg.carditemmsg.url");
                                str2 = (String) q.get(".sysmsg.carditemmsg.button.text");
                                if (!TextUtils.isEmpty(str2)) {
                                    ir irVar = new ir();
                                    irVar.text = str2;
                                    irVar.url = (String) q.get(".sysmsg.carditemmsg.button.url");
                                    str2 = (String) q.get(".sysmsg.carditemmsg.button.action_type");
                                    if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                        irVar.kfr = 0;
                                    } else {
                                        irVar.kfr = Integer.valueOf(str2).intValue();
                                    }
                                    gVar2.kfg = irVar;
                                    try {
                                        gVar2.field_buttonData = gVar2.kfg.toByteArray();
                                    } catch (Throwable e) {
                                        w.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[]{e.getMessage()});
                                        w.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
                                    }
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.opt_region.text");
                                if (!TextUtils.isEmpty(str2)) {
                                    iv ivVar = new iv();
                                    ivVar.text = str2;
                                    ivVar.url = (String) q.get(".sysmsg.carditemmsg.opt_region.url");
                                    str2 = (String) q.get(".sysmsg.carditemmsg.opt_region.type");
                                    if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                        ivVar.type = 0;
                                    } else {
                                        ivVar.type = Integer.valueOf(str2).intValue();
                                    }
                                    str2 = (String) q.get(".sysmsg.carditemmsg.opt_region.endtime");
                                    if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                        ivVar.poY = (int) (System.currentTimeMillis() / 1000);
                                    } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                        ivVar.poY = Integer.MAX_VALUE;
                                    } else {
                                        ivVar.poY = Integer.valueOf(str2).intValue();
                                    }
                                    gVar2.kfh = ivVar;
                                    try {
                                        gVar2.field_operData = gVar2.kfh.toByteArray();
                                    } catch (Throwable e2) {
                                        w.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[]{e2.getMessage()});
                                        w.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
                                    }
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.report_scene");
                                if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                    gVar2.field_report_scene = 2;
                                } else {
                                    gVar2.field_report_scene = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_read_state = 1;
                                gVar2.field_accept_buttons = k.g(q, ".sysmsg.carditemmsg");
                                gVar2.field_jump_buttons = k.f(q, ".sysmsg.carditemmsg");
                                str2 = (String) q.get(".sysmsg.carditemmsg.get_layout_scene");
                                if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                    gVar2.kfk = 0;
                                } else {
                                    gVar2.kfk = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_consumed_box_id = (String) q.get(".sysmsg.carditemmsg.consumed_box_id");
                                gVar2.kfa = (String) q.get(".sysmsg.carditemmsg.reddot_wording");
                                gVar2.kfb = (String) q.get(".sysmsg.carditemmsg.reddot_buff");
                                gVar2.kfc = (String) q.get(".sysmsg.carditemmsg.reddot_icon_url");
                                gVar2.kfd = (String) q.get(".sysmsg.carditemmsg.msg_tips.title");
                                gVar2.kfe = (String) q.get(".sysmsg.carditemmsg.msg_tips.icon_url");
                                str2 = (String) q.get(".sysmsg.carditemmsg.msg_scene");
                                if (TextUtils.isEmpty(str2) || !l.tb(str2)) {
                                    gVar2.kfl = 0;
                                } else {
                                    gVar2.kfl = Integer.valueOf(str2).intValue();
                                    w.i("MicroMsg.CardMsgManager", "msg_scene is " + str2);
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.need_check");
                                w.i("MicroMsg.CardMsgManager", "need_check:" + str2);
                                if (TextUtils.isEmpty(str2)) {
                                    gVar2.kff = false;
                                } else {
                                    gVar2.kff = str2.equals("true");
                                }
                                String str3 = (String) q.get(".sysmsg.carditemmsg.all_unavailable");
                                w.i("MicroMsg.CardMsgManager", "all_Unavailable:" + str2);
                                if (TextUtils.isEmpty(str3)) {
                                    gVar2.kfm = false;
                                } else {
                                    gVar2.kfm = str3.equals("true");
                                }
                                gVar2.field_unavailable_qr_code_list = k.h(q, ".sysmsg.carditemmsg");
                                gVar = gVar2;
                            }
                            if (gVar == null) {
                                w.e("MicroMsg.CardMsgManager", "card msg == null");
                                return;
                            }
                            if (TextUtils.isEmpty(gVar.field_card_id)) {
                                w.e("MicroMsg.CardMsgManager", "card id == null");
                            }
                            str2 = gVar.field_msg_id;
                            gVar.field_msg_id = str;
                            if (TextUtils.isEmpty(gVar.field_msg_id)) {
                                gVar.field_msg_id = str2;
                            }
                            if (TextUtils.isEmpty(gVar.field_msg_id)) {
                                gVar.field_msg_id = System.currentTimeMillis();
                            }
                            w.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + gVar.field_msg_id);
                            w.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + gVar.field_msg_type);
                            if (gVar.kfk != 0) {
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAL, Integer.valueOf(gVar.kfk));
                            }
                            w.i("MicroMsg.CardMsgManager", "reddot_buff is " + gVar.kfb);
                            if (TextUtils.isEmpty(gVar.kfb)) {
                                w.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                            } else {
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAH, gVar.kfb);
                            }
                            if ((gVar.field_msg_type & 1) != 0) {
                                w.i("MicroMsg.CardMsgManager", "msg_tips_title is " + gVar.kfd);
                                w.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + gVar.kfe);
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAJ, gVar.kfd);
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAK, gVar.kfe);
                            }
                            boolean aC = com.tencent.mm.q.c.uk().aC(262152, 266256);
                            if (!(aC || (gVar.field_msg_type & 64) == 0)) {
                                com.tencent.mm.q.c.uk().s(262152, true);
                                aC = true;
                            }
                            if (aC) {
                                w.i("MicroMsg.CardMsgManager", "has card new msg, return");
                            } else {
                                w.i("MicroMsg.CardMsgManager", "not has new!");
                                obj = null;
                                if ((gVar.field_msg_type & 32) != 0) {
                                    com.tencent.mm.q.c.uk().t(262152, true);
                                    w.i("MicroMsg.CardMsgManager", "has reddot");
                                    obj = 1;
                                } else {
                                    w.e("MicroMsg.CardMsgManager", "not has reddot!");
                                }
                                Object obj2 = null;
                                if (TextUtils.isEmpty(gVar.kfa)) {
                                    w.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                                } else {
                                    w.i("MicroMsg.CardMsgManager", "reddot_wording is " + gVar.kfa);
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAF, gVar.kfa);
                                    com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAz, true);
                                    obj2 = 1;
                                }
                                Object obj3 = null;
                                w.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + gVar.kfc);
                                if (TextUtils.isEmpty(gVar.kfc)) {
                                    w.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                                } else {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAI, gVar.kfc);
                                    com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAA, true);
                                    obj3 = 1;
                                }
                                if (obj == null || r1 == null || r2 == null) {
                                    if (obj != null && r1 != null && r2 == null) {
                                        com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAA, false);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAI, "");
                                    } else if (obj != null && r1 == null && r2 != null) {
                                        com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAz, false);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAF, "");
                                    } else if (obj == null && r1 != null && r2 != null) {
                                        com.tencent.mm.q.c.uk().t(262152, false);
                                    } else if (obj != null && r1 == null && r2 == null) {
                                        com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAA, false);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAI, "");
                                        com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAz, false);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAF, "");
                                    } else if (obj == null && r1 != null && r2 == null) {
                                        com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAA, false);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAI, "");
                                        com.tencent.mm.q.c.uk().t(262152, false);
                                    } else if (obj == null && r1 == null && r2 != null) {
                                        com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAz, false);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAF, "");
                                        com.tencent.mm.q.c.uk().t(262152, false);
                                    }
                                }
                                if (!(obj == null && r1 == null && r2 == null)) {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAW, gVar.field_card_id);
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAX, Boolean.valueOf(gVar.kff));
                                    w.i("MicroMsg.CardMsgManager", "card_id:" + gVar.field_card_id + "  need_check:" + gVar.kff);
                                }
                            }
                            if ((gVar.field_msg_type & 1) != 0) {
                                if (age.sn(gVar.field_msg_id)) {
                                    w.e("MicroMsg.CardMsgManager", "msg for id " + gVar.field_msg_id + " is exist!!");
                                    age.so(gVar.field_msg_id);
                                    age.kdw.add(gVar);
                                    k.c(gVar);
                                } else {
                                    age.kdw.add(gVar);
                                    k.c(gVar);
                                    if ((gVar.field_msg_type & FileUtils.S_IWUSR) != 0) {
                                        age.kdx++;
                                    }
                                }
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(139268, Integer.valueOf(age.kdx));
                                age.a(gVar);
                            }
                            if ((gVar.field_msg_type & 2) != 0) {
                                al.afZ();
                                com.tencent.mm.plugin.card.a.b.kn(gVar.kfk);
                            }
                            if ((gVar.field_msg_type & 4) != 0) {
                                age.adZ();
                            }
                            if ((gVar.field_msg_type & 8) != 0) {
                                al.agg().m(gVar.field_card_id, gVar.field_card_tp_id, gVar.field_report_scene);
                            }
                            if ((gVar.field_msg_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                                gVar.afU();
                                al.agq().b(gVar);
                            }
                            l.aiI();
                        }
                    }
                });
            }
        }
    };
    private bp.a kgF = new bp.a(this) {
        final /* synthetic */ al kgG;

        {
            this.kgG = r1;
        }

        public final void a(final d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
            } else {
                this.kgG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 kgK;

                    public final void run() {
                        com.tencent.mm.plugin.card.sharecard.a.c agk = al.agk();
                        Object obj = a;
                        w.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is " + (aVar.hst.tfk));
                        if (!TextUtils.isEmpty(obj)) {
                            com.tencent.mm.plugin.card.sharecard.a.c.a aVar;
                            Map q = bh.q(obj, "sysmsg");
                            if (q == null) {
                                aVar = null;
                            } else {
                                com.tencent.mm.plugin.card.sharecard.a.c.a aVar2 = new com.tencent.mm.plugin.card.sharecard.a.c.a(agk);
                                String str = (String) q.get(".sysmsg.notifysharecard.state_flag");
                                if (TextUtils.isEmpty(str) || !l.tb(str)) {
                                    aVar2.kgV = 0;
                                } else {
                                    aVar2.kgV = Integer.valueOf(str).intValue();
                                }
                                aVar2.username = (String) q.get(".sysmsg.notifysharecard.username");
                                aVar2.fVl = (String) q.get(".sysmsg.notifysharecard.card_id");
                                aVar = aVar2;
                            }
                            if (aVar == null) {
                                w.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                                return;
                            }
                            if (TextUtils.isEmpty(aVar.fVl)) {
                                w.e("MicroMsg.ShareCardMsgMgr", "card id == null");
                            }
                            w.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + aVar.fVl);
                            al.agh().agr();
                            l.aiK();
                        }
                    }
                });
            }
        }
    };
    private com.tencent.mm.plugin.card.a.b kgg;
    private c kgh;
    private ak kgi;
    private h kgj;
    private m kgk;
    private com.tencent.mm.plugin.card.sharecard.a.a kgl;
    private com.tencent.mm.plugin.card.sharecard.model.k kgm;
    private o kgn;
    private com.tencent.mm.plugin.card.sharecard.a.c kgo;
    private k kgp = null;
    private e kgq = null;
    private com.tencent.mm.plugin.card.a.l kgr = null;
    private com.tencent.mm.plugin.card.a.d kgs = null;
    private i kgt = null;
    private com.tencent.mm.plugin.card.a.c kgu;
    private g kgv;
    private l kgw;
    private j kgx;
    private com.tencent.mm.sdk.b.c kgy = new com.tencent.mm.plugin.card.a.n();
    private com.tencent.mm.sdk.b.c kgz = new com.tencent.mm.plugin.card.a.o();
    public ae mHandler = new ae(Looper.getMainLooper());

    public al() {
        File file = new File(m.kfw);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(m.kfx);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private static al afY() {
        al alVar = (al) ap.yR().gs("plugin.card");
        if (alVar != null) {
            return alVar;
        }
        Object alVar2 = new al();
        ap.yR().a("plugin.card", alVar2);
        return alVar2;
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return c.gUx;
            }
        });
        gJr.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return ak.gUx;
            }
        });
        gJr.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return h.gUx;
            }
        });
        gJr.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.card.sharecard.model.k.gUx;
            }
        });
        gJr.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return o.gUx;
            }
        });
        gJr.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return j.gUx;
            }
        });
        gJr.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.a.urY.b(this.kgC);
        com.tencent.mm.sdk.b.a.urY.b(this.kgD);
        com.tencent.mm.sdk.b.a.urY.b(this.kgy);
        com.tencent.mm.sdk.b.a.urY.b(this.kgz);
        com.tencent.mm.sdk.b.a.urY.b(this.kgA);
        ap.getSysCmdMsgExtension().a("carditemmsg", this.kgE, true);
        ap.getSysCmdMsgExtension().a("notifysharecard", this.kgF, true);
        this.kgp = null;
        if (this.kgq != null) {
            this.kgq.kda.clear();
            this.kgq = null;
        }
        if (this.kgk != null) {
            m mVar = this.kgk;
            synchronized (mVar.kdy) {
                mVar.kdy.clear();
            }
            synchronized (mVar.kdz) {
                mVar.kdz.clear();
            }
            ap.vd().b(563, mVar);
            com.tencent.mm.modelgeo.a Gk = com.tencent.mm.modelgeo.c.Gk();
            if (Gk != null) {
                Gk.c(mVar);
            }
            if (mVar.kdB != null) {
                ap.vd().c(mVar.kdB);
            }
            this.kgk = null;
        }
        if (this.kgg != null) {
            this.kgg.detach();
            this.kgg = null;
        }
        if (this.kgl != null) {
            com.tencent.mm.y.e eVar = this.kgl;
            synchronized (eVar.hAl) {
                eVar.kcF.clear();
                eVar.kcG.clear();
            }
            if (eVar.kgL != null) {
                ap.vd().c(eVar.kgL);
            }
            ap.vd().b(903, eVar);
            this.kgl = null;
        }
        if (this.kgs != null) {
            this.kgs.release();
            com.tencent.mm.plugin.card.a.d dVar = this.kgs;
            dVar.kcI.clear();
            dVar.kcU.clear();
            dVar.kcV.clear();
            dVar.kcW.clear();
            dVar.kcY = false;
            this.kgs = null;
        }
        if (this.kgt != null) {
            i iVar = this.kgt;
            ap.vd().b(907, iVar);
            Iterator it = iVar.kdk.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Runnable runnable = (Runnable) iVar.kdm.get(str);
                iVar.kdm.remove(str);
                iVar.kdl.removeCallbacks(runnable);
            }
            iVar.kdj.clear();
            iVar.kdk.clear();
            iVar.kdm.clear();
            this.kgt = null;
        }
        if (this.kgu != null) {
            this.kgu.release();
            this.kgu = null;
        }
        if (this.kgv != null) {
            this.kgv.release();
            this.kgv = null;
        }
        this.kgr = null;
        com.tencent.mm.pluginsdk.l.a.sBv = new j();
        b.WL().registerActivityLifecycleCallbacks(this.kgB);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        if (afY().kgg != null) {
            afY().kgg.detach();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.kgC);
        com.tencent.mm.sdk.b.a.urY.c(this.kgD);
        com.tencent.mm.sdk.b.a.urY.c(this.kgy);
        com.tencent.mm.sdk.b.a.urY.c(this.kgz);
        com.tencent.mm.sdk.b.a.urY.c(this.kgA);
        ap.getSysCmdMsgExtension().b("carditemmsg", this.kgE, true);
        ap.getSysCmdMsgExtension().b("notifysharecard", this.kgF, true);
        com.tencent.mm.pluginsdk.l.a.sBv = null;
        b.WL().unregisterActivityLifecycleCallbacks(this.kgB);
    }

    public static com.tencent.mm.plugin.card.a.b afZ() {
        h.vG().uQ();
        if (afY().kgg == null) {
            afY().kgg = new com.tencent.mm.plugin.card.a.b();
        }
        return afY().kgg;
    }

    public static c aga() {
        h.vG().uQ();
        if (afY().kgh == null) {
            al afY = afY();
            ap.yY();
            afY.kgh = new c(com.tencent.mm.u.c.wO());
        }
        return afY().kgh;
    }

    public static ak agb() {
        h.vG().uQ();
        if (afY().kgi == null) {
            al afY = afY();
            ap.yY();
            afY.kgi = new ak(com.tencent.mm.u.c.wO());
        }
        return afY().kgi;
    }

    public static h agc() {
        h.vG().uQ();
        if (afY().kgj == null) {
            al afY = afY();
            ap.yY();
            afY.kgj = new h(com.tencent.mm.u.c.wO());
        }
        return afY().kgj;
    }

    public static m agd() {
        h.vG().uQ();
        if (afY().kgk == null) {
            afY().kgk = new m();
        }
        return afY().kgk;
    }

    public static k age() {
        h.vG().uQ();
        if (afY().kgp == null) {
            afY().kgp = new k();
        }
        return afY().kgp;
    }

    public static e agf() {
        h.vG().uQ();
        if (afY().kgq == null) {
            afY().kgq = new e();
        }
        return afY().kgq;
    }

    public static com.tencent.mm.plugin.card.a.l agg() {
        h.vG().uQ();
        if (afY().kgr == null) {
            afY().kgr = new com.tencent.mm.plugin.card.a.l();
        }
        return afY().kgr;
    }

    public static com.tencent.mm.plugin.card.sharecard.a.a agh() {
        h.vG().uQ();
        if (afY().kgl == null) {
            afY().kgl = new com.tencent.mm.plugin.card.sharecard.a.a();
        }
        return afY().kgl;
    }

    public static com.tencent.mm.plugin.card.sharecard.model.k agi() {
        h.vG().uQ();
        if (afY().kgm == null) {
            al afY = afY();
            ap.yY();
            afY.kgm = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.u.c.wO());
        }
        return afY().kgm;
    }

    public static o agj() {
        h.vG().uQ();
        if (afY().kgn == null) {
            al afY = afY();
            ap.yY();
            afY.kgn = new o(com.tencent.mm.u.c.wO());
        }
        return afY().kgn;
    }

    public static com.tencent.mm.plugin.card.sharecard.a.c agk() {
        h.vG().uQ();
        if (afY().kgo == null) {
            afY().kgo = new com.tencent.mm.plugin.card.sharecard.a.c();
        }
        return afY().kgo;
    }

    public static com.tencent.mm.plugin.card.a.d agl() {
        h.vG().uQ();
        if (afY().kgs == null) {
            afY().kgs = new com.tencent.mm.plugin.card.a.d();
        }
        return afY().kgs;
    }

    public static i agm() {
        h.vG().uQ();
        if (afY().kgt == null) {
            afY().kgt = new i();
        }
        return afY().kgt;
    }

    public static com.tencent.mm.plugin.card.a.c agn() {
        h.vG().uQ();
        if (afY().kgu == null) {
            afY().kgu = new com.tencent.mm.plugin.card.a.c();
        }
        return afY().kgu;
    }

    public static l ago() {
        h.vG().uQ();
        if (afY().kgw == null) {
            al afY = afY();
            ap.yY();
            afY.kgw = new l(com.tencent.mm.u.c.wO());
        }
        return afY().kgw;
    }

    public static j agp() {
        h.vG().uQ();
        if (afY().kgx == null) {
            al afY = afY();
            ap.yY();
            afY.kgx = new j(com.tencent.mm.u.c.wO());
        }
        return afY().kgx;
    }

    public static g agq() {
        h.vG().uQ();
        if (afY().kgv == null) {
            afY().kgv = new g();
        }
        return afY().kgv;
    }
}
