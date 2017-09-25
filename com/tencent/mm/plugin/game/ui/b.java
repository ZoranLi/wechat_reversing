package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;

public abstract class b<T> extends BaseAdapter {
    private static int mww = 500;
    protected Context mContext;
    protected LinkedList<T> mrk;
    a mwt;
    protected boolean mwu = false;
    private f<String, Bitmap> mwv;
    private aj mwx = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b mwz;

        {
            this.mwz = r1;
        }

        public final boolean oQ() {
            this.mwz.notifyDataSetChanged();
            return false;
        }
    }, false);
    private final com.tencent.mm.sdk.e.j.a mwy = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ b mwz;

        {
            this.mwz = r1;
        }

        public final void a(String str, l lVar) {
            this.mwz.mwx.KH();
            long aaT = (long) b.mww;
            this.mwz.mwx.v(aaT, aaT);
        }
    };

    public interface a {
        void nB(int i);
    }

    public b(Context context) {
        this.mContext = context;
        this.mrk = new LinkedList();
        this.mwv = new f(20);
        an.aRr().c(this.mwy);
    }

    public void O(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.mrk.addAll(linkedList);
            if (this.mwt != null) {
                this.mwt.nB(this.mrk.size());
            }
            super.notifyDataSetChanged();
        } else if (this.mwt != null) {
            this.mwt.nB(this.mrk.size());
        }
    }

    public void P(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.mrk = linkedList;
            if (this.mwt != null) {
                this.mwt.nB(this.mrk.size());
            }
            super.notifyDataSetChanged();
        } else if (this.mwt != null) {
            this.mwt.nB(this.mrk.size());
        }
    }

    protected final void remove(int i) {
        if (this.mrk != null && i >= 0 && i <= this.mrk.size() - 1) {
            this.mrk.remove(i);
            if (this.mwt != null) {
                this.mwt.nB(this.mrk.size());
            }
            super.notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.mrk != null) {
            this.mrk.clear();
        }
        if (this.mwv != null) {
            this.mwv.a(new com.tencent.mm.a.f.a<String, Bitmap>(this) {
                final /* synthetic */ b mwz;

                {
                    this.mwz = r1;
                }
            });
        }
        this.mwv = null;
        an.aRr().f(this.mwy);
    }

    protected final Bitmap xX(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Bitmap bitmap;
        if (this.mwv.aV(str)) {
            bitmap = (Bitmap) this.mwv.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                return bitmap;
            }
        }
        bitmap = g.b(str, 1, com.tencent.mm.bg.a.getDensity(this.mContext));
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        this.mwv.k(str, bitmap);
        return bitmap;
    }

    public int getCount() {
        return this.mrk.size();
    }

    public Object getItem(int i) {
        return this.mrk.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
