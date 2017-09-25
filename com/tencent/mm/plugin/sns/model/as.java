package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.protocal.c.bfc;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class as implements e {
    public List<WeakReference<e>> pXJ = new LinkedList();

    public final void a(e eVar) {
        for (WeakReference weakReference : this.pXJ) {
            if (weakReference != null && weakReference.get() != null && ((e) weakReference.get()).equals(eVar)) {
                return;
            }
        }
        this.pXJ.add(new WeakReference(eVar));
    }

    public final void a(int i, String str, long j, String str2, bfc com_tencent_mm_protocal_c_bfc, boolean z, be beVar) {
        for (WeakReference weakReference : this.pXJ) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, com_tencent_mm_protocal_c_bfc, z, beVar);
            }
        }
    }

    public final void a(int i, String str, long j, String str2, bfc com_tencent_mm_protocal_c_bfc, boolean z) {
        for (WeakReference weakReference : this.pXJ) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, com_tencent_mm_protocal_c_bfc, z);
            }
        }
    }
}
