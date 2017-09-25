package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI extends BaseLifeUI implements e {
    private String gkC = "";
    private OnClickListener mAD = new OnClickListener(this) {
        final /* synthetic */ CheckInLifeUI nYr;

        {
            this.nYr = r1;
        }

        public final void onClick(View view) {
            CheckInLifeUI.a(this.nYr, view, false);
        }
    };
    private String nYe = "";
    private b nYk;
    private b nYl;
    private ArrayList<LatLongData> nYm;
    private b nYn = null;
    private aix nYo;
    private OnClickListener nYp = new OnClickListener(this) {
        final /* synthetic */ CheckInLifeUI nYr;

        {
            this.nYr = r1;
        }

        public final void onClick(View view) {
            CheckInLifeUI.a(this.nYr, view, true);
        }
    };
    private a nYq = new a(this) {
        final /* synthetic */ CheckInLifeUI nYr;

        {
            this.nYr = r1;
        }

        public final void b(Addr addr) {
            w.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[]{addr.toString()});
            if (bg.mA(this.nYr.gkC)) {
                this.nYr.gkC = addr.hCG;
                this.nYr.nYk.cZ(this.nYr.gkC, addr.hCO);
            }
        }
    };

    static /* synthetic */ void a(CheckInLifeUI checkInLifeUI, View view, boolean z) {
        w.d("MicroMsg.CheckInLifeUI", "click tag");
        if (view.getTag() instanceof a) {
            LatLongData BI;
            int BJ;
            a aVar = (a) view.getTag();
            com.tencent.mm.plugin.nearlife.b.a aVar2 = aVar.nYg;
            Intent intent = new Intent();
            try {
                intent.putExtra("get_poi_item_buf", aVar2.nXh.toByteArray());
                intent.putExtra("location_ctx", aVar2.nXg.tZp.sYA);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            }
            if (z) {
                BI = checkInLifeUI.nYl.BI(aVar.nWY);
                BJ = checkInLifeUI.nYl.BJ(aVar.nWY);
                checkInLifeUI.a(BJ, true, aVar.nWY);
            } else {
                BI = checkInLifeUI.nYk.BI(aVar.nWY);
                BJ = checkInLifeUI.nYk.BJ(aVar.nWY);
                checkInLifeUI.a(BJ, false, aVar.nWY);
            }
            intent.putExtra("report_index", BJ);
            intent.putExtra("first_start_time", checkInLifeUI.nXP);
            intent.putExtra("lastSuccStamp", checkInLifeUI.nXR);
            intent.putExtra("firstSuccStamp", checkInLifeUI.nXQ);
            intent.putExtra("reqLoadCnt", checkInLifeUI.nXS);
            intent.putExtra("entry_time", checkInLifeUI.nhv);
            intent.putExtra("search_id", aVar2.nie);
            if (BI == null) {
                BI = checkInLifeUI.nXK == null ? new LatLongData(-85.0f, -1000.0f) : new LatLongData(checkInLifeUI.nXK.tna, checkInLifeUI.nXK.tmZ);
            }
            w.i("MicroMsg.CheckInLifeUI", "lbs.Type %d", new Object[]{Integer.valueOf(aVar2.jOc)});
            switch (aVar.type) {
                case 0:
                    if (BI != null) {
                        intent.putExtra("get_lat", BI.fOb);
                        intent.putExtra("get_lng", BI.hGU);
                    }
                    if (!bg.mA(checkInLifeUI.gkC)) {
                        intent.putExtra("get_city", checkInLifeUI.gkC);
                    }
                    intent.putExtra("get_poi_classify_type", aVar2.jOc);
                    intent.putExtra("get_poi_address", a.aV(aVar2.nXd));
                    intent.putExtra("get_poi_classify_id", aVar2.nWY);
                    intent.putExtra("get_poi_name", aVar2.fDC);
                    intent.putExtra("get_poi_showflag", aVar2.gkv);
                    break;
                case 1:
                    if (BI != null) {
                        intent.putExtra("get_lat", BI.fOb);
                        intent.putExtra("get_lng", BI.hGU);
                    }
                    intent.putExtra("get_city", aVar2.fDC);
                    break;
            }
            intent.putExtra("get_cur_lat", checkInLifeUI.nXL);
            intent.putExtra("get_cur_lng", checkInLifeUI.nXM);
            intent.putExtra("get_accuracy", checkInLifeUI.nXO);
            intent.putExtra("get_loctype", checkInLifeUI.nXN);
            intent.putExtra("get_is_mars", checkInLifeUI.hCZ);
            checkInLifeUI.setResult(-1, intent);
            checkInLifeUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eCE);
        this.nYn = b.Gi();
        this.nYo = new aix();
        this.nYe = getIntent().getStringExtra("get_poi_classify_id");
        try {
            this.nYo = (aix) this.nYo.aD(getIntent().getByteArrayExtra("get_poi_item_buf"));
            if (this.nYo != null) {
                this.nYe = this.nYo.nWY;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            this.nYo = null;
        }
        if (bg.mA(this.nYe)) {
            this.gkC = getIntent().getStringExtra("get_city");
        }
        if (!bg.mA(this.gkC)) {
            this.nYe = this.nYk.cZ(this.gkC, "").nWY;
        }
        this.nYk.nYe = this.nYe;
        if (this.nYo != null && !bg.mA(this.nYo.nWY)) {
            b bVar = this.nYk;
            com.tencent.mm.plugin.nearlife.b.a aVar = new com.tencent.mm.plugin.nearlife.b.a("", this.nYo);
            if (bVar.nYc == null) {
                bVar.a(aVar, 1);
            } else {
                bVar.a(aVar, 2);
            }
        }
    }

    public final void aOS() {
        super.aOS();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nYn != null) {
            this.nYn.a(this.nYq);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.djT;
    }

    public final a aOQ() {
        if (this.nYm == null) {
            this.nYm = L(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.nYk != null) {
            return this.nYk;
        }
        this.nYk = new b(this, this.mAD, "viewlist", false);
        if (!(this.nYm == null || this.nYm.size() == 0)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.nYm.get(this.nYm.size() - 1));
            this.nYk.K(arrayList);
            this.nYk.nXx = false;
        }
        return this.nYk;
    }

    public final a aOR() {
        if (this.nYm == null) {
            this.nYm = L(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.nYl != null) {
            return this.nYl;
        }
        this.nYl = new b(this, this.nYp, "searchlist", true);
        this.nYl.K(this.nYm);
        this.nYl.nXx = true;
        return this.nYl;
    }

    public final void j(double d, double d2) {
        w.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
        if (this.nYn != null && bg.mA(this.gkC)) {
            this.nYn.a(d, d2, this.nYq);
        }
    }

    private static ArrayList<LatLongData> L(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<LatLongData> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (2 == split.length) {
                try {
                    arrayList2.add(new LatLongData(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue()));
                } catch (NumberFormatException e) {
                }
            }
        }
        w.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + arrayList2.size());
        return arrayList2;
    }
}
