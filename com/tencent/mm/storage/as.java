package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface as extends g {

    public interface a {
        void a(ae aeVar, as asVar);
    }

    public interface b {
        String a(int i, String str, String str2, int i2, Context context);

        void a(au auVar, PString pString, PString pString2, PInt pInt, boolean z);
    }

    boolean Ap(String str);

    void RA(String str);

    void RB(String str);

    int RC(String str);

    void Rl(String str);

    ae Rm(String str);

    void Rn(String str);

    boolean Ro(String str);

    boolean Rp(String str);

    boolean Rq(String str);

    boolean Rr(String str);

    boolean Rs(String str);

    boolean Rt(String str);

    Cursor Ru(String str);

    Cursor Rv(String str);

    int Rw(String str);

    String Rx(String str);

    ae Ry(String str);

    int Rz(String str);

    void X(au auVar);

    int a(ae aeVar, String str);

    int a(ae aeVar, String str, boolean z);

    Cursor a(String str, List<String> list, String str2, boolean z);

    Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2);

    com.tencent.mm.vending.b.b a(e eVar);

    void a(d dVar);

    void a(ae aeVar, int i, int i2);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    String aA(int i, String str);

    void aw(LinkedList<String> linkedList);

    Cursor b(String str, List<String> list, boolean z, String str2);

    void b(a aVar);

    boolean b(String str, int i, boolean z, int i2);

    boolean bLC();

    boolean bLD();

    HashMap<String, Long> bLE();

    void bLF();

    List<String> bLH();

    List<String> bLI();

    Cursor bLJ();

    int bLK();

    String bLL();

    Cursor bLM();

    ae bLN();

    Cursor c(String str, List<String> list, String str2);

    void c(a aVar);

    Cursor cG(String str, int i);

    long d(ae aeVar);

    void e(String[] strArr, String str);

    Cursor eK(String str, String str2);

    boolean f(ae aeVar);

    int fM(String str);

    boolean g(ae aeVar);

    Cursor j(List<String> list, int i);

    Cursor o(String str, List<String> list);

    b oG();

    Cursor p(String str, List<String> list);

    boolean wV(String str);
}
