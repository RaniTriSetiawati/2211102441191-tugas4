import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ObjectSpecial extends Actor {
    private GreenfootSound collectSound = new GreenfootSound("teleport.wav"); 
    
    public ObjectSpecial() {
        setImage("object/object.png");
     }
    public void act() {
        checkForCollision();
     }
     
     public void checkForCollision() {
         Actor character = getOneIntersectingObject(Character.class);
         if (character != null) {
             ((Character) character).increaseScore();
             getWorld().removeObject(this);
             playCollectSound(); // Memainkan efek suara
            }
    }
    
    public void playCollectSound() {
        collectSound.play();
    }
}