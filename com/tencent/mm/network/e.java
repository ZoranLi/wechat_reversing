package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public interface e {
    boolean BS();

    c Cc();

    h Cd();

    void Ce();

    int a(q qVar, k kVar);

    int a(String str, boolean z, List<String> list);

    void a(int i, String str, int i2, boolean z);

    void a(b bVar);

    void a(n nVar);

    void a(ab abVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    void aZ(boolean z);

    void ba(boolean z);

    void bb(boolean z);

    void bc(boolean z);

    void cancel(int i);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void hv(String str);

    void hw(String str);

    void keepSignalling();

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
