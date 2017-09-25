package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.co;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements OnScrollListener, OnItemClickListener, com.tencent.mm.plugin.emoji.model.g.a, com.tencent.mm.plugin.emoji.model.g.b, com.tencent.mm.pluginsdk.model.h.a, com.tencent.mm.sdk.e.j.a, c, d, e, com.tencent.mm.y.e {
    private static Map<String, Long> kOX;
    protected ListView Fg;
    protected View jAA;
    private ProgressDialog kIa;
    com.tencent.mm.plugin.emoji.a.a.a kLV;
    private com.tencent.mm.plugin.emoji.h.b kMe;
    protected EmojiStoreVpHeader kOA;
    protected View kOB;
    protected StoreBannerEmojiView kOC;
    protected MMPullDownView kOD;
    protected TextView kOE;
    protected boolean kOF = false;
    int kOG = -1;
    private boolean kOH;
    private View kOI;
    byte[] kOJ;
    private final int kOK = 65537;
    private final int kOL = 20001;
    private final int kOM = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
    protected final int kON = 131074;
    private final int kOO = 131075;
    private final int kOP = 131076;
    private final String kOQ = "product_id";
    private final String kOR = "progress";
    private final String kOS = DownloadInfo.STATUS;
    private n kOT;
    private int kOU;
    private com.tencent.mm.plugin.emoji.model.e kOV;
    private g kOW;
    private com.tencent.mm.sdk.b.c kOY;
    protected com.tencent.mm.plugin.emoji.f.g kOZ;
    protected boolean kPa = false;
    private LinkedList<pc> kPb = new LinkedList();
    private LinkedList<pe> kPc = new LinkedList();

    private class a extends com.tencent.mm.sdk.b.c<co> {
        final /* synthetic */ BaseEmojiStoreUI kPf;

        private a(BaseEmojiStoreUI baseEmojiStoreUI) {
            this.kPf = baseEmojiStoreUI;
            this.usg = co.class.getName().hashCode();
        }

        /* synthetic */ a(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this(baseEmojiStoreUI);
            this.usg = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            co coVar = (co) bVar;
            this.kPf.e(coVar.fFZ.fGa, coVar.fFZ.status, coVar.fFZ.progress, coVar.fFZ.fGb);
            return false;
        }
    }

    private class b implements OnMenuItemClickListener {
        final /* synthetic */ BaseEmojiStoreUI kPf;

        public b(BaseEmojiStoreUI baseEmojiStoreUI) {
            this.kPf = baseEmojiStoreUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.kPf.finish();
            return true;
        }
    }

    public abstract int amF();

    public abstract int amG();

    public abstract com.tencent.mm.plugin.emoji.a.a.a amH();

    public abstract int amO();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kOW = new g();
        KC();
        this.kOU = getIntent().getIntExtra("preceding_scence", 2);
        if (h.amc().kLb != null) {
            h.amc().kLb.c(this);
        }
        this.kOY = new a();
        com.tencent.mm.sdk.b.a.urY.b(this.kOY);
        this.kOW.kLX = this;
        this.kOW.kLV = this.kLV;
        this.kOW.kLZ = amF();
        this.kOW.kMc = this;
        boolean amW = amW();
        if (amW) {
            amW = amT();
        }
        j(false, amW);
        if (kOX == null) {
            kOX = new HashMap();
        }
        w.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        kOX.put(getClass().toString(), Long.valueOf(r0));
        this.kMe = new com.tencent.mm.plugin.emoji.h.b(MMBitmapFactory.ERROR_IO_FAILED);
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(411, this);
        ap.vd().a(423, this);
        ap.vd().a(413, this);
        ap.vd().a(717, this);
        if (amL() && this.kOA != null) {
            this.kOA.anG();
        }
        Boolean.valueOf(false);
        this.kOW.kLW = false;
        if (this.kLV != null && this.kLV.kIP != null) {
            this.kLV.kIP.als();
            this.kLV.aiQ();
        }
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(411, this);
        ap.vd().b(423, this);
        ap.vd().b(413, this);
        ap.vd().b(717, this);
        amR();
        if (amL() && this.kOA != null) {
            this.kOA.anH();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kLV != null) {
            this.kLV.clear();
            this.kLV = null;
        }
        if (amL() && this.kOA != null) {
            this.kOA.clear();
        }
        h.amc().kLb.f(this);
        com.tencent.mm.sdk.b.a.urY.c(this.kOY);
        ap.vd().c(this.kOZ);
        if (this.kOW != null) {
            g gVar = this.kOW;
            gVar.kLV = null;
            gVar.kMc = null;
            gVar.kLX = null;
        }
    }

    protected int getLayoutId() {
        return R.i.daA;
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3 = -1;
        String str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str3 = "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        w.i(str2, str3, objArr);
        amV();
        switch (kVar.getType()) {
            case 411:
                n nVar = (n) kVar;
                if (nVar == null || nVar.mType != amO()) {
                    str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
                    str3 = "no some scene type. this ui type:%d callbak type:%d";
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(amO());
                    if (nVar != null) {
                        i3 = nVar.mType;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    w.i(str2, str3, objArr);
                    return;
                }
                this.kOH = false;
                this.kOI.setVisibility(8);
                com.tencent.mm.plugin.emoji.model.e eVar = null;
                try {
                    eVar = n.a(nVar.ams());
                } catch (Exception e) {
                    w.j("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[]{e.toString()});
                }
                if (eVar != null) {
                    boolean z = i == 0 || i == 4;
                    if (z) {
                        this.jAA.setVisibility(8);
                        this.kOF = false;
                        this.kOJ = nVar.kNk;
                        xy ams;
                        if (i2 == 0) {
                            ams = nVar.ams();
                            a(eVar, false, true);
                            b(ams);
                            this.kOG = 0;
                            return;
                        } else if (i2 == 2) {
                            ams = nVar.ams();
                            a(this.kOG, eVar, false, false);
                            amN();
                            b(ams);
                            this.kOG = 2;
                            return;
                        } else if (i2 == 3) {
                            a(this.kOG, eVar, false, false);
                            this.kOG = 1;
                            return;
                        } else {
                            this.jAA.setVisibility(0);
                            this.kOF = true;
                            if (amO() == 7) {
                                this.kOE.setText(R.l.edP);
                                return;
                            } else {
                                this.kOE.setText(R.l.edn);
                                return;
                            }
                        }
                    }
                }
                if (!this.kPa) {
                    this.jAA.setVisibility(0);
                    this.kOF = true;
                    this.kOE.setText(R.l.edo);
                    return;
                }
                return;
            case 413:
                q qVar = (q) kVar;
                Message message;
                if (i == 0 && i2 == 0) {
                    h.amc().kLb.Sd(qVar.kMS);
                    message = new Message();
                    message.what = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                    message.obj = this.uSU.uTo.getString(R.l.dIR);
                    i(message);
                } else {
                    message = new Message();
                    message.what = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                    message.obj = this.uSU.uTo.getString(R.l.ecz);
                    i(message);
                }
                bP(20001, 800);
                return;
            case 423:
                com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
                if (i == 0 && i2 == 0) {
                    a(gVar);
                    return;
                }
                str2 = gVar.kMS;
                str3 = gVar.kMU;
                final String str4 = gVar.kMT;
                com.tencent.mm.ui.base.g.a(this, getString(R.l.edj, new Object[]{str4}), "", new OnClickListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI kPf;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kPf.F(str2, str3, str4);
                        this.kPf.amS();
                        w.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        this.kPf.aI(str2, 0);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI kPf;

                    {
                        this.kPf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aH(gVar.kMS, -1);
                return;
            case 717:
                if (i == 0 && i2 == 0) {
                    this.kOJ = null;
                    j(false, true);
                    return;
                }
                return;
            default:
                w.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (amL() || amM()) {
            if (i != 0) {
                i--;
            } else {
                return;
            }
        }
        if (i >= 0 && i < this.kLV.getCount()) {
            f lj = this.kLV.lj(i);
            if (lj == null) {
                w.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
            } else if (lj.kJa == com.tencent.mm.plugin.emoji.a.a.f.a.kJj) {
                pe peVar = lj.kJc;
                if (peVar == null) {
                    w.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
                } else {
                    m.a(this.uSU.uTo, peVar, false);
                }
            } else {
                pn pnVar = lj.kJb;
                if (pnVar == null) {
                    w.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                    return;
                }
                m.a(this.uSU.uTo, pnVar, amF(), lj.mStatus, lj.sd, getIntent().getStringExtra("to_talker_name"), amG());
            }
        }
    }

    protected void amE() {
        this.kLV = amH();
        this.kLV.kIQ = this;
    }

    protected void uB(String str) {
    }

    protected void amI() {
    }

    protected void amJ() {
        if (amK()) {
            this.kOD = (MMPullDownView) findViewById(R.h.cbG);
            if (this.kOD != null) {
                this.kOD.kR(false);
                this.kOD.vlA = this;
                this.kOD.vlo = this;
                this.kOD.vlz = this;
                this.kOD.kQ(false);
                this.kOD.kP(false);
            }
        }
    }

    protected boolean amK() {
        return true;
    }

    public void KC() {
        b(new b(this));
        amE();
        this.jAA = findViewById(R.h.empty);
        this.kOE = (TextView) this.jAA.findViewById(R.h.bLN);
        this.kOI = getLayoutInflater().inflate(R.i.daz, null);
        this.kOI.setVisibility(8);
        if (amL()) {
            this.kOA = new EmojiStoreVpHeader(this.uSU.uTo);
        }
        if (amM()) {
            this.kOB = LayoutInflater.from(this).inflate(R.i.daX, null);
            int i = EmojiStoreVpHeader.aG(this.uSU.uTo)[0];
            this.kOB.setLayoutParams(new LayoutParams(i, ((i * 3) / 8) + 1));
            this.kOC = (StoreBannerEmojiView) this.kOB.findViewById(R.h.bKV);
        }
        this.Fg = (ListView) findViewById(16908298);
        this.Fg.setOnItemClickListener(this);
        if (amL()) {
            this.Fg.addHeaderView(this.kOA);
        } else if (amM()) {
            this.Fg.addHeaderView(this.kOB);
        }
        if (amX()) {
            this.Fg.addFooterView(this.kOI);
        }
        amI();
        this.Fg.setAdapter(this.kLV);
        this.Fg.setOnScrollListener(this);
        this.kLV.kIO = this.Fg;
        amJ();
    }

    protected final void j(boolean z, boolean z2) {
        n nVar;
        this.kOH = true;
        if (z) {
            this.kOI.setVisibility(0);
        }
        Object obj = this.kOJ;
        int amO = amO();
        int amQ = amQ();
        int amP = amP();
        if (obj != null) {
            w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[]{obj.toString()});
            nVar = new n(amO, obj, amQ);
            if (amO == 7) {
                nVar.kNm = amP;
            }
        } else {
            w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            nVar = new n(amO, amQ);
            if (amO == 7) {
                nVar.kNm = amP;
            }
        }
        this.kOT = nVar;
        ap.vd().a(this.kOT, 0);
        w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            amU();
        }
    }

    public final boolean akm() {
        j(true, false);
        w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    public final void g(Message message) {
        switch (message.what) {
            case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                String str = (String) message.obj;
                if (isFinishing()) {
                    w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
                    return;
                } else if (this.kIa != null) {
                    this.kIa.setMessage(str);
                    return;
                } else {
                    return;
                }
            case 20001:
                amV();
                return;
            case 65537:
                c((xy) message.obj);
                return;
            default:
                return;
        }
    }

    public void h(Message message) {
        String string;
        switch (message.what) {
            case 131074:
                if (this.kLV != null) {
                    this.kLV.notifyDataSetChanged();
                    amY();
                    return;
                }
                return;
            case 131075:
                if (this.kLV != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.kLV.aI(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (this.kLV != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.kLV.aH(string, message.getData().getInt(DownloadInfo.STATUS));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean amL() {
        return true;
    }

    protected boolean amM() {
        return false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.kOG == 0 || this.kOH) {
            w.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        j(true, false);
        w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    private void amN() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.kLV.kIP, (com.tencent.mm.pluginsdk.model.h.a) this);
    }

    protected void a(com.tencent.mm.plugin.emoji.f.g gVar) {
        aI(gVar.kMS, 0);
    }

    private void aI(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        i(obtain);
    }

    private void aH(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt(DownloadInfo.STATUS, i);
        obtain.what = 131076;
        i(obtain);
    }

    protected final com.tencent.mm.plugin.emoji.f.g F(String str, String str2, String str3) {
        this.kOZ = new com.tencent.mm.plugin.emoji.f.g(str, str2, str3);
        return this.kOZ;
    }

    public int amP() {
        return 0;
    }

    protected int amQ() {
        if (this.kOU == 1) {
            return 1;
        }
        return 2;
    }

    protected final void amR() {
        ap.vd().c(this.kOT);
    }

    protected final void amS() {
        ap.vd().a(this.kOZ, 0);
    }

    protected boolean amT() {
        xy yO = h.amc().kLd.yO(amO());
        com.tencent.mm.plugin.emoji.model.e a = n.a(yO);
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "load cache type: %d, size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(amO());
        objArr[1] = Integer.valueOf(yO == null ? 0 : yO.tEo);
        w.d(str, str2, objArr);
        if (a == null) {
            return false;
        }
        boolean z;
        if (a.kLM.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            w.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[]{Integer.valueOf(a.kLM.size())});
            a(a, true, false);
            return z;
        }
        w.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    protected final void amU() {
        if (isFinishing()) {
            w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.l.dIO);
        this.kIa = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ BaseEmojiStoreUI kPf;

            {
                this.kPf = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.kPf.amR();
                ap.vd().cancel(413);
            }
        });
    }

    protected final void amV() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }

    protected void a(com.tencent.mm.plugin.emoji.model.e eVar, boolean z, boolean z2) {
        w.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (eVar != null && eVar.kLM.size() > 0) {
            this.kPa = true;
            this.jAA.setVisibility(8);
            this.kOF = false;
        }
        a(this.kOG, eVar, z, z2);
        amN();
    }

    private void a(int i, com.tencent.mm.plugin.emoji.model.e eVar, boolean z, boolean z2) {
        boolean z3 = false;
        w.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i) {
            case -1:
                this.kOV = eVar;
                break;
            case 1:
                this.kOV = eVar;
                break;
            case 2:
                if (this.kOV == null) {
                    this.kOV = new com.tencent.mm.plugin.emoji.model.e();
                }
                if (eVar != null) {
                    this.kOV.lp(eVar.kLL);
                    this.kOV.al(eVar.kLM);
                    break;
                }
                break;
            default:
                if (this.kOV != null) {
                    this.kOV.alS();
                }
                a(z3, this.kOV, z, z2);
        }
        z3 = true;
        if (this.kOV != null) {
            this.kOV.alS();
        }
        a(z3, this.kOV, z, z2);
    }

    protected void a(boolean z, com.tencent.mm.plugin.emoji.model.e eVar, boolean z2, boolean z3) {
        if (this.kOV != null && z) {
            if (amL()) {
                if (this.kOV == null || this.kOV.kLN == null || this.kOV.kLN.tuJ == null) {
                    w.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
                } else {
                    this.kPb = (LinkedList) this.kOV.kLO;
                    this.kPc = (LinkedList) this.kOV.kLP;
                    if (this.kPb != null) {
                        this.kOA.c(this.kPb, this.kPc);
                    } else if (this.kOV.kLN != null) {
                        this.kPb = new LinkedList();
                        this.kPb.add(this.kOV.kLN);
                        this.kOA.c(this.kPb, this.kPc);
                    }
                }
            }
            if (this.kLV != null) {
                this.kLV.b(this.kOV);
            }
        }
    }

    private void b(xy xyVar) {
        if (this.kOG == -1) {
            Message obtain = Message.obtain();
            obtain.what = 65537;
            obtain.obj = xyVar;
            if (this.kPD != null) {
                this.kPD.sendMessage(obtain);
            }
        }
    }

    protected void c(xy xyVar) {
        int i = 0;
        if (xyVar != null) {
            String str = "MicroMsg.emoji.BaseEmojiStoreUI";
            String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(xyVar == null ? 0 : xyVar.tEo);
            if (!(xyVar == null || xyVar.tfG == null)) {
                i = xyVar.tfG.aUk();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(amO());
            w.d(str, str2, objArr);
            h.amc().kLd.a(amO(), xyVar);
        }
    }

    public final boolean akn() {
        return false;
    }

    public final boolean ako() {
        return false;
    }

    public void a(String str, l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            ang();
            bP(131074, 50);
        }
    }

    public void e(String str, int i, int i2, String str2) {
        w.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (this.kLV != null && this.kLV.kIP != null) {
            if (i == 6) {
                aI(str, i2);
            } else {
                w.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                aH(str, i);
            }
            f tU = this.kLV.kIP.tU(str);
            if (tU != null) {
                tU.kJe = str2;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.alb();
        objArr[1] = TextUtils.isEmpty(aVar.ald()) ? "" : aVar.ald();
        objArr[2] = Integer.valueOf(aVar.alc());
        w.i(str, str2, objArr);
        if (aVar.alc() == 9) {
            String string = getString(R.l.dIS);
            if (isFinishing()) {
                w.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(R.l.dIO);
                this.kIa = com.tencent.mm.ui.base.g.a(this, string, true, new OnCancelListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI kPf;

                    {
                        this.kPf = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().cancel(413);
                    }
                });
            }
        }
        this.kOW.a(aVar);
    }

    protected boolean amW() {
        return false;
    }

    public final void x(ArrayList<p> arrayList) {
        w.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.kLV != null) {
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.kLV.kIP);
            if (this.kPE != null) {
                this.kPE.removeMessages(131074);
                this.kPE.sendEmptyMessage(131074);
            }
        }
    }

    public final void E(String str, String str2, String str3) {
        F(str, str2, str3);
        amS();
    }

    public final void alT() {
        this.kOJ = null;
        this.kOG = -1;
        j(false, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        this.kOW.onActivityResult(i, i2, intent);
    }

    protected boolean amX() {
        return true;
    }

    public void amY() {
    }
}
