package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.i.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationWidget extends LinearLayout {
    float aLh;
    private String gkC;
    private int gkv;
    private float hCP;
    private float hCQ;
    private boolean hCZ;
    private c nXG;
    float nXM;
    private com.tencent.mm.modelgeo.a.a nXZ;
    private aix nYo;
    private com.tencent.mm.modelgeo.b.a naV;
    private String ndv;
    private com.tencent.mm.modelgeo.b ngr;
    private Activity oqR;
    private ImageView qpP;
    private TextView qqN;
    private View quD;
    private View quE;
    private int[] quF;
    private ImageView[] quG;
    private int quH;
    private TextView quI;
    private byte[] quJ;
    private String quK;
    private String quL;
    private int quM;
    float quN;
    int quO;
    a quP;
    private boolean quQ;
    private b quR;
    private int score;

    public interface a {
        ArrayList<com.tencent.mm.compatible.util.Exif.a> biO();

        boolean biP();
    }

    class b {
        String iGy = "";
        int index;
        long nXP = -1;
        long nXQ = -1;
        long nXR = -1;
        int nXS = 0;
        int nhv = 0;
        final /* synthetic */ LocationWidget quS;

        b(LocationWidget locationWidget) {
            this.quS = locationWidget;
        }
    }

    public LocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.quF = new int[]{f.pDG, f.pDH, f.pDI, f.pDJ, f.pDK};
        this.quG = new ImageView[5];
        this.hCP = -1000.0f;
        this.hCQ = -1000.0f;
        this.quM = 0;
        this.nYo = null;
        this.gkv = 0;
        this.quN = 0.0f;
        this.nXM = 0.0f;
        this.aLh = 0.0f;
        this.quO = -1;
        this.hCZ = true;
        this.nXG = c.Gk();
        this.quP = null;
        this.quQ = false;
        this.naV = new com.tencent.mm.modelgeo.b.a(this) {
            final /* synthetic */ LocationWidget quS;

            {
                this.quS = r1;
            }

            public final void b(Addr addr) {
                w.i("MicroMsg.LocationWidget", "get info %s", new Object[]{addr.toString()});
                if (this.quS.quQ) {
                    this.quS.bja();
                    if (bg.mA(this.quS.gkC)) {
                        this.quS.gkC = addr.hCG;
                        this.quS.bja();
                    }
                }
            }
        };
        this.nXZ = new com.tencent.mm.modelgeo.a.a(this) {
            final /* synthetic */ LocationWidget quS;

            {
                this.quS = r1;
            }

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                if (!z) {
                    return true;
                }
                w.d("MicroMsg.LocationWidget", "get location %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
                e.JX().a(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK, i != 0, this.quS.nXG == null ? false : this.quS.nXG.hCZ, f, f2, (int) d2);
                n.a(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK, f, f2, 0);
                if (!this.quS.quQ) {
                    return false;
                }
                if (this.quS.hCP == -1000.0f || this.quS.hCQ == -1000.0f) {
                    this.quS.hCP = f2;
                    this.quS.hCQ = f;
                }
                return false;
            }
        };
        this.quR = null;
        e((MMActivity) context);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.quF = new int[]{f.pDG, f.pDH, f.pDI, f.pDJ, f.pDK};
        this.quG = new ImageView[5];
        this.hCP = -1000.0f;
        this.hCQ = -1000.0f;
        this.quM = 0;
        this.nYo = null;
        this.gkv = 0;
        this.quN = 0.0f;
        this.nXM = 0.0f;
        this.aLh = 0.0f;
        this.quO = -1;
        this.hCZ = true;
        this.nXG = c.Gk();
        this.quP = null;
        this.quQ = false;
        this.naV = /* anonymous class already generated */;
        this.nXZ = /* anonymous class already generated */;
        this.quR = null;
        e((MMActivity) context);
    }

    private void e(MMActivity mMActivity) {
        this.oqR = mMActivity;
        View inflate = View.inflate(mMActivity, getLayoutResource(), this);
        this.quD = inflate.findViewById(f.pDf);
        this.quI = (TextView) this.quD.findViewById(f.ccr);
        this.qqN = (TextView) this.quD.findViewById(f.pDh);
        this.qpP = (ImageView) this.quD.findViewById(f.pDg);
        this.quE = inflate.findViewById(f.pDF);
        for (int i = 0; i < 5; i++) {
            this.quG[i] = (ImageView) this.quE.findViewById(this.quF[i]);
            this.quG[i].setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LocationWidget quS;

                public final void onClick(View view) {
                    if (this.quS.score == i + 1) {
                        this.quS.score = this.quS.score - 1;
                    } else {
                        this.quS.score = i + 1;
                    }
                    this.quS.biY();
                }
            });
        }
        this.ngr = com.tencent.mm.modelgeo.b.Gi();
        this.quD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LocationWidget quS;

            {
                this.quS = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.quS.oqR, "android.permission.ACCESS_COARSE_LOCATION", 64, "", ""))});
                if (com.tencent.mm.pluginsdk.i.a.a(this.quS.oqR, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                    this.quS.biZ();
                }
            }
        });
        this.quL = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!bg.mA(this.quL)) {
            this.hCP = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.hCQ = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.ndv = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.quK = mMActivity.getIntent().getStringExtra("Kpoi_address");
            bja();
        }
        this.quH = bg.getInt(g.sV().getValue("SnsPostPOICommentSwitch"), 0);
        biY();
    }

    private void biY() {
        int i = 0;
        w.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[]{Integer.valueOf(this.quH), this.quL, Integer.valueOf(this.quM), Integer.valueOf(this.gkv), Boolean.valueOf(bg.bJX())});
        if (bg.bJX() || this.quH == 0 || bg.mA(this.quL) || this.quM == 1 || (this.gkv & 1) == 0) {
            this.quE.setVisibility(8);
            return;
        }
        this.quE.setVisibility(0);
        while (i < this.score) {
            this.quG[i].setImageResource(i.pJy);
            i++;
        }
        for (i = this.score; i < 5; i++) {
            this.quG[i].setImageResource(i.pJx);
        }
    }

    public final void biZ() {
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.nYo.toByteArray());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
        }
        if (!bg.mA(this.quL)) {
            intent.putExtra("get_poi_classify_id", this.quL);
        } else if (!bg.mA(this.gkC)) {
            intent.putExtra("get_city", this.gkC);
        }
        intent.putExtra("get_lat", this.hCP);
        intent.putExtra("get_lng", this.hCQ);
        if (this.quP != null) {
            ArrayList biO = this.quP.biO();
            if (biO != null) {
                Q(biO);
                ArrayList arrayList = new ArrayList();
                Iterator it = biO.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                    arrayList.add(String.format("%f\n%f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)}));
                }
            }
        }
        d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
    }

    private void Q(ArrayList<com.tencent.mm.compatible.util.Exif.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            com.tencent.mm.compatible.util.Exif.a aVar;
            com.tencent.mm.plugin.report.service.g.oUh.A(11139, "1");
            if (((double) Math.abs(-1000.0f - this.hCP)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.hCQ)) > 1.0E-6d) {
                aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(arrayList.size() - 1);
                if (c(aVar.latitude, aVar.longitude, (double) this.hCP, (double) this.hCQ)) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(11139, "2");
                }
            }
            int i = 0;
            while (i < arrayList.size()) {
                Object obj;
                for (int i2 = i + 1; i2 < arrayList.size(); i2++) {
                    aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i);
                    com.tencent.mm.compatible.util.Exif.a aVar2 = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i2);
                    if (c(aVar.latitude, aVar.longitude, aVar2.latitude, aVar2.longitude)) {
                        com.tencent.mm.plugin.report.service.g.oUh.A(11139, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                        obj = null;
                        break;
                    }
                }
                int i3 = 1;
                if (obj != null) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean c(double d, double d2, double d3, double d4) {
        return m.d(d, d2, d3, d4) > 1000.0d;
    }

    public final void stop() {
        if (this.nXG != null) {
            this.nXG.c(this.nXZ);
        }
        if (this.ngr != null) {
            this.ngr.a(this.naV);
        }
    }

    public final boolean P(Intent intent) {
        if (intent != null) {
            this.quM = intent.getIntExtra("get_poi_classify_type", 0);
            this.gkv = intent.getIntExtra("get_poi_showflag", 0);
            w.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[]{Integer.valueOf(this.quM)});
            this.ndv = bg.ap(intent.getStringExtra("get_poi_name"), "");
            this.gkC = bg.ap(intent.getStringExtra("get_city"), "");
            this.hCP = intent.getFloatExtra("get_lat", -1000.0f);
            this.hCQ = intent.getFloatExtra("get_lng", -1000.0f);
            w.i("MicroMsg.LocationWidget", "check cur lat " + this.quN + " " + this.nXM);
            this.quN = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.nXM = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.quO = intent.getIntExtra("get_loctype", -1);
            this.aLh = intent.getFloatExtra("get_accuracy", 0.0f);
            this.hCZ = intent.getBooleanExtra("get_is_mars", true);
            e.JX().a(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK, this.quO != 0, this.hCZ, this.hCQ, this.hCP, (int) this.aLh);
            this.quJ = intent.getByteArrayExtra("location_ctx");
            if (!bg.mA(this.ndv)) {
                this.quK = bg.ap(intent.getStringExtra("get_poi_address"), "");
                this.quL = bg.ap(intent.getStringExtra("get_poi_classify_id"), "");
                this.nYo = new aix();
                try {
                    this.nYo = (aix) this.nYo.aD(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
                    this.nYo = null;
                }
                if (!bg.mA(this.quL)) {
                    this.nYo = new aix();
                    this.nYo.nWY = this.quL;
                    this.nYo.jOc = this.quM;
                    this.nYo.fDC = this.ndv;
                    this.nYo.nXd.add(new avx().OV(this.quK));
                }
            } else if (bg.mA(this.gkC)) {
                this.hCP = -1000.0f;
                this.hCQ = -1000.0f;
                this.ndv = "";
                this.quK = "";
                this.gkC = "";
                this.quL = "";
                this.nYo = null;
            } else {
                this.ndv = "";
                this.quK = "";
                this.quL = "";
                this.nYo = null;
            }
            w.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[]{this.quK, this.ndv});
            bja();
            biY();
            this.quR = new b(this);
            b bVar = this.quR;
            if (intent != null) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.nXP = intent.getLongExtra("first_start_time", 0);
                bVar.nXQ = intent.getLongExtra("lastSuccStamp", 0);
                bVar.nXR = intent.getLongExtra("firstSuccStamp", 0);
                bVar.nXS = intent.getIntExtra("reqLoadCnt", 0);
                bVar.nhv = intent.getIntExtra("entry_time", 0);
                bVar.iGy = intent.getStringExtra("search_id");
            }
        }
        return true;
    }

    private void bja() {
        if (!(this.quI == null || this.qqN == null)) {
            if (!bg.mA(this.ndv)) {
                this.quI.setText(this.ndv);
                this.qqN.setVisibility(8);
            } else if (bg.mA(this.gkC)) {
                this.quI.setText(j.pLK);
                this.qqN.setVisibility(8);
            } else {
                this.quI.setText(this.gkC);
                this.qqN.setVisibility(8);
            }
        }
        if (bg.mA(this.ndv) && bg.mA(this.gkC)) {
            this.qpP.setImageResource(bjb());
        } else {
            this.qpP.setImageResource(bjc());
        }
    }

    protected int bjb() {
        return i.pJr;
    }

    protected int bjc() {
        return i.pJs;
    }

    public final ajq bjd() {
        ajq com_tencent_mm_protocal_c_ajq = new ajq();
        com_tencent_mm_protocal_c_ajq.tna = this.hCP;
        com_tencent_mm_protocal_c_ajq.tmZ = this.hCQ;
        com_tencent_mm_protocal_c_ajq.tNu = 0;
        com_tencent_mm_protocal_c_ajq.score = this.score;
        if (this.quJ != null) {
            com_tencent_mm_protocal_c_ajq.tNv = new com.tencent.mm.bd.b(this.quJ);
        }
        if (!bg.mA(this.ndv)) {
            com_tencent_mm_protocal_c_ajq.quK = this.quK;
            com_tencent_mm_protocal_c_ajq.ndv = this.ndv;
            com_tencent_mm_protocal_c_ajq.tNr = this.quL;
            com_tencent_mm_protocal_c_ajq.hAF = this.gkC;
            if (this.quM == 0 || this.quM != 1) {
                com_tencent_mm_protocal_c_ajq.quM = 1;
            } else {
                com_tencent_mm_protocal_c_ajq.quM = 2;
            }
            w.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ajq.quM)});
        } else if (!bg.mA(this.gkC)) {
            com_tencent_mm_protocal_c_ajq.hAF = this.gkC;
        }
        if (this.quR != null) {
            String format = String.format("%f/%f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_ajq.tna), Float.valueOf(com_tencent_mm_protocal_c_ajq.tmZ)});
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("index " + this.quR.index);
            stringBuffer.append("firstStartStamp " + this.quR.nXP);
            stringBuffer.append("lastSuccStamp " + this.quR.nXR);
            stringBuffer.append("firstSuccStamp " + this.quR.nXQ);
            stringBuffer.append("reqLoadCnt " + this.quR.nXS);
            stringBuffer.append("classifyId " + this.quL);
            stringBuffer.append("entryTime " + this.quR.nhv);
            stringBuffer.append("searchId" + this.quR.iGy);
            w.d("MicroMsg.LocationWidget", "report %s", new Object[]{stringBuffer.toString()});
            com.tencent.mm.plugin.report.service.g.oUh.i(11135, new Object[]{Integer.valueOf(5), Integer.valueOf(this.quR.index + 1), Long.valueOf(this.quR.nXP), Long.valueOf(this.quR.nXR), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.quR.nXQ), Integer.valueOf(this.quR.nXS), format, this.quL, Integer.valueOf(this.quR.nhv), this.quR.iGy, p.rA()});
        }
        bje();
        return com_tencent_mm_protocal_c_ajq;
    }

    private void bje() {
        if (this.quP != null) {
            boolean biP = this.quP.biP();
            ArrayList biO = this.quP.biO();
            if (biO != null && biO.size() != 0) {
                Iterator it = biO.iterator();
                while (it.hasNext()) {
                    int i;
                    com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                    w.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)});
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf((int) (aVar.latitude * 1000000.0d));
                    objArr[1] = Integer.valueOf((int) (aVar.longitude * 1000000.0d));
                    if (biP) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(2);
                    gVar.i(11345, objArr);
                }
            }
        }
    }

    protected int getLayoutResource() {
        return com.tencent.mm.plugin.sns.i.g.pDi;
    }
}
