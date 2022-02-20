package Actions;

import Obstacles.Obstacle;
import Obstacles.Rope;

public class ClimbAction implements PlayerAction{
    private int maxDistance;
    private ActionState actionState;

    public ClimbAction(int maxDistance) {
        this.maxDistance = maxDistance;
        actionState = ActionState.NONE;
    }

    @Override
    public void pass(Obstacle obstacle) {
        if (obstacle instanceof Rope) {
            Rope rope = (Rope) obstacle;
            if (rope.getDistance() <= maxDistance) {
                System.out.println("Игрок залез.");
                actionState = ActionState.VICTORY;
            } else {
                System.out.println("Игрок не смог залезть. Может залезть максимум на " + maxDistance);
                actionState = ActionState.DEFEAT;
            }
        }
    }

    @Override
    public ActionState getActionState() {
        return actionState;
    }
}
