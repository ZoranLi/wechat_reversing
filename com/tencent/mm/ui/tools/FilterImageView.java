package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMHorList;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView extends LinearLayout {
    static c[] wmk = new c[]{new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private Activity fPi;
    int pQX = 0;
    int[] wmb;
    View wmc;
    ImageView wmd;
    CropImageView wme;
    Bitmap wmf;
    private MMHorList wmg;
    private a wmh;
    Runnable wmi;
    Runnable wmj;

    class a extends BaseAdapter {
        int nhN = 0;
        final /* synthetic */ FilterImageView wml;

        class a {
            TextView itE;
            ImageView wmm;
            Bitmap wmn;
            final /* synthetic */ a wmo;

            a(a aVar) {
                this.wmo = aVar;
            }
        }

        a(FilterImageView filterImageView) {
            this.wml = filterImageView;
        }

        public final int getCount() {
            return FilterImageView.wmk.length;
        }

        public final Object getItem(int i) {
            return FilterImageView.wmk[i];
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            c cVar = (c) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(this.wml.fPi, h.hdS, null);
                a aVar2 = new a(this);
                aVar2.itE = (TextView) view.findViewById(g.hcm);
                aVar2.wmm = (ImageView) view.findViewById(g.hcl);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                if (aVar.wmn != null) {
                    w.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{aVar.wmn.toString()});
                    aVar.wmn.recycle();
                }
            }
            TextView textView = aVar.itE;
            b bVar = cVar.wmr;
            String bIN = v.bIN();
            CharSequence charSequence = bIN.equals("zh_CN") ? bVar.vRu : (bIN.equals("zh_TW") || bIN.equals("zh_HK")) ? bVar.wmp : bVar.wmq;
            textView.setText(charSequence);
            try {
                InputStream open = this.wml.fPi.getAssets().open("filter/" + cVar.fSl);
                aVar.wmn = d.decodeStream(open);
                open.close();
                aVar.wmm.setImageBitmap(aVar.wmn);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
            }
            view.setLayoutParams(new LayoutParams(-2, -2));
            if (i == this.nhN) {
                view.findViewById(g.hcl).setBackgroundResource(f.hbL);
            } else {
                view.findViewById(g.hcl).setBackgroundResource(f.hbM);
            }
            return view;
        }
    }

    static class b {
        String vRu;
        String wmp;
        String wmq;

        b(String str, String str2, String str3) {
            this.vRu = str;
            this.wmp = str2;
            this.wmq = str3;
        }
    }

    static class c {
        String fSl;
        b wmr;
        String wms;
        int wmt;
        int wmu;
        int wmv;

        c(b bVar, String str, int i, int i2, String str2, int i3) {
            this.wmr = bVar;
            this.wms = str;
            this.wmt = i;
            this.wmu = i2;
            this.fSl = str2;
            this.wmv = i3;
        }
    }

    static /* synthetic */ boolean a(FilterImageView filterImageView, String str, int i, int i2) {
        if (i2 == 0) {
            filterImageView.wmf.setPixels(filterImageView.wmb, 0, filterImageView.wmf.getWidth(), 0, 0, filterImageView.wmf.getWidth(), filterImageView.wmf.getHeight());
            filterImageView.wme.invalidate();
            return true;
        }
        int width = filterImageView.wmf.getWidth() * filterImageView.wmf.getHeight();
        w.d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, width});
        for (int i3 = 0; i3 < i; i3++) {
            InputStream open = filterImageView.fPi.getAssets().open("filter/" + String.format(str, new Object[]{Integer.valueOf(i3)}));
            byte[] bArr = new byte[width];
            open.read(bArr);
            Bitmap bd = d.bd(bArr);
            open.close();
            if (bd == null) {
                return false;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bd, filterImageView.wmf.getWidth(), filterImageView.wmf.getHeight(), true);
            if (bd != createScaledBitmap) {
                w.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{bd.toString()});
                bd.recycle();
            }
            if (createScaledBitmap == null) {
                return false;
            }
            createScaledBitmap.getPixels(iArr[i3], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
            w.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{createScaledBitmap.toString()});
            createScaledBitmap.recycle();
        }
        PIntArray pIntArray = new PIntArray();
        w.e("MicroMsg.FilterView", "src.len:" + filterImageView.wmb.length);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            w.e("MicroMsg.FilterView", "mask[" + i4 + "].len:" + iArr[i4].length);
        }
        w.e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i2, filterImageView.wmb, iArr, i, filterImageView.wmf.getWidth(), filterImageView.wmf.getHeight(), pIntArray);
        w.e("MicroMsg.FilterView", "after filter");
        filterImageView.wmf.setPixels(pIntArray.value, 0, filterImageView.wmf.getWidth(), 0, 0, filterImageView.wmf.getWidth(), filterImageView.wmf.getHeight());
        filterImageView.wme.invalidate();
        return true;
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPi = (Activity) context;
        View inflate = View.inflate(this.fPi, h.hdR, this);
        this.wme = (CropImageView) inflate.findViewById(g.hcj);
        this.wmd = (ImageView) inflate.findViewById(g.bHs);
        this.wmc = inflate.findViewById(g.bHm);
        this.wme.setOnTouchListener(null);
        this.wmg = (MMHorList) inflate.findViewById(g.bHj);
        this.wmh = new a(this);
        this.wmg.setAdapter(this.wmh);
        this.wmg.invalidate();
        this.wmg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FilterImageView wml;

            {
                this.wml = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a a = this.wml.wmh;
                a.nhN = i;
                a.notifyDataSetChanged();
                try {
                    this.wml.pQX = FilterImageView.wmk[i].wmv;
                    FilterImageView.a(this.wml, FilterImageView.wmk[i].wms, FilterImageView.wmk[i].wmt, FilterImageView.wmk[i].wmu);
                } catch (Throwable e) {
                    w.e("MicroMsg.FilterView", e.toString());
                    w.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
                } catch (Throwable e2) {
                    w.e("MicroMsg.FilterView", e2.toString());
                    w.printErrStackTrace("MicroMsg.FilterView", e2, "", new Object[0]);
                }
            }
        });
    }

    public final void cX(String str, int i) {
        w.i("MicroMsg.FilterView", "filePath before fiterBmp:" + str);
        if (this.wmf == null || this.wmf.isRecycled()) {
            this.wmf = d.b(d.d(str, 480, 480, false), (float) i);
        }
        w.d("MicroMsg.FilterView", "filterBmp w:" + this.wmf.getWidth() + " h:" + this.wmf.getHeight());
        this.wmb = new int[(this.wmf.getWidth() * this.wmf.getHeight())];
        this.wmf.getPixels(this.wmb, 0, this.wmf.getWidth(), 0, 0, this.wmf.getWidth(), this.wmf.getHeight());
        this.wme.setImageBitmap(this.wmf);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.wmh.notifyDataSetChanged();
            this.wmg.invalidate();
        }
        super.setVisibility(i);
    }
}
