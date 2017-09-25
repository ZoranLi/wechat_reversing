package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class e extends BaseAdapter {
    String arH = "";
    byte[] buffer = null;
    private Context context = null;
    boolean kgf = false;
    String lJr = "";
    boolean nhA = false;
    List<f> nhM = new ArrayList();
    int nhN = 0;
    boolean nhO = false;

    static class a {
        TextView jlj;
        TextView nhP;
        ImageView nhQ;
        View nhR;
        View nhS;
        TextView titleView;
    }

    public final /* synthetic */ Object getItem(int i) {
        return oJ(i);
    }

    public e(Context context) {
        this.context = context;
    }

    public final void clean() {
        this.buffer = null;
        this.kgf = false;
        this.arH = "";
        this.nhM.clear();
    }

    public final void zF(String str) {
        this.arH = str;
        w.i("MicroMsg.PoiAdapter", "initdata key %s", new Object[]{str});
    }

    public final void b(f fVar) {
        if (this.nhM.size() >= 0) {
            this.nhM.add(0, fVar);
            notifyDataSetChanged();
        }
    }

    public final void a(List<f> list, byte[] bArr, boolean z, String str) {
        if (this.arH == null || !this.arH.equals(str)) {
            w.i("MicroMsg.PoiAdapter", "old key come pass it %s %s", new Object[]{this.arH, str});
            return;
        }
        for (f add : list) {
            this.nhM.add(add);
        }
        this.buffer = bArr;
        this.kgf = z;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.nhM.size();
    }

    public final f oJ(int i) {
        return (f) this.nhM.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.i.dkJ, null);
            aVar = new a();
            aVar.titleView = (TextView) view.findViewById(R.h.title);
            aVar.nhP = (TextView) view.findViewById(R.h.subtitle);
            aVar.nhQ = (ImageView) view.findViewById(R.h.cIK);
            aVar.nhS = view.findViewById(R.h.bNr);
            aVar.nhR = view.findViewById(R.h.bXE);
            aVar.jlj = (TextView) view.findViewById(R.h.cIF);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (((f) this.nhM.get(i)).type == 1 || ((f) this.nhM.get(i)).type == 2) {
            aVar.nhS.setVisibility(0);
            aVar.nhR.setVisibility(8);
            aVar.jlj.setText(bg.ap(((f) this.nhM.get(i)).nhT, ""));
        } else {
            aVar.nhS.setVisibility(8);
            aVar.nhR.setVisibility(0);
        }
        if (i != 0 || this.nhO) {
            CharSequence zG;
            CharSequence zG2;
            f fVar = (f) this.nhM.get(i);
            String ap = bg.ap(fVar.mName, "");
            String ap2 = bg.ap(fVar.nhT, "");
            if (!this.nhO || bg.mA(this.lJr)) {
                Object obj = ap;
                Object obj2 = ap2;
            } else {
                zG = zG(ap);
                zG2 = zG(ap2);
            }
            aVar.titleView.setText(zG);
            aVar.nhP.setText(zG2);
            aVar.nhP.setVisibility(0);
        } else if (this.nhA) {
            aVar.titleView.setText(bg.ap(((f) this.nhM.get(0)).mName, ""));
            aVar.nhP.setVisibility(0);
            aVar.nhP.setText(bg.ap(((f) this.nhM.get(0)).nhT, ""));
        } else {
            aVar.nhP.setVisibility(8);
            if (!bg.mA(((f) this.nhM.get(0)).nhT)) {
                aVar.titleView.setText(bg.ap(((f) this.nhM.get(i)).nhT, ""));
            } else if (bg.mA(((f) this.nhM.get(0)).nic)) {
                aVar.titleView.setText(bg.ap(((f) this.nhM.get(i)).mName, ""));
            } else {
                aVar.titleView.setText(bg.ap(((f) this.nhM.get(i)).nic, ""));
            }
        }
        if (i == this.nhN) {
            aVar.nhQ.setVisibility(0);
        } else {
            aVar.nhQ.setVisibility(4);
        }
        return view;
    }

    private Spannable zG(String str) {
        return d.a(str, this.lJr);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        w.i("MicroMsg.PoiAdapter", "map notifyDataChange " + bg.bJZ().toString() + " threadId : " + Thread.currentThread().getId());
    }
}
