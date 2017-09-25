package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context context;
    List<k> dataList = new ArrayList();
    int mode;

    private class a {
        public ImageView ioV;
        public TextView ioW;
        public TextView ioX;
        public TextView ioY;
        public TextView ioZ;
        public TextView ipa;
        final /* synthetic */ b ipb;

        public a(b bVar, View view) {
            this.ipb = bVar;
            this.ioV = (ImageView) view.findViewById(R.h.bmn);
            this.ioW = (TextView) view.findViewById(R.h.bmo);
            this.ioX = (TextView) view.findViewById(R.h.bmr);
            this.ioY = (TextView) view.findViewById(R.h.bmp);
            this.ioZ = (TextView) view.findViewById(R.h.bmm);
            this.ipa = (TextView) view.findViewById(R.h.bmq);
        }
    }

    public b(Context context, int i) {
        this.context = context;
        this.mode = i;
    }

    public final int getCount() {
        return this.dataList.size();
    }

    public final Object getItem(int i) {
        return this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = r.eC(this.context).inflate(R.i.cTu, viewGroup, false);
            view.setTag(new a(this, view));
        }
        a aVar = (a) view.getTag();
        k kVar = (k) getItem(i);
        aVar.ioV.setImageResource(R.k.dsG);
        com.tencent.mm.pluginsdk.ui.a.b.g(aVar.ioV, kVar.tbi, R.k.dsG);
        aVar.ioX.setText(h.b(this.context, kVar.title, aVar.ioX.getTextSize()));
        CharSequence eK = n.eK(kVar.tbi);
        if (bg.mA(eK) || eK.endsWith("@chatroom")) {
            eK = this.context.getString(R.l.dVr);
        }
        aVar.ioW.setText(h.b(this.context, eK, aVar.ioW.getTextSize()));
        if (this.mode == 2) {
            aVar.ioY.setText(kVar.tbu);
        } else {
            aVar.ioY.setText(kVar.tbr);
        }
        aVar.ioZ.setText(String.format("%s%s", new Object[]{Float.valueOf(((float) kVar.fZT) / 100.0f), this.context.getString(R.l.dBE)}));
        aVar.ipa.setVisibility(0);
        if (this.mode != 2) {
            switch (kVar.state) {
                case 1:
                    aVar.ipa.setText(R.l.dBh);
                    aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aSz));
                    break;
                case 2:
                    aVar.ipa.setText(R.l.dBf);
                    aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aSz));
                    break;
                case 3:
                    aVar.ipa.setText(R.l.dBd);
                    aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aVD));
                    break;
                case 4:
                    aVar.ipa.setText(R.l.dBe);
                    aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aVD));
                    break;
                default:
                    aVar.ipa.setVisibility(4);
                    break;
            }
        }
        switch (kVar.state) {
            case 1:
                aVar.ipa.setText(R.l.dBi);
                aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aSz));
                break;
            case 2:
                aVar.ipa.setText(R.l.dBg);
                aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aSz));
                break;
            default:
                aVar.ipa.setVisibility(4);
                break;
        }
        return view;
    }

    public final void Oa() {
        this.dataList.clear();
    }
}
