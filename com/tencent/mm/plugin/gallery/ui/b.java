package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    private Context mContext;
    private int meY;
    ArrayList<AlbumItem> mgB;
    AlbumItem mgC;
    String mgD = "";
    private int mgE = 0;

    private static class a {
        public TextView ipx;
        public ImageView lNl;
        public ImageView mfz;
        public TextView mgF;
        public ImageView mgG;
    }

    public final /* synthetic */ Object getItem(int i) {
        return nj(i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.mgB = new ArrayList();
        this.meY = i;
        this.mgC = new AlbumItem("", 0);
        this.mgC.meD = new ImageMediaItem();
        this.mgE = context.getResources().getDimensionPixelSize(R.f.aXR);
    }

    public final int getCount() {
        return this.mgB.size() + 1;
    }

    public final AlbumItem nj(int i) {
        if (i == 0) {
            return this.mgC;
        }
        return (AlbumItem) this.mgB.get(i - 1);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        w.i("MicroMsg.GalleryAdapter", "duanyi test getview:" + i);
        AlbumItem nj = nj(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.dnf, viewGroup, false);
            a aVar2 = new a();
            aVar2.mfz = (ImageView) view.findViewById(R.h.bQP);
            aVar2.ipx = (TextView) view.findViewById(R.h.bQM);
            aVar2.lNl = (ImageView) view.findViewById(R.h.cLU);
            aVar2.mgF = (TextView) view.findViewById(R.h.bQL);
            aVar2.mgG = (ImageView) view.findViewById(R.h.bQO);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.mgD.equals(nj.meC)) {
            aVar.mgG.setVisibility(0);
        } else {
            aVar.mgG.setVisibility(4);
        }
        if (i == 0) {
            aVar.mfz.setImageResource(R.g.bir);
            if (nj.meD != null) {
                h.a(aVar.mfz, nj.meD.getType(), nj.ayB(), nj.meD.hTf, nj.ayC());
            }
            if (c.ayk().ayN() == 1) {
                aVar.ipx.setText(R.l.ent);
            } else if (c.ayk().ayN() == 3) {
                aVar.ipx.setText(R.l.enu);
            } else {
                aVar.ipx.setText(R.l.env);
            }
            aVar.mfz.setVisibility(0);
            aVar.ipx.setVisibility(0);
            aVar.mgF.setVisibility(8);
        } else {
            aVar.mfz.setVisibility(0);
            aVar.ipx.setVisibility(0);
            aVar.ipx.setText(nj.meC);
            aVar.mgF.setVisibility(0);
            aVar.mgF.setText(this.mContext.getString(R.l.enC, new Object[]{Integer.valueOf(nj.fIM)}));
            if (!(aVar.lNl == null || nj.meD == null)) {
                aVar.lNl.setVisibility(nj.meD.getType() == 2 ? 0 : 8);
            }
            String ayB = nj.ayB();
            if (!bg.mA(ayB) && nj.meD != null) {
                h.a(aVar.mfz, nj.meD.getType(), ayB, nj.meD.hTf, nj.ayC());
            } else if (nj.meD == null || nj.meD.getType() != 2) {
                w.e("MicroMsg.GalleryAdapter", "get folder failed");
                aVar.mfz.setVisibility(8);
                aVar.ipx.setVisibility(8);
            } else {
                h.a(aVar.mfz, nj.meD.getType(), null, nj.meD.hTf, nj.ayC());
            }
        }
        return view;
    }
}
