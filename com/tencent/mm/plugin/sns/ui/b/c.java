package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.w;

public abstract class c implements OnCreateContextMenuListener {
    public abstract void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo);

    public abstract boolean cD(View view);

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (cD(view)) {
            a(contextMenu, view, contextMenuInfo);
        } else {
            w.e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
        }
    }
}
