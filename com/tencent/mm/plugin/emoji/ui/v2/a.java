package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.g.b;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class a extends q implements OnScrollListener, OnItemClickListener, com.tencent.mm.plugin.emoji.a.h.a, com.tencent.mm.plugin.emoji.model.g.a, b, com.tencent.mm.pluginsdk.model.h.a, com.tencent.mm.sdk.e.j.a, c, d, e, com.tencent.mm.y.e {
    ListView Fg;
    private ActionBar Gx;
    private View jAA;
    private ae jsW = new ae(this) {
        final /* synthetic */ a kWt;

        {
            this.kWt = r1;
        }

        public final void handleMessage(Message message) {
            a aVar = this.kWt;
            String string;
            switch (message.what) {
                case 131074:
                    if (aVar.kLV != null) {
                        aVar.kLV.notifyDataSetChanged();
                        return;
                    }
                    return;
                case 131075:
                    if (aVar.kLV != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            aVar.kLV.aI(string, message.getData().getInt("progress"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131076:
                    if (aVar.kLV != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            aVar.kLV.aH(string, message.getData().getInt(DownloadInfo.STATUS));
                            return;
                        }
                        return;
                    }
                    return;
                case 131077:
                    if (aVar.kOA != null) {
                        aVar.kOA.anG();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private ProgressDialog kIa;
    com.tencent.mm.plugin.emoji.a.a.a kLV;
    EmojiStoreVpHeader kOA;
    private MMPullDownView kOD;
    private TextView kOE;
    private int kOG = -1;
    private boolean kOH;
    private View kOI;
    private byte[] kOJ;
    private final int kON = 131074;
    private final int kOO = 131075;
    private final int kOP = 131076;
    private final String kOQ = "product_id";
    private final String kOR = "progress";
    private final String kOS = DownloadInfo.STATUS;
    private n kOT;
    private int kOU;
    private com.tencent.mm.plugin.emoji.model.e kOV;
    private g kOW;
    private com.tencent.mm.sdk.b.c kOY = new com.tencent.mm.sdk.b.c<co>(this) {
        final /* synthetic */ a kWt;

        {
            this.kWt = r2;
            this.usg = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            co coVar = (co) bVar;
            if (coVar != null) {
                a aVar = this.kWt;
                String str = coVar.fFZ.fGa;
                int i = coVar.fFZ.status;
                int i2 = coVar.fFZ.progress;
                w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), coVar.fFZ.fGb});
                if (!(aVar.kLV == null || aVar.kLV.kIP == null)) {
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        aVar.i(obtain);
                    } else {
                        w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", new Object[]{Integer.valueOf(i)});
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt(DownloadInfo.STATUS, i);
                        obtain2.what = 131076;
                        aVar.i(obtain2);
                    }
                    f tU = aVar.kLV.kIP.tU(str);
                    if (tU != null) {
                        tU.kJe = r4;
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.plugin.emoji.f.g kOZ;
    private boolean kPa = false;
    private LinkedList<pc> kPb = new LinkedList();
    private LinkedList<pe> kPc = new LinkedList();
    private final int kWm = 131077;
    private com.tencent.mm.ui.b kWn;
    public EmojiStoreV2HotBarView kWo;
    private boolean kWp = false;
    private boolean kWq = false;
    private boolean kWr = false;
    public OnMenuItemClickListener kWs = new OnMenuItemClickListener(this) {
        final /* synthetic */ a kWt;

        {
            this.kWt = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.kWt.bPj().finish();
            return false;
        }
    };

    public abstract com.tencent.mm.plugin.emoji.a.a.a amH();

    public abstract int amO();

    public abstract boolean aoz();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.Gx = ((ActionBarActivity) bPj()).cO().cP();
        View inflate = r.eC(this.uSU.uTo).inflate(R.i.cTB, null);
        this.kWn = new com.tencent.mm.ui.b(inflate);
        this.Gx.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.Gx.cK();
        this.Gx.setDisplayHomeAsUpEnabled(false);
        this.Gx.cJ();
        this.Gx.cL();
        this.Gx.setCustomView(inflate);
        this.Gx.show();
        com.tencent.mm.ui.b bVar = this.kWn;
        bVar.ipw.setText(R.l.ecZ);
        if (com.tencent.mm.bg.a.dM(bVar.ipw.getContext())) {
            bVar.ipw.setTextSize(0, com.tencent.mm.bg.a.dK(bVar.ipw.getContext()) * ((float) com.tencent.mm.bg.a.U(bVar.ipw.getContext(), com.tencent.mm.s.a.e.aWy)));
        }
        this.kWn.h(new OnClickListener(this) {
            final /* synthetic */ a kWt;

            {
                this.kWt = r1;
            }

            public final void onClick(View view) {
                if (this.kWt.uSU.uTe && this.kWt.kWs != null) {
                    this.kWt.kWs.onMenuItemClick(null);
                }
            }
        });
        ks(true);
        a(0, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ a kWt;

            {
                this.kWt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(this.kWt.bPj(), EmojiMineUI.class);
                this.kWt.startActivity(intent);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.urY.b(this.kOY);
        h.amc().kLb.c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.kWr = true;
        this.kLV = amH();
        this.kLV.kIQ = this;
        this.jAA = findViewById(R.h.empty);
        this.kOE = (TextView) this.jAA.findViewById(R.h.bLN);
        this.kOI = bPj().getLayoutInflater().inflate(R.i.daz, null);
        this.kOI.setVisibility(8);
        this.kOA = new EmojiStoreVpHeader(this.uSU.uTo);
        this.Fg = (ListView) findViewById(16908298);
        this.Fg.addHeaderView(this.kOA);
        if (!aoz()) {
            this.kWo = new EmojiStoreV2HotBarView(this.uSU.uTo);
            EmojiStoreV2HotBarView emojiStoreV2HotBarView = this.kWo;
            if (emojiStoreV2HotBarView.kXg != null) {
                emojiStoreV2HotBarView.kXg.setVisibility(8);
            }
            emojiStoreV2HotBarView = this.kWo;
            if (emojiStoreV2HotBarView.kXe != null) {
                int T = com.tencent.mm.bg.a.T(emojiStoreV2HotBarView.getContext(), R.f.aXw);
                int T2 = com.tencent.mm.bg.a.T(emojiStoreV2HotBarView.getContext(), R.f.aXz);
                int T3 = com.tencent.mm.bg.a.T(emojiStoreV2HotBarView.getContext(), R.f.aXH);
                emojiStoreV2HotBarView.kXe.setPadding(T3, T, T3, T2);
            }
            this.Fg.addHeaderView(this.kWo);
        }
        this.Fg.addFooterView(this.kOI);
        this.Fg.setAdapter(this.kLV);
        if (aoz()) {
            this.Fg.setOnItemClickListener(this);
        } else {
            ((com.tencent.mm.plugin.emoji.a.h) this.kLV).kIz = this;
        }
        this.Fg.setOnScrollListener(this);
        this.Fg.setLongClickable(false);
        this.Fg.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ a kWt;

            {
                this.kWt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.kLV.kIO = this.Fg;
        this.kOD = (MMPullDownView) findViewById(R.h.cbG);
        if (this.kOD != null) {
            this.kOD.kR(false);
            this.kOD.vlA = this;
            this.kOD.vlo = this;
            this.kOD.vlz = this;
            this.kOD.kQ(false);
            this.kOD.kP(false);
            this.kOD.vlK = true;
        }
        if (this.kWp) {
            aow();
        }
    }

    public void onStart() {
        super.onStart();
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        ap.vd().a(411, this);
        ap.vd().a(423, this);
        if (this.kWp) {
            if (this.jsW != null) {
                this.jsW.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.kLV == null || this.kLV.kIP == null)) {
                this.kLV.kIP.als();
                this.kLV.aiQ();
            }
            ap.yY();
            if (((Boolean) com.tencent.mm.u.c.vr().get(208900, Boolean.valueOf(false))).booleanValue()) {
                alT();
                ap.yY();
                com.tencent.mm.u.c.vr().set(208900, Boolean.valueOf(false));
            }
        }
    }

    public final void setUserVisibleHint(boolean z) {
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[]{Boolean.valueOf(z)});
        super.setUserVisibleHint(z);
        this.kWp = z;
        if (!this.kWq && this.kWr) {
            aow();
        }
    }

    public void onPause() {
        super.onPause();
        ap.vd().b(411, this);
        ap.vd().b(423, this);
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.kOA != null) {
            this.kOA.anH();
        }
        if (this.jsW != null) {
            this.jsW.removeMessages(131077);
        }
    }

    public void onStop() {
        super.onStop();
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.kLV != null) {
            this.kLV.clear();
            this.kLV = null;
        }
        if (this.kOA != null) {
            this.kOA.anH();
            this.kOA.clear();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.kOY);
        h.amc().kLb.f(this);
    }

    public void onDetach() {
        super.onDetach();
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void aow() {
        int i = 0;
        this.kWq = true;
        this.kOW = new g();
        this.kOW.kLX = bPj();
        this.kOW.kLY = this;
        this.kOW.kLV = this.kLV;
        if (aoz()) {
            this.kOW.kLZ = 1;
        } else {
            this.kOW.kLZ = 2;
        }
        this.kOW.kMc = this;
        this.kOU = bPj().getIntent().getIntExtra("preceding_scence", 5);
        xy yO = h.amc().kLd.yO(amO());
        com.tencent.mm.plugin.emoji.model.e a = n.a(yO);
        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
        String str2 = "load cache type: %d, size: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(amO());
        objArr[1] = Integer.valueOf(yO == null ? 0 : yO.tEo);
        w.d(str, str2, objArr);
        if (a != null && a.kLM.size() > 0) {
            int size;
            int i2;
            int i3;
            this.kPa = true;
            this.jAA.setVisibility(8);
            this.kOD.setVisibility(0);
            a(this.kOG, a);
            if (yO != null) {
                size = yO.tEA == null ? 0 : yO.tEA.size();
                i2 = yO.tEx;
                int i4 = yO.tEy;
                i3 = i2;
                i2 = size;
                size = i4;
            } else {
                size = 0;
                i3 = 0;
                i2 = 0;
            }
            w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(amO())});
            if (this.kLV != null && aoz()) {
                this.kLV.lg(i3 + i2);
                this.kLV.lh(size);
            }
            amN();
            i = 1;
        }
        if (i == 0 || this.jsW == null) {
            dC(true);
        } else {
            this.jsW.postDelayed(new Runnable(this) {
                final /* synthetic */ a kWt;

                {
                    this.kWt = r1;
                }

                public final void run() {
                    this.kWt.dC(false);
                }
            }, 3000);
        }
    }

    public final void dC(boolean z) {
        w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(aoy())});
        if (!z) {
            aoy();
        }
        ae(this.kOJ);
        aox();
    }

    private void ae(byte[] bArr) {
        int amO = amO();
        int i = this.kOU == 1 ? 1 : 2;
        if (bArr != null) {
            w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[]{bArr.toString()});
            this.kOT = new n(amO, bArr, i);
            return;
        }
        w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.kOT = new n(amO, i);
    }

    private void aox() {
        ap.vd().a(this.kOT, 0);
    }

    private static boolean aoy() {
        ap.yY();
        ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzI, Long.valueOf(0))).longValue();
        return true;
    }

    private void a(int i, com.tencent.mm.plugin.emoji.model.e eVar) {
        Object obj = 1;
        Object obj2 = null;
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        int i2;
        switch (i) {
            case -1:
                this.kOV = eVar;
                i2 = 1;
                break;
            case 0:
                this.kOV = eVar;
                obj = null;
                break;
            case 1:
                this.kOV = eVar;
                i2 = 1;
                obj = null;
                break;
            case 2:
                if (this.kOV == null) {
                    this.kOV = new com.tencent.mm.plugin.emoji.model.e();
                }
                this.kOV.lp(eVar.kLL);
                this.kOV.al(eVar.kLM);
                i2 = 1;
                obj = null;
                break;
            default:
                obj = null;
                break;
        }
        if (this.kOV != null) {
            this.kOV.alS();
        }
        if (this.kOV != null && r1 != null) {
            if (obj != null) {
                if (this.kOV == null) {
                    w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
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

    private void amN() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.kLV.kIP, (com.tencent.mm.pluginsdk.model.h.a) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
        switch (kVar.getType()) {
            case 411:
                n nVar = (n) kVar;
                if (nVar != null && nVar.mType == amO()) {
                    int i3;
                    int i4;
                    int i5 = 0;
                    if (nVar == null || nVar.ams() == null) {
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                    } else {
                        if (this.kLV.alo() <= 0 && aoz()) {
                            if (nVar.ams().tEA == null) {
                                i5 = 0;
                            } else {
                                i5 = nVar.ams().tEA.size();
                            }
                            this.kLV.li(i5);
                        }
                        i3 = nVar.ams().tEx;
                        i4 = i5;
                        i5 = nVar.ams().tEy;
                    }
                    w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(r4), Integer.valueOf(nVar.mType)});
                    if (this.kLV != null && this.kLV.aln() <= 0 && aoz()) {
                        this.kLV.lg(i3 + this.kLV.alo());
                        this.kLV.lh(i5);
                    }
                    this.kOH = false;
                    this.kOI.setVisibility(8);
                    Object obj = (i == 0 || i == 4) ? 1 : null;
                    if (obj != null) {
                        this.jAA.setVisibility(8);
                        this.kOD.setVisibility(0);
                        n nVar2 = (n) kVar;
                        com.tencent.mm.plugin.emoji.model.e a = n.a(nVar2.ams());
                        this.kOJ = nVar2.kNk;
                        xy ams;
                        if (i2 == 0) {
                            ams = nVar2.ams();
                            a(this.kOG, a);
                            d(ams);
                            this.kOG = 0;
                        } else if (i2 == 2) {
                            ams = nVar2.ams();
                            a(this.kOG, a);
                            amN();
                            d(ams);
                            this.kOG = 2;
                        } else if (i2 == 3) {
                            a(this.kOG, a);
                            this.kOG = 1;
                        } else {
                            this.jAA.setVisibility(0);
                            this.kOD.setVisibility(8);
                            this.kOE.setText(R.l.edn);
                        }
                    } else if (!this.kPa) {
                        this.jAA.setVisibility(0);
                        this.kOD.setVisibility(8);
                        this.kOE.setText(R.l.edo);
                    }
                    if (aoz()) {
                        if (!(nVar.ams() == null || nVar.ams().tEA == null || nVar.ams().tEA.size() <= 0)) {
                            for (i3 = 0; i3 < nVar.ams().tEA.size(); i3++) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(13223, new Object[]{Integer.valueOf(0), Integer.valueOf(((pe) nVar.ams().tEA.get(i3)).fxo), ((pe) nVar.ams().tEA.get(i3)).fDC, Integer.valueOf(0)});
                            }
                        }
                        if (nVar.ams().tEy > 0 && nVar.ams().tEp != null && nVar.ams().tEp.size() > nVar.ams().tEx + nVar.ams().tEy) {
                            for (i3 = 0; i3 < nVar.ams().tEy; i3++) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(13223, new Object[]{Integer.valueOf(0), ((pn) nVar.ams().tEp.get(nVar.ams().tEx + i3)).tgW, ((pn) nVar.ams().tEp.get(nVar.ams().tEx + i3)).tuV, Integer.valueOf(1)});
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                w.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    public final boolean akm() {
        w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        dD(true);
        return true;
    }

    public final boolean akn() {
        return false;
    }

    public final boolean ako() {
        return false;
    }

    private void d(final xy xyVar) {
        if (this.kOG == -1) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a kWt;

                public final void run() {
                    int i = 0;
                    if (xyVar != null) {
                        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
                        String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(xyVar == null ? 0 : xyVar.tEo);
                        if (!(xyVar == null || xyVar.tfG == null)) {
                            i = xyVar.tfG.aUk();
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(this.kWt.amO());
                        w.d(str, str2, objArr);
                        h.amc().kLd.a(this.kWt.amO(), xyVar);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar.alc() == 9) {
            uE(getString(R.l.dIS));
        }
        if (!aoz()) {
            this.kOW.kLZ = 2;
        } else if (aVar.kC >= 0 && aVar.kC < this.kLV.alm()) {
            this.kOW.kLZ = 3;
        } else if (aVar.kC < this.kLV.alm() || aVar.kC >= this.kLV.aln() + this.kLV.alm()) {
            this.kOW.kLZ = 1;
        } else {
            this.kOW.kLZ = 19;
        }
        this.kOW.a(aVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.Fg.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.kLV.getCount()) {
            f lj = this.kLV.lj(headerViewsCount);
            a(lj, headerViewsCount);
            if (aoz() && this.kLV.aln() > 0 && headerViewsCount >= this.kLV.alm() && headerViewsCount < this.kLV.alm() + this.kLV.aln() && lj.kJb != null) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13223, new Object[]{Integer.valueOf(1), lj.kJb.tgW, lj.kJb.tuV, Integer.valueOf(1), Integer.valueOf(0)});
            }
        }
    }

    public final void lk(int i) {
        if (i >= 0 && i < ((com.tencent.mm.plugin.emoji.a.h) this.kLV).alq()) {
            a(this.kLV.lj(i), i);
        }
    }

    private void a(f fVar, int i) {
        if (fVar == null) {
            w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (fVar.kJa == com.tencent.mm.plugin.emoji.a.a.f.a.kJj) {
            pe peVar = fVar.kJc;
            if (peVar == null) {
                w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                m.a(this.uSU.uTo, peVar, false);
            }
        } else {
            pn pnVar = fVar.kJb;
            if (pnVar == null) {
                w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
                return;
            }
            int i2;
            if (!aoz()) {
                i2 = 2;
            } else if (i >= 0 && i < this.kLV.alm()) {
                i2 = 3;
            } else if (i < this.kLV.alm() || i >= this.kLV.aln() + this.kLV.alm()) {
                i2 = 1;
            } else {
                i2 = 19;
            }
            m.a(this.uSU.uTo, pnVar, i2, fVar.mStatus, fVar.sd, bPj().getIntent().getStringExtra("to_talker_name"), 5);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.kOG == 0 || this.kOH) {
            w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
            return;
        }
        dD(true);
        w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        if (this.kOW != null) {
            this.kOW.onActivityResult(i, i2, intent);
        } else {
            w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    public final void E(String str, String str2, String str3) {
        this.kOZ = new com.tencent.mm.plugin.emoji.f.g(str, str2, str3);
        ap.vd().a(this.kOZ, 0);
    }

    public final void alT() {
        this.kOJ = null;
        this.kOG = -1;
        dD(false);
    }

    private void dD(boolean z) {
        if (this.kOH) {
            w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.kOH = true;
        if (z) {
            this.kOI.setVisibility(0);
        }
        ae(this.kOJ);
        aox();
        w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            uE(getString(R.l.dJd));
        }
    }

    public final void i(Message message) {
        if (this.jsW != null) {
            this.jsW.sendMessage(message);
        }
    }

    private void uE(String str) {
        if (isFinishing()) {
            w.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        Context bPj = bPj();
        getString(R.l.dIO);
        this.kIa = com.tencent.mm.ui.base.g.a(bPj, str, true, new OnCancelListener(this) {
            final /* synthetic */ a kWt;

            {
                this.kWt = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                a.amR();
            }
        });
    }

    protected static void amR() {
    }

    public final void x(ArrayList<p> arrayList) {
        w.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.kLV != null) {
            if (this.jsW != null) {
                this.jsW.sendEmptyMessageDelayed(131074, 50);
            }
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.kLV.kIP);
        }
    }

    public final void a(String str, l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group") && this.jsW != null) {
            this.jsW.sendEmptyMessageDelayed(131074, 50);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kOA != null) {
            this.kOA.requestLayout();
        }
        setRequestedOrientation(1);
    }
}
