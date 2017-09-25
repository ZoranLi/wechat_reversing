package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference extends Preference implements a {
    public f jid;
    public ImageView pti;
    public ImageView ptj;
    public ImageView ptk;
    List<String> ptl;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ptl = null;
        setLayoutResource(R.i.dpn);
        setWidgetLayoutResource(0);
        j.a(this);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.pti = (ImageView) view.findViewById(R.h.cIa);
        this.ptj = (ImageView) view.findViewById(R.h.cIb);
        this.ptk = (ImageView) view.findViewById(R.h.cIc);
        if (this.ptl != null && this.ptl.size() > 0) {
            i bVar = new b((String) this.ptl.get(0));
            this.pti.setTag(bVar.No());
            Bitmap a = j.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.pti.setImageBitmap(a);
            }
            this.pti.setVisibility(0);
            if (1 < this.ptl.size()) {
                bVar = new b((String) this.ptl.get(1));
                this.ptj.setTag(bVar.No());
                a = j.a(bVar);
                if (!(a == null || a.isRecycled())) {
                    this.ptj.setImageBitmap(a);
                }
                this.ptj.setVisibility(0);
                if (2 < this.ptl.size()) {
                    bVar = new b((String) this.ptl.get(2));
                    this.ptk.setTag(bVar.No());
                    a = j.a(bVar);
                    if (!(a == null || a.isRecycled())) {
                        this.ptk.setImageBitmap(a);
                    }
                    this.ptk.setVisibility(0);
                }
            }
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.pti != null && this.pti.getTag() != null && str.equals((String) this.pti.getTag())) {
                this.pti.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference ptm;

                    public final void run() {
                        this.ptm.pti.setImageBitmap(bitmap);
                        if (this.ptm.jid != null) {
                            this.ptm.jid.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.ptj != null && this.ptj.getTag() != null && str.equals((String) this.ptj.getTag())) {
                this.ptj.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference ptm;

                    public final void run() {
                        this.ptm.ptj.setImageBitmap(bitmap);
                        if (this.ptm.jid != null) {
                            this.ptm.jid.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.ptk != null && this.ptk.getTag() != null && str.equals((String) this.ptk.getTag())) {
                this.ptk.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference ptm;

                    public final void run() {
                        this.ptm.ptk.setImageBitmap(bitmap);
                        if (this.ptm.jid != null) {
                            this.ptm.jid.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }
}
