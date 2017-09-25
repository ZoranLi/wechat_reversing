package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private int kwO;
    private String title;

    protected final void Oe() {
        super.Oe();
        this.title = getIntent().getStringExtra("titile");
        this.kwO = getIntent().getIntExtra("list_attr", 0);
    }

    public final void hf(int i) {
        a BL = bYb().BL(i);
        if (BL != null && BL.jiL != null) {
            String str = BL.jiL.field_username;
            w.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[]{str});
            Intent intent = new Intent();
            if (s.ee(this.kwO, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            } else if (s.ee(this.kwO, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                intent.putExtra("Contact_User", str);
                d.b(this, "profile", ".ui.ContactInfoUI", intent);
                finish();
            } else {
                intent.setClass(this, En_5b8fbb1e.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                startActivity(intent);
                finish();
            }
        }
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        return this.title;
    }

    protected final o Oi() {
        return new w(this, getIntent().getStringExtra("filter_type"));
    }

    protected final m Oj() {
        return null;
    }
}
