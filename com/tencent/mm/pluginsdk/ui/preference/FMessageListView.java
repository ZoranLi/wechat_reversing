package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.f;
import com.tencent.mm.av.h;
import com.tencent.mm.av.j;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;

public class FMessageListView extends LinearLayout {
    private Context context;
    private final LayoutParams mBJ;
    com.tencent.mm.pluginsdk.ui.preference.a.a sRR;
    private com.tencent.mm.pluginsdk.e.a sRX;
    private com.tencent.mm.sdk.e.j.a sRY;
    private com.tencent.mm.sdk.e.j.a sRZ;
    a sSa;
    a sSb;
    private TextView sSc;

    static class a extends View {
        public a(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(-1, 1));
        }
    }

    static /* synthetic */ void a(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FMessageListView", "updateLbs, id is null");
            return;
        }
        long j;
        try {
            j = bg.getLong(str, 0);
        } catch (Exception e) {
            w.e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            w.e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            return;
        }
        w.d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = " + j);
        c hVar = new h();
        if (!l.Kz().b(j, hVar)) {
            w.e("MicroMsg.FMessageListView", "updateLbs, get fail, id = " + j);
        } else if (fMessageListView.sRR == null || !fMessageListView.sRR.fJL.equals(hVar.field_sayhiuser)) {
            w.d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
        } else {
            if (fMessageListView.sRR.osP != null && fMessageListView.sRR.osP.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, hVar));
        }
    }

    static /* synthetic */ void b(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            return;
        }
        long j;
        try {
            j = bg.getLong(str, 0);
        } catch (Exception e) {
            w.e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            w.e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            return;
        }
        w.d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = " + j);
        c fVar = new f();
        if (!l.Kx().b(j, fVar)) {
            w.e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = " + j);
        } else if (fMessageListView.sRR == null || !fMessageListView.sRR.fJL.equals(fVar.field_talker)) {
            w.d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
        } else {
            if (fMessageListView.sRR.osP != null && fMessageListView.sRR.osP.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, fVar));
        }
    }

    static /* synthetic */ void c(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FMessageListView", "updateShake, id is null");
            return;
        }
        long j;
        try {
            j = bg.getLong(str, 0);
        } catch (Exception e) {
            w.e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            w.e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            return;
        }
        w.d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = " + j);
        c jVar = new j();
        if (!l.KA().b(j, jVar)) {
            w.e("MicroMsg.FMessageListView", "updateShake, get fail, id = " + j);
        } else if (fMessageListView.sRR == null || !fMessageListView.sRR.fJL.equals(jVar.field_sayhiuser)) {
            w.d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
        } else {
            if (fMessageListView.sRR.osP != null && fMessageListView.sRR.osP.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, jVar));
        }
    }

    public FMessageListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.sRX = new com.tencent.mm.pluginsdk.e.a(this) {
            final /* synthetic */ FMessageListView sSd;

            {
                this.sSd = r1;
            }

            public final void j(b bVar) {
                if (bVar instanceof id) {
                    FMessageListView.a(this.sSd, ((id) bVar).fNH.fDz);
                }
            }
        };
        this.sRY = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ FMessageListView sSd;

            {
                this.sSd = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                FMessageListView.b(this.sSd, str);
            }
        };
        this.sRZ = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ FMessageListView sSd;

            {
                this.sSd = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                FMessageListView.c(this.sSd, str);
            }
        };
        this.mBJ = new LayoutParams(-1, -2);
        this.context = context;
        l.Kx().c(this.sRY);
        com.tencent.mm.pluginsdk.e.a.a(id.class.getName(), this.sRX);
        l.KA().c(this.sRZ);
    }

    public final void detach() {
        l.Kx().f(this.sRY);
        com.tencent.mm.pluginsdk.e.a.b(id.class.getName(), this.sRX);
        l.KA().f(this.sRZ);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                a aVar = (a) childAt;
                ap.vd().b(30, aVar);
                if (aVar.irJ != null && aVar.irJ.isShowing()) {
                    aVar.irJ.dismiss();
                }
            }
        }
        this.sSa = null;
        this.sSb = null;
    }

    public final void a(final b bVar) {
        if (bVar == null) {
            w.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
        } else if (bVar.id <= 0) {
            w.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + bVar.id);
        } else {
            int i;
            String string;
            int childCount = getChildCount();
            for (i = 1; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(bVar.id))) {
                    w.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + bVar.id);
                    return;
                }
            }
            if (bVar.sSg != null) {
                if (this.sSc == null) {
                    this.sSc = (TextView) findViewById(R.h.bFg);
                }
                this.sSc.setText(bVar.sSg);
                this.sSc.setVisibility(0);
            }
            w.d("MicroMsg.FMessageListView", "addItem, current child count = " + childCount);
            if (childCount == 6) {
                w.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                w.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.sSa = new a(this.context);
                addView(this.sSa);
                this.sSb = new a(this.context);
                this.sSb.Ne("");
                this.sSb.xO(0);
                addView(this.sSb, this.mBJ);
                ap.yY();
                af Rc = com.tencent.mm.u.c.wR().Rc(bVar.username);
                if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                    w.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + bVar.username);
                    this.sSa.setVisibility(0);
                    this.sSb.setVisibility(0);
                } else {
                    w.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + bVar.username);
                    this.sSa.setVisibility(8);
                    this.sSb.setVisibility(8);
                }
            }
            if (bVar.fZK) {
                string = this.context.getString(R.l.elc, new Object[]{bVar.hku});
                i = 0;
            } else {
                String str;
                if (bVar.fFa == null || bVar.fFa.length() <= 0) {
                    str = bVar.username;
                    ap.yY();
                    com.tencent.mm.j.a Rc2 = com.tencent.mm.u.c.wR().Rc(bVar.username);
                    if (Rc2 != null && ((int) Rc2.gTQ) > 0) {
                        str = Rc2.tL();
                    }
                } else {
                    str = bVar.fFa;
                }
                string = str + ": " + bVar.hku;
                i = 1;
            }
            View aVar = new a(this.context);
            aVar.setTag(Long.valueOf(bVar.id));
            aVar.Ne(string);
            aVar.xO(8);
            if (i != 0) {
                aVar.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ FMessageListView sSd;

                    public final boolean onLongClick(View view) {
                        w.d("MicroMsg.FMessageListView", "jacks long click digest");
                        g.a(this.sSd.getContext(), null, new String[]{this.sSd.getContext().getString(R.l.dTn)}, new g.c(this) {
                            final /* synthetic */ AnonymousClass4 sSf;

                            {
                                this.sSf = r1;
                            }

                            public final void hq(int i) {
                                switch (i) {
                                    case 0:
                                        ((ClipboardManager) this.sSf.sSd.getContext().getSystemService("clipboard")).setText(bVar.hku);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                });
            }
            addView(aVar, getChildCount() - 2, this.mBJ);
        }
    }
}
