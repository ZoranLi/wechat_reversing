package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;

public final class f extends BaseAdapter {
    private static final String mpe = (com.tencent.mm.loader.stub.a.hgu + "Game/HvMenu/");
    private Context mContext;
    l qJh;

    public class a {
        TextView iUO;
        ImageView jki;
        final /* synthetic */ f sjx;

        public a(f fVar, View view) {
            this.sjx = fVar;
            this.iUO = (TextView) view.findViewById(R.h.title);
            this.jki = (ImageView) view.findViewById(R.h.icon);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return (m) this.qJh.vla.get(i);
    }

    public f(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.qJh == null ? 0 : this.qJh.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.deT, viewGroup, false);
        a aVar = new a(this, inflate);
        m mVar = (m) this.qJh.vla.get(i);
        if (!(mVar == null || mVar.getItemId() == -1)) {
            String charSequence = mVar.getTitle().toString();
            if (!bg.mA(charSequence)) {
                String[] split = charSequence.split("__", 2);
                if (split.length == 1) {
                    aVar.iUO.setText(split[0]);
                } else {
                    aVar.iUO.setText(split[0]);
                    charSequence = split[1];
                    if (charSequence.startsWith("http")) {
                        String str = mpe + g.n(charSequence.getBytes());
                        com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
                        aVar2.hIL = true;
                        aVar2.hIN = str;
                        com.tencent.mm.ah.a.a.Hd().a(charSequence, aVar.jki, aVar2.Hg());
                    } else {
                        aVar.jki.setImageResource(ab.getResources().getIdentifier(charSequence, "drawable", ab.getPackageName()));
                    }
                }
                inflate.setTag(mVar);
                return inflate;
            }
        }
        inflate.setTag(null);
        return inflate;
    }
}
