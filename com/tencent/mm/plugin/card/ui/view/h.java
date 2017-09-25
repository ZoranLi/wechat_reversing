package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.c.a.a.t;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.pb.common.c.i;

public abstract class h implements aa {
    protected MMActivity kdb;
    protected g kqb;

    public abstract boolean aiA();

    public abstract boolean aiB();

    public h(g gVar, MMActivity mMActivity) {
        this.kqb = gVar;
        this.kdb = mMActivity;
    }

    public void c(ViewGroup viewGroup, final b bVar) {
        if (aiA()) {
            TextView textView = (TextView) viewGroup.findViewById(R.h.bCY);
            String str = this.kqb.code;
            if (bVar.afc() || (!i.wx(str) && str.length() <= 40)) {
                textView.setText(m.ti(str));
                if (bVar.aeX()) {
                    textView.setVisibility(0);
                    textView.setOnLongClickListener(new OnLongClickListener(this) {
                        final /* synthetic */ h kqd;

                        public final boolean onLongClick(View view) {
                            if (view.getId() == R.h.bCY) {
                                p.I(this.kqd.kdb, bVar.afj().code);
                                g.bl(this.kqd.kdb, o.getString(R.l.dGy));
                            }
                            return false;
                        }
                    });
                    this.kqb.d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        if (aiB()) {
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.h.bCM);
            if (bVar == null || bVar.afi() == null || bVar.afi().toO == null) {
                relativeLayout.setVisibility(8);
                return;
            }
            viewGroup.findViewById(R.h.bCE).setVisibility(8);
            relativeLayout.setVisibility(0);
            lz lzVar = bVar.afi().toO;
            TextView textView2 = (TextView) viewGroup.findViewById(R.h.bCO);
            textView2.setText(lzVar.title);
            String str2 = bVar.afi().hib;
            if (!i.wx(str2)) {
                textView2.setTextColor(l.ta(str2));
            }
            CharSequence charSequence = lzVar.kdI;
            if (!TextUtils.isEmpty(charSequence)) {
                textView2 = (TextView) viewGroup.findViewById(R.h.bCN);
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = a.fromDPToPix(this.kdb.uSU.uTo, 69);
                relativeLayout.setLayoutParams(layoutParams);
            }
            relativeLayout.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h kqd;

                public final void onClick(View view) {
                    if (bVar.afb()) {
                        com.tencent.mm.plugin.card.a.i.b bVar = new com.tencent.mm.plugin.card.a.i.b();
                        com.tencent.mm.plugin.card.b.b.a(this.kqd.kqb.kdb, bVar.kdu, bVar.kdv, false, bVar);
                    } else {
                        lz lzVar = bVar.afi().toO;
                        if (lzVar != null && !i.wx(lzVar.tnZ) && !i.wx(lzVar.tnY)) {
                            int intExtra;
                            int intExtra2;
                            if (this.kqd.kdb.getIntent() != null) {
                                intExtra = this.kqd.kdb.getIntent().getIntExtra("key_from_scene", 3);
                            } else {
                                intExtra = 3;
                            }
                            if (this.kqd.kdb.getIntent() != null) {
                                intExtra2 = this.kqd.kdb.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra2 = 0;
                            }
                            com.tencent.mm.plugin.card.b.b.a(bVar.afm(), lzVar, intExtra, intExtra2);
                            com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(20), bVar.afm(), bVar.afn(), "", lzVar.title});
                        } else if (!(lzVar == null || TextUtils.isEmpty(lzVar.url))) {
                            com.tencent.mm.plugin.card.b.b.a(this.kqd.kqb.kdb, l.o(lzVar.url, lzVar.tpl), 1);
                            com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(9), bVar.afm(), bVar.afn(), "", lzVar.title});
                            if (l.a(lzVar, bVar.afm())) {
                                String afm = bVar.afm();
                                String str = lzVar.title;
                                l.tg(afm);
                                com.tencent.mm.plugin.card.b.b.a(this.kqd.kqb.kdb, bVar.afi().keT);
                            }
                        }
                    }
                    t.finish();
                }
            });
        }
    }

    public boolean i(b bVar) {
        return true;
    }

    public void e(ViewGroup viewGroup) {
    }
}
