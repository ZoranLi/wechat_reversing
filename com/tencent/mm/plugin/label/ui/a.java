package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.bj.c;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.k;
import java.util.List;

public final class a extends k<f> {
    public static final ColorStateList mZI = com.tencent.mm.bg.a.S(ab.getContext(), R.e.aVa);
    public static final ColorStateList mZJ = com.tencent.mm.bg.a.S(ab.getContext(), R.e.aUo);
    List<String> mZK;

    protected static class a {
        public AddressView mZN;

        public a(View view) {
            this.mZN = (AddressView) view.findViewById(R.h.cmk);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return oB(i);
    }

    public a(Context context) {
        super(context, new f());
    }

    public final int getCount() {
        return super.getCount();
    }

    public final f oB(int i) {
        if (nJ(i)) {
            return (f) aBW();
        }
        f fVar;
        if (this.uSM != null) {
            fVar = (f) this.uSM.get(Integer.valueOf(i));
            if (fVar != null) {
                return fVar;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        fVar = a(null, getCursor());
        if (this.uSM == null) {
            ko(true);
        }
        if (this.uSM == null) {
            return fVar;
        }
        this.uSM.put(Integer.valueOf(i), fVar);
        return fVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence = null;
        af afVar = oB(i).jiL;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, R.i.cZC, null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        b.a(aVar.mZN, afVar.field_username);
        if (afVar.field_verifyFlag != 0) {
            String eZ = com.tencent.mm.u.ag.a.hlU.eZ(afVar.field_verifyFlag);
            if (eZ != null) {
                aVar.mZN.setMaskBitmap(l.ik(eZ));
            } else {
                aVar.mZN.setMaskBitmap(null);
            }
        } else {
            aVar.mZN.setMaskBitmap(null);
        }
        if (afVar.field_deleteFlag == 1) {
            aVar.mZN.setNickNameTextColor(mZJ);
        } else {
            aVar.mZN.setNickNameTextColor(mZI);
        }
        aVar.mZN.updateTextColors();
        CharSequence charSequence2 = afVar.uyS;
        if (charSequence2 == null) {
            try {
                Context context = this.context;
                eZ = afVar.field_username;
                charSequence2 = n.eK(afVar.field_username);
                String str = "";
                if (str.length() > 0 && !str.equals(charSequence2)) {
                    StringBuilder stringBuilder = new StringBuilder(32);
                    stringBuilder.append(charSequence2);
                    stringBuilder.append("(");
                    stringBuilder.append(str);
                    stringBuilder.append(")");
                    charSequence2 = stringBuilder.toString();
                }
                charSequence = h.b(context, charSequence2, aVar.mZN.getNickNameSize());
            } catch (Exception e) {
            }
            if (charSequence == null) {
                charSequence = "";
            }
            aVar.mZN.setName(charSequence);
            afVar.uyS = charSequence;
        } else {
            aVar.mZN.setName(charSequence2);
        }
        aVar.mZN.updatePositionFlag();
        return view;
    }

    public final synchronized void OK() {
        Cursor bNI;
        Object obj = Looper.myLooper() == Looper.getMainLooper() ? 1 : null;
        if (this.mZK == null || this.mZK.size() <= 0) {
            bNI = c.bNI();
        } else {
            ap.yY();
            bNI = com.tencent.mm.u.c.wR().ce(this.mZK);
        }
        if (obj != null) {
            f(bNI);
        } else {
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ a mZM;

                public final void run() {
                    this.mZM.f(bNI);
                }
            });
        }
    }

    protected final void OL() {
        OK();
    }

    private static f a(f fVar, Cursor cursor) {
        if (fVar == null) {
            fVar = new f();
        }
        ap.yY();
        x QX = com.tencent.mm.u.c.wR().QX(x.h(cursor));
        if (QX == null) {
            fVar.jiL.b(cursor);
            ap.yY();
            com.tencent.mm.u.c.wR().O(fVar.jiL);
        } else {
            fVar.jiL = QX;
        }
        return fVar;
    }

    public final void f(Cursor cursor) {
        aEW();
        setCursor(cursor);
        notifyDataSetChanged();
    }
}
