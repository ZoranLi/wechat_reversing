package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h extends Preference {
    public Context mContext = null;
    private View mView = null;
    List<com.tencent.mm.plugin.scanner.a.a.a> oqu = null;

    private static final class a implements i {
        private String mPicUrl = null;

        public a(String str) {
            this.mPicUrl = str;
        }

        public final String Nm() {
            return c.aXW().dl(this.mPicUrl, "@S");
        }

        public final String Nn() {
            return this.mPicUrl;
        }

        public final String No() {
            return this.mPicUrl;
        }

        public final String Np() {
            return this.mPicUrl;
        }

        public final boolean Nq() {
            return false;
        }

        public final boolean Nr() {
            return false;
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
            if (com.tencent.mm.platformtools.i.a.ihH == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ProductGridPreference", e, "", new Object[0]);
                }
            }
            return bitmap;
        }

        public final void Nt() {
        }

        public final void F(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }

        public final Bitmap Ns() {
            if (ab.getContext() == null) {
                return null;
            }
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }

        public final com.tencent.mm.platformtools.i.b Nl() {
            return null;
        }
    }

    final class b extends BaseAdapter implements com.tencent.mm.platformtools.j.a {
        private LayoutInflater Du = null;
        Map<String, WeakReference<ImageView>> oZb = new HashMap();
        private int oZe;
        List<com.tencent.mm.plugin.scanner.a.a.a> oZf = new ArrayList();
        final /* synthetic */ h oZg;

        class a {
            TextView kBi;
            ImageView oXh;
            final /* synthetic */ b oZi;

            a(b bVar) {
                this.oZi = bVar;
            }
        }

        public b(h hVar) {
            this.oZg = hVar;
            this.Du = LayoutInflater.from(hVar.mContext);
            j.a(this);
            this.oZe = hVar.mContext.getResources().getColor(R.e.aUj);
        }

        public final int getCount() {
            return this.oZf.size();
        }

        public final Object getItem(int i) {
            return this.oZf.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.Du.inflate(R.i.dkX, viewGroup, false);
                aVar = new a(this);
                aVar.oXh = (ImageView) view.findViewById(R.h.bVB);
                aVar.kBi = (TextView) view.findViewById(R.h.bVA);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            final com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) this.oZf.get(i);
            Bitmap a = j.a(new a(aVar2.iconUrl));
            if (a == null || a.isRecycled()) {
                aVar.oXh.setBackgroundColor(this.oZe);
                aVar.oXh.setImageBitmap(null);
            } else {
                aVar.oXh.setImageBitmap(a);
                aVar.oXh.setBackgroundColor(0);
            }
            final String str = aVar2.oVS;
            aVar.oXh.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b oZi;

                public final void onClick(View view) {
                    ap.vd().a(new com.tencent.mm.plugin.scanner.a.h(str, aVar2.oVR, aVar2.type, str, this.oZi.getCount(), aVar2.showType), 0);
                    if (!bg.mA(str)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_Product_ID", str);
                        com.tencent.mm.bb.d.b(this.oZi.oZg.mContext, "scanner", ".ui.ProductUI", intent);
                    }
                }
            });
            aVar.oXh.setTag(aVar2.iconUrl);
            this.oZb.put(aVar2.iconUrl, new WeakReference(aVar.oXh));
            aVar.kBi.setText(aVar2.name);
            return view;
        }

        public final void k(String str, final Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled() && !bg.mA(str)) {
                w.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=" + str);
                if (((WeakReference) this.oZb.get(str)) != null) {
                    final ImageView imageView = (ImageView) ((WeakReference) this.oZb.get(str)).get();
                    if (imageView != null && str.equals((String) imageView.getTag())) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ b oZi;

                            public final void run() {
                                imageView.setImageBitmap(bitmap);
                                imageView.setBackgroundColor(0);
                            }
                        });
                    }
                }
            }
        }
    }

    public h(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(R.i.dkW);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        GridView gridView = (GridView) this.mView.findViewById(R.h.cgP);
        b bVar = new b(this);
        gridView.setAdapter(bVar);
        if (this.oqu != null) {
            List list = this.oqu;
            bVar.oZb.clear();
            bVar.oZf.clear();
            bVar.oZf = list;
            bVar.notifyDataSetChanged();
        }
    }
}
