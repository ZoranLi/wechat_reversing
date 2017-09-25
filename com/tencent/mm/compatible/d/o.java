package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class o {
    private RandomAccessFile gQR;
    private RandomAccessFile gQS;
    private a gQT;
    private ArrayList<a> gQU;
    private long pid = 0;

    public class a {
        int gQV;
        long gQW;
        long gQX;
        long gQY;
        int gQZ;
        final /* synthetic */ o gRa;
        long mLastIdle;

        public a(o oVar) {
            this.gRa = oVar;
            this.gQV = 0;
            this.gQW = 0;
            this.mLastIdle = 0;
            this.gQX = 0;
            this.gQY = 0;
            this.gQZ = 0;
        }

        public a(o oVar, long j) {
            this.gRa = oVar;
            this.gQX = j;
        }

        public final void a(String[] strArr, String str) {
            if (this.gQX <= 0) {
                e(strArr);
                return;
            }
            if (str != null && str.length() > 0) {
                String[] split = str.split("[ ]+");
                if (split != null && split.length > 0 && split[0] != null && Long.parseLong(split[0], 10) == this.gQX) {
                    long parseLong = Long.parseLong(split[13], 10);
                    long parseLong2 = Long.parseLong(split[14], 10);
                    long parseLong3 = ((parseLong + parseLong2) + Long.parseLong(split[15], 10)) + Long.parseLong(split[16], 10);
                    long parseLong4 = Long.parseLong(strArr[4], 10);
                    Object obj = 1;
                    long j = 0;
                    for (String str2 : strArr) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            j += Long.parseLong(str2, 10);
                        }
                    }
                    long j2 = j - this.gQW;
                    long j3 = parseLong3 - this.gQY;
                    this.gQV = (int) ((((float) (j2 - (parseLong4 - this.mLastIdle))) / ((float) j2)) * 100.0f);
                    this.gQZ = (int) ((((float) j3) / ((float) j2)) * 100.0f);
                    this.gQW = j;
                    this.mLastIdle = parseLong4;
                    this.gQY = parseLong3;
                    w.i(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(parseLong4), Integer.valueOf(this.gQV), Long.valueOf(this.gQX), Long.valueOf(parseLong3), Integer.valueOf(this.gQZ), Long.valueOf(parseLong), Long.valueOf(parseLong2), Long.valueOf(r12), Long.valueOf(r14), Long.valueOf(j2), Long.valueOf(r6), Long.valueOf(j3));
                    return;
                }
            }
            w.e(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", Long.valueOf(this.gQX), str);
        }

        public final void e(String[] strArr) {
            long parseLong = Long.parseLong(strArr[4], 10);
            long j = 0;
            Object obj = 1;
            for (String str : strArr) {
                if (obj != null) {
                    obj = null;
                } else {
                    j += Long.parseLong(str, 10);
                }
            }
            long j2 = j - this.gQW;
            this.gQV = (int) ((((float) (j2 - (parseLong - this.mLastIdle))) / ((float) j2)) * 100.0f);
            this.gQW = j;
            this.mLastIdle = parseLong;
            w.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j + "; idle=" + parseLong + "; usage=" + this.gQV);
        }
    }

    public o(long j) {
        this.pid = j;
    }

    private void update() {
        try {
            this.gQR = new RandomAccessFile("/proc/stat", "r");
            if (this.pid > 0) {
                this.gQS = new RandomAccessFile("/proc/" + this.pid + "/stat", "r");
            }
            rw();
            if (this.gQR != null) {
                this.gQR.close();
            }
            if (this.gQS != null) {
                this.gQS.close();
            }
        } catch (Throwable e) {
            w.printErrStackTrace(" MicroMsg.CpuUsage", e, "update e:", new Object[0]);
            if (this.gQR != null) {
                try {
                    this.gQR.close();
                } catch (Exception e2) {
                }
                this.gQR = null;
            }
            if (this.gQS != null) {
                try {
                    this.gQS.close();
                } catch (Exception e3) {
                }
                this.gQS = null;
            }
        }
    }

    private void rw() {
        String readLine;
        int i;
        String readLine2;
        int i2;
        String str = null;
        if (this.gQS != null) {
            try {
                this.gQS.seek(0);
                readLine = this.gQS.readLine();
            } catch (IOException e) {
                w.e(" MicroMsg.CpuUsage", "Ops pidStatFile: " + e);
            }
            if (this.gQR != null) {
                this.gQR.seek(0);
                i = -1;
                while (true) {
                    readLine2 = this.gQR.readLine();
                    if (readLine2 != null || readLine2.length() <= 0) {
                        w.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i));
                    } else {
                        String[] split = readLine2.split("[ ]+");
                        if (split[0].indexOf("cpu") != -1) {
                            if (i == -1) {
                                if (this.gQT == null) {
                                    this.gQT = new a(this, this.pid);
                                }
                                this.gQT.a(split, readLine);
                            } else {
                                try {
                                    if (this.gQU == null) {
                                        this.gQU = new ArrayList();
                                    }
                                    if (i < this.gQU.size()) {
                                        ((a) this.gQU.get(i)).e(split);
                                    } else {
                                        a aVar = new a(this);
                                        aVar.e(split);
                                        this.gQU.add(aVar);
                                    }
                                } catch (IOException e2) {
                                    w.e(" MicroMsg.CpuUsage", "Ops statFile: " + e2);
                                    return;
                                }
                            }
                        }
                    }
                    i2 = i + 1;
                    if (readLine2 == null) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
        readLine = str;
        if (this.gQR != null) {
            this.gQR.seek(0);
            i = -1;
            while (true) {
                readLine2 = this.gQR.readLine();
                if (readLine2 != null) {
                }
                w.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i));
                i2 = i + 1;
                if (readLine2 == null) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public final int rx() {
        return bg.bV(this.gQU) ? 1 : this.gQU.size();
    }

    public final int ry() {
        update();
        return this.gQT != null ? this.gQT.gQV : 0;
    }

    public final int rz() {
        int i = 0;
        if (this.gQT != null) {
            i = this.gQT.gQZ;
        }
        if (this.gQU == null || this.gQU.size() <= 1) {
            return i;
        }
        return i * this.gQU.size();
    }

    public final String toString() {
        update();
        StringBuffer stringBuffer = new StringBuffer();
        if (this.gQT != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.gQT.gQV);
            stringBuffer.append("%");
            if (this.pid > 0) {
                stringBuffer.append("pid(");
                stringBuffer.append(this.pid + ") :");
                stringBuffer.append(this.gQT.gQZ);
                stringBuffer.append("%");
            }
        }
        if (this.gQU != null) {
            for (int i = 0; i < this.gQU.size(); i++) {
                a aVar = (a) this.gQU.get(i);
                stringBuffer.append(" Cpu Core(" + i + ") : ");
                stringBuffer.append(aVar.gQV);
                stringBuffer.append("%");
            }
        }
        return stringBuffer.toString();
    }
}
