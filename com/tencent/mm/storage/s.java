package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class s {
    private String filePath = "";
    private boolean gQJ = false;
    public boolean uyY = false;
    public boolean uyZ = false;
    private Map<Integer, Object> values;

    public s(String str) {
        if (!new File(str).exists()) {
            w.e("MicroMsg.ConfigFileStorage", "ConfigFileStorage not exit path[%s]", str);
        }
        this.filePath = str;
        bLa();
        this.gQJ = false;
    }

    public final synchronized void set(int i, Object obj) {
        this.values.put(Integer.valueOf(i), obj);
        if (!this.gQJ) {
            rk();
        }
    }

    public final synchronized Object get(int i) {
        return this.values.get(Integer.valueOf(i));
    }

    public final synchronized Object get(int i, Object obj) {
        Object obj2 = this.values.get(Integer.valueOf(i));
        if (obj2 != null) {
            obj = obj2;
        }
        return obj;
    }

    public final synchronized void bIE() {
        this.gQJ = true;
    }

    public final synchronized void bKZ() {
        this.gQJ = false;
        rk();
    }

    private synchronized void bLa() {
        FileInputStream fileInputStream;
        Throwable e;
        FileInputStream fileInputStream2;
        ObjectInputStream objectInputStream = null;
        synchronized (this) {
            try {
                File file = new File(this.filePath);
                if (!file.exists()) {
                    boolean createNewFile = file.createNewFile();
                    w.w("MicroMsg.ConfigFileStorage", "ConfigFileStorage openCfg not exit path[%s], created[%b]", this.filePath, Boolean.valueOf(createNewFile));
                }
                if (file.length() == 0) {
                    this.values = new HashMap();
                    w.w("MicroMsg.ConfigFileStorage", "ConfigFileStorage openCfg file len == 0 path[%s]", this.filePath);
                } else {
                    fileInputStream = new FileInputStream(file);
                    try {
                        ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream);
                        try {
                            this.values = (Map) objectInputStream2.readObject();
                            w.i("MicroMsg.ConfigFileStorage", "openCfg end, keys count:%d", Integer.valueOf(this.values.size()));
                            this.uyY = false;
                            try {
                                objectInputStream2.close();
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            objectInputStream = objectInputStream2;
                            fileInputStream2 = fileInputStream;
                            try {
                                this.values = new HashMap();
                                w.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
                                this.uyY = true;
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                return;
                            } catch (Throwable th) {
                                e = th;
                                fileInputStream = fileInputStream2;
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e5) {
                                        throw e;
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectInputStream = objectInputStream2;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileInputStream2 = fileInputStream;
                        this.values = new HashMap();
                        w.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
                        this.uyY = true;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return;
                    } catch (Throwable th3) {
                        e = th3;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw e;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                fileInputStream2 = null;
                this.values = new HashMap();
                w.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
                this.uyY = true;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return;
            } catch (Throwable th4) {
                e = th4;
                fileInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
        return;
    }

    private synchronized void rk() {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream = null;
        synchronized (this) {
            FileOutputStream fileOutputStream2;
            try {
                long Nz = bg.Nz();
                fileOutputStream2 = new FileOutputStream(this.filePath);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    try {
                        w.e("MicroMsg.ConfigFileStorage", "exception:%s", bg.g(e));
                        w.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
                        this.uyZ = true;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return;
                    } catch (Throwable th) {
                        e = th;
                        fileOutputStream2 = fileOutputStream;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e4) {
                                throw e;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
                try {
                    objectOutputStream.writeObject(this.values);
                    fileOutputStream2.flush();
                    this.uyZ = false;
                    w.d("MicroMsg.ConfigFileStorage", "writeCfg end, keys count:%d time:%d", Integer.valueOf(this.values.keySet().toArray().length), Long.valueOf(bg.aA(Nz)));
                    try {
                        objectOutputStream.close();
                        fileOutputStream2.close();
                    } catch (Exception e5) {
                    }
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream = fileOutputStream2;
                    w.e("MicroMsg.ConfigFileStorage", "exception:%s", bg.g(e));
                    w.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
                    this.uyZ = true;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return;
                } catch (Throwable th3) {
                    e = th3;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
            } catch (IOException e7) {
                e = e7;
                objectOutputStream = null;
                w.e("MicroMsg.ConfigFileStorage", "exception:%s", bg.g(e));
                w.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
                this.uyZ = true;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            } catch (Throwable th4) {
                e = th4;
                objectOutputStream = null;
                fileOutputStream2 = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw e;
            }
        }
        return;
    }

    public final synchronized void reset() {
        w.i("MicroMsg.ConfigFileStorage", "ConfigFileStorage reset ");
        File file = new File(this.filePath);
        if (file.exists()) {
            file.delete();
        }
        this.values = new HashMap();
    }

    public final synchronized void setInt(int i, int i2) {
        set(i, Integer.valueOf(i2));
    }

    public final synchronized int yA(int i) {
        Integer num;
        num = (Integer) get(i);
        return num == null ? 0 : num.intValue();
    }

    public final synchronized void setLong(int i, long j) {
        set(i, Long.valueOf(j));
    }

    public synchronized long getLong(int i, long j) {
        Long l = (Long) get(i);
        if (l != null) {
            j = l.longValue();
        }
        return j;
    }
}
