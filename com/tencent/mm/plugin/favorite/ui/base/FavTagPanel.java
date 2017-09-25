package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel extends MMTagPanel {
    public LinkedList<d> lKb = new LinkedList();
    a lKc = null;
    public OnClickListener lKd = new OnClickListener(this) {
        final /* synthetic */ FavTagPanel lKe;

        {
            this.lKe = r1;
        }

        public final void onClick(final View view) {
            if (((Integer) view.getTag()).intValue() == 0) {
                this.lKe.a((TextView) view, true, false);
                if (this.lKe.lKc != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 lKf;

                        public final void run() {
                            this.lKf.lKe.lKc;
                            ((TextView) view).getText().toString();
                        }
                    });
                    return;
                }
                return;
            }
            this.lKe.a((TextView) view, false, false);
            if (this.lKe.lKc != null) {
                view.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 lKf;

                    public final void run() {
                        this.lKf.lKe.lKc.wo(((TextView) view).getText().toString());
                    }
                });
            }
        }
    };

    public interface a extends com.tencent.mm.ui.base.MMTagPanel.a {
        void wn(String str);

        void wo(String str);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void auy() {
        if (this.tzv.size() <= 0 && !this.lKb.isEmpty()) {
            String str = ((d) this.lKb.getLast()).vna;
            wp(str);
            if (this.lKc != null) {
                this.lKc.wn(str);
            }
            bSA();
        }
    }

    public final void wp(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.FavTagPanel", "want to remove type, but it is null or empty");
            return;
        }
        Iterator it = this.lKb.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.vna)) {
                this.lKb.remove(dVar);
                removeView(dVar.vnb);
                a(dVar);
                bSA();
                return;
            }
        }
        w.w("MicroMsg.FavTagPanel", "want to remove type %s, but it not exsited!", new Object[]{str});
    }
}
