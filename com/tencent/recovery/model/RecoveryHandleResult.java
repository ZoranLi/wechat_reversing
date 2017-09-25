package com.tencent.recovery.model;

public class RecoveryHandleResult {
    public boolean fDU;
    public boolean wQt;

    public String toString() {
        return "RecoveryHandleResult{result=" + this.fDU + ", retry=" + this.wQt + '}';
    }
}
