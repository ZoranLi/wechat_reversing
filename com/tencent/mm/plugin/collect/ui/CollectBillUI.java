package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.collect.b.a;
import com.tencent.mm.plugin.collect.b.h;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.collect.b.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.ci;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public class CollectBillUI extends WalletBaseUI {
    private int aIo = 20;
    private int fromScene;
    private boolean hoD = false;
    private l iYI;
    private String iol;
    private long kAw;
    private a kBG;
    private LinearLayout kBH;
    private CollectBillHeaderView kBI;
    private ImageView kBJ;
    private MMSwitchBtn kBK;
    private ImageView kBL;
    private MMSwitchBtn kBM;
    private TextView kBN;
    private boolean kBO = false;
    private boolean kBP = true;
    private long kBQ;
    private e kBR = new e(this) {
        final /* synthetic */ CollectBillUI kBT;

        {
            this.kBT = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof h) {
                h hVar = (h) kVar;
                if (i == 0 && i2 == 0) {
                    List<ci> list = hVar.kAA.tpo;
                    if (list == null || list.isEmpty()) {
                        this.kBT.kBN.setVisibility(8);
                        return;
                    }
                    for (final ci ciVar : list) {
                        if (ciVar.type == 1 && !bg.mA(ciVar.fNG)) {
                            w.i("MicroMsg.CollectBillUI", "show notice");
                            this.kBT.kBN.setText(ciVar.fNG);
                            this.kBT.kBN.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass1 kBV;

                                public final void onClick(View view) {
                                    if (!bg.mA(ciVar.url)) {
                                        com.tencent.mm.wallet_core.ui.e.m(this.kBV.kBT.uSU.uTo, ciVar.url, true);
                                    }
                                }
                            });
                            this.kBT.kBN.setVisibility(0);
                            return;
                        }
                    }
                    this.kBT.kBN.setVisibility(8);
                    return;
                }
                w.e("MicroMsg.CollectBillUI", "net error: %s", new Object[]{hVar});
                this.kBT.kBN.setVisibility(8);
            }
        }
    };
    private d kBS = new d(this) {
        final /* synthetic */ CollectBillUI kBT;

        {
            this.kBT = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            if (menuItem.getItemId() == 0) {
                a aVar = (a) this.kBT.kBk.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
                if (aVar != null) {
                    CollectBillUI.a(this.kBT, aVar.kAi, aVar.timestamp);
                }
            }
        }
    };
    private ListView kBk;
    private boolean kBs = false;
    private View koo;
    private int type;

    static /* synthetic */ void a(CollectBillUI collectBillUI, String str, long j) {
        w.i("MicroMsg.CollectBillUI", "do delete, billid: %s, timestamp: %s", new Object[]{str, Long.valueOf(j)});
        k mVar = new m(str, collectBillUI.type, j);
        collectBillUI.kBP = true;
        collectBillUI.q(mVar);
    }

    static /* synthetic */ void f(CollectBillUI collectBillUI) {
        if (!collectBillUI.kBO) {
            w.d("MicroMsg.CollectBillUI", "show loading");
            collectBillUI.kBk.addFooterView(collectBillUI.koo, null, false);
            collectBillUI.kBO = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kBQ = com.tencent.mm.u.m.xQ();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        this.type = getIntent().getIntExtra("key_type", 0);
        this.kAw = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000);
        akl();
        KC();
        zi(R.l.dWy);
        ap.vd().a(1256, this.kBR);
        ap.vd().a(new h(), 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ap.vd().b(1256, this.kBR);
    }

    protected final void KC() {
        this.kBk = (ListView) findViewById(R.h.bDw);
        this.kBH = (LinearLayout) findViewById(R.h.bDi);
        this.kBN = (TextView) findViewById(R.h.bDf);
        this.koo = r.eC(this).inflate(R.i.cZd, this.kBk, false);
        this.kBI = new CollectBillHeaderView(this);
        this.kBk.addHeaderView(this.kBI, null, false);
        this.kBG = new a(this);
        this.kBk.setAdapter(this.kBG);
        this.kBk.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CollectBillUI kBT;

            {
                this.kBT = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (this.kBT.kBk.getLastVisiblePosition() == this.kBT.kBG.getCount() && this.kBT.kBG.getCount() > 0 && !this.kBT.hoD && !this.kBT.kBs) {
                    CollectBillUI.f(this.kBT);
                    this.kBT.akl();
                }
            }
        });
        this.iYI = new l(this);
        this.kBk.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CollectBillUI kBT;

            {
                this.kBT = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                    w.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount())});
                    return;
                }
                a aVar = (a) this.kBT.kBk.getItemAtPosition(i);
                if (aVar == null) {
                    w.w("MicroMsg.CollectBillUI", "invalid position: %d", new Object[]{Integer.valueOf(i)});
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("scene", 2);
                intent.putExtra("trans_id", aVar.kAj);
                intent.putExtra("bill_id", aVar.kAi);
                com.tencent.mm.bb.d.b(this.kBT.uSU.uTo, "order", ".ui.MallOrderTransactionInfoUI", intent);
            }
        });
        this.kBk.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CollectBillUI kBT;

            {
                this.kBT = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                    w.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount())});
                    return false;
                }
                this.kBT.iYI.a(view, i, j, this.kBT, this.kBT.kBS);
                return true;
            }
        });
        if (this.fromScene != 2) {
            a(0, getString(R.l.dWw), new OnMenuItemClickListener(this) {
                final /* synthetic */ CollectBillUI kBT;

                {
                    this.kBT = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.kBT.startActivity(new Intent(this.kBT.uSU.uTo, CollectBillListUI.class));
                    return false;
                }
            });
        }
        if (this.fromScene == 2) {
            View findViewById = this.kBI.findViewById(R.h.bEi);
            View findViewById2 = this.kBH.findViewById(R.h.bEh);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        this.kBJ = (ImageView) this.kBI.findViewById(R.h.bEf);
        this.kBK = (MMSwitchBtn) this.kBI.findViewById(R.h.bEg);
        this.kBL = (ImageView) this.kBH.findViewById(R.h.bEf);
        this.kBM = (MMSwitchBtn) this.kBH.findViewById(R.h.bEg);
        com.tencent.mm.plugin.collect.a.a.ajY();
        if (com.tencent.mm.plugin.collect.a.a.aka()) {
            this.kBK.lS(true);
            this.kBM.lS(true);
            this.kBJ.setImageResource(R.k.dvU);
            this.kBL.setImageResource(R.k.dvU);
        } else {
            this.kBK.lS(false);
            this.kBM.lS(false);
            this.kBJ.setImageResource(R.k.dvT);
            this.kBL.setImageResource(R.k.dvT);
        }
        MMSwitchBtn.a anonymousClass6 = new MMSwitchBtn.a(this) {
            final /* synthetic */ CollectBillUI kBT;

            {
                this.kBT = r1;
            }

            public final void bK(boolean z) {
                int i;
                w.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[]{Boolean.valueOf(z)});
                this.kBT.kBK.lS(z);
                this.kBT.kBM.lS(z);
                if (z) {
                    this.kBT.kBQ = this.kBT.kBQ | 32768;
                    this.kBT.kBJ.setImageResource(R.k.dvU);
                    this.kBT.kBL.setImageResource(R.k.dvU);
                    Toast.makeText(this.kBT.uSU.uTo, R.l.dWP, 1).show();
                    g.oUh.i(13944, new Object[]{Integer.valueOf(11)});
                    i = 1;
                } else {
                    this.kBT.kBQ = this.kBT.kBQ & -32769;
                    i = 2;
                    this.kBT.kBJ.setImageResource(R.k.dvT);
                    this.kBT.kBL.setImageResource(R.k.dvT);
                    Toast.makeText(this.kBT.uSU.uTo, R.l.dWI, 1).show();
                    g.oUh.i(13944, new Object[]{Integer.valueOf(12)});
                }
                ap.yY();
                c.vr().set(147457, Long.valueOf(this.kBT.kBQ));
                com.tencent.mm.bd.a com_tencent_mm_protocal_c_amp = new amp();
                com_tencent_mm_protocal_c_amp.oTE = i;
                ap.yY();
                c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(ag.CTRL_INDEX, com_tencent_mm_protocal_c_amp));
                if (i == 1) {
                    com.tencent.mm.plugin.collect.a.a.ajY().akb();
                } else {
                    com.tencent.mm.plugin.collect.a.a.ajY().akc();
                }
            }
        };
        this.kBK.wwD = anonymousClass6;
        this.kBM.wwD = anonymousClass6;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, R.l.dWx);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            o oVar = (o) kVar;
            if (this.kBO) {
                this.kBk.removeFooterView(this.koo);
                this.kBO = false;
            }
            if (i == 0 && i2 == 0) {
                this.hoD = oVar.hoD;
                this.type = oVar.type;
                this.kAw = oVar.kAw;
                c(oVar.kAx, oVar.kAy, oVar.kAw);
                if (oVar.kBa.isEmpty()) {
                    this.hoD = true;
                    if (bg.mA(this.iol)) {
                        w.i("MicroMsg.CollectBillUI", "no record, show empty view");
                        akk();
                    }
                } else {
                    if (bg.mA(this.iol)) {
                        w.d("MicroMsg.CollectBillUI", "first query, hide block view");
                        this.kBk.setVisibility(0);
                        this.kBH.setVisibility(8);
                    }
                    a aVar = this.kBG;
                    aVar.kBf.addAll(oVar.kBa);
                    aVar.notifyDataSetChanged();
                    this.iol = ((a) oVar.kBa.get(oVar.kBa.size() - 1)).kAi;
                }
                this.kBs = false;
                return true;
            }
            w.i("MicroMsg.CollectBillUI", "net error!");
            this.kBs = false;
            Toast.makeText(this, R.l.dWt, 1).show();
            if (bg.mA(this.iol)) {
                w.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
            }
            return true;
        } else if (!(kVar instanceof m)) {
            return false;
        } else {
            m mVar = (m) kVar;
            if (i == 0 && i2 == 0) {
                a aVar2 = this.kBG;
                String str2 = mVar.kAi;
                for (a aVar3 : aVar2.kBf) {
                    if (aVar3.kAi.equals(str2)) {
                        aVar2.kBf.remove(aVar3);
                        aVar2.notifyDataSetChanged();
                        break;
                    }
                }
                if (this.kBG.getCount() <= 0) {
                    w.i("MicroMsg.CollectBillUI", "delete all records");
                    akk();
                } else {
                    c(mVar.kAx, mVar.kAy, this.kAw);
                }
                return false;
            }
            w.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, mVar.kAi});
            Toast.makeText(this, R.l.dWs, 1).show();
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.cYW;
    }

    private void c(int i, int i2, long j) {
        if (this.kBP) {
            CollectBillHeaderView collectBillHeaderView = this.kBI;
            collectBillHeaderView.kBg.setText(com.tencent.mm.plugin.collect.b.c.a(collectBillHeaderView.getContext(), j, this.type));
            collectBillHeaderView.kBh.setText(com.tencent.mm.plugin.collect.b.c.kV(i2));
            collectBillHeaderView.kBi.setText(collectBillHeaderView.getContext().getString(R.l.dWz, new Object[]{Integer.valueOf(i)}));
            this.kBP = false;
        }
    }

    private void akl() {
        if (!this.hoD) {
            q(new o(this.type, this.kAw, this.iol, this.aIo));
            this.kBs = true;
        }
    }

    private void akk() {
        this.kBk.setVisibility(8);
        this.kBH.setVisibility(0);
        findViewById(R.h.bDj).setVisibility(0);
    }
}
