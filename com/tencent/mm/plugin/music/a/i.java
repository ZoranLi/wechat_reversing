package com.tencent.mm.plugin.music.a;

import android.content.ClipboardManager;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.e;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.b.ch;
import com.tencent.mm.e.b.cm;
import com.tencent.mm.plugin.music.a.e.j;
import com.tencent.mm.plugin.music.ui.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;
import java.util.List;

public final class i implements am {
    private AudioManager gNq;
    private c iyu = new c<ad>(this) {
        final /* synthetic */ i nTs;

        {
            this.nTs = r2;
            this.usg = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            b aeVar = new ae();
            aeVar.fDk.fDm = new a(ab.getContext());
            com.tencent.mm.sdk.b.a.urY.m(aeVar);
            return false;
        }
    };
    private c<e> mcc = new c<e>(this) {
        final /* synthetic */ i nTs;

        {
            this.nTs = r2;
            this.usg = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!((e) bVar).fCm.fCn) {
                com.tencent.mm.plugin.music.a.a.a aVar = new com.tencent.mm.plugin.music.a.a.a();
                ap.yY();
                long longValue = ((Long) com.tencent.mm.u.c.vr().get(w.a.uGK, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue < com.tencent.mm.plugin.music.a.a.a.nTv.longValue()) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CleanMusicController", "don't scanMusic because the time is in one day");
                } else {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.uGK, Long.valueOf(currentTimeMillis));
                    com.tencent.mm.sdk.f.e.b(new Runnable(aVar) {
                        final /* synthetic */ a nTz;

                        {
                            this.nTz = r1;
                        }

                        public final void run() {
                            a.aNX();
                        }
                    }, "ScanMusicThread", 1);
                }
            }
            return false;
        }
    };
    private c nTm;
    private f nTn;
    private com.tencent.mm.plugin.music.a.f.a nTo;
    public ClipboardManager nTp;
    private com.tencent.mm.plugin.music.a.f.c nTq;
    private c nTr = new c<jb>(this) {
        final /* synthetic */ i nTs;

        {
            this.nTs = r2;
            this.usg = jb.class.getName().hashCode();
        }

        private static boolean a(jb jbVar) {
            int i;
            switch (jbVar.fOW.action) {
                case -3:
                    jbVar.fOX.fDU = i.aNS().aNK().HJ();
                    break;
                case -2:
                    jbVar.fOX.fOY = i.aNS().aNJ();
                    break;
                case -1:
                    i.aNS().HH();
                    break;
                case 0:
                    i.aNS().e(jbVar.fOW.fOY);
                    break;
                case 1:
                    i.aNS().aNK().aNC();
                    break;
                case 2:
                    i.aNS().aNK().resume();
                    break;
                case 3:
                    f aNS = i.aNS();
                    anf com_tencent_mm_protocal_c_anf = jbVar.fOW.fOY;
                    if (com_tencent_mm_protocal_c_anf == null) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "shake music item is null");
                        break;
                    }
                    aNS.nSU.clear();
                    aNS.nSU.add(h.h(com_tencent_mm_protocal_c_anf));
                    aNS.nST = 0;
                    i.aNT().s(com_tencent_mm_protocal_c_anf);
                    break;
                case 4:
                    f aNS2 = i.aNS();
                    List list = jbVar.fOW.fKC;
                    int i2 = jbVar.fOW.fOZ;
                    if (list != null && list.size() != 0 && i2 < list.size()) {
                        aNS2.nSU.clear();
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            anf com_tencent_mm_protocal_c_anf2 = (anf) list.get(i3);
                            aNS2.nSU.add(h.h(com_tencent_mm_protocal_c_anf2));
                            i.aNT().s(com_tencent_mm_protocal_c_anf2);
                        }
                        aNS2.nST = i2;
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList:%d", new Object[]{Integer.valueOf(aNS2.nST)});
                        com.tencent.mm.am.a aNI = aNS2.aNI();
                        if (aNI != null) {
                            i = aNI.field_musicType;
                        } else {
                            i = 0;
                        }
                        if (aNI != null && aNI.field_isBlock == 1) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "not play music list, music is block %s", new Object[]{aNS2.aNI().field_musicId});
                            aNS2.nSV.o(aNS2.aNJ());
                            aNS2.nSV.r(aNS2.aNJ());
                            g.d(aNI, true);
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "musicType %d", new Object[]{Integer.valueOf(i)});
                        if (i != 11) {
                            f.aNN();
                        }
                        aNS2.mode = 2;
                        if (!h.qd(i)) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "use musicPlayer");
                            if (aNS2.nSW.HJ()) {
                                aNS2.nSW.adL();
                            }
                            g.oUh.i(14174, new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
                            aNS2.nSV.b(aNI);
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "use qqMusicPlayer");
                        if (aNS2.nSV.HJ()) {
                            aNS2.nSV.adL();
                        }
                        g.oUh.i(14174, new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
                        aNS2.nSW.b(aNI);
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "music wrapper list error");
                    break;
                    break;
                case 5:
                    i.aNS().d(jbVar.fOW.fKC, jbVar.fOW.fPa);
                    break;
                case 6:
                    f aNS3 = i.aNS();
                    anf com_tencent_mm_protocal_c_anf3 = jbVar.fOW.fOY;
                    if (com_tencent_mm_protocal_c_anf3 != null) {
                        boolean z;
                        String h = h.h(com_tencent_mm_protocal_c_anf3);
                        if (aNS3.nSU != null) {
                            i = 0;
                            while (i < aNS3.nSU.size()) {
                                if (h.equals(aNS3.nSU.get(i))) {
                                    aNS3.nST = i;
                                    z = true;
                                    if (aNS3.nSU.size() > 1 && com_tencent_mm_protocal_c_anf3.tRZ) {
                                        aNS3.mode = 2;
                                    }
                                } else {
                                    i++;
                                }
                            }
                            z = false;
                            aNS3.mode = 2;
                            break;
                        }
                        z = false;
                        if (!z) {
                            aNS3.e(com_tencent_mm_protocal_c_anf3);
                            break;
                        }
                        aNS3.e(null);
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
                    break;
                case 7:
                    jbVar.fOX.fDU = i.aNS().aNK().gi(jbVar.fOW.position);
                    break;
                case 8:
                    jbVar.fOX.fPb = i.aNS().aNK().aNG();
                    break;
                case 9:
                    jbVar.fOX.fDU = i.aNS().aNK().HK();
                    break;
                case 10:
                    jbVar.fOX.fDU = i.aNS().aNK().aND();
                    break;
                case 11:
                    i.aNS().aNO();
                    break;
            }
            return false;
        }
    };

    public static i aNR() {
        i iVar = (i) ap.yR().gs("plugin.music");
        if (iVar != null) {
            return iVar;
        }
        Object iVar2 = new i();
        ap.yR().a("plugin.music", iVar2);
        return iVar2;
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        HashMap<Integer, com.tencent.mm.bj.g.c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("Music".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ i nTs;

            {
                this.nTs = r1;
            }

            public final String[] pP() {
                return new String[]{com.tencent.mm.sdk.e.i.a(ch.pw(), "Music")};
            }
        });
        hashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ i nTs;

            {
                this.nTs = r1;
            }

            public final String[] pP() {
                return new String[]{com.tencent.mm.sdk.e.i.a(cm.pw(), "PieceMusicInfo")};
            }
        });
        return hashMap;
    }

    public static f aNS() {
        if (aNR().nTn == null) {
            aNR().nTn = new f();
        }
        return aNR().nTn;
    }

    public static com.tencent.mm.plugin.music.a.f.a aNT() {
        if (aNR().nTo == null) {
            i aNR = aNR();
            ap.yY();
            aNR.nTo = new com.tencent.mm.plugin.music.a.f.a(com.tencent.mm.u.c.wO());
        }
        return aNR().nTo;
    }

    public static AudioManager aNU() {
        if (aNR().gNq == null) {
            aNR().gNq = (AudioManager) ab.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        return aNR().gNq;
    }

    public static c aNV() {
        if (aNR().nTm == null) {
            aNR().nTm = new c();
        }
        return aNR().nTm;
    }

    public static com.tencent.mm.plugin.music.a.f.c aNW() {
        if (aNR().nTq == null) {
            i aNR = aNR();
            ap.yY();
            aNR.nTq = new com.tencent.mm.plugin.music.a.f.c(com.tencent.mm.u.c.wO());
        }
        return aNR().nTq;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        this.mcc.bIy();
        this.nTr.bIy();
        this.iyu.bIy();
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.nTn != null) {
            com.tencent.mm.y.e eVar = this.nTn;
            eVar.HH();
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Music.MusicPlayerManager", "release");
            if (eVar.nSW != null) {
                j jVar = eVar.nSW;
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.QQMusicPlayer", "release");
                if (jVar.nUj != null) {
                    jVar.nUj.release();
                    jVar.nUj = null;
                }
            }
            af.I(eVar.nTa);
            eVar.nSU.clear();
            ap.vd().b(520, eVar);
            ap.vd().b(940, eVar);
        }
        this.nTn = null;
        this.nTm = null;
        this.nTo = null;
        this.gNq = null;
        this.nTp = null;
        this.nTq = null;
        com.tencent.mm.sdk.b.a.urY.c(this.nTr);
        this.nTr.dead();
        this.iyu.dead();
        this.mcc.dead();
    }
}
