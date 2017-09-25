package com.tencent.mm.pluginsdk.c;

import android.content.Context;
import com.tencent.mm.ap.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.u;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d.a;
import java.util.ArrayList;
import java.util.List;

public interface d {
    String a(Context context, WXMediaMessage wXMediaMessage, String str);

    void a(Context context, au auVar);

    void a(String str, c cVar, au auVar);

    boolean a(Context context, c cVar, int i, String str);

    boolean a(String str, String str2, long j, String str3, a aVar);

    boolean alC();

    ArrayList<s> alD();

    ArrayList<String> alE();

    ArrayList<u> alF();

    f alG();

    al bO(String str, String str2);

    String bP(String str, String str2);

    c c(c cVar);

    void d(c cVar);

    int e(c cVar);

    int[] f(c cVar);

    byte[] g(c cVar);

    boolean l(Context context, String str, String str2);

    boolean s(ArrayList<s> arrayList);

    boolean t(ArrayList<u> arrayList);

    c ub(String str);

    String uc(String str);

    List<c> ud(String str);

    String ue(String str);

    boolean uf(String str);

    ArrayList<String> ug(String str);

    String uh(String str);

    String ui(String str);

    int uj(String str);

    String uk(String str);

    void ul(String str);
}
