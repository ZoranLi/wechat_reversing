package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public class JsapiPermissionWrapper implements Parcelable {
    public static final Creator<JsapiPermissionWrapper> CREATOR = new Creator<JsapiPermissionWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsapiPermissionWrapper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsapiPermissionWrapper[i];
        }
    };
    public static final JsapiPermissionWrapper sYZ = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper sZa = new JsapiPermissionWrapper(2);
    public static final JsapiPermissionWrapper sZb = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper sZc = new JsapiPermissionWrapper(4);
    public byte[] sZd;
    private int sZe;
    private Set<Integer> sZf;
    private Set<Integer> sZg;

    public JsapiPermissionWrapper() {
        this.sZd = null;
        this.sZe = 0;
        this.sZd = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        this.sZd = null;
        this.sZe = 0;
        if (bArr == null) {
            this.sZd = null;
        } else {
            this.sZd = bArr;
        }
    }

    public JsapiPermissionWrapper(int i) {
        this.sZd = null;
        this.sZe = 0;
        this.sZe = i;
        this.sZd = new byte[0];
    }

    public final int xX(int i) {
        int i2;
        if (this.sZg == null || !this.sZg.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 1;
        }
        if (this.sZf == null || !this.sZf.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 0;
        }
        if (this.sZe == 1) {
            if (i != 34 && i != 75) {
                return 1;
            }
            w.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (this.sZe == 2) {
            if (i != -3) {
                return 0;
            }
            return 1;
        } else if (this.sZe == 3) {
            if (i != 34 && i != 75 && i != 23) {
                return 1;
            }
            w.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (this.sZe == 4) {
            if (i != 34 && i != 75) {
                return 1;
            }
            w.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (i == -2 || i == -3) {
            return 1;
        } else {
            if (this.sZd == null || i < 0 || i >= this.sZd.length) {
                return 0;
            }
            return this.sZd[i];
        }
    }

    public final void a(int i, byte b) {
        int i2 = 0;
        if (this.sZd == null || i < 0 || i >= this.sZd.length) {
            String str = "MicroMsg.JsapiPermissionWrapper";
            String str2 = "setPermission pos out of range, %s, %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.sZd != null) {
                i2 = this.sZd.length;
            }
            objArr[1] = Integer.valueOf(i2);
            w.e(str, str2, objArr);
            return;
        }
        this.sZd[i] = b;
    }

    public final boolean nw(int i) {
        if (xX(i) == 1) {
            return true;
        }
        return false;
    }

    public static boolean bHm() {
        return true;
    }

    public String toString() {
        if (this.sZd == null) {
            return "null";
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(180);
        for (byte append : this.sZd) {
            stringBuilder.append(append);
        }
        String stringBuilder2 = stringBuilder.toString();
        w.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.sZd);
        parcel.writeInt(this.sZe);
        parcel.writeIntArray(bHn());
        parcel.writeIntArray(bHo());
    }

    public JsapiPermissionWrapper(Parcel parcel) {
        this.sZd = null;
        this.sZe = 0;
        this.sZd = parcel.createByteArray();
        this.sZe = parcel.readInt();
        o(parcel.createIntArray());
        p(parcel.createIntArray());
    }

    public final void toBundle(Bundle bundle) {
        bundle.putByteArray("jsapi_perm_wrapper_bytes", this.sZd);
        bundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.sZe);
        bundle.putIntArray("jsapi_perm_wrapper_blacklist", bHn());
        bundle.putIntArray("jsapi_perm_wrapper_whitelist", bHo());
    }

    public final void fromBundle(Bundle bundle) {
        this.sZd = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.sZe = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        o(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        p(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    }

    private int[] bHn() {
        if (this.sZf == null) {
            return new int[0];
        }
        int[] iArr = new int[this.sZf.size()];
        int i = 0;
        for (Integer num : this.sZf) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void o(int[] iArr) {
        if (this.sZf == null) {
            this.sZf = new HashSet();
        } else {
            this.sZf.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.sZf.add(Integer.valueOf(valueOf));
            }
        }
    }

    private int[] bHo() {
        if (this.sZg == null) {
            return new int[0];
        }
        int[] iArr = new int[this.sZg.size()];
        int i = 0;
        for (Integer num : this.sZg) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void p(int[] iArr) {
        if (this.sZg == null) {
            this.sZg = new HashSet();
        } else {
            this.sZg.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.sZg.add(Integer.valueOf(valueOf));
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsapiPermissionWrapper)) {
            return false;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) obj;
        if (this.sZd == jsapiPermissionWrapper.sZd) {
            return true;
        }
        if (this.sZd == null || jsapiPermissionWrapper.sZd == null || this.sZd.length != jsapiPermissionWrapper.sZd.length) {
            return false;
        }
        for (int i = 0; i < this.sZd.length; i++) {
            if (this.sZd[i] != jsapiPermissionWrapper.sZd[i]) {
                return false;
            }
        }
        return true;
    }
}
