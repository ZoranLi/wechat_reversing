package com.tencent.mm.plugin.sns.a.a;

import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class j {

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7),
        DetailTimeline(8);
        
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
        
        public int value;

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        private d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum e {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        private e(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(m mVar, boolean z, boolean z2) {
        int i = 2;
        bfc bhd = mVar.bhd();
        List list = bhd.ufB.tsO;
        if (list != null && !list.isEmpty()) {
            if ((bhd.ufB.tsN == 15 && mVar.tE(32)) || bhd.ufB.tsN == 18) {
                int i2;
                list.get(0);
                if (mVar.tE(32) && bhd.ufB.tsN == 15) {
                    bhd.ufG.hjJ = mVar.bhc().pZI;
                    bhd.ufG.hjK = bhd.mQY;
                }
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.n("20source_publishid", bhd.ufG.hjK + ",");
                dVar.n("21uxinfo", bhd.ufG.hjJ + ",");
                dVar.n("22clienttime", bg.Nz() + ",");
                dVar.n("23souce_type", (bhd.ufB.tsN == 15 ? 1 : 2) + ",");
                String str = "24scene";
                StringBuilder stringBuilder = new StringBuilder();
                if (z) {
                    i = 6;
                } else if (bhd.ufB.tsN == 15) {
                    i = 1;
                }
                dVar.n(str, stringBuilder.append(i).append(",").toString());
                dVar.n("25scene_chatname", ",");
                dVar.n("26scene_username", bhd.jNj + ",");
                dVar.n("27curr_publishid", bhd.mQY + ",");
                dVar.n("28curr_msgid", ",");
                dVar.n("29curr_favid", "0,");
                String str2 = "30isdownload";
                stringBuilder = new StringBuilder();
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                dVar.n(str2, stringBuilder.append(i2).append(",").toString());
                dVar.n("31chatroom_membercount", "0,");
                o.a(bhd.qui, dVar);
                w.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + dVar.JG());
                g.oUh.i(12989, new Object[]{dVar});
            }
        }
    }

    public static void a(b bVar, a aVar, m mVar) {
        bfc bhd = mVar.bhd();
        List list = bhd.ufB.tsO;
        if (list != null && !list.isEmpty()) {
            if ((bhd.ufB.tsN == 15 && mVar.tE(32)) || bhd.ufB.tsN == 18) {
                list.get(0);
                if (mVar.tE(32) && bhd.ufB.tsN == 15) {
                    bhd.ufG.hjJ = mVar.bhc().pZI;
                    bhd.ufG.hjK = bhd.mQY;
                }
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.n("20source_publishid", bhd.ufG.hjK + ",");
                dVar.n("21uxinfo", bhd.ufG.hjJ + ",");
                dVar.n("22clienttime", bg.Nz() + ",");
                dVar.n("23video_statu", ",");
                dVar.n("24source_type", (bhd.ufB.tsN == 15 ? 1 : 2) + ",");
                dVar.n("25scene", bVar.value + ",");
                dVar.n("26action_type", aVar.value + ",");
                dVar.n("27scene_chatname", ",");
                dVar.n("28scene_username", bhd.jNj + ",");
                dVar.n("29curr_publishid", bhd.mQY + ",");
                dVar.n("30curr_msgid", "0,");
                dVar.n("31curr_favid", "0,");
                dVar.n("32elapsed_time", "0,");
                dVar.n("33load_time", "0,");
                dVar.n("34is_load_complete", "0,");
                dVar.n("35destination", "0,");
                dVar.n("36chatroom_membercount", "0,");
                o.a(bhd.qui, dVar);
                w.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.JG());
                g.oUh.i(12990, new Object[]{dVar});
            }
        }
    }

    public static void a(a aVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4) {
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.n("20source_publishid", str + ",");
        dVar.n("21uxinfo", str2 + ",");
        dVar.n("22clienttime", bg.Nz() + ",");
        dVar.n("23video_statu", ",");
        dVar.n("24source_type", i + ",");
        dVar.n("25scene", i2 + ",");
        dVar.n("26action_type", aVar.value + ",");
        dVar.n("27scene_chatname", str4 + ",");
        dVar.n("28scene_username", str3 + ",");
        dVar.n("29curr_publishid", str5 + ",");
        dVar.n("30curr_msgid", j + ",");
        dVar.n("31curr_favid", i3 + ",");
        dVar.n("32elapsed_time", "0,");
        dVar.n("33load_time", "0,");
        dVar.n("34is_load_complete", "0,");
        dVar.n("35destination", "0,");
        dVar.n("36chatroom_membercount", i4 + ",");
        f.a(str5, dVar);
        w.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.JG());
        g.oUh.i(12990, new Object[]{dVar});
    }

    public static void a(d dVar, c cVar, e eVar, int i, m mVar) {
        bfc bhd = mVar.bhd();
        List list = bhd.ufB.tsO;
        if (list != null && !list.isEmpty()) {
            if ((bhd.ufB.tsN == 15 && mVar.tE(32)) || bhd.ufB.tsN == 18) {
                list.get(0);
                if (mVar.tE(32) && bhd.ufB.tsN == 15) {
                    bhd.ufG.hjJ = mVar.bhc().pZI;
                    bhd.ufG.hjK = bhd.mQY;
                }
                com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
                dVar2.n("20source_publishid", bhd.ufG.hjK + ",");
                dVar2.n("21uxinfo", bhd.ufG.hjJ + ",");
                dVar2.n("22clienttime", bg.Nz() + ",");
                dVar2.n("23video_statu", eVar.value + ",");
                dVar2.n("24source_type", (bhd.ufB.tsN == 15 ? 1 : 2) + ",");
                dVar2.n("25scene", dVar.value + ",");
                dVar2.n("26action_type", cVar.value + ",");
                dVar2.n("27scene_chatname", ",");
                dVar2.n("28scene_username", bhd.jNj + ",");
                dVar2.n("29curr_publishid", bhd.mQY + ",");
                dVar2.n("30curr_msgid", "0,");
                dVar2.n("31curr_favid", "0,");
                dVar2.n("32chatroom_membercount", "0,");
                dVar2.n("33chatroom_toMemberCount", i + ",");
                o.a(bhd.qui, dVar2);
                w.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar2.JG());
                g.oUh.i(12991, new Object[]{dVar2});
            }
        }
    }

    public static void a(c cVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4, int i5) {
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.n("20source_publishid", str + ",");
        dVar.n("21uxinfo", str2 + ",");
        dVar.n("22clienttime", bg.Nz() + ",");
        dVar.n("23video_statu", "3,");
        dVar.n("24source_type", i + ",");
        dVar.n("25scene", i2 + ",");
        dVar.n("26action_type", cVar.value + ",");
        dVar.n("27scene_chatname", str4 + ",");
        dVar.n("28scene_username", str3 + ",");
        dVar.n("29curr_publishid", str5 + ",");
        dVar.n("30curr_msgid", j + ",");
        dVar.n("31curr_favid", i3 + ",");
        dVar.n("32chatroom_membercount", i4 + ",");
        dVar.n("33chatroom_toMemberCount", i5 + ",");
        w.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar.JG());
        f.a(str5, dVar);
        g.oUh.i(12991, new Object[]{dVar});
    }
}
