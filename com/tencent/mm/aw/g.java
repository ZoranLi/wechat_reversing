package com.tencent.mm.aw;

import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class g {
    public String idm;
    LinkedHashMap<String, a> idn = new LinkedHashMap();
    final ReadWriteLock ido = new ReentrantReadWriteLock();
    private StringBuilder idp = new StringBuilder();

    public class a {
        public String data;
        public String idq;
        public boolean idr;
        public boolean ids;
        public int idt;
        public int idu;
        public int idv;
        public boolean idw;
        final /* synthetic */ g idx;

        public a(g gVar) {
            this.idx = gVar;
            long nextInt = 4294967295L & ((long) new Random(System.currentTimeMillis()).nextInt());
            long currentTimeMillis = ((4294967295L & System.currentTimeMillis()) << 32) | nextInt;
            if (currentTimeMillis < 0) {
                currentTimeMillis = Math.abs(currentTimeMillis);
            }
            w.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(r2), Long.toBinaryString(r2), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), this.idx.idm, this.idx.idm + String.valueOf(currentTimeMillis));
            this.idq = r6;
            this.idr = false;
            this.ids = false;
            this.idt = Integer.MAX_VALUE;
            this.idu = 0;
            this.idv = -1;
            this.data = null;
            this.idw = false;
        }
    }

    public g(String str) {
        this.idm = str;
    }

    public final LinkedList<avx> LV() {
        LinkedList<avx> linkedList = new LinkedList();
        this.ido.readLock().lock();
        for (a aVar : this.idn.values()) {
            if (aVar.idr) {
                linkedList.add(new avx().OV(aVar.idq));
            }
        }
        this.ido.readLock().unlock();
        return linkedList;
    }

    public final String LW() {
        this.idp.setLength(0);
        this.ido.readLock().lock();
        for (a aVar : this.idn.values()) {
            if (aVar.data != null) {
                this.idp.append(aVar.data);
            }
        }
        this.ido.readLock().unlock();
        return this.idp.toString();
    }

    public final boolean LX() {
        if (this.idn.size() == 0) {
            w.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            return false;
        }
        boolean z;
        this.ido.readLock().lock();
        for (a aVar : this.idn.values()) {
            w.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", aVar.idq, Boolean.valueOf(aVar.ids), Boolean.valueOf(aVar.idw));
            if (!((a) r3.next()).idw) {
                z = false;
                break;
            }
        }
        z = true;
        this.ido.readLock().unlock();
        return z;
    }

    public final void P(List<bjr> list) {
        String str;
        String str2 = "MicroMsg.ShortSentenceContainer";
        String str3 = "updateVoiceInfoResult respVTList size %s innerContainer %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        this.ido.readLock().lock();
        if (this.idn.size() == 0) {
            this.ido.readLock().unlock();
            str = "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (a aVar : this.idn.values()) {
                stringBuilder.append(aVar.idq).append(", ");
            }
            if (stringBuilder.length() <= 3) {
                this.ido.readLock().unlock();
                str = stringBuilder.append("]").toString();
            } else {
                stringBuilder.setLength(stringBuilder.length() - 2);
                this.ido.readLock().unlock();
                str = stringBuilder.append("]").toString();
            }
        }
        objArr[1] = str;
        w.d(str2, str3, objArr);
        if (list == null || list.size() == 0) {
            w.i("MicroMsg.ShortSentenceContainer", "respList == null");
            return;
        }
        this.ido.readLock().lock();
        for (bjr com_tencent_mm_protocal_c_bjr : list) {
            if (com_tencent_mm_protocal_c_bjr == null) {
                w.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                a aVar2 = (a) this.idn.get(com_tencent_mm_protocal_c_bjr.trv);
                if (aVar2 == null) {
                    w.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", com_tencent_mm_protocal_c_bjr.trv);
                } else if (com_tencent_mm_protocal_c_bjr == null) {
                    w.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
                } else {
                    String str4 = "MicroMsg.ShortSentenceContainer";
                    String str5 = "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s";
                    Object[] objArr2 = new Object[12];
                    objArr2[0] = com_tencent_mm_protocal_c_bjr.trv;
                    objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_bjr.uje);
                    Integer valueOf = (com_tencent_mm_protocal_c_bjr.uhb == null || com_tencent_mm_protocal_c_bjr.uhb.tZp == null) ? null : Integer.valueOf(com_tencent_mm_protocal_c_bjr.uhb.tZn);
                    objArr2[2] = valueOf;
                    objArr2[3] = Boolean.valueOf(com_tencent_mm_protocal_c_bjr.tiL != 0);
                    objArr2[4] = Integer.valueOf(com_tencent_mm_protocal_c_bjr.tiL);
                    objArr2[5] = aVar2.idq;
                    objArr2[6] = Boolean.valueOf(aVar2.idr);
                    objArr2[7] = Boolean.valueOf(aVar2.ids);
                    objArr2[8] = Integer.valueOf(aVar2.idt);
                    objArr2[9] = Integer.valueOf(aVar2.idv);
                    objArr2[10] = aVar2.data == null ? null : Integer.valueOf(aVar2.data.length());
                    objArr2[11] = Boolean.valueOf(aVar2.idw);
                    w.d(str4, str5, objArr2);
                    if (com_tencent_mm_protocal_c_bjr.uje < aVar2.idv || aVar2.idw) {
                        w.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        aVar2.idv = com_tencent_mm_protocal_c_bjr.uje;
                        str3 = (com_tencent_mm_protocal_c_bjr.uhb == null || com_tencent_mm_protocal_c_bjr.uhb.tZp == null) ? null : com_tencent_mm_protocal_c_bjr.uhb.tZp.bGX();
                        aVar2.data = str3;
                        aVar2.idw = com_tencent_mm_protocal_c_bjr.tiL != 0;
                        str3 = "MicroMsg.ShortSentenceContainer";
                        str4 = "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s";
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = com_tencent_mm_protocal_c_bjr.trv;
                        objArr3[1] = Integer.valueOf(aVar2.idv);
                        objArr3[2] = Boolean.valueOf(aVar2.idw);
                        objArr3[3] = Integer.valueOf(aVar2.data == null ? -1 : aVar2.data.length());
                        w.i(str3, str4, objArr3);
                        if (com_tencent_mm_protocal_c_bjr.tiL == 2) {
                            w.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", com_tencent_mm_protocal_c_bjr.trv);
                        }
                    }
                }
            }
        }
        this.ido.readLock().unlock();
    }

    public final void gS(int i) {
        w.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException("splitShortSentence file mark less than zero. mark: " + i);
        }
        this.ido.readLock().lock();
        if (this.idn.size() == 0) {
            w.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            return;
        }
        a aVar = null;
        for (a aVar2 : this.idn.values()) {
        }
        if (aVar == null) {
            throw new IllegalStateException("splitShortSentence last info is null");
        }
        w.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", Integer.valueOf(aVar.idt), aVar.idq, Integer.valueOf(i));
        aVar.idt = i;
        this.ido.readLock().unlock();
    }

    public final a gT(int i) {
        if (this.idn.size() == 0) {
            return null;
        }
        this.ido.readLock().lock();
        for (a aVar : this.idn.values()) {
            w.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", Integer.valueOf(i), Integer.valueOf(aVar.idt), Boolean.valueOf(aVar.ids));
            if (!aVar.ids && i <= aVar.idt) {
                break;
            }
        }
        a aVar2 = null;
        this.ido.readLock().unlock();
        return aVar2;
    }
}
