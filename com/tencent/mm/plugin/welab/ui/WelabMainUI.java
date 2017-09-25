package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class WelabMainUI extends MMActivity {
    private boolean ssY = false;
    private LinearLayout stl;
    private LinearLayout stm;
    private LinearLayout stn;
    private LinearLayout sto;
    private View stp;
    private View stq;
    private Comparator<a> str = new Comparator<a>(this) {
        final /* synthetic */ WelabMainUI stt;

        {
            this.stt = r1;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == aVar2) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    return 1;
                }
                if (aVar.field_Pos == aVar2.field_Pos) {
                    int PY = bg.PY(aVar.field_expId);
                    int PY2 = bg.PY(aVar2.field_expId);
                    if (PY != PY2) {
                        return PY2 > PY ? 1 : -1;
                    } else {
                        return 0;
                    }
                } else if (aVar.field_Pos > aVar2.field_Pos) {
                    return 1;
                }
            }
            return -1;
        }
    };
    private OnClickListener sts = new OnClickListener(this) {
        final /* synthetic */ WelabMainUI stt;

        {
            this.stt = r1;
        }

        public final void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof a) {
                a aVar = (a) tag;
                Intent intent = new Intent();
                intent.putExtra("para_appid", aVar.field_LabsAppId);
                intent.putExtra("para_from_with_red_point", b.bAV().e(aVar) ? 1 : 0);
                intent.setClass(this.stt, WelabAppInfoUI.class);
                this.stt.startActivity(intent);
                b bAV = b.bAV();
                String str = aVar.field_LabsAppId;
                bAV.ssT.put(str, Integer.valueOf(1));
                bAV.tag += "&" + str + "=1";
                h.vI().vr().a(w.a.uHB, bAV.tag);
                b.bAW();
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WelabMainUI", "click " + aVar);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        if (getIntent() != null) {
            if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
                z = true;
            }
            this.ssY = z;
        }
        KC();
        b.bAV();
        ab.bIY().edit().putBoolean("key_has_enter_welab", true).commit();
        b.bAW();
        e.o("", 1, this.ssY);
    }

    protected final int getLayoutId() {
        return c.ssG;
    }

    protected final void KC() {
        zi(d.ssJ);
        zm(com.tencent.mm.plugin.welab.a.a.white);
        bPR();
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.sso));
        }
        if (cO().cP() != null) {
            cO().cP().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.sso));
        }
        this.stl = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.ssv);
        this.stn = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.ssw);
        this.stm = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.ssy);
        this.sto = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.ssz);
        this.stp = findViewById(com.tencent.mm.plugin.welab.a.b.eGS);
        this.stq = findViewById(com.tencent.mm.plugin.welab.a.b.ssu);
        this.stp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WelabMainUI stt;

            {
                this.stt = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", view.getResources().getString(d.ssL));
                intent.putExtra("rawUrl", this.stt.uSU.uTo.getString(d.ssH, new Object[]{v.bIN(), Integer.valueOf(com.tencent.mm.protocal.d.sYN)}));
                intent.putExtra("showShare", false);
                com.tencent.mm.bb.d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WelabMainUI stt;

            {
                this.stt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.stt.aHf();
                this.stt.finish();
                return true;
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.stn.removeAllViews();
        this.sto.removeAllViews();
        List<a> bAH = com.tencent.mm.plugin.welab.b.bAG().bAH();
        if (bAH == null || bAH.isEmpty()) {
            this.stl.setVisibility(8);
        } else {
            this.stl.setVisibility(0);
            Collections.sort(bAH, this.str);
            for (a a : bAH) {
                a(a, this.stn);
            }
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WelabMainUI", "get online app count " + this.stn.getChildCount());
        }
        bAU();
        if (this.stl.getVisibility() == 0 || this.stm.getVisibility() == 0) {
            this.stq.setVisibility(8);
        } else {
            this.stq.setVisibility(0);
        }
    }

    public void onPause() {
        super.onPause();
    }

    private void bAU() {
        List<a> bAP = com.tencent.mm.plugin.welab.b.bAG().ssN.bAP();
        Iterator it = bAP.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if ((System.currentTimeMillis() / 1000) - aVar.field_endtime >= 2592000) {
                it.remove();
                com.tencent.mm.plugin.welab.b.bAG().ssN.a(aVar, new String[0]);
            } else if (aVar.bAQ() && aVar.field_Switch != 3) {
                aVar.field_Switch = 3;
                com.tencent.mm.plugin.welab.b.bAG().ssN.c(aVar, new String[0]);
            } else if (aVar.field_Switch != 3) {
                it.remove();
            }
        }
        if (bAP.isEmpty()) {
            this.stm.setVisibility(8);
            return;
        }
        this.stm.setVisibility(0);
        Collections.sort(bAP, this.str);
        for (a aVar2 : bAP) {
            a(aVar2, this.sto);
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WelabMainUI", "get online app count " + this.sto.getChildCount());
    }

    private void a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(c.ssE, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.ssC);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.ssp);
        TextView textView = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.title);
        TextView textView2 = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        if (b.bAV().e(aVar)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        com.tencent.mm.ah.a.a.Hd().a(aVar.Lb("field_ThumbUrl"), imageView2, com.tencent.mm.plugin.welab.b.bAG().ssQ);
        com.tencent.mm.plugin.welab.b.bAG();
        textView.setText(com.tencent.mm.plugin.welab.b.a(aVar));
        textView2.setText(aVar.Lb("field_Desc"));
        linearLayout2.setTag(aVar);
        linearLayout2.setOnClickListener(this.sts);
        linearLayout.addView(linearLayout2);
    }
}
