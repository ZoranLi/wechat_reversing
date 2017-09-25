package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.wcdb.FileUtils;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class WWAPIImpl implements IWWAPI {
    private static final String[] xlT = new String[]{"com.tencent.wework", "com.tencent.weworklocal"};
    private Context context;
    public Map<String, Object> pSn = new HashMap();
    public String xlU;
    private BroadcastReceiver xlV = new BroadcastReceiver(this) {
        final /* synthetic */ WWAPIImpl xlW;

        {
            this.xlW = r1;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (this.xlW.xlU.equals(intent.getScheme())) {
                    final BaseMessage m = BaseMessage.m(intent.getData());
                    if (m instanceof WWBaseRespMessage) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 xlY;

                            public void run() {
                                try {
                                    this.xlY.xlW.pSn.get(((WWBaseRespMessage) m).transaction);
                                    this.xlY.xlW.pSn.remove(((WWBaseRespMessage) m).transaction);
                                } catch (Throwable th) {
                                    Log.e("WWAPIImpl", "handle message failed", th);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                Log.w("WWAPIImpl", "invalid schema: " + intent.getScheme());
            } catch (Throwable th) {
                Log.e("WWAPIImpl", "handle broadcast failed", th);
            }
        }
    };

    public WWAPIImpl(Context context) {
        this.context = context;
    }

    public final boolean chS() {
        int Wq;
        for (String str : xlT) {
            Wq = Wq(str);
            if (Wq != 0) {
                Log.i("WWAPIImpl", "getWWAppSupportAPI, pkg: " + str + ", versioncode: " + Wq);
                break;
            }
        }
        Wq = 0;
        return Wq >= 100;
    }

    public final String chT() {
        String[] strArr = xlT;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                PackageManager packageManager = this.context.getPackageManager();
                str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
                if (TextUtils.isEmpty(str)) {
                    return "企业微信";
                }
                return str;
            } catch (Throwable th) {
                Log.b("WWAPIImpl", "getWWAppName failed", th);
                i++;
            }
        }
        return "企业微信";
    }

    public final boolean a(BaseMessage baseMessage) {
        String[] strArr = xlT;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            String Wp = Wp(str);
            Log.d("WWAPIImpl", "isValidSignature, pkg: " + str + ", signature: " + Wp);
            if ("011A40266C8C75D181DDD8E4DDC50075".equals(Wp)) {
                Intent intent = new Intent("com.tencent.wework.apihost");
                intent.setClassName(str, "com.tencent.wework.apihost.WWAPIActivity");
                intent.addFlags(411041792);
                try {
                    baseMessage.setContext(this.context);
                    intent.putExtras(BaseMessage.b(baseMessage));
                    intent.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.xlV.getClass()), 134217728));
                    this.context.startActivity(intent);
                    Log.i("WWAPIImpl", "sendMessage, start WWAPIActivity, pkg: " + str);
                    return true;
                } catch (Throwable th) {
                    Log.b("WWAPIImpl", "sendMessage failed, pkg: " + str, th);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    private String Wp(String str) {
        try {
            return bI(this.context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Throwable th) {
            Log.b("WWAPIImpl", "getSignature failed, pkg: " + str, th);
            return "";
        }
    }

    private int Wq(String str) {
        int i = 0;
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(str, FileUtils.S_IWUSR);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            }
        } catch (Throwable th) {
            Log.b("WWAPIImpl", "getVersioncode failed, pkg: " + str, th);
        }
        return i;
    }

    private static String bI(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                stringBuilder.append(Integer.toHexString((b & 240) >>> 4));
                stringBuilder.append(Integer.toHexString(b & 15));
            }
            return stringBuilder.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
