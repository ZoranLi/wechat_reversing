package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaConversation extends WWMediaObject {
    public long date;
    public String lMF;
    public String name;
    public byte[] xma;
    public WWMediaObject xmb;

    public final boolean checkArgs() {
        if (!super.checkArgs()) {
            return false;
        }
        if (this.xma != null && this.xma.length > 10485760) {
            return false;
        }
        if (this.lMF != null && this.lMF.length() > 10240) {
            return false;
        }
        if ((this.lMF == null || WWMediaObject.getFileSize(this.lMF) <= 10485760) && this.xmb != null && this.xmb.checkArgs()) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wwconvobject_name", this.name);
        bundle.putLong("_wwconvobject_date", this.date);
        bundle.putByteArray("_wwconvobject_avatarData", this.xma);
        bundle.putString("_wwconvobject_avatarPath", this.lMF);
        bundle.putBundle("_wwconvobject_message", BaseMessage.b(this.xmb));
    }
}
