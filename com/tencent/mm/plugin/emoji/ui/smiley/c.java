package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.c.d;
import com.tencent.mm.ah.a.c.e;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.r;
import java.util.ArrayList;

public final class c extends a {
    private d kQa = new d(this) {
        final /* synthetic */ c kTt;

        {
            this.kTt = r1;
        }

        public final byte[] e(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof com.tencent.mm.storage.a.c)) {
                    return ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g((com.tencent.mm.storage.a.c) obj);
                }
            }
            return null;
        }
    };
    ArrayList<com.tencent.mm.storage.a.c> kRX;
    private e kTs = new e(this) {
        final /* synthetic */ c kTt;

        {
            this.kTt = r1;
        }

        public final void d(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof com.tencent.mm.storage.a.c)) {
                    b ciVar = new ci();
                    ciVar.fFN.scene = 1;
                    ciVar.fFN.fFO = (com.tencent.mm.storage.a.c) obj;
                    ciVar.fFN.context = this.kTt.mContext;
                    com.tencent.mm.sdk.b.a.urY.m(ciVar);
                }
            }
        }
    };

    class a {
        TextView ipx;
        ImageView jbU;
        final /* synthetic */ c kTt;
        TextView kTu;

        public a(c cVar, View view) {
            this.kTt = cVar;
            this.jbU = (ImageView) view.findViewById(R.h.bqm);
            this.ipx = (TextView) view.findViewById(R.h.bqn);
            this.kTu = (TextView) view.findViewById(R.h.bqo);
            this.kTu.setTextSize(1, 12.0f);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ls(i);
    }

    public c(Context context, f fVar) {
        super(context, fVar);
    }

    public final int getCount() {
        if (this.kTn != this.kTm - 1) {
            return this.kTl;
        }
        int i = this.jZR - (this.kTn * this.kTl);
        if (i < 0) {
            return 0;
        }
        return i;
    }

    private com.tencent.mm.storage.a.c ls(int i) {
        int i2 = (this.kTn * this.kTl) + i;
        if (this.kTk == 25 && this.kTj.hPi != ChatFooterPanel.sID) {
            i2--;
        }
        if (this.kRX == null || i2 < 0 || i2 >= this.kRX.size()) {
            return null;
        }
        return (com.tencent.mm.storage.a.c) this.kRX.get(i2);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = r.eC(this.mContext).inflate(R.i.doG, null);
            view.setLayoutParams(new LayoutParams(this.kTj.getColumnWidth(), this.kTj.kUN));
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.kTk == 25 && this.kTn == 0 && i == 0 && this.kTj.hPi != ChatFooterPanel.sID) {
            com.tencent.mm.plugin.emoji.model.h.alV().a("", aVar.jbU);
            aVar.jbU.setBackgroundResource(R.g.bcf);
            aVar.jbU.setImageResource(R.k.dtV);
            aVar.jbU.setContentDescription(view.getContext().getString(R.l.eSu));
            if (com.tencent.mm.plugin.emoji.model.h.amc().kLa.jZ(false) <= n.alO()) {
                ap.yY();
                if (com.tencent.mm.u.c.isSDCardAvailable()) {
                    aVar.kTu.setVisibility(8);
                }
            }
            aVar.kTu.setVisibility(0);
            aVar.kTu.setText(R.l.ecM);
        } else {
            aVar.kTu.setVisibility(8);
            com.tencent.mm.storage.a.c ls = ls(i);
            if (ls == null) {
                w.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
                aVar.jbU.setVisibility(8);
                aVar.ipx.setVisibility(8);
                com.tencent.mm.plugin.emoji.model.h.alV().a("", aVar.jbU);
            } else {
                aVar.jbU.setVisibility(0);
                CharSequence ue = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ue(ls.EP());
                if (bg.mA(ue) || this.kTk != 23) {
                    aVar.ipx.setVisibility(8);
                } else {
                    aVar.ipx.setText(ue);
                    aVar.ipx.setVisibility(0);
                }
                aVar.jbU.setBackgroundResource(R.g.bkd);
                String name;
                com.tencent.mm.ah.a.a alV;
                com.tencent.mm.ah.a.a.c.a aVar3;
                String eN;
                if (this.kTk == 25) {
                    if (ls.field_catalog == com.tencent.mm.storage.a.a.uKR || ls.field_catalog == com.tencent.mm.storage.a.c.uKX || ls.field_catalog == com.tencent.mm.storage.a.c.uKW) {
                        name = ls.getName();
                        if (bg.mA(name)) {
                            w.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                        } else {
                            name = name.replaceAll(".png", "");
                            alV = com.tencent.mm.plugin.emoji.model.h.alV();
                            ImageView imageView = aVar.jbU;
                            aVar3 = new com.tencent.mm.ah.a.a.c.a();
                            aVar3.hIQ = 3;
                            aVar3.hJe = R.g.bkd;
                            alV.a(name, imageView, aVar3.Hg());
                            if (name.equalsIgnoreCase("dice")) {
                                aVar.jbU.setContentDescription(view.getContext().getString(R.l.ecC));
                            } else if (name.equalsIgnoreCase("jsb")) {
                                aVar.jbU.setContentDescription(view.getContext().getString(R.l.ecF));
                            }
                        }
                    } else {
                        eN = ls.eN(ls.field_groupId, ls.EP());
                        name = eN + "_cover";
                        aVar3 = new com.tencent.mm.ah.a.a.c.a();
                        aVar3.hIQ = 1;
                        aVar3.hJe = R.g.bkd;
                        aVar3.hIX = true;
                        aVar3.fKz = name;
                        aVar3.hIN = eN;
                        aVar3.hIY = true;
                        aVar3.hJm = new Object[]{ls};
                        com.tencent.mm.plugin.emoji.model.h.alV().a(eN, aVar.jbU, aVar3.Hg(), this.kTs, this.kQa);
                    }
                } else if (!ls.field_groupId.equalsIgnoreCase(String.valueOf(com.tencent.mm.storage.a.a.uKQ))) {
                    eN = ls.eN(ls.field_groupId, ls.EP());
                    name = eN + "_cover";
                    aVar3 = new com.tencent.mm.ah.a.a.c.a();
                    aVar3.hIQ = 1;
                    aVar3.hJe = R.g.bkd;
                    aVar3.hIX = true;
                    aVar3.fKz = name;
                    aVar3.hIN = eN;
                    aVar3.hIY = true;
                    aVar3.hJm = new Object[]{ls};
                    com.tencent.mm.plugin.emoji.model.h.alV().a(eN, aVar.jbU, aVar3.Hg(), this.kTs, this.kQa);
                } else if (bg.mA(ls.getName())) {
                    w.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                } else {
                    name = (bg.mA(ls.pM()) ? ls.getName() : ls.pM()).replaceAll(".png", "");
                    alV = com.tencent.mm.plugin.emoji.model.h.alV();
                    ImageView imageView2 = aVar.jbU;
                    com.tencent.mm.ah.a.a.c.a aVar4 = new com.tencent.mm.ah.a.a.c.a();
                    aVar4.hIQ = 3;
                    aVar4.hJe = R.g.bkd;
                    alV.a(name, imageView2, aVar4.Hg());
                }
            }
        }
        return view;
    }
}
