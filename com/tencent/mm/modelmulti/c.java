package com.tencent.mm.modelmulti;

import java.util.ArrayList;

public interface c {

    public static class a {
        long fLh;
        long fileLenInvalidCount;
        final String hJW;
        long hJX;
        long hJY;
        long hJZ;
        int hKa;
        ArrayList<b> hKb = new ArrayList(20);
        ArrayList<c> hKc = new ArrayList(20);
        boolean hKd = false;

        a(String str) {
            this.hJW = str;
        }

        public final String toString() {
            return String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[]{Integer.valueOf(hashCode()), this.hJW, Boolean.valueOf(this.hKd), Long.valueOf(this.hJX), Long.valueOf(this.hJY), Long.valueOf(this.fLh), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.hKb.size()), Integer.valueOf(this.hKc.size()), Long.valueOf(this.hJZ), Integer.valueOf(this.hKa)});
        }
    }

    public static class b {
        long fLh;
        long fileLenInvalidCount;
        final String hJW;
        long hJX;
        long hJY;
        boolean hKd = false;
        final int tag;

        b(String str, int i) {
            this.hJW = str;
            this.tag = i;
        }

        public final String toString() {
            return String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.hJW, Boolean.valueOf(this.hKd), Long.valueOf(this.hJX), Long.valueOf(this.hJY), Long.valueOf(this.fLh), Long.valueOf(this.fileLenInvalidCount)});
        }
    }

    public static class c {
        long fLh;
        final String hJW;
        long hJX;
        long hJY;
        boolean hKd = false;
        long hKe;

        c(String str) {
            this.hJW = str;
        }

        public final String toString() {
            return String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[]{Integer.valueOf(hashCode()), this.hJW, Boolean.valueOf(this.hKd), Long.valueOf(this.hJX), Long.valueOf(this.hJY), Long.valueOf(this.fLh), Long.valueOf(this.hKe)});
        }
    }

    void a(int i, a aVar);
}
