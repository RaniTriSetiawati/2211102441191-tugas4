import greenfoot.*;

public class Character extends Actor {
    private int score = 0;
    private GreenfootImage[] characterImages; // Array untuk animasi karakter
    private int animationIndex = 0;
    
    public Character() {
        // Inisialisasi array gambar animasi karakter
        characterImages = new GreenfootImage[4];
        for (int i = 0; i < 4; i++) {
            characterImages[i] = new GreenfootImage("movement/tile00" + i + ".png");
        }
        setImage(characterImages[0]); // Set gambar awal
    }
    
    public void checkForCollision() {
    Actor objectSpecial = getOneIntersectingObject(ObjectSpecial.class);
    if (objectSpecial != null) {
        // Logika yang harus dilakukan saat terjadi tabrakan dengan ObjectSpecial
        // Contoh: menambahkan skor
        score += 10; // Misalnya, menambahkan 10 poin
        getWorld().removeObject(objectSpecial); // Menghapus ObjectSpecial
        }
    }

    public void act() {
        move(0);
        handleMovement();
        animateCharacter(); // Memanggil metode animasi
        checkForCollision();
    }
 
    public void animateCharacter() {
        // Mengganti gambar animasi karakter
        if (animationIndex < 3) {
            animationIndex++;
        } else {
            animationIndex = 0;
        }
        setImage(characterImages[animationIndex]);
     }
     
    public void increaseScore() {
        score += 10; // Misalnya, menambahkan 10 poin saat berinteraksi dengan ObjectSpecial
    }
    
    public void handleMovement() {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 3); // Menggerakkan karakter ke atas
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 3); // Menggerakkan karakter ke bawah
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 3, getY()); // Menggerakkan karakter ke kiri
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 3, getY()); // Menggerakkan karakter ke kanan
        }
    }
}