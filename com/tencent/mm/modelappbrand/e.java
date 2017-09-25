package com.tencent.mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.c.a;

public interface e extends a {
    d AM();

    i AN();

    void a(String str, View view);

    boolean a(String str, View view, Bundle bundle, q qVar);

    View aR(Context context);

    void gL(String str);

    void initialize();

    void shutdown();
}
