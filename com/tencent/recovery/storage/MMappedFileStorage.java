package com.tencent.recovery.storage;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.recovery.log.RecoveryLog;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class MMappedFileStorage {
    private int currentIndex;
    private int wQB = 153600;
    private File wQC;
    private File wQD = new File(this.wQC.getParentFile(), "temp-" + this.wQC.getName());
    private MappedByteBuffer wQE;
    private RandomAccessFile wQF;

    public MMappedFileStorage(String str) {
        this.wQC = new File(str);
        if (!this.wQC.getParentFile().exists()) {
            this.wQC.getParentFile().mkdirs();
        }
        if (this.wQD.exists()) {
            f(this.wQD, this.wQC);
            this.wQD.delete();
        }
    }

    public final synchronized void c(byte[] bArr, boolean z) {
        try {
            if (this.wQF == null) {
                if (!this.wQD.exists()) {
                    this.wQD.createNewFile();
                }
                this.wQF = new RandomAccessFile(this.wQD, "rw");
            }
            if (this.wQE == null) {
                this.wQE = this.wQF.getChannel().map(MapMode.READ_WRITE, 0, (long) this.wQB);
            }
            if (!(this.wQD == null || this.wQE == null)) {
                if (this.currentIndex + bArr.length > this.wQB || z) {
                    this.wQE.force();
                    try {
                        this.wQF.close();
                    } catch (IOException e) {
                    }
                    f(this.wQD, this.wQC);
                    this.currentIndex = 4;
                    this.wQD.delete();
                    this.wQD.createNewFile();
                    this.wQF = new RandomAccessFile(this.wQD, "rw");
                    this.wQE = this.wQF.getChannel().map(MapMode.READ_WRITE, 0, (long) this.wQB);
                    this.wQE.putInt(this.currentIndex - 4);
                }
                if (bArr.length >= 0) {
                    this.wQE.position(this.currentIndex);
                    this.wQE.put(bArr);
                    this.wQE.position(0);
                    this.currentIndex += bArr.length;
                    this.wQE.putInt(this.currentIndex - 4);
                }
            }
        } catch (Throwable e2) {
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e2, "appendToBuffer", new Object[0]);
        }
    }

    private static void f(File file, File file2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        DataInputStream dataInputStream = null;
        try {
            int readInt;
            DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
            try {
                readInt = dataInputStream2.readInt();
                fileOutputStream = new FileOutputStream(file2, true);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                dataInputStream = dataInputStream2;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                int i = 0;
                while (true) {
                    int i2 = i + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT > readInt ? readInt - i : WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    if (i2 > 0) {
                        i2 = dataInputStream2.read(bArr, 0, i2);
                        if (i2 > 0) {
                            fileOutputStream.write(bArr, 0, i2);
                            i = i2 + i;
                        }
                    }
                    try {
                        break;
                    } catch (IOException e7) {
                    }
                }
                dataInputStream2.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
            } catch (Exception e9) {
                e = e9;
                dataInputStream = dataInputStream2;
                RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                e = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }
}
