package com.tencent.mm.plugin.card.ui.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.i;

public final class n extends h {
    public n(g gVar, MMActivity mMActivity) {
        super(gVar, mMActivity);
    }

    public final int getLayoutId() {
        return R.i.cWj;
    }

    public final boolean i(b bVar) {
        if (bVar.afj().tnV) {
            lz lzVar = bVar.afj().tnU;
            if (lzVar == null || i.wx(lzVar.title)) {
                return true;
            }
            w.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
            return false;
        }
        w.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
        return false;
    }

    public final void e(ViewGroup viewGroup) {
        viewGroup.findViewById(R.h.bCS).setVisibility(8);
        viewGroup.findViewById(R.h.bCR).setVisibility(0);
    }

    public final void c(ViewGroup viewGroup, b bVar) {
        super.c(viewGroup, bVar);
        d(viewGroup, bVar);
    }

    public final void d(final ViewGroup viewGroup, b bVar) {
        or orVar = bVar.afi().toP;
        View findViewById = viewGroup.findViewById(R.h.bCU);
        if (orVar == null || !orVar.tui) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        if (!i.wx(orVar.tuj)) {
            ((TextView) viewGroup.findViewById(R.h.bCV)).setText(orVar.tuj);
            ((ImageView) viewGroup.findViewById(R.h.bCT)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ n kqo;

                public final void onClick(View view) {
                    Button button = (Button) viewGroup.findViewById(R.h.bCD);
                    View findViewById = viewGroup.findViewById(R.h.bCS);
                    if (button.getVisibility() != 0 || findViewById.getVisibility() != 0) {
                        if (findViewById.getVisibility() == 0) {
                            if (l.isNetworkAvailable(this.kqo.kdb.uSU.uTo)) {
                                findViewById.setVisibility(8);
                                viewGroup.findViewById(R.h.bCR).setVisibility(0);
                            } else {
                                d.a(this.kqo.kdb, this.kqo.kdb.getString(R.l.dQM), false);
                                return;
                            }
                        }
                        this.kqo.kqb.d(c.CARDCODEREFRESHACTION_DOREFRESH);
                    }
                }
            });
        }
    }

    public final boolean aiA() {
        return false;
    }

    public final boolean aiB() {
        return true;
    }

    public final void a(ViewGroup viewGroup, final b bVar) {
        al.agq().afz();
        viewGroup.findViewById(R.h.bCS).setVisibility(0);
        viewGroup.findViewById(R.h.bCR).setVisibility(8);
        final lz lzVar = bVar.afj().tnU;
        if (lzVar != null) {
            viewGroup.findViewById(R.h.bCX).setVisibility(0);
            if (!i.wx(lzVar.title)) {
                Button button = (Button) viewGroup.findViewById(R.h.bCD);
                button.setText(lzVar.title);
                button.setVisibility(0);
                a(button, bVar);
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ n kqo;

                    public final void onClick(View view) {
                        if (!i.wx(lzVar.tnZ) && !i.wx(lzVar.tnY)) {
                            int intExtra;
                            int intExtra2 = this.kqo.kdb.getIntent() != null ? this.kqo.kdb.getIntent().getIntExtra("key_from_scene", 3) : 3;
                            if (this.kqo.kdb.getIntent() != null) {
                                intExtra = this.kqo.kdb.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra = 0;
                            }
                            com.tencent.mm.plugin.card.b.b.a(bVar.afm(), lzVar, intExtra2, intExtra);
                            g.oUh.i(11941, new Object[]{Integer.valueOf(20), bVar.afm(), bVar.afn(), "", lzVar.title});
                        } else if (i.wx(lzVar.url)) {
                            d.a(this.kqo.kdb, this.kqo.kdb.getString(R.l.fkA), true);
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(this.kqo.kdb, l.o(lzVar.url, lzVar.tpl), 1);
                            g gVar = g.oUh;
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(9);
                            objArr[1] = bVar.afm();
                            objArr[2] = bVar.afn();
                            objArr[3] = "";
                            objArr[4] = lzVar.title != null ? lzVar.title : "";
                            gVar.i(11941, objArr);
                        }
                    }
                });
                if (!i.wx(lzVar.kdH)) {
                    ((TextView) viewGroup.findViewById(R.h.bCF)).setText(lzVar.kdH);
                }
                TextView textView = (TextView) viewGroup.findViewById(R.h.bCW);
                if (i.wx(lzVar.kdI)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setText(lzVar.kdI);
                textView.setVisibility(0);
            }
        }
    }

    public final void b(ViewGroup viewGroup, b bVar) {
        w.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
        final View findViewById = viewGroup.findViewById(R.h.bCS);
        if (findViewById.getVisibility() == 0) {
            w.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
            return;
        }
        findViewById.setVisibility(0);
        View findViewById2 = viewGroup.findViewById(R.h.bCU);
        if (findViewById2.getVisibility() == 0) {
            findViewById2.setVisibility(8);
        }
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.h.bCR);
        imageView.setVisibility(8);
        final View findViewById3 = viewGroup.findViewById(R.h.bCX);
        findViewById3.setVisibility(0);
        ((TextView) viewGroup.findViewById(R.h.bCF)).setText(this.kdb.getResources().getString(R.l.dQy));
        final Button button = (Button) viewGroup.findViewById(R.h.bCD);
        button.setVisibility(0);
        a(button, bVar);
        com.tencent.mm.plugin.card.a.g agq = al.agq();
        if (bVar == null) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
        } else {
            agq.afz();
            k sv = al.ago().sv(bVar.afm());
            if (sv != null) {
                w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[]{sv.field_card_id, sv.field_code_id});
                if (al.ago().bv(bVar.afm(), sv.field_code_id)) {
                    agq.a(bVar.afm(), sv.field_code_id, c.CARDCODEREFRESHACTION_SNAPSHOT);
                } else {
                    w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[]{sv.field_card_id, sv.field_code_id});
                }
            } else {
                w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
            }
        }
        final ViewGroup viewGroup2 = viewGroup;
        final b bVar2 = bVar;
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ n kqo;

            public final void onClick(View view) {
                findViewById.setVisibility(8);
                findViewById3.setVisibility(8);
                imageView.setVisibility(0);
                button.setVisibility(8);
                this.kqo.kqb.d(c.CARDCODEREFRESHACTION_SNAPSHOT);
                this.kqo.d(viewGroup2, bVar2);
            }
        });
    }

    private void a(Button button, b bVar) {
        String str = bVar.afi().hib;
        if (!i.wx(str)) {
            int ta = l.ta(str);
            button.setText(this.kdb.getResources().getString(R.l.dQz));
            button.setTextColor(ta);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.kdb.getResources().getColor(R.e.aTj));
            gradientDrawable.setStroke(2, ta);
            gradientDrawable.setCornerRadius(8.0f);
            button.setBackground(gradientDrawable);
        }
    }
}
