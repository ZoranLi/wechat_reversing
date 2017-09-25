package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaLink extends WWMediaObject {
    public String thumbUrl;
    public String webpageUrl;

    public final boolean checkArgs() {
        if (super.checkArgs() && this.webpageUrl != null && this.webpageUrl.length() != 0 && this.webpageUrl.length() <= 10240) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        bundle.putString("_wwwebpageobject_thumbUrl", this.thumbUrl);
        bundle.putString("_wwwebpageobject_webpageUrl", this.webpageUrl);
        super.toBundle(bundle);
    }
}
