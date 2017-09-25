package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;

public final class w implements Serializable {
    public float height;
    public String iconUrl;
    public float qfL;
    public float width;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (wVar.iconUrl.equals(this.iconUrl) && wVar.width == this.width && wVar.height == this.height && wVar.qfL == this.qfL) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
