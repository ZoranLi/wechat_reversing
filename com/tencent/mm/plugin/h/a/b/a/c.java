package com.tencent.mm.plugin.h.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.a.g.a;
import com.tencent.mm.plugin.h.a.b.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class c {
    public static final String TAG = c.class.getName();
    private static HashMap<String, Long> jSd = new HashMap();
    private static HashMap<String, Long> jTo;

    static {
        HashMap hashMap = new HashMap();
        jTo = hashMap;
        hashMap.put(h.jSt, Long.valueOf(1));
        jTo.put(h.jSu, Long.valueOf(1));
        jTo.put(h.jSv, Long.valueOf(16));
        jTo.put(h.jSw, Long.valueOf(16));
        jTo.put(h.jSx, Long.valueOf(16));
        jTo.put(h.jSy, Long.valueOf(16));
        jSd.put(h.jSq, Long.valueOf(0));
        jSd.put(h.jSz, Long.valueOf(2));
        jSd.put(h.jSC, Long.valueOf(4));
        jSd.put(h.jSG, Long.valueOf(8));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Z(byte[] r12) {
        /*
        r11 = 16;
        r10 = 2;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bg.bm(r12);
        if (r2 == 0) goto L_0x0014;
    L_0x000b:
        r1 = TAG;
        r2 = "parseBroadcastServiceUuid error. broadcast data is null or nil";
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r0;
    L_0x0015:
        if (r2 < 0) goto L_0x0013;
    L_0x0017:
        r3 = r12.length;
        if (r2 >= r3) goto L_0x0013;
    L_0x001a:
        r4 = r2 + 1;
        r2 = r12[r2];
        r3 = r4 + r2;
        r5 = r12.length;
        if (r3 <= r5) goto L_0x0042;
    L_0x0023:
        r3 = TAG;
        r5 = "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r4 = java.lang.Integer.valueOf(r4);
        r6[r0] = r4;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r1] = r2;
        r1 = r12.length;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r10] = r1;
        com.tencent.mm.sdk.platformtools.w.w(r3, r5, r6);
        goto L_0x0013;
    L_0x0042:
        if (r2 > 0) goto L_0x0055;
    L_0x0044:
        r3 = TAG;
        r4 = "current part of data's len = %d.";
        r1 = new java.lang.Object[r1];
        r2 = java.lang.Integer.valueOf(r2);
        r1[r0] = r2;
        com.tencent.mm.sdk.platformtools.w.w(r3, r4, r1);
        goto L_0x0013;
    L_0x0055:
        r3 = r4 + 1;
        r4 = r12[r4];
        r2 = r2 + -1;
        switch(r4) {
            case -1: goto L_0x00f0;
            case 0: goto L_0x005e;
            case 1: goto L_0x005e;
            case 2: goto L_0x0060;
            case 3: goto L_0x0060;
            case 4: goto L_0x005e;
            case 5: goto L_0x005e;
            case 6: goto L_0x0118;
            case 7: goto L_0x0118;
            default: goto L_0x005e;
        };
    L_0x005e:
        r2 = r2 + r3;
        goto L_0x0015;
    L_0x0060:
        if (r10 > r2) goto L_0x0099;
    L_0x0062:
        r4 = r3 + 1;
        r3 = r12[r3];
        r5 = r3 & 255;
        r3 = r4 + 1;
        r4 = r12[r4];
        r4 = r4 & 255;
        r4 = r4 << 8;
        r4 = r4 | r5;
        r2 = r2 + -2;
        r5 = "%08x-0000-1000-8000-00805f9b34fb";
        r6 = new java.lang.Object[r1];
        r4 = java.lang.Integer.valueOf(r4);
        r6[r0] = r4;
        r4 = java.lang.String.format(r5, r6);
        r5 = TAG;
        r6 = "find 16-bit broacast service = %s";
        r7 = new java.lang.Object[r1];
        r7[r0] = r4;
        com.tencent.mm.sdk.platformtools.w.d(r5, r6, r7);
        r5 = jSd;
        r4 = r5.containsKey(r4);
        if (r4 == 0) goto L_0x0060;
    L_0x0096:
        r0 = r1;
        goto L_0x0013;
    L_0x0099:
        r2 = r2 + r3;
        goto L_0x0015;
    L_0x009c:
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
    L_0x00a1:
        if (r11 > r3) goto L_0x00ec;
    L_0x00a3:
        r2 = 16;
        r2 = java.nio.ByteBuffer.wrap(r12, r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.order(r5);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = new java.util.UUID;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2.<init>(r8, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = TAG;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = "find 128-bit broacast service = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        com.tencent.mm.sdk.platformtools.w.d(r5, r6, r7);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = jSd;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r5.containsKey(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        if (r2 == 0) goto L_0x009c;
    L_0x00d6:
        r0 = r1;
        goto L_0x0013;
    L_0x00d9:
        r2 = move-exception;
        r5 = "BlueToothDeviceFilter.parseUUID";
        r2 = r2.toString();	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.w.e(r5, r2);	 Catch:{ all -> 0x00ea }
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
        goto L_0x00a1;
    L_0x00ea:
        r0 = move-exception;
        throw r0;
    L_0x00ec:
        r2 = r4 + r3;
        goto L_0x0015;
    L_0x00f0:
        r4 = TAG;
        r5 = "Manufacturer Specific Data size = %s";
        r6 = new java.lang.Object[r1];
        r7 = java.lang.Integer.valueOf(r2);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r4 = TAG;
        r5 = "Manufacturer Specific Data = %s";
        r6 = new java.lang.Object[r1];
        r7 = r3 + r2;
        r7 = java.util.Arrays.copyOfRange(r12, r3, r7);
        r7 = com.tencent.mm.plugin.exdevice.j.b.aj(r7);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        goto L_0x005e;
    L_0x0118:
        r4 = r3;
        r3 = r2;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.h.a.b.a.c.Z(byte[]):boolean");
    }

    public static String aJ(long j) {
        for (String str : jSd.keySet()) {
            if (((Long) jSd.get(str)).longValue() == j) {
                return str;
            }
        }
        if (jTo.containsValue(Long.valueOf(j))) {
            return h.jSq;
        }
        return null;
    }

    public static long a(BluetoothGattService bluetoothGattService) {
        long j = 0;
        if (bluetoothGattService == null) {
            w.e(TAG, "service is null");
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        Long l;
        if (!uuid.equalsIgnoreCase(h.jSq) || bluetoothGattService.getCharacteristic(UUID.fromString(h.jSt)) == null) {
            l = (Long) jSd.get(uuid);
            if (l != null) {
                j = l.longValue();
            }
            w.d(TAG, "service uuid = %s, profileType = %d", new Object[]{uuid, Long.valueOf(j)});
            return j;
        }
        List characteristics = bluetoothGattService.getCharacteristics();
        long j2 = 0;
        int i = 0;
        while (i < characteristics.size()) {
            l = (Long) jTo.get(((BluetoothGattCharacteristic) characteristics.get(i)).getUuid().toString());
            i++;
            j2 = (l == null ? 0 : l.longValue()) | j2;
        }
        w.d(TAG, "wechat service, profileType = %d", new Object[]{Long.valueOf(j2)});
        return j2;
    }

    public static boolean b(BluetoothGattService bluetoothGattService) {
        if (bluetoothGattService == null) {
            w.e(TAG, "service is null");
            return false;
        }
        long a = a(bluetoothGattService);
        BluetoothGattCharacteristic characteristic;
        int properties;
        if (0 != (1 & a)) {
            if (bluetoothGattService == null) {
                w.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSt));
            if (characteristic == null) {
                w.e(TAG, "no step measurement characteristic found");
                return false;
            }
            properties = characteristic.getProperties();
            w.d(TAG, "step measurement characteristic properties = %d", new Object[]{Integer.valueOf(properties)});
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                w.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSu));
            if (characteristic != null) {
                properties = characteristic.getProperties();
                if ((properties & 2) == 0 || (properties & 32) == 0) {
                    w.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                    return false;
                }
            }
            return true;
        } else if (0 != (2 & a)) {
            if (bluetoothGattService == null) {
                w.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSA));
            if (characteristic == null) {
                w.e(TAG, "weight scale feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                w.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSB));
            if (characteristic == null) {
                w.e(TAG, "weight measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) != 0) {
                return true;
            }
            w.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
            return false;
        } else if (0 != (4 & a)) {
            if (bluetoothGattService == null) {
                w.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSD));
            if (characteristic == null) {
                w.e(TAG, "heart rate measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 16) == 0) {
                w.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSE));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 2) == 0) {
                    w.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                    return false;
                }
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSF));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 8) == 0) {
                    w.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(8)});
                    return false;
                }
            }
            return true;
        } else if (0 != (8 & a)) {
            if (bluetoothGattService == null) {
                w.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSH));
            if (characteristic == null) {
                w.e(TAG, "blood pressure measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                w.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSJ));
            if (characteristic == null) {
                w.e(TAG, "blood pressure feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                w.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSI));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 16) == 0) {
                    w.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                    return false;
                }
            }
            return true;
        } else if (0 == (a & 16)) {
            return false;
        } else {
            if (bluetoothGattService == null) {
                w.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSv));
            if (characteristic == null) {
                w.e(TAG, "light color characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 16) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                w.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSw));
            if (characteristic == null) {
                w.e(TAG, "light work state characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                w.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSx));
            if (characteristic == null) {
                w.e(TAG, "light state changed characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                w.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jSy));
            if (characteristic == null) {
                w.e(TAG, "control point characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) != 0 && (properties & 8) != 0) {
                return true;
            }
            w.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
            return false;
        }
    }

    public static byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        boolean z = false;
        if (bluetoothGattCharacteristic == null || bArr == null) {
            w.e(TAG, "characteristic or recvData is null");
            return null;
        }
        long j = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j = a(service);
        } else {
            w.e(TAG, "the characteristic has no parent service");
        }
        w.d(TAG, "recv data. uuid = %s, data = %s", new Object[]{uuid, b.aj(bArr)});
        boolean z2;
        int i;
        int i2;
        byte[] aR;
        if (0 != (1 & j) && (uuid.equalsIgnoreCase(f.jTQ) || uuid.equalsIgnoreCase(f.jTR))) {
            f fVar = new f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                w.e(f.TAG, "pase step data error");
                z2 = false;
            } else if (uuid == null || !(uuid.equals(f.jTQ) || uuid.equals(f.jTR))) {
                w.e(f.TAG, "uuid is not correct");
                z2 = false;
            } else {
                fVar.jSL = uuid;
                i = 4;
                if ((bArr[0] & 2) != 0) {
                    i = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i += 3;
                }
                if (i > bArr.length) {
                    w.e(f.TAG, "data len is not enough");
                    z2 = false;
                } else {
                    fVar.jTS = 0;
                    i2 = 0;
                    i = 1;
                    while (i2 < 3) {
                        fVar.jTS += (bArr[i] & 255) << (i2 * 8);
                        i2++;
                        i++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        fVar.jTT = 0;
                        i2 = 0;
                        while (i2 < 3) {
                            fVar.jTT += (bArr[i] & 255) << (i2 * 8);
                            i2++;
                            i++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        fVar.jTU = 0;
                        i2 = i;
                        for (i = 0; i < 3; i++) {
                            fVar.jTU += (bArr[i2] & 255) << (i * 8);
                            i2++;
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                aR = b.aR(fVar);
                w.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[]{Integer.valueOf(fVar.jTS), Integer.valueOf(fVar.jTT), Integer.valueOf(fVar.jTU)});
                return aR;
            }
            w.e(TAG, "parse step data error");
            return null;
        } else if (0 != (2 & j) && (uuid.equalsIgnoreCase(g.jSB) || uuid.equalsIgnoreCase(g.jSA))) {
            g gVar = new g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                w.e(g.TAG, "characteristicUuid or data is null or nil");
                z2 = false;
            } else {
                gVar.jSL = uuid;
                String str;
                Object[] objArr;
                if (gVar.jSL.equalsIgnoreCase(g.jSA)) {
                    if (4 > bArr.length) {
                        w.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[]{Integer.valueOf(bArr.length)});
                        z2 = false;
                    } else {
                        gVar.jTX = new com.tencent.mm.plugin.h.a.b.a.g.c();
                        gVar.jTX.jUd = (bArr[0] & 1) != 0;
                        gVar.jTX.jUe = (bArr[0] & 2) != 0;
                        gVar.jTX.jUf = (bArr[0] & 4) != 0;
                        gVar.jTX.jUg = (byte) ((bArr[0] & 120) >> 3);
                        gVar.jTX.jUh = (byte) (((bArr[0] & FileUtils.S_IWUSR) >> 7) + ((bArr[1] & 3) << 1));
                        uuid = g.TAG;
                        str = "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d";
                        objArr = new Object[5];
                        objArr[0] = gVar.jTX.jUd ? "true" : "false";
                        objArr[1] = gVar.jTX.jUe ? "true" : "false";
                        objArr[2] = gVar.jTX.jUf ? "true" : "false";
                        objArr[3] = Byte.valueOf(gVar.jTX.jUg);
                        objArr[4] = Byte.valueOf(gVar.jTX.jUh);
                        w.d(uuid, str, objArr);
                    }
                } else if (gVar.jSL.equalsIgnoreCase(g.jSB)) {
                    byte b = bArr[0];
                    if ((b & 2) != 0) {
                        i = 10;
                    } else {
                        i = 3;
                    }
                    if ((b & 4) != 0) {
                        i++;
                    }
                    if ((b & 8) != 0) {
                        i += 4;
                    }
                    if (i > bArr.length) {
                        w.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)});
                        z2 = false;
                    } else {
                        gVar.jTY = new g.b();
                        gVar.jTY.jTZ = (b & 1) != 0;
                        gVar.jTY.jUa = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b & 2) != 0) {
                            gVar.jTY.jUb = new a();
                            a aVar = gVar.jTY.jUb;
                            String str2 = g.TAG;
                            String str3 = "data size = %d, offset = %d, lenght = %d";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = Integer.valueOf(3);
                            objArr2[2] = Integer.valueOf(7);
                            w.d(str2, str3, objArr2);
                            if (bArr == null || bArr.length < 10) {
                                w.e(g.TAG, "data input error");
                            } else {
                                aVar.jTi = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                aVar.jTj = bArr[5] & 255;
                                aVar.jTk = bArr[6] & 255;
                                aVar.jTl = bArr[7] & 255;
                                aVar.jTm = bArr[8] & 255;
                                aVar.jTn = bArr[9] & 255;
                                w.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(aVar.jTi), Integer.valueOf(aVar.jTj), Integer.valueOf(aVar.jTk), Integer.valueOf(aVar.jTl), Integer.valueOf(aVar.jTm), Integer.valueOf(aVar.jTn)});
                            }
                            i = 10;
                        } else {
                            i = 3;
                        }
                        if ((b & 4) != 0) {
                            gVar.jTY.jTb = bArr[i] & 255;
                            i++;
                        }
                        if ((b & 8) != 0) {
                            gVar.jTY.jUc = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
                            i += 2;
                            gVar.jTY.RQ = ((bArr[i + 1] & 255) << 8) + (bArr[i] & 255);
                        }
                        uuid = g.TAG;
                        str = "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d";
                        objArr = new Object[6];
                        objArr[0] = gVar.jTY.jTZ ? "lb&inch" : "kg&meter";
                        objArr[1] = Integer.valueOf(gVar.jTY.jUa);
                        objArr[2] = gVar.jTY.jUb == null ? "null" : "object";
                        objArr[3] = Integer.valueOf(gVar.jTY.jTb);
                        objArr[4] = Integer.valueOf(gVar.jTY.jUc);
                        objArr[5] = Integer.valueOf(gVar.jTY.RQ);
                        w.d(uuid, str, objArr);
                    }
                }
                z2 = true;
            }
            if (z2) {
                aR = b.aR(gVar);
                w.d(TAG, "weight info. weight = %d", new Object[]{Integer.valueOf(gVar.jTY.jUa)});
                return aR;
            }
            w.e(TAG, "parse weight scale data error");
            return null;
        } else if (0 != (4 & j) && (uuid.equalsIgnoreCase(d.jSN) || uuid.equalsIgnoreCase(d.jTp) || uuid.equalsIgnoreCase(d.jTq))) {
            d dVar = new d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                w.e(d.TAG, "characteristicUuid or data is null");
            } else {
                dVar.jSL = uuid;
                int length = bArr.length;
                if (dVar.jSL.equalsIgnoreCase(d.jSN)) {
                    if (bArr.length < 2) {
                        w.e(d.TAG, "Received data length is not right:" + length);
                    } else {
                        int i3;
                        dVar.jTx = new a(dVar);
                        byte b2 = bArr[0];
                        w.d(d.TAG, "flag=" + b2);
                        if ((b2 & 1) == 1 && length >= 3) {
                            w.d(d.TAG, "Value Format = uint16");
                            dVar.jTx.jTy = (((bArr[2] << 8) & 65280) & 65280) + (bArr[1] & 255);
                            i = 3;
                        } else if (length >= 2) {
                            w.d(d.TAG, "Value Format = uint8");
                            dVar.jTx.jTy = bArr[1] & 255;
                            i = 2;
                        } else {
                            w.d(d.TAG, "receive data error");
                        }
                        w.v(d.TAG, "Data received from HR " + dVar.jTx.jTy);
                        if ((b2 & 6) == 4) {
                            w.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            dVar.jTx.jTz = 1;
                        } else if ((b2 & 6) == 6) {
                            w.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                            dVar.jTx.jTz = 2;
                        } else {
                            w.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                            dVar.jTx.jTz = 0;
                        }
                        if ((b2 & 8) == 8 && length >= i + 2) {
                            w.d(d.TAG, "Energy Expend Present");
                            i3 = (bArr[i + 1] << 8) & 65280;
                            dVar.jTx.jTA = (bArr[i] & 255) + (i3 & 65280);
                            w.v("H7ConnectThread", "energyExp from HR energyExph " + i3 + " " + dVar.jTx.jTA);
                            i += 2;
                        }
                        if ((b2 & 16) == 16 && length >= i + 2) {
                            w.d(d.TAG, "RR Interval Present");
                            i3 = (bArr[i + 1] & 255) << 8;
                            dVar.jTx.jTB = (bArr[i] & 255) + (i3 & 65280);
                            w.v(d.TAG, "rrInterval from HR rrIntervalh" + i3 + " " + dVar.jTx.jTB);
                        }
                    }
                } else if (dVar.jSL.equalsIgnoreCase(d.jTp)) {
                    switch (bArr[0]) {
                        case (byte) 0:
                            dVar.jTw = "Other";
                            break;
                        case (byte) 1:
                            dVar.jTw = "Chest";
                            break;
                        case (byte) 2:
                            dVar.jTw = "Wrist";
                            break;
                        case (byte) 3:
                            dVar.jTw = "Finger";
                            break;
                        case (byte) 4:
                            dVar.jTw = "Hand";
                            break;
                        case (byte) 5:
                            dVar.jTw = "Ear Lobe";
                            break;
                        case (byte) 6:
                            dVar.jTw = "Foot";
                            break;
                        default:
                            dVar.jTw = "Unknown";
                            break;
                    }
                    w.d(d.TAG, "position=" + dVar.jTw);
                }
                z = true;
            }
            if (z) {
                return b.aR(dVar);
            }
            w.e(TAG, "parse heart rate data error");
            return null;
        } else if (0 != (8 & j) && (uuid.equalsIgnoreCase(b.jSN) || uuid.equalsIgnoreCase(b.jSO) || uuid.equalsIgnoreCase(b.jSP))) {
            b bVar = new b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                w.e(b.TAG, "characteristicUuid or data is null");
            } else {
                bVar.jSL = uuid;
                i = bArr.length;
                byte b3;
                if (bVar.jSL.equalsIgnoreCase(b.jSN)) {
                    if (i < 7) {
                        w.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.jSV = new b(bVar);
                        b3 = bArr[0];
                        w.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            w.d(b.TAG, "the value unit is kPa.");
                            bVar.jSV.jSY = true;
                        } else {
                            w.d(b.TAG, "the value unit is mmHg.");
                            bVar.jSV.jSY = false;
                        }
                        bVar.jSV.jTf = b.s(bArr, 1);
                        bVar.jSV.jTg = b.s(bArr, 3);
                        bVar.jSV.jTh = b.s(bArr, 5);
                        i2 = 7;
                        if ((b3 & 2) == 0 || i < 14) {
                            w.d(b.TAG, "TimeStamp not Present.");
                        } else {
                            w.d(b.TAG, "TimeStamp Present.");
                            bVar.jSV.jTd.t(bArr, 7);
                            i2 = 14;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            w.d(b.TAG, "PulseRate not Present.");
                        } else {
                            w.d(b.TAG, "PulseRate Present.");
                            bVar.jSV.jTa = (int) b.s(bArr, i2);
                            i2 += 2;
                            w.d(b.TAG, "PulseRate =" + bVar.jSV.jTa);
                        }
                        if ((b3 & 8) != 0) {
                            w.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.jSV.jTb = bArr[i2];
                            w.d(b.TAG, "UserId = " + bVar.jSV.jTb);
                        } else {
                            w.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            w.d(b.TAG, "MeasurementStatus Present.");
                            bVar.jSV.jTc = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            w.d(b.TAG, "MeasurementStatus = " + bVar.jSV.jTc);
                        } else {
                            w.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.jSL.equalsIgnoreCase(b.jSO)) {
                    if (i < 3) {
                        w.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.jSW = new a(bVar);
                        b3 = bArr[0];
                        w.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            w.d(b.TAG, "the value unit is kPa.");
                            bVar.jSW.jSY = true;
                        } else {
                            w.d(b.TAG, "the value unit is mmHg.");
                            bVar.jSW.jSY = false;
                        }
                        bVar.jSW.jSZ = b.s(bArr, 1);
                        if ((b3 & 2) == 0 || i < 10) {
                            w.d(b.TAG, "TimeStamp not Present.");
                            i2 = 3;
                        } else {
                            w.d(b.TAG, "TimeStamp Present.");
                            bVar.jSW.jTd.t(bArr, 3);
                            i2 = 10;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            w.d(b.TAG, "PulseRate not Present.");
                        } else {
                            w.d(b.TAG, "PulseRate Present.");
                            bVar.jSW.jTa = (int) b.s(bArr, i2);
                            i2 += 2;
                            w.d(b.TAG, "PulseRate =" + bVar.jSW.jTa);
                        }
                        if ((b3 & 8) != 0) {
                            w.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.jSW.jTb = bArr[i2];
                            w.d(b.TAG, "UserId = " + bVar.jSW.jTb);
                        } else {
                            w.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            w.d(b.TAG, "MeasurementStatus Present.");
                            bVar.jSW.jTc = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            w.d(b.TAG, "MeasurementStatus = " + bVar.jSW.jTc);
                        } else {
                            w.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.jSL.equalsIgnoreCase(b.jSP)) {
                    w.d(b.TAG, "Blood Pressure Feature Characteristic.");
                    if (i < 2) {
                        w.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.jSX = (((bArr[1] << 8) & 65280) & 65280) + (bArr[0] & 255);
                        w.d(b.TAG, "bloodPressureFeatureParameters=" + bVar.jSX);
                    }
                }
                z = true;
            }
            if (z) {
                return b.aR(bVar);
            }
            w.e(TAG, "parse blood pressure data error");
            return null;
        } else if (0 == (j & 16) || !(uuid.equalsIgnoreCase(e.jTD) || uuid.equalsIgnoreCase(e.jTE) || uuid.equalsIgnoreCase(e.jTF) || uuid.equalsIgnoreCase(e.jTG))) {
            w.e(TAG, "unknown characteristic uuid = %s", new Object[]{uuid});
            return null;
        } else {
            e eVar = new e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                w.e(e.TAG, "characteristicUuid or data is null");
            } else {
                eVar.jSL = uuid;
                if (eVar.jSL.equalsIgnoreCase(e.jTD)) {
                    if (bArr.length != 3) {
                        w.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.jTH = bArr[0];
                        eVar.jTI = bArr[1];
                        eVar.jTJ = bArr[2];
                    }
                } else if (eVar.jSL.equalsIgnoreCase(e.jTE)) {
                    if (bArr.length != 1) {
                        w.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.jTK = bArr[0];
                    }
                } else if (eVar.jSL.equalsIgnoreCase(e.jTF)) {
                    if (bArr.length < 2) {
                        w.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.jTL[0] = bArr[0];
                        eVar.jTL[1] = bArr[1];
                    }
                } else if (!eVar.jSL.equalsIgnoreCase(e.jTG)) {
                    w.e(e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    w.e(e.TAG, "Data length incorrect");
                } else {
                    eVar.jTM = (bArr[0] & 255) + ((bArr[1] << 8) & 255);
                    eVar.jTO = bArr[2];
                    eVar.jTN = bArr[3];
                    if (bArr.length > 4) {
                        eVar.jTP = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, eVar.jTP, 0, bArr.length - 4);
                    } else {
                        eVar.jTP = null;
                    }
                }
                z = true;
            }
            if (z) {
                return b.aR(eVar);
            }
            w.e(TAG, "parse light data error");
            return null;
        }
    }
}
