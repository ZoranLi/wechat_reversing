package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailAddrListUI extends MMActivity {
    private j oAf = null;
    private p oDN = null;
    private TextView oDO = null;
    private TextView oDP = null;
    private ListView oDQ;
    private a oDR;
    private List<i> oDS;
    private com.tencent.mm.plugin.qqmail.b.j.a oDT = new com.tencent.mm.plugin.qqmail.b.j.a(this) {
        final /* synthetic */ MailAddrListUI oDU;

        {
            this.oDU = r1;
        }

        public final void onComplete() {
            if (this.oDU.oDN != null) {
                this.oDU.oDN.dismiss();
            }
            this.oDU.oDS = this.oDU.oAf.CP(null);
            if (this.oDU.oDS.size() == 0) {
                this.oDU.oDO.setText(R.l.eTQ);
                this.oDU.oDO.setVisibility(0);
            }
            String[] stringArrayExtra = this.oDU.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
            for (String CQ : stringArrayExtra == null ? new String[]{""} : stringArrayExtra) {
                i CQ2 = j.CQ(CQ);
                if (CQ2 != null) {
                    int i;
                    for (i iVar : this.oDU.oDS) {
                        if (iVar.naK.equalsIgnoreCase(CQ2.naK)) {
                            this.oDU.oDR.c(iVar);
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        this.oDU.oDR.c(CQ2);
                    }
                }
            }
            this.oDU.qP(this.oDU.getString(R.l.eGd) + (this.oDU.oDR.aVb() > 0 ? "(" + this.oDU.oDR.aVb() + ")" : ""));
            this.oDU.oDR.notifyDataSetChanged();
        }
    };

    class a extends BaseAdapter {
        private final Context context;
        final /* synthetic */ MailAddrListUI oDU;
        boolean oDV = false;
        boolean oDW = false;
        Map<String, i> oDX = new HashMap();

        class a {
            CheckBox ipy;
            TextView kzl;
            TextView oDY;
            TextView oDZ;
            final /* synthetic */ a oEa;

            a(a aVar) {
                this.oEa = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return rF(i);
        }

        public a(MailAddrListUI mailAddrListUI, Context context) {
            this.oDU = mailAddrListUI;
            this.context = context;
        }

        public final void c(i iVar) {
            this.oDX.put(iVar.naK, iVar);
        }

        public final int aVb() {
            return this.oDX.size();
        }

        public final int getCount() {
            int size = this.oDU.oDS.size();
            if (size != 0) {
                return !this.oDW ? size + 1 : size;
            } else {
                if (this.oDV) {
                    return 1;
                }
                return 0;
            }
        }

        private TextView aVc() {
            TextView textView = new TextView(this.context);
            textView.setBackgroundResource(R.g.bgi);
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            textView.setTextSize(0, (float) this.oDU.getResources().getDimensionPixelSize(R.f.aXs));
            int dimensionPixelSize = this.oDU.getResources().getDimensionPixelSize(R.f.aXt);
            int dimensionPixelSize2 = this.oDU.getResources().getDimensionPixelSize(R.f.aXR);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            return textView;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            if (i == 0) {
                if (this.oDV) {
                    view = aVc();
                    view.setText(R.l.eGk);
                    int dimensionPixelSize = this.oDU.getResources().getDimensionPixelSize(R.f.aXt);
                    view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    view.setTextSize(0, (float) this.oDU.getResources().getDimensionPixelSize(R.f.aWE));
                    view.setGravity(17);
                    return view;
                } else if (!this.oDW) {
                    view = aVc();
                    view.setText(R.l.eGj);
                    return view;
                }
            }
            if (view == null || view.getTag() == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.context, R.i.dlA, null);
                aVar2.oDY = (TextView) view.findViewById(R.h.ctP);
                aVar2.kzl = (TextView) view.findViewById(R.h.ctQ);
                aVar2.oDZ = (TextView) view.findViewById(R.h.ctO);
                aVar2.ipy = (CheckBox) view.findViewById(R.h.ctR);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            i rF = rF(i);
            if (this.oDW || i <= 10) {
                aVar.oDY.setVisibility(8);
            } else {
                i rF2 = rF(i - 1);
                if (i == 11) {
                    rF2 = null;
                }
                String d = d(rF);
                String d2 = d(rF2);
                if (d == null) {
                    aVar.oDY.setVisibility(8);
                } else if (d.equals(d2)) {
                    aVar.oDY.setVisibility(8);
                } else {
                    aVar.oDY.setText(d.toUpperCase());
                    aVar.oDY.setVisibility(0);
                }
            }
            aVar.kzl.setText(rF.name);
            aVar.oDZ.setText(rF.naK);
            CheckBox checkBox = aVar.ipy;
            if (this.oDX.get(rF.naK) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            return view;
        }

        private static String d(i iVar) {
            if (iVar == null) {
                return null;
            }
            String CL = com.tencent.mm.plugin.qqmail.b.a.CL(iVar.ozJ);
            char charAt = CL.length() > 1 ? CL.charAt(0) : '~';
            switch (charAt) {
                case '{':
                    charAt = CL.charAt(1);
                    if (bg.k(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
                case '~':
                    return "~";
                default:
                    if (bg.j(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
            }
        }

        public final i rF(int i) {
            if (!this.oDW) {
                i = i == 0 ? 0 : i - 1;
            }
            return (i) this.oDU.oDS.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            if (i == 0) {
                return this.oDW;
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return R.i.dlz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eGd);
        this.oDS = new ArrayList();
        this.oAf = w.aUz().oAf;
        KC();
        this.oAf.a(this.oDT);
        this.oAf.aUo();
    }

    protected final void KC() {
        this.oDQ = (ListView) findViewById(R.h.ctS);
        this.oDO = (TextView) findViewById(R.h.bMa);
        this.oDP = (TextView) findViewById(R.h.cor);
        this.oDR = new a(this, this);
        com.tencent.mm.ui.tools.p pVar = new com.tencent.mm.ui.tools.p(true, true);
        pVar.woe = new b(this) {
            final /* synthetic */ MailAddrListUI oDU;

            {
                this.oDU = r1;
            }

            public final void OF() {
            }

            public final void OG() {
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void mR(String str) {
                String ap = bg.ap(str, "");
                this.oDU.oDS = this.oDU.oAf.CP(ap.toLowerCase().trim());
                if (ap.length() > 0) {
                    this.oDU.oDR.oDW = true;
                } else {
                    this.oDU.oDR.oDW = false;
                }
                this.oDU.oDR.oDV = false;
                if (this.oDU.oDS.size() == 0) {
                    this.oDU.kr(false);
                    this.oDU.oDP.setVisibility(0);
                } else {
                    this.oDU.kr(true);
                    this.oDU.oDP.setVisibility(8);
                }
                this.oDU.oDR.notifyDataSetChanged();
            }

            public final void OD() {
            }

            public final void OE() {
            }
        };
        a(pVar);
        this.oDQ.setAdapter(this.oDR);
        this.oDQ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MailAddrListUI oDU;

            {
                this.oDU = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a e = this.oDU.oDR;
                i rF = e.rF(i - this.oDU.oDQ.getHeaderViewsCount());
                String str = rF.naK;
                if (e.oDX.containsKey(str)) {
                    e.oDX.remove(str);
                } else {
                    e.oDX.put(str, rF);
                }
                e.notifyDataSetChanged();
                this.oDU.qP(this.oDU.getString(R.l.eGd) + (this.oDU.oDR.aVb() > 0 ? "(" + this.oDU.oDR.aVb() + ")" : ""));
            }
        });
        this.oDQ.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MailAddrListUI oDU;

            {
                this.oDU = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    this.oDU.aHf();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.oDS = this.oAf.CP(null);
        this.oDR.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailAddrListUI oDU;

            {
                this.oDU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oDU.setResult(0);
                this.oDU.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new OnClickListener(this) {
            final /* synthetic */ MailAddrListUI oDU;

            {
                this.oDU = r1;
            }

            public final void onClick(View view) {
                c.a(this.oDU.oDQ);
            }
        };
        a(0, getString(R.l.eGc), new OnMenuItemClickListener(this) {
            final /* synthetic */ MailAddrListUI oDU;

            {
                this.oDU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                a e = this.oDU.oDR;
                List arrayList = new ArrayList();
                for (String str : e.oDX.keySet()) {
                    arrayList.add(e.oDX.get(str));
                }
                ComposeUI.bc(arrayList);
                this.oDU.setResult(-1);
                this.oDU.finish();
                return true;
            }
        });
        kr(!this.oDS.isEmpty());
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.oDN = g.a(context, getString(R.l.eGb), true, new OnCancelListener(this) {
            final /* synthetic */ MailAddrListUI oDU;

            {
                this.oDU = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.oDR.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.oAf.b(this.oDT);
    }
}
