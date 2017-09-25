package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.ui.r.c;
import com.tencent.mm.plugin.game.ui.s.a;
import com.tencent.mm.protocal.c.sw;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.protocal.c.tb;
import com.tencent.mm.protocal.c.tc;
import com.tencent.mm.protocal.c.td;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI extends MMActivity implements b, e {
    private static final Pattern mFa = Pattern.compile("\\s+");
    private int fromScene;
    private View jAt;
    private ProgressBar jKM;
    private p kww;
    private ViewGroup mFb;
    private TextView mFc;
    private ListView mFd;
    private ListView mFe;
    private r mFf;
    private s mFg;
    private String mFh;
    private String mFi;
    private LinkedList<String> mFj;
    private String mFk;
    private LinkedList<k> mFl = new LinkedList();
    private boolean mFm = false;
    private OnItemClickListener mFn = new OnItemClickListener(this) {
        final /* synthetic */ GameSearchUI mFp;

        {
            this.mFp = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            r b = this.mFp.mFf;
            c cVar = (i < 0 || i >= b.getCount()) ? null : ((r.b) b.getItem(i)).mEQ;
            if (cVar != null) {
                Map hashMap;
                if (cVar.actionType == 1 && !bg.mA(cVar.appId)) {
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", cVar.appId);
                    bundle.putInt("game_report_from_scene", cVar.fTL);
                    int a = com.tencent.mm.plugin.game.d.c.a(this.mFp, cVar.appId, null, bundle);
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.mES);
                    hashMap.put("keyword", this.mFp.mFh);
                    ai.a(this.mFp, 14, cVar.fTL, cVar.position, a, cVar.appId, this.mFp.fromScene, ai.u(hashMap));
                } else if (cVar.actionType == 2 && !bg.mA(cVar.mER)) {
                    com.tencent.mm.plugin.game.d.c.n(this.mFp, cVar.mER, "game_center_detail");
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.mES);
                    hashMap.put("keyword", this.mFp.mFh);
                    ai.a(this.mFp, 14, cVar.fTL, cVar.position, 7, 0, cVar.appId, this.mFp.fromScene, cVar.mEM, String.valueOf(cVar.mEN), null, ai.u(hashMap));
                }
            }
        }
    };
    private OnItemClickListener mFo = new OnItemClickListener(this) {
        final /* synthetic */ GameSearchUI mFp;

        {
            this.mFp = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a nM = ((s) adapterView.getAdapter()).nM(i);
            if (!bg.mA(nM.text)) {
                if (bg.mA(nM.appId)) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(nM.text);
                    this.mFp.a(linkedList, 2, true);
                    this.mFp.nN(1);
                    return;
                }
                switch (nM.actionType) {
                    case 1:
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", nM.appId);
                        bundle.putInt("game_report_from_scene", 1402);
                        int a = com.tencent.mm.plugin.game.d.c.a(this.mFp, nM.appId, null, bundle);
                        ai.a(this.mFp, 14, 1402, i, a, nM.appId, this.mFp.fromScene, null);
                        return;
                    case 2:
                        com.tencent.mm.plugin.game.d.c.n(this.mFp.uSU.uTo, nM.mET, "game_center_detail");
                        ai.a(this.mFp, 14, 1402, i, 7, nM.appId, this.mFp.fromScene, null);
                        return;
                    default:
                        w.e("MicroMsg.GameSearchUI", "unknowed actionType : " + nM.actionType);
                        return;
                }
            }
        }
    };

    public final void OF() {
    }

    public final void OG() {
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (ap.zb()) {
            ap.vd().a(1328, this);
            ap.vd().a(1329, this);
            this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
            KC();
            ai.a((Context) this, 14, 1401, 0, 2, this.fromScene, null);
            w.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        w.e("MicroMsg.GameSearchUI", "account not ready");
        finish();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameSearchUI mFp;

            {
                this.mFp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mFp.onBackPressed();
                return true;
            }
        });
        this.kww = new p();
        this.kww.lK(true);
        this.kww.woe = this;
        this.mFb = (ViewGroup) findViewById(R.h.cNM);
        this.jKM = (ProgressBar) findViewById(R.h.cAW);
        this.mFc = (TextView) findViewById(R.h.coo);
        this.mFd = (ListView) findViewById(R.h.cAZ);
        this.mFf = new r(this);
        this.mFd.setAdapter(this.mFf);
        this.mFd.setOnItemClickListener(this.mFn);
        this.mFd.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ GameSearchUI mFp;

            {
                this.mFp = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.mFp.mFd.clearFocus();
                this.mFp.aHf();
                return false;
            }
        });
        this.mFd.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ GameSearchUI mFp;

            {
                this.mFp = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.mFp.mFf.mEu) {
                    if (this.mFp.jAt != null) {
                        this.mFp.jAt.setVisibility(0);
                    }
                    this.mFp.a(this.mFp.mFj, 0, false);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jAt = getLayoutInflater().inflate(R.i.deP, this.mFd, false);
        this.jAt.setVisibility(8);
        this.mFd.addFooterView(this.jAt);
        this.mFe = (ListView) findViewById(R.h.cAX);
        this.mFg = new s(this);
        this.mFe.setAdapter(this.mFg);
        this.mFe.setOnItemClickListener(this.mFo);
        this.mFe.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ GameSearchUI mFp;

            {
                this.mFp = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.mFp.mFe.clearFocus();
                this.mFp.aHf();
                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kww.a(this, menu);
        this.kww.setHint(SubCoreGameCenter.aBz());
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kww.a(this, menu);
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dfl;
    }

    private void nN(int i) {
        switch (i) {
            case 0:
                this.mFb.setVisibility(8);
                this.mFc.setVisibility(8);
                this.mFd.setVisibility(8);
                this.mFe.setVisibility(8);
                this.jKM.setVisibility(8);
                return;
            case 1:
                aHf();
                this.mFd.smoothScrollToPosition(0);
                this.kww.clearFocus();
                this.mFb.setVisibility(8);
                this.mFc.setVisibility(8);
                this.mFd.setVisibility(8);
                this.mFe.setVisibility(8);
                this.jKM.setVisibility(0);
                return;
            case 2:
                this.mFb.setVisibility(8);
                if (this.mFf.getCount() > 0) {
                    this.mFc.setVisibility(8);
                    this.mFd.setVisibility(0);
                } else {
                    this.mFc.setVisibility(0);
                    this.mFd.setVisibility(8);
                }
                this.mFe.setVisibility(8);
                this.jKM.setVisibility(8);
                return;
            case 3:
                this.mFb.setVisibility(0);
                this.mFc.setVisibility(8);
                this.mFd.setVisibility(8);
                this.mFe.setVisibility(8);
                this.jKM.setVisibility(8);
                return;
            case 4:
                this.mFb.setVisibility(8);
                this.mFc.setVisibility(0);
                this.mFd.setVisibility(8);
                this.mFe.setVisibility(8);
                this.jKM.setVisibility(8);
                return;
            case 5:
                this.mFb.setVisibility(8);
                this.mFc.setVisibility(8);
                this.mFd.setVisibility(8);
                this.mFe.setVisibility(0);
                this.jKM.setVisibility(8);
                return;
            case 6:
                this.mFd.smoothScrollToPosition(0);
                this.mFb.setVisibility(8);
                this.mFc.setVisibility(8);
                this.mFd.setVisibility(8);
                this.mFe.setVisibility(8);
                this.jKM.setVisibility(0);
                return;
            default:
                return;
        }
    }

    private void c(LinkedList<String> linkedList, int i) {
        a(linkedList, 0, true);
    }

    private void a(LinkedList<String> linkedList, int i, boolean z) {
        while (!this.mFl.isEmpty()) {
            h.vJ();
            h.vH().gXC.c((k) this.mFl.pop());
        }
        if (z) {
            r rVar = this.mFf;
            rVar.mqY = 0;
            rVar.mEu = false;
        }
        this.mFj = linkedList;
        k amVar = new am(v.bIN(), linkedList, com.tencent.mm.plugin.game.model.e.aAC(), this.mFf.mqY);
        ap.vd().a(amVar, 0);
        this.mFl.add(amVar);
        Iterator it = linkedList.iterator();
        this.mFh = "";
        while (it.hasNext()) {
            this.mFh += " " + ((String) it.next());
        }
        this.mFh = this.mFh.trim();
        if (i == 1 || i == 2) {
            this.mFm = true;
            this.kww.Ug(this.mFh);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!kVar.hsG) {
            if (this.mFl.contains(kVar)) {
                this.mFl.remove(kVar);
            }
            this.jAt.setVisibility(8);
            switch (kVar.getType()) {
                case 1328:
                    ta taVar = (ta) ((am) kVar).ldw.hsj.hsr;
                    w.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[]{taVar.tAV, Integer.valueOf(taVar.tAW)});
                    if (i == 0 && i2 == 0) {
                        tb tbVar = (tb) ((am) kVar).ldw.hsk.hsr;
                        LinkedList linkedList = tbVar != null ? tbVar.tAX : null;
                        if (!bg.bV(linkedList)) {
                            this.mFi = this.mFh;
                            tc tcVar;
                            if (this.mFf.mqY != 0) {
                                r rVar = this.mFf;
                                String str2 = this.mFi;
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    tcVar = (tc) it.next();
                                    if (tcVar.type != 3 || bg.bV(tcVar.tAZ)) {
                                        rVar.mEu = false;
                                    } else {
                                        rVar.mqY = tcVar.tBd;
                                        rVar.mEu = tcVar.tBe;
                                        Iterator it2 = tcVar.tAZ.iterator();
                                        while (it2.hasNext()) {
                                            r.b a = r.b.a((te) it2.next());
                                            a.fDs = str2;
                                            a.mEQ.appId = a.appId;
                                            a.mEQ.mEM = a.mEM;
                                            a.mEQ.mEN = a.mEN;
                                            a.mEQ.mES = "2";
                                            c cVar = a.mEQ;
                                            int i3 = rVar.mEr;
                                            rVar.mEr = i3 + 1;
                                            cVar.position = i3 + com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX;
                                            a.mEQ.fTL = rVar.fDw ? 1403 : 1405;
                                            rVar.kyt.add(a);
                                        }
                                    }
                                }
                            } else {
                                r rVar2 = this.mFf;
                                String str3 = this.mFi;
                                if (rVar2.kyt == null) {
                                    rVar2.kyt = new ArrayList();
                                }
                                rVar2.mBF = 0;
                                rVar2.mEp = 0;
                                rVar2.mEq = 0;
                                rVar2.mEr = 0;
                                rVar2.mEs = 0;
                                rVar2.fDw = false;
                                rVar2.mEo = false;
                                rVar2.mEu = false;
                                rVar2.mqY = 0;
                                rVar2.kyt.clear();
                                rVar2.mEv = false;
                                Iterator it3 = linkedList.iterator();
                                while (it3.hasNext()) {
                                    tcVar = (tc) it3.next();
                                    Object obj = (tcVar.tAY == null || tcVar.tAY.size() == 0) ? 1 : null;
                                    Object obj2 = (tcVar.tAZ == null || tcVar.tAZ.size() == 0) ? 1 : null;
                                    Object obj3 = (tcVar.tBc == null || tcVar.tBc.size() == 0) ? 1 : null;
                                    obj2 = (obj == null || obj2 == null || obj3 == null) ? null : 1;
                                    if (obj2 == null) {
                                        Iterator it4;
                                        r.b bVar;
                                        c cVar2;
                                        int i4;
                                        rVar2.kyt.add(r.b.ac(0, tcVar.fDC));
                                        if (!rVar2.mEv) {
                                            ((r.b) rVar2.kyt.get(rVar2.kyt.size() - 1)).mEO = true;
                                            rVar2.mEv = true;
                                        }
                                        if (tcVar.type == 4 && tcVar.tBc != null) {
                                            it4 = tcVar.tBc.iterator();
                                            while (it4.hasNext()) {
                                                td tdVar = (td) it4.next();
                                                bVar = new r.b();
                                                bVar.type = 3;
                                                bVar.appId = tdVar.tBf.mtb;
                                                bVar.name = tdVar.tBf.msj;
                                                bVar.iBi = tdVar.tBf.tsz;
                                                bVar.iconUrl = tdVar.tBf.muU;
                                                bVar.mEI = tdVar.tBf.msl;
                                                bVar.mEJ = tdVar.tBf.tAK;
                                                bVar.actionType = tdVar.tBf.tAL;
                                                bVar.mEK = tdVar.tBf.tAM;
                                                bVar.mEL = tdVar.tBg;
                                                bVar.mEQ = new c(tdVar.tBf.tAL, 4, tdVar.tBf.mtb, tdVar.tBf.tAM);
                                                bVar.fDs = str3;
                                                bVar.mEQ.mES = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                                cVar2 = bVar.mEQ;
                                                i4 = rVar2.mEq;
                                                rVar2.mEq = i4 + 1;
                                                cVar2.position = i4 + 601;
                                                rVar2.kyt.add(bVar);
                                            }
                                        }
                                        if ((tcVar.type == 1 || tcVar.type == 2) && tcVar.tAY != null) {
                                            it4 = tcVar.tAY.iterator();
                                            while (it4.hasNext()) {
                                                sw swVar = (sw) it4.next();
                                                bVar = new r.b();
                                                bVar.type = 1;
                                                bVar.appId = swVar.mtb;
                                                bVar.name = swVar.msj;
                                                bVar.iBi = swVar.tsz;
                                                bVar.iconUrl = swVar.muU;
                                                bVar.mEI = swVar.msl;
                                                bVar.mEJ = swVar.tAK;
                                                bVar.actionType = swVar.tAL;
                                                bVar.mEK = swVar.tAM;
                                                bVar.mEQ = new c(swVar.tAL, 1, swVar.mtb, swVar.tAM);
                                                bVar.fDs = str3;
                                                if (tcVar.type == 1) {
                                                    rVar2.fDw = true;
                                                    cVar2 = bVar.mEQ;
                                                    i4 = rVar2.mBF;
                                                    rVar2.mBF = i4 + 1;
                                                    cVar2.position = i4 + 1;
                                                } else if (tcVar.type == 2) {
                                                    rVar2.mEo = true;
                                                    cVar2 = bVar.mEQ;
                                                    i4 = rVar2.mEp;
                                                    rVar2.mEp = i4 + 1;
                                                    cVar2.position = i4 + 1;
                                                }
                                                bVar.mEQ.mES = "1";
                                                rVar2.kyt.add(bVar);
                                            }
                                        } else if (tcVar.type == 3 && tcVar.tAZ != null) {
                                            rVar2.mqY = tcVar.tBd;
                                            rVar2.mEu = tcVar.tBe;
                                            it4 = tcVar.tAZ.iterator();
                                            while (it4.hasNext()) {
                                                r.b a2 = r.b.a((te) it4.next());
                                                a2.fDs = str3;
                                                a2.mEQ.appId = a2.appId;
                                                a2.mEQ.mEM = a2.mEM;
                                                a2.mEQ.mEN = a2.mEN;
                                                a2.mEQ.mES = "2";
                                                c cVar3 = a2.mEQ;
                                                i4 = rVar2.mEr;
                                                rVar2.mEr = i4 + 1;
                                                cVar3.position = i4 + com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX;
                                                rVar2.kyt.add(a2);
                                            }
                                        }
                                        if (!(bg.mA(tcVar.tBa) || bg.mA(tcVar.tBb) || tcVar.type != 1)) {
                                            String str4 = tcVar.tBa;
                                            String str5 = tcVar.tBb;
                                            r.b bVar2 = new r.b();
                                            bVar2.type = 5;
                                            bVar2.name = str4;
                                            bVar2.mEQ = new c(str5);
                                            bVar2.mEQ.appId = "wx62d9035fd4fd2059";
                                            bVar2.mEQ.mES = "1";
                                            bVar2.mEQ.position = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                                            rVar2.kyt.add(bVar2);
                                        }
                                    } else if (tcVar.type == 1) {
                                        rVar2.kyt.add(r.b.ac(6, !bg.mA(str3) ? rVar2.context.getString(R.l.epy, new Object[]{str3}) : rVar2.context.getString(R.l.epx)));
                                        rVar2.mEv = true;
                                    }
                                }
                                Iterator it5 = rVar2.kyt.iterator();
                                while (it5.hasNext()) {
                                    r.b bVar3 = (r.b) it5.next();
                                    if (rVar2.fDw) {
                                        bVar3.mEQ.fTL = 1403;
                                    } else if (rVar2.mEo) {
                                        bVar3.mEQ.fTL = 1404;
                                    } else {
                                        bVar3.mEQ.fTL = 1405;
                                    }
                                }
                                rVar2.notifyDataSetChanged();
                            }
                        }
                    }
                    nN(2);
                    return;
                case 1329:
                    if (i == 0 && i2 == 0) {
                        this.mFg.a(((an) kVar).fDs, ((sy) ((an) kVar).ldw.hsk.hsr).fDC, ((sy) ((an) kVar).ldw.hsk.hsr).tAT);
                        nN(5);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onDestroy() {
        w.i("MicroMsg.GameSearchUI", "onDestroy");
        super.onDestroy();
        ap.vd().b(1328, this);
        ap.vd().b(1329, this);
    }

    public final void OE() {
    }

    public final void OD() {
        aHf();
        onBackPressed();
    }

    public final void mR(String str) {
        if (this.mFm) {
            this.mFm = false;
        } else if (this.mFk == null || !this.mFk.equals(bg.mz(str))) {
            this.mFk = str;
            if (bg.mA(str)) {
                while (!this.mFl.isEmpty()) {
                    h.vJ();
                    h.vH().gXC.c((k) this.mFl.pop());
                }
                k anVar = new an(v.bIN(), str, com.tencent.mm.plugin.game.model.e.aAC());
                ap.vd().a(anVar, 0);
                this.mFl.add(anVar);
                return;
            }
            LinkedList linkedList = new LinkedList();
            String[] split = mFa.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            c(linkedList, 0);
            nN(6);
        } else {
            w.d("MicroMsg.GameSearchUI", "repeat searchChange");
        }
    }

    public final boolean mQ(String str) {
        if (!bg.mA(str)) {
            LinkedList linkedList = new LinkedList();
            String[] split = mFa.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            c(linkedList, 0);
            nN(1);
        }
        return true;
    }
}
