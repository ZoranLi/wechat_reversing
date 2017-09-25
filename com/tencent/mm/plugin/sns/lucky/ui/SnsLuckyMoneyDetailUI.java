package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private ListView nra;
    OnScrollListener nrt = new OnScrollListener(this) {
        private boolean nru = false;
        private boolean nrv;
        final /* synthetic */ SnsLuckyMoneyDetailUI pSh;

        {
            this.pSh = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        this.nru = false;
                        return;
                    case 1:
                        this.nru = true;
                        return;
                    default:
                        return;
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 0 && this.nru) {
                if (i <= 0) {
                    int top;
                    View childAt = absListView.getChildAt(i);
                    if (childAt != null) {
                        top = 0 - childAt.getTop();
                    } else {
                        top = 0;
                    }
                    if (top <= 100) {
                        z = false;
                    }
                }
                if (this.nrv != z) {
                    if (z) {
                        this.pSh.r(this.pSh.getResources().getDrawable(R.e.aVT));
                    } else {
                        this.pSh.r(null);
                    }
                    this.nrv = z;
                }
            }
        }
    };
    private final int nsn = 750;
    private final int nso = 240;
    private b pSg;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        List zI = a.zI(getIntent().getStringExtra("key_feedid"));
        if (!(zI == null || zI.size() == 0)) {
            b bVar = this.pSg;
            if (zI == null) {
                LinkedList linkedList = new LinkedList();
            } else {
                bVar.nro = zI;
            }
            bVar.notifyDataSetChanged();
        }
        bPR();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.aVU));
        }
        SE(null);
    }

    protected final void KC() {
        r(getResources().getDrawable(R.g.bgs));
        zi(R.l.eWS);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyDetailUI pSh;

            {
                this.pSh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pSh.finish();
                return true;
            }
        });
        this.nra = (ListView) findViewById(R.h.cef);
        this.pSg = new b(this.uSU.uTo);
        this.nra.setAdapter(this.pSg);
        this.nra.setOnScrollListener(this.nrt);
        this.nra.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyDetailUI pSh;

            {
                this.pSh = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.doM;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
