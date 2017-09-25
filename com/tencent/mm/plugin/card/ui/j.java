package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class j {
    public Bitmap iuR;
    public o iuS = null;
    ImageView iuT;
    View iuU;
    OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ j koR;

        {
            this.koR = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.csg || view.getId() == R.h.csc) {
                if (this.koR.iuS != null && this.koR.iuS.isShowing()) {
                    this.koR.iuS.dismiss();
                }
                if (!this.koR.kcX.aeR()) {
                    this.koR.ahL();
                }
            }
        }
    };
    MMActivity iwk;
    public b kcX;
    float khH = 0.0f;
    public Bitmap khz;
    boolean kkR = true;
    Bitmap koI = null;
    TextView koJ;
    TextView koK;
    View koL;
    ImageView koM;
    MMVerticalTextView koN;
    MMVerticalTextView koO;
    ArrayList<Bitmap> koP = new ArrayList();
    String koQ = "";

    public j(MMActivity mMActivity) {
        this.iwk = mMActivity;
    }

    private void S(float f) {
        LayoutParams attributes = this.iwk.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.iwk.getWindow().setAttributes(attributes);
    }

    public final void ahK() {
        if (this.khH < 0.8f) {
            S(0.8f);
        }
    }

    public final void ahL() {
        S(this.khH);
    }

    final void ahM() {
        if (this.koP.size() > 2) {
            for (int size = this.koP.size() - 1; size > 1; size--) {
                l.p((Bitmap) this.koP.remove(size));
            }
        }
    }
}
