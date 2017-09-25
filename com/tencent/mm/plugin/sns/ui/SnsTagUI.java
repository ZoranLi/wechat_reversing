package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SnsTagUI extends MMActivity implements e {
    public static int[] qCJ = new int[]{j.pMA, j.pMC};
    public static int[] qHl = new int[]{j.pMu, j.pMD};
    private int linkColor;
    private ListView mUX;
    private a qHi;
    private HashMap<Long, String> qHj = new HashMap();
    private View[] qHk = new View[2];
    private int qHm = 0;
    private OnClickListener qHn = new OnClickListener(this) {
        final /* synthetic */ SnsTagUI qHo;

        {
            this.qHo = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof Integer) {
                this.qHo.ue(((Integer) view.getTag()).intValue());
            }
        }
    };

    class a extends k<s> {
        OnClickListener mAD = new OnClickListener(this) {
            final /* synthetic */ a qHp;

            {
                this.qHp = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof a) {
                    this.qHp.qHo.bkQ();
                    a aVar = (a) view.getTag();
                    if (this.qHp.qHo.qHj.containsKey(Long.valueOf(aVar.pUF))) {
                        this.qHp.qHo.qHj.remove(Long.valueOf(aVar.pUF));
                        if (this.qHp.qHo.qHj.isEmpty()) {
                            this.qHp.qHo.ue(0);
                        }
                    } else {
                        this.qHp.qHo.qHj.put(Long.valueOf(aVar.pUF), aVar.qHq);
                    }
                    this.qHp.qHo.qHi.notifyDataSetChanged();
                }
            }
        };
        final /* synthetic */ SnsTagUI qHo;

        class a {
            ImageView nvW;
            long pUF;
            int position;
            TextView qHf;
            TextView qHg;
            final /* synthetic */ a qHp;
            String qHq;
            TextView qHr;
            View qHs;
            View qHt;

            a(a aVar) {
                this.qHp = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (s) obj;
            if (obj == null) {
                obj = new s();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsTagUI snsTagUI, Context context, s sVar) {
            this.qHo = snsTagUI;
            super(context, sVar);
        }

        protected final void OL() {
            aEW();
            OK();
        }

        public final void OK() {
            t beQ = ae.beQ();
            super.setCursor(beQ.gUz.rawQuery(t.bhY() + " where tagId > 5", null));
            notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            s sVar = (s) super.getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(this.context, g.pIi, null);
                a aVar2 = new a(this);
                aVar2.nvW = (ImageView) view.findViewById(f.pFP);
                aVar2.qHf = (TextView) view.findViewById(f.pFR);
                aVar2.qHg = (TextView) view.findViewById(f.pFN);
                aVar2.qHs = view.findViewById(f.pGc);
                aVar2.qHr = (TextView) aVar2.qHs.findViewById(16908310);
                aVar2.qHt = view.findViewById(f.bZe);
                view.setTag(aVar2);
                view.setOnClickListener(this.mAD);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.position = i;
            aVar.pUF = sVar.field_tagId;
            aVar.qHq = sVar.field_tagName;
            if (this.qHo.qHj.containsKey(Long.valueOf(sVar.field_tagId))) {
                aVar.nvW.setImageResource(i.dvN);
            } else {
                aVar.nvW.setImageResource(i.dvO);
            }
            aVar.qHf.setText(sVar.field_tagName);
            aVar.qHg.setText("  (" + sVar.field_count + ")");
            aVar.qHg.setVisibility(0);
            return view;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        bkO();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(j.pMF);
        KC();
        h.vJ();
        h.vH().gXC.a(292, this);
        h.vJ();
        h.vH().gXC.a(new u(1), 0);
    }

    protected void onDestroy() {
        h.vJ();
        h.vH().gXC.b(292, this);
        this.qHi.aEW();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.qHi != null) {
            this.qHi.a("", null);
        }
    }

    public final void bkO() {
        String str = "";
        String str2 = "";
        if (this.qHm < 0 || this.qHm >= 2) {
            Iterator it = new ArrayList(this.qHj.keySet()).iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                s dI = ae.beQ().dI(longValue);
                if (dI.field_tagId == 0) {
                    this.qHj.remove(Long.valueOf(longValue));
                } else {
                    this.qHj.put(Long.valueOf(longValue), bg.ap(dI.field_tagName, ""));
                }
            }
            Object obj = 1;
            for (Long l : this.qHj.keySet()) {
                String str3;
                if (obj == null) {
                    str = str + ",";
                    str2 = str2 + ",";
                    str3 = str;
                } else {
                    str3 = str;
                }
                str3 = str3 + ((String) this.qHj.get(l));
                str2 = str2 + l;
                obj = null;
                str = str3;
            }
        } else {
            str = getString(qCJ[this.qHm]);
        }
        Intent intent = new Intent();
        intent.putExtra("Ktag_name_list", str);
        intent.putExtra("Ktag_id_list", str2);
        intent.putExtra("Ktag_range_index", this.qHm);
        setResult(-1, intent);
        finish();
    }

    protected final void KC() {
        View findViewById;
        this.linkColor = getResources().getColor(c.aVS);
        boolean booleanExtra = getIntent().getBooleanExtra("Ktag_rangeFilterprivate", false);
        this.mUX = (ListView) findViewById(f.pFQ);
        int i = 0;
        while (i < 2) {
            this.qHk[i] = new View(this);
            this.qHk[i] = View.inflate(this, g.pIi, null);
            ((TextView) this.qHk[i].findViewById(f.pFR)).setText(qCJ[i]);
            this.qHk[i].findViewById(f.pFO).setVisibility(0);
            ((TextView) this.qHk[i].findViewById(f.pFO)).setText(qHl[i]);
            ((TextView) this.qHk[i].findViewById(f.pFO)).setVisibility(8);
            this.qHk[i].setTag(Integer.valueOf(i));
            this.qHk[i].setOnClickListener(this.qHn);
            if (i != 0) {
                this.qHk[1].findViewById(f.pGc).setVisibility(8);
            }
            if (booleanExtra && i == 1) {
                this.qHk[1].setLayoutParams(new LayoutParams(-1, 1));
                this.qHk[1].setVisibility(8);
            }
            if (i == 1) {
                findViewById = this.qHk[1].findViewById(f.bZe);
                int[] iArr = new int[]{findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom()};
                findViewById.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.bgi);
                findViewById.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            this.mUX.addHeaderView(this.qHk[i]);
            i++;
        }
        findViewById = View.inflate(this, g.pIh, null);
        this.mUX.addFooterView(findViewById, null, false);
        this.qHi = new a(this, this, new s());
        this.mUX.setAdapter(this.qHi);
        bkP();
        findViewById.findViewById(f.pCs).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsTagUI qHo;

            {
                this.qHo = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("k_sns_tag_id", 4);
                intent.setClass(this.qHo, SnsBlackDetailUI.class);
                this.qHo.startActivity(intent);
            }
        });
        findViewById.findViewById(f.pCt).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsTagUI qHo;

            {
                this.qHo = r1;
            }

            public final void onClick(View view) {
                this.qHo.v(SnsTagPartlyUI.class);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagUI qHo;

            {
                this.qHo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qHo.bkO();
                return true;
            }
        });
    }

    private void bkP() {
        int i = 0;
        this.qHm = 0;
        switch (this.qHm) {
            case 0:
            case 1:
                ue(this.qHm);
                return;
            case 2:
                String stringExtra = getIntent().getStringExtra("Ktag_id_list");
                String stringExtra2 = getIntent().getStringExtra("Ktag_name_list");
                String[] split = stringExtra.split(",");
                String[] split2 = stringExtra2.split(",");
                int min = Math.min(split.length, split2.length);
                while (i < min) {
                    this.qHj.put(Long.valueOf(bg.getLong(split[i], 0)), split2[i]);
                    i++;
                }
                return;
            default:
                return;
        }
    }

    private void ue(int i) {
        if (i >= 0 && i < 2) {
            bkQ();
            this.qHm = i;
            ((ImageView) this.qHk[i].findViewById(f.pFP)).setImageResource(i.dvN);
            this.qHj.clear();
            if (this.qHi != null) {
                this.qHi.notifyDataSetChanged();
            }
        }
    }

    private void bkQ() {
        this.qHm = 2;
        for (int i = 0; i < 2; i++) {
            ((ImageView) this.qHk[i].findViewById(f.pFP)).setImageResource(i.dvO);
        }
    }

    protected final int getLayoutId() {
        return g.pIg;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (i == 0 && i2 == 0) {
            this.qHi.a("", null);
        }
    }
}
