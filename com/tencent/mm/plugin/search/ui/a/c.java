package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.fts.d.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class c extends com.tencent.mm.plugin.fts.d.a.a {
    public List<String> iJD;
    public CharSequence pgM;
    private b pgN = new b(this);
    a pgO = new a(this);

    private class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public TextView ipx;
        final /* synthetic */ c pgP;

        public a(c cVar) {
            this.pgP = cVar;
            super(cVar);
        }
    }

    private class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ c pgP;

        public b(c cVar) {
            this.pgP = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddG, viewGroup, false);
            a aVar = this.pgP.pgO;
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            e.a(this.pgP.pgM, ((a) aVar).ipx);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            Intent intent = new Intent();
            Serializable arrayList = new ArrayList();
            arrayList.addAll(this.pgP.iJD);
            intent.putExtra("query_phrase_list", arrayList);
            intent.putExtra("go_to_chatroom_direct", true);
            intent.putExtra("scene_from", 3);
            d.a(context, ".ui.transmit.MMCreateChatroomUI", intent);
            return true;
        }
    }

    public c(int i) {
        super(17, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (String str : this.iJD) {
            CharSequence spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.fts.d.d.a.mcz), 0, str.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.pgM = TextUtils.concat(new CharSequence[]{context.getString(R.l.eQA), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.l.eQz)});
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.pgN;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.pgO;
    }
}
