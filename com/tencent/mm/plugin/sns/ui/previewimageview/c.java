package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends b {
    private int qOj;
    private boolean qOk;
    private boolean qOl;
    a qOm;
    private HashMap<String, Bitmap> qwB = new HashMap();
    boolean qwE;

    public interface a {
        void da(int i, int i2);

        void removeItem(int i);
    }

    private class b {
        public ImageView fKf;
        final /* synthetic */ c qOn;
        View view;

        public b(c cVar, View view) {
            this.qOn = cVar;
            this.view = view;
            this.fKf = (ImageView) view.findViewById(f.pCV);
        }
    }

    private class d {
        public Object data;
        public int id;
        final /* synthetic */ c qOn;

        public d(c cVar) {
            this.qOn = cVar;
        }

        public final String toString() {
            return this.data.toString();
        }

        public final int hashCode() {
            return this.id;
        }
    }

    class c extends h<String, Integer, Boolean> {
        private ImageView fMY;
        private Bitmap hqW;
        private String path;
        final /* synthetic */ c qOn;

        public final /* synthetic */ Object bed() {
            if (this.qOn.qwE) {
                return Boolean.valueOf(false);
            }
            this.hqW = com.tencent.mm.sdk.platformtools.d.d(this.path, ae.beS(), ae.beS(), true);
            w.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", new Object[]{this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree())});
            this.hqW = com.tencent.mm.sdk.platformtools.d.b(this.hqW, (float) r0);
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            if (!this.qOn.qwE && i.k(this.hqW)) {
                this.qOn.qwB.put(this.path, this.hqW);
                if (this.fMY.getTag() != null && (this.fMY.getTag() instanceof String) && this.fMY.getTag().equals(this.path)) {
                    this.fMY.setImageBitmap(this.hqW);
                }
            }
        }

        public c(c cVar, ImageView imageView, String str) {
            this.qOn = cVar;
            this.fMY = imageView;
            this.path = str;
        }

        public final com.tencent.mm.sdk.platformtools.ae bec() {
            return ae.bew();
        }
    }

    public c(Context context, List<?> list, int i, boolean z, a aVar) {
        super(context, 4);
        super.bE(bF(list));
        this.qOj = 9;
        this.qOk = z;
        this.qOm = aVar;
        blr();
        bls();
    }

    private List<d> bF(List<?> list) {
        List<d> arrayList = new ArrayList(list.size());
        int i = 0;
        for (Object next : list) {
            d dVar = new d(this);
            dVar.data = next;
            int i2 = i + 1;
            dVar.id = i;
            arrayList.add(dVar);
            i = i2;
        }
        return arrayList;
    }

    private void blr() {
        for (int i = 0; i < this.qOi; i++) {
            d dVar = new d(this);
            dVar.data = "";
            dVar.id = getCount();
            dVar.id = getCount();
            add(i, dVar);
        }
    }

    public final void bls() {
        w.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[]{Boolean.valueOf(this.qOk), Integer.valueOf(getCount()), Integer.valueOf(this.qOi), Integer.valueOf(this.qOj), Boolean.valueOf(this.qOl)});
        if (!this.qOk || blt() >= this.qOj) {
            this.qOl = false;
        } else if (!this.qOl) {
            this.qOl = true;
            add("");
        }
    }

    public final void clear() {
        super.clear();
        this.qOl = false;
    }

    public final void bE(List<?> list) {
        super.bE(bF(list));
        blr();
        bls();
    }

    public final int blt() {
        return (getCount() - this.qOi) - (this.qOl ? 1 : 0);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(g.pHV, viewGroup, false);
            b bVar2 = new b(this, view);
            view.setTag(f.pCR, bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag(f.pCR);
        }
        Object obj = getItem(i).toString();
        ImageView imageView = bVar.fKf;
        if (TextUtils.isEmpty(obj)) {
            imageView.setBackgroundColor(0);
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setBackgroundResource(e.pAj);
            imageView.setContentDescription(bVar.fKf.getContext().getString(j.pKq));
            if (i > 0) {
                bVar.view.setTag(Integer.valueOf(-1));
            } else if (i < bVar.qOn.qOi) {
                bVar.view.setTag(Integer.valueOf(Integer.MAX_VALUE));
            }
        } else {
            bVar.view.setTag(Integer.valueOf(i - bVar.qOn.qOi));
            imageView.setBackgroundDrawable(null);
            imageView.setTag(obj);
            imageView.setContentDescription(bVar.fKf.getContext().getString(j.pLn));
            Bitmap bitmap = (Bitmap) bVar.qOn.qwB.get(obj);
            if (i.k(bitmap)) {
                imageView.setImageBitmap(bitmap);
            } else {
                new c(bVar.qOn, imageView, obj).l("");
            }
        }
        if (i < this.qOi) {
            bVar.fKf.setVisibility(4);
        } else {
            bVar.fKf.setVisibility(0);
            view.setVisibility(0);
        }
        return view;
    }

    public final int getItemViewType(int i) {
        if (TextUtils.isEmpty(getItem(i).toString())) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean uj(int i) {
        if (i < this.qOi) {
            return false;
        }
        if (!this.qOl) {
            return super.uj(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final boolean uk(int i) {
        if (i < this.qOi) {
            return false;
        }
        if (!this.qOl) {
            return super.uk(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final void de(int i, int i2) {
        super.de(i, i2);
        if (this.qOm != null) {
            this.qOm.da(i - this.qOi, i2 - this.qOi);
        }
    }
}
