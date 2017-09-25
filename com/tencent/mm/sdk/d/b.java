package com.tencent.mm.sdk.d;

import com.tencent.mm.sdk.platformtools.w;
import java.io.Serializable;

public class b extends c implements Serializable {
    public final String name = getClass().getSimpleName();

    public void enter() {
        super.enter();
        w.i("LogStateTransitionState", "entering " + this.name);
    }

    public void exit() {
        super.exit();
        w.i("LogStateTransitionState", "exiting " + this.name);
    }
}
