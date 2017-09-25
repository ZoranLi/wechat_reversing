package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.mm.protocal.c.lu;
import junit.framework.Assert;

public interface p {

    public static class a {
        private static SparseArray<p> nyF = new SparseArray();

        public static void a(int i, p pVar) {
            Assert.assertTrue(nyF.get(i) == null);
            nyF.put(i, pVar);
        }

        public static p pk(int i) {
            return (p) nyF.get(i);
        }
    }

    void a(lu luVar, byte[] bArr, boolean z, r rVar);
}
