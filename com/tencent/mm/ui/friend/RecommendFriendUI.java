package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ao.h;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.protocal.c.sq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private int isx = -1;
    private ListView nWh;
    private TextView oDO;
    private LinkedList<sq> wgJ = new LinkedList();
    private boolean wgK;
    private boolean whA = false;
    private b why;
    private LinkedList<anp> whz = new LinkedList();

    static /* synthetic */ void c(RecommendFriendUI recommendFriendUI) {
        for (int i = 0; i < recommendFriendUI.why.bYT().length; i++) {
            ap.yY();
            c.wQ().b(new h(recommendFriendUI.why.bYT()[i], recommendFriendUI.isx));
            q qVar = new q();
            qVar.username = recommendFriendUI.why.bYT()[i];
            qVar.hBx = recommendFriendUI.isx;
            qVar.hve = (int) bg.Ny();
            af.Gc().a(qVar);
        }
        g.a(recommendFriendUI.uSU.uTo, R.l.etb, R.l.dIO, new OnClickListener(recommendFriendUI) {
            final /* synthetic */ RecommendFriendUI whB;

            {
                this.whB = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.whB.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dfP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isx = bg.getInt(getIntent().getStringExtra("recommend_type"), 0);
        this.wgK = false;
        ap.vd().a(b.CTRL_INDEX, this);
        KC();
    }

    protected final void KC() {
        this.oDO = (TextView) findViewById(R.h.bMa);
        if (this.isx == 1) {
            zi(R.l.eTP);
            this.oDO.setText(R.l.eTR);
        } else if (this.isx == 2) {
            zi(R.l.eTO);
            this.oDO.setText(R.l.eTQ);
        } else {
            zi(R.l.eSF);
            this.oDO.setText(R.l.eTS);
        }
        this.why = new b(getLayoutInflater());
        this.nWh = (ListView) findViewById(R.h.bYr);
        this.nWh.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ RecommendFriendUI whB;

            {
                this.whB = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 0;
                if (this.whB.wgK) {
                    RecommendFriendUI recommendFriendUI = this.whB;
                    b b = this.whB.why;
                    if (b.wgK) {
                        i2 = ((sq) b.wgJ.get(i)).tAA;
                    }
                    recommendFriendUI.BR(i2);
                    return;
                }
                this.whB.why.hk(i);
                if (this.whB.why.bYT().length > 0) {
                    this.whB.ks(true);
                } else {
                    this.whB.ks(false);
                }
            }
        });
        this.nWh.setAdapter(this.why);
        a(0, getString(R.l.eta), new OnMenuItemClickListener(this) {
            final /* synthetic */ RecommendFriendUI whB;

            {
                this.whB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int length = this.whB.why.bYT().length;
                g.a(this.whB.uSU.uTo, this.whB.uSU.uTo.getResources().getQuantityString(R.j.dss, length, new Object[]{Integer.valueOf(length)}), this.whB.getString(R.l.dIO), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 whC;

                    {
                        this.whC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RecommendFriendUI.c(this.whC.whB);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 whC;

                    {
                        this.whC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        ks(false);
        this.whA = true;
        final k pVar = new p(this.isx);
        ap.vd().a(pVar, 0);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isv = g.a(context, getString(R.l.etd), true, new OnCancelListener(this) {
            final /* synthetic */ RecommendFriendUI whB;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(pVar);
                this.whB.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecommendFriendUI whB;

            {
                this.whB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.whB.goBack();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new View.OnClickListener(this) {
            final /* synthetic */ RecommendFriendUI whB;

            {
                this.whB = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.whB.nWh);
            }
        };
    }

    private void goBack() {
        if (this.isx != 0) {
            finish();
        } else if (this.wgK || this.whA) {
            finish();
        } else {
            bYV();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        ap.vd().b(b.CTRL_INDEX, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i == 0 && i2 == 0 && kVar.getType() == b.CTRL_INDEX) {
            this.whz = ((anm) ((p) kVar).gUA.hsk.hsr).msI;
            this.wgJ = ((anm) ((p) kVar).gUA.hsk.hsr).tfz;
            this.whA = false;
            if (this.whz.size() <= 0) {
                bYU();
                return;
            } else if (this.isx == 0 && this.wgJ.size() <= 0) {
                bYU();
                return;
            } else if (this.isx != 0) {
                BR(-1);
                return;
            } else {
                bYV();
                return;
            }
        }
        bYU();
    }

    private void bYU() {
        this.oDO.setVisibility(0);
        this.nWh.setVisibility(8);
    }

    private void BR(int i) {
        w.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.whz.size());
        this.why.e(this.whz, i);
        this.nWh.setAdapter(this.why);
        this.wgK = false;
        if (this.isx == 0) {
            String str = "";
            int i2 = 0;
            while (i2 < this.wgJ.size()) {
                String str2;
                if (i == ((sq) this.wgJ.get(i2)).tAA) {
                    str2 = ((sq) this.wgJ.get(i2)).tAB;
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
            qP(str);
        }
        this.why.wgK = this.wgK;
        this.why.notifyDataSetChanged();
    }

    private void bYV() {
        Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", this.isx == 0);
        w.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.wgJ.size());
        this.why.wgJ = this.wgJ;
        this.nWh.setAdapter(this.why);
        ks(false);
        this.wgK = true;
        zi(R.l.eSF);
        this.why.wgK = this.wgK;
        this.why.notifyDataSetChanged();
    }
}
