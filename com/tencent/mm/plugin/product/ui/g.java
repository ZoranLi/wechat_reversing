package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class g extends u {
    public Context mContext;
    private List<String> oqD;
    private ArrayList<b> ora;
    private boolean orb;
    public a orc;

    public interface a {
        void aTo();
    }

    class b implements com.tencent.mm.platformtools.j.a {
        public ImageView fMY = null;
        final /* synthetic */ g ord;
        public String url;

        public b(final g gVar, String str) {
            this.ord = gVar;
            this.url = str;
            this.fMY = (ImageView) ((LayoutInflater) gVar.mContext.getSystemService("layout_inflater")).inflate(R.i.dkZ, null);
            this.fMY.setImageBitmap(j.a(new c(str)));
            this.fMY.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b orf;

                public final void onClick(View view) {
                    w.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
                    if (this.orf.ord.orc != null) {
                        this.orf.ord.orc.aTo();
                    }
                }
            });
            j.a(this);
        }

        public final void k(String str, final Bitmap bitmap) {
            w.d("MicroMsg.MallProductImageAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.url != null && str.equals(this.url)) {
                this.fMY.post(new Runnable(this) {
                    final /* synthetic */ b orf;

                    public final void run() {
                        this.orf.fMY.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public g(Context context) {
        this(context, (byte) 0);
    }

    private g(Context context, byte b) {
        this.orb = false;
        this.orc = null;
        this.mContext = context;
        this.oqD = null;
        ai(this.oqD);
    }

    public final void ai(List<String> list) {
        if (list != null) {
            if (list.size() > 0) {
                this.oqD = list;
            }
            if (this.ora == null) {
                this.ora = new ArrayList();
            } else {
                this.ora.clear();
            }
            for (String bVar : this.oqD) {
                this.ora.add(new b(this, bVar));
            }
        }
    }

    public final int getCount() {
        if (this.oqD == null) {
            return 0;
        }
        if (this.orb) {
            return Integer.MAX_VALUE;
        }
        return this.oqD.size();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        w.d("MicroMsg.MallProductImageAdapter", "destroy item");
        if (this.ora != null) {
            viewGroup.removeView(((b) this.ora.get(i)).fMY);
        }
    }

    public final int j(Object obj) {
        return -2;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.ora == null) {
            return super.b(viewGroup, i);
        }
        w.d("MicroMsg.MallProductImageAdapter", "data valid");
        viewGroup.addView(((b) this.ora.get(i)).fMY, 0);
        return ((b) this.ora.get(i)).fMY;
    }
}
