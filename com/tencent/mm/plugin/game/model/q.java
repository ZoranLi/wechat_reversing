package com.tencent.mm.plugin.game.model;

import com.tencent.mm.e.b.bk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class q extends bk {
    protected static com.tencent.mm.sdk.e.c.a gTP;
    public String iQO = "";
    public String kPs = "";
    private boolean mpG = false;
    public String mpH = "";
    public String mpI = "";
    public String mpJ = "";
    public String mpK = "";
    public String mpL = "";
    public int mpM = 0;
    public String mpN = "";
    public String mpO = "";
    public LinkedList<h> mpP = new LinkedList();
    public boolean mpQ;
    public c mpR = new c();
    public boolean mpS;
    public b mpT = new b();
    public HashMap<String, d> mpU = new HashMap();
    public String mpV = "";
    public int mpW = 0;
    public int mpX = 0;
    public int mpY = 0;
    public String mpZ = "";
    public int mqA = 0;
    public String mqB = "";
    public boolean mqC = false;
    public String mqa = "";
    public String mqb = "";
    public int mqc = 0;
    public long mqd = 0;
    public long mqe = 0;
    public int mqf = 0;
    public a mqg = new a();
    public String mqh = "";
    public String mqi = "";
    public String mqj = "";
    public String mqk = "";
    public String mql = "";
    public String mqm = "";
    public String mqn = "";
    public String mqo;
    public String mqp;
    public String mqq;
    public String mqr;
    public String mqs;
    public f mqt;
    public e mqu = new e();
    public g mqv = new g();
    public i mqw = new i();
    public int mqx;
    public int mqy;
    public String mqz;

    public static class a {
        public boolean mpB;
        public boolean mqD;
        public int orientation;
        public String url;
    }

    public static class b {
        public String gMv;
        public String mqE;
        public String mqF;
    }

    public static class c {
        public String jqT;
        public String mqE;
        public int mqG;
    }

    public static class d {
        public String lkK;
        public int mqH;
    }

    public static class e {
        public String mqE;
        public String mqF;
        public String mqI;
    }

    public static class f {
        public String mqF;
        public String mqJ;
        public String mqK;
        public String mqL;
    }

    public static class g {
        public String mName;
        public String mqF;
        public boolean mqM;
    }

    public static class h {
        public String aIO;
        public String mqN;
        public String mqO;
        public String mqP;
        public String mqQ;
        public String userName;
    }

    public static class i {
        public int kiv = 0;
        public String mqR;
        public long mqS = 0;
    }

    public final void aAN() {
        if (!this.mpG) {
            if (this.field_msgType != 100) {
                if (this != null) {
                    if (!bg.mA(this.field_rawXML)) {
                        Map q = bh.q(this.field_rawXML, "sysmsg");
                        if (q != null && q.size() != 0) {
                            if ("gamecenter".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
                                this.mqc = bg.getInt((String) q.get(".sysmsg.gamecenter.wifi_flag"), 0);
                                this.kPs = s.s(q);
                                this.mpH = bg.ap((String) q.get(".sysmsg.gamecenter.url"), "");
                                this.mpV = bg.ap((String) q.get(".sysmsg.gamecenter.msg_picture_url"), "");
                                this.mpI = bg.ap((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
                                if (bg.mA(this.mpI)) {
                                    this.mpI = bg.ap((String) q.get(".sysmsg.gamecenter.url"), "");
                                }
                                this.mqx = bg.getInt((String) q.get(".sysmsg.gamecenter.notify_type"), 0);
                                this.iQO = bg.ap((String) q.get(".sysmsg.gamecenter.appinfo.appname2"), "");
                                if (bg.mA(this.iQO)) {
                                    this.iQO = bg.ap((String) q.get(".sysmsg.gamecenter.appinfo.appname"), "");
                                }
                                if (this.field_msgType == 6) {
                                    this.mpN = bg.ap((String) q.get(".sysmsg.gamecenter.appinfo.groupname"), "");
                                    this.mpO = bg.ap((String) q.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
                                } else {
                                    this.mpN = this.iQO;
                                }
                                this.mpJ = bg.ap((String) q.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
                                this.mpK = bg.ap((String) q.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
                                this.mpL = bg.ap((String) q.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
                                this.mpM = bg.getInt((String) q.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
                                s.a(q, this);
                                this.mqz = bg.ap((String) q.get(".sysmsg.gamecenter.noticeid"), "");
                                this.mqd = s.t(q);
                                this.mpR.mqG = bg.getInt((String) q.get(".sysmsg.gamecenter.badge_display_type"), 0);
                                this.mpR.mqE = bg.ap((String) q.get(".sysmsg.gamecenter.showiconurl"), "");
                                this.mpR.jqT = bg.ap((String) q.get(".sysmsg.gamecenter.entrancetext"), "");
                                s.b(q, this);
                                this.mpW = bg.getInt((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
                                this.mpT.mqE = bg.ap((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
                                this.mpT.gMv = bg.ap((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
                                this.mqA = bg.getInt((String) q.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
                                this.mqB = bg.ap((String) q.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
                                switch (this.field_msgType) {
                                    case 2:
                                        this.mpX = bg.getInt((String) q.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
                                        this.mpY = bg.getInt((String) q.get(".sysmsg.game_control_info.display_name_type"), 1);
                                        this.mpZ = bg.ap((String) q.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
                                        this.mqa = bg.ap((String) q.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
                                        this.mqb = bg.ap((String) q.get(".sysmsg.gameshare.share_message_info.media_url"), "");
                                        this.mpV = bg.ap((String) q.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
                                        w.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[]{this.field_appId});
                                        break;
                                    case 4:
                                    case 10:
                                    case 11:
                                        break;
                                    case 5:
                                        this.mql = bg.ap((String) q.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
                                        this.mqm = bg.ap((String) q.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
                                        this.mqn = bg.ap((String) q.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
                                        break;
                                    case 6:
                                        this.mqh = bg.ap((String) q.get(".sysmsg.gamecenter.topic.reply_content"), "");
                                        this.mqi = bg.ap((String) q.get(".sysmsg.gamecenter.topic.replied_content"), "");
                                        this.mqk = bg.ap((String) q.get(".sysmsg.gamecenter.topic.topic_title"), "");
                                        this.mqj = bg.ap((String) q.get(".sysmsg.gamecenter.topic.topic_url"), "");
                                        break;
                                    default:
                                        w.e("MicroMsg.GameMessageParser", "error gamecenter type: " + this.field_msgType);
                                        break;
                                }
                            }
                            w.e("MicroMsg.GameMessageParser", "Type not matched");
                        } else {
                            w.e("MicroMsg.GameMessageParser", "Parse failed");
                        }
                    } else {
                        w.e("MicroMsg.GameMessageParser", "msg content is null");
                    }
                } else {
                    w.e("MicroMsg.GameMessageParser", "msg is null");
                }
            } else {
                x.aAZ();
                if (this == null) {
                    w.e("MicroMsg.GameNewMessageParser", "msg is null");
                } else if (bg.mA(this.field_rawXML)) {
                    w.e("MicroMsg.GameNewMessageParser", "msg content is null");
                } else {
                    Map q2 = bh.q(this.field_rawXML, "sysmsg");
                    if (q2 == null || q2.size() == 0) {
                        w.e("MicroMsg.GameNewMessageParser", "Parse failed");
                    } else if ("gamecenter".equalsIgnoreCase((String) q2.get(".sysmsg.$type"))) {
                        this.mqo = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
                        this.mqp = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
                        this.mqq = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
                        this.mqu.mqI = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
                        this.mqu.mqE = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
                        this.mqu.mqF = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
                        this.mqr = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
                        this.mqs = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
                        if (q2.get(".sysmsg.gamecenter.msg_center.msg_sender") != null) {
                            this.mqt = new f();
                            this.mqt.mqJ = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
                            this.mqt.mqK = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
                            this.mqt.mqL = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
                            this.mqt.mqF = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
                        }
                        this.mpP.clear();
                        String str = ".sysmsg.gamecenter.msg_center.userinfo";
                        int i = 0;
                        while (true) {
                            String str2 = i == 0 ? str : str + i;
                            if (!q2.containsKey(str2)) {
                                break;
                            }
                            h hVar = new h();
                            hVar.userName = bg.ap((String) q2.get(str2 + ".username"), "");
                            hVar.aIO = bg.ap((String) q2.get(str2 + ".nickname"), "");
                            hVar.mqN = bg.ap((String) q2.get(str2 + ".usericon"), "");
                            hVar.mqP = bg.ap((String) q2.get(str2 + ".badge_icon"), "");
                            hVar.mqQ = bg.ap((String) q2.get(str2 + ".$jump_id"), "");
                            this.mpP.add(hVar);
                            i++;
                        }
                        this.mqv.mName = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
                        this.mqv.mqM = bg.getInt((String) q2.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0;
                        this.mqv.mqF = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
                        x.c(q2, this);
                        x.d(q2, this);
                        this.mpT.mqE = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
                        this.mpT.gMv = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
                        this.mpT.mqF = bg.ap((String) q2.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
                        x.e(q2, this);
                        this.mpR.mqG = bg.getInt((String) q2.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
                        this.mpR.mqE = bg.ap((String) q2.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        this.mpR.jqT = bg.ap((String) q2.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
                        this.mqw.mqR = bg.ap((String) q2.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        this.mqw.kiv = bg.getInt((String) q2.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        this.mqw.mqS = bg.getLong((String) q2.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                        this.mqc = bg.getInt((String) q2.get(".sysmsg.gamecenter.wifi_flag"), 0);
                    } else {
                        w.e("MicroMsg.GameNewMessageParser", "Type not matched");
                    }
                }
            }
            this.mpG = true;
        }
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.uxd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msgId";
        aVar.columns[1] = "mergerId";
        aVar.uxd.put("mergerId", "TEXT");
        stringBuilder.append(" mergerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "gameMsgId";
        aVar.uxd.put("gameMsgId", "TEXT");
        stringBuilder.append(" gameMsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgType";
        aVar.uxd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.uxd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expireTime";
        aVar.uxd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "showInMsgList";
        aVar.uxd.put("showInMsgList", "INTEGER default 'true' ");
        stringBuilder.append(" showInMsgList INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "isRead";
        aVar.uxd.put("isRead", "INTEGER default 'false' ");
        stringBuilder.append(" isRead INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "label";
        aVar.uxd.put("label", "TEXT default '' ");
        stringBuilder.append(" label TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "isHidden";
        aVar.uxd.put("isHidden", "INTEGER default 'false' ");
        stringBuilder.append(" isHidden INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "weight";
        aVar.uxd.put("weight", "TEXT default '' ");
        stringBuilder.append(" weight TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "rawXML";
        aVar.uxd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "receiveTime";
        aVar.uxd.put("receiveTime", "LONG default '0' ");
        stringBuilder.append(" receiveTime LONG default '0' ");
        aVar.columns[14] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }
}
