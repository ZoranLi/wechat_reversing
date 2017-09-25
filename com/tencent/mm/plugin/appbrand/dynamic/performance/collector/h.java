package com.tencent.mm.plugin.appbrand.dynamic.performance.collector;

import com.tencent.mm.sdk.platformtools.w;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class h implements b {
    private Map<String, CollectSession> iGX = new a();
    private Map<String, Set<CollectSession>> iIv = new a();

    private boolean a(String str, CollectSession collectSession) {
        if (str == null || str.length() == 0 || collectSession == null) {
            return false;
        }
        Set set = (Set) this.iIv.get(str);
        if (set == null) {
            set = new LinkedHashSet();
            this.iIv.put(str, set);
        }
        return set.add(collectSession);
    }

    private Set<CollectSession> oQ(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (Set) this.iIv.get(str);
    }

    public final void clear() {
        this.iGX.clear();
        this.iIv.clear();
    }

    private CollectSession oR(String str) {
        CollectSession collectSession = (CollectSession) this.iGX.get(str);
        if (collectSession != null) {
            return collectSession;
        }
        collectSession = new CollectSession(str);
        this.iGX.put(str, collectSession);
        return collectSession;
    }

    public final void a(CollectSession collectSession) {
        String str = collectSession.id;
        CollectSession collectSession2 = (CollectSession) this.iGX.get(str);
        if (collectSession2 == null) {
            this.iGX.put(str, collectSession);
            a(collectSession.groupId, collectSession);
            return;
        }
        TimePoint timePoint = collectSession.iIn;
        if (collectSession2.iIn == null) {
            collectSession2.iIn = timePoint;
            return;
        }
        while (timePoint != null) {
            String str2 = timePoint.name;
            long j = timePoint.time;
            if (!(str == null || str.length() == 0)) {
                CollectSession oR = oR(str);
                if (oR.iIn == null) {
                    oR.oG(str2);
                    oR.iIn.time = j;
                } else {
                    TimePoint timePoint2 = (TimePoint) oR.iIp.get(str2);
                    if (timePoint2 == null) {
                        oR.oH(str2);
                        oR.iIo.time = j;
                    } else {
                        timePoint2.time = (j + (timePoint2.time * ((long) timePoint2.iIw))) / ((long) (timePoint2.iIw + 1));
                        timePoint2.iIw++;
                    }
                }
            }
            timePoint = timePoint.iIx;
        }
    }

    public final CollectSession aQ(String str, String str2) {
        if (str == null || str.length() == 0) {
            w.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[]{str2});
            return null;
        }
        CollectSession oR = oR(str);
        if (oR.iIn == null) {
            oR.oG(str2);
            return oR;
        }
        oR.oH(str2);
        return oR;
    }

    public final void f(String str, String str2, boolean z) {
        if (!z) {
            return;
        }
        if (str == null || str.length() == 0) {
            w.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[]{str2});
            return;
        }
        CollectSession oR = oR(str);
        if (oR.iIn == null) {
            oR.oG(str2);
        } else {
            oR.oH(str2);
        }
    }

    public final void c(String str, String str2, String str3, boolean z) {
        if (!z) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            w.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[]{str3});
        } else if (str == null || str.length() == 0) {
            w.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[]{str3});
        } else {
            CollectSession oR = oR(str2);
            if (oR.iIn == null) {
                oR.groupId = str;
                a(str, oR);
                oR.oG(str3);
                return;
            }
            oR.oH(str3);
        }
    }

    public final CollectSession oI(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.iGX.get(str);
    }

    public final CollectSession oJ(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.iGX.remove(str);
    }

    public final void aR(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            w.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[]{str, str2});
            return;
        }
        CollectSession collectSession = (CollectSession) this.iGX.get(str);
        if (collectSession == null) {
            w.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[]{str, str2});
            return;
        }
        collectSession.iIq = str2;
    }

    public final void print(String str) {
        CollectSession collectSession = (CollectSession) this.iGX.get(str);
        if (collectSession == null) {
            w.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[]{str});
            return;
        }
        TimePoint timePoint = collectSession.iIn;
        if (timePoint == null) {
            w.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[]{str});
            return;
        }
        e.a(timePoint).insert(0, String.format("session : %s\n", new Object[]{collectSession.id}));
        w.i("MicroMsg.SumCostTimeCollector", "%s", new Object[]{r1.toString()});
    }

    public final StringBuilder oK(String str) {
        Collection oQ = oQ(str);
        if (oQ == null || oQ.isEmpty()) {
            w.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[]{str});
            return new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[]{str}));
        }
        Set<CollectSession> linkedHashSet = new LinkedHashSet(oQ);
        TimePoint timePoint = new TimePoint();
        for (CollectSession collectSession : linkedHashSet) {
            if (collectSession.iIo == null || !(collectSession.iIq == null || collectSession.iIo.name.equals(collectSession.iIq))) {
                w.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[]{collectSession.id});
            } else {
                TimePoint timePoint2 = collectSession.iIn;
                TimePoint timePoint3 = timePoint;
                while (timePoint2 != null) {
                    long j = (timePoint3.time * ((long) timePoint3.iIw)) + timePoint2.time;
                    int i = timePoint3.iIw + 1;
                    timePoint3.iIw = i;
                    timePoint3.time = j / ((long) i);
                    timePoint3.name = timePoint2.name;
                    timePoint2 = timePoint2.iIx;
                    if (timePoint3.iIx == null && timePoint2 != null) {
                        timePoint3.iIx = new TimePoint();
                    }
                    timePoint3 = timePoint3.iIx;
                }
            }
        }
        StringBuilder a = e.a(timePoint);
        a.insert(0, String.format("GroupId : %s, size : %d\n", new Object[]{str, Integer.valueOf(linkedHashSet.size())}));
        return a;
    }

    public final int aS(String str, String str2) {
        Collection oQ = oQ(str);
        if (oQ == null || oQ.isEmpty()) {
            w.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[]{str});
            return 0;
        }
        int i = 0;
        int i2 = 0;
        for (CollectSession collectSession : new LinkedHashSet(oQ)) {
            int i3 = collectSession.fMb.getInt(str2);
            if (i3 != 0) {
                i2 += i3;
                i++;
            }
        }
        if (i != 0) {
            return i2 / i;
        }
        return 0;
    }
}
