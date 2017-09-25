package com.tencent.mm.plugin.appbrand.dynamic.performance.collector;

import com.tencent.mm.sdk.platformtools.w;

public final class e {
    public static StringBuilder a(TimePoint timePoint) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (timePoint == null) {
            w.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
            return stringBuilder;
        }
        stringBuilder.append(0).append(". ").append(timePoint.name).append(" : ");
        stringBuilder.append(timePoint.time);
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.iIw);
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.time - timePoint.time);
        TimePoint timePoint2 = timePoint;
        while (timePoint2.iIx != null) {
            TimePoint timePoint3 = timePoint2.iIx;
            stringBuilder.append("\n");
            stringBuilder.append(i + 1).append(". ").append(timePoint3.name).append(" : ");
            stringBuilder.append(((double) (timePoint3.time - timePoint2.time)) / 1000000.0d);
            i++;
            timePoint2 = timePoint3;
        }
        stringBuilder.append("\n");
        stringBuilder.append("total cost : ").append(((double) (timePoint2.time - timePoint.time)) / 1000000.0d);
        return stringBuilder;
    }
}
