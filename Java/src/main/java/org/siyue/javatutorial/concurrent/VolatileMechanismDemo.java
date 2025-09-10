package org.siyue.javatutorial.concurrent;

/**
 *
 * 验证Volatile的底层逻辑：
 * `volatile` 写会（隐式）编译为 `store + StoreStoreBarrier + StoreLoadBarrier`;
 * `volatile` 读会（隐式）编译为 `load + LoadLoadBarrier + LoadStoreBarrier`;
 *
 * 使用内置的 GraalVM（推荐）编译 GraalVM 已集成 hsdis
 * 使用JDK 21
 * 添加 VM options：
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+PrintAssembly
 * -XX:CompileCommand=print,*VolatileMechanismDemo.write
 * -XX:CompileCommand=print,*VolatileMechanismDemo.read
 *
 * 结果：
 * Volatile写
 * 0x00000228e6b01a40: mov    DWORD PTR [r10+0x14],0x1  ; volatile store
 * 0x00000228e6b01a48: lock add DWORD PTR [rsp],0x0     ; full memory fence
 * mov DWORD PTR [r10+0x14],0x1 是对 volatile int a 的写操作
 * 紧跟其后是 lock add DWORD PTR [rsp],0x0，这是典型的 伪操作 full fence
 *
 * Volatile读
 * 0x00000228e6b01a20: mov    eax,DWORD PTR [r10+0x14]   ; volatile load
 * 0x00000228e6b01a24: lock add DWORD PTR [rsp],0x0     ; full memory fence
 * mov eax,... 是读取 a 的值
 * 紧接着出现 lock add DWORD PTR [rsp],0x0，表示读取之后插入了 memory fence
 *
 */
public class VolatileMechanismDemo {
    volatile int a = 0;

    public void write() {
        a = 1;
    }

    public int read() {
        return a;
    }

    public static void main(String[] args) {
        VolatileMechanismDemo t = new VolatileMechanismDemo();
        for (int i = 0; i < 1_000_000; i++) {
            t.write();
            t.read();
        }
    }
}
