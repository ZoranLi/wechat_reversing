package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;

@Deprecated
public interface h {
    Bitmap a(Activity activity, int i, int i2, Intent intent);

    k a(f fVar);

    void a(Context context, a aVar, Bundle bundle);

    void a(Context context, x xVar, a aVar, Bundle bundle, String str);

    void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5);

    void a(Context context, String str, String str2, String str3, long j);

    void a(Intent intent, String str);

    void a(ame com_tencent_mm_protocal_c_ame, String str);

    boolean a(Context context, int i, int i2, String str);

    boolean a(x xVar);

    void ah(Context context);

    k am(boolean z);

    boolean b(Context context, int i, int i2, String str);

    String bm(String str);

    boolean bn(String str);

    boolean bo(String str);

    void bp(String str);

    boolean c(Activity activity);

    void cT(int i);

    void d(Activity activity);

    String e(Context context, String str, String str2);

    String i(String str, int i);

    String m(Context context, String str);

    boolean n(Context context, String str);

    void oA();

    boolean oB();

    void ou();

    void ow();

    void ox();

    Intent oy();

    boolean oz();

    String s(String str, String str2);
}
