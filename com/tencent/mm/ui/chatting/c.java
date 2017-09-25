package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

final class c extends BaseAdapter {
    private Context context;
    private com.tencent.mm.ah.a.a.c lir;
    private List<dj> vyd;
    boolean vye = false;

    public final /* synthetic */ Object getItem(int i) {
        return AI(i);
    }

    public c(Context context) {
        this.context = context;
        this.vyd = new ArrayList();
        a aVar = new a();
        aVar.hJa = R.g.bhr;
        this.lir = aVar.Hg();
        ao(null);
    }

    public final void ao(List<dj> list) {
        List list2;
        dj djVar;
        this.vyd.clear();
        if (!(list == null || list.size() == 0)) {
            this.vyd.addAll(list);
        }
        if (this.vye) {
            list2 = this.vyd;
            djVar = new dj();
            djVar.rqp = R.g.bjv;
            djVar.gMX = this.context.getString(R.l.dVC);
            list2.add(djVar);
        }
        list2 = this.vyd;
        djVar = new dj();
        djVar.rqp = R.g.bju;
        djVar.gMX = this.context.getString(R.l.eUr);
        list2.add(djVar);
        w.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", Integer.valueOf(this.vyd.size()));
    }

    public final int getCount() {
        return this.vyd.size();
    }

    private dj AI(int i) {
        return (dj) this.vyd.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        eq eqVar;
        dj AI = AI(i);
        if (view == null) {
            eq eqVar2 = new eq();
            view = View.inflate(viewGroup.getContext(), R.i.dnP, null);
            eqVar2.llw = view.findViewById(R.h.bGr);
            eqVar2.kzl = (TextView) view.findViewById(R.h.cml);
            eqVar2.jbU = (ImageView) view.findViewById(R.h.bWv);
            eqVar2.vHs = (TextView) view.findViewById(R.h.cCu);
            eqVar2.vOJ = (SendDataToDeviceProgressBar) view.findViewById(R.h.cCt);
            eqVar2.vOJ.setVisibility(4);
            view.setTag(eqVar2);
            eqVar = eqVar2;
        } else {
            eqVar = (eq) view.getTag();
        }
        eqVar.kzl.setText(AI.gMX);
        w.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", Integer.valueOf(i), AI.gMX);
        if (AI.rqp != 0) {
            eqVar.jbU.setImageResource(AI.rqp);
        } else {
            Bitmap b = g.b(AI.appId, 1, com.tencent.mm.bg.a.getDensity(this.context));
            if (b == null || b.isRecycled()) {
                n.GW().a(AI.iconUrl, eqVar.jbU, this.lir);
            } else {
                eqVar.jbU.setImageBitmap(b);
            }
        }
        eqVar.llw.setTag(Integer.valueOf(i));
        return view;
    }
}
