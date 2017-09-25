package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.d.h;

public final class d implements b {
    Context context;

    public d(Context context) {
        this.context = context;
    }

    public final View cJ(Context context) {
        return View.inflate(context, R.i.dmq, null);
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(R.h.cxe);
        textView.setText(bVar.fKe.desc);
        h.d(textView, 1);
        if (this.context instanceof Activity) {
            ((Activity) this.context).registerForContextMenu(textView);
        }
    }

    public final void destroy() {
        this.context = null;
    }

    public final void pause() {
    }
}
