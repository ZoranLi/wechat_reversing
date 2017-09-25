package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import java.util.ArrayList;
import java.util.List;

public class WWMediaMergedConvs extends WWMediaObject {
    public List<WWMediaConversation> xmd = new ArrayList();

    public final boolean checkArgs() {
        if (!super.checkArgs() || this.xmd == null || this.xmd.size() == 0) {
            return false;
        }
        boolean z;
        for (BaseMessage checkArgs : this.xmd) {
            if (!checkArgs.checkArgs()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final void toBundle(Bundle bundle) {
        bundle.putInt("_wwmergedconvobject_messageslen", this.xmd.size());
        for (int i = 0; i < this.xmd.size(); i++) {
            bundle.putBundle("_wwmergedconvobject_messages" + i, BaseMessage.b((BaseMessage) this.xmd.get(i)));
        }
        super.toBundle(bundle);
    }
}
