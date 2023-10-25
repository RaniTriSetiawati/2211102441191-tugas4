import greenfoot.*;

public class LevelComplete extends Actor {
    private int level;

    public LevelComplete(int level) {
        this.level = level;
        setImage(new GreenfootImage("Level " + level + " Complete", 24, Color.WHITE, Color.BLACK));
    }

    public void act() {
        // Tambahkan logika untuk tindakan LevelComplete jika diperlukan
        // Misalnya, hilangkan objek setelah beberapa saat
        Greenfoot.delay(50);
        getWorld().removeObject(this);
    }
}
