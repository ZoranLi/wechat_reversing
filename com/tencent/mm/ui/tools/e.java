package com.tencent.mm.ui.tools;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    public static int wma = 0;

    public static void e(File file, File file2) {
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        FileOutputStream fileOutputStream = null;
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                w.e("MicroMsg.DBRecover", "copy file fail");
                return;
            }
        }
        InputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                fileOutputStream2 = new FileOutputStream(file);
            } catch (Exception e2) {
                fileOutputStream2 = null;
                inputStream = fileInputStream;
                try {
                    w.e("MicroMsg.DBRecover", "copy file fail");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            return;
                        }
                    }
                    if (fileOutputStream2 == null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = inputStream;
                    fileOutputStream = fileOutputStream2;
                    th2 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            throw th2;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th2;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (fileInputStream.read(bArr) != -1) {
                    fileOutputStream2.write(bArr);
                }
                try {
                    fileInputStream.close();
                    fileOutputStream2.close();
                } catch (Exception e5) {
                }
            } catch (Exception e6) {
                inputStream = fileInputStream;
                w.e("MicroMsg.DBRecover", "copy file fail");
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream2 == null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                th2 = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th2;
            }
        } catch (Exception e7) {
            fileOutputStream2 = null;
            w.e("MicroMsg.DBRecover", "copy file fail");
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream2 == null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th6) {
            th2 = th6;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th2;
        }
    }
}
