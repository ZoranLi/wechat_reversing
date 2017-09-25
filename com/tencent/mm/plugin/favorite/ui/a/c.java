package com.tencent.mm.plugin.favorite.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.protocal.c.sa;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c extends BaseAdapter implements com.tencent.mm.plugin.favorite.b.t.a, com.tencent.mm.ui.base.MMTagPanel.a {
    private Context context;
    private int lJn = R.e.aVo;
    private int lJo = R.g.bks;
    private Set<String> lJp = new HashSet();

    public static class a {
        TextView jZy;
        FavTagPanel lJq;
    }

    public abstract void wi(String str);

    public abstract void wj(String str);

    public /* synthetic */ Object getItem(int i) {
        return h.asT().mt(i);
    }

    public c(Context context) {
        this.context = context;
    }

    public int getCount() {
        h.asT();
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.dcE, null);
            a aVar2 = new a();
            aVar2.jZy = (TextView) view.findViewById(R.h.bOL);
            aVar2.lJq = (FavTagPanel) view.findViewById(R.h.bOV);
            aVar2.lJq.vmJ = this;
            aVar2.lJq.lJo = this.lJo;
            aVar2.lJq.lJn = this.lJn;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        FavTagPanel favTagPanel = aVar.lJq;
        Collection collection = this.lJp;
        List<sa> mt = h.asT().mt(i);
        if (mt == null || mt.isEmpty()) {
            boolean z;
            String str = "MicroMsg.FavTagPanel";
            String str2 = "setTagListByTagInfo,null == tags ?%B,";
            Object[] objArr = new Object[1];
            if (mt == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.e(str, str2, objArr);
        } else {
            w.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[]{Integer.valueOf(mt.size())});
            List linkedList = new LinkedList();
            for (sa saVar : mt) {
                linkedList.add(saVar.sgP);
            }
            favTagPanel.a(collection, linkedList);
        }
        return view;
    }

    public final void uO(String str) {
    }

    public final void uP(String str) {
    }

    public final void uQ(String str) {
    }

    public final void aoI() {
    }

    public final void wk(String str) {
        this.lJp.add(str);
        notifyDataSetChanged();
    }

    public final void wl(String str) {
        this.lJp.remove(str);
        notifyDataSetChanged();
    }

    public final void aw(List<String> list) {
        this.lJp.clear();
        if (list != null) {
            this.lJp.addAll(list);
        }
    }

    public final void uN(String str) {
        wk(str);
        wi(str);
    }

    public final void uM(String str) {
        wl(str);
        wj(str);
    }

    public final void ats() {
        w.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    public final void att() {
        w.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    public final void h(boolean z, int i) {
    }
}
