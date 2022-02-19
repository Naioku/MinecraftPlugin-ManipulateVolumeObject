package pl.adrian_komuda.manipulate_volume_object.runnables;

import org.bukkit.scheduler.BukkitRunnable;

public class CopyRunnable extends BukkitRunnable {

    CopyRunnableManager manager;

    public CopyRunnable(CopyRunnableManager manager) {
        this.manager = manager;
        this.manager.startProcess();
    }

    @Override
    public void run() {
        for (int i = 1; i <= manager.getCallsQuantityForOneTick(); i++) {
            if (manager.isProcessingRunning()) {
                manager.printProcessingOnScreen();
                manager.countOneBlock();
            } else if (manager.isCopyingRunning()) {
                manager.copyOneBlock();
                manager.printCompletionPercentOnScreen();
            } else {
                manager.printDoneOnScreen();
                manager.endProcess(this);
                break;
            }
        }
    }
}
