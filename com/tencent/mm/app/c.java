package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.w;
import java.io.File;
import java.io.RandomAccessFile;

public final class c {
    private static final String fvO = (w.hgq + "channel_history.cfg");

    public static void ac(Context context) {
        Throwable e;
        f.dW(context);
        try {
            a aZ = a.aZ(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            if (!(aZ == null || aZ.fuS == null)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChannelHistory", "apk external info not null");
                if (aZ.fuS.fuV != 0) {
                    f.fuV = aZ.fuS.fuV;
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChannelHistory", "read channelId from apk external");
                }
            }
        } catch (NameNotFoundException e2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ChannelHistory", "NameNotFoundException");
        } catch (Exception e3) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ChannelHistory", "Exception in initChannel, %s", e3.getMessage());
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChannelHistory", "now channel id = %d, proce name = %s", Integer.valueOf(f.fuV), ab.um());
        if (!ob()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(fvO, "rw");
                try {
                    randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(f.fuV)}).getBytes());
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e4) {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", "");
                    }
                } catch (Exception e5) {
                    e4 = e5;
                    try {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Open ChannelHistory History file failed.", "");
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e42) {
                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e42, "Close ChannelHistory History file failed.", "");
                            }
                        }
                    } catch (Throwable th) {
                        e42 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e6) {
                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e6, "Close ChannelHistory History file failed.", "");
                            }
                        }
                        throw e42;
                    }
                }
            } catch (Exception e7) {
                e42 = e7;
                randomAccessFile = null;
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e42, "Open ChannelHistory History file failed.", "");
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th2) {
                e42 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e42;
            }
        }
    }

    public static void oa() {
        RandomAccessFile randomAccessFile;
        Throwable e;
        if (ob()) {
            try {
                randomAccessFile = new RandomAccessFile(fvO, "rw");
                try {
                    long length = randomAccessFile.length();
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", Long.valueOf(length), Integer.valueOf(f.fuV));
                    if (length <= 0) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
                        try {
                            randomAccessFile.close();
                            return;
                        } catch (Throwable e2) {
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e2, "Close ChannelHistory History file failed.", "");
                            return;
                        }
                    }
                    String readLine = randomAccessFile.readLine();
                    int i = f.fuV;
                    int i2 = f.fuV;
                    f.usq = f.fuV;
                    String str = "";
                    if (!bg.mA(readLine)) {
                        str = str + readLine + ",";
                        i2 = bg.getInt(readLine, 0);
                        if (i2 != f.fuV) {
                            f.usq = i2;
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChannelHistory", "real correct final channelid: " + f.fuV);
                        }
                    }
                    if (ab.usY) {
                        while (true) {
                            readLine = randomAccessFile.readLine();
                            if (bg.mA(readLine)) {
                                break;
                            }
                            str = str + readLine + ",";
                            i2 = bg.getInt(readLine, 0);
                        }
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChannelHistory", "channel list: %s", str);
                        if (i2 != i) {
                            randomAccessFile.seek(length);
                            randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(i)}).getBytes());
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChannelHistory", "channelid change from %d to %d", Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                    try {
                        randomAccessFile.close();
                        return;
                    } catch (Throwable e22) {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Close ChannelHistory History file failed.", "");
                        return;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Open ChannelHistory History file failed.", "");
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Throwable e222) {
                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Close ChannelHistory History file failed.", "");
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e222 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e4) {
                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", "");
                            }
                        }
                        throw e222;
                    }
                }
            } catch (Exception e5) {
                e222 = e5;
                randomAccessFile = null;
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Open ChannelHistory History file failed.", "");
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e222 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e222;
            }
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
    }

    private static boolean ob() {
        return new File(fvO).exists();
    }
}
