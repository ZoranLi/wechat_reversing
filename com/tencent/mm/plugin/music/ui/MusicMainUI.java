package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fr;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

@com.tencent.mm.ui.base.a(19)
public class MusicMainUI extends MMActivity implements e, com.tencent.mm.y.e {
    private ae gMa = new ae(Looper.getMainLooper());
    private c iOT = new c<jc>(this) {
        final /* synthetic */ MusicMainUI nVt;

        {
            this.nVt = r2;
            this.usg = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            final jc jcVar = (jc) bVar;
            switch (jcVar.fPc.action) {
                case 0:
                case 1:
                    this.nVt.nVj.setChecked(false);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 nVv;

                        public final void run() {
                            if (jcVar.fPc.action == 0 && i.aNS().mode != 2) {
                                this.nVv.nVt.nVm.a(this.nVv.nVt.nVo);
                                this.nVv.nVt.nVm.Y(100000 + i.aNS().nST);
                            }
                            this.nVv.nVt.aOv();
                        }
                    });
                    break;
                case 2:
                case 3:
                case 4:
                    this.nVt.nVj.setChecked(true);
                    break;
                case 5:
                    aq.B(this.nVt.uSU.uTo, R.l.eVz);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 nVv;

                        {
                            this.nVv = r1;
                        }

                        public final void run() {
                            h.I(this.nVv.nVt);
                            this.nVv.nVt.aOv();
                        }
                    });
                    break;
                case 6:
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 nVv;

                        public final void run() {
                            b h = this.nVv.nVt.nVo;
                            com.tencent.mm.am.a aVar = jcVar.fPc.fPd;
                            boolean z = false;
                            for (Entry value : h.nUQ.entrySet()) {
                                boolean z2;
                                com.tencent.mm.plugin.music.ui.b.a aVar2 = (com.tencent.mm.plugin.music.ui.b.a) ((View) value.getValue()).getTag();
                                if (aVar2.fPd.field_musicId.equals(aVar.field_musicId)) {
                                    aVar2.h(aVar, true);
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                z = z2;
                            }
                            if (!z) {
                                w.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
                                h.notifyDataSetChanged();
                            }
                        }
                    });
                    break;
                case 7:
                    if (i.aNS().mode == 2) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 nVv;

                            {
                                this.nVv = r1;
                            }

                            public final void run() {
                                this.nVv.nVt.nVm.Y(this.nVv.nVt.nVm.ys + 1);
                            }
                        });
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private long jXs;
    private int mode;
    private boolean nTN;
    private com.tencent.mm.plugin.music.a.e.c.a nTS = new com.tencent.mm.plugin.music.a.e.c.a(this) {
        final /* synthetic */ MusicMainUI nVt;

        {
            this.nVt = r1;
        }

        public final void cx(int i, int i2) {
            if (this.nVt.mode == 1 && !this.nVt.nVp) {
                float floatExtra = this.nVt.getIntent().getFloatExtra("key_offset", 0.0f);
                floatExtra *= 1000.0f;
                long currentTimeMillis = (long) (floatExtra + ((float) (System.currentTimeMillis() - this.nVt.getIntent().getLongExtra("music_player_beg_time", 0))));
                if (currentTimeMillis >= 0) {
                    this.nVt.nVo.z(this.nVt.nVm.ys, currentTimeMillis + 200);
                }
            } else if (i >= 0 && i2 > 0) {
                this.nVt.nVo.z(this.nVt.nVm.ys, (long) i);
            }
        }
    };
    private CheckBox nVj;
    private ImageButton nVk;
    private ImageButton nVl;
    private MusicViewPager nVm;
    private com.tencent.mm.pluginsdk.m.c nVn;
    private b nVo;
    private boolean nVp;
    private int nVq = 0;
    private Timer nVr;
    private int nVs = -1;
    private int scene;

    private class a implements Runnable {
        final /* synthetic */ MusicMainUI nVt;
        int position;

        public a(MusicMainUI musicMainUI, int i) {
            this.nVt = musicMainUI;
            this.position = i;
        }

        public final void run() {
            f aNS = i.aNS();
            int i = this.position;
            if (aNS.nSU.size() != 0) {
                i = (i - 100000) % aNS.nSU.size();
                if (i < 0) {
                    i += aNS.nSU.size();
                }
                if (i != aNS.nST) {
                    aNS.nST = i;
                    aNS.e(null);
                }
            }
            com.tencent.mm.am.a aNI = i.aNS().aNI();
            if (aNI != null) {
                if (aNI.HE()) {
                    this.nVt.h(aNI);
                }
                if (i.aNS().aNM()) {
                    this.nVt.nVm.DC = true;
                }
                this.nVt.g(aNI);
            }
        }
    }

    private class b extends com.tencent.mm.pluginsdk.m.c.a {
        final /* synthetic */ MusicMainUI nVt;

        public b(MusicMainUI musicMainUI) {
            this.nVt = musicMainUI;
        }

        public final void aOz() {
            w.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[]{Boolean.valueOf(true)});
            long aB = bg.aB(this.nVt.jXs);
            if (aB < 1200) {
                w.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:" + aB);
                return;
            }
            w.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:" + aB);
            this.nVt.jXs = bg.NA();
            this.nVt.nVq = this.nVt.nVq + 1;
            if (this.nVt.nVq % 2 == 0) {
                f aNS = i.aNS();
                int g = this.nVt.scene;
                g.oUh.a(285, 2, 1, false);
                com.tencent.mm.sdk.b.b jcVar;
                if (aNS.mode != 1) {
                    aNS.mode = 1;
                    jcVar = new jc();
                    jcVar.fPc.action = 5;
                    com.tencent.mm.sdk.b.a.urY.m(jcVar);
                    com.tencent.mm.plugin.music.a.g.J(2, 1, g);
                } else if (aNS.nSZ) {
                    w.i("MicroMsg.Music.MusicPlayerManager", "already running get list");
                } else {
                    aNS.mode = 2;
                    if (aNS.nSU.size() <= 1) {
                        aNS.aNL();
                    } else {
                        jcVar = new jc();
                        jcVar.fPc.action = 5;
                        com.tencent.mm.sdk.b.a.urY.m(jcVar);
                    }
                    com.tencent.mm.plugin.music.a.g.J(1, 2, g);
                }
            }
        }

        public final void onRelease() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        this.mode = getIntent().getIntExtra("key_mode", 2);
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.nTN = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
        this.nVm = (MusicViewPager) findViewById(R.h.cMx);
        this.nVo = new b(this, this.scene, this.nTN);
        this.nVm.a(this.nVo);
        this.nVm.b(this);
        this.nVm.setSystemUiVisibility(Downloads.RECV_BUFFER_SIZE);
        this.nVk = (ImageButton) findViewById(R.h.bqR);
        this.nVl = (ImageButton) findViewById(R.h.cCv);
        this.nVj = (CheckBox) findViewById(R.h.clZ);
        this.nVj.setChecked(!i.aNS().aNK().HJ());
        this.nVn = new com.tencent.mm.pluginsdk.m.c(this);
        this.nVj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MusicMainUI nVt;

            {
                this.nVt = r1;
            }

            public final void onClick(View view) {
                this.nVt.aOw();
                if (this.nVt.nVj.isChecked()) {
                    com.tencent.mm.am.b.qP();
                    this.nVt.nVj.setChecked(true);
                    MusicMainUI.aOy();
                    return;
                }
                this.nVt.nVp = true;
                if (i.aNS().aNK().HK()) {
                    i.aNS().aNK().resume();
                } else {
                    i.aNS().e(null);
                }
                this.nVt.aOx();
                this.nVt.nVj.setChecked(false);
            }
        });
        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
        if (!this.nVn.bDP()) {
            w.w("MicroMsg.Music.MusicMainUI", "not support shake");
        }
        aOv();
        this.nVm.Y(100000 + i.aNS().nST);
        aOx();
        int i = this.scene;
        if (i.aNS().aNI() != null) {
            w.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[]{Integer.valueOf(13041), Integer.valueOf(i), i.aNS().aNI().field_musicId, i.aNS().aNI().field_songName, i.aNS().aNI().field_songAlbum, Integer.valueOf(i.aNS().aNI().field_songId), i.aNS().aNI().field_songSinger, i.aNS().aNI().field_appId});
            g.oUh.i(13041, new Object[]{Integer.valueOf(i), r1.field_musicId, r1.field_songName, r1.field_songAlbum, Integer.valueOf(r1.field_songId), r1.field_songSinger, r1.field_appId});
        }
        g.oUh.a(285, 1, 1, false);
        com.tencent.mm.am.a aNI = i.aNS().aNI();
        if (aNI == null) {
            finish();
            return;
        }
        if (this.scene == 4 && i.aNS().mode == 2) {
            ap.yY();
            int i2 = com.tencent.mm.u.c.vr().getInt(83, 0);
            if (i2 < 3) {
                Toast.makeText(this, R.l.ens, 0).show();
                i2++;
                ap.yY();
                com.tencent.mm.u.c.vr().set(83, Integer.valueOf(i2));
            }
        }
        g(aNI);
        if (this.mode == 1) {
            if (this.nVr == null) {
                this.nVr = new Timer();
            }
            this.nVr.schedule(new TimerTask(this) {
                final /* synthetic */ MusicMainUI nVt;

                {
                    this.nVt = r1;
                }

                public final void run() {
                    this.nVt.nTS.cx(0, 0);
                }
            }, 0, 500);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    protected void onResume() {
        int i;
        super.onResume();
        com.tencent.mm.am.a aNI = i.aNS().aNI();
        if (aNI != null) {
            switch (aNI.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case 9:
                    i = 1;
                    break;
            }
        }
        i = 0;
        if (i == 0) {
            w.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            i.aNS().mode = 1;
        } else if (!this.nTN) {
            if (!(this.nVn == null || !this.nVn.bDP() || this.nVn.bDN())) {
                this.nVn.a(new b(this));
            }
            this.jXs = bg.NA();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.nVn != null) {
            this.nVn.aAA();
        }
    }

    private void aOv() {
        i.aNS();
        this.nVo.count = 200000;
        this.nVo.notifyDataSetChanged();
        if (i.aNS().aNM()) {
            this.nVm.DC = true;
        } else {
            this.nVm.DC = false;
        }
    }

    private void aOw() {
        if (this.nVr != null) {
            this.nVr.cancel();
        }
        this.nVr = null;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nVn != null) {
            this.nVn.aAA();
        }
        if (this.nVo != null) {
            b bVar = this.nVo;
            bVar.nSw.removeCallbacksAndMessages(null);
            d dVar = bVar.nUR;
            dVar.nSw.removeCallbacksAndMessages(null);
            dVar.gKW.clear();
        }
        aOw();
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
        aOy();
        if (!i.aNS().aNK().HJ()) {
            i.aNS().aNK().adL();
        }
        f aNS = i.aNS();
        if (!aNS.nSV.HJ() && !aNS.nSW.HJ()) {
            w.i("MicroMsg.Music.MusicPlayerManager", "really exit music");
            aNS.mode = 1;
        }
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickSend(View view) {
        final anf aNJ = i.aNS().aNJ();
        w.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[]{Integer.valueOf(aNJ.tRH), aNJ.tRP});
        if (aNJ.tRH == 11) {
            com.tencent.mm.sdk.b.b frVar = new fr();
            com.tencent.mm.sdk.b.a.urY.m(frVar);
            final String str = frVar.fKJ.appId;
            CharSequence charSequence = frVar.fKJ.fGs;
            final String str2 = frVar.fKJ.fKK;
            final int i = frVar.fKJ.fKL;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            w.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[]{str, charSequence, Integer.valueOf(i), str2});
            String string = getString(R.l.eqD, new Object[]{charSequence});
            if (TextUtils.isEmpty(aNJ.tRP)) {
                String[] strArr = new String[]{string};
                new ArrayList().add(Integer.valueOf(0));
                com.tencent.mm.ui.base.g.a(this, "", strArr, "", new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ MusicMainUI nVt;

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                h.C(str, str2, i);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return;
            }
            List arrayList = new ArrayList();
            String[] strArr2 = new String[]{getString(R.l.fnu), getString(R.l.fnv), getString(R.l.dTs), string};
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
            arrayList.add(Integer.valueOf(2));
            arrayList.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.g.a(this, "", strArr2, "", new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ MusicMainUI nVt;

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            h.H(this.nVt);
                            com.tencent.mm.plugin.music.a.g.qa(this.nVt.scene);
                            com.tencent.mm.plugin.music.a.g.qc(2);
                            return;
                        case 1:
                            h.c(aNJ, this.nVt);
                            com.tencent.mm.plugin.music.a.g.qb(this.nVt.scene);
                            com.tencent.mm.plugin.music.a.g.qc(1);
                            return;
                        case 2:
                            h.a(aNJ, this.nVt);
                            com.tencent.mm.plugin.music.a.g.qc(3);
                            return;
                        case 3:
                            h.C(str, str2, i);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else if (!TextUtils.isEmpty(aNJ.tRP)) {
            List arrayList2 = new ArrayList();
            String[] strArr3 = new String[]{getString(R.l.fnu), getString(R.l.fnv), getString(R.l.dTs), getString(R.l.ehx)};
            arrayList2.add(Integer.valueOf(0));
            arrayList2.add(Integer.valueOf(1));
            arrayList2.add(Integer.valueOf(2));
            arrayList2.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.g.a(this, "", strArr3, "", new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ MusicMainUI nVt;

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            h.H(this.nVt);
                            com.tencent.mm.plugin.music.a.g.qa(this.nVt.scene);
                            com.tencent.mm.plugin.music.a.g.qc(2);
                            return;
                        case 1:
                            h.c(aNJ, this.nVt);
                            com.tencent.mm.plugin.music.a.g.qb(this.nVt.scene);
                            com.tencent.mm.plugin.music.a.g.qc(1);
                            return;
                        case 2:
                            h.a(aNJ, this.nVt);
                            com.tencent.mm.plugin.music.a.g.qc(3);
                            return;
                        case 3:
                            h.b(aNJ, this.nVt);
                            com.tencent.mm.plugin.music.a.g.qc(4);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.djM;
    }

    public final void a(int i, float f, int i2) {
    }

    private void g(com.tencent.mm.am.a aVar) {
        if (!h.e(aVar) || this.nTN) {
            this.nVj.setVisibility(8);
            this.nVl.setVisibility(8);
            return;
        }
        this.nVj.setVisibility(0);
        this.nVl.setVisibility(0);
    }

    public final void V(int i) {
        w.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[]{Integer.valueOf(i)});
        if (i.aNS().aNM()) {
            this.nVm.DC = false;
        }
        this.gMa.removeCallbacksAndMessages(null);
        this.gMa.postDelayed(new a(this, i), 500);
        if (this.nVs == -1) {
            this.nVs = i;
        }
        if (this.nVs != i) {
            this.nVs = i;
            com.tencent.mm.plugin.music.a.g.nTd = true;
            g.oUh.a(285, 3, 1, false);
            com.tencent.mm.plugin.music.a.g.cv(1, this.scene);
        }
    }

    public final void W(int i) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2 && 1 == i) {
            if (intent != null) {
                h.a(i.aNS().aNJ(), intent, this);
                return;
            }
            w.e("MicroMsg.Music.MusicMainUI", "error on ActivityResult data == null");
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void aOx() {
        i.aNS().aNK().a(this.nTS);
    }

    public static void aOy() {
        i.aNS().aNK().a(null);
    }

    public final void h(com.tencent.mm.am.a aVar) {
        com.tencent.mm.am.a aNI = i.aNS().aNI();
        if (aNI != null && aNI.a(aVar) && this.nVl != null && this.nVk != null && this.nVj != null && this.nVl.getBackground() != null && this.nVk.getBackground() != null && this.nVj.getBackground() != null) {
            if (aVar.HE()) {
                int i = aVar.field_songLyricColor;
                this.nVl.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.nVk.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.nVj.getBackground().setColorFilter(i, Mode.MULTIPLY);
                return;
            }
            this.nVl.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.nVk.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.nVj.getBackground().setColorFilter(-1, Mode.MULTIPLY);
        }
    }
}
