package com.tencent.mm.plugin.music.a;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.music.a.e.c;
import com.tencent.mm.plugin.music.a.e.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.ks;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class f implements e {
    public int mode = 1;
    public int nST;
    public List<String> nSU;
    public e nSV = new e();
    public j nSW = new j();
    private com.tencent.mm.plugin.music.a.c.a nSX;
    public com.tencent.mm.plugin.music.a.c.b nSY;
    public boolean nSZ;
    Runnable nTa = new Runnable(this) {
        final /* synthetic */ f nTb;

        {
            this.nTb = r1;
        }

        public final void run() {
            w.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[]{Boolean.valueOf(this.nTb.aNK().HK()), Boolean.valueOf(this.nTb.aNK().HJ())});
            if (this.nTb.aNK().HK() && !r1) {
                this.nTb.aNK().adL();
            }
        }
    };

    private class a implements Runnable {
        final /* synthetic */ f nTb;

        public a(f fVar) {
            this.nTb = fVar;
        }

        public final void run() {
            List list;
            long currentTimeMillis = System.currentTimeMillis();
            this.nTb.nSZ = true;
            anf aNJ = this.nTb.aNJ();
            List arrayList = new ArrayList();
            com.tencent.mm.sdk.b.b jbVar;
            switch (aNJ.tRH) {
                case 1:
                    jbVar = new jb();
                    jbVar.fOW.action = -5;
                    com.tencent.mm.sdk.b.a.urY.m(jbVar);
                    list = jbVar.fOX.fKC;
                    break;
                case 4:
                    jbVar = new jb();
                    jbVar.fOW.action = -4;
                    com.tencent.mm.sdk.b.a.urY.m(jbVar);
                    list = jbVar.fOX.fKC;
                    break;
                case 6:
                    jbVar = new fp();
                    jbVar.fKp.type = 18;
                    com.tencent.mm.sdk.b.a.urY.m(jbVar);
                    list = jbVar.fKq.fKC;
                    break;
                case 8:
                    jbVar = new jb();
                    jbVar.fOW.action = -6;
                    jbVar.fOW.fOY = aNJ;
                    com.tencent.mm.sdk.b.a.urY.m(jbVar);
                    list = jbVar.fOX.fKC;
                    break;
                default:
                    list = null;
                    break;
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    anf com_tencent_mm_protocal_c_anf = (anf) list.get(i);
                    i.aNT().s(com_tencent_mm_protocal_c_anf);
                    arrayList.add(h.h(com_tencent_mm_protocal_c_anf));
                }
            }
            w.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask run time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.nTb.nSZ = false;
            Runnable bVar = new b(this.nTb);
            bVar.nTc = arrayList;
            af.v(bVar);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ f nTb;
        public List<String> nTc;

        public b(f fVar) {
            this.nTb = fVar;
        }

        public final void run() {
            String h = h.h(this.nTb.aNJ());
            int i = this.nTb.nST;
            int i2 = 0;
            for (int i3 = 0; i3 < this.nTc.size(); i3++) {
                if (((String) this.nTc.get(i3)).equals(h)) {
                    i = i3;
                    i2 = 1;
                }
            }
            if (i2 != 0) {
                int i4;
                for (i4 = i + 1; i4 < this.nTc.size(); i4++) {
                    this.nTb.nSU.add(this.nTc.get(i4));
                }
                for (i4 = 0; i4 < i; i4++) {
                    this.nTb.nSU.add(this.nTc.get(i4));
                }
                w.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[]{Integer.valueOf(this.nTb.nSU.size()), Integer.valueOf(this.nTb.nST)});
                com.tencent.mm.sdk.b.b jcVar = new jc();
                jcVar.fPc.action = 5;
                com.tencent.mm.sdk.b.a.urY.m(jcVar);
            }
        }
    }

    public f() {
        ap.vd().a(520, this);
        this.nSU = new ArrayList();
    }

    public final void e(anf com_tencent_mm_protocal_c_anf) {
        if (com_tencent_mm_protocal_c_anf == null && this.nSU.size() == 0) {
            w.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null && musicList's size is 0");
            return;
        }
        if (com_tencent_mm_protocal_c_anf != null) {
            this.nSU.clear();
            this.nSU.add(h.h(com_tencent_mm_protocal_c_anf));
            this.nST = 0;
            i.aNT().s(com_tencent_mm_protocal_c_anf);
            if (this.mode == 2) {
                aNL();
            }
        }
        w.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
        if (com_tencent_mm_protocal_c_anf == null) {
            com_tencent_mm_protocal_c_anf = aNJ();
        }
        if (com_tencent_mm_protocal_c_anf != null) {
            w.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_anf.tRH)});
        }
        com.tencent.mm.am.a aNI = aNI();
        if (aNI == null || aNI.field_isBlock != 1) {
            int i;
            if (aNI != null) {
                if (this.nSX != null) {
                    ap.vd().c(this.nSX);
                }
                ap.vd().a(940, this);
                this.nSX = new com.tencent.mm.plugin.music.a.c.a(com_tencent_mm_protocal_c_anf == null ? 0 : com_tencent_mm_protocal_c_anf.tRH, aNI);
                ap.vd().a(this.nSX, 0);
            }
            if (com_tencent_mm_protocal_c_anf == null || !h.qd(com_tencent_mm_protocal_c_anf.tRH)) {
                w.i("MicroMsg.Music.MusicPlayerManager", "use musicPlayer");
                if (this.nSW.HJ()) {
                    this.nSW.adL();
                }
                this.nSV.b(aNI);
                if (com_tencent_mm_protocal_c_anf != null) {
                    i = com_tencent_mm_protocal_c_anf.tRH;
                } else {
                    i = 0;
                }
                g.oUh.i(14174, new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
            } else {
                w.i("MicroMsg.Music.MusicPlayerManager", "use qqMusicPlayer");
                if (this.nSV.HJ()) {
                    this.nSV.adL();
                }
                this.nSW.b(aNI);
                g.oUh.i(14174, new Object[]{Integer.valueOf(1), Integer.valueOf(com_tencent_mm_protocal_c_anf.tRH)});
                i = com_tencent_mm_protocal_c_anf.tRH;
            }
            if (i != 11) {
                aNN();
                return;
            }
            return;
        }
        w.i("MicroMsg.Music.MusicPlayerManager", "not play new music, music is block %s", new Object[]{aNI.field_musicId});
        this.nSV.o(com_tencent_mm_protocal_c_anf);
        this.nSV.r(com_tencent_mm_protocal_c_anf);
        g.d(aNI, true);
    }

    public final synchronized void d(List<anf> list, boolean z) {
        if (list != null) {
            if (list.size() != 0) {
                if (z) {
                    this.nSU.clear();
                }
                for (anf com_tencent_mm_protocal_c_anf : list) {
                    this.nSU.add(h.h(com_tencent_mm_protocal_c_anf));
                    i.aNT().s(com_tencent_mm_protocal_c_anf);
                }
            }
        }
        w.i("MicroMsg.Music.MusicPlayerManager", "appendMusicList error");
    }

    public final com.tencent.mm.am.a aNI() {
        if (this.nSU.size() <= this.nST) {
            return null;
        }
        return i.aNT().BE((String) this.nSU.get(this.nST));
    }

    public final anf aNJ() {
        if (this.nSU.size() <= this.nST) {
            return null;
        }
        com.tencent.mm.am.a BE = i.aNT().BE((String) this.nSU.get(this.nST));
        return BE != null ? BE.HG() : null;
    }

    public final void HH() {
        this.nSV.adL();
        if (this.nSW != null) {
            this.nSW.adL();
        }
        af.I(this.nTa);
    }

    public final c aNK() {
        anf aNJ = aNJ();
        if (aNJ == null || !h.qd(aNJ.tRH)) {
            return this.nSV;
        }
        return this.nSW;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2;
        if (kVar instanceof com.tencent.mm.plugin.music.a.c.a) {
            w.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd errCode:%d", new Object[]{Integer.valueOf(i2)});
            ap.vd().b(940, this);
            if (i == 4 && i2 == -24) {
                ks ksVar = ((com.tencent.mm.plugin.music.a.c.a) kVar).nTL;
                if (aNI().field_musicId.equals(ksVar.tqY)) {
                    HH();
                }
                com.tencent.mm.plugin.music.a.f.a aNT = i.aNT();
                str2 = ksVar.tqY;
                ContentValues contentValues = new ContentValues();
                contentValues.put("isBlock", Integer.valueOf(1));
                aNT.gUz.update("Music", contentValues, "musicId=?", new String[]{str2});
                com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) aNT.nUv.get(str2);
                if (aVar != null) {
                    aVar.field_isBlock = 1;
                }
                w.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd music is block %s", new Object[]{aNI().field_musicId});
            }
        } else if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.music.a.c.b bVar = (com.tencent.mm.plugin.music.a.c.b) kVar;
            aap com_tencent_mm_protocal_c_aap = bVar.nTM;
            String str3 = bVar.fPd.field_musicId;
            if (com_tencent_mm_protocal_c_aap != null && str3 != null) {
                for (String str22 : this.nSU) {
                    if (str22.equals(str3)) {
                        str3 = n.b(com_tencent_mm_protocal_c_aap.tGy);
                        String b = n.b(com_tencent_mm_protocal_c_aap.tGz);
                        String b2 = n.b(com_tencent_mm_protocal_c_aap.tGx);
                        com.tencent.mm.plugin.music.a.f.a aNT2 = i.aNT();
                        boolean z = bVar.nTN;
                        com.tencent.mm.sdk.e.c BE = aNT2.BE(str22);
                        if (BE == null) {
                            w.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[]{str22});
                        } else {
                            if (!bg.mA(str3)) {
                                BE.field_songAlbumUrl = str3;
                            }
                            BE.field_songHAlbumUrl = b;
                            BE.field_songLyric = b2;
                            aNT2.c(BE, new String[]{"songAlbumUrl", "songHAlbumUrl", "songLyric"});
                            aNT2.nUv.put(str22, BE);
                            aNT2.g(BE, z);
                        }
                        w.i("MicroMsg.Music.MusicPlayerManager", "get response %s %s %s", new Object[]{str3, b, b2});
                        if (!bg.mA(b)) {
                            com.tencent.mm.sdk.b.b jcVar = new jc();
                            jcVar.fPc.action = 6;
                            jcVar.fPc.fPd = bVar.fPd;
                            com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void aNL() {
        com.tencent.mm.sdk.f.e.post(new a(this), "music_get_list_task");
    }

    public final boolean aNM() {
        return this.nSU.size() > 0 && this.mode == 2;
    }

    public static void aNN() {
        w.i("MicroMsg.Music.MusicPlayerManager", "sendPreemptedEvent");
        com.tencent.mm.sdk.b.b jcVar = new jc();
        jcVar.fPc.action = 10;
        jcVar.fPc.state = "preempted";
        jcVar.fPc.appId = "not from app brand appid";
        jcVar.fPc.fPe = true;
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
    }

    public final void aNO() {
        w.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayIfPaused, delay_ms:%d", new Object[]{Integer.valueOf(600000)});
        af.I(this.nTa);
        af.f(this.nTa, 600000);
    }
}
