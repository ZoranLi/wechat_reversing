package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class f extends k implements j {
    int fEX;
    public b gUA;
    private e gUD;
    private int hFc;
    a hKg;
    boolean htv;
    int iar;
    private a nwZ;

    public f(a aVar, boolean z) {
        this(aVar, z, 0);
    }

    public f(a aVar, boolean z, int i) {
        int i2 = 1;
        this.nwZ = null;
        this.hKg = null;
        this.fEX = 0;
        this.iar = 0;
        this.htv = false;
        this.nwZ = aVar;
        this.hFc = i;
        aVar.iam = bg.Nz();
        if (aVar.msgType == 43) {
            aVar.status = 104;
            o.KV();
            aVar.nwU = s.lx(s.lw(aVar.aJm()));
            o.KV();
            aVar.fuU = s.lx(s.lv(aVar.aJm()));
            this.iar = 2500;
            if (aVar.nwV == 2) {
                this.iar = 2500;
            }
        } else if (aVar.msgType == 34) {
            this.iar = 40;
            aVar.status = 104;
            aVar.fuU = com.tencent.mm.modelvoice.o.lx(aVar.aJm());
            aVar.nwU = 0;
        } else if (aVar.msgType == 3) {
            int i3;
            this.iar = 40;
            if (i == 1) {
                this.iar = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            aVar.nwW = i3;
            aVar.status = 104;
            aVar.nwU = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            aVar.fuU = com.tencent.mm.a.e.aN(stringBuilder.append(c.xb()).append(aVar.aJm()).toString());
        } else if (aVar.msgType == 1) {
            this.iar = 1;
            aVar.status = 104;
            aVar.fuU = aVar.aJm().getBytes().length;
            aVar.nwU = 0;
        } else {
            w.d("MicroMsg.NetSceneMasSend", "error msgtype:" + aVar.msgType);
            Assert.assertTrue("error msgtype:" + aVar.msgType, false);
        }
        b.a aVar2 = new b.a();
        aVar2.hsm = new alc();
        aVar2.hsn = new ald();
        aVar2.uri = "/cgi-bin/micromsg-bin/masssend";
        aVar2.hsl = JsApiChooseMedia.CTRL_INDEX;
        aVar2.hso = 84;
        aVar2.hsp = 1000000084;
        this.gUA = aVar2.BE();
        alc com_tencent_mm_protocal_c_alc = (alc) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_alc.tOM = g.n(aVar.aJo().getBytes());
        com_tencent_mm_protocal_c_alc.tOX = aVar.nwR;
        com_tencent_mm_protocal_c_alc.tOL = aVar.aJo();
        aVar.hTJ = bg.Nz();
        com_tencent_mm_protocal_c_alc.tON = aVar.aJl();
        com_tencent_mm_protocal_c_alc.mtd = aVar.msgType;
        com_tencent_mm_protocal_c_alc.tOO = aVar.nwS;
        if (!z) {
            i2 = 0;
        }
        com_tencent_mm_protocal_c_alc.tOY = i2;
        com_tencent_mm_protocal_c_alc.tFO = i;
        this.hKg = new a();
    }

    public final void cancel() {
        this.htv = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 2;
        int i2 = 0;
        this.gUD = eVar2;
        if (this.htv) {
            w.d("MicroMsg.NetSceneMasSend", "isCancel");
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        }
        this.iar--;
        if (this.iar < 0) {
            w.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        } else if (this.nwZ == null) {
            w.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        } else if (bg.mA(this.nwZ.aJo())) {
            w.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        } else if (this.nwZ.nwR == 0) {
            w.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        } else if (this.nwZ.fuU <= 0) {
            w.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        } else if (this.nwZ.status == 103 && this.nwZ.nwU <= 0) {
            w.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        } else if (this.nwZ.status == 103 || this.nwZ.status == 104) {
            alc com_tencent_mm_protocal_c_alc = (alc) this.gUA.hsj.hsr;
            String aJm;
            if (this.nwZ.msgType == 43) {
                int i3;
                aJm = this.nwZ.aJm();
                if (bg.mA(aJm)) {
                    w.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                    i3 = -1;
                } else {
                    com_tencent_mm_protocal_c_alc.tOP = new avw();
                    com_tencent_mm_protocal_c_alc.tOQ = 0;
                    com_tencent_mm_protocal_c_alc.tOU = new avw();
                    com_tencent_mm_protocal_c_alc.tOT = 0;
                    com_tencent_mm_protocal_c_alc.tOV = 2;
                    com_tencent_mm_protocal_c_alc.tOO = this.nwZ.nwS;
                    if (this.nwZ.nwV <= 0) {
                        i = 0;
                    }
                    com_tencent_mm_protocal_c_alc.tOW = i;
                    com_tencent_mm_protocal_c_alc.tOS = this.nwZ.nwU;
                    com_tencent_mm_protocal_c_alc.tOR = this.nwZ.fuU;
                    s.b h;
                    Object obj;
                    avw com_tencent_mm_protocal_c_avw;
                    if (this.nwZ.status == 103) {
                        o.KV();
                        h = s.h(s.lw(aJm), this.nwZ.iak, 8000);
                        if (h.ret < 0 || h.fAK == 0) {
                            w.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + aJm + "]  Error ");
                            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                            i3 = -1;
                        } else {
                            w.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + aJm + "] read ret:" + h.ret + " readlen:" + h.fAK + " newOff:" + h.iaP + " netOff:" + this.nwZ.iak);
                            if (h.iaP < this.nwZ.iak) {
                                w.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + aJm + "] newOff:" + h.iaP + " OldtOff:" + this.nwZ.iak);
                                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[h.fAK];
                                System.arraycopy(h.buf, 0, obj, 0, h.fAK);
                                com_tencent_mm_protocal_c_alc.tOT = this.nwZ.iak;
                                com_tencent_mm_protocal_c_avw = new avw();
                                com_tencent_mm_protocal_c_avw.bb(obj);
                                com_tencent_mm_protocal_c_alc.tOU = com_tencent_mm_protocal_c_avw;
                            }
                        }
                    } else {
                        o.KV();
                        h = s.h(s.lv(aJm), this.nwZ.nwT, 8000);
                        if (h.ret < 0 || h.fAK == 0) {
                            w.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + aJm + "]  Error ");
                            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                            i3 = -1;
                        } else {
                            w.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + aJm + "] read ret:" + h.ret + " readlen:" + h.fAK + " newOff:" + h.iaP + " netOff:" + this.nwZ.nwT);
                            if (h.iaP < this.nwZ.nwT) {
                                w.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + aJm + "] newOff:" + h.iaP + " OldtOff:" + this.nwZ.nwT);
                                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                                i3 = -1;
                            } else if (h.iaP >= 20971520) {
                                w.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + aJm + "] maxsize:20971520");
                                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[h.fAK];
                                System.arraycopy(h.buf, 0, obj, 0, h.fAK);
                                com_tencent_mm_protocal_c_alc.tOQ = this.nwZ.nwT;
                                com_tencent_mm_protocal_c_alc.tOT = this.nwZ.iak;
                                com_tencent_mm_protocal_c_avw = new avw();
                                com_tencent_mm_protocal_c_avw.bb(obj);
                                com_tencent_mm_protocal_c_alc.tOP = com_tencent_mm_protocal_c_avw;
                            }
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    return i3;
                }
            } else if (this.nwZ.msgType == 34) {
                com_tencent_mm_protocal_c_alc.tOV = 0;
                com_tencent_mm_protocal_c_alc.tOW = 0;
                com_tencent_mm_protocal_c_alc.tOP = new avw().bb(new byte[0]);
                com_tencent_mm_protocal_c_alc.tOQ = 0;
                com_tencent_mm_protocal_c_alc.tOU = new avw().bb(new byte[0]);
                com_tencent_mm_protocal_c_alc.tOT = 0;
                com_tencent_mm_protocal_c_alc.tOS = 0;
                com_tencent_mm_protocal_c_alc.tOR = this.nwZ.fuU;
                com.tencent.mm.modelvoice.b lV = q.lV(this.nwZ.aJm());
                if (lV == null) {
                    this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                    w.d("MicroMsg.NetSceneMasSend", "fileop is null");
                    i2 = -1;
                } else {
                    com.tencent.mm.modelvoice.g bd = lV.bd(this.nwZ.nwT, 8000);
                    if (bd.ret < 0) {
                        w.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.nwZ.aJm() + "] read ret:" + bd.ret + " readlen:" + bd.fAK + " newOff:" + bd.iaP + " netOff:" + this.nwZ.nwT);
                        this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                        i2 = -1;
                    } else if (bd.iaP < this.nwZ.nwT || bd.iaP >= 469000) {
                        w.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.nwZ.aJm() + "] read ret:" + bd.ret + " readlen:" + bd.fAK + " newOff:" + bd.iaP + " netOff:" + this.nwZ.nwT);
                        this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                        i2 = -1;
                    } else if (this.nwZ.fuU <= 0) {
                        w.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.nwZ.aJm() + "] read totalLen:" + this.nwZ.fuU);
                        this.fEX = com.tencent.mm.compatible.util.g.sb() + 10000;
                        i2 = -1;
                    } else {
                        Object obj2 = new byte[bd.fAK];
                        System.arraycopy(bd.buf, 0, obj2, 0, bd.fAK);
                        com_tencent_mm_protocal_c_alc.tOP = new avw().bb(obj2);
                        com_tencent_mm_protocal_c_alc.tOO = this.nwZ.nwS;
                        com_tencent_mm_protocal_c_alc.tOQ = this.nwZ.nwT;
                        com_tencent_mm_protocal_c_alc.tOZ = lV.getFormat();
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.nwZ.msgType == 3) {
                if (bg.mA(this.nwZ.aJm())) {
                    w.d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                    i2 = -1;
                } else {
                    com_tencent_mm_protocal_c_alc.tOV = 0;
                    com_tencent_mm_protocal_c_alc.tOW = 0;
                    com_tencent_mm_protocal_c_alc.tOP = new avw().bb(new byte[0]);
                    com_tencent_mm_protocal_c_alc.tOQ = 0;
                    com_tencent_mm_protocal_c_alc.tOU = new avw().bb(new byte[0]);
                    com_tencent_mm_protocal_c_alc.tOT = 0;
                    com_tencent_mm_protocal_c_alc.tOS = 0;
                    com_tencent_mm_protocal_c_alc.tOO = 0;
                    com_tencent_mm_protocal_c_alc.tOS = this.nwZ.nwU;
                    com_tencent_mm_protocal_c_alc.tOR = this.nwZ.fuU;
                    com_tencent_mm_protocal_c_alc.tFO = this.hFc;
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    aJm = stringBuilder.append(c.xb()).append(this.nwZ.aJm()).toString();
                    i = this.nwZ.fuU - this.nwZ.nwT;
                    if (i > 8000) {
                        i = 8000;
                    }
                    byte[] c = com.tencent.mm.a.e.c(aJm, this.nwZ.nwT, i);
                    if (bg.bm(c)) {
                        w.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.nwZ.aJm() + "]  Error ");
                        this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                        i2 = -1;
                    } else {
                        com_tencent_mm_protocal_c_alc.tOQ = this.nwZ.nwT;
                        com_tencent_mm_protocal_c_alc.tOT = this.nwZ.iak;
                        avw com_tencent_mm_protocal_c_avw2 = new avw();
                        com_tencent_mm_protocal_c_avw2.bb(c);
                        com_tencent_mm_protocal_c_alc.tOP = com_tencent_mm_protocal_c_avw2;
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.nwZ.msgType == 1) {
                com_tencent_mm_protocal_c_alc.tOP = new avw().bb(this.nwZ.aJm().getBytes());
                com_tencent_mm_protocal_c_alc.tOR = this.nwZ.fuU;
                com_tencent_mm_protocal_c_alc.tOO = 0;
                com_tencent_mm_protocal_c_alc.tOQ = 0;
                com_tencent_mm_protocal_c_alc.tOU = new avw().bb(new byte[0]);
                com_tencent_mm_protocal_c_alc.tOT = 0;
                com_tencent_mm_protocal_c_alc.tOS = 0;
                com_tencent_mm_protocal_c_alc.tOV = 0;
                com_tencent_mm_protocal_c_alc.tOW = 0;
            } else {
                w.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.nwZ.msgType);
                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                return -1;
            }
            return a(eVar, this.gUA, this);
        } else {
            w.d("MicroMsg.NetSceneMasSend", "msg type :" + this.nwZ.msgType);
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        }
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 2500;
    }

    protected final void a(k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i2 + " errCode:" + i3);
        if (i2 != 0 || i3 != 0) {
            w.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i2 + " errCode:" + i3);
            this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
            this.gUD.a(i2, i3, str, this);
        } else if (this.nwZ == null) {
            w.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
            this.gUD.a(i2, i3, str, this);
        } else if (this.nwZ.status == 104 || this.nwZ.status == 103) {
            ald com_tencent_mm_protocal_c_ald = (ald) this.gUA.hsk.hsr;
            alc com_tencent_mm_protocal_c_alc = (alc) this.gUA.hsj.hsr;
            if (com_tencent_mm_protocal_c_alc.tOS > 0 && com_tencent_mm_protocal_c_alc.tOU != null && com_tencent_mm_protocal_c_alc.tOU.tZp != null && !bg.bm(com_tencent_mm_protocal_c_alc.tOU.tZp.toByteArray()) && com_tencent_mm_protocal_c_alc.tOT != com_tencent_mm_protocal_c_ald.tOT - com_tencent_mm_protocal_c_alc.tOU.tZn) {
                w.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                this.gUD.a(3, -1, "doScene failed", this);
            } else if (com_tencent_mm_protocal_c_alc.tOR <= 0 || com_tencent_mm_protocal_c_alc.tOP == null || com_tencent_mm_protocal_c_alc.tOP.tZp == null || bg.bm(com_tencent_mm_protocal_c_alc.tOP.tZp.toByteArray()) || com_tencent_mm_protocal_c_alc.tOQ == com_tencent_mm_protocal_c_ald.tOQ - com_tencent_mm_protocal_c_alc.tOP.tZn) {
                this.nwZ.ian = bg.Ny();
                int i4 = this.nwZ.status;
                if (i4 == 103) {
                    this.nwZ.iak = com_tencent_mm_protocal_c_alc.tOU.tZn + com_tencent_mm_protocal_c_alc.tOT;
                    if (this.nwZ.iak >= this.nwZ.nwU) {
                        this.nwZ.status = 199;
                    }
                } else if (i4 == 104) {
                    this.nwZ.nwT = com_tencent_mm_protocal_c_alc.tOP.tZn + com_tencent_mm_protocal_c_alc.tOQ;
                    if (this.nwZ.nwT >= this.nwZ.fuU) {
                        if (this.nwZ.nwU > 0) {
                            this.nwZ.status = 103;
                        } else {
                            this.nwZ.status = 199;
                        }
                    }
                } else {
                    w.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:" + i4);
                    this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                    this.gUD.a(3, -1, "doScene failed", this);
                    return;
                }
                if (this.nwZ.status == 199) {
                    b aJt = h.aJt();
                    a aVar = this.nwZ;
                    if (aVar != null) {
                        aVar.fRW = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((aVar.fRW & 1) != 0) {
                            contentValues.put("clientid", aVar.aJl());
                        }
                        if ((aVar.fRW & 2) != 0) {
                            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(aVar.status));
                        }
                        if ((aVar.fRW & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(aVar.iam));
                        }
                        if ((aVar.fRW & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(aVar.ian));
                        }
                        if ((aVar.fRW & 16) != 0) {
                            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, aVar.aJm());
                        }
                        if ((aVar.fRW & 32) != 0) {
                            contentValues.put("thumbfilename", aVar.aJn());
                        }
                        if ((aVar.fRW & 64) != 0) {
                            contentValues.put("tolist", aVar.aJo());
                        }
                        if ((aVar.fRW & FileUtils.S_IWUSR) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(aVar.nwR));
                        }
                        if ((aVar.fRW & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
                        }
                        if ((aVar.fRW & 512) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(aVar.nwS));
                        }
                        if ((aVar.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(aVar.nwT));
                        }
                        if ((aVar.fRW & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(aVar.fuU));
                        }
                        if ((aVar.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(aVar.iak));
                        }
                        if ((aVar.fRW & 8192) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(aVar.nwU));
                        }
                        if ((aVar.fRW & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(aVar.nwV));
                        }
                        if ((aVar.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(aVar.nwW));
                        }
                        if ((aVar.fRW & 65536) != 0) {
                            contentValues.put("reserved3", aVar.hnF == null ? "" : aVar.hnF);
                        }
                        if ((aVar.fRW & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                            contentValues.put("reserved4", aVar.hnG == null ? "" : aVar.hnG);
                        }
                        if (((int) aJt.hnH.insert("massendinfo", "clientid", contentValues)) != -1) {
                            ap.yY();
                            Object obj = c.wW().Rm("masssendapp") == null ? 1 : null;
                            ae aeVar = new ae();
                            aeVar.setUsername("masssendapp");
                            aeVar.setContent(b.a(aVar));
                            aeVar.s(aVar.iam);
                            aeVar.dw(0);
                            aeVar.dt(0);
                            if (obj != null) {
                                ap.yY();
                                c.wW().d(aeVar);
                            } else {
                                ap.yY();
                                c.wW().a(aeVar, "masssendapp");
                            }
                            aJt.doNotify();
                        }
                    }
                    w.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:" + (this.hKg != null ? this.hKg.se() : 0));
                    this.gUD.a(i2, i3, str, this);
                } else if (a(this.hsD, this.gUD) == -1) {
                    this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                    this.gUD.a(3, -1, "doScene failed", this);
                }
            } else {
                w.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                this.gUD.a(3, -1, "doScene failed", this);
            }
        } else {
            w.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.nwZ.status);
            this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return JsApiChooseMedia.CTRL_INDEX;
    }
}
