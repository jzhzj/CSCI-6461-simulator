package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.cpu.ctrlu.ControlUnitImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.Instruction;

import java.util.HashSet;
import java.util.Set;

/**
 * Singleton
 * CPU
 */
public class CPUImpl implements CPU{

    private static CPUImpl ourInstance = new CPUImpl();

    public static CPUImpl getInstance() {
        return ourInstance;
    }

    private CPUImpl() {
        registers = new HashSet<>();
        registers.add(MARImpl.getInstance());
        registers.add(MBRImpl.getInstance());
        registers.add(MFRImpl.getInstance());
        registers.add(MSRImpl.getInstance());
        registers.add(CCRImpl.getInstance());
        registers.add(GPR0Impl.getInstance());
        registers.add(GPR1Impl.getInstance());
        registers.add(GPR2Impl.getInstance());
        registers.add(GPR3Impl.getInstance());
        registers.add(IARImpl.getInstance());
        registers.add(IDXR1Impl.getInstance());
        registers.add(IDXR2Impl.getInstance());
        registers.add(IDXR3Impl.getInstance());
        registers.add(IRImpl.getInstance());
    }

    public Set<Register> registers;

    private TaskThread taskThread = new TaskThread();

    @Override
    public void resume() {
        if(TaskThread.State.NEW == taskThread.getState()){
            taskThread.reset();
            taskThread.start();
        } else if(TaskThread.State.TERMINATED == taskThread.getState()){
            taskThread = new TaskThread();
            taskThread.start();
        }
    }

    @Override
    public void pause() {
        taskThread.kill();
    }

    @Override
    public void pauseAfter(int count) {
        for(int i = 0; i < count; i++){
            process();
        }
    }


    @Override
    public void reset() {
        pause();
        registers.stream().forEach(register -> register.reset());
    }

    /**
     * CPU processes 1 instruction at current machine state
     */
    private void process() {
        // pc
        DRAMAddress dramAddress = IARImpl.getInstance().read();
        Instruction instruction = DRAMImpl.getInstance().read(dramAddress).toInstruction();
        ControlUnitImpl.getInstance().scheduleTask(instruction);
    }

    /**
     * Task thread
     * call reset() or constructor before call start()
     */
    private class TaskThread extends Thread{

        boolean quit;

        TaskThread(){
            reset();
        }

        void reset(){
            this.quit = false;
        }

        void kill(){
            this.quit = true;
        }

        @Override
        public void run() {
            super.run();

            while(!quit){
                process();
            }
        }
    }
}
