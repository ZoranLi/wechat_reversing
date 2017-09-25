package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public final class n {
    private static Context mContext = null;
    private static n wYi = null;

    private n() {
    }

    static void VA(String str) {
        Throwable th;
        if (f.cfk()) {
            DataOutputStream dataOutputStream = null;
            DataOutputStream dataOutputStream2;
            try {
                File file = new File(f.cfl(), "ins.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                dataOutputStream2 = new DataOutputStream(new BufferedOutputStream(f.L(file)));
                try {
                    dataOutputStream2.writeUTF(str);
                    dataOutputStream2.flush();
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                dataOutputStream2 = null;
                th = th4;
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
                throw th;
            }
        }
    }

    static void VB(String str) {
        try {
            System.putString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer", str);
        } catch (Exception e) {
        }
    }

    public static n gV(Context context) {
        mContext = context.getApplicationContext();
        if (wYi == null) {
            wYi = new n();
        }
        return wYi;
    }
}
