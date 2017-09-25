package com.tencent.mm.plugin.exdevice.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public final class b {
    public static long vx(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.exdevice.Util", "mac string is null or nil");
            return 0;
        }
        String[] split = str.toUpperCase(Locale.US).split(":");
        Byte[] bArr = new Byte[split.length];
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str2 = split[i];
            bArr[i2] = Byte.valueOf((byte) ((((byte) str2.charAt(0)) >= (byte) 65 ? ((str2.charAt(0) - 65) + 10) << 4 : (str2.charAt(0) - 48) << 4) | (((byte) str2.charAt(1)) >= (byte) 65 ? (str2.charAt(1) - 65) + 10 : str2.charAt(1) - 48)));
            i++;
            i2++;
        }
        long j = 0;
        int i3 = 0;
        int length2 = split.length - 1;
        while (i3 < bArr.length) {
            long longValue = ((bArr[i3].longValue() & 255) << (length2 << 3)) | j;
            i3++;
            length2--;
            j = longValue;
        }
        return j;
    }

    public static String bG(long j) {
        int i = 0;
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < 6; i2++) {
            bArr[i2] = (byte) ((int) (j >> (40 - (i2 << 3))));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < 6) {
            if (i != 0) {
                stringBuilder.append(":");
            }
            int i3 = bArr[i] & 255;
            if (i3 < 16) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(i3));
            i++;
        }
        return stringBuilder.toString().toUpperCase(Locale.US);
    }

    public static String aj(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return w(bArr, bArr.length);
    }

    public static String w(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        if (bArr.length < i) {
            w.w("MicroMsg.exdevice.Util", "data length is shorter then print command length");
            i = bArr.length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = bArr[i2] & 255;
            if (i3 < 16) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(i3));
        }
        return stringBuilder.toString().toUpperCase(Locale.US);
    }

    public static long ak(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j |= (((long) bArr[i]) & 255) << ((7 - i) << 3);
        }
        return j;
    }

    public static String aqH() {
        int i = 7;
        int i2 = 0;
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            i2 = bg.getInt(String.valueOf(Calendar.getInstance().get(7)), 0);
            if (i2 != 1) {
                i = i2 - 1;
            }
        } catch (Exception e) {
            w.e("MicroMsg.exdevice.Util", "parse day failed : %s", new Object[]{e.getMessage()});
            i = i2;
        }
        return format + i;
    }

    public static String bH(long j) {
        int i = 0;
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < 6; i2++) {
            bArr[i2] = (byte) ((int) (j >> (40 - (i2 << 3))));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < 6) {
            int i3 = bArr[i] & 255;
            if (i3 < 16) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(i3));
            i++;
        }
        return stringBuilder.toString().toUpperCase(Locale.US);
    }

    public static String vy(String str) {
        if (str == null || 12 != str.length()) {
            w.e("MicroMsg.exdevice.Util", "%s is not server string mac", new Object[]{str});
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 0;
        while (i < str.length()) {
            stringBuilder.append(str.charAt(i));
            if (i % 2 != 0 && i < str.length() - 1) {
                stringBuilder.append(":");
            }
            i++;
        }
        w.i("MicroMsg.exdevice.Util", "%s to %s is ok", new Object[]{str, stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static long aqI() {
        long j;
        String value = g.sV().getValue("DeviceAutoSyncDuration");
        if (bg.mA(value)) {
            j = 60000;
        } else {
            try {
                j = Long.parseLong(value) * 1000;
            } catch (Exception e) {
                w.e("MicroMsg.exdevice.Util", "parse string to time out long failed : %s", new Object[]{e.getMessage()});
                j = 60000;
            }
        }
        w.i("MicroMsg.exdevice.Util", "now sync time out is %d", new Object[]{Long.valueOf(j)});
        if (j == 0) {
            return 60000;
        }
        return j;
    }

    public static boolean bY(String str, String str2) {
        w.i("MicroMsg.exdevice.Util", "isDeviceInDeviceList, device = %s, device list = %s", new Object[]{str, str2});
        if (bg.mA(str) || bg.mA(str2)) {
            return false;
        }
        try {
            String[] split = str2.split("\\|");
            if (split == null) {
                w.e("MicroMsg.exdevice.Util", "null == deviceArray");
                return false;
            }
            for (String equalsIgnoreCase : split) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            w.e("MicroMsg.exdevice.Util", "aDeviceList.split failed, %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    public static String bZ(String str, String str2) {
        w.i("MicroMsg.exdevice.Util", "moveDevicefromDeviceList, device = %s, device list = %s", new Object[]{str, str2});
        if (bg.mA(str) || bg.mA(str2)) {
            w.w("MicroMsg.exdevice.Util", "parameters is null or nil");
            return null;
        }
        try {
            String[] split = str2.split("\\|");
            if (split == null) {
                w.e("MicroMsg.exdevice.Util", "null == strArray");
                return null;
            }
            String str3 = new String();
            int i = 0;
            for (String str4 : split) {
                if (str4.equalsIgnoreCase(str)) {
                    i = 1;
                } else {
                    str3 = (str3 + str4) + "|";
                }
            }
            if (i == 0) {
                w.e("MicroMsg.exdevice.Util", "remove failed!!!, this device is not in the list");
                return null;
            }
            w.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[]{str2});
            return str3;
        } catch (Exception e) {
            w.e("MicroMsg.exdevice.Util", "aDeviceList.split failed!!!, %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static UUID al(byte[] bArr) {
        w.d("MicroMsg.exdevice.Util", "parseUUIDFromByteArray, uuid byte array = %s", new Object[]{aj(bArr)});
        if (bg.bm(bArr)) {
            w.e("MicroMsg.exdevice.Util", "aUUIDByteArray is null or nil");
            return null;
        } else if (16 != bArr.length) {
            w.e("MicroMsg.exdevice.Util", "the length (%d) of this byte array is not 16", new Object[]{Integer.valueOf(bArr.length)});
            return null;
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            ByteBuffer allocate2 = ByteBuffer.allocate(8);
            try {
                allocate.put(bArr, 0, 8);
                allocate.flip();
                allocate2.put(bArr, 8, 8);
                allocate2.flip();
                w.d("MicroMsg.exdevice.Util", "parse successful, string of uuid = %s", new Object[]{new UUID(allocate.getLong(), allocate2.getLong()).toString()});
                return new UUID(allocate.getLong(), allocate2.getLong());
            } catch (Exception e) {
                w.e("MicroMsg.exdevice.Util", "%s", new Object[]{e.getMessage()});
                return null;
            }
        }
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2) {
        if (bg.bm(bArr) || bg.bm(bArr2) || bArr2.length + i > bArr.length || i < 0 || i >= bArr.length) {
            return false;
        }
        int i2 = 0;
        while (i2 < bArr2.length && bArr2[i2] == bArr[i2 + i]) {
            i2++;
        }
        if (i2 == bArr2.length) {
            return true;
        }
        return false;
    }

    public static byte[] aR(Object obj) {
        ObjectOutputStream objectOutputStream;
        byte[] toByteArray;
        Throwable e;
        Throwable th;
        Throwable th2;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                toByteArray = byteArrayOutputStream.toByteArray();
                if (toByteArray == null) {
                    try {
                        w.e("MicroMsg.exdevice.Util", "object2bytes result is null");
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            w.e("MicroMsg.exdevice.Util", "object2bytes IOException:" + e.getMessage());
                            w.printErrStackTrace("MicroMsg.exdevice.Util", e, "", new Object[0]);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Throwable e3) {
                                    w.printErrStackTrace("MicroMsg.exdevice.Util", e3, "", new Object[0]);
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e32) {
                                w.printErrStackTrace("MicroMsg.exdevice.Util", e32, "", new Object[0]);
                            }
                            return toByteArray;
                        } catch (Throwable th3) {
                            th = th3;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Throwable e322) {
                                    w.printErrStackTrace("MicroMsg.exdevice.Util", e322, "", new Object[0]);
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e3222) {
                                w.printErrStackTrace("MicroMsg.exdevice.Util", e3222, "", new Object[0]);
                            }
                            throw th;
                        }
                    }
                }
                try {
                    objectOutputStream.close();
                } catch (Throwable e32222) {
                    w.printErrStackTrace("MicroMsg.exdevice.Util", e32222, "", new Object[0]);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e322222) {
                    w.printErrStackTrace("MicroMsg.exdevice.Util", e322222, "", new Object[0]);
                }
            } catch (Throwable th4) {
                th2 = th4;
                toByteArray = null;
                e322222 = th2;
                w.e("MicroMsg.exdevice.Util", "object2bytes IOException:" + e322222.getMessage());
                w.printErrStackTrace("MicroMsg.exdevice.Util", e322222, "", new Object[0]);
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                byteArrayOutputStream.close();
                return toByteArray;
            }
        } catch (Throwable th42) {
            objectOutputStream = null;
            th2 = th42;
            toByteArray = null;
            e322222 = th2;
            w.e("MicroMsg.exdevice.Util", "object2bytes IOException:" + e322222.getMessage());
            w.printErrStackTrace("MicroMsg.exdevice.Util", e322222, "", new Object[0]);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Throwable th5) {
            th42 = th5;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th42;
        }
        return toByteArray;
    }

    public static Object am(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable e;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        if (bArr != null) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    readObject = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.exdevice.Util", e2, "", new Object[0]);
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.exdevice.Util", e22, "", new Object[0]);
                    }
                } catch (StreamCorruptedException e3) {
                    e22 = e3;
                    try {
                        w.e("MicroMsg.exdevice.Util", "bytes2object StreamCorruptedException:" + e22.getMessage());
                        w.printErrStackTrace("MicroMsg.exdevice.Util", e22, "", new Object[0]);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Throwable e222) {
                                w.printErrStackTrace("MicroMsg.exdevice.Util", e222, "", new Object[0]);
                            }
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable e2222) {
                            w.printErrStackTrace("MicroMsg.exdevice.Util", e2222, "", new Object[0]);
                        }
                        return readObject;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Throwable e22222) {
                                w.printErrStackTrace("MicroMsg.exdevice.Util", e22222, "", new Object[0]);
                            }
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable e222222) {
                            w.printErrStackTrace("MicroMsg.exdevice.Util", e222222, "", new Object[0]);
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e222222 = e4;
                    w.e("MicroMsg.exdevice.Util", "bytes2object IOException:" + e222222.getMessage());
                    w.printErrStackTrace("MicroMsg.exdevice.Util", e222222, "", new Object[0]);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable e2222222) {
                            w.printErrStackTrace("MicroMsg.exdevice.Util", e2222222, "", new Object[0]);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable e22222222) {
                        w.printErrStackTrace("MicroMsg.exdevice.Util", e22222222, "", new Object[0]);
                    }
                    return readObject;
                } catch (ClassNotFoundException e5) {
                    e22222222 = e5;
                    w.e("MicroMsg.exdevice.Util", "bytes2object ClassNotFoundException:" + e22222222.getMessage());
                    w.printErrStackTrace("MicroMsg.exdevice.Util", e22222222, "", new Object[0]);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable e222222222) {
                            w.printErrStackTrace("MicroMsg.exdevice.Util", e222222222, "", new Object[0]);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable e2222222222) {
                        w.printErrStackTrace("MicroMsg.exdevice.Util", e2222222222, "", new Object[0]);
                    }
                    return readObject;
                }
            } catch (StreamCorruptedException e6) {
                e2222222222 = e6;
                objectInputStream = objectInputStream2;
                w.e("MicroMsg.exdevice.Util", "bytes2object StreamCorruptedException:" + e2222222222.getMessage());
                w.printErrStackTrace("MicroMsg.exdevice.Util", e2222222222, "", new Object[0]);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (IOException e7) {
                e2222222222 = e7;
                objectInputStream = objectInputStream2;
                w.e("MicroMsg.exdevice.Util", "bytes2object IOException:" + e2222222222.getMessage());
                w.printErrStackTrace("MicroMsg.exdevice.Util", e2222222222, "", new Object[0]);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e8) {
                e2222222222 = e8;
                objectInputStream = objectInputStream2;
                w.e("MicroMsg.exdevice.Util", "bytes2object ClassNotFoundException:" + e2222222222.getMessage());
                w.printErrStackTrace("MicroMsg.exdevice.Util", e2222222222, "", new Object[0]);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable e22222222222) {
                objectInputStream = objectInputStream2;
                th = e22222222222;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                throw th;
            }
        }
        return readObject;
    }

    public static int v(Context context, int i) {
        int i2 = 0;
        if (context != null) {
            try {
                Rect rect = new Rect();
                ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                i2 = ((Activity) context).getWindow().getDecorView().getHeight();
                if (i2 - rect.height() >= 0) {
                    i2 -= rect.height();
                } else {
                    i2 = rect.top;
                }
            } catch (Exception e) {
                w.i("MicroMsg.exdevice.Util", "getStatusHeight err: %s", new Object[]{e.toString()});
                return i;
            } catch (Throwable th) {
                return i;
            }
        }
        if (i2 <= 0) {
            return i;
        }
        return i2;
    }
}
