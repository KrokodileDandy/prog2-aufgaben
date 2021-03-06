package zoo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a lion in the zoo.
 */
class Lion extends Inhabitant {
    public Lion(String name) {
        super(name);
    }

    @Override
    void moveToFeeder() {
        zoo.lionCompound.remove(this);
        zoo.feedingRoom.add(this);
    }

    @Override
    void moveToCompound() {
        zoo.feedingRoom.remove(this);
        zoo.lionCompound.add(this);
    }

    @Override
    void feeding() throws InterruptedException {
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        getLionSemaphore().acquire(); // can throw Interrupted Exception
        getGazelleSemaphore().acquire(2);
        getZookeeperSemaphore().acquire();
        moveToFeeder();
        zoo.feedingRoom.checkInvariants();
        Thread.sleep(rng.nextInt(5)); // mampf
        moveToCompound();
        getLionSemaphore().release();
        getGazelleSemaphore().release(2);
        getZookeeperSemaphore().release();
    }
}
