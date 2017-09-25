package com.tencent.mm.sdk.e;

import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class a {
    private String filePath;
    private Properties uwZ;

    public a(String str) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        this.uwZ = null;
        this.filePath = null;
        this.uwZ = new Properties();
        this.filePath = str;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.uwZ.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    w.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e2.getLocalizedMessage());
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    w.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            w.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e22.getLocalizedMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            w.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            w.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public final boolean eC(String str, String str2) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                this.uwZ.setProperty(str, str2);
                this.uwZ.store(fileOutputStream, "");
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    w.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e2.getLocalizedMessage());
                    return true;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    w.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e22) {
                        w.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e22.getLocalizedMessage());
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            w.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            w.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public final boolean ab(String str, long j) {
        return eC(str, String.valueOf(j));
    }

    public final boolean cC(String str, int i) {
        return eC(str, String.valueOf(i));
    }

    public final String getValue(String str) {
        if (this.uwZ == null || !this.uwZ.containsKey(str)) {
            return null;
        }
        return this.uwZ.getProperty(str);
    }

    public final Long Qp(String str) {
        Long l = null;
        String value = getValue(str);
        if (value != null) {
            try {
                l = Long.valueOf(Long.parseLong(value));
            } catch (Exception e) {
                w.e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", value, e.getLocalizedMessage());
            }
        }
        return l;
    }

    public final Integer Qq(String str) {
        Integer num = null;
        String value = getValue(str);
        if (value != null) {
            try {
                num = Integer.valueOf(Integer.parseInt(value));
            } catch (Exception e) {
                w.e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", value, e.getLocalizedMessage());
            }
        }
        return num;
    }

    public static String getValue(String str, String str2) {
        return new a(str).getValue(str2);
    }

    public static Long eD(String str, String str2) {
        return new a(str).Qp(str2);
    }

    public static boolean aa(String str, String str2, String str3) {
        return new a(str).eC(str2, str3);
    }

    public static boolean e(String str, String str2, long j) {
        return new a(str).ab(str2, j);
    }
}
