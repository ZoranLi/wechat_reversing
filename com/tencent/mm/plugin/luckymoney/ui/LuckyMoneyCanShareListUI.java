package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    private boolean kOH = false;
    private MMLoadMoreListView nrT;
    private d nrU;
    private boolean nrj = true;
    private List<h> nro = new LinkedList();
    private String nrr = "";
    private int wa = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        aIt();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyCanShareListUI nrV;

            {
                this.nrV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nrV.finish();
                return true;
            }
        });
        this.nrT = (MMLoadMoreListView) findViewById(R.h.cfa);
        qP(getString(R.l.exL));
        this.nrU = new e(this.uSU.uTo);
        this.nrT.setAdapter(this.nrU);
        this.nrT.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyCanShareListUI nrV;

            {
                this.nrV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                h oZ = this.nrV.nrU.oZ((int) j);
                if (oZ != null && !bg.mA(oZ.njw)) {
                    Intent intent = new Intent();
                    intent.setClass(this.nrV.uSU.uTo, LuckyMoneyDetailUI.class);
                    intent.putExtra("key_sendid", oZ.njw);
                    this.nrV.startActivity(intent);
                }
            }
        });
        this.nrT.vkV = new a(this) {
            final /* synthetic */ LuckyMoneyCanShareListUI nrV;

            {
                this.nrV = r1;
            }

            public final void ajC() {
                if (this.nrV.nrj && !this.nrV.kOH) {
                    this.nrV.aIt();
                }
            }
        };
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof x) || i != 0 || i2 != 0) {
            return false;
        }
        x xVar = (x) kVar;
        List list = xVar.nnG.nmB;
        this.nrr = xVar.nnw;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.nro.add(list.get(i3));
            }
            this.wa += list.size();
            this.nrj = xVar.aHZ();
            this.kOH = false;
            this.nrU.aP(this.nro);
        }
        if (this.nrj) {
            this.nrT.bSh();
        } else {
            this.nrT.bSi();
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dho;
    }

    private void aIt() {
        this.kOH = true;
        if (this.wa == 0) {
            this.nrr = "";
        }
        k(new x(10, this.wa, 3, "", "v1.0", this.nrr));
    }
}
