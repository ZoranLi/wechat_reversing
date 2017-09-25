package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.plugin.luckymoney.b.y;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    private TextView kBo;
    private ImageView kDl;
    private boolean kOH = false;
    private int mType;
    public String nnJ = "";
    private MMLoadMoreListView nrT;
    private d nrU;
    private TextView nrd;
    private boolean nrj = true;
    private List<h> nro = new LinkedList();
    private Map<String, Integer> nrp = new HashMap();
    public String nrr = "";
    private TextView nsJ;
    private TextView nsK;
    private TextView nsL;
    private TextView nsM;
    private TextView nsN;
    private TextView nsO;
    private TextView nsP;
    private View nsQ;
    private String nsR;
    private int nsS = -1;
    public List<String> nsT = new ArrayList();
    private int wa = 0;

    class a extends BaseAdapter {
        int mTy;
        List<String> nsT;
        final /* synthetic */ LuckyMoneyMyRecordUI nsU;

        a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
            this.nsU = luckyMoneyMyRecordUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public final int getCount() {
            return this.nsT.size();
        }

        public final String hO(int i) {
            return (String) this.nsT.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(this.nsU.uSU.uTo).inflate(R.i.dqI, viewGroup, false);
            checkedTextView.setText(hO(i));
            if (i == this.mTy) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ void a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, h hVar, int i) {
        if (hVar == null || i < 0 || i > luckyMoneyMyRecordUI.nrU.getCount()) {
            w.e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            return;
        }
        luckyMoneyMyRecordUI.k(new y(hVar.njw, hVar.nmp, luckyMoneyMyRecordUI.mType, i, "v1.0"));
    }

    static /* synthetic */ void b(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        if (luckyMoneyMyRecordUI.nro != null) {
            luckyMoneyMyRecordUI.nro.clear();
        }
        if (luckyMoneyMyRecordUI.nrp != null) {
            luckyMoneyMyRecordUI.nrp.clear();
        }
        luckyMoneyMyRecordUI.wa = 0;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(R.i.dhz, null);
                ListView listView = (ListView) inflate.findViewById(R.h.cgA);
                final a aVar = new a(this);
                List list = this.nsT;
                if (list == null) {
                    aVar.nsT = new ArrayList();
                } else {
                    aVar.nsT = list;
                }
                aVar.notifyDataSetChanged();
                aVar.mTy = 0;
                listView.setAdapter(aVar);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ LuckyMoneyMyRecordUI nsU;

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.nsU.dismissDialog(1);
                        String hO = aVar.hO(i);
                        aVar.mTy = i;
                        if (!hO.equals(this.nsU.nsR)) {
                            this.nsU.nsR = hO;
                            this.nsU.nsO.setText(this.nsU.getString(R.l.eyh, new Object[]{this.nsU.nsR}));
                            this.nsU.wa = 0;
                            this.nsU.nro.clear();
                            this.nsU.nrp.clear();
                            this.nsU.aIt();
                        }
                        g.oUh.i(11701, new Object[]{Integer.valueOf(this.nsU.aID()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), hO});
                    }
                });
                com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(this);
                aVar2.zW(R.l.eym);
                aVar2.dd(inflate);
                aVar2.d(null);
                return aVar2.WJ();
            default:
                return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 2);
        KC();
        aIt();
        g.oUh.i(11701, new Object[]{Integer.valueOf(aID()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI nsU;

            {
                this.nsU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nsU.finish();
                return true;
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI nsU;

            {
                this.nsU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e eVar = new e(this.nsU.uSU.uTo, e.wuP, false);
                eVar.qJf = new c(this) {
                    final /* synthetic */ AnonymousClass2 nsV;

                    {
                        this.nsV = r1;
                    }

                    public final void a(l lVar) {
                        lVar.dX(1, R.l.exR);
                        lVar.dX(2, R.l.exS);
                    }
                };
                eVar.qJg = new d(this) {
                    final /* synthetic */ AnonymousClass2 nsV;

                    {
                        this.nsV = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                if (this.nsV.nsU.mType != 2) {
                                    this.nsV.nsU.mType = 2;
                                    LuckyMoneyMyRecordUI.b(this.nsV.nsU);
                                    this.nsV.nsU.aIC();
                                    this.nsV.nsU.aIt();
                                    return;
                                }
                                return;
                            case 2:
                                if (this.nsV.nsU.mType != 1) {
                                    this.nsV.nsU.mType = 1;
                                    LuckyMoneyMyRecordUI.b(this.nsV.nsU);
                                    this.nsV.nsU.aIC();
                                    this.nsV.nsU.aIt();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                eVar.bzh();
                return false;
            }
        });
        this.kBo = (TextView) findViewById(R.h.ceY);
        this.nrT = (MMLoadMoreListView) findViewById(R.h.cfa);
        this.nsQ = LayoutInflater.from(this).inflate(R.i.dhm, null);
        this.nrT.addHeaderView(this.nsQ);
        this.kDl = (ImageView) this.nsQ.findViewById(R.h.ceM);
        this.nsJ = (TextView) this.nsQ.findViewById(R.h.ceP);
        this.nrd = (TextView) this.nsQ.findViewById(R.h.ceL);
        this.nsK = (TextView) this.nsQ.findViewById(R.h.ceQ);
        this.nsL = (TextView) this.nsQ.findViewById(R.h.ceR);
        this.nsM = (TextView) this.nsQ.findViewById(R.h.ceN);
        this.nsN = (TextView) this.nsQ.findViewById(R.h.ceO);
        this.nsO = (TextView) this.nsQ.findViewById(R.h.ceU);
        this.nsP = (TextView) this.nsQ.findViewById(R.h.ceT);
        this.nrT.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI nsU;

            {
                this.nsU = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 3;
                int i3 = (int) j;
                g.oUh.i(11701, new Object[]{Integer.valueOf(this.nsU.aID()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                if (i3 >= 0 && i3 < this.nsU.nrU.getCount()) {
                    h oZ = this.nsU.nrU.oZ(i3);
                    if (oZ != null && !bg.mA(oZ.njw)) {
                        Intent intent = new Intent();
                        if (oZ.nmA == 2) {
                            w.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                            intent.setClass(this.nsU.uSU.uTo, LuckyMoneyBusiDetailUI.class);
                        } else {
                            w.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
                            intent.setClass(this.nsU.uSU.uTo, LuckyMoneyDetailUI.class);
                        }
                        intent.putExtra("key_sendid", oZ.njw);
                        if (this.nsU.mType != 1) {
                            i2 = 1;
                        }
                        intent.putExtra("key_jump_from", i2);
                        this.nsU.startActivity(intent);
                    }
                }
            }
        });
        this.nrT.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI nsU;

            {
                this.nsU = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i > 0 && i <= this.nsU.nrU.getCount()) {
                    final int i2 = i - 1;
                    com.tencent.mm.ui.base.g.a(this.nsU, this.nsU.getResources().getString(R.l.exM), null, this.nsU.getResources().getString(R.l.dGB), new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass4 nsX;

                        public final void hq(int i) {
                            switch (i) {
                                case 0:
                                    h oZ = this.nsX.nsU.nrU.oZ(i2);
                                    if (oZ != null) {
                                        this.nsX.nsU.nsS = i2;
                                        LuckyMoneyMyRecordUI.a(this.nsX.nsU, oZ, i2);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                return true;
            }
        });
        this.nrT.vkV = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI nsU;

            {
                this.nsU = r1;
            }

            public final void ajC() {
                if (!this.nsU.nqY.aHU()) {
                    this.nsU.kOH = false;
                }
                if (this.nsU.nrj && !this.nsU.kOH) {
                    this.nsU.aIt();
                }
            }
        };
        this.kDl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI nsU;

            {
                this.nsU = r1;
            }

            public final void onClick(View view) {
                if (bg.mA(this.nsU.nnJ)) {
                    w.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
                } else {
                    com.tencent.mm.wallet_core.ui.e.m(this.nsU, this.nsU.nnJ, true);
                }
            }
        });
        aIC();
    }

    private void aIC() {
        this.nsP.setVisibility(8);
        this.nsQ.findViewById(R.h.ceS).setVisibility(8);
        if (this.mType == 1) {
            qP(getString(R.l.exS));
            n.a(this.uSU.uTo, this.nsJ, getString(R.l.eyn, new Object[]{m.xN()}));
            this.nsL.setText(R.l.eyr);
            this.nrU = new e(this.uSU.uTo);
            this.nsP.setVisibility(0);
        } else {
            qP(getString(R.l.exR));
            n.a(this.uSU.uTo, this.nsJ, getString(R.l.eyf, new Object[]{m.xN()}));
            this.nsL.setText(R.l.eyg);
            this.nrU = new c(this.uSU.uTo);
            this.nsQ.findViewById(R.h.ceS).setVisibility(0);
        }
        this.nrT.setAdapter(this.nrU);
        b.a(this.kDl, m.xL(), 0.0f, false);
        this.nsO.setText(getString(R.l.eyh, new Object[]{bg.mz(this.nsR)}));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        h hVar;
        if (kVar instanceof x) {
            if (i == 0 && i2 == 0) {
                x xVar = (x) kVar;
                List list = xVar.nnG.nmB;
                this.nrr = xVar.nnw;
                this.nnJ = xVar.nnJ;
                if (this.wa == 0) {
                    this.nsT = xVar.nnH;
                    this.nsR = xVar.nnI;
                    View findViewById = findViewById(R.h.ceW);
                    ImageView imageView = (ImageView) findViewById(R.h.ceV);
                    if (this.nsT.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyMyRecordUI nsU;

                            {
                                this.nsU = r1;
                            }

                            public final void onClick(View view) {
                                this.nsU.showDialog(1);
                            }
                        });
                    }
                    this.nsO.setText(getString(R.l.eyh, new Object[]{this.nsR}));
                }
                com.tencent.mm.plugin.luckymoney.b.g gVar = xVar.nnG;
                if (gVar != null) {
                    if (this.mType == 1) {
                        this.nrd.setText(com.tencent.mm.wallet_core.ui.e.n(((double) gVar.nmI) / 100.0d));
                        String str2 = gVar.nmH;
                        CharSequence string = getString(R.l.eyq, new Object[]{str2});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.e.aUK));
                        int indexOf = string.indexOf(str2);
                        CharSequence spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
                        this.nsP.setText(spannableString);
                    } else {
                        this.nrd.setText(com.tencent.mm.wallet_core.ui.e.n(((double) gVar.nmG) / 100.0d));
                        this.nsK.setText(gVar.nmF);
                        this.nsM.setText(gVar.hPS);
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        hVar = (h) list.get(i3);
                        if (!this.nrp.containsKey(hVar.njw)) {
                            this.nro.add(list.get(i3));
                            this.nrp.put(hVar.njw, Integer.valueOf(1));
                        }
                    }
                    this.wa += list.size();
                    this.nrj = xVar.aHZ();
                    this.kOH = false;
                    this.nrU.aP(this.nro);
                }
                if (this.nro == null || this.nro.size() == 0) {
                    this.kBo.setVisibility(0);
                } else {
                    this.kBo.setVisibility(8);
                }
                if (this.nrj) {
                    this.nrT.bSh();
                } else {
                    this.nrT.bSi();
                }
                return true;
            }
            this.nnJ = null;
            return false;
        } else if (!(kVar instanceof y)) {
            return false;
        } else {
            int i4 = this.nsS;
            this.nsS = -1;
            if (i != 0 || i2 != 0) {
                return false;
            }
            hVar = this.nrU.oZ(i4);
            if (hVar != null) {
                Toast.makeText(this, R.l.exN, 0).show();
                this.nrU.a(hVar);
                this.nrU.notifyDataSetChanged();
            } else {
                w.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return R.i.dho;
    }

    private void aIt() {
        this.kOH = true;
        if (this.wa == 0) {
            this.nrr = "";
        }
        k(new x(11, this.wa, this.mType, this.nsR, "v1.0", this.nrr));
    }

    private int aID() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }
}
