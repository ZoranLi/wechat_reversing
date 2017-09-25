package com.tencent.mm.network.a;

public interface a {

    public static class a {
        public long beginTime = 0;
        public String clientIp = "";
        public long endTime = 0;
        public int errCode = 0;
        public int errType = 0;
        public long expand1 = 0;
        public long expand2 = 0;
        public long hWj = 0;
        public c ifX;
        public boolean ifY = false;
        public long ifZ = 0;
        public long iga = 0;
        public long igb = 0;
        public int igc = 0;
        public int igd = 0;
        public long ige = 0;
        public long igf = 0;
        public long igg = 0;
        public long netSignal = 0;
        public int netType = 0;
        public int retryCount = 0;
        public long rtType = 0;

        public final String toString() {
            String str = "rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d";
            Object[] objArr = new Object[13];
            objArr[0] = Long.valueOf(this.rtType);
            objArr[1] = Long.valueOf(this.beginTime);
            objArr[2] = Long.valueOf(this.endTime);
            objArr[3] = Long.valueOf(this.endTime - this.beginTime);
            objArr[4] = Long.valueOf(this.hWj);
            objArr[5] = Long.valueOf(this.igb);
            objArr[6] = this.ifX == null ? "null" : this.ifX.toString();
            objArr[7] = Boolean.valueOf(this.ifY);
            objArr[8] = Integer.valueOf(this.netType);
            objArr[9] = Integer.valueOf(this.errType);
            objArr[10] = Integer.valueOf(this.errCode);
            objArr[11] = Long.valueOf(this.ifZ);
            objArr[12] = Long.valueOf(this.iga);
            return String.format(str, objArr);
        }
    }
}
