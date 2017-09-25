package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;

public final class f extends a {
    public String[] mai;
    public CharSequence pgM;
    private com.tencent.mm.ui.contact.a.a.b waB = new b(this);
    com.tencent.mm.ui.contact.a.a.a waC = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView ipx;
        public View waD;
        final /* synthetic */ f waE;

        public a(f fVar) {
            this.waE = fVar;
            super(fVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ f waE;

        public b(f fVar) {
            this.waE = fVar;
            super(fVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.dnJ, viewGroup, false);
            a aVar = (a) this.waE.waC;
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.waD = inflate.findViewById(R.h.bVY);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            e.a(((f) aVar2).pgM, aVar3.ipx);
            if (this.waE.position == 0) {
                aVar3.waD.setVisibility(8);
            } else {
                aVar3.waD.setVisibility(0);
            }
        }

        public final boolean Od() {
            return false;
        }
    }

    public f(int i) {
        super(5, i);
    }

    public final void br(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Object obj : this.mai) {
            CharSequence spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.fts.d.d.a.mcz), 0, obj.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.pgM = TextUtils.concat(new CharSequence[]{context.getString(R.l.eQA), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.l.eQz)});
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.waB;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.waC;
    }
}
