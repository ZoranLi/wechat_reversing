package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.by;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class ad {
    public String ivH = "";
    public List<a> mrd = new LinkedList();

    public static class a implements Serializable {
        public String fSf;
        public long mal;
        public int mre;
        public int mrf;
        public boolean mrg;
        public String mrh;
        public String tag;
    }

    public ad(String str) {
        if (!bg.mA(str)) {
            this.ivH = str;
            this.mrd.addAll(aBi());
        }
    }

    public ad(String str, List<by> list) {
        if (!bg.mA(str) && list != null && !list.isEmpty()) {
            this.ivH = str;
            this.mrd.clear();
            for (by byVar : list) {
                a aVar = new a();
                aVar.mre = byVar.mvC;
                aVar.fSf = byVar.jNj;
                aVar.tag = byVar.mvE;
                aVar.mal = byVar.mvD;
                aVar.mrg = byVar.mvF;
                aVar.mrf = byVar.mvG;
                aVar.mrh = byVar.mvH;
                this.mrd.add(aVar);
            }
            aBj();
        }
    }

    private List<a> aBi() {
        ObjectInput objectInputStream;
        Throwable e;
        String str = this.ivH + "_ranks";
        List<a> linkedList = new LinkedList();
        byte[] xQ = SubCoreGameCenter.aBF().xQ(str);
        if (xQ == null) {
            return linkedList;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(xQ);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                linkedList.addAll((List) objectInputStream.readObject());
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                }
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    w.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return linkedList;
                } catch (Throwable th) {
                    e = th;
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e7) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectInputStream = null;
            w.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return linkedList;
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e;
        }
        return linkedList;
    }

    public final void aBj() {
        ObjectOutput objectOutputStream;
        Throwable e;
        String str = this.ivH + "_ranks";
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(this.mrd);
                SubCoreGameCenter.aBF().o(str, byteArrayOutputStream.toByteArray());
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    w.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectOutputStream = null;
            w.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw e;
        }
    }
}
