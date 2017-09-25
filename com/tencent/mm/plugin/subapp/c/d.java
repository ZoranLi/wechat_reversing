package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.e.a.my;
import com.tencent.mm.e.a.rn;
import com.tencent.mm.e.a.ro;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.f;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.d.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d implements f, am {
    private static HashMap<Integer, c> oUw;
    private static d qSW;
    private final Set<com.tencent.mm.u.ag.d> gNx = new HashSet();
    private String gYf;
    private a oUx;
    private k qSV;
    private j qSX;
    private List<Long> qSY = new ArrayList();
    private com.tencent.mm.sdk.b.c qSZ = new com.tencent.mm.sdk.b.c<ro>(this) {
        final /* synthetic */ d qTc;

        {
            this.qTc = r2;
            this.usg = ro.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ro roVar = (ro) bVar;
            e Hk = e.Hk(roVar.fYA.fQX);
            ce ceVar = roVar.fYA.fCZ;
            if (Hk != null) {
                d bmY = d.bmY();
                String str = ceVar.field_talker;
                String str2 = roVar.fYA.description;
                String M = o.M(ab.getContext(), Hk.qTd);
                String str3 = "";
                if (M != null && M.length() > 0) {
                    String[] split = M.split(";");
                    str3 = str3 + split[0];
                    if (split.length > 1) {
                        str3 = str3 + split[1];
                    }
                }
                if (str2 != null) {
                    str3 = str3 + str2;
                }
                bmY.c(str, str3, ceVar.field_createTime);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qTa = new com.tencent.mm.sdk.b.c<rn>(this) {
        final /* synthetic */ d qTc;

        {
            this.qTc = r2;
            this.usg = rn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            String str = ((rn) bVar).fYz.path;
            if (str != null) {
                String at = h.at(str, false);
                if (!bg.mA(at)) {
                    d.bmZ().gR(at);
                }
                d.bmZ().lW(str);
                new File(str).delete();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qTb = new com.tencent.mm.sdk.b.c<my>(this) {
        final /* synthetic */ d qTc;

        {
            this.qTc = r2;
            this.usg = my.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            int i = (int) ((my) bVar).fUh.fCZ.field_msgId;
            ap.yY();
            au cA = com.tencent.mm.u.c.wT().cA((long) i);
            if (!(cA.field_msgId == 0 || cA.field_imgPath == null || bg.mA(cA.field_imgPath))) {
                g Hl = h.Hl(cA.field_imgPath);
                if (!(Hl == null || bg.mA(Hl.field_filename))) {
                    Hl.field_status = 3;
                    Hl.field_offset = 0;
                    Hl.field_createtime = System.currentTimeMillis() / 1000;
                    Hl.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    Hl.fRW = 16840;
                    h.a(Hl);
                    w.d("MicroMsg.VoiceRemindLogic", " file:" + Hl.field_filename + " msgid:" + Hl.field_msglocalid + "  stat:" + Hl.field_status);
                    if (Hl.field_msglocalid == 0 || bg.mA(Hl.field_user)) {
                        w.e("MicroMsg.VoiceRemindLogic", " failed msg id:" + Hl.field_msglocalid + " user:" + Hl.field_user);
                    } else {
                        cA.dv(1);
                        ap.yY();
                        com.tencent.mm.u.c.wT().a(cA.field_msgId, cA);
                        d.bna().run();
                    }
                }
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        oUw = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return k.gUx;
            }
        });
    }

    public final void a(com.tencent.mm.u.ag.d dVar) {
        w.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (dVar != null) {
            this.gNx.add(dVar);
        }
    }

    public final void b(com.tencent.mm.u.ag.d dVar) {
        w.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (dVar != null) {
            this.gNx.remove(dVar);
        }
    }

    public final void c(String str, String str2, long j) {
        Context context = ab.getContext();
        if (context == null) {
            w.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            return;
        }
        try {
            boolean sq = com.tencent.mm.i.a.sq();
            boolean so = com.tencent.mm.i.a.so();
            w.d("MicroMsg.SubCoreVoiceRemind", "shake " + sq + "sound " + so);
            if (!com.tencent.mm.u.o.fs(ap.getNotification().qh())) {
                if (sq) {
                    bg.k(context, true);
                }
                if (so) {
                    String sp = com.tencent.mm.i.a.sp();
                    Uri defaultUri = sp == e.gTd ? RingtoneManager.getDefaultUri(2) : Uri.parse(sp);
                    MediaPlayer iVar = new i();
                    try {
                        iVar.setDataSource(context, defaultUri);
                        iVar.setOnCompletionListener(new OnCompletionListener(this) {
                            final /* synthetic */ d qTc;

                            {
                                this.qTc = r1;
                            }

                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                try {
                                    mediaPlayer.release();
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                                }
                            }
                        });
                        if (ap.yZ().getStreamVolume(5) != 0) {
                            if (ap.yZ().qO()) {
                                int streamVolume = ap.yZ().getStreamVolume(8);
                                int streamMaxVolume = ap.yZ().getStreamMaxVolume(8);
                                int streamVolume2 = ap.yZ().getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                ap.yZ().ed(streamMaxVolume);
                                iVar.setAudioStreamType(8);
                                iVar.setLooping(true);
                                iVar.prepare();
                                iVar.setLooping(false);
                                iVar.start();
                                ap.yZ().ed(streamVolume);
                                w.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                            } else {
                                iVar.setAudioStreamType(5);
                                iVar.setLooping(true);
                                iVar.prepare();
                                iVar.setLooping(false);
                                iVar.start();
                            }
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                        iVar.release();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "relese error", new Object[0]);
                    }
                }
            } else if (sq) {
                bg.k(context, true);
            }
        } catch (Throwable e22) {
            w.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e22, "", new Object[0]);
        }
        if (this.gNx == null || this.gNx.size() == 0) {
            RemindDialog.r(context, str, str2);
            return;
        }
        for (com.tencent.mm.u.ag.d h : this.gNx) {
            h.h(str2, j);
        }
    }

    public final void gd(String str) {
        ap.yY();
        com.tencent.mm.u.c.wW().Ro(str);
        this.qSY.clear();
        ap.yY();
        Cursor As = com.tencent.mm.u.c.wT().As(str);
        As.moveToFirst();
        w.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!As.isAfterLast()) {
            ce auVar = new au();
            auVar.b(As);
            long j = auVar.field_msgId;
            w.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j + " status = " + auVar.field_status);
            As.moveToNext();
            this.qSY.add(Long.valueOf(j));
        }
        As.close();
        ap.yY();
        com.tencent.mm.u.c.wT().Aq(str);
    }

    public final void yK() {
        bna().run();
    }

    public final boolean K(long j) {
        boolean contains = this.qSY.contains(Long.valueOf(j));
        w.d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j);
        return contains;
    }

    public static d bmY() {
        com.tencent.mm.plugin.subapp.a aVar = (com.tencent.mm.plugin.subapp.a) ap.yR().gs("plugin.subapp");
        qSW = (d) aVar.Hj(d.class.getName());
        w.d("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", aVar, qSW, bg.bJZ());
        if (qSW == null) {
            f dVar = new d();
            qSW = dVar;
            ag.a.hlV = dVar;
            aVar.b(d.class.getName(), qSW);
        }
        return qSW;
    }

    public static k bmZ() {
        h.vG().uQ();
        if (bmY().qSV == null) {
            d bmY = bmY();
            bmY();
            if (bmY().oUx == null) {
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xu()).append("CommonOneMicroMsg.db").toString();
                bmY().oUx = g.a(d.class.hashCode(), stringBuilder2, oUw, false);
            }
            bmY.qSV = new k(bmY().oUx);
        }
        return bmY().qSV;
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        stringBuilder.append(com.tencent.mm.u.c.xu()).append("CommonOneMicroMsg.db");
        bmZ();
        com.tencent.mm.sdk.b.a.urY.b(this.qSZ);
        com.tencent.mm.sdk.b.a.urY.b(this.qTa);
        com.tencent.mm.sdk.b.a.urY.b(this.qTb);
        w.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", Integer.valueOf(hashCode()));
    }

    public final void aN(boolean z) {
        ap.yY();
        String xv = com.tencent.mm.u.c.xv();
        if (bg.mA(xv) || bg.mA(this.gYf) || !xv.equals(this.gYf)) {
            w.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : " + xv);
            this.gYf = xv;
            File file = new File(xv);
            if (!file.exists()) {
                file.mkdirs();
            }
            ap.yY();
            File file2 = new File(com.tencent.mm.u.c.xs());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
    }

    public final void onAccountRelease() {
        if (this.qSX != null) {
            this.qSX.fBo = 0;
        }
        if (qSW != null) {
            w.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            d dVar = qSW;
            if (dVar.oUx != null) {
                dVar.oUx.ha(dVar.hashCode());
                dVar.oUx = null;
            }
            dVar.gYf = "";
        }
        com.tencent.mm.sdk.b.a.urY.c(this.qSZ);
        com.tencent.mm.sdk.b.a.urY.c(this.qTa);
        com.tencent.mm.sdk.b.a.urY.c(this.qTb);
    }

    public static j bna() {
        h.vG().uQ();
        if (bmY().qSX == null) {
            bmY().qSX = new j();
        }
        return bmY().qSX;
    }
}
