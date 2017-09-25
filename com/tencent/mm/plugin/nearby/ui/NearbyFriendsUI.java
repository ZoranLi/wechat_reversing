package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.av.l;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

public class NearbyFriendsUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.c gKi;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ NearbyFriendsUI nWx;

        {
            this.nWx = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (this.nWx.ngv) {
                return false;
            }
            this.nWx.ngv = true;
            if (this.nWx.htv) {
                if (this.nWx.irJ != null) {
                    this.nWx.irJ.dismiss();
                    this.nWx.irJ = null;
                }
                f.sa(11);
                return false;
            }
            if (z) {
                if (this.nWx.irJ != null) {
                    this.nWx.irJ.setMessage(this.nWx.getString(R.l.eCP));
                }
                this.nWx.nWw = new a(this.nWx, f2, f, (int) d2);
                com.tencent.mm.modelstat.e.JX().a(MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN, i != 0, this.nWx.gKi == null ? false : this.nWx.gKi.hCZ, f, f2, (int) d2);
                this.nWx.nWi = new com.tencent.mm.plugin.nearby.a.c(this.nWx.nWm, this.nWx.nWw.hCQ, this.nWx.nWw.hCP, this.nWx.nWw.accuracy, i, "", "");
                ap.vd().a(this.nWx.nWi, 0);
            } else {
                f.sa(11);
                if (this.nWx.irJ != null) {
                    this.nWx.irJ.dismiss();
                    this.nWx.irJ = null;
                }
                this.nWx.aOK();
                this.nWx.findViewById(R.h.cmH).setVisibility(0);
                this.nWx.nWh.setVisibility(8);
                this.nWx.nWt = true;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c gKr = new com.tencent.mm.sdk.b.c<ig>(this) {
        final /* synthetic */ NearbyFriendsUI nWx;

        {
            this.nWx = r2;
            this.usg = ig.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ig igVar = (ig) bVar;
            if (igVar != null && (igVar instanceof ig)) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 nWy;

                    {
                        this.nWy = r1;
                    }

                    public final void run() {
                        this.nWy.nWx.aOJ();
                    }
                });
            }
            return false;
        }
    };
    boolean htv = false;
    private p irJ = null;
    private List<aiw> lqW = new LinkedList();
    private com.tencent.mm.plugin.nearby.a.c nVU;
    private b nWg;
    private ListView nWh;
    private com.tencent.mm.plugin.nearby.a.c nWi;
    private com.tencent.mm.plugin.nearby.a.d nWj;
    private boolean nWk = false;
    private String[] nWl;
    private int nWm = 1;
    private BindMobileOrQQHeaderView nWn;
    private ViewGroup nWo;
    private View nWp;
    private View nWq;
    private boolean nWr = false;
    private int nWs;
    private boolean nWt = false;
    private int nWu = 0;
    private View nWv = null;
    private a nWw;
    private boolean ngv = false;
    private List<aiw> nhM = new LinkedList();

    private class a {
        public int accuracy;
        public float hCP;
        public float hCQ;
        final /* synthetic */ NearbyFriendsUI nWx;

        public a(NearbyFriendsUI nearbyFriendsUI, float f, float f2, int i) {
            this.nWx = nearbyFriendsUI;
            this.hCP = f;
            this.hCQ = f2;
            this.accuracy = i;
        }
    }

    class b extends BaseAdapter {
        private final Context context;
        com.tencent.mm.ui.applet.b hBe = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ b nWB;

            {
                this.nWB = r1;
            }

            public final Bitmap jf(String str) {
                return com.tencent.mm.x.b.a(str, false, -1);
            }
        });
        private com.tencent.mm.ui.applet.b.b hBf = null;
        final /* synthetic */ NearbyFriendsUI nWx;

        public final /* synthetic */ Object getItem(int i) {
            return qo(i);
        }

        public b(NearbyFriendsUI nearbyFriendsUI, Context context) {
            this.nWx = nearbyFriendsUI;
            this.context = context;
        }

        public final int getCount() {
            return this.nWx.lqW.size();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            if (this.hBf == null) {
                this.hBf = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ b nWB;

                    {
                        this.nWB = r1;
                    }

                    public final String fE(int i) {
                        if (i < 0 || i >= this.nWB.getCount()) {
                            w.e("MicroMsg.NearbyFriend", "pos is invalid");
                            return null;
                        }
                        aiw qo = this.nWB.qo(i);
                        if (qo != null) {
                            return qo.jNj;
                        }
                        return null;
                    }

                    public final int Fh() {
                        return this.nWB.getCount();
                    }
                };
            }
            if (this.hBe != null) {
                this.hBe.a(i, this.hBf);
            }
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, R.i.djX, null);
                dVar2.hBj = (TextView) view.findViewById(R.h.cmJ);
                dVar2.nWE = (TextView) view.findViewById(R.h.cmM);
                dVar2.nWD = (TextView) view.findViewById(R.h.cmE);
                dVar2.hBi = (ImageView) view.findViewById(R.h.cmD);
                dVar2.hBk = (TextView) view.findViewById(R.h.cmG);
                dVar2.nWF = (ImageView) view.findViewById(R.h.cmO);
                dVar2.nWG = (ImageView) view.findViewById(R.h.cmN);
                dVar2.nWI = (ImageView) view.findViewById(R.h.cmA);
                dVar2.nWJ = (ImageView) view.findViewById(R.h.cmB);
                dVar2.nWK = (ImageView) view.findViewById(R.h.cmC);
                LayoutParams layoutParams = dVar2.nWG.getLayoutParams();
                layoutParams.height = com.tencent.mm.bg.a.T(this.context, R.f.aXH);
                layoutParams.width = com.tencent.mm.bg.a.T(this.context, R.f.aXH);
                dVar2.nWG.setLayoutParams(layoutParams);
                dVar2.nWH = (ImageView) view.findViewById(R.h.cmL);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            aiw com_tencent_mm_protocal_c_aiw = (aiw) this.nWx.lqW.get(i);
            dVar.hBj.setText(h.b(this.context, com_tencent_mm_protocal_c_aiw.jOp, dVar.hBj.getTextSize()));
            if (this.nWx.nWm == 1) {
                switch (com_tencent_mm_protocal_c_aiw.hAD) {
                    case 1:
                        dVar.nWH.setVisibility(0);
                        dVar.nWH.setImageResource(R.k.dxs);
                        dVar.nWH.setContentDescription(this.context.getString(R.l.ezq));
                        break;
                    case 2:
                        dVar.nWH.setVisibility(0);
                        dVar.nWH.setImageResource(R.k.dxr);
                        dVar.nWH.setContentDescription(this.context.getString(R.l.ejV));
                        break;
                    default:
                        dVar.nWH.setVisibility(8);
                        break;
                }
            }
            dVar.nWH.setVisibility(8);
            if (com_tencent_mm_protocal_c_aiw.tMP != 0) {
                dVar.nWF.setVisibility(0);
                dVar.nWF.setImageBitmap(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(com.tencent.mm.u.ag.a.hlU.eY(com_tencent_mm_protocal_c_aiw.tMP), 2.0f));
                dVar.nWH.setVisibility(8);
            } else {
                dVar.nWF.setVisibility(8);
            }
            dVar.nWD.setText(com_tencent_mm_protocal_c_aiw.tMO);
            dVar.nWI.setVisibility(8);
            dVar.nWJ.setVisibility(8);
            dVar.nWK.setVisibility(8);
            if (com_tencent_mm_protocal_c_aiw instanceof com.tencent.mm.plugin.nearby.a.a) {
                LinkedList linkedList = ((com.tencent.mm.plugin.nearby.a.a) com_tencent_mm_protocal_c_aiw).nVA;
                if (linkedList != null && linkedList.size() == 1) {
                    dVar.nWI.setVisibility(0);
                    NearbyFriendsUI.j(dVar.nWI, (String) linkedList.get(0));
                } else if (linkedList != null && linkedList.size() == 2) {
                    dVar.nWI.setVisibility(0);
                    dVar.nWJ.setVisibility(0);
                    NearbyFriendsUI.j(dVar.nWI, (String) linkedList.get(0));
                    NearbyFriendsUI.j(dVar.nWJ, (String) linkedList.get(1));
                } else if (linkedList != null && linkedList.size() >= 3) {
                    dVar.nWI.setVisibility(0);
                    dVar.nWJ.setVisibility(0);
                    dVar.nWK.setVisibility(0);
                    NearbyFriendsUI.j(dVar.nWI, (String) linkedList.get(0));
                    NearbyFriendsUI.j(dVar.nWJ, (String) linkedList.get(1));
                    NearbyFriendsUI.j(dVar.nWK, (String) linkedList.get(2));
                }
            }
            if (com_tencent_mm_protocal_c_aiw.hAG == null || com_tencent_mm_protocal_c_aiw.hAG.trim().equals("")) {
                dVar.nWE.setVisibility(8);
            } else {
                dVar.nWE.setVisibility(0);
                dVar.nWE.setText(h.b(this.context, com_tencent_mm_protocal_c_aiw.hAG, dVar.nWE.getTextSize()));
            }
            if (com_tencent_mm_protocal_c_aiw.tMV == null || (com_tencent_mm_protocal_c_aiw.tMV.hAO & 1) <= 0) {
                dVar.nWG.setVisibility(8);
            } else {
                dVar.nWG.setVisibility(0);
            }
            if (c.qp(com_tencent_mm_protocal_c_aiw.hAD)) {
                dVar.hBi.setImageBitmap(null);
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                ap.yY();
                aVar.hIO = com.tencent.mm.u.c.xb();
                aVar.hIL = true;
                aVar.hJh = true;
                n.GW().a(com_tencent_mm_protocal_c_aiw.jNj, dVar.hBi, aVar.Hg());
                if (!bg.mA(com_tencent_mm_protocal_c_aiw.hAI)) {
                    dVar.hBk.setText(com_tencent_mm_protocal_c_aiw.hAI);
                    dVar.hBk.setVisibility(0);
                }
                dVar.hBk.setVisibility(8);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(dVar.hBi, com_tencent_mm_protocal_c_aiw.jNj);
                ap.yY();
                if (com.tencent.mm.u.c.wR().QY(com_tencent_mm_protocal_c_aiw.jNj)) {
                    dVar.hBk.setVisibility(0);
                    if (x.yC(com_tencent_mm_protocal_c_aiw.tMP)) {
                        dVar.hBk.setText(this.nWx.getString(R.l.eCQ));
                    } else {
                        ap.yY();
                        x Ra = com.tencent.mm.u.c.wR().Ra(com_tencent_mm_protocal_c_aiw.jNj);
                        if (Ra != null) {
                            dVar.hBj.setText(h.b(this.context, bg.mA(Ra.tL()) ? com_tencent_mm_protocal_c_aiw.jOp : Ra.tL(), dVar.hBj.getTextSize()));
                        }
                        dVar.hBk.setText(this.nWx.getString(R.l.eCS));
                    }
                }
                dVar.hBk.setVisibility(8);
            }
            return view;
        }

        public final aiw qo(int i) {
            return (aiw) this.nWx.lqW.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    static class c {
        public static int nWC = 10000;

        public static boolean qp(int i) {
            return i == nWC;
        }

        public static String b(aiw com_tencent_mm_protocal_c_aiw) {
            if (com_tencent_mm_protocal_c_aiw != null) {
                return com_tencent_mm_protocal_c_aiw.hAE;
            }
            return null;
        }
    }

    static class d {
        ImageView hBi;
        TextView hBj;
        TextView hBk;
        TextView nWD;
        TextView nWE;
        ImageView nWF;
        ImageView nWG;
        ImageView nWH;
        ImageView nWI;
        ImageView nWJ;
        ImageView nWK;

        d() {
        }
    }

    static /* synthetic */ void j(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            return;
        }
        imageView.setImageBitmap(null);
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        ap.yY();
        aVar.hIO = com.tencent.mm.u.c.xb();
        aVar.hIL = true;
        aVar.hJh = true;
        n.GW().a(str, imageView, aVar.Hg());
    }

    static /* synthetic */ void w(NearbyFriendsUI nearbyFriendsUI) {
        if (nearbyFriendsUI.nWw != null) {
            nearbyFriendsUI.nWj = new com.tencent.mm.plugin.nearby.a.d(nearbyFriendsUI.nWw.hCQ, nearbyFriendsUI.nWw.hCP, nearbyFriendsUI.nWw.accuracy, "", "");
            Context context = nearbyFriendsUI.uSU.uTo;
            nearbyFriendsUI.getString(R.l.dIO);
            nearbyFriendsUI.irJ = g.a(context, nearbyFriendsUI.getString(R.l.eDe), true, new OnCancelListener(nearbyFriendsUI) {
                final /* synthetic */ NearbyFriendsUI nWx;

                {
                    this.nWx = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(this.nWx.nWj);
                }
            });
            com.tencent.mm.plugin.nearby.a.b.cV(3);
            ap.vd().a(nearbyFriendsUI.nWj, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        f.rY(11);
        super.onCreate(bundle);
        zi(R.l.eDc);
        ap.vd().a(JsApiScanCode.CTRL_INDEX, this);
        ap.vd().a(376, this);
        ap.vd().a(1087, this);
        this.gKi = com.tencent.mm.modelgeo.c.Gk();
        KC();
        this.nWl = new String[]{getResources().getString(R.l.eCW), getResources().getString(R.l.eCV), getResources().getString(R.l.eCU), getResources().getString(R.l.eOq)};
        ap.yY();
        this.nWm = bg.a((Integer) com.tencent.mm.u.c.vr().get(16386, null), 1);
        if (this.nWm == 3) {
            zl(R.k.dxs);
        } else if (this.nWm == 4) {
            zl(R.k.dxr);
        } else {
            zl(0);
            this.nWm = 1;
        }
        aOI();
    }

    private void aOI() {
        this.ngv = false;
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.irJ = g.a(context, getString(R.l.eCT), true, new OnCancelListener(this) {
            final /* synthetic */ NearbyFriendsUI nWx;

            {
                this.nWx = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.nWx.htv = true;
                f.sa(11);
                if (this.nWx.nWi != null) {
                    ap.vd().c(this.nWx.nWi);
                }
                w.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
                if (!this.nWx.nWt) {
                    this.nWx.finish();
                    w.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
                }
            }
        });
        this.htv = false;
        if (this.gKi != null) {
            this.gKi.a(this.gKp, true);
        }
    }

    protected final int getLayoutId() {
        return R.i.djV;
    }

    private void aOJ() {
        if (com.tencent.mm.az.a.bCj()) {
            View view;
            if (this.nWv != null) {
                this.nWh.removeHeaderView(this.nWv);
                this.nWv = null;
            }
            View inflate = View.inflate(this, R.i.djZ, null);
            TextView textView = (TextView) inflate.findViewById(R.h.czG);
            int Kr = l.Kz().Kr();
            if (Kr == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(R.j.dsD, Kr, new Object[]{Integer.valueOf(Kr)}));
                ImageView imageView = (ImageView) inflate.findViewById(R.h.cjn);
                com.tencent.mm.av.h Ks = l.Kz().Ks();
                if (Ks != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, Ks.field_sayhiuser);
                }
                inflate.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ NearbyFriendsUI nWx;

                    {
                        this.nWx = r1;
                    }

                    public final void onClick(View view) {
                        this.nWx.nWh.removeHeaderView(this.nWx.nWv);
                        this.nWx.nWv = null;
                        Intent intent = new Intent(this.nWx, NearbySayHiListUI.class);
                        intent.putExtra("k_say_hi_type", 2);
                        intent.putExtra("show_clear_header", true);
                        this.nWx.startActivityForResult(intent, 2009);
                    }
                });
                view = inflate;
            }
            this.nWv = view;
            if (this.nWv != null) {
                this.nWh.addHeaderView(this.nWv);
            }
        }
    }

    protected final void KC() {
        this.nWh = (ListView) findViewById(R.h.cmI);
        this.nWg = new b(this, this);
        ListView listView = this.nWh;
        if (this.nWo == null) {
            this.nWo = new LinearLayout(this);
            this.nWo.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ((LinearLayout) this.nWo).setGravity(17);
        }
        this.nWr = true;
        listView.addHeaderView(this.nWo);
        String value = com.tencent.mm.i.g.sV().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.nWs = Integer.valueOf(value).intValue();
            } catch (Exception e) {
                this.nWs = 0;
            }
        }
        ap.yY();
        value = (String) com.tencent.mm.u.c.vr().get(6, null);
        if (value != null && value.length() > 0) {
            this.nWs = 0;
        }
        this.nWu = 0;
        if (com.tencent.mm.u.a.g.Ae().gu(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            value = com.tencent.mm.u.a.g.Ae().gu(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).value;
            com.tencent.mm.modelfriend.m.a Fl = m.Fl();
            if (value.equals("0")) {
                this.nWu = 0;
            } else if (value.equals("2")) {
                if (Fl == com.tencent.mm.modelfriend.m.a.hBt) {
                    this.nWu = 2;
                    com.tencent.mm.u.a.f.gy(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            } else if (value.equals("1") && Fl == com.tencent.mm.modelfriend.m.a.hBq) {
                this.nWu = 2;
                com.tencent.mm.u.a.f.gy(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
        }
        if ((this.nWs > 0 || this.nWu > 0) && this.nWu != 1) {
            this.nWn = new BindMobileOrQQHeaderView(this);
            this.nWh.addHeaderView(this.nWn);
        }
        this.nWh.setAdapter(this.nWg);
        this.nWh.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NearbyFriendsUI nWx;

            {
                this.nWx = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.nWx.nWs > 0 || this.nWx.nWu > 0) {
                    i--;
                }
                if (com.tencent.mm.az.a.bCj() && this.nWx.nWv != null) {
                    i--;
                }
                if (this.nWx.nWr) {
                    i--;
                }
                if (i >= 0 && i < this.nWx.lqW.size()) {
                    aiw com_tencent_mm_protocal_c_aiw = (aiw) this.nWx.lqW.get(i);
                    Intent intent;
                    if (c.qp(com_tencent_mm_protocal_c_aiw.hAD)) {
                        String b = c.b(com_tencent_mm_protocal_c_aiw);
                        w.d("MicroMsg.NearbyFriend", "poi item click, go:" + bg.mz(b));
                        if (!bg.mA(b)) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", b);
                            intent.putExtra("geta8key_scene", 25);
                            intent.putExtra("stastic_scene", 12);
                            com.tencent.mm.bb.d.b(this.nWx.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                            return;
                        }
                        return;
                    }
                    String str = com_tencent_mm_protocal_c_aiw.jNj;
                    ap.yY();
                    com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
                    if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Contact_Scene", 18);
                        intent2.putExtra("Sns_from_Scene", 18);
                        intent2.putExtra("lbs_ticket", com_tencent_mm_protocal_c_aiw.tBM);
                        intent2.putExtra("Contact_IsLbsGotoChatting", true);
                        if (str != null && str.length() > 0) {
                            if (Rc.bLe()) {
                                com.tencent.mm.plugin.report.service.g.oUh.A(10298, str + ",18");
                            }
                            com.tencent.mm.sdk.b.b nzVar = new nz();
                            nzVar.fVf.intent = intent2;
                            nzVar.fVf.username = str;
                            com.tencent.mm.sdk.b.a.urY.m(nzVar);
                            com.tencent.mm.plugin.nearby.a.imv.d(intent2, this.nWx);
                            return;
                        }
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("Contact_User", com_tencent_mm_protocal_c_aiw.jNj);
                    intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_aiw.hAI);
                    intent.putExtra("Contact_Nick", com_tencent_mm_protocal_c_aiw.jOp);
                    intent.putExtra("Contact_Distance", com_tencent_mm_protocal_c_aiw.tMO);
                    intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_aiw.hAG);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(com_tencent_mm_protocal_c_aiw.hAM, com_tencent_mm_protocal_c_aiw.hAE, com_tencent_mm_protocal_c_aiw.hAF));
                    intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_aiw.hAD);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_Scene", 18);
                    intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_aiw.tMQ);
                    intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_aiw.tMP);
                    intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_aiw.tMT);
                    intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_aiw.tMR);
                    intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_aiw.tMS);
                    intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_aiw.tMV.hAO);
                    intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_aiw.tMV.hAQ);
                    intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_aiw.tMV.hAP);
                    intent.putExtra("lbs_ticket", com_tencent_mm_protocal_c_aiw.tBM);
                    intent.putExtra("Contact_IsLbsGotoChatting", true);
                    if (com_tencent_mm_protocal_c_aiw.hAN != null) {
                        com.tencent.mm.sdk.e.c bizInfo = new BizInfo();
                        bizInfo.field_brandList = com_tencent_mm_protocal_c_aiw.hAN;
                        bizInfo.field_brandFlag = com_tencent_mm_protocal_c_aiw.tMW.hAR;
                        bizInfo.field_brandIconURL = com_tencent_mm_protocal_c_aiw.tMW.hAU;
                        bizInfo.field_extInfo = com_tencent_mm_protocal_c_aiw.tMW.hAS;
                        bizInfo.field_brandInfo = com_tencent_mm_protocal_c_aiw.tMW.hAT;
                        intent.putExtra("KBrandInfo_item", new MCacheItem(bizInfo));
                    }
                    intent.putExtra("Sns_from_Scene", 18);
                    com.tencent.mm.plugin.nearby.a.imv.d(intent, this.nWx);
                }
            }
        });
        this.nWh.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ NearbyFriendsUI nWx;

            {
                this.nWx = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.nWx.nWg != null) {
                    b s = this.nWx.nWg;
                    if (s.hBe != null) {
                        s.hBe.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendsUI nWx;

            {
                this.nWx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nWx.finish();
                return true;
            }
        });
        AnonymousClass13 anonymousClass13 = new OnClickListener(this) {
            final /* synthetic */ NearbyFriendsUI nWx;

            {
                this.nWx = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.nWx.nWh);
            }
        };
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendsUI nWx;

            {
                this.nWx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.nWx, com.tencent.mm.ui.widget.e.wuP, false);
                eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                    final /* synthetic */ AnonymousClass14 nWz;

                    {
                        this.nWz = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (i) {
                            case 0:
                                this.nWz.nWx.nWm = 4;
                                this.nWz.nWx.nWk = false;
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(16386, Integer.valueOf(this.nWz.nWx.nWm));
                                this.nWz.nWx.aOI();
                                return;
                            case 1:
                                this.nWz.nWx.nWm = 3;
                                this.nWz.nWx.nWk = false;
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(16386, Integer.valueOf(this.nWz.nWx.nWm));
                                this.nWz.nWx.aOI();
                                return;
                            case 2:
                                this.nWz.nWx.nWm = 1;
                                this.nWz.nWx.nWk = false;
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(16386, Integer.valueOf(this.nWz.nWx.nWm));
                                this.nWz.nWx.aOI();
                                return;
                            case 3:
                                Intent intent = new Intent(this.nWz.nWx, NearbySayHiListUI.class);
                                intent.putExtra("k_say_hi_type", 2);
                                this.nWz.nWx.startActivityForResult(intent, 2009);
                                return;
                            case 4:
                                this.nWz.nWx.nVU = new com.tencent.mm.plugin.nearby.a.c(2, 0.0f, 0.0f, 0, 0, "", "");
                                ap.vd().a(this.nWz.nWx.nVU, 0);
                                NearbyFriendsUI nearbyFriendsUI = this.nWz.nWx;
                                Context context = this.nWz.nWx.uSU.uTo;
                                this.nWz.nWx.getString(R.l.dIO);
                                nearbyFriendsUI.irJ = g.a(context, this.nWz.nWx.getString(R.l.eCN), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass1 nWA;

                                    {
                                        this.nWA = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(this.nWA.nWz.nWx.nVU);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                };
                eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ AnonymousClass14 nWz;

                    {
                        this.nWz = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.dX(-1, R.l.eCW);
                        lVar.dX(-1, R.l.eCV);
                        lVar.dX(-1, R.l.eCU);
                        lVar.dX(-1, R.l.eOq);
                        lVar.dX(-1, R.l.eCJ);
                    }
                };
                eVar.bzh();
                return true;
            }
        });
    }

    private void aOK() {
        com.tencent.mm.plugin.nearby.a.imv.aj(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.nWk = false;
                    aOI();
                    return;
                }
                return;
            case 2009:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.gKi != null) {
            this.gKi.c(this.gKp);
        }
        com.tencent.mm.sdk.b.a.urY.c(this.gKr);
    }

    protected void onResume() {
        super.onResume();
        if (this.gKi != null) {
            this.gKi.a(this.gKp, true);
        }
        aOJ();
        this.nWg.notifyDataSetChanged();
        if (l.Kz().Kr() == 0) {
            this.nWh.removeHeaderView(this.nWq);
        }
        com.tencent.mm.sdk.b.a.urY.b(this.gKr);
    }

    protected void onDestroy() {
        if (this.nWu > 0) {
            com.tencent.mm.u.a.f.gz(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        f.sa(11);
        ap.vd().b(JsApiScanCode.CTRL_INDEX, this);
        ap.vd().b(376, this);
        ap.vd().b(1087, this);
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
        if (this.gKi != null) {
            this.gKi.c(this.gKp);
        }
        com.tencent.mm.x.n.Bz().cancel();
        if (this.nWg != null) {
            b bVar = this.nWg;
            if (bVar.hBe != null) {
                bVar.hBe.detach();
                bVar.hBe = null;
            }
        }
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
            int AJ = ((com.tencent.mm.plugin.nearby.a.c) kVar).AJ();
            if (this.nWi != null || (AJ != 1 && AJ != 3 && AJ != 4)) {
                if ((AJ == 1 || AJ == 3 || AJ == 4) && this.nWk) {
                    w.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[]{Integer.valueOf(AJ)});
                } else if (this.nVU != null || AJ != 2) {
                    w.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
                        if (this.irJ != null) {
                            this.irJ.dismiss();
                            this.irJ = null;
                        }
                        if (i == 0 && i2 == 0) {
                            if (AJ == 1 || AJ == 3 || AJ == 4) {
                                this.lqW = ((com.tencent.mm.plugin.nearby.a.c) kVar).aOF();
                                if (this.lqW == null || this.lqW.size() == 0) {
                                    findViewById(R.h.cmK).setVisibility(0);
                                    this.nWh.setVisibility(8);
                                    aOK();
                                    f.sa(11);
                                } else {
                                    findViewById(R.h.cmK).setVisibility(8);
                                    List linkedList = new LinkedList();
                                    int i3 = 0;
                                    for (aiw com_tencent_mm_protocal_c_aiw : this.lqW) {
                                        ap.yY();
                                        if (com.tencent.mm.u.c.wR().QY(com_tencent_mm_protocal_c_aiw.jNj)) {
                                            linkedList.add(i3, com_tencent_mm_protocal_c_aiw);
                                            i3++;
                                        } else {
                                            linkedList.add(com_tencent_mm_protocal_c_aiw);
                                        }
                                    }
                                    this.lqW.clear();
                                    this.lqW = linkedList;
                                    if (this.nhM != null) {
                                        for (AJ = this.nhM.size() - 1; AJ >= 0; AJ--) {
                                            if (this.nhM.get(AJ) != null) {
                                                this.lqW.add(0, this.nhM.get(AJ));
                                            }
                                        }
                                    }
                                    this.nWg.notifyDataSetChanged();
                                    if (this.nWg.getCount() > 0) {
                                        this.nWh.setSelection(0);
                                    }
                                    this.nWh.post(new Runnable(this) {
                                        final /* synthetic */ NearbyFriendsUI nWx;

                                        {
                                            this.nWx = r1;
                                        }

                                        public final void run() {
                                            f.rZ(11);
                                        }
                                    });
                                }
                                if (this.nWm == 3) {
                                    zl(R.k.dxs);
                                } else if (this.nWm == 4) {
                                    zl(R.k.dxr);
                                } else {
                                    zl(0);
                                    this.nWm = 1;
                                }
                                this.nWk = true;
                                this.nWi = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) kVar).AJ() == 2) {
                                g.a(this.uSU.uTo, getString(R.l.eCM), "", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ NearbyFriendsUI nWx;

                                    {
                                        this.nWx = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.nWx.finish();
                                    }
                                });
                                this.nVU = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) kVar).aOD()) {
                                CharSequence string = getString(R.l.eDf);
                                int aOE = ((com.tencent.mm.plugin.nearby.a.c) kVar).aOE();
                                if (this.nWo != null) {
                                    if (this.nWp == null) {
                                        this.nWp = View.inflate(this, R.i.dka, null);
                                        this.nWo.addView(this.nWp);
                                        this.nWp.setOnClickListener(new OnClickListener(this) {
                                            final /* synthetic */ NearbyFriendsUI nWx;

                                            {
                                                this.nWx = r1;
                                            }

                                            public final void onClick(View view) {
                                                NearbyFriendsUI.w(this.nWx);
                                            }
                                        });
                                    } else {
                                        this.nWp.setVisibility(0);
                                    }
                                    ((TextView) this.nWp.findViewById(R.h.cmQ)).setText(string);
                                    if (aOE != 0) {
                                        ((TextView) this.nWp.findViewById(R.h.cmP)).setText(String.format(getResources().getQuantityString(R.j.dsw, aOE, new Object[]{Integer.valueOf(aOE)}), new Object[0]));
                                    }
                                }
                            } else if (!(this.nWp == null || this.nWo == null)) {
                                this.nWp.setVisibility(8);
                            }
                            this.nWt = true;
                            return;
                        }
                        if (AJ == 1 || AJ == 3 || AJ == 4) {
                            com.tencent.mm.f.a aVar;
                            TextView textView = (TextView) findViewById(R.h.cmK);
                            textView.setVisibility(0);
                            aOK();
                            if (str == null || str.length() <= 0) {
                                aVar = null;
                            } else {
                                aVar = com.tencent.mm.f.a.dn(str);
                            }
                            if (aVar != null && aVar.desc != null && aVar.desc.length() > 0) {
                                textView.setText(aVar.desc);
                            } else if (i2 == -2001) {
                                textView.setText(getString(R.l.eCO));
                            } else {
                                textView.setText(getString(R.l.eCR));
                            }
                            this.nWh.setVisibility(8);
                            this.nWi = null;
                        }
                        if (((com.tencent.mm.plugin.nearby.a.c) kVar).AJ() == 2) {
                            Toast.makeText(this, R.l.eCL, 1).show();
                            this.nVU = null;
                        }
                    }
                }
            }
        } else if (kVar.getType() == 376 && ((com.tencent.mm.plugin.nearby.a.d) kVar).AJ() == 1) {
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            if (i == 0 && i2 == 0 && ((com.tencent.mm.plugin.nearby.a.d) kVar).nVD != null) {
                String str2 = ((com.tencent.mm.plugin.nearby.a.d) kVar).nVD;
                com.tencent.mm.plugin.nearby.a.b.cY(str2, ((com.tencent.mm.plugin.nearby.a.d) kVar).nVE);
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str2);
                com.tencent.mm.plugin.nearby.a.imv.f(intent, this);
                return;
            }
            g.a(this.uSU.uTo, R.l.eDd, R.l.dIO, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ NearbyFriendsUI nWx;

                {
                    this.nWx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
