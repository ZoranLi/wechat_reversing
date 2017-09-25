package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;

public final class h extends BaseAdapter {
    private f kTE;
    private Context mContext;
    ArrayList<com.tencent.mm.storage.a.a> mData = new ArrayList();

    class a {
        ImageView fKf;
        final /* synthetic */ h kWg;

        public a(h hVar, View view) {
            this.kWg = hVar;
            this.fKf = (ImageView) view.findViewById(R.h.cFJ);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return lE(i);
    }

    public h(Context context, f fVar) {
        this.mContext = context;
        this.kTE = fVar;
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public final com.tencent.mm.storage.a.a lE(int i) {
        if (this.mData == null || this.mData.isEmpty() || this.mData.size() < i) {
            return null;
        }
        return (com.tencent.mm.storage.a.a) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.doI, null);
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.storage.a.a lE = lE(i);
        if (lE == null) {
            aVar.fKf.setVisibility(8);
            aVar.fKf.setTag("");
            w.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "emoji group info is null. position:%d", new Object[]{Integer.valueOf(i)});
        } else {
            aVar.fKf.setVisibility(0);
        }
        com.tencent.mm.ah.a.a.c.a aVar2;
        if ("TAG_DEFAULT_TAB".equals(lE.field_productID)) {
            aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIJ = true;
            aVar2.hIQ = 4;
            aVar2.hJe = R.g.bcW;
            aVar2.hIR = this.kTE.kUL;
            aVar2.hIR = this.kTE.kUL;
            n.GW().a(R.k.dwH, aVar.fKf, aVar2.Hg());
            aVar.fKf.setContentDescription(this.mContext.getString(R.l.eej));
        } else if (String.valueOf(com.tencent.mm.storage.a.a.uKR).equals(lE.field_productID)) {
            aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIJ = true;
            aVar2.hIQ = 4;
            aVar2.hJe = R.g.bcW;
            aVar2.hIR = this.kTE.kUL;
            aVar2.hIR = this.kTE.kUL;
            n.GW().a(R.k.dwG, aVar.fKf, aVar2.Hg());
            aVar.fKf.setContentDescription(this.mContext.getString(R.l.eer));
        } else if (String.valueOf(com.tencent.mm.storage.a.a.uKQ).equals(lE.field_productID)) {
            aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIJ = true;
            aVar2.hIQ = 4;
            aVar2.hJe = R.g.bcW;
            aVar2.hIR = this.kTE.kUL;
            aVar2.hIR = this.kTE.kUL;
            n.GW().a(R.g.beU, aVar.fKf, aVar2.Hg());
            aVar.fKf.setContentDescription(this.mContext.getString(R.l.edU));
        } else if ("TAG_STORE_MANEGER_TAB".equals(lE.field_productID)) {
            aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIJ = true;
            aVar2.hIQ = 4;
            aVar2.hJe = R.g.bcW;
            aVar2.hIR = this.kTE.kUL;
            aVar2.hIR = this.kTE.kUL;
            n.GW().a(R.k.dwI, aVar.fKf, aVar2.Hg());
            aVar.fKf.setContentDescription(this.mContext.getString(R.l.eSu));
        } else {
            String stringBuilder;
            if (f.a(lE)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                ap.yY();
                stringBuilder = stringBuilder2.append(EmojiLogic.C(c.xi(), lE.field_productID, "")).append("_panel_enable").toString();
                com.tencent.mm.ah.a.a.c.a aVar3 = new com.tencent.mm.ah.a.a.c.a();
                aVar3.hIN = stringBuilder;
                aVar3.hIJ = true;
                aVar3.hJe = R.g.bcW;
                aVar3.hIQ = 1;
                aVar3.hIR = this.kTE.kUL;
                aVar3.hIR = this.kTE.kUL;
                n.GW().a(stringBuilder, aVar.fKf, aVar3.Hg());
            } else {
                stringBuilder = lE.field_packGrayIconUrl;
                ap.yY();
                String C = EmojiLogic.C(c.xi(), lE.field_productID, stringBuilder);
                com.tencent.mm.ah.a.a.c.a aVar4 = new com.tencent.mm.ah.a.a.c.a();
                aVar4.hIN = C;
                aVar4.hIJ = true;
                aVar4.hIL = true;
                aVar4.hJe = R.g.bcW;
                aVar4.hIU = true;
                aVar4.hIR = this.kTE.kUL;
                aVar4.hIR = this.kTE.kUL;
                com.tencent.mm.ah.a.a.c Hg = aVar4.Hg();
                if (bg.mA(stringBuilder)) {
                    n.GW().a("", aVar.fKf, Hg);
                    w.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "empty url.");
                } else {
                    n.GW().a(stringBuilder, aVar.fKf, Hg);
                }
            }
            if (bg.mA(lE.field_packName)) {
                aVar.fKf.setContentDescription(this.mContext.getString(R.l.edO));
            } else {
                aVar.fKf.setContentDescription(lE.field_packName);
            }
        }
        aVar.fKf.setBackgroundResource(R.g.bcW);
        aVar.fKf.setPadding(this.kTE.kUM, this.kTE.kUM, this.kTE.kUM, this.kTE.kUM);
        if (i == this.kTE.aom()) {
            aVar.fKf.setSelected(true);
        } else {
            aVar.fKf.setSelected(false);
        }
        return view;
    }
}
