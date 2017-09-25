package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.b;
import java.util.List;

public final class e extends ArrayAdapter<com.tencent.mm.storage.a.a> {
    private static final int kId = R.i.dax;
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private int kIe;
    public List<com.tencent.mm.storage.a.a> kIf;
    private Context mContext;

    class a {
        TextView ipw;
        ImageView jbU;
        View kIg;
        ImageView kIh;
        final /* synthetic */ e kIi;

        public a(e eVar, View view) {
            this.kIi = eVar;
            this.kIh = (ImageView) view.findViewById(R.h.bLA);
            this.jbU = (ImageView) view.findViewById(R.h.bLy);
            this.ipw = (TextView) view.findViewById(R.h.bLz);
            this.kIg = view.findViewById(R.h.bLk);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = eVar.kIe;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public e(Context context, List<com.tencent.mm.storage.a.a> list) {
        super(context, kId, list);
        this.kIe = context.getResources().getDimensionPixelSize(R.f.aZE);
        this.mContext = context;
        this.kIf = list;
    }

    public final void alp() {
        if (this.kIf != null) {
            int size = this.kIf.size();
            for (int i = 0; i < size; i++) {
                ((com.tencent.mm.storage.a.a) this.kIf.get(i)).field_idx = i;
            }
            h.amc().kLb.cn(this.kIf);
            c aP = h.amc().kLb.aP(com.tencent.mm.storage.a.a.uKR, false);
            aP.field_sort = this.kIf.size() + 2;
            b bVar = h.amc().kLb;
            if (!b.bNg()) {
                bVar = h.amc().kLb;
                if (aP != null) {
                    w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[]{aP.field_packName, Long.valueOf(aP.field_lastUseTime), Integer.valueOf(aP.field_sort)});
                    bVar.a(aP);
                    bVar.a("event_update_group", 0, bg.bJZ().toString());
                }
            }
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(kId, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.storage.a.a aVar3 = (com.tencent.mm.storage.a.a) getItem(i);
        if (com.tencent.mm.plugin.emoji.h.a.b(aVar3)) {
            aVar.ipw.setText(R.l.edU);
        } else {
            aVar.ipw.setText(aVar3.field_packName);
        }
        if (com.tencent.mm.plugin.emoji.h.a.b(aVar3)) {
            aVar.jbU.setImageResource(R.g.bfN);
        } else {
            n.GW().a(aVar3.field_packIconUrl, aVar.jbU, f.bL(aVar3.field_productID, aVar3.field_packIconUrl));
        }
        if (i + 1 == getCount()) {
            aVar.kIg.setBackgroundResource(R.g.bep);
        }
        view.setVisibility(0);
        return view;
    }
}
