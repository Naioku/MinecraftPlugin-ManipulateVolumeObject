package pl.adrian_komuda.manipulate_volume_object.runnables;

import org.bukkit.scheduler.BukkitRunnable;
import pl.adrian_komuda.manipulate_volume_object.runnables.managers.GeneralRunnableManager;

public class OperationRunnable extends BukkitRunnable {

    GeneralRunnableManager manager;

    public OperationRunnable(GeneralRunnableManager manager) {
        this.manager = manager;
        this.manager.startWholeProcess();
    }

    @Override
    public void run() {
        for (int i = 1; i <= manager.getCallsQuantityForOneTick(); i++) {
            if (manager.isPreparationRunning()) {
                manager.printProcessingOnScreen();
                manager.preparationToOneCircuit();
            } else if (manager.isExactProcessRunning()) {
                manager.exactProcessToOneCircuit();
                manager.printCompletionPercentOnScreen();
            } else {
                manager.printDoneOnScreen();
                manager.endWholeProcess(this);
                break;
            }
        }
    }
}
