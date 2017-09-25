package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String fET;
    private ae hgN = new ae(Looper.getMainLooper());
    private com.tencent.mm.plugin.aa.a.c.c iqa = ((com.tencent.mm.plugin.aa.a.c.c) p(com.tencent.mm.plugin.aa.a.c.c.class));
    private ListView iqb;
    private TextView iqc;
    private TextView iqd;
    private View iqe;
    private TextView iqf;
    private boolean iqg = false;
    private Map<String, String> iqh = new HashMap();
    private a iqi = null;
    private double iqj;
    private long iqk = -1;
    private int iql = -1;
    private boolean iqm;
    private boolean iqn = false;
    private Runnable iqo = new Runnable(this) {
        final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

        {
            this.iqp = r1;
        }

        public final void run() {
            this.iqp.On();
            this.iqp.Oo();
        }
    };

    private class a extends BaseAdapter {
        List<b> dataList;
        final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

        private class a {
            ImageView ioV;
            TextView ipW;
            WalletFormView ipX;
            final /* synthetic */ a iqu;
            c iqv;

            public a(a aVar) {
                this.iqu = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return hh(i);
        }

        public a(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, List<String> list, Map<String, Double> map) {
            this.iqp = launchAAByPersonAmountSelectUI;
            this.dataList = null;
            this.dataList = new ArrayList();
            for (String str : list) {
                b bVar = new b(launchAAByPersonAmountSelectUI);
                bVar.username = str;
                if (map == null || !map.containsKey(str)) {
                    bVar.iqw = "";
                } else {
                    bVar.iqw = launchAAByPersonAmountSelectUI.getString(R.l.dAP, new Object[]{map.get(str)});
                }
                this.dataList.add(bVar);
            }
        }

        public final int getCount() {
            return this.dataList.size();
        }

        private b hh(int i) {
            return (b) this.dataList.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b hh = hh(i);
            if (!(hh == null || bg.mA(hh.username))) {
                if (view == null) {
                    view = r.eC(this.iqp).inflate(R.i.dgB, viewGroup, false);
                    final a aVar = new a(this);
                    aVar.ioV = (ImageView) view.findViewById(R.h.bqG);
                    aVar.ipW = (TextView) view.findViewById(R.h.cLl);
                    aVar.ipX = (WalletFormView) view.findViewById(R.h.ckZ);
                    aVar.iqv = new c(this.iqp, hh.username);
                    aVar.ipX.a(aVar.iqv);
                    aVar.ioV.setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ a iqu;

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            aVar.ipX.requestFocus();
                            return false;
                        }
                    });
                    aVar.ipW.setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ a iqu;

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            aVar.ipX.requestFocus();
                            return false;
                        }
                    });
                    view.setTag(aVar);
                    this.iqp.a(aVar.ipX, 2, false, true);
                }
                a aVar2 = (a) view.getTag();
                if (!bg.mA(hh.username)) {
                    aVar2.iqv.username = hh.username;
                    com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.ioV, hh.username);
                    aVar2.ipW.setText(h.b(this.iqp.uSU.uTo, n.E(hh.username, this.iqp.fET), aVar2.ipW.getTextSize()));
                }
                if (!(hh.iqw == null || aVar2.ipX.getText() == null || hh.iqw.equals(aVar2.ipX.getText().toLowerCase()))) {
                    WalletFormView walletFormView = aVar2.ipX;
                    TextWatcher textWatcher = aVar2.iqv;
                    if (walletFormView.wFX != null) {
                        walletFormView.wFX.removeTextChangedListener(textWatcher);
                    }
                    aVar2.ipX.setText(hh.iqw);
                    aVar2.ipX.a(aVar2.iqv);
                }
            }
            return view;
        }
    }

    private class b {
        final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;
        String iqw = null;
        String username = null;

        public b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
            this.iqp = launchAAByPersonAmountSelectUI;
        }
    }

    protected class c implements TextWatcher {
        final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;
        String username;

        public c(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, String str) {
            this.iqp = launchAAByPersonAmountSelectUI;
            this.username = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            try {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                int lastIndexOf = obj.lastIndexOf(".");
                if (lastIndexOf != indexOf && lastIndexOf > 0 && length > lastIndexOf) {
                    editable.delete(lastIndexOf, length);
                }
            } catch (Exception e) {
            }
            if (bg.J(editable) || bg.getDouble(editable.toString(), 0.0d) <= 0.0d) {
                this.iqp.iqh.remove(this.username);
            } else {
                this.iqp.iqh.put(this.username, editable.toString());
            }
            this.iqp.hgN.removeCallbacks(this.iqp.iqo);
            this.iqp.hgN.postDelayed(this.iqp.iqo, 50);
        }
    }

    static /* synthetic */ void d(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        launchAAByPersonAmountSelectUI.On();
        launchAAByPersonAmountSelectUI.Oo();
        if (!launchAAByPersonAmountSelectUI.iqm) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAByPersonAmountSelectUI.iqh.keySet()) {
                arrayList.add(str + "," + ((String) launchAAByPersonAmountSelectUI.iqh.get(str)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
    }

    static /* synthetic */ void m(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        try {
            launchAAByPersonAmountSelectUI.iqc.setTextColor(launchAAByPersonAmountSelectUI.getResources().getColor(R.e.aSZ));
            launchAAByPersonAmountSelectUI.iqg = false;
            launchAAByPersonAmountSelectUI.iqj = 0.0d;
            launchAAByPersonAmountSelectUI.iqd.setText(launchAAByPersonAmountSelectUI.getString(R.l.evQ, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.iqj)}));
            launchAAByPersonAmountSelectUI.iqh.clear();
            launchAAByPersonAmountSelectUI.On();
            launchAAByPersonAmountSelectUI.Oo();
            if (launchAAByPersonAmountSelectUI.iqi != null) {
                a aVar = launchAAByPersonAmountSelectUI.iqi;
                for (b bVar : aVar.dataList) {
                    bVar.iqw = "";
                }
                aVar.notifyDataSetChanged();
            }
        } catch (Exception e) {
            w.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", new Object[]{e.getMessage()});
        }
        g.oUh.i(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(9)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.evR);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

            {
                this.iqp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.iqp.iqh == null || this.iqp.iqh.size() <= 0) {
                    this.iqp.finish();
                } else {
                    com.tencent.mm.ui.base.g.a(this.iqp, this.iqp.getString(R.l.dBz), null, this.iqp.getString(R.l.dBC), this.iqp.getString(R.l.dBB), false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 iqq;

                        {
                            this.iqq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LaunchAAByPersonAmountSelectUI.d(this.iqq.iqp);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 iqq;

                        {
                            this.iqq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.iqq.iqp.finish();
                        }
                    });
                }
                return true;
            }
        });
        a(233, getString(R.l.dHT), new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

            {
                this.iqp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.iqp.iql <= 0 || this.iqp.iqh == null || this.iqp.iqh.size() <= this.iqp.iql) {
                    LaunchAAByPersonAmountSelectUI.d(this.iqp);
                    g.oUh.i(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(4)});
                } else {
                    com.tencent.mm.ui.base.g.b(this.iqp.uSU.uTo, this.iqp.getString(R.l.evS, new Object[]{Integer.valueOf(this.iqp.iql)}), "", true);
                    g.oUh.i(13722, new Object[]{Integer.valueOf(8)});
                }
                return true;
            }
        }, com.tencent.mm.ui.l.b.uTY);
        this.iqb = (ListView) findViewById(R.h.boC);
        this.iqc = (TextView) findViewById(R.h.bCt);
        this.iqd = (TextView) findViewById(R.h.boD);
        this.iqd.setText(getString(R.l.evQ, new Object[]{Float.valueOf(0.0f)}));
        this.iqe = findViewById(R.h.cGO);
        this.iqf = (TextView) findViewById(R.h.boq);
        this.ipN = this.iqb;
        this.iqe.setVisibility(8);
        this.iqc.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

            {
                this.iqp = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.iqp.iqg) {
                    return true;
                }
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    this.iqp.iqc.setTextColor(this.iqp.getResources().getColor(R.e.aTb));
                } else if (this.iqp.iqg) {
                    this.iqp.iqc.setTextColor(this.iqp.getResources().getColor(R.e.aTa));
                } else {
                    this.iqp.iqc.setTextColor(this.iqp.getResources().getColor(R.e.aSZ));
                }
                return false;
            }
        });
        this.iqc.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

            {
                this.iqp = r1;
            }

            public final void onClick(View view) {
                if (this.iqp.iqh != null && this.iqp.iqh.size() > 0) {
                    try {
                        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.iqp);
                        aVar.zX(R.l.dAQ);
                        aVar.zZ(R.l.dHT).a(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass6 iqs;

                            {
                                this.iqs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                LaunchAAByPersonAmountSelectUI.m(this.iqs.iqp);
                            }
                        });
                        aVar.Aa(R.l.dGs).b(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass6 iqs;

                            {
                                this.iqs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.oUh.i(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(10)});
                            }
                        });
                        aVar.WJ().show();
                    } catch (Exception e) {
                        w.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
                    }
                }
                g.oUh.i(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
            }
        });
        this.iqg = true;
        this.iqb.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

            {
                this.iqp = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 1) {
                    this.iqp.Om();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fET = getIntent().getStringExtra("chatroom");
        this.iqk = getIntent().getLongExtra("maxPerAmount", -1);
        this.iql = getIntent().getIntExtra("maxUserNumber", -1);
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("oldAmountData");
        w.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", new Object[]{this.fET, Long.valueOf(this.iqk), stringArrayListExtra});
        this.iqh = new HashMap();
        final HashMap hashMap = new HashMap();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = ((String) it.next()).split(",");
                        if (split != null && split.length == 2) {
                            hashMap.put(split[0], Double.valueOf(bg.getDouble(split[1], 0.0d)));
                            this.iqh.put(split[0], getString(R.l.dAP, new Object[]{Double.valueOf(r4)}));
                        }
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", new Object[]{e.getMessage()});
            }
        }
        this.iqa.z(com.tencent.mm.plugin.aa.a.c.c.a.class);
        this.iqa.a(com.tencent.mm.plugin.aa.a.c.c.a.class, new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.aa.a.c.c.a>(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI iqp;

            public final /* synthetic */ void aE(Object obj) {
                com.tencent.mm.plugin.aa.a.c.c.a aVar = (com.tencent.mm.plugin.aa.a.c.c.a) obj;
                String str = "MicroMsg.LaunchAAByPersonAmountSelectUI";
                String str2 = "get selectMembers: %s, list.size: %s";
                Object[] objArr = new Object[2];
                objArr[0] = aVar;
                objArr[1] = aVar != null ? Integer.valueOf(aVar.iox.size()) : "0";
                w.i(str, str2, objArr);
                this.iqp.iqb.addFooterView(r.eC(this.iqp).inflate(R.i.cTt, null));
                this.iqp.iqb.addHeaderView(r.eC(this.iqp).inflate(R.i.cTz, null));
                if (!(aVar == null || aVar.iox == null || aVar.iox.size() <= 0)) {
                    this.iqp.iqi = new a(this.iqp, aVar.iox, hashMap);
                    this.iqp.iqb.setAdapter(this.iqp.iqi);
                }
                this.iqp.iqe.setVisibility(0);
                this.iqp.hgN.post(this.iqp.iqo);
            }
        });
    }

    protected final int Ol() {
        return 1;
    }

    private void On() {
        try {
            this.iqj = 0.0d;
            this.iqm = false;
            if (this.iqh != null) {
                for (String str : this.iqh.values()) {
                    double d = bg.getDouble(str, 0.0d);
                    this.iqj += d;
                    if (this.iqk > 0 && d * 100.0d > ((double) this.iqk)) {
                        this.iqm = true;
                    }
                }
                if (this.iqi != null) {
                    a aVar = this.iqi;
                    Map map = this.iqh;
                    for (b bVar : aVar.dataList) {
                        bVar.iqw = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (b bVar2 : aVar.dataList) {
                            if (map.containsKey(bVar2.username)) {
                                bVar2.iqw = (String) map.get(bVar2.username);
                            }
                        }
                    }
                }
            }
            this.iqd.setText(getString(R.l.evQ, new Object[]{Double.valueOf(this.iqj)}));
            if (this.iqh.size() > 0) {
                aB(233, getString(R.l.dAX, new Object[]{Integer.valueOf(this.iqh.size())}));
            } else {
                aB(233, getString(R.l.dHT));
            }
            if (this.iqm) {
                g.oUh.i(13722, new Object[]{Integer.valueOf(7)});
                ae(233, false);
                CharSequence string = getString(R.l.ewa, new Object[]{Float.valueOf(((float) this.iqk) / 100.0f)});
                if (!bg.mA(string)) {
                    this.iqf.setText(string);
                    if (!this.iqf.isShown()) {
                        this.iqf.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRf));
                        this.iqf.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            ae(233, true);
            if (this.iqf.isShown()) {
                this.iqf.setText("");
                this.iqf.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRj));
                this.iqf.setVisibility(8);
            }
        } catch (Exception e) {
            w.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[]{e.getMessage()});
        }
    }

    private void Oo() {
        if (this.iqj > 0.0d) {
            this.iqg = true;
            this.iqc.setTextColor(getResources().getColor(R.e.aTa));
            return;
        }
        this.iqg = false;
        this.iqc.setTextColor(getResources().getColor(R.e.aSZ));
    }

    protected final int getLayoutId() {
        return R.i.dgC;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.iqh != null) {
            this.iqh.clear();
        }
    }
}
