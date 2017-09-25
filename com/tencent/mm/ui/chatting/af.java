package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class af {
    private x fOK;
    public a vBu;
    public cw vBv;
    ChatFooter vBw;
    ChatFooterCustom vBx;
    private boolean vBy = false;
    long[] vBz = null;
    public boolean vxp;

    public af(a aVar, cw cwVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, x xVar, boolean z, long[] jArr) {
        this.vBu = aVar;
        this.vBw = chatFooter;
        this.vBx = chatFooterCustom;
        this.vBv = cwVar;
        this.fOK = xVar;
        this.vxp = z;
        this.vBz = jArr;
        this.vBu.uSU.bQf();
        q qVar = this.vBu;
        qVar.uSU.a(2, this.vBu.getString(R.l.dOQ), new OnMenuItemClickListener(this) {
            final /* synthetic */ af vBA;

            {
                this.vBA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                Set<Long> set = this.vBA.vBv.vFx;
                if (set != null) {
                    List<Long> arrayList = new ArrayList();
                    for (Long l : set) {
                        if (l != null) {
                            arrayList.add(l);
                        }
                    }
                    long[] jArr = new long[arrayList.size()];
                    int i = 0;
                    for (Long l2 : arrayList) {
                        int i2 = i + 1;
                        jArr[i] = l2.longValue();
                        i = i2;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", jArr);
                    this.vBA.vBu.bPj().setResult(-1, intent);
                } else {
                    this.vBA.vBu.bPj().setResult(0, intent);
                }
                intent.putExtra("k_is_group_chat", this.vBA.vxp);
                this.vBA.vBu.finish();
                return false;
            }
        }, null, b.uTY);
        this.vBv.vFH = new OnClickListener(this) {
            final /* synthetic */ af vBA;

            {
                this.vBA = r1;
            }

            public final void onClick(View view) {
                this.vBA.vBv.eG(((Long) view.getTag()).longValue());
            }
        };
    }
}
