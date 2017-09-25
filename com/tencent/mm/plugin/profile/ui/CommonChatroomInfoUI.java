package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;

public class CommonChatroomInfoUI extends MMBaseSelectContactUI {
    private x jiL;
    private a osG;
    private b osH;

    protected final void Oe() {
        super.Oe();
        String stringExtra = getIntent().getStringExtra("Select_Talker_Name");
        ap.yY();
        this.jiL = c.wR().Rc(stringExtra);
    }

    protected final void KC() {
        super.KC();
        a aVar = this.osG;
        f fVar = new f();
        fVar.fRM = aVar.jiL.field_username;
        fVar.mag = aVar;
        fVar.handler = aVar.handler;
        fVar.lZZ = 6;
        fVar.maf = new a(aVar);
        ((l) h.j(l.class)).search(2, fVar);
    }

    protected final boolean Of() {
        return true;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        if (this.jiL.gkr == 1) {
            return getString(R.l.dXT);
        }
        if (this.jiL.gkr == 2) {
            return getString(R.l.dXS);
        }
        return getString(R.l.dXV);
    }

    protected final o Oi() {
        if (this.osG == null) {
            this.osG = new a(this, this.scene, this.jiL);
        }
        return this.osG;
    }

    protected final m Oj() {
        if (this.osH == null) {
            this.osH = new b(this, this.scene, this.jiL);
        }
        return this.osH;
    }

    public final void hf(int i) {
        d.a(this, ".ui.chatting.En_5b8fbb1e", new Intent().putExtra("Chat_User", ((e) this.oCR.getAdapter().getItem(i)).jiL.field_username).putExtra("finish_direct", true));
    }
}
