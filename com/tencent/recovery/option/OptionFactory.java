package com.tencent.recovery.option;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.recovery.ConstantsRecovery.DefaultProcessOptions;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.util.Util;

public class OptionFactory {
    private static IOptionsCreator wQz;

    public static ProcessOptions dh(String str, int i) {
        if (wQz == null) {
            wQz = cdB();
        }
        ProcessOptions processOptions = null;
        if (wQz != null) {
            processOptions = wQz.createProcessOptions(str, i);
        }
        if (processOptions != null) {
            return processOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom process options, use default %d", Integer.valueOf(i));
        if (i == 1) {
            return DefaultProcessOptions.wPS;
        }
        return DefaultProcessOptions.wPQ;
    }

    public static CommonOptions fq(Context context) {
        if (wQz == null) {
            wQz = cdB();
        }
        CommonOptions commonOptions = null;
        if (wQz != null) {
            commonOptions = wQz.createCommonOptions(context);
        }
        if (commonOptions != null) {
            return commonOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
        Builder builder = new Builder();
        builder.wQq = "";
        builder.wQw = false;
        builder.mry = String.valueOf(Util.fs(context));
        try {
            builder.clientVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
        }
        builder.wQx = 600000;
        builder.wQy = 600000;
        return builder.cdA();
    }

    private static IOptionsCreator cdB() {
        Class cls;
        IOptionsCreator iOptionsCreator;
        try {
            cls = Class.forName(String.format("com.tencent.recovery.DefaultOptionsCreator", new Object[0]));
        } catch (ClassNotFoundException e) {
            cls = null;
        }
        if (cls != null) {
            try {
                iOptionsCreator = (IOptionsCreator) cls.newInstance();
            } catch (Exception e2) {
            }
            if (iOptionsCreator == null) {
                RecoveryLog.i("Recovery.OptionFactory", "getCreator %s success %s", cls.getName(), iOptionsCreator.toString());
            } else {
                RecoveryLog.i("Recovery.OptionFactory", "getCreator fail", new Object[0]);
            }
            return iOptionsCreator;
        }
        iOptionsCreator = null;
        if (iOptionsCreator == null) {
            RecoveryLog.i("Recovery.OptionFactory", "getCreator fail", new Object[0]);
        } else {
            RecoveryLog.i("Recovery.OptionFactory", "getCreator %s success %s", cls.getName(), iOptionsCreator.toString());
        }
        return iOptionsCreator;
    }
}
