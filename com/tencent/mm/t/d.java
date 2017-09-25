package com.tencent.mm.t;

import com.tencent.mm.modelbiz.i;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.t.f.a;
import java.util.LinkedList;
import java.util.Map;

public class d extends c {
    public LinkedList<i> hhm = null;

    public final c wD() {
        return new d();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        switch (aVar.showType) {
            case 1:
                this.hhm = i.l(aVar.hho);
                return;
            default:
                return;
        }
    }
}
