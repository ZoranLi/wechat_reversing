package com.tencent.mm.sdk.platformtools;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import java.lang.ref.WeakReference;

public final class au {
    public static final String uvh = Media.EXTERNAL_CONTENT_URI.toString();
    public static final String[] uvi = new String[]{"_display_name", "_data", "date_added"};
    public static ContentObserver uvj;
    public static WeakReference<a> uvk;

    public interface a {
        void XF();
    }

    public static void a(a aVar) {
        w.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback callback[%s], stack[%s]", new Object[]{aVar, bg.bJZ()});
        if (aVar == null) {
            if (uvj != null) {
                ab.getContext().getContentResolver().unregisterContentObserver(uvj);
                uvj = null;
            }
            if (uvk != null) {
                uvk.clear();
                uvk = null;
                return;
            }
            return;
        }
        uvk = new WeakReference(aVar);
        if (uvj == null) {
            uvj = new ContentObserver(new Handler(Looper.myLooper())) {
                private long uvl;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onChange(boolean r18, android.net.Uri r19) {
                    /*
                    r17 = this;
                    r2 = "MicroMsg.ScreenShotUtil";
                    r3 = new java.lang.StringBuilder;
                    r4 = "summerscreenshot onChange: ";
                    r3.<init>(r4);
                    r0 = r18;
                    r3 = r3.append(r0);
                    r4 = ", uri:";
                    r3 = r3.append(r4);
                    r4 = r19.toString();
                    r3 = r3.append(r4);
                    r3 = r3.toString();
                    com.tencent.mm.sdk.platformtools.w.d(r2, r3);
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    if (r2 == 0) goto L_0x0033;
                L_0x002b:
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    r2 = r2.get();
                    if (r2 != 0) goto L_0x0064;
                L_0x0033:
                    r2 = "MicroMsg.ScreenShotUtil";
                    r3 = "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]";
                    r4 = 1;
                    r4 = new java.lang.Object[r4];
                    r5 = 0;
                    r6 = com.tencent.mm.sdk.platformtools.au.uvk;
                    r4[r5] = r6;
                    com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
                    r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
                    r2 = r2.getContentResolver();
                    r0 = r17;
                    r2.unregisterContentObserver(r0);
                    r2 = 0;
                    com.tencent.mm.sdk.platformtools.au.uvj = r2;
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    if (r2 == 0) goto L_0x0060;
                L_0x0058:
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    r2.clear();
                    r2 = 0;
                    com.tencent.mm.sdk.platformtools.au.uvk = r2;
                L_0x0060:
                    super.onChange(r18, r19);
                    return;
                L_0x0064:
                    r9 = 0;
                    r10 = 0;
                    r2 = r19.toString();
                    r3 = com.tencent.mm.sdk.platformtools.au.uvh;
                    r2 = r2.matches(r3);
                    if (r2 != 0) goto L_0x007f;
                L_0x0073:
                    r2 = r19.toString();
                    r3 = com.tencent.mm.sdk.platformtools.au.uvh;
                    r2 = r2.contains(r3);
                    if (r2 == 0) goto L_0x0060;
                L_0x007f:
                    r8 = 0;
                    r2 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x016d, all -> 0x0192 }
                    r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x016d, all -> 0x0192 }
                    r4 = com.tencent.mm.sdk.platformtools.au.uvi;	 Catch:{ Exception -> 0x016d, all -> 0x0192 }
                    r5 = 0;
                    r6 = 0;
                    r7 = "date_added DESC limit 1";
                    r3 = r19;
                    r5 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x016d, all -> 0x0192 }
                    if (r5 == 0) goto L_0x01d4;
                L_0x0097:
                    r2 = r5.moveToFirst();	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    if (r2 == 0) goto L_0x01d4;
                L_0x009d:
                    r2 = "_data";
                    r2 = r5.getColumnIndex(r2);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r4 = r5.getString(r2);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r2 = "date_added";
                    r2 = r5.getColumnIndex(r2);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r6 = r5.getLong(r2);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
                    r2 = r2 / r12;
                    r8 = "MicroMsg.ScreenShotUtil";
                    r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r13 = "summerscreenshot path: ";
                    r12.<init>(r13);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = r12.append(r4);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r13 = ", dateAdded: ";
                    r12 = r12.append(r13);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = r12.append(r6);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r13 = ", currentTime: ";
                    r12 = r12.append(r13);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = r12.append(r2);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = r12.toString();	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    com.tencent.mm.sdk.platformtools.w.d(r8, r12);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = r2 - r6;
                    r12 = java.lang.Math.abs(r12);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r14 = 10;
                    r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
                    if (r8 > 0) goto L_0x01d4;
                L_0x00f2:
                    r0 = r17;
                    r12 = r0.uvl;	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = r2 - r12;
                    r14 = 1;
                    r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
                    if (r8 <= 0) goto L_0x01d4;
                L_0x00fe:
                    r8 = com.tencent.mm.sdk.platformtools.bg.mA(r4);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    if (r8 != 0) goto L_0x01d4;
                L_0x0104:
                    r8 = r4.toLowerCase();	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    r12 = "screenshot";
                    r8 = r8.contains(r12);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    if (r8 != 0) goto L_0x0123;
                L_0x0111:
                    r8 = "截屏";
                    r8 = r4.contains(r8);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    if (r8 != 0) goto L_0x0123;
                L_0x011a:
                    r8 = "截图";
                    r8 = r4.contains(r8);	 Catch:{ Exception -> 0x01c6, all -> 0x01c1 }
                    if (r8 == 0) goto L_0x01d4;
                L_0x0123:
                    r0 = r17;
                    r0.uvl = r2;	 Catch:{ Exception -> 0x01cc, all -> 0x01c1 }
                    r2 = r6;
                L_0x0128:
                    if (r5 == 0) goto L_0x012d;
                L_0x012a:
                    r5.close();
                L_0x012d:
                    r5 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
                    if (r5 != 0) goto L_0x0060;
                L_0x0133:
                    r5 = "MicroMsg.ScreenShotUtil";
                    r6 = new java.lang.StringBuilder;
                    r7 = "summerscreenshot added path: ";
                    r6.<init>(r7);
                    r4 = r6.append(r4);
                    r6 = ", time: ";
                    r4 = r4.append(r6);
                    r2 = r4.append(r2);
                    r2 = r2.toString();
                    com.tencent.mm.sdk.platformtools.w.i(r5, r2);
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    if (r2 == 0) goto L_0x019a;
                L_0x0158:
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    r2 = r2.get();
                    if (r2 == 0) goto L_0x019a;
                L_0x0160:
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    r2 = r2.get();
                    r2 = (com.tencent.mm.sdk.platformtools.au.a) r2;
                    r2.XF();
                    goto L_0x0060;
                L_0x016d:
                    r2 = move-exception;
                    r5 = r2;
                    r6 = r8;
                    r4 = r9;
                    r2 = r10;
                L_0x0172:
                    r7 = "MicroMsg.ScreenShotUtil";
                    r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c3 }
                    r9 = "summerscreenshot fail e:";
                    r8.<init>(r9);	 Catch:{ all -> 0x01c3 }
                    r5 = r5.getMessage();	 Catch:{ all -> 0x01c3 }
                    r5 = r8.append(r5);	 Catch:{ all -> 0x01c3 }
                    r5 = r5.toString();	 Catch:{ all -> 0x01c3 }
                    com.tencent.mm.sdk.platformtools.w.w(r7, r5);	 Catch:{ all -> 0x01c3 }
                    if (r6 == 0) goto L_0x012d;
                L_0x018e:
                    r6.close();
                    goto L_0x012d;
                L_0x0192:
                    r2 = move-exception;
                    r5 = r8;
                L_0x0194:
                    if (r5 == 0) goto L_0x0199;
                L_0x0196:
                    r5.close();
                L_0x0199:
                    throw r2;
                L_0x019a:
                    r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
                    r2 = r2.getContentResolver();
                    r0 = r17;
                    r2.unregisterContentObserver(r0);
                    r2 = 0;
                    com.tencent.mm.sdk.platformtools.au.uvj = r2;
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    if (r2 == 0) goto L_0x01b6;
                L_0x01ae:
                    r2 = com.tencent.mm.sdk.platformtools.au.uvk;
                    r2.clear();
                    r2 = 0;
                    com.tencent.mm.sdk.platformtools.au.uvk = r2;
                L_0x01b6:
                    r2 = "MicroMsg.ScreenShotUtil";
                    r3 = "summerscreenshot unregisterContentObserver callback is null 2";
                    com.tencent.mm.sdk.platformtools.w.i(r2, r3);
                    goto L_0x0060;
                L_0x01c1:
                    r2 = move-exception;
                    goto L_0x0194;
                L_0x01c3:
                    r2 = move-exception;
                    r5 = r6;
                    goto L_0x0194;
                L_0x01c6:
                    r2 = move-exception;
                    r6 = r5;
                    r4 = r9;
                    r5 = r2;
                    r2 = r10;
                    goto L_0x0172;
                L_0x01cc:
                    r2 = move-exception;
                    r16 = r2;
                    r2 = r6;
                    r6 = r5;
                    r5 = r16;
                    goto L_0x0172;
                L_0x01d4:
                    r2 = r10;
                    r4 = r9;
                    goto L_0x0128;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.au.1.onChange(boolean, android.net.Uri):void");
                }
            };
            ab.getContext().getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, uvj);
        }
    }
}
