package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.g;
import java.util.List;

public interface ar extends g {

    public interface a {
        void a(ar arVar, x xVar);
    }

    String Dk();

    void O(x xVar);

    boolean P(x xVar);

    boolean Q(x xVar);

    x QX(String str);

    boolean QY(String str);

    x QZ(String str);

    boolean R(x xVar);

    x Ra(String str);

    x Rb(String str);

    x Rc(String str);

    long Rd(String str);

    boolean Re(String str);

    boolean Rf(String str);

    byte[] Rg(String str);

    int Rh(String str);

    int Ri(String str);

    String Rj(String str);

    int S(x xVar);

    int a(String str, x xVar);

    Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    Cursor a(String str, String str2, List<String> list, boolean z, boolean z2);

    Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2);

    Cursor a(String[] strArr, String str, List<String> list);

    void a(a aVar);

    Cursor aKg();

    int b(String str, x xVar);

    int b(String[] strArr, String... strArr2);

    Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    void b(a aVar);

    int[] b(String str, String str2, String str3, List<String> list);

    int[] b(String str, String str2, String[] strArr, List<String> list);

    List<String> bLq();

    Cursor bLr();

    Cursor bLs();

    Cursor bLt();

    Cursor bLu();

    int bLv();

    int c(String[] strArr, String... strArr2);

    Cursor c(String str, String str2, List<String> list);

    void c(String str, x xVar);

    int[] c(String str, String str2, String str3, List<String> list);

    int[] c(String str, String str2, String[] strArr, List<String> list);

    Cursor cc(List<String> list);

    Cursor cd(List<String> list);

    Cursor ce(List<String> list);

    Cursor cf(List<String> list);

    Cursor ci(List<String> list);

    Cursor cj(List<String> list);

    List<String> ck(List<String> list);

    int[] cl(List<String> list);

    int[] cm(List<String> list);

    Cursor d(String str, String str2, List<String> list);

    String e(String str, String str2, List<String> list);

    x ez(long j);

    Cursor h(List<String> list, boolean z);

    int x(String str, byte[] bArr);
}
