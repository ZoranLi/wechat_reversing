package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaLocation extends WWMediaObject {
    public String hCE;
    public double latitude;
    public double longitude;
    public double xmc;

    public final boolean checkArgs() {
        if (super.checkArgs() && this.hCE != null && this.hCE.length() != 0 && this.hCE.length() <= 10240) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        bundle.putString("_wwlocobject_address", this.hCE);
        bundle.putDouble("_wwlocobject_longitude", this.longitude);
        bundle.putDouble("_wwlocobject_latitude", this.latitude);
        bundle.putDouble("_wwlocobject_zoom", this.xmc);
        super.toBundle(bundle);
    }
}
