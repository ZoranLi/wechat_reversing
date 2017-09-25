package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.m;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.q;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.base.FavCapacityPanel;
import com.tencent.mm.plugin.favorite.ui.base.FavSearchActionView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.plugin.favorite.ui.base.FavTypePanel;
import com.tencent.mm.plugin.favorite.ui.c.e;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.d;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@a(19)
public class FavSearchUI extends MMActivity {
    private String fAR;
    private int icN;
    private ListView kae;
    private g lGT;
    private b lGU;
    private String lHC;
    private Set<Integer> lHD;
    private x.a lHE;
    private c lHF;
    private FavSearchActionView lHG;
    private FavTypePanel lHH;
    private ListView lHI;
    private View lHJ;
    private FavCapacityPanel lHK;
    private Animation lHL;
    private Animation lHM;
    private List<Integer> lHN;
    private List<String> lHO;
    private List<String> lHP;
    private Set<String> lHQ = new HashSet();
    private View lHR;
    private ImageButton lHS;
    private MenuItem lHT;
    private List<Long> lHU = new ArrayList();
    private ae mHandler;

    static /* synthetic */ void a(FavSearchUI favSearchUI, List list, List list2, List list3) {
        if ((list == null || list.isEmpty()) && ((list2 == null || list2.isEmpty()) && (list3 == null || list3.isEmpty()))) {
            favSearchUI.lHS.setVisibility(8);
        } else {
            favSearchUI.lHS.setVisibility(0);
        }
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, boolean z) {
        favSearchUI.lGU.notifyDataSetChanged();
        if (8 != favSearchUI.lHI.getVisibility()) {
            favSearchUI.lHI.setVisibility(8);
            favSearchUI.lHI.startAnimation(favSearchUI.lHM);
        }
        if (favSearchUI.lGU.isEmpty()) {
            if (favSearchUI.lHJ.getVisibility() != 0) {
                favSearchUI.lHJ.setVisibility(0);
                favSearchUI.lHJ.startAnimation(favSearchUI.lHL);
            }
            if (8 != favSearchUI.kae.getVisibility()) {
                favSearchUI.kae.setVisibility(8);
                favSearchUI.kae.startAnimation(favSearchUI.lHM);
            }
        } else {
            if (8 != favSearchUI.lHJ.getVisibility()) {
                favSearchUI.lHJ.setVisibility(8);
                favSearchUI.lHJ.startAnimation(favSearchUI.lHM);
            }
            if (favSearchUI.kae.getVisibility() != 0) {
                favSearchUI.kae.setVisibility(0);
                favSearchUI.kae.startAnimation(favSearchUI.lHL);
            }
        }
        if (favSearchUI.lGU.isEmpty() && ((favSearchUI.lHO == null || favSearchUI.lHO.isEmpty()) && ((favSearchUI.lHN == null || favSearchUI.lHN.isEmpty()) && favSearchUI.lHP != null && favSearchUI.lHP.size() == 1))) {
            w.w("MicroMsg.FavSearchUI", "need del tag %s", new Object[]{(String) favSearchUI.lHP.get(0)});
            favSearchUI.lHQ.add(r0);
        }
        if (z) {
            favSearchUI.aHf();
        }
    }

    static /* synthetic */ void c(FavSearchUI favSearchUI) {
        favSearchUI.lHF.notifyDataSetChanged();
        if (favSearchUI.lHI.getVisibility() != 0) {
            favSearchUI.lHI.setVisibility(0);
            favSearchUI.lHI.startAnimation(favSearchUI.lHL);
        }
        if (8 != favSearchUI.kae.getVisibility()) {
            favSearchUI.kae.setVisibility(8);
            favSearchUI.kae.startAnimation(favSearchUI.lHM);
        }
        if (8 != favSearchUI.lHJ.getVisibility()) {
            favSearchUI.lHJ.setVisibility(8);
            favSearchUI.lHJ.startAnimation(favSearchUI.lHM);
        }
    }

