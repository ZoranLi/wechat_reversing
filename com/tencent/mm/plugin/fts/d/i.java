package com.tencent.mm.plugin.fts.d;

import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface i {

    public static class a {
        public int hPq = 0;
        public List<String> iJD = new LinkedList();
        public int mcN = Integer.MAX_VALUE;
        public boolean mcO = true;
        public int mcP = Integer.MAX_VALUE;
        public boolean mcQ = false;
        public List<com.tencent.mm.plugin.fts.a.a.i> mcR = null;
        public int mcS = 0;
    }

    public interface b {
        void a(i iVar, String str);
    }

    void QZ();

    void a(String str, ae aeVar, HashSet<String> hashSet);

    void axV();

    LinkedList<Integer> axW();

    int getType();

    int mS(int i);

    com.tencent.mm.plugin.fts.d.a.a mT(int i);
}
