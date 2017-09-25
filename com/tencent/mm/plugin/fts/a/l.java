package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.kernel.b.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.i;

public interface l extends c {
    void addSOSHistory(String str);

    void cancelSearchTask(a aVar);

    void deleteSOSHistory(String str);

    f getFTSIndexDB();

    g getFTSIndexStorage(int i);

    h getFTSMainDB();

    k getFTSTaskDaemon();

    boolean isFTSContextReady();

    boolean isFTSIndexReady();

    void registerIndexStorage(g gVar);

    void registerNativeLogic(int i, i iVar);

    a search(int i, f fVar);

    int stringCompareUtfBinary(String str, String str2);

    void unregisterIndexStorage(int i);

    void unregisterNativeLogic(int i);

    void updateTopHitsRank(String str, i iVar, int i);
}
