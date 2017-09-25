package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.sdk.platformtools.bg;

public final class i {
    public int backgroundColor;
    public Object data;
    public int end;
    public String iCS;
    public int linkColor;
    public int start;
    public int type;
    public String url;
    public String username;

    public i(String str, int i, Object obj) {
        this.url = str;
        this.data = obj;
        this.type = i;
    }

    public final <T> T r(Class<T> cls) {
        if (cls.isInstance(this.data)) {
            return cls.cast(this.data);
        }
        return null;
    }

    public final int hashCode() {
        int hashCode = super.hashCode();
        if (!bg.mA(this.url)) {
            hashCode += this.url.hashCode();
        }
        hashCode = ((hashCode + this.type) + this.end) + this.start;
        if (this.data != null) {
            return hashCode + this.data.hashCode();
        }
        return hashCode;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return hashCode() == ((i) obj).hashCode();
        } else {
            return super.equals(obj);
        }
    }
}
