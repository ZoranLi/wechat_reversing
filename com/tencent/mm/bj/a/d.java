package com.tencent.mm.bj.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.bj.a.f.a;
import java.util.HashMap;

public interface d<T> extends Cursor {
    void a(a aVar);

    boolean a(Object obj, a aVar);

    boolean bB(Object obj);

    a bC(Object obj);

    SparseArray<T>[] bNJ();

    HashMap<Object, T> bNK();

    boolean bNL();

    void ka(boolean z);

    boolean yP(int i);

    a yQ(int i);

    void yR(int i);
}