    static /* synthetic */ int j(FavSearchUI favSearchUI) {
        int size = favSearchUI.lHN.size();
        int size2 = favSearchUI.lHO.size();
        int size3 = favSearchUI.lHP.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            return 2;
        }
        if (size == 0 && size2 > 0 && size3 == 0) {
            return 3;
        }
        return (size > 0 && size2 == 0 && size3 == 0) ? 1 : 4;
    }

    protected final int getLayoutId() {
        return R.i.dcA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ae();
        qP("");
        this.icN = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.icN) {
            this.fAR = getIntent().getStringExtra("key_to_user");
            this.lHC = getIntent().getStringExtra("key_fav_item_id");
        }
        this.lHI = (ListView) findViewById(R.h.cHf);
        this.kae = (ListView) findViewById(R.h.cBa);
        this.lHJ = findViewById(R.h.cAI);
        this.lHL = AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aRk);
        this.lHM = AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aRl);
        aug();
        this.lHH = (FavTypePanel) View.inflate(this.uSU.uTo, R.i.dcG, null);
        this.lHH.lKl = new FavTypePanel.a(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final void G(int i, boolean z) {
                if (z) {
                    FavSearchActionView a = this.lHV.lHG;
                    a.lJe.add(Integer.valueOf(i));
                    if (a.lIo != null) {
                        a.aux();
                        FavTagPanel favTagPanel = a.lIo;
                        String w = x.w(a.getContext(), i);
                        if (bg.mA(w)) {
                            w.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
                        } else {
                            String trim = w.trim();
                            Iterator it = favTagPanel.lKb.iterator();
                            while (it.hasNext()) {
                                if (trim.equals(((d) it.next()).vna)) {
                                    w.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[]{trim});
                                    break;
                                }
                            }
                            d bSz = favTagPanel.bSz();
                            favTagPanel.lKb.add(bSz);
                            favTagPanel.a(bSz, trim, true);
                            bSz.vnb.setOnClickListener(favTagPanel.lKd);
                            favTagPanel.addView(bSz.vnb, favTagPanel.lKb.size() - 1);
                            favTagPanel.bSA();
                        }
                        if (a.lJW != null) {
                            a.wm(a.lIo.bSt());
                            a.lJW.a(a.lJe, a.lJV, a.lJU, false);
                            com.tencent.mm.plugin.report.service.g.oUh.i(11126, new Object[]{Integer.valueOf(1)});
                            return;
                        }
                        return;
                    }
                    return;
                }
                FavSearchActionView a2 = this.lHV.lHG;
                a2.lJe.remove(Integer.valueOf(i));
                if (a2.lIo != null) {
                    a2.aux();
                    a2.lIo.wp(x.w(a2.getContext(), i));
                    if (a2.lJW != null) {
                        a2.wm(a2.lIo.bSt());
                        a2.lJW.a(a2.lJe, a2.lJV, a2.lJU, true);
                    }
                }
            }
        };
        this.lHK = (FavCapacityPanel) View.inflate(this.uSU.uTo, R.i.dch, null);
        this.lHK.lJx = getIntent().getIntExtra("key_enter_fav_search_from", 0);
        this.lHF = new c(this, this.uSU.uTo) {
            final /* synthetic */ FavSearchUI lHV;

            protected final void wi(String str) {
                FavSearchActionView a = this.lHV.lHG;
                a.lJU.add(str);
                if (a.lIo != null) {
                    a.lIo.Tb("");
                    a.lIo.aT(str, true);
                    if (a.lJW != null) {
                        a.wm(a.lIo.bSt());
                        a.lJW.a(a.lJe, a.lJV, a.lJU, false);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11126, new Object[]{Integer.valueOf(2)});
                    }
                }
            }

            protected final void wj(String str) {
                FavSearchActionView a = this.lHV.lHG;
                a.lJU.remove(str);
                if (a.lIo != null) {
                    if (a.lJU.isEmpty()) {
                        a.lIo.Tb(a.getResources().getString(R.l.dIz));
                    }
                    a.lIo.removeTag(str);
                    if (a.lJW != null) {
                        a.wm(a.lIo.bSt());
                        a.lJW.a(a.lJe, a.lJV, a.lJU, true);
                    }
                }
            }
        };
        this.lHI.addHeaderView(this.lHH);
        if (h.asT().atr() > 0) {
            this.lHI.addHeaderView((TextView) View.inflate(this.uSU.uTo, R.i.dcD, null));
        }
        this.lHI.addFooterView(this.lHK);
        this.lHI.setAdapter(this.lHF);
        this.lHI.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.lHV.aHf();
                        break;
                }
                return false;
            }
        });
        this.lGT = new g(this.uSU.uTo, 16);
        this.lGU = new b(this.lGT, false);
        if (1 == this.icN) {
            this.lHD = new HashSet();
            this.lHE = new q();
            if (!bg.mA(this.lHC)) {
                for (String str : this.lHC.split(",")) {
                    int i = bg.getInt(str, Integer.MAX_VALUE);
                    if (Integer.MAX_VALUE != i) {
                        this.lHD.add(Integer.valueOf(i));
                    }
                }
            }
            this.lGU.f(this.lHD);
            this.lGU.a(this.lHE);
        }
        this.kae.setAdapter(this.lGU);
        this.kae.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.tencent.mm.plugin.favorite.ui.c.a.b bVar = (com.tencent.mm.plugin.favorite.ui.c.a.b) view.getTag();
                if (1 == this.lHV.icN) {
                    if (bVar == null) {
                        w.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                    } else if (bVar.lFt == null) {
                        w.w("MicroMsg.FavSearchUI", "on item click, info is null");
                    } else {
                        com.tencent.mm.pluginsdk.ui.applet.d.a aVar = new com.tencent.mm.pluginsdk.ui.applet.d.a(this.lHV.uSU.uTo);
                        aVar.bs(this.lHV.fAR);
                        e.a(aVar, this.lHV.uSU.uTo, bVar.lFt);
                        e.b(aVar, this.lHV.uSU.uTo, bVar.lFt);
                        aVar.c(Boolean.valueOf(true)).xp(R.l.dIA).a(new k.a(this) {
                            final /* synthetic */ AnonymousClass3 lHX;

                            public final void a(boolean z, String str, int i) {
                                this.lHX.lHV.aHf();
                                if (z) {
                                    final Dialog a = com.tencent.mm.ui.base.g.a(this.lHX.lHV.uSU.uTo, this.lHX.lHV.getString(R.l.eit), false, null);
                                    r.a(this.lHX.lHV.uSU.uTo, this.lHX.lHV.fAR, str, bVar.lFt, new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 lHY;

                                        public final void run() {
                                            if (a != null) {
                                                a.dismiss();
                                            }
                                            com.tencent.mm.ui.snackbar.a.e(this.lHY.lHX.lHV, this.lHY.lHX.lHV.getString(R.l.ekV));
                                            af.f(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 lHZ;

                                                {
                                                    this.lHZ = r1;
                                                }

                                                public final void run() {
                                                    this.lHZ.lHY.lHX.lHV.finish();
                                                }
                                            }, 1800);
                                        }
                                    });
                                }
                            }
                        }).oHT.show();
                    }
                } else if (2 != this.lHV.icN) {
                    this.lHV.lGU.onItemClick(adapterView, view, i, j);
                    if (bVar.lFt != null) {
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 lHX;

                            public final void run() {
                                int i;
                                w.d("MicroMsg.FavSearchUI", "type %s", new Object[]{Integer.valueOf(bVar.lFt.field_type)});
                                long j = bVar.lFt.field_localId;
                                if (this.lHX.lHV.lHU.size() == 0) {
                                    this.lHX.lHV.lHU = h.ata().atq();
                                }
                                if (this.lHX.lHV.lHU.size() != 0) {
                                    Iterator it = this.lHX.lHV.lHU.iterator();
                                    i = 1;
                                    while (it.hasNext() && ((Long) it.next()).longValue() != j) {
                                        i++;
                                    }
                                } else {
                                    i = 1;
                                }
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(bVar.lFt.field_type);
                                objArr[1] = Integer.valueOf(FavSearchUI.j(this.lHX.lHV));
                                if (this.lHX.lHV.lHU.size() == 0) {
                                    i = i;
                                }
                                objArr[2] = Integer.valueOf(i);
                                gVar.i(12746, objArr);
                            }
                        });
                    }
                } else if (bVar == null) {
                    w.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                } else if (bVar.lFt == null) {
                    w.w("MicroMsg.FavSearchUI", "on item click, info is null");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_result_local_id", bVar.lFt.field_localId);
                    this.lHV.setResult(-1, intent);
                    this.lHV.finish();
                }
            }
        });
        this.kae.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.lHV.aHf();
                        break;
                }
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lHV.finish();
                return true;
            }
        });
        h.asT().a(this.lHF);
        ap.vL().e(new Runnable(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final void run() {
                this.lHV.lHU = h.ata().atq();
            }
        }, 1000);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.lGT.destory();
        this.lGT = null;
        h.asT().a(this.lHF);
        h.asT().d(this.lHQ);
        if (this.lGU != null) {
            this.lGU.finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        w.d("MicroMsg.FavSearchUI", "on create options menu");
        aug();
        this.lHT = menu.add(0, R.h.cjK, 0, R.l.dGO);
        m.a(this.lHT, this.lHG);
        m.a(this.lHT, 9);
        this.lHG.post(new Runnable(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final void run() {
                FavSearchActionView a = this.lHV.lHG;
                if (a.lIo != null) {
                    a.lIo.bSw();
                }
                this.lHV.aHj();
            }
        });
        m.a(this.lHT, new m.e(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                this.lHV.finish();
                return true;
            }
        });
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ FavSearchUI lHV;

            {
                this.lHV = r1;
            }

            public final void run() {
                if (this.lHV.lHT != null) {
                    m.b(this.lHV.lHT);
                    LayoutParams layoutParams = (LayoutParams) this.lHV.lHG.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                        layoutParams.width = -1;
                    }
                    this.lHV.lHG.setLayoutParams(layoutParams);
                }
            }
        });
        return true;
    }

    private void aug() {
        if (this.lHG == null) {
            this.lHG = (FavSearchActionView) View.inflate(this.uSU.uTo, R.i.dcz, null);
            this.lHR = this.lHG.findViewById(R.h.bmv);
            this.lHR.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavSearchUI lHV;

                {
                    this.lHV = r1;
                }

                public final void onClick(View view) {
                    this.lHV.finish();
                }
            });
            this.lHS = (ImageButton) this.lHG.findViewById(R.h.cAw);
            this.lHS.setVisibility(8);
            this.lHG.lJW = new FavSearchActionView.a(this) {
                final /* synthetic */ FavSearchUI lHV;

                {
                    this.lHV = r1;
                }

                public final void OE() {
                    w.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
                    FavSearchUI.c(this.lHV);
                }

                public final void a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
                    w.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[]{list, list2, list3});
                    this.lHV.lHO = list2;
                    this.lHV.lHP = list3;
                    this.lHV.lHN = list;
                    this.lHV.lHF.aw(list3);
                    this.lHV.lHH.ay(list);
                    if (z) {
                        FavSearchUI.c(this.lHV);
                        FavSearchUI.a(this.lHV, list, list2, list3);
                        return;
                    }
                    this.lHV.lGU.b(list, list2, list3);
                    FavSearchUI.a(this.lHV, true);
                    FavSearchUI.a(this.lHV, list, list2, list3);
                }

                public final void a(final List<Integer> list, final List<String> list2, final List<String> list3) {
                    this.lHV.lHG.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass10 lId;

                        public final void run() {
                            FavSearchUI.a(this.lId.lHV, list, list2, list3);
                            w.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[]{list, list2, list3});
                            this.lId.lHV.lHO = list2;
                            this.lId.lHV.lHP = list3;
                            this.lId.lHV.lHN = list;
                            this.lId.lHV.lHF.aw(list3);
                            this.lId.lHV.lHH.ay(list);
                            this.lId.lHV.lGU.b(list, list2, list3);
                            FavSearchUI.a(this.lId.lHV, false);
                        }
                    });
                }
            };
        }
    }

    protected void onResume() {
        long j = 0;
        this.lGU.aur();
        this.lGU.notifyDataSetChanged();
        FavCapacityPanel favCapacityPanel = this.lHK;
        if (favCapacityPanel.lJv != x.atE() / 1048576) {
            favCapacityPanel.lJv = x.atE() / 1048576;
            TextView textView = favCapacityPanel.lJw;
            Context context = favCapacityPanel.lJw.getContext();
            int i = R.l.ehr;
            Object[] objArr = new Object[2];
            if (favCapacityPanel.lJy - favCapacityPanel.lJv > 0) {
                j = favCapacityPanel.lJy - favCapacityPanel.lJv;
            }
            objArr[0] = Long.valueOf(j);
            objArr[1] = Long.valueOf(favCapacityPanel.lJv);
            textView.setText(context.getString(i, objArr));
        }
        super.onResume();
    }
}
