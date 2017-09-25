package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bd.a;

public class VoiceInputBehavior extends a {
    public int cancel;
    public int clear;
    public int click;
    public int fail;
    public int fullScreenVoiceLongClick;
    public long fullScreenVoiceLongClickTime;
    public int longClick;
    public long longClickTime;
    public int send;
    public int smileIconClick;
    public int textChangeCount;
    public int textChangeReturn;
    public long textChangeTime;
    public int textClick;
    public int voiceIconClick;
    public long voiceInputTime;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.cancel);
            aVar.eO(2, this.send);
            aVar.eO(3, this.click);
            aVar.eO(4, this.longClick);
            aVar.O(5, this.longClickTime);
            aVar.eO(6, this.textClick);
            aVar.eO(7, this.textChangeCount);
            aVar.O(8, this.textChangeTime);
            aVar.eO(9, this.textChangeReturn);
            aVar.O(10, this.voiceInputTime);
            aVar.eO(11, this.fail);
            aVar.eO(12, this.clear);
            aVar.eO(13, this.smileIconClick);
            aVar.eO(14, this.voiceIconClick);
            aVar.eO(15, this.fullScreenVoiceLongClick);
            aVar.O(16, this.fullScreenVoiceLongClickTime);
            return 0;
        } else if (i == 1) {
            return (((((((((((((((a.a.a.a.eL(1, this.cancel) + 0) + a.a.a.a.eL(2, this.send)) + a.a.a.a.eL(3, this.click)) + a.a.a.a.eL(4, this.longClick)) + a.a.a.a.N(5, this.longClickTime)) + a.a.a.a.eL(6, this.textClick)) + a.a.a.a.eL(7, this.textChangeCount)) + a.a.a.a.N(8, this.textChangeTime)) + a.a.a.a.eL(9, this.textChangeReturn)) + a.a.a.a.N(10, this.voiceInputTime)) + a.a.a.a.eL(11, this.fail)) + a.a.a.a.eL(12, this.clear)) + a.a.a.a.eL(13, this.smileIconClick)) + a.a.a.a.eL(14, this.voiceIconClick)) + a.a.a.a.eL(15, this.fullScreenVoiceLongClick)) + a.a.a.a.N(16, this.fullScreenVoiceLongClickTime);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                VoiceInputBehavior voiceInputBehavior = (VoiceInputBehavior) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        voiceInputBehavior.cancel = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        voiceInputBehavior.send = aVar3.xmD.mL();
                        return 0;
                    case 3:
                        voiceInputBehavior.click = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        voiceInputBehavior.longClick = aVar3.xmD.mL();
                        return 0;
                    case 5:
                        voiceInputBehavior.longClickTime = aVar3.xmD.mM();
                        return 0;
                    case 6:
                        voiceInputBehavior.textClick = aVar3.xmD.mL();
                        return 0;
                    case 7:
                        voiceInputBehavior.textChangeCount = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        voiceInputBehavior.textChangeTime = aVar3.xmD.mM();
                        return 0;
                    case 9:
                        voiceInputBehavior.textChangeReturn = aVar3.xmD.mL();
                        return 0;
                    case 10:
                        voiceInputBehavior.voiceInputTime = aVar3.xmD.mM();
                        return 0;
                    case 11:
                        voiceInputBehavior.fail = aVar3.xmD.mL();
                        return 0;
                    case 12:
                        voiceInputBehavior.clear = aVar3.xmD.mL();
                        return 0;
                    case 13:
                        voiceInputBehavior.smileIconClick = aVar3.xmD.mL();
                        return 0;
                    case 14:
                        voiceInputBehavior.voiceIconClick = aVar3.xmD.mL();
                        return 0;
                    case 15:
                        voiceInputBehavior.fullScreenVoiceLongClick = aVar3.xmD.mL();
                        return 0;
                    case 16:
                        voiceInputBehavior.fullScreenVoiceLongClickTime = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
