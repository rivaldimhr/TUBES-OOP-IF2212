public class DeadActor {
    public static void handleDeath(Object actor) {
        if (actor instanceof Plant) {
            removePlant((Plant) actor);
        } else if (actor instanceof Zombie) {
            removeZombie((Zombie) actor);
        }
    }

    private static void removePlant(Plant plant) {
        // Placeholder for removing plant from the game environment
        System.out.println(plant.getName() + " is being removed from the game.");
        // Add any animations or clean up logic here
    }

    private static void removeZombie(Zombie zombie) {
        // Placeholder for removing zombie from the game environment
        System.out.println(zombie.getName() + " is being removed from the game.");
        // Add any animations or clean up logic here
    }
}
