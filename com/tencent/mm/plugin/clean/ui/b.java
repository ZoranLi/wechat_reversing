package com.tencent.mm.plugin.clean.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.gridviewheaders.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends BaseAdapter implements e {
    private static int kyY = 0;
    HashSet<Integer> jEP;
    ArrayList<com.tencent.mm.plugin.clean.b.a> jjQ;
    OnItemClickListener kbd = new OnItemClickListener(this) {
        final /* synthetic */ b kzd;

        {
            this.kzd = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            w.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.plugin.clean.b.a kR = this.kzd.kR(i);
            Intent intent = new Intent();
            switch (kR.type) {
                case 1:
                    intent.putExtra("key_title", this.kzd.kyX.getString(R.l.dWg));
                    intent.putExtra("show_menu", false);
                    intent.putExtra("key_image_path", kR.filePath);
                    d.a(this.kzd.kyX, ".ui.tools.ShowImageUI", intent);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(kR.filePath)), "video/*");
                    try {
                        this.kzd.kyX.startActivity(Intent.createChooser(intent, this.kzd.kyX.getString(R.l.fau)));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", kR.fEU);
                    d.a(this.kzd.kyX, ".ui.chatting.AppAttachDownloadUI", intent);
                    return;
                default:
                    return;
            }
        }
    };
    private CleanChattingDetailUI kyX;
    private boolean kyZ;
    c kza = new c(this) {
        final /* synthetic */ b kzd;

        {
            this.kzd = r1;
        }

        public final void ce(View view) {
            b.a(this.kzd, (a) view.getTag());
            this.kzd.notifyDataSetChanged();
        }
    };
    private ae kzb = new ae(this) {
        final /* synthetic */ b kzd;

        {
            this.kzd = r1;
        }

        public final void handleMessage(Message message) {
            if (!this.kzd.kyZ) {
                this.kzd.notifyDataSetChanged();
            }
        }
    };
    OnScrollListener kzc = new OnScrollListener(this) {
        final /* synthetic */ b kzd;

        {
            this.kzd = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            n.GW().bi(i);
            if (i != 2) {
                this.kzd.kyZ = false;
                this.kzd.kzb.removeCallbacksAndMessages(null);
                this.kzd.kzb.sendEmptyMessageDelayed(0, 200);
                return;
            }
            this.kzd.kyZ = true;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    class a {
        final /* synthetic */ b kzd;
        TextView kze;
        TextView kzf;
        CheckBox kzg;
        int position;

        a(b bVar) {
            this.kzd = bVar;
        }
    }

    class b {
        CheckBox ipy;
        final /* synthetic */ b kzd;
        MMImageView kzh;
        ImageView kzi;
        View kzj;
        View kzk;
        TextView kzl;

        b(b bVar) {
            this.kzd = bVar;
        }
    }

    static /* synthetic */ void a(b bVar, int i) {
        w.i("MicroMsg.CleanChattingDetailAdapter", "select position=%d", new Object[]{Integer.valueOf(i)});
        if (!bVar.jEP.remove(Integer.valueOf(i))) {
            bVar.jEP.add(Integer.valueOf(i));
        }
        bVar.ajT();
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        int i;
        w.i("MicroMsg.CleanChattingDetailAdapter", "select header position=%d | headerId=%d", new Object[]{Integer.valueOf(aVar.position), Long.valueOf(bVar.kS(aVar.position))});
        Collection hashSet = new HashSet();
        for (i = 0; i < bVar.jjQ.size(); i++) {
            if (((com.tencent.mm.plugin.clean.b.a) bVar.jjQ.get(i)).ajE() == r4) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        Iterator it = hashSet.iterator();
        i = 1;
        while (it.hasNext()) {
            i = !bVar.jEP.remove(Integer.valueOf(((Integer) it.next()).intValue())) ? 0 : i;
        }
        if (i == 0) {
            bVar.jEP.addAll(hashSet);
        }
        bVar.ajT();
    }

    public final /* synthetic */ Object getItem(int i) {
        return kR(i);
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, ArrayList<com.tencent.mm.plugin.clean.b.a> arrayList) {
        this.kyX = cleanChattingDetailUI;
        this.jjQ = arrayList;
        this.jEP = new HashSet();
    }

    public final int getCount() {
        return this.jjQ.size();
    }

    public final com.tencent.mm.plugin.clean.b.a kR(int i) {
        return (com.tencent.mm.plugin.clean.b.a) this.jjQ.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.kyX.getLayoutInflater().inflate(R.i.cYQ, viewGroup, false);
            b bVar2 = new b(this);
            bVar2.kzh = (MMImageView) view.findViewById(R.h.bGz);
            bVar2.ipy = (CheckBox) view.findViewById(R.h.cBH);
            bVar2.kzj = view.findViewById(R.h.cBJ);
            bVar2.kzk = view.findViewById(R.h.cCl);
            bVar2.kzi = (ImageView) view.findViewById(R.h.crL);
            bVar2.kzl = (TextView) view.findViewById(R.h.cmn);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.clean.b.a kR = kR(i);
        bVar.kzh.setTag(kR.filePath);
        bVar.kzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b kzd;

            public final void onClick(View view) {
                b.a(this.kzd, i);
                this.kzd.notifyDataSetChanged();
            }
        });
        if (this.jEP.contains(Integer.valueOf(i))) {
            bVar.ipy.setChecked(true);
            bVar.kzk.setVisibility(0);
        } else {
            bVar.ipy.setChecked(false);
            bVar.kzk.setVisibility(8);
        }
        if (kR.type == 3) {
            bVar.kzi.setVisibility(0);
        } else {
            bVar.kzi.setVisibility(8);
        }
        if (kR.type == 4) {
            bVar.kzh.setImageResource(q.LV(com.tencent.mm.a.e.aQ(kR.filePath)));
            bVar.kzl.setText(new File(kR.filePath).getName());
            bVar.kzl.setVisibility(0);
        } else {
            if (kyY == 0) {
                kyY = view.getMeasuredWidth();
            }
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIQ = 1;
            aVar.hIM = false;
            aVar.hIS = kyY;
            aVar.hIR = kyY;
            if (kR.type == 1) {
                aVar.hIN = kR.filePath;
                n.GW().a(kR.filePath, bVar.kzh, aVar.Hg());
            } else {
                aVar.hIN = kR.fKz;
                n.GW().a(kR.fKz, bVar.kzh, aVar.Hg());
            }
            bVar.kzl.setVisibility(8);
        }
        w.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return view;
    }

    public final long kS(int i) {
        return ((com.tencent.mm.plugin.clean.b.a) this.jjQ.get(i)).ajE();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            w.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.kyX.getLayoutInflater().inflate(R.i.cYR, viewGroup, false);
            aVar = new a(this);
            aVar.kze = (TextView) view.findViewById(R.h.bWg);
            aVar.kzf = (TextView) view.findViewById(R.h.bWe);
            aVar.kzg = (CheckBox) view.findViewById(R.h.bWd);
            view.setTag(aVar);
        } else {
            w.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.clean.b.a kR = kR(i);
        aVar.position = i;
        aVar.kze.setText(o.Z(this.kyX.getString(R.l.emg), kR.ian / 1000));
        long ajE = kR.ajE();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.jjQ.size(); i2++) {
            if (((com.tencent.mm.plugin.clean.b.a) this.jjQ.get(i2)).ajE() == ajE) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (this.jEP.contains(Integer.valueOf(((Integer) it.next()).intValue()))) {
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            aVar.kzg.setChecked(true);
        } else {
            aVar.kzg.setChecked(false);
        }
        return view;
    }

    final void ajT() {
        boolean z;
        this.kyX.kT(this.jEP.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.kyX;
        if (this.jEP.size() == this.jjQ.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cleanChattingDetailUI.jEX.setChecked(true);
        } else {
            cleanChattingDetailUI.jEX.setChecked(false);
        }
        Iterator it = this.jEP.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((com.tencent.mm.plugin.clean.b.a) this.jjQ.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.kyX;
        if (j > 0) {
            cleanChattingDetailUI2.kzp.setText(cleanChattingDetailUI2.getString(R.l.ebu, new Object[]{bg.ay(j)}));
            return;
        }
        cleanChattingDetailUI2.kzp.setText("");
    }

    public final void ajS() {
        this.jEP.clear();
        ajT();
    }
}
