package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public final class b {

    static class a implements com.tencent.mm.platformtools.j.a {
        public ViewGroup rON = null;
        public e rOO;
        public ViewGroup rOP = null;
        public TextView rOQ = null;
        public ImageView rOR = null;
        public ImageView rwB = null;
        public ImageView rwC = null;
        public TextView rwD = null;
        public TextView rwE = null;
        public TextView rwF = null;
        public TextView rwx = null;
        public TextView rwy = null;
        public TextView rwz = null;

        a() {
        }

        public final void k(String str, final Bitmap bitmap) {
            w.d("MicroMsg.BankcardListAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.rOO != null) {
                if (str.equals(this.rOO.nXm)) {
                    this.rwC.post(new Runnable(this) {
                        final /* synthetic */ a rOS;

                        public final void run() {
                            this.rOS.rwC.setImageBitmap(bitmap);
                            this.rOS.rON.invalidate();
                        }
                    });
                }
                if (str.equals(this.rOO.rEs) && this.rwB != null) {
                    this.rwB.post(new Runnable(this) {
                        final /* synthetic */ a rOS;

                        public final void run() {
                            this.rOS.rwB.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        }
    }

    public static View a(Context context, View view, Bankcard bankcard, int i, com.tencent.mm.plugin.wallet_core.d.a aVar, boolean z) {
        a aVar2;
        if (view == null || view.getTag() == null) {
            view = View.inflate(context, i, null);
            a aVar3 = new a();
            aVar3.rwC = (ImageView) view.findViewById(R.h.brY);
            aVar3.rwy = (TextView) view.findViewById(R.h.brZ);
            aVar3.rwz = (TextView) view.findViewById(R.h.bsv);
            aVar3.rwx = (TextView) view.findViewById(R.h.bsh);
            aVar3.rwD = (TextView) view.findViewById(R.h.bsg);
            aVar3.rON = (ViewGroup) view.findViewById(R.h.cPI);
            aVar3.rwB = (ImageView) view.findViewById(R.h.bsp);
            aVar3.rwE = (TextView) view.findViewById(R.h.bsc);
            aVar3.rOP = (ViewGroup) view.findViewById(R.h.bse);
            aVar3.rOQ = (TextView) view.findViewById(R.h.bsb);
            aVar3.rOR = (ImageView) view.findViewById(R.h.bsq);
            view.setTag(aVar3);
            aVar2 = aVar3;
        } else {
            aVar2 = (a) view.getTag();
        }
        if (bankcard.field_bankcardState == 1) {
            aVar2.rwD.setVisibility(0);
        } else {
            aVar2.rwD.setVisibility(8);
        }
        if (aVar2.rOR != null) {
            if (z) {
                aVar2.rOR.setVisibility(0);
            } else {
                aVar2.rOR.setVisibility(8);
            }
        }
        aVar2.rwy.setText(bankcard.field_bankName);
        if (m.xY()) {
            aVar2.rwz.setVisibility(8);
        } else if (!bg.mA(bankcard.field_bankcardTypeName)) {
            aVar2.rwz.setText(bankcard.field_bankcardTypeName);
        } else if (bankcard.btz()) {
            aVar2.rwz.setText(R.l.flr);
        } else if (bankcard.btC()) {
            aVar2.rwz.setText(R.l.ffh);
        } else {
            aVar2.rwz.setText(R.l.ffv);
        }
        if (aVar2.rwx != null) {
            aVar2.rwx.setText(bankcard.field_bankcardTail);
        }
        if (bg.mA(bankcard.field_card_bottom_wording) || aVar2.rOQ == null) {
            aVar2.rOP.setVisibility(8);
        } else {
            aVar2.rOQ.setText(bankcard.field_card_bottom_wording);
            aVar2.rOP.setVisibility(0);
        }
        aVar.a(context, bankcard, aVar2.rwC, aVar2.rON, aVar2.rwB);
        if (aVar2.rwE != null) {
            com.tencent.mm.plugin.wallet_core.model.m.btS();
            String str = bankcard.field_bindSerial;
            aVar2.rwE.setVisibility(8);
        }
        return view;
    }

    public static Drawable c(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (!NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new BitmapDrawable(bitmap);
            }
            Drawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new Rect(), null);
            ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return ninePatchDrawable;
        } catch (Throwable e) {
            w.f("MicroMsg.BankcardListAdapter", e.getMessage());
            w.printErrStackTrace("MicroMsg.BankcardListAdapter", e, "", new Object[0]);
            return null;
        }
    }
}
