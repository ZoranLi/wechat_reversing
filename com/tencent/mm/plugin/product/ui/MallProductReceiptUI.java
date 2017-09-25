package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.s;

public class MallProductReceiptUI extends MallBaseUI {
    private c oqU;
    private d ork = null;
    private AutoCompleteTextView orl = null;
    private h orm = null;

    protected final int getLayoutId() {
        return R.i.dld;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ork = a.aSQ().aSS();
        a.aSQ();
        this.oqU = a.aSR();
        KC();
    }

    public final void KC() {
        zi(R.l.ezS);
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ MallProductReceiptUI orn;

            {
                this.orn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                String obj = this.orn.orl.getText().toString();
                if (bg.mA(obj)) {
                    s.makeText(this.orn, R.l.ezR, 0).show();
                } else {
                    c b = this.orn.oqU;
                    b.opc = new aue();
                    aue com_tencent_mm_protocal_c_aue = b.opc;
                    if (!bg.mA(obj)) {
                        i = 1;
                    }
                    com_tencent_mm_protocal_c_aue.tXV = i;
                    b.opc.mtg = obj;
                    this.orn.finish();
                }
                return true;
            }
        });
        this.orl = (AutoCompleteTextView) findViewById(R.h.chS);
        aue aSY = this.oqU.aSY();
        if (!(aSY == null || bg.mA(aSY.mtg))) {
            this.orl.setText(aSY.mtg);
        }
        this.orl.setSelection(this.orl.getText().length());
        this.orm = new h(this);
        this.orl.setAdapter(this.orm);
        this.orl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallProductReceiptUI orn;

            {
                this.orn = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d c = this.orn.ork;
                CharSequence charSequence = (c.opn == null || i >= c.opn.size()) ? null : (String) c.opn.get(i);
                w.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = " + charSequence);
                if (!bg.mA(charSequence)) {
                    this.orn.orl.setText(charSequence);
                }
            }
        });
        View.inflate(this.uSU.uTo, R.i.dla, null).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductReceiptUI orn;

            {
                this.orn = r1;
            }

            public final void onClick(View view) {
                d c = this.orn.ork;
                c.opn.clear();
                c.aTl();
                this.orn.orm.notifyDataSetChanged();
            }
        });
    }
}
