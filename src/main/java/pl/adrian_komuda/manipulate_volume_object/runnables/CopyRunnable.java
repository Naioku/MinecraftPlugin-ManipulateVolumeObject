package pl.adrian_komuda.manipulate_volume_object.runnables;

import org.bukkit.scheduler.BukkitRunnable;
import pl.adrian_komuda.manipulate_volume_object.services.operations.CopyService;

public class CopyRunnable extends BukkitRunnable {

    CopyService copyService;

    public CopyRunnable(CopyService copyService) {
        this.copyService = copyService;
        copyService.setReady();
    }

    @Override
    public void run() {
        for (int i = 1; i <= copyService.getCallsQuantityForOneTick(); i++) {
            if (copyService.isProcessingRunning()) {
                copyService.printProcessingOnScreen();
                copyService.countOneBlock();
            } else if (copyService.isCopyingRunning()) {
                copyService.copyOneBlock();
                copyService.printCompletionPercentOnScreen();
            } else {
                copyService.printDoneOnScreen();
                copyService.endProcess();
                this.cancel(); // can't cancel from reference in copyService
                break;
            }
        }
    }
}
