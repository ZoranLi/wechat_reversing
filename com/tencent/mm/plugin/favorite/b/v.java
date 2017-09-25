package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class v {

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

    public static void j(j jVar) {
        if (jVar.field_favProto.tzn != null && !jVar.field_favProto.tzn.isEmpty()) {
            rm rmVar = (rm) jVar.field_favProto.tzn.getFirst();
            rp rpVar = rmVar.tyi;
            if (rpVar != null) {
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.n("20source_publishid", rpVar.hjK + ",");
                dVar.n("21uxinfo", rpVar.hjJ + ",");
                dVar.n("22clienttime", bg.Nz() + ",");
                dVar.n("23source_type", (jVar.field_type == 16 ? 1 : 2) + ",");
                dVar.n("24scene", "5,");
                dVar.n("25scene_chatname", ",");
                dVar.n("26scene_username", jVar.field_fromUser + ",");
                dVar.n("27curr_publishid", ",");
                dVar.n("28curr_msgid", "0,");
                dVar.n("29curr_favid", jVar.field_id + ",");
                dVar.n("30isdownload", "0,");
                dVar.n("31chatroom_membercount", "0,");
                ((h) com.tencent.mm.kernel.h.h(h.class)).b(rmVar.fUY, dVar);
                w.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + dVar.JG());
                g.oUh.i(12989, new Object[]{dVar});
            }
        }
    }

    public static void a(a aVar, j jVar) {
        if (jVar.field_favProto.tzn != null && !jVar.field_favProto.tzn.isEmpty()) {
            rp rpVar = ((rm) jVar.field_favProto.tzn.getFirst()).tyi;
            if (rpVar != null) {
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.n("20source_publishid", rpVar.hjK + ",");
                dVar.n("21uxinfo", rpVar.hjJ + ",");
                dVar.n("22clienttime", bg.Nz() + ",");
                dVar.n("23video_statu", ",");
                dVar.n("24source_type", (jVar.field_type == 16 ? 1 : 2) + ",");
                dVar.n("25scene", "5,");
                dVar.n("26action_type", aVar.value + ",");
                dVar.n("27scene_chatname", ",");
                dVar.n("28scene_username", jVar.field_fromUser + ",");
                dVar.n("29curr_publishid", ",");
                dVar.n("30curr_msgid", "0,");
                dVar.n("31curr_favid", jVar.field_id + ",");
                dVar.n("32elapsed_time", "0,");
                dVar.n("33load_time", "0,");
                dVar.n("34is_load_complete", "0,");
                dVar.n("35destination", "0,");
                dVar.n("36chatroom_membercount", "0,");
                w.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + dVar.JG());
                g.oUh.i(12990, new Object[]{dVar});
            }
        }
    }

    public static void a(c cVar, j jVar, d dVar, int i) {
        if (jVar.field_favProto.tzn != null && !jVar.field_favProto.tzn.isEmpty()) {
            rp rpVar = ((rm) jVar.field_favProto.tzn.getFirst()).tyi;
            if (rpVar != null) {
                com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
                dVar2.n("20source_publishid", rpVar.hjK + ",");
                dVar2.n("21uxinfo", rpVar.hjJ + ",");
                dVar2.n("22clienttime", bg.Nz() + ",");
                dVar2.n("23video_statu", dVar.value + ",");
                dVar2.n("24source_type", (jVar.field_type == 16 ? 1 : 2) + ",");
                dVar2.n("25scene", "5,");
                dVar2.n("26action_type", cVar.value + ",");
                dVar2.n("27scene_chatname", ",");
                dVar2.n("28scene_username", jVar.field_fromUser + ",");
                dVar2.n("29curr_publishid", ",");
                dVar2.n("30curr_msgid", "0,");
                dVar2.n("31curr_favid", jVar.field_id + ",");
                dVar2.n("32chatroom_membercount", "0,");
                dVar2.n("33chatroom_toMemberCount", i + ",");
                w.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + dVar2.JG());
                g.oUh.i(12991, new Object[]{dVar2});
            }
        }
    }
}
