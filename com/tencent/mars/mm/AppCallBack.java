package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic.AccountInfo;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mars.app.AppLogic.ICallBack;
import com.tencent.mm.network.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class AppCallBack implements ICallBack {
    private static final String TAG = "AppCallBack";
    private Context context = null;
    DeviceInfo info = new DeviceInfo(d.sYL, d.DEVICE_TYPE);

    private static String exception2String(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public AppCallBack(Context context) {
        this.context = context;
    }

    public String getAppFilePath() {
        String str = null;
        if (this.context == null) {
            Assert.assertTrue(false);
        } else {
            try {
                File filesDir = this.context.getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.createNewFile();
                }
                str = filesDir.toString();
            } catch (Exception e) {
                w.e(TAG, exception2String(e));
                Assert.assertTrue(e.getClass().getSimpleName() + ":" + e.getStackTrace()[0] + ", " + e.getStackTrace()[1], false);
            }
        }
        return str;
    }

    public AccountInfo getAccountInfo() {
        AccountInfo accountInfo = new AccountInfo();
        if (!(z.MO() == null || z.MO().ieq == null)) {
            try {
                accountInfo.uin = (long) z.MO().ieq.uH();
                accountInfo.userName = z.MO().ieq.Cv();
                if (bg.mA(accountInfo.userName)) {
                    accountInfo.userName = z.MO().ieq.getUsername();
                }
            } catch (Exception e) {
            }
        }
        return accountInfo;
    }

    public int getClientVersion() {
        return d.sYN;
    }

    public DeviceInfo getDeviceType() {
        return this.info;
    }

    public String getCurLanguage() {
        return v.bIN();
    }
}
