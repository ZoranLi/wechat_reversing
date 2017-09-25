package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseLifeUI extends MMActivity implements e {
    boolean gKl = false;
    protected boolean hCZ = true;
    boolean htv = false;
    protected String iGy = "";
    private p kww;
    private boolean nWt = false;
    private NearLifeErrorContent nXA;
    private a nXB;
    private a nXC;
    private View nXD;
    private TextView nXE;
    private TextView nXF;
    private c nXG = c.Gk();
    private com.tencent.mm.plugin.nearlife.b.c nXH;
    private int nXI;
    private List<aiy> nXJ;
    protected aiy nXK = null;
    protected float nXL = 0.0f;
    protected float nXM = 0.0f;
    protected int nXN = 0;
    protected float nXO = 0.0f;
    protected long nXP = -1;
    protected long nXQ = -1;
    protected long nXR = -1;
    protected int nXS = 0;
    protected boolean nXT = false;
    protected int nXU = -1;
    protected boolean nXV = false;
    int nXW = 0;
    private OnClickListener nXX = new OnClickListener(this) {
        final /* synthetic */ BaseLifeUI nYa;

        {
            this.nYa = r1;
        }

        public final void onClick(View view) {
            BaseLifeUI.a(this.nYa);
        }
    };
    private OnClickListener nXY = new OnClickListener(this) {
        final /* synthetic */ BaseLifeUI nYa;

        {
            this.nYa = r1;
        }

        public final void onClick(View view) {
            if (this.nYa.nXK == null) {
                w.e("MicroMsg.BaseLifeUI", "Location is null");
                return;
            }
            g.oUh.i(11138, new Object[]{"1", Integer.valueOf(this.nYa.nXC.getCount() + 1), this.nYa.iGy});
            Intent intent = new Intent();
            intent.setClass(this.nYa, NearLifeCreatePoiUI.class);
            intent.putExtra("get_lat", this.nYa.nXK.tna);
            intent.putExtra("get_lng", this.nYa.nXK.tmZ);
            intent.putExtra("get_preci", this.nYa.nXK.twQ);
            intent.putExtra("get_poi_name", this.nYa.nXC.aOO());
            intent.putExtra("get_cur_lat", this.nYa.nXL);
            intent.putExtra("get_cur_lng", this.nYa.nXM);
            intent.putExtra("get_accuracy", this.nYa.nXO);
            intent.putExtra("get_loctype", this.nYa.nXN);
            intent.putExtra("search_id", this.nYa.iGy);
            intent.putExtra("get_is_mars", this.nYa.hCZ);
            this.nYa.startActivityForResult(intent, 1);
        }
    };
    private a nXZ = new a(this) {
        final /* synthetic */ BaseLifeUI nYa;

        {
            this.nYa = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (this.nYa.htv) {
                return false;
            }
            if (this.nYa.gKl) {
                return false;
            }
            if (!z) {
                return true;
            }
            n.a(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK, f, f2, (int) d2);
            this.nYa.gKl = true;
            w.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            this.nYa.nXK = new aiy();
            this.nYa.nXK.twS = "";
            this.nYa.nXK.twT = 0;
            this.nYa.nXK.tna = f2;
            this.nYa.nXK.tmZ = f;
            this.nYa.nXK.twR = "";
            this.nYa.nXK.twQ = (int) d2;
            this.nYa.nXL = f2;
            this.nYa.nXM = f;
            this.nYa.nXN = i;
            this.nYa.nXO = (float) d2;
            this.nYa.hCZ = this.nYa.nXG == null ? false : this.nYa.nXG.hCZ;
            ArrayList arrayList = this.nYa.nXB.nXs;
            if (arrayList == null || arrayList.size() <= 0) {
                this.nYa.j((double) f2, (double) f);
            } else {
                LatLongData latLongData = (LatLongData) arrayList.get(arrayList.size() - 1);
                this.nYa.j((double) latLongData.fOb, (double) latLongData.hGU);
                this.nYa.nXV = BaseLifeUI.b(latLongData.fOb, latLongData.hGU, f2, f);
            }
            this.nYa.nXB.nXw = new LatLongData(this.nYa.nXK.tna, this.nYa.nXK.tmZ);
            this.nYa.nXC.nXw = new LatLongData(this.nYa.nXK.tna, this.nYa.nXK.tmZ);
            BaseLifeUI.a(this.nYa, this.nYa.nhO ? this.nYa.nXC : this.nYa.nXB);
            this.nYa.fY(false);
            this.nYa.a(this.nYa.kww);
            return false;
        }
    };
    private String nXm = "";
    private View nXz;
    private int nbg = 1;
    MMLoadMoreListView ngO;
    boolean nhO = false;
    public int nhv = -1;

    public abstract a aOQ();

    public abstract a aOR();

    public abstract void j(double d, double d2);

    static /* synthetic */ void a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.nXI != -1 || baseLifeUI.nXH != null) {
            w.i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.fY(true)) {
            baseLifeUI.ngO.bSj();
        }
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, a aVar) {
        if (baseLifeUI.nXK == null) {
            w.e("MicroMsg.BaseLifeUI", "location is null");
            return;
        }
        Map hashMap = new HashMap();
        baseLifeUI.nXJ.clear();
        if (aVar.nXx && baseLifeUI.nXK != null) {
            baseLifeUI.nXJ.add(baseLifeUI.nXK);
            hashMap.put(new LatLongData(baseLifeUI.nXK.tna, baseLifeUI.nXK.tmZ), Integer.valueOf(1));
        }
        Iterator it = aVar.nXs.iterator();
        while (it.hasNext()) {
            LatLongData latLongData = (LatLongData) it.next();
            if (!hashMap.containsKey(latLongData)) {
                aiy com_tencent_mm_protocal_c_aiy = new aiy();
                com_tencent_mm_protocal_c_aiy.twS = "";
                com_tencent_mm_protocal_c_aiy.twT = 0;
                com_tencent_mm_protocal_c_aiy.tna = latLongData.fOb;
                com_tencent_mm_protocal_c_aiy.tmZ = latLongData.hGU;
                com_tencent_mm_protocal_c_aiy.twR = "";
                com_tencent_mm_protocal_c_aiy.twQ = 0;
                baseLifeUI.nXJ.add(com_tencent_mm_protocal_c_aiy);
                hashMap.put(latLongData, Integer.valueOf(1));
            }
        }
        baseLifeUI.nXH = null;
        baseLifeUI.nXI = -1;
        w.i("MicroMsg.BaseLifeUI", "list size:" + baseLifeUI.nXJ.size() + " show curpos: " + aVar.nXx);
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, String str) {
        w.d("MicroMsg.BaseLifeUI", "do auto query");
        baseLifeUI.qt(8);
        if (baseLifeUI.nbg <= 0) {
            w.i("MicroMsg.BaseLifeUI", "block by autoQueryInterval: %d", new Object[]{Integer.valueOf(baseLifeUI.nbg)});
            return;
        }
        aiy com_tencent_mm_protocal_c_aiy;
        if (baseLifeUI.nXH != null) {
            ap.vd().c(baseLifeUI.nXH);
            baseLifeUI.nXH = null;
        }
        if (baseLifeUI.nXJ.size() > 0) {
            com_tencent_mm_protocal_c_aiy = (aiy) baseLifeUI.nXJ.get(0);
        } else {
            w.i("MicroMsg.BaseLifeUI", "empty lbslist");
            com_tencent_mm_protocal_c_aiy = new aiy();
        }
        baseLifeUI.nXI = 0;
        baseLifeUI.nXC.BH(str);
        baseLifeUI.nXH = new com.tencent.mm.plugin.nearlife.b.c(1, baseLifeUI.nXW, com_tencent_mm_protocal_c_aiy.tmZ, com_tencent_mm_protocal_c_aiy.tna, com_tencent_mm_protocal_c_aiy.twQ, com_tencent_mm_protocal_c_aiy.twT, com_tencent_mm_protocal_c_aiy.twR, com_tencent_mm_protocal_c_aiy.twS, null, baseLifeUI.nhO ? baseLifeUI.nXC.aOO() : "", baseLifeUI.nhv, false);
        ap.vd().a(baseLifeUI.nXH, 0);
    }

    static /* synthetic */ void b(BaseLifeUI baseLifeUI, String str) {
        if (!bg.mA(str)) {
            if (baseLifeUI.nXH == null || !str.equals(baseLifeUI.nXH.nXl)) {
                baseLifeUI.qt(8);
                if (baseLifeUI.nXH != null) {
                    ap.vd().c(baseLifeUI.nXH);
                }
                if (baseLifeUI.nXK != null) {
                    baseLifeUI.nXC.aON();
                    baseLifeUI.nXC.BH(str);
                    baseLifeUI.fY(false);
                    baseLifeUI.ngO.bSj();
                }
            }
        }
    }

    static /* synthetic */ boolean b(float f, float f2, float f3, float f4) {
        return m.d((double) f, (double) f2, (double) f3, (double) f4) > 1000.0d;
    }

    public void aOS() {
        w.d("MicroMsg.BaseLifeUI", "init header");
        this.nXD = View.inflate(this, R.i.cZW, null);
        this.nXE = (TextView) this.nXD.findViewById(R.h.cJZ);
        this.nXF = (TextView) this.nXD.findViewById(R.h.cJY);
        this.nXD.setOnClickListener(this.nXY);
        this.nXz = View.inflate(this, R.i.dkN, null);
        this.ngO.addFooterView(this.nXz);
        this.nXz.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nhv = (int) (System.currentTimeMillis() / 1000);
        com.tencent.mm.plugin.nearlife.b.c.clear();
        ap.vd().a(603, this);
        this.nXW = getIntent().getIntExtra("near_life_scene", 0);
        this.nXJ = new ArrayList();
        KC();
        this.ngO.bSj();
        if (this.nXG != null) {
            this.nXG.b(this.nXZ);
        }
        this.htv = false;
    }

    public final void KC() {
        this.ngO = (MMLoadMoreListView) findViewById(R.h.cmw);
        MMLoadMoreListView mMLoadMoreListView = this.ngO;
        mMLoadMoreListView.vkX.setText(getString(R.l.eCH));
        this.nXA = (NearLifeErrorContent) findViewById(R.h.cmv);
        aOS();
        this.nXB = aOQ();
        this.nXC = aOR();
        this.ngO.setAdapter(this.nXB);
        this.nXA.iuu = this.ngO;
        this.nXB.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BaseLifeUI nYa;

            {
                this.nYa = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nYa.a(-1, false, "");
                this.nYa.finish();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ BaseLifeUI nYa;

            {
                this.nYa = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.nYa.ngO);
            }
        };
        this.kww = new p(true, true);
        this.kww.woe = new b(this) {
            final /* synthetic */ BaseLifeUI nYa;

            {
                this.nYa = r1;
            }

            public final void OF() {
                w.d("MicroMsg.BaseLifeUI", "click clear");
                if (this.nYa.nXH != null) {
                    ap.vd().c(this.nYa.nXH);
                    this.nYa.nXH = null;
                }
                this.nYa.nXC.aON();
                this.nYa.qt(8);
            }

            public final void OG() {
            }

            public final void mR(String str) {
                w.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[]{str});
                if (bg.mA(str)) {
                    OF();
                } else {
                    BaseLifeUI.a(this.nYa, str);
                }
            }

            public final void OD() {
                w.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
                this.nYa.nhO = false;
                this.nYa.ngO.setAdapter(this.nYa.nXB);
                this.nYa.nXB.notifyDataSetChanged();
                this.nYa.nXA.qu(this.nYa.nXB.nXy);
                if (!(this.nYa.nXB.aOP() || this.nYa.nXz == null)) {
                    this.nYa.nXz.setVisibility(0);
                }
                this.nYa.ngO.setOnTouchListener(null);
                this.nYa.qt(8);
                BaseLifeUI.a(this.nYa, this.nYa.nXB);
            }

            public final void OE() {
                w.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
                this.nYa.nXT = true;
                this.nYa.kww.setHint(this.nYa.getString(R.l.eCG));
                this.nYa.nhO = true;
                this.nYa.nXC.aON();
                this.nYa.ngO.setAdapter(this.nYa.nXC);
                this.nYa.nXC.notifyDataSetChanged();
                this.nYa.ngO.bSi();
                this.nYa.nXA.qu(this.nYa.nXC.nXy);
                if (this.nYa.nXz != null) {
                    this.nYa.nXz.setVisibility(8);
                }
                this.nYa.ngO.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ AnonymousClass5 nYb;

                    {
                        this.nYb = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.nYb.nYa.aHf();
                        return false;
                    }
                });
                BaseLifeUI.a(this.nYa, this.nYa.nXC);
            }

            public final boolean mQ(String str) {
                w.d("MicroMsg.BaseLifeUI", "search key click");
                BaseLifeUI.b(this.nYa, str);
                return false;
            }
        };
        this.ngO.vkV = new MMLoadMoreListView.a(this) {
            final /* synthetic */ BaseLifeUI nYa;

            {
                this.nYa = r1;
            }

            public final void ajC() {
                BaseLifeUI.a(this.nYa);
            }
        };
        this.ngO.bSh();
    }

    protected void onResume() {
        super.onResume();
        this.nXB.notifyDataSetChanged();
        this.nXG.a(this.nXZ, true);
    }

    protected void onDestroy() {
        ap.vd().b(603, this);
        super.onDestroy();
        if (this.nXG != null) {
            this.nXG.c(this.nXZ);
        }
    }

    protected void onPause() {
        super.onPause();
        this.nXG.c(this.nXZ);
    }

    protected int getLayoutId() {
        return R.i.djT;
    }

    private boolean fY(boolean z) {
        while (this.nXH == null) {
            if (this.nXJ.size() - 1 <= this.nXI) {
                this.nXI = -1;
                w.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            int b;
            this.nXI++;
            aiy com_tencent_mm_protocal_c_aiy = (aiy) this.nXJ.get(this.nXI);
            if (this.nXI == 0) {
                this.nXS++;
            }
            if (this.nhO) {
                b = this.nXC.b(new LatLongData(com_tencent_mm_protocal_c_aiy.tna, com_tencent_mm_protocal_c_aiy.tmZ));
                continue;
            } else {
                b = this.nXB.b(new LatLongData(com_tencent_mm_protocal_c_aiy.tna, com_tencent_mm_protocal_c_aiy.tmZ));
                continue;
            }
            if (b > 0) {
                avw a;
                if (this.nhO) {
                    a = this.nXC.a(new LatLongData(com_tencent_mm_protocal_c_aiy.tna, com_tencent_mm_protocal_c_aiy.tmZ));
                } else {
                    a = this.nXB.a(new LatLongData(com_tencent_mm_protocal_c_aiy.tna, com_tencent_mm_protocal_c_aiy.tmZ));
                }
                int i = this.nhO ? 1 : 0;
                if (com.tencent.mm.plugin.nearlife.b.c.qq(i)) {
                    if (-1 == this.nXP) {
                        this.nXP = System.currentTimeMillis();
                    }
                    this.nXH = new com.tencent.mm.plugin.nearlife.b.c(i, this.nXW, com_tencent_mm_protocal_c_aiy.tmZ, com_tencent_mm_protocal_c_aiy.tna, com_tencent_mm_protocal_c_aiy.twQ, com_tencent_mm_protocal_c_aiy.twT, com_tencent_mm_protocal_c_aiy.twR, com_tencent_mm_protocal_c_aiy.twS, a, this.nhO ? this.nXC.aOO() : "", this.nhv, z);
                    ap.vd().a(this.nXH, 0);
                    w.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[]{Integer.valueOf(this.nXI), Float.valueOf(com_tencent_mm_protocal_c_aiy.tna), Float.valueOf(com_tencent_mm_protocal_c_aiy.tmZ)});
                    return true;
                }
                this.nXI = -1;
                return false;
            }
        }
        w.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 603) {
            this.ngO.bSi();
            com.tencent.mm.plugin.nearlife.b.c cVar = (com.tencent.mm.plugin.nearlife.b.c) kVar;
            if (!bg.mA(cVar.nXm)) {
                this.nXm = cVar.nXm;
                LogoImageView logoImageView = (LogoImageView) this.nXz.findViewById(R.h.ctB);
                String str2 = this.nXm;
                ap.yY();
                logoImageView.imagePath = com.tencent.mm.u.c.xc();
                logoImageView.url = str2;
                logoImageView.neJ = 0;
                logoImageView.lKi = 0;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    r2 = BitmapFactory.decodeFile(logoImageView.imagePath + com.tencent.mm.a.g.n(str2.getBytes()));
                    if (r2 != null) {
                        if (logoImageView.neJ > 0 && logoImageView.lKi > 0) {
                            r2 = d.a(r2, logoImageView.neJ, logoImageView.lKi, true, false);
                        }
                        logoImageView.setImageBitmap(r2);
                    } else {
                        com.tencent.mm.sdk.f.e.post(new a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (com.tencent.mm.a.e.aO(str2)) {
                    r2 = (logoImageView.neJ <= 0 || logoImageView.lKi <= 0) ? d.Pg(str2) : d.d(str2, logoImageView.neJ, logoImageView.lKi, true);
                    if (r2 == null) {
                        logoImageView.setVisibility(8);
                    } else {
                        logoImageView.setImageBitmap(r2);
                    }
                } else {
                    logoImageView.setVisibility(8);
                }
            }
            this.iGy = cVar.iGy;
            this.nbg = cVar.nbg;
            com.tencent.mm.plugin.nearlife.b.c.qr(((com.tencent.mm.plugin.nearlife.b.c) kVar).fJA);
            if (this.nXH == null) {
                w.d("MicroMsg.BaseLifeUI", "scene is null");
                return;
            }
            w.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[]{Integer.valueOf(this.nXI), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r1)});
            boolean z = i2 == 0 || i2 == 101;
            a aVar;
            if (i == 0 || z) {
                if (-1 == this.nXQ) {
                    this.nXQ = System.currentTimeMillis();
                }
                this.nXR = System.currentTimeMillis();
                List list = cVar.nXn;
                aiy com_tencent_mm_protocal_c_aiy = (aiy) this.nXJ.get(this.nXI);
                LatLongData latLongData = new LatLongData(com_tencent_mm_protocal_c_aiy.tna, com_tencent_mm_protocal_c_aiy.tmZ);
                if (this.nhO && !this.nXH.nXo) {
                    this.nXC.aON();
                }
                if (this.nhO) {
                    this.nXC.a(latLongData, cVar.aOM(), cVar.aOL());
                } else {
                    this.nXB.a(latLongData, cVar.aOM(), cVar.aOL());
                }
                if (list == null || list.size() == 0) {
                    aVar = this.nhO ? this.nXC : this.nXB;
                    if (this.nXJ.size() - 1 == this.nXI) {
                        if (aVar.getCount() == 0) {
                            this.nXA.qu(aVar.nXy);
                        }
                        this.ngO.bSi();
                        if (!(aVar.aOP() || i2 == 101)) {
                            aOT();
                        }
                    }
                } else {
                    aVar = this.nhO ? this.nXC : this.nXB;
                    z = this.nXH.nXo;
                    this.ngO.setVisibility(0);
                    aVar.nXy = 0;
                    this.nXA.qu(this.nXC.nXy);
                    aVar.a(latLongData, list);
                    aVar.notifyDataSetChanged();
                    if (this.nXJ.size() - 1 == this.nXI && !aVar.aOP()) {
                        this.ngO.bSi();
                        aOT();
                    }
                }
                if (!(this.nXB.aOP() || this.nXz == null || this.nhO)) {
                    this.nXz.setVisibility(0);
                }
                if (this.nXz != null && !this.nhO) {
                    this.nXz.setVisibility(0);
                } else if (this.nXz != null) {
                    this.nXz.setVisibility(8);
                }
            } else {
                w.d("MicroMsg.BaseLifeUI", "error");
                if (this.nhO) {
                    aVar = this.nXC;
                } else {
                    aVar = this.nXB;
                }
                if (this.nXJ.size() - 1 == this.nXI && aVar.getCount() == 0) {
                    aVar.nXy = 1;
                    this.nXA.qu(aVar.nXy);
                }
            }
            this.nXH = null;
            fY(false);
        }
    }

    private void aOT() {
        if (this.nhO) {
            int i;
            try {
                w.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[]{Integer.valueOf(Integer.valueOf(com.tencent.mm.i.g.sV().getValue("POICreateForbiden")).intValue())});
                if (Integer.valueOf(com.tencent.mm.i.g.sV().getValue("POICreateForbiden")).intValue() == 1) {
                    return;
                }
            } catch (Exception e) {
            }
            a aVar = this.nXC;
            String trim = this.nXC.aOO().trim();
            Iterator it = aVar.nXq.iterator();
            while (it.hasNext()) {
                if (trim.equals(((com.tencent.mm.plugin.nearlife.b.a) it.next()).fDC.trim())) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                this.nXE.setText(String.format(getResources().getString(R.l.eDE), new Object[]{this.nXC.aOO()}));
                qt(0);
                return;
            }
            qt(8);
            return;
        }
        w.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    protected final void a(int i, boolean z, String str) {
        int i2;
        String str2;
        if (str != null && str.startsWith("mm_")) {
            str = "";
        }
        String str3 = "";
        String str4 = "";
        if (i >= 0) {
            i2 = z ? 3 : 1;
            if (this.nXV) {
                g gVar = g.oUh;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(z ? 5 : 4);
                gVar.i(11139, objArr);
            }
            if (z) {
                str4 = this.nXC.qs(i).nie;
            } else {
                str4 = this.nXB.qs(i).nie;
            }
            str3 = str4;
            str4 = this.nXB.qs(i).nif;
        } else {
            i2 = this.nXT ? 4 : 2;
        }
        if (this.nXK == null) {
            str2 = "null/null";
        } else {
            str2 = String.format("%f/%f", new Object[]{Float.valueOf(this.nXK.tna), Float.valueOf(this.nXK.tmZ)});
        }
        w.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s", new Object[]{Integer.valueOf(i + 1), str, Integer.valueOf(i), str3});
        g.oUh.i(11135, new Object[]{Integer.valueOf(i2), Integer.valueOf(i + 1), Long.valueOf(this.nXP), Long.valueOf(this.nXR), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.nXQ), Integer.valueOf(this.nXS), str2, str, Integer.valueOf(this.nhv), str3, com.tencent.mm.compatible.d.p.rA(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str4});
    }

    private void qt(int i) {
        this.ngO.removeFooterView(this.nXz);
        this.ngO.removeFooterView(this.nXD);
        MMLoadMoreListView mMLoadMoreListView = this.ngO;
        mMLoadMoreListView.removeFooterView(mMLoadMoreListView.kPJ);
        this.nXD.setVisibility(i);
        this.nXE.setVisibility(i);
        this.nXF.setVisibility(i);
        if (i == 0) {
            this.ngO.addFooterView(this.nXD);
            return;
        }
        mMLoadMoreListView = this.ngO;
        if (mMLoadMoreListView.kPJ == null) {
            mMLoadMoreListView.bSg();
        }
        try {
            mMLoadMoreListView.removeFooterView(mMLoadMoreListView.kPJ);
            mMLoadMoreListView.addFooterView(mMLoadMoreListView.kPJ);
        } catch (Exception e) {
        }
        this.ngO.addFooterView(this.nXz);
    }
}
