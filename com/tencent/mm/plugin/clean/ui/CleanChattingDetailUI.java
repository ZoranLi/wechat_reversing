package com.tencent.mm.plugin.clean.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.plugin.clean.b.e;
import com.tencent.mm.plugin.clean.b.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CleanChattingDetailUI extends MMActivity implements g {
    private int index;
    private ProgressDialog isv;
    private View jEV;
    CheckBox jEX;
    private GridHeadersGridView kzm;
    private b kzn;
    private b kzo;
    MMAutoAdjustTextView kzp;
    private Button kzq;
    private e kzr;

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        if (d.ajK() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingDetailUI.kzn.jEP);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                arrayList2.add(cleanChattingDetailUI.kzo.kyt.get(intValue));
                cleanChattingDetailUI.kzo.kyt.remove(intValue);
            }
            if (!cleanChattingDetailUI.kzo.ajF()) {
                d.abX().remove(cleanChattingDetailUI.index);
                w.i("MicroMsg.CleanChattingDetailUI", "Delete username=%s", new Object[]{cleanChattingDetailUI.kzo.username});
            }
            cleanChattingDetailUI.kzn.ajS();
            cleanChattingDetailUI.kzn.notifyDataSetChanged();
            if (cleanChattingDetailUI.kzr != null) {
                cleanChattingDetailUI.kzr.ajR();
            }
            cleanChattingDetailUI.kzr = new e(d.ajK(), cleanChattingDetailUI, arrayList2);
            cleanChattingDetailUI.kzr.start();
            cleanChattingDetailUI.isv.show();
            cleanChattingDetailUI.isv.setMessage(cleanChattingDetailUI.getString(R.l.dWi, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.ajP();
        this.index = getIntent().getIntExtra("key_position", -1);
        if (this.index < 0) {
            finish();
        } else if (d.abX() == null) {
            finish();
        } else {
            this.jEV = findViewById(R.h.box);
            this.jEX = (CheckBox) findViewById(R.h.bow);
            this.kzp = (MMAutoAdjustTextView) findViewById(R.h.bHX);
            this.kzq = (Button) findViewById(R.h.bev);
            kT(0);
            this.kzo = (b) d.abX().get(this.index);
            if (o.dH(this.kzo.username)) {
                qP(n.E(this.kzo.username, this.kzo.username));
            } else {
                qP(n.eK(this.kzo.username));
            }
            this.kzm = (GridHeadersGridView) findViewById(R.h.bCp);
            this.kzm.setNumColumns(3);
            this.kzn = new b(this, this.kzo.kyt);
            this.kzm.wjh = this.kzn.kza;
            this.kzm.setOnItemClickListener(this.kzn.kbd);
            this.kzm.setOnScrollListener(this.kzn.kzc);
            this.kzm.setAdapter(this.kzn);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ CleanChattingDetailUI kzs;

                {
                    this.kzs = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.kzs.finish();
                    return false;
                }
            });
            this.jEV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CleanChattingDetailUI kzs;

                {
                    this.kzs = r1;
                }

                public final void onClick(View view) {
                    b a = this.kzs.kzn;
                    if (a.jEP.size() == a.jjQ.size()) {
                        a.jEP.clear();
                    } else {
                        for (int i = 0; i < a.jjQ.size(); i++) {
                            a.jEP.add(Integer.valueOf(i));
                        }
                    }
                    a.ajT();
                    this.kzs.kzn.notifyDataSetChanged();
                }
            });
            this.kzq.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CleanChattingDetailUI kzs;

                {
                    this.kzs = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.ui.base.g.a(this.kzs, this.kzs.getString(R.l.dXf), "", this.kzs.getString(R.l.bHU), this.kzs.getString(R.l.cancel), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 kzt;

                        {
                            this.kzt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            CleanChattingDetailUI.b(this.kzt.kzs);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 kzt;

                        {
                            this.kzt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            });
            getString(R.l.dIO);
            this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.dWc), false, new OnCancelListener(this) {
                final /* synthetic */ CleanChattingDetailUI kzs;

                {
                    this.kzs = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.isv.dismiss();
        }
    }

    protected final int getLayoutId() {
        return R.i.cYS;
    }

    public final void kT(int i) {
        this.kzq.setEnabled(i > 0);
    }

    protected void onDestroy() {
        if (this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (this.kzr != null) {
            this.kzr.ajR();
        }
        d.ajQ();
        d.ajO();
        super.onDestroy();
    }

    public final void bM(int i, int i2) {
        this.isv.setMessage(getString(R.l.dWi, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void aR(long j) {
        this.isv.dismiss();
        d.aQ(d.ajM() + j);
        d.aP(d.ajL() - j);
        com.tencent.mm.ui.base.g.a(this, getString(R.l.dWd, new Object[]{bg.ay(j)}), "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CleanChattingDetailUI kzs;

            {
                this.kzs = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.kzs.kzo.kyt.size() == 0) {
                    this.kzs.finish();
                }
            }
        });
    }
}
