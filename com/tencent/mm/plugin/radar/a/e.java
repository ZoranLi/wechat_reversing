package com.tencent.mm.plugin.radar.a;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e implements com.tencent.mm.y.e {
    private Context context = null;
    private String fGV;
    public com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ e oHj;

        {
            this.oHj = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (this.oHj.htv) {
                w.d("MicroMsg.Radar.RadarManager", "cancel location");
                return false;
            } else if (this.oHj.oGW != null) {
                return false;
            } else {
                if (z) {
                    n.a(2006, f, f2, (int) d2);
                    w.d("MicroMsg.Radar.RadarManager", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
                    this.oHj.oGW = new Location(f2, f, (int) d2, i, "", "");
                    this.oHj.oHh.v(0, 0);
                } else {
                    this.oHj.stop();
                }
                e eVar = this.oHj;
                if (eVar.oGZ != null) {
                    eVar.oGZ.gv(true);
                }
                return false;
            }
        }
    };
    private LinkedList<ati> hNn = new LinkedList();
    public boolean htv = false;
    public com.tencent.mm.modelgeo.c hvP;
    public Location oGW = null;
    public b oGX = null;
    private a oGY = null;
    c oGZ = null;
    public e oHa = e.Stopped;
    public LinkedList<atg> oHb;
    private HashMap<String, String> oHc = new HashMap();
    private Map<String, com.tencent.mm.plugin.radar.a.c.d> oHd = new HashMap();
    private Map<String, com.tencent.mm.plugin.radar.a.c.d> oHe = new HashMap();
    private Map<Long, b> oHf = new HashMap();
    private Map<String, a> oHg = new HashMap();
    public aj oHh = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ e oHj;

        {
            this.oHj = r1;
        }

        public final boolean oQ() {
            if (this.oHj.htv) {
                w.d("MicroMsg.Radar.RadarManager", "cancel radar searching");
            } else {
                this.oHj.oHa = e.RadarSearching;
                w.d("MicroMsg.Radar.RadarManager", "status: %s", new Object[]{this.oHj.oHa});
                if (this.oHj.oGW == null || this.oHj.oGW.bDo()) {
                    w.e("MicroMsg.Radar.RadarManager", "error! location is null!");
                } else {
                    w.d("MicroMsg.Radar.RadarManager", "do once search");
                    this.oHj.oGX = new b(1, this.oHj.oGW.hCP, this.oHj.oGW.hCQ, this.oHj.oGW.accuracy, this.oHj.oGW.fPH, this.oHj.oGW.mac, this.oHj.oGW.fPJ);
                    ap.vd().a(this.oHj.oGX, 0);
                }
            }
            return false;
        }
    }, false);
    private ae oHi = new ae(this) {
        final /* synthetic */ e oHj;

        {
            this.oHj = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                ap.vd().a(new b(), 0);
            }
        }
    };

    public enum a {
        Selected,
        UnSelected
    }

    public static class b {
        public ati oHo;
        public com.tencent.mm.plugin.radar.a.c.d oHp;

        public b(ati com_tencent_mm_protocal_c_ati, com.tencent.mm.plugin.radar.a.c.d dVar) {
            this.oHo = com_tencent_mm_protocal_c_ati;
            this.oHp = dVar;
        }
    }

    public interface c {
        void a(int i, int i2, LinkedList<ati> linkedList);

        void b(int i, int i2, LinkedList<atf> linkedList);

        void gv(boolean z);
    }

    public enum d {
        SEARCHING,
        SEARCH_RETRUN,
        RALATIONCHAIN,
        RALATIONCHAIN_RETRUN,
        CREATING_CHAT
    }

    private enum e {
        Stopped,
        Locating,
        RadarSearching,
        Waiting
    }

    public e(c cVar, Context context) {
        this.oGZ = cVar;
        this.context = context;
    }

    public final void aVB() {
        aVC();
        this.htv = false;
        this.oGW = null;
        this.oHa = e.Stopped;
        this.oHh.KH();
        w.d("MicroMsg.Radar.RadarManager", "start radar");
        if (this.hvP == null) {
            this.hvP = com.tencent.mm.modelgeo.c.Gk();
        }
        this.oHa = e.Locating;
        this.hvP.a(this.gKp, true);
        w.d("MicroMsg.Radar.RadarManager", "status: %s", new Object[]{this.oHa});
    }

    public final void aVC() {
        switch (this.oHa) {
            case Stopped:
                return;
            case Locating:
                stop();
                return;
            case RadarSearching:
                if (this.oGX != null) {
                    stop();
                    ap.vd().c(this.oGX);
                    aVD();
                    return;
                }
                return;
            case Waiting:
                stop();
                aVD();
                break;
        }
        w.d("MicroMsg.Radar.RadarManager", "stop radar");
    }

    private void aVD() {
        this.oHi.sendEmptyMessageDelayed(1, 5000);
    }

    public final void stop() {
        this.htv = true;
        this.oHa = e.Stopped;
        this.oHh.KH();
    }

    private void a(int i, int i2, LinkedList<ati> linkedList) {
        if (this.oGZ != null) {
            this.oGZ.a(i, i2, linkedList);
        }
    }

    private void b(int i, int i2, LinkedList<atf> linkedList) {
        if (this.oGZ != null) {
            this.oGZ.b(i, i2, linkedList);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case 425:
                if (this.oGX == kVar) {
                    b bVar = (b) kVar;
                    if (bVar.fJA == 1) {
                        this.oHa = e.Waiting;
                        if (i == 0 && i2 == 0) {
                            w.d("MicroMsg.Radar.RadarManager", "rader members count: %s ticket: %s", new Object[]{Integer.valueOf(bVar.aVz()), this.fGV});
                            this.oHh.v(3000, 3000);
                            Collection collection = ((atk) bVar.gUA.hsk.hsr).teK;
                            if (collection != null) {
                                Iterator it = collection.iterator();
                                while (it.hasNext()) {
                                    ati com_tencent_mm_protocal_c_ati = (ati) it.next();
                                    ap.yY();
                                    com.tencent.mm.u.c.xB().eI(com_tencent_mm_protocal_c_ati.jNj, com_tencent_mm_protocal_c_ati.tBM);
                                }
                            }
                            this.hNn.clear();
                            this.hNn.addAll(collection);
                            LinkedList linkedList = this.hNn;
                            bVar.aVz();
                            a(i, i2, linkedList);
                            w.d("MicroMsg.Radar.RadarManager", "status: %s", new Object[]{this.oHa});
                            return;
                        }
                        stop();
                        a(i, i2, null);
                        return;
                    }
                    a(i, i2, null);
                    return;
                }
                return;
            case 602:
                w.d("MicroMsg.Radar.RadarManager", " MMFunc_MMRadarRelationChain ");
                if (i == 0 && i2 == 0) {
                    ath com_tencent_mm_protocal_c_ath = (ath) ((a) kVar).gUA.hsk.hsr;
                    this.fGV = com_tencent_mm_protocal_c_ath.tuo;
                    if (com_tencent_mm_protocal_c_ath.ksW > 0) {
                        LinkedList linkedList2 = com_tencent_mm_protocal_c_ath.teK;
                        int i3 = com_tencent_mm_protocal_c_ath.ksW;
                        b(i, i2, linkedList2);
                        return;
                    }
                    b(i, i2, null);
                    return;
                }
                b(i, i2, null);
                return;
            default:
                return;
        }
    }

    public final HashMap<String, String> aVE() {
        if (this.oHc == null) {
            this.oHc = new HashMap();
        }
        return this.oHc;
    }

    public final Map<Long, b> aVF() {
        if (this.oHf == null) {
            this.oHf = new HashMap();
        }
        return this.oHf;
    }

    private Map<String, com.tencent.mm.plugin.radar.a.c.d> aVG() {
        if (this.oHd == null) {
            this.oHd = new HashMap();
        }
        return this.oHd;
    }

    private Map<String, com.tencent.mm.plugin.radar.a.c.d> aVH() {
        if (this.oHe == null) {
            this.oHe = new HashMap();
        }
        return this.oHe;
    }

    public final Map<String, a> aVI() {
        if (this.oHg == null) {
            this.oHg = new HashMap();
        }
        return this.oHg;
    }

    public final void a(String str, com.tencent.mm.plugin.radar.a.c.d dVar) {
        com.tencent.mm.plugin.radar.a.c.d dVar2 = (com.tencent.mm.plugin.radar.a.c.d) aVG().get(str);
        if (dVar2 != null && dVar2 != dVar) {
            aVH().put(str, dVar2);
        }
    }

    public final void b(String str, com.tencent.mm.plugin.radar.a.c.d dVar) {
        if (!bg.mz(str).equals("")) {
            a(str, dVar);
            aVG().put(str, dVar);
        }
    }

    public final com.tencent.mm.plugin.radar.a.c.d a(ati com_tencent_mm_protocal_c_ati, boolean z) {
        com.tencent.mm.plugin.radar.a.c.d ag = ag(com_tencent_mm_protocal_c_ati.jNj, z);
        if (ag == null) {
            return ag(com_tencent_mm_protocal_c_ati.twU, z);
        }
        return ag;
    }

    public final com.tencent.mm.plugin.radar.a.c.d ag(String str, boolean z) {
        Map aVG = !z ? aVG() : aVH();
        if (bg.mz(str).equals("")) {
            return null;
        }
        return (com.tencent.mm.plugin.radar.a.c.d) aVG.get(str);
    }

    public final void a(ati com_tencent_mm_protocal_c_ati) {
        if (aVI() != null && com_tencent_mm_protocal_c_ati != null) {
            String b = com.tencent.mm.plugin.radar.ui.c.b(com_tencent_mm_protocal_c_ati);
            if (aVI().containsKey(b)) {
                aVI().remove(b);
            } else {
                aVI().put(b, a.Selected);
            }
        }
    }
}
