package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.g.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int npX;
    private LinearLayout nsq;
    private LinearLayout nsr;
    private LinearLayout nss;

    static /* synthetic */ void a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i) {
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.uSU.uTo, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.npX);
        luckyMoneyIndexUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.S(this);
        KC();
        b(new v("v1.0", (byte) 0), false);
        this.npX = getIntent().getIntExtra("pay_channel", -1);
        g.oUh.i(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        a.a(this, b.bCz());
    }

    protected final void KC() {
        zi(R.l.eyx);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI nst;

            {
                this.nst = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nst.finish();
                return true;
            }
        });
        this.nsq = (LinearLayout) findViewById(R.h.ceI);
        this.nsr = (LinearLayout) findViewById(R.h.ceG);
        this.nss = (LinearLayout) findViewById(R.h.ceE);
        ((Button) findViewById(R.h.ceH)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI nst;

            {
                this.nst = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                LuckyMoneyIndexUI.a(this.nst, 0);
            }
        });
        ((Button) findViewById(R.h.ceF)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI nst;

            {
                this.nst = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                LuckyMoneyIndexUI.a(this.nst, 1);
            }
        });
        a(0, getString(R.l.exP), new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyIndexUI nst;

            {
                this.nst = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.oUh.i(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.nst.getString(R.l.exR));
                linkedList2.add(Integer.valueOf(0));
                linkedList.add(this.nst.getString(R.l.exS));
                linkedList2.add(Integer.valueOf(1));
                com.tencent.mm.ui.base.g.a(this.nst.uSU.uTo, "", linkedList, linkedList2, "", false, new d(this) {
                    final /* synthetic */ AnonymousClass4 nsu;

                    {
                        this.nsu = r1;
                    }

                    public final void bN(int i, int i2) {
                        int i3 = 1;
                        switch (i2) {
                            case 1:
                                g.oUh.i(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6)});
                                break;
                            default:
                                g.oUh.i(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5)});
                                i3 = 2;
                                break;
                        }
                        Intent intent = new Intent();
                        intent.setClass(this.nsu.nst.uSU.uTo, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", i3);
                        this.nsu.nst.startActivity(intent);
                    }
                });
                return true;
            }
        }, l.b.uUf);
        aIw();
    }

    private void aIw() {
        com.tencent.mm.plugin.luckymoney.a.a.aHG();
        c aHS = com.tencent.mm.plugin.luckymoney.a.a.aHH().aHS();
        if (aHS != null) {
            ImageView imageView = (ImageView) findViewById(R.h.bgL);
            if ((aHS.nma & 1) == 1) {
                w.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
                imageView.setImageResource(R.g.bgL);
                return;
            }
            imageView.setImageResource(R.g.bgM);
        }
    }

    protected final int getLayoutId() {
        return R.i.dhk;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof v)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            v vVar = (v) kVar;
            g.c cVar = new g.c();
            cVar.textColor = getResources().getColor(R.e.aUP);
            cVar.ntW = 101;
            g.a(this, this.nsq, vVar.nmx, cVar, "Text");
            cVar = new g.c();
            cVar.textColor = getResources().getColor(R.e.aUP);
            cVar.ntW = 100;
            g.a(this, this.nsr, vVar.nnD, cVar, "Text");
            cVar = new g.c();
            cVar.ntW = 102;
            g.a(this, this.nss, vVar.nnB, cVar, "Pic");
            aIw();
        }
        return true;
    }
}
