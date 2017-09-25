package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DataRangeTracker {
    private static final String TAG = "DataRangeTracker";
    private Comparator<Range> mComparator = new Comparator<Range>() {
        public int compare(Range range, Range range2) {
            return (int) (range.first - range2.first);
        }
    };
    private final ArrayList<Range> mDownloadDataList = new ArrayList();

    private static class Range {
        public final long first;
        public final long second;

        public Range(long j, long j2) {
            this.first = j;
            this.second = j2;
        }

        public String toString() {
            return "[" + this.first + ", " + this.second + ']';
        }
    }

    public void addRange(long j, long j2) {
        if (j > j2) {
            Logger.e(TAG, "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", Long.valueOf(j), Long.valueOf(j2));
            return;
        }
        Logger.d(TAG, String.format("[addRange] [%d, %d]", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        Collection arrayList = new ArrayList();
        this.mDownloadDataList.add(new Range(j, j2));
        Collections.sort(this.mDownloadDataList, this.mComparator);
        int size = this.mDownloadDataList.size() - 1;
        Range range = (Range) this.mDownloadDataList.get(0);
        if (size > 0) {
            int i = 1;
            Range range2 = range;
            while (i <= size) {
                range = (Range) this.mDownloadDataList.get(i);
                if (range2.second + 1 < range.first) {
                    arrayList.add(new Range(range2.first, range2.second));
                    range = new Range(range.first, range.second);
                } else {
                    range = new Range(range2.first, range2.second > range.second ? range2.second : range.second);
                }
                if (i >= size) {
                    arrayList.add(range);
                }
                i++;
                range2 = range;
            }
            this.mDownloadDataList.clear();
            this.mDownloadDataList.addAll(arrayList);
        }
    }

    public long findStart(long j) {
        int i = 0;
        int size = this.mDownloadDataList.size();
        if (size == 0) {
            return -1;
        }
        long j2 = ((Range) this.mDownloadDataList.get(0)).second + 1;
        while (i < size) {
            if (j < ((Range) this.mDownloadDataList.get(i)).first) {
                return j2;
            }
            j2 = ((Range) this.mDownloadDataList.get(i)).second + 1;
            if (j <= ((Range) this.mDownloadDataList.get(i)).second) {
                return ((Range) this.mDownloadDataList.get(i)).second + 1;
            }
            i++;
        }
        return ((Range) this.mDownloadDataList.get(this.mDownloadDataList.size() - 1)).second + 1;
    }

    public long findEnd(long j) {
        int size = this.mDownloadDataList.size();
        if (size == 0) {
            return -1;
        }
        int i = 0;
        while (i < size) {
            if (j < ((Range) this.mDownloadDataList.get(i)).first) {
                return ((Range) this.mDownloadDataList.get(i)).first - 1;
            }
            if (j <= ((Range) this.mDownloadDataList.get(i)).second && i + 1 < size) {
                return ((Range) this.mDownloadDataList.get(i + 1)).first - 1;
            }
            i++;
        }
        return 0;
    }

    public boolean isCached(long j, int i) {
        long findStart = findStart(j);
        long findStart2 = findStart(((long) i) + j);
        long findEnd = findEnd(j);
        long findEnd2 = findEnd(((long) i) + j);
        if (findStart != findStart2 || findEnd != findEnd2 || findEnd == -1 || ((long) i) + j > findStart) {
            return false;
        }
        return true;
    }

    public long getContinuousEnd() {
        if (this.mDownloadDataList.size() == 0) {
            return -1;
        }
        return ((Range) this.mDownloadDataList.get(0)).second;
    }

    synchronized List<Range> getEmptyContentPairList(long j) {
        List<Range> arrayList;
        arrayList = new ArrayList();
        synchronized (this.mDownloadDataList) {
            Iterator it = this.mDownloadDataList.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (j2 < range.first) {
                    arrayList.add(new Range(j2, range.first - 1));
                }
                j2 = range.second + 1;
            }
        }
        if (j2 < j) {
            arrayList.add(new Range(j2, j - 1));
        }
        return arrayList;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.mDownloadDataList.size(); i++) {
            stringBuilder.append(((Range) this.mDownloadDataList.get(i)).toString());
        }
        return stringBuilder.toString();
    }
}
