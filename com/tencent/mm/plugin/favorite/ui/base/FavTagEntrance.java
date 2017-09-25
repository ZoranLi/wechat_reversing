package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public class FavTagEntrance extends LinearLayout implements a {
    private long fQF = -1;
    private TextView lJY;
    private String lJZ = String.valueOf(this.fQF);

    public FavTagEntrance(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lJY = (TextView) findViewById(R.h.cHe);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavTagEntrance lKa;

            {
                this.lKa = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.lKa.getContext(), FavTagEditUI.class);
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", this.lKa.fQF);
                this.lKa.getContext().startActivity(intent);
            }
        });
    }

    public final void ck(long j) {
        this.fQF = j;
        this.lJZ = String.valueOf(j);
    }

    public final void ax(List<String> list) {
        if (this.lJY != null) {
            CharSequence a = x.a(getContext(), (List) list);
            if (bg.mA(a)) {
                this.lJY.setText("");
                this.lJY.setHint(R.l.ehW);
                return;
            }
            this.lJY.setText(h.b(getContext(), a, this.lJY.getTextSize()));
        }
    }

    public final void a(String str, l lVar) {
        w.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[]{str, this.lJZ});
        if (this.lJZ.equals(str)) {
            j bT = com.tencent.mm.plugin.favorite.h.ata().bT(this.fQF);
            if (bT == null) {
                w.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[]{Long.valueOf(this.fQF)});
                return;
            }
            ax(bT.field_tagProto.tzx);
        }
    }
}
