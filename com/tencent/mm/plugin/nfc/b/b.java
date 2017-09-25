package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b {
    public Tag nZg;
    public byte[] nZh = null;

    public boolean a(Tag tag) {
        this.nZg = tag;
        if (tag != null) {
            this.nZh = tag.getId();
        }
        return true;
    }
}
