package com.tencent.mm.ui.chatting;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;

public final class a {

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
        private int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        private d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(a aVar, au auVar) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(auVar, pString, pString2)) {
            a(aVar, auVar, pString.value, pString2.value);
        }
    }

    public static void a(a aVar, au auVar, String str, String str2) {
        String str3 = auVar.field_talker;
        boolean endsWith = str3.endsWith("@chatroom");
        String xL = auVar.field_isSend == 1 ? m.xL() : endsWith ? ay.gi(auVar.field_content) : str3;
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.n("20source_publishid", str + ",");
        dVar.n("21uxinfo", str2 + ",");
        dVar.n("22clienttime", bg.Nz() + ",");
        dVar.n("23video_statu", ",");
        dVar.n("24source_type", (auVar.field_type == 62 ? 1 : 2) + ",");
        dVar.n("25scene", (endsWith ? 4 : 3) + ",");
        dVar.n("26action_type", aVar.value + ",");
        dVar.n("27scene_chatname", str3 + ",");
        dVar.n("28scene_username", xL + ",");
        dVar.n("29curr_publishid", ",");
        dVar.n("30curr_msgid", auVar.field_msgSvrId + ",");
        dVar.n("31curr_favid", "0,");
        dVar.n("32elapsed_time", "0,");
        dVar.n("33load_time", "0,");
        dVar.n("34is_load_complete", "0,");
        dVar.n("35destination", "0,");
        dVar.n("36chatroom_membercount", (endsWith ? j.eC(str3) : 0) + ",");
        w.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + dVar.JG());
        g.oUh.i(12990, dVar);
    }

    public static void a(c cVar, d dVar, au auVar, int i) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(auVar, pString, pString2)) {
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = auVar.field_talker;
            boolean endsWith = str3.endsWith("@chatroom");
            String xL = auVar.field_isSend == 1 ? m.xL() : endsWith ? ay.gi(auVar.field_content) : str3;
            com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
            dVar2.n("20source_publishid", str + ",");
            dVar2.n("21uxinfo", str2 + ",");
            dVar2.n("22clienttime", bg.Nz() + ",");
            dVar2.n("23video_statu", dVar.value + ",");
            dVar2.n("24source_type", (auVar.field_type == 62 ? 1 : 2) + ",");
            dVar2.n("25scene", (endsWith ? 4 : 3) + ",");
            dVar2.n("26action_type", cVar.value + ",");
            dVar2.n("27scene_chatname", str3 + ",");
            dVar2.n("28scene_username", xL + ",");
            dVar2.n("29curr_publishid", ",");
            dVar2.n("30curr_msgid", auVar.field_msgSvrId + ",");
            dVar2.n("31curr_favid", "0,");
            dVar2.n("32chatroom_membercount", (endsWith ? j.eC(str3) : 0) + ",");
            dVar2.n("33chatroom_toMemberCount", i + ",");
            w.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + dVar2.JG());
            g.oUh.i(12991, dVar2);
        }
    }

    static boolean a(au auVar, PString pString, PString pString2) {
        if (auVar.field_type == 62) {
            r lH = t.lH(auVar.field_imgPath);
            if (lH == null) {
                return false;
            }
            bdu com_tencent_mm_protocal_c_bdu = lH.iay;
            if (com_tencent_mm_protocal_c_bdu == null || bg.mA(com_tencent_mm_protocal_c_bdu.hjJ)) {
                return false;
            }
            pString.value = com_tencent_mm_protocal_c_bdu.hjK;
            pString2.value = com_tencent_mm_protocal_c_bdu.hjJ;
            return true;
        } else if (auVar.field_type != 49) {
            return false;
        } else {
            boolean dH = o.dH(auVar.field_talker);
            String str = auVar.field_content;
            if (dH && auVar.field_content != null && auVar.field_isSend == 0) {
                str = ay.gj(auVar.field_content);
            }
            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
            if (ek == null || ek.type != 4 || bg.mA(ek.hjD)) {
                return false;
            }
            pString.value = ek.hjK;
            pString2.value = ek.hjJ;
            return true;
        }
    }
}
